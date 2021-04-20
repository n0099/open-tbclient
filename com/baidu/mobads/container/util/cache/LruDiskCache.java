package com.baidu.mobads.container.util.cache;

import android.util.LruCache;
import com.baidu.mobads.container.executor.BaseTask;
import com.baidu.mobads.container.executor.TaskScheduler;
import com.baidu.mobads.container.util.FileUtils;
import com.baidu.mobads.container.util.RemoteXAdLogger;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.PriorityQueue;
/* loaded from: classes2.dex */
public class LruDiskCache extends LruCache<String, CacheResource<File>> {
    public static final String TAG = LruDiskCache.class.getSimpleName();
    public static final boolean isDebug = false;
    public HashMap<CacheResource<File>, byte[]> bufferMap;
    public int cacheCount;
    public final String cachePath;
    public long expireTime;
    public final List<OnCacheListener> listeners;
    public volatile boolean restoreCompleted;
    public long tailModifiedTime;

    /* loaded from: classes2.dex */
    public interface OnCacheListener {
        void onCacheComplete(String str, CacheResource<File> cacheResource);

        void onCacheFailed(String str, CacheResource<File> cacheResource);

        void onResourceEvicted(String str, CacheResource<File> cacheResource);
    }

    public LruDiskCache(int i, String str) {
        super(i);
        this.listeners = new ArrayList();
        this.restoreCompleted = false;
        this.cacheCount = 0;
        this.expireTime = 2592000000L;
        this.cachePath = str;
        this.bufferMap = new HashMap<>();
    }

    public static /* synthetic */ int access$108(LruDiskCache lruDiskCache) {
        int i = lruDiskCache.cacheCount;
        lruDiskCache.cacheCount = i + 1;
        return i;
    }

    public static /* synthetic */ int access$110(LruDiskCache lruDiskCache) {
        int i = lruDiskCache.cacheCount;
        lruDiskCache.cacheCount = i - 1;
        return i;
    }

    private void deleteFileAsync(final CacheResource<File> cacheResource) {
        TaskScheduler.getInstance().submit(new BaseTask() { // from class: com.baidu.mobads.container.util.cache.LruDiskCache.3
            @Override // com.baidu.mobads.container.executor.BaseTask
            public Object doInBackground() {
                try {
                    if (cacheResource != null) {
                        long currentTimeMillis = System.currentTimeMillis();
                        String name = ((File) cacheResource.get()).getName();
                        LruDiskCache.access$110(LruDiskCache.this);
                        cacheResource.recycle();
                        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                        LruDiskCache lruDiskCache = LruDiskCache.this;
                        lruDiskCache.logWhenDebug("File deleted using " + currentTimeMillis2 + "ms: " + name);
                    }
                    LruDiskCache.this.cleanExpired();
                    return null;
                } catch (Throwable th) {
                    RemoteXAdLogger remoteXAdLogger = RemoteXAdLogger.getInstance();
                    remoteXAdLogger.d("Failed to delete file. " + th);
                    return null;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void logWhenDebug(String str) {
    }

    private synchronized void onRestoreComplete() {
        this.restoreCompleted = true;
        if (this.bufferMap != null) {
            for (CacheResource<File> cacheResource : this.bufferMap.keySet()) {
                storeFileAsync(cacheResource, this.bufferMap.get(cacheResource));
            }
            this.bufferMap.clear();
            this.bufferMap = null;
        }
    }

    public static LruDiskCache open(final String str, int i) {
        final LruDiskCache lruDiskCache = new LruDiskCache(i, str);
        lruDiskCache.restoreCompleted = false;
        TaskScheduler.getInstance().submit(new BaseTask() { // from class: com.baidu.mobads.container.util.cache.LruDiskCache.1
            @Override // com.baidu.mobads.container.executor.BaseTask
            public Object doInBackground() {
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    File file = new File(str);
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    lruDiskCache.restoreCacheWithQueue(file.listFiles(), currentTimeMillis);
                    return null;
                } catch (Exception e2) {
                    lruDiskCache.restoreCompleted = true;
                    RemoteXAdLogger remoteXAdLogger = RemoteXAdLogger.getInstance();
                    remoteXAdLogger.d("Disk cache initialize failed for " + e2.getMessage());
                    return null;
                }
            }
        });
        return lruDiskCache;
    }

    private void put(String str, File file) {
        if (file.exists()) {
            super.put((LruDiskCache) str, (String) new CacheResource(file));
            this.cacheCount++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void restoreCacheWithQueue(File[] fileArr, long j) {
        if (fileArr != null && fileArr.length > 0) {
            PriorityQueue priorityQueue = new PriorityQueue(11, new Comparator<File>() { // from class: com.baidu.mobads.container.util.cache.LruDiskCache.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                public int compare(File file, File file2) {
                    return Long.valueOf(file.lastModified()).compareTo(Long.valueOf(file2.lastModified()));
                }
            });
            if (priorityQueue.size() > 0) {
                this.tailModifiedTime = ((File) priorityQueue.peek()).lastModified();
            } else {
                this.tailModifiedTime = System.currentTimeMillis();
            }
            priorityQueue.addAll(Arrays.asList(fileArr));
            while (!priorityQueue.isEmpty()) {
                File file = (File) priorityQueue.poll();
                put(file.getName(), file);
            }
        }
        logWhenDebug("Complete restore cache using " + (System.currentTimeMillis() - j) + "ms: ");
        onRestoreComplete();
    }

    private void storeFileAsync(final CacheResource<File> cacheResource, final byte[] bArr) {
        TaskScheduler.getInstance().submit(new BaseTask() { // from class: com.baidu.mobads.container.util.cache.LruDiskCache.2
            @Override // com.baidu.mobads.container.executor.BaseTask
            public Object doInBackground() {
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    FileUtils.saveBytesToFile(bArr, (File) cacheResource.get());
                    LruDiskCache.this.put((LruDiskCache) ((File) cacheResource.get()).getName(), (String) cacheResource);
                    LruDiskCache.access$108(LruDiskCache.this);
                    if (!LruDiskCache.this.listeners.isEmpty()) {
                        for (OnCacheListener onCacheListener : LruDiskCache.this.listeners) {
                            onCacheListener.onCacheComplete(((File) cacheResource.get()).getName(), cacheResource);
                        }
                    }
                    long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                    LruDiskCache lruDiskCache = LruDiskCache.this;
                    lruDiskCache.logWhenDebug("File saved using " + currentTimeMillis2 + "ms: " + ((File) cacheResource.get()).getName() + "\nStatus:" + LruDiskCache.this.status());
                    LruDiskCache.this.cleanExpired();
                    return null;
                } catch (Throwable th) {
                    if (!LruDiskCache.this.listeners.isEmpty()) {
                        for (OnCacheListener onCacheListener2 : LruDiskCache.this.listeners) {
                            onCacheListener2.onCacheFailed(((File) cacheResource.get()).getName(), cacheResource);
                        }
                    }
                    RemoteXAdLogger remoteXAdLogger = RemoteXAdLogger.getInstance();
                    remoteXAdLogger.d("Failed to save file. " + th);
                    return null;
                }
            }
        });
    }

    public void addListeners(OnCacheListener onCacheListener) {
        this.listeners.add(onCacheListener);
    }

    public synchronized void cleanExpired() {
        if (System.currentTimeMillis() - this.tailModifiedTime < this.expireTime) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        Map snapshot = super.snapshot();
        this.tailModifiedTime = System.currentTimeMillis();
        for (String str : snapshot.keySet()) {
            CacheResource cacheResource = (CacheResource) snapshot.get(str);
            if (cacheResource.isExpired(this.expireTime)) {
                ((File) ((CacheResource) super.remove(str)).get()).delete();
                this.cacheCount--;
            } else if (((File) cacheResource.get()).lastModified() < this.tailModifiedTime) {
                this.tailModifiedTime = ((File) cacheResource.get()).lastModified();
            }
        }
        logWhenDebug("Clear cache using " + (System.currentTimeMillis() - currentTimeMillis) + "ms: ");
    }

    public void close() {
        super.evictAll();
    }

    public void delete(String str) {
        if (super.get(str) != null) {
            deleteFileAsync((CacheResource) super.remove(str));
        }
    }

    public CacheResource<File> fetch(String str) {
        CacheResource<File> cacheResource = (CacheResource) super.get(str);
        if (cacheResource != null) {
            try {
                cacheResource.get().setLastModified(System.currentTimeMillis());
                logWhenDebug("Fetch resource for " + str + ",\nStatus:" + status());
            } catch (Throwable th) {
                RemoteXAdLogger remoteXAdLogger = RemoteXAdLogger.getInstance();
                remoteXAdLogger.d("Failed to update file. " + th);
            }
        }
        return cacheResource;
    }

    public String getCachePath() {
        return this.cachePath;
    }

    public long getCurrentSize() {
        return super.size();
    }

    public long getMaxSize() {
        return super.maxSize();
    }

    public boolean query(String str) {
        return fetch(str) != null && fetch(str).get().exists();
    }

    public void removeListener(OnCacheListener onCacheListener) {
        if (this.listeners.contains(onCacheListener)) {
            this.listeners.remove(onCacheListener);
        }
    }

    public void setExpireTime(long j) {
        this.expireTime = j;
    }

    public String status() {
        int hitCount = hitCount() + missCount();
        return String.format(Locale.CHINA, "LruDiskCache[count=%d,size=%d/%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.cacheCount), Integer.valueOf(size()), Integer.valueOf(maxSize()), Integer.valueOf(hitCount()), Integer.valueOf(missCount()), Integer.valueOf(hitCount != 0 ? (hitCount() * 100) / hitCount : 0));
    }

    public void store(byte[] bArr, CacheResource<File> cacheResource) {
        if (cacheResource != null) {
            if (this.restoreCompleted) {
                storeFileAsync(cacheResource, bArr);
            } else {
                this.bufferMap.put(cacheResource, bArr);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.util.LruCache
    public void entryRemoved(boolean z, String str, CacheResource<File> cacheResource, CacheResource<File> cacheResource2) {
        super.entryRemoved(z, (boolean) str, cacheResource, cacheResource2);
        if (z && cacheResource != null) {
            deleteFileAsync(cacheResource);
        }
        if (!z || this.listeners.isEmpty()) {
            return;
        }
        for (OnCacheListener onCacheListener : this.listeners) {
            onCacheListener.onResourceEvicted(str, cacheResource);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.util.LruCache
    public int sizeOf(String str, CacheResource<File> cacheResource) {
        if (cacheResource == null) {
            return super.sizeOf((LruDiskCache) null, (Object) null);
        }
        return cacheResource.size();
    }
}

package com.baidu.live.adp.lib.util;

import android.database.Cursor;
import com.baidu.live.adp.lib.cache.BdCacheBaseDBManager;
import com.baidu.live.adp.lib.cache.BdCacheSQLiteStorage;
import com.baidu.live.adp.lib.cache.BdKVCache;
import com.baidu.live.adp.lib.safe.BdCloseHelper;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes10.dex */
public class KVCacheUtils {
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [62=4] */
    /* JADX WARN: Type inference failed for: r4v11, types: [T, java.lang.String] */
    public static List<BdKVCache.CacheElement<String>> listAllTextItemsInDBCache(BdKVCache<String> bdKVCache) {
        Cursor cursor;
        LinkedList linkedList = new LinkedList();
        try {
            cursor = queryAllForCache(bdKVCache);
        } catch (Throwable th) {
            th = th;
            cursor = null;
        }
        if (cursor == null) {
            BdCloseHelper.close(cursor);
            return null;
        }
        while (cursor.moveToNext()) {
            try {
                BdKVCache.CacheElement cacheElement = new BdKVCache.CacheElement();
                cacheElement.key = cursor.getString(cursor.getColumnIndex("m_key"));
                cacheElement.lastSaveTime = cursor.getLong(cursor.getColumnIndex("saveTime"));
                cacheElement.timeToExpire = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                cacheElement.value = cursor.getString(cursor.getColumnIndex("m_value"));
                linkedList.add(cacheElement);
            } catch (Throwable th2) {
                th = th2;
                try {
                    BdLog.e(th);
                    BdCloseHelper.close(cursor);
                    Collections.sort(linkedList, new CacheElementComparator());
                    return linkedList;
                } finally {
                    BdCloseHelper.close(cursor);
                }
            }
        }
        Collections.sort(linkedList, new CacheElementComparator());
        return linkedList;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [107=4] */
    /* JADX WARN: Type inference failed for: r4v11, types: [byte[], T] */
    public static List<BdKVCache.CacheElement<byte[]>> listAllBytesItemsInDBCache(BdKVCache<byte[]> bdKVCache) {
        Cursor cursor;
        LinkedList linkedList = new LinkedList();
        try {
            cursor = queryAllForCache(bdKVCache);
        } catch (Throwable th) {
            th = th;
            cursor = null;
        }
        if (cursor == null) {
            BdCloseHelper.close(cursor);
            return null;
        }
        while (cursor.moveToNext()) {
            try {
                BdKVCache.CacheElement cacheElement = new BdKVCache.CacheElement();
                cacheElement.key = cursor.getString(cursor.getColumnIndex("m_key"));
                cacheElement.lastSaveTime = cursor.getLong(cursor.getColumnIndex("saveTime"));
                cacheElement.timeToExpire = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                cacheElement.value = cursor.getBlob(cursor.getColumnIndex("m_value"));
                linkedList.add(cacheElement);
            } catch (Throwable th2) {
                th = th2;
                try {
                    BdLog.e(th);
                    BdCloseHelper.close(cursor);
                    Collections.sort(linkedList, new CacheElementComparator());
                    return linkedList;
                } finally {
                    BdCloseHelper.close(cursor);
                }
            }
        }
        Collections.sort(linkedList, new CacheElementComparator());
        return linkedList;
    }

    private static Cursor queryAllForCache(BdKVCache<?> bdKVCache) {
        if (bdKVCache != null && (bdKVCache instanceof BdKVCache.MXSupportedCache)) {
            BdKVCache.MXSupportedCache mXSupportedCache = (BdKVCache.MXSupportedCache) bdKVCache;
            if (mXSupportedCache.getCacheStorage() instanceof BdCacheSQLiteStorage) {
                BdCacheBaseDBManager dbManager = ((BdCacheSQLiteStorage) mXSupportedCache.getCacheStorage()).getDbManager();
                return dbManager.queryAllForNameSpace(dbManager.getDatabaseManager().getOpenedDatabase(), mXSupportedCache.getNameSpace());
            }
            return null;
        }
        return null;
    }

    /* loaded from: classes10.dex */
    private static class CacheElementComparator implements Comparator<BdKVCache.CacheElement<?>> {
        private CacheElementComparator() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        public int compare(BdKVCache.CacheElement<?> cacheElement, BdKVCache.CacheElement<?> cacheElement2) {
            if (cacheElement.lastSaveTime == cacheElement2.lastSaveTime) {
                return 0;
            }
            return cacheElement.lastSaveTime > cacheElement2.lastSaveTime ? -1 : 1;
        }
    }
}

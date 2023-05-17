package com.baidu.searchbox.bddownload;

import android.net.Uri;
import android.util.SparseArray;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.bddownload.core.IdentifiedTask;
import com.baidu.searchbox.bddownload.core.Util;
import com.baidu.searchbox.bddownload.core.breakpoint.BreakpointInfo;
import com.baidu.searchbox.bddownload.core.download.DownloadStrategy;
import com.baidu.searchbox.bddownload.core.listener.DownloadListener;
import com.baidu.searchbox.bddownload.core.priority.PriorityStrategy;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes3.dex */
public class DownloadTask extends IdentifiedTask implements Comparable<DownloadTask> {
    public final boolean autoCallbackToUIThread;
    @Nullable
    public final Integer connectionCount;
    @NonNull
    public final File directoryFile;
    public final boolean filenameFromResponse;
    @NonNull
    public final DownloadStrategy.FilenameHolder filenameHolder;
    public final int flushBufferSize;
    public final Map<String, List<String>> headerMapFields;
    public final int id;
    @Nullable
    public BreakpointInfo info;
    @Nullable
    public final Boolean isPreAllocateLength;
    public volatile SparseArray<Object> keyTagMap;
    public final AtomicLong lastCallbackProcessTimestamp = new AtomicLong();
    public volatile DownloadListener listener;
    public final int minIntervalMillisCallbackProcess;
    public final boolean passIfAlreadyCompleted;
    public final PriorityStrategy.Priority priority;
    @NonNull
    public final File providedPathFile;
    public final int readBufferSize;
    @Nullable
    public String redirectLocation;
    public SpeedCalculator speedCalculator;
    public final int syncBufferIntervalMills;
    public final int syncBufferSize;
    public Object tag;
    @Nullable
    public File targetFile;
    public final Uri uri;
    @NonNull
    public final String url;
    public final boolean wifiRequired;

    /* loaded from: classes3.dex */
    public static class Builder {
        public static final boolean DEFAULT_AUTO_CALLBACK_TO_UI_THREAD = true;
        public static final int DEFAULT_FLUSH_BUFFER_SIZE = 16384;
        public static final boolean DEFAULT_IS_WIFI_REQUIRED = false;
        public static final int DEFAULT_MIN_INTERVAL_MILLIS_CALLBACK_PROCESS = 3000;
        public static final boolean DEFAULT_PASS_IF_ALREADY_COMPLETED = true;
        public static final int DEFAULT_READ_BUFFER_SIZE = 4096;
        public static final int DEFAULT_SYNC_BUFFER_INTERVAL_MILLIS = 2000;
        public static final int DEFAULT_SYNC_BUFFER_SIZE = 65536;
        public boolean autoCallbackToUIThread;
        public Integer connectionCount;
        public String filename;
        public int flushBufferSize;
        public volatile Map<String, List<String>> headerMapFields;
        public Boolean isFilenameFromResponse;
        public Boolean isPreAllocateLength;
        public boolean isWifiRequired;
        public int minIntervalMillisCallbackProcess;
        public boolean passIfAlreadyCompleted;
        public PriorityStrategy.Priority priority;
        public int readBufferSize;
        public int syncBufferIntervalMillis;
        public int syncBufferSize;
        @NonNull
        public final Uri uri;
        @NonNull
        public final String url;

        public Builder(@NonNull String str, @NonNull Uri uri) {
            this.priority = PriorityStrategy.Priority.DEFAULT;
            this.readBufferSize = 4096;
            this.flushBufferSize = 16384;
            this.syncBufferSize = 65536;
            this.syncBufferIntervalMillis = 2000;
            this.autoCallbackToUIThread = true;
            this.minIntervalMillisCallbackProcess = 3000;
            this.passIfAlreadyCompleted = true;
            this.isWifiRequired = false;
            this.url = str;
            this.uri = uri;
            if (Util.isUriContentScheme(uri)) {
                this.filename = Util.getFilenameFromContentUri(uri);
            }
        }

        public Builder(@NonNull String str, @NonNull File file) {
            this.priority = PriorityStrategy.Priority.DEFAULT;
            this.readBufferSize = 4096;
            this.flushBufferSize = 16384;
            this.syncBufferSize = 65536;
            this.syncBufferIntervalMillis = 2000;
            this.autoCallbackToUIThread = true;
            this.minIntervalMillisCallbackProcess = 3000;
            this.passIfAlreadyCompleted = true;
            this.isWifiRequired = false;
            this.url = str;
            this.uri = Uri.fromFile(file);
        }

        public synchronized void addHeader(String str, String str2) {
            if (this.headerMapFields == null) {
                this.headerMapFields = new HashMap();
            }
            List<String> list = this.headerMapFields.get(str);
            if (list == null) {
                list = new ArrayList<>();
                this.headerMapFields.put(str, list);
            }
            list.add(str2);
        }

        public Builder(@NonNull String str, @NonNull String str2, @Nullable String str3) {
            this(str, Uri.fromFile(new File(str2)));
            if (Util.isEmpty(str3)) {
                this.isFilenameFromResponse = Boolean.TRUE;
            } else {
                this.filename = str3;
            }
        }

        public DownloadTask build() {
            return new DownloadTask(this.url, this.uri, this.priority, this.readBufferSize, this.flushBufferSize, this.syncBufferSize, this.syncBufferIntervalMillis, this.autoCallbackToUIThread, this.minIntervalMillisCallbackProcess, this.headerMapFields, this.filename, this.passIfAlreadyCompleted, this.isWifiRequired, this.isFilenameFromResponse, this.connectionCount, this.isPreAllocateLength);
        }

        public Builder setAutoCallbackToUIThread(boolean z) {
            this.autoCallbackToUIThread = z;
            return this;
        }

        public Builder setConnectionCount(@IntRange(from = 1) int i) {
            this.connectionCount = Integer.valueOf(i);
            return this;
        }

        public Builder setFilename(String str) {
            this.filename = str;
            return this;
        }

        public Builder setFilenameFromResponse(@Nullable Boolean bool) {
            if (Util.isUriFileScheme(this.uri)) {
                this.isFilenameFromResponse = bool;
                return this;
            }
            throw new IllegalArgumentException("Uri isn't file scheme we can't let filename from response");
        }

        public Builder setFlushBufferSize(int i) {
            if (i >= 0) {
                this.flushBufferSize = i;
                return this;
            }
            throw new IllegalArgumentException("Value must be positive!");
        }

        public Builder setHeaderMapFields(Map<String, List<String>> map) {
            this.headerMapFields = map;
            return this;
        }

        public Builder setMinIntervalMillisCallbackProcess(int i) {
            this.minIntervalMillisCallbackProcess = i;
            return this;
        }

        public Builder setPassIfAlreadyCompleted(boolean z) {
            this.passIfAlreadyCompleted = z;
            return this;
        }

        public Builder setPreAllocateLength(boolean z) {
            this.isPreAllocateLength = Boolean.valueOf(z);
            return this;
        }

        public Builder setPriority(PriorityStrategy.Priority priority) {
            this.priority = priority;
            return this;
        }

        public Builder setReadBufferSize(int i) {
            if (i >= 0) {
                this.readBufferSize = i;
                return this;
            }
            throw new IllegalArgumentException("Value must be positive!");
        }

        public Builder setSyncBufferIntervalMillis(int i) {
            if (i >= 0) {
                this.syncBufferIntervalMillis = i;
                return this;
            }
            throw new IllegalArgumentException("Value must be positive!");
        }

        public Builder setSyncBufferSize(int i) {
            if (i >= 0) {
                this.syncBufferSize = i;
                return this;
            }
            throw new IllegalArgumentException("Value must be positive!");
        }

        public Builder setWifiRequired(boolean z) {
            this.isWifiRequired = z;
            return this;
        }
    }

    /* loaded from: classes3.dex */
    public static class MockTaskForCompare extends IdentifiedTask {
        @Nullable
        public final String filename;
        public final int id;
        @NonNull
        public final File parentFile;
        @NonNull
        public final File providedPathFile;
        @NonNull
        public final String url;

        public MockTaskForCompare(int i) {
            this.id = i;
            this.url = "";
            File file = IdentifiedTask.EMPTY_FILE;
            this.providedPathFile = file;
            this.filename = null;
            this.parentFile = file;
        }

        public MockTaskForCompare(int i, @NonNull DownloadTask downloadTask) {
            this.id = i;
            this.url = downloadTask.url;
            this.parentFile = downloadTask.getParentFile();
            this.providedPathFile = downloadTask.providedPathFile;
            this.filename = downloadTask.getFilename();
        }

        @Override // com.baidu.searchbox.bddownload.core.IdentifiedTask
        @Nullable
        public String getFilename() {
            return this.filename;
        }

        @Override // com.baidu.searchbox.bddownload.core.IdentifiedTask
        public int getId() {
            return this.id;
        }

        @Override // com.baidu.searchbox.bddownload.core.IdentifiedTask
        @NonNull
        public File getParentFile() {
            return this.parentFile;
        }

        @Override // com.baidu.searchbox.bddownload.core.IdentifiedTask
        @NonNull
        public File getProvidedPathFile() {
            return this.providedPathFile;
        }

        @Override // com.baidu.searchbox.bddownload.core.IdentifiedTask
        @NonNull
        public String getUrl() {
            return this.url;
        }
    }

    public DownloadTask(String str, Uri uri, PriorityStrategy.Priority priority, int i, int i2, int i3, int i4, boolean z, int i5, Map<String, List<String>> map, @Nullable String str2, boolean z2, boolean z3, Boolean bool, @Nullable Integer num, @Nullable Boolean bool2) {
        Boolean bool3;
        String str3 = str2;
        this.url = str;
        this.uri = uri;
        this.priority = priority;
        this.readBufferSize = i;
        this.flushBufferSize = i2;
        this.syncBufferSize = i3;
        this.syncBufferIntervalMills = i4;
        this.autoCallbackToUIThread = z;
        this.minIntervalMillisCallbackProcess = i5;
        this.headerMapFields = map;
        this.passIfAlreadyCompleted = z2;
        this.wifiRequired = z3;
        this.connectionCount = num;
        this.isPreAllocateLength = bool2;
        if (Util.isUriFileScheme(uri)) {
            File file = new File(uri.getPath());
            if (bool != null) {
                if (bool.booleanValue()) {
                    if (file.exists() && file.isFile()) {
                        throw new IllegalArgumentException("If you want filename from response please make sure you provide path is directory " + file.getPath());
                    }
                    if (!Util.isEmpty(str2)) {
                        Util.w("DownloadTask", "Discard filename[" + str3 + "] because you set filenameFromResponse=true");
                        str3 = null;
                    }
                    this.directoryFile = file;
                } else if (file.exists() && file.isDirectory() && Util.isEmpty(str2)) {
                    throw new IllegalArgumentException("If you don't want filename from response please make sure you have already provided valid filename or not directory path " + file.getPath());
                } else if (Util.isEmpty(str2)) {
                    str3 = file.getName();
                    this.directoryFile = Util.getParentFile(file);
                } else {
                    this.directoryFile = file;
                }
                bool3 = bool;
            } else if (file.exists() && file.isDirectory()) {
                bool3 = Boolean.TRUE;
                this.directoryFile = file;
            } else {
                bool3 = Boolean.FALSE;
                if (file.exists()) {
                    if (!Util.isEmpty(str2) && !file.getName().equals(str3)) {
                        throw new IllegalArgumentException("Uri already provided filename!");
                    }
                    str3 = file.getName();
                    this.directoryFile = Util.getParentFile(file);
                } else if (Util.isEmpty(str2)) {
                    str3 = file.getName();
                    this.directoryFile = Util.getParentFile(file);
                } else {
                    this.directoryFile = file;
                }
            }
            this.filenameFromResponse = bool3.booleanValue();
        } else {
            this.filenameFromResponse = false;
            this.directoryFile = new File(uri.getPath());
        }
        if (Util.isEmpty(str3)) {
            this.filenameHolder = new DownloadStrategy.FilenameHolder();
            this.providedPathFile = this.directoryFile;
        } else {
            this.filenameHolder = new DownloadStrategy.FilenameHolder(str3);
            File file2 = new File(this.directoryFile, str3);
            this.targetFile = file2;
            this.providedPathFile = file2;
        }
        this.speedCalculator = new SpeedCalculator();
        this.id = BdDownload.with().breakpointStore().findOrCreateId(this);
    }

    /* loaded from: classes3.dex */
    public static class TaskHideWrapper {
        public static long getLastCallbackProcessTs(DownloadTask downloadTask) {
            return downloadTask.getLastCallbackProcessTs();
        }

        public static void setBreakpointInfo(@NonNull DownloadTask downloadTask, @NonNull BreakpointInfo breakpointInfo) {
            downloadTask.setBreakpointInfo(breakpointInfo);
        }

        public static void setLastCallbackProcessTs(DownloadTask downloadTask, long j) {
            downloadTask.setLastCallbackProcessTs(j);
        }

        public static void setSpeedIncreaseBytes(DownloadTask downloadTask, long j) {
            downloadTask.setSpeedIncreaseBytes(j);
        }
    }

    public static void cancel(DownloadTask[] downloadTaskArr) {
        BdDownload.with().downloadDispatcher().cancel(downloadTaskArr);
    }

    public static MockTaskForCompare mockTaskForCompare(int i) {
        return new MockTaskForCompare(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    public int compareTo(@NonNull DownloadTask downloadTask) {
        return PriorityStrategy.compareTaskPriority(downloadTask, this);
    }

    public void enqueue(DownloadListener downloadListener) {
        this.listener = downloadListener;
        BdDownload.with().downloadDispatcher().enqueue(this);
    }

    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            return true;
        }
        if (obj instanceof DownloadTask) {
            DownloadTask downloadTask = (DownloadTask) obj;
            if (downloadTask.id == this.id) {
                return true;
            }
            return compareIgnoreId(downloadTask);
        }
        return false;
    }

    public void execute(DownloadListener downloadListener) {
        this.listener = downloadListener;
        BdDownload.with().downloadDispatcher().execute(this);
    }

    public Object getTag(int i) {
        if (this.keyTagMap == null) {
            return null;
        }
        return this.keyTagMap.get(i);
    }

    @NonNull
    public MockTaskForCompare mock(int i) {
        return new MockTaskForCompare(i, this);
    }

    public synchronized void removeTag(int i) {
        if (this.keyTagMap != null) {
            this.keyTagMap.remove(i);
        }
    }

    public void replaceListener(@NonNull DownloadListener downloadListener) {
        this.listener = downloadListener;
    }

    public void setBreakpointInfo(@NonNull BreakpointInfo breakpointInfo) {
        this.info = breakpointInfo;
    }

    public void setLastCallbackProcessTs(long j) {
        this.lastCallbackProcessTimestamp.set(j);
    }

    public void setRedirectLocation(@Nullable String str) {
        this.redirectLocation = str;
    }

    public void setSpeedIncreaseBytes(long j) {
        SpeedCalculator speedCalculator = this.speedCalculator;
        if (speedCalculator != null) {
            speedCalculator.downloading(j);
        }
    }

    public void setTag(Object obj) {
        this.tag = obj;
    }

    public void setTags(DownloadTask downloadTask) {
        this.tag = downloadTask.tag;
        this.keyTagMap = downloadTask.keyTagMap;
    }

    public static void enqueue(DownloadTask[] downloadTaskArr, DownloadListener downloadListener) {
        for (DownloadTask downloadTask : downloadTaskArr) {
            downloadTask.listener = downloadListener;
        }
        BdDownload.with().downloadDispatcher().enqueue(downloadTaskArr);
    }

    public synchronized DownloadTask addTag(int i, Object obj) {
        if (this.keyTagMap == null) {
            synchronized (this) {
                if (this.keyTagMap == null) {
                    this.keyTagMap = new SparseArray<>();
                }
            }
        }
        this.keyTagMap.put(i, obj);
        return this;
    }

    public void cancel() {
        BdDownload.with().downloadDispatcher().cancel(this);
    }

    public int getConnectionCount() {
        BreakpointInfo breakpointInfo = this.info;
        if (breakpointInfo == null) {
            return 0;
        }
        return breakpointInfo.getBlockCount();
    }

    @Nullable
    public File getFile() {
        String str = this.filenameHolder.get();
        if (str == null) {
            return null;
        }
        if (this.targetFile == null) {
            this.targetFile = new File(this.directoryFile, str);
        }
        return this.targetFile;
    }

    @Override // com.baidu.searchbox.bddownload.core.IdentifiedTask
    @Nullable
    public String getFilename() {
        return this.filenameHolder.get();
    }

    public DownloadStrategy.FilenameHolder getFilenameHolder() {
        return this.filenameHolder;
    }

    public int getFlushBufferSize() {
        return this.flushBufferSize;
    }

    @Nullable
    public Map<String, List<String>> getHeaderMapFields() {
        return this.headerMapFields;
    }

    @Override // com.baidu.searchbox.bddownload.core.IdentifiedTask
    public int getId() {
        return this.id;
    }

    @Nullable
    public BreakpointInfo getInfo() {
        if (this.info == null) {
            this.info = BdDownload.with().breakpointStore().get(this.id);
        }
        return this.info;
    }

    public long getLastCallbackProcessTs() {
        return this.lastCallbackProcessTimestamp.get();
    }

    public long getLastSeconds() {
        BreakpointInfo breakpointInfo;
        long instantBytesPerSecondAndFlush = this.speedCalculator.getInstantBytesPerSecondAndFlush();
        if (instantBytesPerSecondAndFlush <= 0 || (breakpointInfo = this.info) == null) {
            return -1L;
        }
        return breakpointInfo.getLastLength() / instantBytesPerSecondAndFlush;
    }

    public DownloadListener getListener() {
        return this.listener;
    }

    public int getMinIntervalMillisCallbackProcess() {
        return this.minIntervalMillisCallbackProcess;
    }

    @Override // com.baidu.searchbox.bddownload.core.IdentifiedTask
    @NonNull
    public File getParentFile() {
        return this.directoryFile;
    }

    public int getPriority() {
        return this.priority.ordinal();
    }

    @Override // com.baidu.searchbox.bddownload.core.IdentifiedTask
    @NonNull
    public File getProvidedPathFile() {
        return this.providedPathFile;
    }

    public int getReadBufferSize() {
        return this.readBufferSize;
    }

    @Nullable
    public String getRedirectLocation() {
        return this.redirectLocation;
    }

    @Nullable
    public Integer getSetConnectionCount() {
        return this.connectionCount;
    }

    @Nullable
    public Boolean getSetPreAllocateLength() {
        return this.isPreAllocateLength;
    }

    public int getSyncBufferIntervalMills() {
        return this.syncBufferIntervalMills;
    }

    public int getSyncBufferSize() {
        return this.syncBufferSize;
    }

    public Object getTag() {
        return this.tag;
    }

    public Uri getUri() {
        return this.uri;
    }

    @Override // com.baidu.searchbox.bddownload.core.IdentifiedTask
    @NonNull
    public String getUrl() {
        return this.url;
    }

    public int hashCode() {
        return (this.url + this.providedPathFile.toString() + this.filenameHolder.get()).hashCode();
    }

    public boolean isAutoCallbackToUIThread() {
        return this.autoCallbackToUIThread;
    }

    public boolean isFilenameFromResponse() {
        return this.filenameFromResponse;
    }

    public boolean isPassIfAlreadyCompleted() {
        return this.passIfAlreadyCompleted;
    }

    public boolean isWifiRequired() {
        return this.wifiRequired;
    }

    public synchronized void removeTag() {
        this.tag = null;
    }

    public Builder toBuilder() {
        return toBuilder(this.url, this.uri);
    }

    public Builder toBuilder(String str, Uri uri) {
        Builder passIfAlreadyCompleted = new Builder(str, uri).setPriority(this.priority).setReadBufferSize(this.readBufferSize).setFlushBufferSize(this.flushBufferSize).setSyncBufferSize(this.syncBufferSize).setConnectionCount(1).setSyncBufferIntervalMillis(this.syncBufferIntervalMills).setAutoCallbackToUIThread(this.autoCallbackToUIThread).setMinIntervalMillisCallbackProcess(this.minIntervalMillisCallbackProcess).setHeaderMapFields(this.headerMapFields).setPassIfAlreadyCompleted(this.passIfAlreadyCompleted);
        if (Util.isUriFileScheme(uri) && !new File(uri.getPath()).isFile() && Util.isUriFileScheme(this.uri) && this.filenameHolder.get() != null && !new File(this.uri.getPath()).getName().equals(this.filenameHolder.get())) {
            passIfAlreadyCompleted.setFilename(this.filenameHolder.get());
        }
        return passIfAlreadyCompleted;
    }

    public String toString() {
        return super.toString() + "@" + this.id + "@" + this.url + "@" + this.directoryFile.toString() + "/" + this.filenameHolder.get();
    }
}

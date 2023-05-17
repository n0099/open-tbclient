package com.baidu.searchbox.bddownload;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.bddownload.DownloadTask;
import com.baidu.searchbox.bddownload.core.Util;
import com.baidu.searchbox.bddownload.core.cause.EndCause;
import com.baidu.searchbox.bddownload.core.listener.DownloadListener;
import com.baidu.searchbox.bddownload.core.listener.DownloadListenerBunch;
import com.baidu.searchbox.bddownload.core.listener.DownloadTaskStartEndListener;
import com.baidu.searchbox.bddownload.core.priority.PriorityStrategy;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes3.dex */
public class DownloadContext {
    public static final Executor SERIAL_EXECUTOR = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 30, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory("BdDownload Serial", false));
    public static final String TAG = "DownloadContext";
    @Nullable
    public final DownloadContextListener contextListener;
    public final QueueSet set;
    public volatile boolean started;
    public final DownloadTask[] tasks;
    public Handler uiHandler;

    /* loaded from: classes3.dex */
    public static class AlterContext {
        public final DownloadContext context;

        public AlterContext(DownloadContext downloadContext) {
            this.context = downloadContext;
        }

        public AlterContext replaceTask(DownloadTask downloadTask, DownloadTask downloadTask2) {
            DownloadTask[] downloadTaskArr = this.context.tasks;
            for (int i = 0; i < downloadTaskArr.length; i++) {
                if (downloadTaskArr[i] == downloadTask) {
                    downloadTaskArr[i] = downloadTask2;
                }
            }
            return this;
        }
    }

    /* loaded from: classes3.dex */
    public static class Builder {
        public final ArrayList<DownloadTask> boundTaskList;
        public DownloadContextListener listener;
        public final QueueSet set;

        public Builder() {
            this(new QueueSet());
        }

        public DownloadContext build() {
            return new DownloadContext((DownloadTask[]) this.boundTaskList.toArray(new DownloadTask[this.boundTaskList.size()]), this.listener, this.set);
        }

        public Builder(QueueSet queueSet) {
            this(queueSet, new ArrayList());
        }

        public Builder bindSetTask(@NonNull DownloadTask downloadTask) {
            int indexOf = this.boundTaskList.indexOf(downloadTask);
            if (indexOf >= 0) {
                this.boundTaskList.set(indexOf, downloadTask);
            } else {
                this.boundTaskList.add(downloadTask);
            }
            return this;
        }

        public Builder setListener(DownloadContextListener downloadContextListener) {
            this.listener = downloadContextListener;
            return this;
        }

        public void unbind(int i) {
            for (DownloadTask downloadTask : (List) this.boundTaskList.clone()) {
                if (downloadTask.getId() == i) {
                    this.boundTaskList.remove(downloadTask);
                }
            }
        }

        public Builder(QueueSet queueSet, ArrayList<DownloadTask> arrayList) {
            this.set = queueSet;
            this.boundTaskList = arrayList;
        }

        public DownloadTask bind(@NonNull String str, PriorityStrategy.Priority priority) throws IllegalArgumentException {
            if (this.set.uri != null) {
                return bind(new DownloadTask.Builder(str, this.set.uri).setFilenameFromResponse(Boolean.TRUE), priority);
            }
            throw new IllegalArgumentException("If you want to bind only with url, you have to provide parentPath on QueueSet!");
        }

        public DownloadTask bind(@NonNull DownloadTask.Builder builder, PriorityStrategy.Priority priority) {
            if (this.set.headerMapFields != null) {
                builder.setHeaderMapFields(this.set.headerMapFields);
            }
            if (this.set.readBufferSize != null) {
                builder.setReadBufferSize(this.set.readBufferSize.intValue());
            }
            if (this.set.flushBufferSize != null) {
                builder.setFlushBufferSize(this.set.flushBufferSize.intValue());
            }
            if (this.set.syncBufferSize != null) {
                builder.setSyncBufferSize(this.set.syncBufferSize.intValue());
            }
            if (this.set.wifiRequired != null) {
                builder.setWifiRequired(this.set.wifiRequired.booleanValue());
            }
            if (this.set.syncBufferIntervalMillis != null) {
                builder.setSyncBufferIntervalMillis(this.set.syncBufferIntervalMillis.intValue());
            }
            if (this.set.autoCallbackToUIThread != null) {
                builder.setAutoCallbackToUIThread(this.set.autoCallbackToUIThread.booleanValue());
            }
            if (this.set.minIntervalMillisCallbackProcess != null) {
                builder.setMinIntervalMillisCallbackProcess(this.set.minIntervalMillisCallbackProcess.intValue());
            }
            if (this.set.passIfAlreadyCompleted != null) {
                builder.setPassIfAlreadyCompleted(this.set.passIfAlreadyCompleted.booleanValue());
            }
            if (priority != null) {
                builder.setPriority(priority);
            }
            DownloadTask build = builder.build();
            if (this.set.tag != null) {
                build.setTag(this.set.tag);
            }
            this.boundTaskList.add(build);
            return build;
        }

        public void unbind(@NonNull DownloadTask downloadTask) {
            this.boundTaskList.remove(downloadTask);
        }
    }

    /* loaded from: classes3.dex */
    public static class QueueAttachTaskStartEndListener extends DownloadTaskStartEndListener {
        @NonNull
        public final DownloadContextListener contextListener;
        @NonNull
        public final DownloadContext hostContext;
        public final AtomicInteger remainCount;

        @Override // com.baidu.searchbox.bddownload.core.listener.DownloadListener
        public void taskStart(@NonNull DownloadTask downloadTask) {
        }

        public QueueAttachTaskStartEndListener(@NonNull DownloadContext downloadContext, @NonNull DownloadContextListener downloadContextListener, int i) {
            this.remainCount = new AtomicInteger(i);
            this.contextListener = downloadContextListener;
            this.hostContext = downloadContext;
        }

        @Override // com.baidu.searchbox.bddownload.core.listener.DownloadListener
        public void taskEnd(@NonNull DownloadTask downloadTask, @NonNull EndCause endCause, @Nullable Exception exc) {
            int decrementAndGet = this.remainCount.decrementAndGet();
            this.contextListener.taskEnd(this.hostContext, downloadTask, endCause, exc, decrementAndGet);
            if (decrementAndGet <= 0) {
                this.contextListener.queueEnd(this.hostContext);
                Util.d(DownloadContext.TAG, "taskEnd and remainCount " + decrementAndGet);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class QueueSet {
        public Boolean autoCallbackToUIThread;
        public Integer flushBufferSize;
        public Map<String, List<String>> headerMapFields;
        public Integer minIntervalMillisCallbackProcess;
        public Boolean passIfAlreadyCompleted;
        public Integer readBufferSize;
        public Integer syncBufferIntervalMillis;
        public Integer syncBufferSize;
        public Object tag;
        public Uri uri;
        public Boolean wifiRequired;

        public Builder commit() {
            return new Builder(this);
        }

        public Uri getDirUri() {
            return this.uri;
        }

        public int getFlushBufferSize() {
            Integer num = this.flushBufferSize;
            if (num == null) {
                return 16384;
            }
            return num.intValue();
        }

        public Map<String, List<String>> getHeaderMapFields() {
            return this.headerMapFields;
        }

        public int getMinIntervalMillisCallbackProcess() {
            Integer num = this.minIntervalMillisCallbackProcess;
            if (num == null) {
                return 3000;
            }
            return num.intValue();
        }

        public int getReadBufferSize() {
            Integer num = this.readBufferSize;
            if (num == null) {
                return 4096;
            }
            return num.intValue();
        }

        public int getSyncBufferIntervalMillis() {
            Integer num = this.syncBufferIntervalMillis;
            if (num == null) {
                return 2000;
            }
            return num.intValue();
        }

        public int getSyncBufferSize() {
            Integer num = this.syncBufferSize;
            if (num == null) {
                return 65536;
            }
            return num.intValue();
        }

        public Object getTag() {
            return this.tag;
        }

        public boolean isAutoCallbackToUIThread() {
            Boolean bool = this.autoCallbackToUIThread;
            if (bool == null) {
                return true;
            }
            return bool.booleanValue();
        }

        public boolean isPassIfAlreadyCompleted() {
            Boolean bool = this.passIfAlreadyCompleted;
            if (bool == null) {
                return true;
            }
            return bool.booleanValue();
        }

        public boolean isWifiRequired() {
            Boolean bool = this.wifiRequired;
            if (bool == null) {
                return false;
            }
            return bool.booleanValue();
        }

        public QueueSet setAutoCallbackToUIThread(Boolean bool) {
            this.autoCallbackToUIThread = bool;
            return this;
        }

        public QueueSet setFlushBufferSize(int i) {
            this.flushBufferSize = Integer.valueOf(i);
            return this;
        }

        public void setHeaderMapFields(Map<String, List<String>> map) {
            this.headerMapFields = map;
        }

        public QueueSet setMinIntervalMillisCallbackProcess(Integer num) {
            this.minIntervalMillisCallbackProcess = num;
            return this;
        }

        public QueueSet setParentPath(@NonNull String str) {
            return setParentPathFile(new File(str));
        }

        public QueueSet setParentPathFile(@NonNull File file) {
            if (!file.isFile()) {
                this.uri = Uri.fromFile(file);
                return this;
            }
            throw new IllegalArgumentException("parent path only accept directory path");
        }

        public QueueSet setParentPathUri(@NonNull Uri uri) {
            this.uri = uri;
            return this;
        }

        public QueueSet setPassIfAlreadyCompleted(boolean z) {
            this.passIfAlreadyCompleted = Boolean.valueOf(z);
            return this;
        }

        public QueueSet setReadBufferSize(int i) {
            this.readBufferSize = Integer.valueOf(i);
            return this;
        }

        public QueueSet setSyncBufferIntervalMillis(int i) {
            this.syncBufferIntervalMillis = Integer.valueOf(i);
            return this;
        }

        public QueueSet setSyncBufferSize(int i) {
            this.syncBufferSize = Integer.valueOf(i);
            return this;
        }

        public QueueSet setTag(Object obj) {
            this.tag = obj;
            return this;
        }

        public QueueSet setWifiRequired(Boolean bool) {
            this.wifiRequired = bool;
            return this;
        }
    }

    public AlterContext alter() {
        return new AlterContext(this);
    }

    public DownloadTask[] getTasks() {
        return this.tasks;
    }

    public boolean isStarted() {
        return this.started;
    }

    public void stop() {
        if (this.started) {
            BdDownload.with().downloadDispatcher().cancel(this.tasks);
        }
        this.started = false;
    }

    public Builder toBuilder() {
        return new Builder(this.set, new ArrayList(Arrays.asList(this.tasks))).setListener(this.contextListener);
    }

    public DownloadContext(@NonNull DownloadTask[] downloadTaskArr, @Nullable DownloadContextListener downloadContextListener, @NonNull QueueSet queueSet) {
        this.started = false;
        this.tasks = downloadTaskArr;
        this.contextListener = downloadContextListener;
        this.set = queueSet;
    }

    public DownloadContext(@NonNull DownloadTask[] downloadTaskArr, @Nullable DownloadContextListener downloadContextListener, @NonNull QueueSet queueSet, @NonNull Handler handler) {
        this(downloadTaskArr, downloadContextListener, queueSet);
        this.uiHandler = handler;
    }

    public void addOneTask(int i, DownloadListener downloadListener) {
        this.started = true;
        this.tasks[i].enqueue(downloadListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callbackQueueEndOnSerialLoop(boolean z) {
        DownloadContextListener downloadContextListener = this.contextListener;
        if (downloadContextListener == null) {
            return;
        }
        if (z) {
            if (this.uiHandler == null) {
                this.uiHandler = new Handler(Looper.getMainLooper());
            }
            this.uiHandler.post(new Runnable() { // from class: com.baidu.searchbox.bddownload.DownloadContext.2
                @Override // java.lang.Runnable
                public void run() {
                    DownloadContext downloadContext = DownloadContext.this;
                    downloadContext.contextListener.queueEnd(downloadContext);
                }
            });
            return;
        }
        downloadContextListener.queueEnd(this);
    }

    public void executeOnSerialExecutor(Runnable runnable) {
        SERIAL_EXECUTOR.execute(runnable);
    }

    public void startOnParallel(DownloadListener downloadListener) {
        start(downloadListener, false);
    }

    public void startOnSerial(DownloadListener downloadListener) {
        start(downloadListener, true);
    }

    public void start(@Nullable final DownloadListener downloadListener, boolean z) {
        long uptimeMillis = SystemClock.uptimeMillis();
        Util.d(TAG, "start " + z);
        this.started = true;
        if (this.contextListener != null) {
            downloadListener = new DownloadListenerBunch.Builder().append(downloadListener).append(new QueueAttachTaskStartEndListener(this, this.contextListener, this.tasks.length)).build();
        }
        if (z) {
            final ArrayList arrayList = new ArrayList();
            Collections.addAll(arrayList, this.tasks);
            Collections.sort(arrayList);
            executeOnSerialExecutor(new Runnable() { // from class: com.baidu.searchbox.bddownload.DownloadContext.1
                @Override // java.lang.Runnable
                public void run() {
                    for (DownloadTask downloadTask : arrayList) {
                        if (DownloadContext.this.isStarted()) {
                            downloadTask.execute(downloadListener);
                        } else {
                            DownloadContext.this.callbackQueueEndOnSerialLoop(downloadTask.isAutoCallbackToUIThread());
                            return;
                        }
                    }
                }
            });
        } else {
            DownloadTask.enqueue(this.tasks, downloadListener);
        }
        Util.d(TAG, "start finish " + z + " " + (SystemClock.uptimeMillis() - uptimeMillis) + "ms");
    }
}

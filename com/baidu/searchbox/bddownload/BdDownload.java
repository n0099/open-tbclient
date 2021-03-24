package com.baidu.searchbox.bddownload;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.bddownload.core.Util;
import com.baidu.searchbox.bddownload.core.breakpoint.BreakpointStore;
import com.baidu.searchbox.bddownload.core.breakpoint.DownloadStore;
import com.baidu.searchbox.bddownload.core.connection.DownloadConnection;
import com.baidu.searchbox.bddownload.core.dispatcher.CallbackDispatcher;
import com.baidu.searchbox.bddownload.core.dispatcher.DownloadDispatcher;
import com.baidu.searchbox.bddownload.core.download.DownloadStrategy;
import com.baidu.searchbox.bddownload.core.file.DownloadOutputStream;
import com.baidu.searchbox.bddownload.core.file.DownloadUriOutputStream;
import com.baidu.searchbox.bddownload.core.file.ProcessFileStrategy;
import com.baidu.searchbox.common.runtime.AppRuntime;
/* loaded from: classes2.dex */
public class BdDownload {
    @SuppressLint({"StaticFieldLeak"})
    public static volatile BdDownload singleton;
    public final BreakpointStore breakpointStore;
    public final CallbackDispatcher callbackDispatcher;
    public final DownloadConnection.Factory connectionFactory;
    public final Context context;
    public final DownloadDispatcher downloadDispatcher;
    public final DownloadStrategy downloadStrategy;
    @Nullable
    public DownloadMonitor monitor;
    public final DownloadOutputStream.Factory outputStreamFactory;
    public final ProcessFileStrategy processFileStrategy;

    /* loaded from: classes2.dex */
    public static class Builder {
        public CallbackDispatcher callbackDispatcher;
        public DownloadConnection.Factory connectionFactory;
        public final Context context;
        public DownloadDispatcher downloadDispatcher;
        public DownloadStore downloadStore;
        public DownloadStrategy downloadStrategy;
        public DownloadMonitor monitor;
        public DownloadOutputStream.Factory outputStreamFactory;
        public ProcessFileStrategy processFileStrategy;

        public Builder(@NonNull Context context) {
            this.context = context.getApplicationContext();
        }

        public BdDownload build() {
            if (this.downloadDispatcher == null) {
                this.downloadDispatcher = new DownloadDispatcher();
            }
            if (this.callbackDispatcher == null) {
                this.callbackDispatcher = new CallbackDispatcher();
            }
            if (this.downloadStore == null) {
                this.downloadStore = Util.createDefaultDatabase(this.context);
            }
            if (this.connectionFactory == null) {
                this.connectionFactory = Util.createDefaultConnectionFactory();
            }
            if (this.outputStreamFactory == null) {
                this.outputStreamFactory = new DownloadUriOutputStream.Factory();
            }
            if (this.processFileStrategy == null) {
                this.processFileStrategy = new ProcessFileStrategy();
            }
            if (this.downloadStrategy == null) {
                this.downloadStrategy = new DownloadStrategy();
            }
            BdDownload bdDownload = new BdDownload(this.context, this.downloadDispatcher, this.callbackDispatcher, this.downloadStore, this.connectionFactory, this.outputStreamFactory, this.processFileStrategy, this.downloadStrategy);
            bdDownload.setMonitor(this.monitor);
            Util.d("BdDownload", "downloadStore[" + this.downloadStore + "] connectionFactory[" + this.connectionFactory);
            return bdDownload;
        }

        public Builder callbackDispatcher(CallbackDispatcher callbackDispatcher) {
            this.callbackDispatcher = callbackDispatcher;
            return this;
        }

        public Builder connectionFactory(DownloadConnection.Factory factory) {
            this.connectionFactory = factory;
            return this;
        }

        public Builder downloadDispatcher(DownloadDispatcher downloadDispatcher) {
            this.downloadDispatcher = downloadDispatcher;
            return this;
        }

        public Builder downloadStore(DownloadStore downloadStore) {
            this.downloadStore = downloadStore;
            return this;
        }

        public Builder downloadStrategy(DownloadStrategy downloadStrategy) {
            this.downloadStrategy = downloadStrategy;
            return this;
        }

        public Builder monitor(DownloadMonitor downloadMonitor) {
            this.monitor = downloadMonitor;
            return this;
        }

        public Builder outputStreamFactory(DownloadOutputStream.Factory factory) {
            this.outputStreamFactory = factory;
            return this;
        }

        public Builder processFileStrategy(ProcessFileStrategy processFileStrategy) {
            this.processFileStrategy = processFileStrategy;
            return this;
        }
    }

    public BdDownload(Context context, DownloadDispatcher downloadDispatcher, CallbackDispatcher callbackDispatcher, DownloadStore downloadStore, DownloadConnection.Factory factory, DownloadOutputStream.Factory factory2, ProcessFileStrategy processFileStrategy, DownloadStrategy downloadStrategy) {
        this.context = context;
        this.downloadDispatcher = downloadDispatcher;
        this.callbackDispatcher = callbackDispatcher;
        this.breakpointStore = downloadStore;
        this.connectionFactory = factory;
        this.outputStreamFactory = factory2;
        this.processFileStrategy = processFileStrategy;
        this.downloadStrategy = downloadStrategy;
        downloadDispatcher.setDownloadStore(Util.createRemitDatabase(downloadStore));
    }

    public static void setSingletonInstance(@NonNull BdDownload bdDownload) {
        if (singleton == null) {
            synchronized (BdDownload.class) {
                if (singleton == null) {
                    singleton = bdDownload;
                } else {
                    throw new IllegalArgumentException("BdDownload must be null.");
                }
            }
            return;
        }
        throw new IllegalArgumentException("BdDownload must be null.");
    }

    public static BdDownload with() {
        if (singleton == null) {
            synchronized (BdDownload.class) {
                if (singleton == null) {
                    if (DownloadProvider.context != null) {
                        singleton = new Builder(DownloadProvider.context).build();
                    } else if (AppRuntime.getAppContext() != null) {
                        singleton = new Builder(AppRuntime.getAppContext()).build();
                    } else {
                        throw new IllegalStateException("context == null");
                    }
                }
            }
        }
        return singleton;
    }

    public BreakpointStore breakpointStore() {
        return this.breakpointStore;
    }

    public CallbackDispatcher callbackDispatcher() {
        return this.callbackDispatcher;
    }

    public DownloadConnection.Factory connectionFactory() {
        return this.connectionFactory;
    }

    public Context context() {
        return this.context;
    }

    public DownloadDispatcher downloadDispatcher() {
        return this.downloadDispatcher;
    }

    public DownloadStrategy downloadStrategy() {
        return this.downloadStrategy;
    }

    @Nullable
    public DownloadMonitor getMonitor() {
        return this.monitor;
    }

    public DownloadOutputStream.Factory outputStreamFactory() {
        return this.outputStreamFactory;
    }

    public ProcessFileStrategy processFileStrategy() {
        return this.processFileStrategy;
    }

    public void setMonitor(@Nullable DownloadMonitor downloadMonitor) {
        this.monitor = downloadMonitor;
    }
}

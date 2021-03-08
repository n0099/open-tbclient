package com.baidu.searchbox.logsystem.logsys;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.logsystem.logsys.LogDiskStoreConfig;
import com.baidu.searchbox.logsystem.logsys.LogUploadConfig;
/* loaded from: classes4.dex */
public class LogSystemConfig {
    @NonNull
    private Context mContext;
    @NonNull
    private LogDiskStoreConfig mLogDiskStoreConfig;
    @NonNull
    private LogUploadConfig mLogUploadConfig;

    public static void init() {
        LogUploadConfig.init();
        LogDiskStoreConfig.init();
    }

    private LogSystemConfig(@NonNull Builder builder) {
        LogDiskStoreConfig logDiskStoreConfig;
        LogUploadConfig logUploadConfig;
        this.mContext = builder.mContext;
        if (builder.mLogDiskStoreConfig == null) {
            logDiskStoreConfig = new LogDiskStoreConfig.Builder(this.mContext).build();
        } else {
            logDiskStoreConfig = builder.mLogDiskStoreConfig;
        }
        this.mLogDiskStoreConfig = logDiskStoreConfig;
        if (builder.mLogUploadConfig == null) {
            logUploadConfig = new LogUploadConfig.Builder().build();
        } else {
            logUploadConfig = builder.mLogUploadConfig;
        }
        this.mLogUploadConfig = logUploadConfig;
    }

    @NonNull
    public static Builder newBuilder(@NonNull Context context) {
        return new Builder(context);
    }

    @NonNull
    public LogUploadConfig getLogUploadNetworkConfig() {
        return this.mLogUploadConfig;
    }

    @NonNull
    public LogDiskStoreConfig getLogDiskStoreConfig() {
        return this.mLogDiskStoreConfig;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes4.dex */
    public static class Builder {
        @NonNull
        private Context mContext;
        @Nullable
        private LogDiskStoreConfig mLogDiskStoreConfig;
        @Nullable
        private LogUploadConfig mLogUploadConfig;

        public Builder(@NonNull Context context) {
            this.mContext = context;
        }

        @NonNull
        private Builder setLogUploadNetworkConfig(@Nullable LogUploadConfig logUploadConfig) {
            this.mLogUploadConfig = logUploadConfig;
            return this;
        }

        @NonNull
        private Builder setLogDiskStoreConfig(@Nullable LogDiskStoreConfig logDiskStoreConfig) {
            this.mLogDiskStoreConfig = logDiskStoreConfig;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @NonNull
        public LogSystemConfig build() {
            return new LogSystemConfig(this);
        }
    }
}

package com.baidu.searchbox.logsystem.logsys;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.logsystem.logsys.LogDiskStoreConfig;
import com.baidu.searchbox.logsystem.logsys.LogUploadConfig;
/* loaded from: classes3.dex */
public class LogSystemConfig {
    @NonNull
    public Context mContext;
    @NonNull
    public LogDiskStoreConfig mLogDiskStoreConfig;
    @NonNull
    public LogUploadConfig mLogUploadConfig;

    /* loaded from: classes3.dex */
    public static class Builder {
        @NonNull
        public Context mContext;
        @Nullable
        public LogDiskStoreConfig mLogDiskStoreConfig;
        @Nullable
        public LogUploadConfig mLogUploadConfig;

        public Builder(@NonNull Context context) {
            this.mContext = context;
        }

        @NonNull
        private Builder setLogDiskStoreConfig(@Nullable LogDiskStoreConfig logDiskStoreConfig) {
            this.mLogDiskStoreConfig = logDiskStoreConfig;
            return this;
        }

        @NonNull
        private Builder setLogUploadNetworkConfig(@Nullable LogUploadConfig logUploadConfig) {
            this.mLogUploadConfig = logUploadConfig;
            return this;
        }

        @NonNull
        public LogSystemConfig build() {
            return new LogSystemConfig(this);
        }
    }

    public static void init() {
        LogUploadConfig.init();
        LogDiskStoreConfig.init();
    }

    @NonNull
    public static Builder newBuilder(@NonNull Context context) {
        return new Builder(context);
    }

    @NonNull
    public LogDiskStoreConfig getLogDiskStoreConfig() {
        return this.mLogDiskStoreConfig;
    }

    @NonNull
    public LogUploadConfig getLogUploadNetworkConfig() {
        return this.mLogUploadConfig;
    }

    public LogSystemConfig(@NonNull Builder builder) {
        LogDiskStoreConfig logDiskStoreConfig;
        LogUploadConfig logUploadConfig;
        this.mContext = builder.mContext;
        if (builder.mLogDiskStoreConfig != null) {
            logDiskStoreConfig = builder.mLogDiskStoreConfig;
        } else {
            logDiskStoreConfig = new LogDiskStoreConfig.Builder(this.mContext).build();
        }
        this.mLogDiskStoreConfig = logDiskStoreConfig;
        if (builder.mLogUploadConfig != null) {
            logUploadConfig = builder.mLogUploadConfig;
        } else {
            logUploadConfig = new LogUploadConfig.Builder().build();
        }
        this.mLogUploadConfig = logUploadConfig;
    }
}

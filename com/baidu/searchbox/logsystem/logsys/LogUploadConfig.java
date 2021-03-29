package com.baidu.searchbox.logsystem.logsys;

import androidx.annotation.NonNull;
/* loaded from: classes2.dex */
public class LogUploadConfig {
    public boolean mUploadWifiOnly;

    /* loaded from: classes2.dex */
    public static class Builder {
        public boolean mUploadWifiOnly = false;

        @NonNull
        public LogUploadConfig build() {
            return new LogUploadConfig(this);
        }

        @NonNull
        public Builder setUploadWifiOnly(boolean z) {
            this.mUploadWifiOnly = z;
            return this;
        }
    }

    public static void init() {
    }

    public boolean getUploadWifiOnly() {
        return this.mUploadWifiOnly;
    }

    public LogUploadConfig(@NonNull Builder builder) {
        this.mUploadWifiOnly = builder.mUploadWifiOnly;
    }
}

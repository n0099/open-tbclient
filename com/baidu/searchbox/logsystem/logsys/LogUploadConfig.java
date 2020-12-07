package com.baidu.searchbox.logsystem.logsys;

import android.support.annotation.NonNull;
/* loaded from: classes9.dex */
public class LogUploadConfig {
    private boolean mUploadWifiOnly;

    public static void init() {
    }

    private LogUploadConfig(@NonNull Builder builder) {
        this.mUploadWifiOnly = builder.mUploadWifiOnly;
    }

    public boolean getUploadWifiOnly() {
        return this.mUploadWifiOnly;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes9.dex */
    public static class Builder {
        private boolean mUploadWifiOnly = false;

        @NonNull
        public Builder setUploadWifiOnly(boolean z) {
            this.mUploadWifiOnly = z;
            return this;
        }

        @NonNull
        public LogUploadConfig build() {
            return new LogUploadConfig(this);
        }
    }
}

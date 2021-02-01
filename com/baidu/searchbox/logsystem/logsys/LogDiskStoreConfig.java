package com.baidu.searchbox.logsystem.logsys;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.common.others.java.Supplier;
import java.io.File;
/* loaded from: classes5.dex */
public class LogDiskStoreConfig {
    private static final String DEFAULT_LOG_STORE_ROOT_DIR = "log_store";
    @NonNull
    private Supplier<File> mLogStoreRootDirSupplier;

    private LogDiskStoreConfig(@NonNull final Builder builder) {
        this.mLogStoreRootDirSupplier = builder.mLogStoreRootDirSupplier == null ? new Supplier<File>() { // from class: com.baidu.searchbox.logsystem.logsys.LogDiskStoreConfig.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.baidu.android.common.others.java.Supplier
            public File get() {
                Context applicationContext = builder.mContext.getApplicationContext();
                if (applicationContext == null) {
                    applicationContext = builder.mContext;
                }
                return new File(applicationContext.getFilesDir(), LogDiskStoreConfig.DEFAULT_LOG_STORE_ROOT_DIR);
            }
        } : builder.mLogStoreRootDirSupplier;
    }

    public static void init() {
    }

    @NonNull
    public Supplier<File> getLogStoreRootDirSupplier() {
        return this.mLogStoreRootDirSupplier;
    }

    /* loaded from: classes5.dex */
    public static class Builder {
        @NonNull
        private Context mContext;
        @Nullable
        private Supplier<File> mLogStoreRootDirSupplier;

        public Builder(@NonNull Context context) {
            this.mContext = context;
        }

        @NonNull
        private Builder setLogStoreRootDirSupplier(@Nullable Supplier<File> supplier) {
            this.mLogStoreRootDirSupplier = supplier;
            return this;
        }

        @NonNull
        public LogDiskStoreConfig build() {
            return new LogDiskStoreConfig(this);
        }
    }
}

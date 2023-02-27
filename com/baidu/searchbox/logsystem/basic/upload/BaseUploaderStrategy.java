package com.baidu.searchbox.logsystem.basic.upload;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.logsystem.logsys.LogFile;
import com.baidu.searchbox.logsystem.logsys.LogObject;
import java.util.List;
import java.util.Set;
/* loaded from: classes2.dex */
public abstract class BaseUploaderStrategy implements UploadInterface {
    public boolean mUploadJavaCrash;
    public UploadListener mUploadListener;
    public boolean mUploadNativeCrash;

    /* loaded from: classes2.dex */
    public interface UploadListener {
        void onUploadDone(@Nullable LogObject logObject);

        void onUploadStart(@Nullable LogObject logObject);
    }

    public boolean canStopService() {
        return true;
    }

    @Override // com.baidu.searchbox.logsystem.basic.upload.UploadInterface
    public void upload(Context context) {
    }

    @Override // com.baidu.searchbox.logsystem.basic.upload.UploadInterface
    public void upload(Context context, @NonNull LogObject logObject, @Nullable List<LogFile> list, @Nullable Set<LogFile> set, @Nullable List<LogFile> list2) {
    }

    public BaseUploaderStrategy() {
        this.mUploadJavaCrash = true;
        this.mUploadNativeCrash = true;
        this.mUploadListener = null;
    }

    public BaseUploaderStrategy(boolean z, boolean z2) {
        this(z, z2, null);
    }

    public BaseUploaderStrategy(boolean z, boolean z2, @Nullable UploadListener uploadListener) {
        this.mUploadJavaCrash = true;
        this.mUploadNativeCrash = true;
        this.mUploadListener = null;
        this.mUploadJavaCrash = z;
        this.mUploadNativeCrash = z2;
        this.mUploadListener = uploadListener;
    }
}

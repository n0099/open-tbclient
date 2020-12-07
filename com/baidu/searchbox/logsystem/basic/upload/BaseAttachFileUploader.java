package com.baidu.searchbox.logsystem.basic.upload;

import android.support.annotation.NonNull;
import java.io.File;
/* loaded from: classes15.dex */
public abstract class BaseAttachFileUploader {
    public abstract ResponseEntity uploadSync(@NonNull String str, @NonNull File file);
}

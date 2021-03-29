package com.baidu.searchbox.logsystem.basic.upload;

import androidx.annotation.NonNull;
import java.io.File;
/* loaded from: classes2.dex */
public abstract class BaseAttachFileUploader {
    public abstract ResponseEntity uploadSync(@NonNull String str, @NonNull File file);
}

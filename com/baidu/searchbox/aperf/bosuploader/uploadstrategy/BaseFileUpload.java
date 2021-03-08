package com.baidu.searchbox.aperf.bosuploader.uploadstrategy;

import androidx.annotation.NonNull;
import java.io.File;
/* loaded from: classes5.dex */
public abstract class BaseFileUpload {
    public abstract ResponseEntity uploadSync(@NonNull String str, @NonNull File file);
}

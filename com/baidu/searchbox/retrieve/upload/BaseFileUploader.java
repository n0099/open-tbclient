package com.baidu.searchbox.retrieve.upload;

import androidx.annotation.NonNull;
import com.baidu.tieba.s9a;
import java.io.File;
/* loaded from: classes2.dex */
public abstract class BaseFileUploader {
    public abstract s9a uploadSync(@NonNull String str, @NonNull String str2, @NonNull File file);
}

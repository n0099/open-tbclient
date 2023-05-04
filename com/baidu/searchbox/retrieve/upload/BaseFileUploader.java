package com.baidu.searchbox.retrieve.upload;

import androidx.annotation.NonNull;
import com.baidu.tieba.nna;
import java.io.File;
/* loaded from: classes2.dex */
public abstract class BaseFileUploader {
    public abstract nna uploadSync(@NonNull String str, @NonNull String str2, @NonNull File file);
}

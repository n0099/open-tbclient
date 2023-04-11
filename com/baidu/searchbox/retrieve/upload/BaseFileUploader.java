package com.baidu.searchbox.retrieve.upload;

import androidx.annotation.NonNull;
import com.baidu.tieba.jja;
import java.io.File;
/* loaded from: classes2.dex */
public abstract class BaseFileUploader {
    public abstract jja uploadSync(@NonNull String str, @NonNull String str2, @NonNull File file);
}

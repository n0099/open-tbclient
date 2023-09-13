package com.baidu.searchbox.retrieve.upload;

import androidx.annotation.NonNull;
import com.baidu.tieba.okb;
import java.io.File;
/* loaded from: classes4.dex */
public abstract class BaseFileUploader {
    public abstract okb uploadSync(@NonNull String str, @NonNull String str2, @NonNull File file);
}

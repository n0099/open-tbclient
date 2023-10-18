package com.baidu.searchbox.retrieve.upload;

import androidx.annotation.NonNull;
import com.baidu.tieba.bhb;
import java.io.File;
/* loaded from: classes4.dex */
public abstract class BaseFileUploader {
    public abstract bhb uploadSync(@NonNull String str, @NonNull String str2, @NonNull File file);
}

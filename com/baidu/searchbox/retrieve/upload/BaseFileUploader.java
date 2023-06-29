package com.baidu.searchbox.retrieve.upload;

import androidx.annotation.NonNull;
import com.baidu.tieba.n3b;
import java.io.File;
/* loaded from: classes4.dex */
public abstract class BaseFileUploader {
    public abstract n3b uploadSync(@NonNull String str, @NonNull String str2, @NonNull File file);
}

package com.baidu.searchbox.retrieve.upload;

import androidx.annotation.NonNull;
import com.baidu.tieba.lcb;
import java.io.File;
/* loaded from: classes4.dex */
public class DefaultFileUploader extends BaseFileUploader {
    @Override // com.baidu.searchbox.retrieve.upload.BaseFileUploader
    public lcb uploadSync(@NonNull String str, @NonNull String str2, @NonNull File file) {
        return new lcb();
    }
}

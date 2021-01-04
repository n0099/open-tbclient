package com.baidu.searchbox.aperf.bosuploader.uploadstrategy;

import androidx.annotation.NonNull;
import com.baidu.e.c.b;
import com.baidu.searchbox.aperf.bosuploader.BOSResponseEntity;
import com.baidu.searchbox.aperf.bosuploader.BOSUploader;
import com.baidu.searchbox.aperf.bosuploader.UploadUrlListener;
import java.io.File;
/* loaded from: classes5.dex */
public class BOSFileUpload extends BaseFileUpload {
    private static final String BIZ_ANR = "performance-anr";

    @Override // com.baidu.searchbox.aperf.bosuploader.uploadstrategy.BaseFileUpload
    public ResponseEntity uploadSync(@NonNull String str, @NonNull File file) {
        BOSResponseEntity uploadFileSync = BOSUploader.getInstance().uploadFileSync(BIZ_ANR, str, file, new UploadUrlListener() { // from class: com.baidu.searchbox.aperf.bosuploader.uploadstrategy.BOSFileUpload.1
            @Override // com.baidu.searchbox.aperf.bosuploader.UploadUrlListener
            public String processUrl() {
                return b.uq().processUrl(BASE_UPLOAD_URL);
            }
        });
        return new ResponseEntity(uploadFileSync.isSuccess(), uploadFileSync.getMessage());
    }
}

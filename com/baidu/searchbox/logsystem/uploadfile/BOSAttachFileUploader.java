package com.baidu.searchbox.logsystem.uploadfile;

import androidx.annotation.NonNull;
import com.baidu.searchbox.aperf.bosuploader.BOSResponseEntity;
import com.baidu.searchbox.aperf.bosuploader.BOSUploader;
import com.baidu.searchbox.aperf.bosuploader.UploadUrlListener;
import com.baidu.searchbox.logsystem.basic.upload.BaseAttachFileUploader;
import com.baidu.searchbox.logsystem.basic.upload.ResponseEntity;
import com.baidu.searchbox.logsystem.basic.upload.identity.LokiIdentityManager;
import java.io.File;
/* loaded from: classes6.dex */
public class BOSAttachFileUploader extends BaseAttachFileUploader {
    private static final String BIZ_CRASH = "crash";

    @Override // com.baidu.searchbox.logsystem.basic.upload.BaseAttachFileUploader
    public ResponseEntity uploadSync(@NonNull String str, @NonNull File file) {
        BOSResponseEntity uploadFileSync = BOSUploader.getInstance().uploadFileSync("crash", str, file, new UploadUrlListener() { // from class: com.baidu.searchbox.logsystem.uploadfile.BOSAttachFileUploader.1
            @Override // com.baidu.searchbox.aperf.bosuploader.UploadUrlListener
            public String processUrl() {
                return LokiIdentityManager.getInstance().processUrl(BASE_UPLOAD_URL);
            }
        });
        return new ResponseEntity(uploadFileSync.isSuccess(), uploadFileSync.getMessage());
    }
}

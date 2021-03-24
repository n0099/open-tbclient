package com.baidu.searchbox.aperf.bosuploader.uploadstrategy;

import androidx.annotation.NonNull;
import com.baidu.common.param.CommonUrlParamManager;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.searchbox.aperf.bosuploader.BOSResponseEntity;
import com.baidu.searchbox.aperf.bosuploader.BOSUploader;
import com.baidu.searchbox.aperf.bosuploader.UploadUrlListener;
import java.io.File;
@Singleton
@Service
/* loaded from: classes2.dex */
public class BOSFileUpload extends BaseFileUpload {
    public static final String BIZ_ANR = "performance-anr";

    @Override // com.baidu.searchbox.aperf.bosuploader.uploadstrategy.BaseFileUpload
    public ResponseEntity uploadSync(@NonNull String str, @NonNull File file) {
        BOSResponseEntity uploadFileSync = BOSUploader.getInstance().uploadFileSync(BIZ_ANR, str, file, new UploadUrlListener() { // from class: com.baidu.searchbox.aperf.bosuploader.uploadstrategy.BOSFileUpload.1
            @Override // com.baidu.searchbox.aperf.bosuploader.UploadUrlListener
            public String processUrl() {
                return CommonUrlParamManager.getInstance().processUrl(UploadUrlListener.BASE_UPLOAD_URL);
            }
        });
        return new ResponseEntity(uploadFileSync.isSuccess(), uploadFileSync.getMessage());
    }
}

package com.baidu.searchbox.anr.upload;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.anr.impl.ANRInfo;
import com.baidu.searchbox.anr.ioc.IANRRegister;
import com.baidu.searchbox.anr.ubc.UbcANRRegister;
import com.baidu.searchbox.aperf.bosuploader.uploadstrategy.FileUploadStrategy;
import com.baidu.searchbox.config.AppConfig;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes20.dex */
public class ANRBOSRegister implements IANRRegister {
    private String uploadType = "anr";
    private FileUploadStrategy fileUploadStrategy = new FileUploadStrategy();
    private List<File> uploadFiles = new ArrayList();

    @Override // com.baidu.searchbox.anr.ioc.IANRRegister
    public boolean checkEnable() {
        return UbcANRRegister.sEnable;
    }

    public void retryUpload() {
        if (FileUploadStrategy.checkFlag()) {
            this.fileUploadStrategy.upload();
        }
    }

    @Override // com.baidu.searchbox.anr.ioc.IANRRegister
    public void onANR(Context context, ANRInfo aNRInfo) {
        if (checkEnable()) {
            if (!AppConfig.isDebug()) {
            }
            Log.d("Ruka", "onANR  at ANRBOSRegister");
            this.uploadFiles.clear();
            if (!TextUtils.isEmpty(aNRInfo.getLogcatPath())) {
                File file = new File(aNRInfo.getLogcatPath());
                if (file.exists()) {
                    this.uploadFiles.add(file);
                }
            }
            if (!TextUtils.isEmpty(aNRInfo.getTracesPath())) {
                File file2 = new File(aNRInfo.getTracesPath());
                if (file2.exists() && file2.canRead()) {
                    this.uploadFiles.add(file2);
                    fileUploadBOS(this.uploadFiles, aNRInfo.getLogId());
                    return;
                }
            }
            if (!TextUtils.isEmpty(aNRInfo.getAllStackTracePath())) {
                File file3 = new File(aNRInfo.getAllStackTracePath());
                if (file3.exists()) {
                    this.uploadFiles.add(file3);
                    fileUploadBOS(this.uploadFiles, aNRInfo.getLogId());
                }
            }
        }
    }

    private void fileUploadBOS(List<File> list, String str) {
        if (!list.isEmpty() && !TextUtils.isEmpty(str)) {
            this.fileUploadStrategy.upload(list, str, this.uploadType);
        }
    }
}

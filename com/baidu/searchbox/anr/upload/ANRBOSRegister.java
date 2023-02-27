package com.baidu.searchbox.anr.upload;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.util.io.FileUtils;
import com.baidu.pyramid.annotation.Service;
import com.baidu.searchbox.anr.impl.ANRInfo;
import com.baidu.searchbox.anr.ioc.IANRRegister;
import com.baidu.searchbox.anr.ubc.UbcANRRegister;
import com.baidu.searchbox.aperf.bosuploader.uploadstrategy.FileUploadStrategy;
import com.baidu.searchbox.block.impl.BlockMonitor;
import com.baidu.searchbox.config.AppConfig;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
@Service
/* loaded from: classes2.dex */
public class ANRBOSRegister implements IANRRegister {
    public String uploadType = "anr";
    public FileUploadStrategy fileUploadStrategy = new FileUploadStrategy();
    public List<File> uploadFiles = new ArrayList();

    @Override // com.baidu.searchbox.anr.ioc.IANRRegister
    public boolean checkEnable() {
        return UbcANRRegister.sEnable;
    }

    public void retryUpload() {
        if (FileUploadStrategy.checkFlag()) {
            this.fileUploadStrategy.upload();
        }
    }

    private void deleteFiles(List<File> list) {
        if (list != null && list.size() > 0) {
            for (File file : list) {
                FileUtils.deleteFile(file);
            }
        }
    }

    private void fileUploadBOS(List<File> list, String str) {
        if (!list.isEmpty() && !TextUtils.isEmpty(str)) {
            this.fileUploadStrategy.upload(list, str, this.uploadType);
        }
    }

    @Override // com.baidu.searchbox.anr.ioc.IANRRegister
    public void onANR(Context context, ANRInfo aNRInfo) {
        if (!checkEnable()) {
            return;
        }
        if (AppConfig.isDebug()) {
            Log.d(BlockMonitor.TAG, "onANR  at ANRBOSRegister");
        }
        this.uploadFiles.clear();
        File file = null;
        if (!TextUtils.isEmpty(aNRInfo.getLogcatPath())) {
            file = new File(aNRInfo.getLogcatPath());
            if (file.exists()) {
                this.uploadFiles.add(file);
            }
        }
        if (!TextUtils.isEmpty(aNRInfo.getTracesPath())) {
            File file2 = new File(aNRInfo.getTracesPath());
            if (file2.exists() && file2.canRead()) {
                this.uploadFiles.add(file2);
                fileUploadBOS(this.uploadFiles, aNRInfo.getLogId());
                FileUtils.deleteFile(file);
                return;
            }
        }
        if (!TextUtils.isEmpty(aNRInfo.getAllStackTracePath())) {
            File file3 = new File(aNRInfo.getAllStackTracePath());
            if (file3.exists()) {
                this.uploadFiles.add(file3);
                fileUploadBOS(this.uploadFiles, aNRInfo.getLogId());
                deleteFiles(this.uploadFiles);
            }
        }
    }
}

package com.baidu.searchbox.ruka.ubc;

import android.text.TextUtils;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.PerfSampleManager;
import com.baidu.searchbox.config.QuickPersistConfig;
import com.baidu.ubc.UBCManager;
@Service
/* loaded from: classes2.dex */
public class LooperPerfSampleCallback implements PerfSampleManager.IPerfSampleCallback {
    public static String ACTIVE_UPLOAD_TYPE = "1";
    public static String PASSIVE_UPLOAD_TYPE = "0";
    public static String UBC_BLOCK_ID = "1157";

    @Override // com.baidu.searchbox.PerfSampleManager.IPerfSampleCallback
    public String getSampleFlag() {
        UBCManager uBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
        if (uBCManager != null) {
            String uploadType = uBCManager.getUploadType(UBC_BLOCK_ID);
            if (TextUtils.equals(ACTIVE_UPLOAD_TYPE, uploadType)) {
                if (!UBCLooperRegister.sEnable) {
                    QuickPersistConfig.getInstance().putBoolean(UBCLooperRegister.KEY_BLOCK_ACTIVE_UPLOAD, true);
                }
            } else if (TextUtils.equals(PASSIVE_UPLOAD_TYPE, uploadType) && UBCLooperRegister.sEnable) {
                QuickPersistConfig.getInstance().putBoolean(UBCLooperRegister.KEY_BLOCK_ACTIVE_UPLOAD, false);
            }
        }
        return UBCLooperRegister.sEnable ? UBC_BLOCK_ID : "";
    }
}

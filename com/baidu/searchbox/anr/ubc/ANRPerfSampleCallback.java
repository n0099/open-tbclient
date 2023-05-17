package com.baidu.searchbox.anr.ubc;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.PerfSampleManager;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.config.QuickPersistConfig;
import com.baidu.ubc.UBCManager;
@Service
/* loaded from: classes3.dex */
public class ANRPerfSampleCallback implements PerfSampleManager.IPerfSampleCallback {
    public static String ACTIVE_ANR_UPLOAD_TYPE = "1";
    public static String PASSIVE_ANR_UPLOAD_TYPE = "0";
    public static String UBC_ANR_ID = "1794";

    @Override // com.baidu.searchbox.PerfSampleManager.IPerfSampleCallback
    public String getSampleFlag() {
        UBCManager uBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
        if (uBCManager != null) {
            String uploadType = uBCManager.getUploadType(UBC_ANR_ID);
            if (AppConfig.isDebug()) {
                Log.d("ANRPerfSampleCallback", "getSampleFlag uploadType " + uploadType);
            }
            if (TextUtils.equals(ACTIVE_ANR_UPLOAD_TYPE, uploadType)) {
                if (!UbcANRRegister.sEnable) {
                    QuickPersistConfig.getInstance().putBoolean(UbcANRRegister.KEY_ANR_ACTIVE_UPLOAD, true);
                }
            } else if (TextUtils.equals(PASSIVE_ANR_UPLOAD_TYPE, uploadType) && UbcANRRegister.sEnable) {
                QuickPersistConfig.getInstance().putBoolean(UbcANRRegister.KEY_ANR_ACTIVE_UPLOAD, false);
            }
        }
        if (UbcANRRegister.sEnable) {
            return UBC_ANR_ID;
        }
        return "";
    }
}

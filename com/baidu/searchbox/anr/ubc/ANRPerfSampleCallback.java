package com.baidu.searchbox.anr.ubc;

import android.text.TextUtils;
import com.baidu.pyramid.runtime.service.c;
import com.baidu.searchbox.PerfSampleManager;
import com.baidu.searchbox.config.QuickPersistConfig;
import com.baidu.ubc.ab;
/* loaded from: classes5.dex */
public class ANRPerfSampleCallback implements PerfSampleManager.IPerfSampleCallback {
    private static String UBC_ANR_ID = "1794";
    private static String ACTIVE_ANR_UPLOAD_TYPE = "1";
    private static String PASSIVE_ANR_UPLOAD_TYPE = "0";

    @Override // com.baidu.searchbox.PerfSampleManager.IPerfSampleCallback
    public String getSampleFlag() {
        ab abVar = (ab) c.a(ab.SERVICE_REFERENCE);
        if (abVar != null) {
            String uploadType = abVar.getUploadType(UBC_ANR_ID);
            if (TextUtils.equals(ACTIVE_ANR_UPLOAD_TYPE, uploadType)) {
                if (!UbcANRRegister.sEnable) {
                    QuickPersistConfig.getInstance().putBoolean(UbcANRRegister.KEY_ANR_ACTIVE_UPLOAD, true);
                }
            } else if (TextUtils.equals(PASSIVE_ANR_UPLOAD_TYPE, uploadType) && UbcANRRegister.sEnable) {
                QuickPersistConfig.getInstance().putBoolean(UbcANRRegister.KEY_ANR_ACTIVE_UPLOAD, false);
            }
        }
        return UbcANRRegister.sEnable ? UBC_ANR_ID : "";
    }
}

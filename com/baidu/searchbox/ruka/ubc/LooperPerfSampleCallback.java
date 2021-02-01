package com.baidu.searchbox.ruka.ubc;

import android.text.TextUtils;
import com.baidu.pyramid.runtime.service.c;
import com.baidu.searchbox.PerfSampleManager;
import com.baidu.searchbox.config.QuickPersistConfig;
import com.baidu.ubc.ab;
/* loaded from: classes3.dex */
public class LooperPerfSampleCallback implements PerfSampleManager.IPerfSampleCallback {
    private static String UBC_BLOCK_ID = "1157";
    private static String ACTIVE_UPLOAD_TYPE = "1";
    private static String PASSIVE_UPLOAD_TYPE = "0";

    @Override // com.baidu.searchbox.PerfSampleManager.IPerfSampleCallback
    public String getSampleFlag() {
        ab abVar = (ab) c.a(ab.SERVICE_REFERENCE);
        if (abVar != null) {
            String uploadType = abVar.getUploadType(UBC_BLOCK_ID);
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

package com.baidu.searchbox.fluency.ubc;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.PerfSampleManager;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.config.QuickPersistConfig;
import com.baidu.searchbox.fluency.BdTracesManager;
import com.baidu.ubc.UBCManager;
@Service
/* loaded from: classes3.dex */
public class FpsPerfSampleCallback implements PerfSampleManager.IPerfSampleCallback {
    public static final String ACTIVE_FPS_UPLOAD_TYPE = "1";
    public static final String KEY_FPS_ACTIVE_UPLOAD = "key_fluency_fps_active_upload";
    public static final String PASSIVE_FPS_UPLOAD_TYPE = "0";
    public static final String UBC_FPS_ID = "3715";

    @Override // com.baidu.searchbox.PerfSampleManager.IPerfSampleCallback
    public String getSampleFlag() {
        UBCManager uBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
        if (uBCManager != null) {
            String uploadType = uBCManager.getUploadType(UBC_FPS_ID);
            if (AppConfig.isDebug()) {
                Log.d("FpsPerfSampleCallback", "getFpsSampleFlag uploadType " + uploadType);
            }
            if (TextUtils.equals("1", uploadType)) {
                if (!BdTracesManager.INSTANCE.isActiveUploadType()) {
                    QuickPersistConfig.getInstance().putBoolean(KEY_FPS_ACTIVE_UPLOAD, true);
                }
            } else if (TextUtils.equals("0", uploadType) && BdTracesManager.INSTANCE.isActiveUploadType()) {
                QuickPersistConfig.getInstance().putBoolean(KEY_FPS_ACTIVE_UPLOAD, false);
            }
        }
        if (BdTracesManager.INSTANCE.isActiveUploadType()) {
            return UBC_FPS_ID;
        }
        return "";
    }
}

package com.baidu.searchbox.block.ubc;

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
public class BlockPerfSampleCallback implements PerfSampleManager.IPerfSampleCallback {
    public static final String ACTIVE_BLOCK_UPLOAD_TYPE = "1";
    public static final String PASSIVE_BLOCK_UPLOAD_TYPE = "0";
    public static final String UBC_BLOCK_ID = "3256";

    @Override // com.baidu.searchbox.PerfSampleManager.IPerfSampleCallback
    public String getSampleFlag() {
        UBCManager uBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
        if (uBCManager != null) {
            String uploadType = uBCManager.getUploadType("3256");
            if (AppConfig.isDebug()) {
                Log.d("BlockPerfSampleCallback", "getSampleFlag uploadType " + uploadType);
            }
            if (TextUtils.equals("1", uploadType)) {
                if (!UbcBlockRegister.sEnable) {
                    QuickPersistConfig.getInstance().putBoolean(UbcBlockRegister.KEY_BLOCK_CATCH_ACTIVE_UPLOAD, true);
                }
            } else if (TextUtils.equals("0", uploadType) && UbcBlockRegister.sEnable) {
                QuickPersistConfig.getInstance().putBoolean(UbcBlockRegister.KEY_BLOCK_CATCH_ACTIVE_UPLOAD, false);
            }
        }
        if (UbcBlockRegister.sEnable) {
            return "3256";
        }
        return "";
    }
}

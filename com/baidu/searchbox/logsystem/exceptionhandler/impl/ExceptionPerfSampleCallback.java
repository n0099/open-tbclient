package com.baidu.searchbox.logsystem.exceptionhandler.impl;

import android.text.TextUtils;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.PerfSampleManager;
import com.baidu.ubc.UBCManager;
@Service
/* loaded from: classes2.dex */
public class ExceptionPerfSampleCallback implements PerfSampleManager.IPerfSampleCallback {
    public static String ACTIVE_UPLOAD_TYPE = "1";

    @Override // com.baidu.searchbox.PerfSampleManager.IPerfSampleCallback
    public String getSampleFlag() {
        UBCManager uBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
        if (uBCManager != null) {
            if (TextUtils.equals(ACTIVE_UPLOAD_TYPE, uBCManager.getUploadType(ExceptionHandlerImpl.UBC_ID))) {
                return ExceptionHandlerImpl.UBC_ID;
            }
            return "";
        }
        return "";
    }
}

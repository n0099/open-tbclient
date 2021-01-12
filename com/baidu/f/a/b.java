package com.baidu.f.a;

import com.baidu.pyramid.runtime.service.c;
import com.baidu.searchbox.PerfSampleManager;
import com.baidu.ubc.ab;
/* loaded from: classes14.dex */
public class b implements PerfSampleManager.IPerfSampleCallback {
    private static String ACTIVE_UPLOAD_TYPE = "1";
    private static String PASSIVE_UPLOAD_TYPE = "0";

    @Override // com.baidu.searchbox.PerfSampleManager.IPerfSampleCallback
    public String getSampleFlag() {
        ab abVar = (ab) c.a(ab.SERVICE_REFERENCE);
        if (abVar != null) {
            if (ACTIVE_UPLOAD_TYPE.equals(abVar.getUploadType("2301"))) {
                return "2301";
            }
        }
        return "";
    }
}

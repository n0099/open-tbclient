package com.baidu.searchbox.retrieve.core;

import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.retrieve.inter.IFetchTask;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class FetchReport {
    public static void reportDataNull() {
        IFetchTask iFetchTask = (IFetchTask) ServiceManager.getService(IFetchTask.SERVICE_REFERENCE);
        if (iFetchTask != null) {
            iFetchTask.reportDispatchCheckFail("", "", "", "0", null);
        }
    }

    public static void reportDataError(String str, String str2, String str3, JSONObject jSONObject) {
        IFetchTask iFetchTask = (IFetchTask) ServiceManager.getService(IFetchTask.SERVICE_REFERENCE);
        if (iFetchTask != null) {
            iFetchTask.reportDispatchCheckFail(str, str2, str3, "1", jSONObject);
        }
    }

    public static void reportDispatch(String str, String str2, String str3, JSONObject jSONObject, String str4) {
        IFetchTask iFetchTask = (IFetchTask) ServiceManager.getService(IFetchTask.SERVICE_REFERENCE);
        if (iFetchTask != null) {
            iFetchTask.reportDispatch(str, str2, str3, jSONObject, str4);
        }
    }
}

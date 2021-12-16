package com.baidu.android.imsdk.retrieve;

import org.json.JSONObject;
/* loaded from: classes9.dex */
public interface IRetrieveReportTask {
    void reportDispatch(String str, String str2, String str3, JSONObject jSONObject, String str4, IReportListener iReportListener);

    void reportDispatchCheckFail(String str, String str2, String str3, String str4, JSONObject jSONObject);

    void reportTaskCheckFail(String str, String str2, String str3, JSONObject jSONObject, IReportListener iReportListener);

    void reportTaskDone(String str, String str2, String str3, String str4, String str5, String str6, IReportListener iReportListener, String str7);
}

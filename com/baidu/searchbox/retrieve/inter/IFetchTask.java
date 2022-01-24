package com.baidu.searchbox.retrieve.inter;

import com.baidu.pyramid.runtime.service.ServiceReference;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public interface IFetchTask {
    public static final String NAME = "report";
    public static final String NAME_SPACE = "FetchJob";
    public static final ServiceReference SERVICE_REFERENCE = new ServiceReference(NAME_SPACE, "report");

    void reportDispatch(String str, String str2, String str3, JSONObject jSONObject, String str4);

    void reportDispatchCheckFail(String str, String str2, String str3, String str4, JSONObject jSONObject);

    void reportTaskCheckFail(String str, String str2, String str3, JSONObject jSONObject);

    void reportTaskDone(String str, String str2, String str3, String str4, String str5, String str6);
}

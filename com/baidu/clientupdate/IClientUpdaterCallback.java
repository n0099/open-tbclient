package com.baidu.clientupdate;

import com.baidu.clientupdate.appinfo.ClientUpdateInfo;
import com.baidu.clientupdate.appinfo.RuleInfo;
import org.json.JSONObject;
/* loaded from: classes17.dex */
public interface IClientUpdaterCallback {
    void onCompleted(ClientUpdateInfo clientUpdateInfo, RuleInfo ruleInfo);

    void onError(JSONObject jSONObject);

    void onException(JSONObject jSONObject);

    void onFetched(JSONObject jSONObject);
}

package com.baidu.live.tbadk.ubc;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public interface IUbcManager {
    Object flowBegin(String str, JSONObject jSONObject);

    void flowEnd(Object obj);

    void flowEndSlot(Object obj, String str);

    void flowSetValueWithDuration(Object obj, JSONObject jSONObject);

    void flowStartSlot(Object obj, String str, JSONObject jSONObject);

    void onEvent(String str, JSONObject jSONObject);
}

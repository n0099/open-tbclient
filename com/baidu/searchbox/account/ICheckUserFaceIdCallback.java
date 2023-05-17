package com.baidu.searchbox.account;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public interface ICheckUserFaceIdCallback {
    void onFailure(int i, String str);

    void onSuccess(JSONObject jSONObject);
}

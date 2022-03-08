package com.baidu.searchbox.retrieve.inter.upload;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public interface IActiveUploadResult {
    String getSource();

    void onFailure(String str, JSONObject jSONObject);

    void onSuccess(String str, JSONObject jSONObject);
}

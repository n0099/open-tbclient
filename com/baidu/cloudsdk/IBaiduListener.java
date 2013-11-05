package com.baidu.cloudsdk;

import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public interface IBaiduListener {
    void onCancel();

    void onComplete();

    void onComplete(JSONArray jSONArray);

    void onComplete(JSONObject jSONObject);

    void onError(BaiduException baiduException);
}

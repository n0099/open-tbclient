package com.baidu.swan.apps.model;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public interface a {
    boolean isValid();

    void parseFromJson(JSONObject jSONObject) throws JSONException;
}

package com.baidu.swan.apps.model;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public interface a {
    boolean isValid();

    void parseFromJson(JSONObject jSONObject) throws JSONException;
}

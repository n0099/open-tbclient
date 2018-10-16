package com.baidu.searchbox.ng.ai.apps.model;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public interface IModel {
    boolean isValid();

    void parseFromJson(JSONObject jSONObject) throws JSONException;
}

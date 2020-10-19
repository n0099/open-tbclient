package com.baidu.mapapi.cloud;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public abstract class BaseSearchResult {
    public static final int STATUS_CODE_NETWORK_ERROR = -3;
    public static final int STATUS_CODE_NETWORK_TIME_OUT = -2;
    public static final int STATUS_CODE_PARAM_ERROR = 2;
    public static final int STATUS_CODE_PERMISSION_UNFINISHED = -4;
    public static final int STATUS_CODE_RESULT_NOTFOUND = -1;
    public static final int STATUS_CODE_SEARVER_ERROR = 1;
    public static final int STATUS_CODE_SUCCEED = 0;
    public int size;
    public int status = -1;
    public int total;

    public void parseFromJSON(JSONObject jSONObject) throws JSONException {
        this.status = jSONObject.optInt("status");
        if (this.status == 1233 || this.status == 2) {
            this.status = 2;
        }
        this.size = jSONObject.optInt("size");
        this.total = jSONObject.optInt("total");
    }
}

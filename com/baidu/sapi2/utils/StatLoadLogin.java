package com.baidu.sapi2.utils;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class StatLoadLogin {
    public static final String KEY_IS_LOAD_CACHE = "is_load_cache";
    public static final String KEY_LOAD_LOGIN = "t_load_login";
    public static final String KEY_START_LOGIN = "t_start_login";
    public static final String KEY_TIME_BEFORE_LOGIN = "t_before_login";
    public static final String KEY_TIME_OPEN_LOGIN = "t_open_login";
    public static final String KEY_TIME_WEBVIEW_INIT_DONE = "t_view_init_done";
    public boolean isLoadCache;
    public long tBeforeLogin;
    public long tLoadLogin;
    public long tOpenLoginPage;
    public long tStartLogin;
    public long tWebviewInitDone;

    public JSONObject toJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(KEY_TIME_OPEN_LOGIN, this.tOpenLoginPage);
            jSONObject.put(KEY_TIME_WEBVIEW_INIT_DONE, this.tWebviewInitDone);
            jSONObject.put(KEY_TIME_BEFORE_LOGIN, this.tBeforeLogin);
            jSONObject.put(KEY_START_LOGIN, this.tStartLogin);
            jSONObject.put(KEY_LOAD_LOGIN, this.tLoadLogin);
            jSONObject.put(KEY_IS_LOAD_CACHE, this.isLoadCache);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}

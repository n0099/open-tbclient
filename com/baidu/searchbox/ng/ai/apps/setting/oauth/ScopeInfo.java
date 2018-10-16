package com.baidu.searchbox.ng.ai.apps.setting.oauth;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ScopeInfo {
    public static final String GRADE_1 = "1";
    public static final String GRADE_2 = "2";
    public static final String GRADE_3 = "3";
    public static final String SCOPE_ID_CAMERA = "mapp_camera";
    public static final String SCOPE_ID_CHOOSE_ADDRESS = "mapp_choose_address";
    public static final String SCOPE_ID_INVOICE = "mapp_choose_invoice";
    public static final String SCOPE_ID_LIVE = "mapp_i_live_player";
    public static final String SCOPE_ID_LOCATION = "mapp_location";
    public static final String SCOPE_ID_MAPP_IMAGES = "mapp_images";
    public static final String SCOPE_ID_MAPP_I_DELETE_HISTORY = "mapp_i_delete_history";
    public static final String SCOPE_ID_MAPP_I_GET_BDUSS = "mapp_i_get_bduss";
    public static final String SCOPE_ID_MAPP_I_GET_HISTORY = "mapp_i_get_history";
    public static final String SCOPE_ID_MAPP_I_POLYMEPAYMENT = "mapp_i_polymepayment";
    public static final String SCOPE_ID_MOBILE = "mobile";
    public static final String SCOPE_ID_RECORD = "mapp_record";
    public static final String SCOPE_ID_SNSAPI_BASE = "snsapi_base";
    public static final String SCOPE_ID_SYS_INFO = "mapp_i_get_common_sys_info";
    public static final String SCOPE_ID_USERINFO = "snsapi_userinfo";
    public static final int TIP_STATUS_ALLOW = 1;
    public static final int TIP_STATUS_DENY = -1;
    public static final int TIP_STATUS_TIP = 0;
    private static final String TYPE_CUID_SCOPE = "2";
    private static final String TYPE_UID_SCOPE = "1";
    public boolean forbidden;
    public final String id;
    public String grade = "";
    public String name = "";
    public String shortName = "";
    public String description = "";
    public final List<String> ext = new ArrayList();
    public int tipStatus = -1;
    private String type = "";

    private ScopeInfo(String str) {
        this.id = str;
    }

    public boolean authorized() {
        return this.tipStatus > 0;
    }

    public boolean explicitly() {
        return this.tipStatus != 0;
    }

    public boolean isUidScope() {
        return "1".equals(this.type);
    }

    public static ScopeInfo parse(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String optString = jSONObject.optString("id", "");
        if (TextUtils.isEmpty(optString)) {
            return null;
        }
        return parse(optString, jSONObject);
    }

    public static ScopeInfo parse(String str, JSONObject jSONObject) {
        ScopeInfo scopeInfo = new ScopeInfo(str);
        scopeInfo.forbidden = jSONObject.optBoolean("forbidden", true);
        scopeInfo.grade = jSONObject.optString("grade");
        scopeInfo.type = jSONObject.optString("type", "");
        scopeInfo.name = jSONObject.optString("name", "");
        scopeInfo.shortName = jSONObject.optString("short_name", "");
        scopeInfo.description = jSONObject.optString("description", "");
        scopeInfo.tipStatus = jSONObject.optInt("tip_status", -1);
        JSONArray optJSONArray = jSONObject.optJSONArray("ext");
        for (int i = 0; i < optJSONArray.length(); i++) {
            scopeInfo.ext.add(optJSONArray.optString(i));
        }
        return scopeInfo;
    }

    public String toString() {
        return String.format(Locale.getDefault(), "Scope(%s) tipStatus=%d", this.id, Integer.valueOf(this.tipStatus));
    }
}

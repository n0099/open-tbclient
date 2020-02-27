package com.baidu.swan.apps.api.b;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.unitedscheme.core.R;
import java.nio.charset.StandardCharsets;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b implements a {
    private boolean bfz;
    public JSONObject data;
    public String message;
    public int statusCode;

    public b() {
        this.bfz = false;
    }

    public b(int i) {
        this.bfz = false;
        this.statusCode = i;
    }

    public b(int i, @NonNull String str) {
        this.bfz = false;
        this.statusCode = i;
        this.message = str;
    }

    public b(int i, @NonNull JSONObject jSONObject) {
        this.bfz = false;
        this.statusCode = i;
        this.data = jSONObject;
    }

    public b(int i, @NonNull JSONObject jSONObject, boolean z) {
        this.bfz = false;
        this.statusCode = i;
        this.data = jSONObject;
        this.bfz = z;
    }

    public b(int i, @NonNull String str, @NonNull JSONObject jSONObject) {
        this.bfz = false;
        this.statusCode = i;
        this.message = str;
        this.data = jSONObject;
    }

    @Override // com.baidu.swan.apps.api.b.a
    @NonNull
    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("status", String.valueOf(this.statusCode));
            if (TextUtils.isEmpty(this.message)) {
                this.message = getErrMessage(this.statusCode);
            }
            jSONObject.put("message", this.message);
            if (this.data != null) {
                jSONObject.put("data", this.bfz ? Uri.encode(this.data.toString(), StandardCharsets.UTF_8.name()) : this.data);
            }
        } catch (JSONException e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        }
        return jSONObject.toString();
    }

    public String toString() {
        return toJsonString();
    }

    public boolean isSuccess() {
        return this.statusCode == 0;
    }

    private static String getErrMessage(int i) {
        switch (i) {
            case 0:
                return AppRuntime.getAppContext().getString(R.string.united_scheme_err_message_ok);
            case 101:
                return AppRuntime.getAppContext().getString(R.string.united_scheme_err_message_not_support);
            case 201:
                return AppRuntime.getAppContext().getString(R.string.united_scheme_err_message_parse_fail);
            case 202:
                return AppRuntime.getAppContext().getString(R.string.united_scheme_err_message_params_parse_fail);
            case 301:
                return AppRuntime.getAppContext().getString(R.string.united_scheme_err_message_module_notfound);
            case 302:
                return AppRuntime.getAppContext().getString(R.string.united_scheme_err_message_action_notfound);
            case 401:
                return AppRuntime.getAppContext().getString(R.string.united_scheme_err_message_action_sec_check_fail);
            case 402:
                return AppRuntime.getAppContext().getString(R.string.united_scheme_err_message_action_acl_check_fail);
            case 403:
                return AppRuntime.getAppContext().getString(R.string.united_scheme_err_message_action_allow_close);
            default:
                return AppRuntime.getAppContext().getString(R.string.united_scheme_err_message_parse_fail);
        }
    }
}

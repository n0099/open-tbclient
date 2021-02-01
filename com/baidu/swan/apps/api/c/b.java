package com.baidu.swan.apps.api.c;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.unitedscheme.core.R;
import java.nio.charset.StandardCharsets;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class b implements a {
    private boolean cII;
    public JSONObject data;
    public String message;
    public int status;

    public b() {
        this.cII = false;
    }

    public b(int i) {
        this.cII = false;
        this.status = i;
    }

    public b(int i, @NonNull String str) {
        this.cII = false;
        this.status = i;
        this.message = str;
    }

    public b(int i, @NonNull JSONObject jSONObject) {
        this.cII = false;
        this.status = i;
        this.data = jSONObject;
    }

    public b(int i, @NonNull JSONObject jSONObject, boolean z) {
        this.cII = false;
        this.status = i;
        this.data = jSONObject;
        this.cII = z;
    }

    public b(int i, @NonNull String str, @NonNull JSONObject jSONObject) {
        this.cII = false;
        this.status = i;
        this.message = str;
        this.data = jSONObject;
    }

    @Override // com.baidu.swan.apps.api.c.a
    @NonNull
    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("status", String.valueOf(this.status));
            if (TextUtils.isEmpty(this.message)) {
                this.message = getErrMessage(this.status);
            }
            jSONObject.put("message", this.message);
            if (this.data != null) {
                jSONObject.put("data", this.cII ? Uri.encode(this.data.toString(), StandardCharsets.UTF_8.name()) : this.data);
            }
        } catch (JSONException e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        }
        return jSONObject.toString();
    }

    public boolean i(@NonNull String str, @Nullable Object obj) {
        if (this.data == null) {
            this.data = new JSONObject();
        }
        try {
            this.data.put(str, obj);
            return true;
        } catch (JSONException e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
            return false;
        }
    }

    public String toString() {
        return toJsonString();
    }

    @Override // com.baidu.swan.apps.api.c.a
    public boolean isSuccess() {
        return this.status == 0;
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

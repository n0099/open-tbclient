package com.baidu.swan.apps.statistic.a;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.swan.games.view.webview.GameWebViewJavascriptInterface;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class e {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    protected JSONObject dOd;
    protected JSONObject dOe;
    public String mAppId;
    public String mFrom = GameWebViewJavascriptInterface.JAVASCRIPT_INTERFACE_NAME;
    public String mPage;
    public String mSource;
    public String mType;
    public String mValue;

    public JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(this.mFrom)) {
                jSONObject.put("from", this.mFrom);
            }
            if (!TextUtils.isEmpty(this.mType)) {
                jSONObject.put("type", this.mType);
            }
            if (!TextUtils.isEmpty(this.mValue)) {
                jSONObject.put("value", this.mValue);
            }
            if (TextUtils.isEmpty(this.mSource)) {
                this.mSource = "NA";
            }
            jSONObject.put("source", this.mSource);
            if (!TextUtils.isEmpty(this.mPage)) {
                this.mPage = com.baidu.swan.apps.statistic.g.tz(this.mPage);
                jSONObject.put("page", this.mPage);
            }
            if (this.dOd == null) {
                this.dOd = new JSONObject();
            }
            if (!TextUtils.isEmpty(this.mAppId)) {
                this.dOd.put("appid", this.mAppId);
            }
            jSONObject.put("ext", this.dOd);
            return jSONObject;
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            return null;
        }
    }

    public void ck(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (this.dOd == null) {
                this.dOd = new JSONObject();
            }
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    this.dOd.put(next, jSONObject.opt(next));
                } catch (JSONException e) {
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void tL(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                ck(new JSONObject(str));
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void cl(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (this.dOd == null) {
                this.dOd = new JSONObject();
            }
            this.dOe = this.dOd.optJSONObject("extlog");
            if (this.dOe == null) {
                this.dOe = new JSONObject();
            }
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    this.dOe.put(next, jSONObject.opt(next));
                } catch (JSONException e) {
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                }
            }
            try {
                this.dOd.put("extlog", this.dOe);
            } catch (JSONException e2) {
                if (DEBUG) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public void t(@NonNull String str, Object obj) {
        if (this.dOd == null) {
            this.dOd = new JSONObject();
        }
        try {
            this.dOd.put(str, obj);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public JSONObject aPk() {
        if (this.dOd == null) {
            return null;
        }
        try {
            return new JSONObject(this.dOd.toString());
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
                return null;
            }
            return null;
        }
    }
}

package com.baidu.swan.apps.statistic.a;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.swan.games.view.webview.GameWebViewJavascriptInterface;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class e {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    protected JSONObject dMW;
    protected JSONObject dMX;
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
                this.mPage = com.baidu.swan.apps.statistic.g.sO(this.mPage);
                jSONObject.put("page", this.mPage);
            }
            if (this.dMW == null) {
                this.dMW = new JSONObject();
            }
            if (!TextUtils.isEmpty(this.mAppId)) {
                this.dMW.put("appid", this.mAppId);
            }
            jSONObject.put("ext", this.dMW);
            return jSONObject;
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            return null;
        }
    }

    public void cj(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (this.dMW == null) {
                this.dMW = new JSONObject();
            }
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    this.dMW.put(next, jSONObject.opt(next));
                } catch (JSONException e) {
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void ta(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                cj(new JSONObject(str));
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void ck(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (this.dMW == null) {
                this.dMW = new JSONObject();
            }
            this.dMX = this.dMW.optJSONObject("extlog");
            if (this.dMX == null) {
                this.dMX = new JSONObject();
            }
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    this.dMX.put(next, jSONObject.opt(next));
                } catch (JSONException e) {
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                }
            }
            try {
                this.dMW.put("extlog", this.dMX);
            } catch (JSONException e2) {
                if (DEBUG) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public void s(@NonNull String str, Object obj) {
        if (this.dMW == null) {
            this.dMW = new JSONObject();
        }
        try {
            this.dMW.put(str, obj);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public JSONObject aLN() {
        if (this.dMW == null) {
            return null;
        }
        try {
            return new JSONObject(this.dMW.toString());
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
                return null;
            }
            return null;
        }
    }
}

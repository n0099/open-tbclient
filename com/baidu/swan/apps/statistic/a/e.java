package com.baidu.swan.apps.statistic.a;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class e {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    protected JSONObject cLe;
    protected JSONObject cLf;
    public String mAppId;
    public String mFrom = "swan";
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
                this.mPage = com.baidu.swan.apps.statistic.g.oD(this.mPage);
                jSONObject.put("page", this.mPage);
            }
            if (this.cLe == null) {
                this.cLe = new JSONObject();
            }
            if (!TextUtils.isEmpty(this.mAppId)) {
                this.cLe.put("appid", this.mAppId);
            }
            jSONObject.put("ext", this.cLe);
            return jSONObject;
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            return null;
        }
    }

    public void bA(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (this.cLe == null) {
                this.cLe = new JSONObject();
            }
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    this.cLe.put(next, jSONObject.opt(next));
                } catch (JSONException e) {
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void oO(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                bA(new JSONObject(str));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void bB(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (this.cLe == null) {
                this.cLe = new JSONObject();
            }
            this.cLf = this.cLe.optJSONObject("extlog");
            if (this.cLf == null) {
                this.cLf = new JSONObject();
            }
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    this.cLf.put(next, jSONObject.opt(next));
                } catch (JSONException e) {
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                }
            }
            try {
                this.cLe.put("extlog", this.cLf);
            } catch (JSONException e2) {
                if (DEBUG) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public void v(@NonNull String str, Object obj) {
        if (this.cLe == null) {
            this.cLe = new JSONObject();
        }
        try {
            this.cLe.put(str, obj);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public JSONObject asy() {
        if (this.cLe == null) {
            return null;
        }
        try {
            return new JSONObject(this.cLe.toString());
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
                return null;
            }
            return null;
        }
    }
}

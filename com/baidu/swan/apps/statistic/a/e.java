package com.baidu.swan.apps.statistic.a;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class e {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    protected JSONObject cXA;
    protected JSONObject cXz;
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
                this.mPage = com.baidu.swan.apps.statistic.g.rm(this.mPage);
                jSONObject.put("page", this.mPage);
            }
            if (this.cXz == null) {
                this.cXz = new JSONObject();
            }
            if (!TextUtils.isEmpty(this.mAppId)) {
                this.cXz.put("appid", this.mAppId);
            }
            jSONObject.put("ext", this.cXz);
            return jSONObject;
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            return null;
        }
    }

    public void bN(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (this.cXz == null) {
                this.cXz = new JSONObject();
            }
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    this.cXz.put(next, jSONObject.opt(next));
                } catch (JSONException e) {
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void ry(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                bN(new JSONObject(str));
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void bO(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (this.cXz == null) {
                this.cXz = new JSONObject();
            }
            this.cXA = this.cXz.optJSONObject("extlog");
            if (this.cXA == null) {
                this.cXA = new JSONObject();
            }
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    this.cXA.put(next, jSONObject.opt(next));
                } catch (JSONException e) {
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                }
            }
            try {
                this.cXz.put("extlog", this.cXA);
            } catch (JSONException e2) {
                if (DEBUG) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public void u(@NonNull String str, Object obj) {
        if (this.cXz == null) {
            this.cXz = new JSONObject();
        }
        try {
            this.cXz.put(str, obj);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public JSONObject aCI() {
        if (this.cXz == null) {
            return null;
        }
        try {
            return new JSONObject(this.cXz.toString());
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
                return null;
            }
            return null;
        }
    }
}

package com.baidu.swan.apps.statistic.a;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class e {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    protected JSONObject cOA;
    protected JSONObject cOz;
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
                this.mPage = com.baidu.swan.apps.statistic.g.pm(this.mPage);
                jSONObject.put("page", this.mPage);
            }
            if (this.cOz == null) {
                this.cOz = new JSONObject();
            }
            if (!TextUtils.isEmpty(this.mAppId)) {
                this.cOz.put("appid", this.mAppId);
            }
            jSONObject.put("ext", this.cOz);
            return jSONObject;
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            return null;
        }
    }

    public void bF(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (this.cOz == null) {
                this.cOz = new JSONObject();
            }
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    this.cOz.put(next, jSONObject.opt(next));
                } catch (JSONException e) {
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void py(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                bF(new JSONObject(str));
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void bG(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (this.cOz == null) {
                this.cOz = new JSONObject();
            }
            this.cOA = this.cOz.optJSONObject("extlog");
            if (this.cOA == null) {
                this.cOA = new JSONObject();
            }
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    this.cOA.put(next, jSONObject.opt(next));
                } catch (JSONException e) {
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                }
            }
            try {
                this.cOz.put("extlog", this.cOA);
            } catch (JSONException e2) {
                if (DEBUG) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public void v(@NonNull String str, Object obj) {
        if (this.cOz == null) {
            this.cOz = new JSONObject();
        }
        try {
            this.cOz.put(str, obj);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public JSONObject auz() {
        if (this.cOz == null) {
            return null;
        }
        try {
            return new JSONObject(this.cOz.toString());
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
                return null;
            }
            return null;
        }
    }
}

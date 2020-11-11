package com.baidu.swan.apps.statistic.a;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class e {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    protected JSONObject dAh;
    protected JSONObject dAi;
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
                this.mPage = com.baidu.swan.apps.statistic.g.ta(this.mPage);
                jSONObject.put("page", this.mPage);
            }
            if (this.dAh == null) {
                this.dAh = new JSONObject();
            }
            if (!TextUtils.isEmpty(this.mAppId)) {
                this.dAh.put("appid", this.mAppId);
            }
            jSONObject.put("ext", this.dAh);
            return jSONObject;
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            return null;
        }
    }

    public void cg(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (this.dAh == null) {
                this.dAh = new JSONObject();
            }
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    this.dAh.put(next, jSONObject.opt(next));
                } catch (JSONException e) {
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void tm(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                cg(new JSONObject(str));
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void ch(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (this.dAh == null) {
                this.dAh = new JSONObject();
            }
            this.dAi = this.dAh.optJSONObject("extlog");
            if (this.dAi == null) {
                this.dAi = new JSONObject();
            }
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    this.dAi.put(next, jSONObject.opt(next));
                } catch (JSONException e) {
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                }
            }
            try {
                this.dAh.put("extlog", this.dAi);
            } catch (JSONException e2) {
                if (DEBUG) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public void u(@NonNull String str, Object obj) {
        if (this.dAh == null) {
            this.dAh = new JSONObject();
        }
        try {
            this.dAh.put(str, obj);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public JSONObject aKv() {
        if (this.dAh == null) {
            return null;
        }
        try {
            return new JSONObject(this.dAh.toString());
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
                return null;
            }
            return null;
        }
    }
}

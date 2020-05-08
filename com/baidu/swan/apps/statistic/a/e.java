package com.baidu.swan.apps.statistic.a;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class e {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    protected JSONObject cuv;
    protected JSONObject cuw;
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
                jSONObject.put("page", this.mPage);
            }
            if (this.cuv == null) {
                this.cuv = new JSONObject();
            }
            if (!TextUtils.isEmpty(this.mAppId)) {
                this.cuv.put("appid", this.mAppId);
            }
            jSONObject.put("ext", this.cuv);
            return jSONObject;
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            return null;
        }
    }

    public void bk(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (this.cuv == null) {
                this.cuv = new JSONObject();
            }
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    this.cuv.put(next, jSONObject.opt(next));
                } catch (JSONException e) {
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void nd(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                bk(new JSONObject(str));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void bl(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (this.cuv == null) {
                this.cuv = new JSONObject();
            }
            this.cuw = this.cuv.optJSONObject("extlog");
            if (this.cuw == null) {
                this.cuw = new JSONObject();
            }
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    this.cuw.put(next, jSONObject.opt(next));
                } catch (JSONException e) {
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                }
            }
            try {
                this.cuv.put("extlog", this.cuw);
            } catch (JSONException e2) {
                if (DEBUG) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public void s(@NonNull String str, Object obj) {
        if (this.cuv == null) {
            this.cuv = new JSONObject();
        }
        try {
            this.cuv.put(str, obj);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public JSONObject ani() {
        if (this.cuv == null) {
            return null;
        }
        try {
            return new JSONObject(this.cuv.toString());
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
                return null;
            }
            return null;
        }
    }
}

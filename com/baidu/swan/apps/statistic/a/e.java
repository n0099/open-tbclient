package com.baidu.swan.apps.statistic.a;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class e {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    protected JSONObject cGu;
    protected JSONObject cGv;
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
                this.mPage = com.baidu.swan.apps.statistic.g.ov(this.mPage);
                jSONObject.put("page", this.mPage);
            }
            if (this.cGu == null) {
                this.cGu = new JSONObject();
            }
            if (!TextUtils.isEmpty(this.mAppId)) {
                this.cGu.put("appid", this.mAppId);
            }
            jSONObject.put("ext", this.cGu);
            return jSONObject;
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            return null;
        }
    }

    public void bt(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (this.cGu == null) {
                this.cGu = new JSONObject();
            }
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    this.cGu.put(next, jSONObject.opt(next));
                } catch (JSONException e) {
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void oG(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                bt(new JSONObject(str));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void bu(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (this.cGu == null) {
                this.cGu = new JSONObject();
            }
            this.cGv = this.cGu.optJSONObject("extlog");
            if (this.cGv == null) {
                this.cGv = new JSONObject();
            }
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    this.cGv.put(next, jSONObject.opt(next));
                } catch (JSONException e) {
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                }
            }
            try {
                this.cGu.put("extlog", this.cGv);
            } catch (JSONException e2) {
                if (DEBUG) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public void v(@NonNull String str, Object obj) {
        if (this.cGu == null) {
            this.cGu = new JSONObject();
        }
        try {
            this.cGu.put(str, obj);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public JSONObject arr() {
        if (this.cGu == null) {
            return null;
        }
        try {
            return new JSONObject(this.cGu.toString());
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
                return null;
            }
            return null;
        }
    }
}

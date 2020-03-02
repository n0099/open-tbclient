package com.baidu.swan.apps.statistic.a;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class e {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    protected JSONObject bVl;
    protected JSONObject bVm;
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
            if (this.bVl == null) {
                this.bVl = new JSONObject();
            }
            if (!TextUtils.isEmpty(this.mAppId)) {
                this.bVl.put("appid", this.mAppId);
            }
            jSONObject.put("ext", this.bVl);
            return jSONObject;
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            return null;
        }
    }

    public void aZ(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (this.bVl == null) {
                this.bVl = new JSONObject();
            }
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    this.bVl.put(next, jSONObject.opt(next));
                } catch (JSONException e) {
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void lR(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                aZ(new JSONObject(str));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void ba(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (this.bVl == null) {
                this.bVl = new JSONObject();
            }
            this.bVm = this.bVl.optJSONObject("extlog");
            if (this.bVm == null) {
                this.bVm = new JSONObject();
            }
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    this.bVm.put(next, jSONObject.opt(next));
                } catch (JSONException e) {
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                }
            }
            try {
                this.bVl.put("extlog", this.bVm);
            } catch (JSONException e2) {
                if (DEBUG) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public void n(@NonNull String str, Object obj) {
        if (this.bVl == null) {
            this.bVl = new JSONObject();
        }
        try {
            this.bVl.put(str, obj);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public JSONObject afb() {
        if (this.bVl == null) {
            return null;
        }
        try {
            return new JSONObject(this.bVl.toString());
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
                return null;
            }
            return null;
        }
    }
}

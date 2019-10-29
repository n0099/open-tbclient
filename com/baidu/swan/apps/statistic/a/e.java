package com.baidu.swan.apps.statistic.a;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class e {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String aTe;
    protected JSONObject bpu;
    protected JSONObject bpv;
    public String mAppId;
    public String mFrom = "swan";
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
            if (!TextUtils.isEmpty(this.aTe)) {
                jSONObject.put("page", this.aTe);
            }
            if (this.bpu == null) {
                this.bpu = new JSONObject();
            }
            if (!TextUtils.isEmpty(this.mAppId)) {
                this.bpu.put("appid", this.mAppId);
            }
            jSONObject.put("ext", this.bpu);
            return jSONObject;
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            return null;
        }
    }

    public void aH(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (this.bpu == null) {
                this.bpu = new JSONObject();
            }
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    this.bpu.put(next, jSONObject.opt(next));
                } catch (JSONException e) {
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void aI(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (this.bpu == null) {
                this.bpu = new JSONObject();
            }
            this.bpv = this.bpu.optJSONObject("extlog");
            if (this.bpv == null) {
                this.bpv = new JSONObject();
            }
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    this.bpv.put(next, jSONObject.opt(next));
                } catch (JSONException e) {
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                }
            }
            try {
                this.bpu.put("extlog", this.bpv);
            } catch (JSONException e2) {
                if (DEBUG) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public void h(@NonNull String str, Object obj) {
        if (this.bpu == null) {
            this.bpu = new JSONObject();
        }
        try {
            this.bpu.put(str, obj);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }
}

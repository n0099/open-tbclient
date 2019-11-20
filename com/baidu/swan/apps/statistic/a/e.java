package com.baidu.swan.apps.statistic.a;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class e {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String aSM;
    protected JSONObject bpc;
    protected JSONObject bpd;
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
            if (!TextUtils.isEmpty(this.aSM)) {
                jSONObject.put("page", this.aSM);
            }
            if (this.bpc == null) {
                this.bpc = new JSONObject();
            }
            if (!TextUtils.isEmpty(this.mAppId)) {
                this.bpc.put("appid", this.mAppId);
            }
            jSONObject.put("ext", this.bpc);
            return jSONObject;
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            return null;
        }
    }

    public void aI(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (this.bpc == null) {
                this.bpc = new JSONObject();
            }
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    this.bpc.put(next, jSONObject.opt(next));
                } catch (JSONException e) {
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void aJ(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (this.bpc == null) {
                this.bpc = new JSONObject();
            }
            this.bpd = this.bpc.optJSONObject("extlog");
            if (this.bpd == null) {
                this.bpd = new JSONObject();
            }
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    this.bpd.put(next, jSONObject.opt(next));
                } catch (JSONException e) {
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                }
            }
            try {
                this.bpc.put("extlog", this.bpd);
            } catch (JSONException e2) {
                if (DEBUG) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public void h(@NonNull String str, Object obj) {
        if (this.bpc == null) {
            this.bpc = new JSONObject();
        }
        try {
            this.bpc.put(str, obj);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }
}

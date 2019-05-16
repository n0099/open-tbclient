package com.baidu.swan.apps.statistic.a;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.ubc.UBC;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class e {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    protected JSONObject aVi;
    protected JSONObject aVj;
    public String ayL;
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
                jSONObject.put(UBC.CONTENT_KEY_VALUE, this.mValue);
            }
            if (TextUtils.isEmpty(this.mSource)) {
                this.mSource = "NA";
            }
            jSONObject.put("source", this.mSource);
            if (!TextUtils.isEmpty(this.ayL)) {
                jSONObject.put("page", this.ayL);
            }
            if (this.aVi == null) {
                this.aVi = new JSONObject();
            }
            if (!TextUtils.isEmpty(this.mAppId)) {
                this.aVi.put("appid", this.mAppId);
            }
            jSONObject.put("ext", this.aVi);
            return jSONObject;
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            return null;
        }
    }

    public void aj(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (this.aVi == null) {
                this.aVi = new JSONObject();
            }
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    this.aVi.put(next, jSONObject.opt(next));
                } catch (JSONException e) {
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void ak(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (this.aVi == null) {
                this.aVi = new JSONObject();
            }
            this.aVj = this.aVi.optJSONObject("extlog");
            if (this.aVj == null) {
                this.aVj = new JSONObject();
            }
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    this.aVj.put(next, jSONObject.opt(next));
                } catch (JSONException e) {
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                }
            }
            try {
                this.aVi.put("extlog", this.aVj);
            } catch (JSONException e2) {
                if (DEBUG) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public void k(@NonNull String str, Object obj) {
        if (this.aVi == null) {
            this.aVi = new JSONObject();
        }
        try {
            this.aVi.put(str, obj);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }
}

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
    protected JSONObject aVS;
    protected JSONObject aVT;
    public String azs;
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
            if (!TextUtils.isEmpty(this.azs)) {
                jSONObject.put("page", this.azs);
            }
            if (this.aVS == null) {
                this.aVS = new JSONObject();
            }
            if (!TextUtils.isEmpty(this.mAppId)) {
                this.aVS.put("appid", this.mAppId);
            }
            jSONObject.put("ext", this.aVS);
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
            if (this.aVS == null) {
                this.aVS = new JSONObject();
            }
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    this.aVS.put(next, jSONObject.opt(next));
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
            if (this.aVS == null) {
                this.aVS = new JSONObject();
            }
            this.aVT = this.aVS.optJSONObject("extlog");
            if (this.aVT == null) {
                this.aVT = new JSONObject();
            }
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    this.aVT.put(next, jSONObject.opt(next));
                } catch (JSONException e) {
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                }
            }
            try {
                this.aVS.put("extlog", this.aVT);
            } catch (JSONException e2) {
                if (DEBUG) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public void k(@NonNull String str, Object obj) {
        if (this.aVS == null) {
            this.aVS = new JSONObject();
        }
        try {
            this.aVS.put(str, obj);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }
}

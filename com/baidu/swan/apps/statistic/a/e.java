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
    protected JSONObject aWq;
    protected JSONObject aWr;
    public String azQ;
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
            if (!TextUtils.isEmpty(this.azQ)) {
                jSONObject.put("page", this.azQ);
            }
            if (this.aWq == null) {
                this.aWq = new JSONObject();
            }
            if (!TextUtils.isEmpty(this.mAppId)) {
                this.aWq.put("appid", this.mAppId);
            }
            jSONObject.put("ext", this.aWq);
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
            if (this.aWq == null) {
                this.aWq = new JSONObject();
            }
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    this.aWq.put(next, jSONObject.opt(next));
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
            if (this.aWq == null) {
                this.aWq = new JSONObject();
            }
            this.aWr = this.aWq.optJSONObject("extlog");
            if (this.aWr == null) {
                this.aWr = new JSONObject();
            }
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    this.aWr.put(next, jSONObject.opt(next));
                } catch (JSONException e) {
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                }
            }
            try {
                this.aWq.put("extlog", this.aWr);
            } catch (JSONException e2) {
                if (DEBUG) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public void k(@NonNull String str, Object obj) {
        if (this.aWq == null) {
            this.aWq = new JSONObject();
        }
        try {
            this.aWq.put(str, obj);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }
}

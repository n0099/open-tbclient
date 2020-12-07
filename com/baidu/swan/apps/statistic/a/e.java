package com.baidu.swan.apps.statistic.a;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes25.dex */
public class e {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    protected JSONObject dFA;
    protected JSONObject dFz;
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
                this.mPage = com.baidu.swan.apps.statistic.g.tC(this.mPage);
                jSONObject.put("page", this.mPage);
            }
            if (this.dFz == null) {
                this.dFz = new JSONObject();
            }
            if (!TextUtils.isEmpty(this.mAppId)) {
                this.dFz.put("appid", this.mAppId);
            }
            jSONObject.put("ext", this.dFz);
            return jSONObject;
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            return null;
        }
    }

    public void cc(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (this.dFz == null) {
                this.dFz = new JSONObject();
            }
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    this.dFz.put(next, jSONObject.opt(next));
                } catch (JSONException e) {
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void tO(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                cc(new JSONObject(str));
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void cd(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (this.dFz == null) {
                this.dFz = new JSONObject();
            }
            this.dFA = this.dFz.optJSONObject("extlog");
            if (this.dFA == null) {
                this.dFA = new JSONObject();
            }
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    this.dFA.put(next, jSONObject.opt(next));
                } catch (JSONException e) {
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                }
            }
            try {
                this.dFz.put("extlog", this.dFA);
            } catch (JSONException e2) {
                if (DEBUG) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public void t(@NonNull String str, Object obj) {
        if (this.dFz == null) {
            this.dFz = new JSONObject();
        }
        try {
            this.dFz.put(str, obj);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public JSONObject aMU() {
        if (this.dFz == null) {
            return null;
        }
        try {
            return new JSONObject(this.dFz.toString());
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
                return null;
            }
            return null;
        }
    }
}

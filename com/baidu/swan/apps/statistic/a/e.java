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
    protected JSONObject aSu;
    public String axM;
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
            if (!TextUtils.isEmpty(this.axM)) {
                jSONObject.put("page", this.axM);
            }
            if (this.aSu == null) {
                this.aSu = new JSONObject();
            }
            if (!TextUtils.isEmpty(this.mAppId)) {
                this.aSu.put("appid", this.mAppId);
            }
            jSONObject.put("ext", this.aSu);
            return jSONObject;
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            return null;
        }
    }

    public void ai(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (this.aSu == null) {
                this.aSu = new JSONObject();
            }
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    this.aSu.put(next, jSONObject.opt(next));
                } catch (JSONException e) {
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void aB(@NonNull String str, String str2) {
        if (this.aSu == null) {
            this.aSu = new JSONObject();
        }
        try {
            this.aSu.put(str, str2);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }
}

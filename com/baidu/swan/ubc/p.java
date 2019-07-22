package com.baidu.swan.ubc;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class p {
    private String ayj;
    private int bwL;
    private JSONObject bwM;
    private List<f> bwN = new ArrayList();
    private int mThreshold;

    public p(String str, JSONObject jSONObject) {
        this.ayj = str;
        this.bwM = jSONObject;
    }

    public String getSign() {
        return this.ayj;
    }

    public int Yf() {
        return this.mThreshold;
    }

    public int Yg() {
        return this.bwL;
    }

    public List<f> Yh() {
        return this.bwN;
    }

    public boolean Yi() {
        try {
            JSONObject jSONObject = this.bwM;
            this.mThreshold = jSONObject.getInt("threshold");
            this.bwL = jSONObject.getInt("timeup");
            JSONArray jSONArray = new JSONArray(jSONObject.getString("item"));
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                String string = jSONObject2.getString("id");
                String string2 = jSONObject2.getString("isAbtest");
                int i2 = jSONObject2.getInt("timeout");
                String string3 = jSONObject2.getString("type");
                if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty("1") && !TextUtils.isEmpty("1") && !TextUtils.isEmpty(string3)) {
                    f fVar = new f(string, "1", "1", i2, string3, string2);
                    if (jSONObject2.has("rate")) {
                        fVar.fY(0);
                    }
                    if (jSONObject2.has("c")) {
                        fVar.setCategory(jSONObject2.getString("c"));
                    }
                    if (jSONObject2.has("limitUnit")) {
                        fVar.fZ(jSONObject2.getInt("limitUnit"));
                    }
                    if (jSONObject2.has("limitCnt")) {
                        fVar.ga(jSONObject2.getInt("limitCnt"));
                    }
                    if (jSONObject2.has("idtype")) {
                        fVar.kU(jSONObject2.getString("idtype"));
                    }
                    this.bwN.add(fVar);
                }
            }
            return true;
        } catch (JSONException e) {
            return false;
        }
    }
}

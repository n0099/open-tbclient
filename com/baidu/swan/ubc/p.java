package com.baidu.swan.ubc;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class p {
    private String aRF;
    private int bOZ;
    private JSONObject bPa;
    private List<f> bPb = new ArrayList();
    private int mThreshold;

    public p(String str, JSONObject jSONObject) {
        this.aRF = str;
        this.bPa = jSONObject;
    }

    public String getSign() {
        return this.aRF;
    }

    public int acX() {
        return this.mThreshold;
    }

    public int acY() {
        return this.bOZ;
    }

    public List<f> acZ() {
        return this.bPb;
    }

    public boolean ada() {
        try {
            JSONObject jSONObject = this.bPa;
            this.mThreshold = jSONObject.getInt("threshold");
            this.bOZ = jSONObject.getInt("timeup");
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
                        fVar.gT(0);
                    }
                    if (jSONObject2.has("c")) {
                        fVar.setCategory(jSONObject2.getString("c"));
                    }
                    if (jSONObject2.has("limitUnit")) {
                        fVar.gU(jSONObject2.getInt("limitUnit"));
                    }
                    if (jSONObject2.has("limitCnt")) {
                        fVar.gV(jSONObject2.getInt("limitCnt"));
                    }
                    if (jSONObject2.has("idtype")) {
                        fVar.ly(jSONObject2.getString("idtype"));
                    }
                    this.bPb.add(fVar);
                }
            }
            return true;
        } catch (JSONException e) {
            return false;
        }
    }
}

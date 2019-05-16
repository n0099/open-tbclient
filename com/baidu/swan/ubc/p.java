package com.baidu.swan.ubc;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class p {
    private String axC;
    private int bvV;
    private JSONObject bvW;
    private List<f> bvX = new ArrayList();
    private int mThreshold;

    public p(String str, JSONObject jSONObject) {
        this.axC = str;
        this.bvW = jSONObject;
    }

    public String getSign() {
        return this.axC;
    }

    public int getThreshold() {
        return this.mThreshold;
    }

    public int Xk() {
        return this.bvV;
    }

    public List<f> Xl() {
        return this.bvX;
    }

    public boolean Xm() {
        try {
            JSONObject jSONObject = this.bvW;
            this.mThreshold = jSONObject.getInt("threshold");
            this.bvV = jSONObject.getInt("timeup");
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
                        fVar.fU(0);
                    }
                    if (jSONObject2.has("c")) {
                        fVar.setCategory(jSONObject2.getString("c"));
                    }
                    if (jSONObject2.has("limitUnit")) {
                        fVar.fV(jSONObject2.getInt("limitUnit"));
                    }
                    if (jSONObject2.has("limitCnt")) {
                        fVar.fW(jSONObject2.getInt("limitCnt"));
                    }
                    if (jSONObject2.has("idtype")) {
                        fVar.kN(jSONObject2.getString("idtype"));
                    }
                    this.bvX.add(fVar);
                }
            }
            return true;
        } catch (JSONException e) {
            return false;
        }
    }
}

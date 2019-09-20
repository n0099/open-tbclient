package com.baidu.swan.ubc;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class p {
    private String ayH;
    private int bxj;
    private JSONObject bxk;
    private List<f> bxl = new ArrayList();
    private int mThreshold;

    public p(String str, JSONObject jSONObject) {
        this.ayH = str;
        this.bxk = jSONObject;
    }

    public String getSign() {
        return this.ayH;
    }

    public int Yj() {
        return this.mThreshold;
    }

    public int Yk() {
        return this.bxj;
    }

    public List<f> Yl() {
        return this.bxl;
    }

    public boolean Ym() {
        try {
            JSONObject jSONObject = this.bxk;
            this.mThreshold = jSONObject.getInt("threshold");
            this.bxj = jSONObject.getInt("timeup");
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
                        fVar.fZ(0);
                    }
                    if (jSONObject2.has("c")) {
                        fVar.setCategory(jSONObject2.getString("c"));
                    }
                    if (jSONObject2.has("limitUnit")) {
                        fVar.ga(jSONObject2.getInt("limitUnit"));
                    }
                    if (jSONObject2.has("limitCnt")) {
                        fVar.gb(jSONObject2.getInt("limitCnt"));
                    }
                    if (jSONObject2.has("idtype")) {
                        fVar.kW(jSONObject2.getString("idtype"));
                    }
                    this.bxl.add(fVar);
                }
            }
            return true;
        } catch (JSONException e) {
            return false;
        }
    }
}

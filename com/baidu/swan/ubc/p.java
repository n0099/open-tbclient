package com.baidu.swan.ubc;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class p {
    private String bxu;
    private int cFe;
    private JSONObject cFf;
    private List<f> cFg = new ArrayList();
    private int mThreshold;

    public p(String str, JSONObject jSONObject) {
        this.bxu = str;
        this.cFf = jSONObject;
    }

    public String getSign() {
        return this.bxu;
    }

    public int avL() {
        return this.mThreshold;
    }

    public int avM() {
        return this.cFe;
    }

    public List<f> avN() {
        return this.cFg;
    }

    public boolean avO() {
        try {
            JSONObject jSONObject = this.cFf;
            this.mThreshold = jSONObject.getInt("threshold");
            this.cFe = jSONObject.getInt("timeup");
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
                        fVar.iU(jSONObject2.getInt("rate"));
                    }
                    if (jSONObject2.has("c")) {
                        fVar.setCategory(jSONObject2.getString("c"));
                    }
                    if (jSONObject2.has("limitUnit")) {
                        fVar.iV(jSONObject2.getInt("limitUnit"));
                    }
                    if (jSONObject2.has("limitCnt")) {
                        fVar.iW(jSONObject2.getInt("limitCnt"));
                    }
                    if (jSONObject2.has("idtype")) {
                        fVar.qW(jSONObject2.getString("idtype"));
                    }
                    this.cFg.add(fVar);
                }
            }
            return true;
        } catch (JSONException e) {
            return false;
        }
    }
}

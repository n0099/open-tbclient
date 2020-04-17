package com.baidu.swan.ubc;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class p {
    private String bVL;
    private int dep;
    private JSONObject deq;
    private List<f> der = new ArrayList();
    private int mThreshold;

    public p(String str, JSONObject jSONObject) {
        this.bVL = str;
        this.deq = jSONObject;
    }

    public String getSign() {
        return this.bVL;
    }

    public int aDZ() {
        return this.mThreshold;
    }

    public int aEa() {
        return this.dep;
    }

    public List<f> aEb() {
        return this.der;
    }

    public boolean aEc() {
        try {
            JSONObject jSONObject = this.deq;
            this.mThreshold = jSONObject.getInt("threshold");
            this.dep = jSONObject.getInt("timeup");
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
                        fVar.jb(jSONObject2.getInt("rate"));
                    }
                    if (jSONObject2.has("c")) {
                        fVar.setCategory(jSONObject2.getString("c"));
                    }
                    if (jSONObject2.has("limitUnit")) {
                        fVar.jc(jSONObject2.getInt("limitUnit"));
                    }
                    if (jSONObject2.has("limitCnt")) {
                        fVar.jd(jSONObject2.getInt("limitCnt"));
                    }
                    if (jSONObject2.has("idtype")) {
                        fVar.si(jSONObject2.getString("idtype"));
                    }
                    this.der.add(fVar);
                }
            }
            return true;
        } catch (JSONException e) {
            return false;
        }
    }
}

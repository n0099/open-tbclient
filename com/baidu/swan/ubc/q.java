package com.baidu.swan.ubc;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class q {
    private static final ConcurrentHashMap<String, String> dAQ = new ConcurrentHashMap<>();
    private String cne;
    private int dAR;
    private JSONObject dAS;
    private List<g> dAT = new ArrayList();
    private int mThreshold;

    static {
        dAQ.put("1415", "66");
    }

    public q(String str, JSONObject jSONObject) {
        this.cne = str;
        this.dAS = jSONObject;
    }

    public String getSign() {
        return this.cne;
    }

    public int aNF() {
        return this.mThreshold;
    }

    public int aNG() {
        return this.dAR;
    }

    public List<g> aNH() {
        return this.dAT;
    }

    public boolean aNI() {
        String str;
        try {
            JSONObject jSONObject = this.dAS;
            this.mThreshold = jSONObject.getInt("threshold");
            this.dAR = jSONObject.getInt("timeup");
            JSONArray jSONArray = new JSONArray(jSONObject.getString("item"));
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                String string = jSONObject2.getString("ubcid");
                if (TextUtils.isEmpty(string) || !dAQ.containsKey(string)) {
                    str = string;
                } else {
                    str = jSONObject2.optString("bizid");
                    dAQ.get(string);
                }
                String string2 = jSONObject2.getString("switch");
                String string3 = jSONObject2.getString("isreal");
                String string4 = jSONObject2.getString("isAbtest");
                int intValue = Integer.valueOf(jSONObject2.getString("timeout")).intValue();
                String string5 = jSONObject2.getString("type");
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(string2) && !TextUtils.isEmpty(string3) && !TextUtils.isEmpty(string5)) {
                    g gVar = new g(str, string2, string3, intValue, string5, string4);
                    if (jSONObject2.has("rate")) {
                        gVar.ka(Integer.valueOf(jSONObject2.getString("rate")).intValue());
                    }
                    if (jSONObject2.has("bizid")) {
                        gVar.uX(jSONObject2.getString("bizid"));
                    }
                    if (jSONObject2.has("c")) {
                        gVar.setCategory(jSONObject2.getString("c"));
                    }
                    if (jSONObject2.has("limitUnit")) {
                        gVar.kb(Integer.valueOf(jSONObject2.getString("limitUnit")).intValue());
                    }
                    if (jSONObject2.has("limitCnt")) {
                        gVar.kc(Integer.valueOf(jSONObject2.getString("limitCnt")).intValue());
                    }
                    if (jSONObject2.has("idtype")) {
                        gVar.uY(jSONObject2.getString("idtype"));
                    }
                    if (jSONObject2.has("appblacklist")) {
                        gVar.uZ(jSONObject2.getString("appblacklist"));
                    }
                    this.dAT.add(gVar);
                }
            }
            return true;
        } catch (NumberFormatException | JSONException e) {
            return false;
        }
    }
}

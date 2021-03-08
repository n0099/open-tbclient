package com.baidu.swan.ubc;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes14.dex */
public class q {
    private static final ConcurrentHashMap<String, String> eAy = new ConcurrentHashMap<>();
    private JSONObject eAA;
    private List<g> eAB = new ArrayList();
    private int eAz;
    private String mSign;
    private int mThreshold;

    static {
        eAy.put("1415", "66");
    }

    public q(String str, JSONObject jSONObject) {
        this.mSign = str;
        this.eAA = jSONObject;
    }

    public String getSign() {
        return this.mSign;
    }

    public int bfj() {
        return this.mThreshold;
    }

    public int bfk() {
        return this.eAz;
    }

    public List<g> bfl() {
        return this.eAB;
    }

    public boolean bfm() {
        String str;
        try {
            JSONObject jSONObject = this.eAA;
            this.mThreshold = jSONObject.getInt("threshold");
            this.eAz = jSONObject.getInt("timeup");
            JSONArray jSONArray = new JSONArray(jSONObject.getString("item"));
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                String string = jSONObject2.getString("ubcid");
                if (TextUtils.isEmpty(string) || !eAy.containsKey(string)) {
                    str = string;
                } else {
                    str = jSONObject2.optString("bizid");
                    eAy.get(string);
                }
                String string2 = jSONObject2.getString("switch");
                String string3 = jSONObject2.getString("isreal");
                String string4 = jSONObject2.getString("isAbtest");
                int intValue = Integer.valueOf(jSONObject2.getString("timeout")).intValue();
                String string5 = jSONObject2.getString("type");
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(string2) && !TextUtils.isEmpty(string3) && !TextUtils.isEmpty(string5)) {
                    g gVar = new g(str, string2, string3, intValue, string5, string4);
                    if (jSONObject2.has("rate")) {
                        gVar.mk(Integer.valueOf(jSONObject2.getString("rate")).intValue());
                    }
                    if (jSONObject2.has("bizid")) {
                        gVar.yL(jSONObject2.getString("bizid"));
                    }
                    if (jSONObject2.has("c")) {
                        gVar.setCategory(jSONObject2.getString("c"));
                    }
                    if (jSONObject2.has("limitUnit")) {
                        gVar.ml(Integer.valueOf(jSONObject2.getString("limitUnit")).intValue());
                    }
                    if (jSONObject2.has("limitCnt")) {
                        gVar.mm(Integer.valueOf(jSONObject2.getString("limitCnt")).intValue());
                    }
                    if (jSONObject2.has("idtype")) {
                        gVar.yM(jSONObject2.getString("idtype"));
                    }
                    if (jSONObject2.has("appblacklist")) {
                        gVar.yN(jSONObject2.getString("appblacklist"));
                    }
                    this.eAB.add(gVar);
                }
            }
            return true;
        } catch (NumberFormatException | JSONException e) {
            return false;
        }
    }
}

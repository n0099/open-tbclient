package com.baidu.swan.ubc;

import android.text.TextUtils;
import com.baidu.platform.comapi.map.MapController;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class q {
    private static final ConcurrentHashMap<String, String> emx = new ConcurrentHashMap<>();
    private List<g> emA = new ArrayList();
    private int emy;
    private JSONObject emz;
    private String mSign;
    private int mThreshold;

    static {
        emx.put("1415", "66");
    }

    public q(String str, JSONObject jSONObject) {
        this.mSign = str;
        this.emz = jSONObject;
    }

    public String getSign() {
        return this.mSign;
    }

    public int bdS() {
        return this.mThreshold;
    }

    public int bdT() {
        return this.emy;
    }

    public List<g> bdU() {
        return this.emA;
    }

    public boolean bdV() {
        String str;
        try {
            JSONObject jSONObject = this.emz;
            this.mThreshold = jSONObject.getInt("threshold");
            this.emy = jSONObject.getInt("timeup");
            JSONArray jSONArray = new JSONArray(jSONObject.getString(MapController.ITEM_LAYER_TAG));
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                String string = jSONObject2.getString("ubcid");
                if (TextUtils.isEmpty(string) || !emx.containsKey(string)) {
                    str = string;
                } else {
                    str = jSONObject2.optString("bizid");
                    emx.get(string);
                }
                String string2 = jSONObject2.getString("switch");
                String string3 = jSONObject2.getString("isreal");
                String string4 = jSONObject2.getString("isAbtest");
                int intValue = Integer.valueOf(jSONObject2.getString("timeout")).intValue();
                String string5 = jSONObject2.getString("type");
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(string2) && !TextUtils.isEmpty(string3) && !TextUtils.isEmpty(string5)) {
                    g gVar = new g(str, string2, string3, intValue, string5, string4);
                    if (jSONObject2.has("rate")) {
                        gVar.nj(Integer.valueOf(jSONObject2.getString("rate")).intValue());
                    }
                    if (jSONObject2.has("bizid")) {
                        gVar.yV(jSONObject2.getString("bizid"));
                    }
                    if (jSONObject2.has("c")) {
                        gVar.setCategory(jSONObject2.getString("c"));
                    }
                    if (jSONObject2.has("limitUnit")) {
                        gVar.nk(Integer.valueOf(jSONObject2.getString("limitUnit")).intValue());
                    }
                    if (jSONObject2.has("limitCnt")) {
                        gVar.nl(Integer.valueOf(jSONObject2.getString("limitCnt")).intValue());
                    }
                    if (jSONObject2.has("idtype")) {
                        gVar.yW(jSONObject2.getString("idtype"));
                    }
                    if (jSONObject2.has("appblacklist")) {
                        gVar.yX(jSONObject2.getString("appblacklist"));
                    }
                    this.emA.add(gVar);
                }
            }
            return true;
        } catch (NumberFormatException | JSONException e) {
            return false;
        }
    }
}

package com.baidu.swan.ubc;

import android.text.TextUtils;
import com.baidu.platform.comapi.map.MapController;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class q {
    private static final ConcurrentHashMap<String, String> dKe = new ConcurrentHashMap<>();
    private String cuL;
    private int dKf;
    private JSONObject dKg;
    private List<g> dKh = new ArrayList();
    private int mThreshold;

    static {
        dKe.put("1415", "66");
    }

    public q(String str, JSONObject jSONObject) {
        this.cuL = str;
        this.dKg = jSONObject;
    }

    public String getSign() {
        return this.cuL;
    }

    public int aWf() {
        return this.mThreshold;
    }

    public int aWg() {
        return this.dKf;
    }

    public List<g> aWh() {
        return this.dKh;
    }

    public boolean aWi() {
        String str;
        try {
            JSONObject jSONObject = this.dKg;
            this.mThreshold = jSONObject.getInt("threshold");
            this.dKf = jSONObject.getInt("timeup");
            JSONArray jSONArray = new JSONArray(jSONObject.getString(MapController.ITEM_LAYER_TAG));
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                String string = jSONObject2.getString("ubcid");
                if (TextUtils.isEmpty(string) || !dKe.containsKey(string)) {
                    str = string;
                } else {
                    str = jSONObject2.optString("bizid");
                    dKe.get(string);
                }
                String string2 = jSONObject2.getString("switch");
                String string3 = jSONObject2.getString("isreal");
                String string4 = jSONObject2.getString("isAbtest");
                int intValue = Integer.valueOf(jSONObject2.getString("timeout")).intValue();
                String string5 = jSONObject2.getString("type");
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(string2) && !TextUtils.isEmpty(string3) && !TextUtils.isEmpty(string5)) {
                    g gVar = new g(str, string2, string3, intValue, string5, string4);
                    if (jSONObject2.has("rate")) {
                        gVar.mg(Integer.valueOf(jSONObject2.getString("rate")).intValue());
                    }
                    if (jSONObject2.has("bizid")) {
                        gVar.xj(jSONObject2.getString("bizid"));
                    }
                    if (jSONObject2.has("c")) {
                        gVar.setCategory(jSONObject2.getString("c"));
                    }
                    if (jSONObject2.has("limitUnit")) {
                        gVar.mh(Integer.valueOf(jSONObject2.getString("limitUnit")).intValue());
                    }
                    if (jSONObject2.has("limitCnt")) {
                        gVar.mi(Integer.valueOf(jSONObject2.getString("limitCnt")).intValue());
                    }
                    if (jSONObject2.has("idtype")) {
                        gVar.xk(jSONObject2.getString("idtype"));
                    }
                    if (jSONObject2.has("appblacklist")) {
                        gVar.xl(jSONObject2.getString("appblacklist"));
                    }
                    this.dKh.add(gVar);
                }
            }
            return true;
        } catch (NumberFormatException | JSONException e) {
            return false;
        }
    }
}

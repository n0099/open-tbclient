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
    private static final ConcurrentHashMap<String, String> egG = new ConcurrentHashMap<>();
    private int egH;
    private JSONObject egI;
    private List<g> egJ = new ArrayList();
    private String mSign;
    private int mThreshold;

    static {
        egG.put("1415", "66");
    }

    public q(String str, JSONObject jSONObject) {
        this.mSign = str;
        this.egI = jSONObject;
    }

    public String getSign() {
        return this.mSign;
    }

    public int bbs() {
        return this.mThreshold;
    }

    public int bbt() {
        return this.egH;
    }

    public List<g> bbu() {
        return this.egJ;
    }

    public boolean bbv() {
        String str;
        try {
            JSONObject jSONObject = this.egI;
            this.mThreshold = jSONObject.getInt("threshold");
            this.egH = jSONObject.getInt("timeup");
            JSONArray jSONArray = new JSONArray(jSONObject.getString(MapController.ITEM_LAYER_TAG));
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                String string = jSONObject2.getString("ubcid");
                if (TextUtils.isEmpty(string) || !egG.containsKey(string)) {
                    str = string;
                } else {
                    str = jSONObject2.optString("bizid");
                    egG.get(string);
                }
                String string2 = jSONObject2.getString("switch");
                String string3 = jSONObject2.getString("isreal");
                String string4 = jSONObject2.getString("isAbtest");
                int intValue = Integer.valueOf(jSONObject2.getString("timeout")).intValue();
                String string5 = jSONObject2.getString("type");
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(string2) && !TextUtils.isEmpty(string3) && !TextUtils.isEmpty(string5)) {
                    g gVar = new g(str, string2, string3, intValue, string5, string4);
                    if (jSONObject2.has("rate")) {
                        gVar.mZ(Integer.valueOf(jSONObject2.getString("rate")).intValue());
                    }
                    if (jSONObject2.has("bizid")) {
                        gVar.yH(jSONObject2.getString("bizid"));
                    }
                    if (jSONObject2.has("c")) {
                        gVar.setCategory(jSONObject2.getString("c"));
                    }
                    if (jSONObject2.has("limitUnit")) {
                        gVar.na(Integer.valueOf(jSONObject2.getString("limitUnit")).intValue());
                    }
                    if (jSONObject2.has("limitCnt")) {
                        gVar.nb(Integer.valueOf(jSONObject2.getString("limitCnt")).intValue());
                    }
                    if (jSONObject2.has("idtype")) {
                        gVar.yI(jSONObject2.getString("idtype"));
                    }
                    if (jSONObject2.has("appblacklist")) {
                        gVar.yJ(jSONObject2.getString("appblacklist"));
                    }
                    this.egJ.add(gVar);
                }
            }
            return true;
        } catch (NumberFormatException | JSONException e) {
            return false;
        }
    }
}

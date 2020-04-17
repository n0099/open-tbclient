package com.baidu.live.ar;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.ar.AlaFilterAndBeautyData;
import com.baidu.live.tbadk.core.data.BaseData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c extends BaseData {
    public static c aob = new c();
    public static c aoc = new c();
    public d anV;
    public String anW;
    public AlaFilterAndBeautyData anX;
    private HashMap<String, Integer> aoa;
    public float mFilterLevel;
    public String anU = "";
    private HashMap<String, Integer> anY = new HashMap<>();
    private ArrayList<b> anZ = new ArrayList<>();

    public c() {
        this.anW = "";
        this.anW = AlaFilterAndBeautyData.BeautyAdjustKey.whiten.getJsonKey();
        tQ();
    }

    public String toJsonString() {
        AlaFilterAndBeautyData.BeautyAdjustKey[] values;
        JSONObject jSONObject = new JSONObject();
        try {
            for (AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey : AlaFilterAndBeautyData.BeautyAdjustKey.values()) {
                jSONObject.put(beautyAdjustKey.getJsonKey(), dF(beautyAdjustKey.getJsonKey()));
            }
            jSONObject.put("filter_name", this.anU);
            jSONObject.put("filter_level", this.mFilterLevel);
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry<String, Integer> entry : this.anY.entrySet()) {
                if (!StringUtils.isNullObject(entry.getKey())) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("array_filter_file", entry.getKey());
                    jSONObject2.put("array_filter_level", entry.getValue());
                    jSONArray.put(jSONObject2);
                }
            }
            jSONObject.put("array_filter", jSONArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Log.d("ArUpdate", "toJsonString:" + jSONObject.toString());
        return jSONObject.toString();
    }

    public c dD(String str) {
        AlaFilterAndBeautyData.BeautyAdjustKey[] values;
        if (!TextUtils.isEmpty(str)) {
            Log.d("ArUpdate", "parseJson jsonStr:" + str);
            try {
                JSONObject jSONObject = new JSONObject(str);
                for (AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey : AlaFilterAndBeautyData.BeautyAdjustKey.values()) {
                    u(beautyAdjustKey.getJsonKey(), jSONObject.optInt(beautyAdjustKey.getJsonKey()));
                }
                this.anU = jSONObject.optString("filter_name");
                this.mFilterLevel = jSONObject.optInt("filter_level");
                JSONArray optJSONArray = jSONObject.optJSONArray("array_filter");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = (JSONObject) optJSONArray.opt(i);
                        if (jSONObject2 != null && (jSONObject2.opt("array_filter_level") instanceof Integer)) {
                            this.anY.put(jSONObject2.optString("array_filter_file"), Integer.valueOf(jSONObject2.optInt("array_filter_level")));
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return this;
    }

    public void t(String str, int i) {
        if (!TextUtils.isEmpty(str)) {
            Log.d("ArUpdate", "保存在缓存  putFilterValue--filterName:" + str + ", level:" + i);
            this.anY.put(str, Integer.valueOf(i));
        }
    }

    public int dE(String str) {
        Log.d("ArUpdate", "获取子项值 getFilterValue jsonKey:" + str);
        if (TextUtils.isEmpty(str) || this.anY == null || this.anY.isEmpty()) {
            return 100;
        }
        Log.d("ArUpdate", "获取子项值 getFilterValue value:" + (this.anY.get(str) == null ? 100 : this.anY.get(str).intValue()));
        if (this.anY.get(str) == null) {
            return 100;
        }
        return this.anY.get(str).intValue();
    }

    public int a(d dVar, List<d> list) {
        if (dVar == null) {
            return 100;
        }
        Log.d("ArUpdate", "getFilterThreshold filterFileName:" + dVar.tR());
        for (d dVar2 : list) {
            if (dVar.tR().equals(dVar2.tR())) {
                Log.d("ArUpdate", "getFilterThreshold 阈值:" + dVar2.tT());
                return dVar2.tT();
            }
        }
        return 100;
    }

    public void a(AlaFilterAndBeautyData alaFilterAndBeautyData) {
        this.anX = alaFilterAndBeautyData;
    }

    private void tQ() {
        this.aoa = new HashMap<>();
        for (AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey : AlaFilterAndBeautyData.BeautyAdjustKey.values()) {
            this.aoa.put(beautyAdjustKey.getJsonKey(), 0);
        }
    }

    public void u(String str, int i) {
        if (!TextUtils.isEmpty(str)) {
            this.aoa.put(str, Integer.valueOf(i));
        }
    }

    public int dF(String str) {
        if (TextUtils.isEmpty(str) || this.aoa == null || this.aoa.isEmpty() || this.aoa.get(str) == null) {
            return 0;
        }
        return this.aoa.get(str).intValue();
    }

    public static boolean a(HashMap<AlaFilterAndBeautyData.BeautyAdjustKey, AlaFilterAndBeautyData.b> hashMap, AlaFilterAndBeautyData alaFilterAndBeautyData) {
        AlaFilterAndBeautyData.BeautyAdjustKey[] values;
        if (alaFilterAndBeautyData == null) {
            return false;
        }
        aoc.a(alaFilterAndBeautyData);
        aoc.dD(com.baidu.live.c.tH().getString("ala_beauty_config_ar", ""));
        boolean z = com.baidu.live.c.tH().getBoolean("ala_beauty_changed_by_user", false);
        for (AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey : AlaFilterAndBeautyData.BeautyAdjustKey.values()) {
            int a = AlaFilterAndBeautyData.a(hashMap, beautyAdjustKey);
            if (!z) {
                aoc.u(beautyAdjustKey.getJsonKey(), a);
            }
            aob.u(beautyAdjustKey.getJsonKey(), a);
        }
        for (d dVar : alaFilterAndBeautyData.anJ) {
            b bVar = new b();
            bVar.a(dVar);
            aoc.a(bVar);
        }
        if (!z) {
            com.baidu.live.c.tH().putString("ala_beauty_config_ar", aoc.toJsonString());
        }
        return true;
    }

    public void a(b bVar) {
        this.anZ.add(bVar);
    }

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
    }
}

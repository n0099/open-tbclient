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
    public static c aoh = new c();
    public static c aoi = new c();
    public d aob;
    public String aoc;
    public AlaFilterAndBeautyData aod;
    private HashMap<String, Integer> aog;
    public float mFilterLevel;
    public String aoa = "";
    private HashMap<String, Integer> aoe = new HashMap<>();
    private ArrayList<b> aof = new ArrayList<>();

    public c() {
        this.aoc = "";
        this.aoc = AlaFilterAndBeautyData.BeautyAdjustKey.whiten.getJsonKey();
        tP();
    }

    public String toJsonString() {
        AlaFilterAndBeautyData.BeautyAdjustKey[] values;
        JSONObject jSONObject = new JSONObject();
        try {
            for (AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey : AlaFilterAndBeautyData.BeautyAdjustKey.values()) {
                jSONObject.put(beautyAdjustKey.getJsonKey(), dF(beautyAdjustKey.getJsonKey()));
            }
            jSONObject.put("filter_name", this.aoa);
            jSONObject.put("filter_level", this.mFilterLevel);
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry<String, Integer> entry : this.aoe.entrySet()) {
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
                this.aoa = jSONObject.optString("filter_name");
                this.mFilterLevel = jSONObject.optInt("filter_level");
                JSONArray optJSONArray = jSONObject.optJSONArray("array_filter");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = (JSONObject) optJSONArray.opt(i);
                        if (jSONObject2 != null && (jSONObject2.opt("array_filter_level") instanceof Integer)) {
                            this.aoe.put(jSONObject2.optString("array_filter_file"), Integer.valueOf(jSONObject2.optInt("array_filter_level")));
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
            this.aoe.put(str, Integer.valueOf(i));
        }
    }

    public int dE(String str) {
        Log.d("ArUpdate", "获取子项值 getFilterValue jsonKey:" + str);
        if (TextUtils.isEmpty(str) || this.aoe == null || this.aoe.isEmpty()) {
            return 100;
        }
        Log.d("ArUpdate", "获取子项值 getFilterValue value:" + (this.aoe.get(str) == null ? 100 : this.aoe.get(str).intValue()));
        if (this.aoe.get(str) == null) {
            return 100;
        }
        return this.aoe.get(str).intValue();
    }

    public int a(d dVar, List<d> list) {
        if (dVar == null) {
            return 100;
        }
        Log.d("ArUpdate", "getFilterThreshold filterFileName:" + dVar.tQ());
        for (d dVar2 : list) {
            if (dVar.tQ().equals(dVar2.tQ())) {
                Log.d("ArUpdate", "getFilterThreshold 阈值:" + dVar2.tS());
                return dVar2.tS();
            }
        }
        return 100;
    }

    public void a(AlaFilterAndBeautyData alaFilterAndBeautyData) {
        this.aod = alaFilterAndBeautyData;
    }

    private void tP() {
        this.aog = new HashMap<>();
        for (AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey : AlaFilterAndBeautyData.BeautyAdjustKey.values()) {
            this.aog.put(beautyAdjustKey.getJsonKey(), 0);
        }
    }

    public void u(String str, int i) {
        if (!TextUtils.isEmpty(str)) {
            this.aog.put(str, Integer.valueOf(i));
        }
    }

    public int dF(String str) {
        if (TextUtils.isEmpty(str) || this.aog == null || this.aog.isEmpty() || this.aog.get(str) == null) {
            return 0;
        }
        return this.aog.get(str).intValue();
    }

    public static boolean a(HashMap<AlaFilterAndBeautyData.BeautyAdjustKey, AlaFilterAndBeautyData.b> hashMap, AlaFilterAndBeautyData alaFilterAndBeautyData) {
        AlaFilterAndBeautyData.BeautyAdjustKey[] values;
        if (alaFilterAndBeautyData == null) {
            return false;
        }
        aoi.a(alaFilterAndBeautyData);
        aoi.dD(com.baidu.live.c.tG().getString("ala_beauty_config_ar", ""));
        boolean z = com.baidu.live.c.tG().getBoolean("ala_beauty_changed_by_user", false);
        for (AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey : AlaFilterAndBeautyData.BeautyAdjustKey.values()) {
            int a = AlaFilterAndBeautyData.a(hashMap, beautyAdjustKey);
            if (!z) {
                aoi.u(beautyAdjustKey.getJsonKey(), a);
            }
            aoh.u(beautyAdjustKey.getJsonKey(), a);
        }
        for (d dVar : alaFilterAndBeautyData.anP) {
            b bVar = new b();
            bVar.a(dVar);
            aoi.a(bVar);
        }
        if (!z) {
            com.baidu.live.c.tG().putString("ala_beauty_config_ar", aoi.toJsonString());
        }
        return true;
    }

    public void a(b bVar) {
        this.aof.add(bVar);
    }

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
    }
}

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
    public static c atb = new c();
    public static c atc = new c();
    public d asV;
    public String asW;
    public AlaFilterAndBeautyData asX;
    private HashMap<String, Integer> ata;
    public float mFilterLevel;
    public String asU = "";
    private HashMap<String, Integer> asY = new HashMap<>();
    private ArrayList<b> asZ = new ArrayList<>();

    public c() {
        this.asW = "";
        this.asW = AlaFilterAndBeautyData.BeautyAdjustKey.whiten.getJsonKey();
        uW();
    }

    public String toJsonString() {
        AlaFilterAndBeautyData.BeautyAdjustKey[] values;
        JSONObject jSONObject = new JSONObject();
        try {
            for (AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey : AlaFilterAndBeautyData.BeautyAdjustKey.values()) {
                jSONObject.put(beautyAdjustKey.getJsonKey(), ej(beautyAdjustKey.getJsonKey()));
            }
            jSONObject.put("filter_name", this.asU);
            jSONObject.put("filter_level", this.mFilterLevel);
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry<String, Integer> entry : this.asY.entrySet()) {
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

    public c eh(String str) {
        AlaFilterAndBeautyData.BeautyAdjustKey[] values;
        if (!TextUtils.isEmpty(str)) {
            Log.d("ArUpdate", "parseJson jsonStr:" + str);
            try {
                JSONObject jSONObject = new JSONObject(str);
                for (AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey : AlaFilterAndBeautyData.BeautyAdjustKey.values()) {
                    y(beautyAdjustKey.getJsonKey(), jSONObject.optInt(beautyAdjustKey.getJsonKey()));
                }
                this.asU = jSONObject.optString("filter_name");
                this.mFilterLevel = jSONObject.optInt("filter_level");
                JSONArray optJSONArray = jSONObject.optJSONArray("array_filter");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = (JSONObject) optJSONArray.opt(i);
                        if (jSONObject2 != null && (jSONObject2.opt("array_filter_level") instanceof Integer)) {
                            this.asY.put(jSONObject2.optString("array_filter_file"), Integer.valueOf(jSONObject2.optInt("array_filter_level")));
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return this;
    }

    public void x(String str, int i) {
        if (!TextUtils.isEmpty(str)) {
            Log.d("ArUpdate", "保存在缓存  putFilterValue--filterName:" + str + ", level:" + i);
            this.asY.put(str, Integer.valueOf(i));
        }
    }

    public int ei(String str) {
        Log.d("ArUpdate", "获取子项值 getFilterValue jsonKey:" + str);
        if (TextUtils.isEmpty(str) || this.asY == null || this.asY.isEmpty()) {
            return 100;
        }
        Log.d("ArUpdate", "获取子项值 getFilterValue value:" + (this.asY.get(str) == null ? 100 : this.asY.get(str).intValue()));
        if (this.asY.get(str) == null) {
            return 100;
        }
        return this.asY.get(str).intValue();
    }

    public int a(d dVar, List<d> list) {
        if (dVar == null || list == null || list.size() <= 0) {
            return 100;
        }
        Log.d("ArUpdate", "getFilterThreshold filterFileName:" + dVar.uX());
        for (d dVar2 : list) {
            if (dVar.uX().equals(dVar2.uX())) {
                Log.d("ArUpdate", "getFilterThreshold 阈值:" + dVar2.uZ());
                return dVar2.uZ();
            }
        }
        return 100;
    }

    public void a(AlaFilterAndBeautyData alaFilterAndBeautyData) {
        this.asX = alaFilterAndBeautyData;
    }

    private void uW() {
        this.ata = new HashMap<>();
        for (AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey : AlaFilterAndBeautyData.BeautyAdjustKey.values()) {
            this.ata.put(beautyAdjustKey.getJsonKey(), 0);
        }
    }

    public void y(String str, int i) {
        if (!TextUtils.isEmpty(str)) {
            this.ata.put(str, Integer.valueOf(i));
        }
    }

    public int ej(String str) {
        if (TextUtils.isEmpty(str) || this.ata == null || this.ata.isEmpty() || this.ata.get(str) == null) {
            return 0;
        }
        return this.ata.get(str).intValue();
    }

    public static boolean a(HashMap<AlaFilterAndBeautyData.BeautyAdjustKey, AlaFilterAndBeautyData.b> hashMap, AlaFilterAndBeautyData alaFilterAndBeautyData) {
        AlaFilterAndBeautyData.BeautyAdjustKey[] values;
        if (alaFilterAndBeautyData == null) {
            return false;
        }
        atc.a(alaFilterAndBeautyData);
        atc.eh(com.baidu.live.c.uN().getString("ala_beauty_config_ar", ""));
        boolean z = com.baidu.live.c.uN().getBoolean("ala_beauty_changed_by_user", false);
        for (AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey : AlaFilterAndBeautyData.BeautyAdjustKey.values()) {
            int a = AlaFilterAndBeautyData.a(hashMap, beautyAdjustKey);
            if (!z) {
                atc.y(beautyAdjustKey.getJsonKey(), a);
            }
            atb.y(beautyAdjustKey.getJsonKey(), a);
        }
        for (d dVar : alaFilterAndBeautyData.asJ) {
            b bVar = new b();
            bVar.a(dVar);
            atc.a(bVar);
        }
        if (!z) {
            com.baidu.live.c.uN().putString("ala_beauty_config_ar", atc.toJsonString());
        }
        return true;
    }

    public void a(b bVar) {
        this.asZ.add(bVar);
    }

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
    }
}

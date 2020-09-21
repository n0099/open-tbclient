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
/* loaded from: classes4.dex */
public class d extends BaseData {
    public static d aAH = new d();
    public static d aAI = new d();
    public String aAB;
    private HashMap<String, Integer> aAG;
    public f aAx;
    public String aAy;
    public AlaFilterAndBeautyData aAz;
    public float mFilterLevel;
    public String aAw = "";
    private HashMap<String, Integer> aAA = new HashMap<>();
    public String aAC = "1.0";
    public String aAD = "40";
    private HashMap<String, Integer> aAE = new HashMap<>();
    private ArrayList<c> aAF = new ArrayList<>();

    public d() {
        this.aAy = "";
        this.aAy = AlaFilterAndBeautyData.BeautyAdjustKey.whiten.getJsonKey();
        Bc();
    }

    public String toJsonString() {
        AlaFilterAndBeautyData.BeautyAdjustKey[] values;
        JSONObject jSONObject = new JSONObject();
        try {
            for (AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey : AlaFilterAndBeautyData.BeautyAdjustKey.values()) {
                jSONObject.put(beautyAdjustKey.getJsonKey(), fG(beautyAdjustKey.getJsonKey()));
            }
            jSONObject.put("filter_name", this.aAw);
            jSONObject.put("filter_level", this.mFilterLevel);
            jSONObject.put("face_feature_type", this.aAB);
            jSONObject.put("face_feature_max_value", this.aAC);
            jSONObject.put("face_feature_default_value", this.aAD);
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry<String, Integer> entry : this.aAE.entrySet()) {
                if (!StringUtils.isNullObject(entry.getKey())) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("array_filter_file", entry.getKey());
                    jSONObject2.put("array_filter_level", entry.getValue());
                    jSONArray.put(jSONObject2);
                }
            }
            jSONObject.put("array_filter", jSONArray);
            JSONArray jSONArray2 = new JSONArray();
            for (Map.Entry<String, Integer> entry2 : this.aAA.entrySet()) {
                if (!StringUtils.isNullObject(entry2.getKey())) {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("face_feature_type", entry2.getKey());
                    jSONObject3.put("face_feature_level", entry2.getValue());
                    jSONArray2.put(jSONObject3);
                }
            }
            jSONObject.put("array_face_feature", jSONArray2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Log.d("ArUpdate", "toJsonString:" + jSONObject.toString());
        return jSONObject.toString();
    }

    public d fD(String str) {
        AlaFilterAndBeautyData.BeautyAdjustKey[] values;
        if (!TextUtils.isEmpty(str)) {
            Log.d("ArUpdate", "parseJson jsonStr:" + str);
            try {
                JSONObject jSONObject = new JSONObject(str);
                for (AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey : AlaFilterAndBeautyData.BeautyAdjustKey.values()) {
                    z(beautyAdjustKey.getJsonKey(), jSONObject.optInt(beautyAdjustKey.getJsonKey()));
                }
                this.aAw = jSONObject.optString("filter_name");
                this.mFilterLevel = jSONObject.optInt("filter_level");
                this.aAB = jSONObject.optString("face_feature_type");
                this.aAC = jSONObject.optString("face_feature_max_value");
                this.aAD = jSONObject.optString("face_feature_default_value");
                JSONArray optJSONArray = jSONObject.optJSONArray("array_filter");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = (JSONObject) optJSONArray.opt(i);
                        if (jSONObject2 != null && (jSONObject2.opt("array_filter_level") instanceof Integer)) {
                            this.aAE.put(jSONObject2.optString("array_filter_file"), Integer.valueOf(jSONObject2.optInt("array_filter_level")));
                        }
                    }
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("array_face_feature");
                if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                    int length2 = optJSONArray2.length();
                    for (int i2 = 0; i2 < length2; i2++) {
                        JSONObject jSONObject3 = (JSONObject) optJSONArray2.opt(i2);
                        if (jSONObject3 != null && (jSONObject3.opt("face_feature_level") instanceof Integer)) {
                            this.aAA.put(jSONObject3.optString("face_feature_type"), Integer.valueOf(jSONObject3.optInt("face_feature_level")));
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return this;
    }

    public void y(String str, int i) {
        if (!TextUtils.isEmpty(str)) {
            Log.d("ArUpdate", "保存在缓存  putFilterValue--filterName:" + str + ", level:" + i);
            this.aAE.put(str, Integer.valueOf(i));
        }
    }

    public void dy(int i) {
        if (TextUtils.isEmpty(this.aAB)) {
            this.aAB = "naturalFace";
        }
        Log.d("ArUpdate", "保存在缓存  putFaceFeatureValue--faceType:" + this.aAB + ", level:" + i);
        this.aAA.put(this.aAB, Integer.valueOf(i));
    }

    public int fE(String str) {
        Log.d("ArUpdate", "获取子项值 getFilterValue jsonKey:" + str);
        if (TextUtils.isEmpty(str) || this.aAE == null || this.aAE.isEmpty()) {
            return 100;
        }
        Log.d("ArUpdate", "获取子项值 getFilterValue value:" + (this.aAE.get(str) == null ? 100 : this.aAE.get(str).intValue()));
        if (this.aAE.get(str) == null) {
            return 100;
        }
        return this.aAE.get(str).intValue();
    }

    public int fF(String str) {
        Log.d("ArUpdate", "获取子项值 getFaceFeatureValue jsonKey:" + str);
        if (TextUtils.isEmpty(str) || this.aAA == null || this.aAA.isEmpty()) {
            return 40;
        }
        Log.d("ArUpdate", "获取子项值 sFaceFeatureKeyMap value:" + (this.aAA.get(str) == null ? 40 : this.aAA.get(str).intValue()));
        if (this.aAA.get(str) == null) {
            return 40;
        }
        return this.aAA.get(str).intValue();
    }

    public int a(f fVar, List<f> list) {
        if (fVar == null || list == null || list.size() <= 0) {
            return 100;
        }
        Log.d("ArUpdate", "getFilterThreshold filterFileName:" + fVar.Be());
        for (f fVar2 : list) {
            if (fVar.Be().equals(fVar2.Be())) {
                Log.d("ArUpdate", "getFilterThreshold 阈值:" + fVar2.Bh());
                return fVar2.Bh();
            }
        }
        return 100;
    }

    public void a(AlaFilterAndBeautyData alaFilterAndBeautyData) {
        this.aAz = alaFilterAndBeautyData;
    }

    private void Bc() {
        this.aAG = new HashMap<>();
        for (AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey : AlaFilterAndBeautyData.BeautyAdjustKey.values()) {
            this.aAG.put(beautyAdjustKey.getJsonKey(), 0);
        }
    }

    public void a(boolean z, List<e> list) {
        if (z || this.aAA.size() <= 0) {
            this.aAA = new HashMap<>();
            for (e eVar : list) {
                this.aAA.put(eVar.getType(), Integer.valueOf(eVar.Bf()));
            }
        }
    }

    public void z(String str, int i) {
        if (!TextUtils.isEmpty(str)) {
            this.aAG.put(str, Integer.valueOf(i));
        }
    }

    public int fG(String str) {
        if (TextUtils.isEmpty(str) || this.aAG == null || this.aAG.isEmpty() || this.aAG.get(str) == null) {
            return 0;
        }
        return this.aAG.get(str).intValue();
    }

    public static boolean a(HashMap<AlaFilterAndBeautyData.BeautyAdjustKey, AlaFilterAndBeautyData.b> hashMap, AlaFilterAndBeautyData alaFilterAndBeautyData, JSONObject jSONObject, boolean z) {
        boolean z2;
        if (alaFilterAndBeautyData == null) {
            return false;
        }
        aAI.a(alaFilterAndBeautyData);
        aAI.fD(com.baidu.live.c.AR().getString("ala_beauty_config_ar", ""));
        boolean z3 = com.baidu.live.c.AR().getBoolean("ala_beauty_changed_by_user", false);
        b t = b.t(jSONObject);
        AlaFilterAndBeautyData.BeautyAdjustKey[] values = AlaFilterAndBeautyData.BeautyAdjustKey.values();
        int length = values.length;
        int i = 0;
        boolean z4 = false;
        while (i < length) {
            AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey = values[i];
            int a = AlaFilterAndBeautyData.a(hashMap, beautyAdjustKey);
            boolean z5 = t != null && (beautyAdjustKey == AlaFilterAndBeautyData.BeautyAdjustKey.whiten || beautyAdjustKey == AlaFilterAndBeautyData.BeautyAdjustKey.smooth) && z;
            int a2 = a(hashMap, beautyAdjustKey, t, a);
            if (z3) {
                if (z5) {
                    aAI.z(beautyAdjustKey.getJsonKey(), a2);
                    z2 = true;
                } else {
                    z2 = z4;
                }
            } else {
                aAI.z(beautyAdjustKey.getJsonKey(), a2);
                z2 = true;
            }
            aAH.z(beautyAdjustKey.getJsonKey(), a2);
            i++;
            z4 = z2;
        }
        for (f fVar : alaFilterAndBeautyData.aAi) {
            c cVar = new c();
            cVar.a(fVar);
            aAI.a(cVar);
        }
        if (z4) {
            com.baidu.live.c.AR().putString("ala_beauty_config_ar", aAI.toJsonString());
        }
        if (z) {
            com.baidu.live.c.AR().putBoolean("ar_grading_quality_config_need_update", false);
        }
        return true;
    }

    private static int a(HashMap<AlaFilterAndBeautyData.BeautyAdjustKey, AlaFilterAndBeautyData.b> hashMap, AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey, b bVar, int i) {
        AlaFilterAndBeautyData.b bVar2;
        HashMap<String, Object> Bb;
        HashMap<String, Object> Bb2;
        if (hashMap != null && beautyAdjustKey != null && bVar != null) {
            if (beautyAdjustKey == AlaFilterAndBeautyData.BeautyAdjustKey.whiten) {
                AlaFilterAndBeautyData.b bVar3 = hashMap.get(beautyAdjustKey);
                if (bVar3 != null && (Bb2 = bVar3.Bb()) != null) {
                    Object obj = Bb2.get("whiten");
                    if (obj instanceof String) {
                        try {
                            float floatValue = Float.valueOf((String) obj).floatValue();
                            return bVar.azU >= floatValue ? 100 : (int) ((bVar.azU / floatValue) * 100.0f);
                        } catch (NumberFormatException e) {
                            return i;
                        }
                    }
                    return i;
                }
                return i;
            } else if (beautyAdjustKey == AlaFilterAndBeautyData.BeautyAdjustKey.smooth && (bVar2 = hashMap.get(beautyAdjustKey)) != null && (Bb = bVar2.Bb()) != null) {
                Object obj2 = Bb.get("smooth");
                if (obj2 instanceof String) {
                    try {
                        float floatValue2 = Float.valueOf((String) obj2).floatValue();
                        return bVar.azT < floatValue2 ? (int) ((bVar.azT / floatValue2) * 100.0f) : 100;
                    } catch (NumberFormatException e2) {
                        return i;
                    }
                }
                return i;
            } else {
                return i;
            }
        }
        return i;
    }

    public void a(c cVar) {
        this.aAF.add(cVar);
    }

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
    }
}

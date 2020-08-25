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
/* loaded from: classes7.dex */
public class d extends BaseData {
    public f azP;
    public String azQ;
    public AlaFilterAndBeautyData azR;
    public String azT;
    private HashMap<String, Integer> azY;
    public float mFilterLevel;
    public static d azZ = new d();
    public static d aAa = new d();
    public String azO = "";
    private HashMap<String, Integer> azS = new HashMap<>();
    public String azU = "1.0";
    public String azV = "40";
    private HashMap<String, Integer> azW = new HashMap<>();
    private ArrayList<c> azX = new ArrayList<>();

    public d() {
        this.azQ = "";
        this.azQ = AlaFilterAndBeautyData.BeautyAdjustKey.whiten.getJsonKey();
        AN();
    }

    public String toJsonString() {
        AlaFilterAndBeautyData.BeautyAdjustKey[] values;
        JSONObject jSONObject = new JSONObject();
        try {
            for (AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey : AlaFilterAndBeautyData.BeautyAdjustKey.values()) {
                jSONObject.put(beautyAdjustKey.getJsonKey(), fD(beautyAdjustKey.getJsonKey()));
            }
            jSONObject.put("filter_name", this.azO);
            jSONObject.put("filter_level", this.mFilterLevel);
            jSONObject.put("face_feature_type", this.azT);
            jSONObject.put("face_feature_max_value", this.azU);
            jSONObject.put("face_feature_default_value", this.azV);
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry<String, Integer> entry : this.azW.entrySet()) {
                if (!StringUtils.isNullObject(entry.getKey())) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("array_filter_file", entry.getKey());
                    jSONObject2.put("array_filter_level", entry.getValue());
                    jSONArray.put(jSONObject2);
                }
            }
            jSONObject.put("array_filter", jSONArray);
            JSONArray jSONArray2 = new JSONArray();
            for (Map.Entry<String, Integer> entry2 : this.azS.entrySet()) {
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

    public d fA(String str) {
        AlaFilterAndBeautyData.BeautyAdjustKey[] values;
        if (!TextUtils.isEmpty(str)) {
            Log.d("ArUpdate", "parseJson jsonStr:" + str);
            try {
                JSONObject jSONObject = new JSONObject(str);
                for (AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey : AlaFilterAndBeautyData.BeautyAdjustKey.values()) {
                    z(beautyAdjustKey.getJsonKey(), jSONObject.optInt(beautyAdjustKey.getJsonKey()));
                }
                this.azO = jSONObject.optString("filter_name");
                this.mFilterLevel = jSONObject.optInt("filter_level");
                this.azT = jSONObject.optString("face_feature_type");
                this.azU = jSONObject.optString("face_feature_max_value");
                this.azV = jSONObject.optString("face_feature_default_value");
                JSONArray optJSONArray = jSONObject.optJSONArray("array_filter");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = (JSONObject) optJSONArray.opt(i);
                        if (jSONObject2 != null && (jSONObject2.opt("array_filter_level") instanceof Integer)) {
                            this.azW.put(jSONObject2.optString("array_filter_file"), Integer.valueOf(jSONObject2.optInt("array_filter_level")));
                        }
                    }
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("array_face_feature");
                if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                    int length2 = optJSONArray2.length();
                    for (int i2 = 0; i2 < length2; i2++) {
                        JSONObject jSONObject3 = (JSONObject) optJSONArray2.opt(i2);
                        if (jSONObject3 != null && (jSONObject3.opt("face_feature_level") instanceof Integer)) {
                            this.azS.put(jSONObject3.optString("face_feature_type"), Integer.valueOf(jSONObject3.optInt("face_feature_level")));
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
            this.azW.put(str, Integer.valueOf(i));
        }
    }

    public void du(int i) {
        if (TextUtils.isEmpty(this.azT)) {
            this.azT = "naturalFace";
        }
        Log.d("ArUpdate", "保存在缓存  putFaceFeatureValue--faceType:" + this.azT + ", level:" + i);
        this.azS.put(this.azT, Integer.valueOf(i));
    }

    public int fB(String str) {
        Log.d("ArUpdate", "获取子项值 getFilterValue jsonKey:" + str);
        if (TextUtils.isEmpty(str) || this.azW == null || this.azW.isEmpty()) {
            return 100;
        }
        Log.d("ArUpdate", "获取子项值 getFilterValue value:" + (this.azW.get(str) == null ? 100 : this.azW.get(str).intValue()));
        if (this.azW.get(str) == null) {
            return 100;
        }
        return this.azW.get(str).intValue();
    }

    public int fC(String str) {
        Log.d("ArUpdate", "获取子项值 getFaceFeatureValue jsonKey:" + str);
        if (TextUtils.isEmpty(str) || this.azS == null || this.azS.isEmpty()) {
            return 40;
        }
        Log.d("ArUpdate", "获取子项值 sFaceFeatureKeyMap value:" + (this.azS.get(str) == null ? 40 : this.azS.get(str).intValue()));
        if (this.azS.get(str) == null) {
            return 40;
        }
        return this.azS.get(str).intValue();
    }

    public int a(f fVar, List<f> list) {
        if (fVar == null || list == null || list.size() <= 0) {
            return 100;
        }
        Log.d("ArUpdate", "getFilterThreshold filterFileName:" + fVar.AP());
        for (f fVar2 : list) {
            if (fVar.AP().equals(fVar2.AP())) {
                Log.d("ArUpdate", "getFilterThreshold 阈值:" + fVar2.AS());
                return fVar2.AS();
            }
        }
        return 100;
    }

    public void a(AlaFilterAndBeautyData alaFilterAndBeautyData) {
        this.azR = alaFilterAndBeautyData;
    }

    private void AN() {
        this.azY = new HashMap<>();
        for (AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey : AlaFilterAndBeautyData.BeautyAdjustKey.values()) {
            this.azY.put(beautyAdjustKey.getJsonKey(), 0);
        }
    }

    public void a(boolean z, List<e> list) {
        if (z || this.azS.size() <= 0) {
            this.azS = new HashMap<>();
            for (e eVar : list) {
                this.azS.put(eVar.getType(), Integer.valueOf(eVar.AQ()));
            }
        }
    }

    public void z(String str, int i) {
        if (!TextUtils.isEmpty(str)) {
            this.azY.put(str, Integer.valueOf(i));
        }
    }

    public int fD(String str) {
        if (TextUtils.isEmpty(str) || this.azY == null || this.azY.isEmpty() || this.azY.get(str) == null) {
            return 0;
        }
        return this.azY.get(str).intValue();
    }

    public static boolean a(HashMap<AlaFilterAndBeautyData.BeautyAdjustKey, AlaFilterAndBeautyData.b> hashMap, AlaFilterAndBeautyData alaFilterAndBeautyData, JSONObject jSONObject, boolean z) {
        boolean z2;
        if (alaFilterAndBeautyData == null) {
            return false;
        }
        aAa.a(alaFilterAndBeautyData);
        aAa.fA(com.baidu.live.c.AD().getString("ala_beauty_config_ar", ""));
        boolean z3 = com.baidu.live.c.AD().getBoolean("ala_beauty_changed_by_user", false);
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
                    aAa.z(beautyAdjustKey.getJsonKey(), a2);
                    z2 = true;
                } else {
                    z2 = z4;
                }
            } else {
                aAa.z(beautyAdjustKey.getJsonKey(), a2);
                z2 = true;
            }
            azZ.z(beautyAdjustKey.getJsonKey(), a2);
            i++;
            z4 = z2;
        }
        for (f fVar : alaFilterAndBeautyData.azA) {
            c cVar = new c();
            cVar.a(fVar);
            aAa.a(cVar);
        }
        if (z4) {
            com.baidu.live.c.AD().putString("ala_beauty_config_ar", aAa.toJsonString());
        }
        if (z) {
            com.baidu.live.c.AD().putBoolean("ar_grading_quality_config_need_update", false);
        }
        return true;
    }

    private static int a(HashMap<AlaFilterAndBeautyData.BeautyAdjustKey, AlaFilterAndBeautyData.b> hashMap, AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey, b bVar, int i) {
        AlaFilterAndBeautyData.b bVar2;
        HashMap<String, Object> AM;
        HashMap<String, Object> AM2;
        if (hashMap != null && beautyAdjustKey != null && bVar != null) {
            if (beautyAdjustKey == AlaFilterAndBeautyData.BeautyAdjustKey.whiten) {
                AlaFilterAndBeautyData.b bVar3 = hashMap.get(beautyAdjustKey);
                if (bVar3 != null && (AM2 = bVar3.AM()) != null) {
                    Object obj = AM2.get("whiten");
                    if (obj instanceof String) {
                        try {
                            float floatValue = Float.valueOf((String) obj).floatValue();
                            return bVar.azm >= floatValue ? 100 : (int) ((bVar.azm / floatValue) * 100.0f);
                        } catch (NumberFormatException e) {
                            return i;
                        }
                    }
                    return i;
                }
                return i;
            } else if (beautyAdjustKey == AlaFilterAndBeautyData.BeautyAdjustKey.smooth && (bVar2 = hashMap.get(beautyAdjustKey)) != null && (AM = bVar2.AM()) != null) {
                Object obj2 = AM.get("smooth");
                if (obj2 instanceof String) {
                    try {
                        float floatValue2 = Float.valueOf((String) obj2).floatValue();
                        return bVar.azl < floatValue2 ? (int) ((bVar.azl / floatValue2) * 100.0f) : 100;
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
        this.azX.add(cVar);
    }

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
    }
}

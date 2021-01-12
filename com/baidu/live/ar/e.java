package com.baidu.live.ar;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.ar.AlaFilterAndBeautyData;
import com.baidu.live.ar.m;
import com.baidu.live.tbadk.core.data.BaseData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class e extends BaseData {
    public static e aAZ = new e();
    public static e aBa = new e();
    public i aAN;
    public String aAO;
    public AlaFilterAndBeautyData aAP;
    public String aAR;
    public h aAU;
    public m.a aAV;
    private HashMap<String, Integer> aAY;
    public float mFilterLevel;
    public String aAM = "";
    private HashMap<String, Integer> aAQ = new HashMap<>();
    public String aAS = "1.0";
    public String aAT = "40";
    private HashMap<String, Integer> aAW = new HashMap<>();
    private ArrayList<d> aAX = new ArrayList<>();

    public e() {
        this.aAO = "";
        this.aAO = AlaFilterAndBeautyData.BeautyAdjustKey.whiten.getJsonKey();
        yN();
    }

    public String toJsonString() {
        AlaFilterAndBeautyData.BeautyAdjustKey[] values;
        JSONObject jSONObject = new JSONObject();
        try {
            for (AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey : AlaFilterAndBeautyData.BeautyAdjustKey.values()) {
                jSONObject.put(beautyAdjustKey.getJsonKey(), eM(beautyAdjustKey.getJsonKey()));
            }
            jSONObject.put("filter_name", this.aAM);
            jSONObject.put("filter_level", this.mFilterLevel);
            jSONObject.put("face_feature_type", this.aAR);
            jSONObject.put("face_feature_max_value", this.aAS);
            jSONObject.put("face_feature_default_value", this.aAT);
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry<String, Integer> entry : this.aAW.entrySet()) {
                if (!StringUtils.isNullObject(entry.getKey())) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("array_filter_file", entry.getKey());
                    jSONObject2.put("array_filter_level", entry.getValue());
                    jSONArray.put(jSONObject2);
                }
            }
            jSONObject.put("array_filter", jSONArray);
            JSONArray jSONArray2 = new JSONArray();
            for (Map.Entry<String, Integer> entry2 : this.aAQ.entrySet()) {
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

    public e r(String str, boolean z) {
        AlaFilterAndBeautyData.BeautyAdjustKey[] values;
        if (!TextUtils.isEmpty(str)) {
            Log.d("ArUpdate", "parseJson jsonStr:" + str);
            try {
                JSONObject jSONObject = new JSONObject(str);
                for (AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey : AlaFilterAndBeautyData.BeautyAdjustKey.values()) {
                    B(beautyAdjustKey.getJsonKey(), jSONObject.optInt(beautyAdjustKey.getJsonKey()));
                }
                if (!z) {
                    this.aAM = jSONObject.optString("filter_name");
                    this.mFilterLevel = jSONObject.optInt("filter_level");
                }
                this.aAR = jSONObject.optString("face_feature_type");
                this.aAS = jSONObject.optString("face_feature_max_value");
                this.aAT = jSONObject.optString("face_feature_default_value");
                JSONArray optJSONArray = jSONObject.optJSONArray("array_filter");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = (JSONObject) optJSONArray.opt(i);
                        if (jSONObject2 != null && (jSONObject2.opt("array_filter_level") instanceof Integer)) {
                            this.aAW.put(jSONObject2.optString("array_filter_file"), Integer.valueOf(jSONObject2.optInt("array_filter_level")));
                        }
                    }
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("array_face_feature");
                if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                    int length2 = optJSONArray2.length();
                    for (int i2 = 0; i2 < length2; i2++) {
                        JSONObject jSONObject3 = (JSONObject) optJSONArray2.opt(i2);
                        if (jSONObject3 != null && (jSONObject3.opt("face_feature_level") instanceof Integer)) {
                            this.aAQ.put(jSONObject3.optString("face_feature_type"), Integer.valueOf(jSONObject3.optInt("face_feature_level")));
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return this;
    }

    public void A(String str, int i) {
        if (!TextUtils.isEmpty(str)) {
            Log.d("ArUpdate", "保存在缓存  putFilterValue--filterName:" + str + ", level:" + i);
            this.aAW.put(str, Integer.valueOf(i));
        }
    }

    public void cj(int i) {
        if (TextUtils.isEmpty(this.aAR)) {
            this.aAR = "naturalFace";
        }
        Log.d("ArUpdate", "保存在缓存  putFaceFeatureValue--faceType:" + this.aAR + ", level:" + i);
        this.aAQ.put(this.aAR, Integer.valueOf(i));
    }

    public int eK(String str) {
        Log.d("ArUpdate", "获取子项值 getFilterValue jsonKey:" + str);
        if (TextUtils.isEmpty(str) || this.aAW == null || this.aAW.isEmpty()) {
            return 100;
        }
        Log.d("ArUpdate", "获取子项值 getFilterValue value:" + (this.aAW.get(str) == null ? 100 : this.aAW.get(str).intValue()));
        if (this.aAW.get(str) == null) {
            return 100;
        }
        return this.aAW.get(str).intValue();
    }

    public int eL(String str) {
        Log.d("ArUpdate", "获取子项值 getFaceFeatureValue jsonKey:" + str);
        if (TextUtils.isEmpty(str) || this.aAQ == null || this.aAQ.isEmpty()) {
            return 40;
        }
        Log.d("ArUpdate", "获取子项值 sFaceFeatureKeyMap value:" + (this.aAQ.get(str) == null ? 40 : this.aAQ.get(str).intValue()));
        if (this.aAQ.get(str) == null) {
            return 40;
        }
        return this.aAQ.get(str).intValue();
    }

    public int a(i iVar, List<i> list) {
        if (iVar == null || list == null || list.size() <= 0) {
            return 100;
        }
        Log.d("ArUpdate", "getFilterThreshold filterFileName:" + iVar.yQ());
        for (i iVar2 : list) {
            if (iVar.yQ().equals(iVar2.yQ())) {
                Log.d("ArUpdate", "getFilterThreshold 阈值:" + iVar2.yT());
                return iVar2.yT();
            }
        }
        return 100;
    }

    public void a(AlaFilterAndBeautyData alaFilterAndBeautyData) {
        this.aAP = alaFilterAndBeautyData;
    }

    private void yN() {
        this.aAY = new HashMap<>();
        for (AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey : AlaFilterAndBeautyData.BeautyAdjustKey.values()) {
            this.aAY.put(beautyAdjustKey.getJsonKey(), 0);
        }
    }

    public void b(boolean z, List<h> list) {
        if (z || this.aAQ.size() <= 0) {
            this.aAQ = new HashMap<>();
            for (h hVar : list) {
                this.aAQ.put(hVar.getType(), Integer.valueOf(hVar.yR()));
            }
        }
    }

    public void B(String str, int i) {
        if (!TextUtils.isEmpty(str)) {
            this.aAY.put(str, Integer.valueOf(i));
        }
    }

    public int eM(String str) {
        if (TextUtils.isEmpty(str) || this.aAY == null || this.aAY.isEmpty() || this.aAY.get(str) == null) {
            return 0;
        }
        return this.aAY.get(str).intValue();
    }

    public static boolean a(HashMap<AlaFilterAndBeautyData.BeautyAdjustKey, AlaFilterAndBeautyData.b> hashMap, AlaFilterAndBeautyData alaFilterAndBeautyData, JSONObject jSONObject, boolean z) {
        boolean z2;
        if (alaFilterAndBeautyData == null) {
            return false;
        }
        aBa.a(alaFilterAndBeautyData);
        aBa.r(com.baidu.live.d.xf().getString("ala_beauty_config_ar", ""), false);
        boolean z3 = com.baidu.live.d.xf().getBoolean("ala_beauty_changed_by_user", false);
        b w = b.w(jSONObject);
        AlaFilterAndBeautyData.BeautyAdjustKey[] values = AlaFilterAndBeautyData.BeautyAdjustKey.values();
        int length = values.length;
        int i = 0;
        boolean z4 = false;
        while (i < length) {
            AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey = values[i];
            int a2 = AlaFilterAndBeautyData.a(hashMap, beautyAdjustKey);
            boolean z5 = w != null && (beautyAdjustKey == AlaFilterAndBeautyData.BeautyAdjustKey.whiten || beautyAdjustKey == AlaFilterAndBeautyData.BeautyAdjustKey.smooth) && z;
            int a3 = a(hashMap, beautyAdjustKey, w, a2);
            if (z3) {
                if (z5) {
                    aBa.B(beautyAdjustKey.getJsonKey(), a3);
                    z2 = true;
                } else {
                    z2 = z4;
                }
            } else {
                aBa.B(beautyAdjustKey.getJsonKey(), a3);
                z2 = true;
            }
            aAZ.B(beautyAdjustKey.getJsonKey(), a3);
            i++;
            z4 = z2;
        }
        for (i iVar : alaFilterAndBeautyData.aAy) {
            d dVar = new d();
            dVar.a(iVar);
            aBa.a(dVar);
        }
        if (z4) {
            com.baidu.live.d.xf().putString("ala_beauty_config_ar", aBa.toJsonString());
        }
        if (z) {
            com.baidu.live.d.xf().putBoolean("ar_grading_quality_config_need_update", false);
        }
        return true;
    }

    private static int a(HashMap<AlaFilterAndBeautyData.BeautyAdjustKey, AlaFilterAndBeautyData.b> hashMap, AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey, b bVar, int i) {
        AlaFilterAndBeautyData.b bVar2;
        HashMap<String, Object> yM;
        HashMap<String, Object> yM2;
        if (hashMap != null && beautyAdjustKey != null && bVar != null) {
            if (beautyAdjustKey == AlaFilterAndBeautyData.BeautyAdjustKey.whiten) {
                AlaFilterAndBeautyData.b bVar3 = hashMap.get(beautyAdjustKey);
                if (bVar3 != null && (yM2 = bVar3.yM()) != null) {
                    Object obj = yM2.get("whiten");
                    if (obj instanceof String) {
                        try {
                            float floatValue = Float.valueOf((String) obj).floatValue();
                            return bVar.aAj >= floatValue ? 100 : (int) ((bVar.aAj / floatValue) * 100.0f);
                        } catch (NumberFormatException e) {
                            return i;
                        }
                    }
                    return i;
                }
                return i;
            } else if (beautyAdjustKey == AlaFilterAndBeautyData.BeautyAdjustKey.smooth && (bVar2 = hashMap.get(beautyAdjustKey)) != null && (yM = bVar2.yM()) != null) {
                Object obj2 = yM.get("smooth");
                if (obj2 instanceof String) {
                    try {
                        float floatValue2 = Float.valueOf((String) obj2).floatValue();
                        return bVar.aAi < floatValue2 ? (int) ((bVar.aAi / floatValue2) * 100.0f) : 100;
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

    public void a(d dVar) {
        this.aAX.add(dVar);
    }

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
    }
}

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
    public static d auX = new d();
    public static d auY = new d();
    public f auN;
    public String auO;
    public AlaFilterAndBeautyData auP;
    public String auR;
    private HashMap<String, Integer> auW;
    public float mFilterLevel;
    public String auM = "";
    private HashMap<String, Integer> auQ = new HashMap<>();
    public String auS = "1.0";
    public String auT = "40";
    private HashMap<String, Integer> auU = new HashMap<>();
    private ArrayList<c> auV = new ArrayList<>();

    public d() {
        this.auO = "";
        this.auO = AlaFilterAndBeautyData.BeautyAdjustKey.whiten.getJsonKey();
        vp();
    }

    public String toJsonString() {
        AlaFilterAndBeautyData.BeautyAdjustKey[] values;
        JSONObject jSONObject = new JSONObject();
        try {
            for (AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey : AlaFilterAndBeautyData.BeautyAdjustKey.values()) {
                jSONObject.put(beautyAdjustKey.getJsonKey(), el(beautyAdjustKey.getJsonKey()));
            }
            jSONObject.put("filter_name", this.auM);
            jSONObject.put("filter_level", this.mFilterLevel);
            jSONObject.put("face_feature_type", this.auR);
            jSONObject.put("face_feature_max_value", this.auS);
            jSONObject.put("face_feature_default_value", this.auT);
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry<String, Integer> entry : this.auU.entrySet()) {
                if (!StringUtils.isNullObject(entry.getKey())) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("array_filter_file", entry.getKey());
                    jSONObject2.put("array_filter_level", entry.getValue());
                    jSONArray.put(jSONObject2);
                }
            }
            jSONObject.put("array_filter", jSONArray);
            JSONArray jSONArray2 = new JSONArray();
            for (Map.Entry<String, Integer> entry2 : this.auQ.entrySet()) {
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

    public d ei(String str) {
        AlaFilterAndBeautyData.BeautyAdjustKey[] values;
        if (!TextUtils.isEmpty(str)) {
            Log.d("ArUpdate", "parseJson jsonStr:" + str);
            try {
                JSONObject jSONObject = new JSONObject(str);
                for (AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey : AlaFilterAndBeautyData.BeautyAdjustKey.values()) {
                    y(beautyAdjustKey.getJsonKey(), jSONObject.optInt(beautyAdjustKey.getJsonKey()));
                }
                this.auM = jSONObject.optString("filter_name");
                this.mFilterLevel = jSONObject.optInt("filter_level");
                this.auR = jSONObject.optString("face_feature_type");
                this.auS = jSONObject.optString("face_feature_max_value");
                this.auT = jSONObject.optString("face_feature_default_value");
                JSONArray optJSONArray = jSONObject.optJSONArray("array_filter");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = (JSONObject) optJSONArray.opt(i);
                        if (jSONObject2 != null && (jSONObject2.opt("array_filter_level") instanceof Integer)) {
                            this.auU.put(jSONObject2.optString("array_filter_file"), Integer.valueOf(jSONObject2.optInt("array_filter_level")));
                        }
                    }
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("array_face_feature");
                if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                    int length2 = optJSONArray2.length();
                    for (int i2 = 0; i2 < length2; i2++) {
                        JSONObject jSONObject3 = (JSONObject) optJSONArray2.opt(i2);
                        if (jSONObject3 != null && (jSONObject3.opt("face_feature_level") instanceof Integer)) {
                            this.auQ.put(jSONObject3.optString("face_feature_type"), Integer.valueOf(jSONObject3.optInt("face_feature_level")));
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
            this.auU.put(str, Integer.valueOf(i));
        }
    }

    public void bI(int i) {
        if (TextUtils.isEmpty(this.auR)) {
            this.auR = "naturalFace";
        }
        Log.d("ArUpdate", "保存在缓存  putFaceFeatureValue--faceType:" + this.auR + ", level:" + i);
        this.auQ.put(this.auR, Integer.valueOf(i));
    }

    public int ej(String str) {
        Log.d("ArUpdate", "获取子项值 getFilterValue jsonKey:" + str);
        if (TextUtils.isEmpty(str) || this.auU == null || this.auU.isEmpty()) {
            return 100;
        }
        Log.d("ArUpdate", "获取子项值 getFilterValue value:" + (this.auU.get(str) == null ? 100 : this.auU.get(str).intValue()));
        if (this.auU.get(str) == null) {
            return 100;
        }
        return this.auU.get(str).intValue();
    }

    public int ek(String str) {
        Log.d("ArUpdate", "获取子项值 getFaceFeatureValue jsonKey:" + str);
        if (TextUtils.isEmpty(str) || this.auQ == null || this.auQ.isEmpty()) {
            return 40;
        }
        Log.d("ArUpdate", "获取子项值 sFaceFeatureKeyMap value:" + (this.auQ.get(str) == null ? 40 : this.auQ.get(str).intValue()));
        if (this.auQ.get(str) == null) {
            return 40;
        }
        return this.auQ.get(str).intValue();
    }

    public int a(f fVar, List<f> list) {
        if (fVar == null || list == null || list.size() <= 0) {
            return 100;
        }
        Log.d("ArUpdate", "getFilterThreshold filterFileName:" + fVar.vr());
        for (f fVar2 : list) {
            if (fVar.vr().equals(fVar2.vr())) {
                Log.d("ArUpdate", "getFilterThreshold 阈值:" + fVar2.vu());
                return fVar2.vu();
            }
        }
        return 100;
    }

    public void a(AlaFilterAndBeautyData alaFilterAndBeautyData) {
        this.auP = alaFilterAndBeautyData;
    }

    private void vp() {
        this.auW = new HashMap<>();
        for (AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey : AlaFilterAndBeautyData.BeautyAdjustKey.values()) {
            this.auW.put(beautyAdjustKey.getJsonKey(), 0);
        }
    }

    public void a(boolean z, List<e> list) {
        if (z || this.auQ.size() <= 0) {
            this.auQ = new HashMap<>();
            for (e eVar : list) {
                this.auQ.put(eVar.getType(), Integer.valueOf(eVar.vs()));
            }
        }
    }

    public void y(String str, int i) {
        if (!TextUtils.isEmpty(str)) {
            this.auW.put(str, Integer.valueOf(i));
        }
    }

    public int el(String str) {
        if (TextUtils.isEmpty(str) || this.auW == null || this.auW.isEmpty() || this.auW.get(str) == null) {
            return 0;
        }
        return this.auW.get(str).intValue();
    }

    public static boolean a(HashMap<AlaFilterAndBeautyData.BeautyAdjustKey, AlaFilterAndBeautyData.b> hashMap, AlaFilterAndBeautyData alaFilterAndBeautyData, JSONObject jSONObject, boolean z) {
        boolean z2;
        if (alaFilterAndBeautyData == null) {
            return false;
        }
        auY.a(alaFilterAndBeautyData);
        auY.ei(com.baidu.live.c.vf().getString("ala_beauty_config_ar", ""));
        boolean z3 = com.baidu.live.c.vf().getBoolean("ala_beauty_changed_by_user", false);
        b s = b.s(jSONObject);
        AlaFilterAndBeautyData.BeautyAdjustKey[] values = AlaFilterAndBeautyData.BeautyAdjustKey.values();
        int length = values.length;
        int i = 0;
        boolean z4 = false;
        while (i < length) {
            AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey = values[i];
            int a = AlaFilterAndBeautyData.a(hashMap, beautyAdjustKey);
            boolean z5 = s != null && (beautyAdjustKey == AlaFilterAndBeautyData.BeautyAdjustKey.whiten || beautyAdjustKey == AlaFilterAndBeautyData.BeautyAdjustKey.smooth) && z;
            int a2 = a(hashMap, beautyAdjustKey, s, a);
            if (z3) {
                if (z5) {
                    auY.y(beautyAdjustKey.getJsonKey(), a2);
                    z2 = true;
                } else {
                    z2 = z4;
                }
            } else {
                auY.y(beautyAdjustKey.getJsonKey(), a2);
                z2 = true;
            }
            auX.y(beautyAdjustKey.getJsonKey(), a2);
            i++;
            z4 = z2;
        }
        for (f fVar : alaFilterAndBeautyData.auy) {
            c cVar = new c();
            cVar.a(fVar);
            auY.a(cVar);
        }
        if (z4) {
            com.baidu.live.c.vf().putString("ala_beauty_config_ar", auY.toJsonString());
        }
        if (z) {
            com.baidu.live.c.vf().putBoolean("ar_grading_quality_config_need_update", false);
        }
        return true;
    }

    private static int a(HashMap<AlaFilterAndBeautyData.BeautyAdjustKey, AlaFilterAndBeautyData.b> hashMap, AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey, b bVar, int i) {
        AlaFilterAndBeautyData.b bVar2;
        HashMap<String, Object> vo;
        HashMap<String, Object> vo2;
        if (hashMap != null && beautyAdjustKey != null && bVar != null) {
            if (beautyAdjustKey == AlaFilterAndBeautyData.BeautyAdjustKey.whiten) {
                AlaFilterAndBeautyData.b bVar3 = hashMap.get(beautyAdjustKey);
                if (bVar3 != null && (vo2 = bVar3.vo()) != null) {
                    Object obj = vo2.get("whiten");
                    if (obj instanceof String) {
                        try {
                            float floatValue = Float.valueOf((String) obj).floatValue();
                            return bVar.auk >= floatValue ? 100 : (int) ((bVar.auk / floatValue) * 100.0f);
                        } catch (NumberFormatException e) {
                            return i;
                        }
                    }
                    return i;
                }
                return i;
            } else if (beautyAdjustKey == AlaFilterAndBeautyData.BeautyAdjustKey.smooth && (bVar2 = hashMap.get(beautyAdjustKey)) != null && (vo = bVar2.vo()) != null) {
                Object obj2 = vo.get("smooth");
                if (obj2 instanceof String) {
                    try {
                        float floatValue2 = Float.valueOf((String) obj2).floatValue();
                        return bVar.auj < floatValue2 ? (int) ((bVar.auj / floatValue2) * 100.0f) : 100;
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
        this.auV.add(cVar);
    }

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
    }
}

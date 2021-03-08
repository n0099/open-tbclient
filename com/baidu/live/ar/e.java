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
    public static e aEe = new e();
    public static e aEf = new e();
    public i aDS;
    public String aDT;
    public AlaFilterAndBeautyData aDU;
    public String aDW;
    public h aDZ;
    public m.a aEa;
    private HashMap<String, Integer> aEd;
    public float mFilterLevel;
    public String aDR = "";
    private HashMap<String, Integer> aDV = new HashMap<>();
    public String aDX = "1.0";
    public String aDY = "40";
    private HashMap<String, Integer> aEb = new HashMap<>();
    private ArrayList<d> aEc = new ArrayList<>();

    public e() {
        this.aDT = "";
        this.aDT = AlaFilterAndBeautyData.BeautyAdjustKey.whiten.getJsonKey();
        zx();
    }

    public String toJsonString() {
        AlaFilterAndBeautyData.BeautyAdjustKey[] values;
        JSONObject jSONObject = new JSONObject();
        try {
            for (AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey : AlaFilterAndBeautyData.BeautyAdjustKey.values()) {
                jSONObject.put(beautyAdjustKey.getJsonKey(), fk(beautyAdjustKey.getJsonKey()));
            }
            jSONObject.put("filter_name", this.aDR);
            jSONObject.put("filter_level", this.mFilterLevel);
            jSONObject.put("face_feature_type", this.aDW);
            jSONObject.put("face_feature_max_value", this.aDX);
            jSONObject.put("face_feature_default_value", this.aDY);
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry<String, Integer> entry : this.aEb.entrySet()) {
                if (!StringUtils.isNullObject(entry.getKey())) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("array_filter_file", entry.getKey());
                    jSONObject2.put("array_filter_level", entry.getValue());
                    jSONArray.put(jSONObject2);
                }
            }
            jSONObject.put("array_filter", jSONArray);
            JSONArray jSONArray2 = new JSONArray();
            for (Map.Entry<String, Integer> entry2 : this.aDV.entrySet()) {
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
                    this.aDR = jSONObject.optString("filter_name");
                    this.mFilterLevel = jSONObject.optInt("filter_level");
                }
                this.aDW = jSONObject.optString("face_feature_type");
                this.aDX = jSONObject.optString("face_feature_max_value");
                this.aDY = jSONObject.optString("face_feature_default_value");
                JSONArray optJSONArray = jSONObject.optJSONArray("array_filter");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = (JSONObject) optJSONArray.opt(i);
                        if (jSONObject2 != null && (jSONObject2.opt("array_filter_level") instanceof Integer)) {
                            this.aEb.put(jSONObject2.optString("array_filter_file"), Integer.valueOf(jSONObject2.optInt("array_filter_level")));
                        }
                    }
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("array_face_feature");
                if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                    int length2 = optJSONArray2.length();
                    for (int i2 = 0; i2 < length2; i2++) {
                        JSONObject jSONObject3 = (JSONObject) optJSONArray2.opt(i2);
                        if (jSONObject3 != null && (jSONObject3.opt("face_feature_level") instanceof Integer)) {
                            this.aDV.put(jSONObject3.optString("face_feature_type"), Integer.valueOf(jSONObject3.optInt("face_feature_level")));
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
            this.aEb.put(str, Integer.valueOf(i));
        }
    }

    public void cn(int i) {
        if (TextUtils.isEmpty(this.aDW)) {
            this.aDW = "naturalFace";
        }
        Log.d("ArUpdate", "保存在缓存  putFaceFeatureValue--faceType:" + this.aDW + ", level:" + i);
        this.aDV.put(this.aDW, Integer.valueOf(i));
    }

    public int fi(String str) {
        Log.d("ArUpdate", "获取子项值 getFilterValue jsonKey:" + str);
        if (TextUtils.isEmpty(str) || this.aEb == null || this.aEb.isEmpty()) {
            return 100;
        }
        Log.d("ArUpdate", "获取子项值 getFilterValue value:" + (this.aEb.get(str) == null ? 100 : this.aEb.get(str).intValue()));
        if (this.aEb.get(str) == null) {
            return 100;
        }
        return this.aEb.get(str).intValue();
    }

    public int fj(String str) {
        Log.d("ArUpdate", "获取子项值 getFaceFeatureValue jsonKey:" + str);
        if (TextUtils.isEmpty(str) || this.aDV == null || this.aDV.isEmpty()) {
            return 40;
        }
        Log.d("ArUpdate", "获取子项值 sFaceFeatureKeyMap value:" + (this.aDV.get(str) == null ? 40 : this.aDV.get(str).intValue()));
        if (this.aDV.get(str) == null) {
            return 40;
        }
        return this.aDV.get(str).intValue();
    }

    public int a(i iVar, List<i> list) {
        if (iVar == null || list == null || list.size() <= 0) {
            return 100;
        }
        Log.d("ArUpdate", "getFilterThreshold filterFileName:" + iVar.zA());
        for (i iVar2 : list) {
            if (iVar.zA().equals(iVar2.zA())) {
                Log.d("ArUpdate", "getFilterThreshold 阈值:" + iVar2.zD());
                return iVar2.zD();
            }
        }
        return 100;
    }

    public void a(AlaFilterAndBeautyData alaFilterAndBeautyData) {
        this.aDU = alaFilterAndBeautyData;
    }

    private void zx() {
        this.aEd = new HashMap<>();
        for (AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey : AlaFilterAndBeautyData.BeautyAdjustKey.values()) {
            this.aEd.put(beautyAdjustKey.getJsonKey(), 0);
        }
    }

    public void c(boolean z, List<h> list) {
        if (z || this.aDV.size() <= 0) {
            this.aDV = new HashMap<>();
            for (h hVar : list) {
                this.aDV.put(hVar.getType(), Integer.valueOf(hVar.zB()));
            }
        }
    }

    public void B(String str, int i) {
        if (!TextUtils.isEmpty(str)) {
            this.aEd.put(str, Integer.valueOf(i));
        }
    }

    public int fk(String str) {
        if (TextUtils.isEmpty(str) || this.aEd == null || this.aEd.isEmpty() || this.aEd.get(str) == null) {
            return 0;
        }
        return this.aEd.get(str).intValue();
    }

    public static boolean a(HashMap<AlaFilterAndBeautyData.BeautyAdjustKey, AlaFilterAndBeautyData.b> hashMap, AlaFilterAndBeautyData alaFilterAndBeautyData, JSONObject jSONObject, boolean z) {
        boolean z2;
        if (alaFilterAndBeautyData == null) {
            return false;
        }
        aEf.a(alaFilterAndBeautyData);
        aEf.r(com.baidu.live.d.xf().getString("ala_beauty_config_ar", ""), false);
        boolean z3 = com.baidu.live.d.xf().getBoolean("ala_beauty_changed_by_user", false);
        b y = b.y(jSONObject);
        AlaFilterAndBeautyData.BeautyAdjustKey[] values = AlaFilterAndBeautyData.BeautyAdjustKey.values();
        int length = values.length;
        int i = 0;
        boolean z4 = false;
        while (i < length) {
            AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey = values[i];
            int a2 = AlaFilterAndBeautyData.a(hashMap, beautyAdjustKey);
            boolean z5 = y != null && (beautyAdjustKey == AlaFilterAndBeautyData.BeautyAdjustKey.whiten || beautyAdjustKey == AlaFilterAndBeautyData.BeautyAdjustKey.smooth) && z;
            int a3 = a(hashMap, beautyAdjustKey, y, a2);
            if (z3) {
                if (z5) {
                    aEf.B(beautyAdjustKey.getJsonKey(), a3);
                    z2 = true;
                } else {
                    z2 = z4;
                }
            } else {
                aEf.B(beautyAdjustKey.getJsonKey(), a3);
                z2 = true;
            }
            aEe.B(beautyAdjustKey.getJsonKey(), a3);
            i++;
            z4 = z2;
        }
        for (i iVar : alaFilterAndBeautyData.aDD) {
            d dVar = new d();
            dVar.a(iVar);
            aEf.a(dVar);
        }
        if (z4) {
            com.baidu.live.d.xf().putString("ala_beauty_config_ar", aEf.toJsonString());
        }
        if (z) {
            com.baidu.live.d.xf().putBoolean("ar_grading_quality_config_need_update", false);
        }
        return true;
    }

    private static int a(HashMap<AlaFilterAndBeautyData.BeautyAdjustKey, AlaFilterAndBeautyData.b> hashMap, AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey, b bVar, int i) {
        AlaFilterAndBeautyData.b bVar2;
        HashMap<String, Object> zw;
        HashMap<String, Object> zw2;
        if (hashMap != null && beautyAdjustKey != null && bVar != null) {
            if (beautyAdjustKey == AlaFilterAndBeautyData.BeautyAdjustKey.whiten) {
                AlaFilterAndBeautyData.b bVar3 = hashMap.get(beautyAdjustKey);
                if (bVar3 != null && (zw2 = bVar3.zw()) != null) {
                    Object obj = zw2.get("whiten");
                    if (obj instanceof String) {
                        try {
                            float floatValue = Float.valueOf((String) obj).floatValue();
                            return bVar.aDo >= floatValue ? 100 : (int) ((bVar.aDo / floatValue) * 100.0f);
                        } catch (NumberFormatException e) {
                            return i;
                        }
                    }
                    return i;
                }
                return i;
            } else if (beautyAdjustKey == AlaFilterAndBeautyData.BeautyAdjustKey.smooth && (bVar2 = hashMap.get(beautyAdjustKey)) != null && (zw = bVar2.zw()) != null) {
                Object obj2 = zw.get("smooth");
                if (obj2 instanceof String) {
                    try {
                        float floatValue2 = Float.valueOf((String) obj2).floatValue();
                        return bVar.aDn < floatValue2 ? (int) ((bVar.aDn / floatValue2) * 100.0f) : 100;
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
        this.aEc.add(dVar);
    }

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
    }
}

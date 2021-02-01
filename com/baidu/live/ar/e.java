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
/* loaded from: classes11.dex */
public class e extends BaseData {
    public static e aCE = new e();
    public static e aCF = new e();
    public m.a aCA;
    private HashMap<String, Integer> aCD;
    public i aCs;
    public String aCt;
    public AlaFilterAndBeautyData aCu;
    public String aCw;
    public h aCz;
    public float mFilterLevel;
    public String aCr = "";
    private HashMap<String, Integer> aCv = new HashMap<>();
    public String aCx = "1.0";
    public String aCy = "40";
    private HashMap<String, Integer> aCB = new HashMap<>();
    private ArrayList<d> aCC = new ArrayList<>();

    public e() {
        this.aCt = "";
        this.aCt = AlaFilterAndBeautyData.BeautyAdjustKey.whiten.getJsonKey();
        zu();
    }

    public String toJsonString() {
        AlaFilterAndBeautyData.BeautyAdjustKey[] values;
        JSONObject jSONObject = new JSONObject();
        try {
            for (AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey : AlaFilterAndBeautyData.BeautyAdjustKey.values()) {
                jSONObject.put(beautyAdjustKey.getJsonKey(), fe(beautyAdjustKey.getJsonKey()));
            }
            jSONObject.put("filter_name", this.aCr);
            jSONObject.put("filter_level", this.mFilterLevel);
            jSONObject.put("face_feature_type", this.aCw);
            jSONObject.put("face_feature_max_value", this.aCx);
            jSONObject.put("face_feature_default_value", this.aCy);
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry<String, Integer> entry : this.aCB.entrySet()) {
                if (!StringUtils.isNullObject(entry.getKey())) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("array_filter_file", entry.getKey());
                    jSONObject2.put("array_filter_level", entry.getValue());
                    jSONArray.put(jSONObject2);
                }
            }
            jSONObject.put("array_filter", jSONArray);
            JSONArray jSONArray2 = new JSONArray();
            for (Map.Entry<String, Integer> entry2 : this.aCv.entrySet()) {
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
                    this.aCr = jSONObject.optString("filter_name");
                    this.mFilterLevel = jSONObject.optInt("filter_level");
                }
                this.aCw = jSONObject.optString("face_feature_type");
                this.aCx = jSONObject.optString("face_feature_max_value");
                this.aCy = jSONObject.optString("face_feature_default_value");
                JSONArray optJSONArray = jSONObject.optJSONArray("array_filter");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = (JSONObject) optJSONArray.opt(i);
                        if (jSONObject2 != null && (jSONObject2.opt("array_filter_level") instanceof Integer)) {
                            this.aCB.put(jSONObject2.optString("array_filter_file"), Integer.valueOf(jSONObject2.optInt("array_filter_level")));
                        }
                    }
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("array_face_feature");
                if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                    int length2 = optJSONArray2.length();
                    for (int i2 = 0; i2 < length2; i2++) {
                        JSONObject jSONObject3 = (JSONObject) optJSONArray2.opt(i2);
                        if (jSONObject3 != null && (jSONObject3.opt("face_feature_level") instanceof Integer)) {
                            this.aCv.put(jSONObject3.optString("face_feature_type"), Integer.valueOf(jSONObject3.optInt("face_feature_level")));
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
            this.aCB.put(str, Integer.valueOf(i));
        }
    }

    public void cm(int i) {
        if (TextUtils.isEmpty(this.aCw)) {
            this.aCw = "naturalFace";
        }
        Log.d("ArUpdate", "保存在缓存  putFaceFeatureValue--faceType:" + this.aCw + ", level:" + i);
        this.aCv.put(this.aCw, Integer.valueOf(i));
    }

    public int fc(String str) {
        Log.d("ArUpdate", "获取子项值 getFilterValue jsonKey:" + str);
        if (TextUtils.isEmpty(str) || this.aCB == null || this.aCB.isEmpty()) {
            return 100;
        }
        Log.d("ArUpdate", "获取子项值 getFilterValue value:" + (this.aCB.get(str) == null ? 100 : this.aCB.get(str).intValue()));
        if (this.aCB.get(str) == null) {
            return 100;
        }
        return this.aCB.get(str).intValue();
    }

    public int fd(String str) {
        Log.d("ArUpdate", "获取子项值 getFaceFeatureValue jsonKey:" + str);
        if (TextUtils.isEmpty(str) || this.aCv == null || this.aCv.isEmpty()) {
            return 40;
        }
        Log.d("ArUpdate", "获取子项值 sFaceFeatureKeyMap value:" + (this.aCv.get(str) == null ? 40 : this.aCv.get(str).intValue()));
        if (this.aCv.get(str) == null) {
            return 40;
        }
        return this.aCv.get(str).intValue();
    }

    public int a(i iVar, List<i> list) {
        if (iVar == null || list == null || list.size() <= 0) {
            return 100;
        }
        Log.d("ArUpdate", "getFilterThreshold filterFileName:" + iVar.zx());
        for (i iVar2 : list) {
            if (iVar.zx().equals(iVar2.zx())) {
                Log.d("ArUpdate", "getFilterThreshold 阈值:" + iVar2.zA());
                return iVar2.zA();
            }
        }
        return 100;
    }

    public void a(AlaFilterAndBeautyData alaFilterAndBeautyData) {
        this.aCu = alaFilterAndBeautyData;
    }

    private void zu() {
        this.aCD = new HashMap<>();
        for (AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey : AlaFilterAndBeautyData.BeautyAdjustKey.values()) {
            this.aCD.put(beautyAdjustKey.getJsonKey(), 0);
        }
    }

    public void b(boolean z, List<h> list) {
        if (z || this.aCv.size() <= 0) {
            this.aCv = new HashMap<>();
            for (h hVar : list) {
                this.aCv.put(hVar.getType(), Integer.valueOf(hVar.zy()));
            }
        }
    }

    public void B(String str, int i) {
        if (!TextUtils.isEmpty(str)) {
            this.aCD.put(str, Integer.valueOf(i));
        }
    }

    public int fe(String str) {
        if (TextUtils.isEmpty(str) || this.aCD == null || this.aCD.isEmpty() || this.aCD.get(str) == null) {
            return 0;
        }
        return this.aCD.get(str).intValue();
    }

    public static boolean a(HashMap<AlaFilterAndBeautyData.BeautyAdjustKey, AlaFilterAndBeautyData.b> hashMap, AlaFilterAndBeautyData alaFilterAndBeautyData, JSONObject jSONObject, boolean z) {
        boolean z2;
        if (alaFilterAndBeautyData == null) {
            return false;
        }
        aCF.a(alaFilterAndBeautyData);
        aCF.r(com.baidu.live.d.xc().getString("ala_beauty_config_ar", ""), false);
        boolean z3 = com.baidu.live.d.xc().getBoolean("ala_beauty_changed_by_user", false);
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
                    aCF.B(beautyAdjustKey.getJsonKey(), a3);
                    z2 = true;
                } else {
                    z2 = z4;
                }
            } else {
                aCF.B(beautyAdjustKey.getJsonKey(), a3);
                z2 = true;
            }
            aCE.B(beautyAdjustKey.getJsonKey(), a3);
            i++;
            z4 = z2;
        }
        for (i iVar : alaFilterAndBeautyData.aCd) {
            d dVar = new d();
            dVar.a(iVar);
            aCF.a(dVar);
        }
        if (z4) {
            com.baidu.live.d.xc().putString("ala_beauty_config_ar", aCF.toJsonString());
        }
        if (z) {
            com.baidu.live.d.xc().putBoolean("ar_grading_quality_config_need_update", false);
        }
        return true;
    }

    private static int a(HashMap<AlaFilterAndBeautyData.BeautyAdjustKey, AlaFilterAndBeautyData.b> hashMap, AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey, b bVar, int i) {
        AlaFilterAndBeautyData.b bVar2;
        HashMap<String, Object> zt;
        HashMap<String, Object> zt2;
        if (hashMap != null && beautyAdjustKey != null && bVar != null) {
            if (beautyAdjustKey == AlaFilterAndBeautyData.BeautyAdjustKey.whiten) {
                AlaFilterAndBeautyData.b bVar3 = hashMap.get(beautyAdjustKey);
                if (bVar3 != null && (zt2 = bVar3.zt()) != null) {
                    Object obj = zt2.get("whiten");
                    if (obj instanceof String) {
                        try {
                            float floatValue = Float.valueOf((String) obj).floatValue();
                            return bVar.aBO >= floatValue ? 100 : (int) ((bVar.aBO / floatValue) * 100.0f);
                        } catch (NumberFormatException e) {
                            return i;
                        }
                    }
                    return i;
                }
                return i;
            } else if (beautyAdjustKey == AlaFilterAndBeautyData.BeautyAdjustKey.smooth && (bVar2 = hashMap.get(beautyAdjustKey)) != null && (zt = bVar2.zt()) != null) {
                Object obj2 = zt.get("smooth");
                if (obj2 instanceof String) {
                    try {
                        float floatValue2 = Float.valueOf((String) obj2).floatValue();
                        return bVar.aBN < floatValue2 ? (int) ((bVar.aBN / floatValue2) * 100.0f) : 100;
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
        this.aCC.add(dVar);
    }

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
    }
}

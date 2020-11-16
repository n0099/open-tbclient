package com.baidu.live.ar;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.ar.AlaFilterAndBeautyData;
import com.baidu.live.ar.l;
import com.baidu.live.tbadk.core.data.BaseData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d extends BaseData {
    public static d aCO = new d();
    public static d aCP = new d();
    public h aCC;
    public String aCD;
    public AlaFilterAndBeautyData aCE;
    public String aCG;
    public g aCJ;
    public l.a aCK;
    private HashMap<String, Integer> aCN;
    public float mFilterLevel;
    public String aCB = "";
    private HashMap<String, Integer> aCF = new HashMap<>();
    public String aCH = "1.0";
    public String aCI = "40";
    private HashMap<String, Integer> aCL = new HashMap<>();
    private ArrayList<c> aCM = new ArrayList<>();

    public d() {
        this.aCD = "";
        this.aCD = AlaFilterAndBeautyData.BeautyAdjustKey.whiten.getJsonKey();
        BI();
    }

    public String toJsonString() {
        AlaFilterAndBeautyData.BeautyAdjustKey[] values;
        JSONObject jSONObject = new JSONObject();
        try {
            for (AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey : AlaFilterAndBeautyData.BeautyAdjustKey.values()) {
                jSONObject.put(beautyAdjustKey.getJsonKey(), fS(beautyAdjustKey.getJsonKey()));
            }
            jSONObject.put("filter_name", this.aCB);
            jSONObject.put("filter_level", this.mFilterLevel);
            jSONObject.put("face_feature_type", this.aCG);
            jSONObject.put("face_feature_max_value", this.aCH);
            jSONObject.put("face_feature_default_value", this.aCI);
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry<String, Integer> entry : this.aCL.entrySet()) {
                if (!StringUtils.isNullObject(entry.getKey())) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("array_filter_file", entry.getKey());
                    jSONObject2.put("array_filter_level", entry.getValue());
                    jSONArray.put(jSONObject2);
                }
            }
            jSONObject.put("array_filter", jSONArray);
            JSONArray jSONArray2 = new JSONArray();
            for (Map.Entry<String, Integer> entry2 : this.aCF.entrySet()) {
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

    public d fP(String str) {
        AlaFilterAndBeautyData.BeautyAdjustKey[] values;
        if (!TextUtils.isEmpty(str)) {
            Log.d("ArUpdate", "parseJson jsonStr:" + str);
            try {
                JSONObject jSONObject = new JSONObject(str);
                for (AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey : AlaFilterAndBeautyData.BeautyAdjustKey.values()) {
                    z(beautyAdjustKey.getJsonKey(), jSONObject.optInt(beautyAdjustKey.getJsonKey()));
                }
                this.aCB = jSONObject.optString("filter_name");
                this.mFilterLevel = jSONObject.optInt("filter_level");
                this.aCG = jSONObject.optString("face_feature_type");
                this.aCH = jSONObject.optString("face_feature_max_value");
                this.aCI = jSONObject.optString("face_feature_default_value");
                JSONArray optJSONArray = jSONObject.optJSONArray("array_filter");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = (JSONObject) optJSONArray.opt(i);
                        if (jSONObject2 != null && (jSONObject2.opt("array_filter_level") instanceof Integer)) {
                            this.aCL.put(jSONObject2.optString("array_filter_file"), Integer.valueOf(jSONObject2.optInt("array_filter_level")));
                        }
                    }
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("array_face_feature");
                if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                    int length2 = optJSONArray2.length();
                    for (int i2 = 0; i2 < length2; i2++) {
                        JSONObject jSONObject3 = (JSONObject) optJSONArray2.opt(i2);
                        if (jSONObject3 != null && (jSONObject3.opt("face_feature_level") instanceof Integer)) {
                            this.aCF.put(jSONObject3.optString("face_feature_type"), Integer.valueOf(jSONObject3.optInt("face_feature_level")));
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
            this.aCL.put(str, Integer.valueOf(i));
        }
    }

    public void dz(int i) {
        if (TextUtils.isEmpty(this.aCG)) {
            this.aCG = "naturalFace";
        }
        Log.d("ArUpdate", "保存在缓存  putFaceFeatureValue--faceType:" + this.aCG + ", level:" + i);
        this.aCF.put(this.aCG, Integer.valueOf(i));
    }

    public int fQ(String str) {
        Log.d("ArUpdate", "获取子项值 getFilterValue jsonKey:" + str);
        if (TextUtils.isEmpty(str) || this.aCL == null || this.aCL.isEmpty()) {
            return 100;
        }
        Log.d("ArUpdate", "获取子项值 getFilterValue value:" + (this.aCL.get(str) == null ? 100 : this.aCL.get(str).intValue()));
        if (this.aCL.get(str) == null) {
            return 100;
        }
        return this.aCL.get(str).intValue();
    }

    public int fR(String str) {
        Log.d("ArUpdate", "获取子项值 getFaceFeatureValue jsonKey:" + str);
        if (TextUtils.isEmpty(str) || this.aCF == null || this.aCF.isEmpty()) {
            return 40;
        }
        Log.d("ArUpdate", "获取子项值 sFaceFeatureKeyMap value:" + (this.aCF.get(str) == null ? 40 : this.aCF.get(str).intValue()));
        if (this.aCF.get(str) == null) {
            return 40;
        }
        return this.aCF.get(str).intValue();
    }

    public int a(h hVar, List<h> list) {
        if (hVar == null || list == null || list.size() <= 0) {
            return 100;
        }
        Log.d("ArUpdate", "getFilterThreshold filterFileName:" + hVar.BL());
        for (h hVar2 : list) {
            if (hVar.BL().equals(hVar2.BL())) {
                Log.d("ArUpdate", "getFilterThreshold 阈值:" + hVar2.BO());
                return hVar2.BO();
            }
        }
        return 100;
    }

    public void a(AlaFilterAndBeautyData alaFilterAndBeautyData) {
        this.aCE = alaFilterAndBeautyData;
    }

    private void BI() {
        this.aCN = new HashMap<>();
        for (AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey : AlaFilterAndBeautyData.BeautyAdjustKey.values()) {
            this.aCN.put(beautyAdjustKey.getJsonKey(), 0);
        }
    }

    public void a(boolean z, List<g> list) {
        if (z || this.aCF.size() <= 0) {
            this.aCF = new HashMap<>();
            for (g gVar : list) {
                this.aCF.put(gVar.getType(), Integer.valueOf(gVar.BM()));
            }
        }
    }

    public void z(String str, int i) {
        if (!TextUtils.isEmpty(str)) {
            this.aCN.put(str, Integer.valueOf(i));
        }
    }

    public int fS(String str) {
        if (TextUtils.isEmpty(str) || this.aCN == null || this.aCN.isEmpty() || this.aCN.get(str) == null) {
            return 0;
        }
        return this.aCN.get(str).intValue();
    }

    public static boolean a(HashMap<AlaFilterAndBeautyData.BeautyAdjustKey, AlaFilterAndBeautyData.b> hashMap, AlaFilterAndBeautyData alaFilterAndBeautyData, JSONObject jSONObject, boolean z) {
        boolean z2;
        if (alaFilterAndBeautyData == null) {
            return false;
        }
        aCP.a(alaFilterAndBeautyData);
        aCP.fP(com.baidu.live.d.Aq().getString("ala_beauty_config_ar", ""));
        boolean z3 = com.baidu.live.d.Aq().getBoolean("ala_beauty_changed_by_user", false);
        b q = b.q(jSONObject);
        AlaFilterAndBeautyData.BeautyAdjustKey[] values = AlaFilterAndBeautyData.BeautyAdjustKey.values();
        int length = values.length;
        int i = 0;
        boolean z4 = false;
        while (i < length) {
            AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey = values[i];
            int a2 = AlaFilterAndBeautyData.a(hashMap, beautyAdjustKey);
            boolean z5 = q != null && (beautyAdjustKey == AlaFilterAndBeautyData.BeautyAdjustKey.whiten || beautyAdjustKey == AlaFilterAndBeautyData.BeautyAdjustKey.smooth) && z;
            int a3 = a(hashMap, beautyAdjustKey, q, a2);
            if (z3) {
                if (z5) {
                    aCP.z(beautyAdjustKey.getJsonKey(), a3);
                    z2 = true;
                } else {
                    z2 = z4;
                }
            } else {
                aCP.z(beautyAdjustKey.getJsonKey(), a3);
                z2 = true;
            }
            aCO.z(beautyAdjustKey.getJsonKey(), a3);
            i++;
            z4 = z2;
        }
        for (h hVar : alaFilterAndBeautyData.aCn) {
            c cVar = new c();
            cVar.a(hVar);
            aCP.a(cVar);
        }
        if (z4) {
            com.baidu.live.d.Aq().putString("ala_beauty_config_ar", aCP.toJsonString());
        }
        if (z) {
            com.baidu.live.d.Aq().putBoolean("ar_grading_quality_config_need_update", false);
        }
        return true;
    }

    private static int a(HashMap<AlaFilterAndBeautyData.BeautyAdjustKey, AlaFilterAndBeautyData.b> hashMap, AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey, b bVar, int i) {
        AlaFilterAndBeautyData.b bVar2;
        HashMap<String, Object> BH;
        HashMap<String, Object> BH2;
        if (hashMap != null && beautyAdjustKey != null && bVar != null) {
            if (beautyAdjustKey == AlaFilterAndBeautyData.BeautyAdjustKey.whiten) {
                AlaFilterAndBeautyData.b bVar3 = hashMap.get(beautyAdjustKey);
                if (bVar3 != null && (BH2 = bVar3.BH()) != null) {
                    Object obj = BH2.get("whiten");
                    if (obj instanceof String) {
                        try {
                            float floatValue = Float.valueOf((String) obj).floatValue();
                            return bVar.aBZ >= floatValue ? 100 : (int) ((bVar.aBZ / floatValue) * 100.0f);
                        } catch (NumberFormatException e) {
                            return i;
                        }
                    }
                    return i;
                }
                return i;
            } else if (beautyAdjustKey == AlaFilterAndBeautyData.BeautyAdjustKey.smooth && (bVar2 = hashMap.get(beautyAdjustKey)) != null && (BH = bVar2.BH()) != null) {
                Object obj2 = BH.get("smooth");
                if (obj2 instanceof String) {
                    try {
                        float floatValue2 = Float.valueOf((String) obj2).floatValue();
                        return bVar.aBY < floatValue2 ? (int) ((bVar.aBY / floatValue2) * 100.0f) : 100;
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
        this.aCM.add(cVar);
    }

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
    }
}

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
    public h aEn;
    public String aEo;
    public AlaFilterAndBeautyData aEp;
    public String aEr;
    public g aEu;
    public l.a aEv;
    private HashMap<String, Integer> aEy;
    public float mFilterLevel;
    public static d aEz = new d();
    public static d aEA = new d();
    public String aEm = "";
    private HashMap<String, Integer> aEq = new HashMap<>();
    public String aEs = "1.0";
    public String aEt = "40";
    private HashMap<String, Integer> aEw = new HashMap<>();
    private ArrayList<c> aEx = new ArrayList<>();

    public d() {
        this.aEo = "";
        this.aEo = AlaFilterAndBeautyData.BeautyAdjustKey.whiten.getJsonKey();
        Cr();
    }

    public String toJsonString() {
        AlaFilterAndBeautyData.BeautyAdjustKey[] values;
        JSONObject jSONObject = new JSONObject();
        try {
            for (AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey : AlaFilterAndBeautyData.BeautyAdjustKey.values()) {
                jSONObject.put(beautyAdjustKey.getJsonKey(), fY(beautyAdjustKey.getJsonKey()));
            }
            jSONObject.put("filter_name", this.aEm);
            jSONObject.put("filter_level", this.mFilterLevel);
            jSONObject.put("face_feature_type", this.aEr);
            jSONObject.put("face_feature_max_value", this.aEs);
            jSONObject.put("face_feature_default_value", this.aEt);
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry<String, Integer> entry : this.aEw.entrySet()) {
                if (!StringUtils.isNullObject(entry.getKey())) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("array_filter_file", entry.getKey());
                    jSONObject2.put("array_filter_level", entry.getValue());
                    jSONArray.put(jSONObject2);
                }
            }
            jSONObject.put("array_filter", jSONArray);
            JSONArray jSONArray2 = new JSONArray();
            for (Map.Entry<String, Integer> entry2 : this.aEq.entrySet()) {
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

    public d fV(String str) {
        AlaFilterAndBeautyData.BeautyAdjustKey[] values;
        if (!TextUtils.isEmpty(str)) {
            Log.d("ArUpdate", "parseJson jsonStr:" + str);
            try {
                JSONObject jSONObject = new JSONObject(str);
                for (AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey : AlaFilterAndBeautyData.BeautyAdjustKey.values()) {
                    z(beautyAdjustKey.getJsonKey(), jSONObject.optInt(beautyAdjustKey.getJsonKey()));
                }
                this.aEm = jSONObject.optString("filter_name");
                this.mFilterLevel = jSONObject.optInt("filter_level");
                this.aEr = jSONObject.optString("face_feature_type");
                this.aEs = jSONObject.optString("face_feature_max_value");
                this.aEt = jSONObject.optString("face_feature_default_value");
                JSONArray optJSONArray = jSONObject.optJSONArray("array_filter");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = (JSONObject) optJSONArray.opt(i);
                        if (jSONObject2 != null && (jSONObject2.opt("array_filter_level") instanceof Integer)) {
                            this.aEw.put(jSONObject2.optString("array_filter_file"), Integer.valueOf(jSONObject2.optInt("array_filter_level")));
                        }
                    }
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("array_face_feature");
                if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                    int length2 = optJSONArray2.length();
                    for (int i2 = 0; i2 < length2; i2++) {
                        JSONObject jSONObject3 = (JSONObject) optJSONArray2.opt(i2);
                        if (jSONObject3 != null && (jSONObject3.opt("face_feature_level") instanceof Integer)) {
                            this.aEq.put(jSONObject3.optString("face_feature_type"), Integer.valueOf(jSONObject3.optInt("face_feature_level")));
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
            this.aEw.put(str, Integer.valueOf(i));
        }
    }

    public void dD(int i) {
        if (TextUtils.isEmpty(this.aEr)) {
            this.aEr = "naturalFace";
        }
        Log.d("ArUpdate", "保存在缓存  putFaceFeatureValue--faceType:" + this.aEr + ", level:" + i);
        this.aEq.put(this.aEr, Integer.valueOf(i));
    }

    public int fW(String str) {
        Log.d("ArUpdate", "获取子项值 getFilterValue jsonKey:" + str);
        if (TextUtils.isEmpty(str) || this.aEw == null || this.aEw.isEmpty()) {
            return 100;
        }
        Log.d("ArUpdate", "获取子项值 getFilterValue value:" + (this.aEw.get(str) == null ? 100 : this.aEw.get(str).intValue()));
        if (this.aEw.get(str) == null) {
            return 100;
        }
        return this.aEw.get(str).intValue();
    }

    public int fX(String str) {
        Log.d("ArUpdate", "获取子项值 getFaceFeatureValue jsonKey:" + str);
        if (TextUtils.isEmpty(str) || this.aEq == null || this.aEq.isEmpty()) {
            return 40;
        }
        Log.d("ArUpdate", "获取子项值 sFaceFeatureKeyMap value:" + (this.aEq.get(str) == null ? 40 : this.aEq.get(str).intValue()));
        if (this.aEq.get(str) == null) {
            return 40;
        }
        return this.aEq.get(str).intValue();
    }

    public int a(h hVar, List<h> list) {
        if (hVar == null || list == null || list.size() <= 0) {
            return 100;
        }
        Log.d("ArUpdate", "getFilterThreshold filterFileName:" + hVar.Cu());
        for (h hVar2 : list) {
            if (hVar.Cu().equals(hVar2.Cu())) {
                Log.d("ArUpdate", "getFilterThreshold 阈值:" + hVar2.Cx());
                return hVar2.Cx();
            }
        }
        return 100;
    }

    public void a(AlaFilterAndBeautyData alaFilterAndBeautyData) {
        this.aEp = alaFilterAndBeautyData;
    }

    private void Cr() {
        this.aEy = new HashMap<>();
        for (AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey : AlaFilterAndBeautyData.BeautyAdjustKey.values()) {
            this.aEy.put(beautyAdjustKey.getJsonKey(), 0);
        }
    }

    public void a(boolean z, List<g> list) {
        if (z || this.aEq.size() <= 0) {
            this.aEq = new HashMap<>();
            for (g gVar : list) {
                this.aEq.put(gVar.getType(), Integer.valueOf(gVar.Cv()));
            }
        }
    }

    public void z(String str, int i) {
        if (!TextUtils.isEmpty(str)) {
            this.aEy.put(str, Integer.valueOf(i));
        }
    }

    public int fY(String str) {
        if (TextUtils.isEmpty(str) || this.aEy == null || this.aEy.isEmpty() || this.aEy.get(str) == null) {
            return 0;
        }
        return this.aEy.get(str).intValue();
    }

    public static boolean a(HashMap<AlaFilterAndBeautyData.BeautyAdjustKey, AlaFilterAndBeautyData.b> hashMap, AlaFilterAndBeautyData alaFilterAndBeautyData, JSONObject jSONObject, boolean z) {
        boolean z2;
        if (alaFilterAndBeautyData == null) {
            return false;
        }
        aEA.a(alaFilterAndBeautyData);
        aEA.fV(com.baidu.live.d.AZ().getString("ala_beauty_config_ar", ""));
        boolean z3 = com.baidu.live.d.AZ().getBoolean("ala_beauty_changed_by_user", false);
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
                    aEA.z(beautyAdjustKey.getJsonKey(), a3);
                    z2 = true;
                } else {
                    z2 = z4;
                }
            } else {
                aEA.z(beautyAdjustKey.getJsonKey(), a3);
                z2 = true;
            }
            aEz.z(beautyAdjustKey.getJsonKey(), a3);
            i++;
            z4 = z2;
        }
        for (h hVar : alaFilterAndBeautyData.aDY) {
            c cVar = new c();
            cVar.a(hVar);
            aEA.a(cVar);
        }
        if (z4) {
            com.baidu.live.d.AZ().putString("ala_beauty_config_ar", aEA.toJsonString());
        }
        if (z) {
            com.baidu.live.d.AZ().putBoolean("ar_grading_quality_config_need_update", false);
        }
        return true;
    }

    private static int a(HashMap<AlaFilterAndBeautyData.BeautyAdjustKey, AlaFilterAndBeautyData.b> hashMap, AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey, b bVar, int i) {
        AlaFilterAndBeautyData.b bVar2;
        HashMap<String, Object> Cq;
        HashMap<String, Object> Cq2;
        if (hashMap != null && beautyAdjustKey != null && bVar != null) {
            if (beautyAdjustKey == AlaFilterAndBeautyData.BeautyAdjustKey.whiten) {
                AlaFilterAndBeautyData.b bVar3 = hashMap.get(beautyAdjustKey);
                if (bVar3 != null && (Cq2 = bVar3.Cq()) != null) {
                    Object obj = Cq2.get("whiten");
                    if (obj instanceof String) {
                        try {
                            float floatValue = Float.valueOf((String) obj).floatValue();
                            return bVar.aDK >= floatValue ? 100 : (int) ((bVar.aDK / floatValue) * 100.0f);
                        } catch (NumberFormatException e) {
                            return i;
                        }
                    }
                    return i;
                }
                return i;
            } else if (beautyAdjustKey == AlaFilterAndBeautyData.BeautyAdjustKey.smooth && (bVar2 = hashMap.get(beautyAdjustKey)) != null && (Cq = bVar2.Cq()) != null) {
                Object obj2 = Cq.get("smooth");
                if (obj2 instanceof String) {
                    try {
                        float floatValue2 = Float.valueOf((String) obj2).floatValue();
                        return bVar.aDJ < floatValue2 ? (int) ((bVar.aDJ / floatValue2) * 100.0f) : 100;
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
        this.aEx.add(cVar);
    }

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
    }
}

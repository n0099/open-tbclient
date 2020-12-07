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
    public static d aFu = new d();
    public static d aFv = new d();
    public h aFi;
    public String aFj;
    public AlaFilterAndBeautyData aFk;
    public String aFm;
    public g aFp;
    public l.a aFq;
    private HashMap<String, Integer> aFt;
    public float mFilterLevel;
    public String aFh = "";
    private HashMap<String, Integer> aFl = new HashMap<>();
    public String aFn = "1.0";
    public String aFo = "40";
    private HashMap<String, Integer> aFr = new HashMap<>();
    private ArrayList<c> aFs = new ArrayList<>();

    public d() {
        this.aFj = "";
        this.aFj = AlaFilterAndBeautyData.BeautyAdjustKey.whiten.getJsonKey();
        Ds();
    }

    public String toJsonString() {
        AlaFilterAndBeautyData.BeautyAdjustKey[] values;
        JSONObject jSONObject = new JSONObject();
        try {
            for (AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey : AlaFilterAndBeautyData.BeautyAdjustKey.values()) {
                jSONObject.put(beautyAdjustKey.getJsonKey(), gn(beautyAdjustKey.getJsonKey()));
            }
            jSONObject.put("filter_name", this.aFh);
            jSONObject.put("filter_level", this.mFilterLevel);
            jSONObject.put("face_feature_type", this.aFm);
            jSONObject.put("face_feature_max_value", this.aFn);
            jSONObject.put("face_feature_default_value", this.aFo);
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry<String, Integer> entry : this.aFr.entrySet()) {
                if (!StringUtils.isNullObject(entry.getKey())) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("array_filter_file", entry.getKey());
                    jSONObject2.put("array_filter_level", entry.getValue());
                    jSONArray.put(jSONObject2);
                }
            }
            jSONObject.put("array_filter", jSONArray);
            JSONArray jSONArray2 = new JSONArray();
            for (Map.Entry<String, Integer> entry2 : this.aFl.entrySet()) {
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

    public d r(String str, boolean z) {
        AlaFilterAndBeautyData.BeautyAdjustKey[] values;
        if (!TextUtils.isEmpty(str)) {
            Log.d("ArUpdate", "parseJson jsonStr:" + str);
            try {
                JSONObject jSONObject = new JSONObject(str);
                for (AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey : AlaFilterAndBeautyData.BeautyAdjustKey.values()) {
                    B(beautyAdjustKey.getJsonKey(), jSONObject.optInt(beautyAdjustKey.getJsonKey()));
                }
                if (!z) {
                    this.aFh = jSONObject.optString("filter_name");
                    this.mFilterLevel = jSONObject.optInt("filter_level");
                }
                this.aFm = jSONObject.optString("face_feature_type");
                this.aFn = jSONObject.optString("face_feature_max_value");
                this.aFo = jSONObject.optString("face_feature_default_value");
                JSONArray optJSONArray = jSONObject.optJSONArray("array_filter");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = (JSONObject) optJSONArray.opt(i);
                        if (jSONObject2 != null && (jSONObject2.opt("array_filter_level") instanceof Integer)) {
                            this.aFr.put(jSONObject2.optString("array_filter_file"), Integer.valueOf(jSONObject2.optInt("array_filter_level")));
                        }
                    }
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("array_face_feature");
                if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                    int length2 = optJSONArray2.length();
                    for (int i2 = 0; i2 < length2; i2++) {
                        JSONObject jSONObject3 = (JSONObject) optJSONArray2.opt(i2);
                        if (jSONObject3 != null && (jSONObject3.opt("face_feature_level") instanceof Integer)) {
                            this.aFl.put(jSONObject3.optString("face_feature_type"), Integer.valueOf(jSONObject3.optInt("face_feature_level")));
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
            this.aFr.put(str, Integer.valueOf(i));
        }
    }

    public void dS(int i) {
        if (TextUtils.isEmpty(this.aFm)) {
            this.aFm = "naturalFace";
        }
        Log.d("ArUpdate", "保存在缓存  putFaceFeatureValue--faceType:" + this.aFm + ", level:" + i);
        this.aFl.put(this.aFm, Integer.valueOf(i));
    }

    public int gl(String str) {
        Log.d("ArUpdate", "获取子项值 getFilterValue jsonKey:" + str);
        if (TextUtils.isEmpty(str) || this.aFr == null || this.aFr.isEmpty()) {
            return 100;
        }
        Log.d("ArUpdate", "获取子项值 getFilterValue value:" + (this.aFr.get(str) == null ? 100 : this.aFr.get(str).intValue()));
        if (this.aFr.get(str) == null) {
            return 100;
        }
        return this.aFr.get(str).intValue();
    }

    public int gm(String str) {
        Log.d("ArUpdate", "获取子项值 getFaceFeatureValue jsonKey:" + str);
        if (TextUtils.isEmpty(str) || this.aFl == null || this.aFl.isEmpty()) {
            return 40;
        }
        Log.d("ArUpdate", "获取子项值 sFaceFeatureKeyMap value:" + (this.aFl.get(str) == null ? 40 : this.aFl.get(str).intValue()));
        if (this.aFl.get(str) == null) {
            return 40;
        }
        return this.aFl.get(str).intValue();
    }

    public int a(h hVar, List<h> list) {
        if (hVar == null || list == null || list.size() <= 0) {
            return 100;
        }
        Log.d("ArUpdate", "getFilterThreshold filterFileName:" + hVar.Dv());
        for (h hVar2 : list) {
            if (hVar.Dv().equals(hVar2.Dv())) {
                Log.d("ArUpdate", "getFilterThreshold 阈值:" + hVar2.Dy());
                return hVar2.Dy();
            }
        }
        return 100;
    }

    public void a(AlaFilterAndBeautyData alaFilterAndBeautyData) {
        this.aFk = alaFilterAndBeautyData;
    }

    private void Ds() {
        this.aFt = new HashMap<>();
        for (AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey : AlaFilterAndBeautyData.BeautyAdjustKey.values()) {
            this.aFt.put(beautyAdjustKey.getJsonKey(), 0);
        }
    }

    public void a(boolean z, List<g> list) {
        if (z || this.aFl.size() <= 0) {
            this.aFl = new HashMap<>();
            for (g gVar : list) {
                this.aFl.put(gVar.getType(), Integer.valueOf(gVar.Dw()));
            }
        }
    }

    public void B(String str, int i) {
        if (!TextUtils.isEmpty(str)) {
            this.aFt.put(str, Integer.valueOf(i));
        }
    }

    public int gn(String str) {
        if (TextUtils.isEmpty(str) || this.aFt == null || this.aFt.isEmpty() || this.aFt.get(str) == null) {
            return 0;
        }
        return this.aFt.get(str).intValue();
    }

    public static boolean a(HashMap<AlaFilterAndBeautyData.BeautyAdjustKey, AlaFilterAndBeautyData.b> hashMap, AlaFilterAndBeautyData alaFilterAndBeautyData, JSONObject jSONObject, boolean z) {
        boolean z2;
        if (alaFilterAndBeautyData == null) {
            return false;
        }
        aFv.a(alaFilterAndBeautyData);
        aFv.r(com.baidu.live.d.BM().getString("ala_beauty_config_ar", ""), false);
        boolean z3 = com.baidu.live.d.BM().getBoolean("ala_beauty_changed_by_user", false);
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
                    aFv.B(beautyAdjustKey.getJsonKey(), a3);
                    z2 = true;
                } else {
                    z2 = z4;
                }
            } else {
                aFv.B(beautyAdjustKey.getJsonKey(), a3);
                z2 = true;
            }
            aFu.B(beautyAdjustKey.getJsonKey(), a3);
            i++;
            z4 = z2;
        }
        for (h hVar : alaFilterAndBeautyData.aET) {
            c cVar = new c();
            cVar.a(hVar);
            aFv.a(cVar);
        }
        if (z4) {
            com.baidu.live.d.BM().putString("ala_beauty_config_ar", aFv.toJsonString());
        }
        if (z) {
            com.baidu.live.d.BM().putBoolean("ar_grading_quality_config_need_update", false);
        }
        return true;
    }

    private static int a(HashMap<AlaFilterAndBeautyData.BeautyAdjustKey, AlaFilterAndBeautyData.b> hashMap, AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey, b bVar, int i) {
        AlaFilterAndBeautyData.b bVar2;
        HashMap<String, Object> Dr;
        HashMap<String, Object> Dr2;
        if (hashMap != null && beautyAdjustKey != null && bVar != null) {
            if (beautyAdjustKey == AlaFilterAndBeautyData.BeautyAdjustKey.whiten) {
                AlaFilterAndBeautyData.b bVar3 = hashMap.get(beautyAdjustKey);
                if (bVar3 != null && (Dr2 = bVar3.Dr()) != null) {
                    Object obj = Dr2.get("whiten");
                    if (obj instanceof String) {
                        try {
                            float floatValue = Float.valueOf((String) obj).floatValue();
                            return bVar.aEF >= floatValue ? 100 : (int) ((bVar.aEF / floatValue) * 100.0f);
                        } catch (NumberFormatException e) {
                            return i;
                        }
                    }
                    return i;
                }
                return i;
            } else if (beautyAdjustKey == AlaFilterAndBeautyData.BeautyAdjustKey.smooth && (bVar2 = hashMap.get(beautyAdjustKey)) != null && (Dr = bVar2.Dr()) != null) {
                Object obj2 = Dr.get("smooth");
                if (obj2 instanceof String) {
                    try {
                        float floatValue2 = Float.valueOf((String) obj2).floatValue();
                        return bVar.aEE < floatValue2 ? (int) ((bVar.aEE / floatValue2) * 100.0f) : 100;
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
        this.aFs.add(cVar);
    }

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
    }
}

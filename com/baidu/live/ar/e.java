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
    public static e aFM = new e();
    public static e aFN = new e();
    public i aFA;
    public String aFB;
    public AlaFilterAndBeautyData aFC;
    public String aFE;
    public h aFH;
    public m.a aFI;
    private HashMap<String, Integer> aFL;
    public float mFilterLevel;
    public String aFz = "";
    private HashMap<String, Integer> aFD = new HashMap<>();
    public String aFF = "1.0";
    public String aFG = "40";
    private HashMap<String, Integer> aFJ = new HashMap<>();
    private ArrayList<d> aFK = new ArrayList<>();

    public e() {
        this.aFB = "";
        this.aFB = AlaFilterAndBeautyData.BeautyAdjustKey.whiten.getJsonKey();
        CI();
    }

    public String toJsonString() {
        AlaFilterAndBeautyData.BeautyAdjustKey[] values;
        JSONObject jSONObject = new JSONObject();
        try {
            for (AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey : AlaFilterAndBeautyData.BeautyAdjustKey.values()) {
                jSONObject.put(beautyAdjustKey.getJsonKey(), fX(beautyAdjustKey.getJsonKey()));
            }
            jSONObject.put("filter_name", this.aFz);
            jSONObject.put("filter_level", this.mFilterLevel);
            jSONObject.put("face_feature_type", this.aFE);
            jSONObject.put("face_feature_max_value", this.aFF);
            jSONObject.put("face_feature_default_value", this.aFG);
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry<String, Integer> entry : this.aFJ.entrySet()) {
                if (!StringUtils.isNullObject(entry.getKey())) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("array_filter_file", entry.getKey());
                    jSONObject2.put("array_filter_level", entry.getValue());
                    jSONArray.put(jSONObject2);
                }
            }
            jSONObject.put("array_filter", jSONArray);
            JSONArray jSONArray2 = new JSONArray();
            for (Map.Entry<String, Integer> entry2 : this.aFD.entrySet()) {
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
                    this.aFz = jSONObject.optString("filter_name");
                    this.mFilterLevel = jSONObject.optInt("filter_level");
                }
                this.aFE = jSONObject.optString("face_feature_type");
                this.aFF = jSONObject.optString("face_feature_max_value");
                this.aFG = jSONObject.optString("face_feature_default_value");
                JSONArray optJSONArray = jSONObject.optJSONArray("array_filter");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = (JSONObject) optJSONArray.opt(i);
                        if (jSONObject2 != null && (jSONObject2.opt("array_filter_level") instanceof Integer)) {
                            this.aFJ.put(jSONObject2.optString("array_filter_file"), Integer.valueOf(jSONObject2.optInt("array_filter_level")));
                        }
                    }
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("array_face_feature");
                if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                    int length2 = optJSONArray2.length();
                    for (int i2 = 0; i2 < length2; i2++) {
                        JSONObject jSONObject3 = (JSONObject) optJSONArray2.opt(i2);
                        if (jSONObject3 != null && (jSONObject3.opt("face_feature_level") instanceof Integer)) {
                            this.aFD.put(jSONObject3.optString("face_feature_type"), Integer.valueOf(jSONObject3.optInt("face_feature_level")));
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
            this.aFJ.put(str, Integer.valueOf(i));
        }
    }

    public void dP(int i) {
        if (TextUtils.isEmpty(this.aFE)) {
            this.aFE = "naturalFace";
        }
        Log.d("ArUpdate", "保存在缓存  putFaceFeatureValue--faceType:" + this.aFE + ", level:" + i);
        this.aFD.put(this.aFE, Integer.valueOf(i));
    }

    public int fV(String str) {
        Log.d("ArUpdate", "获取子项值 getFilterValue jsonKey:" + str);
        if (TextUtils.isEmpty(str) || this.aFJ == null || this.aFJ.isEmpty()) {
            return 100;
        }
        Log.d("ArUpdate", "获取子项值 getFilterValue value:" + (this.aFJ.get(str) == null ? 100 : this.aFJ.get(str).intValue()));
        if (this.aFJ.get(str) == null) {
            return 100;
        }
        return this.aFJ.get(str).intValue();
    }

    public int fW(String str) {
        Log.d("ArUpdate", "获取子项值 getFaceFeatureValue jsonKey:" + str);
        if (TextUtils.isEmpty(str) || this.aFD == null || this.aFD.isEmpty()) {
            return 40;
        }
        Log.d("ArUpdate", "获取子项值 sFaceFeatureKeyMap value:" + (this.aFD.get(str) == null ? 40 : this.aFD.get(str).intValue()));
        if (this.aFD.get(str) == null) {
            return 40;
        }
        return this.aFD.get(str).intValue();
    }

    public int a(i iVar, List<i> list) {
        if (iVar == null || list == null || list.size() <= 0) {
            return 100;
        }
        Log.d("ArUpdate", "getFilterThreshold filterFileName:" + iVar.CL());
        for (i iVar2 : list) {
            if (iVar.CL().equals(iVar2.CL())) {
                Log.d("ArUpdate", "getFilterThreshold 阈值:" + iVar2.CO());
                return iVar2.CO();
            }
        }
        return 100;
    }

    public void a(AlaFilterAndBeautyData alaFilterAndBeautyData) {
        this.aFC = alaFilterAndBeautyData;
    }

    private void CI() {
        this.aFL = new HashMap<>();
        for (AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey : AlaFilterAndBeautyData.BeautyAdjustKey.values()) {
            this.aFL.put(beautyAdjustKey.getJsonKey(), 0);
        }
    }

    public void b(boolean z, List<h> list) {
        if (z || this.aFD.size() <= 0) {
            this.aFD = new HashMap<>();
            for (h hVar : list) {
                this.aFD.put(hVar.getType(), Integer.valueOf(hVar.CM()));
            }
        }
    }

    public void B(String str, int i) {
        if (!TextUtils.isEmpty(str)) {
            this.aFL.put(str, Integer.valueOf(i));
        }
    }

    public int fX(String str) {
        if (TextUtils.isEmpty(str) || this.aFL == null || this.aFL.isEmpty() || this.aFL.get(str) == null) {
            return 0;
        }
        return this.aFL.get(str).intValue();
    }

    public static boolean a(HashMap<AlaFilterAndBeautyData.BeautyAdjustKey, AlaFilterAndBeautyData.b> hashMap, AlaFilterAndBeautyData alaFilterAndBeautyData, JSONObject jSONObject, boolean z) {
        boolean z2;
        if (alaFilterAndBeautyData == null) {
            return false;
        }
        aFN.a(alaFilterAndBeautyData);
        aFN.r(com.baidu.live.d.Ba().getString("ala_beauty_config_ar", ""), false);
        boolean z3 = com.baidu.live.d.Ba().getBoolean("ala_beauty_changed_by_user", false);
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
                    aFN.B(beautyAdjustKey.getJsonKey(), a3);
                    z2 = true;
                } else {
                    z2 = z4;
                }
            } else {
                aFN.B(beautyAdjustKey.getJsonKey(), a3);
                z2 = true;
            }
            aFM.B(beautyAdjustKey.getJsonKey(), a3);
            i++;
            z4 = z2;
        }
        for (i iVar : alaFilterAndBeautyData.aFl) {
            d dVar = new d();
            dVar.a(iVar);
            aFN.a(dVar);
        }
        if (z4) {
            com.baidu.live.d.Ba().putString("ala_beauty_config_ar", aFN.toJsonString());
        }
        if (z) {
            com.baidu.live.d.Ba().putBoolean("ar_grading_quality_config_need_update", false);
        }
        return true;
    }

    private static int a(HashMap<AlaFilterAndBeautyData.BeautyAdjustKey, AlaFilterAndBeautyData.b> hashMap, AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey, b bVar, int i) {
        AlaFilterAndBeautyData.b bVar2;
        HashMap<String, Object> CH;
        HashMap<String, Object> CH2;
        if (hashMap != null && beautyAdjustKey != null && bVar != null) {
            if (beautyAdjustKey == AlaFilterAndBeautyData.BeautyAdjustKey.whiten) {
                AlaFilterAndBeautyData.b bVar3 = hashMap.get(beautyAdjustKey);
                if (bVar3 != null && (CH2 = bVar3.CH()) != null) {
                    Object obj = CH2.get("whiten");
                    if (obj instanceof String) {
                        try {
                            float floatValue = Float.valueOf((String) obj).floatValue();
                            return bVar.aEW >= floatValue ? 100 : (int) ((bVar.aEW / floatValue) * 100.0f);
                        } catch (NumberFormatException e) {
                            return i;
                        }
                    }
                    return i;
                }
                return i;
            } else if (beautyAdjustKey == AlaFilterAndBeautyData.BeautyAdjustKey.smooth && (bVar2 = hashMap.get(beautyAdjustKey)) != null && (CH = bVar2.CH()) != null) {
                Object obj2 = CH.get("smooth");
                if (obj2 instanceof String) {
                    try {
                        float floatValue2 = Float.valueOf((String) obj2).floatValue();
                        return bVar.aEV < floatValue2 ? (int) ((bVar.aEV / floatValue2) * 100.0f) : 100;
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
        this.aFK.add(dVar);
    }

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
    }
}

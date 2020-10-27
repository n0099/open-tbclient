package com.baidu.live.ar;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.ar.AlaFilterAndBeautyData;
import com.baidu.live.ar.k;
import com.baidu.live.tbadk.core.data.BaseData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d extends BaseData {
    public static d aDS = new d();
    public static d aDT = new d();
    public g aDG;
    public String aDH;
    public AlaFilterAndBeautyData aDI;
    public String aDK;
    public f aDN;
    public k.a aDO;
    private HashMap<String, Integer> aDR;
    public float mFilterLevel;
    public String aDF = "";
    private HashMap<String, Integer> aDJ = new HashMap<>();
    public String aDL = "1.0";
    public String aDM = "40";
    private HashMap<String, Integer> aDP = new HashMap<>();
    private ArrayList<c> aDQ = new ArrayList<>();

    public d() {
        this.aDH = "";
        this.aDH = AlaFilterAndBeautyData.BeautyAdjustKey.whiten.getJsonKey();
        BZ();
    }

    public String toJsonString() {
        AlaFilterAndBeautyData.BeautyAdjustKey[] values;
        JSONObject jSONObject = new JSONObject();
        try {
            for (AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey : AlaFilterAndBeautyData.BeautyAdjustKey.values()) {
                jSONObject.put(beautyAdjustKey.getJsonKey(), fU(beautyAdjustKey.getJsonKey()));
            }
            jSONObject.put("filter_name", this.aDF);
            jSONObject.put("filter_level", this.mFilterLevel);
            jSONObject.put("face_feature_type", this.aDK);
            jSONObject.put("face_feature_max_value", this.aDL);
            jSONObject.put("face_feature_default_value", this.aDM);
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry<String, Integer> entry : this.aDP.entrySet()) {
                if (!StringUtils.isNullObject(entry.getKey())) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("array_filter_file", entry.getKey());
                    jSONObject2.put("array_filter_level", entry.getValue());
                    jSONArray.put(jSONObject2);
                }
            }
            jSONObject.put("array_filter", jSONArray);
            JSONArray jSONArray2 = new JSONArray();
            for (Map.Entry<String, Integer> entry2 : this.aDJ.entrySet()) {
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

    public d fR(String str) {
        AlaFilterAndBeautyData.BeautyAdjustKey[] values;
        if (!TextUtils.isEmpty(str)) {
            Log.d("ArUpdate", "parseJson jsonStr:" + str);
            try {
                JSONObject jSONObject = new JSONObject(str);
                for (AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey : AlaFilterAndBeautyData.BeautyAdjustKey.values()) {
                    z(beautyAdjustKey.getJsonKey(), jSONObject.optInt(beautyAdjustKey.getJsonKey()));
                }
                this.aDF = jSONObject.optString("filter_name");
                this.mFilterLevel = jSONObject.optInt("filter_level");
                this.aDK = jSONObject.optString("face_feature_type");
                this.aDL = jSONObject.optString("face_feature_max_value");
                this.aDM = jSONObject.optString("face_feature_default_value");
                JSONArray optJSONArray = jSONObject.optJSONArray("array_filter");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = (JSONObject) optJSONArray.opt(i);
                        if (jSONObject2 != null && (jSONObject2.opt("array_filter_level") instanceof Integer)) {
                            this.aDP.put(jSONObject2.optString("array_filter_file"), Integer.valueOf(jSONObject2.optInt("array_filter_level")));
                        }
                    }
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("array_face_feature");
                if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                    int length2 = optJSONArray2.length();
                    for (int i2 = 0; i2 < length2; i2++) {
                        JSONObject jSONObject3 = (JSONObject) optJSONArray2.opt(i2);
                        if (jSONObject3 != null && (jSONObject3.opt("face_feature_level") instanceof Integer)) {
                            this.aDJ.put(jSONObject3.optString("face_feature_type"), Integer.valueOf(jSONObject3.optInt("face_feature_level")));
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
            this.aDP.put(str, Integer.valueOf(i));
        }
    }

    public void dD(int i) {
        if (TextUtils.isEmpty(this.aDK)) {
            this.aDK = "naturalFace";
        }
        Log.d("ArUpdate", "保存在缓存  putFaceFeatureValue--faceType:" + this.aDK + ", level:" + i);
        this.aDJ.put(this.aDK, Integer.valueOf(i));
    }

    public int fS(String str) {
        Log.d("ArUpdate", "获取子项值 getFilterValue jsonKey:" + str);
        if (TextUtils.isEmpty(str) || this.aDP == null || this.aDP.isEmpty()) {
            return 100;
        }
        Log.d("ArUpdate", "获取子项值 getFilterValue value:" + (this.aDP.get(str) == null ? 100 : this.aDP.get(str).intValue()));
        if (this.aDP.get(str) == null) {
            return 100;
        }
        return this.aDP.get(str).intValue();
    }

    public int fT(String str) {
        Log.d("ArUpdate", "获取子项值 getFaceFeatureValue jsonKey:" + str);
        if (TextUtils.isEmpty(str) || this.aDJ == null || this.aDJ.isEmpty()) {
            return 40;
        }
        Log.d("ArUpdate", "获取子项值 sFaceFeatureKeyMap value:" + (this.aDJ.get(str) == null ? 40 : this.aDJ.get(str).intValue()));
        if (this.aDJ.get(str) == null) {
            return 40;
        }
        return this.aDJ.get(str).intValue();
    }

    public int a(g gVar, List<g> list) {
        if (gVar == null || list == null || list.size() <= 0) {
            return 100;
        }
        Log.d("ArUpdate", "getFilterThreshold filterFileName:" + gVar.Cc());
        for (g gVar2 : list) {
            if (gVar.Cc().equals(gVar2.Cc())) {
                Log.d("ArUpdate", "getFilterThreshold 阈值:" + gVar2.Cf());
                return gVar2.Cf();
            }
        }
        return 100;
    }

    public void a(AlaFilterAndBeautyData alaFilterAndBeautyData) {
        this.aDI = alaFilterAndBeautyData;
    }

    private void BZ() {
        this.aDR = new HashMap<>();
        for (AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey : AlaFilterAndBeautyData.BeautyAdjustKey.values()) {
            this.aDR.put(beautyAdjustKey.getJsonKey(), 0);
        }
    }

    public void a(boolean z, List<f> list) {
        if (z || this.aDJ.size() <= 0) {
            this.aDJ = new HashMap<>();
            for (f fVar : list) {
                this.aDJ.put(fVar.getType(), Integer.valueOf(fVar.Cd()));
            }
        }
    }

    public void z(String str, int i) {
        if (!TextUtils.isEmpty(str)) {
            this.aDR.put(str, Integer.valueOf(i));
        }
    }

    public int fU(String str) {
        if (TextUtils.isEmpty(str) || this.aDR == null || this.aDR.isEmpty() || this.aDR.get(str) == null) {
            return 0;
        }
        return this.aDR.get(str).intValue();
    }

    public static boolean a(HashMap<AlaFilterAndBeautyData.BeautyAdjustKey, AlaFilterAndBeautyData.b> hashMap, AlaFilterAndBeautyData alaFilterAndBeautyData, JSONObject jSONObject, boolean z) {
        boolean z2;
        if (alaFilterAndBeautyData == null) {
            return false;
        }
        aDT.a(alaFilterAndBeautyData);
        aDT.fR(com.baidu.live.d.AZ().getString("ala_beauty_config_ar", ""));
        boolean z3 = com.baidu.live.d.AZ().getBoolean("ala_beauty_changed_by_user", false);
        b t = b.t(jSONObject);
        AlaFilterAndBeautyData.BeautyAdjustKey[] values = AlaFilterAndBeautyData.BeautyAdjustKey.values();
        int length = values.length;
        int i = 0;
        boolean z4 = false;
        while (i < length) {
            AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey = values[i];
            int a2 = AlaFilterAndBeautyData.a(hashMap, beautyAdjustKey);
            boolean z5 = t != null && (beautyAdjustKey == AlaFilterAndBeautyData.BeautyAdjustKey.whiten || beautyAdjustKey == AlaFilterAndBeautyData.BeautyAdjustKey.smooth) && z;
            int a3 = a(hashMap, beautyAdjustKey, t, a2);
            if (z3) {
                if (z5) {
                    aDT.z(beautyAdjustKey.getJsonKey(), a3);
                    z2 = true;
                } else {
                    z2 = z4;
                }
            } else {
                aDT.z(beautyAdjustKey.getJsonKey(), a3);
                z2 = true;
            }
            aDS.z(beautyAdjustKey.getJsonKey(), a3);
            i++;
            z4 = z2;
        }
        for (g gVar : alaFilterAndBeautyData.aDr) {
            c cVar = new c();
            cVar.a(gVar);
            aDT.a(cVar);
        }
        if (z4) {
            com.baidu.live.d.AZ().putString("ala_beauty_config_ar", aDT.toJsonString());
        }
        if (z) {
            com.baidu.live.d.AZ().putBoolean("ar_grading_quality_config_need_update", false);
        }
        return true;
    }

    private static int a(HashMap<AlaFilterAndBeautyData.BeautyAdjustKey, AlaFilterAndBeautyData.b> hashMap, AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey, b bVar, int i) {
        AlaFilterAndBeautyData.b bVar2;
        HashMap<String, Object> BY;
        HashMap<String, Object> BY2;
        if (hashMap != null && beautyAdjustKey != null && bVar != null) {
            if (beautyAdjustKey == AlaFilterAndBeautyData.BeautyAdjustKey.whiten) {
                AlaFilterAndBeautyData.b bVar3 = hashMap.get(beautyAdjustKey);
                if (bVar3 != null && (BY2 = bVar3.BY()) != null) {
                    Object obj = BY2.get("whiten");
                    if (obj instanceof String) {
                        try {
                            float floatValue = Float.valueOf((String) obj).floatValue();
                            return bVar.aDd >= floatValue ? 100 : (int) ((bVar.aDd / floatValue) * 100.0f);
                        } catch (NumberFormatException e) {
                            return i;
                        }
                    }
                    return i;
                }
                return i;
            } else if (beautyAdjustKey == AlaFilterAndBeautyData.BeautyAdjustKey.smooth && (bVar2 = hashMap.get(beautyAdjustKey)) != null && (BY = bVar2.BY()) != null) {
                Object obj2 = BY.get("smooth");
                if (obj2 instanceof String) {
                    try {
                        float floatValue2 = Float.valueOf((String) obj2).floatValue();
                        return bVar.aDc < floatValue2 ? (int) ((bVar.aDc / floatValue2) * 100.0f) : 100;
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
        this.aDQ.add(cVar);
    }

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
    }
}

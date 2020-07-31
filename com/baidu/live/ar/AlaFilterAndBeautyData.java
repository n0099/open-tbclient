package com.baidu.live.ar;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.tbadk.core.data.BaseData;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.img.effect.FilterImageAction;
import com.baidu.pass.biometrics.face.liveness.stat.LivenessStat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaFilterAndBeautyData extends BaseData {
    public static HashMap<BeautyAdjustKey, b> auD = new HashMap<>();
    public String auB;
    public String auC;
    public BdUniqueId auE;
    public boolean auF;
    public String auw;
    public a aux;
    public List<f> auy = new ArrayList();
    public List<e> auz = new ArrayList();
    public ConcurrentHashMap<String, Object> auA = new ConcurrentHashMap<>();

    /* loaded from: classes4.dex */
    public static class a {
        public int auG;
        public int auH;
        public int auI;
        public String mText;
    }

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.auw = jSONObject.optString("ar_token");
            JSONObject optJSONObject = jSONObject.optJSONObject("bubble");
            if (optJSONObject != null) {
                this.aux = new a();
                this.aux.auG = optJSONObject.optInt("is_show");
                this.aux.mText = optJSONObject.optString("text");
                this.aux.auH = optJSONObject.optInt("subitem_red_dot");
                this.aux.auI = optJSONObject.optInt("beauty_tab_red_dot");
            }
            JSONArray optJSONArray = jSONObject.optJSONArray(FilterImageAction.ACTION_NAME);
            if (optJSONArray != null && optJSONArray.length() > 0) {
                int length = optJSONArray.length();
                ListUtils.clear(this.auy);
                for (int i = 0; i < length; i++) {
                    JSONObject jSONObject2 = (JSONObject) optJSONArray.opt(i);
                    if (jSONObject2 != null) {
                        f fVar = new f();
                        fVar.parseJson(jSONObject2);
                        this.auy.add(fVar);
                    }
                }
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("ARBeauty");
            if (optJSONObject2 != null) {
                JSONObject optJSONObject3 = optJSONObject2.optJSONObject("default");
                this.auB = optJSONObject3.optString("file");
                this.auC = optJSONObject3.optString("file_token");
                this.auA.clear();
                this.auA.putAll(t(optJSONObject3));
                JSONObject optJSONObject4 = optJSONObject2.optJSONObject("adjust");
                if (optJSONObject4 != null) {
                    auD.clear();
                    int length2 = BeautyAdjustKey.values().length;
                    for (int i2 = 0; i2 < length2; i2++) {
                        JSONObject optJSONObject5 = optJSONObject4.optJSONObject(BeautyAdjustKey.values()[i2].getKey());
                        if (optJSONObject5 != null) {
                            b bVar = new b();
                            bVar.bH(optJSONObject5.optInt("current"));
                            bVar.x(t(optJSONObject5.optJSONObject("subitems")));
                            auD.put(BeautyAdjustKey.values()[i2], bVar);
                        }
                    }
                }
                JSONArray optJSONArray2 = optJSONObject2.optJSONArray("face_feature");
                if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                    int length3 = optJSONArray2.length();
                    ListUtils.clear(this.auz);
                    for (int i3 = 0; i3 < length3; i3++) {
                        JSONObject jSONObject3 = (JSONObject) optJSONArray2.opt(i3);
                        if (jSONObject3 != null) {
                            e eVar = new e();
                            eVar.parseJson(jSONObject3);
                            this.auz.add(eVar);
                        }
                    }
                }
            }
        }
    }

    private static HashMap<String, Object> t(JSONObject jSONObject) {
        HashMap<String, Object> hashMap = new HashMap<>();
        if (jSONObject != null) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, jSONObject.opt(next));
            }
        }
        return hashMap;
    }

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
    }

    /* loaded from: classes4.dex */
    public static class b {
        int auJ;
        HashMap<String, Object> auK;

        public int vn() {
            return this.auJ;
        }

        public void bH(int i) {
            this.auJ = i;
        }

        public HashMap<String, Object> vo() {
            return this.auK;
        }

        public void x(HashMap<String, Object> hashMap) {
            this.auK = hashMap;
        }
    }

    public static int a(HashMap<BeautyAdjustKey, b> hashMap, BeautyAdjustKey beautyAdjustKey) {
        if (hashMap == null || beautyAdjustKey == null || hashMap.get(beautyAdjustKey) == null) {
            return 0;
        }
        return hashMap.get(beautyAdjustKey).auJ;
    }

    public static BeautyAdjustKey eh(String str) {
        BeautyAdjustKey[] values;
        for (BeautyAdjustKey beautyAdjustKey : BeautyAdjustKey.values()) {
            if (beautyAdjustKey.getJsonKey().equals(str)) {
                return beautyAdjustKey;
            }
        }
        return null;
    }

    /* loaded from: classes4.dex */
    public enum BeautyAdjustKey {
        whiten("whiten_slider", "white_percent"),
        smooth("smooth_slider", "blur_level"),
        eye("eye_slider", "big_eye"),
        thinFace("thinFace_slider", "thin_face"),
        chin("chin_slider", "chin"),
        nose("nose_slider", "nose"),
        vFace("vface_slider", "v_face"),
        threeCounts("threeCounts_slider", "face_three_counts"),
        cheekboneWidth("cheekbone_slider", "cheek_bone"),
        mouthWidth("mouthWidth_slider", LivenessStat.TYPE_LIVING_MOUTH),
        faceWidth("faceWidth_slider", "face_width"),
        noseLength("noseLength_slider", "nose_length"),
        upCount("upCount_slider", "up_count"),
        eyeDistance("eyeDistance_slider", "eye_distance");
        
        String mJsonKey;
        String mKey;

        BeautyAdjustKey(String str, String str2) {
            this.mKey = str;
            this.mJsonKey = str2;
        }

        public String getKey() {
            return this.mKey;
        }

        public String getJsonKey() {
            return this.mJsonKey;
        }
    }
}

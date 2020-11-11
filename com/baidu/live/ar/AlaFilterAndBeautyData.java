package com.baidu.live.ar;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.tbadk.core.data.BaseData;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.img.effect.FilterImageAction;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaFilterAndBeautyData extends BaseData {
    public static HashMap<BeautyAdjustKey, b> aEd = new HashMap<>();
    public String aDW;
    public a aDX;
    public List<h> aDY = new ArrayList();
    public List<g> aDZ = new ArrayList();
    public ConcurrentHashMap<String, Object> aEa = new ConcurrentHashMap<>();
    public String aEb;
    public String aEc;
    public BdUniqueId aEe;
    public boolean aEf;

    /* loaded from: classes4.dex */
    public static class a {
        public int aEg;
        public int aEh;
        public int aEi;
        public String mText;
    }

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aDW = jSONObject.optString("ar_token");
            JSONObject optJSONObject = jSONObject.optJSONObject("bubble");
            if (optJSONObject != null) {
                this.aDX = new a();
                this.aDX.aEg = optJSONObject.optInt("is_show");
                this.aDX.mText = optJSONObject.optString("text");
                this.aDX.aEh = optJSONObject.optInt("subitem_red_dot");
                this.aDX.aEi = optJSONObject.optInt("beauty_tab_red_dot");
            }
            JSONArray optJSONArray = jSONObject.optJSONArray(FilterImageAction.ACTION_NAME);
            if (optJSONArray != null && optJSONArray.length() > 0) {
                int length = optJSONArray.length();
                ListUtils.clear(this.aDY);
                for (int i = 0; i < length; i++) {
                    JSONObject jSONObject2 = (JSONObject) optJSONArray.opt(i);
                    if (jSONObject2 != null) {
                        h hVar = new h();
                        hVar.parseJson(jSONObject2);
                        this.aDY.add(hVar);
                    }
                }
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("ARBeauty");
            if (optJSONObject2 != null) {
                JSONObject optJSONObject3 = optJSONObject2.optJSONObject("default");
                this.aEb = optJSONObject3.optString("file");
                this.aEc = optJSONObject3.optString("file_token");
                this.aEa.clear();
                this.aEa.putAll(x(optJSONObject3));
                JSONObject optJSONObject4 = optJSONObject2.optJSONObject("adjust");
                if (optJSONObject4 != null) {
                    aEd.clear();
                    int length2 = BeautyAdjustKey.values().length;
                    for (int i2 = 0; i2 < length2; i2++) {
                        JSONObject optJSONObject5 = optJSONObject4.optJSONObject(BeautyAdjustKey.values()[i2].getKey());
                        if (optJSONObject5 != null) {
                            b bVar = new b();
                            bVar.dC(optJSONObject5.optInt("current"));
                            bVar.x(x(optJSONObject5.optJSONObject("subitems")));
                            aEd.put(BeautyAdjustKey.values()[i2], bVar);
                        }
                    }
                }
                JSONArray optJSONArray2 = optJSONObject2.optJSONArray("face_feature");
                if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                    int length3 = optJSONArray2.length();
                    ListUtils.clear(this.aDZ);
                    for (int i3 = 0; i3 < length3; i3++) {
                        JSONObject jSONObject3 = (JSONObject) optJSONArray2.opt(i3);
                        if (jSONObject3 != null) {
                            g gVar = new g();
                            gVar.parseJson(jSONObject3);
                            this.aDZ.add(gVar);
                        }
                    }
                }
            }
        }
    }

    private static HashMap<String, Object> x(JSONObject jSONObject) {
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
        int aEj;
        HashMap<String, Object> aEk;

        public int Cp() {
            return this.aEj;
        }

        public void dC(int i) {
            this.aEj = i;
        }

        public HashMap<String, Object> Cq() {
            return this.aEk;
        }

        public void x(HashMap<String, Object> hashMap) {
            this.aEk = hashMap;
        }
    }

    public static int a(HashMap<BeautyAdjustKey, b> hashMap, BeautyAdjustKey beautyAdjustKey) {
        if (hashMap == null || beautyAdjustKey == null || hashMap.get(beautyAdjustKey) == null) {
            return 0;
        }
        return hashMap.get(beautyAdjustKey).aEj;
    }

    public static BeautyAdjustKey fU(String str) {
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
        mouthWidth("mouthWidth_slider", com.baidu.pass.biometrics.face.liveness.c.a.i),
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

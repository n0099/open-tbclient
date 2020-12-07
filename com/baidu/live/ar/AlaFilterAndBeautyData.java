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
    public static HashMap<BeautyAdjustKey, b> aEY = new HashMap<>();
    public String aER;
    public a aES;
    public List<h> aET = new ArrayList();
    public List<g> aEU = new ArrayList();
    public ConcurrentHashMap<String, Object> aEV = new ConcurrentHashMap<>();
    public String aEW;
    public String aEX;
    public BdUniqueId aEZ;
    public boolean aFa;

    /* loaded from: classes4.dex */
    public static class a {
        public int aFb;
        public int aFc;
        public int aFd;
        public String mText;
    }

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aER = jSONObject.optString("ar_token");
            JSONObject optJSONObject = jSONObject.optJSONObject("bubble");
            if (optJSONObject != null) {
                this.aES = new a();
                this.aES.aFb = optJSONObject.optInt("is_show");
                this.aES.mText = optJSONObject.optString("text");
                this.aES.aFc = optJSONObject.optInt("subitem_red_dot");
                this.aES.aFd = optJSONObject.optInt("beauty_tab_red_dot");
            }
            JSONArray optJSONArray = jSONObject.optJSONArray(FilterImageAction.ACTION_NAME);
            if (optJSONArray != null && optJSONArray.length() > 0) {
                int length = optJSONArray.length();
                ListUtils.clear(this.aET);
                for (int i = 0; i < length; i++) {
                    JSONObject jSONObject2 = (JSONObject) optJSONArray.opt(i);
                    if (jSONObject2 != null) {
                        h hVar = new h();
                        hVar.parseJson(jSONObject2);
                        this.aET.add(hVar);
                    }
                }
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("ARBeauty");
            if (optJSONObject2 != null) {
                JSONObject optJSONObject3 = optJSONObject2.optJSONObject("default");
                this.aEW = optJSONObject3.optString("file");
                this.aEX = optJSONObject3.optString("file_token");
                this.aEV.clear();
                this.aEV.putAll(r(optJSONObject3));
                JSONObject optJSONObject4 = optJSONObject2.optJSONObject("adjust");
                if (optJSONObject4 != null) {
                    aEY.clear();
                    int length2 = BeautyAdjustKey.values().length;
                    for (int i2 = 0; i2 < length2; i2++) {
                        JSONObject optJSONObject5 = optJSONObject4.optJSONObject(BeautyAdjustKey.values()[i2].getKey());
                        if (optJSONObject5 != null) {
                            b bVar = new b();
                            bVar.dR(optJSONObject5.optInt("current"));
                            bVar.x(r(optJSONObject5.optJSONObject("subitems")));
                            aEY.put(BeautyAdjustKey.values()[i2], bVar);
                        }
                    }
                }
                JSONArray optJSONArray2 = optJSONObject2.optJSONArray("face_feature");
                if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                    int length3 = optJSONArray2.length();
                    ListUtils.clear(this.aEU);
                    for (int i3 = 0; i3 < length3; i3++) {
                        JSONObject jSONObject3 = (JSONObject) optJSONArray2.opt(i3);
                        if (jSONObject3 != null) {
                            g gVar = new g();
                            gVar.parseJson(jSONObject3);
                            this.aEU.add(gVar);
                        }
                    }
                }
            }
        }
    }

    private static HashMap<String, Object> r(JSONObject jSONObject) {
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
        int aFe;
        HashMap<String, Object> aFf;

        public int Dq() {
            return this.aFe;
        }

        public void dR(int i) {
            this.aFe = i;
        }

        public HashMap<String, Object> Dr() {
            return this.aFf;
        }

        public void x(HashMap<String, Object> hashMap) {
            this.aFf = hashMap;
        }
    }

    public static int a(HashMap<BeautyAdjustKey, b> hashMap, BeautyAdjustKey beautyAdjustKey) {
        if (hashMap == null || beautyAdjustKey == null || hashMap.get(beautyAdjustKey) == null) {
            return 0;
        }
        return hashMap.get(beautyAdjustKey).aFe;
    }

    public static BeautyAdjustKey gk(String str) {
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

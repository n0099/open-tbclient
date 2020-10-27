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
    public static HashMap<BeautyAdjustKey, b> aDw = new HashMap<>();
    public String aDp;
    public a aDq;
    public List<g> aDr = new ArrayList();
    public List<f> aDs = new ArrayList();
    public ConcurrentHashMap<String, Object> aDt = new ConcurrentHashMap<>();
    public String aDu;
    public String aDv;
    public BdUniqueId aDx;
    public boolean aDy;

    /* loaded from: classes4.dex */
    public static class a {
        public int aDA;
        public int aDB;
        public int aDz;
        public String mText;
    }

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aDp = jSONObject.optString("ar_token");
            JSONObject optJSONObject = jSONObject.optJSONObject("bubble");
            if (optJSONObject != null) {
                this.aDq = new a();
                this.aDq.aDz = optJSONObject.optInt("is_show");
                this.aDq.mText = optJSONObject.optString("text");
                this.aDq.aDA = optJSONObject.optInt("subitem_red_dot");
                this.aDq.aDB = optJSONObject.optInt("beauty_tab_red_dot");
            }
            JSONArray optJSONArray = jSONObject.optJSONArray(FilterImageAction.ACTION_NAME);
            if (optJSONArray != null && optJSONArray.length() > 0) {
                int length = optJSONArray.length();
                ListUtils.clear(this.aDr);
                for (int i = 0; i < length; i++) {
                    JSONObject jSONObject2 = (JSONObject) optJSONArray.opt(i);
                    if (jSONObject2 != null) {
                        g gVar = new g();
                        gVar.parseJson(jSONObject2);
                        this.aDr.add(gVar);
                    }
                }
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("ARBeauty");
            if (optJSONObject2 != null) {
                JSONObject optJSONObject3 = optJSONObject2.optJSONObject("default");
                this.aDu = optJSONObject3.optString("file");
                this.aDv = optJSONObject3.optString("file_token");
                this.aDt.clear();
                this.aDt.putAll(u(optJSONObject3));
                JSONObject optJSONObject4 = optJSONObject2.optJSONObject("adjust");
                if (optJSONObject4 != null) {
                    aDw.clear();
                    int length2 = BeautyAdjustKey.values().length;
                    for (int i2 = 0; i2 < length2; i2++) {
                        JSONObject optJSONObject5 = optJSONObject4.optJSONObject(BeautyAdjustKey.values()[i2].getKey());
                        if (optJSONObject5 != null) {
                            b bVar = new b();
                            bVar.dC(optJSONObject5.optInt("current"));
                            bVar.x(u(optJSONObject5.optJSONObject("subitems")));
                            aDw.put(BeautyAdjustKey.values()[i2], bVar);
                        }
                    }
                }
                JSONArray optJSONArray2 = optJSONObject2.optJSONArray("face_feature");
                if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                    int length3 = optJSONArray2.length();
                    ListUtils.clear(this.aDs);
                    for (int i3 = 0; i3 < length3; i3++) {
                        JSONObject jSONObject3 = (JSONObject) optJSONArray2.opt(i3);
                        if (jSONObject3 != null) {
                            f fVar = new f();
                            fVar.parseJson(jSONObject3);
                            this.aDs.add(fVar);
                        }
                    }
                }
            }
        }
    }

    private static HashMap<String, Object> u(JSONObject jSONObject) {
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
        int aDC;
        HashMap<String, Object> aDD;

        public int BX() {
            return this.aDC;
        }

        public void dC(int i) {
            this.aDC = i;
        }

        public HashMap<String, Object> BY() {
            return this.aDD;
        }

        public void x(HashMap<String, Object> hashMap) {
            this.aDD = hashMap;
        }
    }

    public static int a(HashMap<BeautyAdjustKey, b> hashMap, BeautyAdjustKey beautyAdjustKey) {
        if (hashMap == null || beautyAdjustKey == null || hashMap.get(beautyAdjustKey) == null) {
            return 0;
        }
        return hashMap.get(beautyAdjustKey).aDC;
    }

    public static BeautyAdjustKey fQ(String str) {
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

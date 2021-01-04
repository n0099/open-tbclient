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
/* loaded from: classes11.dex */
public class AlaFilterAndBeautyData extends BaseData {
    public static HashMap<BeautyAdjustKey, b> aFq = new HashMap<>();
    public String aFj;
    public a aFk;
    public List<i> aFl = new ArrayList();
    public List<h> aFm = new ArrayList();
    public ConcurrentHashMap<String, Object> aFn = new ConcurrentHashMap<>();
    public String aFo;
    public String aFp;
    public BdUniqueId aFr;
    public boolean aFs;

    /* loaded from: classes11.dex */
    public static class a {
        public int aFt;
        public int aFu;
        public int aFv;
        public String mText;
    }

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aFj = jSONObject.optString("ar_token");
            JSONObject optJSONObject = jSONObject.optJSONObject("bubble");
            if (optJSONObject != null) {
                this.aFk = new a();
                this.aFk.aFt = optJSONObject.optInt("is_show");
                this.aFk.mText = optJSONObject.optString("text");
                this.aFk.aFu = optJSONObject.optInt("subitem_red_dot");
                this.aFk.aFv = optJSONObject.optInt("beauty_tab_red_dot");
            }
            JSONArray optJSONArray = jSONObject.optJSONArray(FilterImageAction.ACTION_NAME);
            if (optJSONArray != null && optJSONArray.length() > 0) {
                int length = optJSONArray.length();
                ListUtils.clear(this.aFl);
                for (int i = 0; i < length; i++) {
                    JSONObject jSONObject2 = (JSONObject) optJSONArray.opt(i);
                    if (jSONObject2 != null) {
                        i iVar = new i();
                        iVar.parseJson(jSONObject2);
                        this.aFl.add(iVar);
                    }
                }
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("ARBeauty");
            if (optJSONObject2 != null) {
                JSONObject optJSONObject3 = optJSONObject2.optJSONObject("default");
                this.aFo = optJSONObject3.optString("file");
                this.aFp = optJSONObject3.optString("file_token");
                this.aFn.clear();
                this.aFn.putAll(x(optJSONObject3));
                JSONObject optJSONObject4 = optJSONObject2.optJSONObject("adjust");
                if (optJSONObject4 != null) {
                    aFq.clear();
                    int length2 = BeautyAdjustKey.values().length;
                    for (int i2 = 0; i2 < length2; i2++) {
                        JSONObject optJSONObject5 = optJSONObject4.optJSONObject(BeautyAdjustKey.values()[i2].getKey());
                        if (optJSONObject5 != null) {
                            b bVar = new b();
                            bVar.dO(optJSONObject5.optInt("current"));
                            bVar.x(x(optJSONObject5.optJSONObject("subitems")));
                            aFq.put(BeautyAdjustKey.values()[i2], bVar);
                        }
                    }
                }
                JSONArray optJSONArray2 = optJSONObject2.optJSONArray("face_feature");
                if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                    int length3 = optJSONArray2.length();
                    ListUtils.clear(this.aFm);
                    for (int i3 = 0; i3 < length3; i3++) {
                        JSONObject jSONObject3 = (JSONObject) optJSONArray2.opt(i3);
                        if (jSONObject3 != null) {
                            h hVar = new h();
                            hVar.parseJson(jSONObject3);
                            this.aFm.add(hVar);
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

    /* loaded from: classes11.dex */
    public static class b {
        int aFw;
        HashMap<String, Object> aFx;

        public int CG() {
            return this.aFw;
        }

        public void dO(int i) {
            this.aFw = i;
        }

        public HashMap<String, Object> CH() {
            return this.aFx;
        }

        public void x(HashMap<String, Object> hashMap) {
            this.aFx = hashMap;
        }
    }

    public static int a(HashMap<BeautyAdjustKey, b> hashMap, BeautyAdjustKey beautyAdjustKey) {
        if (hashMap == null || beautyAdjustKey == null || hashMap.get(beautyAdjustKey) == null) {
            return 0;
        }
        return hashMap.get(beautyAdjustKey).aFw;
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

    /* loaded from: classes11.dex */
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

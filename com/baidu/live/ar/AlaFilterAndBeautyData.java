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
/* loaded from: classes3.dex */
public class AlaFilterAndBeautyData extends BaseData {
    public static HashMap<BeautyAdjustKey, b> anN = new HashMap<>();
    public String anH;
    public a anI;
    public List<d> anJ = new ArrayList();
    public ConcurrentHashMap<String, Object> anK = new ConcurrentHashMap<>();
    public String anL;
    public String anM;
    public BdUniqueId anO;
    public boolean anP;

    /* loaded from: classes3.dex */
    public static class a {
        public int anQ;
        public String mText;
    }

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.anH = jSONObject.optString("ar_token");
            JSONObject optJSONObject = jSONObject.optJSONObject("bubble");
            if (optJSONObject != null) {
                this.anI = new a();
                this.anI.anQ = optJSONObject.optInt("is_show");
                this.anI.mText = optJSONObject.optString("text");
            }
            JSONArray optJSONArray = jSONObject.optJSONArray(FilterImageAction.ACTION_NAME);
            if (optJSONArray != null && optJSONArray.length() > 0) {
                int length = optJSONArray.length();
                ListUtils.clear(this.anJ);
                for (int i = 0; i < length; i++) {
                    JSONObject jSONObject2 = (JSONObject) optJSONArray.opt(i);
                    if (jSONObject2 != null) {
                        d dVar = new d();
                        dVar.parseJson(jSONObject2);
                        this.anJ.add(dVar);
                    }
                }
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("ARBeauty");
            if (optJSONObject2 != null) {
                JSONObject optJSONObject3 = optJSONObject2.optJSONObject("default");
                this.anL = optJSONObject3.optString("file");
                this.anM = optJSONObject3.optString("file_token");
                this.anK.clear();
                this.anK.putAll(o(optJSONObject3));
                JSONObject optJSONObject4 = optJSONObject2.optJSONObject("adjust");
                if (optJSONObject4 != null) {
                    anN.clear();
                    int length2 = BeautyAdjustKey.values().length;
                    for (int i2 = 0; i2 < length2; i2++) {
                        JSONObject optJSONObject5 = optJSONObject4.optJSONObject(BeautyAdjustKey.values()[i2].getKey());
                        if (optJSONObject5 != null) {
                            b bVar = new b();
                            bVar.br(optJSONObject5.optInt("current"));
                            bVar.x(o(optJSONObject5.optJSONObject("subitems")));
                            anN.put(BeautyAdjustKey.values()[i2], bVar);
                        }
                    }
                }
            }
        }
    }

    private static HashMap<String, Object> o(JSONObject jSONObject) {
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

    /* loaded from: classes3.dex */
    public static class b {
        int anR;
        HashMap<String, Object> anS;

        public int tO() {
            return this.anR;
        }

        public void br(int i) {
            this.anR = i;
        }

        public HashMap<String, Object> tP() {
            return this.anS;
        }

        public void x(HashMap<String, Object> hashMap) {
            this.anS = hashMap;
        }
    }

    public static int a(HashMap<BeautyAdjustKey, b> hashMap, BeautyAdjustKey beautyAdjustKey) {
        if (hashMap == null || beautyAdjustKey == null || hashMap.get(beautyAdjustKey) == null) {
            return 0;
        }
        return hashMap.get(beautyAdjustKey).anR;
    }

    public static BeautyAdjustKey dC(String str) {
        BeautyAdjustKey[] values;
        for (BeautyAdjustKey beautyAdjustKey : BeautyAdjustKey.values()) {
            if (beautyAdjustKey.getJsonKey().equals(str)) {
                return beautyAdjustKey;
            }
        }
        return null;
    }

    /* loaded from: classes3.dex */
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
        mouthWidth("mouthWidth_slider", LivenessStat.TYPE_LIVING_MOUTH);
        
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

package com.baidu.live.ar;

import com.baidu.live.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes2.dex */
public class AlaFilterAndBeautyData {
    public static HashMap<BeautyAdjustKey, b> Ub = new HashMap<>();
    public a TY;
    public List<Object> TZ = new ArrayList();
    public HashMap<String, Object> Ua = new HashMap<>();
    public BdUniqueId Uc;

    /* loaded from: classes2.dex */
    public static class a {
        public int Ue;
        public String mText;
    }

    /* loaded from: classes2.dex */
    public static class b {
        HashMap<String, Object> Uf;

        public HashMap<String, Object> oN() {
            return this.Uf;
        }
    }

    /* loaded from: classes2.dex */
    public enum BeautyAdjustKey {
        whiten("whiten_slider", "white_percent"),
        smooth("smooth_slider", "blur_level"),
        eye("eye_slider", "big_eye"),
        thinFace("thinFace_slider", "thin_face"),
        chin("chin_slider", "chin"),
        nose("nose_slider", "nose"),
        vFace("vface_slider", "v_face"),
        threeCounts("threeCounts_slider", "face_three_counts");
        
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

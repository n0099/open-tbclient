package com.baidu.ar.ability;

import com.baidu.ar.auth.ARAuth;
import com.baidu.ar.auth.FeatureCodes;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class a {
    public static volatile Map<String, Integer> bv = Z();
    public static volatile Map<String, Integer> bw = aa();

    public static Map<String, Integer> Z() {
        HashMap hashMap = new HashMap();
        hashMap.put("com.baidu.ar.vo.VOAR", 1300);
        hashMap.put("com.baidu.ar.pose.PoseAR", 1400);
        hashMap.put("com.baidu.ar.stretch.StretchAR", 1400);
        hashMap.put("com.baidu.ar.gesture.GestureAR", 1500);
        return hashMap;
    }

    public static Map<String, Integer> aa() {
        HashMap hashMap = new HashMap();
        hashMap.put("ability_face_model", 1200);
        hashMap.put("ability_face_filter", 1000);
        hashMap.put("ability_makeup_filter", Integer.valueOf((int) FeatureCodes.BEAUTY_MAKEUP));
        hashMap.put("ability_vo", 1300);
        hashMap.put("ability_pose", 1400);
        hashMap.put("ability_body_detect", 1400);
        hashMap.put("ability_gesture", 1500);
        hashMap.put("ability_image_segmentation", Integer.valueOf((int) FeatureCodes.BODY_SEG));
        hashMap.put("ability_sky_segmentation", Integer.valueOf((int) FeatureCodes.SKY_SEG));
        hashMap.put("ability_hair_segmentation", 1800);
        hashMap.put("ability_object_detect", 2000);
        hashMap.put("ability_3d_track", Integer.valueOf((int) FeatureCodes.TRACK_3D));
        return hashMap;
    }

    public static boolean o(String str) {
        if (bv.containsKey(str)) {
            return ARAuth.checkFeatureAuth(bv.get(str).intValue());
        }
        return true;
    }

    public static boolean p(String str) {
        if (bw.containsKey(str)) {
            return ARAuth.checkFeatureAuth(bw.get(str).intValue());
        }
        return true;
    }

    public static boolean q(String str) {
        if (bw.containsKey(str)) {
            return ARAuth.enableFeature(bw.get(str).intValue());
        }
        return true;
    }
}

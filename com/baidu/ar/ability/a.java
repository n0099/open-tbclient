package com.baidu.ar.ability;

import com.baidu.ar.auth.ARAuth;
import com.baidu.ar.auth.FeatureCodes;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class a {
    private static volatile Map<String, Integer> bv = Z();
    private static volatile Map<String, Integer> bw = aa();

    private static Map<String, Integer> Z() {
        HashMap hashMap = new HashMap();
        hashMap.put("com.baidu.ar.vo.VOAR", 1300);
        hashMap.put("com.baidu.ar.pose.PoseAR", Integer.valueOf((int) FeatureCodes.POSE));
        hashMap.put("com.baidu.ar.stretch.StretchAR", Integer.valueOf((int) FeatureCodes.POSE));
        hashMap.put("com.baidu.ar.gesture.GestureAR", 1500);
        return hashMap;
    }

    private static Map<String, Integer> aa() {
        HashMap hashMap = new HashMap();
        hashMap.put("ability_face_model", Integer.valueOf((int) FeatureCodes.FACE));
        hashMap.put("ability_face_filter", 1000);
        hashMap.put("ability_makeup_filter", Integer.valueOf((int) FeatureCodes.BEAUTY_MAKEUP));
        hashMap.put("ability_vo", 1300);
        hashMap.put("ability_pose", Integer.valueOf((int) FeatureCodes.POSE));
        hashMap.put("ability_body_detect", Integer.valueOf((int) FeatureCodes.POSE));
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

package com.baidu.ar.ability;

import com.baidu.ar.auth.FeatureCodes;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes11.dex */
public class a {
    private static volatile Map<String, Integer> bs = X();
    private static volatile Map<String, Integer> bt = Y();

    private static Map<String, Integer> X() {
        HashMap hashMap = new HashMap();
        hashMap.put("com.baidu.ar.vo.VOAR", Integer.valueOf((int) FeatureCodes.VO));
        hashMap.put("com.baidu.ar.pose.PoseAR", Integer.valueOf((int) FeatureCodes.POSE));
        hashMap.put("com.baidu.ar.stretch.StretchAR", Integer.valueOf((int) FeatureCodes.POSE));
        hashMap.put("com.baidu.ar.gesture.GestureAR", 1500);
        return hashMap;
    }

    private static Map<String, Integer> Y() {
        HashMap hashMap = new HashMap();
        hashMap.put("ability_face_model", Integer.valueOf((int) FeatureCodes.FACE));
        hashMap.put("ability_face_filter", 1000);
        hashMap.put("ability_makeup_filter", Integer.valueOf((int) FeatureCodes.BEAUTY_MAKEUP));
        hashMap.put("ability_vo", Integer.valueOf((int) FeatureCodes.VO));
        hashMap.put("ability_pose", Integer.valueOf((int) FeatureCodes.POSE));
        hashMap.put("ability_body_detect", Integer.valueOf((int) FeatureCodes.POSE));
        hashMap.put("ability_gesture", 1500);
        hashMap.put("ability_image_segmentation", Integer.valueOf((int) FeatureCodes.BODY_SEG));
        hashMap.put("ability_sky_segmentation", Integer.valueOf((int) FeatureCodes.SKY_SEG));
        hashMap.put("ability_hair_segmentation", 1800);
        hashMap.put("ability_object_detect", 2000);
        return hashMap;
    }

    public static boolean m(String str) {
        if (bs.containsKey(str)) {
            return com.baidu.ar.auth.a.checkFeatureAuth(bs.get(str).intValue());
        }
        return true;
    }

    public static boolean n(String str) {
        if (bt.containsKey(str)) {
            return com.baidu.ar.auth.a.checkFeatureAuth(bt.get(str).intValue());
        }
        return true;
    }

    public static boolean o(String str) {
        if (bt.containsKey(str)) {
            return com.baidu.ar.auth.a.enableFeature(bt.get(str).intValue());
        }
        return true;
    }
}

package com.baidu.ala.dumixar;

import com.baidu.minivideo.arface.bean.BeautyType;
import com.baidu.pass.biometrics.face.liveness.c.a;
import java.util.HashMap;
/* loaded from: classes9.dex */
public class ARNetKey2BeautyType {
    public static HashMap<String, BeautyType> sKeyMap = new HashMap<>();

    static {
        sKeyMap.put("threeCounts", BeautyType.threeCounts);
        sKeyMap.put("eyeDistance", BeautyType.eyeDistance);
        sKeyMap.put("mouthWidth", BeautyType.mouthWidth);
        sKeyMap.put("eyebrowDistance", BeautyType.eyebrowDistance);
        sKeyMap.put("jawAngleWidth", BeautyType.jawAngleWidth);
        sKeyMap.put("eyeAngle", BeautyType.eyeAngle);
        sKeyMap.put("upCount", BeautyType.upCount);
        sKeyMap.put("whiten", BeautyType.whiten);
        sKeyMap.put("smooth", BeautyType.smooth);
        sKeyMap.put(a.h, BeautyType.eye);
        sKeyMap.put("thinFace", BeautyType.thinFace);
        sKeyMap.put("faceWidth", BeautyType.faceWidth);
        sKeyMap.put("chinHeight", BeautyType.chinHeight);
        sKeyMap.put("noseWidth", BeautyType.noseWidth);
        sKeyMap.put("middleCount", BeautyType.middleCount);
        sKeyMap.put("downCount", BeautyType.downCount);
        sKeyMap.put("cheekbone", BeautyType.cheekboneWidth);
        sKeyMap.put("faceWidth", BeautyType.faceWidth);
        sKeyMap.put("noseLength", BeautyType.noseLength);
        sKeyMap.put("upCount", BeautyType.upCount);
        sKeyMap.put("eyeDistance", BeautyType.eyeDistance);
        sKeyMap.put("lips", BeautyType.lips);
        sKeyMap.put("cheeks", BeautyType.cheeks);
        sKeyMap.put("highlight", BeautyType.highlight);
        sKeyMap.put("eyeliner", BeautyType.eyeliner);
        sKeyMap.put("eyeshadow", BeautyType.eyeshadow);
        sKeyMap.put("eyeball", BeautyType.eyeball);
        sKeyMap.put("eyelash", BeautyType.eyelash);
        sKeyMap.put("eyebrow", BeautyType.eyebrow);
    }

    public static BeautyType getBeautyType(String str) {
        return sKeyMap.get(str);
    }
}

package com.baidu.ala.dumixar;

import com.baidu.minivideo.arface.bean.BeautyType;
import com.baidu.pass.biometrics.face.liveness.stat.LivenessStat;
import java.util.HashMap;
/* loaded from: classes7.dex */
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
        sKeyMap.put(LivenessStat.TYPE_LIVING_EYE, BeautyType.eye);
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
    }

    public static BeautyType getBeautyType(String str) {
        return sKeyMap.get(str);
    }
}

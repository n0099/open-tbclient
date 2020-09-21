package com.baidu.ala.dumixar;

import com.baidu.minivideo.arface.bean.BeautyType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
/* loaded from: classes12.dex */
public class BeautyDataManager {
    public static final float CHINHEIGHT = 0.25f;
    public static final float CHINWIDTH = 0.5f;
    public static final float DOWNCOUNT = 0.5f;
    public static final float EYE = 0.0f;
    public static final float EYEANGLE = 0.5f;
    public static final float EYEBROWDISTANCE = 0.5f;
    public static final float EYEDISTANCE = 0.5f;
    public static final float FACEWIDTH = 0.4f;
    public static final float JAWANGLEWIDTH = 0.35f;
    public static final float MIDDLECOUNT = 0.65f;
    public static final float MOUTHWIDTH = 0.2f;
    public static final float NOSEBRIDGEWIDTH = 0.21f;
    public static final float NOSEWINGWIDTH = 0.2f;
    public static final float SMOOTH = 0.68f;
    public static final float THINFACE = 0.35f;
    public static final float THREECOUNTS = 0.5f;
    public static final float UPCOUNT = 0.5f;
    public static final float WHITEN = 0.0f;
    private static BeautyDataManager sInstance = new BeautyDataManager();
    private ConcurrentHashMap<String, Object> mDefaultBeautyParams;

    public static BeautyDataManager getInstance() {
        return sInstance;
    }

    private BeautyDataManager() {
    }

    public ConcurrentHashMap<BeautyType, Object> getBeautyTypes(ConcurrentHashMap<BeautyType, Object> concurrentHashMap) {
        concurrentHashMap.put(BeautyType.whiten, Float.valueOf(0.0f));
        concurrentHashMap.put(BeautyType.smooth, Float.valueOf(0.68f));
        concurrentHashMap.put(BeautyType.eye, Float.valueOf(0.0f));
        concurrentHashMap.put(BeautyType.thinFace, Float.valueOf(0.35f));
        concurrentHashMap.put(BeautyType.threeCounts, Float.valueOf(0.5f));
        concurrentHashMap.put(BeautyType.chinHeight, Float.valueOf(0.25f));
        concurrentHashMap.put(BeautyType.noseWidth, Float.valueOf(0.21f));
        concurrentHashMap.put(BeautyType.eyeDistance, Float.valueOf(0.5f));
        concurrentHashMap.put(BeautyType.mouthWidth, Float.valueOf(0.2f));
        concurrentHashMap.put(BeautyType.eyebrowDistance, Float.valueOf(0.5f));
        concurrentHashMap.put(BeautyType.downCount, Float.valueOf(0.5f));
        concurrentHashMap.put(BeautyType.jawAngleWidth, Float.valueOf(0.35f));
        concurrentHashMap.put(BeautyType.eyeAngle, Float.valueOf(0.5f));
        concurrentHashMap.put(BeautyType.faceWidth, Float.valueOf(0.4f));
        concurrentHashMap.put(BeautyType.middleCount, Float.valueOf(0.65f));
        concurrentHashMap.put(BeautyType.upCount, Float.valueOf(0.5f));
        return concurrentHashMap;
    }

    public HashMap<BeautyType, Object> getFaceThinTypes(boolean z) {
        HashMap<BeautyType, Object> hashMap = new HashMap<>();
        if (z && this.mDefaultBeautyParams != null && !this.mDefaultBeautyParams.isEmpty()) {
            hashMap.putAll(convertParams(this.mDefaultBeautyParams));
        }
        return hashMap;
    }

    public ConcurrentHashMap<BeautyType, Object> convertParams(ConcurrentHashMap<String, Object> concurrentHashMap) {
        BeautyType beautyType;
        ConcurrentHashMap<BeautyType, Object> concurrentHashMap2 = new ConcurrentHashMap<>();
        if (concurrentHashMap == null || concurrentHashMap.isEmpty()) {
            return concurrentHashMap2;
        }
        for (Map.Entry<String, Object> entry : concurrentHashMap.entrySet()) {
            if (entry != null && entry.getKey() != null && entry.getValue() != null && (beautyType = ARNetKey2BeautyType.getBeautyType(entry.getKey())) != null) {
                if (entry.getValue() instanceof JSONArray) {
                    JSONArray jSONArray = (JSONArray) entry.getValue();
                    if (jSONArray != null && jSONArray.length() > 0) {
                        ArrayList arrayList = new ArrayList();
                        for (int i = 0; i < jSONArray.length(); i++) {
                            arrayList.add(jSONArray.opt(i));
                        }
                        entry.setValue(arrayList);
                    }
                } else if (entry.getValue() instanceof String) {
                    try {
                        entry.setValue(Float.valueOf((String) entry.getValue()));
                    } catch (Exception e) {
                    }
                }
                concurrentHashMap2.put(beautyType, entry.getValue());
            }
        }
        return concurrentHashMap2;
    }

    public void setDefaultBeautyParams(ConcurrentHashMap<String, Object> concurrentHashMap) {
        this.mDefaultBeautyParams = concurrentHashMap;
    }
}

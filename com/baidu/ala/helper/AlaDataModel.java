package com.baidu.ala.helper;

import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes12.dex */
public class AlaDataModel {
    public static final String ALA_DATA_BEAUTY_PARAMS_KEYS = "ala_beauty_params_key";
    private static volatile AlaDataModel mInstance = null;
    private ConcurrentHashMap<String, String> mCache = new ConcurrentHashMap<>();

    private AlaDataModel() {
    }

    public static AlaDataModel getInstance() {
        if (mInstance != null) {
            return mInstance;
        }
        synchronized (AlaDataModel.class) {
            if (mInstance == null) {
                mInstance = new AlaDataModel();
            }
        }
        return mInstance;
    }

    public void putData(String str, String str2) {
        try {
            this.mCache.put(str, str2);
        } catch (Exception e) {
        }
    }

    public String getData(String str) {
        try {
            return this.mCache.get(str);
        } catch (Exception e) {
            return null;
        }
    }

    public void clear() {
        this.mCache.clear();
    }
}

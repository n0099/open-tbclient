package com.baidu.pass.biometrics.face.liveness.beans;

import com.baidu.pass.biometrics.base.dto.PassBiometricDto;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class BeanDataCache {
    private static BeanDataCache INSTANCE = null;
    public static final String KEY = "request_data";
    private HashMap<String, PassBiometricDto> mRequestList = new HashMap<>();

    private BeanDataCache() {
    }

    public static BeanDataCache getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new BeanDataCache();
        }
        return INSTANCE;
    }

    public PassBiometricDto getCacheData(String str) {
        if (this.mRequestList != null) {
            return this.mRequestList.get(str);
        }
        return null;
    }

    public void addToCache(String str, PassBiometricDto passBiometricDto) {
        if (this.mRequestList == null) {
            this.mRequestList = new HashMap<>();
        }
        this.mRequestList.put(str, passBiometricDto);
    }

    public void removeCache() {
        if (this.mRequestList != null) {
            this.mRequestList.clear();
            this.mRequestList = null;
        }
    }
}

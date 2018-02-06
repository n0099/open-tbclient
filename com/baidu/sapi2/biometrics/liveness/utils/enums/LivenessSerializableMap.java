package com.baidu.sapi2.biometrics.liveness.utils.enums;

import java.io.Serializable;
import java.util.Map;
/* loaded from: classes2.dex */
public class LivenessSerializableMap implements Serializable {
    private Map<String, String> map;

    public Map<String, String> getMap() {
        return this.map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }
}

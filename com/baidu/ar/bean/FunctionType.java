package com.baidu.ar.bean;
/* loaded from: classes3.dex */
public enum FunctionType {
    NONE("none"),
    VIDEO("video"),
    IMU("imu");
    
    private final String mValue;

    FunctionType(String str) {
        this.mValue = str;
    }

    public static FunctionType a(String str) {
        FunctionType[] values;
        if (str == null) {
            return NONE;
        }
        for (FunctionType functionType : values()) {
            if (functionType.a().equalsIgnoreCase(str)) {
                return functionType;
            }
        }
        return NONE;
    }

    public String a() {
        return this.mValue;
    }
}

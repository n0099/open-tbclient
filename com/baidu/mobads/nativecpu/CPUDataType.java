package com.baidu.mobads.nativecpu;

import android.text.TextUtils;
/* loaded from: classes2.dex */
public enum CPUDataType {
    NEWS("news", 0),
    IMAGE("image", 1),
    VIDEO("video", 2),
    TOPIC("topic", 3),
    AD("ad", 4),
    HOTDOC("hotkey", 5),
    SMALLVIDEO("smallvideo", 6),
    RECALLNEWS("recallNews", 8),
    POLICETASK("policetask", 9);
    

    /* renamed from: a  reason: collision with root package name */
    public String f8370a;

    /* renamed from: b  reason: collision with root package name */
    public int f8371b;

    CPUDataType(String str, int i) {
        this.f8370a = str;
        this.f8371b = i;
    }

    public static CPUDataType parseType(String str) {
        CPUDataType[] values;
        for (CPUDataType cPUDataType : values()) {
            if (cPUDataType != null && TextUtils.isEmpty(cPUDataType.f8370a) && cPUDataType.f8370a.equals(str)) {
                return cPUDataType;
            }
        }
        return null;
    }

    public String getName() {
        return this.f8370a;
    }

    public int getValue() {
        return this.f8371b;
    }
}

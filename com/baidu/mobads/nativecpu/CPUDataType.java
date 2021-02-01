package com.baidu.mobads.nativecpu;

import android.text.TextUtils;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
/* loaded from: classes5.dex */
public enum CPUDataType {
    NEWS("news", 0),
    IMAGE("image", 1),
    VIDEO("video", 2),
    TOPIC(AlbumActivityConfig.FROM_TOPIC, 3),
    AD("ad", 4),
    HOTDOC("hotkey", 5),
    SMALLVIDEO("smallvideo", 6),
    RECALLNEWS("recallNews", 8),
    POLICETASK("policetask", 9);
    

    /* renamed from: a  reason: collision with root package name */
    String f3399a;

    /* renamed from: b  reason: collision with root package name */
    int f3400b;

    CPUDataType(String str, int i) {
        this.f3399a = str;
        this.f3400b = i;
    }

    public String getName() {
        return this.f3399a;
    }

    public int getValue() {
        return this.f3400b;
    }

    public static CPUDataType parseType(String str) {
        CPUDataType[] values;
        for (CPUDataType cPUDataType : values()) {
            if (cPUDataType != null && TextUtils.isEmpty(cPUDataType.f3399a) && cPUDataType.f3399a.equals(str)) {
                return cPUDataType;
            }
        }
        return null;
    }
}

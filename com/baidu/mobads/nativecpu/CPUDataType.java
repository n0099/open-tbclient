package com.baidu.mobads.nativecpu;

import android.text.TextUtils;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
/* loaded from: classes4.dex */
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
    String f2424a;
    int b;

    CPUDataType(String str, int i) {
        this.f2424a = str;
        this.b = i;
    }

    public String getName() {
        return this.f2424a;
    }

    public int getValue() {
        return this.b;
    }

    public static CPUDataType parseType(String str) {
        CPUDataType[] values;
        for (CPUDataType cPUDataType : values()) {
            if (cPUDataType != null && TextUtils.isEmpty(cPUDataType.f2424a) && cPUDataType.f2424a.equals(str)) {
                return cPUDataType;
            }
        }
        return null;
    }
}

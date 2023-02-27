package com.baidu.nadcore.net.request;
/* loaded from: classes2.dex */
public enum BodyStyle {
    BYTE("BYTE"),
    STRING("STRING"),
    FILE("FILE"),
    FORM("FORM");
    
    public final String value;

    BodyStyle(String str) {
        this.value = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }
}

package com.baidu.sapi2.utils.enums;
/* loaded from: classes25.dex */
public enum Language {
    CHINESE(0, "chinese"),
    ENGLISH(1, "english");
    
    private int a;
    private String b;

    Language(int i, String str) {
        this.a = i;
        this.b = str;
    }

    public int getType() {
        return this.a;
    }
}

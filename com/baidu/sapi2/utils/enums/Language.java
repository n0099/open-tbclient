package com.baidu.sapi2.utils.enums;
/* loaded from: classes19.dex */
public enum Language {
    CHINESE(0, "chinese"),
    ENGLISH(1, "english");
    
    private int b;
    private String c;

    Language(int i, String str) {
        this.b = i;
        this.c = str;
    }

    public int getType() {
        return this.b;
    }
}

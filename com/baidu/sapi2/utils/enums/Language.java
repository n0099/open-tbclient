package com.baidu.sapi2.utils.enums;
/* loaded from: classes2.dex */
public enum Language {
    CHINESE(0, "chinese"),
    ENGLISH(1, "english");
    
    public String name;
    public int type;

    Language(int i2, String str) {
        this.type = i2;
        this.name = str;
    }

    public int getType() {
        return this.type;
    }
}

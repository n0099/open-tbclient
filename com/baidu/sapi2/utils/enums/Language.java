package com.baidu.sapi2.utils.enums;
/* loaded from: classes2.dex */
public enum Language {
    CHINESE(0, "chinese"),
    ENGLISH(1, "english");
    
    public String name;
    public int type;

    public int getType() {
        return this.type;
    }

    Language(int i, String str) {
        this.type = i;
        this.name = str;
    }
}

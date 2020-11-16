package com.baidu.sapi2.utils.enums;
/* loaded from: classes15.dex */
public enum Language {
    CHINESE(0, "chinese"),
    ENGLISH(1, "english");
    

    /* renamed from: a  reason: collision with root package name */
    private int f3549a;
    private String b;

    Language(int i, String str) {
        this.f3549a = i;
        this.b = str;
    }

    public int getType() {
        return this.f3549a;
    }
}

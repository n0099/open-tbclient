package com.baidu.sapi2.utils.enums;
/* loaded from: classes3.dex */
public enum Language {
    CHINESE(0, "chinese"),
    ENGLISH(1, "english");
    

    /* renamed from: a  reason: collision with root package name */
    private int f3455a;
    private String b;

    Language(int i, String str) {
        this.f3455a = i;
        this.b = str;
    }

    public int getType() {
        return this.f3455a;
    }
}

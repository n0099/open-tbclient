package com.baidu.sapi2.utils.enums;
/* loaded from: classes3.dex */
public enum Language {
    CHINESE(0, "chinese"),
    ENGLISH(1, "english");
    

    /* renamed from: a  reason: collision with root package name */
    private int f5401a;

    /* renamed from: b  reason: collision with root package name */
    private String f5402b;

    Language(int i, String str) {
        this.f5401a = i;
        this.f5402b = str;
    }

    public int getType() {
        return this.f5401a;
    }
}

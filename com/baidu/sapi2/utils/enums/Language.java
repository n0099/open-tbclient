package com.baidu.sapi2.utils.enums;
/* loaded from: classes3.dex */
public enum Language {
    CHINESE(0, "chinese"),
    ENGLISH(1, "english");
    

    /* renamed from: a  reason: collision with root package name */
    private int f5119a;

    /* renamed from: b  reason: collision with root package name */
    private String f5120b;

    Language(int i, String str) {
        this.f5119a = i;
        this.f5120b = str;
    }

    public int getType() {
        return this.f5119a;
    }
}

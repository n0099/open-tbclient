package com.baidu.sapi2.utils.enums;
/* loaded from: classes15.dex */
public enum Language {
    CHINESE(0, "chinese"),
    ENGLISH(1, "english");
    

    /* renamed from: a  reason: collision with root package name */
    private int f5121a;

    /* renamed from: b  reason: collision with root package name */
    private String f5122b;

    Language(int i, String str) {
        this.f5121a = i;
        this.f5122b = str;
    }

    public int getType() {
        return this.f5121a;
    }
}

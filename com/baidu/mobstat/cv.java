package com.baidu.mobstat;
/* loaded from: classes3.dex */
public class cv extends cy implements ct {

    /* renamed from: a  reason: collision with root package name */
    private String f3803a = "*";

    @Override // com.baidu.mobstat.ct
    public void a(String str) throws IllegalArgumentException {
        if (str == null) {
            throw new IllegalArgumentException("http resource descriptor must not be null");
        }
        this.f3803a = str;
    }

    @Override // com.baidu.mobstat.cs
    public String a() {
        return this.f3803a;
    }
}

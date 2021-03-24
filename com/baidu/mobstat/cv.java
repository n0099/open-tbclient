package com.baidu.mobstat;
/* loaded from: classes2.dex */
public class cv extends cy implements ct {

    /* renamed from: a  reason: collision with root package name */
    public String f9191a = "*";

    @Override // com.baidu.mobstat.ct
    public void a(String str) throws IllegalArgumentException {
        if (str != null) {
            this.f9191a = str;
            return;
        }
        throw new IllegalArgumentException("http resource descriptor must not be null");
    }

    @Override // com.baidu.mobstat.cs
    public String a() {
        return this.f9191a;
    }
}

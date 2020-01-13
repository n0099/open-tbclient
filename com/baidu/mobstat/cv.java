package com.baidu.mobstat;
/* loaded from: classes9.dex */
public class cv extends cy implements ct {
    private String a = "*";

    @Override // com.baidu.mobstat.ct
    public void a(String str) throws IllegalArgumentException {
        if (str == null) {
            throw new IllegalArgumentException("http resource descriptor must not be null");
        }
        this.a = str;
    }

    @Override // com.baidu.mobstat.cs
    public String a() {
        return this.a;
    }
}

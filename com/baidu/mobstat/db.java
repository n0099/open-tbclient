package com.baidu.mobstat;
/* loaded from: classes3.dex */
public class db extends de implements cz {
    private String a = "*";

    @Override // com.baidu.mobstat.cz
    public void a(String str) throws IllegalArgumentException {
        if (str == null) {
            throw new IllegalArgumentException("http resource descriptor must not be null");
        }
        this.a = str;
    }

    @Override // com.baidu.mobstat.cy
    public String a() {
        return this.a;
    }
}

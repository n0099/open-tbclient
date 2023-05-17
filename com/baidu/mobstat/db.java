package com.baidu.mobstat;
/* loaded from: classes3.dex */
public class db extends de implements cz {
    public String a = "*";

    @Override // com.baidu.mobstat.cy
    public String a() {
        return this.a;
    }

    @Override // com.baidu.mobstat.cz
    public void a(String str) throws IllegalArgumentException {
        if (str != null) {
            this.a = str;
            return;
        }
        throw new IllegalArgumentException("http resource descriptor must not be null");
    }
}

package com.baidu.adp.newwidget.a;
/* loaded from: classes.dex */
public class f {
    public static f BI = new f();

    private f() {
    }

    public static f kj() {
        return BI;
    }

    public a am(int i) {
        switch (i) {
            case 0:
                return new c();
            case 1:
                return new k();
            case 2:
                return new h();
            case 3:
                return new m();
            case 4:
                return new l();
            case 5:
                return new g();
            default:
                return new c();
        }
    }
}

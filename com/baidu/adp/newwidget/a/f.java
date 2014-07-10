package com.baidu.adp.newwidget.a;
/* loaded from: classes.dex */
public class f {
    public static f a = new f();

    private f() {
    }

    public static f a() {
        return a;
    }

    public a a(int i) {
        switch (i) {
            case 0:
                return new c();
            case 1:
                return new k();
            case 2:
                return new g();
            case 3:
                return new l();
            default:
                return new c();
        }
    }
}

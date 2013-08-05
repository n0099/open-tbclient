package com.baidu.loginshare;
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    static final int f766a = 1;
    static final int b = 2;
    private static final String e = "EffectUserCount";
    private static final String f = "ServiceAppCount";
    private String c;
    private String d;
    private boolean g = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(String str, String str2) {
        this.c = null;
        this.d = null;
        this.c = str;
        this.d = str2;
    }

    void a() {
        this.c = null;
        this.d = null;
        this.g = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, String str) {
        if (this.g && e.a(str)) {
            d dVar = null;
            switch (i) {
                case 1:
                    dVar = new d(this, g.q(), str, e);
                    break;
                case 2:
                    dVar = new d(this, g.r(), str, f);
                    break;
            }
            if (dVar != null) {
                new Thread(dVar).start();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        this.g = true;
    }
}

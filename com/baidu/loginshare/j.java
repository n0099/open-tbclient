package com.baidu.loginshare;
/* loaded from: classes.dex */
public class j {
    private static final String d = "EffectUserCount";
    private static final String e = "ServiceAppCount";
    private static int f = 1;
    private static int g = 2;
    String a;
    String b;
    boolean c;

    public j() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(String str, String str2) {
        this.a = null;
        this.b = null;
        this.c = false;
        this.a = str;
        this.b = str2;
    }

    public static boolean a(String str) {
        return str != null && str.length() > 0;
    }

    private void b() {
        this.a = null;
        this.b = null;
        this.c = false;
    }

    final void a() {
        this.c = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(int i, String str) {
        if (this.c && l.a(str)) {
            k kVar = null;
            switch (i) {
                case 1:
                    kVar = new k(this, Keystore.p(), str, d);
                    break;
                case 2:
                    kVar = new k(this, Keystore.q(), str, e);
                    break;
            }
            if (kVar != null) {
                new Thread(kVar).start();
            }
        }
    }
}

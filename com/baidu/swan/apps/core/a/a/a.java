package com.baidu.swan.apps.core.a.a;
/* loaded from: classes2.dex */
public class a {
    private int apt;
    private boolean apu = false;
    private boolean apv = false;
    private String apw = "0";
    private com.baidu.swan.apps.core.a.c.a apx;

    public int yy() {
        return this.apt;
    }

    public boolean yz() {
        return this.apu;
    }

    public com.baidu.swan.apps.core.a.c.a yA() {
        return this.apx;
    }

    public String yB() {
        return this.apw;
    }

    /* renamed from: com.baidu.swan.apps.core.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0129a {
        private a apy = new a();

        public a yC() {
            return this.apy;
        }

        public C0129a bY(int i) {
            this.apy.apt = i;
            return this;
        }

        public C0129a aW(boolean z) {
            this.apy.apu = z;
            return this;
        }
    }
}

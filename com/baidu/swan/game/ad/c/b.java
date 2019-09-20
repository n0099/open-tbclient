package com.baidu.swan.game.ad.c;

import com.baidu.swan.apps.an.z;
/* loaded from: classes2.dex */
public class b {
    private String a;
    private String b;
    private String c;
    private int d;
    private int e;

    private b(a aVar) {
        this.b = aVar.b;
        this.a = aVar.a;
        this.d = aVar.d;
        this.e = aVar.e;
        this.c = aVar.c;
    }

    public int a() {
        return this.d;
    }

    public int b() {
        return this.e;
    }

    public String c() {
        return this.b;
    }

    public String d() {
        return this.a;
    }

    public String e() {
        return this.c;
    }

    /* loaded from: classes2.dex */
    public static class a {
        private String a;
        private String b;
        private String c;
        private int d;
        private int e;

        public a iJ(String str) {
            this.b = str;
            return this;
        }

        public a iK(String str) {
            this.a = str;
            return this;
        }

        public a iL(String str) {
            this.c = str;
            return this;
        }

        public a eU(int i) {
            this.d = z.ad(i);
            return this;
        }

        public a eV(int i) {
            this.e = z.ad(i);
            return this;
        }

        public b QO() {
            return new b(this);
        }
    }
}

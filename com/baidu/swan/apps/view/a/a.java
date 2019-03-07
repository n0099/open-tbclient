package com.baidu.swan.apps.view.a;

import com.baidu.swan.apps.c;
/* loaded from: classes2.dex */
public class a {
    private static final boolean DEBUG = c.DEBUG;
    public int aWV;
    public boolean aWW;
    public boolean aWX;
    public boolean aWY;
    public boolean aWZ;
    public int statusBarColor;

    private a() {
    }

    /* renamed from: com.baidu.swan.apps.view.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0151a {
        private int aXa;
        private int statusBarColor;
        private boolean aWW = true;
        private boolean aXb = true;
        private boolean aXc = true;
        private boolean aWZ = false;

        public static C0151a Mx() {
            return new C0151a();
        }

        public C0151a eq(int i) {
            this.statusBarColor = i;
            return this;
        }

        public C0151a er(int i) {
            this.aXa = i;
            return this;
        }

        public C0151a co(boolean z) {
            this.aWW = z;
            return this;
        }

        public C0151a cp(boolean z) {
            this.aXb = z;
            return this;
        }

        public C0151a cq(boolean z) {
            this.aXc = z;
            return this;
        }

        public C0151a cr(boolean z) {
            this.aWZ = z;
            return this;
        }

        public a My() {
            a aVar = new a();
            aVar.aWV = this.aXa;
            aVar.aWW = this.aWW;
            aVar.aWY = this.aXc;
            aVar.aWX = this.aXb;
            aVar.statusBarColor = this.statusBarColor;
            aVar.aWZ = this.aWZ;
            return aVar;
        }
    }
}

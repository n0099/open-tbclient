package com.baidu.swan.apps.swancore.e;

import android.support.annotation.Nullable;
/* loaded from: classes2.dex */
public class c {
    public boolean aWV;
    public boolean aWW;
    @Nullable
    public com.baidu.swan.apps.v.b.c aWX;
    public String aWY;

    private c() {
        this.aWV = false;
        this.aWW = false;
        this.aWX = null;
        this.aWY = "";
    }

    /* loaded from: classes2.dex */
    public static class a {
        private boolean aWV = false;
        private boolean aWW = false;
        @Nullable
        private com.baidu.swan.apps.v.b.c aWX = null;
        private String aWY = "";

        public static a Ok() {
            return new a();
        }

        public a cA(boolean z) {
            this.aWV = z;
            return this;
        }

        public a hR(String str) {
            this.aWY = str;
            return this;
        }

        public c Ol() {
            c cVar = new c();
            cVar.aWV = this.aWV;
            cVar.aWW = this.aWW;
            cVar.aWX = this.aWX;
            cVar.aWY = this.aWY;
            return cVar;
        }

        public c Om() {
            this.aWV = false;
            this.aWW = false;
            this.aWX = null;
            this.aWY = "";
            return Ol();
        }
    }
}

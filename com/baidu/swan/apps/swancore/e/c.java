package com.baidu.swan.apps.swancore.e;

import android.support.annotation.Nullable;
/* loaded from: classes2.dex */
public class c {
    public boolean aXt;
    public boolean aXu;
    @Nullable
    public com.baidu.swan.apps.v.b.c aXv;
    public String aXw;

    private c() {
        this.aXt = false;
        this.aXu = false;
        this.aXv = null;
        this.aXw = "";
    }

    /* loaded from: classes2.dex */
    public static class a {
        private boolean aXt = false;
        private boolean aXu = false;
        @Nullable
        private com.baidu.swan.apps.v.b.c aXv = null;
        private String aXw = "";

        public static a Oo() {
            return new a();
        }

        public a cA(boolean z) {
            this.aXt = z;
            return this;
        }

        public a hT(String str) {
            this.aXw = str;
            return this;
        }

        public c Op() {
            c cVar = new c();
            cVar.aXt = this.aXt;
            cVar.aXu = this.aXu;
            cVar.aXv = this.aXv;
            cVar.aXw = this.aXw;
            return cVar;
        }

        public c Oq() {
            this.aXt = false;
            this.aXu = false;
            this.aXv = null;
            this.aXw = "";
            return Op();
        }
    }
}

package com.baidu.swan.apps.swancore.e;

import android.support.annotation.Nullable;
/* loaded from: classes2.dex */
public class c {
    public boolean aWl;
    public boolean aWm;
    @Nullable
    public com.baidu.swan.apps.v.b.c aWn;
    public String aWo;

    private c() {
        this.aWl = false;
        this.aWm = false;
        this.aWn = null;
        this.aWo = "";
    }

    /* loaded from: classes2.dex */
    public static class a {
        private boolean aWl = false;
        private boolean aWm = false;
        @Nullable
        private com.baidu.swan.apps.v.b.c aWn = null;
        private String aWo = "";

        public static a Nv() {
            return new a();
        }

        public a cx(boolean z) {
            this.aWl = z;
            return this;
        }

        public a hK(String str) {
            this.aWo = str;
            return this;
        }

        public c Nw() {
            c cVar = new c();
            cVar.aWl = this.aWl;
            cVar.aWm = this.aWm;
            cVar.aWn = this.aWn;
            cVar.aWo = this.aWo;
            return cVar;
        }

        public c Nx() {
            this.aWl = false;
            this.aWm = false;
            this.aWn = null;
            this.aWo = "";
            return Nw();
        }
    }
}

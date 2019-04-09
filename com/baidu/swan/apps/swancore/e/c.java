package com.baidu.swan.apps.swancore.e;

import android.support.annotation.Nullable;
/* loaded from: classes2.dex */
public class c {
    public boolean aTw;
    public boolean aTx;
    @Nullable
    public com.baidu.swan.apps.v.b.c aTy;

    private c() {
        this.aTw = false;
        this.aTx = false;
        this.aTy = null;
    }

    /* loaded from: classes2.dex */
    public static class a {
        private boolean aTw = false;
        private boolean aTx = false;
        @Nullable
        private com.baidu.swan.apps.v.b.c aTy = null;

        public static a KW() {
            return new a();
        }

        public a ci(boolean z) {
            this.aTw = z;
            return this;
        }

        public c KX() {
            c cVar = new c();
            cVar.aTw = this.aTw;
            cVar.aTx = this.aTx;
            cVar.aTy = this.aTy;
            return cVar;
        }

        public c KY() {
            this.aTw = false;
            this.aTx = false;
            this.aTy = null;
            return KX();
        }
    }
}

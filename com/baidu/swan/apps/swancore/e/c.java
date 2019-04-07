package com.baidu.swan.apps.swancore.e;

import android.support.annotation.Nullable;
/* loaded from: classes2.dex */
public class c {
    public boolean aTv;
    public boolean aTw;
    @Nullable
    public com.baidu.swan.apps.v.b.c aTx;

    private c() {
        this.aTv = false;
        this.aTw = false;
        this.aTx = null;
    }

    /* loaded from: classes2.dex */
    public static class a {
        private boolean aTv = false;
        private boolean aTw = false;
        @Nullable
        private com.baidu.swan.apps.v.b.c aTx = null;

        public static a KW() {
            return new a();
        }

        public a ci(boolean z) {
            this.aTv = z;
            return this;
        }

        public c KX() {
            c cVar = new c();
            cVar.aTv = this.aTv;
            cVar.aTw = this.aTw;
            cVar.aTx = this.aTx;
            return cVar;
        }

        public c KY() {
            this.aTv = false;
            this.aTw = false;
            this.aTx = null;
            return KX();
        }
    }
}

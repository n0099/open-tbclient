package com.baidu.swan.apps.swancore.e;

import android.support.annotation.Nullable;
/* loaded from: classes2.dex */
public class c {
    public boolean aTr;
    public boolean aTs;
    @Nullable
    public com.baidu.swan.apps.v.b.c aTt;

    private c() {
        this.aTr = false;
        this.aTs = false;
        this.aTt = null;
    }

    /* loaded from: classes2.dex */
    public static class a {
        private boolean aTr = false;
        private boolean aTs = false;
        @Nullable
        private com.baidu.swan.apps.v.b.c aTt = null;

        public static a KY() {
            return new a();
        }

        public a ci(boolean z) {
            this.aTr = z;
            return this;
        }

        public c KZ() {
            c cVar = new c();
            cVar.aTr = this.aTr;
            cVar.aTs = this.aTs;
            cVar.aTt = this.aTt;
            return cVar;
        }

        public c La() {
            this.aTr = false;
            this.aTs = false;
            this.aTt = null;
            return KZ();
        }
    }
}

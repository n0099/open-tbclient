package com.baidu.swan.apps.swancore.e;

import android.support.annotation.Nullable;
/* loaded from: classes2.dex */
public class c {
    public boolean aTs;
    public boolean aTt;
    @Nullable
    public com.baidu.swan.apps.v.b.c aTu;

    private c() {
        this.aTs = false;
        this.aTt = false;
        this.aTu = null;
    }

    /* loaded from: classes2.dex */
    public static class a {
        private boolean aTs = false;
        private boolean aTt = false;
        @Nullable
        private com.baidu.swan.apps.v.b.c aTu = null;

        public static a KY() {
            return new a();
        }

        public a ci(boolean z) {
            this.aTs = z;
            return this;
        }

        public c KZ() {
            c cVar = new c();
            cVar.aTs = this.aTs;
            cVar.aTt = this.aTt;
            cVar.aTu = this.aTu;
            return cVar;
        }

        public c La() {
            this.aTs = false;
            this.aTt = false;
            this.aTu = null;
            return KZ();
        }
    }
}

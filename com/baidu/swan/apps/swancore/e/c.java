package com.baidu.swan.apps.swancore.e;

import android.support.annotation.Nullable;
/* loaded from: classes2.dex */
public class c {
    public String bqA;
    public boolean bqx;
    public boolean bqy;
    @Nullable
    public com.baidu.swan.apps.v.b.c bqz;

    private c() {
        this.bqx = false;
        this.bqy = false;
        this.bqz = null;
        this.bqA = "";
    }

    /* loaded from: classes2.dex */
    public static class a {
        private boolean bqx = false;
        private boolean bqy = false;
        @Nullable
        private com.baidu.swan.apps.v.b.c bqz = null;
        private String bqA = "";

        public static a Te() {
            return new a();
        }

        public a cR(boolean z) {
            this.bqx = z;
            return this;
        }

        public a ix(String str) {
            this.bqA = str;
            return this;
        }

        public c Tf() {
            c cVar = new c();
            cVar.bqx = this.bqx;
            cVar.bqy = this.bqy;
            cVar.bqz = this.bqz;
            cVar.bqA = this.bqA;
            return cVar;
        }

        public c Tg() {
            this.bqx = false;
            this.bqy = false;
            this.bqz = null;
            this.bqA = "";
            return Tf();
        }
    }
}

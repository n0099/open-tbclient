package com.baidu.swan.apps.swancore.e;

import android.support.annotation.Nullable;
/* loaded from: classes2.dex */
public class c {
    public boolean bqf;
    public boolean bqg;
    @Nullable
    public com.baidu.swan.apps.v.b.c bqh;
    public String bqi;

    private c() {
        this.bqf = false;
        this.bqg = false;
        this.bqh = null;
        this.bqi = "";
    }

    /* loaded from: classes2.dex */
    public static class a {
        private boolean bqf = false;
        private boolean bqg = false;
        @Nullable
        private com.baidu.swan.apps.v.b.c bqh = null;
        private String bqi = "";

        public static a Tg() {
            return new a();
        }

        public a cR(boolean z) {
            this.bqf = z;
            return this;
        }

        public a ix(String str) {
            this.bqi = str;
            return this;
        }

        public c Th() {
            c cVar = new c();
            cVar.bqf = this.bqf;
            cVar.bqg = this.bqg;
            cVar.bqh = this.bqh;
            cVar.bqi = this.bqi;
            return cVar;
        }

        public c Ti() {
            this.bqf = false;
            this.bqg = false;
            this.bqh = null;
            this.bqi = "";
            return Th();
        }
    }
}

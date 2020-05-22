package com.baidu.swan.apps.swancore.d;

import android.support.annotation.Nullable;
import com.baidu.swan.apps.v.b.c;
/* loaded from: classes11.dex */
public class b {
    public boolean cHv;
    public boolean cHw;
    @Nullable
    public c cHx;
    public String cHy;

    private b() {
        this.cHv = false;
        this.cHw = false;
        this.cHx = null;
        this.cHy = "";
    }

    /* loaded from: classes11.dex */
    public static class a {
        private boolean cHv = false;
        private boolean cHw = false;
        @Nullable
        private c cHx = null;
        private String cHy = "";

        public static a asd() {
            return new a();
        }

        public a fo(boolean z) {
            this.cHv = z;
            return this;
        }

        public a pk(String str) {
            this.cHy = str;
            return this;
        }

        public b ase() {
            b bVar = new b();
            bVar.cHv = this.cHv;
            bVar.cHw = this.cHw;
            bVar.cHx = this.cHx;
            bVar.cHy = this.cHy;
            return bVar;
        }
    }
}

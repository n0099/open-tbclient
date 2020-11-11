package com.baidu.swan.apps.swancore.d;

import android.support.annotation.Nullable;
import com.baidu.swan.apps.u.c.c;
/* loaded from: classes10.dex */
public class b {
    public boolean dBk;
    public boolean dBl;
    @Nullable
    public c dBm;
    public String dBn;

    private b() {
        this.dBk = false;
        this.dBl = false;
        this.dBm = null;
        this.dBn = "";
    }

    /* loaded from: classes10.dex */
    public static class a {
        private boolean dBk = false;
        private boolean dBl = false;
        @Nullable
        private c dBm = null;
        private String dBn = "";

        public static a aLh() {
            return new a();
        }

        public a gM(boolean z) {
            this.dBk = z;
            return this;
        }

        public a tR(String str) {
            this.dBn = str;
            return this;
        }

        public b aLi() {
            b bVar = new b();
            bVar.dBk = this.dBk;
            bVar.dBl = this.dBl;
            bVar.dBm = this.dBm;
            bVar.dBn = this.dBn;
            return bVar;
        }
    }
}

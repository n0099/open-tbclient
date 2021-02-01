package com.baidu.swan.apps.swancore.d;

import androidx.annotation.Nullable;
import com.baidu.swan.apps.u.c.c;
/* loaded from: classes9.dex */
public class b {
    @Nullable
    public c dMA;
    public String dMB;
    public boolean dMy;
    public boolean dMz;

    private b() {
        this.dMy = false;
        this.dMz = false;
        this.dMA = null;
        this.dMB = "";
    }

    /* loaded from: classes9.dex */
    public static class a {
        private boolean dMy = false;
        private boolean dMz = false;
        @Nullable
        private c dMA = null;
        private String dMB = "";

        public static a aMw() {
            return new a();
        }

        public a hu(boolean z) {
            this.dMy = z;
            return this;
        }

        public a ty(String str) {
            this.dMB = str;
            return this;
        }

        public b aMx() {
            b bVar = new b();
            bVar.dMy = this.dMy;
            bVar.dMz = this.dMz;
            bVar.dMA = this.dMA;
            bVar.dMB = this.dMB;
            return bVar;
        }
    }
}

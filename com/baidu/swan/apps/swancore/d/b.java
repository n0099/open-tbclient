package com.baidu.swan.apps.swancore.d;

import android.support.annotation.Nullable;
import com.baidu.swan.apps.u.c.c;
/* loaded from: classes25.dex */
public class b {
    public boolean dGC;
    public boolean dGD;
    @Nullable
    public c dGE;
    public String dGF;

    private b() {
        this.dGC = false;
        this.dGD = false;
        this.dGE = null;
        this.dGF = "";
    }

    /* loaded from: classes25.dex */
    public static class a {
        private boolean dGC = false;
        private boolean dGD = false;
        @Nullable
        private c dGE = null;
        private String dGF = "";

        public static a aNG() {
            return new a();
        }

        public a he(boolean z) {
            this.dGC = z;
            return this;
        }

        public a ut(String str) {
            this.dGF = str;
            return this;
        }

        public b aNH() {
            b bVar = new b();
            bVar.dGC = this.dGC;
            bVar.dGD = this.dGD;
            bVar.dGE = this.dGE;
            bVar.dGF = this.dGF;
            return bVar;
        }
    }
}

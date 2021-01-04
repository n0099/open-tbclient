package com.baidu.swan.apps.swancore.d;

import androidx.annotation.Nullable;
import com.baidu.swan.apps.u.c.c;
/* loaded from: classes9.dex */
public class b {
    public boolean dPg;
    public boolean dPh;
    @Nullable
    public c dPi;
    public String dPj;

    private b() {
        this.dPg = false;
        this.dPh = false;
        this.dPi = null;
        this.dPj = "";
    }

    /* loaded from: classes9.dex */
    public static class a {
        private boolean dPg = false;
        private boolean dPh = false;
        @Nullable
        private c dPi = null;
        private String dPj = "";

        public static a aPW() {
            return new a();
        }

        public a hw(boolean z) {
            this.dPg = z;
            return this;
        }

        public a uq(String str) {
            this.dPj = str;
            return this;
        }

        public b aPX() {
            b bVar = new b();
            bVar.dPg = this.dPg;
            bVar.dPh = this.dPh;
            bVar.dPi = this.dPi;
            bVar.dPj = this.dPj;
            return bVar;
        }
    }
}

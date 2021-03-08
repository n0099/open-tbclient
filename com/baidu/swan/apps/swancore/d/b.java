package com.baidu.swan.apps.swancore.d;

import androidx.annotation.Nullable;
import com.baidu.swan.apps.u.c.c;
/* loaded from: classes8.dex */
public class b {
    public boolean dNZ;
    public boolean dOa;
    @Nullable
    public c dOb;
    public String dOc;

    private b() {
        this.dNZ = false;
        this.dOa = false;
        this.dOb = null;
        this.dOc = "";
    }

    /* loaded from: classes8.dex */
    public static class a {
        private boolean dNZ = false;
        private boolean dOa = false;
        @Nullable
        private c dOb = null;
        private String dOc = "";

        public static a aMz() {
            return new a();
        }

        public a hu(boolean z) {
            this.dNZ = z;
            return this;
        }

        public a tF(String str) {
            this.dOc = str;
            return this;
        }

        public b aMA() {
            b bVar = new b();
            bVar.dNZ = this.dNZ;
            bVar.dOa = this.dOa;
            bVar.dOb = this.dOb;
            bVar.dOc = this.dOc;
            return bVar;
        }
    }
}

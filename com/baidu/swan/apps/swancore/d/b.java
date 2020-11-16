package com.baidu.swan.apps.swancore.d;

import android.support.annotation.Nullable;
import com.baidu.swan.apps.u.c.c;
/* loaded from: classes7.dex */
public class b {
    public boolean dzD;
    public boolean dzE;
    @Nullable
    public c dzF;
    public String dzG;

    private b() {
        this.dzD = false;
        this.dzE = false;
        this.dzF = null;
        this.dzG = "";
    }

    /* loaded from: classes7.dex */
    public static class a {
        private boolean dzD = false;
        private boolean dzE = false;
        @Nullable
        private c dzF = null;
        private String dzG = "";

        public static a aKz() {
            return new a();
        }

        public a gP(boolean z) {
            this.dzD = z;
            return this;
        }

        public a tM(String str) {
            this.dzG = str;
            return this;
        }

        public b aKA() {
            b bVar = new b();
            bVar.dzD = this.dzD;
            bVar.dzE = this.dzE;
            bVar.dzF = this.dzF;
            bVar.dzG = this.dzG;
            return bVar;
        }
    }
}

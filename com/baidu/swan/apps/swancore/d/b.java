package com.baidu.swan.apps.swancore.d;

import android.support.annotation.Nullable;
import com.baidu.swan.apps.u.c.c;
/* loaded from: classes7.dex */
public class b {
    public boolean cPA;
    public boolean cPB;
    @Nullable
    public c cPC;
    public String cPD;

    private b() {
        this.cPA = false;
        this.cPB = false;
        this.cPC = null;
        this.cPD = "";
    }

    /* loaded from: classes7.dex */
    public static class a {
        private boolean cPA = false;
        private boolean cPB = false;
        @Nullable
        private c cPC = null;
        private String cPD = "";

        public static a avl() {
            return new a();
        }

        public a fC(boolean z) {
            this.cPA = z;
            return this;
        }

        public a qd(String str) {
            this.cPD = str;
            return this;
        }

        public b avm() {
            b bVar = new b();
            bVar.cPA = this.cPA;
            bVar.cPB = this.cPB;
            bVar.cPC = this.cPC;
            bVar.cPD = this.cPD;
            return bVar;
        }
    }
}

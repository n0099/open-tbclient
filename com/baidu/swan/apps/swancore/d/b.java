package com.baidu.swan.apps.swancore.d;

import android.support.annotation.Nullable;
import com.baidu.swan.apps.u.c.c;
/* loaded from: classes10.dex */
public class b {
    public boolean dmQ;
    public boolean dmR;
    @Nullable
    public c dmS;
    public String dmT;

    private b() {
        this.dmQ = false;
        this.dmR = false;
        this.dmS = null;
        this.dmT = "";
    }

    /* loaded from: classes10.dex */
    public static class a {
        private boolean dmQ = false;
        private boolean dmR = false;
        @Nullable
        private c dmS = null;
        private String dmT = "";

        public static a aGN() {
            return new a();
        }

        public a gq(boolean z) {
            this.dmQ = z;
            return this;
        }

        public a tk(String str) {
            this.dmT = str;
            return this;
        }

        public b aGO() {
            b bVar = new b();
            bVar.dmQ = this.dmQ;
            bVar.dmR = this.dmR;
            bVar.dmS = this.dmS;
            bVar.dmT = this.dmT;
            return bVar;
        }
    }
}

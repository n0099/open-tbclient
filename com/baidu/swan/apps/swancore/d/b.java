package com.baidu.swan.apps.swancore.d;

import android.support.annotation.Nullable;
import com.baidu.swan.apps.u.c.c;
/* loaded from: classes8.dex */
public class b {
    public boolean cYC;
    public boolean cYD;
    @Nullable
    public c cYE;
    public String cYF;

    private b() {
        this.cYC = false;
        this.cYD = false;
        this.cYE = null;
        this.cYF = "";
    }

    /* loaded from: classes8.dex */
    public static class a {
        private boolean cYC = false;
        private boolean cYD = false;
        @Nullable
        private c cYE = null;
        private String cYF = "";

        public static a aDu() {
            return new a();
        }

        public a fV(boolean z) {
            this.cYC = z;
            return this;
        }

        public a sd(String str) {
            this.cYF = str;
            return this;
        }

        public b aDv() {
            b bVar = new b();
            bVar.cYC = this.cYC;
            bVar.cYD = this.cYD;
            bVar.cYE = this.cYE;
            bVar.cYF = this.cYF;
            return bVar;
        }
    }
}

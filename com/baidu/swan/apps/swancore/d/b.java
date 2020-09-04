package com.baidu.swan.apps.swancore.d;

import android.support.annotation.Nullable;
import com.baidu.swan.apps.u.c.c;
/* loaded from: classes8.dex */
public class b {
    public boolean cYG;
    public boolean cYH;
    @Nullable
    public c cYI;
    public String cYJ;

    private b() {
        this.cYG = false;
        this.cYH = false;
        this.cYI = null;
        this.cYJ = "";
    }

    /* loaded from: classes8.dex */
    public static class a {
        private boolean cYG = false;
        private boolean cYH = false;
        @Nullable
        private c cYI = null;
        private String cYJ = "";

        public static a aDu() {
            return new a();
        }

        public a fW(boolean z) {
            this.cYG = z;
            return this;
        }

        public a se(String str) {
            this.cYJ = str;
            return this;
        }

        public b aDv() {
            b bVar = new b();
            bVar.cYG = this.cYG;
            bVar.cYH = this.cYH;
            bVar.cYI = this.cYI;
            bVar.cYJ = this.cYJ;
            return bVar;
        }
    }
}

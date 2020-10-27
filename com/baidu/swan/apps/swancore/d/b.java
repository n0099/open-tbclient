package com.baidu.swan.apps.swancore.d;

import android.support.annotation.Nullable;
import com.baidu.swan.apps.u.c.c;
/* loaded from: classes10.dex */
public class b {
    public boolean dvs;
    public boolean dvt;
    @Nullable
    public c dvu;
    public String dvv;

    private b() {
        this.dvs = false;
        this.dvt = false;
        this.dvu = null;
        this.dvv = "";
    }

    /* loaded from: classes10.dex */
    public static class a {
        private boolean dvs = false;
        private boolean dvt = false;
        @Nullable
        private c dvu = null;
        private String dvv = "";

        public static a aIH() {
            return new a();
        }

        public a gD(boolean z) {
            this.dvs = z;
            return this;
        }

        public a tD(String str) {
            this.dvv = str;
            return this;
        }

        public b aII() {
            b bVar = new b();
            bVar.dvs = this.dvs;
            bVar.dvt = this.dvt;
            bVar.dvu = this.dvu;
            bVar.dvv = this.dvv;
            return bVar;
        }
    }
}

package com.baidu.swan.apps.swancore.d;

import androidx.annotation.Nullable;
import com.baidu.swan.apps.u.c.c;
/* loaded from: classes8.dex */
public class b {
    public boolean dKu;
    public boolean dKv;
    @Nullable
    public c dKw;
    public String dKx;

    private b() {
        this.dKu = false;
        this.dKv = false;
        this.dKw = null;
        this.dKx = "";
    }

    /* loaded from: classes8.dex */
    public static class a {
        private boolean dKu = false;
        private boolean dKv = false;
        @Nullable
        private c dKw = null;
        private String dKx = "";

        public static a aMd() {
            return new a();
        }

        public a hs(boolean z) {
            this.dKu = z;
            return this;
        }

        public a tf(String str) {
            this.dKx = str;
            return this;
        }

        public b aMe() {
            b bVar = new b();
            bVar.dKu = this.dKu;
            bVar.dKv = this.dKv;
            bVar.dKw = this.dKw;
            bVar.dKx = this.dKx;
            return bVar;
        }
    }
}

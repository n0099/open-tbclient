package com.baidu.swan.apps.swancore.e;

import android.support.annotation.Nullable;
import com.baidu.swan.apps.x.b.c;
/* loaded from: classes11.dex */
public class b {
    public boolean bWm;
    public boolean bWn;
    @Nullable
    public c bWo;
    public String bWp;

    private b() {
        this.bWm = false;
        this.bWn = false;
        this.bWo = null;
        this.bWp = "";
    }

    /* loaded from: classes11.dex */
    public static class a {
        private boolean bWm = false;
        private boolean bWn = false;
        @Nullable
        private c bWo = null;
        private String bWp = "";

        public static a afF() {
            return new a();
        }

        public a dX(boolean z) {
            this.bWm = z;
            return this;
        }

        public a mr(String str) {
            this.bWp = str;
            return this;
        }

        public b afG() {
            b bVar = new b();
            bVar.bWm = this.bWm;
            bVar.bWn = this.bWn;
            bVar.bWo = this.bWo;
            bVar.bWp = this.bWp;
            return bVar;
        }
    }
}

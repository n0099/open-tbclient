package com.baidu.swan.apps.swancore.e;

import android.support.annotation.Nullable;
import com.baidu.swan.apps.x.b.c;
/* loaded from: classes11.dex */
public class b {
    public boolean bWl;
    public boolean bWm;
    @Nullable
    public c bWn;
    public String bWo;

    private b() {
        this.bWl = false;
        this.bWm = false;
        this.bWn = null;
        this.bWo = "";
    }

    /* loaded from: classes11.dex */
    public static class a {
        private boolean bWl = false;
        private boolean bWm = false;
        @Nullable
        private c bWn = null;
        private String bWo = "";

        public static a afF() {
            return new a();
        }

        public a dX(boolean z) {
            this.bWl = z;
            return this;
        }

        public a mr(String str) {
            this.bWo = str;
            return this;
        }

        public b afG() {
            b bVar = new b();
            bVar.bWl = this.bWl;
            bVar.bWm = this.bWm;
            bVar.bWn = this.bWn;
            bVar.bWo = this.bWo;
            return bVar;
        }
    }
}

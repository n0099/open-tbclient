package com.baidu.swan.apps.swancore.e;

import android.support.annotation.Nullable;
import com.baidu.swan.apps.x.b.c;
/* loaded from: classes11.dex */
public class b {
    public boolean bWk;
    public boolean bWl;
    @Nullable
    public c bWm;
    public String bWn;

    private b() {
        this.bWk = false;
        this.bWl = false;
        this.bWm = null;
        this.bWn = "";
    }

    /* loaded from: classes11.dex */
    public static class a {
        private boolean bWk = false;
        private boolean bWl = false;
        @Nullable
        private c bWm = null;
        private String bWn = "";

        public static a afD() {
            return new a();
        }

        public a dX(boolean z) {
            this.bWk = z;
            return this;
        }

        public a mr(String str) {
            this.bWn = str;
            return this;
        }

        public b afE() {
            b bVar = new b();
            bVar.bWk = this.bWk;
            bVar.bWl = this.bWl;
            bVar.bWm = this.bWm;
            bVar.bWn = this.bWn;
            return bVar;
        }
    }
}

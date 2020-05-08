package com.baidu.swan.apps.swancore.e;

import android.support.annotation.Nullable;
import com.baidu.swan.apps.x.b.c;
/* loaded from: classes11.dex */
public class b {
    public boolean cvu;
    public boolean cvv;
    @Nullable
    public c cvw;
    public String cvx;

    private b() {
        this.cvu = false;
        this.cvv = false;
        this.cvw = null;
        this.cvx = "";
    }

    /* loaded from: classes11.dex */
    public static class a {
        private boolean cvu = false;
        private boolean cvv = false;
        @Nullable
        private c cvw = null;
        private String cvx = "";

        public static a anM() {
            return new a();
        }

        public a eU(boolean z) {
            this.cvu = z;
            return this;
        }

        public a nD(String str) {
            this.cvx = str;
            return this;
        }

        public b anN() {
            b bVar = new b();
            bVar.cvu = this.cvu;
            bVar.cvv = this.cvv;
            bVar.cvw = this.cvw;
            bVar.cvx = this.cvx;
            return bVar;
        }
    }
}

package com.baidu.swan.apps.swancore.e;

import android.support.annotation.Nullable;
import com.baidu.swan.apps.x.b.c;
/* loaded from: classes11.dex */
public class b {
    public boolean cvo;
    public boolean cvp;
    @Nullable
    public c cvq;
    public String cvr;

    private b() {
        this.cvo = false;
        this.cvp = false;
        this.cvq = null;
        this.cvr = "";
    }

    /* loaded from: classes11.dex */
    public static class a {
        private boolean cvo = false;
        private boolean cvp = false;
        @Nullable
        private c cvq = null;
        private String cvr = "";

        public static a anN() {
            return new a();
        }

        public a eU(boolean z) {
            this.cvo = z;
            return this;
        }

        public a nD(String str) {
            this.cvr = str;
            return this;
        }

        public b anO() {
            b bVar = new b();
            bVar.cvo = this.cvo;
            bVar.cvp = this.cvp;
            bVar.cvq = this.cvq;
            bVar.cvr = this.cvr;
            return bVar;
        }
    }
}

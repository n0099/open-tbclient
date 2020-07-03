package com.baidu.swan.apps.swancore.d;

import android.support.annotation.Nullable;
import com.baidu.swan.apps.v.b.c;
/* loaded from: classes11.dex */
public class b {
    public boolean cMf;
    public boolean cMg;
    @Nullable
    public c cMh;
    public String cMi;

    private b() {
        this.cMf = false;
        this.cMg = false;
        this.cMh = null;
        this.cMi = "";
    }

    /* loaded from: classes11.dex */
    public static class a {
        private boolean cMf = false;
        private boolean cMg = false;
        @Nullable
        private c cMh = null;
        private String cMi = "";

        public static a atk() {
            return new a();
        }

        public a ft(boolean z) {
            this.cMf = z;
            return this;
        }

        public a ps(String str) {
            this.cMi = str;
            return this;
        }

        public b atl() {
            b bVar = new b();
            bVar.cMf = this.cMf;
            bVar.cMg = this.cMg;
            bVar.cMh = this.cMh;
            bVar.cMi = this.cMi;
            return bVar;
        }
    }
}

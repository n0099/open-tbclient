package com.baidu.swan.apps.swancore.e;

import android.support.annotation.Nullable;
import com.baidu.swan.apps.x.b.c;
/* loaded from: classes10.dex */
public class b {
    public boolean bSg;
    public boolean bSh;
    @Nullable
    public c bSi;
    public String bSj;

    private b() {
        this.bSg = false;
        this.bSh = false;
        this.bSi = null;
        this.bSj = "";
    }

    /* loaded from: classes10.dex */
    public static class a {
        private boolean bSg = false;
        private boolean bSh = false;
        @Nullable
        private c bSi = null;
        private String bSj = "";

        public static a adp() {
            return new a();
        }

        public a dQ(boolean z) {
            this.bSg = z;
            return this;
        }

        public a mc(String str) {
            this.bSj = str;
            return this;
        }

        public b adq() {
            b bVar = new b();
            bVar.bSg = this.bSg;
            bVar.bSh = this.bSh;
            bVar.bSi = this.bSi;
            bVar.bSj = this.bSj;
            return bVar;
        }
    }
}

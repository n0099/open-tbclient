package com.baidu.swan.apps.swancore.e;

import android.support.annotation.Nullable;
import com.baidu.swan.apps.x.b.c;
/* loaded from: classes11.dex */
public class b {
    public String bWA;
    public boolean bWx;
    public boolean bWy;
    @Nullable
    public c bWz;

    private b() {
        this.bWx = false;
        this.bWy = false;
        this.bWz = null;
        this.bWA = "";
    }

    /* loaded from: classes11.dex */
    public static class a {
        private boolean bWx = false;
        private boolean bWy = false;
        @Nullable
        private c bWz = null;
        private String bWA = "";

        public static a afI() {
            return new a();
        }

        public a dY(boolean z) {
            this.bWx = z;
            return this;
        }

        public a mq(String str) {
            this.bWA = str;
            return this;
        }

        public b afJ() {
            b bVar = new b();
            bVar.bWx = this.bWx;
            bVar.bWy = this.bWy;
            bVar.bWz = this.bWz;
            bVar.bWA = this.bWA;
            return bVar;
        }
    }
}

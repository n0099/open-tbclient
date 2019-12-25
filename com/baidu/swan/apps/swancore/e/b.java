package com.baidu.swan.apps.swancore.e;

import android.support.annotation.Nullable;
import com.baidu.swan.apps.x.b.c;
/* loaded from: classes9.dex */
public class b {
    public boolean bRw;
    public boolean bRx;
    @Nullable
    public c bRy;
    public String bRz;

    private b() {
        this.bRw = false;
        this.bRx = false;
        this.bRy = null;
        this.bRz = "";
    }

    /* loaded from: classes9.dex */
    public static class a {
        private boolean bRw = false;
        private boolean bRx = false;
        @Nullable
        private c bRy = null;
        private String bRz = "";

        public static a acS() {
            return new a();
        }

        public a dL(boolean z) {
            this.bRw = z;
            return this;
        }

        public a lZ(String str) {
            this.bRz = str;
            return this;
        }

        public b acT() {
            b bVar = new b();
            bVar.bRw = this.bRw;
            bVar.bRx = this.bRx;
            bVar.bRy = this.bRy;
            bVar.bRz = this.bRz;
            return bVar;
        }
    }
}

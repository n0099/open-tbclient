package com.baidu.swan.apps.swancore.d;

import android.support.annotation.Nullable;
import com.baidu.swan.apps.u.c.c;
/* loaded from: classes3.dex */
public class b {
    public boolean daI;
    public boolean daJ;
    @Nullable
    public c daK;
    public String daL;

    private b() {
        this.daI = false;
        this.daJ = false;
        this.daK = null;
        this.daL = "";
    }

    /* loaded from: classes3.dex */
    public static class a {
        private boolean daI = false;
        private boolean daJ = false;
        @Nullable
        private c daK = null;
        private String daL = "";

        public static a aEe() {
            return new a();
        }

        public a fU(boolean z) {
            this.daI = z;
            return this;
        }

        public a sy(String str) {
            this.daL = str;
            return this;
        }

        public b aEf() {
            b bVar = new b();
            bVar.daI = this.daI;
            bVar.daJ = this.daJ;
            bVar.daK = this.daK;
            bVar.daL = this.daL;
            return bVar;
        }
    }
}

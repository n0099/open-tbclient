package com.baidu.swan.apps.env.b;

import android.support.annotation.NonNull;
import com.baidu.swan.pms.e.b;
/* loaded from: classes10.dex */
public final class a implements com.baidu.swan.pms.e.b {
    private boolean cMA;
    private com.baidu.swan.pms.e.b cMB;
    private String cMz;

    private a() {
    }

    @Override // com.baidu.swan.pms.e.b
    public void a(String str, b.a aVar) {
        if (this.cMB != null) {
            this.cMB.a(str, aVar);
        } else if (aVar != null) {
            aVar.eU(true);
        }
    }

    public String aqO() {
        return this.cMz;
    }

    public boolean aqP() {
        return this.cMA;
    }

    @NonNull
    public String toString() {
        return "SoLib:: libName=" + this.cMz + " buildin=" + this.cMA;
    }

    /* renamed from: com.baidu.swan.apps.env.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0426a {
        private a cMC;

        private a aqQ() {
            if (this.cMC == null) {
                this.cMC = new a();
            }
            return this.cMC;
        }

        public C0426a nH(String str) {
            aqQ().cMz = str;
            return this;
        }

        public C0426a eT(boolean z) {
            aqQ().cMA = z;
            return this;
        }

        public C0426a a(com.baidu.swan.pms.e.b bVar) {
            aqQ().cMB = bVar;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public a aqR() {
            a aVar = this.cMC;
            this.cMC = null;
            return aVar;
        }
    }
}

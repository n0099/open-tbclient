package com.baidu.swan.apps.env.b;

import android.support.annotation.NonNull;
import com.baidu.swan.pms.e.b;
/* loaded from: classes25.dex */
public final class a implements com.baidu.swan.pms.e.b {
    private String cXB;
    private boolean cXC;
    private com.baidu.swan.pms.e.b cXD;

    private a() {
    }

    @Override // com.baidu.swan.pms.e.b
    public void a(String str, b.a aVar) {
        if (this.cXD != null) {
            this.cXD.a(str, aVar);
        } else if (aVar != null) {
            aVar.fv(true);
        }
    }

    public String avP() {
        return this.cXB;
    }

    public boolean avQ() {
        return this.cXC;
    }

    @NonNull
    public String toString() {
        return "SoLib:: libName=" + this.cXB + " buildin=" + this.cXC;
    }

    /* renamed from: com.baidu.swan.apps.env.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public static class C0448a {
        private a cXE;

        private a avR() {
            if (this.cXE == null) {
                this.cXE = new a();
            }
            return this.cXE;
        }

        public C0448a oy(String str) {
            avR().cXB = str;
            return this;
        }

        public C0448a fu(boolean z) {
            avR().cXC = z;
            return this;
        }

        public C0448a a(com.baidu.swan.pms.e.b bVar) {
            avR().cXD = bVar;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public a avS() {
            a aVar = this.cXE;
            this.cXE = null;
            return aVar;
        }
    }
}

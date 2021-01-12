package com.baidu.swan.apps.env.b;

import androidx.annotation.NonNull;
import com.baidu.swan.pms.e.b;
/* loaded from: classes8.dex */
public final class a implements com.baidu.swan.pms.e.b {
    private boolean cXI;
    private com.baidu.swan.pms.e.b cXJ;
    private String libName;

    private a() {
    }

    @Override // com.baidu.swan.pms.e.b
    public void a(String str, b.a aVar) {
        if (this.cXJ != null) {
            this.cXJ.a(str, aVar);
        } else if (aVar != null) {
            aVar.fA(true);
        }
    }

    public String ato() {
        return this.libName;
    }

    public boolean atp() {
        return this.cXI;
    }

    @NonNull
    public String toString() {
        return "SoLib:: libName=" + this.libName + " buildin=" + this.cXI;
    }

    /* renamed from: com.baidu.swan.apps.env.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0423a {
        private a cXK;

        private a atq() {
            if (this.cXK == null) {
                this.cXK = new a();
            }
            return this.cXK;
        }

        public C0423a ne(String str) {
            atq().libName = str;
            return this;
        }

        public C0423a fz(boolean z) {
            atq().cXI = z;
            return this;
        }

        public C0423a a(com.baidu.swan.pms.e.b bVar) {
            atq().cXJ = bVar;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public a atr() {
            a aVar = this.cXK;
            this.cXK = null;
            return aVar;
        }
    }
}

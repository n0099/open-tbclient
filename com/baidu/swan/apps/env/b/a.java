package com.baidu.swan.apps.env.b;

import androidx.annotation.NonNull;
import com.baidu.swan.pms.e.b;
/* loaded from: classes9.dex */
public final class a implements com.baidu.swan.pms.e.b {
    private boolean dcx;
    private com.baidu.swan.pms.e.b dcy;
    private String libName;

    private a() {
    }

    @Override // com.baidu.swan.pms.e.b
    public void a(String str, b.a aVar) {
        if (this.dcy != null) {
            this.dcy.a(str, aVar);
        } else if (aVar != null) {
            aVar.fE(true);
        }
    }

    public String axi() {
        return this.libName;
    }

    public boolean axj() {
        return this.dcx;
    }

    @NonNull
    public String toString() {
        return "SoLib:: libName=" + this.libName + " buildin=" + this.dcx;
    }

    /* renamed from: com.baidu.swan.apps.env.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0440a {
        private a dcz;

        private a axk() {
            if (this.dcz == null) {
                this.dcz = new a();
            }
            return this.dcz;
        }

        public C0440a or(String str) {
            axk().libName = str;
            return this;
        }

        public C0440a fD(boolean z) {
            axk().dcx = z;
            return this;
        }

        public C0440a a(com.baidu.swan.pms.e.b bVar) {
            axk().dcy = bVar;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public a axl() {
            a aVar = this.dcz;
            this.dcz = null;
            return aVar;
        }
    }
}

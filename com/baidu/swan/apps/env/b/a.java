package com.baidu.swan.apps.env.b;

import androidx.annotation.NonNull;
import com.baidu.swan.pms.e.b;
/* loaded from: classes9.dex */
public final class a implements com.baidu.swan.pms.e.b {
    private boolean cZS;
    private com.baidu.swan.pms.e.b cZT;
    private String libName;

    private a() {
    }

    @Override // com.baidu.swan.pms.e.b
    public void a(String str, b.a aVar) {
        if (this.cZT != null) {
            this.cZT.a(str, aVar);
        } else if (aVar != null) {
            aVar.fC(true);
        }
    }

    public String atM() {
        return this.libName;
    }

    public boolean atN() {
        return this.cZS;
    }

    @NonNull
    public String toString() {
        return "SoLib:: libName=" + this.libName + " buildin=" + this.cZS;
    }

    /* renamed from: com.baidu.swan.apps.env.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0420a {
        private a cZU;

        private a atO() {
            if (this.cZU == null) {
                this.cZU = new a();
            }
            return this.cZU;
        }

        public C0420a nw(String str) {
            atO().libName = str;
            return this;
        }

        public C0420a fB(boolean z) {
            atO().cZS = z;
            return this;
        }

        public C0420a a(com.baidu.swan.pms.e.b bVar) {
            atO().cZT = bVar;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public a atP() {
            a aVar = this.cZU;
            this.cZU = null;
            return aVar;
        }
    }
}

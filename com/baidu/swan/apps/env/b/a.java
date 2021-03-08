package com.baidu.swan.apps.env.b;

import androidx.annotation.NonNull;
import com.baidu.swan.pms.e.b;
/* loaded from: classes8.dex */
public final class a implements com.baidu.swan.pms.e.b {
    private String dbu;
    private boolean dbv;
    private com.baidu.swan.pms.e.b dbw;

    private a() {
    }

    @Override // com.baidu.swan.pms.e.b
    public void a(String str, b.a aVar) {
        if (this.dbw != null) {
            this.dbw.a(str, aVar);
        } else if (aVar != null) {
            aVar.fC(true);
        }
    }

    public String atP() {
        return this.dbu;
    }

    public boolean atQ() {
        return this.dbv;
    }

    @NonNull
    public String toString() {
        return "SoLib:: libName=" + this.dbu + " buildin=" + this.dbv;
    }

    /* renamed from: com.baidu.swan.apps.env.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0426a {
        private a dbx;

        private a atR() {
            if (this.dbx == null) {
                this.dbx = new a();
            }
            return this.dbx;
        }

        public C0426a nD(String str) {
            atR().dbu = str;
            return this;
        }

        public C0426a fB(boolean z) {
            atR().dbv = z;
            return this;
        }

        public C0426a a(com.baidu.swan.pms.e.b bVar) {
            atR().dbw = bVar;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public a atS() {
            a aVar = this.dbx;
            this.dbx = null;
            return aVar;
        }
    }
}

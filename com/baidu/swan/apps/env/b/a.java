package com.baidu.swan.apps.env.b;

import android.support.annotation.NonNull;
import com.baidu.swan.pms.e.b;
/* loaded from: classes10.dex */
public final class a implements com.baidu.swan.pms.e.b {
    private String cEd;
    private boolean cEe;
    private com.baidu.swan.pms.e.b cEf;

    private a() {
    }

    @Override // com.baidu.swan.pms.e.b
    public void a(String str, b.a aVar) {
        if (this.cEf != null) {
            this.cEf.a(str, aVar);
        } else if (aVar != null) {
            aVar.eH(true);
        }
    }

    public String aoT() {
        return this.cEd;
    }

    public boolean aoU() {
        return this.cEe;
    }

    @NonNull
    public String toString() {
        return "SoLib:: libName=" + this.cEd + " buildin=" + this.cEe;
    }

    /* renamed from: com.baidu.swan.apps.env.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0412a {
        private a cEg;

        private a aoV() {
            if (this.cEg == null) {
                this.cEg = new a();
            }
            return this.cEg;
        }

        public C0412a no(String str) {
            aoV().cEd = str;
            return this;
        }

        public C0412a eG(boolean z) {
            aoV().cEe = z;
            return this;
        }

        public C0412a a(com.baidu.swan.pms.e.b bVar) {
            aoV().cEf = bVar;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public a aoW() {
            a aVar = this.cEg;
            this.cEg = null;
            return aVar;
        }
    }
}

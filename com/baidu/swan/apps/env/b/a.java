package com.baidu.swan.apps.env.b;

import android.support.annotation.NonNull;
import com.baidu.swan.pms.e.b;
/* loaded from: classes10.dex */
public final class a implements com.baidu.swan.pms.e.b {
    private String cSs;
    private boolean cSt;
    private com.baidu.swan.pms.e.b cSu;

    private a() {
    }

    @Override // com.baidu.swan.pms.e.b
    public void a(String str, b.a aVar) {
        if (this.cSu != null) {
            this.cSu.a(str, aVar);
        } else if (aVar != null) {
            aVar.fd(true);
        }
    }

    public String atp() {
        return this.cSs;
    }

    public boolean atq() {
        return this.cSt;
    }

    @NonNull
    public String toString() {
        return "SoLib:: libName=" + this.cSs + " buildin=" + this.cSt;
    }

    /* renamed from: com.baidu.swan.apps.env.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0438a {
        private a cSv;

        private a atr() {
            if (this.cSv == null) {
                this.cSv = new a();
            }
            return this.cSv;
        }

        public C0438a nV(String str) {
            atr().cSs = str;
            return this;
        }

        public C0438a fc(boolean z) {
            atr().cSt = z;
            return this;
        }

        public C0438a a(com.baidu.swan.pms.e.b bVar) {
            atr().cSu = bVar;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public a ats() {
            a aVar = this.cSv;
            this.cSv = null;
            return aVar;
        }
    }
}

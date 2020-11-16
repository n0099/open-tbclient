package com.baidu.swan.apps.env.b;

import android.support.annotation.NonNull;
import com.baidu.swan.pms.e.b;
/* loaded from: classes7.dex */
public final class a implements com.baidu.swan.pms.e.b {
    private String cQI;
    private boolean cQJ;
    private com.baidu.swan.pms.e.b cQK;

    private a() {
    }

    @Override // com.baidu.swan.pms.e.b
    public void a(String str, b.a aVar) {
        if (this.cQK != null) {
            this.cQK.a(str, aVar);
        } else if (aVar != null) {
            aVar.fg(true);
        }
    }

    public String asH() {
        return this.cQI;
    }

    public boolean asI() {
        return this.cQJ;
    }

    @NonNull
    public String toString() {
        return "SoLib:: libName=" + this.cQI + " buildin=" + this.cQJ;
    }

    /* renamed from: com.baidu.swan.apps.env.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0436a {
        private a cQL;

        private a asJ() {
            if (this.cQL == null) {
                this.cQL = new a();
            }
            return this.cQL;
        }

        public C0436a nP(String str) {
            asJ().cQI = str;
            return this;
        }

        public C0436a ff(boolean z) {
            asJ().cQJ = z;
            return this;
        }

        public C0436a a(com.baidu.swan.pms.e.b bVar) {
            asJ().cQK = bVar;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public a asK() {
            a aVar = this.cQL;
            this.cQL = null;
            return aVar;
        }
    }
}

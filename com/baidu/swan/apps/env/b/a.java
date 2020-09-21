package com.baidu.swan.apps.env.b;

import android.support.annotation.NonNull;
import com.baidu.swan.pms.e.b;
/* loaded from: classes3.dex */
public final class a implements com.baidu.swan.pms.e.b {
    private String crS;
    private boolean crT;
    private com.baidu.swan.pms.e.b crU;

    private a() {
    }

    @Override // com.baidu.swan.pms.e.b
    public void a(String str, b.a aVar) {
        if (this.crU != null) {
            this.crU.a(str, aVar);
        } else if (aVar != null) {
            aVar.el(true);
        }
    }

    public String ami() {
        return this.crS;
    }

    public boolean amj() {
        return this.crT;
    }

    @NonNull
    public String toString() {
        return "SoLib:: libName=" + this.crS + " buildin=" + this.crT;
    }

    /* renamed from: com.baidu.swan.apps.env.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0395a {
        private a crV;

        private a amk() {
            if (this.crV == null) {
                this.crV = new a();
            }
            return this.crV;
        }

        public C0395a mC(String str) {
            amk().crS = str;
            return this;
        }

        public C0395a ek(boolean z) {
            amk().crT = z;
            return this;
        }

        public C0395a a(com.baidu.swan.pms.e.b bVar) {
            amk().crU = bVar;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public a aml() {
            a aVar = this.crV;
            this.crV = null;
            return aVar;
        }
    }
}

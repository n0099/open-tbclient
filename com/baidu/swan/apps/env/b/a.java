package com.baidu.swan.apps.env.b;

import android.support.annotation.NonNull;
import com.baidu.swan.pms.e.b;
/* loaded from: classes8.dex */
public final class a implements com.baidu.swan.pms.e.b {
    private String cpP;
    private boolean cpQ;
    private com.baidu.swan.pms.e.b cpR;

    private a() {
    }

    @Override // com.baidu.swan.pms.e.b
    public void a(String str, b.a aVar) {
        if (this.cpR != null) {
            this.cpR.a(str, aVar);
        } else if (aVar != null) {
            aVar.en(true);
        }
    }

    public String aly() {
        return this.cpP;
    }

    public boolean alz() {
        return this.cpQ;
    }

    @NonNull
    public String toString() {
        return "SoLib:: libName=" + this.cpP + " buildin=" + this.cpQ;
    }

    /* renamed from: com.baidu.swan.apps.env.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0400a {
        private a cpS;

        private a alA() {
            if (this.cpS == null) {
                this.cpS = new a();
            }
            return this.cpS;
        }

        public C0400a mj(String str) {
            alA().cpP = str;
            return this;
        }

        public C0400a em(boolean z) {
            alA().cpQ = z;
            return this;
        }

        public C0400a a(com.baidu.swan.pms.e.b bVar) {
            alA().cpR = bVar;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public a alB() {
            a aVar = this.cpS;
            this.cpS = null;
            return aVar;
        }
    }
}

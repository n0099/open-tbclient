package com.baidu.swan.apps.env.b;

import android.support.annotation.NonNull;
import com.baidu.swan.pms.e.b;
/* loaded from: classes8.dex */
public final class a implements com.baidu.swan.pms.e.b {
    private String cpL;
    private boolean cpM;
    private com.baidu.swan.pms.e.b cpN;

    private a() {
    }

    @Override // com.baidu.swan.pms.e.b
    public void a(String str, b.a aVar) {
        if (this.cpN != null) {
            this.cpN.a(str, aVar);
        } else if (aVar != null) {
            aVar.em(true);
        }
    }

    public String aly() {
        return this.cpL;
    }

    public boolean alz() {
        return this.cpM;
    }

    @NonNull
    public String toString() {
        return "SoLib:: libName=" + this.cpL + " buildin=" + this.cpM;
    }

    /* renamed from: com.baidu.swan.apps.env.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0400a {
        private a cpO;

        private a alA() {
            if (this.cpO == null) {
                this.cpO = new a();
            }
            return this.cpO;
        }

        public C0400a mi(String str) {
            alA().cpL = str;
            return this;
        }

        public C0400a el(boolean z) {
            alA().cpM = z;
            return this;
        }

        public C0400a a(com.baidu.swan.pms.e.b bVar) {
            alA().cpN = bVar;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public a alB() {
            a aVar = this.cpO;
            this.cpO = null;
            return aVar;
        }
    }
}

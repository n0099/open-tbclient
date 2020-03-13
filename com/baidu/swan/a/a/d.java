package com.baidu.swan.a.a;

import android.os.Bundle;
import com.baidu.swan.a.e;
import java.util.Set;
/* loaded from: classes11.dex */
public class d extends com.baidu.swan.a.a<c> {
    private e<c> cfA;
    private com.baidu.swan.pms.a.c<c> cfB = new com.baidu.swan.pms.a.b<c>() { // from class: com.baidu.swan.a.a.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c
        /* renamed from: c */
        public String K(c cVar) {
            return null;
        }

        @Override // com.baidu.swan.pms.a.e
        public Bundle a(Bundle bundle, Set<String> set) {
            return d.this.a(bundle, set);
        }

        @Override // com.baidu.swan.pms.a.b
        protected int getPriority() {
            return 200;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: d */
        public void I(c cVar) {
            super.I(cVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: e */
        public void H(c cVar) {
            super.H(cVar);
            if (d.this.cfA != null) {
                d.this.cfA.n(cVar.currentSize, cVar.size);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        public void a(c cVar, com.baidu.swan.pms.model.a aVar) {
            super.a((AnonymousClass1) cVar, aVar);
            if (d.this.cfA != null) {
                d.this.cfA.E(aVar.errorNo, aVar.errorMsg);
            }
            com.baidu.swan.d.c.rg(cVar.filePath);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: f */
        public void G(c cVar) {
            super.G(cVar);
            if (d.this.cfA != null) {
                d.this.cfA.P(cVar);
            }
        }
    };

    public d(e<c> eVar) {
        this.cfA = eVar;
    }

    @Override // com.baidu.swan.pms.a.g
    public void Pm() {
        super.Pm();
    }

    @Override // com.baidu.swan.pms.a.g
    public void a(com.baidu.swan.pms.model.a aVar) {
        super.a(aVar);
        if (this.cfA != null) {
            this.cfA.E(aVar.errorNo, aVar.errorMsg);
        }
    }

    @Override // com.baidu.swan.a.a
    public com.baidu.swan.pms.a.c<c> ajj() {
        return this.cfB;
    }
}

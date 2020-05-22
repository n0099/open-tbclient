package com.baidu.swan.a.a;

import android.os.Bundle;
import com.baidu.swan.a.e;
import java.util.Set;
/* loaded from: classes11.dex */
public class d extends com.baidu.swan.a.a<c> {
    private e<c> cOY;
    private com.baidu.swan.pms.a.c<c> cOZ = new com.baidu.swan.pms.a.b<c>() { // from class: com.baidu.swan.a.a.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c
        /* renamed from: c */
        public String P(c cVar) {
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
        public void N(c cVar) {
            super.N(cVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: e */
        public void M(c cVar) {
            super.M(cVar);
            if (d.this.cOY != null) {
                d.this.cOY.p(cVar.currentSize, cVar.size);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        public void a(c cVar, com.baidu.swan.pms.model.a aVar) {
            super.a((AnonymousClass1) cVar, aVar);
            if (d.this.cOY != null) {
                d.this.cOY.W(aVar.errorNo, aVar.errorMsg);
            }
            com.baidu.swan.e.d.tW(cVar.filePath);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: f */
        public void L(c cVar) {
            super.L(cVar);
            if (d.this.cOY != null) {
                d.this.cOY.V(cVar);
            }
        }
    };

    public d(e<c> eVar) {
        this.cOY = eVar;
    }

    @Override // com.baidu.swan.pms.a.g
    public void ZP() {
        super.ZP();
    }

    @Override // com.baidu.swan.pms.a.g
    public void b(com.baidu.swan.pms.model.a aVar) {
        super.b(aVar);
        if (this.cOY != null) {
            this.cOY.W(aVar.errorNo, aVar.errorMsg);
        }
    }

    @Override // com.baidu.swan.a.a
    public com.baidu.swan.pms.a.c<c> avc() {
        return this.cOZ;
    }
}

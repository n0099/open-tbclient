package com.baidu.swan.a.a;

import android.os.Bundle;
import com.baidu.swan.a.e;
import java.util.Set;
/* loaded from: classes11.dex */
public class d extends com.baidu.swan.a.a<c> {
    private e<c> cTI;
    private com.baidu.swan.pms.a.c<c> cTJ = new com.baidu.swan.pms.a.b<c>() { // from class: com.baidu.swan.a.a.d.1
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
            if (d.this.cTI != null) {
                d.this.cTI.p(cVar.currentSize, cVar.size);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        public void a(c cVar, com.baidu.swan.pms.model.a aVar) {
            super.a((AnonymousClass1) cVar, aVar);
            if (d.this.cTI != null) {
                d.this.cTI.Y(aVar.errorNo, aVar.errorMsg);
            }
            com.baidu.swan.e.d.ue(cVar.filePath);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: f */
        public void L(c cVar) {
            super.L(cVar);
            if (d.this.cTI != null) {
                d.this.cTI.V(cVar);
            }
        }
    };

    public d(e<c> eVar) {
        this.cTI = eVar;
    }

    @Override // com.baidu.swan.pms.a.g
    public void aaV() {
        super.aaV();
    }

    @Override // com.baidu.swan.pms.a.g
    public void b(com.baidu.swan.pms.model.a aVar) {
        super.b(aVar);
        if (this.cTI != null) {
            this.cTI.Y(aVar.errorNo, aVar.errorMsg);
        }
    }

    @Override // com.baidu.swan.a.a
    public com.baidu.swan.pms.a.c<c> awi() {
        return this.cTJ;
    }
}

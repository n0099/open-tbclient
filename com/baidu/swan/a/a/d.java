package com.baidu.swan.a.a;

import android.os.Bundle;
import com.baidu.swan.a.e;
import java.util.Set;
/* loaded from: classes3.dex */
public class d extends com.baidu.swan.a.a<c> {
    private e<c> cYl;
    private com.baidu.swan.pms.a.c<c> cYm = new com.baidu.swan.pms.a.b<c>() { // from class: com.baidu.swan.a.a.d.1
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

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.pms.a.b
        public int getPriority() {
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
            if (d.this.cYl != null) {
                d.this.cYl.q(cVar.currentSize, cVar.size);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        public void a(c cVar, com.baidu.swan.pms.model.a aVar) {
            super.a((AnonymousClass1) cVar, aVar);
            if (d.this.cYl != null) {
                d.this.cYl.Z(aVar.errorNo, aVar.errorMsg);
            }
            com.baidu.swan.d.d.vh(cVar.filePath);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: f */
        public void L(c cVar) {
            super.L(cVar);
            if (d.this.cYl != null) {
                d.this.cYl.V(cVar);
            }
        }
    };

    public d(e<c> eVar) {
        this.cYl = eVar;
    }

    @Override // com.baidu.swan.pms.a.g
    public void abX() {
        super.abX();
    }

    @Override // com.baidu.swan.pms.a.g
    public void b(com.baidu.swan.pms.model.a aVar) {
        super.b(aVar);
        if (this.cYl != null) {
            this.cYl.Z(aVar.errorNo, aVar.errorMsg);
        }
    }

    @Override // com.baidu.swan.a.a
    public com.baidu.swan.pms.a.c<c> ayW() {
        return this.cYm;
    }
}

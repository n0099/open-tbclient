package com.baidu.swan.apps.p.b;

import android.os.Bundle;
import android.support.annotation.NonNull;
import com.baidu.swan.apps.p.b.a;
/* loaded from: classes7.dex */
public class b extends com.baidu.swan.apps.p.b<a> {
    public b(@NonNull a aVar) {
        super(aVar);
        ((a) this.cma).a(new a.InterfaceC0371a() { // from class: com.baidu.swan.apps.p.b.b.1
            @Override // com.baidu.swan.apps.p.b.a.InterfaceC0371a
            public void B(Bundle bundle) {
                if (b.this.clZ != null) {
                    b.this.clZ.onCallback(b.this, "onMediaMetadataExtracted", bundle);
                }
            }

            @Override // com.baidu.swan.apps.p.b.a.InterfaceC0371a
            public void onRelease() {
                if (b.this.clZ != null) {
                    b.this.clZ = null;
                }
            }
        });
        this.clY.a(new com.baidu.swan.apps.p.b.a.a());
        this.clY.a(new com.baidu.swan.apps.p.b.a.b());
    }
}

package com.baidu.swan.apps.inlinewidget.b;

import android.os.Bundle;
import android.support.annotation.NonNull;
import com.baidu.swan.apps.inlinewidget.b.a;
/* loaded from: classes25.dex */
public class b extends com.baidu.swan.apps.inlinewidget.b<a> {
    public b(@NonNull a aVar) {
        super(aVar);
        ((a) this.dba).a(new a.InterfaceC0455a() { // from class: com.baidu.swan.apps.inlinewidget.b.b.1
            @Override // com.baidu.swan.apps.inlinewidget.b.a.InterfaceC0455a
            public void z(Bundle bundle) {
                if (b.this.daZ != null) {
                    b.this.daZ.onCallback(b.this, "onMediaMetadataExtracted", bundle);
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.b.a.InterfaceC0455a
            public void onRelease() {
                if (b.this.daZ != null) {
                    b.this.daZ = null;
                }
            }
        });
        this.daY.a(new com.baidu.swan.apps.inlinewidget.b.a.a());
        this.daY.a(new com.baidu.swan.apps.inlinewidget.b.a.b());
    }
}

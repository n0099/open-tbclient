package com.baidu.swan.apps.inlinewidget.b;

import android.os.Bundle;
import android.support.annotation.NonNull;
import com.baidu.swan.apps.inlinewidget.b.a;
/* loaded from: classes10.dex */
public class b extends com.baidu.swan.apps.inlinewidget.b<a> {
    public b(@NonNull a aVar) {
        super(aVar);
        ((a) this.cVO).a(new a.InterfaceC0445a() { // from class: com.baidu.swan.apps.inlinewidget.b.b.1
            @Override // com.baidu.swan.apps.inlinewidget.b.a.InterfaceC0445a
            public void z(Bundle bundle) {
                if (b.this.cVN != null) {
                    b.this.cVN.onCallback(b.this, "onMediaMetadataExtracted", bundle);
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.b.a.InterfaceC0445a
            public void onRelease() {
                if (b.this.cVN != null) {
                    b.this.cVN = null;
                }
            }
        });
        this.cVM.a(new com.baidu.swan.apps.inlinewidget.b.a.a());
        this.cVM.a(new com.baidu.swan.apps.inlinewidget.b.a.b());
    }
}

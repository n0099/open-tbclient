package com.baidu.swan.apps.inlinewidget.b;

import android.os.Bundle;
import android.support.annotation.NonNull;
import com.baidu.swan.apps.inlinewidget.b.a;
/* loaded from: classes8.dex */
public class b extends com.baidu.swan.apps.inlinewidget.b<a> {
    public b(@NonNull a aVar) {
        super(aVar);
        ((a) this.cti).a(new a.InterfaceC0407a() { // from class: com.baidu.swan.apps.inlinewidget.b.b.1
            @Override // com.baidu.swan.apps.inlinewidget.b.a.InterfaceC0407a
            public void z(Bundle bundle) {
                if (b.this.cth != null) {
                    b.this.cth.onCallback(b.this, "onMediaMetadataExtracted", bundle);
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.b.a.InterfaceC0407a
            public void onRelease() {
                if (b.this.cth != null) {
                    b.this.cth = null;
                }
            }
        });
        this.ctg.a(new com.baidu.swan.apps.inlinewidget.b.a.a());
        this.ctg.a(new com.baidu.swan.apps.inlinewidget.b.a.b());
    }
}

package com.baidu.swan.apps.inlinewidget.b;

import android.os.Bundle;
import android.support.annotation.NonNull;
import com.baidu.swan.apps.inlinewidget.b.a;
/* loaded from: classes7.dex */
public class b extends com.baidu.swan.apps.inlinewidget.b<a> {
    public b(@NonNull a aVar) {
        super(aVar);
        ((a) this.cUe).a(new a.InterfaceC0443a() { // from class: com.baidu.swan.apps.inlinewidget.b.b.1
            @Override // com.baidu.swan.apps.inlinewidget.b.a.InterfaceC0443a
            public void z(Bundle bundle) {
                if (b.this.cUd != null) {
                    b.this.cUd.onCallback(b.this, "onMediaMetadataExtracted", bundle);
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.b.a.InterfaceC0443a
            public void onRelease() {
                if (b.this.cUd != null) {
                    b.this.cUd = null;
                }
            }
        });
        this.cUc.a(new com.baidu.swan.apps.inlinewidget.b.a.a());
        this.cUc.a(new com.baidu.swan.apps.inlinewidget.b.a.b());
    }
}

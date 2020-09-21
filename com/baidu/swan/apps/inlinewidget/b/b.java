package com.baidu.swan.apps.inlinewidget.b;

import android.os.Bundle;
import android.support.annotation.NonNull;
import com.baidu.swan.apps.inlinewidget.b.a;
/* loaded from: classes3.dex */
public class b extends com.baidu.swan.apps.inlinewidget.b<a> {
    public b(@NonNull a aVar) {
        super(aVar);
        ((a) this.cvs).a(new a.InterfaceC0402a() { // from class: com.baidu.swan.apps.inlinewidget.b.b.1
            @Override // com.baidu.swan.apps.inlinewidget.b.a.InterfaceC0402a
            public void z(Bundle bundle) {
                if (b.this.cvr != null) {
                    b.this.cvr.onCallback(b.this, "onMediaMetadataExtracted", bundle);
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.b.a.InterfaceC0402a
            public void onRelease() {
                if (b.this.cvr != null) {
                    b.this.cvr = null;
                }
            }
        });
        this.cvq.a(new com.baidu.swan.apps.inlinewidget.b.a.a());
        this.cvq.a(new com.baidu.swan.apps.inlinewidget.b.a.b());
    }
}

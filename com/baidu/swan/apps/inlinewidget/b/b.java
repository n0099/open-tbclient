package com.baidu.swan.apps.inlinewidget.b;

import android.os.Bundle;
import android.support.annotation.NonNull;
import com.baidu.swan.apps.inlinewidget.b.a;
/* loaded from: classes10.dex */
public class b extends com.baidu.swan.apps.inlinewidget.b<a> {
    public b(@NonNull a aVar) {
        super(aVar);
        ((a) this.cHz).a(new a.InterfaceC0419a() { // from class: com.baidu.swan.apps.inlinewidget.b.b.1
            @Override // com.baidu.swan.apps.inlinewidget.b.a.InterfaceC0419a
            public void z(Bundle bundle) {
                if (b.this.cHy != null) {
                    b.this.cHy.onCallback(b.this, "onMediaMetadataExtracted", bundle);
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.b.a.InterfaceC0419a
            public void onRelease() {
                if (b.this.cHy != null) {
                    b.this.cHy = null;
                }
            }
        });
        this.cHx.a(new com.baidu.swan.apps.inlinewidget.b.a.a());
        this.cHx.a(new com.baidu.swan.apps.inlinewidget.b.a.b());
    }
}

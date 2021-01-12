package com.baidu.swan.apps.inlinewidget.b;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.inlinewidget.b.a;
/* loaded from: classes8.dex */
public class b extends com.baidu.swan.apps.inlinewidget.b<a> {
    public b(@NonNull a aVar) {
        super(aVar);
        ((a) this.dbg).a(new a.InterfaceC0430a() { // from class: com.baidu.swan.apps.inlinewidget.b.b.1
            @Override // com.baidu.swan.apps.inlinewidget.b.a.InterfaceC0430a
            public void z(Bundle bundle) {
                if (b.this.dbf != null) {
                    b.this.dbf.onCallback(b.this, "onMediaMetadataExtracted", bundle);
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.b.a.InterfaceC0430a
            public void onRelease() {
                if (b.this.dbf != null) {
                    b.this.dbf = null;
                }
            }
        });
        this.dbe.a(new com.baidu.swan.apps.inlinewidget.b.a.a());
        this.dbe.a(new com.baidu.swan.apps.inlinewidget.b.a.b());
    }
}

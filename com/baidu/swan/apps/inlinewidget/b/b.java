package com.baidu.swan.apps.inlinewidget.b;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.inlinewidget.b.a;
/* loaded from: classes8.dex */
public class b extends com.baidu.swan.apps.inlinewidget.b<a> {
    public b(@NonNull a aVar) {
        super(aVar);
        ((a) this.deV).a(new a.InterfaceC0433a() { // from class: com.baidu.swan.apps.inlinewidget.b.b.1
            @Override // com.baidu.swan.apps.inlinewidget.b.a.InterfaceC0433a
            public void z(Bundle bundle) {
                if (b.this.deU != null) {
                    b.this.deU.onCallback(b.this, "onMediaMetadataExtracted", bundle);
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.b.a.InterfaceC0433a
            public void onRelease() {
                if (b.this.deU != null) {
                    b.this.deU = null;
                }
            }
        });
        this.deT.a(new com.baidu.swan.apps.inlinewidget.b.a.a());
        this.deT.a(new com.baidu.swan.apps.inlinewidget.b.a.b());
    }
}

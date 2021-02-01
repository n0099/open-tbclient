package com.baidu.swan.apps.inlinewidget.b;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.inlinewidget.b.a;
/* loaded from: classes9.dex */
public class b extends com.baidu.swan.apps.inlinewidget.b<a> {
    public b(@NonNull a aVar) {
        super(aVar);
        ((a) this.dds).a(new a.InterfaceC0427a() { // from class: com.baidu.swan.apps.inlinewidget.b.b.1
            @Override // com.baidu.swan.apps.inlinewidget.b.a.InterfaceC0427a
            public void z(Bundle bundle) {
                if (b.this.ddr != null) {
                    b.this.ddr.onCallback(b.this, "onMediaMetadataExtracted", bundle);
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.b.a.InterfaceC0427a
            public void onRelease() {
                if (b.this.ddr != null) {
                    b.this.ddr = null;
                }
            }
        });
        this.ddq.a(new com.baidu.swan.apps.inlinewidget.b.a.a());
        this.ddq.a(new com.baidu.swan.apps.inlinewidget.b.a.b());
    }
}

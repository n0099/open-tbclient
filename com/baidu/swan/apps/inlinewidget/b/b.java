package com.baidu.swan.apps.inlinewidget.b;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.inlinewidget.b.a;
/* loaded from: classes9.dex */
public class b extends com.baidu.swan.apps.inlinewidget.b<a> {
    public b(@NonNull a aVar) {
        super(aVar);
        ((a) this.dfV).a(new a.InterfaceC0447a() { // from class: com.baidu.swan.apps.inlinewidget.b.b.1
            @Override // com.baidu.swan.apps.inlinewidget.b.a.InterfaceC0447a
            public void z(Bundle bundle) {
                if (b.this.dfU != null) {
                    b.this.dfU.onCallback(b.this, "onMediaMetadataExtracted", bundle);
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.b.a.InterfaceC0447a
            public void onRelease() {
                if (b.this.dfU != null) {
                    b.this.dfU = null;
                }
            }
        });
        this.dfT.a(new com.baidu.swan.apps.inlinewidget.b.a.a());
        this.dfT.a(new com.baidu.swan.apps.inlinewidget.b.a.b());
    }
}

package com.baidu.swan.b.a.c;

import java.lang.ref.WeakReference;
/* loaded from: classes9.dex */
public class c implements com.baidu.swan.b.a.d.a {
    private WeakReference<com.baidu.swan.b.a.d.a> cfe;

    public c(com.baidu.swan.b.a.d.a aVar) {
        this.cfe = new WeakReference<>(aVar);
    }

    @Override // com.baidu.swan.b.a.d.b
    public void b(com.baidu.swan.b.a.e.b bVar) {
        if (this.cfe.get() != null) {
            this.cfe.get().b(bVar);
        }
    }

    @Override // com.baidu.swan.b.a.d.a
    public void setPackageName(String str) {
        if (this.cfe.get() != null) {
            this.cfe.get().setPackageName(str);
        }
    }

    @Override // com.baidu.swan.b.a.d.a
    public void setFilePath(String str) {
        if (this.cfe.get() != null) {
            this.cfe.get().setFilePath(str);
        }
    }
}

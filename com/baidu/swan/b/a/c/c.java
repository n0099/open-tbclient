package com.baidu.swan.b.a.c;

import java.lang.ref.WeakReference;
/* loaded from: classes11.dex */
public class c implements com.baidu.swan.b.a.d.a {
    private WeakReference<com.baidu.swan.b.a.d.a> cIJ;

    public c(com.baidu.swan.b.a.d.a aVar) {
        this.cIJ = new WeakReference<>(aVar);
    }

    @Override // com.baidu.swan.b.a.d.b
    public void b(com.baidu.swan.b.a.e.b bVar) {
        if (this.cIJ.get() != null) {
            this.cIJ.get().b(bVar);
        }
    }

    @Override // com.baidu.swan.b.a.d.a
    public void setPackageName(String str) {
        if (this.cIJ.get() != null) {
            this.cIJ.get().setPackageName(str);
        }
    }

    @Override // com.baidu.swan.b.a.d.a
    public void setFilePath(String str) {
        if (this.cIJ.get() != null) {
            this.cIJ.get().setFilePath(str);
        }
    }
}

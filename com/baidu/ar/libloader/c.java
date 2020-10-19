package com.baidu.ar.libloader;

import android.content.Context;
import com.baidu.ar.ARType;
import com.baidu.ar.libloader.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes14.dex */
public class c implements a {
    private boolean sv = false;
    private e sw = new e();

    @Override // com.baidu.ar.libloader.a
    public void a(Context context, a.b bVar) {
        this.sv = true;
        this.sw.fj();
        this.sw.clearAll();
        if (bVar != null) {
            bVar.onSuccess();
        }
    }

    @Override // com.baidu.ar.libloader.a
    public void a(ARType aRType, String str, String str2, a.InterfaceC0085a interfaceC0085a) {
        if (interfaceC0085a != null) {
            interfaceC0085a.a(aRType, str, str2);
        }
    }

    @Override // com.baidu.ar.libloader.a
    public void a(String str, a.c cVar) {
        if (cVar != null) {
            if (this.sv) {
                cVar.onReady();
            } else {
                this.sw.b(str, cVar);
            }
        }
    }

    @Override // com.baidu.ar.libloader.a
    public void as(String str) {
        System.loadLibrary(str);
    }

    @Override // com.baidu.ar.libloader.a
    public void release() {
        if (this.sw != null) {
            this.sw.clearAll();
        }
    }

    @Override // com.baidu.ar.libloader.a
    public void setLibLoadPlugin(ILibLoaderPlugin iLibLoaderPlugin) {
    }
}

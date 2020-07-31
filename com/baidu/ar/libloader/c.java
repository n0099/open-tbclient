package com.baidu.ar.libloader;

import android.content.Context;
import com.baidu.ar.ARType;
import com.baidu.ar.libloader.a;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes11.dex */
class c implements a {
    private boolean rQ = false;
    private Map<String, a.c> rR = new HashMap();

    @Override // com.baidu.ar.libloader.a
    public void a(Context context, a.b bVar) {
        this.rQ = true;
        for (Map.Entry<String, a.c> entry : this.rR.entrySet()) {
            entry.getValue().onReady();
        }
        this.rR.clear();
        if (bVar != null) {
            bVar.onSuccess();
        }
    }

    @Override // com.baidu.ar.libloader.a
    public void a(ARType aRType, String str, String str2, a.InterfaceC0086a interfaceC0086a) {
        if (interfaceC0086a != null) {
            interfaceC0086a.a(aRType, str, str2);
        }
    }

    @Override // com.baidu.ar.libloader.a
    public void a(String str, a.c cVar) {
        if (cVar == null) {
            this.rR.remove(str);
        } else if (this.rQ) {
            cVar.onReady();
        } else {
            this.rR.put(str, cVar);
        }
    }

    @Override // com.baidu.ar.libloader.a
    public void ao(String str) {
        System.loadLibrary(str);
    }

    @Override // com.baidu.ar.libloader.a
    public void release() {
        if (this.rR != null) {
            this.rR.clear();
        }
    }

    @Override // com.baidu.ar.libloader.a
    public void setLibLoadPlugin(ILibLoaderPlugin iLibLoaderPlugin) {
    }
}

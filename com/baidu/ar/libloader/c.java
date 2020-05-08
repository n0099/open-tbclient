package com.baidu.ar.libloader;

import android.content.Context;
import com.baidu.ar.ARType;
import com.baidu.ar.libloader.a;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
class c implements a {
    private boolean rr = false;
    private Map<String, a.c> rs = new HashMap();

    @Override // com.baidu.ar.libloader.a
    public void a(Context context, a.b bVar) {
        this.rr = true;
        for (Map.Entry<String, a.c> entry : this.rs.entrySet()) {
            entry.getValue().onReady();
        }
        this.rs.clear();
        if (bVar != null) {
            bVar.onSuccess();
        }
    }

    @Override // com.baidu.ar.libloader.a
    public void a(ARType aRType, String str, String str2, a.InterfaceC0082a interfaceC0082a) {
        if (interfaceC0082a != null) {
            interfaceC0082a.a(aRType, str, str2);
        }
    }

    @Override // com.baidu.ar.libloader.a
    public void a(String str, a.c cVar) {
        if (cVar == null) {
            this.rs.remove(str);
        } else if (this.rr) {
            cVar.onReady();
        } else {
            this.rs.put(str, cVar);
        }
    }

    @Override // com.baidu.ar.libloader.a
    public void an(String str) {
        System.loadLibrary(str);
    }

    @Override // com.baidu.ar.libloader.a
    public void release() {
        if (this.rs != null) {
            this.rs.clear();
        }
    }

    @Override // com.baidu.ar.libloader.a
    public void setLibLoadPlugin(ILibLoaderPlugin iLibLoaderPlugin) {
    }
}

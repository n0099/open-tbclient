package com.baidu.ar.libloader;

import android.content.Context;
import com.baidu.ar.ARType;
import com.baidu.ar.libloader.ILibLoader;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class b implements ILibLoader {
    private boolean sM = false;
    private d sN = new d();

    @Override // com.baidu.ar.libloader.ILibLoader
    public void load(Context context, ILibLoader.b bVar) {
        this.sM = true;
        this.sN.fi();
        this.sN.clearAll();
        if (bVar != null) {
            bVar.onSuccess();
        }
    }

    @Override // com.baidu.ar.libloader.ILibLoader
    public void prepareCaseRes(ARType aRType, String str, String str2, ILibLoader.a aVar) {
        if (aVar != null) {
            aVar.a(aRType, str, str2);
        }
    }

    @Override // com.baidu.ar.libloader.ILibLoader
    public void release() {
        if (this.sN != null) {
            this.sN.clearAll();
        }
    }

    @Override // com.baidu.ar.libloader.ILibLoader
    public void require(String str) {
        System.loadLibrary(str);
    }

    @Override // com.baidu.ar.libloader.ILibLoader
    public void setLibLoadPlugin(ILibLoaderPlugin iLibLoaderPlugin) {
    }

    @Override // com.baidu.ar.libloader.ILibLoader
    public void setLibReadyListener(String str, ILibLoader.c cVar) {
        if (cVar != null) {
            if (this.sM) {
                cVar.onReady();
            } else {
                this.sN.a(str, cVar);
            }
        }
    }
}

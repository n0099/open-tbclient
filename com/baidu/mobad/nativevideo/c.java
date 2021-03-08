package com.baidu.mobad.nativevideo;

import android.content.Context;
import android.widget.RelativeLayout;
import com.baidu.mobad.nativevideo.PatchVideoNative;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PatchVideoNative f2332a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(PatchVideoNative patchVideoNative) {
        this.f2332a = patchVideoNative;
    }

    @Override // java.lang.Runnable
    public void run() {
        PatchVideoNative.IPatchVideoNativeListener iPatchVideoNativeListener;
        Context context;
        com.baidu.mobads.i.b bVar;
        boolean z;
        RelativeLayout relativeLayout;
        com.baidu.mobads.i.b bVar2;
        com.baidu.mobads.i.b bVar3;
        com.baidu.mobads.i.b bVar4;
        e eVar;
        PatchVideoNative.IPatchVideoNativeListener iPatchVideoNativeListener2;
        e eVar2;
        iPatchVideoNativeListener = this.f2332a.d;
        if (iPatchVideoNativeListener != null) {
            iPatchVideoNativeListener2 = this.f2332a.d;
            eVar2 = this.f2332a.g;
            iPatchVideoNativeListener2.onAdLoad(eVar2.getMaterialType());
        }
        PatchVideoNative patchVideoNative = this.f2332a;
        context = this.f2332a.f2328a;
        patchVideoNative.f = new com.baidu.mobads.i.b(context);
        bVar = this.f2332a.f;
        z = this.f2332a.h;
        bVar.a(z);
        relativeLayout = this.f2332a.c;
        bVar2 = this.f2332a.f;
        relativeLayout.addView(bVar2, new RelativeLayout.LayoutParams(-1, -1));
        bVar3 = this.f2332a.f;
        bVar3.a(new d(this));
        bVar4 = this.f2332a.f;
        eVar = this.f2332a.g;
        bVar4.a((XAdVideoResponse) eVar);
    }
}

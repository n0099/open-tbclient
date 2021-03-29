package com.baidu.mobad.nativevideo;

import android.content.Context;
import android.widget.RelativeLayout;
import com.baidu.mobad.nativevideo.PatchVideoNative;
/* loaded from: classes2.dex */
public class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PatchVideoNative f8063a;

    public c(PatchVideoNative patchVideoNative) {
        this.f8063a = patchVideoNative;
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
        iPatchVideoNativeListener = this.f8063a.f8051d;
        if (iPatchVideoNativeListener != null) {
            iPatchVideoNativeListener2 = this.f8063a.f8051d;
            eVar2 = this.f8063a.f8054g;
            iPatchVideoNativeListener2.onAdLoad(eVar2.getMaterialType());
        }
        PatchVideoNative patchVideoNative = this.f8063a;
        context = this.f8063a.f8048a;
        patchVideoNative.f8053f = new com.baidu.mobads.i.b(context);
        bVar = this.f8063a.f8053f;
        z = this.f8063a.f8055h;
        bVar.a(z);
        relativeLayout = this.f8063a.f8050c;
        bVar2 = this.f8063a.f8053f;
        relativeLayout.addView(bVar2, new RelativeLayout.LayoutParams(-1, -1));
        bVar3 = this.f8063a.f8053f;
        bVar3.a(new d(this));
        bVar4 = this.f8063a.f8053f;
        eVar = this.f8063a.f8054g;
        bVar4.a((XAdVideoResponse) eVar);
    }
}

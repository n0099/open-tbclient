package com.baidu.mobad.nativevideo;

import android.content.Context;
import android.widget.RelativeLayout;
import com.baidu.mobad.nativevideo.PatchVideoNative;
/* loaded from: classes2.dex */
public class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PatchVideoNative f8062a;

    public c(PatchVideoNative patchVideoNative) {
        this.f8062a = patchVideoNative;
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
        iPatchVideoNativeListener = this.f8062a.f8050d;
        if (iPatchVideoNativeListener != null) {
            iPatchVideoNativeListener2 = this.f8062a.f8050d;
            eVar2 = this.f8062a.f8053g;
            iPatchVideoNativeListener2.onAdLoad(eVar2.getMaterialType());
        }
        PatchVideoNative patchVideoNative = this.f8062a;
        context = this.f8062a.f8047a;
        patchVideoNative.f8052f = new com.baidu.mobads.i.b(context);
        bVar = this.f8062a.f8052f;
        z = this.f8062a.f8054h;
        bVar.a(z);
        relativeLayout = this.f8062a.f8049c;
        bVar2 = this.f8062a.f8052f;
        relativeLayout.addView(bVar2, new RelativeLayout.LayoutParams(-1, -1));
        bVar3 = this.f8062a.f8052f;
        bVar3.a(new d(this));
        bVar4 = this.f8062a.f8052f;
        eVar = this.f8062a.f8053g;
        bVar4.a((XAdVideoResponse) eVar);
    }
}

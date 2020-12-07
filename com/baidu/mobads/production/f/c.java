package com.baidu.mobads.production.f;

import android.view.ViewGroup;
import android.widget.RelativeLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f2409a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.f2409a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        RelativeLayout relativeLayout;
        RelativeLayout relativeLayout2;
        ViewGroup b;
        RelativeLayout relativeLayout3;
        RelativeLayout relativeLayout4;
        this.f2409a.x.d("remote Interstitial.removeAd");
        this.f2409a.B = false;
        try {
            relativeLayout = this.f2409a.e;
            relativeLayout.removeAllViews();
            b bVar = this.f2409a;
            relativeLayout2 = this.f2409a.e;
            b = bVar.b(relativeLayout2.getContext());
            relativeLayout3 = this.f2409a.D;
            relativeLayout3.removeAllViews();
            relativeLayout4 = this.f2409a.D;
            b.removeView(relativeLayout4);
        } catch (Exception e) {
            this.f2409a.x.d("Interstitial.removeAd", e);
        }
    }
}

package com.baidu.mobads.production.e;

import android.view.ViewGroup;
import android.widget.RelativeLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f2457a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.f2457a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        RelativeLayout relativeLayout;
        RelativeLayout relativeLayout2;
        ViewGroup b;
        RelativeLayout relativeLayout3;
        RelativeLayout relativeLayout4;
        this.f2457a.A.d("remote Interstitial.removeAd");
        this.f2457a.E = false;
        try {
            relativeLayout = this.f2457a.e;
            relativeLayout.removeAllViews();
            b bVar = this.f2457a;
            relativeLayout2 = this.f2457a.e;
            b = bVar.b(relativeLayout2.getContext());
            relativeLayout3 = this.f2457a.G;
            relativeLayout3.removeAllViews();
            relativeLayout4 = this.f2457a.G;
            b.removeView(relativeLayout4);
        } catch (Exception e) {
            this.f2457a.A.d("Interstitial.removeAd", e);
        }
    }
}

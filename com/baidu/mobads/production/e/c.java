package com.baidu.mobads.production.e;

import android.view.ViewGroup;
import android.widget.RelativeLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f3450a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.f3450a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        RelativeLayout relativeLayout;
        RelativeLayout relativeLayout2;
        ViewGroup b2;
        RelativeLayout relativeLayout3;
        RelativeLayout relativeLayout4;
        this.f3450a.A.d("remote Interstitial.removeAd");
        this.f3450a.E = false;
        try {
            relativeLayout = this.f3450a.e;
            relativeLayout.removeAllViews();
            b bVar = this.f3450a;
            relativeLayout2 = this.f3450a.e;
            b2 = bVar.b(relativeLayout2.getContext());
            relativeLayout3 = this.f3450a.G;
            relativeLayout3.removeAllViews();
            relativeLayout4 = this.f3450a.G;
            b2.removeView(relativeLayout4);
        } catch (Exception e) {
            this.f3450a.A.d("Interstitial.removeAd", e);
        }
    }
}

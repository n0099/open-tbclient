package com.baidu.mobads.production.f;

import android.view.ViewGroup;
import android.widget.RelativeLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes10.dex */
public class c implements Runnable {
    final /* synthetic */ b a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        RelativeLayout relativeLayout;
        RelativeLayout relativeLayout2;
        ViewGroup b;
        RelativeLayout relativeLayout3;
        RelativeLayout relativeLayout4;
        this.a.x.d("remote Interstitial.removeAd");
        this.a.B = false;
        try {
            relativeLayout = this.a.e;
            relativeLayout.removeAllViews();
            b bVar = this.a;
            relativeLayout2 = this.a.e;
            b = bVar.b(relativeLayout2.getContext());
            relativeLayout3 = this.a.D;
            relativeLayout3.removeAllViews();
            relativeLayout4 = this.a.D;
            b.removeView(relativeLayout4);
        } catch (Exception e) {
            this.a.x.d("Interstitial.removeAd", e);
        }
    }
}

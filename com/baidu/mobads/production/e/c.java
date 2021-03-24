package com.baidu.mobads.production.e;

import android.view.ViewGroup;
import android.widget.RelativeLayout;
/* loaded from: classes2.dex */
public class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b f8464a;

    public c(b bVar) {
        this.f8464a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        RelativeLayout relativeLayout;
        RelativeLayout relativeLayout2;
        ViewGroup b2;
        RelativeLayout relativeLayout3;
        RelativeLayout relativeLayout4;
        this.f8464a.A.d("remote Interstitial.removeAd");
        this.f8464a.E = false;
        try {
            relativeLayout = this.f8464a.f8437e;
            relativeLayout.removeAllViews();
            b bVar = this.f8464a;
            relativeLayout2 = this.f8464a.f8437e;
            b2 = bVar.b(relativeLayout2.getContext());
            relativeLayout3 = this.f8464a.G;
            relativeLayout3.removeAllViews();
            relativeLayout4 = this.f8464a.G;
            b2.removeView(relativeLayout4);
        } catch (Exception e2) {
            this.f8464a.A.d("Interstitial.removeAd", e2);
        }
    }
}

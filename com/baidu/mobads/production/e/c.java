package com.baidu.mobads.production.e;

import android.view.ViewGroup;
import android.widget.RelativeLayout;
/* loaded from: classes2.dex */
public class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b f8465a;

    public c(b bVar) {
        this.f8465a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        RelativeLayout relativeLayout;
        RelativeLayout relativeLayout2;
        ViewGroup b2;
        RelativeLayout relativeLayout3;
        RelativeLayout relativeLayout4;
        this.f8465a.A.d("remote Interstitial.removeAd");
        this.f8465a.E = false;
        try {
            relativeLayout = this.f8465a.f8438e;
            relativeLayout.removeAllViews();
            b bVar = this.f8465a;
            relativeLayout2 = this.f8465a.f8438e;
            b2 = bVar.b(relativeLayout2.getContext());
            relativeLayout3 = this.f8465a.G;
            relativeLayout3.removeAllViews();
            relativeLayout4 = this.f8465a.G;
            b2.removeView(relativeLayout4);
        } catch (Exception e2) {
            this.f8465a.A.d("Interstitial.removeAd", e2);
        }
    }
}

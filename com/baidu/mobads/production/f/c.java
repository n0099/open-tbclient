package com.baidu.mobads.production.f;

import android.view.ViewGroup;
import android.widget.RelativeLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f3481a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.f3481a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        RelativeLayout relativeLayout;
        RelativeLayout relativeLayout2;
        ViewGroup b2;
        RelativeLayout relativeLayout3;
        RelativeLayout relativeLayout4;
        this.f3481a.x.d("remote Interstitial.removeAd");
        this.f3481a.B = false;
        try {
            relativeLayout = this.f3481a.e;
            relativeLayout.removeAllViews();
            b bVar = this.f3481a;
            relativeLayout2 = this.f3481a.e;
            b2 = bVar.b(relativeLayout2.getContext());
            relativeLayout3 = this.f3481a.D;
            relativeLayout3.removeAllViews();
            relativeLayout4 = this.f3481a.D;
            b2.removeView(relativeLayout4);
        } catch (Exception e) {
            this.f3481a.x.d("Interstitial.removeAd", e);
        }
    }
}

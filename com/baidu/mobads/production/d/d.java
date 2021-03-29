package com.baidu.mobads.production.d;

import android.view.ViewGroup;
import android.widget.RelativeLayout;
/* loaded from: classes2.dex */
public class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b f8457a;

    public d(b bVar) {
        this.f8457a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        RelativeLayout relativeLayout;
        RelativeLayout relativeLayout2;
        RelativeLayout relativeLayout3;
        RelativeLayout relativeLayout4;
        this.f8457a.A.d("remote Interstitial.removeAd");
        try {
            relativeLayout = this.f8457a.f8438e;
            if (relativeLayout.getParent() != null) {
                relativeLayout3 = this.f8457a.f8438e;
                relativeLayout4 = this.f8457a.f8438e;
                ((ViewGroup) relativeLayout3.getParent()).removeView(relativeLayout4);
            }
            relativeLayout2 = this.f8457a.f8438e;
            relativeLayout2.removeAllViews();
        } catch (Exception e2) {
            this.f8457a.A.d("Interstitial.removeAd", e2);
        }
    }
}

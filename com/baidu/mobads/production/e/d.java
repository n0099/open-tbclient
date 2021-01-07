package com.baidu.mobads.production.e;

import android.view.ViewGroup;
import android.widget.RelativeLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f3478a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar) {
        this.f3478a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        RelativeLayout relativeLayout;
        RelativeLayout relativeLayout2;
        RelativeLayout relativeLayout3;
        RelativeLayout relativeLayout4;
        this.f3478a.x.d("remote Interstitial.removeAd");
        try {
            relativeLayout = this.f3478a.e;
            if (relativeLayout.getParent() != null) {
                relativeLayout3 = this.f3478a.e;
                relativeLayout4 = this.f3478a.e;
                ((ViewGroup) relativeLayout3.getParent()).removeView(relativeLayout4);
            }
            relativeLayout2 = this.f3478a.e;
            relativeLayout2.removeAllViews();
        } catch (Exception e) {
            this.f3478a.x.d("Interstitial.removeAd", e);
        }
    }
}

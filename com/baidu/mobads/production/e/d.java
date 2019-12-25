package com.baidu.mobads.production.e;

import android.view.ViewGroup;
import android.widget.RelativeLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class d implements Runnable {
    final /* synthetic */ b a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar) {
        this.a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        RelativeLayout relativeLayout;
        RelativeLayout relativeLayout2;
        RelativeLayout relativeLayout3;
        RelativeLayout relativeLayout4;
        this.a.x.d("remote Interstitial.removeAd");
        try {
            relativeLayout = this.a.e;
            if (relativeLayout.getParent() != null) {
                relativeLayout3 = this.a.e;
                relativeLayout4 = this.a.e;
                ((ViewGroup) relativeLayout3.getParent()).removeView(relativeLayout4);
            }
            relativeLayout2 = this.a.e;
            relativeLayout2.removeAllViews();
        } catch (Exception e) {
            this.a.x.d("Interstitial.removeAd", e);
        }
    }
}

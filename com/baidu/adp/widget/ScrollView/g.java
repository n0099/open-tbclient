package com.baidu.adp.widget.ScrollView;

import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {
    final /* synthetic */ f wc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.wc = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        WeakReference weakReference;
        WeakReference weakReference2;
        boolean z;
        Handler handler;
        Runnable runnable;
        Handler handler2;
        Runnable runnable2;
        int i;
        h hVar;
        Handler handler3;
        Runnable runnable3;
        h hVar2;
        int i2;
        int i3;
        int i4;
        weakReference = this.wc.wa;
        if (weakReference != null) {
            weakReference2 = this.wc.wa;
            View view = (View) weakReference2.get();
            if (view == null) {
                this.wc.vW = true;
            } else {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
                int i5 = layoutParams.topMargin;
                i2 = this.wc.vp;
                layoutParams.topMargin = i5 - ((int) (i2 * 1.5f));
                int i6 = layoutParams.topMargin;
                i3 = this.wc.vV;
                if (i6 <= i3) {
                    i4 = this.wc.vV;
                    layoutParams.topMargin = i4;
                    this.wc.vW = true;
                }
                view.setLayoutParams(layoutParams);
            }
            z = this.wc.vW;
            if (z) {
                hVar = this.wc.vr;
                if (hVar != null) {
                    hVar2 = this.wc.vr;
                    hVar2.hU();
                }
                handler3 = this.wc.handler;
                runnable3 = this.wc.wb;
                handler3.removeCallbacks(runnable3);
                return;
            }
            handler = this.wc.handler;
            runnable = this.wc.wb;
            handler.removeCallbacks(runnable);
            handler2 = this.wc.handler;
            runnable2 = this.wc.wb;
            i = this.wc.vU;
            handler2.postDelayed(runnable2, i);
        }
    }
}

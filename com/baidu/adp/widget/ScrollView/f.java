package com.baidu.adp.widget.ScrollView;

import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Runnable {
    final /* synthetic */ e CJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.CJ = eVar;
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
        g gVar;
        Handler handler3;
        Runnable runnable3;
        g gVar2;
        int i2;
        int i3;
        int i4;
        weakReference = this.CJ.CH;
        if (weakReference != null) {
            weakReference2 = this.CJ.CH;
            View view = (View) weakReference2.get();
            if (view == null) {
                this.CJ.CD = true;
            } else {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
                int i5 = layoutParams.topMargin;
                i2 = this.CJ.Cn;
                layoutParams.topMargin = i5 - ((int) (i2 * 1.5f));
                int i6 = layoutParams.topMargin;
                i3 = this.CJ.CC;
                if (i6 <= i3) {
                    i4 = this.CJ.CC;
                    layoutParams.topMargin = i4;
                    this.CJ.CD = true;
                }
                view.setLayoutParams(layoutParams);
            }
            z = this.CJ.CD;
            if (z) {
                gVar = this.CJ.Cp;
                if (gVar != null) {
                    gVar2 = this.CJ.Cp;
                    gVar2.kB();
                }
                handler3 = this.CJ.handler;
                runnable3 = this.CJ.CI;
                handler3.removeCallbacks(runnable3);
                return;
            }
            handler = this.CJ.handler;
            runnable = this.CJ.CI;
            handler.removeCallbacks(runnable);
            handler2 = this.CJ.handler;
            runnable2 = this.CJ.CI;
            i = this.CJ.CB;
            handler2.postDelayed(runnable2, i);
        }
    }
}

package com.baidu.adp.widget.ScrollView;

import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Runnable {
    final /* synthetic */ e yf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.yf = eVar;
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
        weakReference = this.yf.yc;
        if (weakReference != null) {
            weakReference2 = this.yf.yc;
            View view = (View) weakReference2.get();
            if (view == null) {
                this.yf.xY = true;
            } else {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
                int i5 = layoutParams.topMargin;
                i2 = this.yf.xt;
                layoutParams.topMargin = i5 - ((int) (i2 * 1.5f));
                int i6 = layoutParams.topMargin;
                i3 = this.yf.xX;
                if (i6 <= i3) {
                    i4 = this.yf.xX;
                    layoutParams.topMargin = i4;
                    this.yf.xY = true;
                }
                view.setLayoutParams(layoutParams);
            }
            z = this.yf.xY;
            if (z) {
                gVar = this.yf.xv;
                if (gVar != null) {
                    gVar2 = this.yf.xv;
                    gVar2.jN();
                }
                handler3 = this.yf.handler;
                runnable3 = this.yf.yd;
                handler3.removeCallbacks(runnable3);
                return;
            }
            handler = this.yf.handler;
            runnable = this.yf.yd;
            handler.removeCallbacks(runnable);
            handler2 = this.yf.handler;
            runnable2 = this.yf.yd;
            i = this.yf.xW;
            handler2.postDelayed(runnable2, i);
        }
    }
}

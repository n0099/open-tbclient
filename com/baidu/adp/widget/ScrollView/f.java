package com.baidu.adp.widget.ScrollView;

import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Runnable {
    final /* synthetic */ e yb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.yb = eVar;
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
        weakReference = this.yb.xZ;
        if (weakReference != null) {
            weakReference2 = this.yb.xZ;
            View view = (View) weakReference2.get();
            if (view == null) {
                this.yb.xV = true;
            } else {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
                int i5 = layoutParams.topMargin;
                i2 = this.yb.xq;
                layoutParams.topMargin = i5 - ((int) (i2 * 1.5f));
                int i6 = layoutParams.topMargin;
                i3 = this.yb.xU;
                if (i6 <= i3) {
                    i4 = this.yb.xU;
                    layoutParams.topMargin = i4;
                    this.yb.xV = true;
                }
                view.setLayoutParams(layoutParams);
            }
            z = this.yb.xV;
            if (z) {
                gVar = this.yb.xs;
                if (gVar != null) {
                    gVar2 = this.yb.xs;
                    gVar2.jG();
                }
                handler3 = this.yb.handler;
                runnable3 = this.yb.ya;
                handler3.removeCallbacks(runnable3);
                return;
            }
            handler = this.yb.handler;
            runnable = this.yb.ya;
            handler.removeCallbacks(runnable);
            handler2 = this.yb.handler;
            runnable2 = this.yb.ya;
            i = this.yb.xT;
            handler2.postDelayed(runnable2, i);
        }
    }
}

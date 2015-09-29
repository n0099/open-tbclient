package com.baidu.adp.widget.ScrollView;

import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Runnable {
    final /* synthetic */ e Iy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.Iy = eVar;
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
        weakReference = this.Iy.Iw;
        if (weakReference != null) {
            weakReference2 = this.Iy.Iw;
            View view = (View) weakReference2.get();
            if (view == null) {
                this.Iy.Is = true;
            } else {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
                int i5 = layoutParams.topMargin;
                i2 = this.Iy.Ic;
                layoutParams.topMargin = i5 - ((int) (i2 * 1.5f));
                int i6 = layoutParams.topMargin;
                i3 = this.Iy.Ir;
                if (i6 <= i3) {
                    i4 = this.Iy.Ir;
                    layoutParams.topMargin = i4;
                    this.Iy.Is = true;
                }
                view.setLayoutParams(layoutParams);
            }
            z = this.Iy.Is;
            if (z) {
                gVar = this.Iy.Ie;
                if (gVar != null) {
                    gVar2 = this.Iy.Ie;
                    gVar2.nA();
                }
                handler3 = this.Iy.handler;
                runnable3 = this.Iy.Ix;
                handler3.removeCallbacks(runnable3);
                return;
            }
            handler = this.Iy.handler;
            runnable = this.Iy.Ix;
            handler.removeCallbacks(runnable);
            handler2 = this.Iy.handler;
            runnable2 = this.Iy.Ix;
            i = this.Iy.Iq;
            handler2.postDelayed(runnable2, i);
        }
    }
}

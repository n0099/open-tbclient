package com.baidu.adp.widget.ScrollView;

import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Runnable {
    final /* synthetic */ e IK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.IK = eVar;
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
        weakReference = this.IK.II;
        if (weakReference != null) {
            weakReference2 = this.IK.II;
            View view = (View) weakReference2.get();
            if (view == null) {
                this.IK.IE = true;
            } else {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
                int i5 = layoutParams.topMargin;
                i2 = this.IK.Io;
                layoutParams.topMargin = i5 - ((int) (i2 * 1.5f));
                int i6 = layoutParams.topMargin;
                i3 = this.IK.IC;
                if (i6 <= i3) {
                    i4 = this.IK.IC;
                    layoutParams.topMargin = i4;
                    this.IK.IE = true;
                }
                view.setLayoutParams(layoutParams);
            }
            z = this.IK.IE;
            if (z) {
                gVar = this.IK.Iq;
                if (gVar != null) {
                    gVar2 = this.IK.Iq;
                    gVar2.lr();
                }
                handler3 = this.IK.handler;
                runnable3 = this.IK.IJ;
                handler3.removeCallbacks(runnable3);
                return;
            }
            handler = this.IK.handler;
            runnable = this.IK.IJ;
            handler.removeCallbacks(runnable);
            handler2 = this.IK.handler;
            runnable2 = this.IK.IJ;
            i = this.IK.IB;
            handler2.postDelayed(runnable2, i);
        }
    }
}

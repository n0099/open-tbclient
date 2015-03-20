package com.baidu.adp.widget.ScrollView;

import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Runnable {
    final /* synthetic */ e IE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.IE = eVar;
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
        weakReference = this.IE.IB;
        if (weakReference != null) {
            weakReference2 = this.IE.IB;
            View view = (View) weakReference2.get();
            if (view == null) {
                this.IE.Ix = true;
            } else {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
                int i5 = layoutParams.topMargin;
                i2 = this.IE.Ii;
                layoutParams.topMargin = i5 - ((int) (i2 * 1.5f));
                int i6 = layoutParams.topMargin;
                i3 = this.IE.Iw;
                if (i6 <= i3) {
                    i4 = this.IE.Iw;
                    layoutParams.topMargin = i4;
                    this.IE.Ix = true;
                }
                view.setLayoutParams(layoutParams);
            }
            z = this.IE.Ix;
            if (z) {
                gVar = this.IE.Ik;
                if (gVar != null) {
                    gVar2 = this.IE.Ik;
                    gVar2.nb();
                }
                handler3 = this.IE.handler;
                runnable3 = this.IE.IC;
                handler3.removeCallbacks(runnable3);
                return;
            }
            handler = this.IE.handler;
            runnable = this.IE.IC;
            handler.removeCallbacks(runnable);
            handler2 = this.IE.handler;
            runnable2 = this.IE.IC;
            i = this.IE.Iv;
            handler2.postDelayed(runnable2, i);
        }
    }
}

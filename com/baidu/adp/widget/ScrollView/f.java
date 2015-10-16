package com.baidu.adp.widget.ScrollView;

import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Runnable {
    final /* synthetic */ e Iz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.Iz = eVar;
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
        weakReference = this.Iz.Ix;
        if (weakReference != null) {
            weakReference2 = this.Iz.Ix;
            View view = (View) weakReference2.get();
            if (view == null) {
                this.Iz.It = true;
            } else {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
                int i5 = layoutParams.topMargin;
                i2 = this.Iz.Id;
                layoutParams.topMargin = i5 - ((int) (i2 * 1.5f));
                int i6 = layoutParams.topMargin;
                i3 = this.Iz.Is;
                if (i6 <= i3) {
                    i4 = this.Iz.Is;
                    layoutParams.topMargin = i4;
                    this.Iz.It = true;
                }
                view.setLayoutParams(layoutParams);
            }
            z = this.Iz.It;
            if (z) {
                gVar = this.Iz.If;
                if (gVar != null) {
                    gVar2 = this.Iz.If;
                    gVar2.nA();
                }
                handler3 = this.Iz.handler;
                runnable3 = this.Iz.Iy;
                handler3.removeCallbacks(runnable3);
                return;
            }
            handler = this.Iz.handler;
            runnable = this.Iz.Iy;
            handler.removeCallbacks(runnable);
            handler2 = this.Iz.handler;
            runnable2 = this.Iz.Iy;
            i = this.Iz.Ir;
            handler2.postDelayed(runnable2, i);
        }
    }
}

package com.baidu.adp.widget.ScrollView;

import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Runnable {
    final /* synthetic */ e JE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.JE = eVar;
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
        weakReference = this.JE.JC;
        if (weakReference != null) {
            weakReference2 = this.JE.JC;
            View view = (View) weakReference2.get();
            if (view == null) {
                this.JE.Jy = true;
            } else {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
                int i5 = layoutParams.topMargin;
                i2 = this.JE.Ji;
                layoutParams.topMargin = i5 - ((int) (i2 * 1.5f));
                int i6 = layoutParams.topMargin;
                i3 = this.JE.Jx;
                if (i6 <= i3) {
                    i4 = this.JE.Jx;
                    layoutParams.topMargin = i4;
                    this.JE.Jy = true;
                }
                view.setLayoutParams(layoutParams);
            }
            z = this.JE.Jy;
            if (z) {
                gVar = this.JE.Jk;
                if (gVar != null) {
                    gVar2 = this.JE.Jk;
                    gVar2.nq();
                }
                handler3 = this.JE.handler;
                runnable3 = this.JE.JD;
                handler3.removeCallbacks(runnable3);
                return;
            }
            handler = this.JE.handler;
            runnable = this.JE.JD;
            handler.removeCallbacks(runnable);
            handler2 = this.JE.handler;
            runnable2 = this.JE.JD;
            i = this.JE.Jw;
            handler2.postDelayed(runnable2, i);
        }
    }
}

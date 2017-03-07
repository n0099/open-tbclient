package com.baidu.adp.widget.ScrollView;

import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Runnable {
    final /* synthetic */ e Jk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.Jk = eVar;
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
        weakReference = this.Jk.Ji;
        if (weakReference != null) {
            weakReference2 = this.Jk.Ji;
            View view = (View) weakReference2.get();
            if (view == null) {
                this.Jk.Je = true;
            } else {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
                int i5 = layoutParams.topMargin;
                i2 = this.Jk.IO;
                layoutParams.topMargin = i5 - ((int) (i2 * 1.5f));
                int i6 = layoutParams.topMargin;
                i3 = this.Jk.Jd;
                if (i6 <= i3) {
                    i4 = this.Jk.Jd;
                    layoutParams.topMargin = i4;
                    this.Jk.Je = true;
                }
                view.setLayoutParams(layoutParams);
            }
            z = this.Jk.Je;
            if (z) {
                gVar = this.Jk.IQ;
                if (gVar != null) {
                    gVar2 = this.Jk.IQ;
                    gVar2.ln();
                }
                handler3 = this.Jk.handler;
                runnable3 = this.Jk.Jj;
                handler3.removeCallbacks(runnable3);
                return;
            }
            handler = this.Jk.handler;
            runnable = this.Jk.Jj;
            handler.removeCallbacks(runnable);
            handler2 = this.Jk.handler;
            runnable2 = this.Jk.Jj;
            i = this.Jk.Jc;
            handler2.postDelayed(runnable2, i);
        }
    }
}

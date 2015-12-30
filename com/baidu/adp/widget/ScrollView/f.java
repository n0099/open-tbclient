package com.baidu.adp.widget.ScrollView;

import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Runnable {
    final /* synthetic */ e Jj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.Jj = eVar;
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
        weakReference = this.Jj.Jh;
        if (weakReference != null) {
            weakReference2 = this.Jj.Jh;
            View view = (View) weakReference2.get();
            if (view == null) {
                this.Jj.Jd = true;
            } else {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
                int i5 = layoutParams.topMargin;
                i2 = this.Jj.IM;
                layoutParams.topMargin = i5 - ((int) (i2 * 1.5f));
                int i6 = layoutParams.topMargin;
                i3 = this.Jj.Jc;
                if (i6 <= i3) {
                    i4 = this.Jj.Jc;
                    layoutParams.topMargin = i4;
                    this.Jj.Jd = true;
                }
                view.setLayoutParams(layoutParams);
            }
            z = this.Jj.Jd;
            if (z) {
                gVar = this.Jj.IO;
                if (gVar != null) {
                    gVar2 = this.Jj.IO;
                    gVar2.nf();
                }
                handler3 = this.Jj.handler;
                runnable3 = this.Jj.Ji;
                handler3.removeCallbacks(runnable3);
                return;
            }
            handler = this.Jj.handler;
            runnable = this.Jj.Ji;
            handler.removeCallbacks(runnable);
            handler2 = this.Jj.handler;
            runnable2 = this.Jj.Ji;
            i = this.Jj.Jb;
            handler2.postDelayed(runnable2, i);
        }
    }
}

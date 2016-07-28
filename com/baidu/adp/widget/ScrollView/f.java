package com.baidu.adp.widget.ScrollView;

import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Runnable {
    final /* synthetic */ e Av;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.Av = eVar;
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
        weakReference = this.Av.At;
        if (weakReference != null) {
            weakReference2 = this.Av.At;
            View view = (View) weakReference2.get();
            if (view == null) {
                this.Av.Ap = true;
            } else {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
                int i5 = layoutParams.topMargin;
                i2 = this.Av.zY;
                layoutParams.topMargin = i5 - ((int) (i2 * 1.5f));
                int i6 = layoutParams.topMargin;
                i3 = this.Av.Ao;
                if (i6 <= i3) {
                    i4 = this.Av.Ao;
                    layoutParams.topMargin = i4;
                    this.Av.Ap = true;
                }
                view.setLayoutParams(layoutParams);
            }
            z = this.Av.Ap;
            if (z) {
                gVar = this.Av.Aa;
                if (gVar != null) {
                    gVar2 = this.Av.Aa;
                    gVar2.jG();
                }
                handler3 = this.Av.handler;
                runnable3 = this.Av.Au;
                handler3.removeCallbacks(runnable3);
                return;
            }
            handler = this.Av.handler;
            runnable = this.Av.Au;
            handler.removeCallbacks(runnable);
            handler2 = this.Av.handler;
            runnable2 = this.Av.Au;
            i = this.Av.An;
            handler2.postDelayed(runnable2, i);
        }
    }
}

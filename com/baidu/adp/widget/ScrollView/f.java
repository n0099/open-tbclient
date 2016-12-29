package com.baidu.adp.widget.ScrollView;

import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Runnable {
    final /* synthetic */ e CK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.CK = eVar;
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
        weakReference = this.CK.CI;
        if (weakReference != null) {
            weakReference2 = this.CK.CI;
            View view = (View) weakReference2.get();
            if (view == null) {
                this.CK.CE = true;
            } else {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
                int i5 = layoutParams.topMargin;
                i2 = this.CK.Co;
                layoutParams.topMargin = i5 - ((int) (i2 * 1.5f));
                int i6 = layoutParams.topMargin;
                i3 = this.CK.CD;
                if (i6 <= i3) {
                    i4 = this.CK.CD;
                    layoutParams.topMargin = i4;
                    this.CK.CE = true;
                }
                view.setLayoutParams(layoutParams);
            }
            z = this.CK.CE;
            if (z) {
                gVar = this.CK.Cq;
                if (gVar != null) {
                    gVar2 = this.CK.Cq;
                    gVar2.kB();
                }
                handler3 = this.CK.handler;
                runnable3 = this.CK.CJ;
                handler3.removeCallbacks(runnable3);
                return;
            }
            handler = this.CK.handler;
            runnable = this.CK.CJ;
            handler.removeCallbacks(runnable);
            handler2 = this.CK.handler;
            runnable2 = this.CK.CJ;
            i = this.CK.CC;
            handler2.postDelayed(runnable2, i);
        }
    }
}

package com.baidu.adp.widget.ScrollView;

import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Runnable {
    final /* synthetic */ e zT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.zT = eVar;
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
        weakReference = this.zT.zR;
        if (weakReference != null) {
            weakReference2 = this.zT.zR;
            View view = (View) weakReference2.get();
            if (view == null) {
                this.zT.zN = true;
            } else {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
                int i5 = layoutParams.topMargin;
                i2 = this.zT.zx;
                layoutParams.topMargin = i5 - ((int) (i2 * 1.5f));
                int i6 = layoutParams.topMargin;
                i3 = this.zT.zM;
                if (i6 <= i3) {
                    i4 = this.zT.zM;
                    layoutParams.topMargin = i4;
                    this.zT.zN = true;
                }
                view.setLayoutParams(layoutParams);
            }
            z = this.zT.zN;
            if (z) {
                gVar = this.zT.zz;
                if (gVar != null) {
                    gVar2 = this.zT.zz;
                    gVar2.jH();
                }
                handler3 = this.zT.handler;
                runnable3 = this.zT.zS;
                handler3.removeCallbacks(runnable3);
                return;
            }
            handler = this.zT.handler;
            runnable = this.zT.zS;
            handler.removeCallbacks(runnable);
            handler2 = this.zT.handler;
            runnable2 = this.zT.zS;
            i = this.zT.zL;
            handler2.postDelayed(runnable2, i);
        }
    }
}

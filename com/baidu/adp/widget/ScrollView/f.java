package com.baidu.adp.widget.ScrollView;

import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Runnable {
    final /* synthetic */ e IS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.IS = eVar;
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
        weakReference = this.IS.IQ;
        if (weakReference != null) {
            weakReference2 = this.IS.IQ;
            View view = (View) weakReference2.get();
            if (view == null) {
                this.IS.IM = true;
            } else {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
                int i5 = layoutParams.topMargin;
                i2 = this.IS.Iv;
                layoutParams.topMargin = i5 - ((int) (i2 * 1.5f));
                int i6 = layoutParams.topMargin;
                i3 = this.IS.IL;
                if (i6 <= i3) {
                    i4 = this.IS.IL;
                    layoutParams.topMargin = i4;
                    this.IS.IM = true;
                }
                view.setLayoutParams(layoutParams);
            }
            z = this.IS.IM;
            if (z) {
                gVar = this.IS.Ix;
                if (gVar != null) {
                    gVar2 = this.IS.Ix;
                    gVar2.nH();
                }
                handler3 = this.IS.handler;
                runnable3 = this.IS.IR;
                handler3.removeCallbacks(runnable3);
                return;
            }
            handler = this.IS.handler;
            runnable = this.IS.IR;
            handler.removeCallbacks(runnable);
            handler2 = this.IS.handler;
            runnable2 = this.IS.IR;
            i = this.IS.IK;
            handler2.postDelayed(runnable2, i);
        }
    }
}

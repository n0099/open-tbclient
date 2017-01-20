package com.baidu.adp.widget.ScrollView;

import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Runnable {
    final /* synthetic */ e BV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.BV = eVar;
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
        weakReference = this.BV.BT;
        if (weakReference != null) {
            weakReference2 = this.BV.BT;
            View view = (View) weakReference2.get();
            if (view == null) {
                this.BV.BP = true;
            } else {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
                int i5 = layoutParams.topMargin;
                i2 = this.BV.BA;
                layoutParams.topMargin = i5 - ((int) (i2 * 1.5f));
                int i6 = layoutParams.topMargin;
                i3 = this.BV.BO;
                if (i6 <= i3) {
                    i4 = this.BV.BO;
                    layoutParams.topMargin = i4;
                    this.BV.BP = true;
                }
                view.setLayoutParams(layoutParams);
            }
            z = this.BV.BP;
            if (z) {
                gVar = this.BV.BC;
                if (gVar != null) {
                    gVar2 = this.BV.BC;
                    gVar2.kt();
                }
                handler3 = this.BV.handler;
                runnable3 = this.BV.BU;
                handler3.removeCallbacks(runnable3);
                return;
            }
            handler = this.BV.handler;
            runnable = this.BV.BU;
            handler.removeCallbacks(runnable);
            handler2 = this.BV.handler;
            runnable2 = this.BV.BU;
            i = this.BV.BN;
            handler2.postDelayed(runnable2, i);
        }
    }
}

package com.baidu.adp.widget.ScrollView;

import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Runnable {
    final /* synthetic */ e Jy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.Jy = eVar;
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
        weakReference = this.Jy.Jw;
        if (weakReference != null) {
            weakReference2 = this.Jy.Jw;
            View view = (View) weakReference2.get();
            if (view == null) {
                this.Jy.Js = true;
            } else {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
                int i5 = layoutParams.topMargin;
                i2 = this.Jy.Jc;
                layoutParams.topMargin = i5 - ((int) (i2 * 1.5f));
                int i6 = layoutParams.topMargin;
                i3 = this.Jy.Jr;
                if (i6 <= i3) {
                    i4 = this.Jy.Jr;
                    layoutParams.topMargin = i4;
                    this.Jy.Js = true;
                }
                view.setLayoutParams(layoutParams);
            }
            z = this.Jy.Js;
            if (z) {
                gVar = this.Jy.Je;
                if (gVar != null) {
                    gVar2 = this.Jy.Je;
                    gVar2.nz();
                }
                handler3 = this.Jy.handler;
                runnable3 = this.Jy.Jx;
                handler3.removeCallbacks(runnable3);
                return;
            }
            handler = this.Jy.handler;
            runnable = this.Jy.Jx;
            handler.removeCallbacks(runnable);
            handler2 = this.Jy.handler;
            runnable2 = this.Jy.Jx;
            i = this.Jy.Jq;
            handler2.postDelayed(runnable2, i);
        }
    }
}

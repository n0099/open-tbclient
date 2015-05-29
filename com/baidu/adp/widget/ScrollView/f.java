package com.baidu.adp.widget.ScrollView;

import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Runnable {
    final /* synthetic */ e Iv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.Iv = eVar;
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
        weakReference = this.Iv.It;
        if (weakReference != null) {
            weakReference2 = this.Iv.It;
            View view = (View) weakReference2.get();
            if (view == null) {
                this.Iv.Ip = true;
            } else {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
                int i5 = layoutParams.topMargin;
                i2 = this.Iv.Ia;
                layoutParams.topMargin = i5 - ((int) (i2 * 1.5f));
                int i6 = layoutParams.topMargin;
                i3 = this.Iv.Io;
                if (i6 <= i3) {
                    i4 = this.Iv.Io;
                    layoutParams.topMargin = i4;
                    this.Iv.Ip = true;
                }
                view.setLayoutParams(layoutParams);
            }
            z = this.Iv.Ip;
            if (z) {
                gVar = this.Iv.Ic;
                if (gVar != null) {
                    gVar2 = this.Iv.Ic;
                    gVar2.ns();
                }
                handler3 = this.Iv.handler;
                runnable3 = this.Iv.Iu;
                handler3.removeCallbacks(runnable3);
                return;
            }
            handler = this.Iv.handler;
            runnable = this.Iv.Iu;
            handler.removeCallbacks(runnable);
            handler2 = this.Iv.handler;
            runnable2 = this.Iv.Iu;
            i = this.Iv.In;
            handler2.postDelayed(runnable2, i);
        }
    }
}

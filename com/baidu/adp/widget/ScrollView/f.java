package com.baidu.adp.widget.ScrollView;

import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Runnable {
    final /* synthetic */ e zU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.zU = eVar;
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
        weakReference = this.zU.zS;
        if (weakReference != null) {
            weakReference2 = this.zU.zS;
            View view = (View) weakReference2.get();
            if (view == null) {
                this.zU.zO = true;
            } else {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
                int i5 = layoutParams.topMargin;
                i2 = this.zU.zy;
                layoutParams.topMargin = i5 - ((int) (i2 * 1.5f));
                int i6 = layoutParams.topMargin;
                i3 = this.zU.zN;
                if (i6 <= i3) {
                    i4 = this.zU.zN;
                    layoutParams.topMargin = i4;
                    this.zU.zO = true;
                }
                view.setLayoutParams(layoutParams);
            }
            z = this.zU.zO;
            if (z) {
                gVar = this.zU.zA;
                if (gVar != null) {
                    gVar2 = this.zU.zA;
                    gVar2.jE();
                }
                handler3 = this.zU.handler;
                runnable3 = this.zU.zT;
                handler3.removeCallbacks(runnable3);
                return;
            }
            handler = this.zU.handler;
            runnable = this.zU.zT;
            handler.removeCallbacks(runnable);
            handler2 = this.zU.handler;
            runnable2 = this.zU.zT;
            i = this.zU.zM;
            handler2.postDelayed(runnable2, i);
        }
    }
}

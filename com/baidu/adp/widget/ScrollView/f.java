package com.baidu.adp.widget.ScrollView;

import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Runnable {
    final /* synthetic */ e IM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.IM = eVar;
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
        weakReference = this.IM.IK;
        if (weakReference != null) {
            weakReference2 = this.IM.IK;
            View view = (View) weakReference2.get();
            if (view == null) {
                this.IM.IG = true;
            } else {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
                int i5 = layoutParams.topMargin;
                i2 = this.IM.Iq;
                layoutParams.topMargin = i5 - ((int) (i2 * 1.5f));
                int i6 = layoutParams.topMargin;
                i3 = this.IM.IF;
                if (i6 <= i3) {
                    i4 = this.IM.IF;
                    layoutParams.topMargin = i4;
                    this.IM.IG = true;
                }
                view.setLayoutParams(layoutParams);
            }
            z = this.IM.IG;
            if (z) {
                gVar = this.IM.Is;
                if (gVar != null) {
                    gVar2 = this.IM.Is;
                    gVar2.ls();
                }
                handler3 = this.IM.handler;
                runnable3 = this.IM.IL;
                handler3.removeCallbacks(runnable3);
                return;
            }
            handler = this.IM.handler;
            runnable = this.IM.IL;
            handler.removeCallbacks(runnable);
            handler2 = this.IM.handler;
            runnable2 = this.IM.IL;
            i = this.IM.IE;
            handler2.postDelayed(runnable2, i);
        }
    }
}

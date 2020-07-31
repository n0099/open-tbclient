package com.baidu.ar.npc;

import android.util.Log;
import android.view.MotionEvent;
import com.baidu.ar.npc.BaiduArView;
import java.util.Calendar;
/* loaded from: classes10.dex */
class ad implements Runnable {
    final /* synthetic */ MotionEvent a;
    final /* synthetic */ aa b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(aa aaVar, MotionEvent motionEvent) {
        this.b = aaVar;
        this.a = motionEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        Log.d(BaiduArView.b, "touch onLongPress " + this.a);
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        if (!this.b.a.x && !this.b.a.D) {
            ArBridge.getInstance().a(BaiduArView.j.ELongPress.ordinal(), this.a.getPointerId(0), this.a.getX(), this.a.getY(), -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, timeInMillis);
        }
    }
}

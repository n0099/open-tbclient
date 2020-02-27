package com.baidu.ar.npc;

import android.util.Log;
import android.view.MotionEvent;
import com.baidu.ar.npc.BaiduArView;
import java.util.Calendar;
/* loaded from: classes8.dex */
class ab implements Runnable {
    final /* synthetic */ MotionEvent a;
    final /* synthetic */ aa b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(aa aaVar, MotionEvent motionEvent) {
        this.b = aaVar;
        this.a = motionEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        Log.d(BaiduArView.b, "touch on single tap with motionEvnet " + this.a);
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        Log.d(BaiduArView.b, "touch timeInMils " + timeInMillis);
        if (!this.b.a.x && !this.b.a.z) {
            ArBridge.getInstance().a(BaiduArView.j.EClick.ordinal(), this.a.getPointerId(0), this.a.getX(), this.a.getY(), -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, timeInMillis);
        }
    }
}

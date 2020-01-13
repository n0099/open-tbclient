package com.baidu.ar.npc;

import android.util.Log;
import android.view.MotionEvent;
import com.baidu.ar.npc.BaiduArView;
import java.util.Calendar;
/* loaded from: classes6.dex */
class ac implements Runnable {
    final /* synthetic */ MotionEvent a;
    final /* synthetic */ MotionEvent b;
    final /* synthetic */ float c;
    final /* synthetic */ float d;
    final /* synthetic */ aa e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(aa aaVar, MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        this.e = aaVar;
        this.a = motionEvent;
        this.b = motionEvent2;
        this.c = f;
        this.d = f2;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        Log.d(BaiduArView.b, String.format("touch onScroll begin motionevent %s and end motion event %s and speed %1.2f, %1.2f ", this.a.toString(), this.b.toString(), Float.valueOf(this.c), Float.valueOf(this.d)));
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        if (!this.e.a.x) {
            z = this.e.a.B;
            if (z) {
                ArBridge.getInstance().a(BaiduArView.j.EScroll.ordinal(), this.a.getPointerId(0), this.a.getX(), this.a.getY(), -1.0f, -1.0f, this.b.getPointerId(0), this.b.getX(), this.b.getY(), this.c, this.d, timeInMillis);
            }
        }
    }
}

package com.baidu.ar.npc;

import android.util.Log;
import android.view.MotionEvent;
import com.baidu.ar.npc.BaiduArView;
import java.util.Calendar;
/* loaded from: classes7.dex */
class ac implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MotionEvent f1212a;
    final /* synthetic */ MotionEvent b;
    final /* synthetic */ float c;
    final /* synthetic */ float d;
    final /* synthetic */ aa e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(aa aaVar, MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        this.e = aaVar;
        this.f1212a = motionEvent;
        this.b = motionEvent2;
        this.c = f;
        this.d = f2;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        Log.d(BaiduArView.b, String.format("touch onScroll begin motionevent %s and end motion event %s and speed %1.2f, %1.2f ", this.f1212a.toString(), this.b.toString(), Float.valueOf(this.c), Float.valueOf(this.d)));
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        if (!this.e.f1210a.x) {
            z = this.e.f1210a.B;
            if (z) {
                ArBridge.getInstance().a(BaiduArView.i.EScroll.ordinal(), this.f1212a.getPointerId(0), this.f1212a.getX(), this.f1212a.getY(), -1.0f, -1.0f, this.b.getPointerId(0), this.b.getX(), this.b.getY(), this.c, this.d, timeInMillis);
            }
        }
    }
}

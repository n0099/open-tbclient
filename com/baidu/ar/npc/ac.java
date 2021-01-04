package com.baidu.ar.npc;

import android.util.Log;
import android.view.MotionEvent;
import com.baidu.ar.npc.BaiduArView;
import java.util.Calendar;
/* loaded from: classes15.dex */
class ac implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MotionEvent f1517a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ MotionEvent f1518b;
    final /* synthetic */ float c;
    final /* synthetic */ float d;
    final /* synthetic */ aa e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(aa aaVar, MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        this.e = aaVar;
        this.f1517a = motionEvent;
        this.f1518b = motionEvent2;
        this.c = f;
        this.d = f2;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        Log.d(BaiduArView.f1495b, String.format("touch onScroll begin motionevent %s and end motion event %s and speed %1.2f, %1.2f ", this.f1517a.toString(), this.f1518b.toString(), Float.valueOf(this.c), Float.valueOf(this.d)));
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        if (!this.e.f1514a.x) {
            z = this.e.f1514a.B;
            if (z) {
                ArBridge.getInstance().a(BaiduArView.i.EScroll.ordinal(), this.f1517a.getPointerId(0), this.f1517a.getX(), this.f1517a.getY(), -1.0f, -1.0f, this.f1518b.getPointerId(0), this.f1518b.getX(), this.f1518b.getY(), this.c, this.d, timeInMillis);
            }
        }
    }
}

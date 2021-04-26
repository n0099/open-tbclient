package com.baidu.ar.npc;

import android.util.Log;
import android.view.MotionEvent;
import com.baidu.ar.npc.BaiduArView;
import java.util.Calendar;
/* loaded from: classes.dex */
public class ac implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MotionEvent f4263a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MotionEvent f4264b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ float f4265c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ float f4266d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ aa f4267e;

    public ac(aa aaVar, MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        this.f4267e = aaVar;
        this.f4263a = motionEvent;
        this.f4264b = motionEvent2;
        this.f4265c = f2;
        this.f4266d = f3;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        Log.d(BaiduArView.f4198b, String.format("touch onScroll begin motionevent %s and end motion event %s and speed %1.2f, %1.2f ", this.f4263a.toString(), this.f4264b.toString(), Float.valueOf(this.f4265c), Float.valueOf(this.f4266d)));
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        if (this.f4267e.f4260a.x) {
            return;
        }
        z = this.f4267e.f4260a.B;
        if (z) {
            ArBridge.getInstance().a(BaiduArView.j.EScroll.ordinal(), this.f4263a.getPointerId(0), this.f4263a.getX(), this.f4263a.getY(), -1.0f, -1.0f, this.f4264b.getPointerId(0), this.f4264b.getX(), this.f4264b.getY(), this.f4265c, this.f4266d, timeInMillis);
        }
    }
}

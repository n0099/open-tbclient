package com.baidu.ar.npc;

import android.util.Log;
import android.view.MotionEvent;
import com.baidu.ar.npc.BaiduArView;
import java.util.Calendar;
/* loaded from: classes.dex */
public class ac implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MotionEvent f4194a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MotionEvent f4195b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ float f4196c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ float f4197d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ aa f4198e;

    public ac(aa aaVar, MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        this.f4198e = aaVar;
        this.f4194a = motionEvent;
        this.f4195b = motionEvent2;
        this.f4196c = f2;
        this.f4197d = f3;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        Log.d(BaiduArView.f4134b, String.format("touch onScroll begin motionevent %s and end motion event %s and speed %1.2f, %1.2f ", this.f4194a.toString(), this.f4195b.toString(), Float.valueOf(this.f4196c), Float.valueOf(this.f4197d)));
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        if (this.f4198e.f4191a.x) {
            return;
        }
        z = this.f4198e.f4191a.B;
        if (z) {
            ArBridge.getInstance().a(BaiduArView.j.EScroll.ordinal(), this.f4194a.getPointerId(0), this.f4194a.getX(), this.f4194a.getY(), -1.0f, -1.0f, this.f4195b.getPointerId(0), this.f4195b.getX(), this.f4195b.getY(), this.f4196c, this.f4197d, timeInMillis);
        }
    }
}

package com.baidu.ar.npc;

import android.util.Log;
import android.view.MotionEvent;
import com.baidu.ar.npc.BaiduArView;
import java.util.Calendar;
/* loaded from: classes2.dex */
public class ac implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MotionEvent f4158a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MotionEvent f4159b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ float f4160c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ float f4161d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ aa f4162e;

    public ac(aa aaVar, MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        this.f4162e = aaVar;
        this.f4158a = motionEvent;
        this.f4159b = motionEvent2;
        this.f4160c = f2;
        this.f4161d = f3;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        Log.d(BaiduArView.f4098b, String.format("touch onScroll begin motionevent %s and end motion event %s and speed %1.2f, %1.2f ", this.f4158a.toString(), this.f4159b.toString(), Float.valueOf(this.f4160c), Float.valueOf(this.f4161d)));
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        if (this.f4162e.f4155a.x) {
            return;
        }
        z = this.f4162e.f4155a.B;
        if (z) {
            ArBridge.getInstance().a(BaiduArView.j.EScroll.ordinal(), this.f4158a.getPointerId(0), this.f4158a.getX(), this.f4158a.getY(), -1.0f, -1.0f, this.f4159b.getPointerId(0), this.f4159b.getX(), this.f4159b.getY(), this.f4160c, this.f4161d, timeInMillis);
        }
    }
}

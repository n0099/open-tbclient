package com.baidu.ar.npc;

import android.util.Log;
import android.view.MotionEvent;
import com.baidu.ar.npc.BaiduArView;
import java.util.Calendar;
/* loaded from: classes.dex */
public class ac implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MotionEvent f4159a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MotionEvent f4160b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ float f4161c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ float f4162d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ aa f4163e;

    public ac(aa aaVar, MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        this.f4163e = aaVar;
        this.f4159a = motionEvent;
        this.f4160b = motionEvent2;
        this.f4161c = f2;
        this.f4162d = f3;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        Log.d(BaiduArView.f4099b, String.format("touch onScroll begin motionevent %s and end motion event %s and speed %1.2f, %1.2f ", this.f4159a.toString(), this.f4160b.toString(), Float.valueOf(this.f4161c), Float.valueOf(this.f4162d)));
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        if (this.f4163e.f4156a.x) {
            return;
        }
        z = this.f4163e.f4156a.B;
        if (z) {
            ArBridge.getInstance().a(BaiduArView.j.EScroll.ordinal(), this.f4159a.getPointerId(0), this.f4159a.getX(), this.f4159a.getY(), -1.0f, -1.0f, this.f4160b.getPointerId(0), this.f4160b.getX(), this.f4160b.getY(), this.f4161c, this.f4162d, timeInMillis);
        }
    }
}

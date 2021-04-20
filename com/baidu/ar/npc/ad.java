package com.baidu.ar.npc;

import android.util.Log;
import android.view.MotionEvent;
import com.baidu.ar.npc.BaiduArView;
import java.util.Calendar;
/* loaded from: classes.dex */
public class ad implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MotionEvent f4199a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ aa f4200b;

    public ad(aa aaVar, MotionEvent motionEvent) {
        this.f4200b = aaVar;
        this.f4199a = motionEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str = BaiduArView.f4134b;
        Log.d(str, "touch onLongPress " + this.f4199a);
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        if (this.f4200b.f4191a.x || this.f4200b.f4191a.D) {
            return;
        }
        ArBridge.getInstance().a(BaiduArView.j.ELongPress.ordinal(), this.f4199a.getPointerId(0), this.f4199a.getX(), this.f4199a.getY(), -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, timeInMillis);
    }
}

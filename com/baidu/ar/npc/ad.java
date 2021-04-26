package com.baidu.ar.npc;

import android.util.Log;
import android.view.MotionEvent;
import com.baidu.ar.npc.BaiduArView;
import java.util.Calendar;
/* loaded from: classes.dex */
public class ad implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MotionEvent f4268a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ aa f4269b;

    public ad(aa aaVar, MotionEvent motionEvent) {
        this.f4269b = aaVar;
        this.f4268a = motionEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str = BaiduArView.f4198b;
        Log.d(str, "touch onLongPress " + this.f4268a);
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        if (this.f4269b.f4260a.x || this.f4269b.f4260a.D) {
            return;
        }
        ArBridge.getInstance().a(BaiduArView.j.ELongPress.ordinal(), this.f4268a.getPointerId(0), this.f4268a.getX(), this.f4268a.getY(), -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, timeInMillis);
    }
}

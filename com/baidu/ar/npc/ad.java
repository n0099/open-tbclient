package com.baidu.ar.npc;

import android.util.Log;
import android.view.MotionEvent;
import com.baidu.ar.npc.BaiduArView;
import java.util.Calendar;
/* loaded from: classes.dex */
public class ad implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MotionEvent f4164a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ aa f4165b;

    public ad(aa aaVar, MotionEvent motionEvent) {
        this.f4165b = aaVar;
        this.f4164a = motionEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str = BaiduArView.f4099b;
        Log.d(str, "touch onLongPress " + this.f4164a);
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        if (this.f4165b.f4156a.x || this.f4165b.f4156a.D) {
            return;
        }
        ArBridge.getInstance().a(BaiduArView.j.ELongPress.ordinal(), this.f4164a.getPointerId(0), this.f4164a.getX(), this.f4164a.getY(), -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, timeInMillis);
    }
}

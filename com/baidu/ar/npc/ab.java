package com.baidu.ar.npc;

import android.util.Log;
import android.view.MotionEvent;
import com.baidu.ar.npc.BaiduArView;
import java.util.Calendar;
/* loaded from: classes.dex */
public class ab implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MotionEvent f4261a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ aa f4262b;

    public ab(aa aaVar, MotionEvent motionEvent) {
        this.f4262b = aaVar;
        this.f4261a = motionEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str = BaiduArView.f4198b;
        Log.d(str, "touch on single tap with motionEvnet " + this.f4261a);
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        String str2 = BaiduArView.f4198b;
        Log.d(str2, "touch timeInMils " + timeInMillis);
        if (this.f4262b.f4260a.x || this.f4262b.f4260a.z) {
            return;
        }
        ArBridge.getInstance().a(BaiduArView.j.EClick.ordinal(), this.f4261a.getPointerId(0), this.f4261a.getX(), this.f4261a.getY(), -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, timeInMillis);
    }
}

package com.baidu.ar.npc;

import android.util.Log;
import android.view.MotionEvent;
import com.baidu.ar.npc.BaiduArView;
import java.util.Calendar;
/* loaded from: classes.dex */
public class ab implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MotionEvent f4157a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ aa f4158b;

    public ab(aa aaVar, MotionEvent motionEvent) {
        this.f4158b = aaVar;
        this.f4157a = motionEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str = BaiduArView.f4099b;
        Log.d(str, "touch on single tap with motionEvnet " + this.f4157a);
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        String str2 = BaiduArView.f4099b;
        Log.d(str2, "touch timeInMils " + timeInMillis);
        if (this.f4158b.f4156a.x || this.f4158b.f4156a.z) {
            return;
        }
        ArBridge.getInstance().a(BaiduArView.j.EClick.ordinal(), this.f4157a.getPointerId(0), this.f4157a.getX(), this.f4157a.getY(), -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, timeInMillis);
    }
}

package com.baidu.ar.npc;

import android.util.Log;
import android.view.MotionEvent;
import com.baidu.ar.npc.BaiduArView;
import java.util.Calendar;
/* loaded from: classes4.dex */
class ab implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MotionEvent f1279a;
    final /* synthetic */ aa b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(aa aaVar, MotionEvent motionEvent) {
        this.b = aaVar;
        this.f1279a = motionEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        Log.d(BaiduArView.b, "touch on single tap with motionEvnet " + this.f1279a);
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        Log.d(BaiduArView.b, "touch timeInMils " + timeInMillis);
        if (!this.b.f1278a.x && !this.b.f1278a.z) {
            ArBridge.getInstance().a(BaiduArView.j.EClick.ordinal(), this.f1279a.getPointerId(0), this.f1279a.getX(), this.f1279a.getY(), -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, timeInMillis);
        }
    }
}

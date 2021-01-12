package com.baidu.ar.npc;

import android.util.Log;
import android.view.MotionEvent;
import com.baidu.ar.npc.BaiduArView;
import java.util.Calendar;
/* loaded from: classes6.dex */
class ab implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MotionEvent f1524a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ aa f1525b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(aa aaVar, MotionEvent motionEvent) {
        this.f1525b = aaVar;
        this.f1524a = motionEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        Log.d(BaiduArView.f1502b, "touch on single tap with motionEvnet " + this.f1524a);
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        Log.d(BaiduArView.f1502b, "touch timeInMils " + timeInMillis);
        if (!this.f1525b.f1523a.x && !this.f1525b.f1523a.z) {
            ArBridge.getInstance().a(BaiduArView.j.EClick.ordinal(), this.f1524a.getPointerId(0), this.f1524a.getX(), this.f1524a.getY(), -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, timeInMillis);
        }
    }
}

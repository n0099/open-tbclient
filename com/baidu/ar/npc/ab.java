package com.baidu.ar.npc;

import android.util.Log;
import android.view.MotionEvent;
import com.baidu.ar.npc.BaiduArView;
import java.util.Calendar;
/* loaded from: classes15.dex */
class ab implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MotionEvent f1515a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ aa f1516b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(aa aaVar, MotionEvent motionEvent) {
        this.f1516b = aaVar;
        this.f1515a = motionEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        Log.d(BaiduArView.f1495b, "touch on single tap with motionEvnet " + this.f1515a);
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        Log.d(BaiduArView.f1495b, "touch timeInMils " + timeInMillis);
        if (!this.f1516b.f1514a.x && !this.f1516b.f1514a.z) {
            ArBridge.getInstance().a(BaiduArView.i.EClick.ordinal(), this.f1515a.getPointerId(0), this.f1515a.getX(), this.f1515a.getY(), -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, timeInMillis);
        }
    }
}

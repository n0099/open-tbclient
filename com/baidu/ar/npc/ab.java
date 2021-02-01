package com.baidu.ar.npc;

import android.util.Log;
import android.view.MotionEvent;
import com.baidu.ar.npc.BaiduArView;
import java.util.Calendar;
/* loaded from: classes4.dex */
class ab implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MotionEvent f1522a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ aa f1523b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(aa aaVar, MotionEvent motionEvent) {
        this.f1523b = aaVar;
        this.f1522a = motionEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        Log.d(BaiduArView.f1500b, "touch on single tap with motionEvnet " + this.f1522a);
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        Log.d(BaiduArView.f1500b, "touch timeInMils " + timeInMillis);
        if (!this.f1523b.f1521a.x && !this.f1523b.f1521a.z) {
            ArBridge.getInstance().a(BaiduArView.j.EClick.ordinal(), this.f1522a.getPointerId(0), this.f1522a.getX(), this.f1522a.getY(), -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, timeInMillis);
        }
    }
}

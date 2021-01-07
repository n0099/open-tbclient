package com.baidu.ar.npc;

import android.util.Log;
import android.view.MotionEvent;
import com.baidu.ar.npc.BaiduArView;
import java.util.Calendar;
/* loaded from: classes3.dex */
class ab implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MotionEvent f1516a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ aa f1517b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(aa aaVar, MotionEvent motionEvent) {
        this.f1517b = aaVar;
        this.f1516a = motionEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        Log.d(BaiduArView.f1496b, "touch on single tap with motionEvnet " + this.f1516a);
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        Log.d(BaiduArView.f1496b, "touch timeInMils " + timeInMillis);
        if (!this.f1517b.f1515a.x && !this.f1517b.f1515a.z) {
            ArBridge.getInstance().a(BaiduArView.i.EClick.ordinal(), this.f1516a.getPointerId(0), this.f1516a.getX(), this.f1516a.getY(), -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, timeInMillis);
        }
    }
}

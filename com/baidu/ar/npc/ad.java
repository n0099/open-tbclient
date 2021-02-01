package com.baidu.ar.npc;

import android.util.Log;
import android.view.MotionEvent;
import com.baidu.ar.npc.BaiduArView;
import java.util.Calendar;
/* loaded from: classes4.dex */
class ad implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MotionEvent f1526a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ aa f1527b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(aa aaVar, MotionEvent motionEvent) {
        this.f1527b = aaVar;
        this.f1526a = motionEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        Log.d(BaiduArView.f1500b, "touch onLongPress " + this.f1526a);
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        if (!this.f1527b.f1521a.x && !this.f1527b.f1521a.D) {
            ArBridge.getInstance().a(BaiduArView.j.ELongPress.ordinal(), this.f1526a.getPointerId(0), this.f1526a.getX(), this.f1526a.getY(), -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, timeInMillis);
        }
    }
}

package com.baidu.ar.npc;

import android.util.Log;
import android.view.MotionEvent;
import com.baidu.ar.npc.BaiduArView;
import java.util.Calendar;
/* loaded from: classes15.dex */
class ad implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MotionEvent f1519a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ aa f1520b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(aa aaVar, MotionEvent motionEvent) {
        this.f1520b = aaVar;
        this.f1519a = motionEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        Log.d(BaiduArView.f1495b, "touch onLongPress " + this.f1519a);
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        if (!this.f1520b.f1514a.x && !this.f1520b.f1514a.D) {
            ArBridge.getInstance().a(BaiduArView.i.ELongPress.ordinal(), this.f1519a.getPointerId(0), this.f1519a.getX(), this.f1519a.getY(), -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, timeInMillis);
        }
    }
}

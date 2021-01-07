package com.baidu.ar.npc;

import android.util.Log;
import android.view.MotionEvent;
import com.baidu.ar.npc.BaiduArView;
import java.util.Calendar;
/* loaded from: classes3.dex */
class ad implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MotionEvent f1520a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ aa f1521b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(aa aaVar, MotionEvent motionEvent) {
        this.f1521b = aaVar;
        this.f1520a = motionEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        Log.d(BaiduArView.f1496b, "touch onLongPress " + this.f1520a);
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        if (!this.f1521b.f1515a.x && !this.f1521b.f1515a.D) {
            ArBridge.getInstance().a(BaiduArView.i.ELongPress.ordinal(), this.f1520a.getPointerId(0), this.f1520a.getX(), this.f1520a.getY(), -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, timeInMillis);
        }
    }
}

package com.baidu.ar.npc;

import android.util.Log;
import android.view.MotionEvent;
import com.baidu.ar.npc.BaiduArView;
import java.util.Calendar;
/* loaded from: classes6.dex */
class ad implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MotionEvent f1528a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ aa f1529b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(aa aaVar, MotionEvent motionEvent) {
        this.f1529b = aaVar;
        this.f1528a = motionEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        Log.d(BaiduArView.f1502b, "touch onLongPress " + this.f1528a);
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        if (!this.f1529b.f1523a.x && !this.f1529b.f1523a.D) {
            ArBridge.getInstance().a(BaiduArView.j.ELongPress.ordinal(), this.f1528a.getPointerId(0), this.f1528a.getX(), this.f1528a.getY(), -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, timeInMillis);
        }
    }
}

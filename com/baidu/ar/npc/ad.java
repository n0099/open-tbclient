package com.baidu.ar.npc;

import android.util.Log;
import android.view.MotionEvent;
import com.baidu.ar.npc.BaiduArView;
import java.util.Calendar;
/* loaded from: classes26.dex */
class ad implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MotionEvent f1214a;
    final /* synthetic */ aa b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(aa aaVar, MotionEvent motionEvent) {
        this.b = aaVar;
        this.f1214a = motionEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        Log.d(BaiduArView.b, "touch onLongPress " + this.f1214a);
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        if (!this.b.f1211a.x && !this.b.f1211a.D) {
            ArBridge.getInstance().a(BaiduArView.i.ELongPress.ordinal(), this.f1214a.getPointerId(0), this.f1214a.getX(), this.f1214a.getY(), -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, timeInMillis);
        }
    }
}

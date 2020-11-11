package com.baidu.ar.npc;

import android.util.Log;
import android.view.MotionEvent;
import com.baidu.ar.npc.BaiduArView;
import java.util.Calendar;
/* loaded from: classes7.dex */
class ad implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MotionEvent f1213a;
    final /* synthetic */ aa b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(aa aaVar, MotionEvent motionEvent) {
        this.b = aaVar;
        this.f1213a = motionEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        Log.d(BaiduArView.b, "touch onLongPress " + this.f1213a);
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        if (!this.b.f1210a.x && !this.b.f1210a.D) {
            ArBridge.getInstance().a(BaiduArView.i.ELongPress.ordinal(), this.f1213a.getPointerId(0), this.f1213a.getX(), this.f1213a.getY(), -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, timeInMillis);
        }
    }
}

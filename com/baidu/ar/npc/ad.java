package com.baidu.ar.npc;

import android.util.Log;
import android.view.MotionEvent;
import com.baidu.ar.npc.BaiduArView;
import java.util.Calendar;
/* loaded from: classes2.dex */
public class ad implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MotionEvent f4163a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ aa f4164b;

    public ad(aa aaVar, MotionEvent motionEvent) {
        this.f4164b = aaVar;
        this.f4163a = motionEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str = BaiduArView.f4098b;
        Log.d(str, "touch onLongPress " + this.f4163a);
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        if (this.f4164b.f4155a.x || this.f4164b.f4155a.D) {
            return;
        }
        ArBridge.getInstance().a(BaiduArView.j.ELongPress.ordinal(), this.f4163a.getPointerId(0), this.f4163a.getX(), this.f4163a.getY(), -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, timeInMillis);
    }
}

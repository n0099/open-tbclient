package com.baidu.location.a;

import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class y extends Handler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ x f2591a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(x xVar, Looper looper) {
        super(looper);
        this.f2591a = xVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Handler handler;
        Handler handler2;
        boolean z = true;
        switch (message.what) {
            case 1:
                Bundle data = message.getData();
                try {
                    Location location = (Location) data.getParcelable("loc");
                    data.getInt("satnum");
                    if (location != null) {
                        d.a().a(location);
                        return;
                    }
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            case 2:
                w.a(u.c(), com.baidu.location.b.i.a().n(), u.d(), u.a());
                return;
            case 3:
                w.a(u.c(), null, u.d(), a.a().c());
                return;
            case 4:
                boolean i = com.baidu.location.b.i.i();
                if (!i) {
                    z = i;
                } else if (h.a().d() == 1) {
                    z = false;
                }
                if (z) {
                }
                try {
                    handler = this.f2591a.d;
                    if (handler != null) {
                        handler2 = this.f2591a.d;
                        handler2.sendEmptyMessageDelayed(4, com.baidu.location.d.j.Q);
                        return;
                    }
                    return;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            case 5:
            case 6:
            default:
                return;
            case 7:
                w.a().c();
                return;
            case 8:
                message.getData();
                return;
        }
    }
}

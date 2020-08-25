package com.baidu.location.b;

import android.location.GnssNavigationMessage;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes20.dex */
public class ad extends Handler {
    final /* synthetic */ ac a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ad(ac acVar, Looper looper) {
        super(looper);
        this.a = acVar;
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
                        g.a().a(location);
                        return;
                    }
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            case 2:
                ab.a(x.c(), com.baidu.location.c.i.a().n(), x.d(), x.a());
                return;
            case 3:
                ab.a(x.c(), null, x.d(), b.a().c());
                return;
            case 4:
                boolean i = com.baidu.location.c.i.a().i();
                if (com.baidu.location.e.l.b()) {
                    i = false;
                }
                if (!i) {
                    z = i;
                } else if (k.a().d() == 1) {
                    z = false;
                }
                if (z) {
                }
                try {
                    handler = this.a.d;
                    if (handler != null) {
                        handler2 = this.a.d;
                        handler2.sendEmptyMessageDelayed(4, com.baidu.location.e.l.R);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                aa.a().b();
                return;
            case 5:
            case 6:
            case 10:
            default:
                return;
            case 7:
                ab.a().c();
                return;
            case 8:
                message.getData();
                return;
            case 9:
                message.getData();
                return;
            case 11:
                Bundle data2 = message.getData();
                try {
                    aa.a().a((GnssNavigationMessage) data2.getParcelable("gnss_navigation_message"), data2.getLong("gps_time"));
                    return;
                } catch (Exception e3) {
                    return;
                }
        }
    }
}

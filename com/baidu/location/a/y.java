package com.baidu.location.a;

import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* loaded from: classes2.dex */
public class y extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ x f6607a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(x xVar, Looper looper) {
        super(looper);
        this.f6607a = xVar;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x008d -> B:35:0x0090). Please submit an issue!!! */
    @Override // android.os.Handler
    public void handleMessage(Message message) {
        com.baidu.location.b.a c2;
        com.baidu.location.b.h n;
        Location d2;
        String a2;
        Handler handler;
        Handler handler2;
        int i = message.what;
        try {
            if (i != 1) {
                if (i == 2) {
                    c2 = u.c();
                    n = com.baidu.location.b.i.a().n();
                    d2 = u.d();
                    a2 = u.a();
                } else if (i == 3) {
                    c2 = u.c();
                    n = null;
                    d2 = u.d();
                    a2 = a.a().c();
                } else if (i != 4) {
                    if (i == 7) {
                        w.a().c();
                        return;
                    } else if (i != 8) {
                        return;
                    } else {
                        message.getData();
                        return;
                    }
                } else {
                    if (com.baidu.location.b.i.i()) {
                        h.a().d();
                    }
                    handler = this.f6607a.f6605d;
                    if (handler != null) {
                        handler2 = this.f6607a.f6605d;
                        handler2.sendEmptyMessageDelayed(4, com.baidu.location.d.j.Q);
                    }
                }
                w.a(c2, n, d2, a2);
                return;
            }
            Bundle data = message.getData();
            Location location = (Location) data.getParcelable("loc");
            data.getInt("satnum");
            if (location != null) {
                d.a().a(location);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}

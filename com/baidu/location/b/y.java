package com.baidu.location.b;

import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* loaded from: classes2.dex */
public class y extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ x f6640a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(x xVar, Looper looper) {
        super(looper);
        this.f6640a = xVar;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x009a -> B:39:0x009d). Please submit an issue!!! */
    @Override // android.os.Handler
    public void handleMessage(Message message) {
        com.baidu.location.c.a c2;
        com.baidu.location.c.h n;
        Location d2;
        String a2;
        Handler handler;
        Handler handler2;
        int i2 = message.what;
        try {
            if (i2 != 1) {
                if (i2 == 2) {
                    c2 = t.c();
                    n = com.baidu.location.c.i.a().n();
                    d2 = t.d();
                    a2 = t.a();
                } else if (i2 == 3) {
                    c2 = t.c();
                    n = null;
                    d2 = t.d();
                    a2 = a.a().c();
                } else if (i2 != 4) {
                    if (i2 == 7) {
                        w.a().c();
                        return;
                    } else if (i2 == 8 || i2 == 9) {
                        message.getData();
                        return;
                    } else {
                        return;
                    }
                } else {
                    boolean i3 = com.baidu.location.c.i.i();
                    if (com.baidu.location.e.k.b()) {
                        i3 = false;
                    }
                    if (i3) {
                        h.a().d();
                    }
                    handler = this.f6640a.f6638d;
                    if (handler != null) {
                        handler2 = this.f6640a.f6638d;
                        handler2.sendEmptyMessageDelayed(4, com.baidu.location.e.k.R);
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

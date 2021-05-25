package com.baidu.location.c;

import android.location.Location;
import android.os.Handler;
import android.os.Message;
/* loaded from: classes2.dex */
public class g extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ e f6636a;

    public g(e eVar) {
        this.f6636a = eVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        e eVar;
        Location location;
        String str;
        if (com.baidu.location.f.isServing) {
            int i2 = message.what;
            if (i2 == 1) {
                this.f6636a.e((Location) message.obj);
                return;
            }
            if (i2 == 3) {
                eVar = this.f6636a;
                location = (Location) message.obj;
                str = "&og=1";
            } else if (i2 != 4) {
                return;
            } else {
                eVar = this.f6636a;
                location = (Location) message.obj;
                str = "&og=2";
            }
            eVar.a(str, location);
        }
    }
}

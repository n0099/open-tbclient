package com.baidu.location.b;

import android.location.Location;
import android.os.Handler;
import android.os.Message;
/* loaded from: classes2.dex */
public class g extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ e f6643a;

    public g(e eVar) {
        this.f6643a = eVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        e eVar;
        Location location;
        String str;
        if (com.baidu.location.f.isServing) {
            int i = message.what;
            if (i == 1) {
                this.f6643a.e((Location) message.obj);
                return;
            }
            if (i == 3) {
                eVar = this.f6643a;
                location = (Location) message.obj;
                str = "&og=1";
            } else if (i != 4) {
                return;
            } else {
                eVar = this.f6643a;
                location = (Location) message.obj;
                str = "&og=2";
            }
            eVar.a(str, location);
        }
    }
}

package com.baidu.android.systemmonitor.devicestatistic;

import android.content.Context;
import android.content.Intent;
import android.os.FileObserver;
import com.baidu.zeus.NotificationProxy;
/* loaded from: classes.dex */
public class h extends FileObserver {

    /* renamed from: a  reason: collision with root package name */
    private Context f421a;
    private com.baidu.android.systemmonitor.devicestatistic.a.b b;
    private String c;

    public h(String str, Context context) {
        super(str, 1280);
        this.f421a = null;
        this.b = null;
        this.c = null;
        this.f421a = context.getApplicationContext();
        this.c = str;
    }

    @Override // android.os.FileObserver
    public void onEvent(int i, String str) {
        switch (i & 4095) {
            case 256:
                this.b = new com.baidu.android.systemmonitor.devicestatistic.a.b(System.currentTimeMillis(), this.c, str);
                d.a(this.f421a).a(this.b);
                return;
            case NotificationProxy.MAX_URL_LENGTH /* 1024 */:
                Intent intent = new Intent("com.baidu.moplus.systemmonitor.pathdeleted");
                intent.putExtra("path", this.c);
                this.f421a.sendBroadcast(intent);
                return;
            default:
                return;
        }
    }
}

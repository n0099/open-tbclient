package com.baidu.android.systemmonitor.devicestatistic;

import android.content.Context;
import android.content.Intent;
import android.os.FileObserver;
/* loaded from: classes.dex */
public class j extends FileObserver {

    /* renamed from: a  reason: collision with root package name */
    private Context f691a;
    private com.baidu.android.systemmonitor.devicestatistic.a.a b;
    private String c;

    public j(String str, Context context) {
        super(str, 1280);
        this.f691a = null;
        this.b = null;
        this.c = null;
        this.f691a = context.getApplicationContext();
        this.c = str;
    }

    @Override // android.os.FileObserver
    public void onEvent(int i, String str) {
        switch (i & 4095) {
            case 256:
                this.b = new com.baidu.android.systemmonitor.devicestatistic.a.a(System.currentTimeMillis(), this.c, str);
                d.a(this.f691a).a(this.b);
                return;
            case 1024:
                Intent intent = new Intent("com.baidu.moplus.systemmonitor.pathdeleted");
                intent.putExtra("path", this.c);
                this.f691a.sendBroadcast(intent);
                return;
            default:
                return;
        }
    }
}

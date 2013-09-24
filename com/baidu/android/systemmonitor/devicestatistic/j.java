package com.baidu.android.systemmonitor.devicestatistic;

import android.content.Context;
import android.content.Intent;
import android.os.FileObserver;
/* loaded from: classes.dex */
public class j extends FileObserver {

    /* renamed from: a  reason: collision with root package name */
    private Context f726a;
    private com.baidu.android.systemmonitor.devicestatistic.a.a b;
    private String c;

    public j(String str, Context context) {
        super(str, 1280);
        this.f726a = null;
        this.b = null;
        this.c = null;
        this.f726a = context.getApplicationContext();
        this.c = str;
    }

    @Override // android.os.FileObserver
    public void onEvent(int i, String str) {
        switch (i & 4095) {
            case 256:
                this.b = new com.baidu.android.systemmonitor.devicestatistic.a.a(System.currentTimeMillis(), this.c, str);
                d.a(this.f726a).a(this.b);
                return;
            case 1024:
                Intent intent = new Intent("com.baidu.moplus.systemmonitor.pathdeleted");
                intent.putExtra("path", this.c);
                this.f726a.sendBroadcast(intent);
                return;
            default:
                return;
        }
    }
}

package com.baidu.android.systemmonitor.devicestatistic;

import android.content.Context;
import android.content.Intent;
import android.os.FileObserver;
/* loaded from: classes.dex */
public class i extends FileObserver {
    private Context a;
    private com.baidu.android.systemmonitor.devicestatistic.a.a b;
    private String c;

    public i(String str, Context context) {
        super(str, 1280);
        this.a = null;
        this.b = null;
        this.c = null;
        this.a = context.getApplicationContext();
        this.c = str;
    }

    @Override // android.os.FileObserver
    public void onEvent(int i, String str) {
        switch (i & 4095) {
            case 256:
                this.b = new com.baidu.android.systemmonitor.devicestatistic.a.a(System.currentTimeMillis(), this.c, str);
                g.a(this.a).a(this.b);
                return;
            case 1024:
                Intent intent = new Intent("com.baidu.moplus.systemmonitor.pathdeleted");
                intent.putExtra("path", this.c);
                this.a.sendBroadcast(intent);
                return;
            default:
                return;
        }
    }
}

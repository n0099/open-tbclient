package com.baidu.android.systemmonitor.devicestatistic;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Environment;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f706a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.f706a = aVar;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action.equals("com.baidu.moplus.systemmonitor.pathdeleted")) {
            this.f706a.a(intent.getStringExtra("path"));
        } else if ("com.baidu.moplus.systemmonitor.pathrefresh".equals(action)) {
            this.f706a.e();
            this.f706a.b();
        } else if (!Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
            this.f706a.c();
        } else {
            this.f706a.d();
            this.f706a.b();
        }
    }
}

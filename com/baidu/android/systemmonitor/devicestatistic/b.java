package com.baidu.android.systemmonitor.devicestatistic;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Environment;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f811a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.f811a = aVar;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action.equals("com.baidu.moplus.systemmonitor.pathdeleted")) {
            this.f811a.a(intent.getStringExtra("path"));
        } else if ("com.baidu.moplus.systemmonitor.pathrefresh".equals(action)) {
            this.f811a.e();
            this.f811a.b();
        } else if (!Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
            this.f811a.c();
        } else {
            this.f811a.d();
            this.f811a.b();
        }
    }
}

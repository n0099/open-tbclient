package com.baidu.adp.lib.debug.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f446a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.f446a = bVar;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        this.f446a.b.unregisterReceiver(this);
        com.baidu.adp.lib.debug.b.c(intent.getIntExtra("level", 0) + "%");
    }
}

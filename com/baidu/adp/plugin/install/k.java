package com.baidu.adp.plugin.install;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Messenger;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements ServiceConnection {
    private final /* synthetic */ Intent CQ;
    final /* synthetic */ d this$0;
    private final /* synthetic */ Context val$context;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(d dVar, Context context, Intent intent) {
        this.this$0 = dVar;
        this.val$context = context;
        this.CQ = intent;
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.this$0.lx();
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.this$0.messenger = new Messenger(iBinder);
        this.val$context.startService(this.CQ);
    }
}

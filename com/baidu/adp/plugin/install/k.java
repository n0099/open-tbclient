package com.baidu.adp.plugin.install;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Messenger;
import android.text.TextUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements ServiceConnection {
    private final /* synthetic */ Intent DB;
    final /* synthetic */ d this$0;
    private final /* synthetic */ Context val$context;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(d dVar, Intent intent, Context context) {
        this.this$0 = dVar;
        this.DB = intent;
        this.val$context = context;
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.this$0.lf();
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        c cVar;
        c cVar2;
        this.this$0.messenger = new Messenger(iBinder);
        String stringExtra = this.DB.getStringExtra("package_name");
        cVar = this.this$0.Dr;
        if (cVar == null) {
            return;
        }
        cVar2 = this.this$0.Dr;
        if (TextUtils.equals(stringExtra, cVar2.pkgName)) {
            this.val$context.startService(this.DB);
        }
    }
}

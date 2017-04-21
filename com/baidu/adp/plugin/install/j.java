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
public class j implements ServiceConnection {
    private final /* synthetic */ Intent Dy;
    final /* synthetic */ c this$0;
    private final /* synthetic */ Context val$context;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(c cVar, Intent intent, Context context) {
        this.this$0 = cVar;
        this.Dy = intent;
        this.val$context = context;
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.this$0.ja();
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        PluginInstallTask pluginInstallTask;
        PluginInstallTask pluginInstallTask2;
        this.this$0.messenger = new Messenger(iBinder);
        String stringExtra = this.Dy.getStringExtra("package_name");
        pluginInstallTask = this.this$0.Do;
        if (pluginInstallTask == null) {
            return;
        }
        pluginInstallTask2 = this.this$0.Do;
        if (TextUtils.equals(stringExtra, pluginInstallTask2.CC)) {
            this.val$context.startService(this.Dy);
        }
    }
}

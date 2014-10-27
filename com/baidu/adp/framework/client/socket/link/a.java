package com.baidu.adp.framework.client.socket.link;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
/* loaded from: classes.dex */
class a implements ServiceConnection {
    final /* synthetic */ BdSocketDaemonService cr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BdSocketDaemonService bdSocketDaemonService) {
        this.cr = bdSocketDaemonService;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        BdSocketLinkService.startService(false, "restart");
    }
}

package com.baidu.adp.framework.client.socket.link;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
/* loaded from: classes.dex */
class a implements ServiceConnection {
    final /* synthetic */ BdSocketDaemonService iK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BdSocketDaemonService bdSocketDaemonService) {
        this.iK = bdSocketDaemonService;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        g gVar;
        g gVar2;
        gVar = BdSocketDaemonService.sCallBack;
        if (gVar != null) {
            gVar2 = BdSocketDaemonService.sCallBack;
            gVar2.ce();
            return;
        }
        BdSocketLinkService.startService(false, "restart");
    }
}

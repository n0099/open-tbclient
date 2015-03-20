package com.baidu.adp.framework.client.socket.link;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
/* loaded from: classes.dex */
class a implements ServiceConnection {
    final /* synthetic */ BdSocketDaemonService pS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BdSocketDaemonService bdSocketDaemonService) {
        this.pS = bdSocketDaemonService;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        i iVar;
        i iVar2;
        iVar = BdSocketDaemonService.sCallBack;
        if (iVar != null) {
            iVar2 = BdSocketDaemonService.sCallBack;
            iVar2.eL();
            return;
        }
        BdSocketLinkService.startService(false, "restart");
    }
}

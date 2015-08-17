package com.baidu.adp.framework.client.socket.link;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
/* loaded from: classes.dex */
class d implements ServiceConnection {
    final /* synthetic */ BdSocketLinkService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(BdSocketLinkService bdSocketLinkService) {
        this.this$0 = bdSocketLinkService;
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        BdSocketDaemonService.startService();
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
    }
}

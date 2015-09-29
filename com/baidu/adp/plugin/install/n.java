package com.baidu.adp.plugin.install;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
class n extends Handler {
    final /* synthetic */ PluginInstallerService CX;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(PluginInstallerService pluginInstallerService, Looper looper) {
        super(looper);
        this.CX = pluginInstallerService;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message != null && message.replyTo != null) {
            Message message2 = new Message();
            try {
                message2.setData(message.getData());
                message.replyTo.send(message2);
            } catch (RemoteException e) {
                BdLog.detailException(e);
            }
        }
    }
}

package com.baidu.tbadk.core.frameworkData;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements ServiceConnection {
    final /* synthetic */ IntentConfig XS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(IntentConfig intentConfig) {
        this.XS = intentConfig;
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Messenger messenger;
        Messenger messenger2;
        Messenger messenger3;
        if (iBinder != null) {
            this.XS.mReplyMessenger = new Messenger(iBinder);
            messenger = this.XS.mReplyMessenger;
            if (messenger != null) {
                Message obtain = Message.obtain();
                Bundle bundle = new Bundle();
                if (this.XS.mComponentClass != null) {
                    bundle.putString("class", this.XS.mComponentClass.getName());
                }
                obtain.setData(bundle);
                messenger2 = this.XS.mClientMessenger;
                obtain.replyTo = messenger2;
                try {
                    messenger3 = this.XS.mReplyMessenger;
                    messenger3.send(obtain);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

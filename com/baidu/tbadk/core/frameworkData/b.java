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
    final /* synthetic */ IntentConfig XM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(IntentConfig intentConfig) {
        this.XM = intentConfig;
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
            this.XM.mReplyMessenger = new Messenger(iBinder);
            messenger = this.XM.mReplyMessenger;
            if (messenger != null) {
                Message obtain = Message.obtain();
                Bundle bundle = new Bundle();
                if (this.XM.mComponentClass != null) {
                    bundle.putString("class", this.XM.mComponentClass.getName());
                }
                obtain.setData(bundle);
                messenger2 = this.XM.mClientMessenger;
                obtain.replyTo = messenger2;
                try {
                    messenger3 = this.XM.mReplyMessenger;
                    messenger3.send(obtain);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

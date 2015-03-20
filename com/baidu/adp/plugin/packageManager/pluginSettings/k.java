package com.baidu.adp.plugin.packageManager.pluginSettings;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements ServiceConnection {
    final /* synthetic */ h EB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(h hVar) {
        this.EB = hVar;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        Messenger messenger;
        this.EB.Ex = new Messenger(iBinder);
        this.EB.lQ();
        arrayList = this.EB.EA;
        if (arrayList.size() > 0) {
            arrayList2 = this.EB.EA;
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                Message message = (Message) it.next();
                try {
                    messenger = this.EB.Ex;
                    messenger.send(message);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
            arrayList3 = this.EB.EA;
            arrayList3.clear();
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        ArrayList arrayList;
        this.EB.Ex = null;
        arrayList = this.EB.EA;
        arrayList.clear();
    }
}

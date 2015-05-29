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
    final /* synthetic */ h Er;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(h hVar) {
        this.Er = hVar;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        Messenger messenger;
        this.Er.Eo = new Messenger(iBinder);
        this.Er.mj();
        arrayList = this.Er.Eq;
        if (arrayList.size() > 0) {
            arrayList2 = this.Er.Eq;
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                Message message = (Message) it.next();
                try {
                    messenger = this.Er.Eo;
                    messenger.send(message);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
            arrayList3 = this.Er.Eq;
            arrayList3.clear();
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        ArrayList arrayList;
        this.Er.Eo = null;
        arrayList = this.Er.Eq;
        arrayList.clear();
    }
}

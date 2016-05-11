package com.baidu.location;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements ServiceConnection {
    final /* synthetic */ LocationClient a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(LocationClient locationClient) {
        this.a = locationClient;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        boolean z;
        Bundle optionBundle;
        Boolean bool;
        this.a.mServer = new Messenger(iBinder);
        if (this.a.mServer == null) {
            return;
        }
        this.a.mIsStarted = true;
        Log.d("baidu_location_client", "baidu location connected ...");
        z = this.a.isStop;
        if (z) {
            this.a.mHandler.obtainMessage(2).sendToTarget();
            return;
        }
        try {
            Message obtain = Message.obtain((Handler) null, 11);
            obtain.replyTo = this.a.mMessenger;
            optionBundle = this.a.getOptionBundle();
            obtain.setData(optionBundle);
            this.a.mServer.send(obtain);
            this.a.mIsStarted = true;
            if (this.a.mOption != null) {
                bool = this.a.firstConnected;
                if (bool.booleanValue()) {
                }
                this.a.mHandler.obtainMessage(4).sendToTarget();
            }
        } catch (Exception e) {
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.a.mServer = null;
        this.a.mIsStarted = false;
    }
}

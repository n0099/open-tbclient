package com.baidu.tbadk.aladin;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
/* loaded from: classes.dex */
public class AladinServer extends Service {
    private a mTcpListener = null;

    public static void start(Context context) {
        context.startService(new Intent(context, AladinServer.class));
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        reStartListener();
        return 0;
    }

    public void reStartListener() {
        if (this.mTcpListener == null || !this.mTcpListener.b()) {
            if (this.mTcpListener != null) {
                this.mTcpListener.a();
            }
            this.mTcpListener = new a(this);
            this.mTcpListener.start();
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        if (this.mTcpListener != null) {
            this.mTcpListener.a();
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }
}

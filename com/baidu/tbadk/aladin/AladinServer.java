package com.baidu.tbadk.aladin;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.baidu.adp.lib.g.i;
/* loaded from: classes.dex */
public class AladinServer extends Service {
    private a mTcpListener = null;

    public static void start(Context context) {
        i.b(context, new Intent(context, AladinServer.class));
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        reStartListener();
        return 0;
    }

    public void reStartListener() {
        if (this.mTcpListener == null || !this.mTcpListener.iI()) {
            if (this.mTcpListener != null) {
                this.mTcpListener.quit();
            }
            this.mTcpListener = new a(this);
            this.mTcpListener.start();
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        if (this.mTcpListener != null) {
            this.mTcpListener.quit();
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }
}

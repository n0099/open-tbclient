package com.baidu.adp.titan;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;
import androidx.annotation.Nullable;
/* loaded from: classes.dex */
public class TitanLocalService extends Service {
    public static final String TAG = TitanLocalService.class.getName();
    public ServiceConnection connection = new a();
    public b mBinder;

    /* loaded from: classes.dex */
    public class a implements ServiceConnection {
        public a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Log.e("LocalService", "connected with TitanLocalService");
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Toast.makeText(TitanLocalService.this, "链接断开，重新启动 RemoteService", 1).show();
            Log.e(TitanLocalService.TAG, "onServiceDisconnected: 链接断开，重新启动 RemoteService");
            TitanLocalService.this.startService(new Intent(TitanLocalService.this, TitanDownloadService.class));
            TitanLocalService.this.bindService(new Intent(TitanLocalService.this, TitanDownloadService.class), TitanLocalService.this.connection, 64);
        }
    }

    /* loaded from: classes.dex */
    public class b extends Binder {
        public b() {
        }
    }

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(Intent intent) {
        b bVar = new b();
        this.mBinder = bVar;
        return bVar;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        Log.e(TAG, "onStartCommand: LocalService 启动");
        Toast.makeText(this, "LocalService 启动", 1).show();
        startService(new Intent(this, TitanDownloadService.class));
        bindService(new Intent(this, TitanDownloadService.class), this.connection, 64);
        return 1;
    }
}

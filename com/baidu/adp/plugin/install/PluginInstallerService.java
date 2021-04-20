package com.baidu.adp.plugin.install;

import android.app.Notification;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.baidu.adp.lib.util.BdLog;
import d.b.c.h.g.d;
/* loaded from: classes.dex */
public class PluginInstallerService extends HighPriorityIntentService {
    public static final String ACTION_INSTALL = "com.baidu.adp.plugin.action.install";
    public static final String ACTION_UNINSTALL = "com.baidu.adp.plugin.action.uninstall";
    public static int APK_LIB_CPUABI_OFFSITE = 4;
    public static final String APK_LIB_DIR_PREFIX = "lib/";
    public static final String APK_LIB_SUFFIX = ".so";
    public Handler handler;
    public Messenger messenger;

    /* loaded from: classes.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message == null || message.replyTo == null) {
                return;
            }
            Message message2 = new Message();
            try {
                message2.setData(message.getData());
                message.replyTo.send(message2);
            } catch (RemoteException e2) {
                BdLog.detailException(e2);
            }
        }
    }

    public PluginInstallerService() {
        super(PluginInstallerService.class.getSimpleName());
        this.handler = new a(Looper.getMainLooper());
        this.messenger = new Messenger(this.handler);
    }

    @Override // com.baidu.adp.plugin.install.HighPriorityIntentService, android.app.Service
    public IBinder onBind(Intent intent) {
        return this.messenger.getBinder();
    }

    @Override // com.baidu.adp.plugin.install.HighPriorityIntentService, android.app.Service
    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT < 18) {
            startForeground(2147483646, new Notification());
        }
    }

    @Override // com.baidu.adp.plugin.install.HighPriorityIntentService, android.app.Service
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.baidu.adp.plugin.install.HighPriorityIntentService
    public void onHandleIntent(Intent intent) {
        d.p(intent);
    }

    @Override // com.baidu.adp.plugin.install.HighPriorityIntentService, android.app.Service
    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
    }

    @Override // com.baidu.adp.plugin.install.HighPriorityIntentService, android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        super.onStartCommand(intent, i, i2);
        return 2;
    }
}

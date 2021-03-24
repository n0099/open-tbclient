package com.baidu.adp.plugin.install;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
/* loaded from: classes.dex */
public abstract class HighPriorityIntentService extends Service {
    public String mName;
    public boolean mRedelivery;
    public volatile a mServiceHandler;
    public volatile Looper mServiceLooper;

    /* loaded from: classes.dex */
    public final class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            HighPriorityIntentService.this.onHandleIntent((Intent) message.obj);
            HighPriorityIntentService.this.stopSelf(message.arg1);
        }
    }

    public HighPriorityIntentService(String str) {
        this.mName = str;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        HandlerThread handlerThread = new HandlerThread("IntentService[" + this.mName + "]", -8);
        handlerThread.start();
        this.mServiceLooper = handlerThread.getLooper();
        this.mServiceHandler = new a(this.mServiceLooper);
    }

    @Override // android.app.Service
    public void onDestroy() {
        this.mServiceLooper.quit();
    }

    public abstract void onHandleIntent(Intent intent);

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        Message obtainMessage = this.mServiceHandler.obtainMessage();
        obtainMessage.arg1 = i;
        obtainMessage.obj = intent;
        this.mServiceHandler.sendMessage(obtainMessage);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        onStart(intent, i2);
        return this.mRedelivery ? 3 : 2;
    }

    public void setIntentRedelivery(boolean z) {
        this.mRedelivery = z;
    }
}

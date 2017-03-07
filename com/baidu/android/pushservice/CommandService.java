package com.baidu.android.pushservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class CommandService extends Service {
    private static final String TAG = "CommandService";

    /* loaded from: classes.dex */
    public static class OnStartCommandData {
        public int flags;
        public Intent intent;
        public int startId;
    }

    @Override // android.app.Service
    public void onCreate() {
        Log.d(TAG, "-- CommandService oncreate -- ");
        super.onCreate();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent == null) {
            stopSelf();
        } else {
            OnStartCommandData onStartCommandData = new OnStartCommandData();
            onStartCommandData.intent = intent;
            onStartCommandData.flags = i;
            onStartCommandData.startId = i2;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage<OnStartCommandData>(CmdConfigCustom.CMD_PUSH_COMMANDSERVICE_ONSTARTCOMMAND, onStartCommandData) { // from class: com.baidu.android.pushservice.CommandService.1
            });
        }
        return 2;
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "onBind initSuc: ");
        return null;
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }
}

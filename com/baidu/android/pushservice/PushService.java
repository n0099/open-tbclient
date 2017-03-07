package com.baidu.android.pushservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.pushservice.CommandService;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class PushService extends Service {
    public static final int FLAG_INCLUDE_STOPPED_PACKAGES = 32;
    private static final String TAG = "PushService";

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "PushService onCreate");
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PUSH_PUSHSERVICE_ONCREATE));
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        CommandService.OnStartCommandData onStartCommandData = new CommandService.OnStartCommandData();
        onStartCommandData.intent = intent;
        onStartCommandData.flags = i;
        onStartCommandData.startId = i2;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_PUSH_PUSHSERVICE_ONSTARTCOMMAND, onStartCommandData), Integer.class);
        if (runTask == null || runTask.getData() == null) {
            return 2;
        }
        return ((Integer) runTask.getData()).intValue() == 1 ? 1 : 2;
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PUSH_PUSHSERVICE_ONDESTROY));
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_PUSH_PUSHSERVICE_ONBIND, intent), IBinder.class);
        if (runTask == null) {
            return null;
        }
        return (IBinder) runTask.getData();
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PUSH_PUSHSERVICE_ONUNBIND, intent));
        return super.onUnbind(intent);
    }
}

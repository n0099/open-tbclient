package com.baidu.tbadk.core.frameworkData;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseService;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
/* loaded from: classes.dex */
public class RemoteActivityProxyService extends BdBaseService {
    public static final int PLUGIN_CHECK_RESULT = 0;
    public static final int PLUGIN_LOADED_FAILED = 2;
    public static final int PLUGIN_LOADED_SUCCEED = 1;
    private Messenger mMessenger;

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        if (this.mMessenger == null) {
            this.mMessenger = new Messenger(new a());
        }
        return this.mMessenger.getBinder();
    }

    /* loaded from: classes.dex */
    private static class a extends Handler {
        private a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            boolean z = false;
            if (message != null) {
                Messenger messenger = message.replyTo;
                try {
                    Bundle data = message.getData();
                    if (data != null) {
                        String string = data.getString(DealIntentService.KEY_CLASS);
                        if (!TextUtils.isEmpty(string)) {
                            Class.forName(string);
                            z = true;
                        }
                    }
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                if (messenger != null) {
                    try {
                        messenger.send(Message.obtain(null, 0, z ? 1 : 2, 0));
                    } catch (RemoteException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }
}

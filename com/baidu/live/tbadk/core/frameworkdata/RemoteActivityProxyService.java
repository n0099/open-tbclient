package com.baidu.live.tbadk.core.frameworkdata;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import com.baidu.live.adp.base.BdBaseService;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
/* loaded from: classes11.dex */
public class RemoteActivityProxyService extends BdBaseService {
    public static final int PLUGIN_CHECK_RESULT = 0;
    public static final int PLUGIN_LOADED_FAILED = 2;
    public static final int PLUGIN_LOADED_SUCCEED = 1;
    private Messenger mClient;
    private Messenger mMessenger;

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        if (this.mMessenger == null) {
            this.mMessenger = new Messenger(new IncomingHandler());
        }
        return this.mMessenger.getBinder();
    }

    @SuppressLint({"HandlerLeak"})
    /* loaded from: classes11.dex */
    private class IncomingHandler extends Handler {
        private IncomingHandler() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            boolean z = false;
            if (message != null) {
                RemoteActivityProxyService.this.mClient = message.replyTo;
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
                try {
                    if (RemoteActivityProxyService.this.mClient != null) {
                        RemoteActivityProxyService.this.mClient.send(Message.obtain(null, 0, z ? 1 : 2, 0));
                    }
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }
}

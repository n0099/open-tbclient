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
/* loaded from: classes3.dex */
public class RemoteActivityProxyService extends BdBaseService {
    public static final int PLUGIN_CHECK_RESULT = 0;
    public static final int PLUGIN_LOADED_FAILED = 2;
    public static final int PLUGIN_LOADED_SUCCEED = 1;
    public Messenger mMessenger;

    /* loaded from: classes3.dex */
    public static class b extends Handler {
        public b() {
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x0024  */
        /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
        @Override // android.os.Handler
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void handleMessage(Message message) {
            boolean z;
            Bundle data;
            if (message == null) {
                return;
            }
            Messenger messenger = message.replyTo;
            try {
                data = message.getData();
            } catch (ClassNotFoundException e2) {
                e2.printStackTrace();
            }
            if (data != null) {
                String string = data.getString(DealIntentService.KEY_CLASS);
                if (!TextUtils.isEmpty(string)) {
                    Class.forName(string);
                    z = true;
                    if (messenger == null) {
                        try {
                            messenger.send(Message.obtain(null, 0, z ? 1 : 2, 0));
                            return;
                        } catch (RemoteException e3) {
                            e3.printStackTrace();
                            return;
                        }
                    }
                    return;
                }
            }
            z = false;
            if (messenger == null) {
            }
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        if (this.mMessenger == null) {
            this.mMessenger = new Messenger(new b());
        }
        return this.mMessenger.getBinder();
    }
}

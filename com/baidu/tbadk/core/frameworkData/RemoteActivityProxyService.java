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
/* loaded from: classes.dex */
public class RemoteActivityProxyService extends BdBaseService {
    public static final int PLUGIN_CHECK_RESULT = 0;
    public static final int PLUGIN_LOADED_FAILED = 2;
    public static final int PLUGIN_LOADED_SUCCEED = 1;
    private Messenger mClient;
    private Messenger mMessenger;

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        if (this.mMessenger == null) {
            this.mMessenger = new Messenger(new a(this, null));
        }
        return this.mMessenger.getBinder();
    }

    /* loaded from: classes.dex */
    private class a extends Handler {
        private a() {
        }

        /* synthetic */ a(RemoteActivityProxyService remoteActivityProxyService, a aVar) {
            this();
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x0029 A[Catch: RemoteException -> 0x0045, TryCatch #0 {RemoteException -> 0x0045, blocks: (B:11:0x0021, B:13:0x0029, B:16:0x0034), top: B:24:0x0021 }] */
        /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
        @Override // android.os.Handler
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void handleMessage(Message message) {
            boolean z;
            Bundle data;
            if (message != null) {
                RemoteActivityProxyService.this.mClient = message.replyTo;
                try {
                    data = message.getData();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                try {
                    if (data != null) {
                        String string = data.getString("class");
                        if (!TextUtils.isEmpty(string)) {
                            Class.forName(string);
                            z = true;
                            if (RemoteActivityProxyService.this.mClient == null) {
                                RemoteActivityProxyService.this.mClient.send(Message.obtain(null, 0, z ? 1 : 2, 0));
                                return;
                            }
                            return;
                        }
                    }
                    if (RemoteActivityProxyService.this.mClient == null) {
                    }
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                    return;
                }
                z = false;
            }
        }
    }
}

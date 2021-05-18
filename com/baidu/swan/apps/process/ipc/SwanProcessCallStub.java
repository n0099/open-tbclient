package com.baidu.swan.apps.process.ipc;

import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import com.baidu.swan.apps.IProcessBridge;
import d.a.i0.a.v1.b.d;
/* loaded from: classes3.dex */
public class SwanProcessCallStub extends IProcessBridge.Stub {
    public final Handler mHandler;

    public SwanProcessCallStub(Handler handler) {
        this.mHandler = handler;
    }

    @Override // com.baidu.swan.apps.IProcessBridge
    @WorkerThread
    public Bundle callMainProcessSync(String str, Bundle bundle) throws RemoteException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return d.d(str, bundle);
    }

    @Override // com.baidu.swan.apps.IProcessBridge
    @WorkerThread
    public void send(Message message) throws RemoteException {
        if (message == null || this.mHandler == null) {
            return;
        }
        message.sendingUid = Binder.getCallingUid();
        this.mHandler.sendMessage(message);
    }
}

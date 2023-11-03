package com.baidu.swan.apps.process.ipc;

import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import com.baidu.swan.apps.IAsyncProcessCallback;
import com.baidu.swan.apps.IProcessBridge;
import com.baidu.tieba.t23;
/* loaded from: classes4.dex */
public class SwanProcessCallStub extends IProcessBridge.Stub {
    public final Handler mHandler;

    @Override // com.baidu.swan.apps.IProcessBridge
    public void callMainProcessAsync(String str, int i, IAsyncProcessCallback iAsyncProcessCallback) throws RemoteException {
    }

    public SwanProcessCallStub(Handler handler) {
        this.mHandler = handler;
    }

    @Override // com.baidu.swan.apps.IProcessBridge
    @WorkerThread
    public void send(Message message) throws RemoteException {
        if (message != null && this.mHandler != null) {
            message.sendingUid = Binder.getCallingUid();
            this.mHandler.sendMessage(message);
        }
    }

    @Override // com.baidu.swan.apps.IProcessBridge
    @WorkerThread
    public Bundle callMainProcessSync(String str, Bundle bundle) throws RemoteException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return t23.e(str, bundle);
    }
}

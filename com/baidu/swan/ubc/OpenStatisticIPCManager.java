package com.baidu.swan.ubc;

import android.os.RemoteException;
import android.text.TextUtils;
import com.baidu.pyramid.runtime.multiprocess.IPCServiceManager;
import com.baidu.swan.ubc.IRemoteUBCService;
import com.baidu.tieba.an4;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class OpenStatisticIPCManager {
    public static void a() {
        IPCServiceManager.c("open_log", new IRemoteUBCService.Stub() { // from class: com.baidu.swan.ubc.OpenStatisticIPCManager.1
            @Override // com.baidu.swan.ubc.IRemoteUBCService
            public void flowAddEvent(Flow flow, String str, String str2) throws RemoteException {
                if (flow != null) {
                    flow.addEvent(str, str2);
                }
            }

            @Override // com.baidu.swan.ubc.IRemoteUBCService
            public void flowStartSlot(Flow flow, String str, String str2) throws RemoteException {
                if (flow != null) {
                    if (TextUtils.isEmpty(str2)) {
                        flow.startSlot(str, null);
                        return;
                    }
                    try {
                        flow.startSlot(str, new JSONObject(str2));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override // com.baidu.swan.ubc.IRemoteUBCService
            public Flow ubcBeginFlow(String str, String str2, int i) throws RemoteException {
                return an4.e(str, str2, i);
            }

            @Override // com.baidu.swan.ubc.IRemoteUBCService
            public void ubcOnEvent(String str, String str2, int i) throws RemoteException {
                an4.i(str, str2, i);
            }

            @Override // com.baidu.swan.ubc.IRemoteUBCService
            public void flowAddEventWithTime(Flow flow, String str, String str2, long j) {
                if (flow != null) {
                    flow.addEvent(str, str2, j);
                }
            }

            @Override // com.baidu.swan.ubc.IRemoteUBCService
            public void flowCancel(Flow flow) throws RemoteException {
                if (flow != null) {
                    flow.cancel();
                }
            }

            @Override // com.baidu.swan.ubc.IRemoteUBCService
            public void flowEnd(Flow flow) throws RemoteException {
                if (flow != null) {
                    flow.end();
                }
            }

            @Override // com.baidu.swan.ubc.IRemoteUBCService
            public void flowEndSlot(Flow flow, String str) throws RemoteException {
                if (flow != null) {
                    flow.endSlot(str);
                }
            }

            @Override // com.baidu.swan.ubc.IRemoteUBCService
            public void flowSetValue(Flow flow, String str) throws RemoteException {
                if (flow != null) {
                    flow.setValue(str);
                }
            }

            @Override // com.baidu.swan.ubc.IRemoteUBCService
            public void flowSetValueWithDuration(Flow flow, String str) throws RemoteException {
                if (flow != null) {
                    flow.setValueWithDuration(str);
                }
            }
        }, false);
    }
}

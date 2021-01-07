package com.baidu.swan.ubc;

import android.os.RemoteException;
import android.text.TextUtils;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class p {
    private p() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class a {
        private static final p eBC = new p();
    }

    public static p biL() {
        return a.eBC;
    }

    public final void onEvent(String str) {
        onEvent(str, "", 0);
    }

    public final void onEvent(String str, Map<String, String> map, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
        } catch (JSONException e) {
        }
        onEvent(str, jSONObject.toString(), i);
    }

    public void onEvent(String str, String str2, int i) {
        if (com.baidu.pyramid.runtime.multiprocess.a.ahE()) {
            if (e.bio() != null || !TextUtils.isEmpty(str)) {
                n.biK().o(str, str2, i);
                return;
            }
            return;
        }
        try {
            bip().ubcOnEvent(str, s.zC(str2), i);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void onEvent(String str, JSONObject jSONObject, int i) {
        if (com.baidu.pyramid.runtime.multiprocess.a.ahE()) {
            if (e.bio() != null || !TextUtils.isEmpty(str)) {
                n.biK().a(str, jSONObject, i);
                return;
            }
            return;
        }
        try {
            bip().ubcOnEvent(str, s.dm(jSONObject), i);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public Flow n(String str, String str2, int i) {
        if (com.baidu.pyramid.runtime.multiprocess.a.ahE()) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return n.biK().n(str, str2, i);
        }
        return p(str, s.zC(str2), i);
    }

    public void upload() {
        n.biK().upload();
    }

    public void biM() {
        n.biK().bii();
    }

    private IRemoteUBCService bip() throws RemoteException {
        return e.bip();
    }

    private Flow p(String str, String str2, int i) {
        Flow flow;
        try {
            flow = bip().ubcBeginFlow(str, str2, i);
        } catch (RemoteException e) {
            e.printStackTrace();
            flow = null;
        }
        if (flow == null) {
            return new Flow();
        }
        return flow;
    }
}

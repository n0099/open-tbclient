package com.baidu.swan.ubc;

import android.os.RemoteException;
import android.text.TextUtils;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes14.dex */
public class p {
    private p() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes14.dex */
    public static class a {
        private static final p eAx = new p();
    }

    public static p bfg() {
        return a.eAx;
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
        if (com.baidu.pyramid.runtime.multiprocess.a.aee()) {
            if (e.beJ() != null || !TextUtils.isEmpty(str)) {
                n.bff().o(str, str2, i);
                return;
            }
            return;
        }
        try {
            beK().ubcOnEvent(str, s.yR(str2), i);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void onEvent(String str, JSONObject jSONObject, int i) {
        if (com.baidu.pyramid.runtime.multiprocess.a.aee()) {
            if (e.beJ() != null || !TextUtils.isEmpty(str)) {
                n.bff().a(str, jSONObject, i);
                return;
            }
            return;
        }
        try {
            beK().ubcOnEvent(str, s.dl(jSONObject), i);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public Flow n(String str, String str2, int i) {
        if (com.baidu.pyramid.runtime.multiprocess.a.aee()) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return n.bff().n(str, str2, i);
        }
        return p(str, s.yR(str2), i);
    }

    public void upload() {
        n.bff().upload();
    }

    public void bfh() {
        n.bff().beD();
    }

    private IRemoteUBCService beK() throws RemoteException {
        return e.beK();
    }

    private Flow p(String str, String str2, int i) {
        Flow flow;
        try {
            flow = beK().ubcBeginFlow(str, str2, i);
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

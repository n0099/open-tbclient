package com.baidu.swan.ubc;

import android.os.RemoteException;
import android.text.TextUtils;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class p {
    private p() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class a {
        private static final p dJZ = new p();
    }

    public static p aWc() {
        return a.dJZ;
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
        if (com.baidu.pyramid.runtime.multiprocess.a.Wi()) {
            if (e.aVF() != null || !TextUtils.isEmpty(str)) {
                n.aWb().k(str, str2, i);
                return;
            }
            return;
        }
        try {
            aVG().ubcOnEvent(str, s.xo(str2), i);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void onEvent(String str, JSONObject jSONObject, int i) {
        if (com.baidu.pyramid.runtime.multiprocess.a.Wi()) {
            if (e.aVF() != null || !TextUtils.isEmpty(str)) {
                n.aWb().a(str, jSONObject, i);
                return;
            }
            return;
        }
        try {
            aVG().ubcOnEvent(str, s.cP(jSONObject), i);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public Flow j(String str, String str2, int i) {
        if (com.baidu.pyramid.runtime.multiprocess.a.Wi()) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return n.aWb().j(str, str2, i);
        }
        return l(str, s.xo(str2), i);
    }

    public void upload() {
        n.aWb().upload();
    }

    public void aWd() {
        n.aWb().aVz();
    }

    private IRemoteUBCService aVG() throws RemoteException {
        return e.aVG();
    }

    private Flow l(String str, String str2, int i) {
        Flow flow;
        try {
            flow = aVG().ubcBeginFlow(str, str2, i);
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

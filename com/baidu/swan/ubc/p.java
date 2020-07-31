package com.baidu.swan.ubc;

import android.os.RemoteException;
import android.text.TextUtils;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class p {
    private p() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class a {
        private static final p dAP = new p();
    }

    public static p aNC() {
        return a.dAP;
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
        if (com.baidu.pyramid.runtime.multiprocess.a.Qn()) {
            if (e.aNf() != null || !TextUtils.isEmpty(str)) {
                n.aNB().j(str, str2, i);
                return;
            }
            return;
        }
        try {
            aNg().ubcOnEvent(str, s.vd(str2), i);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void onEvent(String str, JSONObject jSONObject, int i) {
        if (com.baidu.pyramid.runtime.multiprocess.a.Qn()) {
            if (e.aNf() != null || !TextUtils.isEmpty(str)) {
                n.aNB().a(str, jSONObject, i);
                return;
            }
            return;
        }
        try {
            aNg().ubcOnEvent(str, s.cJ(jSONObject), i);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public Flow i(String str, String str2, int i) {
        if (com.baidu.pyramid.runtime.multiprocess.a.Qn()) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return n.aNB().i(str, str2, i);
        }
        return k(str, s.vd(str2), i);
    }

    public void upload() {
        n.aNB().upload();
    }

    public void aND() {
        n.aNB().aMZ();
    }

    private IRemoteUBCService aNg() throws RemoteException {
        return e.aNg();
    }

    private Flow k(String str, String str2, int i) {
        Flow flow;
        try {
            flow = aNg().ubcBeginFlow(str, str2, i);
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

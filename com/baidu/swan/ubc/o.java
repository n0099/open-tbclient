package com.baidu.swan.ubc;

import android.os.RemoteException;
import android.text.TextUtils;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class o {
    private o() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a {
        private static final o bOY = new o();
    }

    public static o acT() {
        return a.bOY;
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
        if (com.baidu.pyramid.runtime.multiprocess.a.Aa()) {
            if (s.adf() != null || !TextUtils.isEmpty(str)) {
                m.acQ().f(str, str2, i);
                return;
            }
            return;
        }
        try {
            acV().ubcOnEvent(str, r.lC(str2), i);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void onEvent(String str, JSONObject jSONObject, int i) {
        if (com.baidu.pyramid.runtime.multiprocess.a.Aa()) {
            if (s.adf() != null || !TextUtils.isEmpty(str)) {
                m.acQ().a(str, jSONObject, i);
                return;
            }
            return;
        }
        try {
            acV().ubcOnEvent(str, r.bs(jSONObject), i);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public Flow g(String str, String str2, int i) {
        if (com.baidu.pyramid.runtime.multiprocess.a.Aa()) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return m.acQ().g(str, str2, i);
        }
        return h(str, r.lC(str2), i);
    }

    public void acR() {
        m.acQ().acR();
    }

    public void acU() {
        m.acQ().acr();
    }

    private IRemoteUBCService acV() throws RemoteException {
        return s.acV();
    }

    private Flow h(String str, String str2, int i) {
        Flow flow;
        try {
            flow = acV().ubcBeginFlow(str, str2, i);
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

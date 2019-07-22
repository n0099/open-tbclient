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
        private static final o bwK = new o();
    }

    public static o Yb() {
        return a.bwK;
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
        if (com.baidu.pyramid.runtime.multiprocess.a.vb()) {
            if (s.Yn() != null || !TextUtils.isEmpty(str)) {
                m.XY().f(str, str2, i);
                return;
            }
            return;
        }
        try {
            Yd().ubcOnEvent(str, r.kY(str2), i);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void onEvent(String str, JSONObject jSONObject, int i) {
        if (com.baidu.pyramid.runtime.multiprocess.a.vb()) {
            if (s.Yn() != null || !TextUtils.isEmpty(str)) {
                m.XY().a(str, jSONObject, i);
                return;
            }
            return;
        }
        try {
            Yd().ubcOnEvent(str, r.aT(jSONObject), i);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public Flow g(String str, String str2, int i) {
        if (com.baidu.pyramid.runtime.multiprocess.a.vb()) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return m.XY().g(str, str2, i);
        }
        return h(str, r.kY(str2), i);
    }

    public void XZ() {
        m.XY().XZ();
    }

    public void Yc() {
        m.XY().XA();
    }

    private IRemoteUBCService Yd() throws RemoteException {
        return s.Yd();
    }

    private Flow h(String str, String str2, int i) {
        Flow flow;
        try {
            flow = Yd().ubcBeginFlow(str, str2, i);
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

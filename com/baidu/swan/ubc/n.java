package com.baidu.swan.ubc;

import android.os.RemoteException;
import android.text.TextUtils;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class n {
    private n() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a {
        private static final n bpE = new n();
    }

    public static n Tl() {
        return a.bpE;
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
        if (com.baidu.pyramid.runtime.multiprocess.a.tR()) {
            if (q.Ts() != null || !TextUtils.isEmpty(str)) {
                l.Tk().h(str, str2, i);
                return;
            }
            return;
        }
        try {
            Tm().ubcOnEvent(str, p.jR(str2), i);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void onEvent(String str, JSONObject jSONObject, int i) {
        if (com.baidu.pyramid.runtime.multiprocess.a.tR()) {
            if (q.Ts() != null || !TextUtils.isEmpty(str)) {
                l.Tk().a(str, jSONObject, i);
                return;
            }
            return;
        }
        try {
            Tm().ubcOnEvent(str, p.aH(jSONObject), i);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public Flow i(String str, String str2, int i) {
        if (com.baidu.pyramid.runtime.multiprocess.a.tR()) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return l.Tk().i(str, str2, i);
        }
        return j(str, p.jR(str2), i);
    }

    private IRemoteUBCService Tm() throws RemoteException {
        return q.Tm();
    }

    private Flow j(String str, String str2, int i) {
        Flow flow;
        try {
            flow = Tm().ubcBeginFlow(str, str2, i);
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

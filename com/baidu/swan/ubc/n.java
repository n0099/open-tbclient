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
        private static final n bpI = new n();
    }

    public static n Tj() {
        return a.bpI;
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
        if (com.baidu.pyramid.runtime.multiprocess.a.tQ()) {
            if (q.Tq() != null || !TextUtils.isEmpty(str)) {
                l.Ti().h(str, str2, i);
                return;
            }
            return;
        }
        try {
            Tk().ubcOnEvent(str, p.jS(str2), i);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void onEvent(String str, JSONObject jSONObject, int i) {
        if (com.baidu.pyramid.runtime.multiprocess.a.tQ()) {
            if (q.Tq() != null || !TextUtils.isEmpty(str)) {
                l.Ti().a(str, jSONObject, i);
                return;
            }
            return;
        }
        try {
            Tk().ubcOnEvent(str, p.aH(jSONObject), i);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public Flow i(String str, String str2, int i) {
        if (com.baidu.pyramid.runtime.multiprocess.a.tQ()) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return l.Ti().i(str, str2, i);
        }
        return j(str, p.jS(str2), i);
    }

    private IRemoteUBCService Tk() throws RemoteException {
        return q.Tk();
    }

    private Flow j(String str, String str2, int i) {
        Flow flow;
        try {
            flow = Tk().ubcBeginFlow(str, str2, i);
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

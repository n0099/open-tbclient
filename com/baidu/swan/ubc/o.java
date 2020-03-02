package com.baidu.swan.ubc;

import android.os.RemoteException;
import android.text.TextUtils;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class o {
    private o() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class a {
        private static final o cFc = new o();
    }

    public static o avH() {
        return a.cFc;
    }

    public final void onEvent(String str) {
        k(str, "", 0);
    }

    public final void a(String str, Map<String, String> map, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
        } catch (JSONException e) {
        }
        k(str, jSONObject.toString(), i);
    }

    public void k(String str, String str2, int i) {
        if (com.baidu.pyramid.runtime.multiprocess.a.ER()) {
            if (s.avT() != null || !TextUtils.isEmpty(str)) {
                m.avF().i(str, str2, i);
                return;
            }
            return;
        }
        try {
            avJ().ubcOnEvent(str, r.ra(str2), i);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void b(String str, JSONObject jSONObject, int i) {
        if (com.baidu.pyramid.runtime.multiprocess.a.ER()) {
            if (s.avT() != null || !TextUtils.isEmpty(str)) {
                m.avF().a(str, jSONObject, i);
                return;
            }
            return;
        }
        try {
            avJ().ubcOnEvent(str, r.cf(jSONObject), i);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public Flow j(String str, String str2, int i) {
        if (com.baidu.pyramid.runtime.multiprocess.a.ER()) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return m.avF().j(str, str2, i);
        }
        return l(str, r.ra(str2), i);
    }

    public void upload() {
        m.avF().upload();
    }

    public void avI() {
        m.avF().avg();
    }

    private IRemoteUBCService avJ() throws RemoteException {
        return s.avJ();
    }

    private Flow l(String str, String str2, int i) {
        Flow flow;
        try {
            flow = avJ().ubcBeginFlow(str, str2, i);
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

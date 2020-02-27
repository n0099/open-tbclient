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
        private static final o cFb = new o();
    }

    public static o avF() {
        return a.cFb;
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
        if (com.baidu.pyramid.runtime.multiprocess.a.EP()) {
            if (s.avR() != null || !TextUtils.isEmpty(str)) {
                m.avD().i(str, str2, i);
                return;
            }
            return;
        }
        try {
            avH().ubcOnEvent(str, r.ra(str2), i);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void b(String str, JSONObject jSONObject, int i) {
        if (com.baidu.pyramid.runtime.multiprocess.a.EP()) {
            if (s.avR() != null || !TextUtils.isEmpty(str)) {
                m.avD().a(str, jSONObject, i);
                return;
            }
            return;
        }
        try {
            avH().ubcOnEvent(str, r.cf(jSONObject), i);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public Flow j(String str, String str2, int i) {
        if (com.baidu.pyramid.runtime.multiprocess.a.EP()) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return m.avD().j(str, str2, i);
        }
        return l(str, r.ra(str2), i);
    }

    public void upload() {
        m.avD().upload();
    }

    public void avG() {
        m.avD().ave();
    }

    private IRemoteUBCService avH() throws RemoteException {
        return s.avH();
    }

    private Flow l(String str, String str2, int i) {
        Flow flow;
        try {
            flow = avH().ubcBeginFlow(str, str2, i);
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

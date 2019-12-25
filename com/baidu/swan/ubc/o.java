package com.baidu.swan.ubc;

import android.os.RemoteException;
import android.text.TextUtils;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class o {
    private o() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class a {
        private static final o cAS = new o();
    }

    public static o asY() {
        return a.cAS;
    }

    public final void onEvent(String str) {
        l(str, "", 0);
    }

    public final void a(String str, Map<String, String> map, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
        } catch (JSONException e) {
        }
        l(str, jSONObject.toString(), i);
    }

    public void l(String str, String str2, int i) {
        if (com.baidu.pyramid.runtime.multiprocess.a.BX()) {
            if (s.atk() != null || !TextUtils.isEmpty(str)) {
                m.asW().j(str, str2, i);
                return;
            }
            return;
        }
        try {
            ata().ubcOnEvent(str, r.qI(str2), i);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void b(String str, JSONObject jSONObject, int i) {
        if (com.baidu.pyramid.runtime.multiprocess.a.BX()) {
            if (s.atk() != null || !TextUtils.isEmpty(str)) {
                m.asW().a(str, jSONObject, i);
                return;
            }
            return;
        }
        try {
            ata().ubcOnEvent(str, r.cf(jSONObject), i);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public Flow k(String str, String str2, int i) {
        if (com.baidu.pyramid.runtime.multiprocess.a.BX()) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return m.asW().k(str, str2, i);
        }
        return m(str, r.qI(str2), i);
    }

    public void upload() {
        m.asW().upload();
    }

    public void asZ() {
        m.asW().asx();
    }

    private IRemoteUBCService ata() throws RemoteException {
        return s.ata();
    }

    private Flow m(String str, String str2, int i) {
        Flow flow;
        try {
            flow = ata().ubcBeginFlow(str, str2, i);
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

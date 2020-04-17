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
        private static final o deo = new o();
    }

    public static o aDV() {
        return a.deo;
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
        if (com.baidu.pyramid.runtime.multiprocess.a.MG()) {
            if (s.aEh() != null || !TextUtils.isEmpty(str)) {
                m.aDT().i(str, str2, i);
                return;
            }
            return;
        }
        try {
            aDX().ubcOnEvent(str, r.sm(str2), i);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void onEvent(String str, JSONObject jSONObject, int i) {
        if (com.baidu.pyramid.runtime.multiprocess.a.MG()) {
            if (s.aEh() != null || !TextUtils.isEmpty(str)) {
                m.aDT().a(str, jSONObject, i);
                return;
            }
            return;
        }
        try {
            aDX().ubcOnEvent(str, r.cq(jSONObject), i);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public Flow j(String str, String str2, int i) {
        if (com.baidu.pyramid.runtime.multiprocess.a.MG()) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return m.aDT().j(str, str2, i);
        }
        return k(str, r.sm(str2), i);
    }

    public void upload() {
        m.aDT().upload();
    }

    public void aDW() {
        m.aDT().aDu();
    }

    private IRemoteUBCService aDX() throws RemoteException {
        return s.aDX();
    }

    private Flow k(String str, String str2, int i) {
        Flow flow;
        try {
            flow = aDX().ubcBeginFlow(str, str2, i);
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

package com.baidu.swan.ubc;

import android.os.RemoteException;
import android.text.TextUtils;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes15.dex */
public class p {
    private p() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes15.dex */
    public static class a {
        private static final p eyW = new p();
    }

    public static p bfe() {
        return a.eyW;
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
        if (com.baidu.pyramid.runtime.multiprocess.a.aeb()) {
            if (e.beH() != null || !TextUtils.isEmpty(str)) {
                n.bfd().o(str, str2, i);
                return;
            }
            return;
        }
        try {
            beI().ubcOnEvent(str, s.yK(str2), i);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void onEvent(String str, JSONObject jSONObject, int i) {
        if (com.baidu.pyramid.runtime.multiprocess.a.aeb()) {
            if (e.beH() != null || !TextUtils.isEmpty(str)) {
                n.bfd().a(str, jSONObject, i);
                return;
            }
            return;
        }
        try {
            beI().ubcOnEvent(str, s.dj(jSONObject), i);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public Flow n(String str, String str2, int i) {
        if (com.baidu.pyramid.runtime.multiprocess.a.aeb()) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return n.bfd().n(str, str2, i);
        }
        return p(str, s.yK(str2), i);
    }

    public void upload() {
        n.bfd().upload();
    }

    public void bff() {
        n.bfd().beB();
    }

    private IRemoteUBCService beI() throws RemoteException {
        return e.beI();
    }

    private Flow p(String str, String str2, int i) {
        Flow flow;
        try {
            flow = beI().ubcBeginFlow(str, str2, i);
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

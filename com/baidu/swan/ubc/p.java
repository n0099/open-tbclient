package com.baidu.swan.ubc;

import android.os.RemoteException;
import android.text.TextUtils;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes16.dex */
public class p {
    private p() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes16.dex */
    public static class a {
        private static final p ekP = new p();
    }

    public static p bdi() {
        return a.ekP;
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
        if (com.baidu.pyramid.runtime.multiprocess.a.acx()) {
            if (e.bcL() != null || !TextUtils.isEmpty(str)) {
                n.bdh().l(str, str2, i);
                return;
            }
            return;
        }
        try {
            bcM().ubcOnEvent(str, s.yW(str2), i);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void onEvent(String str, JSONObject jSONObject, int i) {
        if (com.baidu.pyramid.runtime.multiprocess.a.acx()) {
            if (e.bcL() != null || !TextUtils.isEmpty(str)) {
                n.bdh().a(str, jSONObject, i);
                return;
            }
            return;
        }
        try {
            bcM().ubcOnEvent(str, s.dc(jSONObject), i);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public Flow k(String str, String str2, int i) {
        if (com.baidu.pyramid.runtime.multiprocess.a.acx()) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return n.bdh().k(str, str2, i);
        }
        return m(str, s.yW(str2), i);
    }

    public void upload() {
        n.bdh().upload();
    }

    public void bdj() {
        n.bdh().bcF();
    }

    private IRemoteUBCService bcM() throws RemoteException {
        return e.bcM();
    }

    private Flow m(String str, String str2, int i) {
        Flow flow;
        try {
            flow = bcM().ubcBeginFlow(str, str2, i);
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

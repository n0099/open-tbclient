package com.baidu.swan.ubc;

import android.os.RemoteException;
import android.text.TextUtils;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class p {
    private p() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class a {
        private static final p dYi = new p();
    }

    public static p aZw() {
        return a.dYi;
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
        if (com.baidu.pyramid.runtime.multiprocess.a.YO()) {
            if (e.aYZ() != null || !TextUtils.isEmpty(str)) {
                n.aZv().k(str, str2, i);
                return;
            }
            return;
        }
        try {
            aZa().ubcOnEvent(str, s.yu(str2), i);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void onEvent(String str, JSONObject jSONObject, int i) {
        if (com.baidu.pyramid.runtime.multiprocess.a.YO()) {
            if (e.aYZ() != null || !TextUtils.isEmpty(str)) {
                n.aZv().a(str, jSONObject, i);
                return;
            }
            return;
        }
        try {
            aZa().ubcOnEvent(str, s.cZ(jSONObject), i);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public Flow j(String str, String str2, int i) {
        if (com.baidu.pyramid.runtime.multiprocess.a.YO()) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return n.aZv().j(str, str2, i);
        }
        return l(str, s.yu(str2), i);
    }

    public void upload() {
        n.aZv().upload();
    }

    public void aZx() {
        n.aZv().aYT();
    }

    private IRemoteUBCService aZa() throws RemoteException {
        return e.aZa();
    }

    private Flow l(String str, String str2, int i) {
        Flow flow;
        try {
            flow = aZa().ubcBeginFlow(str, str2, i);
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

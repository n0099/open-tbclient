package com.baidu.swan.ubc;

import android.os.RemoteException;
import android.text.TextUtils;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class p {
    private p() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class a {
        private static final p ewN = new p();
    }

    public static p beR() {
        return a.ewN;
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
        if (com.baidu.pyramid.runtime.multiprocess.a.adK()) {
            if (e.beu() != null || !TextUtils.isEmpty(str)) {
                n.beQ().o(str, str2, i);
                return;
            }
            return;
        }
        try {
            bev().ubcOnEvent(str, s.yr(str2), i);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void onEvent(String str, JSONObject jSONObject, int i) {
        if (com.baidu.pyramid.runtime.multiprocess.a.adK()) {
            if (e.beu() != null || !TextUtils.isEmpty(str)) {
                n.beQ().a(str, jSONObject, i);
                return;
            }
            return;
        }
        try {
            bev().ubcOnEvent(str, s.dm(jSONObject), i);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public Flow n(String str, String str2, int i) {
        if (com.baidu.pyramid.runtime.multiprocess.a.adK()) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return n.beQ().n(str, str2, i);
        }
        return p(str, s.yr(str2), i);
    }

    public void upload() {
        n.beQ().upload();
    }

    public void beS() {
        n.beQ().beo();
    }

    private IRemoteUBCService bev() throws RemoteException {
        return e.bev();
    }

    private Flow p(String str, String str2, int i) {
        Flow flow;
        try {
            flow = bev().ubcBeginFlow(str, str2, i);
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

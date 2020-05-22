package com.baidu.swan.ubc;

import android.os.RemoteException;
import android.text.TextUtils;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class p {
    private p() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class a {
        private static final p dqo = new p();
    }

    public static p aIF() {
        return a.dqo;
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
        if (com.baidu.pyramid.runtime.multiprocess.a.OS()) {
            if (e.aIh() != null || !TextUtils.isEmpty(str)) {
                n.aID().j(str, str2, i);
                return;
            }
            return;
        }
        try {
            aIi().ubcOnEvent(str, s.tS(str2), i);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void onEvent(String str, JSONObject jSONObject, int i) {
        if (com.baidu.pyramid.runtime.multiprocess.a.OS()) {
            if (e.aIh() != null || !TextUtils.isEmpty(str)) {
                n.aID().a(str, jSONObject, i);
                return;
            }
            return;
        }
        try {
            aIi().ubcOnEvent(str, s.cw(jSONObject), i);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public Flow i(String str, String str2, int i) {
        if (com.baidu.pyramid.runtime.multiprocess.a.OS()) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return n.aID().i(str, str2, i);
        }
        return k(str, s.tS(str2), i);
    }

    public void upload() {
        n.aID().upload();
    }

    public void aIG() {
        n.aID().aIb();
    }

    private IRemoteUBCService aIi() throws RemoteException {
        return e.aIi();
    }

    private Flow k(String str, String str2, int i) {
        Flow flow;
        try {
            flow = aIi().ubcBeginFlow(str, str2, i);
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

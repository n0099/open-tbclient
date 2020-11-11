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
        private static final p emw = new p();
    }

    public static p bdP() {
        return a.emw;
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
        if (com.baidu.pyramid.runtime.multiprocess.a.adg()) {
            if (e.bds() != null || !TextUtils.isEmpty(str)) {
                n.bdO().l(str, str2, i);
                return;
            }
            return;
        }
        try {
            bdt().ubcOnEvent(str, s.zb(str2), i);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void onEvent(String str, JSONObject jSONObject, int i) {
        if (com.baidu.pyramid.runtime.multiprocess.a.adg()) {
            if (e.bds() != null || !TextUtils.isEmpty(str)) {
                n.bdO().a(str, jSONObject, i);
                return;
            }
            return;
        }
        try {
            bdt().ubcOnEvent(str, s.di(jSONObject), i);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public Flow k(String str, String str2, int i) {
        if (com.baidu.pyramid.runtime.multiprocess.a.adg()) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return n.bdO().k(str, str2, i);
        }
        return m(str, s.zb(str2), i);
    }

    public void upload() {
        n.bdO().upload();
    }

    public void bdQ() {
        n.bdO().bdm();
    }

    private IRemoteUBCService bdt() throws RemoteException {
        return e.bdt();
    }

    private Flow m(String str, String str2, int i) {
        Flow flow;
        try {
            flow = bdt().ubcBeginFlow(str, str2, i);
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

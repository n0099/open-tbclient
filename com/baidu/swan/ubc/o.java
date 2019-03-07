package com.baidu.swan.ubc;

import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class o {
    public static final boolean DEBUG = e.DEBUG;

    private o() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a {
        private static final o bpD = new o();
    }

    public static o Tl() {
        return a.bpD;
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
            if (DEBUG) {
                Log.d("OpenStatManager", "Open Statistic : UBC onEvent# exception:" + e.getMessage());
            }
        }
        onEvent(str, jSONObject.toString(), i);
    }

    public void onEvent(String str, String str2, int i) {
        if (com.baidu.pyramid.runtime.multiprocess.a.tR()) {
            if (r.Ts() == null && TextUtils.isEmpty(str)) {
                if (DEBUG) {
                    throw new IllegalArgumentException("UBC onEvent#eventId must not be null.");
                }
                return;
            }
            if (DEBUG) {
                Log.d("OpenStatManager", "Open Statistic : on event id:" + str + " value:" + str2);
            }
            m.Tk().h(str, str2, i);
            return;
        }
        try {
            Tm().ubcOnEvent(str, q.jR(str2), i);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void onEvent(String str, JSONObject jSONObject, int i) {
        if (com.baidu.pyramid.runtime.multiprocess.a.tR()) {
            if (r.Ts() != null || !TextUtils.isEmpty(str)) {
                if (DEBUG) {
                    Log.d("OpenStatManager", "Open Statistic : on event id:" + str + " value:" + jSONObject.toString());
                }
                m.Tk().a(str, jSONObject, i);
                return;
            }
            return;
        }
        try {
            Tm().ubcOnEvent(str, q.aH(jSONObject), i);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public Flow i(String str, String str2, int i) {
        if (com.baidu.pyramid.runtime.multiprocess.a.tR()) {
            if (TextUtils.isEmpty(str)) {
                if (DEBUG) {
                    throw new IllegalArgumentException("UBC beginFlow#flowId must not be null.");
                }
                return null;
            }
            if (DEBUG) {
                Log.d("OpenStatManager", "begin flow id:" + str + " value:" + str2);
            }
            return m.Tk().i(str, str2, i);
        }
        return j(str, q.jR(str2), i);
    }

    private IRemoteUBCService Tm() throws RemoteException {
        return r.Tm();
    }

    private Flow j(String str, String str2, int i) {
        Flow flow;
        Flow flow2 = null;
        try {
            flow2 = Tm().ubcBeginFlow(str, str2, i);
            if (DEBUG) {
                Log.d("OpenStatManager", "flow id " + str + " beginFlow  process name " + com.baidu.pyramid.runtime.multiprocess.a.getProcessName() + "flow hashCode " + flow2.hashCode() + " handle id " + flow2.getHandle());
            }
            flow = flow2;
        } catch (RemoteException e) {
            e.printStackTrace();
            flow = flow2;
        }
        if (flow == null) {
            return new Flow();
        }
        return flow;
    }
}

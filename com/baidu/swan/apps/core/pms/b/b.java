package com.baidu.swan.apps.core.pms.b;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.runtime.i;
import com.baidu.swan.apps.runtime.j;
import com.baidu.swan.pms.c.f;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public final class b extends com.baidu.swan.apps.core.pms.b.a implements f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static Boolean cdb = null;

    public b(j jVar) {
        super(jVar);
    }

    @Override // com.baidu.swan.apps.core.pms.b.a, com.baidu.swan.pms.c.f
    public void a(String str, Map<String, String> map, Map<String, String> map2, f.a aVar) {
        log("buildGetRequest");
        if (abo()) {
            a("pms_http_with_ipc_action_build_get_request", str, map, map2, null, aVar);
        } else {
            super.a(str, map, map2, aVar);
        }
    }

    @Override // com.baidu.swan.apps.core.pms.b.a, com.baidu.swan.pms.c.f
    public void a(String str, Map<String, String> map, Map<String, String> map2, JSONObject jSONObject, f.a aVar) {
        log("buildJsonPostRequest");
        if (abo()) {
            a("pms_http_with_ipc_action_build_json_post_request", str, map, map2, jSONObject, aVar);
        } else {
            super.a(str, map, map2, jSONObject, aVar);
        }
    }

    boolean abo() {
        if (cdb == null) {
            cdb = Boolean.valueOf(com.baidu.swan.apps.u.a.aga().getSwitch("swan_pms_proxy", false));
        }
        log("shouldIpcProxy: " + cdb);
        return cdb.booleanValue();
    }

    private void a(@NonNull String str, String str2, Map<String, String> map, Map<String, String> map2, JSONObject jSONObject, f.a aVar) {
        log("ipcHttp");
        String jSONObject2 = jSONObject == null ? "" : jSONObject.toString();
        final a aVar2 = new a(aVar);
        com.baidu.swan.apps.process.b.b bu = com.baidu.swan.apps.process.b.c.nc("pms_http_with_ipc").bu("pms_http_with_ipc_key_action", str);
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        com.baidu.swan.apps.process.b.b bu2 = bu.bu("pms_http_with_ipc_key_url", str2);
        if (TextUtils.isEmpty(jSONObject2)) {
            jSONObject2 = "";
        }
        com.baidu.swan.apps.process.b.b l = bu2.bu("pms_http_with_ipc_keyjson_body", jSONObject2).e("pms_http_with_ipc_key_url_param_map", p(map)).e("pms_http_with_ipc_key_header_param_map", p(map2)).eL(true).m(aVar2).l(new com.baidu.swan.apps.aq.e.b<com.baidu.swan.apps.process.b.b>() { // from class: com.baidu.swan.apps.core.pms.b.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.aq.e.b
            /* renamed from: a */
            public void H(com.baidu.swan.apps.process.b.b bVar) {
                aVar2.onFail(bVar.getException());
            }
        });
        D("ipcHttp", "session=" + l);
        l.bi(cdi);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a implements com.baidu.swan.apps.aq.e.b<i.a>, f.a {
        final f.a cde;
        final boolean cdf;
        boolean finished = false;

        public a(f.a aVar) {
            this.cde = aVar;
            this.cdf = aVar != null;
            b.this.D("IpcHttpCallbackWrapper", "wrappedCallback=" + aVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.aq.e.b
        /* renamed from: b */
        public void H(i.a aVar) {
            JSONObject jSONObject;
            synchronized (this) {
                b.this.D("IpcHttpCallbackWrapper#onCallback", "msg=" + aVar);
                if (valid()) {
                    String string = aVar.getString("pms_http_with_ipc_key_action", "");
                    char c = 65535;
                    switch (string.hashCode()) {
                        case -2080875416:
                            if (string.equals("pms_http_with_ipc_action_success")) {
                                c = 1;
                                break;
                            }
                            break;
                        case -898655015:
                            if (string.equals("pms_http_with_ipc_action_fail")) {
                                c = 2;
                                break;
                            }
                            break;
                        case 1737801345:
                            if (string.equals("pms_http_with_ipc_action_stat_record")) {
                                c = 0;
                                break;
                            }
                            break;
                    }
                    switch (c) {
                        case 0:
                            try {
                                jSONObject = new JSONObject(aVar.getString("pms_http_with_ipc_key_stat_record"));
                            } catch (JSONException e) {
                                if (b.DEBUG) {
                                    e.printStackTrace();
                                }
                                jSONObject = null;
                            }
                            String string2 = aVar.getString("pms_http_with_ipc_key_url");
                            String string3 = aVar.getString("pms_http_with_ipc_key_response");
                            if (jSONObject == null) {
                                jSONObject = new JSONObject();
                            }
                            b(string2, string3, jSONObject);
                            break;
                        case 1:
                            onSuccess(aVar.getString("pms_http_with_ipc_key_response"), aVar.getInt("pms_http_with_ipc_key_status_code"));
                            break;
                        case 2:
                            onFail(new Exception(aVar.getString("pms_http_with_ipc_key_error")));
                            break;
                    }
                }
            }
        }

        @Override // com.baidu.swan.pms.c.f.a
        public void b(String str, String str2, JSONObject jSONObject) {
            synchronized (this) {
                b.this.D("IpcHttpCallbackWrapper#onStatRecord", "url=" + str + " statRecord=" + jSONObject);
                if (valid()) {
                    this.cde.b(str, str2, jSONObject);
                }
            }
        }

        @Override // com.baidu.swan.pms.c.f.a
        public void onSuccess(String str, int i) {
            synchronized (this) {
                b.this.D("IpcHttpCallbackWrapper#onSuccess", "statusCode=" + i + " response=" + str);
                if (valid()) {
                    finish();
                    this.cde.onSuccess(str, i);
                }
            }
        }

        @Override // com.baidu.swan.pms.c.f.a
        public void onFail(Exception exc) {
            synchronized (this) {
                b.this.D("IpcHttpCallbackWrapper#onCallback", "exception=" + exc);
                if (valid()) {
                    finish();
                    f.a aVar = this.cde;
                    if (exc == null) {
                        exc = new Exception("onFail");
                    }
                    aVar.onFail(exc);
                }
            }
        }

        synchronized void finish() {
            this.finished = true;
        }

        synchronized boolean valid() {
            boolean z;
            if (this.cdf) {
                z = this.finished ? false : true;
            }
            return z;
        }
    }

    private void log(String str) {
        if (DEBUG) {
            Log.i("PmsHttpForClient", str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(String str, String str2) {
        log(str + ": " + str2);
    }
}

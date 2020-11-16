package com.baidu.swan.apps.core.pms.b;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.ap.v;
import com.baidu.swan.apps.runtime.i;
import com.baidu.swan.apps.runtime.j;
import com.baidu.swan.pms.c.f;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class b extends com.baidu.swan.apps.core.pms.b.a implements f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public b(j jVar) {
        super(jVar);
    }

    @Override // com.baidu.swan.apps.core.pms.b.a, com.baidu.swan.pms.c.f
    public void a(String str, Map<String, String> map, Map<String, String> map2, f.a aVar) {
        if (DEBUG) {
            log("buildGetRequest");
        }
        a("pms_http_with_ipc_action_build_get_request", str, map, map2, null, aVar);
    }

    @Override // com.baidu.swan.apps.core.pms.b.a, com.baidu.swan.pms.c.f
    public void a(String str, Map<String, String> map, Map<String, String> map2, JSONObject jSONObject, f.a aVar) {
        if (DEBUG) {
            log("buildJsonPostRequest");
        }
        a("pms_http_with_ipc_action_build_json_post_request", str, map, map2, jSONObject, aVar);
    }

    private void a(@NonNull String str, String str2, Map<String, String> map, Map<String, String> map2, JSONObject jSONObject, f.a aVar) {
        if (DEBUG) {
            log("ipcHttp");
        }
        String jSONObject2 = jSONObject == null ? "" : jSONObject.toString();
        final a aVar2 = new a(aVar);
        com.baidu.swan.apps.process.b.b bU = com.baidu.swan.apps.process.b.c.ro("pms_http_with_ipc").bU("pms_http_with_ipc_key_action", str);
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        com.baidu.swan.apps.process.b.b bU2 = bU.bU("pms_http_with_ipc_key_url", str2);
        if (TextUtils.isEmpty(jSONObject2)) {
            jSONObject2 = "";
        }
        com.baidu.swan.apps.process.b.b t = bU2.bU("pms_http_with_ipc_keyjson_body", jSONObject2).d("pms_http_with_ipc_key_url_param_map", z(map)).d("pms_http_with_ipc_key_header_param_map", z(map2)).gh(true).u(aVar2).t(new com.baidu.swan.apps.ap.e.b<com.baidu.swan.apps.process.b.b>() { // from class: com.baidu.swan.apps.core.pms.b.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.b
            /* renamed from: a */
            public void M(com.baidu.swan.apps.process.b.b bVar) {
                aVar2.onFail(bVar.getException());
            }
        });
        if (DEBUG) {
            D("ipcHttp", "session=" + t);
        }
        t.ch(cMh);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class a implements com.baidu.swan.apps.ap.e.b<i.a>, f.a {
        final f.a cMc;
        final boolean cMd;
        boolean finished = false;

        public a(f.a aVar) {
            this.cMc = aVar;
            this.cMd = aVar != null;
            if (b.DEBUG) {
                b.this.D("IpcHttpCallbackWrapper", "wrappedCallback=" + aVar);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.ap.e.b
        /* renamed from: b */
        public void M(i.a aVar) {
            synchronized (this) {
                boolean valid = valid();
                if (b.DEBUG) {
                    b.this.D("IpcHttpCallbackWrapper#onCallback", "valid=" + valid + " msg=" + aVar);
                }
                if (valid) {
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
                            b(aVar.getString("pms_http_with_ipc_key_url"), aVar.getString("pms_http_with_ipc_key_response"), v.parseString(aVar.getString("pms_http_with_ipc_key_stat_record")));
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
                boolean valid = valid();
                if (b.DEBUG) {
                    b.this.D("IpcHttpCallbackWrapper#onStatRecord", "valid=" + valid + " url=" + str + " statRecord=" + jSONObject);
                }
                if (valid) {
                    this.cMc.b(str, str2, jSONObject);
                }
            }
        }

        @Override // com.baidu.swan.pms.c.f.a
        public void onSuccess(String str, int i) {
            synchronized (this) {
                boolean valid = valid();
                if (b.DEBUG) {
                    b.this.D("IpcHttpCallbackWrapper#onSuccess", "valid=" + valid + " statusCode=" + i + " response=" + str);
                }
                if (valid) {
                    finish();
                    this.cMc.onSuccess(str, i);
                }
            }
        }

        @Override // com.baidu.swan.pms.c.f.a
        public void onFail(Exception exc) {
            synchronized (this) {
                boolean valid = valid();
                if (b.DEBUG) {
                    b.this.D("IpcHttpCallbackWrapper#onFail", "valid=" + valid + " exception=" + exc);
                }
                if (valid) {
                    finish();
                    f.a aVar = this.cMc;
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
            if (this.cMd) {
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

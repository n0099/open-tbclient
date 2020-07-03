package com.baidu.swan.apps.core.pms.b;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.runtime.i;
import com.baidu.swan.apps.runtime.l;
import com.baidu.swan.apps.v.b.a.c;
import com.baidu.swan.pms.c.f;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public final class c extends com.baidu.swan.apps.core.pms.b.a implements com.baidu.swan.apps.aq.e.b<i.a>, f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public interface a {
        void b(String str, Map<String, String> map, Map<String, String> map2, JSONObject jSONObject, f.a aVar);
    }

    public c(l lVar) {
        super(lVar);
        n(new com.baidu.swan.apps.runtime.b().a(this, "event_messenger_call"));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.aq.e.b
    /* renamed from: b */
    public void H(i.a aVar) {
        d(aVar);
    }

    private void d(i.a aVar) {
        D("handleIpcMsg", "msg=" + aVar);
        if (aVar != null && com.baidu.swan.apps.process.b.c.c(aVar.toBundle(), "pms_http_with_ipc")) {
            String string = aVar.getString("ipc_session_id");
            D("handleIpcMsg", "session=" + string);
            if (!TextUtils.isEmpty(string)) {
                String string2 = aVar.getString("pms_http_with_ipc_key_action");
                D("handleIpcMsg", "action=" + string2);
                if (TextUtils.isEmpty(string2)) {
                    bd(string, "empty action");
                    return;
                }
                char c = 65535;
                switch (string2.hashCode()) {
                    case 646251642:
                        if (string2.equals("pms_http_with_ipc_action_build_get_request")) {
                            c = 0;
                            break;
                        }
                        break;
                    case 1779116731:
                        if (string2.equals("pms_http_with_ipc_action_build_json_post_request")) {
                            c = 1;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        a(string, aVar, new a() { // from class: com.baidu.swan.apps.core.pms.b.c.1
                            @Override // com.baidu.swan.apps.core.pms.b.c.a
                            public void b(String str, Map<String, String> map, Map<String, String> map2, JSONObject jSONObject, f.a aVar2) {
                                c.this.a(str, map, map2, aVar2);
                            }
                        });
                        return;
                    case 1:
                        a(string, aVar, new a() { // from class: com.baidu.swan.apps.core.pms.b.c.2
                            @Override // com.baidu.swan.apps.core.pms.b.c.a
                            public void b(String str, Map<String, String> map, Map<String, String> map2, JSONObject jSONObject, f.a aVar2) {
                                c.this.a(str, map, map2, jSONObject, aVar2);
                            }
                        });
                        return;
                    default:
                        bd(string, "no such action:" + string2);
                        return;
                }
            }
        }
    }

    private void a(final String str, @NonNull i.a aVar, @NonNull a aVar2) {
        JSONObject jSONObject;
        D("buildRequestForIpc", "session=" + str + " msg=" + aVar + " adapter=" + aVar2);
        if (com.baidu.swan.apps.process.b.c.bL(str, "pms_http_with_ipc")) {
            String string = aVar.getString("pms_http_with_ipc_key_url");
            Map<String, String> r = r(aVar.lq("pms_http_with_ipc_key_url_param_map"));
            Map<String, String> r2 = r(aVar.lq("pms_http_with_ipc_key_header_param_map"));
            String string2 = aVar.getString("pms_http_with_ipc_keyjson_body");
            try {
                jSONObject = TextUtils.isEmpty(string2) ? null : new JSONObject(string2);
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
                jSONObject = null;
            }
            try {
                aVar2.b(string, r, r2, jSONObject, new f.a() { // from class: com.baidu.swan.apps.core.pms.b.c.3
                    @Override // com.baidu.swan.pms.c.f.a
                    public void b(String str2, String str3, JSONObject jSONObject2) {
                        c.this.a(str, "pms_http_with_ipc_action_stat_record", new c.a().bu("pms_http_with_ipc_key_url", str2).bu("pms_http_with_ipc_key_response", str3).bu("pms_http_with_ipc_key_stat_record", jSONObject2.toString()));
                    }

                    @Override // com.baidu.swan.pms.c.f.a
                    public void onSuccess(String str2, int i) {
                        c.this.a(str, "pms_http_with_ipc_action_success", new c.a().bu("pms_http_with_ipc_key_response", str2).M("pms_http_with_ipc_key_status_code", i));
                    }

                    @Override // com.baidu.swan.pms.c.f.a
                    public void onFail(Exception exc) {
                        c.this.bd(str, "http: " + exc);
                        if (c.DEBUG) {
                            exc.printStackTrace();
                        }
                    }
                });
            } catch (Exception e2) {
                bd(str, "catch: " + e2);
                if (DEBUG) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bd(String str, String str2) {
        a(str, "pms_http_with_ipc_action_fail", new c.a().bu("pms_http_with_ipc_key_error", str2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, c.a aVar) {
        D("callbackIpcSession", "session=" + str + " action=" + str2 + " msg=" + aVar);
        if (!TextUtils.isEmpty(str)) {
            if (!com.baidu.swan.apps.process.b.c.bL(str, "pms_http_with_ipc")) {
                D("callbackIpcSession", "return by topic pms_http_with_ipc");
                return;
            }
            com.baidu.swan.apps.process.b.b bu = com.baidu.swan.apps.process.b.c.nd(str).bu("pms_http_with_ipc_key_action", str2);
            if (aVar != null) {
                bu.I(aVar.toBundle());
            }
            D("callbackIpcSession", "ipcSession= " + bu);
            bu.anH();
        }
    }

    private void log(String str) {
        if (DEBUG) {
            Log.i("PmsHttpForService", str);
        }
    }

    private void D(String str, String str2) {
        log(str + ": " + str2);
    }
}

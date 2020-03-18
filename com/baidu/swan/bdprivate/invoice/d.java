package com.baidu.swan.bdprivate.invoice;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.http.request.PostFormRequest;
import com.baidu.swan.apps.as.s;
import com.baidu.swan.bdprivate.invoice.c;
import com.baidu.swan.bdprivate.invoice.model.InvoiceInfo;
import java.util.HashMap;
import java.util.Map;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class d {
    private static d cdL;

    public static d aiG() {
        if (cdL == null) {
            synchronized (d.class) {
                if (cdL == null) {
                    cdL = new d();
                }
            }
        }
        return cdL;
    }

    public void a(InvoiceInfo invoiceInfo, final c.a aVar) {
        if (invoiceInfo != null) {
            String Lf = com.baidu.swan.apps.h.c.Lf();
            HashMap hashMap = new HashMap();
            hashMap.put("data", invoiceInfo.toJson().toString());
            a(Lf, hashMap, new ResponseCallback<com.baidu.swan.bdprivate.invoice.model.d<InvoiceInfo>>() { // from class: com.baidu.swan.bdprivate.invoice.d.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.searchbox.http.callback.ResponseCallback
                /* renamed from: b */
                public com.baidu.swan.bdprivate.invoice.model.d<InvoiceInfo> parseResponse(Response response, int i) throws Exception {
                    com.baidu.swan.bdprivate.invoice.model.d<InvoiceInfo> dVar = new com.baidu.swan.bdprivate.invoice.model.d<>(new InvoiceInfo());
                    if (response != null && response.body() != null) {
                        dVar.bg(s.parseString(response.body().string()));
                    }
                    return dVar;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.searchbox.http.callback.ResponseCallback
                /* renamed from: a */
                public void onSuccess(com.baidu.swan.bdprivate.invoice.model.d<InvoiceInfo> dVar, int i) {
                    if (aVar != null) {
                        if (!TextUtils.equals(dVar.cdX, "0") || dVar.cdZ == null) {
                            d.this.a(dVar.cdX, dVar.cdY, aVar);
                        } else {
                            aVar.a(dVar.cdZ);
                        }
                    }
                }

                @Override // com.baidu.searchbox.http.callback.ResponseCallback
                public void onFail(Exception exc) {
                    if (aVar != null) {
                        aVar.bw("-1", exc.getMessage());
                    }
                }
            });
        }
    }

    public void a(Context context, final String str, final String str2, final c.InterfaceC0321c interfaceC0321c) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            if (interfaceC0321c != null) {
                interfaceC0321c.bw("-1", "");
                return;
            }
            return;
        }
        com.baidu.swan.bdprivate.a.a.a(context, new com.baidu.swan.apps.as.d.b<Bundle>() { // from class: com.baidu.swan.bdprivate.invoice.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.as.d.b
            /* renamed from: z */
            public void D(Bundle bundle) {
                if (bundle != null) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("ma_id", str);
                        jSONObject.put("app_key", str2);
                        jSONObject.put("host_pkgname", com.baidu.swan.apps.setting.oauth.c.getAppContext().getPackageName());
                        jSONObject.put("host_key_hash", com.baidu.swan.apps.setting.oauth.c.getKeyHash());
                        jSONObject.put("stoken", bundle.getString("dev", ""));
                        jSONObject.put("host_api_key", com.baidu.swan.apps.w.a.Ul().If());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put("data", jSONObject.toString());
                    d.this.a(com.baidu.swan.apps.h.c.Lh(), hashMap, interfaceC0321c);
                } else if (interfaceC0321c != null) {
                    interfaceC0321c.bw("-1", "");
                }
            }
        }, "dev");
    }

    public void a(c.InterfaceC0321c interfaceC0321c) {
        a(com.baidu.swan.apps.h.c.Lg(), (Map<String, String>) null, interfaceC0321c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, Map<String, String> map, final c.InterfaceC0321c interfaceC0321c) {
        a(str, map, new ResponseCallback<com.baidu.swan.bdprivate.invoice.model.d<com.baidu.swan.bdprivate.invoice.model.a>>() { // from class: com.baidu.swan.bdprivate.invoice.d.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            /* renamed from: b */
            public com.baidu.swan.bdprivate.invoice.model.d<com.baidu.swan.bdprivate.invoice.model.a> parseResponse(Response response, int i) throws Exception {
                com.baidu.swan.bdprivate.invoice.model.d<com.baidu.swan.bdprivate.invoice.model.a> dVar = new com.baidu.swan.bdprivate.invoice.model.d<>(new com.baidu.swan.bdprivate.invoice.model.a());
                if (response != null && response.body() != null) {
                    dVar.bg(s.parseString(response.body().string()));
                }
                return dVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            /* renamed from: a */
            public void onSuccess(com.baidu.swan.bdprivate.invoice.model.d<com.baidu.swan.bdprivate.invoice.model.a> dVar, int i) {
                if (interfaceC0321c != null) {
                    if (!TextUtils.equals(dVar.cdX, "0") || dVar.cdZ == null) {
                        d.this.a(dVar.cdX, dVar.cdY, interfaceC0321c);
                    } else {
                        interfaceC0321c.ai(dVar.cdZ.cdW);
                    }
                }
            }

            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public void onFail(Exception exc) {
                if (interfaceC0321c != null) {
                    interfaceC0321c.bw("-1", exc.getMessage());
                }
            }
        });
    }

    public void a(InvoiceInfo invoiceInfo, final c.e eVar) {
        String Li = com.baidu.swan.apps.h.c.Li();
        HashMap hashMap = new HashMap();
        hashMap.put("data", invoiceInfo.toJson().toString());
        a(Li, hashMap, new ResponseCallback<com.baidu.swan.bdprivate.invoice.model.d<InvoiceInfo>>() { // from class: com.baidu.swan.bdprivate.invoice.d.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            /* renamed from: b */
            public com.baidu.swan.bdprivate.invoice.model.d<InvoiceInfo> parseResponse(Response response, int i) throws Exception {
                com.baidu.swan.bdprivate.invoice.model.d<InvoiceInfo> dVar = new com.baidu.swan.bdprivate.invoice.model.d<>(new InvoiceInfo());
                if (response != null && response.body() != null) {
                    dVar.bg(s.parseString(response.body().string()));
                }
                return dVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            /* renamed from: a */
            public void onSuccess(com.baidu.swan.bdprivate.invoice.model.d<InvoiceInfo> dVar, int i) {
                if (eVar != null) {
                    if (!TextUtils.equals(dVar.cdX, "0") || dVar.cdZ == null) {
                        d.this.a(dVar.cdX, dVar.cdY, eVar);
                    } else {
                        eVar.b(dVar.cdZ);
                    }
                }
            }

            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public void onFail(Exception exc) {
                if (eVar != null) {
                    eVar.bw("-1", exc.getMessage());
                }
            }
        });
    }

    public void a(final long j, final c.d dVar) {
        String Lj = com.baidu.swan.apps.h.c.Lj();
        com.baidu.swan.bdprivate.invoice.model.b bVar = new com.baidu.swan.bdprivate.invoice.model.b(j);
        HashMap hashMap = new HashMap();
        hashMap.put("data", bVar.toJson().toString());
        a(Lj, hashMap, new ResponseCallback<com.baidu.swan.bdprivate.invoice.model.d>() { // from class: com.baidu.swan.bdprivate.invoice.d.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            /* renamed from: b */
            public com.baidu.swan.bdprivate.invoice.model.d parseResponse(Response response, int i) throws Exception {
                com.baidu.swan.bdprivate.invoice.model.d dVar2 = new com.baidu.swan.bdprivate.invoice.model.d();
                if (response != null && response.body() != null) {
                    dVar2.bg(s.parseString(response.body().string()));
                }
                return dVar2;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            /* renamed from: a */
            public void onSuccess(com.baidu.swan.bdprivate.invoice.model.d dVar2, int i) {
                if (dVar != null) {
                    if (!TextUtils.equals(dVar2.cdX, "0")) {
                        d.this.a(dVar2.cdX, dVar2.cdY, dVar);
                    } else {
                        dVar.aN(j);
                    }
                }
            }

            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public void onFail(Exception exc) {
                if (dVar != null) {
                    dVar.bw("-1", exc.getMessage());
                }
            }
        });
    }

    public void a(long j, final c.b bVar) {
        String Lk = com.baidu.swan.apps.h.c.Lk();
        com.baidu.swan.bdprivate.invoice.model.b bVar2 = new com.baidu.swan.bdprivate.invoice.model.b(j);
        HashMap hashMap = new HashMap();
        hashMap.put("data", bVar2.toJson().toString());
        a(Lk, hashMap, new ResponseCallback<com.baidu.swan.bdprivate.invoice.model.d<com.baidu.swan.bdprivate.invoice.model.b>>() { // from class: com.baidu.swan.bdprivate.invoice.d.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            /* renamed from: b */
            public com.baidu.swan.bdprivate.invoice.model.d<com.baidu.swan.bdprivate.invoice.model.b> parseResponse(Response response, int i) throws Exception {
                com.baidu.swan.bdprivate.invoice.model.d<com.baidu.swan.bdprivate.invoice.model.b> dVar = new com.baidu.swan.bdprivate.invoice.model.d<>(new com.baidu.swan.bdprivate.invoice.model.b());
                if (response != null && response.body() != null) {
                    dVar.bg(s.parseString(response.body().string()));
                }
                return dVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            /* renamed from: a */
            public void onSuccess(com.baidu.swan.bdprivate.invoice.model.d<com.baidu.swan.bdprivate.invoice.model.b> dVar, int i) {
                if (bVar != null) {
                    if (!TextUtils.equals(dVar.cdX, "0") || dVar.cdZ == null) {
                        d.this.a(dVar.cdX, dVar.cdY, bVar);
                    } else {
                        bVar.aM(dVar.cdZ.mId);
                    }
                }
            }

            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public void onFail(Exception exc) {
                if (bVar != null) {
                    bVar.bw("-1", exc.getMessage());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, c cVar) {
        if (cVar != null) {
            if (TextUtils.equals(str, TbEnum.SystemMessage.EVENT_ID_APPLY_FRIEND)) {
                cVar.nl(str2);
            } else {
                cVar.bw(str, str2);
            }
        }
    }

    private void a(String str, Map<String, String> map, ResponseCallback responseCallback) {
        if (!TextUtils.isEmpty(str)) {
            PostFormRequest.PostFormRequestBuilder postFormRequestBuilder = (PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) HttpManager.getDefault(AppRuntime.getAppContext()).postFormRequest().url(com.baidu.swan.apps.h.c.processCommonParams(str))).cookieManager(com.baidu.swan.apps.w.a.Ux().Ix());
            if (map != null) {
                postFormRequestBuilder.params(map);
            }
            postFormRequestBuilder.build().executeAsyncOnUIBack(responseCallback);
        }
    }
}

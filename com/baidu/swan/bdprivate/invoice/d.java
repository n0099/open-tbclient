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
/* loaded from: classes10.dex */
public class d {
    private static d bZs;

    public static d agn() {
        if (bZs == null) {
            synchronized (d.class) {
                if (bZs == null) {
                    bZs = new d();
                }
            }
        }
        return bZs;
    }

    public void a(InvoiceInfo invoiceInfo, final c.a aVar) {
        if (invoiceInfo != null) {
            String IL = com.baidu.swan.apps.h.c.IL();
            HashMap hashMap = new HashMap();
            hashMap.put("data", invoiceInfo.toJson().toString());
            a(IL, hashMap, new ResponseCallback<com.baidu.swan.bdprivate.invoice.model.d<InvoiceInfo>>() { // from class: com.baidu.swan.bdprivate.invoice.d.1
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
                        if (!TextUtils.equals(dVar.bZE, "0") || dVar.bZG == null) {
                            d.this.a(dVar.bZE, dVar.bZF, aVar);
                        } else {
                            aVar.a(dVar.bZG);
                        }
                    }
                }

                @Override // com.baidu.searchbox.http.callback.ResponseCallback
                public void onFail(Exception exc) {
                    if (aVar != null) {
                        aVar.bo("-1", exc.getMessage());
                    }
                }
            });
        }
    }

    public void a(Context context, final String str, final String str2, final c.InterfaceC0311c interfaceC0311c) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            if (interfaceC0311c != null) {
                interfaceC0311c.bo("-1", "");
                return;
            }
            return;
        }
        com.baidu.swan.bdprivate.a.a.a(context, new com.baidu.swan.apps.as.d.b<Bundle>() { // from class: com.baidu.swan.bdprivate.invoice.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.as.d.b
            /* renamed from: z */
            public void B(Bundle bundle) {
                if (bundle != null) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("ma_id", str);
                        jSONObject.put("app_key", str2);
                        jSONObject.put("host_pkgname", com.baidu.swan.apps.setting.oauth.c.getAppContext().getPackageName());
                        jSONObject.put("host_key_hash", com.baidu.swan.apps.setting.oauth.c.getKeyHash());
                        jSONObject.put("stoken", bundle.getString("dev", ""));
                        jSONObject.put("host_api_key", com.baidu.swan.apps.w.a.RS().FL());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put("data", jSONObject.toString());
                    d.this.a(com.baidu.swan.apps.h.c.IN(), hashMap, interfaceC0311c);
                } else if (interfaceC0311c != null) {
                    interfaceC0311c.bo("-1", "");
                }
            }
        }, "dev");
    }

    public void a(c.InterfaceC0311c interfaceC0311c) {
        a(com.baidu.swan.apps.h.c.IM(), (Map<String, String>) null, interfaceC0311c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, Map<String, String> map, final c.InterfaceC0311c interfaceC0311c) {
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
                if (interfaceC0311c != null) {
                    if (!TextUtils.equals(dVar.bZE, "0") || dVar.bZG == null) {
                        d.this.a(dVar.bZE, dVar.bZF, interfaceC0311c);
                    } else {
                        interfaceC0311c.ai(dVar.bZG.bZD);
                    }
                }
            }

            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public void onFail(Exception exc) {
                if (interfaceC0311c != null) {
                    interfaceC0311c.bo("-1", exc.getMessage());
                }
            }
        });
    }

    public void a(InvoiceInfo invoiceInfo, final c.e eVar) {
        String IO = com.baidu.swan.apps.h.c.IO();
        HashMap hashMap = new HashMap();
        hashMap.put("data", invoiceInfo.toJson().toString());
        a(IO, hashMap, new ResponseCallback<com.baidu.swan.bdprivate.invoice.model.d<InvoiceInfo>>() { // from class: com.baidu.swan.bdprivate.invoice.d.4
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
                    if (!TextUtils.equals(dVar.bZE, "0") || dVar.bZG == null) {
                        d.this.a(dVar.bZE, dVar.bZF, eVar);
                    } else {
                        eVar.b(dVar.bZG);
                    }
                }
            }

            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public void onFail(Exception exc) {
                if (eVar != null) {
                    eVar.bo("-1", exc.getMessage());
                }
            }
        });
    }

    public void a(final long j, final c.d dVar) {
        String IP = com.baidu.swan.apps.h.c.IP();
        com.baidu.swan.bdprivate.invoice.model.b bVar = new com.baidu.swan.bdprivate.invoice.model.b(j);
        HashMap hashMap = new HashMap();
        hashMap.put("data", bVar.toJson().toString());
        a(IP, hashMap, new ResponseCallback<com.baidu.swan.bdprivate.invoice.model.d>() { // from class: com.baidu.swan.bdprivate.invoice.d.5
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
                    if (!TextUtils.equals(dVar2.bZE, "0")) {
                        d.this.a(dVar2.bZE, dVar2.bZF, dVar);
                    } else {
                        dVar.aJ(j);
                    }
                }
            }

            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public void onFail(Exception exc) {
                if (dVar != null) {
                    dVar.bo("-1", exc.getMessage());
                }
            }
        });
    }

    public void a(long j, final c.b bVar) {
        String IQ = com.baidu.swan.apps.h.c.IQ();
        com.baidu.swan.bdprivate.invoice.model.b bVar2 = new com.baidu.swan.bdprivate.invoice.model.b(j);
        HashMap hashMap = new HashMap();
        hashMap.put("data", bVar2.toJson().toString());
        a(IQ, hashMap, new ResponseCallback<com.baidu.swan.bdprivate.invoice.model.d<com.baidu.swan.bdprivate.invoice.model.b>>() { // from class: com.baidu.swan.bdprivate.invoice.d.6
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
                    if (!TextUtils.equals(dVar.bZE, "0") || dVar.bZG == null) {
                        d.this.a(dVar.bZE, dVar.bZF, bVar);
                    } else {
                        bVar.aI(dVar.bZG.mId);
                    }
                }
            }

            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public void onFail(Exception exc) {
                if (bVar != null) {
                    bVar.bo("-1", exc.getMessage());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, c cVar) {
        if (cVar != null) {
            if (TextUtils.equals(str, TbEnum.SystemMessage.EVENT_ID_APPLY_FRIEND)) {
                cVar.mX(str2);
            } else {
                cVar.bo(str, str2);
            }
        }
    }

    private void a(String str, Map<String, String> map, ResponseCallback responseCallback) {
        if (!TextUtils.isEmpty(str)) {
            PostFormRequest.PostFormRequestBuilder postFormRequestBuilder = (PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) HttpManager.getDefault(AppRuntime.getAppContext()).postFormRequest().url(com.baidu.swan.apps.h.c.processCommonParams(str))).cookieManager(com.baidu.swan.apps.w.a.Se().Gd());
            if (map != null) {
                postFormRequestBuilder.params(map);
            }
            postFormRequestBuilder.build().executeAsyncOnUIBack(responseCallback);
        }
    }
}

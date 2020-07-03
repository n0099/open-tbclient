package com.baidu.swan.apps.scheme.actions;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.searchbox.websocket.WebSocketRequest;
import com.baidu.swan.apps.aq.aj;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.network.a.a;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicLong;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class g extends com.baidu.swan.apps.network.a implements com.baidu.swan.apps.network.f {
    private static AtomicLong cGt = new AtomicLong(System.currentTimeMillis());
    private int cGu;

    public g(com.baidu.swan.apps.scheme.j jVar) {
        super(jVar, "/swanAPI/downloadFile");
        this.cGu = 0;
    }

    @Override // com.baidu.swan.apps.network.a, com.baidu.swan.apps.scheme.actions.aa
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        if (eVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "swanApp is null");
            return false;
        }
        JSONObject b = b(unitedSchemeEntity, "params");
        if (b == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal params");
            return false;
        }
        final String optString = b.optString("onProgressUpdate");
        final String optString2 = b.optString("cb");
        if (TextUtils.isEmpty(optString2)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal resultCallback");
            return false;
        }
        final String optString3 = b.optString("filePath");
        if (!TextUtils.isEmpty(optString3) && com.baidu.swan.e.d.uh(optString3)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal path");
            return false;
        }
        String apO = com.baidu.swan.apps.runtime.e.apO();
        if (TextUtils.isEmpty(apO)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal appId");
            return false;
        }
        final String hT = com.baidu.swan.apps.api.module.network.c.hT(apO);
        Request v = v(b, hT);
        if (v == null) {
            unitedSchemeEntity.result = gl(this.cGu);
            return false;
        }
        final String httpUrl = v.url().toString();
        final String fileExtensionFromUrl = getFileExtensionFromUrl(httpUrl);
        JSONObject optJSONObject = b.optJSONObject(WebSocketRequest.PARAM_KEY_HEADER);
        com.baidu.swan.apps.network.a.b bVar = new com.baidu.swan.apps.network.a.b();
        HashMap<String, String> c = c(optJSONObject, true);
        String optString4 = b.optString("__plugin__");
        if (!TextUtils.isEmpty(optString4)) {
            com.baidu.swan.pms.model.h mX = com.baidu.swan.apps.ae.g.b.mX(optString4);
            if (c == null) {
                c = new HashMap<>();
            }
            c.put("X-SWAN-HOSTSIGN", com.baidu.swan.apps.ae.g.a.e(mX));
        }
        bVar.B(c);
        com.baidu.swan.apps.w.f.ajb().aji();
        final String valueOf = String.valueOf(System.currentTimeMillis());
        this.cuC.put(valueOf, 0L);
        com.baidu.swan.apps.network.a.a aVar = new com.baidu.swan.apps.network.a.a();
        aVar.a(new a.InterfaceC0366a() { // from class: com.baidu.swan.apps.scheme.actions.g.1
            @Override // com.baidu.swan.apps.network.a.a.InterfaceC0366a
            public void be(long j) {
                callbackHandler.handleSchemeDispatchCallback(optString2, UnitedSchemeUtility.wrapCallbackParams(1001, "download file failed because file size exceeds limit").toString());
                SwanAppNetworkUtils.a(com.baidu.swan.c.c.a.aGD().getOkHttpClient(), hT);
                g.this.mo(valueOf);
            }

            @Override // com.baidu.swan.apps.network.a.a.InterfaceC0366a
            public void l(long j, long j2) {
                callbackHandler.handleSchemeDispatchCallback(optString2, UnitedSchemeUtility.wrapCallbackParams(1001, "progress callback fail()").toString());
                SwanAppNetworkUtils.a(com.baidu.swan.c.c.a.aGD().getOkHttpClient(), hT);
                g.this.mo(valueOf);
            }

            @Override // com.baidu.swan.apps.network.a.a.InterfaceC0366a
            public void b(int i, long j, long j2) {
                if (System.currentTimeMillis() - g.this.mn(valueOf) > 500) {
                    if (i <= 100) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("progress", i);
                            jSONObject.put("totalBytesWritten", j);
                            jSONObject.put("totalBytesExpectedToWrite", j2);
                            callbackHandler.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParamsWithEncode(jSONObject, 0).toString());
                        } catch (Exception e) {
                            if (aa.DEBUG) {
                                e.printStackTrace();
                            }
                        }
                    }
                    g.this.cuC.put(valueOf, Long.valueOf(System.currentTimeMillis()));
                }
            }
        });
        final String asv = com.baidu.swan.apps.statistic.h.asv();
        final String page = aj.ava().getPage();
        com.baidu.swan.apps.statistic.h.S(httpUrl, 0);
        OkHttpClient.Builder aGE = com.baidu.swan.c.c.a.aGD().aGE();
        aGE.addNetworkInterceptor(new com.baidu.swan.apps.network.a.d());
        com.baidu.swan.c.c.a.aGD().a(aGE);
        aGE.addInterceptor(bVar).addNetworkInterceptor(aVar).build().newCall(com.baidu.swan.apps.network.a.c.a(v, "downloadFile", b.optString("__plugin__"))).enqueue(new Callback() { // from class: com.baidu.swan.apps.scheme.actions.g.2
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                com.baidu.swan.apps.w.f.ajb().ajj();
                callbackHandler.handleSchemeDispatchCallback(optString2, UnitedSchemeUtility.wrapCallbackParams(1001, iOException.getMessage()).toString());
                g.this.mo(valueOf);
                if (SwanAppNetworkUtils.isNetworkConnected(null)) {
                    com.baidu.swan.apps.statistic.h.a(0, httpUrl, 0, iOException.getMessage(), asv, page);
                }
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) {
                String oj;
                String str;
                if (!TextUtils.isEmpty(optString3)) {
                    oj = g.this.oj(optString3);
                } else {
                    oj = g.a(response, fileExtensionFromUrl);
                }
                if (TextUtils.isEmpty(oj)) {
                    callbackHandler.handleSchemeDispatchCallback(optString2, UnitedSchemeUtility.wrapCallbackParams(1001, "realFilePath create fail").toString());
                    return;
                }
                if (aa.DEBUG) {
                    Log.d("DownloadFileAction", "the real file path is " + oj);
                }
                if (TextUtils.isEmpty(optString3)) {
                    str = com.baidu.swan.apps.w.f.ajb().aiH().pk(oj);
                } else {
                    str = optString3;
                }
                if (TextUtils.isEmpty(str)) {
                    callbackHandler.handleSchemeDispatchCallback(optString2, UnitedSchemeUtility.wrapCallbackParams(1001, "parse tmpFilePath from realFilePath fail").toString());
                    return;
                }
                int code = response.code();
                String message = response.message();
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("statusCode", code);
                    jSONObject.put(TextUtils.isEmpty(optString3) ? "tempFilePath" : "filePath", str);
                    InputStream byteStream = response.body().byteStream();
                    File file = new File(oj);
                    if (file.exists()) {
                        file.delete();
                        file.createNewFile();
                    }
                    if (com.baidu.swan.e.g.streamToFile(byteStream, file)) {
                        callbackHandler.handleSchemeDispatchCallback(optString2, UnitedSchemeUtility.wrapCallbackParamsWithEncode(jSONObject, 0).toString());
                    } else {
                        callbackHandler.handleSchemeDispatchCallback(optString2, UnitedSchemeUtility.wrapCallbackParams(1001, "streamToFile fail").toString());
                    }
                } catch (Exception e) {
                    if (aa.DEBUG) {
                        e.printStackTrace();
                    }
                    callbackHandler.handleSchemeDispatchCallback(optString2, UnitedSchemeUtility.wrapCallbackParams(201, e.getMessage()).toString());
                } finally {
                    g.this.mo(valueOf);
                    com.baidu.swan.apps.w.f.ajb().ajj();
                }
                if (aa.DEBUG) {
                    Log.d("DownloadFileAction", "onResponse: respCode: " + code + ", url=" + httpUrl + ", msg=" + message);
                }
                com.baidu.swan.apps.statistic.h.a(code, httpUrl, 0, message, asv, page);
            }
        });
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(hV(hT), 0));
        return true;
    }

    @Nullable
    private Request v(@Nullable JSONObject jSONObject, @Nullable String str) {
        HttpUrl hU;
        if (jSONObject == null || TextUtils.isEmpty(str) || (hU = com.baidu.swan.apps.api.module.network.c.hU(jSONObject.optString("url"))) == null) {
            return null;
        }
        String httpUrl = hU.toString();
        if (TextUtils.isEmpty(httpUrl)) {
            return null;
        }
        this.cGu = com.baidu.swan.apps.ah.a.b.H("downloadFile", httpUrl, jSONObject.optString("__plugin__"));
        if (this.cGu == 0) {
            return new Request.Builder().url(httpUrl).tag(str).build();
        }
        return null;
    }

    @Nullable
    public static String a(Response response, String str) {
        int lastIndexOf;
        String header = response.header("Content-Disposition", null);
        if (!TextUtils.isEmpty(header)) {
            String pN = com.baidu.swan.apps.aq.p.pN(header);
            if (!TextUtils.isEmpty(pN) && (lastIndexOf = pN.lastIndexOf(".") + 1) > 0) {
                str = pN.substring(lastIndexOf);
            }
        } else {
            String header2 = response.header("Content-Type", null);
            if (!TextUtils.isEmpty(header2)) {
                String[] split = header2.split(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
                int length = split.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    String pL = com.baidu.swan.apps.aq.p.pL(split[i]);
                    if (!TextUtils.isEmpty(pL)) {
                        str = pL;
                        break;
                    }
                    i++;
                }
            }
        }
        return com.baidu.swan.apps.w.f.ajb().aiH().pl(cGt.getAndIncrement() + (TextUtils.isEmpty(str) ? "" : "." + str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public String oj(@NonNull String str) {
        File parentFile;
        String pi = com.baidu.swan.apps.w.f.ajb().aiH().pi(str);
        if (pi == null || pi.endsWith(File.separator) || (parentFile = new File(pi).getParentFile()) == null || !parentFile.exists()) {
            return null;
        }
        return pi;
    }

    private String getFileExtensionFromUrl(String str) {
        Uri parse;
        if (TextUtils.isEmpty(str) || (parse = Uri.parse(str)) == null) {
            return null;
        }
        return com.baidu.swan.e.d.ug(parse.getPath());
    }
}

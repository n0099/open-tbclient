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
import com.baidu.swan.apps.aq.al;
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
/* loaded from: classes7.dex */
public class g extends com.baidu.swan.apps.network.a implements com.baidu.swan.apps.network.f {
    private static AtomicLong cJl = new AtomicLong(System.currentTimeMillis());
    private int cJm;

    public g(com.baidu.swan.apps.scheme.j jVar) {
        super(jVar, "/swanAPI/downloadFile");
        this.cJm = 0;
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
        final String optString2 = b.optString("headersReceivedEvent");
        final String optString3 = b.optString("cb");
        if (TextUtils.isEmpty(optString3)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal resultCallback");
            return false;
        }
        final String optString4 = b.optString("filePath");
        if (!TextUtils.isEmpty(optString4) && com.baidu.swan.d.d.vk(optString4)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal path");
            return false;
        }
        String arx = com.baidu.swan.apps.runtime.e.arx();
        if (TextUtils.isEmpty(arx)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal appId");
            return false;
        }
        final String id = com.baidu.swan.apps.api.module.network.c.id(arx);
        Request w = w(b, id);
        if (w == null) {
            unitedSchemeEntity.result = gv(this.cJm);
            return false;
        }
        final String httpUrl = w.url().toString();
        final String fileExtensionFromUrl = getFileExtensionFromUrl(httpUrl);
        JSONObject optJSONObject = b.optJSONObject(WebSocketRequest.PARAM_KEY_HEADER);
        com.baidu.swan.apps.network.a.b bVar = new com.baidu.swan.apps.network.a.b();
        HashMap<String, String> c = c(optJSONObject, true);
        String optString5 = b.optString("__plugin__");
        if (!TextUtils.isEmpty(optString5)) {
            com.baidu.swan.pms.model.h nE = com.baidu.swan.apps.ad.g.b.nE(optString5);
            if (c == null) {
                c = new HashMap<>();
            }
            c.put("X-SWAN-HOSTSIGN", com.baidu.swan.apps.ad.g.a.e(nE));
        }
        bVar.A(c);
        com.baidu.swan.apps.v.f.akr().aky();
        final String valueOf = String.valueOf(System.currentTimeMillis());
        this.cwD.put(valueOf, 0L);
        com.baidu.swan.apps.network.a.a aVar = new com.baidu.swan.apps.network.a.a();
        aVar.a(new a.InterfaceC0368a() { // from class: com.baidu.swan.apps.scheme.actions.g.1
            @Override // com.baidu.swan.apps.network.a.a.InterfaceC0368a
            public void bi(long j) {
                callbackHandler.handleSchemeDispatchCallback(optString3, UnitedSchemeUtility.wrapCallbackParams(1001, "download file failed because file size exceeds limit").toString());
                SwanAppNetworkUtils.a(com.baidu.swan.b.c.a.aKu().getOkHttpClient(), id);
                g.this.mM(valueOf);
            }

            @Override // com.baidu.swan.apps.network.a.a.InterfaceC0368a
            public void l(long j, long j2) {
                callbackHandler.handleSchemeDispatchCallback(optString3, UnitedSchemeUtility.wrapCallbackParams(1001, "progress callback fail()").toString());
                SwanAppNetworkUtils.a(com.baidu.swan.b.c.a.aKu().getOkHttpClient(), id);
                g.this.mM(valueOf);
            }

            @Override // com.baidu.swan.apps.network.a.a.InterfaceC0368a
            public void b(int i, long j, long j2) {
                if (System.currentTimeMillis() - g.this.mL(valueOf) > 500) {
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
                    g.this.cwD.put(valueOf, Long.valueOf(System.currentTimeMillis()));
                }
            }
        });
        final String aut = com.baidu.swan.apps.statistic.h.aut();
        final String page = al.axg().getPage();
        com.baidu.swan.apps.statistic.h.S(httpUrl, 0);
        OkHttpClient.Builder aKv = com.baidu.swan.b.c.a.aKu().aKv();
        aKv.addNetworkInterceptor(new com.baidu.swan.apps.network.a.d());
        com.baidu.swan.b.c.a.aKu().a(aKv);
        aKv.addInterceptor(bVar).addNetworkInterceptor(aVar).build().newCall(com.baidu.swan.apps.network.a.c.a(w, "downloadFile", b.optString("__plugin__"))).enqueue(new Callback() { // from class: com.baidu.swan.apps.scheme.actions.g.2
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                com.baidu.swan.apps.v.f.akr().akz();
                callbackHandler.handleSchemeDispatchCallback(optString3, UnitedSchemeUtility.wrapCallbackParams(1001, iOException.getMessage()).toString());
                g.this.mM(valueOf);
                if (SwanAppNetworkUtils.isNetworkConnected(null)) {
                    com.baidu.swan.apps.statistic.h.a(0, httpUrl, 0, iOException.getMessage(), aut, page);
                }
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) {
                String oP;
                String str;
                if (!TextUtils.isEmpty(optString4)) {
                    oP = g.this.oP(optString4);
                } else {
                    oP = g.a(response, fileExtensionFromUrl);
                }
                if (TextUtils.isEmpty(oP)) {
                    callbackHandler.handleSchemeDispatchCallback(optString3, UnitedSchemeUtility.wrapCallbackParams(1001, "realFilePath create fail").toString());
                    return;
                }
                if (aa.DEBUG) {
                    Log.d("DownloadFileAction", "the real file path is " + oP);
                }
                g.this.a(optString2, response.headers());
                if (TextUtils.isEmpty(optString4)) {
                    str = com.baidu.swan.apps.v.f.akr().ajX().pV(oP);
                } else {
                    str = optString4;
                }
                if (TextUtils.isEmpty(str)) {
                    callbackHandler.handleSchemeDispatchCallback(optString3, UnitedSchemeUtility.wrapCallbackParams(1001, "parse tmpFilePath from realFilePath fail").toString());
                    return;
                }
                int code = response.code();
                String message = response.message();
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("statusCode", code);
                    jSONObject.put(TextUtils.isEmpty(optString4) ? "tempFilePath" : "filePath", str);
                    InputStream byteStream = response.body().byteStream();
                    File file = new File(oP);
                    if (file.exists()) {
                        file.delete();
                        file.createNewFile();
                    }
                    if (com.baidu.swan.d.f.streamToFile(byteStream, file)) {
                        callbackHandler.handleSchemeDispatchCallback(optString3, UnitedSchemeUtility.wrapCallbackParamsWithEncode(jSONObject, 0).toString());
                    } else {
                        callbackHandler.handleSchemeDispatchCallback(optString3, UnitedSchemeUtility.wrapCallbackParams(1001, "streamToFile fail").toString());
                    }
                } catch (Exception e) {
                    if (aa.DEBUG) {
                        e.printStackTrace();
                    }
                    callbackHandler.handleSchemeDispatchCallback(optString3, UnitedSchemeUtility.wrapCallbackParams(201, e.getMessage()).toString());
                } finally {
                    g.this.mM(valueOf);
                    com.baidu.swan.apps.v.f.akr().akz();
                }
                if (aa.DEBUG) {
                    Log.d("DownloadFileAction", "onResponse: respCode: " + code + ", url=" + httpUrl + ", msg=" + message);
                }
                com.baidu.swan.apps.statistic.h.a(code, httpUrl, 0, message, aut, page);
            }
        });
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(m28if(id), 0));
        return true;
    }

    @Nullable
    private Request w(@Nullable JSONObject jSONObject, @Nullable String str) {
        HttpUrl ie;
        if (jSONObject == null || TextUtils.isEmpty(str) || (ie = com.baidu.swan.apps.api.module.network.c.ie(jSONObject.optString("url"))) == null) {
            return null;
        }
        String httpUrl = ie.toString();
        if (TextUtils.isEmpty(httpUrl)) {
            return null;
        }
        this.cJm = com.baidu.swan.apps.ah.a.b.H("downloadFile", httpUrl, jSONObject.optString("__plugin__"));
        if (this.cJm == 0) {
            return new Request.Builder().url(httpUrl).tag(str).build();
        }
        return null;
    }

    @Nullable
    public static String a(Response response, String str) {
        int lastIndexOf;
        String header = response.header("Content-Disposition", null);
        if (!TextUtils.isEmpty(header)) {
            String qy = com.baidu.swan.apps.aq.r.qy(header);
            if (!TextUtils.isEmpty(qy) && (lastIndexOf = qy.lastIndexOf(".") + 1) > 0) {
                str = qy.substring(lastIndexOf);
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
                    String qw = com.baidu.swan.apps.aq.r.qw(split[i]);
                    if (!TextUtils.isEmpty(qw)) {
                        str = qw;
                        break;
                    }
                    i++;
                }
            }
        }
        return com.baidu.swan.apps.v.f.akr().ajX().pW(cJl.getAndIncrement() + (TextUtils.isEmpty(str) ? "" : "." + str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public String oP(@NonNull String str) {
        File parentFile;
        String pT = com.baidu.swan.apps.v.f.akr().ajX().pT(str);
        if (pT == null || pT.endsWith(File.separator) || (parentFile = new File(pT).getParentFile()) == null || !parentFile.exists()) {
            return null;
        }
        return pT;
    }

    private String getFileExtensionFromUrl(String str) {
        Uri parse;
        if (TextUtils.isEmpty(str) || (parse = Uri.parse(str)) == null) {
            return null;
        }
        return com.baidu.swan.d.d.vj(parse.getPath());
    }
}

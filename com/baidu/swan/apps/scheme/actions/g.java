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
import com.baidu.swan.apps.ap.ak;
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
/* loaded from: classes10.dex */
public class g extends com.baidu.swan.apps.network.a implements com.baidu.swan.apps.network.f {
    private static AtomicLong duU = new AtomicLong(System.currentTimeMillis());
    private int duV;

    public g(com.baidu.swan.apps.scheme.j jVar) {
        super(jVar, "/swanAPI/downloadFile");
        this.duV = 0;
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
        if (!TextUtils.isEmpty(optString4) && com.baidu.swan.c.d.zi(optString4)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal path");
            return false;
        }
        String aHw = com.baidu.swan.apps.runtime.e.aHw();
        if (TextUtils.isEmpty(aHw)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal appId");
            return false;
        }
        final String lo = com.baidu.swan.apps.api.module.network.c.lo(aHw);
        Request w = w(b, lo);
        if (w == null) {
            unitedSchemeEntity.result = jD(this.duV);
            return false;
        }
        final String httpUrl = w.url().toString();
        final String fileExtensionFromUrl = getFileExtensionFromUrl(httpUrl);
        JSONObject optJSONObject = b.optJSONObject(WebSocketRequest.PARAM_KEY_HEADER);
        com.baidu.swan.apps.network.a.b bVar = new com.baidu.swan.apps.network.a.b();
        HashMap<String, String> c = c(optJSONObject, true);
        String optString5 = b.optString("__plugin__");
        if (!TextUtils.isEmpty(optString5)) {
            com.baidu.swan.pms.model.h rp = com.baidu.swan.apps.ac.g.b.rp(optString5);
            if (c == null) {
                c = new HashMap<>();
            }
            c.put("X-SWAN-HOSTSIGN", com.baidu.swan.apps.ac.g.a.e(rp));
        }
        bVar.A(c);
        com.baidu.swan.apps.v.f.azO().azV();
        final String valueOf = String.valueOf(System.currentTimeMillis());
        this.dgX.put(valueOf, 0L);
        com.baidu.swan.apps.network.a.a aVar = new com.baidu.swan.apps.network.a.a();
        aVar.a(new a.InterfaceC0456a() { // from class: com.baidu.swan.apps.scheme.actions.g.1
            @Override // com.baidu.swan.apps.network.a.a.InterfaceC0456a
            public void bU(long j) {
                callbackHandler.handleSchemeDispatchCallback(optString3, UnitedSchemeUtility.wrapCallbackParams(1001, "download file failed because file size exceeds limit").toString());
                SwanAppNetworkUtils.a(com.baidu.swan.a.c.a.baK().getOkHttpClient(), lo);
                g.this.qy(valueOf);
            }

            @Override // com.baidu.swan.apps.network.a.a.InterfaceC0456a
            public void i(long j, long j2) {
                callbackHandler.handleSchemeDispatchCallback(optString3, UnitedSchemeUtility.wrapCallbackParams(1001, "progress callback fail()").toString());
                SwanAppNetworkUtils.a(com.baidu.swan.a.c.a.baK().getOkHttpClient(), lo);
                g.this.qy(valueOf);
            }

            @Override // com.baidu.swan.apps.network.a.a.InterfaceC0456a
            public void c(int i, long j, long j2) {
                if (System.currentTimeMillis() - g.this.qx(valueOf) > 500) {
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
                    g.this.dgX.put(valueOf, Long.valueOf(System.currentTimeMillis()));
                }
            }
        });
        final String aKp = com.baidu.swan.apps.statistic.h.aKp();
        final String page = ak.aNc().getPage();
        com.baidu.swan.apps.statistic.h.W(httpUrl, 0);
        OkHttpClient.Builder baL = com.baidu.swan.a.c.a.baK().baL();
        baL.addNetworkInterceptor(new com.baidu.swan.apps.network.a.d());
        com.baidu.swan.a.c.a.baK().a(baL);
        baL.addInterceptor(bVar).addNetworkInterceptor(aVar).build().newCall(com.baidu.swan.apps.network.a.c.a(w, "downloadFile", b.optString("__plugin__"))).enqueue(new Callback() { // from class: com.baidu.swan.apps.scheme.actions.g.2
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                com.baidu.swan.apps.v.f.azO().azW();
                callbackHandler.handleSchemeDispatchCallback(optString3, UnitedSchemeUtility.wrapCallbackParams(1001, iOException.getMessage()).toString());
                g.this.qy(valueOf);
                if (SwanAppNetworkUtils.isNetworkConnected(null)) {
                    com.baidu.swan.apps.statistic.h.a(0, httpUrl, 0, iOException.getMessage(), aKp, page);
                }
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) {
                String sA;
                String str;
                if (!TextUtils.isEmpty(optString4)) {
                    sA = g.this.sA(optString4);
                } else {
                    sA = g.a(response, fileExtensionFromUrl);
                }
                if (TextUtils.isEmpty(sA)) {
                    callbackHandler.handleSchemeDispatchCallback(optString3, UnitedSchemeUtility.wrapCallbackParams(1001, "realFilePath create fail").toString());
                    return;
                }
                if (aa.DEBUG) {
                    Log.d("DownloadFileAction", "the real file path is " + sA);
                }
                g.this.a(optString2, response.headers());
                if (TextUtils.isEmpty(optString4)) {
                    str = com.baidu.swan.apps.v.f.azO().azu().tJ(sA);
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
                    File file = new File(sA);
                    if (file.exists()) {
                        file.delete();
                        file.createNewFile();
                    }
                    if (com.baidu.swan.c.f.streamToFile(byteStream, file)) {
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
                    g.this.qy(valueOf);
                    com.baidu.swan.apps.v.f.azO().azW();
                }
                if (aa.DEBUG) {
                    Log.d("DownloadFileAction", "onResponse: respCode: " + code + ", url=" + httpUrl + ", msg=" + message);
                }
                com.baidu.swan.apps.statistic.h.a(code, httpUrl, 0, message, aKp, page);
            }
        });
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(lq(lo), 0));
        return true;
    }

    @Nullable
    private Request w(@Nullable JSONObject jSONObject, @Nullable String str) {
        HttpUrl lp;
        if (jSONObject == null || TextUtils.isEmpty(str) || (lp = com.baidu.swan.apps.api.module.network.c.lp(jSONObject.optString("url"))) == null) {
            return null;
        }
        String httpUrl = lp.toString();
        if (TextUtils.isEmpty(httpUrl)) {
            return null;
        }
        this.duV = com.baidu.swan.apps.ag.a.b.S("downloadFile", httpUrl, jSONObject.optString("__plugin__"));
        if (this.duV == 0) {
            return new Request.Builder().url(httpUrl).tag(str).build();
        }
        return null;
    }

    @Nullable
    public static String a(Response response, String str) {
        int lastIndexOf;
        String header = response.header("Content-Disposition", null);
        if (!TextUtils.isEmpty(header)) {
            String um = com.baidu.swan.apps.ap.r.um(header);
            if (!TextUtils.isEmpty(um) && (lastIndexOf = um.lastIndexOf(".") + 1) > 0) {
                str = um.substring(lastIndexOf);
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
                    String uk = com.baidu.swan.apps.ap.r.uk(split[i]);
                    if (!TextUtils.isEmpty(uk)) {
                        str = uk;
                        break;
                    }
                    i++;
                }
            }
        }
        return com.baidu.swan.apps.v.f.azO().azu().tK(duU.getAndIncrement() + (TextUtils.isEmpty(str) ? "" : "." + str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public String sA(@NonNull String str) {
        File parentFile;
        String tH = com.baidu.swan.apps.v.f.azO().azu().tH(str);
        if (tH == null || tH.endsWith(File.separator) || (parentFile = new File(tH).getParentFile()) == null || !parentFile.exists()) {
            return null;
        }
        return tH;
    }

    private String getFileExtensionFromUrl(String str) {
        Uri parse;
        if (TextUtils.isEmpty(str) || (parse = Uri.parse(str)) == null) {
            return null;
        }
        return com.baidu.swan.c.d.zh(parse.getPath());
    }
}

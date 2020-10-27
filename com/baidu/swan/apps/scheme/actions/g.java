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
    private static AtomicLong doZ = new AtomicLong(System.currentTimeMillis());
    private int dpa;

    public g(com.baidu.swan.apps.scheme.j jVar) {
        super(jVar, "/swanAPI/downloadFile");
        this.dpa = 0;
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
        if (!TextUtils.isEmpty(optString4) && com.baidu.swan.c.d.yU(optString4)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal path");
            return false;
        }
        String aEW = com.baidu.swan.apps.runtime.e.aEW();
        if (TextUtils.isEmpty(aEW)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal appId");
            return false;
        }
        final String kZ = com.baidu.swan.apps.api.module.network.c.kZ(aEW);
        Request w = w(b, kZ);
        if (w == null) {
            unitedSchemeEntity.result = jt(this.dpa);
            return false;
        }
        final String httpUrl = w.url().toString();
        final String fileExtensionFromUrl = getFileExtensionFromUrl(httpUrl);
        JSONObject optJSONObject = b.optJSONObject(WebSocketRequest.PARAM_KEY_HEADER);
        com.baidu.swan.apps.network.a.b bVar = new com.baidu.swan.apps.network.a.b();
        HashMap<String, String> c = c(optJSONObject, true);
        String optString5 = b.optString("__plugin__");
        if (!TextUtils.isEmpty(optString5)) {
            com.baidu.swan.pms.model.h rb = com.baidu.swan.apps.ac.g.b.rb(optString5);
            if (c == null) {
                c = new HashMap<>();
            }
            c.put("X-SWAN-HOSTSIGN", com.baidu.swan.apps.ac.g.a.e(rb));
        }
        bVar.A(c);
        com.baidu.swan.apps.v.f.axo().axv();
        final String valueOf = String.valueOf(System.currentTimeMillis());
        this.dbc.put(valueOf, 0L);
        com.baidu.swan.apps.network.a.a aVar = new com.baidu.swan.apps.network.a.a();
        aVar.a(new a.InterfaceC0444a() { // from class: com.baidu.swan.apps.scheme.actions.g.1
            @Override // com.baidu.swan.apps.network.a.a.InterfaceC0444a
            public void by(long j) {
                callbackHandler.handleSchemeDispatchCallback(optString3, UnitedSchemeUtility.wrapCallbackParams(1001, "download file failed because file size exceeds limit").toString());
                SwanAppNetworkUtils.a(com.baidu.swan.a.c.a.aYk().getOkHttpClient(), kZ);
                g.this.qk(valueOf);
            }

            @Override // com.baidu.swan.apps.network.a.a.InterfaceC0444a
            public void h(long j, long j2) {
                callbackHandler.handleSchemeDispatchCallback(optString3, UnitedSchemeUtility.wrapCallbackParams(1001, "progress callback fail()").toString());
                SwanAppNetworkUtils.a(com.baidu.swan.a.c.a.aYk().getOkHttpClient(), kZ);
                g.this.qk(valueOf);
            }

            @Override // com.baidu.swan.apps.network.a.a.InterfaceC0444a
            public void b(int i, long j, long j2) {
                if (System.currentTimeMillis() - g.this.qj(valueOf) > 500) {
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
                    g.this.dbc.put(valueOf, Long.valueOf(System.currentTimeMillis()));
                }
            }
        });
        final String aHP = com.baidu.swan.apps.statistic.h.aHP();
        final String page = ak.aKC().getPage();
        com.baidu.swan.apps.statistic.h.U(httpUrl, 0);
        OkHttpClient.Builder aYl = com.baidu.swan.a.c.a.aYk().aYl();
        aYl.addNetworkInterceptor(new com.baidu.swan.apps.network.a.d());
        com.baidu.swan.a.c.a.aYk().a(aYl);
        aYl.addInterceptor(bVar).addNetworkInterceptor(aVar).build().newCall(com.baidu.swan.apps.network.a.c.a(w, "downloadFile", b.optString("__plugin__"))).enqueue(new Callback() { // from class: com.baidu.swan.apps.scheme.actions.g.2
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                com.baidu.swan.apps.v.f.axo().axw();
                callbackHandler.handleSchemeDispatchCallback(optString3, UnitedSchemeUtility.wrapCallbackParams(1001, iOException.getMessage()).toString());
                g.this.qk(valueOf);
                if (SwanAppNetworkUtils.isNetworkConnected(null)) {
                    com.baidu.swan.apps.statistic.h.a(0, httpUrl, 0, iOException.getMessage(), aHP, page);
                }
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) {
                String sl;
                String str;
                if (!TextUtils.isEmpty(optString4)) {
                    sl = g.this.sl(optString4);
                } else {
                    sl = g.a(response, fileExtensionFromUrl);
                }
                if (TextUtils.isEmpty(sl)) {
                    callbackHandler.handleSchemeDispatchCallback(optString3, UnitedSchemeUtility.wrapCallbackParams(1001, "realFilePath create fail").toString());
                    return;
                }
                if (aa.DEBUG) {
                    Log.d("DownloadFileAction", "the real file path is " + sl);
                }
                g.this.a(optString2, response.headers());
                if (TextUtils.isEmpty(optString4)) {
                    str = com.baidu.swan.apps.v.f.axo().awU().tv(sl);
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
                    File file = new File(sl);
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
                    g.this.qk(valueOf);
                    com.baidu.swan.apps.v.f.axo().axw();
                }
                if (aa.DEBUG) {
                    Log.d("DownloadFileAction", "onResponse: respCode: " + code + ", url=" + httpUrl + ", msg=" + message);
                }
                com.baidu.swan.apps.statistic.h.a(code, httpUrl, 0, message, aHP, page);
            }
        });
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(lb(kZ), 0));
        return true;
    }

    @Nullable
    private Request w(@Nullable JSONObject jSONObject, @Nullable String str) {
        HttpUrl la;
        if (jSONObject == null || TextUtils.isEmpty(str) || (la = com.baidu.swan.apps.api.module.network.c.la(jSONObject.optString("url"))) == null) {
            return null;
        }
        String httpUrl = la.toString();
        if (TextUtils.isEmpty(httpUrl)) {
            return null;
        }
        this.dpa = com.baidu.swan.apps.ag.a.b.S("downloadFile", httpUrl, jSONObject.optString("__plugin__"));
        if (this.dpa == 0) {
            return new Request.Builder().url(httpUrl).tag(str).build();
        }
        return null;
    }

    @Nullable
    public static String a(Response response, String str) {
        int lastIndexOf;
        String header = response.header("Content-Disposition", null);
        if (!TextUtils.isEmpty(header)) {
            String tY = com.baidu.swan.apps.ap.r.tY(header);
            if (!TextUtils.isEmpty(tY) && (lastIndexOf = tY.lastIndexOf(".") + 1) > 0) {
                str = tY.substring(lastIndexOf);
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
                    String tW = com.baidu.swan.apps.ap.r.tW(split[i]);
                    if (!TextUtils.isEmpty(tW)) {
                        str = tW;
                        break;
                    }
                    i++;
                }
            }
        }
        return com.baidu.swan.apps.v.f.axo().awU().tw(doZ.getAndIncrement() + (TextUtils.isEmpty(str) ? "" : "." + str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public String sl(@NonNull String str) {
        File parentFile;
        String tt = com.baidu.swan.apps.v.f.axo().awU().tt(str);
        if (tt == null || tt.endsWith(File.separator) || (parentFile = new File(tt).getParentFile()) == null || !parentFile.exists()) {
            return null;
        }
        return tt;
    }

    private String getFileExtensionFromUrl(String str) {
        Uri parse;
        if (TextUtils.isEmpty(str) || (parse = Uri.parse(str)) == null) {
            return null;
        }
        return com.baidu.swan.c.d.yT(parse.getPath());
    }
}

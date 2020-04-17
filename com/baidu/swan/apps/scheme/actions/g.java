package com.baidu.swan.apps.scheme.actions;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.searchbox.websocket.WebSocketRequest;
import com.baidu.swan.apps.as.ai;
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
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class g extends com.baidu.swan.apps.network.a implements com.baidu.swan.apps.network.f {
    private static AtomicLong cpN = new AtomicLong(System.currentTimeMillis());
    private int cpO;

    public g(com.baidu.swan.apps.scheme.j jVar) {
        super(jVar, "/swanAPI/downloadFile");
        this.cpO = 0;
    }

    @Override // com.baidu.swan.apps.network.a, com.baidu.swan.apps.scheme.actions.ab
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final com.baidu.swan.apps.runtime.e eVar) {
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
        if (!TextUtils.isEmpty(optString3) && com.baidu.swan.d.c.sv(optString3)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal path");
            return false;
        }
        String akP = com.baidu.swan.apps.runtime.e.akP();
        if (TextUtils.isEmpty(akP)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal appId");
            return false;
        }
        final String gV = com.baidu.swan.apps.api.module.g.c.gV(akP);
        Request o = o(b, gV);
        if (o == null) {
            unitedSchemeEntity.result = fJ(this.cpO);
            return false;
        }
        final String httpUrl = o.url().toString();
        final String fileExtensionFromUrl = getFileExtensionFromUrl(httpUrl);
        JSONObject optJSONObject = b.optJSONObject(WebSocketRequest.PARAM_KEY_HEADER);
        com.baidu.swan.apps.network.a.b bVar = new com.baidu.swan.apps.network.a.b();
        HashMap<String, String> c = c(optJSONObject, true);
        String optString4 = b.optString("__plugin__");
        if (!TextUtils.isEmpty(optString4)) {
            com.baidu.swan.pms.model.h ly = com.baidu.swan.apps.ag.g.b.ly(optString4);
            if (c == null) {
                c = new HashMap<>();
            }
            c.put("X-SWAN-HOSTSIGN", com.baidu.swan.apps.ag.g.a.e(ly));
        }
        bVar.A(c);
        final String valueOf = String.valueOf(System.currentTimeMillis());
        this.ceZ.put(valueOf, 0L);
        com.baidu.swan.apps.network.a.a aVar = new com.baidu.swan.apps.network.a.a();
        aVar.a(new a.InterfaceC0297a() { // from class: com.baidu.swan.apps.scheme.actions.g.1
            @Override // com.baidu.swan.apps.network.a.a.InterfaceC0297a
            public void aX(long j) {
                callbackHandler.handleSchemeDispatchCallback(optString2, UnitedSchemeUtility.wrapCallbackParams(1001, "download file size > 10MB").toString());
                SwanAppNetworkUtils.a(eVar.akZ().ahf(), gV);
                g.this.kS(valueOf);
            }

            @Override // com.baidu.swan.apps.network.a.a.InterfaceC0297a
            public void k(long j, long j2) {
                callbackHandler.handleSchemeDispatchCallback(optString2, UnitedSchemeUtility.wrapCallbackParams(1001, "progress callback fail()").toString());
                SwanAppNetworkUtils.a(eVar.akZ().ahf(), gV);
                g.this.kS(valueOf);
            }

            @Override // com.baidu.swan.apps.network.a.a.InterfaceC0297a
            public void b(int i, long j, long j2) {
                if (System.currentTimeMillis() - g.this.kR(valueOf) > 500) {
                    if (i <= 100) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("progress", String.valueOf(i));
                            jSONObject.put("totalBytesWritten", String.valueOf(j));
                            jSONObject.put("totalBytesExpectedToWrite", String.valueOf(j2));
                            if (jSONObject.toString().length() > g.this.alU()) {
                                callbackHandler.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(201, "response json length over limits").toString());
                            } else {
                                callbackHandler.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParamsWithEncode(jSONObject, 0).toString());
                            }
                        } catch (Exception e) {
                            if (ab.DEBUG) {
                                e.printStackTrace();
                            }
                        }
                    }
                    g.this.ceZ.put(valueOf, Long.valueOf(System.currentTimeMillis()));
                }
            }
        });
        final String ang = com.baidu.swan.apps.statistic.f.ang();
        final String page = ai.apv().getPage();
        com.baidu.swan.apps.statistic.f.O(httpUrl, 0);
        eVar.akZ().ahf().newBuilder().addInterceptor(bVar).addNetworkInterceptor(aVar).build().newCall(o).enqueue(new Callback() { // from class: com.baidu.swan.apps.scheme.actions.g.2
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                callbackHandler.handleSchemeDispatchCallback(optString2, UnitedSchemeUtility.wrapCallbackParams(1001, iOException.getMessage()).toString());
                g.this.kS(valueOf);
                if (SwanAppNetworkUtils.isNetworkConnected(null)) {
                    com.baidu.swan.apps.statistic.f.a(0, httpUrl, 0, iOException.getMessage(), ang, page);
                }
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) {
                String mD;
                String str;
                if (!TextUtils.isEmpty(optString3)) {
                    mD = g.this.mD(optString3);
                } else {
                    mD = g.a(response, fileExtensionFromUrl);
                }
                if (TextUtils.isEmpty(mD)) {
                    callbackHandler.handleSchemeDispatchCallback(optString2, UnitedSchemeUtility.wrapCallbackParams(1001, "realFilePath create fail").toString());
                    return;
                }
                if (ab.DEBUG) {
                    Log.d("DownloadFileAction", "the real file path is " + mD);
                }
                if (TextUtils.isEmpty(optString3)) {
                    str = com.baidu.swan.apps.y.f.aeK().aer().nw(mD);
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
                    File file = new File(mD);
                    if (file.exists()) {
                        file.delete();
                        file.createNewFile();
                    }
                    if (com.baidu.swan.d.f.streamToFile(byteStream, file)) {
                        callbackHandler.handleSchemeDispatchCallback(optString2, UnitedSchemeUtility.wrapCallbackParamsWithEncode(jSONObject, 0).toString());
                    } else {
                        callbackHandler.handleSchemeDispatchCallback(optString2, UnitedSchemeUtility.wrapCallbackParams(1001, "streamToFile fail").toString());
                    }
                } catch (Exception e) {
                    if (ab.DEBUG) {
                        e.printStackTrace();
                    }
                    callbackHandler.handleSchemeDispatchCallback(optString2, UnitedSchemeUtility.wrapCallbackParams(201, e.getMessage()).toString());
                } finally {
                    g.this.kS(valueOf);
                }
                if (ab.DEBUG) {
                    Log.d("DownloadFileAction", "onResponse: respCode: " + code + ", url=" + httpUrl + ", msg=" + message);
                }
                com.baidu.swan.apps.statistic.f.a(code, httpUrl, 0, message, ang, page);
            }
        });
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(gX(gV), 0));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long alU() {
        if (com.baidu.swan.apps.runtime.d.akK().Om() == 0) {
            return 10485760L;
        }
        return Config.RAVEN_LOG_LIMIT;
    }

    @Nullable
    private Request o(@Nullable JSONObject jSONObject, @Nullable String str) {
        HttpUrl gW;
        if (jSONObject == null || TextUtils.isEmpty(str) || (gW = com.baidu.swan.apps.api.module.g.c.gW(jSONObject.optString("url"))) == null) {
            return null;
        }
        String httpUrl = gW.toString();
        if (TextUtils.isEmpty(httpUrl)) {
            return null;
        }
        this.cpO = com.baidu.swan.apps.aj.a.b.D("downloadFile", httpUrl, jSONObject.optString("__plugin__"));
        if (this.cpO == 0) {
            return new Request.Builder().url(httpUrl).tag(str).build();
        }
        return null;
    }

    @Nullable
    public static String a(Response response, String str) {
        int lastIndexOf;
        String header = response.header("Content-Disposition", null);
        if (!TextUtils.isEmpty(header)) {
            String nW = com.baidu.swan.apps.as.o.nW(header);
            if (!TextUtils.isEmpty(nW) && (lastIndexOf = nW.lastIndexOf(".") + 1) > 0) {
                str = nW.substring(lastIndexOf);
            }
        } else {
            String header2 = response.header("Content-Type", null);
            if (!TextUtils.isEmpty(header2)) {
                str = com.baidu.swan.apps.as.o.cxG.containsKey(header2) ? com.baidu.swan.apps.as.o.cxG.get(header2) : str;
            }
        }
        return com.baidu.swan.apps.y.f.aeK().aer().nx(cpN.getAndIncrement() + (TextUtils.isEmpty(str) ? "" : "." + str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public String mD(@NonNull String str) {
        File parentFile;
        String nu = com.baidu.swan.apps.y.f.aeK().aer().nu(str);
        if (nu == null || nu.endsWith(File.separator) || (parentFile = new File(nu).getParentFile()) == null || !parentFile.exists()) {
            return null;
        }
        return nu;
    }

    private String getFileExtensionFromUrl(String str) {
        Uri parse;
        if (TextUtils.isEmpty(str) || (parse = Uri.parse(str)) == null) {
            return null;
        }
        return com.baidu.swan.d.c.su(parse.getPath());
    }
}

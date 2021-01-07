package com.baidu.swan.apps.scheme.actions;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.searchbox.websocket.WebSocketRequest;
import com.baidu.swan.apps.ao.ak;
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
/* loaded from: classes9.dex */
public class g extends com.baidu.swan.apps.network.a implements com.baidu.swan.apps.network.f {
    private static AtomicLong dIR = new AtomicLong(System.currentTimeMillis());
    private int dIS;

    public g(com.baidu.swan.apps.scheme.j jVar) {
        super(jVar, "/swanAPI/downloadFile");
        this.dIS = 0;
    }

    @Override // com.baidu.swan.apps.network.a, com.baidu.swan.apps.scheme.actions.aa
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        if (eVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "swanApp is null");
            return false;
        }
        JSONObject b2 = b(unitedSchemeEntity, "params");
        if (b2 == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal params");
            return false;
        }
        final String optString = b2.optString("onProgressUpdate");
        final String optString2 = b2.optString("headersReceivedEvent");
        final String optString3 = b2.optString("cb");
        if (TextUtils.isEmpty(optString3)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal resultCallback");
            return false;
        }
        final String optString4 = b2.optString("filePath");
        if (!TextUtils.isEmpty(optString4) && com.baidu.swan.c.d.zJ(optString4)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal path");
            return false;
        }
        String aMn = com.baidu.swan.apps.runtime.e.aMn();
        if (TextUtils.isEmpty(aMn)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal appId");
            return false;
        }
        final String lI = com.baidu.swan.apps.api.module.network.c.lI(aMn);
        Request t = t(b2, lI);
        if (t == null) {
            unitedSchemeEntity.result = jS(this.dIS);
            return false;
        }
        final String httpUrl = t.url().toString();
        final String fileExtensionFromUrl = getFileExtensionFromUrl(httpUrl);
        JSONObject optJSONObject = b2.optJSONObject(WebSocketRequest.PARAM_KEY_HEADER);
        com.baidu.swan.apps.network.a.b bVar = new com.baidu.swan.apps.network.a.b();
        HashMap<String, String> e = e(optJSONObject, true);
        String optString5 = b2.optString("__plugin__");
        if (!TextUtils.isEmpty(optString5)) {
            com.baidu.swan.pms.model.h rJ = com.baidu.swan.apps.ac.g.b.rJ(optString5);
            if (e == null) {
                e = new HashMap<>();
            }
            e.put("X-SWAN-HOSTSIGN", com.baidu.swan.apps.ac.g.a.e(rJ));
        }
        bVar.A(e);
        com.baidu.swan.apps.v.f.aDH().aDO();
        final String valueOf = String.valueOf(System.currentTimeMillis());
        this.dro.put(valueOf, 0L);
        com.baidu.swan.apps.network.a.a aVar = new com.baidu.swan.apps.network.a.a();
        aVar.a(new a.InterfaceC0458a() { // from class: com.baidu.swan.apps.scheme.actions.g.1
            @Override // com.baidu.swan.apps.network.a.a.InterfaceC0458a
            public void cu(long j) {
                callbackHandler.handleSchemeDispatchCallback(optString3, UnitedSchemeUtility.wrapCallbackParams(1001, "download file failed because file size exceeds limit").toString());
                SwanAppNetworkUtils.a(com.baidu.swan.a.c.a.bfF().getOkHttpClient(), lI);
                g.this.qT(valueOf);
            }

            @Override // com.baidu.swan.apps.network.a.a.InterfaceC0458a
            public void l(long j, long j2) {
                callbackHandler.handleSchemeDispatchCallback(optString3, UnitedSchemeUtility.wrapCallbackParams(1001, "progress callback fail()").toString());
                SwanAppNetworkUtils.a(com.baidu.swan.a.c.a.bfF().getOkHttpClient(), lI);
                g.this.qT(valueOf);
            }

            @Override // com.baidu.swan.apps.network.a.a.InterfaceC0458a
            public void d(int i, long j, long j2) {
                if (System.currentTimeMillis() - g.this.qS(valueOf) > 500) {
                    if (i <= 100) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("progress", i);
                            jSONObject.put("totalBytesWritten", j);
                            jSONObject.put("totalBytesExpectedToWrite", j2);
                            callbackHandler.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParamsWithEncode(jSONObject, 0).toString());
                        } catch (Exception e2) {
                            if (aa.DEBUG) {
                                e2.printStackTrace();
                            }
                        }
                    }
                    g.this.dro.put(valueOf, Long.valueOf(System.currentTimeMillis()));
                }
            }
        });
        final String aPf = com.baidu.swan.apps.statistic.h.aPf();
        final String page = ak.aRS().getPage();
        com.baidu.swan.apps.statistic.h.Z(httpUrl, 0);
        OkHttpClient.Builder bfG = com.baidu.swan.a.c.a.bfF().bfG();
        bfG.addNetworkInterceptor(new com.baidu.swan.apps.network.a.d());
        com.baidu.swan.a.c.a.bfF().a(bfG);
        bfG.addInterceptor(bVar).addNetworkInterceptor(aVar).build().newCall(com.baidu.swan.apps.network.a.c.a(t, "downloadFile", b2.optString("__plugin__"))).enqueue(new Callback() { // from class: com.baidu.swan.apps.scheme.actions.g.2
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                com.baidu.swan.apps.v.f.aDH().aDP();
                callbackHandler.handleSchemeDispatchCallback(optString3, UnitedSchemeUtility.wrapCallbackParams(1001, iOException.getMessage()).toString());
                g.this.qT(valueOf);
                if (SwanAppNetworkUtils.isNetworkConnected(null)) {
                    com.baidu.swan.apps.statistic.h.a(0, httpUrl, 0, iOException.getMessage(), aPf, page);
                }
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) {
                String sZ;
                String str;
                if (!TextUtils.isEmpty(optString4)) {
                    sZ = g.this.sZ(optString4);
                } else {
                    sZ = g.a(response, fileExtensionFromUrl);
                }
                if (TextUtils.isEmpty(sZ)) {
                    callbackHandler.handleSchemeDispatchCallback(optString3, UnitedSchemeUtility.wrapCallbackParams(1001, "realFilePath create fail").toString());
                    return;
                }
                if (aa.DEBUG) {
                    Log.d("DownloadFileAction", "the real file path is " + sZ);
                }
                g.this.a(optString2, response.headers());
                if (TextUtils.isEmpty(optString4)) {
                    str = com.baidu.swan.apps.v.f.aDH().aDn().ui(sZ);
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
                    File file = new File(sZ);
                    if (file.exists()) {
                        file.delete();
                        file.createNewFile();
                    }
                    if (com.baidu.swan.c.f.streamToFile(byteStream, file)) {
                        callbackHandler.handleSchemeDispatchCallback(optString3, UnitedSchemeUtility.wrapCallbackParamsWithEncode(jSONObject, 0).toString());
                    } else {
                        callbackHandler.handleSchemeDispatchCallback(optString3, UnitedSchemeUtility.wrapCallbackParams(1001, "streamToFile fail").toString());
                    }
                } catch (Exception e2) {
                    if (aa.DEBUG) {
                        e2.printStackTrace();
                    }
                    callbackHandler.handleSchemeDispatchCallback(optString3, UnitedSchemeUtility.wrapCallbackParams(201, e2.getMessage()).toString());
                } finally {
                    g.this.qT(valueOf);
                    com.baidu.swan.apps.v.f.aDH().aDP();
                }
                if (aa.DEBUG) {
                    Log.d("DownloadFileAction", "onResponse: respCode: " + code + ", url=" + httpUrl + ", msg=" + message);
                }
                com.baidu.swan.apps.statistic.h.a(code, httpUrl, 0, message, aPf, page);
            }
        });
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(lK(lI), 0));
        return true;
    }

    @Nullable
    private Request t(@Nullable JSONObject jSONObject, @Nullable String str) {
        HttpUrl lJ;
        if (jSONObject == null || TextUtils.isEmpty(str) || (lJ = com.baidu.swan.apps.api.module.network.c.lJ(jSONObject.optString("url"))) == null) {
            return null;
        }
        String httpUrl = lJ.toString();
        if (TextUtils.isEmpty(httpUrl)) {
            return null;
        }
        this.dIS = com.baidu.swan.apps.af.a.b.Y("downloadFile", httpUrl, jSONObject.optString("__plugin__"));
        if (this.dIS == 0) {
            return new Request.Builder().url(httpUrl).tag(str).build();
        }
        return null;
    }

    @Nullable
    public static String a(Response response, String str) {
        int lastIndexOf;
        String header = response.header("Content-Disposition", null);
        if (!TextUtils.isEmpty(header)) {
            String uM = com.baidu.swan.apps.ao.r.uM(header);
            if (!TextUtils.isEmpty(uM) && (lastIndexOf = uM.lastIndexOf(".") + 1) > 0) {
                str = uM.substring(lastIndexOf);
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
                    String uK = com.baidu.swan.apps.ao.r.uK(split[i]);
                    if (!TextUtils.isEmpty(uK)) {
                        str = uK;
                        break;
                    }
                    i++;
                }
            }
        }
        return com.baidu.swan.apps.v.f.aDH().aDn().uj(dIR.getAndIncrement() + (TextUtils.isEmpty(str) ? "" : "." + str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public String sZ(@NonNull String str) {
        File parentFile;
        String ug = com.baidu.swan.apps.v.f.aDH().aDn().ug(str);
        if (ug == null || ug.endsWith(File.separator) || (parentFile = new File(ug).getParentFile()) == null || !parentFile.exists()) {
            return null;
        }
        return ug;
    }

    private String getFileExtensionFromUrl(String str) {
        Uri parse;
        if (TextUtils.isEmpty(str) || (parse = Uri.parse(str)) == null) {
            return null;
        }
        return com.baidu.swan.c.d.zI(parse.getPath());
    }
}

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
    private static AtomicLong bQN = new AtomicLong(System.currentTimeMillis());
    private int bQO;

    public g(com.baidu.swan.apps.scheme.j jVar) {
        super(jVar, "/swanAPI/downloadFile");
        this.bQO = 0;
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
        if (!TextUtils.isEmpty(optString3) && com.baidu.swan.d.c.ri(optString3)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal path");
            return false;
        }
        String acF = com.baidu.swan.apps.runtime.e.acF();
        if (TextUtils.isEmpty(acF)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal appId");
            return false;
        }
        final String fI = com.baidu.swan.apps.api.module.g.c.fI(acF);
        Request n = n(b, fI);
        if (n == null) {
            unitedSchemeEntity.result = fC(this.bQO);
            return false;
        }
        final String httpUrl = n.url().toString();
        final String fileExtensionFromUrl = getFileExtensionFromUrl(httpUrl);
        JSONObject optJSONObject = b.optJSONObject(WebSocketRequest.PARAM_KEY_HEADER);
        com.baidu.swan.apps.network.a.b bVar = new com.baidu.swan.apps.network.a.b();
        HashMap<String, String> c = c(optJSONObject, true);
        String optString4 = b.optString("__plugin__");
        if (!TextUtils.isEmpty(optString4)) {
            com.baidu.swan.pms.model.h km = com.baidu.swan.apps.ag.g.b.km(optString4);
            if (c == null) {
                c = new HashMap<>();
            }
            c.put("X-SWAN-HOSTSIGN", com.baidu.swan.apps.ag.g.a.e(km));
        }
        bVar.m(c);
        final String valueOf = String.valueOf(System.currentTimeMillis());
        this.bGc.put(valueOf, 0L);
        com.baidu.swan.apps.network.a.a aVar = new com.baidu.swan.apps.network.a.a();
        aVar.a(new a.InterfaceC0267a() { // from class: com.baidu.swan.apps.scheme.actions.g.1
            @Override // com.baidu.swan.apps.network.a.a.InterfaceC0267a
            public void as(long j) {
                callbackHandler.handleSchemeDispatchCallback(optString2, UnitedSchemeUtility.wrapCallbackParams(1001, "download file size > 10MB").toString());
                SwanAppNetworkUtils.a(eVar.acP().YU(), fI);
                g.this.jG(valueOf);
            }

            @Override // com.baidu.swan.apps.network.a.a.InterfaceC0267a
            public void j(long j, long j2) {
                callbackHandler.handleSchemeDispatchCallback(optString2, UnitedSchemeUtility.wrapCallbackParams(1001, "progress callback fail()").toString());
                SwanAppNetworkUtils.a(eVar.acP().YU(), fI);
                g.this.jG(valueOf);
            }

            @Override // com.baidu.swan.apps.network.a.a.InterfaceC0267a
            public void b(int i, long j, long j2) {
                if (System.currentTimeMillis() - g.this.jF(valueOf) > 500) {
                    if (i <= 100) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("progress", String.valueOf(i));
                            jSONObject.put("totalBytesWritten", String.valueOf(j));
                            jSONObject.put("totalBytesExpectedToWrite", String.valueOf(j2));
                            if (jSONObject.toString().length() > g.this.adK()) {
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
                    g.this.bGc.put(valueOf, Long.valueOf(System.currentTimeMillis()));
                }
            }
        });
        final String aeW = com.baidu.swan.apps.statistic.f.aeW();
        final String page = ai.ahi().getPage();
        com.baidu.swan.apps.statistic.f.G(httpUrl, 0);
        eVar.acP().YU().newBuilder().addInterceptor(bVar).addNetworkInterceptor(aVar).build().newCall(n).enqueue(new Callback() { // from class: com.baidu.swan.apps.scheme.actions.g.2
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                callbackHandler.handleSchemeDispatchCallback(optString2, UnitedSchemeUtility.wrapCallbackParams(1001, iOException.getMessage()).toString());
                g.this.jG(valueOf);
                if (SwanAppNetworkUtils.isNetworkConnected(null)) {
                    com.baidu.swan.apps.statistic.f.a(0, httpUrl, 0, iOException.getMessage(), aeW, page);
                }
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) {
                String lr;
                String str;
                if (!TextUtils.isEmpty(optString3)) {
                    lr = g.this.lr(optString3);
                } else {
                    lr = g.a(response, fileExtensionFromUrl);
                }
                if (TextUtils.isEmpty(lr)) {
                    callbackHandler.handleSchemeDispatchCallback(optString2, UnitedSchemeUtility.wrapCallbackParams(1001, "realFilePath create fail").toString());
                    return;
                }
                if (ab.DEBUG) {
                    Log.d("DownloadFileAction", "the real file path is " + lr);
                }
                if (TextUtils.isEmpty(optString3)) {
                    str = com.baidu.swan.apps.y.f.WQ().Wx().mk(lr);
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
                    File file = new File(lr);
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
                    g.this.jG(valueOf);
                }
                if (ab.DEBUG) {
                    Log.d("DownloadFileAction", "onResponse: respCode: " + code + ", url=" + httpUrl + ", msg=" + message);
                }
                com.baidu.swan.apps.statistic.f.a(code, httpUrl, 0, message, aeW, page);
            }
        });
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(fK(fI), 0));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long adK() {
        if (com.baidu.swan.apps.runtime.d.acA().Gs() == 0) {
            return 10485760L;
        }
        return Config.RAVEN_LOG_LIMIT;
    }

    @Nullable
    private Request n(@Nullable JSONObject jSONObject, @Nullable String str) {
        HttpUrl fJ;
        if (jSONObject == null || TextUtils.isEmpty(str) || (fJ = com.baidu.swan.apps.api.module.g.c.fJ(jSONObject.optString("url"))) == null) {
            return null;
        }
        String httpUrl = fJ.toString();
        if (TextUtils.isEmpty(httpUrl)) {
            return null;
        }
        this.bQO = com.baidu.swan.apps.aj.a.b.D("downloadFile", httpUrl, jSONObject.optString("__plugin__"));
        if (this.bQO == 0) {
            return new Request.Builder().url(httpUrl).tag(str).build();
        }
        return null;
    }

    @Nullable
    public static String a(Response response, String str) {
        int lastIndexOf;
        String header = response.header("Content-Disposition", null);
        if (!TextUtils.isEmpty(header)) {
            String mK = com.baidu.swan.apps.as.o.mK(header);
            if (!TextUtils.isEmpty(mK) && (lastIndexOf = mK.lastIndexOf(".") + 1) > 0) {
                str = mK.substring(lastIndexOf);
            }
        } else {
            String header2 = response.header("Content-Type", null);
            if (!TextUtils.isEmpty(header2)) {
                str = com.baidu.swan.apps.as.o.bYx.containsKey(header2) ? com.baidu.swan.apps.as.o.bYx.get(header2) : str;
            }
        }
        return com.baidu.swan.apps.y.f.WQ().Wx().ml(bQN.getAndIncrement() + (TextUtils.isEmpty(str) ? "" : "." + str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public String lr(@NonNull String str) {
        File parentFile;
        String mi = com.baidu.swan.apps.y.f.WQ().Wx().mi(str);
        if (mi == null || mi.endsWith(File.separator) || (parentFile = new File(mi).getParentFile()) == null || !parentFile.exists()) {
            return null;
        }
        return mi;
    }

    private String getFileExtensionFromUrl(String str) {
        Uri parse;
        if (TextUtils.isEmpty(str) || (parse = Uri.parse(str)) == null) {
            return null;
        }
        return com.baidu.swan.d.c.rh(parse.getPath());
    }
}

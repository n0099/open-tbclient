package com.baidu.swan.apps.scheme.actions;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.DefaultConfig;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.searchbox.websocket.WebSocketRequest;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.network.a.a;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicLong;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class f extends com.baidu.swan.apps.network.a implements com.baidu.swan.apps.network.f {
    private static AtomicLong blo = new AtomicLong(System.currentTimeMillis());

    public f(com.baidu.swan.apps.scheme.j jVar) {
        super(jVar, "/swan/downloadFile");
    }

    @Override // com.baidu.swan.apps.network.a, com.baidu.swan.apps.scheme.actions.z
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final com.baidu.swan.apps.ae.b bVar) {
        if (bVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "swanApp is null");
            return false;
        }
        JSONObject c = c(unitedSchemeEntity, "params");
        if (c == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal params");
            return false;
        }
        final String optString = c.optString("onProgressUpdate");
        final String optString2 = c.optString("cb");
        if (TextUtils.isEmpty(optString2)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal resultCallback");
            return false;
        }
        final boolean isInvokedFromSwanGame = UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler);
        final String optString3 = c.optString("filePath");
        if (!TextUtils.isEmpty(optString3) && com.baidu.swan.c.a.lN(optString3)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal path");
            return false;
        }
        final String Rm = com.baidu.swan.apps.ae.b.Rm();
        if (TextUtils.isEmpty(Rm)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal appId");
            return false;
        }
        final String go = go(Rm);
        Request j = j(c, go);
        if (j == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal request");
            return false;
        }
        final String lM = com.baidu.swan.c.a.lM(j.url().toString());
        JSONObject optJSONObject = c.optJSONObject(WebSocketRequest.PARAM_KEY_HEADER);
        com.baidu.swan.apps.network.a.b bVar2 = new com.baidu.swan.apps.network.a.b();
        bVar2.n(b(optJSONObject, true));
        final String valueOf = String.valueOf(System.currentTimeMillis());
        this.aXX.put(valueOf, 0L);
        com.baidu.swan.apps.network.a.a aVar = new com.baidu.swan.apps.network.a.a();
        aVar.a(new a.InterfaceC0194a() { // from class: com.baidu.swan.apps.scheme.actions.f.1
            @Override // com.baidu.swan.apps.network.a.a.InterfaceC0194a
            public void ac(long j2) {
                callbackHandler.handleSchemeDispatchCallback(optString2, UnitedSchemeUtility.wrapCallbackParams(1001, "download file size > 10MB").toString());
                SwanAppNetworkUtils.a(bVar.Rh().MM(), go);
                f.this.gm(valueOf);
            }

            @Override // com.baidu.swan.apps.network.a.a.InterfaceC0194a
            public void k(long j2, long j3) {
                callbackHandler.handleSchemeDispatchCallback(optString2, UnitedSchemeUtility.wrapCallbackParams(1001, "progress callback fail()").toString());
                SwanAppNetworkUtils.a(bVar.Rh().MM(), go);
                f.this.gm(valueOf);
            }

            @Override // com.baidu.swan.apps.network.a.a.InterfaceC0194a
            public void b(int i, long j2, long j3) {
                if (System.currentTimeMillis() - f.this.gl(valueOf) > 500) {
                    if (i <= 100) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("progress", String.valueOf(i));
                            jSONObject.put("totalBytesWritten", String.valueOf(j2));
                            jSONObject.put("totalBytesExpectedToWrite", String.valueOf(j3));
                            callbackHandler.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParamsWithEncode(jSONObject, 0).toString());
                        } catch (Exception e) {
                            if (z.DEBUG) {
                                e.printStackTrace();
                            }
                        }
                    }
                    f.this.aXX.put(valueOf, Long.valueOf(System.currentTimeMillis()));
                }
            }
        });
        bVar.Rh().MM().newBuilder().addInterceptor(bVar2).addNetworkInterceptor(aVar).build().newCall(j).enqueue(new Callback() { // from class: com.baidu.swan.apps.scheme.actions.f.2
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                callbackHandler.handleSchemeDispatchCallback(optString2, UnitedSchemeUtility.wrapCallbackParams(1001, iOException.getMessage()).toString());
                f.this.gm(valueOf);
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) {
                String str;
                String a = TextUtils.isEmpty(optString3) ? f.this.a(response, lM, Rm, isInvokedFromSwanGame) : f.this.k(optString3, Rm, isInvokedFromSwanGame);
                if (TextUtils.isEmpty(a)) {
                    callbackHandler.handleSchemeDispatchCallback(optString2, UnitedSchemeUtility.wrapCallbackParams(1001, "realFilePath create fail").toString());
                    return;
                }
                if (z.DEBUG) {
                    Log.d("DownloadFileAction", "the real file path is " + a);
                }
                if (TextUtils.isEmpty(optString3)) {
                    str = f.this.l(a, Rm, isInvokedFromSwanGame);
                } else {
                    str = optString3;
                }
                try {
                    if (TextUtils.isEmpty(str)) {
                        callbackHandler.handleSchemeDispatchCallback(optString2, UnitedSchemeUtility.wrapCallbackParams(1001, "parse tmpFilePath from realFilePath fail").toString());
                        return;
                    }
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("statusCode", response.code());
                    jSONObject.put(TextUtils.isEmpty(optString3) ? "tempFilePath" : "filePath", str);
                    InputStream byteStream = response.body().byteStream();
                    File file = new File(a);
                    if (file.exists()) {
                        file.delete();
                        file.createNewFile();
                    }
                    if (com.baidu.swan.c.e.d(byteStream, file)) {
                        callbackHandler.handleSchemeDispatchCallback(optString2, UnitedSchemeUtility.wrapCallbackParamsWithEncode(jSONObject, 0).toString());
                    } else {
                        callbackHandler.handleSchemeDispatchCallback(optString2, UnitedSchemeUtility.wrapCallbackParams(1001, "streamToFile fail").toString());
                    }
                } catch (Exception e) {
                    if (z.DEBUG) {
                        e.printStackTrace();
                    }
                    callbackHandler.handleSchemeDispatchCallback(optString2, UnitedSchemeUtility.wrapCallbackParams(201, e.getMessage()).toString());
                } finally {
                    f.this.gm(valueOf);
                }
            }
        });
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(gp(go), 0));
        return true;
    }

    @Nullable
    private Request j(@Nullable JSONObject jSONObject, @Nullable String str) {
        HttpUrl gn;
        if (jSONObject == null || TextUtils.isEmpty(str) || (gn = gn(jSONObject.optString("url"))) == null) {
            return null;
        }
        String httpUrl = gn.toString();
        if (TextUtils.isEmpty(httpUrl) || !com.baidu.swan.apps.af.a.b.aD("downloadFile", httpUrl)) {
            return null;
        }
        return new Request.Builder().url(httpUrl).tag(str).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public String a(Response response, String str, @Nullable String str2, boolean z) {
        String header = response.header("Content-Type", null);
        String str3 = "";
        if (!TextUtils.isEmpty(header)) {
            str3 = com.baidu.swan.apps.an.l.bsJ.containsKey(header) ? com.baidu.swan.apps.an.l.bsJ.get(header) : str;
        }
        String str4 = String.valueOf(blo.getAndIncrement()) + (TextUtils.isEmpty(str3) ? "" : DefaultConfig.TOKEN_SEPARATOR + str3);
        if (z) {
            return com.baidu.swan.games.f.g.jW("bdfile://tmp" + File.separator + str4);
        }
        return com.baidu.swan.apps.storage.b.A(str2, str4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public String k(@NonNull String str, String str2, boolean z) {
        String jW;
        if (!z) {
            return com.baidu.swan.apps.storage.b.aL(str, str2);
        }
        if (str.endsWith(File.separator)) {
            return null;
        }
        if (str.startsWith(com.baidu.swan.games.f.a.USER_DATA_PATH)) {
            jW = com.baidu.swan.games.f.g.jV(str);
        } else {
            jW = com.baidu.swan.games.f.g.jW(str);
        }
        if (TextUtils.isEmpty(jW)) {
            return null;
        }
        File file = new File(com.baidu.swan.games.f.g.getBasePath() + File.separator + (str.startsWith(com.baidu.swan.games.f.a.USER_DATA_PATH) ? com.baidu.swan.games.f.a.USER_DATA_PATH : "bdfile://tmp").substring("bdfile://".length()));
        if (!file.exists()) {
            file.mkdirs();
        }
        if (!new File(jW).getParentFile().exists()) {
            jW = null;
        }
        return jW;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public String l(@NonNull String str, @Nullable String str2, boolean z) {
        if (!z) {
            return com.baidu.swan.apps.storage.b.aN(str, str2);
        }
        int length = com.baidu.swan.games.f.g.getBasePath().length() + 1;
        if (str.length() > length) {
            return "bdfile://" + str.substring(length);
        }
        return null;
    }
}

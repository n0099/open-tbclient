package com.baidu.swan.apps.scheme.actions;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.util.Log;
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
    private static AtomicLong aRu = new AtomicLong(System.currentTimeMillis());

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
        if (!TextUtils.isEmpty(optString3) && com.baidu.swan.c.a.lb(optString3)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal path");
            return false;
        }
        final String LB = com.baidu.swan.apps.ae.b.LB();
        if (TextUtils.isEmpty(LB)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal appId");
            return false;
        }
        final String fE = fE(LB);
        Request j = j(c, fE);
        if (j == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal request");
            return false;
        }
        final String la = com.baidu.swan.c.a.la(j.url().toString());
        JSONObject optJSONObject = c.optJSONObject(WebSocketRequest.PARAM_KEY_HEADER);
        com.baidu.swan.apps.network.a.b bVar2 = new com.baidu.swan.apps.network.a.b();
        bVar2.n(a(optJSONObject, true));
        final String valueOf = String.valueOf(System.currentTimeMillis());
        this.aDU.put(valueOf, 0L);
        com.baidu.swan.apps.network.a.a aVar = new com.baidu.swan.apps.network.a.a();
        aVar.a(new a.InterfaceC0151a() { // from class: com.baidu.swan.apps.scheme.actions.f.1
            @Override // com.baidu.swan.apps.network.a.a.InterfaceC0151a
            public void K(long j2) {
                callbackHandler.handleSchemeDispatchCallback(optString2, UnitedSchemeUtility.wrapCallbackParams(1001, "download file size > 10MB").toString());
                SwanAppNetworkUtils.a(bVar.Lw().Hc(), fE);
                f.this.fC(valueOf);
            }

            @Override // com.baidu.swan.apps.network.a.a.InterfaceC0151a
            public void e(long j2, long j3) {
                callbackHandler.handleSchemeDispatchCallback(optString2, UnitedSchemeUtility.wrapCallbackParams(1001, "progress callback fail()").toString());
                SwanAppNetworkUtils.a(bVar.Lw().Hc(), fE);
                f.this.fC(valueOf);
            }

            @Override // com.baidu.swan.apps.network.a.a.InterfaceC0151a
            public void b(int i, long j2, long j3) {
                if (System.currentTimeMillis() - f.this.fB(valueOf) > 500) {
                    if (i <= 100) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put(NotificationCompat.CATEGORY_PROGRESS, String.valueOf(i));
                            jSONObject.put("totalBytesWritten", String.valueOf(j2));
                            jSONObject.put("totalBytesExpectedToWrite", String.valueOf(j3));
                            callbackHandler.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParamsWithEncode(jSONObject, 0).toString());
                        } catch (Exception e) {
                            if (z.DEBUG) {
                                e.printStackTrace();
                            }
                        }
                    }
                    f.this.aDU.put(valueOf, Long.valueOf(System.currentTimeMillis()));
                }
            }
        });
        bVar.Lw().Hc().newBuilder().addInterceptor(bVar2).addNetworkInterceptor(aVar).build().newCall(j).enqueue(new Callback() { // from class: com.baidu.swan.apps.scheme.actions.f.2
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                callbackHandler.handleSchemeDispatchCallback(optString2, UnitedSchemeUtility.wrapCallbackParams(1001, iOException.getMessage()).toString());
                f.this.fC(valueOf);
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) {
                String str;
                String a = TextUtils.isEmpty(optString3) ? f.this.a(response, la, LB, isInvokedFromSwanGame) : f.this.h(optString3, LB, isInvokedFromSwanGame);
                if (TextUtils.isEmpty(a)) {
                    callbackHandler.handleSchemeDispatchCallback(optString2, UnitedSchemeUtility.wrapCallbackParams(1001, "realFilePath create fail").toString());
                    return;
                }
                if (z.DEBUG) {
                    Log.d("DownloadFileAction", "the real file path is " + a);
                }
                if (TextUtils.isEmpty(optString3)) {
                    str = f.this.i(a, LB, isInvokedFromSwanGame);
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
                    f.this.fC(valueOf);
                }
            }
        });
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(fF(fE), 0));
        return true;
    }

    @Nullable
    private Request j(@Nullable JSONObject jSONObject, @Nullable String str) {
        HttpUrl fD;
        if (jSONObject == null || TextUtils.isEmpty(str) || (fD = fD(jSONObject.optString("url"))) == null) {
            return null;
        }
        String httpUrl = fD.toString();
        if (TextUtils.isEmpty(httpUrl) || !com.baidu.swan.apps.af.a.b.av("downloadFile", httpUrl)) {
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
            str3 = com.baidu.swan.apps.an.l.aZt.containsKey(header) ? com.baidu.swan.apps.an.l.aZt.get(header) : str;
        }
        String str4 = String.valueOf(aRu.getAndIncrement()) + (TextUtils.isEmpty(str3) ? "" : "." + str3);
        if (z) {
            return com.baidu.swan.games.f.g.jk("bdfile://tmp" + File.separator + str4);
        }
        return com.baidu.swan.apps.storage.b.u(str2, str4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public String h(@NonNull String str, String str2, boolean z) {
        String jk;
        if (!z) {
            return com.baidu.swan.apps.storage.b.aE(str, str2);
        }
        if (str.endsWith(File.separator)) {
            return null;
        }
        if (str.startsWith(com.baidu.swan.games.f.a.USER_DATA_PATH)) {
            jk = com.baidu.swan.games.f.g.jj(str);
        } else {
            jk = com.baidu.swan.games.f.g.jk(str);
        }
        if (TextUtils.isEmpty(jk)) {
            return null;
        }
        File file = new File(com.baidu.swan.games.f.g.getBasePath() + File.separator + (str.startsWith(com.baidu.swan.games.f.a.USER_DATA_PATH) ? com.baidu.swan.games.f.a.USER_DATA_PATH : "bdfile://tmp").substring("bdfile://".length()));
        if (!file.exists()) {
            file.mkdirs();
        }
        if (!new File(jk).getParentFile().exists()) {
            jk = null;
        }
        return jk;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public String i(@NonNull String str, @Nullable String str2, boolean z) {
        if (!z) {
            return com.baidu.swan.apps.storage.b.aG(str, str2);
        }
        int length = com.baidu.swan.games.f.g.getBasePath().length() + 1;
        if (str.length() > length) {
            return "bdfile://" + str.substring(length);
        }
        return null;
    }
}

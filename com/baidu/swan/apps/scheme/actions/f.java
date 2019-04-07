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
import com.baidu.searchbox.v8engine.WebGLImageLoader;
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
    private static AtomicLong aPp = new AtomicLong(System.currentTimeMillis());

    public f(com.baidu.swan.apps.scheme.j jVar) {
        super(jVar, "/swan/downloadFile");
    }

    @Override // com.baidu.swan.apps.network.a, com.baidu.swan.apps.scheme.actions.y
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
        final String optString3 = isInvokedFromSwanGame ? c.optString("filePath") : null;
        if (!TextUtils.isEmpty(optString3) && com.baidu.swan.c.b.kb(optString3)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal path");
            return false;
        }
        final String Jg = com.baidu.swan.apps.ae.b.Jg();
        if (TextUtils.isEmpty(Jg)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal appId");
            return false;
        }
        final String fq = fq(Jg);
        Request k = k(c, fq);
        if (k == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal request");
            return false;
        }
        final String ka = com.baidu.swan.c.b.ka(k.url().toString());
        JSONObject optJSONObject = c.optJSONObject(WebSocketRequest.PARAM_KEY_HEADER);
        com.baidu.swan.apps.network.a.b bVar2 = new com.baidu.swan.apps.network.a.b();
        bVar2.n(a(optJSONObject, true));
        final String valueOf = String.valueOf(System.currentTimeMillis());
        this.aCh.put(valueOf, 0L);
        com.baidu.swan.apps.network.a.a aVar = new com.baidu.swan.apps.network.a.a();
        aVar.a(new a.InterfaceC0146a() { // from class: com.baidu.swan.apps.scheme.actions.f.1
            @Override // com.baidu.swan.apps.network.a.a.InterfaceC0146a
            public void y(long j) {
                callbackHandler.handleSchemeDispatchCallback(optString2, UnitedSchemeUtility.wrapCallbackParams(1001, "download file size > 10MB").toString());
                SwanAppNetworkUtils.a(bVar.Jb().EX(), fq);
                f.this.fo(valueOf);
            }

            @Override // com.baidu.swan.apps.network.a.a.InterfaceC0146a
            public void e(long j, long j2) {
                callbackHandler.handleSchemeDispatchCallback(optString2, UnitedSchemeUtility.wrapCallbackParams(1001, "progress callback fail()").toString());
                SwanAppNetworkUtils.a(bVar.Jb().EX(), fq);
                f.this.fo(valueOf);
            }

            @Override // com.baidu.swan.apps.network.a.a.InterfaceC0146a
            public void b(int i, long j, long j2) {
                if (System.currentTimeMillis() - f.this.fn(valueOf) > 500) {
                    if (i != 100) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put(NotificationCompat.CATEGORY_PROGRESS, String.valueOf(i));
                            jSONObject.put("totalBytesWritten", String.valueOf(j));
                            jSONObject.put("totalBytesExpectedToWrite", String.valueOf(j2));
                            callbackHandler.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParamsWithEncode(jSONObject, 0).toString());
                        } catch (Exception e) {
                            if (y.DEBUG) {
                                e.printStackTrace();
                            }
                        }
                    }
                    f.this.aCh.put(valueOf, Long.valueOf(System.currentTimeMillis()));
                }
            }
        });
        bVar.Jb().EX().newBuilder().addInterceptor(bVar2).addNetworkInterceptor(aVar).build().newCall(k).enqueue(new Callback() { // from class: com.baidu.swan.apps.scheme.actions.f.2
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                callbackHandler.handleSchemeDispatchCallback(optString2, UnitedSchemeUtility.wrapCallbackParams(1001, iOException.getMessage()).toString());
                f.this.fo(valueOf);
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) {
                String str;
                String a = TextUtils.isEmpty(optString3) ? f.this.a(response, ka, Jg, isInvokedFromSwanGame) : f.this.gE(optString3);
                if (TextUtils.isEmpty(a)) {
                    callbackHandler.handleSchemeDispatchCallback(optString2, UnitedSchemeUtility.wrapCallbackParams(1001, "realFilePath create fail").toString());
                    return;
                }
                if (y.DEBUG) {
                    Log.d("DownloadFileAction", "the real file path is " + a);
                }
                if (TextUtils.isEmpty(optString3)) {
                    str = f.this.h(a, Jg, isInvokedFromSwanGame);
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
                    if (y.DEBUG) {
                        e.printStackTrace();
                    }
                    callbackHandler.handleSchemeDispatchCallback(optString2, UnitedSchemeUtility.wrapCallbackParams(201, e.getMessage()).toString());
                } finally {
                    f.this.fo(valueOf);
                }
            }
        });
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(fr(fq), 0));
        return true;
    }

    @Nullable
    private Request k(@Nullable JSONObject jSONObject, @Nullable String str) {
        HttpUrl fp;
        if (jSONObject == null || TextUtils.isEmpty(str) || (fp = fp(jSONObject.optString("url"))) == null) {
            return null;
        }
        String httpUrl = fp.toString();
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
            str3 = com.baidu.swan.apps.an.k.aWo.containsKey(header) ? com.baidu.swan.apps.an.k.aWo.get(header) : str;
        }
        String str4 = String.valueOf(aPp.getAndIncrement()) + (TextUtils.isEmpty(str3) ? "" : "." + str3);
        if (z) {
            return com.baidu.swan.games.f.g.iB("bdfile://tmp" + File.separator + str4);
        }
        return com.baidu.swan.apps.storage.b.u(str2, str4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public String gE(@NonNull String str) {
        String iB;
        if (str.endsWith(File.separator)) {
            return null;
        }
        if (str.startsWith(com.baidu.swan.games.f.a.USER_DATA_PATH)) {
            iB = com.baidu.swan.games.f.g.iA(str);
        } else {
            iB = com.baidu.swan.games.f.g.iB(str);
        }
        if (TextUtils.isEmpty(iB)) {
            return null;
        }
        File file = new File(com.baidu.swan.games.f.g.getBasePath() + File.separator + (str.startsWith(com.baidu.swan.games.f.a.USER_DATA_PATH) ? com.baidu.swan.games.f.a.USER_DATA_PATH : "bdfile://tmp").substring(WebGLImageLoader.BDFILE.length()));
        if (!file.exists()) {
            file.mkdirs();
        }
        if (!new File(iB).getParentFile().exists()) {
            iB = null;
        }
        return iB;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public String h(@NonNull String str, @Nullable String str2, boolean z) {
        if (!z) {
            return com.baidu.swan.apps.storage.b.aD(str, str2);
        }
        int length = com.baidu.swan.games.f.g.getBasePath().length() + 1;
        if (str.length() > length) {
            return WebGLImageLoader.BDFILE + str.substring(length);
        }
        return null;
    }
}

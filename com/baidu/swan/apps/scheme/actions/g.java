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
    private static AtomicLong dGj = new AtomicLong(System.currentTimeMillis());
    private int dGk;

    public g(com.baidu.swan.apps.scheme.j jVar) {
        super(jVar, "/swanAPI/downloadFile");
        this.dGk = 0;
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
        if (!TextUtils.isEmpty(optString4) && com.baidu.swan.c.d.yQ(optString4)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal path");
            return false;
        }
        String aIM = com.baidu.swan.apps.runtime.e.aIM();
        if (TextUtils.isEmpty(aIM)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal appId");
            return false;
        }
        final String kP = com.baidu.swan.apps.api.module.network.c.kP(aIM);
        Request s = s(b2, kP);
        if (s == null) {
            unitedSchemeEntity.result = ip(this.dGk);
            return false;
        }
        final String httpUrl = s.url().toString();
        final String fileExtensionFromUrl = getFileExtensionFromUrl(httpUrl);
        JSONObject optJSONObject = b2.optJSONObject(WebSocketRequest.PARAM_KEY_HEADER);
        com.baidu.swan.apps.network.a.b bVar = new com.baidu.swan.apps.network.a.b();
        HashMap<String, String> e = e(optJSONObject, true);
        String optString5 = b2.optString("__plugin__");
        if (!TextUtils.isEmpty(optString5)) {
            com.baidu.swan.pms.model.h qQ = com.baidu.swan.apps.ac.g.b.qQ(optString5);
            if (e == null) {
                e = new HashMap<>();
            }
            e.put("X-SWAN-HOSTSIGN", com.baidu.swan.apps.ac.g.a.e(qQ));
        }
        bVar.C(e);
        com.baidu.swan.apps.v.f.aAl().aAs();
        final String valueOf = String.valueOf(System.currentTimeMillis());
        this.doL.put(valueOf, 0L);
        com.baidu.swan.apps.network.a.a aVar = new com.baidu.swan.apps.network.a.a();
        aVar.a(new a.InterfaceC0438a() { // from class: com.baidu.swan.apps.scheme.actions.g.1
            @Override // com.baidu.swan.apps.network.a.a.InterfaceC0438a
            public void cA(long j) {
                callbackHandler.handleSchemeDispatchCallback(optString3, UnitedSchemeUtility.wrapCallbackParams(1001, "download file failed because file size exceeds limit").toString());
                SwanAppNetworkUtils.a(com.baidu.swan.a.c.a.bbY().getOkHttpClient(), kP);
                g.this.qa(valueOf);
            }

            @Override // com.baidu.swan.apps.network.a.a.InterfaceC0438a
            public void p(long j, long j2) {
                callbackHandler.handleSchemeDispatchCallback(optString3, UnitedSchemeUtility.wrapCallbackParams(1001, "progress callback fail()").toString());
                SwanAppNetworkUtils.a(com.baidu.swan.a.c.a.bbY().getOkHttpClient(), kP);
                g.this.qa(valueOf);
            }

            @Override // com.baidu.swan.apps.network.a.a.InterfaceC0438a
            public void d(int i, long j, long j2) {
                if (System.currentTimeMillis() - g.this.pZ(valueOf) > 500) {
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
                    g.this.doL.put(valueOf, Long.valueOf(System.currentTimeMillis()));
                }
            }
        });
        final String aLE = com.baidu.swan.apps.statistic.h.aLE();
        final String page = ak.aOr().getPage();
        com.baidu.swan.apps.statistic.h.ab(httpUrl, 0);
        OkHttpClient.Builder bbZ = com.baidu.swan.a.c.a.bbY().bbZ();
        bbZ.addNetworkInterceptor(new com.baidu.swan.apps.network.a.d());
        com.baidu.swan.a.c.a.bbY().a(bbZ);
        bbZ.addInterceptor(bVar).addNetworkInterceptor(aVar).build().newCall(com.baidu.swan.apps.network.a.c.a(s, "downloadFile", b2.optString("__plugin__"))).enqueue(new Callback() { // from class: com.baidu.swan.apps.scheme.actions.g.2
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                com.baidu.swan.apps.v.f.aAl().aAt();
                callbackHandler.handleSchemeDispatchCallback(optString3, UnitedSchemeUtility.wrapCallbackParams(1001, iOException.getMessage()).toString());
                g.this.qa(valueOf);
                if (SwanAppNetworkUtils.isNetworkConnected(null)) {
                    com.baidu.swan.apps.statistic.h.a(0, httpUrl, 0, iOException.getMessage(), aLE, page);
                }
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) {
                String sg;
                String str;
                if (!TextUtils.isEmpty(optString4)) {
                    sg = g.this.sg(optString4);
                } else {
                    sg = g.a(response, fileExtensionFromUrl);
                }
                if (TextUtils.isEmpty(sg)) {
                    callbackHandler.handleSchemeDispatchCallback(optString3, UnitedSchemeUtility.wrapCallbackParams(1001, "realFilePath create fail").toString());
                    return;
                }
                if (aa.DEBUG) {
                    Log.d("DownloadFileAction", "the real file path is " + sg);
                }
                g.this.a(optString2, response.headers());
                if (TextUtils.isEmpty(optString4)) {
                    str = com.baidu.swan.apps.v.f.aAl().azR().tq(sg);
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
                    File file = new File(sg);
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
                    g.this.qa(valueOf);
                    com.baidu.swan.apps.v.f.aAl().aAt();
                }
                if (aa.DEBUG) {
                    Log.d("DownloadFileAction", "onResponse: respCode: " + code + ", url=" + httpUrl + ", msg=" + message);
                }
                com.baidu.swan.apps.statistic.h.a(code, httpUrl, 0, message, aLE, page);
            }
        });
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(kR(kP), 0));
        return true;
    }

    @Nullable
    private Request s(@Nullable JSONObject jSONObject, @Nullable String str) {
        HttpUrl kQ;
        if (jSONObject == null || TextUtils.isEmpty(str) || (kQ = com.baidu.swan.apps.api.module.network.c.kQ(jSONObject.optString("url"))) == null) {
            return null;
        }
        String httpUrl = kQ.toString();
        if (TextUtils.isEmpty(httpUrl)) {
            return null;
        }
        this.dGk = com.baidu.swan.apps.af.a.b.Y("downloadFile", httpUrl, jSONObject.optString("__plugin__"));
        if (this.dGk == 0) {
            return new Request.Builder().url(httpUrl).tag(str).build();
        }
        return null;
    }

    @Nullable
    public static String a(Response response, String str) {
        int lastIndexOf;
        String header = response.header("Content-Disposition", null);
        if (!TextUtils.isEmpty(header)) {
            String tU = com.baidu.swan.apps.ao.r.tU(header);
            if (!TextUtils.isEmpty(tU) && (lastIndexOf = tU.lastIndexOf(".") + 1) > 0) {
                str = tU.substring(lastIndexOf);
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
                    String tS = com.baidu.swan.apps.ao.r.tS(split[i]);
                    if (!TextUtils.isEmpty(tS)) {
                        str = tS;
                        break;
                    }
                    i++;
                }
            }
        }
        return com.baidu.swan.apps.v.f.aAl().azR().tr(dGj.getAndIncrement() + (TextUtils.isEmpty(str) ? "" : "." + str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public String sg(@NonNull String str) {
        File parentFile;
        String str2 = com.baidu.swan.apps.v.f.aAl().azR().to(str);
        if (str2 == null || str2.endsWith(File.separator) || (parentFile = new File(str2).getParentFile()) == null || !parentFile.exists()) {
            return null;
        }
        return str2;
    }

    private String getFileExtensionFromUrl(String str) {
        Uri parse;
        if (TextUtils.isEmpty(str) || (parse = Uri.parse(str)) == null) {
            return null;
        }
        return com.baidu.swan.c.d.yP(parse.getPath());
    }
}

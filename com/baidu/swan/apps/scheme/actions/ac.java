package com.baidu.swan.apps.scheme.actions;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.searchbox.websocket.WebSocketRequest;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ac extends com.baidu.swan.apps.network.a implements com.baidu.swan.apps.network.f {
    public ac(com.baidu.swan.apps.scheme.j jVar) {
        super(jVar, "/swan/uploadFile");
    }

    @Override // com.baidu.swan.apps.network.a, com.baidu.swan.apps.scheme.actions.z
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        if (bVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "swanApp is null");
            return false;
        }
        JSONObject c = c(unitedSchemeEntity, "params");
        if (c == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal params");
            return false;
        }
        String optString = c.optString("onProgressUpdate");
        final String optString2 = c.optString("cb");
        if (TextUtils.isEmpty(optString2)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal resultCallback");
            return false;
        }
        String Rk = com.baidu.swan.apps.ae.b.Rk();
        if (TextUtils.isEmpty(Rk)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal appId");
            return false;
        }
        String go = go(Rk);
        final String valueOf = String.valueOf(System.currentTimeMillis());
        Request a = a(c, optString, go, valueOf, bVar, callbackHandler);
        if (a == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal request");
            gm(valueOf);
            return false;
        }
        JSONObject optJSONObject = c.optJSONObject(WebSocketRequest.PARAM_KEY_HEADER);
        com.baidu.swan.apps.network.a.b bVar2 = new com.baidu.swan.apps.network.a.b();
        bVar2.n(b(optJSONObject, true));
        bVar.Rf().a(a, bVar2, new Callback() { // from class: com.baidu.swan.apps.scheme.actions.ac.1
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                callbackHandler.handleSchemeDispatchCallback(optString2, UnitedSchemeUtility.wrapCallbackParams(1001, iOException.getMessage()).toString());
                ac.this.gm(valueOf);
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("statusCode", response.code());
                    ac.this.a(jSONObject, response.body());
                    callbackHandler.handleSchemeDispatchCallback(optString2, UnitedSchemeUtility.wrapCallbackParamsWithEncode(jSONObject, 0).toString());
                } catch (Exception e) {
                    if (z.DEBUG) {
                        e.printStackTrace();
                    }
                    callbackHandler.handleSchemeDispatchCallback(optString2, UnitedSchemeUtility.wrapCallbackParams(201, e.getMessage()).toString());
                } finally {
                    ac.this.gm(valueOf);
                }
            }
        });
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(gp(go), 0));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull JSONObject jSONObject, @Nullable ResponseBody responseBody) throws IOException, JSONException {
        if (responseBody != null) {
            String string = responseBody.string();
            if (!TextUtils.isEmpty(string)) {
                try {
                    JSONObject jSONObject2 = new JSONObject(string);
                    if (jSONObject2 != null) {
                        jSONObject.put("data", jSONObject2);
                    }
                } catch (JSONException e) {
                    jSONObject.put("data", string);
                } catch (Throwable th) {
                    if (0 != 0) {
                        jSONObject.put("data", (Object) null);
                    }
                    throw th;
                }
            }
        }
    }

    @Nullable
    private Request a(@Nullable JSONObject jSONObject, @Nullable final String str, @Nullable String str2, @Nullable final String str3, @Nullable com.baidu.swan.apps.ae.b bVar, @Nullable final CallbackHandler callbackHandler) {
        HttpUrl gn;
        if (jSONObject == null || (gn = gn(jSONObject.optString("url"))) == null) {
            return null;
        }
        String httpUrl = gn.toString();
        if (TextUtils.isEmpty(httpUrl) || !com.baidu.swan.apps.af.a.b.aD("uploadFile", httpUrl)) {
            return null;
        }
        String optString = jSONObject.optString("filePath", "");
        if (TextUtils.isEmpty(optString) || com.baidu.swan.c.a.lN(optString)) {
            return null;
        }
        boolean isInvokedFromSwanGame = UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler);
        String b = com.baidu.swan.apps.storage.b.b(optString, bVar);
        if (isInvokedFromSwanGame) {
            if (!optString.startsWith("bdfile://")) {
                String jZ = com.baidu.swan.games.f.g.jZ(optString);
                String Lm = com.baidu.swan.apps.w.e.LD().Lm();
                if (Lm.endsWith(File.separator)) {
                    Lm = Lm.substring(0, Lm.length() - 1);
                }
                b = Lm + jZ.substring("bdfile://code".length());
            } else if (optString.startsWith(com.baidu.swan.games.f.a.USER_DATA_PATH)) {
                b = com.baidu.swan.games.f.g.jV(optString);
            } else if (optString.startsWith("bdfile://tmp")) {
                b = com.baidu.swan.games.f.g.jW(optString);
            }
        }
        if (TextUtils.isEmpty(b)) {
            return null;
        }
        File file = new File(b);
        if (!file.exists() || !file.isFile()) {
            return null;
        }
        final long length = file.length();
        if (length > 26214400) {
            return null;
        }
        String optString2 = jSONObject.optString("name", "");
        if (TextUtils.isEmpty(optString2)) {
            return null;
        }
        if (jSONObject.has("formData") && !(jSONObject.opt("formData") instanceof JSONObject)) {
            return null;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("formData");
        this.aYp.put(str3, 0L);
        com.baidu.swan.apps.network.c cVar = new com.baidu.swan.apps.network.c(file, "multipart/form-data", new com.baidu.swan.apps.network.b.a() { // from class: com.baidu.swan.apps.scheme.actions.ac.2
            @Override // com.baidu.swan.apps.network.b.a
            public void ae(long j) {
                ac.this.a(length, j, str, str3, callbackHandler);
            }
        });
        MultipartBody.Builder type = new MultipartBody.Builder().setType(MultipartBody.FORM);
        a(type, optJSONObject);
        a(type, optString2, file.getName(), cVar);
        return new Request.Builder().url(httpUrl).tag(str2).post(type.build()).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, long j2, String str, String str2, CallbackHandler callbackHandler) {
        if (j > 0 && j2 <= j && j2 != 0 && !TextUtils.isEmpty(str) && callbackHandler != null) {
            int floor = (int) Math.floor((100 * j2) / j);
            if (System.currentTimeMillis() - gl(str2) > 500 || floor == 100) {
                if (floor <= 100) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("progress", String.valueOf(floor));
                        jSONObject.put("totalBytesSent", String.valueOf(j2));
                        jSONObject.put("totalBytesExpectedToSend", String.valueOf(j));
                        callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParamsWithEncode(jSONObject, 0).toString());
                    } catch (Exception e) {
                        if (DEBUG) {
                            e.printStackTrace();
                        }
                    }
                }
                this.aYp.put(str2, Long.valueOf(System.currentTimeMillis()));
            }
        }
    }

    private void a(MultipartBody.Builder builder, String str, String str2, com.baidu.swan.apps.network.c cVar) {
        if (builder != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && cVar != null) {
            builder.addFormDataPart(str, str2, cVar);
        }
    }

    public static void a(MultipartBody.Builder builder, JSONObject jSONObject) {
        if (builder != null && jSONObject != null && jSONObject.length() >= 1) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (!TextUtils.isEmpty(next)) {
                    String optString = jSONObject.optString(next);
                    if (!TextUtils.isEmpty(optString)) {
                        builder.addFormDataPart(next, optString);
                    }
                }
            }
        }
    }
}

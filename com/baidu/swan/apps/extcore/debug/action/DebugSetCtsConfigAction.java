package com.baidu.swan.apps.extcore.debug.action;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.scheme.actions.z;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.apps.storage.b.f;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class DebugSetCtsConfigAction extends z {
    private static final String avY = c.class.getSimpleName();
    private static final String avZ = String.format("?swanjs_version=%s", com.baidu.swan.apps.swancore.b.dS(0));
    private static final String awa = "http://sut.baidu-int.com/yts/sut/preload" + avZ + "&type=1";
    private static final String awb = "http://sut.baidu-int.com/yts/sut/preload" + avZ + "&type=2";
    private boolean awc;
    private boolean awd;
    private boolean awe;
    private String awf;
    private String awg;

    /* loaded from: classes2.dex */
    public enum FrameType {
        MASTER,
        SLAVE
    }

    public DebugSetCtsConfigAction(j jVar) {
        super(jVar, "/swan/debug/setCtsConfig");
        this.awc = false;
        this.awd = false;
        this.awe = false;
    }

    @Override // com.baidu.swan.apps.scheme.actions.z
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        if (!DEBUG) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(302);
            return false;
        }
        JSONObject c = c(unitedSchemeEntity, "params");
        if (c == null) {
            com.baidu.swan.apps.console.c.e(avY, "params is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        String optString = c.optString("cb");
        if (!c.has("loadCts")) {
            com.baidu.swan.apps.console.c.e(avY, "loadCts is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        if (c.optInt("loadCts") == 1) {
            JSONObject jSONObject = new JSONObject();
            aY(context);
            a(bVar, this.awf, callbackHandler, optString, jSONObject, FrameType.MASTER);
            a(bVar, this.awg, callbackHandler, optString, jSONObject, FrameType.SLAVE);
            this.awe = true;
        } else {
            this.awe = false;
            com.baidu.swan.apps.ac.a.a.bI(false);
            callbackHandler.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(0).toString());
        }
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(0);
        return true;
    }

    private void aY(Context context) {
        if (com.baidu.swan.apps.an.c.U(context, "aiapps/debug_cts_url.json")) {
            try {
                JSONObject jSONObject = new JSONObject(com.baidu.swan.apps.an.c.V(context, "aiapps/debug_cts_url.json"));
                this.awf = jSONObject.optString("master");
                this.awg = jSONObject.optString("slave");
                if (TextUtils.isEmpty(this.awf)) {
                    this.awf = awa;
                }
                if (TextUtils.isEmpty(this.awg)) {
                    this.awg = awb;
                    return;
                }
                return;
            } catch (JSONException e) {
                e.printStackTrace();
                this.awf = awa;
                this.awg = awb;
                return;
            }
        }
        this.awf = awa;
        this.awg = awb;
    }

    private void a(com.baidu.swan.apps.ae.b bVar, String str, final CallbackHandler callbackHandler, final String str2, final JSONObject jSONObject, final FrameType frameType) {
        bVar.Lw().a(new Request.Builder().url(str).get().build(), new Callback() { // from class: com.baidu.swan.apps.extcore.debug.action.DebugSetCtsConfigAction.1
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                if (DebugSetCtsConfigAction.DEBUG) {
                    Log.d("SwanAppAction", "onFailure: " + iOException.getMessage());
                }
                callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(501, "网络异常").toString());
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws IOException {
                if (response.code() == 200 && response.body() != null) {
                    try {
                        JSONObject jSONObject2 = new JSONObject(response.body().string());
                        if (jSONObject2.has("code") && jSONObject2.optInt("code") == 0) {
                            JSONArray optJSONArray = jSONObject2.optJSONArray("data");
                            switch (AnonymousClass2.awk[frameType.ordinal()]) {
                                case 1:
                                    jSONObject.put("master", optJSONArray);
                                    DebugSetCtsConfigAction.this.awc = true;
                                    DebugSetCtsConfigAction.this.a(jSONObject, callbackHandler, str2);
                                    break;
                                case 2:
                                    jSONObject.put("slave", optJSONArray);
                                    DebugSetCtsConfigAction.this.awd = true;
                                    DebugSetCtsConfigAction.this.a(jSONObject, callbackHandler, str2);
                                    break;
                                default:
                                    com.baidu.swan.apps.console.c.e(DebugSetCtsConfigAction.avY, "error type, get cts url failed");
                                    break;
                            }
                        } else {
                            callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
                        }
                        return;
                    } catch (JSONException e) {
                        e.printStackTrace();
                        callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
                        return;
                    }
                }
                callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
            }
        });
    }

    /* renamed from: com.baidu.swan.apps.extcore.debug.action.DebugSetCtsConfigAction$2  reason: invalid class name */
    /* loaded from: classes2.dex */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] awk = new int[FrameType.values().length];

        static {
            try {
                awk[FrameType.MASTER.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                awk[FrameType.SLAVE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(JSONObject jSONObject, CallbackHandler callbackHandler, String str) {
        if (this.awc && this.awd && this.awe) {
            com.baidu.swan.apps.ac.a.a.bI(true);
            f.Ni().putString("ctsUrl", jSONObject.toString());
            callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(0).toString());
            this.awd = false;
            this.awc = false;
        }
    }
}

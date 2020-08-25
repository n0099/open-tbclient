package com.baidu.n.b;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeAbsDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.UnitedSchemeStatisticUtil;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.runtime.e;
import com.meizu.cloud.pushsdk.platform.message.BasicPushStatus;
import java.io.File;
import java.net.URI;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a extends UnitedSchemeBaseDispatcher {
    private static final boolean DEBUG = b.DEBUG;
    private static final String TAG = a.class.getSimpleName();

    @Override // com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher
    public String getDispatcherName() {
        return "svgaAnimView";
    }

    @Override // com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher
    public boolean invoke(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        if (DEBUG) {
            Log.i(TAG, String.format(Locale.getDefault(), "entity(%s)", unitedSchemeEntity.getUri()));
        }
        c.d(TAG, "start UnitedSchemeSvgaDispatcher");
        String path = unitedSchemeEntity.getPath(false);
        if (TextUtils.isEmpty(path)) {
            if (!unitedSchemeEntity.isOnlyVerify()) {
                UnitedSchemeStatisticUtil.doUBCForInvalidScheme(unitedSchemeEntity.getUri(), "no action");
            }
            if (DEBUG) {
                Log.w(TAG, "Uri action is null");
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(201));
            return false;
        } else if (unitedSchemeEntity.isOnlyVerify()) {
            return true;
        } else {
            char c = 65535;
            switch (path.hashCode()) {
                case -1183792455:
                    if (path.equals("insert")) {
                        c = 0;
                        break;
                    }
                    break;
                case -934610812:
                    if (path.equals("remove")) {
                        c = 2;
                        break;
                    }
                    break;
                case -838846263:
                    if (path.equals(IMTrack.DbBuilder.ACTION_UPDATE)) {
                        c = 1;
                        break;
                    }
                    break;
                case -735858614:
                    if (path.equals("fileInfo")) {
                        c = 3;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    b(context, unitedSchemeEntity, callbackHandler);
                    break;
                case 1:
                    c(context, unitedSchemeEntity, callbackHandler);
                    break;
                case 2:
                    d(context, unitedSchemeEntity, callbackHandler);
                    break;
                case 3:
                    e(context, unitedSchemeEntity, callbackHandler);
                    break;
                default:
                    if (DEBUG) {
                        Log.w(TAG, "action " + path + " not support");
                    }
                    unitedSchemeEntity.result = UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(201));
                    return false;
            }
            return true;
        }
    }

    private boolean b(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        com.baidu.n.a.b a = a(unitedSchemeEntity);
        if (a == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            c.e(TAG, "model is null");
            return false;
        } else if (!a.XN()) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            c.e(TAG, "parse insert params, but invalid");
            return false;
        } else {
            com.baidu.swan.apps.component.b.c acZ = new com.baidu.n.a.a(context, a).acZ();
            boolean isSuccess = acZ.isSuccess();
            c.i(TAG, "insert anim view success = " + isSuccess);
            if (isSuccess) {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            } else {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, acZ.msg);
                c.e(TAG, "insert anim view, but failure: " + acZ.msg);
            }
            return isSuccess;
        }
    }

    private boolean c(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        com.baidu.n.a.b a = a(unitedSchemeEntity);
        if (a == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            c.e(TAG, "model is null");
            return false;
        } else if (!a.isValid()) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            c.e(TAG, "parse update params, but invalid");
            return false;
        } else {
            com.baidu.n.a.a aVar = (com.baidu.n.a.a) com.baidu.swan.apps.component.container.a.d(a);
            if (aVar == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                c.e(TAG, "get component is null");
                return false;
            }
            com.baidu.swan.apps.component.b.c a2 = aVar.a((com.baidu.n.a.a) a);
            boolean isSuccess = a2.isSuccess();
            c.i(TAG, "update anim view success = " + isSuccess);
            if (isSuccess) {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                return isSuccess;
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, a2.msg);
            c.e(TAG, "update anim view, but failure: " + a2.msg);
            return isSuccess;
        }
    }

    private boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        com.baidu.n.a.b a = a(unitedSchemeEntity);
        if (a == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            c.e(TAG, "model is null");
            return false;
        } else if (!a.isValid()) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            c.e(TAG, "parse remove params, but invalid");
            return false;
        } else {
            com.baidu.n.a.a aVar = (com.baidu.n.a.a) com.baidu.swan.apps.component.container.a.d(a);
            if (aVar == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                c.e(TAG, "get component is null");
                return false;
            }
            com.baidu.swan.apps.component.b.c adb = aVar.adb();
            boolean isSuccess = adb.isSuccess();
            c.i(TAG, "remove anim view success = " + isSuccess);
            if (isSuccess) {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                return isSuccess;
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, adb.msg);
            c.e(TAG, "remove anim view, but failure: " + adb.msg);
            return isSuccess;
        }
    }

    private boolean e(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        com.baidu.n.a.b a = a(unitedSchemeEntity);
        if (a == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            c.e(TAG, "model is null");
            return false;
        } else if (!a.isValid()) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            c.e(TAG, "parse remove params, but invalid");
            return false;
        } else {
            boolean a2 = a(a.path, e.azI());
            String str = null;
            try {
                JSONObject jSONObject = new JSONObject(unitedSchemeEntity.getParam("params"));
                if (jSONObject != null) {
                    str = jSONObject.optString("cb");
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("status", a2 ? BasicPushStatus.SUCCESS_CODE : "404");
                jSONObject2.put("path", a.path);
                jSONObject2.put("msg", a2 ? "file found" : " file not found");
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            JSONObject wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(jSONObject2, 0);
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            callbackHandler.handleSchemeDispatchCallback(str, wrapCallbackParams.toString());
            c.e(TAG, a.path + (a2 ? "file found" : " file not found"));
            return true;
        }
    }

    private com.baidu.n.a.b a(UnitedSchemeEntity unitedSchemeEntity) {
        com.baidu.n.a.b bVar = null;
        if (unitedSchemeEntity != null) {
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                c.e(TAG, "params is null");
            } else {
                bVar = new com.baidu.n.a.b();
                try {
                    bVar.parseFromJson(optParamsAsJo);
                } catch (JSONException e) {
                    e.printStackTrace();
                    c.e(TAG, "model parse exception:", e);
                }
            }
        }
        return bVar;
    }

    private boolean a(String str, e eVar) {
        String a;
        if (TextUtils.isEmpty(str) || eVar == null) {
            return false;
        }
        try {
            if ("bdfile".equalsIgnoreCase(URI.create(str).getScheme())) {
                a = com.baidu.swan.apps.storage.b.cn(str, eVar.id);
            } else {
                a = com.baidu.swan.apps.storage.b.a(str, eVar, eVar.getVersion());
            }
            if (DEBUG) {
                Log.e(TAG, "checkBdFileExits file real path:" + a);
            }
            if (TextUtils.isEmpty(a)) {
                return false;
            }
            File file = new File(a);
            return file.exists() && file.isFile();
        } catch (Exception e) {
            if (DEBUG) {
                Log.e(TAG, "checkBdFileExits" + e.getMessage());
                return false;
            }
            return false;
        }
    }

    @Override // com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher
    public Class<? extends UnitedSchemeAbsDispatcher> getSubDispatcher(String str) {
        return null;
    }
}

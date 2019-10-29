package com.baidu.swan.apps.i.a;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.ae.b;
import com.baidu.swan.apps.scheme.actions.z;
import com.baidu.swan.apps.scheme.j;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends z {
    private String callback;

    public a(j jVar) {
        super(jVar, "/swan/setPhoneContact");
    }

    @Override // com.baidu.swan.apps.scheme.actions.z
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, b bVar) {
        if (context == null || callbackHandler == null || bVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        if (DEBUG) {
            Log.d("SetPhoneContactAction", "handle params:" + optParamsAsJo);
        }
        String optString = optParamsAsJo.optString("action");
        if (TextUtils.isEmpty(optString)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        com.baidu.swan.apps.i.a S = com.baidu.swan.apps.i.a.S(optParamsAsJo);
        if (!S.isValid()) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        this.callback = optParamsAsJo.optString("cb");
        char c = 65535;
        switch (optString.hashCode()) {
            case -1183792455:
                if (optString.equals("insert")) {
                    c = 0;
                    break;
                }
                break;
            case 3108362:
                if (optString.equals("edit")) {
                    c = 1;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                a(context, S, callbackHandler);
                return true;
            case 1:
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                b(context, S, callbackHandler);
                return true;
            default:
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                return false;
        }
    }

    private void a(Context context, com.baidu.swan.apps.i.a aVar, CallbackHandler callbackHandler) {
        Intent intent = new Intent("android.intent.action.INSERT", Uri.withAppendedPath(Uri.parse("content://com.android.contacts"), "contacts"));
        intent.putExtra("name", aVar.getDisplayName());
        intent.putExtra(NotificationCompat.CATEGORY_EMAIL, aVar.email);
        intent.putParcelableArrayListExtra("data", a(aVar));
        intent.setFlags(268435456);
        a(context, intent, callbackHandler);
    }

    private void b(Context context, com.baidu.swan.apps.i.a aVar, CallbackHandler callbackHandler) {
        Intent intent = new Intent("android.intent.action.INSERT_OR_EDIT");
        intent.setType("vnd.android.cursor.item/contact");
        intent.putExtra("name", aVar.getDisplayName());
        intent.putExtra(NotificationCompat.CATEGORY_EMAIL, aVar.email);
        intent.putParcelableArrayListExtra("data", a(aVar));
        intent.setFlags(268435456);
        a(context, intent, callbackHandler);
    }

    private void a(Context context, Intent intent, CallbackHandler callbackHandler) {
        try {
            context.startActivity(intent);
            if (!TextUtils.isEmpty(this.callback)) {
                callbackHandler.handleSchemeDispatchCallback(this.callback, UnitedSchemeUtility.wrapCallbackParams(0, "ok").toString());
            }
        } catch (Exception e) {
            if (DEBUG) {
                Log.d("SetPhoneContactAction", "startContactActivity:" + e.toString());
            }
            if (!TextUtils.isEmpty(this.callback)) {
                callbackHandler.handleSchemeDispatchCallback(this.callback, UnitedSchemeUtility.wrapCallbackParams(201, "fail startactivity exception").toString());
            }
        }
    }

    private ArrayList<ContentValues> a(com.baidu.swan.apps.i.a aVar) {
        ArrayList<ContentValues> arrayList = new ArrayList<>(16);
        arrayList.add(aVar.Dw());
        arrayList.add(aVar.Dx());
        arrayList.add(aVar.Dy());
        arrayList.add(aVar.Dz());
        arrayList.add(aVar.DA());
        arrayList.add(aVar.DB());
        arrayList.add(aVar.Du());
        arrayList.add(aVar.DC());
        arrayList.add(aVar.DE());
        arrayList.add(aVar.Dv());
        arrayList.add(aVar.DD());
        arrayList.add(aVar.DF());
        arrayList.add(aVar.DG());
        arrayList.add(aVar.DH());
        return arrayList;
    }
}

package com.baidu.swan.bdprivate.c.a;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.os.Build;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.down.request.db.DownloadDataConstants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.af.c;
import com.baidu.swan.apps.scheme.actions.ab;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.apps.setting.oauth.a.b;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class g extends ab {
    public g(j jVar) {
        super(jVar, "/swanAPI/getPhoneContacts");
    }

    @Override // com.baidu.swan.apps.scheme.actions.ab
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        if (eVar == null) {
            com.baidu.swan.apps.console.c.e("ReadContacts", "swanApp is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "swanApp is null");
            return false;
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            com.baidu.swan.apps.console.c.e("ReadContacts", "params is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "params is null");
            return false;
        }
        com.baidu.swan.apps.console.c.i("ReadContacts", "params is:" + optParamsAsJo.toString());
        if (!(context instanceof Activity)) {
            com.baidu.swan.apps.console.c.e("ReadContacts", "the context is error");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "the context is error");
            return false;
        }
        final Activity activity = (Activity) context;
        final String optString = optParamsAsJo.optString("cb");
        if (TextUtils.isEmpty(optString)) {
            com.baidu.swan.apps.console.c.e("ReadContacts", "the callback is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "the callback is null");
            return false;
        }
        eVar.acP().b(activity, "mapp_i_read_contacts", new com.baidu.swan.apps.as.d.b<com.baidu.swan.apps.setting.oauth.h<b.d>>() { // from class: com.baidu.swan.bdprivate.c.a.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.as.d.b
            /* renamed from: a */
            public void D(com.baidu.swan.apps.setting.oauth.h<b.d> hVar) {
                if (!com.baidu.swan.apps.setting.oauth.c.b(hVar)) {
                    com.baidu.swan.apps.setting.oauth.c.a(hVar, callbackHandler, optString);
                    return;
                }
                com.baidu.swan.apps.console.c.i("ReadContacts", "request authorize success");
                g.this.a(activity, callbackHandler, optString);
            }
        });
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final Activity activity, final CallbackHandler callbackHandler, final String str) {
        if (Build.VERSION.SDK_INT < 23) {
            if (DEBUG) {
                Log.i("ReadContactsAction", "don't need to request permission");
            }
            com.baidu.swan.apps.console.c.i("ReadContacts", "don't need to request permission");
            b(activity, callbackHandler, str);
        } else if (aiy()) {
            if (DEBUG) {
                Log.i("ReadContactsAction", "permission has granted");
            }
            com.baidu.swan.apps.console.c.i("ReadContacts", "permission has granted");
            b(activity, callbackHandler, str);
        } else if (ActivityCompat.shouldShowRequestPermissionRationale(activity, "android.permission.READ_CONTACTS")) {
            com.baidu.swan.apps.console.c.e("ReadContacts", "has requested permission but denied");
            a(callbackHandler, str, 200402, "has requested permission but denied");
        } else {
            String[] strArr = {"android.permission.READ_CONTACTS"};
            com.baidu.swan.apps.y.f WS = com.baidu.swan.apps.y.f.WS();
            if (WS == null) {
                if (DEBUG) {
                    Log.e("ReadContactsAction", "SwanAppController is null");
                }
                com.baidu.swan.apps.console.c.e("ReadContacts", "request permission denied");
                a(callbackHandler, str, 200402, "request permission denied");
                return;
            }
            WS.a(666, strArr, new c.a() { // from class: com.baidu.swan.bdprivate.c.a.g.2
                @Override // com.baidu.swan.apps.af.c.a
                public void onRequestPermissionsResult(int i, @NonNull String[] strArr2, @NonNull int[] iArr) {
                    if (i != 666 || !TextUtils.equals(strArr2[0], "android.permission.READ_CONTACTS") || iArr.length <= 0 || iArr[0] != 0) {
                        if (g.DEBUG) {
                            Log.e("ReadContactsAction", "dynamic request permission denied");
                        }
                        com.baidu.swan.apps.console.c.e("ReadContacts", "dynamic request permission denied");
                        g.this.a(callbackHandler, str, 200402, "dynamic request permission denied");
                        return;
                    }
                    if (g.DEBUG) {
                        Log.i("ReadContactsAction", "dynamic request permission success");
                    }
                    com.baidu.swan.apps.console.c.i("ReadContacts", "dynamic request permission success");
                    g.this.b(activity, callbackHandler, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Activity activity, CallbackHandler callbackHandler, String str) {
        try {
            JSONObject di = di(activity);
            if (DEBUG) {
                Log.i("ReadContactsAction", "read contacts:" + di.toString());
            }
            com.baidu.swan.apps.console.c.e("ReadContacts", "read contacts:" + di.toString());
            a(callbackHandler, str, 0, di);
        } catch (JSONException e) {
            if (DEBUG) {
                Log.e("ReadContactsAction", "read contacts error caused by JsonException");
                e.printStackTrace();
            }
            com.baidu.swan.apps.console.c.e("ReadContacts", "read contacts error caused by JsonException");
            a(callbackHandler, str, 1001, "json parse error");
        }
    }

    private void a(CallbackHandler callbackHandler, String str, int i, JSONObject jSONObject) {
        callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(jSONObject, i).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CallbackHandler callbackHandler, String str, int i, String str2) {
        callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(i, str2).toString());
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private JSONObject di(Context context) throws JSONException {
        char c;
        JSONArray jSONArray = null;
        JSONArray jSONArray2 = new JSONArray();
        Cursor query = context.getContentResolver().query(ContactsContract.Data.CONTENT_URI, null, null, null, "raw_contact_id");
        if (query != null && query.getCount() > 0) {
            JSONObject jSONObject = null;
            int i = -1;
            while (query.moveToNext()) {
                int i2 = query.getInt(query.getColumnIndex("raw_contact_id"));
                if (i != i2) {
                    if (jSONObject != null && jSONArray != null && jSONArray.length() > 0) {
                        jSONArray2.put(jSONObject);
                    }
                    jSONObject = new JSONObject();
                    jSONArray = new JSONArray();
                    i = i2;
                }
                if (jSONObject != null) {
                    String string = query.getString(query.getColumnIndex(DownloadDataConstants.Columns.COLUMN_MIME_TYPE));
                    switch (string.hashCode()) {
                        case -1079224304:
                            if (string.equals("vnd.android.cursor.item/name")) {
                                c = 0;
                                break;
                            }
                            c = 65535;
                            break;
                        case -1079210633:
                            if (string.equals("vnd.android.cursor.item/note")) {
                                c = 1;
                                break;
                            }
                            c = 65535;
                            break;
                        case 684173810:
                            if (string.equals("vnd.android.cursor.item/phone_v2")) {
                                c = 2;
                                break;
                            }
                            c = 65535;
                            break;
                        case 2034973555:
                            if (string.equals("vnd.android.cursor.item/nickname")) {
                                c = 3;
                                break;
                            }
                            c = 65535;
                            break;
                        default:
                            c = 65535;
                            break;
                    }
                    switch (c) {
                        case 0:
                            String string2 = query.getString(query.getColumnIndex("data1"));
                            String string3 = query.getString(query.getColumnIndex("data3"));
                            String string4 = query.getString(query.getColumnIndex("data2"));
                            String string5 = query.getString(query.getColumnIndex("data5"));
                            if (string2 == null) {
                                string2 = "";
                            }
                            jSONObject.put("name", string2);
                            jSONObject.put("lastName", string3 != null ? string3 : "");
                            jSONObject.put("firstName", string4 != null ? string4 : "");
                            jSONObject.put("middleName", string5 != null ? string5 : "");
                            continue;
                        case 1:
                            String string6 = query.getString(query.getColumnIndex("data1"));
                            if (string6 == null) {
                                string6 = "";
                            }
                            jSONObject.put("remark", string6);
                            continue;
                        case 2:
                            String string7 = query.getString(query.getColumnIndex("data1"));
                            if (!TextUtils.isEmpty(string7) && jSONArray != null) {
                                jSONArray.put(string7);
                            }
                            jSONObject.put("phoneNumbers", jSONArray);
                            continue;
                        case 3:
                            jSONObject.put("nickName", query.getString(query.getColumnIndex("data1")));
                            continue;
                    }
                }
            }
            if (jSONObject != null && jSONArray != null && jSONArray.length() > 0) {
                jSONArray2.put(jSONObject);
            }
            if (query != null) {
                query.close();
            }
        }
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("contacts", jSONArray2);
        return jSONObject2;
    }

    public boolean aiy() {
        if (com.baidu.swan.apps.as.a.hasMarshMallow()) {
            return Build.VERSION.SDK_INT >= 23 && AppRuntime.getAppContext().checkSelfPermission("android.permission.READ_CONTACTS") == 0;
        }
        return true;
    }
}

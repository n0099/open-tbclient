package com.baidu.swan.bdprivate.extensions.a;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.down.request.db.DownloadDataConstants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.scheme.actions.aa;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.apps.setting.oauth.a.b;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class h extends aa {
    public h(j jVar) {
        super(jVar, "/swanAPI/getPhoneContacts");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
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
        eVar.aMx().b(activity, "mapp_i_read_contacts", new com.baidu.swan.apps.ao.e.b<com.baidu.swan.apps.setting.oauth.h<b.d>>() { // from class: com.baidu.swan.bdprivate.extensions.a.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ao.e.b
            /* renamed from: a */
            public void L(com.baidu.swan.apps.setting.oauth.h<b.d> hVar) {
                if (!com.baidu.swan.apps.setting.oauth.c.b(hVar)) {
                    com.baidu.swan.apps.setting.oauth.c.a(hVar, callbackHandler, optString);
                    return;
                }
                com.baidu.swan.apps.console.c.i("ReadContacts", "request authorize success");
                h.this.a(activity, callbackHandler, optString);
            }
        });
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final Activity activity, final CallbackHandler callbackHandler, final String str) {
        com.baidu.swan.apps.ab.a.a("android.permission.READ_CONTACTS", new String[]{"android.permission.READ_CONTACTS"}, 666, activity, new com.baidu.swan.apps.ab.b() { // from class: com.baidu.swan.bdprivate.extensions.a.h.2
            @Override // com.baidu.swan.apps.ab.b
            public void kN(String str2) {
                h.this.b(activity, callbackHandler, str);
                com.baidu.swan.apps.console.c.e("ReadContacts", str2 + "");
            }

            @Override // com.baidu.swan.apps.ab.b
            public void ah(int i, String str2) {
                com.baidu.swan.apps.setting.oauth.c.a(10005, callbackHandler, str);
                com.baidu.swan.apps.console.c.e("ReadContacts", str2 + "");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Activity activity, CallbackHandler callbackHandler, String str) {
        try {
            JSONObject en = en(activity);
            if (DEBUG) {
                Log.i("ReadContactsAction", "read contacts:" + en.toString());
            }
            com.baidu.swan.apps.console.c.e("ReadContacts", "read contacts:" + en.toString());
            a(callbackHandler, str, 0, en);
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

    private void a(CallbackHandler callbackHandler, String str, int i, String str2) {
        callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(i, str2).toString());
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private JSONObject en(Context context) throws JSONException {
        JSONArray jSONArray;
        char c;
        JSONArray jSONArray2 = new JSONArray();
        Cursor query = context.getContentResolver().query(ContactsContract.Data.CONTENT_URI, null, null, null, "raw_contact_id");
        if (query != null && query.getCount() > 0) {
            JSONArray jSONArray3 = null;
            JSONObject jSONObject = null;
            int i = -1;
            while (query.moveToNext()) {
                int i2 = query.getInt(query.getColumnIndex("raw_contact_id"));
                if (i != i2) {
                    if (jSONObject != null && jSONArray3 != null && jSONArray3.length() > 0) {
                        jSONArray2.put(jSONObject);
                    }
                    jSONObject = new JSONObject();
                    jSONArray = new JSONArray();
                    i = i2;
                } else {
                    jSONArray = jSONArray3;
                }
                if (jSONObject == null) {
                    jSONArray3 = jSONArray;
                } else {
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
                            break;
                        case 1:
                            String string6 = query.getString(query.getColumnIndex("data1"));
                            if (string6 == null) {
                                string6 = "";
                            }
                            jSONObject.put("remark", string6);
                            break;
                        case 2:
                            String string7 = query.getString(query.getColumnIndex("data1"));
                            if (!TextUtils.isEmpty(string7) && jSONArray != null) {
                                jSONArray.put(string7);
                            }
                            jSONObject.put("phoneNumbers", jSONArray);
                            break;
                        case 3:
                            jSONObject.put("nickName", query.getString(query.getColumnIndex("data1")));
                            break;
                    }
                    jSONArray3 = jSONArray;
                }
            }
            if (jSONObject != null && jSONArray3 != null && jSONArray3.length() > 0) {
                jSONArray2.put(jSONObject);
            }
            com.baidu.swan.apps.media.image.a.closeSafely(query);
        }
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("contacts", jSONArray2);
        return jSONObject2;
    }
}

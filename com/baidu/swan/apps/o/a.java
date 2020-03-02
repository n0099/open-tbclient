package com.baidu.swan.apps.o;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.support.annotation.AnyThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.as.m;
import com.baidu.swan.apps.database.subscribe.SwanAppSubscribeMsgProvider;
import com.baidu.swan.apps.o.c;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.scheme.actions.ab;
import com.baidu.swan.apps.scheme.j;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a extends ab {

    /* renamed from: com.baidu.swan.apps.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0269a {
        void aG(@Nullable String str, @Nullable String str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public interface b {
        void onResult(int i);
    }

    public a(j jVar) {
        super(jVar, "/swanAPI/getFormId");
    }

    @Override // com.baidu.swan.apps.scheme.actions.ab
    public boolean a(final Context context, UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final e eVar) {
        if (unitedSchemeEntity == null) {
            if (DEBUG) {
                Log.w("GetFormIdAction", "entity is null");
            }
            return false;
        } else if (eVar == null || !(context instanceof Activity) || callbackHandler == null) {
            if (DEBUG) {
                Log.d("GetFormIdAction", "runtime parameter error");
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "runtime parameter error");
            return false;
        } else {
            JSONObject b2 = b(unitedSchemeEntity, "params");
            if (b2 == null || b2.length() == 0) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal params");
                return false;
            }
            final String optString = b2.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                if (DEBUG) {
                    Log.w("GetFormIdAction", "cb is empty");
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "cb is empty");
                return false;
            }
            final String appKey = eVar.getAppKey();
            if (TextUtils.isEmpty(appKey)) {
                if (DEBUG) {
                    Log.w("GetFormIdAction", "appKey is empty");
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "appKey is empty");
                return false;
            }
            if (TableDefine.PaSubscribeColumns.COLUMN_SUBSCRIBE.equals(b2.optString("reportType"))) {
                final String optString2 = b2.optString("templateId");
                final String optString3 = b2.optString("subscribeId");
                if (TextUtils.isEmpty(optString2) || TextUtils.isEmpty(optString3)) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "templateId or subscribeId is empty");
                    return false;
                }
                a(context, appKey, optString2, new b() { // from class: com.baidu.swan.apps.o.a.1
                    @Override // com.baidu.swan.apps.o.a.b
                    public void onResult(int i) {
                        if (a.DEBUG) {
                            Log.i("GetFormIdAction", "querySubscribeInfo result=" + i);
                        }
                        if (i == -1) {
                            callbackHandler.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(500101, "user rejected forever").toString());
                        } else if (i == 1) {
                            a.this.a(callbackHandler, appKey, optString2, optString3, optString);
                        } else {
                            a.this.a(context, callbackHandler, eVar, optString, appKey, optString2, optString3);
                        }
                    }
                });
            } else {
                a(callbackHandler, appKey, null, null, optString);
            }
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
            return true;
        }
    }

    @AnyThread
    private void a(@NonNull final Context context, final String str, final String str2, @NonNull final b bVar) {
        m.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.o.a.2
            @Override // java.lang.Runnable
            public void run() {
                Cursor query = context.getContentResolver().query(SwanAppSubscribeMsgProvider.CONTENT_URI, new String[]{"result"}, "appKey=? and templateId=?", new String[]{str, str2}, null);
                if (query != null) {
                    if (query.getCount() > 0 && query.moveToFirst()) {
                        bVar.onResult(query.getInt(query.getColumnIndex("result")));
                    } else {
                        bVar.onResult(0);
                    }
                    com.baidu.swan.d.c.closeSafely(query);
                    return;
                }
                bVar.onResult(0);
            }
        }, "querySubscribeInfo");
    }

    /* JADX INFO: Access modifiers changed from: private */
    @AnyThread
    public void a(final Context context, final CallbackHandler callbackHandler, final e eVar, final String str, final String str2, final String str3, final String str4) {
        com.baidu.swan.apps.w.a.UA().a(str2, str3, new InterfaceC0269a() { // from class: com.baidu.swan.apps.o.a.3
            @Override // com.baidu.swan.apps.o.a.InterfaceC0269a
            public void aG(@Nullable String str5, @Nullable String str6) {
                if (!TextUtils.isEmpty(str5) && !TextUtils.isEmpty(str6)) {
                    a.this.a(context, callbackHandler, eVar, str, str2, str3, str4, str5, str6);
                    return;
                }
                if (str5 == null) {
                    str5 = "requestMsgTpl fail";
                }
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(500104, str5).toString());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final Context context, final CallbackHandler callbackHandler, e eVar, final String str, final String str2, final String str3, final String str4, @Nullable final String str5, @Nullable final String str6) {
        c.a((Activity) context, eVar, str5, str6, new c.a() { // from class: com.baidu.swan.apps.o.a.4
            @Override // com.baidu.swan.apps.o.c.a
            public void a(DialogInterface dialogInterface, int i, boolean z) {
                final boolean z2 = i == -1;
                if (a.DEBUG) {
                    Log.i("GetFormIdAction", "showSubscribeDialog isPositive=" + z2 + ", rememberChecked=" + z);
                }
                if (z) {
                    m.agL().execute(new Runnable() { // from class: com.baidu.swan.apps.o.a.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("appKey", str2);
                            contentValues.put("templateId", str3);
                            contentValues.put("title", str6);
                            contentValues.put("tips", str5);
                            contentValues.put("result", Integer.valueOf(z2 ? 1 : -1));
                            context.getContentResolver().insert(SwanAppSubscribeMsgProvider.CONTENT_URI, contentValues);
                        }
                    });
                }
                if (z2) {
                    a.this.a(callbackHandler, str2, str3, str4, str);
                } else {
                    callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(z ? 500101 : 500102, "user rejected").toString());
                }
            }
        }, new DialogInterface.OnCancelListener() { // from class: com.baidu.swan.apps.o.a.5
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(500103, "user canceled").toString());
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull final CallbackHandler callbackHandler, @NonNull String str, @Nullable String str2, @Nullable String str3, @NonNull final String str4) {
        com.baidu.swan.apps.w.a.UA().a(str, str2, str3, new com.baidu.swan.apps.o.b() { // from class: com.baidu.swan.apps.o.a.6
            @Override // com.baidu.swan.apps.ai.a
            public void K(JSONObject jSONObject) {
                callbackHandler.handleSchemeDispatchCallback(str4, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
            }

            @Override // com.baidu.swan.apps.ai.a
            public void onFail(String str5) {
                callbackHandler.handleSchemeDispatchCallback(str4, UnitedSchemeUtility.wrapCallbackParams(500105, str5).toString());
            }
        });
    }
}

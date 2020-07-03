package com.baidu.swan.apps.m;

import android.app.Activity;
import android.content.ContentResolver;
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
import com.baidu.swan.apps.aq.aj;
import com.baidu.swan.apps.aq.n;
import com.baidu.swan.apps.database.subscribe.SwanAppSubscribeMsgProvider;
import com.baidu.swan.apps.m.c;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.scheme.actions.aa;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.apps.statistic.h;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a extends aa {

    /* renamed from: com.baidu.swan.apps.m.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0359a {
        void d(@Nullable String str, @Nullable List<d> list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public interface b {
        void z(HashMap<String, Boolean> hashMap);
    }

    public a(j jVar) {
        super(jVar, "/swanAPI/getFormId");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(final Context context, UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final e eVar) {
        final String[] strArr;
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
                JSONArray optJSONArray = b2.optJSONArray("templateId");
                String optString2 = b2.optString("templateId");
                final String optString3 = b2.optString("subscribeId");
                if (TextUtils.isEmpty(optString3)) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "subscribeId is empty");
                    return false;
                }
                final boolean z = optJSONArray == null;
                if (z) {
                    if (TextUtils.isEmpty(optString2)) {
                        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "templateId is empty");
                        return false;
                    }
                    strArr = new String[]{optString2};
                } else {
                    int length = optJSONArray.length();
                    if (length < 1 || length > 3) {
                        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                        return false;
                    }
                    strArr = new String[length];
                    for (int i = 0; i < length; i++) {
                        strArr[i] = optJSONArray.optString(i);
                    }
                }
                a(context, appKey, strArr, new b() { // from class: com.baidu.swan.apps.m.a.1
                    @Override // com.baidu.swan.apps.m.a.b
                    public void z(HashMap<String, Boolean> hashMap) {
                        if (hashMap == null || hashMap.size() == 0) {
                            a.this.a(callbackHandler, appKey, Arrays.asList(strArr), optString3, z, optString);
                            return;
                        }
                        a.this.a(context, callbackHandler, eVar, optString, appKey, optString3, hashMap, z);
                        if (a.DEBUG) {
                            Iterator<String> it = hashMap.keySet().iterator();
                            while (it.hasNext()) {
                                Log.i("GetFormIdAction", "querySubscribeInfo unallowedTemplateId=" + it.next());
                            }
                        }
                    }
                });
            } else {
                a(callbackHandler, appKey, optString);
            }
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
            return true;
        }
    }

    @AnyThread
    private void a(@NonNull final Context context, final String str, final String[] strArr, final b bVar) {
        n.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.m.a.2
            @Override // java.lang.Runnable
            public void run() {
                String[] strArr2;
                Cursor query = context.getContentResolver().query(SwanAppSubscribeMsgProvider.CONTENT_URI, new String[]{"templateId", "result"}, "appKey=?", new String[]{str}, null);
                HashMap hashMap = new HashMap();
                if (query != null && query.getCount() > 0 && query.moveToFirst()) {
                    do {
                        hashMap.put(query.getString(query.getColumnIndex("templateId")), Integer.valueOf(query.getInt(query.getColumnIndex("result"))));
                    } while (query.moveToNext());
                    com.baidu.swan.e.d.closeSafely(query);
                }
                HashMap<String, Boolean> hashMap2 = new HashMap<>();
                for (String str2 : strArr) {
                    Integer num = (Integer) hashMap.get(str2);
                    if (num == null) {
                        hashMap2.put(str2, false);
                    } else if (num.intValue() != 1) {
                        hashMap2.put(str2, true);
                    }
                }
                bVar.z(hashMap2);
            }
        }, "querySubscribeInfo");
    }

    /* JADX INFO: Access modifiers changed from: private */
    @AnyThread
    public void a(final Context context, final CallbackHandler callbackHandler, final e eVar, final String str, final String str2, final String str3, final HashMap<String, Boolean> hashMap, final boolean z) {
        com.baidu.swan.apps.u.a.agA().a(str2, hashMap.keySet(), new InterfaceC0359a() { // from class: com.baidu.swan.apps.m.a.3
            @Override // com.baidu.swan.apps.m.a.InterfaceC0359a
            public void d(@Nullable final String str4, final List<d> list) {
                if (!TextUtils.isEmpty(str4) && list != null && list.size() > 0) {
                    n.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.m.a.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ContentResolver contentResolver = context.getContentResolver();
                            for (d dVar : list) {
                                String str5 = dVar.ciU;
                                Boolean bool = (Boolean) hashMap.get(str5);
                                if (bool != null && !bool.booleanValue()) {
                                    ContentValues contentValues = new ContentValues();
                                    contentValues.put("appKey", str2);
                                    contentValues.put("templateId", str5);
                                    contentValues.put("result", (Integer) 0);
                                    contentValues.put("title", dVar.ciV);
                                    contentValues.put(TableDefine.MessageColumns.COLUME_TIPS, str4);
                                    contentResolver.insert(SwanAppSubscribeMsgProvider.CONTENT_URI, contentValues);
                                }
                            }
                        }
                    }, "createFormDataBase");
                    aj.p(new Runnable() { // from class: com.baidu.swan.apps.m.a.3.2
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.a(context, callbackHandler, eVar, str, str2, str3, str4, list, z);
                        }
                    });
                    return;
                }
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(500104, "请求模板内容失败").toString());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final Context context, final CallbackHandler callbackHandler, final e eVar, final String str, final String str2, final String str3, final String str4, final List<d> list, final boolean z) {
        c.a((Activity) context, eVar, str4, list, new c.a() { // from class: com.baidu.swan.apps.m.a.4
            @Override // com.baidu.swan.apps.m.c.a
            public boolean a(DialogInterface dialogInterface, int i, final List<d> list2) {
                String str5;
                final boolean z2 = i == -1;
                if (a.DEBUG) {
                    Log.i("GetFormIdAction", "showSubscribeDialog isPositive=" + z2);
                }
                if (z2 && list2.size() == 0) {
                    return false;
                }
                n.auA().execute(new Runnable() { // from class: com.baidu.swan.apps.m.a.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ContentResolver contentResolver = context.getContentResolver();
                        for (d dVar : list2) {
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("title", dVar.ciV);
                            contentValues.put(TableDefine.MessageColumns.COLUME_TIPS, str4);
                            contentValues.put("result", Integer.valueOf(z2 ? 1 : -1));
                            contentResolver.update(SwanAppSubscribeMsgProvider.CONTENT_URI, contentValues, "appKey=? and templateId=?", new String[]{str2, dVar.ciU});
                        }
                    }
                });
                if (z2) {
                    ArrayList arrayList = new ArrayList();
                    for (d dVar : list2) {
                        arrayList.add(dVar.ciU);
                    }
                    a.this.a(callbackHandler, str2, arrayList, str3, z, str);
                    str5 = "permit_click";
                } else {
                    callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(500102, "用户单次拒绝授权").toString());
                    str5 = "reject_click";
                }
                a.this.a(eVar, str5, list, list2);
                return true;
            }
        }, new DialogInterface.OnCancelListener() { // from class: com.baidu.swan.apps.m.a.5
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(500103, "用户取消授权").toString());
            }
        }).show();
        a(eVar, "show", list, list);
    }

    private void a(@NonNull final CallbackHandler callbackHandler, @NonNull String str, @NonNull final String str2) {
        com.baidu.swan.apps.u.a.agA().a(str, new com.baidu.swan.apps.m.b() { // from class: com.baidu.swan.apps.m.a.6
            @Override // com.baidu.swan.apps.ag.a
            public void ah(JSONObject jSONObject) {
                callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
            }

            @Override // com.baidu.swan.apps.ag.a
            public void onFail(String str3) {
                callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(500105, "请求formId失败").toString());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull final CallbackHandler callbackHandler, @NonNull String str, @NonNull List<String> list, @Nullable String str2, boolean z, @NonNull final String str3) {
        com.baidu.swan.apps.u.a.agA().a(str, list, str2, z, new com.baidu.swan.apps.m.b() { // from class: com.baidu.swan.apps.m.a.7
            @Override // com.baidu.swan.apps.ag.a
            public void ah(JSONObject jSONObject) {
                callbackHandler.handleSchemeDispatchCallback(str3, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
            }

            @Override // com.baidu.swan.apps.ag.a
            public void onFail(String str4) {
                callbackHandler.handleSchemeDispatchCallback(str3, UnitedSchemeUtility.wrapCallbackParams(500105, "请求formId失败").toString());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(e eVar, String str, List<d> list, List<d> list2) {
        com.baidu.swan.apps.statistic.a.e eVar2 = new com.baidu.swan.apps.statistic.a.e();
        eVar2.mFrom = "swan";
        eVar2.mType = str;
        if (list2 != null) {
            eVar2.mValue = String.valueOf(list2.size());
        }
        eVar2.v("appkey", eVar.getAppId());
        eVar2.v("tpl", ah(list));
        eVar2.v("selected_tpl", ah(list2));
        if (DEBUG) {
            Log.d("GetFormIdAction", "event: " + eVar2.toJSONObject());
        }
        h.a("1311", eVar2);
    }

    private JSONArray ah(List<d> list) {
        JSONArray jSONArray = new JSONArray();
        if (list != null && list.size() > 0) {
            for (d dVar : list) {
                jSONArray.put(dVar.ciV);
            }
        }
        return jSONArray;
    }
}

package com.baidu.swan.apps.n;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.apps.ao.p;
import com.baidu.swan.apps.database.subscribe.SwanAppSubscribeMsgProvider;
import com.baidu.swan.apps.n.c;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.scheme.actions.aa;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.apps.statistic.h;
import com.baidu.swan.games.view.webview.GameWebViewJavascriptInterface;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a extends aa {
    private e cJK;
    private CallbackHandler det;
    private Context mContext;

    /* renamed from: com.baidu.swan.apps.n.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0457a {
        void b(@Nullable String str, @Nullable List<d> list, boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public interface b {
        void a(@NonNull LinkedHashMap<String, Boolean> linkedHashMap, @NonNull List<String> list);
    }

    public a(j jVar) {
        super(jVar, "/swanAPI/getFormId");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
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
            this.mContext = context;
            this.cJK = eVar;
            this.det = callbackHandler;
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
                final boolean optBoolean = b2.optBoolean("skipSubscribeAuthorize");
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
                a(appKey, strArr, new b() { // from class: com.baidu.swan.apps.n.a.1
                    @Override // com.baidu.swan.apps.n.a.b
                    public void a(@NonNull LinkedHashMap<String, Boolean> linkedHashMap, @NonNull List<String> list) {
                        if (linkedHashMap == null || linkedHashMap.size() == 0) {
                            a.this.a(appKey, Arrays.asList(strArr), optString3, z, optString);
                            return;
                        }
                        a.this.a(optString, appKey, optString3, linkedHashMap, list, z, optBoolean);
                        if (a.DEBUG) {
                            Iterator<String> it = linkedHashMap.keySet().iterator();
                            while (it.hasNext()) {
                                Log.i("GetFormIdAction", "querySubscribeInfo unallowedTemplateId=" + it.next());
                            }
                        }
                    }
                });
            } else {
                bM(appKey, optString);
            }
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
            return true;
        }
    }

    @AnyThread
    private void a(final String str, final String[] strArr, final b bVar) {
        p.a(new Runnable() { // from class: com.baidu.swan.apps.n.a.2
            @Override // java.lang.Runnable
            public void run() {
                String[] strArr2;
                Cursor query = a.this.mContext.getContentResolver().query(SwanAppSubscribeMsgProvider.CONTENT_URI, new String[]{"templateId", "result"}, "appKey=?", new String[]{str}, null);
                HashMap hashMap = new HashMap();
                if (query != null && query.getCount() > 0 && query.moveToFirst()) {
                    do {
                        hashMap.put(query.getString(query.getColumnIndex("templateId")), Integer.valueOf(query.getInt(query.getColumnIndex("result"))));
                    } while (query.moveToNext());
                    com.baidu.swan.c.d.closeSafely(query);
                }
                LinkedHashMap<String, Boolean> linkedHashMap = new LinkedHashMap<>();
                ArrayList arrayList = new ArrayList();
                for (String str2 : strArr) {
                    Integer num = (Integer) hashMap.get(str2);
                    if (num == null) {
                        linkedHashMap.put(str2, false);
                    } else if (num.intValue() != 1) {
                        linkedHashMap.put(str2, true);
                    } else {
                        arrayList.add(str2);
                    }
                }
                bVar.a(linkedHashMap, arrayList);
            }
        }, "querySubscribeInfo");
    }

    /* JADX INFO: Access modifiers changed from: private */
    @AnyThread
    public void a(final String str, final String str2, final String str3, final LinkedHashMap<String, Boolean> linkedHashMap, @NonNull final List<String> list, final boolean z, final boolean z2) {
        com.baidu.swan.apps.t.a.aAW().a(str2, linkedHashMap.keySet(), new InterfaceC0457a() { // from class: com.baidu.swan.apps.n.a.3
            @Override // com.baidu.swan.apps.n.a.InterfaceC0457a
            public void b(@Nullable final String str4, final List<d> list2, boolean z3) {
                if (TextUtils.isEmpty(str4) || list2 == null || list2.size() <= 0) {
                    a.this.det.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(500104, "请求模板内容失败").toString());
                    return;
                }
                p.a(new Runnable() { // from class: com.baidu.swan.apps.n.a.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ContentResolver contentResolver = a.this.mContext.getContentResolver();
                        for (d dVar : list2) {
                            String str5 = dVar.deT;
                            Boolean bool = (Boolean) linkedHashMap.get(str5);
                            if (bool != null && !bool.booleanValue()) {
                                ContentValues contentValues = new ContentValues();
                                contentValues.put("appKey", str2);
                                contentValues.put("templateId", str5);
                                contentValues.put("result", (Integer) 0);
                                contentValues.put("title", dVar.deU);
                                contentValues.put(TableDefine.MessageColumns.COLUME_TIPS, str4);
                                contentResolver.insert(SwanAppSubscribeMsgProvider.CONTENT_URI, contentValues);
                            }
                        }
                    }
                }, "createFormDataBase");
                if (z3 && z2) {
                    a.this.a(str2, list2, str4, true);
                    for (d dVar : list2) {
                        list.add(dVar.deT);
                    }
                    a.this.a(str2, list, str3, z, str);
                    return;
                }
                ak.l(new Runnable() { // from class: com.baidu.swan.apps.n.a.3.2
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.a(str, str2, str3, str4, list2, list, z);
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final String str, final String str2, final String str3, final String str4, final List<d> list, @NonNull final List<String> list2, final boolean z) {
        c.a((Activity) this.mContext, this.cJK, str4, list, new c.a() { // from class: com.baidu.swan.apps.n.a.4
            @Override // com.baidu.swan.apps.n.c.a
            public boolean a(DialogInterface dialogInterface, int i, List<d> list3) {
                String str5;
                boolean z2 = i == -1;
                if (a.DEBUG) {
                    Log.i("GetFormIdAction", "showSubscribeDialog isPositive=" + z2);
                }
                if (z2 && list3.size() == 0) {
                    return false;
                }
                a.this.a(str2, list3, str4, z2);
                if (z2) {
                    for (d dVar : list3) {
                        list2.add(dVar.deT);
                    }
                    a.this.a(str2, list2, str3, z, str);
                    str5 = "permit_click";
                } else {
                    a.this.det.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(500102, "用户单次拒绝授权").toString());
                    str5 = "reject_click";
                }
                a.this.a(str5, list, list3);
                return true;
            }
        }, new DialogInterface.OnCancelListener() { // from class: com.baidu.swan.apps.n.a.5
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                a.this.det.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(500103, "用户取消授权").toString());
            }
        }).show();
        a("show", list, list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final String str, final List<d> list, final String str2, final boolean z) {
        p.aRp().execute(new Runnable() { // from class: com.baidu.swan.apps.n.a.6
            @Override // java.lang.Runnable
            public void run() {
                ContentResolver contentResolver = a.this.mContext.getContentResolver();
                for (d dVar : list) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("title", dVar.deU);
                    contentValues.put(TableDefine.MessageColumns.COLUME_TIPS, str2);
                    contentValues.put("result", Integer.valueOf(z ? 1 : -1));
                    contentResolver.update(SwanAppSubscribeMsgProvider.CONTENT_URI, contentValues, "appKey=? and templateId=?", new String[]{str, dVar.deT});
                }
            }
        });
    }

    private void bM(@NonNull String str, @NonNull final String str2) {
        com.baidu.swan.apps.t.a.aAW().a(str, new com.baidu.swan.apps.n.b() { // from class: com.baidu.swan.apps.n.a.7
            @Override // com.baidu.swan.apps.ae.a
            public void aI(JSONObject jSONObject) {
                a.this.det.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
                if (com.baidu.swan.apps.t.a.aAw().cb(a.this.mContext)) {
                    com.baidu.swan.apps.ae.c.dwQ.aJU();
                } else {
                    com.baidu.swan.apps.ae.c.dwQ.aJV();
                }
            }

            @Override // com.baidu.swan.apps.ae.a
            public void onFail(String str3) {
                a.this.det.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(500105, "请求formId失败").toString());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull String str, @NonNull List<String> list, @Nullable String str2, boolean z, @NonNull final String str3) {
        com.baidu.swan.apps.t.a.aAW().a(str, list, str2, z, new com.baidu.swan.apps.n.b() { // from class: com.baidu.swan.apps.n.a.8
            @Override // com.baidu.swan.apps.ae.a
            public void aI(JSONObject jSONObject) {
                a.this.det.handleSchemeDispatchCallback(str3, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
                if (com.baidu.swan.apps.t.a.aAw().cb(a.this.mContext)) {
                    com.baidu.swan.apps.ae.c.dwQ.aJU();
                } else {
                    com.baidu.swan.apps.ae.c.dwQ.aJV();
                }
            }

            @Override // com.baidu.swan.apps.ae.a
            public void onFail(String str4) {
                a.this.det.handleSchemeDispatchCallback(str3, UnitedSchemeUtility.wrapCallbackParams(500105, "请求formId失败").toString());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, List<d> list, List<d> list2) {
        com.baidu.swan.apps.statistic.a.e eVar = new com.baidu.swan.apps.statistic.a.e();
        eVar.mFrom = GameWebViewJavascriptInterface.JAVASCRIPT_INTERFACE_NAME;
        eVar.mType = str;
        if (list2 != null) {
            eVar.mValue = String.valueOf(list2.size());
        }
        eVar.t("appkey", this.cJK.getAppId());
        eVar.t("tpl", aM(list));
        eVar.t("selected_tpl", aM(list2));
        if (DEBUG) {
            Log.d("GetFormIdAction", "event: " + eVar.toJSONObject());
        }
        h.a("1311", eVar);
    }

    private JSONArray aM(List<d> list) {
        JSONArray jSONArray = new JSONArray();
        if (list != null && list.size() > 0) {
            for (d dVar : list) {
                jSONArray.put(dVar.deU);
            }
        }
        return jSONArray;
    }
}

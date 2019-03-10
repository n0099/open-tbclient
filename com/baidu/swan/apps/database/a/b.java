package com.baidu.swan.apps.database.a;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.an.j;
import com.baidu.swan.apps.database.SwanAppDbControl;
import com.baidu.swan.apps.scheme.actions.c.a;
import com.facebook.common.internal.h;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import rx.functions.f;
import rx.schedulers.Schedulers;
/* loaded from: classes2.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.c.DEBUG;
    private static final Set<String> auz = h.K("sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u");
    private static final String[] auo = {"_id", SwanAppDbControl.SwanAppTable.app_id.name(), SwanAppDbControl.SwanAppTable.app_key.name(), SwanAppDbControl.SwanAppTable.version.name(), SwanAppDbControl.SwanAppTable.description.name(), SwanAppDbControl.SwanAppTable.error_code.name(), SwanAppDbControl.SwanAppTable.error_detail.name(), SwanAppDbControl.SwanAppTable.error_msg.name(), SwanAppDbControl.SwanAppTable.resume_date.name(), SwanAppDbControl.SwanAppTable.icon.name(), SwanAppDbControl.SwanAppTable.icon_url.name(), SwanAppDbControl.SwanAppTable.max_swan_version.name(), SwanAppDbControl.SwanAppTable.min_swan_version.name(), SwanAppDbControl.SwanAppTable.name.name(), SwanAppDbControl.SwanAppTable.service_category.name(), SwanAppDbControl.SwanAppTable.subject_info.name(), SwanAppDbControl.SwanAppTable.bear_info.name(), SwanAppDbControl.SwanAppTable.sign.name(), SwanAppDbControl.SwanAppTable.type.name(), SwanAppDbControl.SwanAppTable.is_have_zip.name(), SwanAppDbControl.SwanAppTable.app_open_url.name(), SwanAppDbControl.SwanAppTable.app_download_url.name(), SwanAppDbControl.SwanAppTable.target_swan_version.name(), SwanAppDbControl.SwanAppTable.app_zip_size.name(), SwanAppDbControl.SwanAppTable.pending_aps_errcode.name(), SwanAppDbControl.SwanAppTable.version_code.name(), SwanAppDbControl.SwanAppTable.app_category.name(), SwanAppDbControl.SwanAppTable.orientation.name(), SwanAppDbControl.SwanAppTable.max_age.name(), SwanAppDbControl.SwanAppTable.create_time.name(), SwanAppDbControl.SwanAppTable.force_fetch_meta_info.name(), "app_from", "visit_time"};

    public static boolean a(@NonNull ContentResolver contentResolver, @Nullable com.baidu.swan.apps.database.b bVar) {
        if (bVar == null || TextUtils.isEmpty(bVar.AG())) {
            return false;
        }
        if (DEBUG) {
            Log.d("SwanAppHistoryHelper", "addHistory: " + bVar.AH() + " / " + bVar.AG());
        }
        if (es(bVar.AG())) {
            if (DEBUG) {
                Log.w("SwanAppHistoryHelper", "addHistory: isInIgnoreHisList");
                return false;
            }
            return false;
        }
        if (TextUtils.equals("0", bVar.aum)) {
            c(contentResolver, bVar.AG());
        }
        e(contentResolver, bVar.AG());
        Uri AU = com.baidu.swan.apps.database.a.a.AU();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", bVar.AG());
        contentValues.put("visit_time", Long.valueOf(System.currentTimeMillis()));
        contentValues.put("app_from", bVar.AI());
        Uri insert = AppRuntime.getAppContext().getContentResolver().insert(AU, contentValues);
        if (DEBUG) {
            Log.d("SwanAppHistoryHelper", "Add history: newUri - " + (insert == null ? "NULL" : insert.toString()));
        }
        return insert == null;
    }

    public static void a(com.baidu.swan.apps.ae.b bVar) {
        com.baidu.swan.apps.v.b.b uB;
        if (bVar != null && (uB = bVar.uB()) != null) {
            if (DEBUG) {
                Log.d("SwanAppHistoryHelper", "addHistoryAsync: " + uB.axC + " / " + uB.mAppId);
            }
            final com.baidu.swan.apps.database.b bVar2 = new com.baidu.swan.apps.database.b(uB.mAppId);
            bVar2.ei(uB.mAppId);
            bVar2.em(uB.axD);
            bVar2.ej(uB.axC);
            bVar2.ek(uB.axF);
            bVar2.cq(uB.axW);
            switch (uB.mType) {
                case 0:
                    bVar2.el("1");
                    break;
                case 1:
                    bVar2.el("0");
                    break;
                case 2:
                    bVar2.el("2");
                    break;
                case 3:
                    bVar2.el("3");
                    break;
            }
            j.a(new Runnable() { // from class: com.baidu.swan.apps.database.a.b.1
                @Override // java.lang.Runnable
                public void run() {
                    b.a(AppRuntime.getAppContext().getContentResolver(), com.baidu.swan.apps.database.b.this);
                }
            }, "saveSwanAppInHistoryAsync");
        }
    }

    @Nullable
    public static Cursor b(@NonNull ContentResolver contentResolver, @NonNull String str) {
        Cursor cursor;
        try {
            cursor = contentResolver.query(com.baidu.swan.apps.database.a.a.AS(), null, SwanAppDbControl.SwanAppTable.name.name() + " LIKE ? ", new String[]{"%" + str + "%"}, "visit_time desc  LIMIT 400");
        } catch (Exception e2) {
            if (DEBUG) {
                e2.printStackTrace();
            }
            cursor = null;
        }
        if (DEBUG && cursor != null) {
            Log.d("SwanAppHistoryHelper", "queryHistoryByKeyword: keyword[" + str + "]  Cursor count: " + cursor.getCount());
        }
        return cursor;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [230=4] */
    @NonNull
    public static Set<String> a(@NonNull ContentResolver contentResolver) {
        Cursor cursor;
        Cursor cursor2 = null;
        HashSet hashSet = new HashSet();
        try {
            try {
                cursor = contentResolver.query(com.baidu.swan.apps.database.a.a.AU(), null, null, null, null);
                if (cursor != null) {
                    try {
                        if (cursor.moveToFirst()) {
                            do {
                                hashSet.add(cursor.getString(cursor.getColumnIndex("app_id")));
                            } while (cursor.moveToNext());
                        }
                    } catch (Exception e2) {
                        e = e2;
                        if (DEBUG) {
                            e.printStackTrace();
                        }
                        if (DEBUG && cursor != null) {
                            Log.d("SwanAppHistoryHelper", "getAllHistoryIdsSet: Cursor count: " + cursor.getCount());
                        }
                        com.baidu.swan.c.b.c(cursor);
                        return hashSet;
                    }
                }
                if (DEBUG && cursor != null) {
                    Log.d("SwanAppHistoryHelper", "getAllHistoryIdsSet: Cursor count: " + cursor.getCount());
                }
                com.baidu.swan.c.b.c(cursor);
            } catch (Throwable th) {
                th = th;
                if (DEBUG && 0 != 0) {
                    Log.d("SwanAppHistoryHelper", "getAllHistoryIdsSet: Cursor count: " + cursor2.getCount());
                }
                com.baidu.swan.c.b.c(null);
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            if (DEBUG) {
                Log.d("SwanAppHistoryHelper", "getAllHistoryIdsSet: Cursor count: " + cursor2.getCount());
            }
            com.baidu.swan.c.b.c(null);
            throw th;
        }
        return hashSet;
    }

    public static void a(final a.InterfaceC0136a interfaceC0136a) {
        if (interfaceC0136a != null) {
            rx.d.bn("").b(Schedulers.io()).d(new f<String, Cursor>() { // from class: com.baidu.swan.apps.database.a.b.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.f
                /* renamed from: et */
                public Cursor call(String str) {
                    if (com.baidu.swan.apps.core.pms.a.vq()) {
                        return b.z(str, 400);
                    }
                    return b.b(AppRuntime.getAppContext().getContentResolver(), str);
                }
            }).a(rx.a.b.a.cDR()).c(new rx.functions.b<Cursor>() { // from class: com.baidu.swan.apps.database.a.b.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                /* renamed from: h */
                public void call(Cursor cursor) {
                    if (cursor == null || !cursor.moveToFirst()) {
                        if (b.DEBUG) {
                            Log.d("SwanAppHistoryHelper", "historyList == null || historyList.size() == 0");
                        }
                        if (cursor != null) {
                            try {
                                cursor.close();
                            } catch (Exception e2) {
                                if (b.DEBUG) {
                                    e2.printStackTrace();
                                }
                            }
                        }
                        a.InterfaceC0136a.this.ab(null);
                        return;
                    }
                    a.InterfaceC0136a.this.ab(b.f(cursor));
                }
            });
        }
    }

    public static boolean a(ContentResolver contentResolver, String str, boolean z) {
        com.baidu.swan.apps.env.c Bg;
        if (!TextUtils.isEmpty(str)) {
            r0 = contentResolver.delete(com.baidu.swan.apps.database.a.a.AU(), "app_id=?", new String[]{str}) > 0;
            if (z && r0 && (Bg = com.baidu.swan.apps.env.e.Bf().Bg()) != null) {
                Bg.p(str, true);
            }
            if (DEBUG) {
                Log.d("SwanAppHistoryHelper", "deleteHistory: " + str + " isSuccess: " + r0);
            }
        }
        return r0;
    }

    private static void c(@NonNull ContentResolver contentResolver, @Nullable String str) {
        if (DEBUG) {
            Log.d("SwanAppHistoryHelper", "start deleteOtherDevHistory: ");
        }
        if (!TextUtils.isEmpty(str)) {
            String dn = com.baidu.swan.apps.f.a.dn(str);
            if (!TextUtils.isEmpty(dn)) {
                List<String> d2 = d(contentResolver, str);
                if (d2 == null || d2.size() == 0) {
                    if (DEBUG) {
                        Log.d("SwanAppHistoryHelper", "deleteOtherDevHistory finish because: other dev history is empty");
                        return;
                    }
                    return;
                }
                com.baidu.swan.apps.env.c Bg = com.baidu.swan.apps.env.e.Bf().Bg();
                if (Bg != null) {
                    if (DEBUG) {
                        Log.d("SwanAppHistoryHelper", "deleteOtherDevHistory: delete other dev SwanApp");
                    }
                    Bg.a(d2, false, false);
                }
                if (DEBUG) {
                    Log.d("SwanAppHistoryHelper", "deleteOtherDevHistory: delete other dev history");
                }
                contentResolver.delete(com.baidu.swan.apps.database.a.a.AU(), "app_id LIKE ? AND app_id != ?", new String[]{dn + "_dev%", str});
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [500=6] */
    /* JADX WARN: Not initialized variable reg: 1, insn: 0x00a6: MOVE  (r6 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:31:0x00a6 */
    @Nullable
    private static List<String> d(@NonNull ContentResolver contentResolver, @Nullable String str) {
        Closeable closeable;
        Cursor cursor;
        Closeable closeable2 = null;
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                String dn = com.baidu.swan.apps.f.a.dn(str);
                if (TextUtils.isEmpty(dn)) {
                    com.baidu.swan.c.b.c(null);
                    return null;
                }
                cursor = contentResolver.query(com.baidu.swan.apps.database.a.a.AU(), null, "app_id LIKE ? AND app_id != ?", new String[]{dn + "_dev%", str}, "visit_time desc  LIMIT 400");
                if (cursor != null) {
                    try {
                        if (cursor.moveToFirst()) {
                            ArrayList arrayList = new ArrayList();
                            do {
                                String string = cursor.getString(cursor.getColumnIndex("app_id"));
                                if (!TextUtils.isEmpty(string)) {
                                    arrayList.add(string);
                                }
                            } while (cursor.moveToNext());
                            com.baidu.swan.c.b.c(cursor);
                            return arrayList;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        if (DEBUG) {
                            e.printStackTrace();
                        }
                        com.baidu.swan.c.b.c(cursor);
                        return null;
                    }
                }
                com.baidu.swan.c.b.c(cursor);
                return null;
            } catch (Exception e3) {
                e = e3;
                cursor = null;
            } catch (Throwable th) {
                th = th;
                com.baidu.swan.c.b.c(closeable2);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            closeable2 = closeable;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [542=5] */
    private static void e(@NonNull ContentResolver contentResolver, @Nullable String str) {
        Cursor cursor;
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                cursor = contentResolver.query(com.baidu.swan.apps.database.a.a.AU(), null, "app_id != ?", new String[]{str}, null);
                if (cursor == null) {
                    com.baidu.swan.c.b.c(cursor);
                    return;
                }
                try {
                    int count = (cursor.getCount() + 1) - 400;
                    if (count <= 0) {
                        if (DEBUG) {
                            Log.d("SwanAppHistoryHelper", "tryDelUpperLimitSwanApp: no need to delete, currentCount: " + cursor.getCount());
                        }
                        com.baidu.swan.c.b.c(cursor);
                        return;
                    }
                    if (DEBUG) {
                        Log.w("SwanAppHistoryHelper", "tryDelUpperLimitSwanApp: number to delete " + count + " / currentCount" + cursor.getCount());
                    }
                    a(contentResolver, count);
                    com.baidu.swan.c.b.c(cursor);
                } catch (Exception e2) {
                    e = e2;
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                    com.baidu.swan.c.b.c(cursor);
                }
            } catch (Exception e3) {
                e = e3;
                cursor = null;
            } catch (Throwable th) {
                th = th;
                com.baidu.swan.c.b.c(null);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [591=4] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:32:0x00a6 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v13, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v2 */
    private static void a(@NonNull ContentResolver contentResolver, int i) {
        ?? r1;
        Cursor cursor;
        if (DEBUG) {
            r1 = "delUpperLimitSwanApp delCount: " + i;
            Log.d("SwanAppHistoryHelper", r1);
        }
        try {
            if (i <= 0) {
                return;
            }
            try {
                cursor = contentResolver.query(com.baidu.swan.apps.database.a.a.AU(), null, null, null, "visit_time asc " + (" LIMIT " + i));
                if (cursor != null) {
                    try {
                        if (cursor.moveToFirst()) {
                            ArrayList arrayList = new ArrayList();
                            do {
                                String string = cursor.getString(cursor.getColumnIndex("app_id"));
                                if (!TextUtils.isEmpty(string)) {
                                    arrayList.add(string);
                                }
                            } while (cursor.moveToNext());
                            com.baidu.swan.apps.env.c Bg = com.baidu.swan.apps.env.e.Bf().Bg();
                            if (Bg != null) {
                                Bg.e(arrayList, false);
                            }
                            com.baidu.swan.c.b.c(cursor);
                            return;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        if (DEBUG) {
                            e.printStackTrace();
                        }
                        com.baidu.swan.c.b.c(cursor);
                        return;
                    }
                }
                com.baidu.swan.c.b.c(cursor);
            } catch (Exception e3) {
                e = e3;
                cursor = null;
            } catch (Throwable th) {
                th = th;
                r1 = 0;
                com.baidu.swan.c.b.c(r1);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static boolean es(String str) {
        return TextUtils.isEmpty(str) || auz.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public static JSONObject f(Cursor cursor) {
        String str;
        String str2;
        JSONArray jSONArray = new JSONArray();
        do {
            JSONObject jSONObject = new JSONObject();
            try {
                String string = cursor.getString(cursor.getColumnIndex("app_id"));
                if (!TextUtils.isEmpty(string)) {
                    jSONObject.put("appid", string);
                }
                int i = cursor.getInt(cursor.getColumnIndex(SwanAppDbControl.SwanAppTable.app_category.name()));
                jSONObject.put("frameType", i);
                switch (cursor.getInt(cursor.getColumnIndex(SwanAppDbControl.SwanAppTable.type.name()))) {
                    case 0:
                        str = "1";
                        break;
                    case 1:
                        str = "0";
                        break;
                    case 2:
                        str = "2";
                        break;
                    case 3:
                        str = "3";
                        break;
                    default:
                        str = "1";
                        break;
                }
                jSONObject.put("type", str);
                if (TextUtils.isEmpty(string)) {
                    string = "";
                }
                if (i == 1) {
                    str2 = String.format(com.baidu.swan.apps.scheme.actions.c.a.aPN, string);
                } else {
                    str2 = com.baidu.swan.apps.scheme.actions.c.a.aPM + string + "\"}";
                }
                jSONObject.put("scheme", str2);
                if (!TextUtils.isEmpty(cursor.getString(cursor.getColumnIndex("visit_time")))) {
                    jSONObject.put("dataStamp", cursor.getString(cursor.getColumnIndex("visit_time")));
                }
                if (!TextUtils.isEmpty(cursor.getString(cursor.getColumnIndex(SwanAppDbControl.SwanAppTable.icon_url.name())))) {
                    jSONObject.put("iconUrl", cursor.getString(cursor.getColumnIndex(SwanAppDbControl.SwanAppTable.icon_url.name())));
                }
                if (!TextUtils.isEmpty(cursor.getString(cursor.getColumnIndex(SwanAppDbControl.SwanAppTable.name.name())))) {
                    jSONObject.put("title", cursor.getString(cursor.getColumnIndex(SwanAppDbControl.SwanAppTable.name.name())));
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            jSONArray.put(jSONObject);
        } while (cursor.moveToNext());
        try {
            cursor.close();
        } catch (Exception e3) {
            if (DEBUG) {
                e3.printStackTrace();
            }
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("history", jSONArray);
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        if (DEBUG) {
            Log.d("SwanAppHistoryHelper", "historyCursorToJson : " + jSONObject2.toString());
        }
        return jSONObject2;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01fe A[LOOP:3: B:45:0x01f8->B:47:0x01fe, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x027b  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0289  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x02be A[LOOP:5: B:62:0x02b8->B:64:0x02be, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Cursor z(@NonNull String str, int i) {
        Cursor query;
        List<c> arrayList;
        HashMap hashMap = new HashMap();
        Cursor b = b(AppRuntime.getAppContext().getContentResolver(), str);
        if (b != null && b.moveToFirst()) {
            do {
                com.baidu.swan.apps.database.a aVar = new com.baidu.swan.apps.database.a();
                SwanAppDbControl.bE(AppRuntime.getAppContext()).a(b, aVar);
                if (!TextUtils.isEmpty(aVar.appId)) {
                    a aVar2 = new a();
                    aVar2.aup = aVar;
                    aVar2.auD.id = aVar.appId;
                    aVar2.auD.from = b.getString(b.getColumnIndex("app_from"));
                    aVar2.auD.auC = b.getLong(b.getColumnIndex("visit_time"));
                    hashMap.put(aVar2.auD.id, aVar2);
                    if (DEBUG) {
                        Log.v("history_migrate_pms", "Aps&History == " + aVar.appId);
                    }
                }
            } while (b.moveToNext());
            com.baidu.swan.c.b.c(b);
            if (DEBUG) {
            }
            query = AppRuntime.getAppContext().getContentResolver().query(com.baidu.swan.apps.database.a.a.AU(), null, null, null, null);
            HashMap hashMap2 = new HashMap();
            if (query == null) {
            }
            com.baidu.swan.c.b.c(query);
            if (DEBUG) {
            }
            ArrayList<c> arrayList2 = new ArrayList();
            while (r5.hasNext()) {
            }
            if (DEBUG) {
            }
            while (r1.hasNext()) {
            }
            if (DEBUG) {
            }
            arrayList = new ArrayList(hashMap.values());
            Collections.sort(arrayList, new d());
            if (i > 0) {
            }
            MatrixCursor matrixCursor = new MatrixCursor(auo, 50);
            int i2 = 0;
            while (r3.hasNext()) {
            }
            return matrixCursor;
        }
        com.baidu.swan.c.b.c(b);
        if (DEBUG) {
            Log.d("history_migrate_pms", "^ Aps & History 查询到 " + hashMap.size() + " 个历史记录");
        }
        query = AppRuntime.getAppContext().getContentResolver().query(com.baidu.swan.apps.database.a.a.AU(), null, null, null, null);
        HashMap hashMap22 = new HashMap();
        if (query == null && query.moveToFirst()) {
            do {
                C0109b c0109b = new C0109b();
                c0109b.id = query.getString(query.getColumnIndex("app_id"));
                c0109b.from = query.getString(query.getColumnIndex("app_from"));
                c0109b.auC = query.getLong(query.getColumnIndex("visit_time"));
                hashMap22.put(c0109b.id, c0109b);
                if (DEBUG) {
                    Log.v("history_migrate_pms", "History == " + c0109b.id);
                }
            } while (query.moveToNext());
            com.baidu.swan.c.b.c(query);
            if (DEBUG) {
            }
            ArrayList<c> arrayList22 = new ArrayList();
            while (r5.hasNext()) {
            }
            if (DEBUG) {
            }
            while (r1.hasNext()) {
            }
            if (DEBUG) {
            }
            arrayList = new ArrayList(hashMap.values());
            Collections.sort(arrayList, new d());
            if (i > 0) {
                arrayList = arrayList.subList(0, i);
                if (DEBUG) {
                }
            }
            MatrixCursor matrixCursor2 = new MatrixCursor(auo, 50);
            int i22 = 0;
            while (r3.hasNext()) {
            }
            return matrixCursor2;
        }
        com.baidu.swan.c.b.c(query);
        if (DEBUG) {
            Log.d("history_migrate_pms", "^ History 库查询到 " + hashMap22.size() + " 个历史记录");
        }
        ArrayList<c> arrayList222 = new ArrayList();
        for (com.baidu.swan.pms.model.a aVar3 : new ArrayList(com.baidu.swan.pms.database.a.RA().RB().values())) {
            if (DEBUG) {
                Log.v("history_migrate_pms", "Pms == " + aVar3.appId);
            }
            if (aVar3.appName != null && aVar3.appName.contains(str) && hashMap22.containsKey(aVar3.appId)) {
                e eVar = new e();
                eVar.auD = (C0109b) hashMap22.get(aVar3.appId);
                eVar.aus = aVar3;
                arrayList222.add(eVar);
            }
        }
        if (DEBUG) {
            Log.d("history_migrate_pms", "^ Pms & History 查询到 " + arrayList222.size() + " 个历史记录");
        }
        for (c cVar : arrayList222) {
            hashMap.put(cVar.auD.id, cVar);
        }
        if (DEBUG) {
            Log.d("history_migrate_pms", "合并后有 " + hashMap.size() + " 个历史记录");
            Iterator it = hashMap.values().iterator();
            while (it.hasNext()) {
                Log.v("history_migrate_pms", "Migrate == " + ((c) it.next()).auD.id);
            }
        }
        arrayList = new ArrayList(hashMap.values());
        Collections.sort(arrayList, new d());
        if (i > 0 && i < arrayList.size()) {
            arrayList = arrayList.subList(0, i);
            if (DEBUG) {
                Log.d("history_migrate_pms", "Limit限制 " + i + " 条");
            }
        }
        MatrixCursor matrixCursor22 = new MatrixCursor(auo, 50);
        int i222 = 0;
        for (c cVar2 : arrayList) {
            a(matrixCursor22, i222, cVar2);
            i222++;
        }
        return matrixCursor22;
    }

    private static void a(MatrixCursor matrixCursor, int i, c cVar) {
        if (cVar instanceof a) {
            a aVar = (a) cVar;
            matrixCursor.newRow().add("_id", Integer.valueOf(i)).add(SwanAppDbControl.SwanAppTable.app_id.name(), aVar.aup.appId).add(SwanAppDbControl.SwanAppTable.app_key.name(), aVar.aup.appKey).add(SwanAppDbControl.SwanAppTable.version.name(), aVar.aup.version).add(SwanAppDbControl.SwanAppTable.description.name(), aVar.aup.description).add(SwanAppDbControl.SwanAppTable.error_code.name(), Integer.valueOf(aVar.aup.errorCode)).add(SwanAppDbControl.SwanAppTable.error_detail.name(), aVar.aup.errorDetail).add(SwanAppDbControl.SwanAppTable.error_msg.name(), aVar.aup.errorMsg).add(SwanAppDbControl.SwanAppTable.resume_date.name(), aVar.aup.atT).add(SwanAppDbControl.SwanAppTable.icon.name(), aVar.aup.icon).add(SwanAppDbControl.SwanAppTable.icon_url.name(), aVar.aup.iconUrl).add(SwanAppDbControl.SwanAppTable.max_swan_version.name(), aVar.aup.atU).add(SwanAppDbControl.SwanAppTable.min_swan_version.name(), aVar.aup.atV).add(SwanAppDbControl.SwanAppTable.name.name(), aVar.aup.name).add(SwanAppDbControl.SwanAppTable.service_category.name(), aVar.aup.atW).add(SwanAppDbControl.SwanAppTable.subject_info.name(), aVar.aup.atX).add(SwanAppDbControl.SwanAppTable.bear_info.name(), aVar.aup.atY).add(SwanAppDbControl.SwanAppTable.sign.name(), aVar.aup.sign).add(SwanAppDbControl.SwanAppTable.type.name(), Integer.valueOf(aVar.aup.type)).add(SwanAppDbControl.SwanAppTable.is_have_zip.name(), Integer.valueOf(aVar.aup.atZ)).add(SwanAppDbControl.SwanAppTable.app_open_url.name(), aVar.aup.aua).add(SwanAppDbControl.SwanAppTable.app_download_url.name(), aVar.aup.aub).add(SwanAppDbControl.SwanAppTable.target_swan_version.name(), aVar.aup.auc).add(SwanAppDbControl.SwanAppTable.app_zip_size.name(), Long.valueOf(aVar.aup.aud)).add(SwanAppDbControl.SwanAppTable.pending_aps_errcode.name(), Integer.valueOf(aVar.aup.aue)).add(SwanAppDbControl.SwanAppTable.version_code.name(), aVar.aup.auf).add(SwanAppDbControl.SwanAppTable.app_category.name(), Integer.valueOf(aVar.aup.category)).add(SwanAppDbControl.SwanAppTable.orientation.name(), Integer.valueOf(aVar.aup.orientation)).add(SwanAppDbControl.SwanAppTable.max_age.name(), Long.valueOf(aVar.aup.aug)).add(SwanAppDbControl.SwanAppTable.create_time.name(), Long.valueOf(aVar.aup.createTime)).add(SwanAppDbControl.SwanAppTable.force_fetch_meta_info.name(), Integer.valueOf(aVar.aup.auh ? 1 : 0)).add("app_from", aVar.auD.from).add("visit_time", Long.valueOf(aVar.auD.auC));
            return;
        }
        e eVar = (e) cVar;
        matrixCursor.newRow().add("_id", Integer.valueOf(i)).add(SwanAppDbControl.SwanAppTable.app_id.name(), eVar.aus.appId).add(SwanAppDbControl.SwanAppTable.app_key.name(), eVar.aus.appKey).add(SwanAppDbControl.SwanAppTable.version.name(), Integer.valueOf(eVar.aus.versionCode)).add(SwanAppDbControl.SwanAppTable.description.name(), eVar.aus.description).add(SwanAppDbControl.SwanAppTable.error_code.name(), Integer.valueOf(eVar.aus.appStatus)).add(SwanAppDbControl.SwanAppTable.error_detail.name(), eVar.aus.blM).add(SwanAppDbControl.SwanAppTable.error_msg.name(), eVar.aus.blN).add(SwanAppDbControl.SwanAppTable.resume_date.name(), eVar.aus.atT).add(SwanAppDbControl.SwanAppTable.icon.name(), "").add(SwanAppDbControl.SwanAppTable.icon_url.name(), eVar.aus.iconUrl).add(SwanAppDbControl.SwanAppTable.max_swan_version.name(), "").add(SwanAppDbControl.SwanAppTable.min_swan_version.name(), "").add(SwanAppDbControl.SwanAppTable.name.name(), eVar.aus.appName).add(SwanAppDbControl.SwanAppTable.service_category.name(), eVar.aus.atW).add(SwanAppDbControl.SwanAppTable.subject_info.name(), eVar.aus.atX).add(SwanAppDbControl.SwanAppTable.bear_info.name(), eVar.aus.atY).add(SwanAppDbControl.SwanAppTable.sign.name(), "").add(SwanAppDbControl.SwanAppTable.type.name(), Integer.valueOf(eVar.aus.type)).add(SwanAppDbControl.SwanAppTable.is_have_zip.name(), 0).add(SwanAppDbControl.SwanAppTable.app_open_url.name(), "").add(SwanAppDbControl.SwanAppTable.app_download_url.name(), "").add(SwanAppDbControl.SwanAppTable.target_swan_version.name(), "").add(SwanAppDbControl.SwanAppTable.app_zip_size.name(), Long.valueOf(eVar.aus.blO)).add(SwanAppDbControl.SwanAppTable.pending_aps_errcode.name(), Integer.valueOf(eVar.aus.blP)).add(SwanAppDbControl.SwanAppTable.version_code.name(), eVar.aus.versionName).add(SwanAppDbControl.SwanAppTable.app_category.name(), Integer.valueOf(eVar.aus.appCategory)).add(SwanAppDbControl.SwanAppTable.orientation.name(), Integer.valueOf(eVar.aus.orientation)).add(SwanAppDbControl.SwanAppTable.max_age.name(), Long.valueOf(eVar.aus.aug)).add(SwanAppDbControl.SwanAppTable.create_time.name(), Long.valueOf(eVar.aus.createTime)).add(SwanAppDbControl.SwanAppTable.force_fetch_meta_info.name(), 0).add("app_from", eVar.auD.from).add("visit_time", Long.valueOf(eVar.auD.auC));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.database.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0109b {
        long auC;
        String from;
        String id;

        private C0109b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a extends c {
        com.baidu.swan.apps.database.a aup;

        private a() {
            super();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class e extends c {
        com.baidu.swan.pms.model.a aus;

        private e() {
            super();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static abstract class c {
        C0109b auD;

        private c() {
            this.auD = new C0109b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class d implements Comparator<c> {
        private d() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(c cVar, c cVar2) {
            return Long.compare(cVar2.auD.auC, cVar.auD.auC);
        }
    }
}

package com.baidu.swan.apps.database.a;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.an.j;
import com.baidu.swan.apps.database.SwanAppDbControl;
import com.baidu.swan.apps.scheme.actions.b.a;
import com.baidu.swan.apps.storage.b.f;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.facebook.common.internal.h;
import com.xiaomi.mipush.sdk.Constants;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import rx.schedulers.Schedulers;
/* loaded from: classes2.dex */
public class b {
    @Nullable
    private static AtomicLong auV;
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final Set<String> auU = h.L("sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u");
    private static final String[] auJ = {"_id", SwanAppDbControl.SwanAppTable.app_id.name(), SwanAppDbControl.SwanAppTable.app_key.name(), SwanAppDbControl.SwanAppTable.version.name(), SwanAppDbControl.SwanAppTable.description.name(), SwanAppDbControl.SwanAppTable.error_code.name(), SwanAppDbControl.SwanAppTable.error_detail.name(), SwanAppDbControl.SwanAppTable.error_msg.name(), SwanAppDbControl.SwanAppTable.resume_date.name(), SwanAppDbControl.SwanAppTable.icon.name(), SwanAppDbControl.SwanAppTable.icon_url.name(), SwanAppDbControl.SwanAppTable.max_swan_version.name(), SwanAppDbControl.SwanAppTable.min_swan_version.name(), SwanAppDbControl.SwanAppTable.name.name(), SwanAppDbControl.SwanAppTable.service_category.name(), SwanAppDbControl.SwanAppTable.subject_info.name(), SwanAppDbControl.SwanAppTable.bear_info.name(), SwanAppDbControl.SwanAppTable.sign.name(), SwanAppDbControl.SwanAppTable.type.name(), SwanAppDbControl.SwanAppTable.is_have_zip.name(), SwanAppDbControl.SwanAppTable.app_open_url.name(), SwanAppDbControl.SwanAppTable.app_download_url.name(), SwanAppDbControl.SwanAppTable.target_swan_version.name(), SwanAppDbControl.SwanAppTable.app_zip_size.name(), SwanAppDbControl.SwanAppTable.pending_aps_errcode.name(), SwanAppDbControl.SwanAppTable.version_code.name(), SwanAppDbControl.SwanAppTable.app_category.name(), SwanAppDbControl.SwanAppTable.orientation.name(), SwanAppDbControl.SwanAppTable.max_age.name(), SwanAppDbControl.SwanAppTable.create_time.name(), SwanAppDbControl.SwanAppTable.force_fetch_meta_info.name(), "app_from", "visit_time"};

    @WorkerThread
    public static boolean a(@NonNull ContentResolver contentResolver, @Nullable com.baidu.swan.apps.database.b bVar) {
        if (bVar == null || TextUtils.isEmpty(bVar.getAppID())) {
            return false;
        }
        if (DEBUG) {
            Log.d("SwanAppHistoryHelper", "addHistory: " + bVar.BM() + " / " + bVar.getAppID());
        }
        if (eh(bVar.getAppID())) {
            if (DEBUG) {
                Log.w("SwanAppHistoryHelper", "addHistory: isInIgnoreHisList");
                return false;
            }
            return false;
        }
        if (TextUtils.equals("0", bVar.auH)) {
            c(contentResolver, bVar.getAppID());
        }
        Uri BZ = com.baidu.swan.apps.database.a.a.BZ();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Constants.APP_ID, bVar.getAppID());
        contentValues.put("visit_time", Long.valueOf(System.currentTimeMillis()));
        contentValues.put("app_from", bVar.BN());
        Uri insert = AppRuntime.getAppContext().getContentResolver().insert(BZ, contentValues);
        if (DEBUG) {
            Log.d("SwanAppHistoryHelper", "Add history: newUri - " + (insert == null ? "NULL" : insert.toString()));
        }
        if (Ca()) {
            e(contentResolver, bVar.getAppID());
        }
        return insert == null;
    }

    private static boolean Ca() {
        boolean z = false;
        if (auV != null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - auV.get() > 86400000) {
                auV.set(currentTimeMillis);
                f.Ni().putLong("key_check_delete_swan_history", currentTimeMillis);
                return true;
            }
            return false;
        }
        synchronized (f.class) {
            if (auV == null) {
                auV = new AtomicLong(f.Ni().getLong("key_check_delete_swan_history", 0L));
                z = Ca();
            }
        }
        return z;
    }

    public static void a(com.baidu.swan.apps.ae.b bVar) {
        com.baidu.swan.apps.v.b.b vk;
        if (bVar != null && (vk = bVar.vk()) != null) {
            if (DEBUG) {
                Log.d("SwanAppHistoryHelper", "addHistoryAsync: " + vk.BM() + " / " + vk.getAppId());
            }
            final com.baidu.swan.apps.database.b bVar2 = new com.baidu.swan.apps.database.b(vk.getAppId());
            bVar2.setAppID(vk.getAppId());
            bVar2.eb(vk.getIconUrl());
            bVar2.dY(vk.BM());
            bVar2.dZ(vk.EW());
            bVar2.cr(vk.Fg());
            switch (vk.getType()) {
                case 0:
                    bVar2.ea("1");
                    break;
                case 1:
                    bVar2.ea("0");
                    break;
                case 2:
                    bVar2.ea("2");
                    break;
                case 3:
                    bVar2.ea("3");
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
            cursor = contentResolver.query(com.baidu.swan.apps.database.a.a.BX(), null, SwanAppDbControl.SwanAppTable.name.name() + " LIKE ? ", new String[]{"%" + str + "%"}, "visit_time desc  LIMIT 400");
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [265=4] */
    @NonNull
    public static Set<String> a(@NonNull ContentResolver contentResolver) {
        Cursor cursor;
        Cursor cursor2 = null;
        HashSet hashSet = new HashSet();
        try {
            try {
                cursor = contentResolver.query(com.baidu.swan.apps.database.a.a.BZ(), null, null, null, null);
                if (cursor != null) {
                    try {
                        if (cursor.moveToFirst()) {
                            do {
                                hashSet.add(cursor.getString(cursor.getColumnIndex(Constants.APP_ID)));
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
                        com.baidu.swan.c.a.c(cursor);
                        return hashSet;
                    }
                }
                if (DEBUG && cursor != null) {
                    Log.d("SwanAppHistoryHelper", "getAllHistoryIdsSet: Cursor count: " + cursor.getCount());
                }
                com.baidu.swan.c.a.c(cursor);
            } catch (Throwable th) {
                th = th;
                if (DEBUG && 0 != 0) {
                    Log.d("SwanAppHistoryHelper", "getAllHistoryIdsSet: Cursor count: " + cursor2.getCount());
                }
                com.baidu.swan.c.a.c(null);
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
            com.baidu.swan.c.a.c(null);
            throw th;
        }
        return hashSet;
    }

    public static void a(final a.InterfaceC0171a interfaceC0171a) {
        if (interfaceC0171a != null) {
            rx.d.bl("").b(Schedulers.io()).d(new rx.functions.f<String, Cursor>() { // from class: com.baidu.swan.apps.database.a.b.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.f
                /* renamed from: ei */
                public Cursor call(String str) {
                    if (com.baidu.swan.apps.core.pms.a.Ax()) {
                        return b.v(str, 400);
                    }
                    return b.b(AppRuntime.getAppContext().getContentResolver(), str);
                }
            }).a(rx.a.b.a.cLq()).c(new rx.functions.b<Cursor>() { // from class: com.baidu.swan.apps.database.a.b.2
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
                        a.InterfaceC0171a.this.ab(null);
                        return;
                    }
                    a.InterfaceC0171a.this.ab(b.f(cursor));
                }
            });
        }
    }

    public static boolean a(ContentResolver contentResolver, String str, boolean z) {
        com.baidu.swan.apps.env.b Ci;
        if (!TextUtils.isEmpty(str)) {
            r0 = contentResolver.delete(com.baidu.swan.apps.database.a.a.BZ(), "app_id=?", new String[]{str}) > 0;
            if (z && r0 && (Ci = com.baidu.swan.apps.env.d.Cg().Ci()) != null) {
                Ci.p(str, true);
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
            String db = com.baidu.swan.apps.f.a.db(str);
            if (!TextUtils.isEmpty(db)) {
                List<String> d2 = d(contentResolver, str);
                if (d2 == null || d2.size() == 0) {
                    if (DEBUG) {
                        Log.d("SwanAppHistoryHelper", "deleteOtherDevHistory finish because: other dev history is empty");
                        return;
                    }
                    return;
                }
                com.baidu.swan.apps.env.b Ci = com.baidu.swan.apps.env.d.Cg().Ci();
                if (Ci != null) {
                    if (DEBUG) {
                        Log.d("SwanAppHistoryHelper", "deleteOtherDevHistory: delete other dev SwanApp");
                    }
                    Ci.a(d2, false, false);
                }
                if (DEBUG) {
                    Log.d("SwanAppHistoryHelper", "deleteOtherDevHistory: delete other dev history");
                }
                contentResolver.delete(com.baidu.swan.apps.database.a.a.BZ(), "app_id LIKE ? AND app_id != ?", new String[]{db + "_dev%", str});
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [535=5] */
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
                String db = com.baidu.swan.apps.f.a.db(str);
                if (TextUtils.isEmpty(db)) {
                    com.baidu.swan.c.a.c(null);
                    return null;
                }
                cursor = contentResolver.query(com.baidu.swan.apps.database.a.a.BZ(), null, "app_id LIKE ? AND app_id != ?", new String[]{db + "_dev%", str}, "visit_time desc  LIMIT 400");
                if (cursor != null) {
                    try {
                        if (cursor.moveToFirst()) {
                            ArrayList arrayList = new ArrayList();
                            do {
                                String string = cursor.getString(cursor.getColumnIndex(Constants.APP_ID));
                                if (!TextUtils.isEmpty(string)) {
                                    arrayList.add(string);
                                }
                            } while (cursor.moveToNext());
                            com.baidu.swan.c.a.c(cursor);
                            return arrayList;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        if (DEBUG) {
                            e.printStackTrace();
                        }
                        com.baidu.swan.c.a.c(cursor);
                        return null;
                    }
                }
                com.baidu.swan.c.a.c(cursor);
                return null;
            } catch (Exception e3) {
                e = e3;
                cursor = null;
            } catch (Throwable th) {
                th = th;
                com.baidu.swan.c.a.c(closeable2);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            closeable2 = closeable;
        }
    }

    @WorkerThread
    private static void e(@NonNull ContentResolver contentResolver, @Nullable String str) {
        Cursor cursor;
        if (str == null) {
            str = "";
        }
        try {
            cursor = contentResolver.query(com.baidu.swan.apps.database.a.a.BZ(), null, "app_id != ?", new String[]{str, String.valueOf(400)}, "visit_time DESC limit ?,-1");
            try {
                try {
                    ArrayList arrayList = new ArrayList();
                    if (cursor != null) {
                        while (cursor.moveToNext()) {
                            String string = cursor.getString(cursor.getColumnIndex(Constants.APP_ID));
                            if (!TextUtils.isEmpty(string)) {
                                arrayList.add(string);
                            }
                        }
                    }
                    if (DEBUG) {
                        Log.i("SwanAppHistoryHelper", "tryDelUpperLimitSwanApp size=" + arrayList.size() + ", appId=" + str);
                    }
                    if (!arrayList.isEmpty()) {
                        com.baidu.swan.apps.env.b Ci = com.baidu.swan.apps.env.d.Cg().Ci();
                        if (Ci != null) {
                            Ci.d(arrayList, false);
                        }
                        StringBuilder sb = new StringBuilder();
                        int size = arrayList.size();
                        for (int i = 0; i < size; i++) {
                            sb.append('\'').append((String) arrayList.get(i)).append('\'');
                            if (i < size - 1) {
                                sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                            }
                        }
                        String str2 = "app_id in (" + sb.toString() + ")";
                        int delete = contentResolver.delete(com.baidu.swan.apps.database.a.a.BZ(), str2, null);
                        if (DEBUG) {
                            Log.i("SwanAppHistoryHelper", "tryDelUpperLimitSwanApp delete result=" + delete + ", query=" + str2);
                        }
                        com.baidu.swan.c.a.c(cursor);
                        return;
                    }
                    com.baidu.swan.c.a.c(cursor);
                } catch (Exception e2) {
                    e = e2;
                    if (DEBUG) {
                        Log.e("SwanAppHistoryHelper", "tryDelUpperLimitSwanApp error", e);
                    }
                    com.baidu.swan.c.a.c(cursor);
                }
            } catch (Throwable th) {
                th = th;
                com.baidu.swan.c.a.c(cursor);
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
            com.baidu.swan.c.a.c(cursor);
            throw th;
        }
    }

    private static boolean eh(String str) {
        return TextUtils.isEmpty(str) || auU.contains(str);
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
                String string = cursor.getString(cursor.getColumnIndex(Constants.APP_ID));
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
                    str2 = String.format(com.baidu.swan.apps.scheme.actions.b.a.aRX, string);
                } else {
                    str2 = com.baidu.swan.apps.scheme.actions.b.a.aRW + string + "\"}";
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
    public static Cursor v(@NonNull String str, int i) {
        Cursor query;
        List<c> arrayList;
        HashMap hashMap = new HashMap();
        Cursor b = b(AppRuntime.getAppContext().getContentResolver(), str);
        if (b != null && b.moveToFirst()) {
            do {
                com.baidu.swan.apps.database.a aVar = new com.baidu.swan.apps.database.a();
                SwanAppDbControl.aX(AppRuntime.getAppContext()).a(b, aVar);
                if (!TextUtils.isEmpty(aVar.appId)) {
                    a aVar2 = new a();
                    aVar2.auK = aVar;
                    aVar2.auZ.id = aVar.appId;
                    aVar2.auZ.from = b.getString(b.getColumnIndex("app_from"));
                    aVar2.auZ.auY = b.getLong(b.getColumnIndex("visit_time"));
                    hashMap.put(aVar2.auZ.id, aVar2);
                    if (DEBUG) {
                        Log.v("history_migrate_pms", "Aps&History == " + aVar.appId);
                    }
                }
            } while (b.moveToNext());
            com.baidu.swan.c.a.c(b);
            if (DEBUG) {
            }
            query = AppRuntime.getAppContext().getContentResolver().query(com.baidu.swan.apps.database.a.a.BZ(), null, null, null, null);
            HashMap hashMap2 = new HashMap();
            if (query == null) {
            }
            com.baidu.swan.c.a.c(query);
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
            MatrixCursor matrixCursor = new MatrixCursor(auJ, 50);
            int i2 = 0;
            while (r3.hasNext()) {
            }
            return matrixCursor;
        }
        com.baidu.swan.c.a.c(b);
        if (DEBUG) {
            Log.d("history_migrate_pms", "^ Aps & History 查询到 " + hashMap.size() + " 个历史记录");
        }
        query = AppRuntime.getAppContext().getContentResolver().query(com.baidu.swan.apps.database.a.a.BZ(), null, null, null, null);
        HashMap hashMap22 = new HashMap();
        if (query == null && query.moveToFirst()) {
            do {
                C0143b c0143b = new C0143b();
                c0143b.id = query.getString(query.getColumnIndex(Constants.APP_ID));
                c0143b.from = query.getString(query.getColumnIndex("app_from"));
                c0143b.auY = query.getLong(query.getColumnIndex("visit_time"));
                hashMap22.put(c0143b.id, c0143b);
                if (DEBUG) {
                    Log.v("history_migrate_pms", "History == " + c0143b.id);
                }
            } while (query.moveToNext());
            com.baidu.swan.c.a.c(query);
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
            MatrixCursor matrixCursor2 = new MatrixCursor(auJ, 50);
            int i22 = 0;
            while (r3.hasNext()) {
            }
            return matrixCursor2;
        }
        com.baidu.swan.c.a.c(query);
        if (DEBUG) {
            Log.d("history_migrate_pms", "^ History 库查询到 " + hashMap22.size() + " 个历史记录");
        }
        ArrayList<c> arrayList222 = new ArrayList();
        for (PMSAppInfo pMSAppInfo : new ArrayList(com.baidu.swan.pms.database.a.Vl().Vm().values())) {
            if (DEBUG) {
                Log.v("history_migrate_pms", "Pms == " + pMSAppInfo.appId);
            }
            if (pMSAppInfo.appName != null && pMSAppInfo.appName.contains(str) && hashMap22.containsKey(pMSAppInfo.appId)) {
                e eVar = new e();
                eVar.auZ = (C0143b) hashMap22.get(pMSAppInfo.appId);
                eVar.auN = pMSAppInfo;
                arrayList222.add(eVar);
            }
        }
        if (DEBUG) {
            Log.d("history_migrate_pms", "^ Pms & History 查询到 " + arrayList222.size() + " 个历史记录");
        }
        for (c cVar : arrayList222) {
            hashMap.put(cVar.auZ.id, cVar);
        }
        if (DEBUG) {
            Log.d("history_migrate_pms", "合并后有 " + hashMap.size() + " 个历史记录");
            Iterator it = hashMap.values().iterator();
            while (it.hasNext()) {
                Log.v("history_migrate_pms", "Migrate == " + ((c) it.next()).auZ.id);
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
        MatrixCursor matrixCursor22 = new MatrixCursor(auJ, 50);
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
            matrixCursor.newRow().add("_id", Integer.valueOf(i)).add(SwanAppDbControl.SwanAppTable.app_id.name(), aVar.auK.appId).add(SwanAppDbControl.SwanAppTable.app_key.name(), aVar.auK.appKey).add(SwanAppDbControl.SwanAppTable.version.name(), aVar.auK.version).add(SwanAppDbControl.SwanAppTable.description.name(), aVar.auK.description).add(SwanAppDbControl.SwanAppTable.error_code.name(), Integer.valueOf(aVar.auK.errorCode)).add(SwanAppDbControl.SwanAppTable.error_detail.name(), aVar.auK.errorDetail).add(SwanAppDbControl.SwanAppTable.error_msg.name(), aVar.auK.errorMsg).add(SwanAppDbControl.SwanAppTable.resume_date.name(), aVar.auK.aup).add(SwanAppDbControl.SwanAppTable.icon.name(), aVar.auK.icon).add(SwanAppDbControl.SwanAppTable.icon_url.name(), aVar.auK.iconUrl).add(SwanAppDbControl.SwanAppTable.max_swan_version.name(), aVar.auK.auq).add(SwanAppDbControl.SwanAppTable.min_swan_version.name(), aVar.auK.aur).add(SwanAppDbControl.SwanAppTable.name.name(), aVar.auK.name).add(SwanAppDbControl.SwanAppTable.service_category.name(), aVar.auK.aus).add(SwanAppDbControl.SwanAppTable.subject_info.name(), aVar.auK.aut).add(SwanAppDbControl.SwanAppTable.bear_info.name(), aVar.auK.auu).add(SwanAppDbControl.SwanAppTable.sign.name(), aVar.auK.sign).add(SwanAppDbControl.SwanAppTable.type.name(), Integer.valueOf(aVar.auK.type)).add(SwanAppDbControl.SwanAppTable.is_have_zip.name(), Integer.valueOf(aVar.auK.auv)).add(SwanAppDbControl.SwanAppTable.app_open_url.name(), aVar.auK.auw).add(SwanAppDbControl.SwanAppTable.app_download_url.name(), aVar.auK.aux).add(SwanAppDbControl.SwanAppTable.target_swan_version.name(), aVar.auK.auy).add(SwanAppDbControl.SwanAppTable.app_zip_size.name(), Long.valueOf(aVar.auK.auz)).add(SwanAppDbControl.SwanAppTable.pending_aps_errcode.name(), Integer.valueOf(aVar.auK.auA)).add(SwanAppDbControl.SwanAppTable.version_code.name(), aVar.auK.auB).add(SwanAppDbControl.SwanAppTable.app_category.name(), Integer.valueOf(aVar.auK.category)).add(SwanAppDbControl.SwanAppTable.orientation.name(), Integer.valueOf(aVar.auK.orientation)).add(SwanAppDbControl.SwanAppTable.max_age.name(), Long.valueOf(aVar.auK.auC)).add(SwanAppDbControl.SwanAppTable.create_time.name(), Long.valueOf(aVar.auK.createTime)).add(SwanAppDbControl.SwanAppTable.force_fetch_meta_info.name(), Integer.valueOf(aVar.auK.auD ? 1 : 0)).add("app_from", aVar.auZ.from).add("visit_time", Long.valueOf(aVar.auZ.auY));
            return;
        }
        e eVar = (e) cVar;
        matrixCursor.newRow().add("_id", Integer.valueOf(i)).add(SwanAppDbControl.SwanAppTable.app_id.name(), eVar.auN.appId).add(SwanAppDbControl.SwanAppTable.app_key.name(), eVar.auN.appKey).add(SwanAppDbControl.SwanAppTable.version.name(), Integer.valueOf(eVar.auN.versionCode)).add(SwanAppDbControl.SwanAppTable.description.name(), eVar.auN.description).add(SwanAppDbControl.SwanAppTable.error_code.name(), Integer.valueOf(eVar.auN.appStatus)).add(SwanAppDbControl.SwanAppTable.error_detail.name(), eVar.auN.brT).add(SwanAppDbControl.SwanAppTable.error_msg.name(), eVar.auN.brU).add(SwanAppDbControl.SwanAppTable.resume_date.name(), eVar.auN.aup).add(SwanAppDbControl.SwanAppTable.icon.name(), "").add(SwanAppDbControl.SwanAppTable.icon_url.name(), eVar.auN.iconUrl).add(SwanAppDbControl.SwanAppTable.max_swan_version.name(), "").add(SwanAppDbControl.SwanAppTable.min_swan_version.name(), "").add(SwanAppDbControl.SwanAppTable.name.name(), eVar.auN.appName).add(SwanAppDbControl.SwanAppTable.service_category.name(), eVar.auN.aus).add(SwanAppDbControl.SwanAppTable.subject_info.name(), eVar.auN.aut).add(SwanAppDbControl.SwanAppTable.bear_info.name(), eVar.auN.auu).add(SwanAppDbControl.SwanAppTable.sign.name(), "").add(SwanAppDbControl.SwanAppTable.type.name(), Integer.valueOf(eVar.auN.type)).add(SwanAppDbControl.SwanAppTable.is_have_zip.name(), 0).add(SwanAppDbControl.SwanAppTable.app_open_url.name(), "").add(SwanAppDbControl.SwanAppTable.app_download_url.name(), "").add(SwanAppDbControl.SwanAppTable.target_swan_version.name(), "").add(SwanAppDbControl.SwanAppTable.app_zip_size.name(), Long.valueOf(eVar.auN.brV)).add(SwanAppDbControl.SwanAppTable.pending_aps_errcode.name(), Integer.valueOf(eVar.auN.brW)).add(SwanAppDbControl.SwanAppTable.version_code.name(), eVar.auN.versionName).add(SwanAppDbControl.SwanAppTable.app_category.name(), Integer.valueOf(eVar.auN.appCategory)).add(SwanAppDbControl.SwanAppTable.orientation.name(), Integer.valueOf(eVar.auN.orientation)).add(SwanAppDbControl.SwanAppTable.max_age.name(), Long.valueOf(eVar.auN.auC)).add(SwanAppDbControl.SwanAppTable.create_time.name(), Long.valueOf(eVar.auN.createTime)).add(SwanAppDbControl.SwanAppTable.force_fetch_meta_info.name(), 0).add("app_from", eVar.auZ.from).add("visit_time", Long.valueOf(eVar.auZ.auY));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.database.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0143b {
        long auY;
        String from;
        String id;

        private C0143b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a extends c {
        com.baidu.swan.apps.database.a auK;

        private a() {
            super();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class e extends c {
        PMSAppInfo auN;

        private e() {
            super();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static abstract class c {
        C0143b auZ;

        private c() {
            this.auZ = new C0143b();
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
            return Long.compare(cVar2.auZ.auY, cVar.auZ.auY);
        }
    }
}

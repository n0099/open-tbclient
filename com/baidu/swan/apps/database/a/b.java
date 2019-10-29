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
import com.baidu.android.imsdk.IMConstants;
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
    private static AtomicLong aPm;
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final Set<String> aPl = h.J("sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u");
    private static final String[] aPa = {IMConstants.MSG_ROW_ID, SwanAppDbControl.SwanAppTable.app_id.name(), SwanAppDbControl.SwanAppTable.app_key.name(), SwanAppDbControl.SwanAppTable.version.name(), SwanAppDbControl.SwanAppTable.description.name(), SwanAppDbControl.SwanAppTable.error_code.name(), SwanAppDbControl.SwanAppTable.error_detail.name(), SwanAppDbControl.SwanAppTable.error_msg.name(), SwanAppDbControl.SwanAppTable.resume_date.name(), SwanAppDbControl.SwanAppTable.icon.name(), SwanAppDbControl.SwanAppTable.icon_url.name(), SwanAppDbControl.SwanAppTable.max_swan_version.name(), SwanAppDbControl.SwanAppTable.min_swan_version.name(), SwanAppDbControl.SwanAppTable.name.name(), SwanAppDbControl.SwanAppTable.service_category.name(), SwanAppDbControl.SwanAppTable.subject_info.name(), SwanAppDbControl.SwanAppTable.bear_info.name(), SwanAppDbControl.SwanAppTable.sign.name(), SwanAppDbControl.SwanAppTable.type.name(), SwanAppDbControl.SwanAppTable.is_have_zip.name(), SwanAppDbControl.SwanAppTable.app_open_url.name(), SwanAppDbControl.SwanAppTable.app_download_url.name(), SwanAppDbControl.SwanAppTable.target_swan_version.name(), SwanAppDbControl.SwanAppTable.app_zip_size.name(), SwanAppDbControl.SwanAppTable.pending_aps_errcode.name(), SwanAppDbControl.SwanAppTable.version_code.name(), SwanAppDbControl.SwanAppTable.app_category.name(), SwanAppDbControl.SwanAppTable.orientation.name(), SwanAppDbControl.SwanAppTable.max_age.name(), SwanAppDbControl.SwanAppTable.create_time.name(), SwanAppDbControl.SwanAppTable.force_fetch_meta_info.name(), "app_from", "visit_time"};

    @WorkerThread
    public static boolean a(@NonNull ContentResolver contentResolver, @Nullable com.baidu.swan.apps.database.b bVar) {
        if (bVar == null || TextUtils.isEmpty(bVar.getAppID())) {
            return false;
        }
        if (DEBUG) {
            Log.d("SwanAppHistoryHelper", "addHistory: " + bVar.Ht() + " / " + bVar.getAppID());
        }
        if (eV(bVar.getAppID())) {
            if (DEBUG) {
                Log.w("SwanAppHistoryHelper", "addHistory: isInIgnoreHisList");
                return false;
            }
            return false;
        }
        if (TextUtils.equals("0", bVar.aOY)) {
            c(contentResolver, bVar.getAppID());
        }
        Uri HG = com.baidu.swan.apps.database.a.a.HG();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Constants.APP_ID, bVar.getAppID());
        contentValues.put("visit_time", Long.valueOf(System.currentTimeMillis()));
        contentValues.put("app_from", bVar.Hu());
        Uri insert = AppRuntime.getAppContext().getContentResolver().insert(HG, contentValues);
        if (DEBUG) {
            Log.d("SwanAppHistoryHelper", "Add history: newUri - " + (insert == null ? "NULL" : insert.toString()));
        }
        if (HH()) {
            e(contentResolver, bVar.getAppID());
        }
        return insert == null;
    }

    private static boolean HH() {
        boolean z = false;
        if (aPm != null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - aPm.get() > 86400000) {
                aPm.set(currentTimeMillis);
                f.SR().putLong("key_check_delete_swan_history", currentTimeMillis);
                return true;
            }
            return false;
        }
        synchronized (f.class) {
            if (aPm == null) {
                aPm = new AtomicLong(f.SR().getLong("key_check_delete_swan_history", 0L));
                z = HH();
            }
        }
        return z;
    }

    public static void a(com.baidu.swan.apps.ae.b bVar) {
        com.baidu.swan.apps.v.b.b AJ;
        if (bVar != null && (AJ = bVar.AJ()) != null) {
            if (DEBUG) {
                Log.d("SwanAppHistoryHelper", "addHistoryAsync: " + AJ.Ht() + " / " + AJ.getAppId());
            }
            final com.baidu.swan.apps.database.b bVar2 = new com.baidu.swan.apps.database.b(AJ.getAppId());
            bVar2.setAppID(AJ.getAppId());
            bVar2.eP(AJ.getIconUrl());
            bVar2.eM(AJ.Ht());
            bVar2.eN(AJ.KE());
            bVar2.m17do(AJ.KO());
            switch (AJ.getType()) {
                case 0:
                    bVar2.eO("1");
                    break;
                case 1:
                    bVar2.eO("0");
                    break;
                case 2:
                    bVar2.eO("2");
                    break;
                case 3:
                    bVar2.eO("3");
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
            cursor = contentResolver.query(com.baidu.swan.apps.database.a.a.HE(), null, SwanAppDbControl.SwanAppTable.name.name() + " LIKE ? ", new String[]{"%" + str + "%"}, "visit_time desc  LIMIT 400");
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
                cursor = contentResolver.query(com.baidu.swan.apps.database.a.a.HG(), null, null, null, null);
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
                        com.baidu.swan.c.a.b(cursor);
                        return hashSet;
                    }
                }
                if (DEBUG && cursor != null) {
                    Log.d("SwanAppHistoryHelper", "getAllHistoryIdsSet: Cursor count: " + cursor.getCount());
                }
                com.baidu.swan.c.a.b(cursor);
            } catch (Throwable th) {
                th = th;
                if (DEBUG && 0 != 0) {
                    Log.d("SwanAppHistoryHelper", "getAllHistoryIdsSet: Cursor count: " + cursor2.getCount());
                }
                com.baidu.swan.c.a.b(null);
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
            com.baidu.swan.c.a.b(null);
            throw th;
        }
        return hashSet;
    }

    public static void a(final a.InterfaceC0214a interfaceC0214a) {
        if (interfaceC0214a != null) {
            rx.d.bh("").b(Schedulers.io()).d(new rx.functions.f<String, Cursor>() { // from class: com.baidu.swan.apps.database.a.b.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.f
                /* renamed from: eW */
                public Cursor call(String str) {
                    if (com.baidu.swan.apps.core.pms.a.Ge()) {
                        return b.v(str, 400);
                    }
                    return b.b(AppRuntime.getAppContext().getContentResolver(), str);
                }
            }).a(rx.a.b.a.cOs()).c(new rx.functions.b<Cursor>() { // from class: com.baidu.swan.apps.database.a.b.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                /* renamed from: g */
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
                        a.InterfaceC0214a.this.az(null);
                        return;
                    }
                    a.InterfaceC0214a.this.az(b.e(cursor));
                }
            });
        }
    }

    public static boolean a(ContentResolver contentResolver, String str, boolean z) {
        com.baidu.swan.apps.env.b HP;
        if (!TextUtils.isEmpty(str)) {
            r0 = contentResolver.delete(com.baidu.swan.apps.database.a.a.HG(), "app_id=?", new String[]{str}) > 0;
            if (z && r0 && (HP = com.baidu.swan.apps.env.d.HN().HP()) != null) {
                HP.s(str, true);
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
            String dR = com.baidu.swan.apps.f.a.dR(str);
            if (!TextUtils.isEmpty(dR)) {
                List<String> d2 = d(contentResolver, str);
                if (d2 == null || d2.size() == 0) {
                    if (DEBUG) {
                        Log.d("SwanAppHistoryHelper", "deleteOtherDevHistory finish because: other dev history is empty");
                        return;
                    }
                    return;
                }
                com.baidu.swan.apps.env.b HP = com.baidu.swan.apps.env.d.HN().HP();
                if (HP != null) {
                    if (DEBUG) {
                        Log.d("SwanAppHistoryHelper", "deleteOtherDevHistory: delete other dev SwanApp");
                    }
                    HP.b(d2, false, false);
                }
                if (DEBUG) {
                    Log.d("SwanAppHistoryHelper", "deleteOtherDevHistory: delete other dev history");
                }
                contentResolver.delete(com.baidu.swan.apps.database.a.a.HG(), "app_id LIKE ? AND app_id != ?", new String[]{dR + "_dev%", str});
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
                String dR = com.baidu.swan.apps.f.a.dR(str);
                if (TextUtils.isEmpty(dR)) {
                    com.baidu.swan.c.a.b(null);
                    return null;
                }
                cursor = contentResolver.query(com.baidu.swan.apps.database.a.a.HG(), null, "app_id LIKE ? AND app_id != ?", new String[]{dR + "_dev%", str}, "visit_time desc  LIMIT 400");
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
                            com.baidu.swan.c.a.b(cursor);
                            return arrayList;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        if (DEBUG) {
                            e.printStackTrace();
                        }
                        com.baidu.swan.c.a.b(cursor);
                        return null;
                    }
                }
                com.baidu.swan.c.a.b(cursor);
                return null;
            } catch (Exception e3) {
                e = e3;
                cursor = null;
            } catch (Throwable th) {
                th = th;
                com.baidu.swan.c.a.b(closeable2);
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
            cursor = contentResolver.query(com.baidu.swan.apps.database.a.a.HG(), null, "app_id != ?", new String[]{str, String.valueOf(400)}, "visit_time DESC limit ?,-1");
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
                        com.baidu.swan.apps.env.b HP = com.baidu.swan.apps.env.d.HN().HP();
                        if (HP != null) {
                            HP.g(arrayList, false);
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
                        int delete = contentResolver.delete(com.baidu.swan.apps.database.a.a.HG(), str2, null);
                        if (DEBUG) {
                            Log.i("SwanAppHistoryHelper", "tryDelUpperLimitSwanApp delete result=" + delete + ", query=" + str2);
                        }
                        com.baidu.swan.c.a.b(cursor);
                        return;
                    }
                    com.baidu.swan.c.a.b(cursor);
                } catch (Exception e2) {
                    e = e2;
                    if (DEBUG) {
                        Log.e("SwanAppHistoryHelper", "tryDelUpperLimitSwanApp error", e);
                    }
                    com.baidu.swan.c.a.b(cursor);
                }
            } catch (Throwable th) {
                th = th;
                com.baidu.swan.c.a.b(cursor);
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
            com.baidu.swan.c.a.b(cursor);
            throw th;
        }
    }

    private static boolean eV(String str) {
        return TextUtils.isEmpty(str) || aPl.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public static JSONObject e(Cursor cursor) {
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
                    str2 = String.format(com.baidu.swan.apps.scheme.actions.b.a.bmj, string);
                } else {
                    str2 = com.baidu.swan.apps.scheme.actions.b.a.bmi + string + "\"}";
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
                SwanAppDbControl.aZ(AppRuntime.getAppContext()).a(b, aVar);
                if (!TextUtils.isEmpty(aVar.appId)) {
                    a aVar2 = new a();
                    aVar2.aPb = aVar;
                    aVar2.aPq.id = aVar.appId;
                    aVar2.aPq.from = b.getString(b.getColumnIndex("app_from"));
                    aVar2.aPq.aPp = b.getLong(b.getColumnIndex("visit_time"));
                    hashMap.put(aVar2.aPq.id, aVar2);
                    if (DEBUG) {
                        Log.v("history_migrate_pms", "Aps&History == " + aVar.appId);
                    }
                }
            } while (b.moveToNext());
            com.baidu.swan.c.a.b(b);
            if (DEBUG) {
            }
            query = AppRuntime.getAppContext().getContentResolver().query(com.baidu.swan.apps.database.a.a.HG(), null, null, null, null);
            HashMap hashMap2 = new HashMap();
            if (query == null) {
            }
            com.baidu.swan.c.a.b(query);
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
            MatrixCursor matrixCursor = new MatrixCursor(aPa, 50);
            int i2 = 0;
            while (r3.hasNext()) {
            }
            return matrixCursor;
        }
        com.baidu.swan.c.a.b(b);
        if (DEBUG) {
            Log.d("history_migrate_pms", "^ Aps & History 查询到 " + hashMap.size() + " 个历史记录");
        }
        query = AppRuntime.getAppContext().getContentResolver().query(com.baidu.swan.apps.database.a.a.HG(), null, null, null, null);
        HashMap hashMap22 = new HashMap();
        if (query == null && query.moveToFirst()) {
            do {
                C0186b c0186b = new C0186b();
                c0186b.id = query.getString(query.getColumnIndex(Constants.APP_ID));
                c0186b.from = query.getString(query.getColumnIndex("app_from"));
                c0186b.aPp = query.getLong(query.getColumnIndex("visit_time"));
                hashMap22.put(c0186b.id, c0186b);
                if (DEBUG) {
                    Log.v("history_migrate_pms", "History == " + c0186b.id);
                }
            } while (query.moveToNext());
            com.baidu.swan.c.a.b(query);
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
            MatrixCursor matrixCursor2 = new MatrixCursor(aPa, 50);
            int i22 = 0;
            while (r3.hasNext()) {
            }
            return matrixCursor2;
        }
        com.baidu.swan.c.a.b(query);
        if (DEBUG) {
            Log.d("history_migrate_pms", "^ History 库查询到 " + hashMap22.size() + " 个历史记录");
        }
        ArrayList<c> arrayList222 = new ArrayList();
        for (PMSAppInfo pMSAppInfo : new ArrayList(com.baidu.swan.pms.database.a.aaX().aaY().values())) {
            if (DEBUG) {
                Log.v("history_migrate_pms", "Pms == " + pMSAppInfo.appId);
            }
            if (pMSAppInfo.appName != null && pMSAppInfo.appName.contains(str) && hashMap22.containsKey(pMSAppInfo.appId)) {
                e eVar = new e();
                eVar.aPq = (C0186b) hashMap22.get(pMSAppInfo.appId);
                eVar.aPe = pMSAppInfo;
                arrayList222.add(eVar);
            }
        }
        if (DEBUG) {
            Log.d("history_migrate_pms", "^ Pms & History 查询到 " + arrayList222.size() + " 个历史记录");
        }
        for (c cVar : arrayList222) {
            hashMap.put(cVar.aPq.id, cVar);
        }
        if (DEBUG) {
            Log.d("history_migrate_pms", "合并后有 " + hashMap.size() + " 个历史记录");
            Iterator it = hashMap.values().iterator();
            while (it.hasNext()) {
                Log.v("history_migrate_pms", "Migrate == " + ((c) it.next()).aPq.id);
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
        MatrixCursor matrixCursor22 = new MatrixCursor(aPa, 50);
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
            matrixCursor.newRow().add(IMConstants.MSG_ROW_ID, Integer.valueOf(i)).add(SwanAppDbControl.SwanAppTable.app_id.name(), aVar.aPb.appId).add(SwanAppDbControl.SwanAppTable.app_key.name(), aVar.aPb.appKey).add(SwanAppDbControl.SwanAppTable.version.name(), aVar.aPb.version).add(SwanAppDbControl.SwanAppTable.description.name(), aVar.aPb.description).add(SwanAppDbControl.SwanAppTable.error_code.name(), Integer.valueOf(aVar.aPb.errorCode)).add(SwanAppDbControl.SwanAppTable.error_detail.name(), aVar.aPb.errorDetail).add(SwanAppDbControl.SwanAppTable.error_msg.name(), aVar.aPb.errorMsg).add(SwanAppDbControl.SwanAppTable.resume_date.name(), aVar.aPb.aOG).add(SwanAppDbControl.SwanAppTable.icon.name(), aVar.aPb.icon).add(SwanAppDbControl.SwanAppTable.icon_url.name(), aVar.aPb.iconUrl).add(SwanAppDbControl.SwanAppTable.max_swan_version.name(), aVar.aPb.aOH).add(SwanAppDbControl.SwanAppTable.min_swan_version.name(), aVar.aPb.aOI).add(SwanAppDbControl.SwanAppTable.name.name(), aVar.aPb.name).add(SwanAppDbControl.SwanAppTable.service_category.name(), aVar.aPb.aOJ).add(SwanAppDbControl.SwanAppTable.subject_info.name(), aVar.aPb.aOK).add(SwanAppDbControl.SwanAppTable.bear_info.name(), aVar.aPb.aOL).add(SwanAppDbControl.SwanAppTable.sign.name(), aVar.aPb.sign).add(SwanAppDbControl.SwanAppTable.type.name(), Integer.valueOf(aVar.aPb.type)).add(SwanAppDbControl.SwanAppTable.is_have_zip.name(), Integer.valueOf(aVar.aPb.aOM)).add(SwanAppDbControl.SwanAppTable.app_open_url.name(), aVar.aPb.aON).add(SwanAppDbControl.SwanAppTable.app_download_url.name(), aVar.aPb.aOO).add(SwanAppDbControl.SwanAppTable.target_swan_version.name(), aVar.aPb.aOP).add(SwanAppDbControl.SwanAppTable.app_zip_size.name(), Long.valueOf(aVar.aPb.aOQ)).add(SwanAppDbControl.SwanAppTable.pending_aps_errcode.name(), Integer.valueOf(aVar.aPb.aOR)).add(SwanAppDbControl.SwanAppTable.version_code.name(), aVar.aPb.aOS).add(SwanAppDbControl.SwanAppTable.app_category.name(), Integer.valueOf(aVar.aPb.category)).add(SwanAppDbControl.SwanAppTable.orientation.name(), Integer.valueOf(aVar.aPb.orientation)).add(SwanAppDbControl.SwanAppTable.max_age.name(), Long.valueOf(aVar.aPb.aOT)).add(SwanAppDbControl.SwanAppTable.create_time.name(), Long.valueOf(aVar.aPb.createTime)).add(SwanAppDbControl.SwanAppTable.force_fetch_meta_info.name(), Integer.valueOf(aVar.aPb.aOU ? 1 : 0)).add("app_from", aVar.aPq.from).add("visit_time", Long.valueOf(aVar.aPq.aPp));
            return;
        }
        e eVar = (e) cVar;
        matrixCursor.newRow().add(IMConstants.MSG_ROW_ID, Integer.valueOf(i)).add(SwanAppDbControl.SwanAppTable.app_id.name(), eVar.aPe.appId).add(SwanAppDbControl.SwanAppTable.app_key.name(), eVar.aPe.appKey).add(SwanAppDbControl.SwanAppTable.version.name(), Integer.valueOf(eVar.aPe.versionCode)).add(SwanAppDbControl.SwanAppTable.description.name(), eVar.aPe.description).add(SwanAppDbControl.SwanAppTable.error_code.name(), Integer.valueOf(eVar.aPe.appStatus)).add(SwanAppDbControl.SwanAppTable.error_detail.name(), eVar.aPe.bLQ).add(SwanAppDbControl.SwanAppTable.error_msg.name(), eVar.aPe.bLR).add(SwanAppDbControl.SwanAppTable.resume_date.name(), eVar.aPe.aOG).add(SwanAppDbControl.SwanAppTable.icon.name(), "").add(SwanAppDbControl.SwanAppTable.icon_url.name(), eVar.aPe.iconUrl).add(SwanAppDbControl.SwanAppTable.max_swan_version.name(), "").add(SwanAppDbControl.SwanAppTable.min_swan_version.name(), "").add(SwanAppDbControl.SwanAppTable.name.name(), eVar.aPe.appName).add(SwanAppDbControl.SwanAppTable.service_category.name(), eVar.aPe.aOJ).add(SwanAppDbControl.SwanAppTable.subject_info.name(), eVar.aPe.aOK).add(SwanAppDbControl.SwanAppTable.bear_info.name(), eVar.aPe.aOL).add(SwanAppDbControl.SwanAppTable.sign.name(), "").add(SwanAppDbControl.SwanAppTable.type.name(), Integer.valueOf(eVar.aPe.type)).add(SwanAppDbControl.SwanAppTable.is_have_zip.name(), 0).add(SwanAppDbControl.SwanAppTable.app_open_url.name(), "").add(SwanAppDbControl.SwanAppTable.app_download_url.name(), "").add(SwanAppDbControl.SwanAppTable.target_swan_version.name(), "").add(SwanAppDbControl.SwanAppTable.app_zip_size.name(), Long.valueOf(eVar.aPe.bLS)).add(SwanAppDbControl.SwanAppTable.pending_aps_errcode.name(), Integer.valueOf(eVar.aPe.bLT)).add(SwanAppDbControl.SwanAppTable.version_code.name(), eVar.aPe.versionName).add(SwanAppDbControl.SwanAppTable.app_category.name(), Integer.valueOf(eVar.aPe.bLU)).add(SwanAppDbControl.SwanAppTable.orientation.name(), Integer.valueOf(eVar.aPe.orientation)).add(SwanAppDbControl.SwanAppTable.max_age.name(), Long.valueOf(eVar.aPe.aOT)).add(SwanAppDbControl.SwanAppTable.create_time.name(), Long.valueOf(eVar.aPe.createTime)).add(SwanAppDbControl.SwanAppTable.force_fetch_meta_info.name(), 0).add("app_from", eVar.aPq.from).add("visit_time", Long.valueOf(eVar.aPq.aPp));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.database.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0186b {
        long aPp;
        String from;
        String id;

        private C0186b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a extends c {
        com.baidu.swan.apps.database.a aPb;

        private a() {
            super();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class e extends c {
        PMSAppInfo aPe;

        private e() {
            super();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static abstract class c {
        C0186b aPq;

        private c() {
            this.aPq = new C0186b();
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
            return Long.compare(cVar2.aPq.aPp, cVar.aPq.aPp);
        }
    }
}

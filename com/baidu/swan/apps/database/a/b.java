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
import com.baidu.swan.apps.ap.p;
import com.baidu.swan.apps.database.SwanAppDbControl;
import com.baidu.swan.apps.env.c.b;
import com.baidu.swan.apps.scheme.actions.c.a;
import com.baidu.swan.apps.storage.c.h;
import com.baidu.swan.apps.u.c.b;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.facebook.common.internal.i;
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
import rx.functions.f;
import rx.schedulers.Schedulers;
/* loaded from: classes10.dex */
public class b implements com.baidu.swan.apps.env.c.b {
    @Nullable
    private static AtomicLong cRz;
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final Set<String> cRy = i.ekc();
    private static final String[] cRm = {IMConstants.MSG_ROW_ID, SwanAppDbControl.SwanAppTable.app_id.name(), SwanAppDbControl.SwanAppTable.app_key.name(), SwanAppDbControl.SwanAppTable.version.name(), SwanAppDbControl.SwanAppTable.description.name(), SwanAppDbControl.SwanAppTable.error_code.name(), SwanAppDbControl.SwanAppTable.error_detail.name(), SwanAppDbControl.SwanAppTable.error_msg.name(), SwanAppDbControl.SwanAppTable.resume_date.name(), SwanAppDbControl.SwanAppTable.icon.name(), SwanAppDbControl.SwanAppTable.icon_url.name(), SwanAppDbControl.SwanAppTable.max_swan_version.name(), SwanAppDbControl.SwanAppTable.min_swan_version.name(), SwanAppDbControl.SwanAppTable.name.name(), SwanAppDbControl.SwanAppTable.service_category.name(), SwanAppDbControl.SwanAppTable.subject_info.name(), SwanAppDbControl.SwanAppTable.bear_info.name(), SwanAppDbControl.SwanAppTable.sign.name(), SwanAppDbControl.SwanAppTable.type.name(), SwanAppDbControl.SwanAppTable.is_have_zip.name(), SwanAppDbControl.SwanAppTable.app_open_url.name(), SwanAppDbControl.SwanAppTable.app_download_url.name(), SwanAppDbControl.SwanAppTable.target_swan_version.name(), SwanAppDbControl.SwanAppTable.app_zip_size.name(), SwanAppDbControl.SwanAppTable.pending_aps_errcode.name(), SwanAppDbControl.SwanAppTable.version_code.name(), SwanAppDbControl.SwanAppTable.app_category.name(), SwanAppDbControl.SwanAppTable.orientation.name(), SwanAppDbControl.SwanAppTable.max_age.name(), SwanAppDbControl.SwanAppTable.create_time.name(), SwanAppDbControl.SwanAppTable.force_fetch_meta_info.name(), "app_from", "visit_time", SwanAppDbControl.SwanAppTable.pay_protected.name(), "customer_service", "global_notice", "global_private", "pa_number", Constants.PHONE_BRAND, SwanAppDbControl.SwanAppTable.quick_app_key.name()};

    @WorkerThread
    public static boolean a(@NonNull ContentResolver contentResolver, @Nullable com.baidu.swan.apps.database.b bVar, b.C0439b c0439b) {
        if (bVar == null || TextUtils.isEmpty(bVar.getAppID())) {
            return false;
        }
        if (DEBUG) {
            Log.d("SwanAppHistoryHelper", "addHistory: " + bVar.asF() + " / " + bVar.getAppID());
        }
        if (nP(bVar.getAppID())) {
            if (DEBUG) {
                Log.w("SwanAppHistoryHelper", "addHistory: isInIgnoreHisList");
                return false;
            }
            return false;
        }
        if (TextUtils.equals("0", bVar.cRj)) {
            a(contentResolver, bVar.getAppID(), com.baidu.swan.apps.env.c.c.a(c0439b).iv(1).atO());
        }
        Uri asX = com.baidu.swan.apps.database.a.a.asX();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", bVar.getAppID());
        contentValues.put("visit_time", Long.valueOf(System.currentTimeMillis()));
        contentValues.put("app_from", bVar.asG());
        try {
            Uri insert = AppRuntime.getAppContext().getContentResolver().insert(asX, contentValues);
            if (DEBUG) {
                Log.d("SwanAppHistoryHelper", "Add history: newUri - " + (insert == null ? "NULL" : insert.toString()));
            }
            if (asY()) {
                b(contentResolver, bVar.getAppID(), com.baidu.swan.apps.env.c.c.a(c0439b).iv(2).atO());
            }
            return insert != null;
        } catch (Exception e2) {
            com.baidu.swan.apps.core.e.H(asX.toString(), bVar.getAppID(), e2.toString());
            if (DEBUG) {
                Log.e("SwanAppHistoryHelper", "encounter error while adding swan history" + e2.toString());
                throw new RuntimeException("encounter error while adding swan history, only throw in debug mode", e2);
            }
            return false;
        }
    }

    private static boolean asY() {
        boolean z = false;
        if (cRz != null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - cRz.get() > 86400000) {
                cRz.set(currentTimeMillis);
                h.aKS().putLong("key_check_delete_swan_history", currentTimeMillis);
                return true;
            }
            return false;
        }
        synchronized (h.class) {
            if (cRz == null) {
                cRz = new AtomicLong(h.aKS().getLong("key_check_delete_swan_history", 0L));
                z = asY();
            }
        }
        return z;
    }

    public static void a(com.baidu.swan.apps.runtime.e eVar, final b.C0439b c0439b) {
        b.a afO;
        if (eVar != null && (afO = eVar.afO()) != null && !TextUtils.equals("1", afO.ayL())) {
            String appId = afO.getAppId();
            if (!TextUtils.equals("sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u", appId) && !TextUtils.equals("g4X7FfGEDt7G1ksLibU22o0wB2p49W0D", appId) && !TextUtils.equals("VlKQRMSyT32ln2AG84dmTjW6qldpGsNk", appId)) {
                if (DEBUG) {
                    Log.d("SwanAppHistoryHelper", "addHistoryAsync: " + afO.asF() + " / " + appId);
                }
                final com.baidu.swan.apps.database.b bVar = new com.baidu.swan.apps.database.b(appId);
                bVar.setAppID(appId);
                bVar.nN(afO.getIconUrl());
                bVar.nL(afO.asF());
                bVar.nM(afO.ayD());
                bVar.setAppFrameType(afO.getAppFrameType());
                switch (afO.getType()) {
                    case 0:
                        bVar.it("1");
                        break;
                    case 1:
                        bVar.it("0");
                        break;
                    case 2:
                        bVar.it("2");
                        break;
                    case 3:
                        bVar.it("3");
                        break;
                }
                p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.database.a.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        boolean a2 = b.a(AppRuntime.getAppContext().getContentResolver(), com.baidu.swan.apps.database.b.this, c0439b);
                        if (b.DEBUG && !a2) {
                            Log.e("SwanAppHistoryHelper", "addHistoryAsync Failed!");
                        }
                    }
                }, "saveSwanAppInHistoryAsync");
            }
        }
    }

    @Nullable
    public static Cursor a(@NonNull ContentResolver contentResolver, @NonNull String str) {
        Cursor cursor;
        try {
            cursor = contentResolver.query(com.baidu.swan.apps.database.a.a.asV(), null, SwanAppDbControl.SwanAppTable.name.name() + " LIKE ? ", new String[]{"%" + str + "%"}, "visit_time desc  LIMIT 400");
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [319=4] */
    @NonNull
    public static Set<String> a(@NonNull ContentResolver contentResolver) {
        Cursor cursor;
        Cursor cursor2 = null;
        HashSet hashSet = new HashSet();
        try {
            try {
                cursor = contentResolver.query(com.baidu.swan.apps.database.a.a.asX(), null, null, null, null);
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
                        com.baidu.swan.c.d.closeSafely(cursor);
                        return hashSet;
                    }
                }
                if (DEBUG && cursor != null) {
                    Log.d("SwanAppHistoryHelper", "getAllHistoryIdsSet: Cursor count: " + cursor.getCount());
                }
                com.baidu.swan.c.d.closeSafely(cursor);
            } catch (Throwable th) {
                th = th;
                if (DEBUG && 0 != 0) {
                    Log.d("SwanAppHistoryHelper", "getAllHistoryIdsSet: Cursor count: " + cursor2.getCount());
                }
                com.baidu.swan.c.d.closeSafely(null);
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
            com.baidu.swan.c.d.closeSafely(null);
            throw th;
        }
        return hashSet;
    }

    public static void a(final a.InterfaceC0473a interfaceC0473a) {
        if (interfaceC0473a != null) {
            rx.d.cd("").d(Schedulers.io()).d(new f<String, Cursor>() { // from class: com.baidu.swan.apps.database.a.b.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.f
                /* renamed from: nQ */
                public Cursor call(String str) {
                    return b.Q(str, 400);
                }
            }).c(rx.a.b.a.eFz()).c(new rx.functions.b<Cursor>() { // from class: com.baidu.swan.apps.database.a.b.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                /* renamed from: f */
                public void call(Cursor cursor) {
                    if (cursor == null || !cursor.moveToFirst()) {
                        if (b.DEBUG) {
                            Log.d("SwanAppHistoryHelper", "historyList == null || historyList.size() == 0");
                        }
                        com.baidu.swan.apps.media.image.a.closeSafely(cursor);
                        a.InterfaceC0473a.this.bR(null);
                        return;
                    }
                    a.InterfaceC0473a.this.bR(b.d(cursor));
                }
            });
        }
    }

    public static boolean a(ContentResolver contentResolver, String str, boolean z, b.C0439b c0439b) {
        com.baidu.swan.apps.env.c atj;
        if (!TextUtils.isEmpty(str)) {
            r0 = contentResolver.delete(com.baidu.swan.apps.database.a.a.asX(), "app_id=?", new String[]{str}) > 0;
            if (z && r0 && (atj = com.baidu.swan.apps.env.e.ati().atj()) != null) {
                atj.a(str, true, com.baidu.swan.apps.env.c.c.a(c0439b).iv(4).atO());
            }
            if (DEBUG) {
                Log.d("SwanAppHistoryHelper", "deleteHistory: " + str + " isSuccess: " + r0);
            }
        }
        return r0;
    }

    private static void a(@NonNull ContentResolver contentResolver, @Nullable String str, b.C0439b c0439b) {
        if (DEBUG) {
            Log.d("SwanAppHistoryHelper", "start deleteOtherDevHistory: ");
        }
        if (!TextUtils.isEmpty(str)) {
            String mb = com.baidu.swan.apps.f.a.mb(str);
            if (!TextUtils.isEmpty(mb)) {
                List<String> b = b(contentResolver, str);
                if (b == null || b.size() == 0) {
                    if (DEBUG) {
                        Log.d("SwanAppHistoryHelper", "deleteOtherDevHistory finish because: other dev history is empty");
                        return;
                    }
                    return;
                }
                com.baidu.swan.apps.env.c atj = com.baidu.swan.apps.env.e.ati().atj();
                if (atj != null) {
                    if (DEBUG) {
                        Log.d("SwanAppHistoryHelper", "deleteOtherDevHistory: delete other dev SwanApp");
                    }
                    atj.a(b, false, false, c0439b);
                }
                if (DEBUG) {
                    Log.d("SwanAppHistoryHelper", "deleteOtherDevHistory: delete other dev history");
                }
                contentResolver.delete(com.baidu.swan.apps.database.a.a.asX(), "app_id LIKE ? AND app_id != ?", new String[]{mb + "_dev%", str});
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [567=6] */
    /* JADX WARN: Not initialized variable reg: 1, insn: 0x00a6: MOVE  (r6 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:31:0x00a6 */
    @Nullable
    private static List<String> b(@NonNull ContentResolver contentResolver, @Nullable String str) {
        Closeable closeable;
        Cursor cursor;
        Closeable closeable2 = null;
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                String mb = com.baidu.swan.apps.f.a.mb(str);
                if (TextUtils.isEmpty(mb)) {
                    com.baidu.swan.c.d.closeSafely(null);
                    return null;
                }
                cursor = contentResolver.query(com.baidu.swan.apps.database.a.a.asX(), null, "app_id LIKE ? AND app_id != ?", new String[]{mb + "_dev%", str}, "visit_time desc  LIMIT 400");
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
                            com.baidu.swan.c.d.closeSafely(cursor);
                            return arrayList;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        if (DEBUG) {
                            e.printStackTrace();
                        }
                        com.baidu.swan.c.d.closeSafely(cursor);
                        return null;
                    }
                }
                com.baidu.swan.c.d.closeSafely(cursor);
                return null;
            } catch (Exception e3) {
                e = e3;
                cursor = null;
            } catch (Throwable th) {
                th = th;
                com.baidu.swan.c.d.closeSafely(closeable2);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            closeable2 = closeable;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [631=4] */
    @WorkerThread
    private static void b(@NonNull ContentResolver contentResolver, @Nullable String str, b.C0439b c0439b) {
        Cursor cursor;
        if (str == null) {
            str = "";
        }
        try {
            cursor = contentResolver.query(com.baidu.swan.apps.database.a.a.asX(), null, "app_id != ?", new String[]{str, String.valueOf(400)}, "visit_time DESC limit ?,-1");
            try {
                try {
                    ArrayList arrayList = new ArrayList();
                    if (cursor != null) {
                        while (cursor.moveToNext()) {
                            String string = cursor.getString(cursor.getColumnIndex("app_id"));
                            if (!TextUtils.isEmpty(string)) {
                                arrayList.add(string);
                            }
                        }
                    }
                    if (DEBUG) {
                        Log.i("SwanAppHistoryHelper", "tryDelUpperLimitSwanApp size=" + arrayList.size() + ", appId=" + str);
                    }
                    if (arrayList.isEmpty()) {
                        com.baidu.swan.c.d.closeSafely(cursor);
                        return;
                    }
                    com.baidu.swan.apps.env.c atj = com.baidu.swan.apps.env.e.ati().atj();
                    if (atj != null) {
                        atj.a((List<String>) arrayList, false, c0439b);
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
                    int delete = contentResolver.delete(com.baidu.swan.apps.database.a.a.asX(), str2, null);
                    if (DEBUG) {
                        Log.i("SwanAppHistoryHelper", "tryDelUpperLimitSwanApp delete result=" + delete + ", query=" + str2);
                    }
                    com.baidu.swan.c.d.closeSafely(cursor);
                } catch (Exception e2) {
                    e = e2;
                    if (DEBUG) {
                        Log.e("SwanAppHistoryHelper", "tryDelUpperLimitSwanApp error", e);
                    }
                    com.baidu.swan.c.d.closeSafely(cursor);
                }
            } catch (Throwable th) {
                th = th;
                com.baidu.swan.c.d.closeSafely(cursor);
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
            com.baidu.swan.c.d.closeSafely(cursor);
            throw th;
        }
    }

    private static boolean nP(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        return cRy.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public static JSONObject d(Cursor cursor) {
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
                    str2 = String.format(com.baidu.swan.apps.scheme.actions.c.a.dvJ, string);
                } else {
                    str2 = com.baidu.swan.apps.scheme.actions.c.a.dvI + string + "\"}";
                }
                jSONObject.put("scheme", str2);
                if (!TextUtils.isEmpty(cursor.getString(cursor.getColumnIndex("visit_time")))) {
                    String string2 = cursor.getString(cursor.getColumnIndex("visit_time"));
                    jSONObject.put("dataStamp", string2);
                    jSONObject.put("dateStamp", string2);
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
        com.baidu.swan.apps.media.image.a.closeSafely(cursor);
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("history", jSONArray);
        } catch (JSONException e3) {
            e3.printStackTrace();
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
    public static Cursor Q(@NonNull String str, int i) {
        Cursor query;
        List<c> arrayList;
        HashMap hashMap = new HashMap();
        Cursor a2 = a(AppRuntime.getAppContext().getContentResolver(), str);
        if (a2 != null && a2.moveToFirst()) {
            do {
                com.baidu.swan.apps.database.a aVar = new com.baidu.swan.apps.database.a();
                SwanAppDbControl.cd(AppRuntime.getAppContext()).a(a2, aVar);
                if (!TextUtils.isEmpty(aVar.appId)) {
                    a aVar2 = new a();
                    aVar2.cRn = aVar;
                    aVar2.cRE.id = aVar.appId;
                    aVar2.cRE.from = a2.getString(a2.getColumnIndex("app_from"));
                    aVar2.cRE.cRD = a2.getLong(a2.getColumnIndex("visit_time"));
                    hashMap.put(aVar2.cRE.id, aVar2);
                    if (DEBUG) {
                        Log.v("history_migrate_pms", "Aps&History == " + aVar.appId);
                    }
                }
            } while (a2.moveToNext());
            com.baidu.swan.c.d.closeSafely(a2);
            if (DEBUG) {
            }
            query = AppRuntime.getAppContext().getContentResolver().query(com.baidu.swan.apps.database.a.a.asX(), null, null, null, null);
            HashMap hashMap2 = new HashMap();
            if (query == null) {
            }
            com.baidu.swan.c.d.closeSafely(query);
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
            MatrixCursor matrixCursor = new MatrixCursor(cRm, 50);
            int i2 = 0;
            while (r3.hasNext()) {
            }
            return matrixCursor;
        }
        com.baidu.swan.c.d.closeSafely(a2);
        if (DEBUG) {
            Log.d("history_migrate_pms", "^ Aps & History 查询到 " + hashMap.size() + " 个历史记录");
        }
        query = AppRuntime.getAppContext().getContentResolver().query(com.baidu.swan.apps.database.a.a.asX(), null, null, null, null);
        HashMap hashMap22 = new HashMap();
        if (query == null && query.moveToFirst()) {
            do {
                C0436b c0436b = new C0436b();
                c0436b.id = query.getString(query.getColumnIndex("app_id"));
                c0436b.from = query.getString(query.getColumnIndex("app_from"));
                c0436b.cRD = query.getLong(query.getColumnIndex("visit_time"));
                hashMap22.put(c0436b.id, c0436b);
                if (DEBUG) {
                    Log.v("history_migrate_pms", "History == " + c0436b.id);
                }
            } while (query.moveToNext());
            com.baidu.swan.c.d.closeSafely(query);
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
            MatrixCursor matrixCursor2 = new MatrixCursor(cRm, 50);
            int i22 = 0;
            while (r3.hasNext()) {
            }
            return matrixCursor2;
        }
        com.baidu.swan.c.d.closeSafely(query);
        if (DEBUG) {
            Log.d("history_migrate_pms", "^ History 库查询到 " + hashMap22.size() + " 个历史记录");
        }
        ArrayList<c> arrayList222 = new ArrayList();
        for (PMSAppInfo pMSAppInfo : new ArrayList(com.baidu.swan.pms.database.a.bbh().bbj().values())) {
            if (DEBUG) {
                Log.v("history_migrate_pms", "Pms == " + pMSAppInfo.appId);
            }
            if (pMSAppInfo.appName != null && pMSAppInfo.appName.contains(str) && hashMap22.containsKey(pMSAppInfo.appId)) {
                e eVar = new e();
                eVar.cRE = (C0436b) hashMap22.get(pMSAppInfo.appId);
                eVar.cRq = pMSAppInfo;
                arrayList222.add(eVar);
            }
        }
        if (DEBUG) {
            Log.d("history_migrate_pms", "^ Pms & History 查询到 " + arrayList222.size() + " 个历史记录");
        }
        for (c cVar : arrayList222) {
            hashMap.put(cVar.cRE.id, cVar);
        }
        if (DEBUG) {
            Log.d("history_migrate_pms", "合并后有 " + hashMap.size() + " 个历史记录");
            Iterator it = hashMap.values().iterator();
            while (it.hasNext()) {
                Log.v("history_migrate_pms", "Migrate == " + ((c) it.next()).cRE.id);
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
        MatrixCursor matrixCursor22 = new MatrixCursor(cRm, 50);
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
            matrixCursor.newRow().add(IMConstants.MSG_ROW_ID, Integer.valueOf(i)).add(SwanAppDbControl.SwanAppTable.app_id.name(), aVar.cRn.appId).add(SwanAppDbControl.SwanAppTable.app_key.name(), aVar.cRn.appKey).add(SwanAppDbControl.SwanAppTable.version.name(), aVar.cRn.version).add(SwanAppDbControl.SwanAppTable.description.name(), aVar.cRn.description).add(SwanAppDbControl.SwanAppTable.error_code.name(), Integer.valueOf(aVar.cRn.errorCode)).add(SwanAppDbControl.SwanAppTable.error_detail.name(), aVar.cRn.errorDetail).add(SwanAppDbControl.SwanAppTable.error_msg.name(), aVar.cRn.errorMsg).add(SwanAppDbControl.SwanAppTable.resume_date.name(), aVar.cRn.resumeDate).add(SwanAppDbControl.SwanAppTable.icon.name(), aVar.cRn.icon).add(SwanAppDbControl.SwanAppTable.icon_url.name(), aVar.cRn.iconUrl).add(SwanAppDbControl.SwanAppTable.max_swan_version.name(), aVar.cRn.cQW).add(SwanAppDbControl.SwanAppTable.min_swan_version.name(), aVar.cRn.cQX).add(SwanAppDbControl.SwanAppTable.name.name(), aVar.cRn.name).add(SwanAppDbControl.SwanAppTable.service_category.name(), aVar.cRn.serviceCategory).add(SwanAppDbControl.SwanAppTable.subject_info.name(), aVar.cRn.subjectInfo).add(SwanAppDbControl.SwanAppTable.bear_info.name(), aVar.cRn.bearInfo).add(SwanAppDbControl.SwanAppTable.sign.name(), aVar.cRn.sign).add(SwanAppDbControl.SwanAppTable.type.name(), Integer.valueOf(aVar.cRn.type)).add(SwanAppDbControl.SwanAppTable.is_have_zip.name(), Integer.valueOf(aVar.cRn.cQY)).add(SwanAppDbControl.SwanAppTable.app_open_url.name(), aVar.cRn.cQZ).add(SwanAppDbControl.SwanAppTable.app_download_url.name(), aVar.cRn.cRa).add(SwanAppDbControl.SwanAppTable.target_swan_version.name(), aVar.cRn.cRb).add(SwanAppDbControl.SwanAppTable.app_zip_size.name(), Long.valueOf(aVar.cRn.cRc)).add(SwanAppDbControl.SwanAppTable.pending_aps_errcode.name(), Integer.valueOf(aVar.cRn.cRd)).add(SwanAppDbControl.SwanAppTable.version_code.name(), aVar.cRn.cRe).add(SwanAppDbControl.SwanAppTable.app_category.name(), Integer.valueOf(aVar.cRn.category)).add(SwanAppDbControl.SwanAppTable.orientation.name(), Integer.valueOf(aVar.cRn.orientation)).add(SwanAppDbControl.SwanAppTable.max_age.name(), Long.valueOf(aVar.cRn.maxAge)).add(SwanAppDbControl.SwanAppTable.create_time.name(), Long.valueOf(aVar.cRn.createTime)).add(SwanAppDbControl.SwanAppTable.force_fetch_meta_info.name(), Integer.valueOf(aVar.cRn.cRf ? 1 : 0)).add("app_from", aVar.cRE.from).add("visit_time", Long.valueOf(aVar.cRE.cRD)).add(SwanAppDbControl.SwanAppTable.pay_protected.name(), Integer.valueOf(aVar.cRn.payProtected)).add(SwanAppDbControl.SwanAppTable.quick_app_key.name(), aVar.cRn.quickAppKey);
            return;
        }
        e eVar = (e) cVar;
        matrixCursor.newRow().add(IMConstants.MSG_ROW_ID, Integer.valueOf(i)).add(SwanAppDbControl.SwanAppTable.app_id.name(), eVar.cRq.appId).add(SwanAppDbControl.SwanAppTable.app_key.name(), eVar.cRq.appKey).add(SwanAppDbControl.SwanAppTable.version.name(), Long.valueOf(eVar.cRq.versionCode)).add(SwanAppDbControl.SwanAppTable.description.name(), eVar.cRq.description).add(SwanAppDbControl.SwanAppTable.error_code.name(), Integer.valueOf(eVar.cRq.appStatus)).add(SwanAppDbControl.SwanAppTable.error_detail.name(), eVar.cRq.statusDetail).add(SwanAppDbControl.SwanAppTable.error_msg.name(), eVar.cRq.statusDesc).add(SwanAppDbControl.SwanAppTable.resume_date.name(), eVar.cRq.resumeDate).add(SwanAppDbControl.SwanAppTable.icon.name(), "").add(SwanAppDbControl.SwanAppTable.icon_url.name(), eVar.cRq.iconUrl).add(SwanAppDbControl.SwanAppTable.max_swan_version.name(), "").add(SwanAppDbControl.SwanAppTable.min_swan_version.name(), "").add(SwanAppDbControl.SwanAppTable.name.name(), eVar.cRq.appName).add(SwanAppDbControl.SwanAppTable.service_category.name(), eVar.cRq.serviceCategory).add(SwanAppDbControl.SwanAppTable.subject_info.name(), eVar.cRq.subjectInfo).add(SwanAppDbControl.SwanAppTable.bear_info.name(), eVar.cRq.bearInfo).add(SwanAppDbControl.SwanAppTable.sign.name(), "").add(SwanAppDbControl.SwanAppTable.type.name(), Integer.valueOf(eVar.cRq.type)).add(SwanAppDbControl.SwanAppTable.is_have_zip.name(), 0).add(SwanAppDbControl.SwanAppTable.app_open_url.name(), "").add(SwanAppDbControl.SwanAppTable.app_download_url.name(), "").add(SwanAppDbControl.SwanAppTable.target_swan_version.name(), "").add(SwanAppDbControl.SwanAppTable.app_zip_size.name(), Long.valueOf(eVar.cRq.pkgSize)).add(SwanAppDbControl.SwanAppTable.pending_aps_errcode.name(), Integer.valueOf(eVar.cRq.pendingErrCode)).add(SwanAppDbControl.SwanAppTable.version_code.name(), eVar.cRq.versionName).add(SwanAppDbControl.SwanAppTable.app_category.name(), Integer.valueOf(eVar.cRq.appCategory)).add(SwanAppDbControl.SwanAppTable.orientation.name(), Integer.valueOf(eVar.cRq.getOrientation())).add(SwanAppDbControl.SwanAppTable.max_age.name(), Long.valueOf(eVar.cRq.maxAge)).add(SwanAppDbControl.SwanAppTable.create_time.name(), Long.valueOf(eVar.cRq.createTime)).add(SwanAppDbControl.SwanAppTable.force_fetch_meta_info.name(), 0).add("app_from", eVar.cRE.from).add("visit_time", Long.valueOf(eVar.cRE.cRD)).add(SwanAppDbControl.SwanAppTable.pay_protected.name(), Integer.valueOf(eVar.cRq.payProtected)).add("customer_service", Integer.valueOf(eVar.cRq.customerService)).add("global_notice", Integer.valueOf(eVar.cRq.globalNotice)).add("global_private", Integer.valueOf(eVar.cRq.globalPrivate)).add("pa_number", eVar.cRq.paNumber).add(Constants.PHONE_BRAND, eVar.cRq.brandsInfo).add(SwanAppDbControl.SwanAppTable.quick_app_key.name(), eVar.cRq.quickAppKey);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.database.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0436b {
        long cRD;
        String from;
        String id;

        private C0436b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class a extends c {
        com.baidu.swan.apps.database.a cRn;

        private a() {
            super();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class e extends c {
        PMSAppInfo cRq;

        private e() {
            super();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static abstract class c {
        C0436b cRE;

        private c() {
            this.cRE = new C0436b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class d implements Comparator<c> {
        private d() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(c cVar, c cVar2) {
            return Long.compare(cVar2.cRE.cRD, cVar.cRE.cRD);
        }
    }
}

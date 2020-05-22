package com.baidu.swan.apps.database.favorite;

import android.content.ContentValues;
import android.content.SharedPreferences;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.delegate.DelegateResult;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.database.SwanAppDbControl;
import com.baidu.swan.apps.env.SwanAppDeleteInfo;
import com.baidu.swan.apps.favordata.SwanFavorItemData;
import com.baidu.swan.apps.storage.c.h;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.facebook.common.internal.i;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
/* loaded from: classes11.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final Set<String> cbD = i.O("sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u");
    private static final String[] cbE = {IMConstants.MSG_ROW_ID, SwanAppDbControl.SwanAppTable.app_id.name(), SwanAppDbControl.SwanAppTable.app_key.name(), SwanAppDbControl.SwanAppTable.version.name(), SwanAppDbControl.SwanAppTable.description.name(), SwanAppDbControl.SwanAppTable.error_code.name(), SwanAppDbControl.SwanAppTable.error_detail.name(), SwanAppDbControl.SwanAppTable.error_msg.name(), SwanAppDbControl.SwanAppTable.resume_date.name(), SwanAppDbControl.SwanAppTable.icon.name(), SwanAppDbControl.SwanAppTable.icon_url.name(), SwanAppDbControl.SwanAppTable.max_swan_version.name(), SwanAppDbControl.SwanAppTable.min_swan_version.name(), SwanAppDbControl.SwanAppTable.name.name(), SwanAppDbControl.SwanAppTable.service_category.name(), SwanAppDbControl.SwanAppTable.subject_info.name(), SwanAppDbControl.SwanAppTable.bear_info.name(), SwanAppDbControl.SwanAppTable.sign.name(), SwanAppDbControl.SwanAppTable.type.name(), SwanAppDbControl.SwanAppTable.is_have_zip.name(), SwanAppDbControl.SwanAppTable.app_open_url.name(), SwanAppDbControl.SwanAppTable.app_download_url.name(), SwanAppDbControl.SwanAppTable.target_swan_version.name(), SwanAppDbControl.SwanAppTable.app_zip_size.name(), SwanAppDbControl.SwanAppTable.pending_aps_errcode.name(), SwanAppDbControl.SwanAppTable.version_code.name(), SwanAppDbControl.SwanAppTable.app_category.name(), SwanAppDbControl.SwanAppTable.orientation.name(), SwanAppDbControl.SwanAppTable.max_age.name(), SwanAppDbControl.SwanAppTable.create_time.name(), SwanAppDbControl.SwanAppTable.force_fetch_meta_info.name(), "favorite_time", SwanAppDbControl.SwanAppTable.pay_protected.name(), "customer_service", "global_notice", "global_private", "pa_number", Constants.PHONE_BRAND};

    private static boolean a(@NonNull SwanFavorItemData swanFavorItemData, int i) {
        Uri acg = acg();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", swanFavorItemData.getAppKey());
        contentValues.put("sort_index", Integer.valueOf(i));
        contentValues.put("favorite_time", Long.valueOf(System.currentTimeMillis()));
        contentValues.put("app_name", swanFavorItemData.getAppName());
        contentValues.put("app_icon", swanFavorItemData.getIconUrl());
        contentValues.put("app_type", Integer.valueOf(swanFavorItemData.getAppType()));
        contentValues.put("frame_type", Integer.valueOf(swanFavorItemData.getAppFrameType()));
        if (AppRuntime.getAppContext().getContentResolver().insert(acg, contentValues) != null) {
            if (DEBUG) {
                Log.d("SwanAppFavoriteHelper", "数据库收藏成功： " + swanFavorItemData.getAppKey());
            }
            h.arO().putString("favorite_guide_count_" + swanFavorItemData.getAppKey(), "-1");
            return true;
        }
        return false;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, MOVE_EXCEPTION, INVOKE, MOVE_EXCEPTION] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [143=4, 145=4] */
    private static boolean V(List<SwanFavorItemData> list) {
        if (list == null || list.size() <= 0) {
            return false;
        }
        SQLiteDatabase writableDatabase = SwanAppDbControl.bN(com.baidu.swan.apps.u.a.aeR()).abQ().getWritableDatabase();
        try {
            writableDatabase.beginTransaction();
            for (int i = 0; i < list.size(); i++) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("app_id", list.get(i).getAppKey());
                contentValues.put("sort_index", Integer.valueOf(i + 1));
                contentValues.put("favorite_time", Long.valueOf(System.currentTimeMillis()));
                contentValues.put("app_name", list.get(i).getAppName());
                contentValues.put("app_icon", list.get(i).getIconUrl());
                contentValues.put("app_type", Integer.valueOf(list.get(i).getAppType()));
                contentValues.put("frame_type", Integer.valueOf(list.get(i).getAppFrameType()));
                if (writableDatabase.insertWithOnConflict("ai_apps_favorites", null, contentValues, 5) < 0) {
                    if (writableDatabase != null) {
                        try {
                            writableDatabase.endTransaction();
                        } catch (Exception e2) {
                        }
                    }
                    return false;
                }
            }
            if (DEBUG) {
                Log.d("SwanAppFavoriteHelper", "批量数据库收藏成功");
            }
            writableDatabase.setTransactionSuccessful();
            if (writableDatabase != null) {
                try {
                    writableDatabase.endTransaction();
                    return true;
                } catch (Exception e3) {
                    return true;
                }
            }
            return true;
        } catch (Exception e4) {
            if (writableDatabase != null) {
                try {
                    writableDatabase.endTransaction();
                } catch (Exception e5) {
                }
            }
            return false;
        } catch (Throwable th) {
            if (writableDatabase != null) {
                try {
                    writableDatabase.endTransaction();
                } catch (Exception e6) {
                }
            }
            throw th;
        }
    }

    public static boolean a(@NonNull SwanFavorItemData swanFavorItemData, int i, com.baidu.swan.apps.favordata.a.a aVar) {
        if (i < 0) {
            if (aVar != null) {
                aVar.ade();
                return false;
            }
            return false;
        }
        List<SwanFavorItemData> abX = abX();
        if (abX.size() == 0) {
            if (a(swanFavorItemData, 1)) {
                if (aVar != null) {
                    aVar.add();
                }
                acb();
                return true;
            } else if (aVar != null) {
                aVar.ade();
                return false;
            } else {
                return false;
            }
        } else if (abX.size() + 1 == i) {
            if (a(swanFavorItemData, abX.get(abX.size() - 1).getIndex() + 1)) {
                if (aVar != null) {
                    aVar.add();
                }
                acb();
                return true;
            } else if (aVar != null) {
                aVar.ade();
                return false;
            } else {
                return false;
            }
        } else {
            for (int i2 = 0; i2 < abX.size(); i2++) {
                if (i2 + 1 == i) {
                    swanFavorItemData.setIndex(abX.get(i2).getIndex());
                    if (!a(swanFavorItemData, swanFavorItemData.getIndex())) {
                        if (aVar != null) {
                            aVar.ade();
                            return false;
                        }
                        return false;
                    }
                }
            }
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (int i3 = 0; i3 < abX.size(); i3++) {
                if (i3 + 1 >= i) {
                    int index = abX.get(i3).getIndex() + 1;
                    abX.get(i3).setIndex(index);
                    arrayList.add(abX.get(i3).getAppKey());
                    arrayList2.add(Integer.valueOf(index));
                }
            }
            boolean e2 = e(arrayList, arrayList2);
            if (!e2) {
                if (aVar != null) {
                    aVar.ade();
                    return false;
                }
                return false;
            }
            if (aVar != null) {
                aVar.add();
            }
            acb();
            return e2;
        }
    }

    public static boolean a(String str, int i, com.baidu.swan.apps.favordata.a.a aVar) {
        if (TextUtils.isEmpty(str) || i < 1) {
            if (aVar != null) {
                aVar.ade();
                return false;
            }
            return false;
        }
        List<SwanFavorItemData> abX = abX();
        if (abX.size() < i) {
            if (aVar != null) {
                aVar.ade();
                return false;
            }
            return false;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i2 = 0; i2 < abX.size(); i2++) {
            if (i2 + 1 == i) {
                arrayList.add(str);
                arrayList2.add(Integer.valueOf(abX.get(i2).getIndex()));
                if (!e(arrayList, arrayList2)) {
                    if (aVar != null) {
                        aVar.ade();
                        return false;
                    }
                    return false;
                }
            }
        }
        arrayList.clear();
        arrayList2.clear();
        for (int i3 = 0; i3 < abX.size(); i3++) {
            if (i3 + 1 >= i && !TextUtils.equals(abX.get(i3).getAppKey(), str)) {
                arrayList2.add(Integer.valueOf(abX.get(i3).getIndex() + 1));
                arrayList.add(abX.get(i3).getAppKey());
            }
        }
        boolean e2 = e(arrayList, arrayList2);
        if (!e2) {
            if (aVar != null) {
                aVar.ade();
                return false;
            }
            return false;
        }
        if (aVar != null) {
            aVar.add();
        }
        acb();
        return e2;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, MOVE_EXCEPTION, INVOKE, MOVE_EXCEPTION] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [343=4, 345=4] */
    private static boolean e(List<String> list, List<Integer> list2) {
        if (list == null || list.size() <= 0 || list2 == null || list2.size() <= 0) {
            return false;
        }
        SQLiteDatabase writableDatabase = SwanAppDbControl.bN(com.baidu.swan.apps.u.a.aeR()).abQ().getWritableDatabase();
        writableDatabase.beginTransaction();
        for (int i = 0; i < list.size(); i++) {
            try {
                String[] strArr = {list.get(i)};
                ContentValues contentValues = new ContentValues();
                contentValues.put("sort_index", list2.get(i));
                if (writableDatabase.update("ai_apps_favorites", contentValues, "app_id = ?", strArr) <= 0) {
                    if (writableDatabase != null) {
                        try {
                            writableDatabase.endTransaction();
                        } catch (Exception e2) {
                        }
                    }
                    return false;
                }
            } catch (Exception e3) {
                if (writableDatabase != null) {
                    try {
                        writableDatabase.endTransaction();
                    } catch (Exception e4) {
                    }
                }
                return false;
            } catch (Throwable th) {
                if (writableDatabase != null) {
                    try {
                        writableDatabase.endTransaction();
                    } catch (Exception e5) {
                    }
                }
                throw th;
            }
        }
        writableDatabase.setTransactionSuccessful();
        if (writableDatabase != null) {
            try {
                writableDatabase.endTransaction();
            } catch (Exception e6) {
            }
        }
        return true;
    }

    private static void a(@NonNull SwanFavorItemData swanFavorItemData) {
        if (!TextUtils.isEmpty(swanFavorItemData.getAppKey())) {
            Uri acg = acg();
            String[] strArr = {swanFavorItemData.getAppKey()};
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_name", swanFavorItemData.getAppName());
            contentValues.put("app_icon", swanFavorItemData.getIconUrl());
            contentValues.put("app_type", Integer.valueOf(swanFavorItemData.getAppType()));
            contentValues.put("frame_type", Integer.valueOf(swanFavorItemData.getAppFrameType()));
            if (AppRuntime.getAppContext().getContentResolver().update(acg, contentValues, "app_id = ?", strArr) > 0 && DEBUG) {
                Log.d("SwanAppFavoriteHelper", "更新收藏");
            }
        }
    }

    public static boolean a(@NonNull String str, com.baidu.swan.apps.favordata.a.b bVar) {
        if (TextUtils.isEmpty(str)) {
            if (bVar != null) {
                bVar.adg();
                return false;
            }
            return false;
        }
        if (AppRuntime.getAppContext().getContentResolver().delete(acg(), "app_id = ?", new String[]{str}) > 0) {
            if (DEBUG) {
                Log.d("SwanAppFavoriteHelper", "删除收藏，检查是否需要清理包");
            }
            if (!TextUtils.equals(str, "sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u")) {
                if (ProcessUtils.isMainProcess()) {
                    com.baidu.swan.apps.env.c acw = com.baidu.swan.apps.env.e.acv().acw();
                    if (acw != null) {
                        acw.J(str, true);
                    }
                } else if (com.baidu.swan.apps.database.a.b.a(AppRuntime.getAppContext().getContentResolver()).contains(str) || !TextUtils.equals(com.baidu.swan.apps.runtime.e.aoH(), str)) {
                    com.baidu.swan.apps.process.messaging.client.a.amQ().a(8, new SwanAppDeleteInfo(str));
                }
            }
            if (DEBUG) {
                Log.d("SwanAppFavoriteHelper", "取消收藏成功： " + str);
            }
            acb();
            if (bVar != null) {
                bVar.adf();
            }
        }
        return true;
    }

    @NonNull
    public static List<com.baidu.swan.apps.database.a> abW() {
        ArrayList arrayList = new ArrayList();
        Cursor ace = ace();
        try {
            if (ace != null) {
                if (ace.getCount() > 0) {
                    ace.moveToFirst();
                    do {
                        com.baidu.swan.apps.database.a aVar = new com.baidu.swan.apps.database.a();
                        SwanAppDbControl.bN(AppRuntime.getAppContext()).a(ace, aVar);
                        if (!TextUtils.isEmpty(aVar.appId)) {
                            arrayList.add(aVar);
                        }
                    } while (ace.moveToNext());
                }
            }
        } catch (Exception e2) {
            if (DEBUG) {
                e2.printStackTrace();
            }
        } finally {
            com.baidu.swan.e.d.closeSafely(ace);
        }
        return arrayList;
    }

    @NonNull
    public static List<SwanFavorItemData> abX() {
        Cursor abY = abY();
        ArrayList arrayList = new ArrayList(abY.getCount());
        try {
        } catch (Exception e2) {
            if (DEBUG) {
                e2.printStackTrace();
            }
        } finally {
            com.baidu.swan.e.d.closeSafely(abY);
        }
        if (abY.getCount() > 0) {
            abY.moveToFirst();
            do {
                SwanFavorItemData c2 = c(abY);
                if (!TextUtils.isEmpty(c2.getAppKey()) && !TextUtils.isEmpty(c2.getAppName())) {
                    arrayList.add(c2);
                }
            } while (abY.moveToNext());
            return arrayList;
        }
        return arrayList;
    }

    public static SwanFavorItemData c(@NonNull Cursor cursor) {
        SwanFavorItemData swanFavorItemData = new SwanFavorItemData();
        swanFavorItemData.setIndex(cursor.getInt(cursor.getColumnIndex("sort_index")));
        swanFavorItemData.setAppKey(cursor.getString(cursor.getColumnIndex("app_id")));
        swanFavorItemData.setAppName(cursor.getString(cursor.getColumnIndex("app_name")));
        swanFavorItemData.setIconUrl(cursor.getString(cursor.getColumnIndex("app_icon")));
        swanFavorItemData.setAppType(cursor.getInt(cursor.getColumnIndex("app_type")));
        swanFavorItemData.setAppFrameType(cursor.getInt(cursor.getColumnIndex("frame_type")));
        if (DEBUG) {
            Log.v("favorite_migrate_pms", "Favotite == " + swanFavorItemData.getAppKey());
        }
        if (TextUtils.isEmpty(swanFavorItemData.getAppName()) || TextUtils.isEmpty(swanFavorItemData.getIconUrl())) {
            List<com.baidu.swan.apps.database.a> abW = abW();
            if (abW.size() > 0) {
                Iterator<com.baidu.swan.apps.database.a> it = abW.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    com.baidu.swan.apps.database.a next = it.next();
                    if (TextUtils.equals(swanFavorItemData.getAppKey(), next.appId)) {
                        swanFavorItemData.setAppKey(next.appId);
                        swanFavorItemData.setAppName(next.name);
                        swanFavorItemData.setIconUrl(next.iconUrl);
                        swanFavorItemData.setAppFrameType(next.category);
                        swanFavorItemData.setAppType(next.type);
                        a(swanFavorItemData);
                        break;
                    }
                }
            }
        }
        return swanFavorItemData;
    }

    public static void W(List<SwanFavorItemData> list) {
        boolean z = true;
        Cursor abY = abY();
        if (list == null || list.size() <= 0) {
            if (abY != null && abY.getCount() > 0) {
                AppRuntime.getAppContext().getContentResolver().delete(acg(), null, null);
                acb();
            }
        } else if (abY != null) {
            boolean z2 = false;
            try {
                abY.moveToFirst();
                while (true) {
                    if (!abY.moveToNext()) {
                        break;
                    }
                    if (!a(list, abY.getString(abY.getColumnIndex("app_id")), abY.getString(abY.getColumnIndex("app_name")), abY.getString(abY.getColumnIndex("app_icon")))) {
                        z2 = true;
                        break;
                    }
                }
                if (z2 || abY.getCount() == list.size()) {
                    z = z2;
                }
                if (z) {
                    AppRuntime.getAppContext().getContentResolver().delete(acg(), null, null);
                    V(list);
                    acb();
                }
            } catch (Exception e2) {
                if (DEBUG) {
                    e2.printStackTrace();
                }
            } finally {
                com.baidu.swan.e.d.closeSafely(abY);
            }
        }
    }

    private static boolean a(List<SwanFavorItemData> list, String str, String str2, String str3) {
        if (list == null || list.size() <= 0) {
            return false;
        }
        for (SwanFavorItemData swanFavorItemData : list) {
            if (TextUtils.equals(str, swanFavorItemData.getAppKey()) && TextUtils.equals(str2, swanFavorItemData.getAppName()) && TextUtils.equals(str3, swanFavorItemData.getIconUrl())) {
                return true;
            }
        }
        return false;
    }

    public static Cursor abY() {
        abZ();
        return AppRuntime.getAppContext().getContentResolver().query(acg(), null, null, null, "sort_index");
    }

    private static void abZ() {
        if (h.arO().getBoolean("key_first_sort", true)) {
            h.arO().putBoolean("key_first_sort", false);
            Cursor query = AppRuntime.getAppContext().getContentResolver().query(acg(), null, null, null, "favorite_time DESC");
            try {
                if (query != null) {
                    query.moveToFirst();
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    int i = 1;
                    do {
                        arrayList.add(query.getString(query.getColumnIndex("app_id")));
                        arrayList2.add(Integer.valueOf(i));
                        i++;
                    } while (query.moveToNext());
                    e(arrayList, arrayList2);
                }
            } catch (Exception e2) {
                if (DEBUG) {
                    e2.printStackTrace();
                }
            } finally {
                com.baidu.swan.e.d.closeSafely(query);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [700=4] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0028 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean jW(@NonNull String str) {
        boolean z;
        Cursor query;
        try {
            query = AppRuntime.getAppContext().getContentResolver().query(acg(), null, "app_id = ?", new String[]{str}, null);
        } catch (Exception e2) {
            z = false;
            if (DEBUG) {
                e2.printStackTrace();
            }
        }
        if (query != null) {
            if (query.getCount() > 0) {
                z = true;
                if (query != null) {
                    try {
                        if (0 != 0) {
                            query.close();
                        } else {
                            query.close();
                        }
                    }
                }
                if (DEBUG) {
                    Log.d("SwanAppFavoriteHelper", "小程序： " + str + "是否在收藏列表中：" + z);
                }
                return z;
            }
        }
        z = false;
        if (query != null) {
        }
        if (DEBUG) {
        }
        return z;
    }

    public static Uri aca() {
        return com.baidu.swan.apps.database.favorite.b.CONTENT_URI.buildUpon().appendPath("favorite_and_aps").build();
    }

    private static void acb() {
        AppRuntime.getAppContext().getContentResolver().notifyChange(acg(), (ContentObserver) null, false);
        AppRuntime.getAppContext().getContentResolver().notifyChange(aca(), (ContentObserver) null, false);
        AppRuntime.getAppContext().getContentResolver().notifyChange(acf(), (ContentObserver) null, false);
    }

    public static void acc() {
        if (DEBUG) {
            Log.d("SwanAppFavoriteHelper", "记录用户在小程序框架菜单中点击收藏");
        }
        DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), f.class, null);
    }

    public static int acd() {
        if (DEBUG) {
            Log.v("SwanAppFavoriteHelper", "调用获取收藏次数");
        }
        DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), e.class, null);
        int i = callOnMainWithContentProvider.isOk() ? callOnMainWithContentProvider.mResult.getInt("fav_count", 0) : 0;
        if (DEBUG) {
            Log.d("SwanAppFavoriteHelper", "用户在小程序框架菜单中点击收藏的次数：" + i);
        }
        return i;
    }

    /* loaded from: classes11.dex */
    private static class e extends ProviderDelegation {
        private e() {
        }

        @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
        public Bundle execCall(Bundle bundle) {
            int i = AppRuntime.getAppContext().getSharedPreferences("aiapps_favorite", 0).getInt("aiapps_user_fav_count", 0);
            if (a.DEBUG) {
                Log.v("SwanAppFavoriteHelper", "delegate读取到的收藏次数：" + i);
            }
            Bundle bundle2 = new Bundle();
            bundle2.putInt("fav_count", i);
            return bundle2;
        }
    }

    /* loaded from: classes11.dex */
    private static class f extends ProviderDelegation {
        private f() {
        }

        @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
        public Bundle execCall(Bundle bundle) {
            SharedPreferences sharedPreferences = AppRuntime.getAppContext().getSharedPreferences("aiapps_favorite", 0);
            int i = sharedPreferences.getInt("aiapps_user_fav_count", 0);
            if (a.DEBUG) {
                Log.v("SwanAppFavoriteHelper", "delegate当前收藏次数：" + i);
            }
            SharedPreferences.Editor edit = sharedPreferences.edit();
            int i2 = i + 1;
            edit.putInt("aiapps_user_fav_count", i2);
            edit.commit();
            if (a.DEBUG) {
                Log.v("SwanAppFavoriteHelper", "delegate写入新收藏次数" + i2);
            }
            Bundle bundle2 = new Bundle();
            bundle2.putInt("fav_count", i2);
            return bundle2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x01de A[LOOP:3: B:41:0x01d8->B:43:0x01de, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x026e A[LOOP:5: B:51:0x0268->B:53:0x026e, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x027b A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Cursor ace() {
        Cursor query;
        MatrixCursor matrixCursor;
        int i;
        Iterator it;
        HashMap hashMap = new HashMap();
        Cursor query2 = AppRuntime.getAppContext().getContentResolver().query(aca(), null, null, null, "favorite_time DESC");
        if (query2 != null && query2.moveToFirst()) {
            do {
                com.baidu.swan.apps.database.a aVar = new com.baidu.swan.apps.database.a();
                SwanAppDbControl.bN(AppRuntime.getAppContext()).a(query2, aVar);
                if (!TextUtils.isEmpty(aVar.appId)) {
                    C0348a c0348a = new C0348a();
                    c0348a.cbF = aVar;
                    c0348a.cbH.id = aVar.appId;
                    c0348a.cbH.cbG = query2.getLong(query2.getColumnIndex("favorite_time"));
                    hashMap.put(c0348a.cbH.id, c0348a);
                    if (DEBUG) {
                        Log.v("favorite_migrate_pms", "Aps&Favotite == " + aVar.appId);
                    }
                }
            } while (query2.moveToNext());
            com.baidu.swan.e.d.closeSafely(query2);
            if (DEBUG) {
            }
            query = AppRuntime.getAppContext().getContentResolver().query(acg(), null, null, null, null);
            HashMap hashMap2 = new HashMap();
            if (query == null) {
            }
            com.baidu.swan.e.d.closeSafely(query);
            if (DEBUG) {
            }
            ArrayList<c> arrayList = new ArrayList();
            while (r5.hasNext()) {
            }
            if (DEBUG) {
            }
            while (r1.hasNext()) {
            }
            if (DEBUG) {
            }
            ArrayList arrayList2 = new ArrayList(hashMap.values());
            Collections.sort(arrayList2, new d());
            matrixCursor = new MatrixCursor(cbE, 50);
            i = 0;
            it = arrayList2.iterator();
            while (true) {
                int i2 = i;
                if (it.hasNext()) {
                }
                a(matrixCursor, i2, (c) it.next());
                i = i2 + 1;
            }
        } else {
            com.baidu.swan.e.d.closeSafely(query2);
            if (DEBUG) {
                Log.d("favorite_migrate_pms", "^ Aps & Favorite 查询到 " + hashMap.size() + " 条收藏");
            }
            query = AppRuntime.getAppContext().getContentResolver().query(acg(), null, null, null, null);
            HashMap hashMap22 = new HashMap();
            if (query == null && query.moveToFirst()) {
                do {
                    b bVar = new b();
                    bVar.id = query.getString(query.getColumnIndex("app_id"));
                    bVar.cbG = query.getLong(query.getColumnIndex("favorite_time"));
                    hashMap22.put(bVar.id, bVar);
                    if (DEBUG) {
                        Log.v("favorite_migrate_pms", "Favotite == " + bVar.id);
                    }
                } while (query.moveToNext());
                com.baidu.swan.e.d.closeSafely(query);
                if (DEBUG) {
                }
                ArrayList<c> arrayList3 = new ArrayList();
                while (r5.hasNext()) {
                }
                if (DEBUG) {
                }
                while (r1.hasNext()) {
                }
                if (DEBUG) {
                }
                ArrayList arrayList22 = new ArrayList(hashMap.values());
                Collections.sort(arrayList22, new d());
                matrixCursor = new MatrixCursor(cbE, 50);
                i = 0;
                it = arrayList22.iterator();
                while (true) {
                    int i22 = i;
                    if (it.hasNext()) {
                    }
                    a(matrixCursor, i22, (c) it.next());
                    i = i22 + 1;
                }
            } else {
                com.baidu.swan.e.d.closeSafely(query);
                if (DEBUG) {
                    Log.d("favorite_migrate_pms", "^ Favorite 库查询到 " + hashMap22.size() + " 条收藏");
                }
                ArrayList<c> arrayList32 = new ArrayList();
                for (PMSAppInfo pMSAppInfo : new ArrayList(com.baidu.swan.pms.database.a.aFV().aFX().values())) {
                    if (DEBUG) {
                        Log.v("favorite_migrate_pms", "Pms == " + pMSAppInfo.appId);
                    }
                    if (hashMap22.containsKey(pMSAppInfo.appId)) {
                        g gVar = new g();
                        gVar.cbH = (b) hashMap22.get(pMSAppInfo.appId);
                        gVar.cbI = pMSAppInfo;
                        arrayList32.add(gVar);
                    }
                }
                if (DEBUG) {
                    Log.d("favorite_migrate_pms", "^ Pms & Favorite 查询到 " + arrayList32.size() + " 条收藏");
                }
                for (c cVar : arrayList32) {
                    hashMap.put(cVar.cbH.id, cVar);
                }
                if (DEBUG) {
                    Log.d("favorite_migrate_pms", "合并后有 " + hashMap.size() + " 条收藏");
                    Iterator it2 = hashMap.values().iterator();
                    while (it2.hasNext()) {
                        Log.v("favorite_migrate_pms", "Migrate == " + ((c) it2.next()).cbH.id);
                    }
                }
                ArrayList arrayList222 = new ArrayList(hashMap.values());
                Collections.sort(arrayList222, new d());
                matrixCursor = new MatrixCursor(cbE, 50);
                i = 0;
                it = arrayList222.iterator();
                while (true) {
                    int i222 = i;
                    if (it.hasNext()) {
                        a(matrixCursor, i222, (c) it.next());
                        i = i222 + 1;
                    } else {
                        return matrixCursor;
                    }
                }
            }
        }
    }

    public static Uri acf() {
        return com.baidu.swan.apps.database.favorite.b.CONTENT_URI.buildUpon().appendPath("favorite_with_aps_pms").build();
    }

    public static Uri acg() {
        return com.baidu.swan.apps.database.favorite.b.CONTENT_URI.buildUpon().appendPath("favorite").build();
    }

    private static void a(MatrixCursor matrixCursor, int i, c cVar) {
        if (cVar instanceof C0348a) {
            C0348a c0348a = (C0348a) cVar;
            matrixCursor.newRow().add(IMConstants.MSG_ROW_ID, Integer.valueOf(i)).add(SwanAppDbControl.SwanAppTable.app_id.name(), c0348a.cbF.appId).add(SwanAppDbControl.SwanAppTable.app_key.name(), c0348a.cbF.appKey).add(SwanAppDbControl.SwanAppTable.version.name(), c0348a.cbF.version).add(SwanAppDbControl.SwanAppTable.description.name(), c0348a.cbF.description).add(SwanAppDbControl.SwanAppTable.error_code.name(), Integer.valueOf(c0348a.cbF.errorCode)).add(SwanAppDbControl.SwanAppTable.error_detail.name(), c0348a.cbF.errorDetail).add(SwanAppDbControl.SwanAppTable.error_msg.name(), c0348a.cbF.errorMsg).add(SwanAppDbControl.SwanAppTable.resume_date.name(), c0348a.cbF.resumeDate).add(SwanAppDbControl.SwanAppTable.icon.name(), c0348a.cbF.icon).add(SwanAppDbControl.SwanAppTable.icon_url.name(), c0348a.cbF.iconUrl).add(SwanAppDbControl.SwanAppTable.max_swan_version.name(), c0348a.cbF.cbn).add(SwanAppDbControl.SwanAppTable.min_swan_version.name(), c0348a.cbF.cbo).add(SwanAppDbControl.SwanAppTable.name.name(), c0348a.cbF.name).add(SwanAppDbControl.SwanAppTable.service_category.name(), c0348a.cbF.serviceCategory).add(SwanAppDbControl.SwanAppTable.subject_info.name(), c0348a.cbF.subjectInfo).add(SwanAppDbControl.SwanAppTable.bear_info.name(), c0348a.cbF.bearInfo).add(SwanAppDbControl.SwanAppTable.sign.name(), c0348a.cbF.sign).add(SwanAppDbControl.SwanAppTable.type.name(), Integer.valueOf(c0348a.cbF.type)).add(SwanAppDbControl.SwanAppTable.is_have_zip.name(), Integer.valueOf(c0348a.cbF.cbp)).add(SwanAppDbControl.SwanAppTable.app_open_url.name(), c0348a.cbF.cbq).add(SwanAppDbControl.SwanAppTable.app_download_url.name(), c0348a.cbF.cbr).add(SwanAppDbControl.SwanAppTable.target_swan_version.name(), c0348a.cbF.cbs).add(SwanAppDbControl.SwanAppTable.app_zip_size.name(), Long.valueOf(c0348a.cbF.cbt)).add(SwanAppDbControl.SwanAppTable.pending_aps_errcode.name(), Integer.valueOf(c0348a.cbF.cbu)).add(SwanAppDbControl.SwanAppTable.version_code.name(), c0348a.cbF.cbv).add(SwanAppDbControl.SwanAppTable.app_category.name(), Integer.valueOf(c0348a.cbF.category)).add(SwanAppDbControl.SwanAppTable.orientation.name(), Integer.valueOf(c0348a.cbF.orientation)).add(SwanAppDbControl.SwanAppTable.max_age.name(), Long.valueOf(c0348a.cbF.maxAge)).add(SwanAppDbControl.SwanAppTable.create_time.name(), Long.valueOf(c0348a.cbF.createTime)).add(SwanAppDbControl.SwanAppTable.force_fetch_meta_info.name(), Integer.valueOf(c0348a.cbF.cbw ? 1 : 0)).add("favorite_time", Long.valueOf(c0348a.cbH.cbG)).add(SwanAppDbControl.SwanAppTable.pay_protected.name(), Integer.valueOf(c0348a.cbF.payProtected));
            return;
        }
        g gVar = (g) cVar;
        matrixCursor.newRow().add(IMConstants.MSG_ROW_ID, Integer.valueOf(i)).add(SwanAppDbControl.SwanAppTable.app_id.name(), gVar.cbI.appId).add(SwanAppDbControl.SwanAppTable.app_key.name(), gVar.cbI.appKey).add(SwanAppDbControl.SwanAppTable.version.name(), Integer.valueOf(gVar.cbI.versionCode)).add(SwanAppDbControl.SwanAppTable.description.name(), gVar.cbI.description).add(SwanAppDbControl.SwanAppTable.error_code.name(), Integer.valueOf(gVar.cbI.appStatus)).add(SwanAppDbControl.SwanAppTable.error_detail.name(), gVar.cbI.statusDetail).add(SwanAppDbControl.SwanAppTable.error_msg.name(), gVar.cbI.statusDesc).add(SwanAppDbControl.SwanAppTable.resume_date.name(), gVar.cbI.resumeDate).add(SwanAppDbControl.SwanAppTable.icon.name(), "").add(SwanAppDbControl.SwanAppTable.icon_url.name(), gVar.cbI.iconUrl).add(SwanAppDbControl.SwanAppTable.max_swan_version.name(), "").add(SwanAppDbControl.SwanAppTable.min_swan_version.name(), "").add(SwanAppDbControl.SwanAppTable.name.name(), gVar.cbI.appName).add(SwanAppDbControl.SwanAppTable.service_category.name(), gVar.cbI.serviceCategory).add(SwanAppDbControl.SwanAppTable.subject_info.name(), gVar.cbI.subjectInfo).add(SwanAppDbControl.SwanAppTable.bear_info.name(), gVar.cbI.bearInfo).add(SwanAppDbControl.SwanAppTable.sign.name(), "").add(SwanAppDbControl.SwanAppTable.type.name(), Integer.valueOf(gVar.cbI.type)).add(SwanAppDbControl.SwanAppTable.is_have_zip.name(), 0).add(SwanAppDbControl.SwanAppTable.app_open_url.name(), "").add(SwanAppDbControl.SwanAppTable.app_download_url.name(), "").add(SwanAppDbControl.SwanAppTable.target_swan_version.name(), "").add(SwanAppDbControl.SwanAppTable.app_zip_size.name(), Long.valueOf(gVar.cbI.pkgSize)).add(SwanAppDbControl.SwanAppTable.pending_aps_errcode.name(), Integer.valueOf(gVar.cbI.pendingErrCode)).add(SwanAppDbControl.SwanAppTable.version_code.name(), gVar.cbI.versionName).add(SwanAppDbControl.SwanAppTable.app_category.name(), Integer.valueOf(gVar.cbI.appCategory)).add(SwanAppDbControl.SwanAppTable.orientation.name(), Integer.valueOf(gVar.cbI.getOrientation())).add(SwanAppDbControl.SwanAppTable.max_age.name(), Long.valueOf(gVar.cbI.maxAge)).add(SwanAppDbControl.SwanAppTable.create_time.name(), Long.valueOf(gVar.cbI.createTime)).add(SwanAppDbControl.SwanAppTable.force_fetch_meta_info.name(), 0).add("favorite_time", Long.valueOf(gVar.cbH.cbG)).add(SwanAppDbControl.SwanAppTable.pay_protected.name(), Integer.valueOf(gVar.cbI.payProtected)).add("customer_service", Integer.valueOf(gVar.cbI.customerService)).add("global_notice", Integer.valueOf(gVar.cbI.globalNotice)).add("global_private", Integer.valueOf(gVar.cbI.globalPrivate)).add("pa_number", gVar.cbI.paNumber).add(Constants.PHONE_BRAND, gVar.cbI.brandsInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class b {
        long cbG;
        String id;

        private b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.database.favorite.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0348a extends c {
        com.baidu.swan.apps.database.a cbF;

        private C0348a() {
            super();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class g extends c {
        PMSAppInfo cbI;

        private g() {
            super();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static abstract class c {
        b cbH;

        private c() {
            this.cbH = new b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class d implements Comparator<c> {
        private d() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(c cVar, c cVar2) {
            return Long.compare(cVar2.cbH.cbG, cVar.cbH.cbG);
        }
    }
}

package com.baidu.swan.apps.database.favorite;

import android.content.ContentValues;
import android.content.SharedPreferences;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.pass.biometrics.face.liveness.stat.LivenessStat;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.database.SwanAppDbControl;
import com.baidu.swan.apps.env.SwanAppDeleteInfo;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String[] aPa = {IMConstants.MSG_ROW_ID, SwanAppDbControl.SwanAppTable.app_id.name(), SwanAppDbControl.SwanAppTable.app_key.name(), SwanAppDbControl.SwanAppTable.version.name(), SwanAppDbControl.SwanAppTable.description.name(), SwanAppDbControl.SwanAppTable.error_code.name(), SwanAppDbControl.SwanAppTable.error_detail.name(), SwanAppDbControl.SwanAppTable.error_msg.name(), SwanAppDbControl.SwanAppTable.resume_date.name(), SwanAppDbControl.SwanAppTable.icon.name(), SwanAppDbControl.SwanAppTable.icon_url.name(), SwanAppDbControl.SwanAppTable.max_swan_version.name(), SwanAppDbControl.SwanAppTable.min_swan_version.name(), SwanAppDbControl.SwanAppTable.name.name(), SwanAppDbControl.SwanAppTable.service_category.name(), SwanAppDbControl.SwanAppTable.subject_info.name(), SwanAppDbControl.SwanAppTable.bear_info.name(), SwanAppDbControl.SwanAppTable.sign.name(), SwanAppDbControl.SwanAppTable.type.name(), SwanAppDbControl.SwanAppTable.is_have_zip.name(), SwanAppDbControl.SwanAppTable.app_open_url.name(), SwanAppDbControl.SwanAppTable.app_download_url.name(), SwanAppDbControl.SwanAppTable.target_swan_version.name(), SwanAppDbControl.SwanAppTable.app_zip_size.name(), SwanAppDbControl.SwanAppTable.pending_aps_errcode.name(), SwanAppDbControl.SwanAppTable.version_code.name(), SwanAppDbControl.SwanAppTable.app_category.name(), SwanAppDbControl.SwanAppTable.orientation.name(), SwanAppDbControl.SwanAppTable.max_age.name(), SwanAppDbControl.SwanAppTable.create_time.name(), SwanAppDbControl.SwanAppTable.force_fetch_meta_info.name(), "favorite_time"};

    public static boolean eQ(@NonNull String str) {
        Uri build = com.baidu.swan.apps.database.favorite.b.CONTENT_URI.buildUpon().appendPath("favorite").build();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Constants.APP_ID, str);
        contentValues.put("favorite_time", Long.valueOf(System.currentTimeMillis()));
        if (AppRuntime.getAppContext().getContentResolver().insert(build, contentValues) != null) {
            if (DEBUG) {
                Log.d("SwanAppFavoriteHelper", "收藏成功： " + str);
            }
            com.baidu.swan.apps.storage.b.f.SR().putString("favorite_guide_count_" + str, LivenessStat.TYPE_STRING_DEFAULT);
            Hy();
            return true;
        }
        return false;
    }

    public static boolean eR(@NonNull String str) {
        int delete = AppRuntime.getAppContext().getContentResolver().delete(com.baidu.swan.apps.database.favorite.b.CONTENT_URI.buildUpon().appendPath("favorite").build(), "app_id = ?", new String[]{str});
        if (delete > 0) {
            if (DEBUG) {
                Log.d("SwanAppFavoriteHelper", "删除收藏，检查是否需要清理包");
            }
            if (ProcessUtils.isMainProcess()) {
                com.baidu.swan.apps.env.b HP = com.baidu.swan.apps.env.d.HN().HP();
                if (HP != null) {
                    HP.s(str, true);
                }
            } else {
                com.baidu.swan.apps.process.messaging.client.a.Op().a(8, new SwanAppDeleteInfo(str));
            }
            if (DEBUG) {
                Log.d("SwanAppFavoriteHelper", "取消收藏成功： " + str);
            }
            Hy();
        }
        return delete > 0;
    }

    public static boolean eS(@NonNull String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("favorite_time", Long.valueOf(System.currentTimeMillis()));
        int update = AppRuntime.getAppContext().getContentResolver().update(com.baidu.swan.apps.database.favorite.b.CONTENT_URI.buildUpon().appendPath("favorite").build(), contentValues, "app_id = ?", new String[]{str});
        if (update > 0) {
            if (DEBUG) {
                Log.d("SwanAppFavoriteHelper", "收藏移动到最前成功： " + str);
            }
            Hy();
        }
        return update > 0;
    }

    @NonNull
    public static List<com.baidu.swan.apps.database.a> Hw() {
        Cursor query;
        ArrayList arrayList = new ArrayList();
        if (com.baidu.swan.apps.core.pms.a.Ge()) {
            query = HA();
        } else {
            query = AppRuntime.getAppContext().getContentResolver().query(Hx(), null, null, null, "favorite_time DESC");
        }
        try {
            if (query != null) {
                if (query.moveToFirst()) {
                    do {
                        com.baidu.swan.apps.database.a aVar = new com.baidu.swan.apps.database.a();
                        SwanAppDbControl.aZ(AppRuntime.getAppContext()).a(query, aVar);
                        if (!TextUtils.isEmpty(aVar.appId)) {
                            arrayList.add(aVar);
                        }
                    } while (query.moveToNext());
                }
            }
        } catch (Exception e2) {
            if (DEBUG) {
                e2.printStackTrace();
            }
        } finally {
            com.baidu.swan.c.a.b(query);
        }
        return arrayList;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [219=4] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0035 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean eT(@NonNull String str) {
        boolean z;
        Cursor query;
        try {
            query = AppRuntime.getAppContext().getContentResolver().query(com.baidu.swan.apps.database.favorite.b.CONTENT_URI.buildUpon().appendPath("favorite").build(), null, "app_id = ?", new String[]{str}, null);
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

    public static Uri Hx() {
        return com.baidu.swan.apps.database.favorite.b.CONTENT_URI.buildUpon().appendPath("favorite_and_aps").build();
    }

    public static boolean eU(@NonNull String str) {
        return "sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u".equals(str);
    }

    private static void Hy() {
        AppRuntime.getAppContext().getContentResolver().notifyChange(Hx(), (ContentObserver) null, false);
        AppRuntime.getAppContext().getContentResolver().notifyChange(HB(), (ContentObserver) null, false);
    }

    public static void Hz() {
        if (DEBUG) {
            Log.d("SwanAppFavoriteHelper", "记录用户在小程序框架菜单中点击收藏");
        }
        DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), e.class, null);
    }

    /* loaded from: classes2.dex */
    private static class e extends ProviderDelegation {
        private e() {
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
    /* JADX WARN: Removed duplicated region for block: B:24:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x01eb A[LOOP:3: B:41:0x01e5->B:43:0x01eb, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01fd  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x027b A[LOOP:5: B:51:0x0275->B:53:0x027b, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0288 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Cursor HA() {
        Cursor query;
        MatrixCursor matrixCursor;
        int i;
        Iterator it;
        HashMap hashMap = new HashMap();
        Cursor query2 = AppRuntime.getAppContext().getContentResolver().query(Hx(), null, null, null, "favorite_time DESC");
        if (query2 != null && query2.moveToFirst()) {
            do {
                com.baidu.swan.apps.database.a aVar = new com.baidu.swan.apps.database.a();
                SwanAppDbControl.aZ(AppRuntime.getAppContext()).a(query2, aVar);
                if (!TextUtils.isEmpty(aVar.appId)) {
                    C0187a c0187a = new C0187a();
                    c0187a.aPb = aVar;
                    c0187a.aPd.id = aVar.appId;
                    c0187a.aPd.aPc = query2.getLong(query2.getColumnIndex("favorite_time"));
                    hashMap.put(c0187a.aPd.id, c0187a);
                    if (DEBUG) {
                        Log.v("favorite_migrate_pms", "Aps&Favotite == " + aVar.appId);
                    }
                }
            } while (query2.moveToNext());
            com.baidu.swan.c.a.b(query2);
            if (DEBUG) {
            }
            query = AppRuntime.getAppContext().getContentResolver().query(com.baidu.swan.apps.database.favorite.b.CONTENT_URI.buildUpon().appendPath("favorite").build(), null, null, null, null);
            HashMap hashMap2 = new HashMap();
            if (query == null) {
            }
            com.baidu.swan.c.a.b(query);
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
            matrixCursor = new MatrixCursor(aPa, 50);
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
            com.baidu.swan.c.a.b(query2);
            if (DEBUG) {
                Log.d("favorite_migrate_pms", "^ Aps & Favorite 查询到 " + hashMap.size() + " 条收藏");
            }
            query = AppRuntime.getAppContext().getContentResolver().query(com.baidu.swan.apps.database.favorite.b.CONTENT_URI.buildUpon().appendPath("favorite").build(), null, null, null, null);
            HashMap hashMap22 = new HashMap();
            if (query == null && query.moveToFirst()) {
                do {
                    b bVar = new b();
                    bVar.id = query.getString(query.getColumnIndex(Constants.APP_ID));
                    bVar.aPc = query.getLong(query.getColumnIndex("favorite_time"));
                    hashMap22.put(bVar.id, bVar);
                    if (DEBUG) {
                        Log.v("favorite_migrate_pms", "Favotite == " + bVar.id);
                    }
                } while (query.moveToNext());
                com.baidu.swan.c.a.b(query);
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
                matrixCursor = new MatrixCursor(aPa, 50);
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
                com.baidu.swan.c.a.b(query);
                if (DEBUG) {
                    Log.d("favorite_migrate_pms", "^ Favorite 库查询到 " + hashMap22.size() + " 条收藏");
                }
                ArrayList<c> arrayList32 = new ArrayList();
                for (PMSAppInfo pMSAppInfo : new ArrayList(com.baidu.swan.pms.database.a.aaX().aaY().values())) {
                    if (DEBUG) {
                        Log.v("favorite_migrate_pms", "Pms == " + pMSAppInfo.appId);
                    }
                    if (hashMap22.containsKey(pMSAppInfo.appId)) {
                        f fVar = new f();
                        fVar.aPd = (b) hashMap22.get(pMSAppInfo.appId);
                        fVar.aPe = pMSAppInfo;
                        arrayList32.add(fVar);
                    }
                }
                if (DEBUG) {
                    Log.d("favorite_migrate_pms", "^ Pms & Favorite 查询到 " + arrayList32.size() + " 条收藏");
                }
                for (c cVar : arrayList32) {
                    hashMap.put(cVar.aPd.id, cVar);
                }
                if (DEBUG) {
                    Log.d("favorite_migrate_pms", "合并后有 " + hashMap.size() + " 条收藏");
                    Iterator it2 = hashMap.values().iterator();
                    while (it2.hasNext()) {
                        Log.v("favorite_migrate_pms", "Migrate == " + ((c) it2.next()).aPd.id);
                    }
                }
                ArrayList arrayList222 = new ArrayList(hashMap.values());
                Collections.sort(arrayList222, new d());
                matrixCursor = new MatrixCursor(aPa, 50);
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

    public static Uri HB() {
        return com.baidu.swan.apps.database.favorite.b.CONTENT_URI.buildUpon().appendPath("favorite_with_aps_pms").build();
    }

    private static void a(MatrixCursor matrixCursor, int i, c cVar) {
        if (cVar instanceof C0187a) {
            C0187a c0187a = (C0187a) cVar;
            matrixCursor.newRow().add(IMConstants.MSG_ROW_ID, Integer.valueOf(i)).add(SwanAppDbControl.SwanAppTable.app_id.name(), c0187a.aPb.appId).add(SwanAppDbControl.SwanAppTable.app_key.name(), c0187a.aPb.appKey).add(SwanAppDbControl.SwanAppTable.version.name(), c0187a.aPb.version).add(SwanAppDbControl.SwanAppTable.description.name(), c0187a.aPb.description).add(SwanAppDbControl.SwanAppTable.error_code.name(), Integer.valueOf(c0187a.aPb.errorCode)).add(SwanAppDbControl.SwanAppTable.error_detail.name(), c0187a.aPb.errorDetail).add(SwanAppDbControl.SwanAppTable.error_msg.name(), c0187a.aPb.errorMsg).add(SwanAppDbControl.SwanAppTable.resume_date.name(), c0187a.aPb.aOG).add(SwanAppDbControl.SwanAppTable.icon.name(), c0187a.aPb.icon).add(SwanAppDbControl.SwanAppTable.icon_url.name(), c0187a.aPb.iconUrl).add(SwanAppDbControl.SwanAppTable.max_swan_version.name(), c0187a.aPb.aOH).add(SwanAppDbControl.SwanAppTable.min_swan_version.name(), c0187a.aPb.aOI).add(SwanAppDbControl.SwanAppTable.name.name(), c0187a.aPb.name).add(SwanAppDbControl.SwanAppTable.service_category.name(), c0187a.aPb.aOJ).add(SwanAppDbControl.SwanAppTable.subject_info.name(), c0187a.aPb.aOK).add(SwanAppDbControl.SwanAppTable.bear_info.name(), c0187a.aPb.aOL).add(SwanAppDbControl.SwanAppTable.sign.name(), c0187a.aPb.sign).add(SwanAppDbControl.SwanAppTable.type.name(), Integer.valueOf(c0187a.aPb.type)).add(SwanAppDbControl.SwanAppTable.is_have_zip.name(), Integer.valueOf(c0187a.aPb.aOM)).add(SwanAppDbControl.SwanAppTable.app_open_url.name(), c0187a.aPb.aON).add(SwanAppDbControl.SwanAppTable.app_download_url.name(), c0187a.aPb.aOO).add(SwanAppDbControl.SwanAppTable.target_swan_version.name(), c0187a.aPb.aOP).add(SwanAppDbControl.SwanAppTable.app_zip_size.name(), Long.valueOf(c0187a.aPb.aOQ)).add(SwanAppDbControl.SwanAppTable.pending_aps_errcode.name(), Integer.valueOf(c0187a.aPb.aOR)).add(SwanAppDbControl.SwanAppTable.version_code.name(), c0187a.aPb.aOS).add(SwanAppDbControl.SwanAppTable.app_category.name(), Integer.valueOf(c0187a.aPb.category)).add(SwanAppDbControl.SwanAppTable.orientation.name(), Integer.valueOf(c0187a.aPb.orientation)).add(SwanAppDbControl.SwanAppTable.max_age.name(), Long.valueOf(c0187a.aPb.aOT)).add(SwanAppDbControl.SwanAppTable.create_time.name(), Long.valueOf(c0187a.aPb.createTime)).add(SwanAppDbControl.SwanAppTable.force_fetch_meta_info.name(), Integer.valueOf(c0187a.aPb.aOU ? 1 : 0)).add("favorite_time", Long.valueOf(c0187a.aPd.aPc));
            return;
        }
        f fVar = (f) cVar;
        matrixCursor.newRow().add(IMConstants.MSG_ROW_ID, Integer.valueOf(i)).add(SwanAppDbControl.SwanAppTable.app_id.name(), fVar.aPe.appId).add(SwanAppDbControl.SwanAppTable.app_key.name(), fVar.aPe.appKey).add(SwanAppDbControl.SwanAppTable.version.name(), Integer.valueOf(fVar.aPe.versionCode)).add(SwanAppDbControl.SwanAppTable.description.name(), fVar.aPe.description).add(SwanAppDbControl.SwanAppTable.error_code.name(), Integer.valueOf(fVar.aPe.appStatus)).add(SwanAppDbControl.SwanAppTable.error_detail.name(), fVar.aPe.bLQ).add(SwanAppDbControl.SwanAppTable.error_msg.name(), fVar.aPe.bLR).add(SwanAppDbControl.SwanAppTable.resume_date.name(), fVar.aPe.aOG).add(SwanAppDbControl.SwanAppTable.icon.name(), "").add(SwanAppDbControl.SwanAppTable.icon_url.name(), fVar.aPe.iconUrl).add(SwanAppDbControl.SwanAppTable.max_swan_version.name(), "").add(SwanAppDbControl.SwanAppTable.min_swan_version.name(), "").add(SwanAppDbControl.SwanAppTable.name.name(), fVar.aPe.appName).add(SwanAppDbControl.SwanAppTable.service_category.name(), fVar.aPe.aOJ).add(SwanAppDbControl.SwanAppTable.subject_info.name(), fVar.aPe.aOK).add(SwanAppDbControl.SwanAppTable.bear_info.name(), fVar.aPe.aOL).add(SwanAppDbControl.SwanAppTable.sign.name(), "").add(SwanAppDbControl.SwanAppTable.type.name(), Integer.valueOf(fVar.aPe.type)).add(SwanAppDbControl.SwanAppTable.is_have_zip.name(), 0).add(SwanAppDbControl.SwanAppTable.app_open_url.name(), "").add(SwanAppDbControl.SwanAppTable.app_download_url.name(), "").add(SwanAppDbControl.SwanAppTable.target_swan_version.name(), "").add(SwanAppDbControl.SwanAppTable.app_zip_size.name(), Long.valueOf(fVar.aPe.bLS)).add(SwanAppDbControl.SwanAppTable.pending_aps_errcode.name(), Integer.valueOf(fVar.aPe.bLT)).add(SwanAppDbControl.SwanAppTable.version_code.name(), fVar.aPe.versionName).add(SwanAppDbControl.SwanAppTable.app_category.name(), Integer.valueOf(fVar.aPe.bLU)).add(SwanAppDbControl.SwanAppTable.orientation.name(), Integer.valueOf(fVar.aPe.orientation)).add(SwanAppDbControl.SwanAppTable.max_age.name(), Long.valueOf(fVar.aPe.aOT)).add(SwanAppDbControl.SwanAppTable.create_time.name(), Long.valueOf(fVar.aPe.createTime)).add(SwanAppDbControl.SwanAppTable.force_fetch_meta_info.name(), 0).add("favorite_time", Long.valueOf(fVar.aPd.aPc));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class b {
        long aPc;
        String id;

        private b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.database.favorite.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0187a extends c {
        com.baidu.swan.apps.database.a aPb;

        private C0187a() {
            super();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class f extends c {
        PMSAppInfo aPe;

        private f() {
            super();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static abstract class c {
        b aPd;

        private c() {
            this.aPd = new b();
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
            return Long.compare(cVar2.aPd.aPc, cVar.aPd.aPc);
        }
    }
}

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
    private static final String[] avn = {"_id", SwanAppDbControl.SwanAppTable.app_id.name(), SwanAppDbControl.SwanAppTable.app_key.name(), SwanAppDbControl.SwanAppTable.version.name(), SwanAppDbControl.SwanAppTable.description.name(), SwanAppDbControl.SwanAppTable.error_code.name(), SwanAppDbControl.SwanAppTable.error_detail.name(), SwanAppDbControl.SwanAppTable.error_msg.name(), SwanAppDbControl.SwanAppTable.resume_date.name(), SwanAppDbControl.SwanAppTable.icon.name(), SwanAppDbControl.SwanAppTable.icon_url.name(), SwanAppDbControl.SwanAppTable.max_swan_version.name(), SwanAppDbControl.SwanAppTable.min_swan_version.name(), SwanAppDbControl.SwanAppTable.name.name(), SwanAppDbControl.SwanAppTable.service_category.name(), SwanAppDbControl.SwanAppTable.subject_info.name(), SwanAppDbControl.SwanAppTable.bear_info.name(), SwanAppDbControl.SwanAppTable.sign.name(), SwanAppDbControl.SwanAppTable.type.name(), SwanAppDbControl.SwanAppTable.is_have_zip.name(), SwanAppDbControl.SwanAppTable.app_open_url.name(), SwanAppDbControl.SwanAppTable.app_download_url.name(), SwanAppDbControl.SwanAppTable.target_swan_version.name(), SwanAppDbControl.SwanAppTable.app_zip_size.name(), SwanAppDbControl.SwanAppTable.pending_aps_errcode.name(), SwanAppDbControl.SwanAppTable.version_code.name(), SwanAppDbControl.SwanAppTable.app_category.name(), SwanAppDbControl.SwanAppTable.orientation.name(), SwanAppDbControl.SwanAppTable.max_age.name(), SwanAppDbControl.SwanAppTable.create_time.name(), SwanAppDbControl.SwanAppTable.force_fetch_meta_info.name(), "favorite_time"};

    public static boolean eh(@NonNull String str) {
        Uri build = com.baidu.swan.apps.database.favorite.b.CONTENT_URI.buildUpon().appendPath("favorite").build();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Constants.APP_ID, str);
        contentValues.put("favorite_time", Long.valueOf(System.currentTimeMillis()));
        if (AppRuntime.getAppContext().getContentResolver().insert(build, contentValues) != null) {
            if (DEBUG) {
                Log.d("SwanAppFavoriteHelper", "收藏成功： " + str);
            }
            com.baidu.swan.apps.storage.b.f.NX().putString("favorite_guide_count_" + str, LivenessStat.TYPE_STRING_DEFAULT);
            CA();
            return true;
        }
        return false;
    }

    public static boolean ei(@NonNull String str) {
        int delete = AppRuntime.getAppContext().getContentResolver().delete(com.baidu.swan.apps.database.favorite.b.CONTENT_URI.buildUpon().appendPath("favorite").build(), "app_id = ?", new String[]{str});
        if (delete > 0) {
            if (DEBUG) {
                Log.d("SwanAppFavoriteHelper", "删除收藏，检查是否需要清理包");
            }
            if (ProcessUtils.isMainProcess()) {
                com.baidu.swan.apps.env.b CR = com.baidu.swan.apps.env.d.CP().CR();
                if (CR != null) {
                    CR.p(str, true);
                }
            } else {
                com.baidu.swan.apps.process.messaging.client.a.Jr().a(8, new SwanAppDeleteInfo(str));
            }
            if (DEBUG) {
                Log.d("SwanAppFavoriteHelper", "取消收藏成功： " + str);
            }
            CA();
        }
        return delete > 0;
    }

    public static boolean ej(@NonNull String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("favorite_time", Long.valueOf(System.currentTimeMillis()));
        int update = AppRuntime.getAppContext().getContentResolver().update(com.baidu.swan.apps.database.favorite.b.CONTENT_URI.buildUpon().appendPath("favorite").build(), contentValues, "app_id = ?", new String[]{str});
        if (update > 0) {
            if (DEBUG) {
                Log.d("SwanAppFavoriteHelper", "收藏移动到最前成功： " + str);
            }
            CA();
        }
        return update > 0;
    }

    @NonNull
    public static List<com.baidu.swan.apps.database.a> Cy() {
        Cursor query;
        ArrayList arrayList = new ArrayList();
        if (com.baidu.swan.apps.core.pms.a.Bf()) {
            query = CC();
        } else {
            query = AppRuntime.getAppContext().getContentResolver().query(Cz(), null, null, null, "favorite_time DESC");
        }
        try {
            if (query != null) {
                if (query.moveToFirst()) {
                    do {
                        com.baidu.swan.apps.database.a aVar = new com.baidu.swan.apps.database.a();
                        SwanAppDbControl.aX(AppRuntime.getAppContext()).a(query, aVar);
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
            com.baidu.swan.c.a.c(query);
        }
        return arrayList;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [219=4] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0035 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean ek(@NonNull String str) {
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

    public static Uri Cz() {
        return com.baidu.swan.apps.database.favorite.b.CONTENT_URI.buildUpon().appendPath("favorite_and_aps").build();
    }

    public static boolean el(@NonNull String str) {
        return "sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u".equals(str);
    }

    private static void CA() {
        AppRuntime.getAppContext().getContentResolver().notifyChange(Cz(), (ContentObserver) null, false);
        AppRuntime.getAppContext().getContentResolver().notifyChange(CD(), (ContentObserver) null, false);
    }

    public static void CB() {
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
    public static Cursor CC() {
        Cursor query;
        MatrixCursor matrixCursor;
        int i;
        Iterator it;
        HashMap hashMap = new HashMap();
        Cursor query2 = AppRuntime.getAppContext().getContentResolver().query(Cz(), null, null, null, "favorite_time DESC");
        if (query2 != null && query2.moveToFirst()) {
            do {
                com.baidu.swan.apps.database.a aVar = new com.baidu.swan.apps.database.a();
                SwanAppDbControl.aX(AppRuntime.getAppContext()).a(query2, aVar);
                if (!TextUtils.isEmpty(aVar.appId)) {
                    C0146a c0146a = new C0146a();
                    c0146a.avo = aVar;
                    c0146a.avq.id = aVar.appId;
                    c0146a.avq.avp = query2.getLong(query2.getColumnIndex("favorite_time"));
                    hashMap.put(c0146a.avq.id, c0146a);
                    if (DEBUG) {
                        Log.v("favorite_migrate_pms", "Aps&Favotite == " + aVar.appId);
                    }
                }
            } while (query2.moveToNext());
            com.baidu.swan.c.a.c(query2);
            if (DEBUG) {
            }
            query = AppRuntime.getAppContext().getContentResolver().query(com.baidu.swan.apps.database.favorite.b.CONTENT_URI.buildUpon().appendPath("favorite").build(), null, null, null, null);
            HashMap hashMap2 = new HashMap();
            if (query == null) {
            }
            com.baidu.swan.c.a.c(query);
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
            matrixCursor = new MatrixCursor(avn, 50);
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
            com.baidu.swan.c.a.c(query2);
            if (DEBUG) {
                Log.d("favorite_migrate_pms", "^ Aps & Favorite 查询到 " + hashMap.size() + " 条收藏");
            }
            query = AppRuntime.getAppContext().getContentResolver().query(com.baidu.swan.apps.database.favorite.b.CONTENT_URI.buildUpon().appendPath("favorite").build(), null, null, null, null);
            HashMap hashMap22 = new HashMap();
            if (query == null && query.moveToFirst()) {
                do {
                    b bVar = new b();
                    bVar.id = query.getString(query.getColumnIndex(Constants.APP_ID));
                    bVar.avp = query.getLong(query.getColumnIndex("favorite_time"));
                    hashMap22.put(bVar.id, bVar);
                    if (DEBUG) {
                        Log.v("favorite_migrate_pms", "Favotite == " + bVar.id);
                    }
                } while (query.moveToNext());
                com.baidu.swan.c.a.c(query);
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
                matrixCursor = new MatrixCursor(avn, 50);
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
                com.baidu.swan.c.a.c(query);
                if (DEBUG) {
                    Log.d("favorite_migrate_pms", "^ Favorite 库查询到 " + hashMap22.size() + " 条收藏");
                }
                ArrayList<c> arrayList32 = new ArrayList();
                for (PMSAppInfo pMSAppInfo : new ArrayList(com.baidu.swan.pms.database.a.We().Wf().values())) {
                    if (DEBUG) {
                        Log.v("favorite_migrate_pms", "Pms == " + pMSAppInfo.appId);
                    }
                    if (hashMap22.containsKey(pMSAppInfo.appId)) {
                        f fVar = new f();
                        fVar.avq = (b) hashMap22.get(pMSAppInfo.appId);
                        fVar.avr = pMSAppInfo;
                        arrayList32.add(fVar);
                    }
                }
                if (DEBUG) {
                    Log.d("favorite_migrate_pms", "^ Pms & Favorite 查询到 " + arrayList32.size() + " 条收藏");
                }
                for (c cVar : arrayList32) {
                    hashMap.put(cVar.avq.id, cVar);
                }
                if (DEBUG) {
                    Log.d("favorite_migrate_pms", "合并后有 " + hashMap.size() + " 条收藏");
                    Iterator it2 = hashMap.values().iterator();
                    while (it2.hasNext()) {
                        Log.v("favorite_migrate_pms", "Migrate == " + ((c) it2.next()).avq.id);
                    }
                }
                ArrayList arrayList222 = new ArrayList(hashMap.values());
                Collections.sort(arrayList222, new d());
                matrixCursor = new MatrixCursor(avn, 50);
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

    public static Uri CD() {
        return com.baidu.swan.apps.database.favorite.b.CONTENT_URI.buildUpon().appendPath("favorite_with_aps_pms").build();
    }

    private static void a(MatrixCursor matrixCursor, int i, c cVar) {
        if (cVar instanceof C0146a) {
            C0146a c0146a = (C0146a) cVar;
            matrixCursor.newRow().add("_id", Integer.valueOf(i)).add(SwanAppDbControl.SwanAppTable.app_id.name(), c0146a.avo.appId).add(SwanAppDbControl.SwanAppTable.app_key.name(), c0146a.avo.appKey).add(SwanAppDbControl.SwanAppTable.version.name(), c0146a.avo.version).add(SwanAppDbControl.SwanAppTable.description.name(), c0146a.avo.description).add(SwanAppDbControl.SwanAppTable.error_code.name(), Integer.valueOf(c0146a.avo.errorCode)).add(SwanAppDbControl.SwanAppTable.error_detail.name(), c0146a.avo.errorDetail).add(SwanAppDbControl.SwanAppTable.error_msg.name(), c0146a.avo.errorMsg).add(SwanAppDbControl.SwanAppTable.resume_date.name(), c0146a.avo.auS).add(SwanAppDbControl.SwanAppTable.icon.name(), c0146a.avo.icon).add(SwanAppDbControl.SwanAppTable.icon_url.name(), c0146a.avo.iconUrl).add(SwanAppDbControl.SwanAppTable.max_swan_version.name(), c0146a.avo.auT).add(SwanAppDbControl.SwanAppTable.min_swan_version.name(), c0146a.avo.auU).add(SwanAppDbControl.SwanAppTable.name.name(), c0146a.avo.name).add(SwanAppDbControl.SwanAppTable.service_category.name(), c0146a.avo.auV).add(SwanAppDbControl.SwanAppTable.subject_info.name(), c0146a.avo.auW).add(SwanAppDbControl.SwanAppTable.bear_info.name(), c0146a.avo.auX).add(SwanAppDbControl.SwanAppTable.sign.name(), c0146a.avo.sign).add(SwanAppDbControl.SwanAppTable.type.name(), Integer.valueOf(c0146a.avo.type)).add(SwanAppDbControl.SwanAppTable.is_have_zip.name(), Integer.valueOf(c0146a.avo.auY)).add(SwanAppDbControl.SwanAppTable.app_open_url.name(), c0146a.avo.auZ).add(SwanAppDbControl.SwanAppTable.app_download_url.name(), c0146a.avo.ava).add(SwanAppDbControl.SwanAppTable.target_swan_version.name(), c0146a.avo.avb).add(SwanAppDbControl.SwanAppTable.app_zip_size.name(), Long.valueOf(c0146a.avo.avc)).add(SwanAppDbControl.SwanAppTable.pending_aps_errcode.name(), Integer.valueOf(c0146a.avo.avd)).add(SwanAppDbControl.SwanAppTable.version_code.name(), c0146a.avo.avf).add(SwanAppDbControl.SwanAppTable.app_category.name(), Integer.valueOf(c0146a.avo.ave)).add(SwanAppDbControl.SwanAppTable.orientation.name(), Integer.valueOf(c0146a.avo.orientation)).add(SwanAppDbControl.SwanAppTable.max_age.name(), Long.valueOf(c0146a.avo.avg)).add(SwanAppDbControl.SwanAppTable.create_time.name(), Long.valueOf(c0146a.avo.createTime)).add(SwanAppDbControl.SwanAppTable.force_fetch_meta_info.name(), Integer.valueOf(c0146a.avo.avh ? 1 : 0)).add("favorite_time", Long.valueOf(c0146a.avq.avp));
            return;
        }
        f fVar = (f) cVar;
        matrixCursor.newRow().add("_id", Integer.valueOf(i)).add(SwanAppDbControl.SwanAppTable.app_id.name(), fVar.avr.appId).add(SwanAppDbControl.SwanAppTable.app_key.name(), fVar.avr.appKey).add(SwanAppDbControl.SwanAppTable.version.name(), Integer.valueOf(fVar.avr.versionCode)).add(SwanAppDbControl.SwanAppTable.description.name(), fVar.avr.description).add(SwanAppDbControl.SwanAppTable.error_code.name(), Integer.valueOf(fVar.avr.appStatus)).add(SwanAppDbControl.SwanAppTable.error_detail.name(), fVar.avr.bsH).add(SwanAppDbControl.SwanAppTable.error_msg.name(), fVar.avr.bsI).add(SwanAppDbControl.SwanAppTable.resume_date.name(), fVar.avr.auS).add(SwanAppDbControl.SwanAppTable.icon.name(), "").add(SwanAppDbControl.SwanAppTable.icon_url.name(), fVar.avr.iconUrl).add(SwanAppDbControl.SwanAppTable.max_swan_version.name(), "").add(SwanAppDbControl.SwanAppTable.min_swan_version.name(), "").add(SwanAppDbControl.SwanAppTable.name.name(), fVar.avr.appName).add(SwanAppDbControl.SwanAppTable.service_category.name(), fVar.avr.auV).add(SwanAppDbControl.SwanAppTable.subject_info.name(), fVar.avr.auW).add(SwanAppDbControl.SwanAppTable.bear_info.name(), fVar.avr.auX).add(SwanAppDbControl.SwanAppTable.sign.name(), "").add(SwanAppDbControl.SwanAppTable.type.name(), Integer.valueOf(fVar.avr.type)).add(SwanAppDbControl.SwanAppTable.is_have_zip.name(), 0).add(SwanAppDbControl.SwanAppTable.app_open_url.name(), "").add(SwanAppDbControl.SwanAppTable.app_download_url.name(), "").add(SwanAppDbControl.SwanAppTable.target_swan_version.name(), "").add(SwanAppDbControl.SwanAppTable.app_zip_size.name(), Long.valueOf(fVar.avr.bsJ)).add(SwanAppDbControl.SwanAppTable.pending_aps_errcode.name(), Integer.valueOf(fVar.avr.bsK)).add(SwanAppDbControl.SwanAppTable.version_code.name(), fVar.avr.versionName).add(SwanAppDbControl.SwanAppTable.app_category.name(), Integer.valueOf(fVar.avr.bsL)).add(SwanAppDbControl.SwanAppTable.orientation.name(), Integer.valueOf(fVar.avr.orientation)).add(SwanAppDbControl.SwanAppTable.max_age.name(), Long.valueOf(fVar.avr.avg)).add(SwanAppDbControl.SwanAppTable.create_time.name(), Long.valueOf(fVar.avr.createTime)).add(SwanAppDbControl.SwanAppTable.force_fetch_meta_info.name(), 0).add("favorite_time", Long.valueOf(fVar.avq.avp));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class b {
        long avp;
        String id;

        private b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.database.favorite.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0146a extends c {
        com.baidu.swan.apps.database.a avo;

        private C0146a() {
            super();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class f extends c {
        PMSAppInfo avr;

        private f() {
            super();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static abstract class c {
        b avq;

        private c() {
            this.avq = new b();
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
            return Long.compare(cVar2.avq.avp, cVar.avq.avp);
        }
    }
}

package com.baidu.swan.apps.favordata;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.a.c;
import com.baidu.swan.apps.aq.n;
import com.baidu.swan.apps.commonsync.CommonSyncServerData;
import com.baidu.swan.apps.database.SwanAppDbControl;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.storage.c.h;
import com.baidu.swan.apps.w.f;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
/* loaded from: classes11.dex */
public class SwanFavorDataManager implements c {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    /* loaded from: classes11.dex */
    public interface a {
        void ac(List<SwanFavorItemData> list);

        void adb();
    }

    /* loaded from: classes11.dex */
    public class FavorDataDBLoaderCB implements LoaderManager.LoaderCallbacks<Cursor> {
        private a cdH;

        @Override // android.support.v4.app.LoaderManager.LoaderCallbacks
        @NonNull
        public Loader<Cursor> onCreateLoader(int i, @Nullable Bundle bundle) {
            return new CursorLoader(com.baidu.swan.apps.u.a.aeR(), com.baidu.swan.apps.database.favorite.a.acg(), null, null, null, "sort_index");
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Removed duplicated region for block: B:23:0x004a  */
        /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
        @Override // android.support.v4.app.LoaderManager.LoaderCallbacks
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onLoadFinished(@NonNull Loader<Cursor> loader, Cursor cursor) {
            if (loader.getId() != 101) {
                if (this.cdH != null) {
                    this.cdH.adb();
                    return;
                }
                return;
            }
            ArrayList arrayList = new ArrayList();
            if (cursor != null && cursor.getCount() > 0 && cursor.moveToFirst()) {
                do {
                    SwanFavorItemData c = com.baidu.swan.apps.database.favorite.a.c(cursor);
                    if (!TextUtils.isEmpty(c.getAppKey()) && !TextUtils.isEmpty(c.getAppName())) {
                        arrayList.add(c);
                    }
                } while (cursor.moveToNext());
                if (this.cdH == null) {
                }
            } else if (this.cdH == null) {
                this.cdH.ac(arrayList);
            }
        }

        @Override // android.support.v4.app.LoaderManager.LoaderCallbacks
        public void onLoaderReset(@NonNull Loader<Cursor> loader) {
            if (this.cdH != null) {
                this.cdH.adb();
            }
        }
    }

    private SwanFavorDataManager() {
        SwanAppDbControl.bN(com.baidu.swan.apps.u.a.aeR());
        com.baidu.swan.apps.u.a.aeW().a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class b {
        private static final SwanFavorDataManager cdI = new SwanFavorDataManager();
    }

    public static SwanFavorDataManager acW() {
        return b.cdI;
    }

    public List<SwanFavorItemData> acX() {
        return com.baidu.swan.apps.database.favorite.a.abX();
    }

    private void acY() {
        com.baidu.swan.apps.u.a.afA().a(new com.baidu.swan.apps.commonsync.a.a() { // from class: com.baidu.swan.apps.favordata.SwanFavorDataManager.1
            @Override // com.baidu.swan.apps.commonsync.a.a
            public void onSuccess() {
                SwanFavorDataManager.this.acZ();
            }
        });
    }

    public void acZ() {
        a(new com.baidu.swan.apps.commonsync.a.b() { // from class: com.baidu.swan.apps.favordata.SwanFavorDataManager.2
            @Override // com.baidu.swan.apps.commonsync.a.b
            public void a(CommonSyncServerData commonSyncServerData) {
                SwanFavorDataManager.this.b(commonSyncServerData);
            }
        });
    }

    public void a(com.baidu.swan.apps.commonsync.a.b bVar) {
        com.baidu.swan.apps.u.a.afA().a(bVar);
    }

    private void A(String str, String str2, String str3) {
        com.baidu.swan.apps.u.a.afA().l(com.baidu.swan.apps.favordata.a.z(str, str2, str3));
    }

    private void ada() {
        n.a(new Runnable() { // from class: com.baidu.swan.apps.favordata.SwanFavorDataManager.3
            @Override // java.lang.Runnable
            public void run() {
                List<SwanFavorItemData> acX = SwanFavorDataManager.this.acX();
                if (acX != null && acX.size() > 0) {
                    StringBuilder sb = new StringBuilder();
                    StringBuilder sb2 = new StringBuilder();
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < acX.size()) {
                            if (i2 == acX.size() - 1) {
                                sb.append(acX.get(i2).getAppKey());
                                sb2.append(i2 + 1);
                            } else {
                                sb.append(acX.get(i2).getAppKey());
                                sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                                sb2.append(i2 + 1);
                                sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                            }
                            i = i2 + 1;
                        } else {
                            com.baidu.swan.apps.u.a.afA().m(com.baidu.swan.apps.favordata.a.bf(sb.toString(), sb2.toString()));
                            return;
                        }
                    }
                }
            }
        }, 1200L, TimeUnit.MILLISECONDS);
    }

    public void b(String str, int i, com.baidu.swan.apps.favordata.a.a aVar) {
        SwanFavorItemData swanFavorItemData = new SwanFavorItemData();
        swanFavorItemData.setAppKey(str);
        b(swanFavorItemData, i, aVar);
    }

    public void b(SwanFavorItemData swanFavorItemData, int i, com.baidu.swan.apps.favordata.a.a aVar) {
        if (com.baidu.swan.apps.database.favorite.a.a(swanFavorItemData, i, aVar)) {
            K(swanFavorItemData.getAppKey(), true);
        }
        A(swanFavorItemData.getAppKey(), "add", String.valueOf(i));
        if (i > 1) {
            ada();
        }
    }

    public void c(String str, int i, com.baidu.swan.apps.favordata.a.a aVar) {
        com.baidu.swan.apps.database.favorite.a.a(str, i, aVar);
        ada();
    }

    public void b(String str, com.baidu.swan.apps.favordata.a.b bVar) {
        if (com.baidu.swan.apps.database.favorite.a.a(str, bVar)) {
            K(str, false);
        }
        A(str, "cancel", "-1");
    }

    public void K(String str, boolean z) {
        if (ProcessUtils.isMainProcess()) {
            com.baidu.swan.apps.process.messaging.a.b.a(L(str, z), com.baidu.swan.apps.favordata.b.b.class);
            return;
        }
        e aoG = e.aoG();
        if (aoG != null) {
            if (TextUtils.equals(aoG.getAppId(), "sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u")) {
                com.baidu.swan.apps.process.messaging.a.b.a(L(str, z), com.baidu.swan.apps.favordata.b.a.class, null);
            } else if (TextUtils.equals(aoG.getAppId(), str)) {
                dP(z);
            }
        }
    }

    private Bundle L(String str, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putString("appKey", str);
        bundle.putBoolean("isFavor", z);
        return bundle;
    }

    public static void dP(boolean z) {
        if (DEBUG) {
            Log.d("SwanFavorDataManager", "sendFavorStatusMsg: isAddfavor = " + z);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("status", z ? "1" : "0");
        f.ahV().a(new com.baidu.swan.apps.event.a.b("favorStatusChange", hashMap));
    }

    public void b(CommonSyncServerData commonSyncServerData) {
        if (commonSyncServerData != null) {
            List<CommonSyncServerData.MetaItemInfo> list = commonSyncServerData.metaItems;
            ArrayList arrayList = new ArrayList();
            if (list == null || list.size() <= 0) {
                if (!h.arO().getBoolean("upload_local_data_to_server", true)) {
                    com.baidu.swan.apps.database.favorite.a.W(arrayList);
                }
                acY();
                return;
            }
            for (CommonSyncServerData.MetaItemInfo metaItemInfo : list) {
                if (metaItemInfo != null && metaItemInfo.metaData != null && metaItemInfo.metaData.otherData != null) {
                    SwanFavorItemData swanFavorItemData = new SwanFavorItemData();
                    String str = metaItemInfo.metaData.otherData.appKey;
                    swanFavorItemData.setAppKey(str);
                    swanFavorItemData.setAppType(com.baidu.swan.apps.e.a.iu(str));
                    swanFavorItemData.setIconUrl(metaItemInfo.metaData.logoUrl);
                    swanFavorItemData.setAppName(metaItemInfo.metaData.title);
                    if (metaItemInfo.metaData.platConf != null && metaItemInfo.metaData.platConf.platH5 != null && !TextUtils.isEmpty(metaItemInfo.metaData.platConf.platH5.url)) {
                        swanFavorItemData.setAppFrameType(swanFavorItemData.getFrameTypeFromScheme(metaItemInfo.metaData.platConf.platH5.url));
                    } else {
                        swanFavorItemData.setAppFrameType(0);
                    }
                    arrayList.add(swanFavorItemData);
                }
            }
            com.baidu.swan.apps.database.favorite.a.W(arrayList);
        }
    }

    public boolean km(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return com.baidu.swan.apps.database.favorite.a.jW(str);
    }

    @Override // com.baidu.swan.apps.a.c
    public void db(boolean z) {
        acZ();
    }
}

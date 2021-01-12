package com.baidu.swan.apps.favordata;

import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.CursorLoader;
import androidx.loader.content.Loader;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.a.c;
import com.baidu.swan.apps.ao.p;
import com.baidu.swan.apps.commonsync.CommonSyncServerData;
import com.baidu.swan.apps.database.SwanAppDbControl;
import com.baidu.swan.apps.env.c.b;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.storage.c.h;
import com.baidu.swan.apps.v.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
/* loaded from: classes8.dex */
public class SwanFavorDataManager implements c {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    /* loaded from: classes8.dex */
    public interface a {
        void onLoadFail();

        void onLoadSuccess(List<SwanFavorItemData> list);
    }

    /* loaded from: classes8.dex */
    public class FavorDataDBLoaderCB implements LoaderManager.LoaderCallbacks<Cursor> {
        private a cZA;

        @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
        @NonNull
        public Loader<Cursor> onCreateLoader(int i, @Nullable Bundle bundle) {
            return new CursorLoader(com.baidu.swan.apps.t.a.awy(), com.baidu.swan.apps.database.favorite.a.asQ(), null, null, null, "sort_index");
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Removed duplicated region for block: B:23:0x004a  */
        /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
        @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onLoadFinished(@NonNull Loader<Cursor> loader, Cursor cursor) {
            if (loader.getId() != 101) {
                if (this.cZA != null) {
                    this.cZA.onLoadFail();
                    return;
                }
                return;
            }
            ArrayList arrayList = new ArrayList();
            if (cursor != null && cursor.getCount() > 0 && cursor.moveToFirst()) {
                do {
                    SwanFavorItemData d = com.baidu.swan.apps.database.favorite.a.d(cursor);
                    if (!TextUtils.isEmpty(d.getAppKey()) && !TextUtils.isEmpty(d.getAppName())) {
                        arrayList.add(d);
                    }
                } while (cursor.moveToNext());
                if (this.cZA == null) {
                }
            } else if (this.cZA == null) {
                this.cZA.onLoadSuccess(arrayList);
            }
        }

        @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
        public void onLoaderReset(@NonNull Loader<Cursor> loader) {
            if (this.cZA != null) {
                this.cZA.onLoadFail();
            }
        }
    }

    private SwanFavorDataManager() {
        SwanAppDbControl.cQ(com.baidu.swan.apps.t.a.awy());
        com.baidu.swan.apps.t.a.awD().a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public static class b {
        private static final SwanFavorDataManager cZB = new SwanFavorDataManager();
    }

    public static SwanFavorDataManager auq() {
        return b.cZB;
    }

    public List<SwanFavorItemData> aur() {
        return com.baidu.swan.apps.database.favorite.a.asI();
    }

    private void aus() {
        com.baidu.swan.apps.t.a.axj().a(new com.baidu.swan.apps.commonsync.a.a() { // from class: com.baidu.swan.apps.favordata.SwanFavorDataManager.1
            @Override // com.baidu.swan.apps.commonsync.a.a
            public void onSuccess() {
                SwanFavorDataManager.this.aut();
            }
        });
    }

    public void aut() {
        a(new com.baidu.swan.apps.commonsync.a.b() { // from class: com.baidu.swan.apps.favordata.SwanFavorDataManager.2
            @Override // com.baidu.swan.apps.commonsync.a.b
            public void a(CommonSyncServerData commonSyncServerData) {
                SwanFavorDataManager.this.b(commonSyncServerData);
            }
        });
    }

    public void a(com.baidu.swan.apps.commonsync.a.b bVar) {
        com.baidu.swan.apps.t.a.axj().a(bVar);
    }

    private void Q(String str, String str2, String str3) {
        com.baidu.swan.apps.t.a.axj().w(com.baidu.swan.apps.favordata.a.P(str, str2, str3));
    }

    private void auu() {
        p.a(new Runnable() { // from class: com.baidu.swan.apps.favordata.SwanFavorDataManager.3
            @Override // java.lang.Runnable
            public void run() {
                List<SwanFavorItemData> aur = SwanFavorDataManager.this.aur();
                if (aur != null && aur.size() > 0) {
                    StringBuilder sb = new StringBuilder();
                    StringBuilder sb2 = new StringBuilder();
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < aur.size()) {
                            if (i2 == aur.size() - 1) {
                                sb.append(aur.get(i2).getAppKey());
                                sb2.append(i2 + 1);
                            } else {
                                sb.append(aur.get(i2).getAppKey());
                                sb.append(",");
                                sb2.append(i2 + 1);
                                sb2.append(",");
                            }
                            i = i2 + 1;
                        } else {
                            com.baidu.swan.apps.t.a.axj().x(com.baidu.swan.apps.favordata.a.bK(sb.toString(), sb2.toString()));
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
            X(swanFavorItemData.getAppKey(), true);
        }
        Q(swanFavorItemData.getAppKey(), IMTrack.DbBuilder.ACTION_ADD, String.valueOf(i));
        if (i > 1) {
            auu();
        }
    }

    public void c(String str, int i, com.baidu.swan.apps.favordata.a.a aVar) {
        com.baidu.swan.apps.database.favorite.a.a(str, i, aVar);
        auu();
    }

    public void b(String str, com.baidu.swan.apps.favordata.a.b bVar, b.C0424b c0424b) {
        if (com.baidu.swan.apps.database.favorite.a.a(str, bVar, c0424b)) {
            X(str, false);
        }
        Q(str, "cancel", "-1");
    }

    public void X(String str, boolean z) {
        if (ProcessUtils.isMainProcess()) {
            com.baidu.swan.apps.process.messaging.a.b.a(Y(str, z), com.baidu.swan.apps.favordata.b.b.class);
            return;
        }
        e aIs = e.aIs();
        if (aIs != null) {
            if (TextUtils.equals(aIs.getAppId(), "sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u")) {
                com.baidu.swan.apps.process.messaging.a.b.a(Y(str, z), com.baidu.swan.apps.favordata.b.a.class, null);
            } else if (TextUtils.equals(aIs.getAppId(), str)) {
                fC(z);
            }
        }
    }

    private Bundle Y(String str, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putString("appKey", str);
        bundle.putBoolean("isFavor", z);
        return bundle;
    }

    public static void fC(boolean z) {
        if (DEBUG) {
            Log.d("SwanFavorDataManager", "sendFavorStatusMsg: isAddfavor = " + z);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("status", z ? "1" : "0");
        f.azN().b(new com.baidu.swan.apps.event.a.b("favorStatusChange", hashMap));
    }

    public void b(CommonSyncServerData commonSyncServerData) {
        if (commonSyncServerData != null) {
            List<CommonSyncServerData.MetaItemInfo> list = commonSyncServerData.metaItems;
            ArrayList arrayList = new ArrayList();
            if (list == null || list.size() <= 0) {
                if (!h.aLO().getBoolean("upload_local_data_to_server", true)) {
                    com.baidu.swan.apps.database.favorite.a.aG(arrayList);
                }
                aus();
                return;
            }
            for (CommonSyncServerData.MetaItemInfo metaItemInfo : list) {
                if (metaItemInfo != null && metaItemInfo.metaData != null && metaItemInfo.metaData.otherData != null) {
                    SwanFavorItemData swanFavorItemData = new SwanFavorItemData();
                    String str = metaItemInfo.metaData.otherData.appKey;
                    swanFavorItemData.setAppKey(str);
                    swanFavorItemData.setAppType(com.baidu.swan.apps.f.a.lj(str));
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
            com.baidu.swan.apps.database.favorite.a.aG(arrayList);
        }
    }

    @Override // com.baidu.swan.apps.a.c
    public void eE(boolean z) {
        aut();
    }
}

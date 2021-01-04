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
/* loaded from: classes9.dex */
public class SwanFavorDataManager implements c {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    /* loaded from: classes9.dex */
    public interface a {
        void onLoadFail();

        void onLoadSuccess(List<SwanFavorItemData> list);
    }

    /* loaded from: classes9.dex */
    public class FavorDataDBLoaderCB implements LoaderManager.LoaderCallbacks<Cursor> {
        private a deq;

        @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
        @NonNull
        public Loader<Cursor> onCreateLoader(int i, @Nullable Bundle bundle) {
            return new CursorLoader(com.baidu.swan.apps.t.a.aAr(), com.baidu.swan.apps.database.favorite.a.awJ(), null, null, null, "sort_index");
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
                if (this.deq != null) {
                    this.deq.onLoadFail();
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
                if (this.deq == null) {
                }
            } else if (this.deq == null) {
                this.deq.onLoadSuccess(arrayList);
            }
        }

        @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
        public void onLoaderReset(@NonNull Loader<Cursor> loader) {
            if (this.deq != null) {
                this.deq.onLoadFail();
            }
        }
    }

    private SwanFavorDataManager() {
        SwanAppDbControl.cR(com.baidu.swan.apps.t.a.aAr());
        com.baidu.swan.apps.t.a.aAw().a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class b {
        private static final SwanFavorDataManager der = new SwanFavorDataManager();
    }

    public static SwanFavorDataManager ayj() {
        return b.der;
    }

    public List<SwanFavorItemData> ayk() {
        return com.baidu.swan.apps.database.favorite.a.awB();
    }

    private void ayl() {
        com.baidu.swan.apps.t.a.aBc().a(new com.baidu.swan.apps.commonsync.a.a() { // from class: com.baidu.swan.apps.favordata.SwanFavorDataManager.1
            @Override // com.baidu.swan.apps.commonsync.a.a
            public void onSuccess() {
                SwanFavorDataManager.this.aym();
            }
        });
    }

    public void aym() {
        a(new com.baidu.swan.apps.commonsync.a.b() { // from class: com.baidu.swan.apps.favordata.SwanFavorDataManager.2
            @Override // com.baidu.swan.apps.commonsync.a.b
            public void a(CommonSyncServerData commonSyncServerData) {
                SwanFavorDataManager.this.b(commonSyncServerData);
            }
        });
    }

    public void a(com.baidu.swan.apps.commonsync.a.b bVar) {
        com.baidu.swan.apps.t.a.aBc().a(bVar);
    }

    private void R(String str, String str2, String str3) {
        com.baidu.swan.apps.t.a.aBc().w(com.baidu.swan.apps.favordata.a.Q(str, str2, str3));
    }

    private void ayn() {
        p.a(new Runnable() { // from class: com.baidu.swan.apps.favordata.SwanFavorDataManager.3
            @Override // java.lang.Runnable
            public void run() {
                List<SwanFavorItemData> ayk = SwanFavorDataManager.this.ayk();
                if (ayk != null && ayk.size() > 0) {
                    StringBuilder sb = new StringBuilder();
                    StringBuilder sb2 = new StringBuilder();
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < ayk.size()) {
                            if (i2 == ayk.size() - 1) {
                                sb.append(ayk.get(i2).getAppKey());
                                sb2.append(i2 + 1);
                            } else {
                                sb.append(ayk.get(i2).getAppKey());
                                sb.append(",");
                                sb2.append(i2 + 1);
                                sb2.append(",");
                            }
                            i = i2 + 1;
                        } else {
                            com.baidu.swan.apps.t.a.aBc().x(com.baidu.swan.apps.favordata.a.bL(sb.toString(), sb2.toString()));
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
        R(swanFavorItemData.getAppKey(), IMTrack.DbBuilder.ACTION_ADD, String.valueOf(i));
        if (i > 1) {
            ayn();
        }
    }

    public void c(String str, int i, com.baidu.swan.apps.favordata.a.a aVar) {
        com.baidu.swan.apps.database.favorite.a.a(str, i, aVar);
        ayn();
    }

    public void b(String str, com.baidu.swan.apps.favordata.a.b bVar, b.C0441b c0441b) {
        if (com.baidu.swan.apps.database.favorite.a.a(str, bVar, c0441b)) {
            X(str, false);
        }
        R(str, "cancel", "-1");
    }

    public void X(String str, boolean z) {
        if (ProcessUtils.isMainProcess()) {
            com.baidu.swan.apps.process.messaging.a.b.a(Y(str, z), com.baidu.swan.apps.favordata.b.b.class);
            return;
        }
        e aMl = e.aMl();
        if (aMl != null) {
            if (TextUtils.equals(aMl.getAppId(), "sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u")) {
                com.baidu.swan.apps.process.messaging.a.b.a(Y(str, z), com.baidu.swan.apps.favordata.b.a.class, null);
            } else if (TextUtils.equals(aMl.getAppId(), str)) {
                fG(z);
            }
        }
    }

    private Bundle Y(String str, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putString("appKey", str);
        bundle.putBoolean("isFavor", z);
        return bundle;
    }

    public static void fG(boolean z) {
        if (DEBUG) {
            Log.d("SwanFavorDataManager", "sendFavorStatusMsg: isAddfavor = " + z);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("status", z ? "1" : "0");
        f.aDG().b(new com.baidu.swan.apps.event.a.b("favorStatusChange", hashMap));
    }

    public void b(CommonSyncServerData commonSyncServerData) {
        if (commonSyncServerData != null) {
            List<CommonSyncServerData.MetaItemInfo> list = commonSyncServerData.metaItems;
            ArrayList arrayList = new ArrayList();
            if (list == null || list.size() <= 0) {
                if (!h.aPH().getBoolean("upload_local_data_to_server", true)) {
                    com.baidu.swan.apps.database.favorite.a.aG(arrayList);
                }
                ayl();
                return;
            }
            for (CommonSyncServerData.MetaItemInfo metaItemInfo : list) {
                if (metaItemInfo != null && metaItemInfo.metaData != null && metaItemInfo.metaData.otherData != null) {
                    SwanFavorItemData swanFavorItemData = new SwanFavorItemData();
                    String str = metaItemInfo.metaData.otherData.appKey;
                    swanFavorItemData.setAppKey(str);
                    swanFavorItemData.setAppType(com.baidu.swan.apps.f.a.mu(str));
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
    public void eI(boolean z) {
        aym();
    }
}

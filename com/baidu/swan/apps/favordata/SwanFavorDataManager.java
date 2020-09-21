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
import com.baidu.swan.apps.ap.p;
import com.baidu.swan.apps.commonsync.CommonSyncServerData;
import com.baidu.swan.apps.database.SwanAppDbControl;
import com.baidu.swan.apps.env.c.b;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.storage.c.h;
import com.baidu.swan.apps.v.f;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public class SwanFavorDataManager implements c {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    /* loaded from: classes3.dex */
    public interface a {
        void al(List<SwanFavorItemData> list);

        void anp();
    }

    /* loaded from: classes3.dex */
    public class FavorDataDBLoaderCB implements LoaderManager.LoaderCallbacks<Cursor> {
        private a ctN;

        @Override // android.support.v4.app.LoaderManager.LoaderCallbacks
        @NonNull
        public Loader<Cursor> onCreateLoader(int i, @Nullable Bundle bundle) {
            return new CursorLoader(com.baidu.swan.apps.t.a.apu(), com.baidu.swan.apps.database.favorite.a.alK(), null, null, null, "sort_index");
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
                if (this.ctN != null) {
                    this.ctN.anp();
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
                if (this.ctN == null) {
                }
            } else if (this.ctN == null) {
                this.ctN.al(arrayList);
            }
        }

        @Override // android.support.v4.app.LoaderManager.LoaderCallbacks
        public void onLoaderReset(@NonNull Loader<Cursor> loader) {
            if (this.ctN != null) {
                this.ctN.anp();
            }
        }
    }

    private SwanFavorDataManager() {
        SwanAppDbControl.bX(com.baidu.swan.apps.t.a.apu());
        com.baidu.swan.apps.t.a.apz().a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class b {
        private static final SwanFavorDataManager ctO = new SwanFavorDataManager();
    }

    public static SwanFavorDataManager ank() {
        return b.ctO;
    }

    public List<SwanFavorItemData> anl() {
        return com.baidu.swan.apps.database.favorite.a.alC();
    }

    private void anm() {
        com.baidu.swan.apps.t.a.aqf().a(new com.baidu.swan.apps.commonsync.a.a() { // from class: com.baidu.swan.apps.favordata.SwanFavorDataManager.1
            @Override // com.baidu.swan.apps.commonsync.a.a
            public void onSuccess() {
                SwanFavorDataManager.this.ann();
            }
        });
    }

    public void ann() {
        a(new com.baidu.swan.apps.commonsync.a.b() { // from class: com.baidu.swan.apps.favordata.SwanFavorDataManager.2
            @Override // com.baidu.swan.apps.commonsync.a.b
            public void a(CommonSyncServerData commonSyncServerData) {
                SwanFavorDataManager.this.b(commonSyncServerData);
            }
        });
    }

    public void a(com.baidu.swan.apps.commonsync.a.b bVar) {
        com.baidu.swan.apps.t.a.aqf().a(bVar);
    }

    private void D(String str, String str2, String str3) {
        com.baidu.swan.apps.t.a.aqf().l(com.baidu.swan.apps.favordata.a.C(str, str2, str3));
    }

    private void ano() {
        p.a(new Runnable() { // from class: com.baidu.swan.apps.favordata.SwanFavorDataManager.3
            @Override // java.lang.Runnable
            public void run() {
                List<SwanFavorItemData> anl = SwanFavorDataManager.this.anl();
                if (anl != null && anl.size() > 0) {
                    StringBuilder sb = new StringBuilder();
                    StringBuilder sb2 = new StringBuilder();
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < anl.size()) {
                            if (i2 == anl.size() - 1) {
                                sb.append(anl.get(i2).getAppKey());
                                sb2.append(i2 + 1);
                            } else {
                                sb.append(anl.get(i2).getAppKey());
                                sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                                sb2.append(i2 + 1);
                                sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                            }
                            i = i2 + 1;
                        } else {
                            com.baidu.swan.apps.t.a.aqf().m(com.baidu.swan.apps.favordata.a.bu(sb.toString(), sb2.toString()));
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
            Q(swanFavorItemData.getAppKey(), true);
        }
        D(swanFavorItemData.getAppKey(), "add", String.valueOf(i));
        if (i > 1) {
            ano();
        }
    }

    public void c(String str, int i, com.baidu.swan.apps.favordata.a.a aVar) {
        com.baidu.swan.apps.database.favorite.a.a(str, i, aVar);
        ano();
    }

    public void b(String str, com.baidu.swan.apps.favordata.a.b bVar, b.C0396b c0396b) {
        if (com.baidu.swan.apps.database.favorite.a.a(str, bVar, c0396b)) {
            Q(str, false);
        }
        D(str, "cancel", "-1");
    }

    public void Q(String str, boolean z) {
        if (ProcessUtils.isMainProcess()) {
            com.baidu.swan.apps.process.messaging.a.b.a(R(str, z), com.baidu.swan.apps.favordata.b.b.class);
            return;
        }
        e aAs = e.aAs();
        if (aAs != null) {
            if (TextUtils.equals(aAs.getAppId(), "sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u")) {
                com.baidu.swan.apps.process.messaging.a.b.a(R(str, z), com.baidu.swan.apps.favordata.b.a.class, null);
            } else if (TextUtils.equals(aAs.getAppId(), str)) {
                en(z);
            }
        }
    }

    private Bundle R(String str, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putString("appKey", str);
        bundle.putBoolean("isFavor", z);
        return bundle;
    }

    public static void en(boolean z) {
        if (DEBUG) {
            Log.d("SwanFavorDataManager", "sendFavorStatusMsg: isAddfavor = " + z);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("status", z ? "1" : "0");
        f.asJ().b(new com.baidu.swan.apps.event.a.b("favorStatusChange", hashMap));
    }

    public void b(CommonSyncServerData commonSyncServerData) {
        if (commonSyncServerData != null) {
            List<CommonSyncServerData.MetaItemInfo> list = commonSyncServerData.metaItems;
            ArrayList arrayList = new ArrayList();
            if (list == null || list.size() <= 0) {
                if (!h.aDP().getBoolean("upload_local_data_to_server", true)) {
                    com.baidu.swan.apps.database.favorite.a.af(arrayList);
                }
                anm();
                return;
            }
            for (CommonSyncServerData.MetaItemInfo metaItemInfo : list) {
                if (metaItemInfo != null && metaItemInfo.metaData != null && metaItemInfo.metaData.otherData != null) {
                    SwanFavorItemData swanFavorItemData = new SwanFavorItemData();
                    String str = metaItemInfo.metaData.otherData.appKey;
                    swanFavorItemData.setAppKey(str);
                    swanFavorItemData.setAppType(com.baidu.swan.apps.f.a.kG(str));
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
            com.baidu.swan.apps.database.favorite.a.af(arrayList);
        }
    }

    @Override // com.baidu.swan.apps.a.c
    public void dq(boolean z) {
        ann();
    }
}

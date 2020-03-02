package com.baidu.swan.apps.favordata;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.text.TextUtils;
import com.baidu.searchbox.ugc.utils.UgcUBCUtils;
import com.baidu.swan.apps.a.c;
import com.baidu.swan.apps.as.m;
import com.baidu.swan.apps.commonsync.CommonSyncServerData;
import com.baidu.swan.apps.database.SwanAppDbControl;
import com.baidu.swan.apps.storage.c.h;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
/* loaded from: classes11.dex */
public class SwanFavorDataManager implements c {

    /* loaded from: classes11.dex */
    public interface a {
        void Sk();

        void T(List<SwanFavorItemData> list);
    }

    /* loaded from: classes11.dex */
    public class FavorDataDBLoaderCB implements LoaderManager.LoaderCallbacks<Cursor> {
        private a bvn;

        @Override // android.support.v4.app.LoaderManager.LoaderCallbacks
        @NonNull
        public Loader<Cursor> onCreateLoader(int i, @Nullable Bundle bundle) {
            return new CursorLoader(com.baidu.swan.apps.w.a.TW(), com.baidu.swan.apps.database.favorite.a.Ro(), null, null, null, "sort_index");
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
                if (this.bvn != null) {
                    this.bvn.Sk();
                    return;
                }
                return;
            }
            ArrayList arrayList = new ArrayList();
            if (cursor != null && cursor.getCount() > 0 && cursor.moveToFirst()) {
                do {
                    SwanFavorItemData b = com.baidu.swan.apps.database.favorite.a.b(cursor);
                    if (!TextUtils.isEmpty(b.getAppKey()) && !TextUtils.isEmpty(b.getAppName())) {
                        arrayList.add(b);
                    }
                } while (cursor.moveToNext());
                if (this.bvn == null) {
                }
            } else if (this.bvn == null) {
                this.bvn.T(arrayList);
            }
        }

        @Override // android.support.v4.app.LoaderManager.LoaderCallbacks
        public void onLoaderReset(@NonNull Loader<Cursor> loader) {
            if (this.bvn != null) {
                this.bvn.Sk();
            }
        }
    }

    private SwanFavorDataManager() {
        SwanAppDbControl.cb(com.baidu.swan.apps.w.a.TW());
        com.baidu.swan.apps.w.a.Ub().a(this);
    }

    /* loaded from: classes11.dex */
    private static class b {
        private static final SwanFavorDataManager bvo = new SwanFavorDataManager();
    }

    public static SwanFavorDataManager Sf() {
        return b.bvo;
    }

    public List<SwanFavorItemData> Sg() {
        return com.baidu.swan.apps.database.favorite.a.Rf();
    }

    private void Sh() {
        com.baidu.swan.apps.w.a.UG().a(new com.baidu.swan.apps.commonsync.a.a() { // from class: com.baidu.swan.apps.favordata.SwanFavorDataManager.1
            @Override // com.baidu.swan.apps.commonsync.a.a
            public void onSuccess() {
                SwanFavorDataManager.this.Si();
            }
        });
    }

    public void Si() {
        a(new com.baidu.swan.apps.commonsync.a.b() { // from class: com.baidu.swan.apps.favordata.SwanFavorDataManager.2
            @Override // com.baidu.swan.apps.commonsync.a.b
            public void a(CommonSyncServerData commonSyncServerData) {
                SwanFavorDataManager.this.b(commonSyncServerData);
            }
        });
    }

    public void a(com.baidu.swan.apps.commonsync.a.b bVar) {
        com.baidu.swan.apps.w.a.UG().a(bVar);
    }

    private void x(String str, String str2, String str3) {
        com.baidu.swan.apps.w.a.UG().l(com.baidu.swan.apps.favordata.a.u(str, str2, str3));
    }

    private void Sj() {
        m.a(new Runnable() { // from class: com.baidu.swan.apps.favordata.SwanFavorDataManager.3
            @Override // java.lang.Runnable
            public void run() {
                List<SwanFavorItemData> Sg = SwanFavorDataManager.this.Sg();
                if (Sg != null && Sg.size() > 0) {
                    StringBuilder sb = new StringBuilder();
                    StringBuilder sb2 = new StringBuilder();
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < Sg.size()) {
                            if (i2 == Sg.size() - 1) {
                                sb.append(Sg.get(i2).getAppKey());
                                sb2.append(i2 + 1);
                            } else {
                                sb.append(Sg.get(i2).getAppKey());
                                sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                                sb2.append(i2 + 1);
                                sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                            }
                            i = i2 + 1;
                        } else {
                            com.baidu.swan.apps.w.a.UG().m(com.baidu.swan.apps.favordata.a.aF(sb.toString(), sb2.toString()));
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
        com.baidu.swan.apps.database.favorite.a.a(swanFavorItemData, i, aVar);
        x(swanFavorItemData.getAppKey(), "add", String.valueOf(i));
        if (i > 1) {
            Sj();
        }
    }

    public void c(String str, int i, com.baidu.swan.apps.favordata.a.a aVar) {
        com.baidu.swan.apps.database.favorite.a.a(str, i, aVar);
        Sj();
    }

    public void a(String str, com.baidu.swan.apps.favordata.a.b bVar) {
        com.baidu.swan.apps.database.favorite.a.a(str, bVar);
        x(str, UgcUBCUtils.UGC_TIME_CANCEL, "-1");
    }

    public void b(CommonSyncServerData commonSyncServerData) {
        if (commonSyncServerData != null) {
            List<CommonSyncServerData.MetaItemInfo> list = commonSyncServerData.metaItems;
            ArrayList arrayList = new ArrayList();
            if (list == null || list.size() <= 0) {
                if (!h.afr().getBoolean("upload_local_data_to_server", true)) {
                    com.baidu.swan.apps.database.favorite.a.N(arrayList);
                }
                Sh();
                return;
            }
            for (CommonSyncServerData.MetaItemInfo metaItemInfo : list) {
                if (metaItemInfo != null && metaItemInfo.metaData != null && metaItemInfo.metaData.otherData != null) {
                    SwanFavorItemData swanFavorItemData = new SwanFavorItemData();
                    swanFavorItemData.setAppKey(metaItemInfo.metaData.otherData.appKey);
                    swanFavorItemData.setAppType(0);
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
            com.baidu.swan.apps.database.favorite.a.N(arrayList);
        }
    }

    @Override // com.baidu.swan.apps.a.c
    public void bS(boolean z) {
        Si();
    }
}

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
/* loaded from: classes9.dex */
public class SwanFavorDataManager implements c {

    /* loaded from: classes9.dex */
    public interface a {
        void Py();

        void U(List<SwanFavorItemData> list);
    }

    /* loaded from: classes9.dex */
    public class FavorDataDBLoaderCB implements LoaderManager.LoaderCallbacks<Cursor> {
        private a bqo;

        @Override // android.support.v4.app.LoaderManager.LoaderCallbacks
        @NonNull
        public Loader<Cursor> onCreateLoader(int i, @Nullable Bundle bundle) {
            return new CursorLoader(com.baidu.swan.apps.w.a.Rk(), com.baidu.swan.apps.database.favorite.a.OC(), null, null, null, "sort_index");
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
                if (this.bqo != null) {
                    this.bqo.Py();
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
                if (this.bqo == null) {
                }
            } else if (this.bqo == null) {
                this.bqo.U(arrayList);
            }
        }

        @Override // android.support.v4.app.LoaderManager.LoaderCallbacks
        public void onLoaderReset(@NonNull Loader<Cursor> loader) {
            if (this.bqo != null) {
                this.bqo.Py();
            }
        }
    }

    private SwanFavorDataManager() {
        SwanAppDbControl.bX(com.baidu.swan.apps.w.a.Rk());
        com.baidu.swan.apps.w.a.Rp().a(this);
    }

    /* loaded from: classes9.dex */
    private static class b {
        private static final SwanFavorDataManager bqp = new SwanFavorDataManager();
    }

    public static SwanFavorDataManager Pt() {
        return b.bqp;
    }

    public List<SwanFavorItemData> Pu() {
        return com.baidu.swan.apps.database.favorite.a.Ot();
    }

    private void Pv() {
        com.baidu.swan.apps.w.a.RU().a(new com.baidu.swan.apps.commonsync.a.a() { // from class: com.baidu.swan.apps.favordata.SwanFavorDataManager.1
            @Override // com.baidu.swan.apps.commonsync.a.a
            public void onSuccess() {
                SwanFavorDataManager.this.Pw();
            }
        });
    }

    public void Pw() {
        a(new com.baidu.swan.apps.commonsync.a.b() { // from class: com.baidu.swan.apps.favordata.SwanFavorDataManager.2
            @Override // com.baidu.swan.apps.commonsync.a.b
            public void a(CommonSyncServerData commonSyncServerData) {
                SwanFavorDataManager.this.b(commonSyncServerData);
            }
        });
    }

    public void a(com.baidu.swan.apps.commonsync.a.b bVar) {
        com.baidu.swan.apps.w.a.RU().a(bVar);
    }

    private void u(String str, String str2, String str3) {
        com.baidu.swan.apps.w.a.RU().l(com.baidu.swan.apps.favordata.a.t(str, str2, str3));
    }

    private void Px() {
        m.a(new Runnable() { // from class: com.baidu.swan.apps.favordata.SwanFavorDataManager.3
            @Override // java.lang.Runnable
            public void run() {
                List<SwanFavorItemData> Pu = SwanFavorDataManager.this.Pu();
                if (Pu != null && Pu.size() > 0) {
                    StringBuilder sb = new StringBuilder();
                    StringBuilder sb2 = new StringBuilder();
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < Pu.size()) {
                            if (i2 == Pu.size() - 1) {
                                sb.append(Pu.get(i2).getAppKey());
                                sb2.append(i2 + 1);
                            } else {
                                sb.append(Pu.get(i2).getAppKey());
                                sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                                sb2.append(i2 + 1);
                                sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                            }
                            i = i2 + 1;
                        } else {
                            com.baidu.swan.apps.w.a.RU().m(com.baidu.swan.apps.favordata.a.au(sb.toString(), sb2.toString()));
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
        u(swanFavorItemData.getAppKey(), "add", String.valueOf(i));
        if (i > 1) {
            Px();
        }
    }

    public void c(String str, int i, com.baidu.swan.apps.favordata.a.a aVar) {
        com.baidu.swan.apps.database.favorite.a.a(str, i, aVar);
        Px();
    }

    public void a(String str, com.baidu.swan.apps.favordata.a.b bVar) {
        com.baidu.swan.apps.database.favorite.a.a(str, bVar);
        u(str, UgcUBCUtils.UGC_TIME_CANCEL, "-1");
    }

    public void b(CommonSyncServerData commonSyncServerData) {
        if (commonSyncServerData != null) {
            List<CommonSyncServerData.MetaItemInfo> list = commonSyncServerData.metaItems;
            ArrayList arrayList = new ArrayList();
            if (list == null || list.size() <= 0) {
                if (!h.acE().getBoolean("upload_local_data_to_server", true)) {
                    com.baidu.swan.apps.database.favorite.a.O(arrayList);
                }
                Pv();
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
            com.baidu.swan.apps.database.favorite.a.O(arrayList);
        }
    }

    @Override // com.baidu.swan.apps.a.c
    public void bF(boolean z) {
        Pw();
    }
}

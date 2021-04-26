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
import com.baidu.livesdk.sdk.service.IMLikeRequest;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.commonsync.CommonSyncServerData;
import com.baidu.swan.apps.database.SwanAppDbControl;
import com.baidu.wallet.paysdk.banksign.datamodel.QueryResponse;
import d.a.h0.a.a2.g.h;
import d.a.h0.a.i2.p;
import d.a.h0.a.j0.j.b;
import d.a.h0.a.k;
import d.a.h0.a.z0.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public class SwanFavorDataManager implements d.a.h0.a.m.c {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f11728e = k.f43101a;

    /* loaded from: classes2.dex */
    public class FavorDataDBLoaderCB implements LoaderManager.LoaderCallbacks<Cursor> {

        /* renamed from: a  reason: collision with root package name */
        public d f11729a;

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0048  */
        /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
        @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onLoadFinished(@NonNull Loader<Cursor> loader, Cursor cursor) {
            d dVar;
            if (loader.getId() != 101) {
                d dVar2 = this.f11729a;
                if (dVar2 != null) {
                    dVar2.onLoadFail();
                    return;
                }
                return;
            }
            ArrayList arrayList = new ArrayList();
            if (cursor != null && cursor.getCount() > 0 && cursor.moveToFirst()) {
                do {
                    SwanFavorItemData l = d.a.h0.a.g0.c.a.l(cursor);
                    if (!TextUtils.isEmpty(l.getAppKey()) && !TextUtils.isEmpty(l.getAppName())) {
                        arrayList.add(l);
                    }
                } while (cursor.moveToNext());
                dVar = this.f11729a;
                if (dVar == null) {
                }
            } else {
                dVar = this.f11729a;
                if (dVar == null) {
                    dVar.onLoadSuccess(arrayList);
                }
            }
        }

        @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
        @NonNull
        public Loader<Cursor> onCreateLoader(int i2, @Nullable Bundle bundle) {
            return new CursorLoader(d.a.h0.a.w0.a.c(), d.a.h0.a.g0.c.a.e(), null, null, null, "sort_index");
        }

        @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
        public void onLoaderReset(@NonNull Loader<Cursor> loader) {
            d dVar = this.f11729a;
            if (dVar != null) {
                dVar.onLoadFail();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class a implements d.a.h0.a.z.a.a {
        public a() {
        }

        @Override // d.a.h0.a.z.a.a
        public void onSuccess() {
            SwanFavorDataManager.this.e();
        }
    }

    /* loaded from: classes2.dex */
    public class b implements d.a.h0.a.z.a.b {
        public b() {
        }

        @Override // d.a.h0.a.z.a.b
        public void a(CommonSyncServerData commonSyncServerData) {
            SwanFavorDataManager.this.g(commonSyncServerData);
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            List<SwanFavorItemData> j = SwanFavorDataManager.this.j();
            if (j == null || j.size() <= 0) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            for (int i2 = 0; i2 < j.size(); i2++) {
                if (i2 == j.size() - 1) {
                    sb.append(j.get(i2).getAppKey());
                    sb2.append(i2 + 1);
                } else {
                    sb.append(j.get(i2).getAppKey());
                    sb.append(",");
                    sb2.append(i2 + 1);
                    sb2.append(",");
                }
            }
            d.a.h0.a.w0.a.S().d(d.a.h0.a.m0.a.b(sb.toString(), sb2.toString()));
        }
    }

    /* loaded from: classes2.dex */
    public interface d {
        void onLoadFail();

        void onLoadSuccess(List<SwanFavorItemData> list);
    }

    /* loaded from: classes2.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public static final SwanFavorDataManager f11733a = new SwanFavorDataManager(null);
    }

    public /* synthetic */ SwanFavorDataManager(a aVar) {
        this();
    }

    public static SwanFavorDataManager i() {
        return e.f11733a;
    }

    public static void m(boolean z) {
        if (f11728e) {
            Log.d("SwanFavorDataManager", "sendFavorStatusMsg: isAddfavor = " + z);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("status", z ? "1" : "0");
        f.V().x(new d.a.h0.a.k0.b.b("favorStatusChange", hashMap));
    }

    @Override // d.a.h0.a.m.c
    public void a(boolean z) {
        e();
    }

    public void b(String str, int i2, d.a.h0.a.m0.b.a aVar) {
        SwanFavorItemData swanFavorItemData = new SwanFavorItemData();
        swanFavorItemData.setAppKey(str);
        c(swanFavorItemData, i2, aVar);
    }

    public void c(SwanFavorItemData swanFavorItemData, int i2, d.a.h0.a.m0.b.a aVar) {
        if (d.a.h0.a.g0.c.a.b(swanFavorItemData, i2, aVar)) {
            n(swanFavorItemData.getAppKey(), true);
        }
        l(swanFavorItemData.getAppKey(), IMTrack.DbBuilder.ACTION_ADD, String.valueOf(i2));
        if (i2 > 1) {
            o();
        }
    }

    public void d(String str, d.a.h0.a.m0.b.b bVar, b.C0679b c0679b) {
        if (d.a.h0.a.g0.c.a.g(str, bVar, c0679b)) {
            n(str, false);
        }
        l(str, QueryResponse.Options.CANCEL, "-1");
    }

    public void e() {
        f(new b());
    }

    public void f(d.a.h0.a.z.a.b bVar) {
        d.a.h0.a.w0.a.S().c(bVar);
    }

    public void g(CommonSyncServerData commonSyncServerData) {
        CommonSyncServerData.MetaData metaData;
        CommonSyncServerData.PlatH5 platH5;
        if (commonSyncServerData == null) {
            return;
        }
        List<CommonSyncServerData.MetaItemInfo> list = commonSyncServerData.metaItems;
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            for (CommonSyncServerData.MetaItemInfo metaItemInfo : list) {
                if (metaItemInfo != null && (metaData = metaItemInfo.metaData) != null && metaData.otherData != null) {
                    SwanFavorItemData swanFavorItemData = new SwanFavorItemData();
                    String str = metaItemInfo.metaData.otherData.appKey;
                    swanFavorItemData.setAppKey(str);
                    swanFavorItemData.setAppType(d.a.h0.a.u.a.b(str));
                    swanFavorItemData.setIconUrl(metaItemInfo.metaData.logoUrl);
                    swanFavorItemData.setAppName(metaItemInfo.metaData.title);
                    CommonSyncServerData.PlatConf platConf = metaItemInfo.metaData.platConf;
                    if (platConf != null && (platH5 = platConf.platH5) != null && !TextUtils.isEmpty(platH5.url)) {
                        swanFavorItemData.setAppFrameType(swanFavorItemData.getFrameTypeFromScheme(metaItemInfo.metaData.platConf.platH5.url));
                    } else {
                        swanFavorItemData.setAppFrameType(0);
                    }
                    arrayList.add(swanFavorItemData);
                }
            }
            d.a.h0.a.g0.c.a.q(arrayList);
            return;
        }
        if (!h.a().getBoolean("upload_local_data_to_server", true)) {
            d.a.h0.a.g0.c.a.q(arrayList);
        }
        p();
    }

    public final Bundle h(String str, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putString("appKey", str);
        bundle.putBoolean("isFavor", z);
        return bundle;
    }

    public List<SwanFavorItemData> j() {
        return d.a.h0.a.g0.c.a.j();
    }

    public void k(String str, int i2, d.a.h0.a.m0.b.a aVar) {
        d.a.h0.a.g0.c.a.o(str, i2, aVar);
        o();
    }

    public final void l(String str, String str2, String str3) {
        d.a.h0.a.w0.a.S().b(d.a.h0.a.m0.a.a(str, str2, str3));
    }

    public void n(String str, boolean z) {
        if (ProcessUtils.isMainProcess()) {
            d.a.h0.a.n1.c.d.b.a(h(str, z), d.a.h0.a.m0.c.b.class);
            return;
        }
        d.a.h0.a.r1.e O = d.a.h0.a.r1.e.O();
        if (O == null) {
            return;
        }
        if (TextUtils.equals(O.getAppId(), "sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u")) {
            d.a.h0.a.n1.c.d.b.c(h(str, z), d.a.h0.a.m0.c.a.class, null);
        } else if (TextUtils.equals(O.getAppId(), str)) {
            m(z);
        }
    }

    public final void o() {
        p.e(new c(), IMLikeRequest.TIME_INTERVAL, TimeUnit.MILLISECONDS);
    }

    public final void p() {
        d.a.h0.a.w0.a.S().a(new a());
    }

    public SwanFavorDataManager() {
        SwanAppDbControl.f(d.a.h0.a.w0.a.c());
        d.a.h0.a.w0.a.O().b(this);
    }
}

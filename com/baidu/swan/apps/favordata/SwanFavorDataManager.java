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
import com.baidu.swan.apps.commonsync.CommonSyncServerData;
import com.baidu.swan.apps.database.SwanAppDbControl;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.wallet.paysdk.banksign.datamodel.QueryResponse;
import d.a.l0.a.a2.e;
import d.a.l0.a.g1.f;
import d.a.l0.a.k;
import d.a.l0.a.n0.l.b;
import d.a.l0.a.v2.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes3.dex */
public class SwanFavorDataManager implements d.a.l0.a.m.c {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f10853e = k.f46875a;

    /* loaded from: classes3.dex */
    public class FavorDataDBLoaderCB implements LoaderManager.LoaderCallbacks<Cursor> {

        /* renamed from: a  reason: collision with root package name */
        public c f10854a;

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0048  */
        /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
        @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onLoadFinished(@NonNull Loader<Cursor> loader, Cursor cursor) {
            c cVar;
            if (loader.getId() != 101) {
                c cVar2 = this.f10854a;
                if (cVar2 != null) {
                    cVar2.onLoadFail();
                    return;
                }
                return;
            }
            ArrayList arrayList = new ArrayList();
            if (cursor != null && cursor.getCount() > 0 && cursor.moveToFirst()) {
                do {
                    SwanFavorItemData l = d.a.l0.a.j0.b.a.l(cursor);
                    if (!TextUtils.isEmpty(l.getAppKey()) && !TextUtils.isEmpty(l.getAppName())) {
                        arrayList.add(l);
                    }
                } while (cursor.moveToNext());
                cVar = this.f10854a;
                if (cVar == null) {
                }
            } else {
                cVar = this.f10854a;
                if (cVar == null) {
                    cVar.onLoadSuccess(arrayList);
                }
            }
        }

        @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
        @NonNull
        public Loader<Cursor> onCreateLoader(int i2, @Nullable Bundle bundle) {
            return new CursorLoader(d.a.l0.a.c1.a.b(), d.a.l0.a.j0.b.a.e(), null, null, null, "sort_index");
        }

        @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
        public void onLoaderReset(@NonNull Loader<Cursor> loader) {
            c cVar = this.f10854a;
            if (cVar != null) {
                cVar.onLoadFail();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class a implements d.a.l0.a.b0.c.a {
        public a() {
        }

        @Override // d.a.l0.a.b0.c.a
        public void a(CommonSyncServerData commonSyncServerData) {
            d.a.l0.a.e0.d.h("SwanFavorDataManager", "fetchFavorDataFromServer onSuccess");
            SwanFavorDataManager.this.f(commonSyncServerData);
        }

        @Override // d.a.l0.a.b0.c.a
        public void onFail() {
            d.a.l0.a.e0.d.h("SwanFavorDataManager", "fetchFavorDataFromServer onFail");
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.b0.c.a f10856e;

        public b(SwanFavorDataManager swanFavorDataManager, d.a.l0.a.b0.c.a aVar) {
            this.f10856e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.l0.a.b0.a.b(this.f10856e);
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void onLoadFail();

        void onLoadSuccess(List<SwanFavorItemData> list);
    }

    /* loaded from: classes3.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public static final SwanFavorDataManager f10857a = new SwanFavorDataManager(null);
    }

    public /* synthetic */ SwanFavorDataManager(a aVar) {
        this();
    }

    public static SwanFavorDataManager h() {
        return d.f10857a;
    }

    public static void l(boolean z) {
        if (f10853e) {
            Log.d("SwanFavorDataManager", "sendFavorStatusMsg: isAddfavor = " + z);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("status", z ? "1" : "0");
        f.V().v(new d.a.l0.a.o0.d.b("favorStatusChange", hashMap));
    }

    @Override // d.a.l0.a.m.c
    public void a(boolean z) {
        d.a.l0.a.e0.d.h("SwanFavorDataManager", "onLoginStatusChanged isLoggedIn=" + z);
        d();
    }

    public void b(String str, d.a.l0.a.q0.b.a aVar) {
        if (!SwanAppNetworkUtils.h()) {
            if (aVar != null) {
                aVar.a();
                return;
            }
            return;
        }
        SwanFavorItemData swanFavorItemData = new SwanFavorItemData();
        swanFavorItemData.setAppKey(str);
        swanFavorItemData.setIsNewFavor(1);
        if (d.a.l0.a.j0.b.a.b(swanFavorItemData, 1, aVar)) {
            m(str, true);
        }
        k(str, IMTrack.DbBuilder.ACTION_ADD);
    }

    public void c(String str, d.a.l0.a.q0.b.b bVar, b.C0819b c0819b) {
        if (SwanAppNetworkUtils.h()) {
            if (d.a.l0.a.j0.b.a.g(str, bVar, c0819b)) {
                m(str, false);
            }
            k(str, QueryResponse.Options.CANCEL);
        } else if (bVar != null) {
            bVar.a();
        }
    }

    public void d() {
        e(new a());
    }

    public void e(d.a.l0.a.b0.c.a aVar) {
        q.j(new b(this, aVar), "fetchFavorDataFromServer");
    }

    public void f(CommonSyncServerData commonSyncServerData) {
        List<CommonSyncServerData.MetaItemInfo> list;
        if (commonSyncServerData == null || (list = commonSyncServerData.metaItems) == null || list.size() <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (CommonSyncServerData.MetaItemInfo metaItemInfo : list) {
            if (metaItemInfo != null) {
                SwanFavorItemData swanFavorItemData = new SwanFavorItemData();
                String str = metaItemInfo.appKey;
                swanFavorItemData.setAppKey(str);
                swanFavorItemData.setAppType(d.a.l0.a.v.a.b(str));
                swanFavorItemData.setIconUrl(metaItemInfo.icon);
                swanFavorItemData.setAppName(metaItemInfo.appName);
                swanFavorItemData.setAppFrameType(metaItemInfo.subCategory);
                swanFavorItemData.setCreateTime(metaItemInfo.createTime);
                swanFavorItemData.setPayProtected(metaItemInfo.payProtected);
                arrayList.add(swanFavorItemData);
            }
        }
        d.a.l0.a.j0.b.a.q(arrayList);
    }

    public final Bundle g(String str, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putString("appKey", str);
        bundle.putBoolean("isFavor", z);
        return bundle;
    }

    public List<SwanFavorItemData> i() {
        return d.a.l0.a.j0.b.a.j();
    }

    public void j(String str, d.a.l0.a.q0.b.a aVar) {
        if (SwanAppNetworkUtils.h()) {
            d.a.l0.a.j0.b.a.o(str, 1, aVar);
            n(str);
        } else if (aVar != null) {
            aVar.a();
        }
    }

    public final void k(String str, String str2) {
        d.a.l0.a.b0.a.d(d.a.l0.a.q0.a.b(str, str2));
    }

    public void m(String str, boolean z) {
        if (ProcessUtils.isMainProcess()) {
            d.a.l0.a.v1.c.d.b.a(g(str, z), d.a.l0.a.q0.c.b.class);
            return;
        }
        e Q = e.Q();
        if (Q == null) {
            return;
        }
        if (TextUtils.equals(Q.getAppId(), "sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u")) {
            d.a.l0.a.v1.c.d.b.c(g(str, z), d.a.l0.a.q0.c.a.class, null);
        } else if (TextUtils.equals(Q.getAppId(), str)) {
            l(z);
        }
    }

    public final void n(String str) {
        d.a.l0.a.b0.a.e(d.a.l0.a.q0.a.c(str, 1));
    }

    public SwanFavorDataManager() {
        SwanAppDbControl.f(d.a.l0.a.c1.a.b());
        d.a.l0.a.c1.a.a0().c(this);
    }
}

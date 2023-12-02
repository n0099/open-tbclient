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
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.commonsync.CommonSyncServerData;
import com.baidu.swan.apps.database.SwanAppDbControl;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.c63;
import com.baidu.tieba.ci2;
import com.baidu.tieba.di2;
import com.baidu.tieba.e33;
import com.baidu.tieba.eg2;
import com.baidu.tieba.ei2;
import com.baidu.tieba.ej3;
import com.baidu.tieba.ek3;
import com.baidu.tieba.fi2;
import com.baidu.tieba.gi2;
import com.baidu.tieba.id2;
import com.baidu.tieba.j63;
import com.baidu.tieba.k32;
import com.baidu.tieba.k63;
import com.baidu.tieba.lg2;
import com.baidu.tieba.ny1;
import com.baidu.tieba.o12;
import com.baidu.tieba.q12;
import com.baidu.tieba.rp2;
import com.baidu.tieba.vm1;
import com.baidu.tieba.xr2;
import com.baidu.tieba.zm1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes4.dex */
public class SwanFavorDataManager implements zm1 {
    public static final boolean a = vm1.a;

    /* loaded from: classes4.dex */
    public interface c {
        void d();

        void e(List<SwanFavorItemData> list);
    }

    /* loaded from: classes4.dex */
    public class FavorDataDBLoaderCB implements LoaderManager.LoaderCallbacks<Cursor> {
        public c a;

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
                c cVar2 = this.a;
                if (cVar2 != null) {
                    cVar2.d();
                    return;
                }
                return;
            }
            ArrayList arrayList = new ArrayList();
            if (cursor != null && cursor.getCount() > 0 && cursor.moveToFirst()) {
                do {
                    SwanFavorItemData l = id2.l(cursor);
                    if (!TextUtils.isEmpty(l.getAppKey()) && !TextUtils.isEmpty(l.getAppName())) {
                        arrayList.add(l);
                    }
                } while (cursor.moveToNext());
                cVar = this.a;
                if (cVar == null) {
                }
            } else {
                cVar = this.a;
                if (cVar == null) {
                    cVar.e(arrayList);
                }
            }
        }

        @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
        @NonNull
        public Loader<Cursor> onCreateLoader(int i, @Nullable Bundle bundle) {
            return new CursorLoader(rp2.c(), id2.e(), null, null, null, "sort_index");
        }

        @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
        public void onLoaderReset(@NonNull Loader<Cursor> loader) {
            c cVar = this.a;
            if (cVar != null) {
                cVar.d();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class a implements q12 {
        public a() {
        }

        @Override // com.baidu.tieba.q12
        public void a(CommonSyncServerData commonSyncServerData) {
            k32.k("SwanFavorDataManager", "fetchFavorDataFromServer onSuccess");
            SwanFavorDataManager.this.f(commonSyncServerData);
        }

        @Override // com.baidu.tieba.q12
        public void onFail() {
            k32.k("SwanFavorDataManager", "fetchFavorDataFromServer onFail");
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public final /* synthetic */ q12 a;

        public b(SwanFavorDataManager swanFavorDataManager, q12 q12Var) {
            this.a = q12Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            o12.b(this.a);
        }
    }

    /* loaded from: classes4.dex */
    public static class d {
        public static final SwanFavorDataManager a = new SwanFavorDataManager(null);
    }

    public SwanFavorDataManager() {
        SwanAppDbControl.f(rp2.c());
        rp2.h0().c(this);
    }

    public static SwanFavorDataManager h() {
        return d.a;
    }

    public void d() {
        e(new a());
    }

    public List<SwanFavorItemData> i() {
        return id2.j();
    }

    public /* synthetic */ SwanFavorDataManager(a aVar) {
        this();
    }

    @Override // com.baidu.tieba.zm1
    public void a(boolean z) {
        k32.k("SwanFavorDataManager", "onLoginStatusChanged isLoggedIn=" + z);
        d();
    }

    public void e(q12 q12Var) {
        ej3.k(new b(this, q12Var), "fetchFavorDataFromServer");
    }

    public final void n(String str) {
        o12.e(ci2.c(str, 1));
    }

    public static void l(boolean z) {
        String str;
        if (a) {
            Log.d("SwanFavorDataManager", "sendFavorStatusMsg: isAddfavor = " + z);
        }
        HashMap hashMap = new HashMap();
        if (z) {
            str = "1";
        } else {
            str = "0";
        }
        hashMap.put("status", str);
        xr2.V().v(new lg2("favorStatusChange", hashMap));
    }

    public void b(String str, di2 di2Var) {
        rp2.t().a();
        if (!ek3.T(R.string.obfuscated_res_0x7f0f152d) && rp2.t().b()) {
            if (!SwanAppNetworkUtils.h()) {
                if (di2Var != null) {
                    di2Var.a();
                }
            } else if (TextUtils.equals(str, j63.K().q().P()) && j63.K().q().X().w1() != 0) {
                c63.f(AppRuntime.getAppContext(), R.string.obfuscated_res_0x7f0f1500).G();
                di2Var.b(true);
            } else {
                SwanFavorItemData swanFavorItemData = new SwanFavorItemData();
                swanFavorItemData.setAppKey(str);
                swanFavorItemData.setIsNewFavor(1);
                if (id2.b(swanFavorItemData, 1, di2Var)) {
                    m(str, true);
                }
                k(str, "add");
            }
        }
    }

    public void c(String str, ei2 ei2Var, eg2.b bVar) {
        if (ek3.T(R.string.obfuscated_res_0x7f0f152d)) {
            return;
        }
        if (!SwanAppNetworkUtils.h()) {
            if (ei2Var != null) {
                ei2Var.a();
            }
        } else if (TextUtils.equals(str, j63.K().q().P()) && j63.K().q().X().w1() != 0) {
            c63.f(AppRuntime.getAppContext(), R.string.obfuscated_res_0x7f0f1500).G();
            ei2Var.c(true);
        } else {
            if (id2.g(str, ei2Var, bVar)) {
                m(str, false);
            }
            k(str, "cancel");
        }
    }

    public void f(CommonSyncServerData commonSyncServerData) {
        List<CommonSyncServerData.MetaItemInfo> list;
        if (commonSyncServerData != null && (list = commonSyncServerData.metaItems) != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (CommonSyncServerData.MetaItemInfo metaItemInfo : list) {
                if (metaItemInfo != null) {
                    SwanFavorItemData swanFavorItemData = new SwanFavorItemData();
                    String str = metaItemInfo.appKey;
                    swanFavorItemData.setAppKey(str);
                    swanFavorItemData.setAppType(ny1.b(str));
                    swanFavorItemData.setIconUrl(metaItemInfo.icon);
                    swanFavorItemData.setAppName(metaItemInfo.appName);
                    swanFavorItemData.setAppFrameType(metaItemInfo.subCategory);
                    swanFavorItemData.setCreateTime(metaItemInfo.createTime);
                    swanFavorItemData.setPayProtected(metaItemInfo.payProtected);
                    arrayList.add(swanFavorItemData);
                }
            }
            id2.q(arrayList);
        }
    }

    public final Bundle g(String str, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putString("appKey", str);
        bundle.putBoolean("isFavor", z);
        return bundle;
    }

    public void j(String str, di2 di2Var) {
        if (!SwanAppNetworkUtils.h()) {
            if (di2Var != null) {
                di2Var.a();
                return;
            }
            return;
        }
        id2.o(str, 1, di2Var);
        n(str);
    }

    public final void k(String str, String str2) {
        o12.d(ci2.b(str, str2));
    }

    public void m(String str, boolean z) {
        if (ProcessUtils.isMainProcess()) {
            e33.a(g(str, z), gi2.class);
            return;
        }
        k63 c0 = k63.c0();
        if (c0 == null) {
            return;
        }
        if (TextUtils.equals(c0.getAppId(), "sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u")) {
            e33.c(g(str, z), fi2.class, null);
        } else if (TextUtils.equals(c0.getAppId(), str)) {
            l(z);
        }
    }
}

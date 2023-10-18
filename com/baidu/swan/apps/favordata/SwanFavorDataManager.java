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
import com.baidu.tieba.am1;
import com.baidu.tieba.cr2;
import com.baidu.tieba.em1;
import com.baidu.tieba.h53;
import com.baidu.tieba.hh2;
import com.baidu.tieba.ih2;
import com.baidu.tieba.j23;
import com.baidu.tieba.jf2;
import com.baidu.tieba.jh2;
import com.baidu.tieba.ji3;
import com.baidu.tieba.jj3;
import com.baidu.tieba.kh2;
import com.baidu.tieba.lh2;
import com.baidu.tieba.nc2;
import com.baidu.tieba.o53;
import com.baidu.tieba.p22;
import com.baidu.tieba.p53;
import com.baidu.tieba.qf2;
import com.baidu.tieba.sx1;
import com.baidu.tieba.t02;
import com.baidu.tieba.v02;
import com.baidu.tieba.wo2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes4.dex */
public class SwanFavorDataManager implements em1 {
    public static final boolean a = am1.a;

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
                    SwanFavorItemData l = nc2.l(cursor);
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
            return new CursorLoader(wo2.c(), nc2.e(), null, null, null, "sort_index");
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
    public class a implements v02 {
        public a() {
        }

        @Override // com.baidu.tieba.v02
        public void a(CommonSyncServerData commonSyncServerData) {
            p22.k("SwanFavorDataManager", "fetchFavorDataFromServer onSuccess");
            SwanFavorDataManager.this.f(commonSyncServerData);
        }

        @Override // com.baidu.tieba.v02
        public void onFail() {
            p22.k("SwanFavorDataManager", "fetchFavorDataFromServer onFail");
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public final /* synthetic */ v02 a;

        public b(SwanFavorDataManager swanFavorDataManager, v02 v02Var) {
            this.a = v02Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            t02.b(this.a);
        }
    }

    /* loaded from: classes4.dex */
    public static class d {
        public static final SwanFavorDataManager a = new SwanFavorDataManager(null);
    }

    public SwanFavorDataManager() {
        SwanAppDbControl.f(wo2.c());
        wo2.h0().c(this);
    }

    public static SwanFavorDataManager h() {
        return d.a;
    }

    public void d() {
        e(new a());
    }

    public List<SwanFavorItemData> i() {
        return nc2.j();
    }

    public /* synthetic */ SwanFavorDataManager(a aVar) {
        this();
    }

    @Override // com.baidu.tieba.em1
    public void a(boolean z) {
        p22.k("SwanFavorDataManager", "onLoginStatusChanged isLoggedIn=" + z);
        d();
    }

    public void e(v02 v02Var) {
        ji3.k(new b(this, v02Var), "fetchFavorDataFromServer");
    }

    public final void n(String str) {
        t02.e(hh2.c(str, 1));
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
        cr2.V().v(new qf2("favorStatusChange", hashMap));
    }

    public void b(String str, ih2 ih2Var) {
        wo2.t().a();
        if (!jj3.T(R.string.obfuscated_res_0x7f0f1505) && wo2.t().b()) {
            if (!SwanAppNetworkUtils.h()) {
                if (ih2Var != null) {
                    ih2Var.a();
                }
            } else if (TextUtils.equals(str, o53.K().q().P()) && o53.K().q().X().w1() != 0) {
                h53.f(AppRuntime.getAppContext(), R.string.obfuscated_res_0x7f0f14d8).G();
                ih2Var.b(true);
            } else {
                SwanFavorItemData swanFavorItemData = new SwanFavorItemData();
                swanFavorItemData.setAppKey(str);
                swanFavorItemData.setIsNewFavor(1);
                if (nc2.b(swanFavorItemData, 1, ih2Var)) {
                    m(str, true);
                }
                k(str, "add");
            }
        }
    }

    public void c(String str, jh2 jh2Var, jf2.b bVar) {
        if (jj3.T(R.string.obfuscated_res_0x7f0f1505)) {
            return;
        }
        if (!SwanAppNetworkUtils.h()) {
            if (jh2Var != null) {
                jh2Var.a();
            }
        } else if (TextUtils.equals(str, o53.K().q().P()) && o53.K().q().X().w1() != 0) {
            h53.f(AppRuntime.getAppContext(), R.string.obfuscated_res_0x7f0f14d8).G();
            jh2Var.c(true);
        } else {
            if (nc2.g(str, jh2Var, bVar)) {
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
                    swanFavorItemData.setAppType(sx1.b(str));
                    swanFavorItemData.setIconUrl(metaItemInfo.icon);
                    swanFavorItemData.setAppName(metaItemInfo.appName);
                    swanFavorItemData.setAppFrameType(metaItemInfo.subCategory);
                    swanFavorItemData.setCreateTime(metaItemInfo.createTime);
                    swanFavorItemData.setPayProtected(metaItemInfo.payProtected);
                    arrayList.add(swanFavorItemData);
                }
            }
            nc2.q(arrayList);
        }
    }

    public final Bundle g(String str, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putString("appKey", str);
        bundle.putBoolean("isFavor", z);
        return bundle;
    }

    public void j(String str, ih2 ih2Var) {
        if (!SwanAppNetworkUtils.h()) {
            if (ih2Var != null) {
                ih2Var.a();
                return;
            }
            return;
        }
        nc2.o(str, 1, ih2Var);
        n(str);
    }

    public final void k(String str, String str2) {
        t02.d(hh2.b(str, str2));
    }

    public void m(String str, boolean z) {
        if (ProcessUtils.isMainProcess()) {
            j23.a(g(str, z), lh2.class);
            return;
        }
        p53 c0 = p53.c0();
        if (c0 == null) {
            return;
        }
        if (TextUtils.equals(c0.getAppId(), "sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u")) {
            j23.c(g(str, z), kh2.class, null);
        } else if (TextUtils.equals(c0.getAppId(), str)) {
            l(z);
        }
    }
}

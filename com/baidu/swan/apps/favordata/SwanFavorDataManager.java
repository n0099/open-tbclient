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
import com.baidu.tieba.a32;
import com.baidu.tieba.cr2;
import com.baidu.tieba.fo1;
import com.baidu.tieba.it2;
import com.baidu.tieba.jo1;
import com.baidu.tieba.n73;
import com.baidu.tieba.nj2;
import com.baidu.tieba.oj2;
import com.baidu.tieba.p43;
import com.baidu.tieba.ph2;
import com.baidu.tieba.pj2;
import com.baidu.tieba.pk3;
import com.baidu.tieba.pl3;
import com.baidu.tieba.qj2;
import com.baidu.tieba.rj2;
import com.baidu.tieba.te2;
import com.baidu.tieba.u73;
import com.baidu.tieba.v42;
import com.baidu.tieba.v73;
import com.baidu.tieba.wh2;
import com.baidu.tieba.xz1;
import com.baidu.tieba.y22;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes3.dex */
public class SwanFavorDataManager implements jo1 {
    public static final boolean a = fo1.a;

    /* loaded from: classes3.dex */
    public interface c {
        void onLoadFail();

        void onLoadSuccess(List<SwanFavorItemData> list);
    }

    /* loaded from: classes3.dex */
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
                    cVar2.onLoadFail();
                    return;
                }
                return;
            }
            ArrayList arrayList = new ArrayList();
            if (cursor != null && cursor.getCount() > 0 && cursor.moveToFirst()) {
                do {
                    SwanFavorItemData l = te2.l(cursor);
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
                    cVar.onLoadSuccess(arrayList);
                }
            }
        }

        @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
        @NonNull
        public Loader<Cursor> onCreateLoader(int i, @Nullable Bundle bundle) {
            return new CursorLoader(cr2.c(), te2.e(), null, null, null, "sort_index");
        }

        @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
        public void onLoaderReset(@NonNull Loader<Cursor> loader) {
            c cVar = this.a;
            if (cVar != null) {
                cVar.onLoadFail();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class a implements a32 {
        public a() {
        }

        @Override // com.baidu.tieba.a32
        public void a(CommonSyncServerData commonSyncServerData) {
            v42.k("SwanFavorDataManager", "fetchFavorDataFromServer onSuccess");
            SwanFavorDataManager.this.f(commonSyncServerData);
        }

        @Override // com.baidu.tieba.a32
        public void onFail() {
            v42.k("SwanFavorDataManager", "fetchFavorDataFromServer onFail");
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public final /* synthetic */ a32 a;

        public b(SwanFavorDataManager swanFavorDataManager, a32 a32Var) {
            this.a = a32Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            y22.b(this.a);
        }
    }

    /* loaded from: classes3.dex */
    public static class d {
        public static final SwanFavorDataManager a = new SwanFavorDataManager(null);
    }

    public SwanFavorDataManager() {
        SwanAppDbControl.f(cr2.c());
        cr2.h0().c(this);
    }

    public static SwanFavorDataManager h() {
        return d.a;
    }

    public void d() {
        e(new a());
    }

    public List<SwanFavorItemData> i() {
        return te2.j();
    }

    public /* synthetic */ SwanFavorDataManager(a aVar) {
        this();
    }

    @Override // com.baidu.tieba.jo1
    public void a(boolean z) {
        v42.k("SwanFavorDataManager", "onLoginStatusChanged isLoggedIn=" + z);
        d();
    }

    public void e(a32 a32Var) {
        pk3.k(new b(this, a32Var), "fetchFavorDataFromServer");
    }

    public final void n(String str) {
        y22.e(nj2.c(str, 1));
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
        it2.U().u(new wh2("favorStatusChange", hashMap));
    }

    public void b(String str, oj2 oj2Var) {
        cr2.t().a();
        if (!pl3.T(R.string.obfuscated_res_0x7f0f1352) && cr2.t().b()) {
            if (!SwanAppNetworkUtils.h()) {
                if (oj2Var != null) {
                    oj2Var.a();
                }
            } else if (TextUtils.equals(str, u73.K().q().O()) && u73.K().q().W().getType() != 0) {
                n73.f(AppRuntime.getAppContext(), R.string.obfuscated_res_0x7f0f1325).G();
                oj2Var.b(true);
            } else {
                SwanFavorItemData swanFavorItemData = new SwanFavorItemData();
                swanFavorItemData.setAppKey(str);
                swanFavorItemData.setIsNewFavor(1);
                if (te2.b(swanFavorItemData, 1, oj2Var)) {
                    m(str, true);
                }
                k(str, "add");
            }
        }
    }

    public void c(String str, pj2 pj2Var, ph2.b bVar) {
        if (pl3.T(R.string.obfuscated_res_0x7f0f1352)) {
            return;
        }
        if (!SwanAppNetworkUtils.h()) {
            if (pj2Var != null) {
                pj2Var.a();
            }
        } else if (TextUtils.equals(str, u73.K().q().O()) && u73.K().q().W().getType() != 0) {
            n73.f(AppRuntime.getAppContext(), R.string.obfuscated_res_0x7f0f1325).G();
            pj2Var.c(true);
        } else {
            if (te2.g(str, pj2Var, bVar)) {
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
                    swanFavorItemData.setAppType(xz1.b(str));
                    swanFavorItemData.setIconUrl(metaItemInfo.icon);
                    swanFavorItemData.setAppName(metaItemInfo.appName);
                    swanFavorItemData.setAppFrameType(metaItemInfo.subCategory);
                    swanFavorItemData.setCreateTime(metaItemInfo.createTime);
                    swanFavorItemData.setPayProtected(metaItemInfo.payProtected);
                    arrayList.add(swanFavorItemData);
                }
            }
            te2.q(arrayList);
        }
    }

    public final Bundle g(String str, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putString("appKey", str);
        bundle.putBoolean("isFavor", z);
        return bundle;
    }

    public void j(String str, oj2 oj2Var) {
        if (!SwanAppNetworkUtils.h()) {
            if (oj2Var != null) {
                oj2Var.a();
                return;
            }
            return;
        }
        te2.o(str, 1, oj2Var);
        n(str);
    }

    public final void k(String str, String str2) {
        y22.d(nj2.b(str, str2));
    }

    public void m(String str, boolean z) {
        if (ProcessUtils.isMainProcess()) {
            p43.a(g(str, z), rj2.class);
            return;
        }
        v73 b0 = v73.b0();
        if (b0 == null) {
            return;
        }
        if (TextUtils.equals(b0.getAppId(), "sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u")) {
            p43.c(g(str, z), qj2.class, null);
        } else if (TextUtils.equals(b0.getAppId(), str)) {
            l(z);
        }
    }
}

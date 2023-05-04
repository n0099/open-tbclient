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
import com.baidu.tieba.c32;
import com.baidu.tieba.er2;
import com.baidu.tieba.ho1;
import com.baidu.tieba.kt2;
import com.baidu.tieba.lo1;
import com.baidu.tieba.p73;
import com.baidu.tieba.pj2;
import com.baidu.tieba.qj2;
import com.baidu.tieba.r43;
import com.baidu.tieba.rh2;
import com.baidu.tieba.rj2;
import com.baidu.tieba.rk3;
import com.baidu.tieba.rl3;
import com.baidu.tieba.sj2;
import com.baidu.tieba.tj2;
import com.baidu.tieba.ve2;
import com.baidu.tieba.w73;
import com.baidu.tieba.x42;
import com.baidu.tieba.x73;
import com.baidu.tieba.yh2;
import com.baidu.tieba.zz1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes3.dex */
public class SwanFavorDataManager implements lo1 {
    public static final boolean a = ho1.a;

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
                    SwanFavorItemData l = ve2.l(cursor);
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
            return new CursorLoader(er2.c(), ve2.e(), null, null, null, "sort_index");
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
    public class a implements c32 {
        public a() {
        }

        @Override // com.baidu.tieba.c32
        public void a(CommonSyncServerData commonSyncServerData) {
            x42.k("SwanFavorDataManager", "fetchFavorDataFromServer onSuccess");
            SwanFavorDataManager.this.f(commonSyncServerData);
        }

        @Override // com.baidu.tieba.c32
        public void onFail() {
            x42.k("SwanFavorDataManager", "fetchFavorDataFromServer onFail");
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public final /* synthetic */ c32 a;

        public b(SwanFavorDataManager swanFavorDataManager, c32 c32Var) {
            this.a = c32Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            a32.b(this.a);
        }
    }

    /* loaded from: classes3.dex */
    public static class d {
        public static final SwanFavorDataManager a = new SwanFavorDataManager(null);
    }

    public SwanFavorDataManager() {
        SwanAppDbControl.f(er2.c());
        er2.h0().c(this);
    }

    public static SwanFavorDataManager h() {
        return d.a;
    }

    public void d() {
        e(new a());
    }

    public List<SwanFavorItemData> i() {
        return ve2.j();
    }

    public /* synthetic */ SwanFavorDataManager(a aVar) {
        this();
    }

    @Override // com.baidu.tieba.lo1
    public void a(boolean z) {
        x42.k("SwanFavorDataManager", "onLoginStatusChanged isLoggedIn=" + z);
        d();
    }

    public void e(c32 c32Var) {
        rk3.k(new b(this, c32Var), "fetchFavorDataFromServer");
    }

    public final void n(String str) {
        a32.e(pj2.c(str, 1));
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
        kt2.U().u(new yh2("favorStatusChange", hashMap));
    }

    public void b(String str, qj2 qj2Var) {
        er2.t().a();
        if (!rl3.T(R.string.obfuscated_res_0x7f0f136b) && er2.t().b()) {
            if (!SwanAppNetworkUtils.h()) {
                if (qj2Var != null) {
                    qj2Var.a();
                }
            } else if (TextUtils.equals(str, w73.K().q().O()) && w73.K().q().W().getType() != 0) {
                p73.f(AppRuntime.getAppContext(), R.string.obfuscated_res_0x7f0f133e).G();
                qj2Var.b(true);
            } else {
                SwanFavorItemData swanFavorItemData = new SwanFavorItemData();
                swanFavorItemData.setAppKey(str);
                swanFavorItemData.setIsNewFavor(1);
                if (ve2.b(swanFavorItemData, 1, qj2Var)) {
                    m(str, true);
                }
                k(str, "add");
            }
        }
    }

    public void c(String str, rj2 rj2Var, rh2.b bVar) {
        if (rl3.T(R.string.obfuscated_res_0x7f0f136b)) {
            return;
        }
        if (!SwanAppNetworkUtils.h()) {
            if (rj2Var != null) {
                rj2Var.a();
            }
        } else if (TextUtils.equals(str, w73.K().q().O()) && w73.K().q().W().getType() != 0) {
            p73.f(AppRuntime.getAppContext(), R.string.obfuscated_res_0x7f0f133e).G();
            rj2Var.c(true);
        } else {
            if (ve2.g(str, rj2Var, bVar)) {
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
                    swanFavorItemData.setAppType(zz1.b(str));
                    swanFavorItemData.setIconUrl(metaItemInfo.icon);
                    swanFavorItemData.setAppName(metaItemInfo.appName);
                    swanFavorItemData.setAppFrameType(metaItemInfo.subCategory);
                    swanFavorItemData.setCreateTime(metaItemInfo.createTime);
                    swanFavorItemData.setPayProtected(metaItemInfo.payProtected);
                    arrayList.add(swanFavorItemData);
                }
            }
            ve2.q(arrayList);
        }
    }

    public final Bundle g(String str, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putString("appKey", str);
        bundle.putBoolean("isFavor", z);
        return bundle;
    }

    public void j(String str, qj2 qj2Var) {
        if (!SwanAppNetworkUtils.h()) {
            if (qj2Var != null) {
                qj2Var.a();
                return;
            }
            return;
        }
        ve2.o(str, 1, qj2Var);
        n(str);
    }

    public final void k(String str, String str2) {
        a32.d(pj2.b(str, str2));
    }

    public void m(String str, boolean z) {
        if (ProcessUtils.isMainProcess()) {
            r43.a(g(str, z), tj2.class);
            return;
        }
        x73 b0 = x73.b0();
        if (b0 == null) {
            return;
        }
        if (TextUtils.equals(b0.getAppId(), "sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u")) {
            r43.c(g(str, z), sj2.class, null);
        } else if (TextUtils.equals(b0.getAppId(), str)) {
            l(z);
        }
    }
}

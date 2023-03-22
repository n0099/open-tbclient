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
import com.baidu.tieba.ar2;
import com.baidu.tieba.do1;
import com.baidu.tieba.gt2;
import com.baidu.tieba.ho1;
import com.baidu.tieba.l73;
import com.baidu.tieba.lj2;
import com.baidu.tieba.mj2;
import com.baidu.tieba.n43;
import com.baidu.tieba.nh2;
import com.baidu.tieba.nj2;
import com.baidu.tieba.nk3;
import com.baidu.tieba.nl3;
import com.baidu.tieba.oj2;
import com.baidu.tieba.pj2;
import com.baidu.tieba.re2;
import com.baidu.tieba.s73;
import com.baidu.tieba.t42;
import com.baidu.tieba.t73;
import com.baidu.tieba.uh2;
import com.baidu.tieba.vz1;
import com.baidu.tieba.w22;
import com.baidu.tieba.y22;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes3.dex */
public class SwanFavorDataManager implements ho1 {
    public static final boolean a = do1.a;

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
                    SwanFavorItemData l = re2.l(cursor);
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
            return new CursorLoader(ar2.c(), re2.e(), null, null, null, "sort_index");
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
    public class a implements y22 {
        public a() {
        }

        @Override // com.baidu.tieba.y22
        public void a(CommonSyncServerData commonSyncServerData) {
            t42.k("SwanFavorDataManager", "fetchFavorDataFromServer onSuccess");
            SwanFavorDataManager.this.f(commonSyncServerData);
        }

        @Override // com.baidu.tieba.y22
        public void onFail() {
            t42.k("SwanFavorDataManager", "fetchFavorDataFromServer onFail");
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public final /* synthetic */ y22 a;

        public b(SwanFavorDataManager swanFavorDataManager, y22 y22Var) {
            this.a = y22Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            w22.b(this.a);
        }
    }

    /* loaded from: classes3.dex */
    public static class d {
        public static final SwanFavorDataManager a = new SwanFavorDataManager(null);
    }

    public SwanFavorDataManager() {
        SwanAppDbControl.f(ar2.c());
        ar2.h0().c(this);
    }

    public static SwanFavorDataManager h() {
        return d.a;
    }

    public void d() {
        e(new a());
    }

    public List<SwanFavorItemData> i() {
        return re2.j();
    }

    public /* synthetic */ SwanFavorDataManager(a aVar) {
        this();
    }

    @Override // com.baidu.tieba.ho1
    public void a(boolean z) {
        t42.k("SwanFavorDataManager", "onLoginStatusChanged isLoggedIn=" + z);
        d();
    }

    public void e(y22 y22Var) {
        nk3.k(new b(this, y22Var), "fetchFavorDataFromServer");
    }

    public final void n(String str) {
        w22.e(lj2.c(str, 1));
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
        gt2.U().u(new uh2("favorStatusChange", hashMap));
    }

    public void b(String str, mj2 mj2Var) {
        ar2.t().a();
        if (!nl3.T(R.string.obfuscated_res_0x7f0f135b) && ar2.t().b()) {
            if (!SwanAppNetworkUtils.h()) {
                if (mj2Var != null) {
                    mj2Var.a();
                }
            } else if (TextUtils.equals(str, s73.K().q().O()) && s73.K().q().W().getType() != 0) {
                l73.f(AppRuntime.getAppContext(), R.string.obfuscated_res_0x7f0f132e).G();
                mj2Var.b(true);
            } else {
                SwanFavorItemData swanFavorItemData = new SwanFavorItemData();
                swanFavorItemData.setAppKey(str);
                swanFavorItemData.setIsNewFavor(1);
                if (re2.b(swanFavorItemData, 1, mj2Var)) {
                    m(str, true);
                }
                k(str, "add");
            }
        }
    }

    public void c(String str, nj2 nj2Var, nh2.b bVar) {
        if (nl3.T(R.string.obfuscated_res_0x7f0f135b)) {
            return;
        }
        if (!SwanAppNetworkUtils.h()) {
            if (nj2Var != null) {
                nj2Var.a();
            }
        } else if (TextUtils.equals(str, s73.K().q().O()) && s73.K().q().W().getType() != 0) {
            l73.f(AppRuntime.getAppContext(), R.string.obfuscated_res_0x7f0f132e).G();
            nj2Var.c(true);
        } else {
            if (re2.g(str, nj2Var, bVar)) {
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
                    swanFavorItemData.setAppType(vz1.b(str));
                    swanFavorItemData.setIconUrl(metaItemInfo.icon);
                    swanFavorItemData.setAppName(metaItemInfo.appName);
                    swanFavorItemData.setAppFrameType(metaItemInfo.subCategory);
                    swanFavorItemData.setCreateTime(metaItemInfo.createTime);
                    swanFavorItemData.setPayProtected(metaItemInfo.payProtected);
                    arrayList.add(swanFavorItemData);
                }
            }
            re2.q(arrayList);
        }
    }

    public final Bundle g(String str, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putString("appKey", str);
        bundle.putBoolean("isFavor", z);
        return bundle;
    }

    public void j(String str, mj2 mj2Var) {
        if (!SwanAppNetworkUtils.h()) {
            if (mj2Var != null) {
                mj2Var.a();
                return;
            }
            return;
        }
        re2.o(str, 1, mj2Var);
        n(str);
    }

    public final void k(String str, String str2) {
        w22.d(lj2.b(str, str2));
    }

    public void m(String str, boolean z) {
        if (ProcessUtils.isMainProcess()) {
            n43.a(g(str, z), pj2.class);
            return;
        }
        t73 b0 = t73.b0();
        if (b0 == null) {
            return;
        }
        if (TextUtils.equals(b0.getAppId(), "sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u")) {
            n43.c(g(str, z), oj2.class, null);
        } else if (TextUtils.equals(b0.getAppId(), str)) {
            l(z);
        }
    }
}

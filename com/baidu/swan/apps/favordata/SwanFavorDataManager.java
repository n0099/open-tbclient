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
import com.baidu.tieba.bi2;
import com.baidu.tieba.cb3;
import com.baidu.tieba.d82;
import com.baidu.tieba.db3;
import com.baidu.tieba.el2;
import com.baidu.tieba.f32;
import com.baidu.tieba.g62;
import com.baidu.tieba.i62;
import com.baidu.tieba.ku2;
import com.baidu.tieba.nr1;
import com.baidu.tieba.qw2;
import com.baidu.tieba.rr1;
import com.baidu.tieba.va3;
import com.baidu.tieba.vm2;
import com.baidu.tieba.wm2;
import com.baidu.tieba.x73;
import com.baidu.tieba.xk2;
import com.baidu.tieba.xm2;
import com.baidu.tieba.xn3;
import com.baidu.tieba.xo3;
import com.baidu.tieba.ym2;
import com.baidu.tieba.zm2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes4.dex */
public class SwanFavorDataManager implements rr1 {
    public static final boolean a = nr1.a;

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
                    SwanFavorItemData l = bi2.l(cursor);
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
            return new CursorLoader(ku2.c(), bi2.e(), null, null, null, "sort_index");
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
    public class a implements i62 {
        public a() {
        }

        @Override // com.baidu.tieba.i62
        public void a(CommonSyncServerData commonSyncServerData) {
            d82.k("SwanFavorDataManager", "fetchFavorDataFromServer onSuccess");
            SwanFavorDataManager.this.f(commonSyncServerData);
        }

        @Override // com.baidu.tieba.i62
        public void onFail() {
            d82.k("SwanFavorDataManager", "fetchFavorDataFromServer onFail");
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public final /* synthetic */ i62 a;

        public b(SwanFavorDataManager swanFavorDataManager, i62 i62Var) {
            this.a = i62Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            g62.b(this.a);
        }
    }

    /* loaded from: classes4.dex */
    public static class d {
        public static final SwanFavorDataManager a = new SwanFavorDataManager(null);
    }

    public SwanFavorDataManager() {
        SwanAppDbControl.f(ku2.c());
        ku2.h0().c(this);
    }

    public static SwanFavorDataManager h() {
        return d.a;
    }

    public void d() {
        e(new a());
    }

    public List<SwanFavorItemData> i() {
        return bi2.j();
    }

    public /* synthetic */ SwanFavorDataManager(a aVar) {
        this();
    }

    @Override // com.baidu.tieba.rr1
    public void a(boolean z) {
        d82.k("SwanFavorDataManager", "onLoginStatusChanged isLoggedIn=" + z);
        d();
    }

    public void e(i62 i62Var) {
        xn3.k(new b(this, i62Var), "fetchFavorDataFromServer");
    }

    public final void n(String str) {
        g62.e(vm2.c(str, 1));
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
        qw2.T().u(new el2("favorStatusChange", hashMap));
    }

    public void b(String str, wm2 wm2Var) {
        ku2.t().a();
        if (!xo3.T(R.string.obfuscated_res_0x7f0f14d8) && ku2.t().b()) {
            if (!SwanAppNetworkUtils.h()) {
                if (wm2Var != null) {
                    wm2Var.a();
                }
            } else if (TextUtils.equals(str, cb3.K().q().O()) && cb3.K().q().W().getType() != 0) {
                va3.f(AppRuntime.getAppContext(), R.string.obfuscated_res_0x7f0f14ab).G();
                wm2Var.b(true);
            } else {
                SwanFavorItemData swanFavorItemData = new SwanFavorItemData();
                swanFavorItemData.setAppKey(str);
                swanFavorItemData.setIsNewFavor(1);
                if (bi2.b(swanFavorItemData, 1, wm2Var)) {
                    m(str, true);
                }
                k(str, "add");
            }
        }
    }

    public void c(String str, xm2 xm2Var, xk2.b bVar) {
        if (xo3.T(R.string.obfuscated_res_0x7f0f14d8)) {
            return;
        }
        if (!SwanAppNetworkUtils.h()) {
            if (xm2Var != null) {
                xm2Var.a();
            }
        } else if (TextUtils.equals(str, cb3.K().q().O()) && cb3.K().q().W().getType() != 0) {
            va3.f(AppRuntime.getAppContext(), R.string.obfuscated_res_0x7f0f14ab).G();
            xm2Var.c(true);
        } else {
            if (bi2.g(str, xm2Var, bVar)) {
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
                    swanFavorItemData.setAppType(f32.b(str));
                    swanFavorItemData.setIconUrl(metaItemInfo.icon);
                    swanFavorItemData.setAppName(metaItemInfo.appName);
                    swanFavorItemData.setAppFrameType(metaItemInfo.subCategory);
                    swanFavorItemData.setCreateTime(metaItemInfo.createTime);
                    swanFavorItemData.setPayProtected(metaItemInfo.payProtected);
                    arrayList.add(swanFavorItemData);
                }
            }
            bi2.q(arrayList);
        }
    }

    public final Bundle g(String str, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putString("appKey", str);
        bundle.putBoolean("isFavor", z);
        return bundle;
    }

    public void j(String str, wm2 wm2Var) {
        if (!SwanAppNetworkUtils.h()) {
            if (wm2Var != null) {
                wm2Var.a();
                return;
            }
            return;
        }
        bi2.o(str, 1, wm2Var);
        n(str);
    }

    public final void k(String str, String str2) {
        g62.d(vm2.b(str, str2));
    }

    public void m(String str, boolean z) {
        if (ProcessUtils.isMainProcess()) {
            x73.a(g(str, z), zm2.class);
            return;
        }
        db3 b0 = db3.b0();
        if (b0 == null) {
            return;
        }
        if (TextUtils.equals(b0.getAppId(), "sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u")) {
            x73.c(g(str, z), ym2.class, null);
        } else if (TextUtils.equals(b0.getAppId(), str)) {
            l(z);
        }
    }
}

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
import com.baidu.tieba.aj2;
import com.baidu.tieba.bc3;
import com.baidu.tieba.c92;
import com.baidu.tieba.cc3;
import com.baidu.tieba.dm2;
import com.baidu.tieba.e42;
import com.baidu.tieba.f72;
import com.baidu.tieba.h72;
import com.baidu.tieba.jv2;
import com.baidu.tieba.ms1;
import com.baidu.tieba.px2;
import com.baidu.tieba.qs1;
import com.baidu.tieba.ub3;
import com.baidu.tieba.un2;
import com.baidu.tieba.vn2;
import com.baidu.tieba.w83;
import com.baidu.tieba.wl2;
import com.baidu.tieba.wn2;
import com.baidu.tieba.wo3;
import com.baidu.tieba.wp3;
import com.baidu.tieba.xn2;
import com.baidu.tieba.yn2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes4.dex */
public class SwanFavorDataManager implements qs1 {
    public static final boolean a = ms1.a;

    /* loaded from: classes4.dex */
    public interface c {
        void c();

        void d(List<SwanFavorItemData> list);
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
                    cVar2.c();
                    return;
                }
                return;
            }
            ArrayList arrayList = new ArrayList();
            if (cursor != null && cursor.getCount() > 0 && cursor.moveToFirst()) {
                do {
                    SwanFavorItemData l = aj2.l(cursor);
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
                    cVar.d(arrayList);
                }
            }
        }

        @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
        @NonNull
        public Loader<Cursor> onCreateLoader(int i, @Nullable Bundle bundle) {
            return new CursorLoader(jv2.c(), aj2.e(), null, null, null, "sort_index");
        }

        @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
        public void onLoaderReset(@NonNull Loader<Cursor> loader) {
            c cVar = this.a;
            if (cVar != null) {
                cVar.c();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class a implements h72 {
        public a() {
        }

        @Override // com.baidu.tieba.h72
        public void a(CommonSyncServerData commonSyncServerData) {
            c92.k("SwanFavorDataManager", "fetchFavorDataFromServer onSuccess");
            SwanFavorDataManager.this.f(commonSyncServerData);
        }

        @Override // com.baidu.tieba.h72
        public void onFail() {
            c92.k("SwanFavorDataManager", "fetchFavorDataFromServer onFail");
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public final /* synthetic */ h72 a;

        public b(SwanFavorDataManager swanFavorDataManager, h72 h72Var) {
            this.a = h72Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            f72.b(this.a);
        }
    }

    /* loaded from: classes4.dex */
    public static class d {
        public static final SwanFavorDataManager a = new SwanFavorDataManager(null);
    }

    public SwanFavorDataManager() {
        SwanAppDbControl.f(jv2.c());
        jv2.h0().c(this);
    }

    public static SwanFavorDataManager h() {
        return d.a;
    }

    public void d() {
        e(new a());
    }

    public List<SwanFavorItemData> i() {
        return aj2.j();
    }

    public /* synthetic */ SwanFavorDataManager(a aVar) {
        this();
    }

    @Override // com.baidu.tieba.qs1
    public void a(boolean z) {
        c92.k("SwanFavorDataManager", "onLoginStatusChanged isLoggedIn=" + z);
        d();
    }

    public void e(h72 h72Var) {
        wo3.k(new b(this, h72Var), "fetchFavorDataFromServer");
    }

    public final void n(String str) {
        f72.e(un2.c(str, 1));
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
        px2.T().u(new dm2("favorStatusChange", hashMap));
    }

    public void b(String str, vn2 vn2Var) {
        jv2.t().a();
        if (!wp3.T(R.string.obfuscated_res_0x7f0f14b0) && jv2.t().b()) {
            if (!SwanAppNetworkUtils.h()) {
                if (vn2Var != null) {
                    vn2Var.a();
                }
            } else if (TextUtils.equals(str, bc3.K().q().O()) && bc3.K().q().W().getType() != 0) {
                ub3.f(AppRuntime.getAppContext(), R.string.obfuscated_res_0x7f0f1483).G();
                vn2Var.b(true);
            } else {
                SwanFavorItemData swanFavorItemData = new SwanFavorItemData();
                swanFavorItemData.setAppKey(str);
                swanFavorItemData.setIsNewFavor(1);
                if (aj2.b(swanFavorItemData, 1, vn2Var)) {
                    m(str, true);
                }
                k(str, "add");
            }
        }
    }

    public void c(String str, wn2 wn2Var, wl2.b bVar) {
        if (wp3.T(R.string.obfuscated_res_0x7f0f14b0)) {
            return;
        }
        if (!SwanAppNetworkUtils.h()) {
            if (wn2Var != null) {
                wn2Var.a();
            }
        } else if (TextUtils.equals(str, bc3.K().q().O()) && bc3.K().q().W().getType() != 0) {
            ub3.f(AppRuntime.getAppContext(), R.string.obfuscated_res_0x7f0f1483).G();
            wn2Var.c(true);
        } else {
            if (aj2.g(str, wn2Var, bVar)) {
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
                    swanFavorItemData.setAppType(e42.b(str));
                    swanFavorItemData.setIconUrl(metaItemInfo.icon);
                    swanFavorItemData.setAppName(metaItemInfo.appName);
                    swanFavorItemData.setAppFrameType(metaItemInfo.subCategory);
                    swanFavorItemData.setCreateTime(metaItemInfo.createTime);
                    swanFavorItemData.setPayProtected(metaItemInfo.payProtected);
                    arrayList.add(swanFavorItemData);
                }
            }
            aj2.q(arrayList);
        }
    }

    public final Bundle g(String str, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putString("appKey", str);
        bundle.putBoolean("isFavor", z);
        return bundle;
    }

    public void j(String str, vn2 vn2Var) {
        if (!SwanAppNetworkUtils.h()) {
            if (vn2Var != null) {
                vn2Var.a();
                return;
            }
            return;
        }
        aj2.o(str, 1, vn2Var);
        n(str);
    }

    public final void k(String str, String str2) {
        f72.d(un2.b(str, str2));
    }

    public void m(String str, boolean z) {
        if (ProcessUtils.isMainProcess()) {
            w83.a(g(str, z), yn2.class);
            return;
        }
        cc3 b0 = cc3.b0();
        if (b0 == null) {
            return;
        }
        if (TextUtils.equals(b0.getAppId(), "sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u")) {
            w83.c(g(str, z), xn2.class, null);
        } else if (TextUtils.equals(b0.getAppId(), str)) {
            l(z);
        }
    }
}

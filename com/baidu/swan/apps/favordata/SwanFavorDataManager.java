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
import com.baidu.tieba.a72;
import com.baidu.tieba.cv2;
import com.baidu.tieba.fs1;
import com.baidu.tieba.ix2;
import com.baidu.tieba.js1;
import com.baidu.tieba.nb3;
import com.baidu.tieba.nn2;
import com.baidu.tieba.on2;
import com.baidu.tieba.p83;
import com.baidu.tieba.pl2;
import com.baidu.tieba.pn2;
import com.baidu.tieba.po3;
import com.baidu.tieba.pp3;
import com.baidu.tieba.qn2;
import com.baidu.tieba.rn2;
import com.baidu.tieba.ti2;
import com.baidu.tieba.ub3;
import com.baidu.tieba.v82;
import com.baidu.tieba.vb3;
import com.baidu.tieba.wl2;
import com.baidu.tieba.x32;
import com.baidu.tieba.y62;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes4.dex */
public class SwanFavorDataManager implements js1 {
    public static final boolean a = fs1.a;

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
                    SwanFavorItemData l = ti2.l(cursor);
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
            return new CursorLoader(cv2.c(), ti2.e(), null, null, null, "sort_index");
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
    public class a implements a72 {
        public a() {
        }

        @Override // com.baidu.tieba.a72
        public void a(CommonSyncServerData commonSyncServerData) {
            v82.k("SwanFavorDataManager", "fetchFavorDataFromServer onSuccess");
            SwanFavorDataManager.this.f(commonSyncServerData);
        }

        @Override // com.baidu.tieba.a72
        public void onFail() {
            v82.k("SwanFavorDataManager", "fetchFavorDataFromServer onFail");
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public final /* synthetic */ a72 a;

        public b(SwanFavorDataManager swanFavorDataManager, a72 a72Var) {
            this.a = a72Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            y62.b(this.a);
        }
    }

    /* loaded from: classes4.dex */
    public static class d {
        public static final SwanFavorDataManager a = new SwanFavorDataManager(null);
    }

    public SwanFavorDataManager() {
        SwanAppDbControl.f(cv2.c());
        cv2.h0().c(this);
    }

    public static SwanFavorDataManager h() {
        return d.a;
    }

    public void d() {
        e(new a());
    }

    public List<SwanFavorItemData> i() {
        return ti2.j();
    }

    public /* synthetic */ SwanFavorDataManager(a aVar) {
        this();
    }

    @Override // com.baidu.tieba.js1
    public void a(boolean z) {
        v82.k("SwanFavorDataManager", "onLoginStatusChanged isLoggedIn=" + z);
        d();
    }

    public void e(a72 a72Var) {
        po3.k(new b(this, a72Var), "fetchFavorDataFromServer");
    }

    public final void n(String str) {
        y62.e(nn2.c(str, 1));
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
        ix2.T().u(new wl2("favorStatusChange", hashMap));
    }

    public void b(String str, on2 on2Var) {
        cv2.t().a();
        if (!pp3.T(R.string.obfuscated_res_0x7f0f14c6) && cv2.t().b()) {
            if (!SwanAppNetworkUtils.h()) {
                if (on2Var != null) {
                    on2Var.a();
                }
            } else if (TextUtils.equals(str, ub3.K().q().O()) && ub3.K().q().W().getType() != 0) {
                nb3.f(AppRuntime.getAppContext(), R.string.obfuscated_res_0x7f0f1499).G();
                on2Var.b(true);
            } else {
                SwanFavorItemData swanFavorItemData = new SwanFavorItemData();
                swanFavorItemData.setAppKey(str);
                swanFavorItemData.setIsNewFavor(1);
                if (ti2.b(swanFavorItemData, 1, on2Var)) {
                    m(str, true);
                }
                k(str, "add");
            }
        }
    }

    public void c(String str, pn2 pn2Var, pl2.b bVar) {
        if (pp3.T(R.string.obfuscated_res_0x7f0f14c6)) {
            return;
        }
        if (!SwanAppNetworkUtils.h()) {
            if (pn2Var != null) {
                pn2Var.a();
            }
        } else if (TextUtils.equals(str, ub3.K().q().O()) && ub3.K().q().W().getType() != 0) {
            nb3.f(AppRuntime.getAppContext(), R.string.obfuscated_res_0x7f0f1499).G();
            pn2Var.c(true);
        } else {
            if (ti2.g(str, pn2Var, bVar)) {
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
                    swanFavorItemData.setAppType(x32.b(str));
                    swanFavorItemData.setIconUrl(metaItemInfo.icon);
                    swanFavorItemData.setAppName(metaItemInfo.appName);
                    swanFavorItemData.setAppFrameType(metaItemInfo.subCategory);
                    swanFavorItemData.setCreateTime(metaItemInfo.createTime);
                    swanFavorItemData.setPayProtected(metaItemInfo.payProtected);
                    arrayList.add(swanFavorItemData);
                }
            }
            ti2.q(arrayList);
        }
    }

    public final Bundle g(String str, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putString("appKey", str);
        bundle.putBoolean("isFavor", z);
        return bundle;
    }

    public void j(String str, on2 on2Var) {
        if (!SwanAppNetworkUtils.h()) {
            if (on2Var != null) {
                on2Var.a();
                return;
            }
            return;
        }
        ti2.o(str, 1, on2Var);
        n(str);
    }

    public final void k(String str, String str2) {
        y62.d(nn2.b(str, str2));
    }

    public void m(String str, boolean z) {
        if (ProcessUtils.isMainProcess()) {
            p83.a(g(str, z), rn2.class);
            return;
        }
        vb3 b0 = vb3.b0();
        if (b0 == null) {
            return;
        }
        if (TextUtils.equals(b0.getAppId(), "sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u")) {
            p83.c(g(str, z), qn2.class, null);
        } else if (TextUtils.equals(b0.getAppId(), str)) {
            l(z);
        }
    }
}

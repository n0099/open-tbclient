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
import com.baidu.tieba.a63;
import com.baidu.tieba.aj2;
import com.baidu.tieba.al2;
import com.baidu.tieba.am3;
import com.baidu.tieba.an3;
import com.baidu.tieba.bl2;
import com.baidu.tieba.cl2;
import com.baidu.tieba.eg2;
import com.baidu.tieba.f93;
import com.baidu.tieba.g62;
import com.baidu.tieba.g93;
import com.baidu.tieba.hj2;
import com.baidu.tieba.i12;
import com.baidu.tieba.j42;
import com.baidu.tieba.l42;
import com.baidu.tieba.ns2;
import com.baidu.tieba.qp1;
import com.baidu.tieba.tu2;
import com.baidu.tieba.up1;
import com.baidu.tieba.y83;
import com.baidu.tieba.yk2;
import com.baidu.tieba.zk2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes4.dex */
public class SwanFavorDataManager implements up1 {
    public static final boolean a = qp1.a;

    /* loaded from: classes4.dex */
    public interface c {
        void onLoadFail();

        void onLoadSuccess(List<SwanFavorItemData> list);
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
                    cVar2.onLoadFail();
                    return;
                }
                return;
            }
            ArrayList arrayList = new ArrayList();
            if (cursor != null && cursor.getCount() > 0 && cursor.moveToFirst()) {
                do {
                    SwanFavorItemData l = eg2.l(cursor);
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
            return new CursorLoader(ns2.c(), eg2.e(), null, null, null, "sort_index");
        }

        @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
        public void onLoaderReset(@NonNull Loader<Cursor> loader) {
            c cVar = this.a;
            if (cVar != null) {
                cVar.onLoadFail();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class a implements l42 {
        public a() {
        }

        @Override // com.baidu.tieba.l42
        public void a(CommonSyncServerData commonSyncServerData) {
            g62.k("SwanFavorDataManager", "fetchFavorDataFromServer onSuccess");
            SwanFavorDataManager.this.f(commonSyncServerData);
        }

        @Override // com.baidu.tieba.l42
        public void onFail() {
            g62.k("SwanFavorDataManager", "fetchFavorDataFromServer onFail");
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public final /* synthetic */ l42 a;

        public b(SwanFavorDataManager swanFavorDataManager, l42 l42Var) {
            this.a = l42Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            j42.b(this.a);
        }
    }

    /* loaded from: classes4.dex */
    public static class d {
        public static final SwanFavorDataManager a = new SwanFavorDataManager(null);
    }

    public SwanFavorDataManager() {
        SwanAppDbControl.f(ns2.c());
        ns2.h0().c(this);
    }

    public static SwanFavorDataManager h() {
        return d.a;
    }

    public void d() {
        e(new a());
    }

    public List<SwanFavorItemData> i() {
        return eg2.j();
    }

    public /* synthetic */ SwanFavorDataManager(a aVar) {
        this();
    }

    @Override // com.baidu.tieba.up1
    public void a(boolean z) {
        g62.k("SwanFavorDataManager", "onLoginStatusChanged isLoggedIn=" + z);
        d();
    }

    public void e(l42 l42Var) {
        am3.k(new b(this, l42Var), "fetchFavorDataFromServer");
    }

    public final void n(String str) {
        j42.e(yk2.c(str, 1));
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
        tu2.U().u(new hj2("favorStatusChange", hashMap));
    }

    public void b(String str, zk2 zk2Var) {
        ns2.t().a();
        if (!an3.T(R.string.obfuscated_res_0x7f0f143d) && ns2.t().b()) {
            if (!SwanAppNetworkUtils.h()) {
                if (zk2Var != null) {
                    zk2Var.a();
                }
            } else if (TextUtils.equals(str, f93.K().q().O()) && f93.K().q().W().getType() != 0) {
                y83.f(AppRuntime.getAppContext(), R.string.obfuscated_res_0x7f0f1410).G();
                zk2Var.b(true);
            } else {
                SwanFavorItemData swanFavorItemData = new SwanFavorItemData();
                swanFavorItemData.setAppKey(str);
                swanFavorItemData.setIsNewFavor(1);
                if (eg2.b(swanFavorItemData, 1, zk2Var)) {
                    m(str, true);
                }
                k(str, "add");
            }
        }
    }

    public void c(String str, al2 al2Var, aj2.b bVar) {
        if (an3.T(R.string.obfuscated_res_0x7f0f143d)) {
            return;
        }
        if (!SwanAppNetworkUtils.h()) {
            if (al2Var != null) {
                al2Var.a();
            }
        } else if (TextUtils.equals(str, f93.K().q().O()) && f93.K().q().W().getType() != 0) {
            y83.f(AppRuntime.getAppContext(), R.string.obfuscated_res_0x7f0f1410).G();
            al2Var.c(true);
        } else {
            if (eg2.g(str, al2Var, bVar)) {
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
                    swanFavorItemData.setAppType(i12.b(str));
                    swanFavorItemData.setIconUrl(metaItemInfo.icon);
                    swanFavorItemData.setAppName(metaItemInfo.appName);
                    swanFavorItemData.setAppFrameType(metaItemInfo.subCategory);
                    swanFavorItemData.setCreateTime(metaItemInfo.createTime);
                    swanFavorItemData.setPayProtected(metaItemInfo.payProtected);
                    arrayList.add(swanFavorItemData);
                }
            }
            eg2.q(arrayList);
        }
    }

    public final Bundle g(String str, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putString("appKey", str);
        bundle.putBoolean("isFavor", z);
        return bundle;
    }

    public void j(String str, zk2 zk2Var) {
        if (!SwanAppNetworkUtils.h()) {
            if (zk2Var != null) {
                zk2Var.a();
                return;
            }
            return;
        }
        eg2.o(str, 1, zk2Var);
        n(str);
    }

    public final void k(String str, String str2) {
        j42.d(yk2.b(str, str2));
    }

    public void m(String str, boolean z) {
        if (ProcessUtils.isMainProcess()) {
            a63.a(g(str, z), cl2.class);
            return;
        }
        g93 b0 = g93.b0();
        if (b0 == null) {
            return;
        }
        if (TextUtils.equals(b0.getAppId(), "sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u")) {
            a63.c(g(str, z), bl2.class, null);
        } else if (TextUtils.equals(b0.getAppId(), str)) {
            l(z);
        }
    }
}

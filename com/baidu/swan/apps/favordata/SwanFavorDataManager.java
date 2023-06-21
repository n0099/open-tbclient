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
import com.baidu.tieba.am2;
import com.baidu.tieba.b42;
import com.baidu.tieba.c72;
import com.baidu.tieba.e72;
import com.baidu.tieba.gv2;
import com.baidu.tieba.js1;
import com.baidu.tieba.mx2;
import com.baidu.tieba.ns1;
import com.baidu.tieba.rb3;
import com.baidu.tieba.rn2;
import com.baidu.tieba.sn2;
import com.baidu.tieba.t83;
import com.baidu.tieba.tl2;
import com.baidu.tieba.tn2;
import com.baidu.tieba.to3;
import com.baidu.tieba.tp3;
import com.baidu.tieba.un2;
import com.baidu.tieba.vn2;
import com.baidu.tieba.xi2;
import com.baidu.tieba.yb3;
import com.baidu.tieba.z82;
import com.baidu.tieba.zb3;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes4.dex */
public class SwanFavorDataManager implements ns1 {
    public static final boolean a = js1.a;

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
                    SwanFavorItemData l = xi2.l(cursor);
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
            return new CursorLoader(gv2.c(), xi2.e(), null, null, null, "sort_index");
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
    public class a implements e72 {
        public a() {
        }

        @Override // com.baidu.tieba.e72
        public void a(CommonSyncServerData commonSyncServerData) {
            z82.k("SwanFavorDataManager", "fetchFavorDataFromServer onSuccess");
            SwanFavorDataManager.this.f(commonSyncServerData);
        }

        @Override // com.baidu.tieba.e72
        public void onFail() {
            z82.k("SwanFavorDataManager", "fetchFavorDataFromServer onFail");
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public final /* synthetic */ e72 a;

        public b(SwanFavorDataManager swanFavorDataManager, e72 e72Var) {
            this.a = e72Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            c72.b(this.a);
        }
    }

    /* loaded from: classes4.dex */
    public static class d {
        public static final SwanFavorDataManager a = new SwanFavorDataManager(null);
    }

    public SwanFavorDataManager() {
        SwanAppDbControl.f(gv2.c());
        gv2.h0().c(this);
    }

    public static SwanFavorDataManager h() {
        return d.a;
    }

    public void d() {
        e(new a());
    }

    public List<SwanFavorItemData> i() {
        return xi2.j();
    }

    public /* synthetic */ SwanFavorDataManager(a aVar) {
        this();
    }

    @Override // com.baidu.tieba.ns1
    public void a(boolean z) {
        z82.k("SwanFavorDataManager", "onLoginStatusChanged isLoggedIn=" + z);
        d();
    }

    public void e(e72 e72Var) {
        to3.k(new b(this, e72Var), "fetchFavorDataFromServer");
    }

    public final void n(String str) {
        c72.e(rn2.c(str, 1));
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
        mx2.T().u(new am2("favorStatusChange", hashMap));
    }

    public void b(String str, sn2 sn2Var) {
        gv2.t().a();
        if (!tp3.T(R.string.obfuscated_res_0x7f0f1493) && gv2.t().b()) {
            if (!SwanAppNetworkUtils.h()) {
                if (sn2Var != null) {
                    sn2Var.a();
                }
            } else if (TextUtils.equals(str, yb3.K().q().O()) && yb3.K().q().W().getType() != 0) {
                rb3.f(AppRuntime.getAppContext(), R.string.obfuscated_res_0x7f0f1466).G();
                sn2Var.b(true);
            } else {
                SwanFavorItemData swanFavorItemData = new SwanFavorItemData();
                swanFavorItemData.setAppKey(str);
                swanFavorItemData.setIsNewFavor(1);
                if (xi2.b(swanFavorItemData, 1, sn2Var)) {
                    m(str, true);
                }
                k(str, "add");
            }
        }
    }

    public void c(String str, tn2 tn2Var, tl2.b bVar) {
        if (tp3.T(R.string.obfuscated_res_0x7f0f1493)) {
            return;
        }
        if (!SwanAppNetworkUtils.h()) {
            if (tn2Var != null) {
                tn2Var.a();
            }
        } else if (TextUtils.equals(str, yb3.K().q().O()) && yb3.K().q().W().getType() != 0) {
            rb3.f(AppRuntime.getAppContext(), R.string.obfuscated_res_0x7f0f1466).G();
            tn2Var.c(true);
        } else {
            if (xi2.g(str, tn2Var, bVar)) {
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
                    swanFavorItemData.setAppType(b42.b(str));
                    swanFavorItemData.setIconUrl(metaItemInfo.icon);
                    swanFavorItemData.setAppName(metaItemInfo.appName);
                    swanFavorItemData.setAppFrameType(metaItemInfo.subCategory);
                    swanFavorItemData.setCreateTime(metaItemInfo.createTime);
                    swanFavorItemData.setPayProtected(metaItemInfo.payProtected);
                    arrayList.add(swanFavorItemData);
                }
            }
            xi2.q(arrayList);
        }
    }

    public final Bundle g(String str, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putString("appKey", str);
        bundle.putBoolean("isFavor", z);
        return bundle;
    }

    public void j(String str, sn2 sn2Var) {
        if (!SwanAppNetworkUtils.h()) {
            if (sn2Var != null) {
                sn2Var.a();
                return;
            }
            return;
        }
        xi2.o(str, 1, sn2Var);
        n(str);
    }

    public final void k(String str, String str2) {
        c72.d(rn2.b(str, str2));
    }

    public void m(String str, boolean z) {
        if (ProcessUtils.isMainProcess()) {
            t83.a(g(str, z), vn2.class);
            return;
        }
        zb3 b0 = zb3.b0();
        if (b0 == null) {
            return;
        }
        if (TextUtils.equals(b0.getAppId(), "sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u")) {
            t83.c(g(str, z), un2.class, null);
        } else if (TextUtils.equals(b0.getAppId(), str)) {
            l(z);
        }
    }
}

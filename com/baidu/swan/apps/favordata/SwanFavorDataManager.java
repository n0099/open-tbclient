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
import com.baidu.tieba.br2;
import com.baidu.tieba.eo1;
import com.baidu.tieba.ht2;
import com.baidu.tieba.io1;
import com.baidu.tieba.m73;
import com.baidu.tieba.mj2;
import com.baidu.tieba.nj2;
import com.baidu.tieba.o43;
import com.baidu.tieba.oh2;
import com.baidu.tieba.oj2;
import com.baidu.tieba.ok3;
import com.baidu.tieba.ol3;
import com.baidu.tieba.pj2;
import com.baidu.tieba.qj2;
import com.baidu.tieba.se2;
import com.baidu.tieba.t73;
import com.baidu.tieba.u42;
import com.baidu.tieba.u73;
import com.baidu.tieba.vh2;
import com.baidu.tieba.wz1;
import com.baidu.tieba.x22;
import com.baidu.tieba.z22;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes3.dex */
public class SwanFavorDataManager implements io1 {
    public static final boolean a = eo1.a;

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
                    SwanFavorItemData l = se2.l(cursor);
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
            return new CursorLoader(br2.c(), se2.e(), null, null, null, "sort_index");
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
    public class a implements z22 {
        public a() {
        }

        @Override // com.baidu.tieba.z22
        public void a(CommonSyncServerData commonSyncServerData) {
            u42.k("SwanFavorDataManager", "fetchFavorDataFromServer onSuccess");
            SwanFavorDataManager.this.f(commonSyncServerData);
        }

        @Override // com.baidu.tieba.z22
        public void onFail() {
            u42.k("SwanFavorDataManager", "fetchFavorDataFromServer onFail");
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public final /* synthetic */ z22 a;

        public b(SwanFavorDataManager swanFavorDataManager, z22 z22Var) {
            this.a = z22Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            x22.b(this.a);
        }
    }

    /* loaded from: classes3.dex */
    public static class d {
        public static final SwanFavorDataManager a = new SwanFavorDataManager(null);
    }

    public SwanFavorDataManager() {
        SwanAppDbControl.f(br2.c());
        br2.h0().c(this);
    }

    public static SwanFavorDataManager h() {
        return d.a;
    }

    public void d() {
        e(new a());
    }

    public List<SwanFavorItemData> i() {
        return se2.j();
    }

    public /* synthetic */ SwanFavorDataManager(a aVar) {
        this();
    }

    @Override // com.baidu.tieba.io1
    public void a(boolean z) {
        u42.k("SwanFavorDataManager", "onLoginStatusChanged isLoggedIn=" + z);
        d();
    }

    public void e(z22 z22Var) {
        ok3.k(new b(this, z22Var), "fetchFavorDataFromServer");
    }

    public final void n(String str) {
        x22.e(mj2.c(str, 1));
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
        ht2.U().u(new vh2("favorStatusChange", hashMap));
    }

    public void b(String str, nj2 nj2Var) {
        br2.t().a();
        if (!ol3.T(R.string.obfuscated_res_0x7f0f1352) && br2.t().b()) {
            if (!SwanAppNetworkUtils.h()) {
                if (nj2Var != null) {
                    nj2Var.a();
                }
            } else if (TextUtils.equals(str, t73.K().q().O()) && t73.K().q().W().getType() != 0) {
                m73.f(AppRuntime.getAppContext(), R.string.obfuscated_res_0x7f0f1325).G();
                nj2Var.b(true);
            } else {
                SwanFavorItemData swanFavorItemData = new SwanFavorItemData();
                swanFavorItemData.setAppKey(str);
                swanFavorItemData.setIsNewFavor(1);
                if (se2.b(swanFavorItemData, 1, nj2Var)) {
                    m(str, true);
                }
                k(str, "add");
            }
        }
    }

    public void c(String str, oj2 oj2Var, oh2.b bVar) {
        if (ol3.T(R.string.obfuscated_res_0x7f0f1352)) {
            return;
        }
        if (!SwanAppNetworkUtils.h()) {
            if (oj2Var != null) {
                oj2Var.a();
            }
        } else if (TextUtils.equals(str, t73.K().q().O()) && t73.K().q().W().getType() != 0) {
            m73.f(AppRuntime.getAppContext(), R.string.obfuscated_res_0x7f0f1325).G();
            oj2Var.c(true);
        } else {
            if (se2.g(str, oj2Var, bVar)) {
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
                    swanFavorItemData.setAppType(wz1.b(str));
                    swanFavorItemData.setIconUrl(metaItemInfo.icon);
                    swanFavorItemData.setAppName(metaItemInfo.appName);
                    swanFavorItemData.setAppFrameType(metaItemInfo.subCategory);
                    swanFavorItemData.setCreateTime(metaItemInfo.createTime);
                    swanFavorItemData.setPayProtected(metaItemInfo.payProtected);
                    arrayList.add(swanFavorItemData);
                }
            }
            se2.q(arrayList);
        }
    }

    public final Bundle g(String str, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putString("appKey", str);
        bundle.putBoolean("isFavor", z);
        return bundle;
    }

    public void j(String str, nj2 nj2Var) {
        if (!SwanAppNetworkUtils.h()) {
            if (nj2Var != null) {
                nj2Var.a();
                return;
            }
            return;
        }
        se2.o(str, 1, nj2Var);
        n(str);
    }

    public final void k(String str, String str2) {
        x22.d(mj2.b(str, str2));
    }

    public void m(String str, boolean z) {
        if (ProcessUtils.isMainProcess()) {
            o43.a(g(str, z), qj2.class);
            return;
        }
        u73 b0 = u73.b0();
        if (b0 == null) {
            return;
        }
        if (TextUtils.equals(b0.getAppId(), "sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u")) {
            o43.c(g(str, z), pj2.class, null);
        } else if (TextUtils.equals(b0.getAppId(), str)) {
            l(z);
        }
    }
}

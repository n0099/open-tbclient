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
import com.baidu.tieba.aq1;
import com.baidu.tieba.e93;
import com.baidu.tieba.el2;
import com.baidu.tieba.fl2;
import com.baidu.tieba.g63;
import com.baidu.tieba.gj2;
import com.baidu.tieba.gl2;
import com.baidu.tieba.gm3;
import com.baidu.tieba.gn3;
import com.baidu.tieba.hl2;
import com.baidu.tieba.il2;
import com.baidu.tieba.kg2;
import com.baidu.tieba.l93;
import com.baidu.tieba.m62;
import com.baidu.tieba.m93;
import com.baidu.tieba.nj2;
import com.baidu.tieba.o12;
import com.baidu.tieba.p42;
import com.baidu.tieba.r42;
import com.baidu.tieba.ts2;
import com.baidu.tieba.wp1;
import com.baidu.tieba.zu2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes3.dex */
public class SwanFavorDataManager implements aq1 {
    public static final boolean a = wp1.a;

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
                    SwanFavorItemData l = kg2.l(cursor);
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
            return new CursorLoader(ts2.c(), kg2.e(), null, null, null, "sort_index");
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
    public class a implements r42 {
        public a() {
        }

        @Override // com.baidu.tieba.r42
        public void a(CommonSyncServerData commonSyncServerData) {
            m62.k("SwanFavorDataManager", "fetchFavorDataFromServer onSuccess");
            SwanFavorDataManager.this.f(commonSyncServerData);
        }

        @Override // com.baidu.tieba.r42
        public void onFail() {
            m62.k("SwanFavorDataManager", "fetchFavorDataFromServer onFail");
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public final /* synthetic */ r42 a;

        public b(SwanFavorDataManager swanFavorDataManager, r42 r42Var) {
            this.a = r42Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            p42.b(this.a);
        }
    }

    /* loaded from: classes3.dex */
    public static class d {
        public static final SwanFavorDataManager a = new SwanFavorDataManager(null);
    }

    public SwanFavorDataManager() {
        SwanAppDbControl.f(ts2.c());
        ts2.h0().c(this);
    }

    public static SwanFavorDataManager h() {
        return d.a;
    }

    public void d() {
        e(new a());
    }

    public List<SwanFavorItemData> i() {
        return kg2.j();
    }

    public /* synthetic */ SwanFavorDataManager(a aVar) {
        this();
    }

    @Override // com.baidu.tieba.aq1
    public void a(boolean z) {
        m62.k("SwanFavorDataManager", "onLoginStatusChanged isLoggedIn=" + z);
        d();
    }

    public void e(r42 r42Var) {
        gm3.k(new b(this, r42Var), "fetchFavorDataFromServer");
    }

    public final void n(String str) {
        p42.e(el2.c(str, 1));
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
        zu2.U().u(new nj2("favorStatusChange", hashMap));
    }

    public void b(String str, fl2 fl2Var) {
        ts2.t().a();
        if (!gn3.T(R.string.obfuscated_res_0x7f0f1347) && ts2.t().b()) {
            if (!SwanAppNetworkUtils.h()) {
                if (fl2Var != null) {
                    fl2Var.a();
                }
            } else if (TextUtils.equals(str, l93.K().q().O()) && l93.K().q().W().getType() != 0) {
                e93.f(AppRuntime.getAppContext(), R.string.obfuscated_res_0x7f0f131a).G();
                fl2Var.b(true);
            } else {
                SwanFavorItemData swanFavorItemData = new SwanFavorItemData();
                swanFavorItemData.setAppKey(str);
                swanFavorItemData.setIsNewFavor(1);
                if (kg2.b(swanFavorItemData, 1, fl2Var)) {
                    m(str, true);
                }
                k(str, "add");
            }
        }
    }

    public void c(String str, gl2 gl2Var, gj2.b bVar) {
        if (gn3.T(R.string.obfuscated_res_0x7f0f1347)) {
            return;
        }
        if (!SwanAppNetworkUtils.h()) {
            if (gl2Var != null) {
                gl2Var.a();
            }
        } else if (TextUtils.equals(str, l93.K().q().O()) && l93.K().q().W().getType() != 0) {
            e93.f(AppRuntime.getAppContext(), R.string.obfuscated_res_0x7f0f131a).G();
            gl2Var.c(true);
        } else {
            if (kg2.g(str, gl2Var, bVar)) {
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
                    swanFavorItemData.setAppType(o12.b(str));
                    swanFavorItemData.setIconUrl(metaItemInfo.icon);
                    swanFavorItemData.setAppName(metaItemInfo.appName);
                    swanFavorItemData.setAppFrameType(metaItemInfo.subCategory);
                    swanFavorItemData.setCreateTime(metaItemInfo.createTime);
                    swanFavorItemData.setPayProtected(metaItemInfo.payProtected);
                    arrayList.add(swanFavorItemData);
                }
            }
            kg2.q(arrayList);
        }
    }

    public final Bundle g(String str, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putString("appKey", str);
        bundle.putBoolean("isFavor", z);
        return bundle;
    }

    public void j(String str, fl2 fl2Var) {
        if (!SwanAppNetworkUtils.h()) {
            if (fl2Var != null) {
                fl2Var.a();
                return;
            }
            return;
        }
        kg2.o(str, 1, fl2Var);
        n(str);
    }

    public final void k(String str, String str2) {
        p42.d(el2.b(str, str2));
    }

    public void m(String str, boolean z) {
        if (ProcessUtils.isMainProcess()) {
            g63.a(g(str, z), il2.class);
            return;
        }
        m93 b0 = m93.b0();
        if (b0 == null) {
            return;
        }
        if (TextUtils.equals(b0.getAppId(), "sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u")) {
            g63.c(g(str, z), hl2.class, null);
        } else if (TextUtils.equals(b0.getAppId(), str)) {
            l(z);
        }
    }
}

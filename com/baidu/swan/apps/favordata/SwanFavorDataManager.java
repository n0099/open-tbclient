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
import com.baidu.tieba.ai2;
import com.baidu.tieba.b33;
import com.baidu.tieba.bg2;
import com.baidu.tieba.bi2;
import com.baidu.tieba.bj3;
import com.baidu.tieba.bk3;
import com.baidu.tieba.ci2;
import com.baidu.tieba.di2;
import com.baidu.tieba.fd2;
import com.baidu.tieba.g63;
import com.baidu.tieba.h32;
import com.baidu.tieba.h63;
import com.baidu.tieba.ig2;
import com.baidu.tieba.ky1;
import com.baidu.tieba.l12;
import com.baidu.tieba.n12;
import com.baidu.tieba.op2;
import com.baidu.tieba.sm1;
import com.baidu.tieba.ur2;
import com.baidu.tieba.wm1;
import com.baidu.tieba.z53;
import com.baidu.tieba.zh2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes4.dex */
public class SwanFavorDataManager implements wm1 {
    public static final boolean a = sm1.a;

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
                    SwanFavorItemData l = fd2.l(cursor);
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
            return new CursorLoader(op2.c(), fd2.e(), null, null, null, "sort_index");
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
    public class a implements n12 {
        public a() {
        }

        @Override // com.baidu.tieba.n12
        public void a(CommonSyncServerData commonSyncServerData) {
            h32.k("SwanFavorDataManager", "fetchFavorDataFromServer onSuccess");
            SwanFavorDataManager.this.f(commonSyncServerData);
        }

        @Override // com.baidu.tieba.n12
        public void onFail() {
            h32.k("SwanFavorDataManager", "fetchFavorDataFromServer onFail");
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public final /* synthetic */ n12 a;

        public b(SwanFavorDataManager swanFavorDataManager, n12 n12Var) {
            this.a = n12Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            l12.b(this.a);
        }
    }

    /* loaded from: classes4.dex */
    public static class d {
        public static final SwanFavorDataManager a = new SwanFavorDataManager(null);
    }

    public SwanFavorDataManager() {
        SwanAppDbControl.f(op2.c());
        op2.h0().c(this);
    }

    public static SwanFavorDataManager h() {
        return d.a;
    }

    public void d() {
        e(new a());
    }

    public List<SwanFavorItemData> i() {
        return fd2.j();
    }

    public /* synthetic */ SwanFavorDataManager(a aVar) {
        this();
    }

    @Override // com.baidu.tieba.wm1
    public void a(boolean z) {
        h32.k("SwanFavorDataManager", "onLoginStatusChanged isLoggedIn=" + z);
        d();
    }

    public void e(n12 n12Var) {
        bj3.k(new b(this, n12Var), "fetchFavorDataFromServer");
    }

    public final void n(String str) {
        l12.e(zh2.c(str, 1));
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
        ur2.V().v(new ig2("favorStatusChange", hashMap));
    }

    public void b(String str, ai2 ai2Var) {
        op2.t().a();
        if (!bk3.T(R.string.obfuscated_res_0x7f0f152c) && op2.t().b()) {
            if (!SwanAppNetworkUtils.h()) {
                if (ai2Var != null) {
                    ai2Var.a();
                }
            } else if (TextUtils.equals(str, g63.K().q().P()) && g63.K().q().X().w1() != 0) {
                z53.f(AppRuntime.getAppContext(), R.string.obfuscated_res_0x7f0f14ff).G();
                ai2Var.b(true);
            } else {
                SwanFavorItemData swanFavorItemData = new SwanFavorItemData();
                swanFavorItemData.setAppKey(str);
                swanFavorItemData.setIsNewFavor(1);
                if (fd2.b(swanFavorItemData, 1, ai2Var)) {
                    m(str, true);
                }
                k(str, "add");
            }
        }
    }

    public void c(String str, bi2 bi2Var, bg2.b bVar) {
        if (bk3.T(R.string.obfuscated_res_0x7f0f152c)) {
            return;
        }
        if (!SwanAppNetworkUtils.h()) {
            if (bi2Var != null) {
                bi2Var.a();
            }
        } else if (TextUtils.equals(str, g63.K().q().P()) && g63.K().q().X().w1() != 0) {
            z53.f(AppRuntime.getAppContext(), R.string.obfuscated_res_0x7f0f14ff).G();
            bi2Var.c(true);
        } else {
            if (fd2.g(str, bi2Var, bVar)) {
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
                    swanFavorItemData.setAppType(ky1.b(str));
                    swanFavorItemData.setIconUrl(metaItemInfo.icon);
                    swanFavorItemData.setAppName(metaItemInfo.appName);
                    swanFavorItemData.setAppFrameType(metaItemInfo.subCategory);
                    swanFavorItemData.setCreateTime(metaItemInfo.createTime);
                    swanFavorItemData.setPayProtected(metaItemInfo.payProtected);
                    arrayList.add(swanFavorItemData);
                }
            }
            fd2.q(arrayList);
        }
    }

    public final Bundle g(String str, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putString("appKey", str);
        bundle.putBoolean("isFavor", z);
        return bundle;
    }

    public void j(String str, ai2 ai2Var) {
        if (!SwanAppNetworkUtils.h()) {
            if (ai2Var != null) {
                ai2Var.a();
                return;
            }
            return;
        }
        fd2.o(str, 1, ai2Var);
        n(str);
    }

    public final void k(String str, String str2) {
        l12.d(zh2.b(str, str2));
    }

    public void m(String str, boolean z) {
        if (ProcessUtils.isMainProcess()) {
            b33.a(g(str, z), di2.class);
            return;
        }
        h63 c0 = h63.c0();
        if (c0 == null) {
            return;
        }
        if (TextUtils.equals(c0.getAppId(), "sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u")) {
            b33.c(g(str, z), ci2.class, null);
        } else if (TextUtils.equals(c0.getAppId(), str)) {
            l(z);
        }
    }
}

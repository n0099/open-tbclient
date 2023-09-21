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
import com.baidu.tieba.a83;
import com.baidu.tieba.al2;
import com.baidu.tieba.an2;
import com.baidu.tieba.ao3;
import com.baidu.tieba.ap3;
import com.baidu.tieba.bn2;
import com.baidu.tieba.cn2;
import com.baidu.tieba.ei2;
import com.baidu.tieba.fb3;
import com.baidu.tieba.g82;
import com.baidu.tieba.gb3;
import com.baidu.tieba.hl2;
import com.baidu.tieba.i32;
import com.baidu.tieba.j62;
import com.baidu.tieba.l62;
import com.baidu.tieba.nu2;
import com.baidu.tieba.qr1;
import com.baidu.tieba.tw2;
import com.baidu.tieba.ur1;
import com.baidu.tieba.ya3;
import com.baidu.tieba.ym2;
import com.baidu.tieba.zm2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes4.dex */
public class SwanFavorDataManager implements ur1 {
    public static final boolean a = qr1.a;

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
                    SwanFavorItemData l = ei2.l(cursor);
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
            return new CursorLoader(nu2.c(), ei2.e(), null, null, null, "sort_index");
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
    public class a implements l62 {
        public a() {
        }

        @Override // com.baidu.tieba.l62
        public void a(CommonSyncServerData commonSyncServerData) {
            g82.k("SwanFavorDataManager", "fetchFavorDataFromServer onSuccess");
            SwanFavorDataManager.this.f(commonSyncServerData);
        }

        @Override // com.baidu.tieba.l62
        public void onFail() {
            g82.k("SwanFavorDataManager", "fetchFavorDataFromServer onFail");
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public final /* synthetic */ l62 a;

        public b(SwanFavorDataManager swanFavorDataManager, l62 l62Var) {
            this.a = l62Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            j62.b(this.a);
        }
    }

    /* loaded from: classes4.dex */
    public static class d {
        public static final SwanFavorDataManager a = new SwanFavorDataManager(null);
    }

    public SwanFavorDataManager() {
        SwanAppDbControl.f(nu2.c());
        nu2.h0().c(this);
    }

    public static SwanFavorDataManager h() {
        return d.a;
    }

    public void d() {
        e(new a());
    }

    public List<SwanFavorItemData> i() {
        return ei2.j();
    }

    public /* synthetic */ SwanFavorDataManager(a aVar) {
        this();
    }

    @Override // com.baidu.tieba.ur1
    public void a(boolean z) {
        g82.k("SwanFavorDataManager", "onLoginStatusChanged isLoggedIn=" + z);
        d();
    }

    public void e(l62 l62Var) {
        ao3.k(new b(this, l62Var), "fetchFavorDataFromServer");
    }

    public final void n(String str) {
        j62.e(ym2.c(str, 1));
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
        tw2.T().u(new hl2("favorStatusChange", hashMap));
    }

    public void b(String str, zm2 zm2Var) {
        nu2.t().a();
        if (!ap3.T(R.string.obfuscated_res_0x7f0f14f4) && nu2.t().b()) {
            if (!SwanAppNetworkUtils.h()) {
                if (zm2Var != null) {
                    zm2Var.a();
                }
            } else if (TextUtils.equals(str, fb3.K().q().O()) && fb3.K().q().W().getType() != 0) {
                ya3.f(AppRuntime.getAppContext(), R.string.obfuscated_res_0x7f0f14c7).G();
                zm2Var.b(true);
            } else {
                SwanFavorItemData swanFavorItemData = new SwanFavorItemData();
                swanFavorItemData.setAppKey(str);
                swanFavorItemData.setIsNewFavor(1);
                if (ei2.b(swanFavorItemData, 1, zm2Var)) {
                    m(str, true);
                }
                k(str, "add");
            }
        }
    }

    public void c(String str, an2 an2Var, al2.b bVar) {
        if (ap3.T(R.string.obfuscated_res_0x7f0f14f4)) {
            return;
        }
        if (!SwanAppNetworkUtils.h()) {
            if (an2Var != null) {
                an2Var.a();
            }
        } else if (TextUtils.equals(str, fb3.K().q().O()) && fb3.K().q().W().getType() != 0) {
            ya3.f(AppRuntime.getAppContext(), R.string.obfuscated_res_0x7f0f14c7).G();
            an2Var.c(true);
        } else {
            if (ei2.g(str, an2Var, bVar)) {
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
                    swanFavorItemData.setAppType(i32.b(str));
                    swanFavorItemData.setIconUrl(metaItemInfo.icon);
                    swanFavorItemData.setAppName(metaItemInfo.appName);
                    swanFavorItemData.setAppFrameType(metaItemInfo.subCategory);
                    swanFavorItemData.setCreateTime(metaItemInfo.createTime);
                    swanFavorItemData.setPayProtected(metaItemInfo.payProtected);
                    arrayList.add(swanFavorItemData);
                }
            }
            ei2.q(arrayList);
        }
    }

    public final Bundle g(String str, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putString("appKey", str);
        bundle.putBoolean("isFavor", z);
        return bundle;
    }

    public void j(String str, zm2 zm2Var) {
        if (!SwanAppNetworkUtils.h()) {
            if (zm2Var != null) {
                zm2Var.a();
                return;
            }
            return;
        }
        ei2.o(str, 1, zm2Var);
        n(str);
    }

    public final void k(String str, String str2) {
        j62.d(ym2.b(str, str2));
    }

    public void m(String str, boolean z) {
        if (ProcessUtils.isMainProcess()) {
            a83.a(g(str, z), cn2.class);
            return;
        }
        gb3 b0 = gb3.b0();
        if (b0 == null) {
            return;
        }
        if (TextUtils.equals(b0.getAppId(), "sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u")) {
            a83.c(g(str, z), bn2.class, null);
        } else if (TextUtils.equals(b0.getAppId(), str)) {
            l(z);
        }
    }
}

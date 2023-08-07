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
import com.baidu.tieba.a32;
import com.baidu.tieba.b62;
import com.baidu.tieba.d62;
import com.baidu.tieba.fu2;
import com.baidu.tieba.ir1;
import com.baidu.tieba.lw2;
import com.baidu.tieba.mr1;
import com.baidu.tieba.qa3;
import com.baidu.tieba.qm2;
import com.baidu.tieba.rm2;
import com.baidu.tieba.s73;
import com.baidu.tieba.sk2;
import com.baidu.tieba.sm2;
import com.baidu.tieba.sn3;
import com.baidu.tieba.so3;
import com.baidu.tieba.tm2;
import com.baidu.tieba.um2;
import com.baidu.tieba.wh2;
import com.baidu.tieba.xa3;
import com.baidu.tieba.y72;
import com.baidu.tieba.ya3;
import com.baidu.tieba.zk2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes4.dex */
public class SwanFavorDataManager implements mr1 {
    public static final boolean a = ir1.a;

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
                    SwanFavorItemData l = wh2.l(cursor);
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
            return new CursorLoader(fu2.c(), wh2.e(), null, null, null, "sort_index");
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
    public class a implements d62 {
        public a() {
        }

        @Override // com.baidu.tieba.d62
        public void a(CommonSyncServerData commonSyncServerData) {
            y72.k("SwanFavorDataManager", "fetchFavorDataFromServer onSuccess");
            SwanFavorDataManager.this.f(commonSyncServerData);
        }

        @Override // com.baidu.tieba.d62
        public void onFail() {
            y72.k("SwanFavorDataManager", "fetchFavorDataFromServer onFail");
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public final /* synthetic */ d62 a;

        public b(SwanFavorDataManager swanFavorDataManager, d62 d62Var) {
            this.a = d62Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            b62.b(this.a);
        }
    }

    /* loaded from: classes4.dex */
    public static class d {
        public static final SwanFavorDataManager a = new SwanFavorDataManager(null);
    }

    public SwanFavorDataManager() {
        SwanAppDbControl.f(fu2.c());
        fu2.h0().c(this);
    }

    public static SwanFavorDataManager h() {
        return d.a;
    }

    public void d() {
        e(new a());
    }

    public List<SwanFavorItemData> i() {
        return wh2.j();
    }

    public /* synthetic */ SwanFavorDataManager(a aVar) {
        this();
    }

    @Override // com.baidu.tieba.mr1
    public void a(boolean z) {
        y72.k("SwanFavorDataManager", "onLoginStatusChanged isLoggedIn=" + z);
        d();
    }

    public void e(d62 d62Var) {
        sn3.k(new b(this, d62Var), "fetchFavorDataFromServer");
    }

    public final void n(String str) {
        b62.e(qm2.c(str, 1));
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
        lw2.T().u(new zk2("favorStatusChange", hashMap));
    }

    public void b(String str, rm2 rm2Var) {
        fu2.t().a();
        if (!so3.T(R.string.obfuscated_res_0x7f0f14ca) && fu2.t().b()) {
            if (!SwanAppNetworkUtils.h()) {
                if (rm2Var != null) {
                    rm2Var.a();
                }
            } else if (TextUtils.equals(str, xa3.K().q().O()) && xa3.K().q().W().getType() != 0) {
                qa3.f(AppRuntime.getAppContext(), R.string.obfuscated_res_0x7f0f149d).G();
                rm2Var.b(true);
            } else {
                SwanFavorItemData swanFavorItemData = new SwanFavorItemData();
                swanFavorItemData.setAppKey(str);
                swanFavorItemData.setIsNewFavor(1);
                if (wh2.b(swanFavorItemData, 1, rm2Var)) {
                    m(str, true);
                }
                k(str, "add");
            }
        }
    }

    public void c(String str, sm2 sm2Var, sk2.b bVar) {
        if (so3.T(R.string.obfuscated_res_0x7f0f14ca)) {
            return;
        }
        if (!SwanAppNetworkUtils.h()) {
            if (sm2Var != null) {
                sm2Var.a();
            }
        } else if (TextUtils.equals(str, xa3.K().q().O()) && xa3.K().q().W().getType() != 0) {
            qa3.f(AppRuntime.getAppContext(), R.string.obfuscated_res_0x7f0f149d).G();
            sm2Var.c(true);
        } else {
            if (wh2.g(str, sm2Var, bVar)) {
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
                    swanFavorItemData.setAppType(a32.b(str));
                    swanFavorItemData.setIconUrl(metaItemInfo.icon);
                    swanFavorItemData.setAppName(metaItemInfo.appName);
                    swanFavorItemData.setAppFrameType(metaItemInfo.subCategory);
                    swanFavorItemData.setCreateTime(metaItemInfo.createTime);
                    swanFavorItemData.setPayProtected(metaItemInfo.payProtected);
                    arrayList.add(swanFavorItemData);
                }
            }
            wh2.q(arrayList);
        }
    }

    public final Bundle g(String str, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putString("appKey", str);
        bundle.putBoolean("isFavor", z);
        return bundle;
    }

    public void j(String str, rm2 rm2Var) {
        if (!SwanAppNetworkUtils.h()) {
            if (rm2Var != null) {
                rm2Var.a();
                return;
            }
            return;
        }
        wh2.o(str, 1, rm2Var);
        n(str);
    }

    public final void k(String str, String str2) {
        b62.d(qm2.b(str, str2));
    }

    public void m(String str, boolean z) {
        if (ProcessUtils.isMainProcess()) {
            s73.a(g(str, z), um2.class);
            return;
        }
        ya3 b0 = ya3.b0();
        if (b0 == null) {
            return;
        }
        if (TextUtils.equals(b0.getAppId(), "sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u")) {
            s73.c(g(str, z), tm2.class, null);
        } else if (TextUtils.equals(b0.getAppId(), str)) {
            l(z);
        }
    }
}

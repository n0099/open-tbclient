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
import com.baidu.tieba.a42;
import com.baidu.tieba.b72;
import com.baidu.tieba.d72;
import com.baidu.tieba.fv2;
import com.baidu.tieba.is1;
import com.baidu.tieba.lx2;
import com.baidu.tieba.ms1;
import com.baidu.tieba.qb3;
import com.baidu.tieba.qn2;
import com.baidu.tieba.rn2;
import com.baidu.tieba.s83;
import com.baidu.tieba.sl2;
import com.baidu.tieba.sn2;
import com.baidu.tieba.so3;
import com.baidu.tieba.sp3;
import com.baidu.tieba.tn2;
import com.baidu.tieba.un2;
import com.baidu.tieba.wi2;
import com.baidu.tieba.xb3;
import com.baidu.tieba.y82;
import com.baidu.tieba.yb3;
import com.baidu.tieba.zl2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes4.dex */
public class SwanFavorDataManager implements ms1 {
    public static final boolean a = is1.a;

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
                    SwanFavorItemData l = wi2.l(cursor);
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
            return new CursorLoader(fv2.c(), wi2.e(), null, null, null, "sort_index");
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
    public class a implements d72 {
        public a() {
        }

        @Override // com.baidu.tieba.d72
        public void a(CommonSyncServerData commonSyncServerData) {
            y82.k("SwanFavorDataManager", "fetchFavorDataFromServer onSuccess");
            SwanFavorDataManager.this.f(commonSyncServerData);
        }

        @Override // com.baidu.tieba.d72
        public void onFail() {
            y82.k("SwanFavorDataManager", "fetchFavorDataFromServer onFail");
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public final /* synthetic */ d72 a;

        public b(SwanFavorDataManager swanFavorDataManager, d72 d72Var) {
            this.a = d72Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            b72.b(this.a);
        }
    }

    /* loaded from: classes4.dex */
    public static class d {
        public static final SwanFavorDataManager a = new SwanFavorDataManager(null);
    }

    public SwanFavorDataManager() {
        SwanAppDbControl.f(fv2.c());
        fv2.h0().c(this);
    }

    public static SwanFavorDataManager h() {
        return d.a;
    }

    public void d() {
        e(new a());
    }

    public List<SwanFavorItemData> i() {
        return wi2.j();
    }

    public /* synthetic */ SwanFavorDataManager(a aVar) {
        this();
    }

    @Override // com.baidu.tieba.ms1
    public void a(boolean z) {
        y82.k("SwanFavorDataManager", "onLoginStatusChanged isLoggedIn=" + z);
        d();
    }

    public void e(d72 d72Var) {
        so3.k(new b(this, d72Var), "fetchFavorDataFromServer");
    }

    public final void n(String str) {
        b72.e(qn2.c(str, 1));
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
        lx2.T().u(new zl2("favorStatusChange", hashMap));
    }

    public void b(String str, rn2 rn2Var) {
        fv2.t().a();
        if (!sp3.T(R.string.obfuscated_res_0x7f0f148f) && fv2.t().b()) {
            if (!SwanAppNetworkUtils.h()) {
                if (rn2Var != null) {
                    rn2Var.a();
                }
            } else if (TextUtils.equals(str, xb3.K().q().O()) && xb3.K().q().W().getType() != 0) {
                qb3.f(AppRuntime.getAppContext(), R.string.obfuscated_res_0x7f0f1462).G();
                rn2Var.b(true);
            } else {
                SwanFavorItemData swanFavorItemData = new SwanFavorItemData();
                swanFavorItemData.setAppKey(str);
                swanFavorItemData.setIsNewFavor(1);
                if (wi2.b(swanFavorItemData, 1, rn2Var)) {
                    m(str, true);
                }
                k(str, "add");
            }
        }
    }

    public void c(String str, sn2 sn2Var, sl2.b bVar) {
        if (sp3.T(R.string.obfuscated_res_0x7f0f148f)) {
            return;
        }
        if (!SwanAppNetworkUtils.h()) {
            if (sn2Var != null) {
                sn2Var.a();
            }
        } else if (TextUtils.equals(str, xb3.K().q().O()) && xb3.K().q().W().getType() != 0) {
            qb3.f(AppRuntime.getAppContext(), R.string.obfuscated_res_0x7f0f1462).G();
            sn2Var.c(true);
        } else {
            if (wi2.g(str, sn2Var, bVar)) {
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
                    swanFavorItemData.setAppType(a42.b(str));
                    swanFavorItemData.setIconUrl(metaItemInfo.icon);
                    swanFavorItemData.setAppName(metaItemInfo.appName);
                    swanFavorItemData.setAppFrameType(metaItemInfo.subCategory);
                    swanFavorItemData.setCreateTime(metaItemInfo.createTime);
                    swanFavorItemData.setPayProtected(metaItemInfo.payProtected);
                    arrayList.add(swanFavorItemData);
                }
            }
            wi2.q(arrayList);
        }
    }

    public final Bundle g(String str, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putString("appKey", str);
        bundle.putBoolean("isFavor", z);
        return bundle;
    }

    public void j(String str, rn2 rn2Var) {
        if (!SwanAppNetworkUtils.h()) {
            if (rn2Var != null) {
                rn2Var.a();
                return;
            }
            return;
        }
        wi2.o(str, 1, rn2Var);
        n(str);
    }

    public final void k(String str, String str2) {
        b72.d(qn2.b(str, str2));
    }

    public void m(String str, boolean z) {
        if (ProcessUtils.isMainProcess()) {
            s83.a(g(str, z), un2.class);
            return;
        }
        yb3 b0 = yb3.b0();
        if (b0 == null) {
            return;
        }
        if (TextUtils.equals(b0.getAppId(), "sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u")) {
            s83.c(g(str, z), tn2.class, null);
        } else if (TextUtils.equals(b0.getAppId(), str)) {
            l(z);
        }
    }
}

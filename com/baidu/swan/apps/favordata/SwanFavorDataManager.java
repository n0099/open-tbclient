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
import com.baidu.tieba.an2;
import com.baidu.tieba.b83;
import com.baidu.tieba.bl2;
import com.baidu.tieba.bn2;
import com.baidu.tieba.bo3;
import com.baidu.tieba.bp3;
import com.baidu.tieba.cn2;
import com.baidu.tieba.dn2;
import com.baidu.tieba.fi2;
import com.baidu.tieba.gb3;
import com.baidu.tieba.h82;
import com.baidu.tieba.hb3;
import com.baidu.tieba.il2;
import com.baidu.tieba.j32;
import com.baidu.tieba.k62;
import com.baidu.tieba.m62;
import com.baidu.tieba.ou2;
import com.baidu.tieba.rr1;
import com.baidu.tieba.uw2;
import com.baidu.tieba.vr1;
import com.baidu.tieba.za3;
import com.baidu.tieba.zm2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes4.dex */
public class SwanFavorDataManager implements vr1 {
    public static final boolean a = rr1.a;

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
                    SwanFavorItemData l = fi2.l(cursor);
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
            return new CursorLoader(ou2.c(), fi2.e(), null, null, null, "sort_index");
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
    public class a implements m62 {
        public a() {
        }

        @Override // com.baidu.tieba.m62
        public void a(CommonSyncServerData commonSyncServerData) {
            h82.k("SwanFavorDataManager", "fetchFavorDataFromServer onSuccess");
            SwanFavorDataManager.this.f(commonSyncServerData);
        }

        @Override // com.baidu.tieba.m62
        public void onFail() {
            h82.k("SwanFavorDataManager", "fetchFavorDataFromServer onFail");
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public final /* synthetic */ m62 a;

        public b(SwanFavorDataManager swanFavorDataManager, m62 m62Var) {
            this.a = m62Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            k62.b(this.a);
        }
    }

    /* loaded from: classes4.dex */
    public static class d {
        public static final SwanFavorDataManager a = new SwanFavorDataManager(null);
    }

    public SwanFavorDataManager() {
        SwanAppDbControl.f(ou2.c());
        ou2.h0().c(this);
    }

    public static SwanFavorDataManager h() {
        return d.a;
    }

    public void d() {
        e(new a());
    }

    public List<SwanFavorItemData> i() {
        return fi2.j();
    }

    public /* synthetic */ SwanFavorDataManager(a aVar) {
        this();
    }

    @Override // com.baidu.tieba.vr1
    public void a(boolean z) {
        h82.k("SwanFavorDataManager", "onLoginStatusChanged isLoggedIn=" + z);
        d();
    }

    public void e(m62 m62Var) {
        bo3.k(new b(this, m62Var), "fetchFavorDataFromServer");
    }

    public final void n(String str) {
        k62.e(zm2.c(str, 1));
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
        uw2.T().u(new il2("favorStatusChange", hashMap));
    }

    public void b(String str, an2 an2Var) {
        ou2.t().a();
        if (!bp3.T(R.string.obfuscated_res_0x7f0f14f1) && ou2.t().b()) {
            if (!SwanAppNetworkUtils.h()) {
                if (an2Var != null) {
                    an2Var.a();
                }
            } else if (TextUtils.equals(str, gb3.K().q().O()) && gb3.K().q().W().getType() != 0) {
                za3.f(AppRuntime.getAppContext(), R.string.obfuscated_res_0x7f0f14c4).G();
                an2Var.b(true);
            } else {
                SwanFavorItemData swanFavorItemData = new SwanFavorItemData();
                swanFavorItemData.setAppKey(str);
                swanFavorItemData.setIsNewFavor(1);
                if (fi2.b(swanFavorItemData, 1, an2Var)) {
                    m(str, true);
                }
                k(str, "add");
            }
        }
    }

    public void c(String str, bn2 bn2Var, bl2.b bVar) {
        if (bp3.T(R.string.obfuscated_res_0x7f0f14f1)) {
            return;
        }
        if (!SwanAppNetworkUtils.h()) {
            if (bn2Var != null) {
                bn2Var.a();
            }
        } else if (TextUtils.equals(str, gb3.K().q().O()) && gb3.K().q().W().getType() != 0) {
            za3.f(AppRuntime.getAppContext(), R.string.obfuscated_res_0x7f0f14c4).G();
            bn2Var.c(true);
        } else {
            if (fi2.g(str, bn2Var, bVar)) {
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
                    swanFavorItemData.setAppType(j32.b(str));
                    swanFavorItemData.setIconUrl(metaItemInfo.icon);
                    swanFavorItemData.setAppName(metaItemInfo.appName);
                    swanFavorItemData.setAppFrameType(metaItemInfo.subCategory);
                    swanFavorItemData.setCreateTime(metaItemInfo.createTime);
                    swanFavorItemData.setPayProtected(metaItemInfo.payProtected);
                    arrayList.add(swanFavorItemData);
                }
            }
            fi2.q(arrayList);
        }
    }

    public final Bundle g(String str, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putString("appKey", str);
        bundle.putBoolean("isFavor", z);
        return bundle;
    }

    public void j(String str, an2 an2Var) {
        if (!SwanAppNetworkUtils.h()) {
            if (an2Var != null) {
                an2Var.a();
                return;
            }
            return;
        }
        fi2.o(str, 1, an2Var);
        n(str);
    }

    public final void k(String str, String str2) {
        k62.d(zm2.b(str, str2));
    }

    public void m(String str, boolean z) {
        if (ProcessUtils.isMainProcess()) {
            b83.a(g(str, z), dn2.class);
            return;
        }
        hb3 b0 = hb3.b0();
        if (b0 == null) {
            return;
        }
        if (TextUtils.equals(b0.getAppId(), "sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u")) {
            b83.c(g(str, z), cn2.class, null);
        } else if (TextUtils.equals(b0.getAppId(), str)) {
            l(z);
        }
    }
}

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
import com.baidu.tieba.a33;
import com.baidu.tieba.ag2;
import com.baidu.tieba.ai2;
import com.baidu.tieba.aj3;
import com.baidu.tieba.ak3;
import com.baidu.tieba.bi2;
import com.baidu.tieba.ci2;
import com.baidu.tieba.ed2;
import com.baidu.tieba.f63;
import com.baidu.tieba.g32;
import com.baidu.tieba.g63;
import com.baidu.tieba.hg2;
import com.baidu.tieba.jy1;
import com.baidu.tieba.k12;
import com.baidu.tieba.m12;
import com.baidu.tieba.np2;
import com.baidu.tieba.rm1;
import com.baidu.tieba.tr2;
import com.baidu.tieba.vm1;
import com.baidu.tieba.y53;
import com.baidu.tieba.yh2;
import com.baidu.tieba.zh2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes4.dex */
public class SwanFavorDataManager implements vm1 {
    public static final boolean a = rm1.a;

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
                    SwanFavorItemData l = ed2.l(cursor);
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
            return new CursorLoader(np2.c(), ed2.e(), null, null, null, "sort_index");
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
    public class a implements m12 {
        public a() {
        }

        @Override // com.baidu.tieba.m12
        public void a(CommonSyncServerData commonSyncServerData) {
            g32.k("SwanFavorDataManager", "fetchFavorDataFromServer onSuccess");
            SwanFavorDataManager.this.f(commonSyncServerData);
        }

        @Override // com.baidu.tieba.m12
        public void onFail() {
            g32.k("SwanFavorDataManager", "fetchFavorDataFromServer onFail");
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public final /* synthetic */ m12 a;

        public b(SwanFavorDataManager swanFavorDataManager, m12 m12Var) {
            this.a = m12Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            k12.b(this.a);
        }
    }

    /* loaded from: classes4.dex */
    public static class d {
        public static final SwanFavorDataManager a = new SwanFavorDataManager(null);
    }

    public SwanFavorDataManager() {
        SwanAppDbControl.f(np2.c());
        np2.h0().c(this);
    }

    public static SwanFavorDataManager h() {
        return d.a;
    }

    public void d() {
        e(new a());
    }

    public List<SwanFavorItemData> i() {
        return ed2.j();
    }

    public /* synthetic */ SwanFavorDataManager(a aVar) {
        this();
    }

    @Override // com.baidu.tieba.vm1
    public void a(boolean z) {
        g32.k("SwanFavorDataManager", "onLoginStatusChanged isLoggedIn=" + z);
        d();
    }

    public void e(m12 m12Var) {
        aj3.k(new b(this, m12Var), "fetchFavorDataFromServer");
    }

    public final void n(String str) {
        k12.e(yh2.c(str, 1));
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
        tr2.V().v(new hg2("favorStatusChange", hashMap));
    }

    public void b(String str, zh2 zh2Var) {
        np2.t().a();
        if (!ak3.T(R.string.obfuscated_res_0x7f0f151c) && np2.t().b()) {
            if (!SwanAppNetworkUtils.h()) {
                if (zh2Var != null) {
                    zh2Var.a();
                }
            } else if (TextUtils.equals(str, f63.K().q().P()) && f63.K().q().X().w1() != 0) {
                y53.f(AppRuntime.getAppContext(), R.string.obfuscated_res_0x7f0f14ef).G();
                zh2Var.b(true);
            } else {
                SwanFavorItemData swanFavorItemData = new SwanFavorItemData();
                swanFavorItemData.setAppKey(str);
                swanFavorItemData.setIsNewFavor(1);
                if (ed2.b(swanFavorItemData, 1, zh2Var)) {
                    m(str, true);
                }
                k(str, "add");
            }
        }
    }

    public void c(String str, ai2 ai2Var, ag2.b bVar) {
        if (ak3.T(R.string.obfuscated_res_0x7f0f151c)) {
            return;
        }
        if (!SwanAppNetworkUtils.h()) {
            if (ai2Var != null) {
                ai2Var.a();
            }
        } else if (TextUtils.equals(str, f63.K().q().P()) && f63.K().q().X().w1() != 0) {
            y53.f(AppRuntime.getAppContext(), R.string.obfuscated_res_0x7f0f14ef).G();
            ai2Var.c(true);
        } else {
            if (ed2.g(str, ai2Var, bVar)) {
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
                    swanFavorItemData.setAppType(jy1.b(str));
                    swanFavorItemData.setIconUrl(metaItemInfo.icon);
                    swanFavorItemData.setAppName(metaItemInfo.appName);
                    swanFavorItemData.setAppFrameType(metaItemInfo.subCategory);
                    swanFavorItemData.setCreateTime(metaItemInfo.createTime);
                    swanFavorItemData.setPayProtected(metaItemInfo.payProtected);
                    arrayList.add(swanFavorItemData);
                }
            }
            ed2.q(arrayList);
        }
    }

    public final Bundle g(String str, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putString("appKey", str);
        bundle.putBoolean("isFavor", z);
        return bundle;
    }

    public void j(String str, zh2 zh2Var) {
        if (!SwanAppNetworkUtils.h()) {
            if (zh2Var != null) {
                zh2Var.a();
                return;
            }
            return;
        }
        ed2.o(str, 1, zh2Var);
        n(str);
    }

    public final void k(String str, String str2) {
        k12.d(yh2.b(str, str2));
    }

    public void m(String str, boolean z) {
        if (ProcessUtils.isMainProcess()) {
            a33.a(g(str, z), ci2.class);
            return;
        }
        g63 c0 = g63.c0();
        if (c0 == null) {
            return;
        }
        if (TextUtils.equals(c0.getAppId(), "sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u")) {
            a33.c(g(str, z), bi2.class, null);
        } else if (TextUtils.equals(c0.getAppId(), str)) {
            l(z);
        }
    }
}

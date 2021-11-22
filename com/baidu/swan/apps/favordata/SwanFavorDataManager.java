package com.baidu.swan.apps.favordata;

import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.CursorLoader;
import androidx.loader.content.Loader;
import b.a.p0.a.c2.b.f.e;
import b.a.p0.a.g1.f;
import b.a.p0.a.h;
import b.a.p0.a.k;
import b.a.p0.a.n0.l.b;
import b.a.p0.a.z2.q;
import b.a.p0.a.z2.q0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.commonsync.CommonSyncServerData;
import com.baidu.swan.apps.database.SwanAppDbControl;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.paysdk.banksign.datamodel.QueryResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes8.dex */
public class SwanFavorDataManager implements b.a.p0.a.m.c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f44467e;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public class FavorDataDBLoaderCB implements LoaderManager.LoaderCallbacks<Cursor> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public c f44468a;

        public FavorDataDBLoaderCB(SwanFavorDataManager swanFavorDataManager, c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanFavorDataManager, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44468a = cVar;
        }

        @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
        @NonNull
        public Loader<Cursor> onCreateLoader(int i2, @Nullable Bundle bundle) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i2, bundle)) == null) ? new CursorLoader(b.a.p0.a.c1.a.c(), b.a.p0.a.j0.b.a.e(), null, null, null, "sort_index") : (Loader) invokeIL.objValue;
        }

        @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
        public void onLoaderReset(@NonNull Loader<Cursor> loader) {
            c cVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, loader) == null) || (cVar = this.f44468a) == null) {
                return;
            }
            cVar.onLoadFail();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Removed duplicated region for block: B:25:0x004c  */
        /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
        @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onLoadFinished(@NonNull Loader<Cursor> loader, Cursor cursor) {
            c cVar;
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, loader, cursor) != null) {
                return;
            }
            if (loader.getId() != 101) {
                c cVar2 = this.f44468a;
                if (cVar2 != null) {
                    cVar2.onLoadFail();
                    return;
                }
                return;
            }
            ArrayList arrayList = new ArrayList();
            if (cursor != null && cursor.getCount() > 0 && cursor.moveToFirst()) {
                do {
                    SwanFavorItemData l = b.a.p0.a.j0.b.a.l(cursor);
                    if (!TextUtils.isEmpty(l.getAppKey()) && !TextUtils.isEmpty(l.getAppName())) {
                        arrayList.add(l);
                    }
                } while (cursor.moveToNext());
                cVar = this.f44468a;
                if (cVar == null) {
                }
            } else {
                cVar = this.f44468a;
                if (cVar == null) {
                    cVar.onLoadSuccess(arrayList);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class a implements b.a.p0.a.b0.c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SwanFavorDataManager f44469a;

        public a(SwanFavorDataManager swanFavorDataManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanFavorDataManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44469a = swanFavorDataManager;
        }

        @Override // b.a.p0.a.b0.c.a
        public void a(CommonSyncServerData commonSyncServerData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, commonSyncServerData) == null) {
                b.a.p0.a.e0.d.k("SwanFavorDataManager", "fetchFavorDataFromServer onSuccess");
                this.f44469a.f(commonSyncServerData);
            }
        }

        @Override // b.a.p0.a.b0.c.a
        public void onFail() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                b.a.p0.a.e0.d.k("SwanFavorDataManager", "fetchFavorDataFromServer onFail");
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.b0.c.a f44470e;

        public b(SwanFavorDataManager swanFavorDataManager, b.a.p0.a.b0.c.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanFavorDataManager, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44470e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.p0.a.b0.a.b(this.f44470e);
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface c {
        void onLoadFail();

        void onLoadSuccess(List<SwanFavorItemData> list);
    }

    /* loaded from: classes8.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final SwanFavorDataManager f44471a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-191873967, "Lcom/baidu/swan/apps/favordata/SwanFavorDataManager$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-191873967, "Lcom/baidu/swan/apps/favordata/SwanFavorDataManager$d;");
                    return;
                }
            }
            f44471a = new SwanFavorDataManager(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1894770321, "Lcom/baidu/swan/apps/favordata/SwanFavorDataManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1894770321, "Lcom/baidu/swan/apps/favordata/SwanFavorDataManager;");
                return;
            }
        }
        f44467e = k.f6863a;
    }

    public /* synthetic */ SwanFavorDataManager(a aVar) {
        this();
    }

    public static SwanFavorDataManager h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? d.f44471a : (SwanFavorDataManager) invokeV.objValue;
    }

    public static void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TRACKBALL, null, z) == null) {
            if (f44467e) {
                String str = "sendFavorStatusMsg: isAddfavor = " + z;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("status", z ? "1" : "0");
            f.U().u(new b.a.p0.a.o0.d.c("favorStatusChange", hashMap));
        }
    }

    @Override // b.a.p0.a.m.c
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            b.a.p0.a.e0.d.k("SwanFavorDataManager", "onLoginStatusChanged isLoggedIn=" + z);
            d();
        }
    }

    public void b(String str, b.a.p0.a.q0.b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, aVar) == null) {
            int i2 = h.swan_app_teen_mode_add_favor_tips;
            b.a.p0.a.c1.a.t().a();
            if (q0.T(i2) || !b.a.p0.a.c1.a.t().b()) {
                return;
            }
            if (!SwanAppNetworkUtils.h()) {
                if (aVar != null) {
                    aVar.a();
                }
            } else if (TextUtils.equals(str, b.a.p0.a.d2.d.J().r().N()) && b.a.p0.a.d2.d.J().r().V().getType() != 0) {
                e.f(AppRuntime.getAppContext(), h.swan_app_follow_failed).G();
                aVar.b(true);
            } else {
                SwanFavorItemData swanFavorItemData = new SwanFavorItemData();
                swanFavorItemData.setAppKey(str);
                swanFavorItemData.setIsNewFavor(1);
                if (b.a.p0.a.j0.b.a.b(swanFavorItemData, 1, aVar)) {
                    m(str, true);
                }
                k(str, "add");
            }
        }
    }

    public void c(String str, b.a.p0.a.q0.b.b bVar, b.C0322b c0322b) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, bVar, c0322b) == null) || q0.T(h.swan_app_teen_mode_add_favor_tips)) {
            return;
        }
        if (!SwanAppNetworkUtils.h()) {
            if (bVar != null) {
                bVar.a();
            }
        } else if (TextUtils.equals(str, b.a.p0.a.d2.d.J().r().N()) && b.a.p0.a.d2.d.J().r().V().getType() != 0) {
            e.f(AppRuntime.getAppContext(), h.swan_app_follow_failed).G();
            bVar.c(true);
        } else {
            if (b.a.p0.a.j0.b.a.g(str, bVar, c0322b)) {
                m(str, false);
            }
            k(str, QueryResponse.Options.CANCEL);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            e(new a(this));
        }
    }

    public void e(b.a.p0.a.b0.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            q.k(new b(this, aVar), "fetchFavorDataFromServer");
        }
    }

    public void f(CommonSyncServerData commonSyncServerData) {
        List<CommonSyncServerData.MetaItemInfo> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, commonSyncServerData) == null) || commonSyncServerData == null || (list = commonSyncServerData.metaItems) == null || list.size() <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (CommonSyncServerData.MetaItemInfo metaItemInfo : list) {
            if (metaItemInfo != null) {
                SwanFavorItemData swanFavorItemData = new SwanFavorItemData();
                String str = metaItemInfo.appKey;
                swanFavorItemData.setAppKey(str);
                swanFavorItemData.setAppType(b.a.p0.a.v.a.b(str));
                swanFavorItemData.setIconUrl(metaItemInfo.icon);
                swanFavorItemData.setAppName(metaItemInfo.appName);
                swanFavorItemData.setAppFrameType(metaItemInfo.subCategory);
                swanFavorItemData.setCreateTime(metaItemInfo.createTime);
                swanFavorItemData.setPayProtected(metaItemInfo.payProtected);
                arrayList.add(swanFavorItemData);
            }
        }
        b.a.p0.a.j0.b.a.q(arrayList);
    }

    public final Bundle g(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048582, this, str, z)) == null) {
            Bundle bundle = new Bundle();
            bundle.putString("appKey", str);
            bundle.putBoolean("isFavor", z);
            return bundle;
        }
        return (Bundle) invokeLZ.objValue;
    }

    public List<SwanFavorItemData> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? b.a.p0.a.j0.b.a.j() : (List) invokeV.objValue;
    }

    public void j(String str, b.a.p0.a.q0.b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, aVar) == null) {
            if (SwanAppNetworkUtils.h()) {
                b.a.p0.a.j0.b.a.o(str, 1, aVar);
                n(str);
            } else if (aVar != null) {
                aVar.a();
            }
        }
    }

    public final void k(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, str, str2) == null) {
            b.a.p0.a.b0.a.d(b.a.p0.a.q0.a.b(str, str2));
        }
    }

    public void m(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048586, this, str, z) == null) {
            if (ProcessUtils.isMainProcess()) {
                b.a.p0.a.y1.c.d.b.a(g(str, z), b.a.p0.a.q0.c.b.class);
                return;
            }
            b.a.p0.a.d2.e a0 = b.a.p0.a.d2.e.a0();
            if (a0 == null) {
                return;
            }
            if (TextUtils.equals(a0.getAppId(), "sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u")) {
                b.a.p0.a.y1.c.d.b.c(g(str, z), b.a.p0.a.q0.c.a.class, null);
            } else if (TextUtils.equals(a0.getAppId(), str)) {
                l(z);
            }
        }
    }

    public final void n(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            b.a.p0.a.b0.a.e(b.a.p0.a.q0.a.c(str, 1));
        }
    }

    public SwanFavorDataManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        SwanAppDbControl.f(b.a.p0.a.c1.a.c());
        b.a.p0.a.c1.a.h0().c(this);
    }
}

package com.baidu.swan.apps.favordata;

import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.CursorLoader;
import androidx.loader.content.Loader;
import com.baidu.android.imsdk.internal.Constants;
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
import d.a.n0.a.a2.e;
import d.a.n0.a.g1.f;
import d.a.n0.a.k;
import d.a.n0.a.n0.l.b;
import d.a.n0.a.v2.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes3.dex */
public class SwanFavorDataManager implements d.a.n0.a.m.c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f11024e;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public class FavorDataDBLoaderCB implements LoaderManager.LoaderCallbacks<Cursor> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public c f11025a;

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Removed duplicated region for block: B:25:0x004c  */
        /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
        @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onLoadFinished(@NonNull Loader<Cursor> loader, Cursor cursor) {
            c cVar;
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLL(1048576, this, loader, cursor) != null) {
                return;
            }
            if (loader.getId() != 101) {
                c cVar2 = this.f11025a;
                if (cVar2 != null) {
                    cVar2.onLoadFail();
                    return;
                }
                return;
            }
            ArrayList arrayList = new ArrayList();
            if (cursor != null && cursor.getCount() > 0 && cursor.moveToFirst()) {
                do {
                    SwanFavorItemData l = d.a.n0.a.j0.b.a.l(cursor);
                    if (!TextUtils.isEmpty(l.getAppKey()) && !TextUtils.isEmpty(l.getAppName())) {
                        arrayList.add(l);
                    }
                } while (cursor.moveToNext());
                cVar = this.f11025a;
                if (cVar == null) {
                }
            } else {
                cVar = this.f11025a;
                if (cVar == null) {
                    cVar.onLoadSuccess(arrayList);
                }
            }
        }

        @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
        @NonNull
        public Loader<Cursor> onCreateLoader(int i2, @Nullable Bundle bundle) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, bundle)) == null) ? new CursorLoader(d.a.n0.a.c1.a.b(), d.a.n0.a.j0.b.a.e(), null, null, null, "sort_index") : (Loader) invokeIL.objValue;
        }

        @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
        public void onLoaderReset(@NonNull Loader<Cursor> loader) {
            c cVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, loader) == null) || (cVar = this.f11025a) == null) {
                return;
            }
            cVar.onLoadFail();
        }
    }

    /* loaded from: classes3.dex */
    public class a implements d.a.n0.a.b0.c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SwanFavorDataManager f11026a;

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
            this.f11026a = swanFavorDataManager;
        }

        @Override // d.a.n0.a.b0.c.a
        public void a(CommonSyncServerData commonSyncServerData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, commonSyncServerData) == null) {
                d.a.n0.a.e0.d.h("SwanFavorDataManager", "fetchFavorDataFromServer onSuccess");
                this.f11026a.f(commonSyncServerData);
            }
        }

        @Override // d.a.n0.a.b0.c.a
        public void onFail() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                d.a.n0.a.e0.d.h("SwanFavorDataManager", "fetchFavorDataFromServer onFail");
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.b0.c.a f11027e;

        public b(SwanFavorDataManager swanFavorDataManager, d.a.n0.a.b0.c.a aVar) {
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
            this.f11027e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.n0.a.b0.a.b(this.f11027e);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void onLoadFail();

        void onLoadSuccess(List<SwanFavorItemData> list);
    }

    /* loaded from: classes3.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final SwanFavorDataManager f11028a;
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
            f11028a = new SwanFavorDataManager(null);
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
        f11024e = k.f45831a;
    }

    public /* synthetic */ SwanFavorDataManager(a aVar) {
        this();
    }

    public static SwanFavorDataManager h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? d.f11028a : (SwanFavorDataManager) invokeV.objValue;
    }

    public static void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TRACKBALL, null, z) == null) {
            if (f11024e) {
                Log.d("SwanFavorDataManager", "sendFavorStatusMsg: isAddfavor = " + z);
            }
            HashMap hashMap = new HashMap();
            hashMap.put("status", z ? "1" : "0");
            f.V().v(new d.a.n0.a.o0.d.b("favorStatusChange", hashMap));
        }
    }

    @Override // d.a.n0.a.m.c
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            d.a.n0.a.e0.d.h("SwanFavorDataManager", "onLoginStatusChanged isLoggedIn=" + z);
            d();
        }
    }

    public void b(String str, d.a.n0.a.q0.b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, aVar) == null) {
            if (!SwanAppNetworkUtils.h()) {
                if (aVar != null) {
                    aVar.a();
                    return;
                }
                return;
            }
            SwanFavorItemData swanFavorItemData = new SwanFavorItemData();
            swanFavorItemData.setAppKey(str);
            swanFavorItemData.setIsNewFavor(1);
            if (d.a.n0.a.j0.b.a.b(swanFavorItemData, 1, aVar)) {
                m(str, true);
            }
            k(str, "add");
        }
    }

    public void c(String str, d.a.n0.a.q0.b.b bVar, b.C0831b c0831b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, bVar, c0831b) == null) {
            if (SwanAppNetworkUtils.h()) {
                if (d.a.n0.a.j0.b.a.g(str, bVar, c0831b)) {
                    m(str, false);
                }
                k(str, QueryResponse.Options.CANCEL);
            } else if (bVar != null) {
                bVar.a();
            }
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            e(new a(this));
        }
    }

    public void e(d.a.n0.a.b0.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            q.j(new b(this, aVar), "fetchFavorDataFromServer");
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
                swanFavorItemData.setAppType(d.a.n0.a.v.a.b(str));
                swanFavorItemData.setIconUrl(metaItemInfo.icon);
                swanFavorItemData.setAppName(metaItemInfo.appName);
                swanFavorItemData.setAppFrameType(metaItemInfo.subCategory);
                swanFavorItemData.setCreateTime(metaItemInfo.createTime);
                swanFavorItemData.setPayProtected(metaItemInfo.payProtected);
                arrayList.add(swanFavorItemData);
            }
        }
        d.a.n0.a.j0.b.a.q(arrayList);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? d.a.n0.a.j0.b.a.j() : (List) invokeV.objValue;
    }

    public void j(String str, d.a.n0.a.q0.b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, aVar) == null) {
            if (SwanAppNetworkUtils.h()) {
                d.a.n0.a.j0.b.a.o(str, 1, aVar);
                n(str);
            } else if (aVar != null) {
                aVar.a();
            }
        }
    }

    public final void k(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, str, str2) == null) {
            d.a.n0.a.b0.a.d(d.a.n0.a.q0.a.b(str, str2));
        }
    }

    public void m(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048586, this, str, z) == null) {
            if (ProcessUtils.isMainProcess()) {
                d.a.n0.a.v1.c.d.b.a(g(str, z), d.a.n0.a.q0.c.b.class);
                return;
            }
            e Q = e.Q();
            if (Q == null) {
                return;
            }
            if (TextUtils.equals(Q.getAppId(), "sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u")) {
                d.a.n0.a.v1.c.d.b.c(g(str, z), d.a.n0.a.q0.c.a.class, null);
            } else if (TextUtils.equals(Q.getAppId(), str)) {
                l(z);
            }
        }
    }

    public final void n(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            d.a.n0.a.b0.a.e(d.a.n0.a.q0.a.c(str, 1));
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
        SwanAppDbControl.f(d.a.n0.a.c1.a.b());
        d.a.n0.a.c1.a.a0().c(this);
    }
}

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
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.commonsync.CommonSyncServerData;
import com.baidu.swan.apps.database.SwanAppDbControl;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ab2;
import com.repackage.b92;
import com.repackage.bb2;
import com.repackage.bc3;
import com.repackage.bd3;
import com.repackage.bw2;
import com.repackage.cb2;
import com.repackage.db2;
import com.repackage.f62;
import com.repackage.gz2;
import com.repackage.hw1;
import com.repackage.hz2;
import com.repackage.i92;
import com.repackage.jr1;
import com.repackage.ku1;
import com.repackage.mu1;
import com.repackage.oi2;
import com.repackage.rf1;
import com.repackage.uk2;
import com.repackage.vf1;
import com.repackage.za2;
import com.repackage.zy2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes2.dex */
public class SwanFavorDataManager implements vf1 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public class FavorDataDBLoaderCB implements LoaderManager.LoaderCallbacks<Cursor> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public c a;

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
                    SwanFavorItemData l = f62.l(cursor);
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
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bundle)) == null) ? new CursorLoader(oi2.c(), f62.e(), null, null, null, "sort_index") : (Loader) invokeIL.objValue;
        }

        @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
        public void onLoaderReset(@NonNull Loader<Cursor> loader) {
            c cVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, loader) == null) || (cVar = this.a) == null) {
                return;
            }
            cVar.onLoadFail();
        }
    }

    /* loaded from: classes2.dex */
    public class a implements mu1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanFavorDataManager a;

        public a(SwanFavorDataManager swanFavorDataManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanFavorDataManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = swanFavorDataManager;
        }

        @Override // com.repackage.mu1
        public void a(CommonSyncServerData commonSyncServerData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, commonSyncServerData) == null) {
                hw1.k("SwanFavorDataManager", "fetchFavorDataFromServer onSuccess");
                this.a.f(commonSyncServerData);
            }
        }

        @Override // com.repackage.mu1
        public void onFail() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                hw1.k("SwanFavorDataManager", "fetchFavorDataFromServer onFail");
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mu1 a;

        public b(SwanFavorDataManager swanFavorDataManager, mu1 mu1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanFavorDataManager, mu1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mu1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ku1.b(this.a);
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface c {
        void onLoadFail();

        void onLoadSuccess(List<SwanFavorItemData> list);
    }

    /* loaded from: classes2.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public static final SwanFavorDataManager a;
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
            a = new SwanFavorDataManager(null);
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
        a = rf1.a;
    }

    public /* synthetic */ SwanFavorDataManager(a aVar) {
        this();
    }

    public static SwanFavorDataManager h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? d.a : (SwanFavorDataManager) invokeV.objValue;
    }

    public static void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TRACKBALL, null, z) == null) {
            if (a) {
                Log.d("SwanFavorDataManager", "sendFavorStatusMsg: isAddfavor = " + z);
            }
            HashMap hashMap = new HashMap();
            hashMap.put("status", z ? "1" : "0");
            uk2.U().u(new i92("favorStatusChange", hashMap));
        }
    }

    @Override // com.repackage.vf1
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            hw1.k("SwanFavorDataManager", "onLoginStatusChanged isLoggedIn=" + z);
            d();
        }
    }

    public void b(String str, ab2 ab2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, ab2Var) == null) {
            oi2.t().a();
            if (bd3.T(R.string.obfuscated_res_0x7f0f126f) || !oi2.t().b()) {
                return;
            }
            if (!SwanAppNetworkUtils.h()) {
                if (ab2Var != null) {
                    ab2Var.a();
                }
            } else if (TextUtils.equals(str, gz2.J().r().N()) && gz2.J().r().V().getType() != 0) {
                zy2.f(AppRuntime.getAppContext(), R.string.obfuscated_res_0x7f0f1242).G();
                ab2Var.b(true);
            } else {
                SwanFavorItemData swanFavorItemData = new SwanFavorItemData();
                swanFavorItemData.setAppKey(str);
                swanFavorItemData.setIsNewFavor(1);
                if (f62.b(swanFavorItemData, 1, ab2Var)) {
                    m(str, true);
                }
                k(str, "add");
            }
        }
    }

    public void c(String str, bb2 bb2Var, b92.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, bb2Var, bVar) == null) || bd3.T(R.string.obfuscated_res_0x7f0f126f)) {
            return;
        }
        if (!SwanAppNetworkUtils.h()) {
            if (bb2Var != null) {
                bb2Var.a();
            }
        } else if (TextUtils.equals(str, gz2.J().r().N()) && gz2.J().r().V().getType() != 0) {
            zy2.f(AppRuntime.getAppContext(), R.string.obfuscated_res_0x7f0f1242).G();
            bb2Var.c(true);
        } else {
            if (f62.g(str, bb2Var, bVar)) {
                m(str, false);
            }
            k(str, "cancel");
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            e(new a(this));
        }
    }

    public void e(mu1 mu1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, mu1Var) == null) {
            bc3.k(new b(this, mu1Var), "fetchFavorDataFromServer");
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
                swanFavorItemData.setAppType(jr1.b(str));
                swanFavorItemData.setIconUrl(metaItemInfo.icon);
                swanFavorItemData.setAppName(metaItemInfo.appName);
                swanFavorItemData.setAppFrameType(metaItemInfo.subCategory);
                swanFavorItemData.setCreateTime(metaItemInfo.createTime);
                swanFavorItemData.setPayProtected(metaItemInfo.payProtected);
                arrayList.add(swanFavorItemData);
            }
        }
        f62.q(arrayList);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? f62.j() : (List) invokeV.objValue;
    }

    public void j(String str, ab2 ab2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, ab2Var) == null) {
            if (SwanAppNetworkUtils.h()) {
                f62.o(str, 1, ab2Var);
                n(str);
            } else if (ab2Var != null) {
                ab2Var.a();
            }
        }
    }

    public final void k(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, str, str2) == null) {
            ku1.d(za2.b(str, str2));
        }
    }

    public void m(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048586, this, str, z) == null) {
            if (ProcessUtils.isMainProcess()) {
                bw2.a(g(str, z), db2.class);
                return;
            }
            hz2 a0 = hz2.a0();
            if (a0 == null) {
                return;
            }
            if (TextUtils.equals(a0.getAppId(), "sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u")) {
                bw2.c(g(str, z), cb2.class, null);
            } else if (TextUtils.equals(a0.getAppId(), str)) {
                l(z);
            }
        }
    }

    public final void n(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            ku1.e(za2.c(str, 1));
        }
    }

    public SwanFavorDataManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        SwanAppDbControl.f(oi2.c());
        oi2.h0().c(this);
    }
}

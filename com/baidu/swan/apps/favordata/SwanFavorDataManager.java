package com.baidu.swan.apps.favordata;

import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
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
import com.baidu.tieba.ak1;
import com.baidu.tieba.e33;
import com.baidu.tieba.ef2;
import com.baidu.tieba.ff2;
import com.baidu.tieba.g03;
import com.baidu.tieba.gd2;
import com.baidu.tieba.gf2;
import com.baidu.tieba.gg3;
import com.baidu.tieba.gh3;
import com.baidu.tieba.hf2;
import com.baidu.tieba.if2;
import com.baidu.tieba.ka2;
import com.baidu.tieba.l33;
import com.baidu.tieba.m02;
import com.baidu.tieba.m33;
import com.baidu.tieba.nd2;
import com.baidu.tieba.ov1;
import com.baidu.tieba.py1;
import com.baidu.tieba.ry1;
import com.baidu.tieba.tm2;
import com.baidu.tieba.wj1;
import com.baidu.tieba.zo2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes2.dex */
public class SwanFavorDataManager implements ak1 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public interface c {
        void onLoadFail();

        void onLoadSuccess(List list);
    }

    /* loaded from: classes2.dex */
    public class FavorDataDBLoaderCB implements LoaderManager.LoaderCallbacks {
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
        public void onLoadFinished(Loader loader, Cursor cursor) {
            c cVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, loader, cursor) == null) {
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
                        SwanFavorItemData l = ka2.l(cursor);
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
        }

        @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
        public Loader onCreateLoader(int i, Bundle bundle) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bundle)) == null) {
                return new CursorLoader(tm2.c(), ka2.e(), null, null, null, "sort_index");
            }
            return (Loader) invokeIL.objValue;
        }

        @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
        public void onLoaderReset(Loader loader) {
            c cVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048579, this, loader) == null) && (cVar = this.a) != null) {
                cVar.onLoadFail();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class a implements ry1 {
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

        @Override // com.baidu.tieba.ry1
        public void a(CommonSyncServerData commonSyncServerData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, commonSyncServerData) == null) {
                m02.k("SwanFavorDataManager", "fetchFavorDataFromServer onSuccess");
                this.a.f(commonSyncServerData);
            }
        }

        @Override // com.baidu.tieba.ry1
        public void onFail() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                m02.k("SwanFavorDataManager", "fetchFavorDataFromServer onFail");
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ry1 a;

        public b(SwanFavorDataManager swanFavorDataManager, ry1 ry1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanFavorDataManager, ry1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ry1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                py1.b(this.a);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d {
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
        a = wj1.a;
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
        SwanAppDbControl.f(tm2.c());
        tm2.h0().c(this);
    }

    public static SwanFavorDataManager h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return d.a;
        }
        return (SwanFavorDataManager) invokeV.objValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            e(new a(this));
        }
    }

    public List i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return ka2.j();
        }
        return (List) invokeV.objValue;
    }

    public /* synthetic */ SwanFavorDataManager(a aVar) {
        this();
    }

    @Override // com.baidu.tieba.ak1
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            m02.k("SwanFavorDataManager", "onLoginStatusChanged isLoggedIn=" + z);
            d();
        }
    }

    public void e(ry1 ry1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, ry1Var) == null) {
            gg3.k(new b(this, ry1Var), "fetchFavorDataFromServer");
        }
    }

    public final void n(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            py1.e(ef2.c(str, 1));
        }
    }

    public static void l(boolean z) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TRACKBALL, null, z) == null) {
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
            zo2.U().u(new nd2("favorStatusChange", hashMap));
        }
    }

    public void b(String str, ff2 ff2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, ff2Var) == null) {
            tm2.t().a();
            if (!gh3.T(R.string.obfuscated_res_0x7f0f1298) && tm2.t().b()) {
                if (!SwanAppNetworkUtils.h()) {
                    if (ff2Var != null) {
                        ff2Var.a();
                    }
                } else if (TextUtils.equals(str, l33.K().q().O()) && l33.K().q().W().getType() != 0) {
                    e33.f(AppRuntime.getAppContext(), R.string.obfuscated_res_0x7f0f126b).G();
                    ff2Var.b(true);
                } else {
                    SwanFavorItemData swanFavorItemData = new SwanFavorItemData();
                    swanFavorItemData.setAppKey(str);
                    swanFavorItemData.setIsNewFavor(1);
                    if (ka2.b(swanFavorItemData, 1, ff2Var)) {
                        m(str, true);
                    }
                    k(str, "add");
                }
            }
        }
    }

    public void c(String str, gf2 gf2Var, gd2.b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, gf2Var, bVar) != null) || gh3.T(R.string.obfuscated_res_0x7f0f1298)) {
            return;
        }
        if (!SwanAppNetworkUtils.h()) {
            if (gf2Var != null) {
                gf2Var.a();
            }
        } else if (TextUtils.equals(str, l33.K().q().O()) && l33.K().q().W().getType() != 0) {
            e33.f(AppRuntime.getAppContext(), R.string.obfuscated_res_0x7f0f126b).G();
            gf2Var.c(true);
        } else {
            if (ka2.g(str, gf2Var, bVar)) {
                m(str, false);
            }
            k(str, "cancel");
        }
    }

    public void f(CommonSyncServerData commonSyncServerData) {
        List<CommonSyncServerData.MetaItemInfo> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, commonSyncServerData) == null) && commonSyncServerData != null && (list = commonSyncServerData.metaItems) != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (CommonSyncServerData.MetaItemInfo metaItemInfo : list) {
                if (metaItemInfo != null) {
                    SwanFavorItemData swanFavorItemData = new SwanFavorItemData();
                    String str = metaItemInfo.appKey;
                    swanFavorItemData.setAppKey(str);
                    swanFavorItemData.setAppType(ov1.b(str));
                    swanFavorItemData.setIconUrl(metaItemInfo.icon);
                    swanFavorItemData.setAppName(metaItemInfo.appName);
                    swanFavorItemData.setAppFrameType(metaItemInfo.subCategory);
                    swanFavorItemData.setCreateTime(metaItemInfo.createTime);
                    swanFavorItemData.setPayProtected(metaItemInfo.payProtected);
                    arrayList.add(swanFavorItemData);
                }
            }
            ka2.q(arrayList);
        }
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

    public void j(String str, ff2 ff2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, ff2Var) == null) {
            if (!SwanAppNetworkUtils.h()) {
                if (ff2Var != null) {
                    ff2Var.a();
                    return;
                }
                return;
            }
            ka2.o(str, 1, ff2Var);
            n(str);
        }
    }

    public final void k(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, str, str2) == null) {
            py1.d(ef2.b(str, str2));
        }
    }

    public void m(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048586, this, str, z) == null) {
            if (ProcessUtils.isMainProcess()) {
                g03.a(g(str, z), if2.class);
                return;
            }
            m33 b0 = m33.b0();
            if (b0 == null) {
                return;
            }
            if (TextUtils.equals(b0.getAppId(), "sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u")) {
                g03.c(g(str, z), hf2.class, null);
            } else if (TextUtils.equals(b0.getAppId(), str)) {
                l(z);
            }
        }
    }
}

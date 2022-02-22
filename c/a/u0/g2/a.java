package c.a.u0.g2;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.m;
import c.a.d.f.p.n;
import c.a.t0.e.f;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.live.impl.IMasterSwitchCallback;
import com.baidu.searchbox.live.impl.LiveNpsGetSwitchManager;
import com.baidu.searchbox.live.interfaces.callback.ILiveFileSizeCallback;
import com.baidu.searchbox.live.nps.LiveNPSPluginManager;
import com.baidu.searchbox.live.nps.LiveNpsLoadingCallback;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tieba.view.NpsPluginLoadingDialogActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.Map;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public WeakReference<NpsPluginLoadingDialogActivity> a;

    /* renamed from: b  reason: collision with root package name */
    public int f18014b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f18015c;

    /* renamed from: c.a.u0.g2.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1118a implements LiveNpsLoadingCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public C1118a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // com.baidu.searchbox.live.nps.LiveNpsLoadingCallback
        public void onLoadingEnd(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.a.f18015c = false;
                this.a.f();
            }
        }

        @Override // com.baidu.searchbox.live.nps.LiveNpsLoadingCallback
        public void onLoadingProgress(long j2, long j3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) {
                BdLog.d("[onDownloadUpdate] package:, current:" + j2 + ",total:" + j3);
                this.a.f18014b = (int) (j3 <= 0 ? 0.0f : (((float) j2) * 100.0f) / ((float) j3));
                a aVar = this.a;
                aVar.J(aVar.i());
            }
        }

        @Override // com.baidu.searchbox.live.nps.LiveNpsLoadingCallback
        public void onLoadingStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.a.f18015c = true;
                this.a.p(TbadkCoreApplication.getInst());
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements IMasterSwitchCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f a;

        public b(a aVar, f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fVar;
        }

        @Override // com.baidu.searchbox.live.impl.IMasterSwitchCallback
        public void switchCallback(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (!m.isEmpty(str)) {
                    TbSingleton.getInstance().setYyCloudSwitch(str);
                }
                if (this.a != null) {
                    if ("yy".equals(str)) {
                        this.a.onSwitchGet(true);
                    } else if ("baidu".equals(str)) {
                        this.a.onSwitchGet(false);
                    } else {
                        this.a.onFail();
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements ILiveFileSizeCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long[] a;

        public c(a aVar, long[] jArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, jArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jArr;
        }

        @Override // com.baidu.searchbox.live.interfaces.callback.ILiveFileSizeCallback
        public void getFileSize(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j2) == null) {
                this.a[0] = j2;
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class d {
        public static /* synthetic */ Interceptable $ic;
        public static final a a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(901190288, "Lc/a/u0/g2/a$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(901190288, "Lc/a/u0/g2/a$d;");
                    return;
                }
            }
            a = new a(null);
        }
    }

    public /* synthetic */ a(C1118a c1118a) {
        this();
    }

    public static a j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? d.a : (a) invokeV.objValue;
    }

    public void A(@NonNull Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, str) == null) {
            if (I()) {
                n.N(context, "安卓系统版本不支持");
            } else {
                LiveNPSPluginManager.getInstance().startPatronsActivity(context, str);
            }
        }
    }

    public void B(@NonNull Context context, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str) == null) {
            if (I()) {
                n.N(context, "安卓系统版本不支持");
            } else {
                LiveNPSPluginManager.getInstance().startPayActivity(context, str);
            }
        }
    }

    public void C(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, context, str, str2) == null) {
            if (I()) {
                n.N(context, "安卓系统版本不支持");
            } else {
                LiveNPSPluginManager.getInstance().startRealAuthActivity(context, str, str2);
            }
        }
    }

    public void D(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, context, str) == null) {
            if (I()) {
                n.N(context, "安卓系统版本不支持");
            } else {
                LiveNPSPluginManager.getInstance().dispatchYYLiveRouter(context, "yylive?url=yymobile%3a%2f%2fMobileLive%2fPreViewPage%3fneedLogin%3d1");
            }
        }
    }

    public void E(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, context, str) == null) {
            if (I()) {
                n.N(context, "安卓系统版本不支持");
            } else {
                LiveNPSPluginManager.getInstance().startYYCustomerServiceActivity(context, str);
            }
        }
    }

    public void F(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, context, str) == null) {
            if (I()) {
                n.N(context, "安卓系统版本不支持");
            } else {
                LiveNPSPluginManager.getInstance().startYYFeedbackActivity(context, str);
            }
        }
    }

    public void G(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, context, str) == null) {
            if (I()) {
                n.N(context, "安卓系统版本不支持");
                return;
            }
            if (BdLog.isDebugMode()) {
                BdLog.e("YYStartLiveRoom|" + str);
            }
            LiveNPSPluginManager.getInstance().startYYLiveActivity(context, str);
        }
    }

    public void H(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, context, str) == null) {
            if (I()) {
                n.N(context, "安卓系统版本不支持");
            } else {
                LiveNPSPluginManager.getInstance().startYuYinCreateLiveRoomActivity(context, str);
            }
        }
    }

    public boolean I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? Build.VERSION.SDK_INT < 21 : invokeV.booleanValue;
    }

    public void J(NpsPluginLoadingDialogActivity npsPluginLoadingDialogActivity) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, npsPluginLoadingDialogActivity) == null) || npsPluginLoadingDialogActivity == null) {
            return;
        }
        npsPluginLoadingDialogActivity.setRoundProgress(this.f18014b);
    }

    public void e(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, context) == null) {
            LiveNPSPluginManager.getInstance().clearResourceFile(context);
        }
    }

    public final void f() {
        NpsPluginLoadingDialogActivity i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (i2 = i()) == null) {
            return;
        }
        i2.finish();
        this.a = null;
    }

    public void g(Context context, String str, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048588, this, context, str, map) == null) {
            if (I()) {
                n.N(context, "安卓系统版本不支持");
            } else {
                LiveNPSPluginManager.getInstance().dispatchHostEvent(context, str, map);
            }
        }
    }

    public void h(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, context, str) == null) {
            if (I()) {
                n.N(context, "安卓系统版本不支持");
            } else {
                LiveNPSPluginManager.getInstance().dispatchYYLiveRouter(context, str);
            }
        }
    }

    public final NpsPluginLoadingDialogActivity i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            WeakReference<NpsPluginLoadingDialogActivity> weakReference = this.a;
            if (weakReference != null) {
                return weakReference.get();
            }
            return null;
        }
        return (NpsPluginLoadingDialogActivity) invokeV.objValue;
    }

    public long k(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, context)) == null) {
            long[] jArr = {0};
            LiveNPSPluginManager.getInstance().getLiveResourceFileSize(context, new c(this, jArr));
            return jArr[0];
        }
        return invokeL.longValue;
    }

    public void l(@Nullable f fVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048592, this, fVar) == null) && PermissionUtil.isAgreePrivacyPolicy()) {
            LiveNpsGetSwitchManager.INSTANCE.getMasterSwitch("", new b(this, fVar));
        }
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f18015c : invokeV.booleanValue;
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.a = null;
            LiveNPSPluginManager.getInstance().cancelLoading();
        }
    }

    public void o(NpsPluginLoadingDialogActivity npsPluginLoadingDialogActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, npsPluginLoadingDialogActivity) == null) {
            this.a = new WeakReference<>(npsPluginLoadingDialogActivity);
            J(npsPluginLoadingDialogActivity);
        }
    }

    public void p(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048596, this, context) == null) && i() == null) {
            long currentTimeMillis = System.currentTimeMillis();
            Intent intent = new Intent(context, NpsPluginLoadingDialogActivity.class);
            intent.putExtra("dialogId", currentTimeMillis);
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            context.startActivity(intent);
        }
    }

    public void q(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, context) == null) {
            if (I()) {
                n.N(context, "安卓系统版本不支持");
            } else {
                LiveNPSPluginManager.getInstance().startAdminListActivity(context);
            }
        }
    }

    public void r(Application application, String str, Uri uri) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048598, this, application, str, uri) == null) {
            if (I()) {
                n.N(application, "安卓系统版本不支持");
            } else {
                LiveNPSPluginManager.getInstance().startBjhMasterActivity(application, str, uri);
            }
        }
    }

    public void s(Context context, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048599, this, context, str, i2) == null) {
            if (I()) {
                n.N(context, "安卓系统版本不支持");
            } else {
                LiveNPSPluginManager.getInstance().startFansListActivity(context, str, i2);
            }
        }
    }

    public void t(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, context) == null) {
            if (I()) {
                n.N(context, "安卓系统版本不支持");
            } else {
                LiveNPSPluginManager.getInstance().startForbiddenListActivity(context);
            }
        }
    }

    public void u(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048601, this, context, str, str2) == null) {
            if (I()) {
                n.N(context, "安卓系统版本不支持");
            } else {
                LiveNPSPluginManager.getInstance().startGuardianListActivity(context, str, str2);
            }
        }
    }

    public void v(Context context, long j2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048602, this, new Object[]{context, Long.valueOf(j2), Integer.valueOf(i2)}) == null) {
            if (I()) {
                n.N(context, "安卓系统版本不支持");
            } else {
                LiveNPSPluginManager.getInstance().startLiveExpActivity(context, j2, i2);
            }
        }
    }

    public void w(Context context, String str, String str2, String str3, Uri uri) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLLL(1048603, this, context, str, str2, str3, uri) == null) || I()) {
            return;
        }
        LiveNPSPluginManager.getInstance().startLiveMediaActivity(context, str, str2, str3, uri);
    }

    public void x(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048604, this, context, str) == null) {
            if (I()) {
                n.N(context, "安卓系统版本不支持");
            } else {
                LiveNPSPluginManager.getInstance().startLiveShowActivity(context, str);
            }
        }
    }

    public void y(Context context, String str, String str2, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048605, this, context, str, str2, map) == null) {
            if (I()) {
                n.N(context, "安卓系统版本不支持");
            } else {
                LiveNPSPluginManager.getInstance().startYuYinActivity(context, str, str2, map);
            }
        }
    }

    public void z(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, context) == null) {
            if (I()) {
                n.N(context, "安卓系统版本不支持");
            } else {
                LiveNPSPluginManager.getInstance().startPatronageActivity(context);
            }
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f18014b = 0;
        this.f18015c = false;
        LiveNPSPluginManager.getInstance().setLoadingCallback(new C1118a(this));
        c.a.u0.c2.i.a.e(TbadkCoreApplication.getInst());
    }
}

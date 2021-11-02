package b.a.r0.x1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import b.a.e.e.p.k;
import b.a.e.e.p.l;
import b.a.q0.e.f;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.sapi2.utils.enums.FastLoginFeature;
import com.baidu.searchbox.live.impl.IMasterSwitchCallback;
import com.baidu.searchbox.live.impl.LiveNpsGetSwitchManager;
import com.baidu.searchbox.live.interfaces.callback.ILiveFileSizeCallback;
import com.baidu.searchbox.live.nps.LiveNPSPluginManager;
import com.baidu.searchbox.live.nps.LiveNpsLoadingCallback;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
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
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public WeakReference<NpsPluginLoadingDialogActivity> f27006a;

    /* renamed from: b  reason: collision with root package name */
    public int f27007b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f27008c;

    /* renamed from: b.a.r0.x1.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1326a implements LiveNpsLoadingCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f27009a;

        public C1326a(a aVar) {
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
            this.f27009a = aVar;
        }

        @Override // com.baidu.searchbox.live.nps.LiveNpsLoadingCallback
        public void onLoadingEnd(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.f27009a.f27008c = false;
                this.f27009a.f();
            }
        }

        @Override // com.baidu.searchbox.live.nps.LiveNpsLoadingCallback
        public void onLoadingProgress(long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
                BdLog.d("[onDownloadUpdate] package:, current:" + j + ",total:" + j2);
                this.f27009a.f27007b = (int) (j2 <= 0 ? 0.0f : (((float) j) * 100.0f) / ((float) j2));
                a aVar = this.f27009a;
                aVar.I(aVar.i());
            }
        }

        @Override // com.baidu.searchbox.live.nps.LiveNpsLoadingCallback
        public void onLoadingStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f27009a.f27008c = true;
                this.f27009a.p(TbadkCoreApplication.getInst());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements IMasterSwitchCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f27010a;

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
            this.f27010a = fVar;
        }

        @Override // com.baidu.searchbox.live.impl.IMasterSwitchCallback
        public void switchCallback(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (!k.isEmpty(str)) {
                    TbSingleton.getInstance().setYyCloudSwitch(str);
                }
                if (this.f27010a != null) {
                    if (FastLoginFeature.SSOLoginType.YY.equals(str)) {
                        this.f27010a.onSwitchGet(true);
                    } else if ("baidu".equals(str)) {
                        this.f27010a.onSwitchGet(false);
                    } else {
                        this.f27010a.onFail();
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements ILiveFileSizeCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ long[] f27011a;

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
            this.f27011a = jArr;
        }

        @Override // com.baidu.searchbox.live.interfaces.callback.ILiveFileSizeCallback
        public void getFileSize(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
                this.f27011a[0] = j;
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class d {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final a f27012a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-124646330, "Lb/a/r0/x1/a$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-124646330, "Lb/a/r0/x1/a$d;");
                    return;
                }
            }
            f27012a = new a(null);
        }
    }

    public /* synthetic */ a(C1326a c1326a) {
        this();
    }

    public static a j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? d.f27012a : (a) invokeV.objValue;
    }

    public void A(@NonNull Context context, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, str) == null) {
            if (H()) {
                l.M(context, "安卓系统版本不支持");
            } else {
                LiveNPSPluginManager.getInstance().startPayActivity(context, str);
            }
        }
    }

    public void B(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str, str2) == null) {
            if (H()) {
                l.M(context, "安卓系统版本不支持");
            } else {
                LiveNPSPluginManager.getInstance().startRealAuthActivity(context, str, str2);
            }
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:20:0x0032 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:36:0x003b */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0041  */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [org.json.JSONObject] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void C(Context context, String str) {
        JSONObject jSONObject;
        JSONException e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, str) == null) {
            if (H()) {
                l.M(context, "安卓系统版本不支持");
                return;
            }
            Object obj = null;
            try {
                try {
                    if (TextUtils.isEmpty(str)) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("show_ar_loading", 1);
                        jSONObject = jSONObject2;
                    } else {
                        JSONObject jSONObject3 = new JSONObject(str);
                        obj = jSONObject3.opt("show_ar_loading");
                        jSONObject = jSONObject3;
                        if (obj == null) {
                            jSONObject3.put("show_ar_loading", 1);
                            jSONObject = jSONObject3;
                        }
                    }
                } catch (JSONException e3) {
                    e2 = e3;
                    e2.printStackTrace();
                    LiveNPSPluginManager liveNPSPluginManager = LiveNPSPluginManager.getInstance();
                    if (jSONObject != 0) {
                    }
                    liveNPSPluginManager.startMasterActivity(context, str, "");
                }
            } catch (JSONException e4) {
                jSONObject = obj;
                e2 = e4;
            }
            LiveNPSPluginManager liveNPSPluginManager2 = LiveNPSPluginManager.getInstance();
            if (jSONObject != 0) {
                str = jSONObject.toString();
            }
            liveNPSPluginManager2.startMasterActivity(context, str, "");
        }
    }

    public void D(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, context, str) == null) {
            if (H()) {
                l.M(context, "安卓系统版本不支持");
            } else {
                LiveNPSPluginManager.getInstance().startYYCustomerServiceActivity(context, str);
            }
        }
    }

    public void E(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, context, str) == null) {
            if (H()) {
                l.M(context, "安卓系统版本不支持");
            } else {
                LiveNPSPluginManager.getInstance().startYYFeedbackActivity(context, str);
            }
        }
    }

    public void F(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, context, str) == null) {
            if (H()) {
                l.M(context, "安卓系统版本不支持");
                return;
            }
            if (BdLog.isDebugMode()) {
                BdLog.e("YYStartLiveRoom|" + str);
            }
            LiveNPSPluginManager.getInstance().startYYLiveActivity(context, str);
        }
    }

    public void G(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, context, str) == null) {
            if (H()) {
                l.M(context, "安卓系统版本不支持");
            } else {
                LiveNPSPluginManager.getInstance().startYuYinCreateLiveRoomActivity(context, str);
            }
        }
    }

    public boolean H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? Build.VERSION.SDK_INT < 21 : invokeV.booleanValue;
    }

    public void I(NpsPluginLoadingDialogActivity npsPluginLoadingDialogActivity) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, npsPluginLoadingDialogActivity) == null) || npsPluginLoadingDialogActivity == null) {
            return;
        }
        npsPluginLoadingDialogActivity.setRoundProgress(this.f27007b);
    }

    public void e(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, context) == null) {
            LiveNPSPluginManager.getInstance().clearResourceFile(context);
        }
    }

    public final void f() {
        NpsPluginLoadingDialogActivity i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (i2 = i()) == null) {
            return;
        }
        i2.finish();
        this.f27006a = null;
    }

    public void g(Context context, String str, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048587, this, context, str, map) == null) {
            if (H()) {
                l.M(context, "安卓系统版本不支持");
            } else {
                LiveNPSPluginManager.getInstance().dispatchHostEvent(context, str, map);
            }
        }
    }

    public void h(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, context, str) == null) {
            if (H()) {
                l.M(context, "安卓系统版本不支持");
            } else {
                LiveNPSPluginManager.getInstance().dispatchYYLiveRouter(context, str);
            }
        }
    }

    public final NpsPluginLoadingDialogActivity i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            WeakReference<NpsPluginLoadingDialogActivity> weakReference = this.f27006a;
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, context)) == null) {
            long[] jArr = {0};
            LiveNPSPluginManager.getInstance().getLiveResourceFileSize(context, new c(this, jArr));
            return jArr[0];
        }
        return invokeL.longValue;
    }

    public void l(@Nullable f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, fVar) == null) {
            LiveNpsGetSwitchManager.INSTANCE.getMasterSwitch("", new b(this, fVar));
        }
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f27008c : invokeV.booleanValue;
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.f27006a = null;
            LiveNPSPluginManager.getInstance().cancelLoading();
        }
    }

    public void o(NpsPluginLoadingDialogActivity npsPluginLoadingDialogActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, npsPluginLoadingDialogActivity) == null) {
            this.f27006a = new WeakReference<>(npsPluginLoadingDialogActivity);
            I(npsPluginLoadingDialogActivity);
        }
    }

    public void p(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048595, this, context) == null) && i() == null) {
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
        if (interceptable == null || interceptable.invokeL(1048596, this, context) == null) {
            if (H()) {
                l.M(context, "安卓系统版本不支持");
            } else {
                LiveNPSPluginManager.getInstance().startAdminListActivity(context);
            }
        }
    }

    public void r(Context context, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048597, this, context, str, i2) == null) {
            if (H()) {
                l.M(context, "安卓系统版本不支持");
            } else {
                LiveNPSPluginManager.getInstance().startFansListActivity(context, str, i2);
            }
        }
    }

    public void s(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, context) == null) {
            if (H()) {
                l.M(context, "安卓系统版本不支持");
            } else {
                LiveNPSPluginManager.getInstance().startForbiddenListActivity(context);
            }
        }
    }

    public void t(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048599, this, context, str, str2) == null) {
            if (H()) {
                l.M(context, "安卓系统版本不支持");
            } else {
                LiveNPSPluginManager.getInstance().startGuardianListActivity(context, str, str2);
            }
        }
    }

    public void u(Context context, long j, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048600, this, new Object[]{context, Long.valueOf(j), Integer.valueOf(i2)}) == null) {
            if (H()) {
                l.M(context, "安卓系统版本不支持");
            } else {
                LiveNPSPluginManager.getInstance().startLiveExpActivity(context, j, i2);
            }
        }
    }

    public void v(Context context, String str, String str2, String str3, Uri uri) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLLL(1048601, this, context, str, str2, str3, uri) == null) || H()) {
            return;
        }
        LiveNPSPluginManager.getInstance().startLiveMediaActivity(context, str, str2, str3, uri);
    }

    public void w(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048602, this, context, str) == null) {
            if (H()) {
                l.M(context, "安卓系统版本不支持");
            } else {
                LiveNPSPluginManager.getInstance().startLiveShowActivity(context, str);
            }
        }
    }

    public void x(Context context, String str, String str2, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048603, this, context, str, str2, map) == null) {
            if (H()) {
                l.M(context, "安卓系统版本不支持");
            } else {
                LiveNPSPluginManager.getInstance().startYuYinActivity(context, str, str2, map);
            }
        }
    }

    public void y(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, context) == null) {
            if (H()) {
                l.M(context, "安卓系统版本不支持");
            } else {
                LiveNPSPluginManager.getInstance().startPatronageActivity(context);
            }
        }
    }

    public void z(@NonNull Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048605, this, context, str) == null) {
            if (H()) {
                l.M(context, "安卓系统版本不支持");
            } else {
                LiveNPSPluginManager.getInstance().startPatronsActivity(context, str);
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
        this.f27007b = 0;
        this.f27008c = false;
        LiveNPSPluginManager.getInstance().setLoadingCallback(new C1326a(this));
        b.a.r0.t1.i.a.c(TbadkCoreApplication.getInst());
    }
}

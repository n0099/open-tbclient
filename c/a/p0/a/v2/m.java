package c.a.p0.a.v2;

import android.app.ActivityManager;
import android.os.Build;
import android.os.StatFs;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.n2.c.a;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.mobads.sdk.internal.XAdSDKPorxyConfig;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.DecimalFormat;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class m {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile String f9360a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a extends c.a.p0.a.v1.a.b.c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f9361c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ long f9362d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.v2.e1.b f9363e;

        /* renamed from: c.a.p0.a.v2.m$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0438a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f9364e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f9365f;

            public RunnableC0438a(a aVar, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, Integer.valueOf(i2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f9365f = aVar;
                this.f9364e = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        m.f(jSONObject, this.f9364e, this.f9365f.f9361c, this.f9365f.f9362d);
                    } catch (Exception e2) {
                        w.f(jSONObject, "errorMsg", e2.getMessage());
                    }
                    this.f9365f.f9363e.onCallback(jSONObject);
                }
            }
        }

        public a(int i2, long j2, c.a.p0.a.v2.e1.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Long.valueOf(j2), bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9361c = i2;
            this.f9362d = j2;
            this.f9363e = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.v1.a.b.c.b, c.a.p0.a.v1.a.b.c.c, c.a.p0.a.v1.a.b.c.a
        public void onEvent(@NonNull c.a.p0.a.v1.a.b.a.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                ExecutorUtilsExt.postOnElastic(new RunnableC0438a(this, bVar.a() == null ? -1 : bVar.a().getInt("net_quality")), "getDeviceInfoAsync", 2);
            }
        }
    }

    public m() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static String b(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65538, null, j2)) == null) ? new DecimalFormat("#.##").format(j2 / 1.073741824E9d) : (String) invokeJ.objValue;
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (TextUtils.isEmpty(f9360a)) {
                synchronized (m.class) {
                    f9360a = e();
                }
            }
            return f9360a;
        }
        return (String) invokeV.objValue;
    }

    public static void d(@NonNull c.a.p0.a.f1.e.b bVar, @NonNull c.a.p0.a.v2.e1.b<JSONObject> bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, bVar, bVar2) == null) {
            c.a.p0.a.a2.d.g().z().L(null, c.a.p0.a.n1.m.class, new a(bVar.i("host_launch_type"), bVar.k("box_cold_launch"), bVar2));
        }
    }

    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
            String str = Build.MODEL;
            String replace = TextUtils.isEmpty(str) ? "NUL" : str.replace("_", "-");
            String str2 = Build.VERSION.RELEASE;
            String replace2 = TextUtils.isEmpty(str2) ? XAdSDKPorxyConfig.REMOTE_VERSION_DEFAULT : str2.replace("_", "-");
            int i2 = Build.VERSION.SDK_INT;
            String str3 = Build.MANUFACTURER;
            String replace3 = TextUtils.isEmpty(str3) ? "NUL" : str3.replace("_", "-");
            return replace + "_" + replace2 + "_" + i2 + "_" + replace3;
        }
        return (String) invokeV.objValue;
    }

    public static void f(@NonNull JSONObject jSONObject, int i2, int i3, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, null, new Object[]{jSONObject, Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2)}) == null) {
            w.f(jSONObject, "model", Build.MODEL);
            w.f(jSONObject, "systemVersion", Build.VERSION.RELEASE);
            w.f(jSONObject, "netStatus", Integer.valueOf(i2));
            a.C0322a a2 = c.a.p0.a.n2.c.a.a(c.a.p0.a.c1.a.b());
            w.f(jSONObject, "batteryLevel", Integer.valueOf(a2 == null ? -1 : a2.f7678a));
            w.f(jSONObject, "appCurVersion", q0.D());
            w.f(jSONObject, "startupType", String.valueOf(i3));
            w.f(jSONObject, "coldLaunchTime", Long.valueOf(j2));
            StatFs statFs = new StatFs(c.a.p0.a.a1.e.i());
            w.f(jSONObject, "totalDiskSpace", b(statFs.getTotalBytes()));
            w.f(jSONObject, "freeDiskSpace", b(statFs.getAvailableBytes()));
            ActivityManager activityManager = (ActivityManager) c.a.p0.a.a2.d.g().getSystemService("activity");
            if (activityManager != null) {
                ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                activityManager.getMemoryInfo(memoryInfo);
                w.f(jSONObject, "totalMemory", b(memoryInfo.totalMem));
                w.f(jSONObject, "freeMemory", b(memoryInfo.availMem));
                w.f(jSONObject, "lowMemory", memoryInfo.lowMemory ? "1" : "0");
            }
        }
    }
}

package c.a.s0.a.z2;

import android.app.ActivityManager;
import android.os.Build;
import android.os.StatFs;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.s0.a.r2.c.a;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.DecimalFormat;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class m {
    public static /* synthetic */ Interceptable $ic;
    public static volatile String a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f10241e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f10242f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.a.s0.a.z2.g1.c f10243g;

        public a(int i2, long j2, c.a.s0.a.z2.g1.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Long.valueOf(j2), cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10241e = i2;
            this.f10242f = j2;
            this.f10243g = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    m.f(jSONObject, c.a.s0.a.p1.l.a(), this.f10241e, this.f10242f);
                } catch (Exception e2) {
                    w.f(jSONObject, "errorMsg", e2.getMessage());
                }
                this.f10243g.onCallback(jSONObject);
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
            if (TextUtils.isEmpty(a)) {
                synchronized (m.class) {
                    a = e();
                }
            }
            return a;
        }
        return (String) invokeV.objValue;
    }

    public static void d(@NonNull c.a.s0.a.f1.e.b bVar, @NonNull c.a.s0.a.z2.g1.c<JSONObject> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, bVar, cVar) == null) {
            ExecutorUtilsExt.postOnElastic(new a(bVar.i("host_launch_type"), bVar.k("box_cold_launch"), cVar), "getDeviceInfoAsync", 2);
        }
    }

    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            String str = Build.MODEL;
            String replace = TextUtils.isEmpty(str) ? "NUL" : str.replace("_", "-");
            String str2 = Build.VERSION.RELEASE;
            String replace2 = TextUtils.isEmpty(str2) ? "0.0" : str2.replace("_", "-");
            int i2 = Build.VERSION.SDK_INT;
            String str3 = Build.MANUFACTURER;
            String replace3 = TextUtils.isEmpty(str3) ? "NUL" : str3.replace("_", "-");
            return replace + "_" + replace2 + "_" + i2 + "_" + replace3;
        }
        return (String) invokeV.objValue;
    }

    public static void f(@NonNull JSONObject jSONObject, int i2, int i3, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{jSONObject, Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2)}) == null) {
            w.f(jSONObject, "model", Build.MODEL);
            w.f(jSONObject, "systemVersion", Build.VERSION.RELEASE);
            w.f(jSONObject, "netStatus", Integer.valueOf(i2));
            a.C0551a a2 = c.a.s0.a.r2.c.a.a(c.a.s0.a.c1.a.c());
            w.f(jSONObject, "batteryLevel", Integer.valueOf(a2 == null ? -1 : a2.a));
            w.f(jSONObject, "appCurVersion", q0.D());
            w.f(jSONObject, "startupType", String.valueOf(i3));
            w.f(jSONObject, "coldLaunchTime", Long.valueOf(j2));
            StatFs statFs = new StatFs(c.a.s0.a.a1.d.i());
            w.f(jSONObject, "totalDiskSpace", b(statFs.getTotalBytes()));
            w.f(jSONObject, "freeDiskSpace", b(statFs.getAvailableBytes()));
            ActivityManager activityManager = (ActivityManager) c.a.s0.a.d2.d.J().getSystemService("activity");
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

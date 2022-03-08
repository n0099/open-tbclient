package c.a.p0.a.p2;

import android.app.ActivityManager;
import android.os.Build;
import android.os.StatFs;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.h2.c.a;
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
    public static volatile String a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f6969e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f6970f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.p2.g1.c f6971g;

        public a(int i2, long j2, c.a.p0.a.p2.g1.c cVar) {
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
            this.f6969e = i2;
            this.f6970f = j2;
            this.f6971g = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    m.f(jSONObject, c.a.p0.a.f1.l.a(), this.f6969e, this.f6970f);
                } catch (Exception e2) {
                    w.f(jSONObject, "errorMsg", e2.getMessage());
                }
                this.f6971g.onCallback(jSONObject);
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

    public static void d(@NonNull c.a.p0.a.v0.e.b bVar, @NonNull c.a.p0.a.p2.g1.c<JSONObject> cVar) {
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
            a.C0308a a2 = c.a.p0.a.h2.c.a.a(c.a.p0.a.s0.a.c());
            w.f(jSONObject, "batteryLevel", Integer.valueOf(a2 == null ? -1 : a2.a));
            w.f(jSONObject, "appCurVersion", q0.D());
            w.f(jSONObject, "startupType", String.valueOf(i3));
            w.f(jSONObject, "coldLaunchTime", Long.valueOf(j2));
            StatFs statFs = new StatFs(c.a.p0.a.q0.d.i());
            w.f(jSONObject, "totalDiskSpace", b(statFs.getTotalBytes()));
            w.f(jSONObject, "freeDiskSpace", b(statFs.getAvailableBytes()));
            ActivityManager activityManager = (ActivityManager) c.a.p0.a.t1.d.J().getSystemService("activity");
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

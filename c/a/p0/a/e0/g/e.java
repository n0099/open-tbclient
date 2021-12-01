package c.a.p0.a.e0.g;

import android.app.ActivityManager;
import android.os.Bundle;
import android.os.Debug;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.DecimalFormat;
import java.util.Random;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static ActivityManager f4800c;

    /* renamed from: d  reason: collision with root package name */
    public static float f4801d;

    /* renamed from: e  reason: collision with root package name */
    public static int f4802e;

    /* renamed from: f  reason: collision with root package name */
    public static int f4803f;
    public transient /* synthetic */ FieldHolder $fh;
    public DecimalFormat a;

    /* renamed from: b  reason: collision with root package name */
    public volatile d f4804b;

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes.dex */
    public static class b extends ProviderDelegation {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
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

        @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
        public Bundle execCall(Bundle bundle) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bundle)) == null) {
                Bundle bundle2 = new Bundle();
                bundle2.putLong("key_get_host_pss", Debug.getPss());
                return bundle2;
            }
            return (Bundle) invokeL.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public float a;

        /* renamed from: b  reason: collision with root package name */
        public float f4805b;

        /* renamed from: c  reason: collision with root package name */
        public float f4806c;

        public c() {
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
            this.a = 0.0f;
            this.f4805b = 0.0f;
            this.f4806c = 0.0f;
        }
    }

    /* loaded from: classes.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic = null;

        /* renamed from: e  reason: collision with root package name */
        public static volatile String f4807e = "0";
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f4808b;

        /* renamed from: c  reason: collision with root package name */
        public String f4809c;

        /* renamed from: d  reason: collision with root package name */
        public String f4810d;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1931223723, "Lc/a/p0/a/e0/g/e$d;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1931223723, "Lc/a/p0/a/e0/g/e$d;");
            }
        }

        public d() {
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
            this.a = "0";
            this.f4808b = "0";
            this.f4809c = "0";
            this.f4810d = "0";
        }
    }

    /* renamed from: c.a.p0.a.e0.g.e$e  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0211e {
        public static /* synthetic */ Interceptable $ic;
        public static final e a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1931223754, "Lc/a/p0/a/e0/g/e$e;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1931223754, "Lc/a/p0/a/e0/g/e$e;");
                    return;
                }
            }
            a = new e(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1575642261, "Lc/a/p0/a/e0/g/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1575642261, "Lc/a/p0/a/e0/g/e;");
                return;
            }
        }
        boolean z = k.a;
        f4800c = (ActivityManager) c.a.p0.a.c1.a.c().getSystemService("activity");
        f4801d = -1.0f;
        c.a.p0.a.c1.a.g0().getSwitch("swan_memory_sample", 0);
        f4802e = 0;
        f4803f = new Random().nextInt(100);
    }

    public /* synthetic */ e(a aVar) {
        this();
    }

    public static e c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? C0211e.a : (e) invokeV.objValue;
    }

    public static float d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (f4801d < 0.0f) {
                f4801d = e().floatValue();
            }
            return f4801d;
        }
        return invokeV.floatValue;
    }

    public static Float e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            f4800c.getMemoryInfo(memoryInfo);
            return Float.valueOf(((float) memoryInfo.totalMem) / 1048576.0f);
        }
        return (Float) invokeV.objValue;
    }

    public static long f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? c.a.p0.a.y1.b.e.c(b.class, null).a.getLong("key_get_host_pss") : invokeV.longValue;
    }

    @NonNull
    public static c i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            c cVar = new c();
            Debug.MemoryInfo[] processMemoryInfo = f4800c.getProcessMemoryInfo(new int[]{Process.myPid(), c.a.p0.a.d2.d.J().r().V().j("main_pid", -1)});
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            f4800c.getMemoryInfo(memoryInfo);
            cVar.f4806c = ((float) (memoryInfo.totalMem - memoryInfo.availMem)) / 1048576.0f;
            if (processMemoryInfo != null && processMemoryInfo.length == 2) {
                Debug.MemoryInfo memoryInfo2 = processMemoryInfo[0];
                Debug.MemoryInfo memoryInfo3 = processMemoryInfo[1];
                if (memoryInfo2 != null) {
                    cVar.f4805b = ((float) Debug.getPss()) / 1024.0f;
                }
                if (memoryInfo3 != null) {
                    cVar.a = ((float) f()) / 1024.0f;
                }
            }
            return cVar;
        }
        return (c) invokeV.objValue;
    }

    public final void a(JSONObject jSONObject, ActivityManager.MemoryInfo memoryInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, jSONObject, memoryInfo) == null) || jSONObject == null || memoryInfo == null) {
            return;
        }
        this.f4804b = new d();
        this.f4804b.f4808b = jSONObject.optString("host_used_mem");
        this.f4804b.a = jSONObject.optString("smart_app_used_mem");
        this.f4804b.f4810d = jSONObject.optString("sys_free_mem");
        this.f4804b.f4809c = b(((float) memoryInfo.totalMem) / 1048576.0f);
    }

    public final String b(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f2)) == null) ? this.a.format(f2) : (String) invokeF.objValue;
    }

    @NonNull
    public d g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f4804b != null ? this.f4804b : new d() : (d) invokeV.objValue;
    }

    public String h(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            if (m()) {
                JSONObject jSONObject = new JSONObject();
                try {
                    c.a.p0.a.e0.d.k("SwanMemoryProperty", "getMemoryInfo mainPid: " + i2);
                    Debug.MemoryInfo[] processMemoryInfo = f4800c.getProcessMemoryInfo(new int[]{Process.myPid(), i2});
                    if (processMemoryInfo != null && processMemoryInfo.length == 2) {
                        Debug.MemoryInfo memoryInfo = processMemoryInfo[0];
                        if (memoryInfo != null) {
                            jSONObject.put("smart_app_used_mem", b(((float) Debug.getPss()) / 1024.0f));
                            jSONObject.put("total_rss", b((((memoryInfo.getTotalPrivateClean() + memoryInfo.getTotalPrivateDirty()) + memoryInfo.getTotalSharedClean()) + memoryInfo.getTotalSharedDirty()) / 1024.0f));
                            jSONObject.put("private_clean", b(memoryInfo.getTotalPrivateClean() / 1024.0f));
                            jSONObject.put("private_dirty", b(memoryInfo.getTotalPrivateDirty() / 1024.0f));
                            jSONObject.put("shared_clean", b(memoryInfo.getTotalSharedClean() / 1024.0f));
                            jSONObject.put("shared_dirty", b(memoryInfo.getTotalSharedDirty() / 1024.0f));
                        }
                        Debug.MemoryInfo memoryInfo2 = processMemoryInfo[1];
                        if (memoryInfo2 != null) {
                            jSONObject.put("host_used_mem", b((((memoryInfo2.getTotalPrivateClean() + memoryInfo2.getTotalPrivateDirty()) + memoryInfo2.getTotalSharedClean()) + memoryInfo2.getTotalSharedDirty()) / 1024.0f));
                        }
                    }
                    ActivityManager.MemoryInfo memoryInfo3 = new ActivityManager.MemoryInfo();
                    f4800c.getMemoryInfo(memoryInfo3);
                    jSONObject.put("sys_free_mem", b(((float) memoryInfo3.availMem) / 1048576.0f));
                    jSONObject.put("sys_low_mem", memoryInfo3.lowMemory ? "1" : "0");
                    jSONObject.put("native_heap", b(((float) Debug.getNativeHeapSize()) / 1048576.0f));
                    jSONObject.put("native_heap_alloc", b(((float) Debug.getNativeHeapAllocatedSize()) / 1048576.0f));
                    jSONObject.put("vm_max_mem", b(((float) Runtime.getRuntime().maxMemory()) / 1048576.0f));
                    jSONObject.put("vm_total_mem", b(((float) Runtime.getRuntime().totalMemory()) / 1048576.0f));
                    jSONObject.put("vm_free_mem", b(((float) Runtime.getRuntime().freeMemory()) / 1048576.0f));
                    jSONObject.put("thread_count", Thread.activeCount());
                    a(jSONObject, memoryInfo3);
                } catch (Exception e2) {
                    c.a.p0.a.e0.d.k("SwanMemoryProperty", "getMemoryInfo: " + Log.getStackTraceString(e2));
                }
                c.a.p0.a.e0.d.k("SwanMemoryProperty", "getMemoryInfo result=" + jSONObject);
                return jSONObject.toString();
            }
            return "";
        }
        return (String) invokeI.objValue;
    }

    public d j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            d dVar = new d();
            Debug.MemoryInfo[] processMemoryInfo = f4800c.getProcessMemoryInfo(new int[]{Process.myPid(), c.a.p0.a.d2.d.J().r().V().j("main_pid", -1)});
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            f4800c.getMemoryInfo(memoryInfo);
            if (processMemoryInfo != null && processMemoryInfo.length == 2) {
                Debug.MemoryInfo memoryInfo2 = processMemoryInfo[0];
                Debug.MemoryInfo memoryInfo3 = processMemoryInfo[1];
                if (memoryInfo2 != null) {
                    if (TextUtils.equals("0", d.f4807e)) {
                        String unused = d.f4807e = b(((float) memoryInfo.totalMem) / 1048576.0f);
                    }
                    dVar.f4809c = d.f4807e;
                    dVar.f4810d = b(((float) memoryInfo.availMem) / 1048576.0f);
                    dVar.a = b(((float) Debug.getPss()) / 1024.0f);
                }
                if (memoryInfo3 != null) {
                    dVar.f4808b = b((((memoryInfo3.getTotalPrivateClean() + memoryInfo3.getTotalPrivateDirty()) + memoryInfo3.getTotalSharedClean()) + memoryInfo3.getTotalSharedDirty()) / 1024.0f);
                }
            }
            return dVar;
        }
        return (d) invokeV.objValue;
    }

    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (m()) {
                ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                f4800c.getMemoryInfo(memoryInfo);
                String b2 = b(((float) memoryInfo.totalMem) / 1048576.0f);
                c.a.p0.a.e0.d.k("SwanMemoryProperty", "getMemoryInfo sysTotalMemory=" + b2);
                return b2;
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public void l() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && this.f4804b == null) {
            this.f4804b = j();
        }
    }

    public final boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            c.a.p0.a.e0.d.k("SwanMemoryProperty", "getMemoryInfo mMemSample =" + f4802e + "; mRandomNum =" + f4803f);
            int i2 = f4802e;
            if (i2 <= 0) {
                return false;
            }
            return i2 >= 100 || f4803f <= i2;
        }
        return invokeV.booleanValue;
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f4804b = null;
        }
    }

    public e() {
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
        this.a = new DecimalFormat("#.###");
    }
}

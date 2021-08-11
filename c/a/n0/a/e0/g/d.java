package c.a.n0.a.e0.g;

import android.app.ActivityManager;
import android.os.Debug;
import android.os.Process;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.Log;
import java.text.DecimalFormat;
import java.util.Random;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static ActivityManager f5064b;

    /* renamed from: c  reason: collision with root package name */
    public static int f5065c;

    /* renamed from: d  reason: collision with root package name */
    public static int f5066d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public DecimalFormat f5067a;

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final d f5068a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1352656176, "Lc/a/n0/a/e0/g/d$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1352656176, "Lc/a/n0/a/e0/g/d$b;");
                    return;
                }
            }
            f5068a = new d(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1833807730, "Lc/a/n0/a/e0/g/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1833807730, "Lc/a/n0/a/e0/g/d;");
                return;
            }
        }
        f5064b = (ActivityManager) c.a.n0.a.c1.a.b().getSystemService("activity");
        c.a.n0.a.c1.a.Z().getSwitch("swan_memory_sample", 0);
        f5065c = 0;
        f5066d = new Random().nextInt(100);
    }

    public /* synthetic */ d(a aVar) {
        this();
    }

    public static d b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? b.f5068a : (d) invokeV.objValue;
    }

    public final String a(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(1048576, this, f2)) == null) ? this.f5067a.format(f2) : (String) invokeF.objValue;
    }

    public String c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            if (e()) {
                JSONObject jSONObject = new JSONObject();
                try {
                    c.a.n0.a.e0.d.h("SwanMemoryProperty", "getMemoryInfo mainPid: " + i2);
                    Debug.MemoryInfo[] processMemoryInfo = f5064b.getProcessMemoryInfo(new int[]{Process.myPid(), i2});
                    if (processMemoryInfo != null && processMemoryInfo.length == 2) {
                        Debug.MemoryInfo memoryInfo = processMemoryInfo[0];
                        if (memoryInfo != null) {
                            jSONObject.put("smart_app_used_mem", a(((float) Debug.getPss()) / 1024.0f));
                            jSONObject.put("total_rss", a((((memoryInfo.getTotalPrivateClean() + memoryInfo.getTotalPrivateDirty()) + memoryInfo.getTotalSharedClean()) + memoryInfo.getTotalSharedDirty()) / 1024.0f));
                            jSONObject.put("private_clean", a(memoryInfo.getTotalPrivateClean() / 1024.0f));
                            jSONObject.put("private_dirty", a(memoryInfo.getTotalPrivateDirty() / 1024.0f));
                            jSONObject.put("shared_clean", a(memoryInfo.getTotalSharedClean() / 1024.0f));
                            jSONObject.put("shared_dirty", a(memoryInfo.getTotalSharedDirty() / 1024.0f));
                        }
                        Debug.MemoryInfo memoryInfo2 = processMemoryInfo[1];
                        if (memoryInfo2 != null) {
                            jSONObject.put("host_used_mem", a((((memoryInfo2.getTotalPrivateClean() + memoryInfo2.getTotalPrivateDirty()) + memoryInfo2.getTotalSharedClean()) + memoryInfo2.getTotalSharedDirty()) / 1024.0f));
                        }
                    }
                    ActivityManager.MemoryInfo memoryInfo3 = new ActivityManager.MemoryInfo();
                    f5064b.getMemoryInfo(memoryInfo3);
                    jSONObject.put("sys_free_mem", a(((float) memoryInfo3.availMem) / 1048576.0f));
                    jSONObject.put("sys_low_mem", memoryInfo3.lowMemory ? "1" : "0");
                    jSONObject.put("native_heap", a(((float) Debug.getNativeHeapSize()) / 1048576.0f));
                    jSONObject.put("native_heap_alloc", a(((float) Debug.getNativeHeapAllocatedSize()) / 1048576.0f));
                    jSONObject.put("vm_max_mem", a(((float) Runtime.getRuntime().maxMemory()) / 1048576.0f));
                    jSONObject.put("vm_total_mem", a(((float) Runtime.getRuntime().totalMemory()) / 1048576.0f));
                    jSONObject.put("vm_free_mem", a(((float) Runtime.getRuntime().freeMemory()) / 1048576.0f));
                    jSONObject.put("thread_count", Thread.activeCount());
                } catch (Exception e2) {
                    c.a.n0.a.e0.d.h("SwanMemoryProperty", "getMemoryInfo: " + Log.getStackTraceString(e2));
                }
                c.a.n0.a.e0.d.h("SwanMemoryProperty", "getMemoryInfo result=" + jSONObject);
                return jSONObject.toString();
            }
            return "";
        }
        return (String) invokeI.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (e()) {
                ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                f5064b.getMemoryInfo(memoryInfo);
                String a2 = a(((float) memoryInfo.totalMem) / 1048576.0f);
                c.a.n0.a.e0.d.h("SwanMemoryProperty", "getMemoryInfo sysTotalMemory=" + a2);
                return a2;
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public final boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            c.a.n0.a.e0.d.h("SwanMemoryProperty", "getMemoryInfo mMemSample =" + f5065c + "; mRandomNum =" + f5066d);
            int i2 = f5065c;
            if (i2 <= 0) {
                return false;
            }
            return i2 >= 100 || f5066d <= i2;
        }
        return invokeV.booleanValue;
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
        this.f5067a = new DecimalFormat("#.###");
    }
}

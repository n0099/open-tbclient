package c.a.o0.a.m2.f;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.a.k;
import c.a.o0.a.k2.g.h;
import c.a.o0.a.v1.c.f.c;
import c.a.o0.a.v1.c.f.e;
import c.a.o0.a.v2.j0;
import c.a.o0.a.v2.q;
import c.a.o0.n.h.d;
import c.a.o0.t.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.extcore.cores.SwanAppCores;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f7369a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.o0.a.m2.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class RunnableC0298a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f7370e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f7371f;

        public RunnableC0298a(long j2, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Long.valueOf(j2), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7370e = j2;
            this.f7371f = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    c.a.o0.a.m2.a.c().a(this.f7370e, this.f7371f);
                } catch (Exception e2) {
                    if (a.f7369a) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f7372a;

        /* renamed from: b  reason: collision with root package name */
        public String f7373b;

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
                    return;
                }
            }
            this.f7372a = 0;
        }

        public static b a(int i2, String str) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(65537, null, i2, str)) == null) {
                b bVar = new b();
                bVar.f7372a = i2;
                bVar.f7373b = str;
                return bVar;
            }
            return (b) invokeIL.objValue;
        }

        public static b b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? a(1, str) : (b) invokeL.objValue;
        }

        public static b d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? a(0, "") : (b) invokeV.objValue;
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f7372a == 0 : invokeV.booleanValue;
        }

        @NonNull
        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return "RemoteCoreUpdateStatus{statusCode=" + this.f7372a + ", message='" + this.f7373b + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
            }
            return (String) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1157565559, "Lc/a/o0/a/m2/f/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1157565559, "Lc/a/o0/a/m2/f/a;");
                return;
            }
        }
        f7369a = k.f7049a;
    }

    public static void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65538, null, i2) == null) {
            l("0", 0L, i2);
        }
    }

    public static b c(d dVar, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, dVar, i2)) == null) {
            c.a.o0.a.e0.d.h("RemoteSwanCoreControl", "doRemoteUpdate start. framework: " + dVar);
            if (dVar == null) {
                return b.b("framework is null.");
            }
            long j2 = dVar.f11859i;
            if (j2 == 0) {
                return b.b("invalid version code : " + dVar.f11860j);
            } else if (!j0.a(new File(dVar.f11851a), dVar.m)) {
                return b.b("sign failed.");
            } else {
                String path = h(j2, i2).getPath();
                if (!c.a.o0.t.d.T(dVar.f11851a, path)) {
                    return b.b("unzip bundle failed.");
                }
                if (i2 == 0) {
                    boolean A = c.a.o0.t.d.A(dVar.f11851a, path);
                    if (f7369a) {
                        String str = "isZipFileMatchUnzipResult:" + A + ",path:" + path;
                    }
                    if (!A) {
                        c.a.o0.a.m2.b.m(1, i2, j2);
                        c.a.o0.t.d.L(path);
                        if (!c.a.o0.t.d.T(dVar.f11851a, path)) {
                            return b.b("unzip bundle failed.");
                        }
                    }
                }
                if (f7369a) {
                    String b2 = f.b(new File(dVar.f11851a), false);
                    if (!TextUtils.isEmpty(b2)) {
                        h.a().putString(c.a.o0.a.m2.a.d(i2), b2);
                    }
                }
                if (ProcessUtils.isMainProcess()) {
                    c.a.o0.a.m2.b.b(g(i2), k(e(i2), j2));
                }
                l(dVar.f11860j, dVar.f11859i, i2);
                c.a.o0.a.e0.d.h("RemoteSwanCoreControl", "doRemoteUpdate end. version = " + j2);
                return b.d();
            }
        }
        return (b) invokeLI.objValue;
    }

    public static SwanCoreVersion d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i2)) == null) {
            SwanCoreVersion swanCoreVersion = new SwanCoreVersion();
            swanCoreVersion.swanCoreType = 1;
            swanCoreVersion.swanCoreVersionCode = e(i2);
            swanCoreVersion.swanCoreVersionName = f(i2);
            swanCoreVersion.swanCorePath = h(swanCoreVersion.swanCoreVersionCode, i2).getPath();
            return swanCoreVersion;
        }
        return (SwanCoreVersion) invokeI.objValue;
    }

    public static long e(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(AdIconUtil.AD_TEXT_ID, null, i2)) == null) ? h.a().getLong(i(i2), 0L) : invokeI.longValue;
    }

    public static String f(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(AdIconUtil.BAIDU_LOGO_ID, null, i2)) == null) ? h.a().getString(j(i2), "") : (String) invokeI.objValue;
    }

    public static File g(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65543, null, i2)) == null) ? new File(c.a.o0.a.m2.b.d(i2), "remote") : (File) invokeI.objValue;
    }

    public static File h(long j2, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{Long.valueOf(j2), Integer.valueOf(i2)})) == null) ? new File(g(i2), String.valueOf(j2)) : (File) invokeCommon.objValue;
    }

    public static String i(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65545, null, i2)) == null) ? i2 == 1 ? "aigames_cur_remote_ver_key" : "aiapps_cur_remote_ver_key" : (String) invokeI.objValue;
    }

    public static String j(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65546, null, i2)) == null) ? i2 == 1 ? "aigames_cur_remote_ver_name_key" : "aiapps_cur_remote_ver_name_key" : (String) invokeI.objValue;
    }

    public static ArrayList<Long> k(long j2, long j3) {
        InterceptResult invokeCommon;
        SwanCoreVersion swanCoreVersion;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65547, null, new Object[]{Long.valueOf(j2), Long.valueOf(j3)})) == null) {
            ArrayList<Long> arrayList = new ArrayList<>();
            if (j2 != 0) {
                arrayList.add(Long.valueOf(j2));
            }
            arrayList.add(Long.valueOf(j3));
            for (c cVar : e.k().q()) {
                SwanAppCores n = cVar.n();
                if (cVar.H() && n != null && (swanCoreVersion = n.getSwanCoreVersion()) != null && !arrayList.contains(Long.valueOf(swanCoreVersion.swanCoreVersionCode))) {
                    arrayList.add(Long.valueOf(swanCoreVersion.swanCoreVersionCode));
                }
            }
            if (f7369a) {
                String str = "SwanCoreVersion usedVersions: " + Arrays.toString(arrayList.toArray());
            }
            return arrayList;
        }
        return (ArrayList) invokeCommon.objValue;
    }

    public static void l(String str, long j2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65548, null, new Object[]{str, Long.valueOf(j2), Integer.valueOf(i2)}) == null) {
            h.a().putString(j(i2), str);
            h.a().putLong(i(i2), j2);
            q.j(new RunnableC0298a(j2, i2), "cacheSwanCoreInfo");
        }
    }
}

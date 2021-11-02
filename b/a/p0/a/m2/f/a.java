package b.a.p0.a.m2.f;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.k;
import b.a.p0.a.k2.g.h;
import b.a.p0.a.v1.c.f.c;
import b.a.p0.a.v1.c.f.e;
import b.a.p0.a.v2.j0;
import b.a.p0.a.v2.q;
import b.a.p0.n.h.d;
import b.a.p0.t.f;
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
    public static final boolean f6714a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b.a.p0.a.m2.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class RunnableC0295a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f6715e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f6716f;

        public RunnableC0295a(long j, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Long.valueOf(j), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6715e = j;
            this.f6716f = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    b.a.p0.a.m2.a.c().a(this.f6715e, this.f6716f);
                } catch (Exception e2) {
                    if (a.f6714a) {
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
        public int f6717a;

        /* renamed from: b  reason: collision with root package name */
        public String f6718b;

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
            this.f6717a = 0;
        }

        public static b a(int i2, String str) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(65537, null, i2, str)) == null) {
                b bVar = new b();
                bVar.f6717a = i2;
                bVar.f6718b = str;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f6717a == 0 : invokeV.booleanValue;
        }

        @NonNull
        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return "RemoteCoreUpdateStatus{statusCode=" + this.f6717a + ", message='" + this.f6718b + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
            }
            return (String) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1797182455, "Lb/a/p0/a/m2/f/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1797182455, "Lb/a/p0/a/m2/f/a;");
                return;
            }
        }
        f6714a = k.f6397a;
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
            b.a.p0.a.e0.d.h("RemoteSwanCoreControl", "doRemoteUpdate start. framework: " + dVar);
            if (dVar == null) {
                return b.b("framework is null.");
            }
            long j = dVar.f11078i;
            if (j == 0) {
                return b.b("invalid version code : " + dVar.j);
            } else if (!j0.a(new File(dVar.f11070a), dVar.m)) {
                return b.b("sign failed.");
            } else {
                String path = h(j, i2).getPath();
                if (!b.a.p0.t.d.T(dVar.f11070a, path)) {
                    return b.b("unzip bundle failed.");
                }
                if (i2 == 0) {
                    boolean A = b.a.p0.t.d.A(dVar.f11070a, path);
                    if (f6714a) {
                        String str = "isZipFileMatchUnzipResult:" + A + ",path:" + path;
                    }
                    if (!A) {
                        b.a.p0.a.m2.b.m(1, i2, j);
                        b.a.p0.t.d.L(path);
                        if (!b.a.p0.t.d.T(dVar.f11070a, path)) {
                            return b.b("unzip bundle failed.");
                        }
                    }
                }
                if (f6714a) {
                    String b2 = f.b(new File(dVar.f11070a), false);
                    if (!TextUtils.isEmpty(b2)) {
                        h.a().putString(b.a.p0.a.m2.a.d(i2), b2);
                    }
                }
                if (ProcessUtils.isMainProcess()) {
                    b.a.p0.a.m2.b.b(g(i2), k(e(i2), j));
                }
                l(dVar.j, dVar.f11078i, i2);
                b.a.p0.a.e0.d.h("RemoteSwanCoreControl", "doRemoteUpdate end. version = " + j);
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
        return (interceptable == null || (invokeI = interceptable.invokeI(65543, null, i2)) == null) ? new File(b.a.p0.a.m2.b.d(i2), "remote") : (File) invokeI.objValue;
    }

    public static File h(long j, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{Long.valueOf(j), Integer.valueOf(i2)})) == null) ? new File(g(i2), String.valueOf(j)) : (File) invokeCommon.objValue;
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

    public static ArrayList<Long> k(long j, long j2) {
        InterceptResult invokeCommon;
        SwanCoreVersion swanCoreVersion;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65547, null, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) {
            ArrayList<Long> arrayList = new ArrayList<>();
            if (j != 0) {
                arrayList.add(Long.valueOf(j));
            }
            arrayList.add(Long.valueOf(j2));
            for (c cVar : e.k().q()) {
                SwanAppCores n = cVar.n();
                if (cVar.H() && n != null && (swanCoreVersion = n.getSwanCoreVersion()) != null && !arrayList.contains(Long.valueOf(swanCoreVersion.swanCoreVersionCode))) {
                    arrayList.add(Long.valueOf(swanCoreVersion.swanCoreVersionCode));
                }
            }
            if (f6714a) {
                String str = "SwanCoreVersion usedVersions: " + Arrays.toString(arrayList.toArray());
            }
            return arrayList;
        }
        return (ArrayList) invokeCommon.objValue;
    }

    public static void l(String str, long j, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65548, null, new Object[]{str, Long.valueOf(j), Integer.valueOf(i2)}) == null) {
            h.a().putString(j(i2), str);
            h.a().putLong(i(i2), j);
            q.j(new RunnableC0295a(j, i2), "cacheSwanCoreInfo");
        }
    }
}

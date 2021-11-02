package b.a.p0.a.a2.n;

import b.a.p0.a.v2.q;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
/* loaded from: classes.dex */
public class d {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static int f4001a = -1;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppConfigData f4002e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ File f4003f;

        public a(SwanAppConfigData swanAppConfigData, File file, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppConfigData, file, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4002e = swanAppConfigData;
            this.f4003f = file;
        }

        @Override // java.lang.Runnable
        public void run() {
            FileOutputStream fileOutputStream;
            Throwable th;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f4002e == null) {
                return;
            }
            FileOutputStream fileOutputStream2 = null;
            try {
                fileOutputStream = new FileOutputStream(this.f4003f);
                try {
                    fileOutputStream.write(SwanAppConfigData.s.call2((f<SwanAppConfigData>) this.f4002e));
                    b.a.p0.t.d.d(fileOutputStream);
                } catch (Exception unused) {
                    fileOutputStream2 = fileOutputStream;
                    b.a.p0.t.d.d(fileOutputStream2);
                } catch (Throwable th2) {
                    th = th2;
                    b.a.p0.t.d.d(fileOutputStream);
                    throw th;
                }
            } catch (Exception unused2) {
            } catch (Throwable th3) {
                fileOutputStream = null;
                th = th3;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-262688704, "Lb/a/p0/a/a2/n/d;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-262688704, "Lb/a/p0/a/a2/n/d;");
        }
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f4001a == -1) {
                b.a.p0.a.c1.a.Z().getSwitch("swan_app_json_serialize", 0);
                f4001a = 0;
            }
            return f4001a == 1;
        }
        return invokeV.booleanValue;
    }

    public static SwanAppConfigData b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? c(str, false) : (SwanAppConfigData) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x006f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static SwanAppConfigData c(String str, boolean z) {
        InterceptResult invokeLZ;
        FileInputStream fileInputStream;
        SwanAppConfigData call;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65539, null, str, z)) == null) {
            System.currentTimeMillis();
            File file = new File(str, "app.json");
            FileInputStream fileInputStream2 = null;
            if (file.exists()) {
                String D = b.a.p0.t.d.D(file);
                File file2 = new File(str, "app_json_serialize3.kv");
                if (a() && !z && file2.exists()) {
                    try {
                        fileInputStream = new FileInputStream(file2);
                    } catch (Exception unused) {
                    } catch (Throwable th) {
                        th = th;
                    }
                    try {
                        int available = fileInputStream.available();
                        byte[] bArr = new byte[available];
                        if (available == fileInputStream.read(bArr) && (call = SwanAppConfigData.t.call(bArr)) != null) {
                            call.m = D;
                            b.a.p0.t.d.d(fileInputStream);
                            return call;
                        }
                        b.a.p0.t.d.d(fileInputStream);
                    } catch (Exception unused2) {
                        fileInputStream2 = fileInputStream;
                        b.a.p0.t.d.d(fileInputStream2);
                        SwanAppConfigData c2 = SwanAppConfigData.c(D, file.getParentFile());
                        if (a()) {
                        }
                        return c2;
                    } catch (Throwable th2) {
                        th = th2;
                        fileInputStream2 = fileInputStream;
                        b.a.p0.t.d.d(fileInputStream2);
                        throw th;
                    }
                }
                SwanAppConfigData c22 = SwanAppConfigData.c(D, file.getParentFile());
                if (a()) {
                    q.j(new a(c22, file2, str), "SwanAppConfigDataReader");
                }
                return c22;
            }
            return null;
        }
        return (SwanAppConfigData) invokeLZ.objValue;
    }
}

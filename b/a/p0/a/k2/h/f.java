package b.a.p0.a.k2.h;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import b.a.p0.a.k;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.storage.swankv.AshmemFileDescriptor;
import com.baidu.storage.swankv.SwanKV;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Map;
/* loaded from: classes.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f6489a;

    /* renamed from: b  reason: collision with root package name */
    public static final Map<String, e> f6490b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(22234830, "Lb/a/p0/a/k2/h/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(22234830, "Lb/a/p0/a/k2/h/f;");
                return;
            }
        }
        f6489a = k.f6397a;
        f6490b = new ArrayMap();
    }

    @Nullable
    public static AshmemFileDescriptor a(@NonNull String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, str, i2)) == null) {
            try {
                if (ProcessUtils.isMainProcess()) {
                    synchronized (f6490b) {
                        e eVar = f6490b.get(str);
                        if (eVar != null && eVar.a() != null) {
                            return eVar.a();
                        }
                        int ashmemFD = SwanKV.getAshmemFD(str, i2);
                        if (ashmemFD >= 0) {
                            AshmemFileDescriptor ashmemFileDescriptor = new AshmemFileDescriptor(str, ashmemFD, i2);
                            b.e(ashmemFileDescriptor);
                            return ashmemFileDescriptor;
                        }
                        return null;
                    }
                }
                return a.a(str, i2);
            } catch (Throwable th) {
                if (f6489a) {
                    th.printStackTrace();
                    return null;
                }
                return null;
            }
        }
        return (AshmemFileDescriptor) invokeLI.objValue;
    }

    public static synchronized void b(@NonNull AshmemFileDescriptor ashmemFileDescriptor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, ashmemFileDescriptor) == null) {
            synchronized (f.class) {
                if (ProcessUtils.isMainProcess()) {
                    return;
                }
                e eVar = f6490b.get(ashmemFileDescriptor.getName());
                if (eVar != null && eVar.a() != null && eVar.a().getAshmemFD() != ashmemFileDescriptor.getAshmemFD()) {
                    SwanKV b2 = eVar.b();
                    eVar.c(new SwanKV(ashmemFileDescriptor));
                    b2.o();
                }
            }
        }
    }
}

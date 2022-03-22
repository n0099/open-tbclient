package c.a.n0.a.x.q.d;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class b implements c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f7416c;
    public transient /* synthetic */ FieldHolder $fh;
    public final c.a.n0.a.x.q.c.a a;

    /* renamed from: b  reason: collision with root package name */
    public final int f7417b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1307974418, "Lc/a/n0/a/x/q/d/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1307974418, "Lc/a/n0/a/x/q/d/b;");
                return;
            }
        }
        f7416c = c.a.n0.a.a.a;
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new c.a.n0.a.x.q.c.c();
        this.f7417b = 30;
    }

    @Override // c.a.n0.a.x.q.d.c
    public c.a.n0.a.x.q.c.a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (c.a.n0.a.x.q.c.a) invokeV.objValue;
    }

    @Override // c.a.n0.a.x.q.d.c
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.n0.a.x.q.d.c
    public boolean c(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, str2, str3)) == null) {
            if (f7416c) {
                Log.d("GlobalRecorderStrategy", "prefetchId - " + str);
                Log.d("GlobalRecorderStrategy", "appId - " + str2);
                Log.d("GlobalRecorderStrategy", "url - " + str3);
            }
            c.a.n0.a.x.q.c.b a = this.a.a(str2, str3);
            if (a == null) {
                if (f7416c) {
                    Log.d("GlobalRecorderStrategy", "has no record, need prelink");
                }
                return true;
            } else if (!TextUtils.isEmpty(str)) {
                if (f7416c) {
                    Log.d("GlobalRecorderStrategy", "in preload stage, has record, not real prelink ");
                }
                return false;
            } else {
                String curProcessName = ProcessUtils.getCurProcessName();
                if (!TextUtils.equals(curProcessName, a.a)) {
                    if (f7416c) {
                        Log.d("GlobalRecorderStrategy", "process not match, current - " + curProcessName + ", record - " + a.a);
                    }
                    return true;
                }
                boolean z = System.currentTimeMillis() - a.f7413b >= ((long) (this.f7417b * 1000));
                if (f7416c) {
                    Log.d("GlobalRecorderStrategy", "url in recorder, time is out - " + z);
                }
                return z;
            }
        }
        return invokeLLL.booleanValue;
    }
}

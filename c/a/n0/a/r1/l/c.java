package c.a.n0.a.r1.l;

import android.content.ContentResolver;
import android.content.ContentValues;
import androidx.annotation.AnyThread;
import c.a.n0.a.j2.j;
import c.a.n0.a.v2.q;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class c {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static int f8162a = -1;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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

        @Override // java.lang.Runnable
        public void run() {
            c.a.n0.a.a2.e Q;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (Q = c.a.n0.a.a2.e.Q()) == null) {
                return;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("appKey", Q.getAppId());
            contentValues.put("launch_type", Integer.valueOf(j.b()));
            contentValues.put("source", Q.L().T());
            contentValues.put("time", Long.valueOf(System.currentTimeMillis()));
            ContentResolver contentResolver = c.a.n0.a.c1.a.b().getContentResolver();
            if (contentResolver != null) {
                contentResolver.insert(c.a.n0.a.j0.b.d.b(), contentValues);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1142583606, "Lc/a/n0/a/r1/l/c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1142583606, "Lc/a/n0/a/r1/l/c;");
        }
    }

    public static int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            int i2 = f8162a;
            if (i2 != -1) {
                return i2;
            }
            c.a.n0.a.c1.a.Z().getSwitch("swan_backstage_policy", 0);
            f8162a = 300;
            if (300 < 60) {
                f8162a = 60;
            } else if (300 > 3600) {
                f8162a = 3600;
            }
            return f8162a;
        }
        return invokeV.intValue;
    }

    @AnyThread
    public static void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            q.j(new a(), "SwanLaunchBehavior");
        }
    }
}

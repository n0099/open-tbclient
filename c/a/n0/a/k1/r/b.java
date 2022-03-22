package c.a.n0.a.k1.r;

import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class b implements c.a.n0.a.v0.f.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public Map<Runnable, String> f5391c;

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: c.a.n0.a.k1.r.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0367b {
        public static /* synthetic */ Interceptable $ic;
        public static final b a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1549776948, "Lc/a/n0/a/k1/r/b$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1549776948, "Lc/a/n0/a/k1/r/b$b;");
                    return;
                }
            }
            a = new b(null);
        }
    }

    public /* synthetic */ b(a aVar) {
        this();
    }

    public static b b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? C0367b.a : (b) invokeV.objValue;
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f5391c.isEmpty()) {
            return;
        }
        if (c.a.n0.a.v0.f.a.a) {
            Log.d("SwanPerformance", "main process batch handle thread, size = " + this.f5391c.size());
        }
        for (Map.Entry<Runnable, String> entry : this.f5391c.entrySet()) {
            if (entry != null) {
                ExecutorUtilsExt.postOnElastic(entry.getKey(), entry.getValue(), 2);
            }
        }
        this.f5391c.clear();
    }

    public void c(Message message) {
        Object obj;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, message) == null) || message == null || (obj = message.obj) == null || !(obj instanceof Bundle)) {
            return;
        }
        Bundle bundle = (Bundle) obj;
        boolean z = bundle.getBoolean("is_timeout", false);
        String string = bundle.getString("app_id", null);
        if (c.a.n0.a.v0.f.a.a) {
            Log.e("SwanPerformance", "main process launch end，timeout = " + z + " ; appId = " + string);
        }
        a();
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            if (c.a.n0.a.v0.f.a.a) {
                Log.e("SwanPerformance", "main process launch start，appId = " + str);
            }
            System.currentTimeMillis();
        }
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f5391c = new ConcurrentHashMap();
    }
}

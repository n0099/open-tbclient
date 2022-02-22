package c.a.d0.d0.g;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.nadcore.thread.task.ElasticTask;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static volatile a f2682b;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1522339752, "Lc/a/d0/d0/g/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1522339752, "Lc/a/d0/d0/g/a;");
        }
    }

    public a() {
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
        this.a = 0L;
    }

    public static a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f2682b == null) {
                synchronized (a.class) {
                    if (f2682b == null) {
                        f2682b = new a();
                    }
                }
            }
            return f2682b;
        }
        return (a) invokeV.objValue;
    }

    public ElasticTask a(@NonNull Runnable runnable, @NonNull String str, int i2) {
        InterceptResult invokeLLI;
        ElasticTask elasticTask;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048576, this, runnable, str, i2)) == null) {
            if (runnable != null && !TextUtils.isEmpty(str)) {
                synchronized (this) {
                    long j2 = this.a + 1;
                    this.a = j2;
                    elasticTask = new ElasticTask(runnable, str, j2, i2);
                }
                return elasticTask;
            }
            throw new IllegalArgumentException("illegal params");
        }
        return (ElasticTask) invokeLLI.objValue;
    }
}

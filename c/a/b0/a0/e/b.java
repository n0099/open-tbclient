package c.a.b0.a0.e;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.thread.task.ElasticTask;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final a[] a;

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
        this.a = new a[4];
        int length = c.a.b0.a0.a.s.length;
        for (int i4 = 0; i4 < 4; i4++) {
            this.a[i4] = new a();
        }
    }

    public double a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (c(0).d()) {
                double d2 = 0.0d;
                for (int i2 = 0; i2 < 4; i2++) {
                    d2 += this.a[i2].a() * c.a.b0.a0.a.s[i2];
                }
                return d2 / 1000.0d;
            }
            return 9999999.0d;
        }
        return invokeV.doubleValue;
    }

    public ElasticTask b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            for (int i2 = 0; i2 < 4; i2++) {
                if (!this.a[i2].d()) {
                    return this.a[i2].b();
                }
            }
            return null;
        }
        return (ElasticTask) invokeV.objValue;
    }

    public a c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) != null) {
            return (a) invokeI.objValue;
        }
        int i3 = 0;
        while (true) {
            int[] iArr = c.a.b0.a0.a.a;
            if (i3 < iArr.length) {
                if (iArr[i3] == i2) {
                    return this.a[i3];
                }
                i3++;
            } else {
                a[] aVarArr = this.a;
                return aVarArr[aVarArr.length - 1];
            }
        }
    }

    public void d(Runnable runnable, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048579, this, runnable, str, i2) == null) {
            c(i2).c(runnable, str, i2);
        }
    }

    public void e(ElasticTask elasticTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, elasticTask) == null) {
            c(elasticTask.b()).e(elasticTask);
        }
    }
}

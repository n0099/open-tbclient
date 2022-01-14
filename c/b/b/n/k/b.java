package c.b.b.n.k;

import c.b.b.q.l;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public l[] a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(339228176, "Lc/b/b/n/k/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(339228176, "Lc/b/b/n/k/b;");
                return;
            }
        }
        new c.b.b.n.a(1.0f, 1.0f, 1.0f, 1.0f);
    }

    public b(a aVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        new c.b.b.q.a();
        new c.b.b.q.a();
        new c.b.b.n.a(1.0f, 1.0f, 1.0f, 1.0f);
        int i4 = aVar.f27109f.f27361f;
        if (i4 != 0) {
            float[][] fArr = new float[i4];
            int[] iArr = new int[i4];
            if (i4 > 1) {
                l[] lVarArr = new l[i4];
                this.a = lVarArr;
                int length = lVarArr.length;
                for (int i5 = 0; i5 < length; i5++) {
                    this.a[i5] = new l();
                }
            }
            int[] iArr2 = new int[i4];
            return;
        }
        throw new IllegalArgumentException("The specified font must contain at least one texture page.");
    }
}

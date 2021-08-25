package c.a.o0.a.v1.a.b.c;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import c.a.o0.a.k;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public abstract class c implements a<c.a.o0.a.v1.a.b.a.b> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f9186b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f9187a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1631949763, "Lc/a/o0/a/v1/a/b/c/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1631949763, "Lc/a/o0/a/v1/a/b/c/c;");
                return;
            }
        }
        f9186b = k.f7049a;
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // c.a.o0.a.v1.a.b.c.a
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (!TextUtils.isEmpty(this.f9187a)) {
                return this.f9187a;
            }
            String str = System.currentTimeMillis() + "" + hashCode();
            this.f9187a = str;
            if (f9186b && c.a.o0.a.v1.a.b.d.a.a(str)) {
                throw new RuntimeException("illegal observer id");
            }
            return this.f9187a;
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.o0.a.v1.a.b.c.a
    public abstract /* synthetic */ void onEvent(@NonNull T t);
}

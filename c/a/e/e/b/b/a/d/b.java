package c.a.e.e.b.b.a.d;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
/* loaded from: classes.dex */
public class b implements h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f2102a;

    public b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f2102a = z;
    }

    @Override // c.a.e.e.b.b.a.d.h
    public Object a(c.a.e.e.b.b.a.e.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) {
            Class<?> a2 = cVar.a();
            if (a2 != Boolean.class && a2 != Boolean.TYPE) {
                if (a2 == Short.class || a2 == Short.TYPE) {
                    return Short.valueOf((short) (!this.f2102a ? 1 : 0));
                }
                if (a2 == Integer.class || a2 == Integer.TYPE) {
                    return Integer.valueOf(!this.f2102a ? 1 : 0);
                }
                if (a2 == Long.class || a2 == Long.TYPE) {
                    return Long.valueOf(!this.f2102a ? 1 : 0);
                }
                if (a2 == Float.class || a2 == Float.TYPE) {
                    return Float.valueOf(!this.f2102a ? 1 : 0);
                }
                if (a2 == Double.class || a2 == Double.TYPE) {
                    return Double.valueOf(!this.f2102a ? 1 : 0);
                }
                if (a2 == Character.class || a2 == Character.TYPE) {
                    return Character.valueOf((char) (!this.f2102a ? 1 : 0));
                }
                if (a2 == String.class) {
                    return String.valueOf(this.f2102a);
                }
                if (a2 == char[].class) {
                    return String.valueOf(this.f2102a).toCharArray();
                }
                if (a2 == byte[].class) {
                    try {
                        return c.a.e.e.p.c.e(String.valueOf(this.f2102a), 0);
                    } catch (IOException e2) {
                        e2.printStackTrace();
                        return null;
                    }
                }
                return null;
            }
            return Boolean.valueOf(this.f2102a);
        }
        return invokeL.objValue;
    }
}

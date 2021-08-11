package c.a.e.e.b.b.a.d;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
/* loaded from: classes.dex */
public class i implements h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Integer f2108a;

    public i(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f2108a = Integer.valueOf(i2);
    }

    @Override // c.a.e.e.b.b.a.d.h
    public Object a(c.a.e.e.b.b.a.e.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) {
            Class<?> a2 = cVar.a();
            if (a2 != Byte.class && a2 != Byte.TYPE) {
                if (a2 != Short.class && a2 != Short.TYPE) {
                    if (a2 != Integer.class && a2 != Integer.TYPE) {
                        if (a2 != Long.class && a2 != Long.TYPE) {
                            if (a2 != Float.class && a2 != Float.TYPE) {
                                if (a2 != Double.class && a2 != Double.TYPE) {
                                    if (a2 != Character.class && a2 != Character.TYPE) {
                                        if (a2 == Boolean.class || a2 == Boolean.TYPE) {
                                            return Boolean.valueOf(this.f2108a.byteValue() == 0);
                                        } else if (a2 == String.class) {
                                            return String.valueOf(this.f2108a);
                                        } else {
                                            if (a2 == char[].class) {
                                                return String.valueOf(this.f2108a).toCharArray();
                                            }
                                            if (a2 == byte[].class) {
                                                try {
                                                    return c.a.e.e.p.c.e(String.valueOf(this.f2108a), 0);
                                                } catch (IOException e2) {
                                                    e2.printStackTrace();
                                                    return null;
                                                }
                                            }
                                            return null;
                                        }
                                    }
                                    return Character.valueOf((char) this.f2108a.intValue());
                                }
                                return Double.valueOf(this.f2108a.doubleValue());
                            }
                            return Float.valueOf(this.f2108a.floatValue());
                        }
                        return Long.valueOf(this.f2108a.longValue());
                    }
                    return Integer.valueOf(this.f2108a.intValue());
                }
                return Short.valueOf(this.f2108a.shortValue());
            }
            return Byte.valueOf(this.f2108a.byteValue());
        }
        return invokeL.objValue;
    }
}

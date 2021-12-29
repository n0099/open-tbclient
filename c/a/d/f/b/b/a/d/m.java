package c.a.d.f.b.b.a.d;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
/* loaded from: classes.dex */
public class m implements h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Long a;

    public m(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = Long.valueOf(j2);
    }

    @Override // c.a.d.f.b.b.a.d.h
    public Object a(c.a.d.f.b.b.a.e.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) {
            Class<?> a = cVar.a();
            if (a != Byte.class && a != Byte.TYPE) {
                if (a != Short.class && a != Short.TYPE) {
                    if (a != Integer.class && a != Integer.TYPE) {
                        if (a != Long.class && a != Long.TYPE) {
                            if (a != Float.class && a != Float.TYPE) {
                                if (a != Double.class && a != Double.TYPE) {
                                    if (a != Character.class && a != Character.TYPE) {
                                        if (a == Boolean.class || a == Boolean.TYPE) {
                                            return Boolean.valueOf(this.a.byteValue() == 0);
                                        } else if (a == String.class) {
                                            return String.valueOf(this.a);
                                        } else {
                                            if (a == char[].class) {
                                                return String.valueOf(this.a).toCharArray();
                                            }
                                            if (a == byte[].class) {
                                                try {
                                                    return c.a.d.f.p.e.e(String.valueOf(this.a), 0);
                                                } catch (IOException e2) {
                                                    e2.printStackTrace();
                                                    return null;
                                                }
                                            }
                                            return null;
                                        }
                                    }
                                    return Character.valueOf((char) this.a.intValue());
                                }
                                return Double.valueOf(this.a.doubleValue());
                            }
                            return Float.valueOf(this.a.floatValue());
                        }
                        return Long.valueOf(this.a.longValue());
                    }
                    return Integer.valueOf(this.a.intValue());
                }
                return Short.valueOf(this.a.shortValue());
            }
            return Byte.valueOf(this.a.byteValue());
        }
        return invokeL.objValue;
    }
}

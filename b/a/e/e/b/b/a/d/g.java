package b.a.e.e.b.b.a.d;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
/* loaded from: classes.dex */
public class g implements h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Float f1647a;

    public g(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Float.valueOf(f2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f1647a = Float.valueOf(f2);
    }

    @Override // b.a.e.e.b.b.a.d.h
    public Object a(b.a.e.e.b.b.a.e.c cVar) {
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
                                            return Boolean.valueOf(this.f1647a.byteValue() == 0);
                                        } else if (a2 == String.class) {
                                            return String.valueOf(this.f1647a);
                                        } else {
                                            if (a2 == char[].class) {
                                                return String.valueOf(this.f1647a).toCharArray();
                                            }
                                            if (a2 == byte[].class) {
                                                try {
                                                    return b.a.e.e.p.c.e(String.valueOf(this.f1647a), 0);
                                                } catch (IOException e2) {
                                                    e2.printStackTrace();
                                                    return null;
                                                }
                                            }
                                            return null;
                                        }
                                    }
                                    return Character.valueOf((char) this.f1647a.intValue());
                                }
                                return Double.valueOf(this.f1647a.doubleValue());
                            }
                            return Float.valueOf(this.f1647a.floatValue());
                        }
                        return Long.valueOf(this.f1647a.longValue());
                    }
                    return Integer.valueOf(this.f1647a.intValue());
                }
                return Short.valueOf(this.f1647a.shortValue());
            }
            return Byte.valueOf(this.f1647a.byteValue());
        }
        return invokeL.objValue;
    }
}

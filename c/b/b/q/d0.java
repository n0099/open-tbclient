package c.b.b.q;

import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.reflect.ReflectionException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class d0<T> extends z<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public final c.b.b.q.p0.c f28177d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d0(Class<T> cls, int i2, int i3) {
        super(i2, i3);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cls, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        c.b.b.q.p0.c g2 = g(cls);
        this.f28177d = g2;
        if (g2 != null) {
            return;
        }
        throw new RuntimeException("Class cannot be created (missing no-arg constructor): " + cls.getName());
    }

    @Override // c.b.b.q.z
    public T d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                return (T) this.f28177d.b(null);
            } catch (Exception e2) {
                throw new GdxRuntimeException("Unable to create new instance: " + this.f28177d.a().getName(), e2);
            }
        }
        return (T) invokeV.objValue;
    }

    public final c.b.b.q.p0.c g(Class<T> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cls)) == null) {
            try {
                try {
                    return c.b.b.q.p0.b.b(cls, null);
                } catch (ReflectionException unused) {
                    return null;
                }
            } catch (Exception unused2) {
                c.b.b.q.p0.c c2 = c.b.b.q.p0.b.c(cls, null);
                c2.c(true);
                return c2;
            }
        }
        return (c.b.b.q.p0.c) invokeL.objValue;
    }
}

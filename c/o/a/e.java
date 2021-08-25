package c.o.a;

import androidx.core.view.InputDeviceCompat;
import c.o.a.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire2.FieldEncoding;
import com.squareup.wire2.ProtoAdapter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* loaded from: classes4.dex */
public final class e<E extends g> extends ProtoAdapter<E> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Class<E> f34302a;

    /* renamed from: b  reason: collision with root package name */
    public Method f34303b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(Class<E> cls) {
        super(FieldEncoding.VARINT, cls);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cls};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((FieldEncoding) objArr2[0], (Class) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f34302a = cls;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.squareup.wire2.ProtoAdapter
    /* renamed from: a */
    public E decode(c cVar) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) {
            int l = cVar.l();
            try {
                E e2 = (E) d().invoke(null, Integer.valueOf(l));
                if (e2 != null) {
                    return e2;
                }
                throw new ProtoAdapter.EnumConstantNotFoundException(l, this.f34302a);
            } catch (IllegalAccessException | InvocationTargetException e3) {
                throw new AssertionError(e3);
            }
        }
        return (E) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.squareup.wire2.ProtoAdapter
    /* renamed from: b */
    public void encode(d dVar, E e2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar, e2) == null) {
            dVar.q(e2.getValue());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.squareup.wire2.ProtoAdapter
    /* renamed from: c */
    public int encodedSize(E e2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, e2)) == null) ? d.i(e2.getValue()) : invokeL.intValue;
    }

    public final Method d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            Method method = this.f34303b;
            if (method != null) {
                return method;
            }
            try {
                Method method2 = this.f34302a.getMethod("fromValue", Integer.TYPE);
                this.f34303b = method2;
                return method2;
            } catch (NoSuchMethodException e2) {
                throw new AssertionError(e2);
            }
        }
        return (Method) invokeV.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, obj)) == null) ? (obj instanceof e) && ((e) obj).f34302a == this.f34302a : invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f34302a.hashCode() : invokeV.intValue;
    }
}

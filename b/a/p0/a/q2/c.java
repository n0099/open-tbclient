package b.a.p0.a.q2;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Locale;
/* loaded from: classes.dex */
public final class c<ValueT> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final String f7416a;

    /* renamed from: b  reason: collision with root package name */
    public ValueT f7417b;

    /* renamed from: c  reason: collision with root package name */
    public a<ValueT> f7418c;

    /* loaded from: classes.dex */
    public interface a<ValueT> {
        ValueT update() throws IllegalStateException;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v1, resolved type: b.a.p0.a.q2.e */
    /* JADX WARN: Multi-variable type inference failed */
    public c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f7416a = str;
        e.a().h(this);
    }

    public CharSequence a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ValueT valuet = this.f7417b;
            return valuet == null ? "" : valuet.toString();
        }
        return (CharSequence) invokeV.objValue;
    }

    public c<ValueT> b(a<ValueT> aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar)) == null) {
            this.f7418c = aVar;
            update();
            return this;
        }
        return (c) invokeL.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? String.format(Locale.getDefault(), "%s :: %s(%s)", super.toString(), this.f7416a, a()) : (String) invokeV.objValue;
    }

    public boolean update() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? update((a) this.f7418c) : invokeV.booleanValue;
    }

    public boolean update(a<ValueT> aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, aVar)) == null) {
            if (aVar != null) {
                try {
                    return update((c<ValueT>) aVar.update());
                } catch (IllegalStateException e2) {
                    b.a.p0.a.e0.d.l("Tracer", "index update IllegalStateException " + e2.getMessage());
                    return false;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v1, resolved type: b.a.p0.a.q2.e */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean update(ValueT valuet) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, valuet)) == null) {
            this.f7417b = valuet;
            e.a().e(this);
            return true;
        }
        return invokeL.booleanValue;
    }
}

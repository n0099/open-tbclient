package c.b.b.q;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public abstract class z<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int a;

    /* renamed from: b  reason: collision with root package name */
    public int f27543b;

    /* renamed from: c  reason: collision with root package name */
    public final c.b.b.q.a<T> f27544c;

    /* loaded from: classes9.dex */
    public interface a {
        void reset();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public z() {
        this(16, Integer.MAX_VALUE);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr = newInitContext.callArgs;
                this(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public void a(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, t) == null) {
        }
    }

    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            for (int i3 = 0; i3 < i2; i3++) {
                c.b.b.q.a<T> aVar = this.f27544c;
                if (aVar.f27361f < this.a) {
                    aVar.a(d());
                }
            }
            this.f27543b = Math.max(this.f27543b, this.f27544c.f27361f);
        }
    }

    public void c(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t) == null) {
            if (t != null) {
                c.b.b.q.a<T> aVar = this.f27544c;
                if (aVar.f27361f < this.a) {
                    aVar.a(t);
                    this.f27543b = Math.max(this.f27543b, this.f27544c.f27361f);
                    f(t);
                    return;
                }
                a(t);
                return;
            }
            throw new IllegalArgumentException("object cannot be null.");
        }
    }

    public abstract T d();

    public T e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            c.b.b.q.a<T> aVar = this.f27544c;
            return aVar.f27361f == 0 ? d() : aVar.pop();
        }
        return (T) invokeV.objValue;
    }

    public void f(T t) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, t) == null) && (t instanceof a)) {
            ((a) t).reset();
        }
    }

    public z(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f27544c = new c.b.b.q.a<>(false, i2);
        this.a = i3;
    }
}

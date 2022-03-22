package c.b.b.q;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Comparator;
/* loaded from: classes3.dex */
public class g0<T> extends a<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public T[] f22760e;

    /* renamed from: f  reason: collision with root package name */
    public T[] f22761f;

    /* renamed from: g  reason: collision with root package name */
    public int f22762g;

    public g0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // c.b.b.q.a
    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            r();
            super.clear();
        }
    }

    @Override // c.b.b.q.a
    public T i(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            r();
            return (T) super.i(i);
        }
        return (T) invokeI.objValue;
    }

    @Override // c.b.b.q.a
    public void insert(int i, T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, t) == null) {
            r();
            super.insert(i, t);
        }
    }

    @Override // c.b.b.q.a
    public boolean j(T t, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048579, this, t, z)) == null) {
            r();
            return super.j(t, z);
        }
        return invokeLZ.booleanValue;
    }

    @Override // c.b.b.q.a
    public void l(int i, T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048580, this, i, t) == null) {
            r();
            super.l(i, t);
        }
    }

    @Override // c.b.b.q.a
    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            r();
            super.m();
        }
    }

    public T[] p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            r();
            T[] tArr = this.a;
            this.f22760e = tArr;
            this.f22762g++;
            return tArr;
        }
        return (T[]) ((Object[]) invokeV.objValue);
    }

    @Override // c.b.b.q.a
    public T pop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            r();
            return (T) super.pop();
        }
        return (T) invokeV.objValue;
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            int max = Math.max(0, this.f22762g - 1);
            this.f22762g = max;
            T[] tArr = this.f22760e;
            if (tArr == null) {
                return;
            }
            if (tArr != this.a && max == 0) {
                this.f22761f = tArr;
                int length = tArr.length;
                for (int i = 0; i < length; i++) {
                    this.f22761f[i] = null;
                }
            }
            this.f22760e = null;
        }
    }

    public final void r() {
        T[] tArr;
        T[] tArr2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (tArr = this.f22760e) != null && tArr == (tArr2 = this.a)) {
            T[] tArr3 = this.f22761f;
            if (tArr3 != null) {
                int length = tArr3.length;
                int i = this.f22717b;
                if (length >= i) {
                    System.arraycopy(tArr2, 0, tArr3, 0, i);
                    this.a = this.f22761f;
                    this.f22761f = null;
                    return;
                }
            }
            k(this.a.length);
        }
    }

    @Override // c.b.b.q.a
    public void sort(Comparator<? super T> comparator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, comparator) == null) {
            r();
            super.sort(comparator);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g0(boolean z, int i) {
        super(z, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z), Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Boolean) objArr2[0]).booleanValue(), ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g0(Class cls) {
        super(cls);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cls};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Class) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }
}

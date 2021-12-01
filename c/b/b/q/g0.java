package c.b.b.q;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Comparator;
/* loaded from: classes7.dex */
public class g0<T> extends a<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: i  reason: collision with root package name */
    public T[] f27819i;

    /* renamed from: j  reason: collision with root package name */
    public T[] f27820j;

    /* renamed from: k  reason: collision with root package name */
    public int f27821k;

    public g0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // c.b.b.q.a
    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            q();
            super.clear();
        }
    }

    @Override // c.b.b.q.a
    public T h(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            q();
            return (T) super.h(i2);
        }
        return (T) invokeI.objValue;
    }

    @Override // c.b.b.q.a
    public boolean i(T t, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, t, z)) == null) {
            q();
            return super.i(t, z);
        }
        return invokeLZ.booleanValue;
    }

    @Override // c.b.b.q.a
    public void insert(int i2, T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i2, t) == null) {
            q();
            super.insert(i2, t);
        }
    }

    @Override // c.b.b.q.a
    public void k(int i2, T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048580, this, i2, t) == null) {
            q();
            super.k(i2, t);
        }
    }

    @Override // c.b.b.q.a
    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            q();
            super.l();
        }
    }

    public T[] o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            q();
            T[] tArr = this.f27767e;
            this.f27819i = tArr;
            this.f27821k++;
            return tArr;
        }
        return (T[]) ((Object[]) invokeV.objValue);
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            int max = Math.max(0, this.f27821k - 1);
            this.f27821k = max;
            T[] tArr = this.f27819i;
            if (tArr == null) {
                return;
            }
            if (tArr != this.f27767e && max == 0) {
                this.f27820j = tArr;
                int length = tArr.length;
                for (int i2 = 0; i2 < length; i2++) {
                    this.f27820j[i2] = null;
                }
            }
            this.f27819i = null;
        }
    }

    @Override // c.b.b.q.a
    public T pop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            q();
            return (T) super.pop();
        }
        return (T) invokeV.objValue;
    }

    public final void q() {
        T[] tArr;
        T[] tArr2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (tArr = this.f27819i) != null && tArr == (tArr2 = this.f27767e)) {
            T[] tArr3 = this.f27820j;
            if (tArr3 != null) {
                int length = tArr3.length;
                int i2 = this.f27768f;
                if (length >= i2) {
                    System.arraycopy(tArr2, 0, tArr3, 0, i2);
                    this.f27767e = this.f27820j;
                    this.f27820j = null;
                    return;
                }
            }
            j(this.f27767e.length);
        }
    }

    @Override // c.b.b.q.a
    public void sort(Comparator<? super T> comparator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, comparator) == null) {
            q();
            super.sort(comparator);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g0(boolean z, int i2) {
        super(z, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Class) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }
}

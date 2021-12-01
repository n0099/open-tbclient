package c.a.b0.s.p0;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.b0.s.p0.c;
import c.a.b0.s.v0.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class a<T extends c> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Object[] a;

    /* renamed from: b  reason: collision with root package name */
    public int f2076b;

    /* renamed from: c  reason: collision with root package name */
    public int f2077c;

    /* renamed from: d  reason: collision with root package name */
    public final int f2078d;

    public a(int i2) {
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
        this.f2077c = 0;
        i2 = i2 <= 0 ? 2 : i2;
        this.f2078d = i2;
        this.a = new Object[i2];
    }

    public T a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f2076b > 0) {
                if (this.f2077c >= this.f2078d) {
                    h.j("acquire(), active player is overSize : " + this.f2078d);
                }
                int i2 = this.f2076b;
                int i3 = i2 - 1;
                Object[] objArr = this.a;
                T t = (T) objArr[i3];
                objArr[i3] = null;
                this.f2076b = i2 - 1;
                this.f2077c++;
                t.onInit();
                return t;
            }
            return null;
        }
        return (T) invokeV.objValue;
    }

    @Nullable
    public T b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (this.f2076b > 0) {
                if (this.f2077c >= this.f2078d) {
                    h.j("acquire(" + str + "), active player is overSize : " + this.f2078d);
                }
                int i2 = -1;
                for (int i3 = 0; i3 < this.f2076b; i3++) {
                    if (((c) this.a[i3]).verify(str)) {
                        i2 = i3;
                    }
                }
                if (i2 != -1) {
                    this.f2077c++;
                    Object[] objArr = this.a;
                    T t = (T) objArr[i2];
                    objArr[i2] = null;
                    while (true) {
                        int i4 = this.f2076b;
                        if (i2 < i4 - 1) {
                            Object[] objArr2 = this.a;
                            int i5 = i2 + 1;
                            objArr2[i2] = objArr2[i5];
                            i2 = i5;
                        } else {
                            this.a[i4 - 1] = null;
                            this.f2076b = i4 - 1;
                            t.onInit();
                            return t;
                        }
                    }
                }
            }
            return null;
        }
        return (T) invokeL.objValue;
    }

    public void c(T t) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t) == null) || e(t)) {
            return;
        }
        d(t);
        t.onInit();
    }

    public final void d(T t) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, t) == null) || e(t)) {
            return;
        }
        int i2 = this.f2076b;
        Object[] objArr = this.a;
        if (i2 < objArr.length) {
            objArr[i2] = t;
            this.f2076b = i2 + 1;
            return;
        }
        int i3 = 0;
        while (true) {
            Object[] objArr2 = this.a;
            if (i3 < objArr2.length - 1) {
                int i4 = i3 + 1;
                objArr2[i3] = objArr2[i4];
                i3 = i4;
            } else {
                objArr2[this.f2076b - 1] = t;
                return;
            }
        }
    }

    public final boolean e(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, t)) == null) {
            for (int i2 = 0; i2 < this.f2076b; i2++) {
                if (this.a[i2] == t) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void f(@NonNull T t) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, t) == null) || e(t)) {
            return;
        }
        d(t);
        this.f2077c--;
        t.onRelease();
    }
}

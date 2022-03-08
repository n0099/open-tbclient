package c.a.r0.k4.i;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public abstract class b<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public T f18689b;

    /* renamed from: c  reason: collision with root package name */
    public T f18690c;

    /* renamed from: d  reason: collision with root package name */
    public a f18691d;

    /* renamed from: e  reason: collision with root package name */
    public String f18692e;

    /* renamed from: f  reason: collision with root package name */
    public Long f18693f;

    /* loaded from: classes2.dex */
    public interface a<T> {
        void a(b<T> bVar, T t, T t2);
    }

    public b(String str, T t, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, t, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f18692e = str2;
        i(t);
        j(str);
    }

    public T a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f18690c : (T) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a : (String) invokeV.objValue;
    }

    public long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f18693f == null && !TextUtils.isEmpty(this.f18692e)) {
                d();
            }
            Long l = this.f18693f;
            if (l == null) {
                return 0L;
            }
            return l.longValue();
        }
        return invokeV.longValue;
    }

    public T d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.f18689b == null && !TextUtils.isEmpty(this.a)) {
                this.f18689b = f();
                if (!TextUtils.isEmpty(this.f18692e)) {
                    this.f18693f = Long.valueOf(e(this.f18692e, 0L));
                }
            }
            return this.f18689b;
        }
        return (T) invokeV.objValue;
    }

    public abstract long e(String str, long j2);

    public abstract T f();

    public abstract void g(String str, long j2);

    public abstract void h();

    public void i(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, t) == null) {
            this.f18690c = t;
        }
    }

    public void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.a = str;
        }
    }

    public void k(T t) {
        T t2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, t) == null) || TextUtils.isEmpty(this.a) || t == (t2 = this.f18689b)) {
            return;
        }
        if (t == null || !t.equals(t2)) {
            T t3 = this.f18689b;
            this.f18689b = t;
            h();
            if (!TextUtils.isEmpty(this.f18692e)) {
                Long valueOf = Long.valueOf(System.currentTimeMillis());
                this.f18693f = valueOf;
                g(this.f18692e, valueOf.longValue());
            }
            a aVar = this.f18691d;
            if (aVar != null) {
                aVar.a(this, t3, t);
            }
        }
    }
}

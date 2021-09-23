package c.a.r0.w3.i;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public abstract class b<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f28227a;

    /* renamed from: b  reason: collision with root package name */
    public T f28228b;

    /* renamed from: c  reason: collision with root package name */
    public T f28229c;

    /* renamed from: d  reason: collision with root package name */
    public a f28230d;

    /* renamed from: e  reason: collision with root package name */
    public String f28231e;

    /* renamed from: f  reason: collision with root package name */
    public Long f28232f;

    /* loaded from: classes4.dex */
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
        this.f28231e = str2;
        i(t);
        j(str);
    }

    public T a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f28229c : (T) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f28227a : (String) invokeV.objValue;
    }

    public long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f28232f == null && !TextUtils.isEmpty(this.f28231e)) {
                d();
            }
            Long l = this.f28232f;
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
            if (this.f28228b == null && !TextUtils.isEmpty(this.f28227a)) {
                this.f28228b = f();
                if (!TextUtils.isEmpty(this.f28231e)) {
                    this.f28232f = Long.valueOf(e(this.f28231e, 0L));
                }
            }
            return this.f28228b;
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
            this.f28229c = t;
        }
    }

    public void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.f28227a = str;
        }
    }

    public void k(T t) {
        T t2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, t) == null) || TextUtils.isEmpty(this.f28227a) || t == (t2 = this.f28228b)) {
            return;
        }
        if (t == null || !t.equals(t2)) {
            T t3 = this.f28228b;
            this.f28228b = t;
            h();
            if (!TextUtils.isEmpty(this.f28231e)) {
                Long valueOf = Long.valueOf(System.currentTimeMillis());
                this.f28232f = valueOf;
                g(this.f28231e, valueOf.longValue());
            }
            a aVar = this.f28230d;
            if (aVar != null) {
                aVar.a(this, t3, t);
            }
        }
    }
}

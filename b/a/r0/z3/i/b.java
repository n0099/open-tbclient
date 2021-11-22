package b.a.r0.z3.i;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public abstract class b<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f29451a;

    /* renamed from: b  reason: collision with root package name */
    public T f29452b;

    /* renamed from: c  reason: collision with root package name */
    public T f29453c;

    /* renamed from: d  reason: collision with root package name */
    public a f29454d;

    /* renamed from: e  reason: collision with root package name */
    public String f29455e;

    /* renamed from: f  reason: collision with root package name */
    public Long f29456f;

    /* loaded from: classes6.dex */
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
        this.f29455e = str2;
        i(t);
        j(str);
    }

    public T a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f29453c : (T) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f29451a : (String) invokeV.objValue;
    }

    public long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f29456f == null && !TextUtils.isEmpty(this.f29455e)) {
                d();
            }
            Long l = this.f29456f;
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
            if (this.f29452b == null && !TextUtils.isEmpty(this.f29451a)) {
                this.f29452b = f();
                if (!TextUtils.isEmpty(this.f29455e)) {
                    this.f29456f = Long.valueOf(e(this.f29455e, 0L));
                }
            }
            return this.f29452b;
        }
        return (T) invokeV.objValue;
    }

    public abstract long e(String str, long j);

    public abstract T f();

    public abstract void g(String str, long j);

    public abstract void h();

    public void i(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, t) == null) {
            this.f29453c = t;
        }
    }

    public void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.f29451a = str;
        }
    }

    public void k(T t) {
        T t2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, t) == null) || TextUtils.isEmpty(this.f29451a) || t == (t2 = this.f29452b)) {
            return;
        }
        if (t == null || !t.equals(t2)) {
            T t3 = this.f29452b;
            this.f29452b = t;
            h();
            if (!TextUtils.isEmpty(this.f29455e)) {
                Long valueOf = Long.valueOf(System.currentTimeMillis());
                this.f29456f = valueOf;
                g(this.f29455e, valueOf.longValue());
            }
            a aVar = this.f29454d;
            if (aVar != null) {
                aVar.a(this, t3, t);
            }
        }
    }
}

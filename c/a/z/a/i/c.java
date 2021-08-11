package c.a.z.a.i;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f30993a;

    /* renamed from: b  reason: collision with root package name */
    public long f30994b;

    /* renamed from: c  reason: collision with root package name */
    public long f30995c;

    /* renamed from: d  reason: collision with root package name */
    public long f30996d;

    /* renamed from: e  reason: collision with root package name */
    public long f30997e;

    /* renamed from: f  reason: collision with root package name */
    public long f30998f;

    /* renamed from: g  reason: collision with root package name */
    public long f30999g;

    /* renamed from: h  reason: collision with root package name */
    public long f31000h;

    /* renamed from: i  reason: collision with root package name */
    public long f31001i;

    /* renamed from: j  reason: collision with root package name */
    public long f31002j;
    public String k;
    public String l;
    public boolean m;
    public StringBuilder n;

    public c(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f30998f = 1000L;
        this.m = false;
        this.n = new StringBuilder();
        this.k = str;
        this.l = str2;
        e();
    }

    public final void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            long currentTimeMillis = System.currentTimeMillis() - this.f31000h;
            this.f31001i = currentTimeMillis;
            this.f31002j = this.f30999g;
            this.f31000h = 0L;
            this.f30999g = 0L;
            if (this.m) {
                a(this.k, String.format("%s, PeriodTime: %d, Times: %d", this.l, Long.valueOf(currentTimeMillis), Long.valueOf(this.f31002j)));
            }
        }
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            String format = String.format("%s, Total: %d, Times: %d, Min: %d, Max: %d, Average：%f", this.l, Long.valueOf(this.f30996d), Long.valueOf(this.f30997e), Long.valueOf(this.f30995c), Long.valueOf(this.f30994b), Float.valueOf(((float) this.f30996d) / ((float) this.f30997e)));
            if (this.m) {
                a(this.k, format);
            }
            return format;
        }
        return (String) invokeV.objValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.f30993a == 0) {
                this.f30993a = System.currentTimeMillis();
                return;
            }
            long currentTimeMillis = System.currentTimeMillis() - this.f30993a;
            this.f30996d += currentTimeMillis;
            this.f30997e++;
            if (currentTimeMillis > this.f30994b) {
                this.f30994b = currentTimeMillis;
            } else if (currentTimeMillis < this.f30995c) {
                this.f30995c = currentTimeMillis;
            }
            if (this.m) {
                if (this.n.length() > 0) {
                    StringBuilder sb = this.n;
                    sb.delete(0, sb.length());
                }
                this.n.append(this.l);
                for (int i2 = (int) ((currentTimeMillis - 33) / 5); i2 > 0; i2--) {
                    this.n.append('.');
                }
                this.n.append(currentTimeMillis);
                a(this.k, this.n.toString());
            }
            this.f30999g++;
            if (this.f30998f > 0 && System.currentTimeMillis() - this.f31000h > this.f30998f) {
                b();
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            this.f30993a = currentTimeMillis2;
            if (this.f31000h == 0) {
                this.f31000h = currentTimeMillis2;
                this.f30999g = 0L;
            }
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f30993a = 0L;
            this.f30996d = 0L;
            this.f30997e = 0L;
            this.f30994b = Long.MIN_VALUE;
            this.f30995c = Long.MAX_VALUE;
        }
    }

    public void f(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048581, this, j2) == null) {
            this.f30998f = j2;
        }
    }
}

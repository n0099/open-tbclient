package c.a.b0.a.i;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;

    /* renamed from: b  reason: collision with root package name */
    public long f1592b;

    /* renamed from: c  reason: collision with root package name */
    public long f1593c;

    /* renamed from: d  reason: collision with root package name */
    public long f1594d;

    /* renamed from: e  reason: collision with root package name */
    public long f1595e;

    /* renamed from: f  reason: collision with root package name */
    public long f1596f;

    /* renamed from: g  reason: collision with root package name */
    public long f1597g;

    /* renamed from: h  reason: collision with root package name */
    public long f1598h;

    /* renamed from: i  reason: collision with root package name */
    public long f1599i;

    /* renamed from: j  reason: collision with root package name */
    public long f1600j;
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
        this.f1596f = 1000L;
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
            long currentTimeMillis = System.currentTimeMillis() - this.f1598h;
            this.f1599i = currentTimeMillis;
            this.f1600j = this.f1597g;
            this.f1598h = 0L;
            this.f1597g = 0L;
            if (this.m) {
                a(this.k, String.format("%s, PeriodTime: %d, Times: %d", this.l, Long.valueOf(currentTimeMillis), Long.valueOf(this.f1600j)));
            }
        }
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            String format = String.format("%s, Total: %d, Times: %d, Min: %d, Max: %d, Average：%f", this.l, Long.valueOf(this.f1594d), Long.valueOf(this.f1595e), Long.valueOf(this.f1593c), Long.valueOf(this.f1592b), Float.valueOf(((float) this.f1594d) / ((float) this.f1595e)));
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
            if (this.a == 0) {
                this.a = System.currentTimeMillis();
                return;
            }
            long currentTimeMillis = System.currentTimeMillis() - this.a;
            this.f1594d += currentTimeMillis;
            this.f1595e++;
            if (currentTimeMillis > this.f1592b) {
                this.f1592b = currentTimeMillis;
            } else if (currentTimeMillis < this.f1593c) {
                this.f1593c = currentTimeMillis;
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
            this.f1597g++;
            if (this.f1596f > 0 && System.currentTimeMillis() - this.f1598h > this.f1596f) {
                b();
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            this.a = currentTimeMillis2;
            if (this.f1598h == 0) {
                this.f1598h = currentTimeMillis2;
                this.f1597g = 0L;
            }
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.a = 0L;
            this.f1594d = 0L;
            this.f1595e = 0L;
            this.f1592b = Long.MIN_VALUE;
            this.f1593c = Long.MAX_VALUE;
        }
    }

    public void f(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048581, this, j2) == null) {
            this.f1596f = j2;
        }
    }
}

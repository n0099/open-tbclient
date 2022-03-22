package c.a.z.a.i;

import android.util.Log;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;

    /* renamed from: b  reason: collision with root package name */
    public long f22209b;

    /* renamed from: c  reason: collision with root package name */
    public long f22210c;

    /* renamed from: d  reason: collision with root package name */
    public long f22211d;

    /* renamed from: e  reason: collision with root package name */
    public long f22212e;

    /* renamed from: f  reason: collision with root package name */
    public long f22213f;

    /* renamed from: g  reason: collision with root package name */
    public long f22214g;

    /* renamed from: h  reason: collision with root package name */
    public long f22215h;
    public long i;
    public long j;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f22213f = 1000L;
        this.m = false;
        this.n = new StringBuilder();
        this.k = str;
        this.l = str2;
        e();
    }

    public final void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
            Log.d(str, str2);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            long currentTimeMillis = System.currentTimeMillis() - this.f22215h;
            this.i = currentTimeMillis;
            this.j = this.f22214g;
            this.f22215h = 0L;
            this.f22214g = 0L;
            if (this.m) {
                a(this.k, String.format("%s, PeriodTime: %d, Times: %d", this.l, Long.valueOf(currentTimeMillis), Long.valueOf(this.j)));
            }
        }
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            String format = String.format("%s, Total: %d, Times: %d, Min: %d, Max: %d, Average：%f", this.l, Long.valueOf(this.f22211d), Long.valueOf(this.f22212e), Long.valueOf(this.f22210c), Long.valueOf(this.f22209b), Float.valueOf(((float) this.f22211d) / ((float) this.f22212e)));
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
            this.f22211d += currentTimeMillis;
            this.f22212e++;
            if (currentTimeMillis > this.f22209b) {
                this.f22209b = currentTimeMillis;
            } else if (currentTimeMillis < this.f22210c) {
                this.f22210c = currentTimeMillis;
            }
            if (this.m) {
                if (this.n.length() > 0) {
                    StringBuilder sb = this.n;
                    sb.delete(0, sb.length());
                }
                this.n.append(this.l);
                for (int i = (int) ((currentTimeMillis - 33) / 5); i > 0; i--) {
                    this.n.append(IStringUtil.EXTENSION_SEPARATOR);
                }
                this.n.append(currentTimeMillis);
                a(this.k, this.n.toString());
            }
            this.f22214g++;
            if (this.f22213f > 0 && System.currentTimeMillis() - this.f22215h > this.f22213f) {
                b();
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            this.a = currentTimeMillis2;
            if (this.f22215h == 0) {
                this.f22215h = currentTimeMillis2;
                this.f22214g = 0L;
            }
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.a = 0L;
            this.f22211d = 0L;
            this.f22212e = 0L;
            this.f22209b = Long.MIN_VALUE;
            this.f22210c = Long.MAX_VALUE;
        }
    }

    public void f(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048581, this, j) == null) {
            this.f22213f = j;
        }
    }
}

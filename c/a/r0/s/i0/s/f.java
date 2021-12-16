package c.a.r0.s.i0.s;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.UrlParser.DataRes;
import tbclient.UrlParser.UrlParserResIdl;
/* loaded from: classes6.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f13089b;

    /* renamed from: c  reason: collision with root package name */
    public String f13090c;

    /* renamed from: d  reason: collision with root package name */
    public String f13091d;

    /* renamed from: e  reason: collision with root package name */
    public String f13092e;

    /* renamed from: f  reason: collision with root package name */
    public String f13093f;

    /* renamed from: g  reason: collision with root package name */
    public String f13094g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f13095h;

    /* renamed from: i  reason: collision with root package name */
    public String f13096i;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-236513838, "Lc/a/r0/s/i0/s/f;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-236513838, "Lc/a/r0/s/i0/s/f;");
        }
    }

    public f() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public void a(UrlParserResIdl urlParserResIdl) {
        DataRes dataRes;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, urlParserResIdl) == null) || urlParserResIdl == null || (dataRes = urlParserResIdl.data) == null) {
            return;
        }
        this.a = dataRes.status.intValue();
        this.f13089b = urlParserResIdl.data.url_type.intValue();
        DataRes dataRes2 = urlParserResIdl.data;
        this.f13091d = dataRes2.image;
        this.f13092e = dataRes2.title;
        this.f13093f = dataRes2.link_from;
        this.f13094g = dataRes2.price_txt;
        this.f13095h = dataRes2.is_recognize.intValue() == 1;
        this.f13096i = urlParserResIdl.data.description;
    }
}

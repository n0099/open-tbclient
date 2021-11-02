package b.a.q0.s.g0.s;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.UrlParser.DataRes;
import tbclient.UrlParser.UrlParserResIdl;
/* loaded from: classes4.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f13052a;

    /* renamed from: b  reason: collision with root package name */
    public int f13053b;

    /* renamed from: c  reason: collision with root package name */
    public String f13054c;

    /* renamed from: d  reason: collision with root package name */
    public String f13055d;

    /* renamed from: e  reason: collision with root package name */
    public String f13056e;

    /* renamed from: f  reason: collision with root package name */
    public String f13057f;

    /* renamed from: g  reason: collision with root package name */
    public String f13058g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f13059h;

    /* renamed from: i  reason: collision with root package name */
    public String f13060i;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1630069742, "Lb/a/q0/s/g0/s/f;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1630069742, "Lb/a/q0/s/g0/s/f;");
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
        this.f13052a = dataRes.status.intValue();
        this.f13053b = urlParserResIdl.data.url_type.intValue();
        DataRes dataRes2 = urlParserResIdl.data;
        this.f13055d = dataRes2.image;
        this.f13056e = dataRes2.title;
        this.f13057f = dataRes2.link_from;
        this.f13058g = dataRes2.price_txt;
        this.f13059h = dataRes2.is_recognize.intValue() == 1;
        this.f13060i = urlParserResIdl.data.description;
    }
}

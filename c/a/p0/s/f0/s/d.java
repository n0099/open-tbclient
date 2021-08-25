package c.a.p0.s.f0.s;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.UrlParser.DataRes;
import tbclient.UrlParser.UrlParserResIdl;
/* loaded from: classes3.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f13957a;

    /* renamed from: b  reason: collision with root package name */
    public int f13958b;

    /* renamed from: c  reason: collision with root package name */
    public String f13959c;

    /* renamed from: d  reason: collision with root package name */
    public String f13960d;

    /* renamed from: e  reason: collision with root package name */
    public String f13961e;

    /* renamed from: f  reason: collision with root package name */
    public String f13962f;

    /* renamed from: g  reason: collision with root package name */
    public String f13963g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f13964h;

    /* renamed from: i  reason: collision with root package name */
    public String f13965i;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1137776915, "Lc/a/p0/s/f0/s/d;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1137776915, "Lc/a/p0/s/f0/s/d;");
        }
    }

    public d() {
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
        this.f13957a = dataRes.status.intValue();
        this.f13958b = urlParserResIdl.data.url_type.intValue();
        DataRes dataRes2 = urlParserResIdl.data;
        this.f13960d = dataRes2.image;
        this.f13961e = dataRes2.title;
        this.f13962f = dataRes2.link_from;
        this.f13963g = dataRes2.price_txt;
        this.f13964h = dataRes2.is_recognize.intValue() == 1;
        this.f13965i = urlParserResIdl.data.description;
    }
}

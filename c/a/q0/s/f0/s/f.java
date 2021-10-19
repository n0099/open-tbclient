package c.a.q0.s.f0.s;

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
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f13930a;

    /* renamed from: b  reason: collision with root package name */
    public int f13931b;

    /* renamed from: c  reason: collision with root package name */
    public String f13932c;

    /* renamed from: d  reason: collision with root package name */
    public String f13933d;

    /* renamed from: e  reason: collision with root package name */
    public String f13934e;

    /* renamed from: f  reason: collision with root package name */
    public String f13935f;

    /* renamed from: g  reason: collision with root package name */
    public String f13936g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f13937h;

    /* renamed from: i  reason: collision with root package name */
    public String f13938i;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1266859696, "Lc/a/q0/s/f0/s/f;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1266859696, "Lc/a/q0/s/f0/s/f;");
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
        this.f13930a = dataRes.status.intValue();
        this.f13931b = urlParserResIdl.data.url_type.intValue();
        DataRes dataRes2 = urlParserResIdl.data;
        this.f13933d = dataRes2.image;
        this.f13934e = dataRes2.title;
        this.f13935f = dataRes2.link_from;
        this.f13936g = dataRes2.price_txt;
        this.f13937h = dataRes2.is_recognize.intValue() == 1;
        this.f13938i = urlParserResIdl.data.description;
    }
}

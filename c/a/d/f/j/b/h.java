package c.a.d.f.j.b;

import com.baidu.adp.lib.network.http.IHttpNet;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile boolean a;

    /* renamed from: b  reason: collision with root package name */
    public int f2163b;

    /* renamed from: c  reason: collision with root package name */
    public int f2164c;

    /* renamed from: d  reason: collision with root package name */
    public String f2165d;

    /* renamed from: e  reason: collision with root package name */
    public String f2166e;

    /* renamed from: f  reason: collision with root package name */
    public String f2167f;

    /* renamed from: g  reason: collision with root package name */
    public String f2168g;

    /* renamed from: h  reason: collision with root package name */
    public Map<String, List<String>> f2169h;
    public byte[] i;
    public int j;

    public h() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = false;
        this.f2163b = -1;
        this.f2164c = -1;
        this.f2165d = "";
        this.f2166e = "";
        this.f2167f = "";
        this.f2168g = "net error";
    }

    public void a(IHttpNet iHttpNet) throws Exception {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, iHttpNet) == null) || iHttpNet == null) {
            return;
        }
        this.f2163b = iHttpNet.getResponseCode();
        this.f2165d = iHttpNet.getContentEncoding();
        this.f2166e = iHttpNet.getContentType();
        this.f2167f = iHttpNet.getContentLength() + "";
        this.f2169h = iHttpNet.b();
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f2163b == 200 : invokeV.booleanValue;
    }
}

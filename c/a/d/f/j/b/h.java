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
    public int f2623b;

    /* renamed from: c  reason: collision with root package name */
    public int f2624c;

    /* renamed from: d  reason: collision with root package name */
    public String f2625d;

    /* renamed from: e  reason: collision with root package name */
    public String f2626e;

    /* renamed from: f  reason: collision with root package name */
    public String f2627f;

    /* renamed from: g  reason: collision with root package name */
    public Map<String, List<String>> f2628g;

    /* renamed from: h  reason: collision with root package name */
    public byte[] f2629h;

    /* renamed from: i  reason: collision with root package name */
    public int f2630i;

    public h() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = false;
        this.f2623b = -1;
        this.f2624c = -1;
        this.f2625d = "";
        this.f2626e = "";
        this.f2627f = "";
    }

    public void a(IHttpNet iHttpNet) throws Exception {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, iHttpNet) == null) || iHttpNet == null) {
            return;
        }
        this.f2623b = iHttpNet.getResponseCode();
        this.f2625d = iHttpNet.getContentEncoding();
        this.f2626e = iHttpNet.getContentType();
        this.f2627f = iHttpNet.getContentLength() + "";
        this.f2628g = iHttpNet.b();
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f2623b == 200 : invokeV.booleanValue;
    }
}

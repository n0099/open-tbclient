package c.a.e.e.j.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f2269a;

    /* renamed from: b  reason: collision with root package name */
    public int f2270b;

    /* renamed from: c  reason: collision with root package name */
    public int f2271c;

    /* renamed from: d  reason: collision with root package name */
    public String f2272d;

    /* renamed from: e  reason: collision with root package name */
    public String f2273e;

    /* renamed from: f  reason: collision with root package name */
    public String f2274f;

    /* renamed from: g  reason: collision with root package name */
    public Map<String, List<String>> f2275g;

    /* renamed from: h  reason: collision with root package name */
    public byte[] f2276h;

    /* renamed from: i  reason: collision with root package name */
    public int f2277i;

    public g() {
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
        this.f2269a = false;
        this.f2270b = -1;
        this.f2271c = -1;
        this.f2272d = "";
        this.f2273e = "";
        this.f2274f = "";
    }

    public void a(HttpURLConnection httpURLConnection) throws Exception {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, httpURLConnection) == null) || httpURLConnection == null) {
            return;
        }
        this.f2270b = httpURLConnection.getResponseCode();
        this.f2272d = httpURLConnection.getContentEncoding();
        this.f2273e = httpURLConnection.getContentType();
        this.f2274f = httpURLConnection.getContentLength() + "";
        this.f2275g = httpURLConnection.getHeaderFields();
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f2270b == 200 : invokeV.booleanValue;
    }
}

package c.a.d.f.j.a;

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
    public volatile boolean a;

    /* renamed from: b  reason: collision with root package name */
    public int f2811b;

    /* renamed from: c  reason: collision with root package name */
    public int f2812c;

    /* renamed from: d  reason: collision with root package name */
    public String f2813d;

    /* renamed from: e  reason: collision with root package name */
    public String f2814e;

    /* renamed from: f  reason: collision with root package name */
    public String f2815f;

    /* renamed from: g  reason: collision with root package name */
    public Map<String, List<String>> f2816g;

    /* renamed from: h  reason: collision with root package name */
    public byte[] f2817h;

    /* renamed from: i  reason: collision with root package name */
    public int f2818i;

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
        this.a = false;
        this.f2811b = -1;
        this.f2812c = -1;
        this.f2813d = "";
        this.f2814e = "";
        this.f2815f = "";
    }

    public void a(HttpURLConnection httpURLConnection) throws Exception {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, httpURLConnection) == null) || httpURLConnection == null) {
            return;
        }
        this.f2811b = httpURLConnection.getResponseCode();
        this.f2813d = httpURLConnection.getContentEncoding();
        this.f2814e = httpURLConnection.getContentType();
        this.f2815f = httpURLConnection.getContentLength() + "";
        this.f2816g = httpURLConnection.getHeaderFields();
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f2811b == 200 : invokeV.booleanValue;
    }
}

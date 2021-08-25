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
    public volatile boolean f2327a;

    /* renamed from: b  reason: collision with root package name */
    public int f2328b;

    /* renamed from: c  reason: collision with root package name */
    public int f2329c;

    /* renamed from: d  reason: collision with root package name */
    public String f2330d;

    /* renamed from: e  reason: collision with root package name */
    public String f2331e;

    /* renamed from: f  reason: collision with root package name */
    public String f2332f;

    /* renamed from: g  reason: collision with root package name */
    public Map<String, List<String>> f2333g;

    /* renamed from: h  reason: collision with root package name */
    public byte[] f2334h;

    /* renamed from: i  reason: collision with root package name */
    public int f2335i;

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
        this.f2327a = false;
        this.f2328b = -1;
        this.f2329c = -1;
        this.f2330d = "";
        this.f2331e = "";
        this.f2332f = "";
    }

    public void a(HttpURLConnection httpURLConnection) throws Exception {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, httpURLConnection) == null) || httpURLConnection == null) {
            return;
        }
        this.f2328b = httpURLConnection.getResponseCode();
        this.f2330d = httpURLConnection.getContentEncoding();
        this.f2331e = httpURLConnection.getContentType();
        this.f2332f = httpURLConnection.getContentLength() + "";
        this.f2333g = httpURLConnection.getHeaderFields();
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f2328b == 200 : invokeV.booleanValue;
    }
}

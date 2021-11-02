package b.a.e.e.j.a;

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
    public volatile boolean f1805a;

    /* renamed from: b  reason: collision with root package name */
    public int f1806b;

    /* renamed from: c  reason: collision with root package name */
    public int f1807c;

    /* renamed from: d  reason: collision with root package name */
    public String f1808d;

    /* renamed from: e  reason: collision with root package name */
    public String f1809e;

    /* renamed from: f  reason: collision with root package name */
    public String f1810f;

    /* renamed from: g  reason: collision with root package name */
    public Map<String, List<String>> f1811g;

    /* renamed from: h  reason: collision with root package name */
    public byte[] f1812h;

    /* renamed from: i  reason: collision with root package name */
    public int f1813i;

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
        this.f1805a = false;
        this.f1806b = -1;
        this.f1807c = -1;
        this.f1808d = "";
        this.f1809e = "";
        this.f1810f = "";
    }

    public void a(HttpURLConnection httpURLConnection) throws Exception {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, httpURLConnection) == null) || httpURLConnection == null) {
            return;
        }
        this.f1806b = httpURLConnection.getResponseCode();
        this.f1808d = httpURLConnection.getContentEncoding();
        this.f1809e = httpURLConnection.getContentType();
        this.f1810f = httpURLConnection.getContentLength() + "";
        this.f1811g = httpURLConnection.getHeaderFields();
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f1806b == 200 : invokeV.booleanValue;
    }
}

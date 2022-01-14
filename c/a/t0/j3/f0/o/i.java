package c.a.t0.j3.f0.o;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;
/* loaded from: classes7.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile boolean a;

    /* renamed from: b  reason: collision with root package name */
    public int f18367b;

    /* renamed from: c  reason: collision with root package name */
    public int f18368c;

    /* renamed from: d  reason: collision with root package name */
    public String f18369d;

    /* renamed from: e  reason: collision with root package name */
    public String f18370e;

    /* renamed from: f  reason: collision with root package name */
    public Map<String, List<String>> f18371f;

    /* renamed from: g  reason: collision with root package name */
    public byte[] f18372g;

    /* renamed from: h  reason: collision with root package name */
    public int f18373h;

    public i() {
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
        this.f18367b = -1;
        this.f18369d = "";
        this.f18370e = "";
    }

    public void a(HttpURLConnection httpURLConnection) throws Exception {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, httpURLConnection) == null) || httpURLConnection == null) {
            return;
        }
        this.f18367b = httpURLConnection.getResponseCode();
        this.f18369d = httpURLConnection.getContentEncoding();
        httpURLConnection.getContentType();
        this.f18370e = httpURLConnection.getContentLength() + "";
        this.f18371f = httpURLConnection.getHeaderFields();
    }
}

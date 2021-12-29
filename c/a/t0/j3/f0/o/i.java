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
    public int f18837b;

    /* renamed from: c  reason: collision with root package name */
    public int f18838c;

    /* renamed from: d  reason: collision with root package name */
    public String f18839d;

    /* renamed from: e  reason: collision with root package name */
    public String f18840e;

    /* renamed from: f  reason: collision with root package name */
    public Map<String, List<String>> f18841f;

    /* renamed from: g  reason: collision with root package name */
    public byte[] f18842g;

    /* renamed from: h  reason: collision with root package name */
    public int f18843h;

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
        this.f18837b = -1;
        this.f18839d = "";
        this.f18840e = "";
    }

    public void a(HttpURLConnection httpURLConnection) throws Exception {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, httpURLConnection) == null) || httpURLConnection == null) {
            return;
        }
        this.f18837b = httpURLConnection.getResponseCode();
        this.f18839d = httpURLConnection.getContentEncoding();
        httpURLConnection.getContentType();
        this.f18840e = httpURLConnection.getContentLength() + "";
        this.f18841f = httpURLConnection.getHeaderFields();
    }
}

package c.a.s0.j3.f0.o;

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
    public int f18363b;

    /* renamed from: c  reason: collision with root package name */
    public int f18364c;

    /* renamed from: d  reason: collision with root package name */
    public String f18365d;

    /* renamed from: e  reason: collision with root package name */
    public String f18366e;

    /* renamed from: f  reason: collision with root package name */
    public Map<String, List<String>> f18367f;

    /* renamed from: g  reason: collision with root package name */
    public byte[] f18368g;

    /* renamed from: h  reason: collision with root package name */
    public int f18369h;

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
        this.f18363b = -1;
        this.f18365d = "";
        this.f18366e = "";
    }

    public void a(HttpURLConnection httpURLConnection) throws Exception {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, httpURLConnection) == null) || httpURLConnection == null) {
            return;
        }
        this.f18363b = httpURLConnection.getResponseCode();
        this.f18365d = httpURLConnection.getContentEncoding();
        httpURLConnection.getContentType();
        this.f18366e = httpURLConnection.getContentLength() + "";
        this.f18367f = httpURLConnection.getHeaderFields();
    }
}

package c.a.p0.l3.g0.o;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile boolean a;

    /* renamed from: b  reason: collision with root package name */
    public int f16209b;

    /* renamed from: c  reason: collision with root package name */
    public int f16210c;

    /* renamed from: d  reason: collision with root package name */
    public String f16211d;

    /* renamed from: e  reason: collision with root package name */
    public String f16212e;

    /* renamed from: f  reason: collision with root package name */
    public Map<String, List<String>> f16213f;

    /* renamed from: g  reason: collision with root package name */
    public byte[] f16214g;

    /* renamed from: h  reason: collision with root package name */
    public int f16215h;

    public i() {
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
        this.f16209b = -1;
        this.f16211d = "";
        this.f16212e = "";
    }

    public void a(HttpURLConnection httpURLConnection) throws Exception {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, httpURLConnection) == null) || httpURLConnection == null) {
            return;
        }
        this.f16209b = httpURLConnection.getResponseCode();
        this.f16211d = httpURLConnection.getContentEncoding();
        httpURLConnection.getContentType();
        this.f16212e = httpURLConnection.getContentLength() + "";
        this.f16213f = httpURLConnection.getHeaderFields();
    }
}

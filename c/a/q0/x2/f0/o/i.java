package c.a.q0.x2.f0.o;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f28837a;

    /* renamed from: b  reason: collision with root package name */
    public int f28838b;

    /* renamed from: c  reason: collision with root package name */
    public int f28839c;

    /* renamed from: d  reason: collision with root package name */
    public String f28840d;

    /* renamed from: e  reason: collision with root package name */
    public String f28841e;

    /* renamed from: f  reason: collision with root package name */
    public Map<String, List<String>> f28842f;

    /* renamed from: g  reason: collision with root package name */
    public byte[] f28843g;

    /* renamed from: h  reason: collision with root package name */
    public int f28844h;

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
        this.f28837a = false;
        this.f28838b = -1;
        this.f28840d = "";
        this.f28841e = "";
    }

    public void a(HttpURLConnection httpURLConnection) throws Exception {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, httpURLConnection) == null) || httpURLConnection == null) {
            return;
        }
        this.f28838b = httpURLConnection.getResponseCode();
        this.f28840d = httpURLConnection.getContentEncoding();
        httpURLConnection.getContentType();
        this.f28841e = httpURLConnection.getContentLength() + "";
        this.f28842f = httpURLConnection.getHeaderFields();
    }
}

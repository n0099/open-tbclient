package c.a.r0.y2.f0.o;

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
    public volatile boolean f29454a;

    /* renamed from: b  reason: collision with root package name */
    public int f29455b;

    /* renamed from: c  reason: collision with root package name */
    public int f29456c;

    /* renamed from: d  reason: collision with root package name */
    public String f29457d;

    /* renamed from: e  reason: collision with root package name */
    public String f29458e;

    /* renamed from: f  reason: collision with root package name */
    public Map<String, List<String>> f29459f;

    /* renamed from: g  reason: collision with root package name */
    public byte[] f29460g;

    /* renamed from: h  reason: collision with root package name */
    public int f29461h;

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
        this.f29454a = false;
        this.f29455b = -1;
        this.f29457d = "";
        this.f29458e = "";
    }

    public void a(HttpURLConnection httpURLConnection) throws Exception {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, httpURLConnection) == null) || httpURLConnection == null) {
            return;
        }
        this.f29455b = httpURLConnection.getResponseCode();
        this.f29457d = httpURLConnection.getContentEncoding();
        httpURLConnection.getContentType();
        this.f29458e = httpURLConnection.getContentLength() + "";
        this.f29459f = httpURLConnection.getHeaderFields();
    }
}

package b.a.r0.z2.f0.o;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f28064a;

    /* renamed from: b  reason: collision with root package name */
    public int f28065b;

    /* renamed from: c  reason: collision with root package name */
    public int f28066c;

    /* renamed from: d  reason: collision with root package name */
    public String f28067d;

    /* renamed from: e  reason: collision with root package name */
    public String f28068e;

    /* renamed from: f  reason: collision with root package name */
    public Map<String, List<String>> f28069f;

    /* renamed from: g  reason: collision with root package name */
    public byte[] f28070g;

    /* renamed from: h  reason: collision with root package name */
    public int f28071h;

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
        this.f28064a = false;
        this.f28065b = -1;
        this.f28067d = "";
        this.f28068e = "";
    }

    public void a(HttpURLConnection httpURLConnection) throws Exception {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, httpURLConnection) == null) || httpURLConnection == null) {
            return;
        }
        this.f28065b = httpURLConnection.getResponseCode();
        this.f28067d = httpURLConnection.getContentEncoding();
        httpURLConnection.getContentType();
        this.f28068e = httpURLConnection.getContentLength() + "";
        this.f28069f = httpURLConnection.getHeaderFields();
    }
}

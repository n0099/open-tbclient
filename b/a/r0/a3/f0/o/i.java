package b.a.r0.a3.f0.o;

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
    public volatile boolean f15699a;

    /* renamed from: b  reason: collision with root package name */
    public int f15700b;

    /* renamed from: c  reason: collision with root package name */
    public int f15701c;

    /* renamed from: d  reason: collision with root package name */
    public String f15702d;

    /* renamed from: e  reason: collision with root package name */
    public String f15703e;

    /* renamed from: f  reason: collision with root package name */
    public Map<String, List<String>> f15704f;

    /* renamed from: g  reason: collision with root package name */
    public byte[] f15705g;

    /* renamed from: h  reason: collision with root package name */
    public int f15706h;

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
        this.f15699a = false;
        this.f15700b = -1;
        this.f15702d = "";
        this.f15703e = "";
    }

    public void a(HttpURLConnection httpURLConnection) throws Exception {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, httpURLConnection) == null) || httpURLConnection == null) {
            return;
        }
        this.f15700b = httpURLConnection.getResponseCode();
        this.f15702d = httpURLConnection.getContentEncoding();
        httpURLConnection.getContentType();
        this.f15703e = httpURLConnection.getContentLength() + "";
        this.f15704f = httpURLConnection.getHeaderFields();
    }
}

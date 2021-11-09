package b.q.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.Q;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import org.apache.http.protocol.HTTP;
/* loaded from: classes6.dex */
public class s1 implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f33469e;

    /* renamed from: f  reason: collision with root package name */
    public String f33470f;

    /* renamed from: g  reason: collision with root package name */
    public String f33471g;

    /* renamed from: h  reason: collision with root package name */
    public y1 f33472h;

    /* renamed from: i  reason: collision with root package name */
    public a1 f33473i;
    public boolean j;
    public long k;

    public s1(String str, String str2, y1 y1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, y1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f33469e = 0;
        this.j = false;
        this.f33470f = str;
        this.f33471g = str2;
        this.f33472h = y1Var;
        this.f33473i = new a1(this);
        this.j = true;
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || Thread.currentThread().isInterrupted()) {
            return;
        }
        try {
            URL url = new URL(this.f33470f);
            HttpURLConnection httpURLConnection = url.toString().startsWith("https://") ? (HttpsURLConnection) url.openConnection() : (HttpURLConnection) url.openConnection();
            httpURLConnection.setConnectTimeout(3000);
            httpURLConnection.setReadTimeout(3000);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty("Range", "bytes=" + this.f33469e + "-");
            httpURLConnection.setRequestProperty(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
            httpURLConnection.connect();
            this.k = (long) httpURLConnection.getContentLength();
            if (Thread.currentThread().isInterrupted()) {
                return;
            }
            if (this.f33473i != null && this.k > 10) {
                this.f33473i.c(httpURLConnection.getInputStream());
            } else if (this.f33472h != null) {
                this.f33472h.a();
            }
        } catch (IOException e2) {
            if (!Thread.currentThread().isInterrupted()) {
                throw e2;
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            try {
                a();
            } catch (Exception unused) {
                a1 a1Var = this.f33473i;
                if (a1Var != null) {
                    a1Var.d(a1Var.a(1, new Object[]{Q.f70468b}));
                }
            }
        }
    }
}

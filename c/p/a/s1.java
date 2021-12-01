package c.p.a;

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
/* loaded from: classes7.dex */
public class s1 implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f30912e;

    /* renamed from: f  reason: collision with root package name */
    public String f30913f;

    /* renamed from: g  reason: collision with root package name */
    public String f30914g;

    /* renamed from: h  reason: collision with root package name */
    public y1 f30915h;

    /* renamed from: i  reason: collision with root package name */
    public a1 f30916i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f30917j;

    /* renamed from: k  reason: collision with root package name */
    public long f30918k;

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
        this.f30912e = 0;
        this.f30917j = false;
        this.f30913f = str;
        this.f30914g = str2;
        this.f30915h = y1Var;
        this.f30916i = new a1(this);
        this.f30917j = true;
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || Thread.currentThread().isInterrupted()) {
            return;
        }
        try {
            URL url = new URL(this.f30913f);
            HttpURLConnection httpURLConnection = url.toString().startsWith("https://") ? (HttpsURLConnection) url.openConnection() : (HttpURLConnection) url.openConnection();
            httpURLConnection.setConnectTimeout(3000);
            httpURLConnection.setReadTimeout(3000);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty("Range", "bytes=" + this.f30912e + "-");
            httpURLConnection.setRequestProperty(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
            httpURLConnection.connect();
            this.f30918k = (long) httpURLConnection.getContentLength();
            if (Thread.currentThread().isInterrupted()) {
                return;
            }
            if (this.f30916i != null && this.f30918k > 10) {
                this.f30916i.c(httpURLConnection.getInputStream());
            } else if (this.f30915h != null) {
                this.f30915h.a();
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
                a1 a1Var = this.f30916i;
                if (a1Var != null) {
                    a1Var.d(a1Var.a(1, new Object[]{Q.f62609b}));
                }
            }
        }
    }
}

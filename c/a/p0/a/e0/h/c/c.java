package c.a.p0.a.e0.h.c;

import android.net.LocalServerSocket;
import android.net.LocalSocket;
import c.a.p0.a.e0.h.a;
import c.a.p0.a.k;
import com.android.internal.http.multipart.Part;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
/* loaded from: classes.dex */
public class c implements a.c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f5379f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public a.b f5380a;

    /* renamed from: b  reason: collision with root package name */
    public LocalServerSocket f5381b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.p0.a.e0.h.c.a f5382c;

    /* renamed from: d  reason: collision with root package name */
    public String f5383d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f5384e;

    /* loaded from: classes.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Map<String, String> f5385a;

        /* renamed from: b  reason: collision with root package name */
        public String f5386b;

        /* renamed from: c  reason: collision with root package name */
        public String f5387c;

        /* renamed from: d  reason: collision with root package name */
        public String f5388d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f5389e;

        public a() {
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
            this.f5385a = new HashMap();
        }
    }

    /* loaded from: classes.dex */
    public static abstract class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public a f5390a;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5390a = aVar;
        }

        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "" : (String) invokeV.objValue;
        }

        public abstract Map<String, String> b();

        public abstract String c();

        public final void d(PrintWriter printWriter, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048579, this, printWriter, str, str2) == null) {
                printWriter.append((CharSequence) str).append(": ").append((CharSequence) str2).append(Part.CRLF);
            }
        }

        public void e(OutputStream outputStream) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, outputStream) == null) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("E, d MMM yyyy HH:mm:ss 'GMT'", Locale.US);
                simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
                PrintWriter printWriter = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
                printWriter.append("HTTP/1.1").append(' ').append((CharSequence) c()).append(" \r\n");
                d(printWriter, "Date", simpleDateFormat.format(new Date()));
                printWriter.print("Content-Length: " + a().getBytes().length + Part.CRLF);
                Map<String, String> b2 = b();
                if (b2 != null && b2.size() > 0) {
                    for (Map.Entry<String, String> entry : b().entrySet()) {
                        d(printWriter, entry.getKey(), entry.getValue());
                    }
                }
                printWriter.append(Part.CRLF);
                printWriter.append((CharSequence) a());
                printWriter.flush();
                printWriter.close();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1959803832, "Lc/a/p0/a/e0/h/c/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1959803832, "Lc/a/p0/a/e0/h/c/c;");
                return;
            }
        }
        f5379f = k.f7077a;
    }

    public c(String str, a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, bVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f5383d = str;
        this.f5380a = bVar;
    }

    @Override // c.a.p0.a.e0.h.a.c
    public void start() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f5384e) {
            return;
        }
        try {
            this.f5381b = new LocalServerSocket(this.f5383d);
            this.f5384e = true;
            int i2 = 0;
            while (this.f5384e) {
                LocalSocket accept = this.f5381b.accept();
                c.a.p0.a.e0.h.c.a aVar = new c.a.p0.a.e0.h.c.a(accept.getInputStream(), accept.getOutputStream());
                this.f5382c = aVar;
                aVar.o(this.f5380a);
                ExecutorUtilsExt.postOnSerial(this.f5382c, "V8InspectorServer");
                if (c.a.p0.a.u1.a.a.G() && (i2 = i2 + 1) > 10) {
                    boolean z = f5379f;
                    return;
                }
            }
        } catch (IOException e2) {
            c.a.p0.a.e0.d.c("V8InspectorServer", "launch local server fail", e2);
        }
    }

    @Override // c.a.p0.a.e0.h.a.c
    public void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f5384e = false;
            LocalServerSocket localServerSocket = this.f5381b;
            if (localServerSocket != null) {
                try {
                    localServerSocket.close();
                } catch (IOException e2) {
                    c.a.p0.a.e0.d.c("V8InspectorServer", "stop local server fail", e2);
                }
                this.f5381b = null;
            }
            c.a.p0.a.e0.h.c.a aVar = this.f5382c;
            if (aVar != null) {
                aVar.l();
                this.f5382c = null;
            }
            this.f5380a = null;
        }
    }
}

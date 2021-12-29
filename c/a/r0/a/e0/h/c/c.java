package c.a.r0.a.e0.h.c;

import android.net.LocalServerSocket;
import android.net.LocalSocket;
import c.a.r0.a.e0.h.a;
import c.a.r0.a.k;
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
    public static final boolean f5887f;
    public transient /* synthetic */ FieldHolder $fh;
    public a.b a;

    /* renamed from: b  reason: collision with root package name */
    public LocalServerSocket f5888b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.r0.a.e0.h.c.a f5889c;

    /* renamed from: d  reason: collision with root package name */
    public String f5890d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f5891e;

    /* loaded from: classes.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Map<String, String> a;

        /* renamed from: b  reason: collision with root package name */
        public String f5892b;

        /* renamed from: c  reason: collision with root package name */
        public String f5893c;

        /* renamed from: d  reason: collision with root package name */
        public String f5894d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f5895e;

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
            this.a = new HashMap();
        }
    }

    /* loaded from: classes.dex */
    public static abstract class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public a a;

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
            this.a = aVar;
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
                printWriter.append((CharSequence) str).append(": ").append((CharSequence) str2).append("\r\n");
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
                printWriter.print("Content-Length: " + a().getBytes().length + "\r\n");
                Map<String, String> b2 = b();
                if (b2 != null && b2.size() > 0) {
                    for (Map.Entry<String, String> entry : b2.entrySet()) {
                        d(printWriter, entry.getKey(), entry.getValue());
                    }
                }
                printWriter.append("\r\n");
                printWriter.append((CharSequence) a());
                printWriter.flush();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(948686582, "Lc/a/r0/a/e0/h/c/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(948686582, "Lc/a/r0/a/e0/h/c/c;");
                return;
            }
        }
        f5887f = k.a;
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
        this.f5890d = str;
        this.a = bVar;
    }

    @Override // c.a.r0.a.e0.h.a.c
    public void start() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f5891e) {
            return;
        }
        try {
            this.f5888b = new LocalServerSocket(this.f5890d);
            this.f5891e = true;
            int i2 = 0;
            while (this.f5891e) {
                LocalSocket accept = this.f5888b.accept();
                c.a.r0.a.e0.h.c.a aVar = new c.a.r0.a.e0.h.c.a(accept.getInputStream(), accept.getOutputStream());
                this.f5889c = aVar;
                aVar.o(this.a);
                ExecutorUtilsExt.postOnSerial(this.f5889c, "V8InspectorServer");
                if (c.a.r0.a.x1.a.a.H() && (i2 = i2 + 1) > 10) {
                    boolean z = f5887f;
                    return;
                }
            }
        } catch (IOException e2) {
            c.a.r0.a.e0.d.d("V8InspectorServer", "launch local server fail", e2);
        }
    }

    @Override // c.a.r0.a.e0.h.a.c
    public void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f5891e = false;
            LocalServerSocket localServerSocket = this.f5888b;
            if (localServerSocket != null) {
                try {
                    localServerSocket.close();
                } catch (IOException e2) {
                    c.a.r0.a.e0.d.d("V8InspectorServer", "stop local server fail", e2);
                }
                this.f5888b = null;
            }
            c.a.r0.a.e0.h.c.a aVar = this.f5889c;
            if (aVar != null) {
                aVar.l();
                this.f5889c = null;
            }
            this.a = null;
        }
    }
}

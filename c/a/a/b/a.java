package c.a.a.b;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cloudbase.download.exception.DownloadException;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<c> a;

    /* renamed from: b  reason: collision with root package name */
    public Context f1021b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, Integer> f1022c;

    /* renamed from: c.a.a.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0006a extends c.a.a.c.c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f1023b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ File f1024c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ File f1025d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f1026e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f1027f;

        public C0006a(a aVar, c cVar, String str, File file, File file2, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, cVar, str, file, file2, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1027f = aVar;
            this.a = cVar;
            this.f1023b = str;
            this.f1024c = file;
            this.f1025d = file2;
            this.f1026e = str2;
        }

        @Override // c.a.a.c.c.a
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                try {
                    this.f1024c.renameTo(this.f1025d);
                    StringBuilder sb = new StringBuilder();
                    sb.append("unzip:");
                    sb.append(this.f1025d);
                    sb.append("---");
                    sb.append(this.f1026e);
                    Log.e("RtcDownSo", sb.toString());
                    c.a.a.e.a.e(this.f1025d, this.f1026e);
                    c.a.a.e.a.b(this.f1025d.getAbsolutePath());
                    this.f1027f.h(this.a, this.f1023b, this.f1026e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    c.a.a.e.a.b(this.f1025d.getAbsolutePath());
                    if (c.a.a.e.a.c(this.f1026e)) {
                        c.a.a.e.a.a(new File(this.f1026e));
                    }
                    this.f1027f.e(this.a, this.f1023b, 108, "unzip exception");
                }
            }
        }

        @Override // c.a.a.c.c.a
        public void f(DownloadException downloadException) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadException) == null) {
                downloadException.printStackTrace();
                c.a.a.e.a.b(this.f1024c.getAbsolutePath());
                this.f1027f.e(this.a, this.f1023b, downloadException.getErrorCode(), downloadException.getErrorMessage());
            }
        }

        @Override // c.a.a.c.c.a
        public void g(long j, long j2, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i)}) == null) {
                this.f1027f.f(this.a, this.f1023b, i);
            }
        }

        @Override // c.a.a.c.c.a
        public void h() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.f1027f.g(this.a, this.f1023b);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static a a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1550926947, "Lc/a/a/b/a$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1550926947, "Lc/a/a/b/a$b;");
                    return;
                }
            }
            a = new a();
        }
    }

    public a() {
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
        this.f1022c = new HashMap();
    }

    public static a k(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            b.a.f1021b = context.getApplicationContext();
            return b.a;
        }
        return (a) invokeL.objValue;
    }

    public final void e(c cVar, String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(1048576, this, cVar, str, i, str2) == null) {
            this.f1022c.put(str, 2);
            if (cVar != null) {
                cVar.onDownloadFail(str, i, str2);
            }
            if (this.a != null) {
                for (int i2 = 0; i2 < this.a.size(); i2++) {
                    this.a.get(i2).onDownloadFail(str, i, str2);
                }
            }
        }
    }

    public final void f(c cVar, String str, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{cVar, str, Float.valueOf(f2)}) == null) {
            if (cVar != null) {
                cVar.onDownloadProgress(f2);
            }
            if (this.a != null) {
                for (int i = 0; i < this.a.size(); i++) {
                    this.a.get(i).onDownloadProgress(f2);
                }
            }
        }
    }

    public final void g(c cVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, cVar, str) == null) {
            if (cVar != null) {
                cVar.onDownloadStart(str);
            }
            if (this.a != null) {
                for (int i = 0; i < this.a.size(); i++) {
                    this.a.get(i).onDownloadStart(str);
                }
            }
        }
    }

    public final void h(c cVar, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, cVar, str, str2) == null) {
            this.f1022c.put(str, 3);
            if (cVar != null) {
                cVar.onDownloadSuccess(str, str2);
            }
            if (this.a != null) {
                for (int i = 0; i < this.a.size(); i++) {
                    this.a.get(i).onDownloadSuccess(str, str2);
                }
            }
        }
    }

    public final void i(String str, String str2, Looper looper, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048580, this, str, str2, looper, cVar) == null) {
            if (!m(str)) {
                c.a.a.e.a.a(new File(str2));
            }
            File file = new File(str2);
            if (!file.exists()) {
                file.mkdirs();
            }
            this.f1022c.put(str, 1);
            String d2 = c.a.a.b.b.d(this.f1021b, str, str2);
            File file2 = new File(d2 + ".temp");
            File file3 = new File(d2 + ".zip");
            Log.d("RtcDownSo", "start down folder=" + str2 + "name=" + file2.getName());
            c.a.a.c.a.i().h(str, str2, file2.getName(), looper, new C0006a(this, cVar, str, file2, file3, d2));
        }
    }

    public void j(@NonNull String str, boolean z, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{str, Boolean.valueOf(z), cVar}) == null) {
            String b2 = c.a.a.b.b.b(this.f1021b);
            if (TextUtils.isEmpty(str)) {
                cVar.onDownloadFail(str, 108, "download url is empty.");
            } else if (l(str, b2)) {
                if (cVar != null) {
                    cVar.onDownloadSuccess(str, c.a.a.b.b.d(this.f1021b, str, b2));
                }
            } else if (z) {
                if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
                    Log.d("RtcDownSo", "start down so main thread");
                    i(str, b2, Looper.getMainLooper(), cVar);
                    return;
                }
                Looper.prepare();
                Log.d("RtcDownSo", "start down so sub thread");
                i(str, b2, Looper.myLooper(), cVar);
                Looper.loop();
            } else {
                i(str, b2, Looper.getMainLooper(), cVar);
            }
        }
    }

    public boolean l(@NonNull String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, str, str2)) == null) ? c.a.a.b.b.m(this.f1021b, str, str2) : invokeLL.booleanValue;
    }

    public final boolean m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) ? c.a.a.c.a.i().l(str) : invokeL.booleanValue;
    }

    public boolean n(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            File file = new File(str);
            if (file.exists()) {
                Context context = this.f1021b;
                if (context == null ? false : b.a.a.c.a.c.a().a(context, file)) {
                    return true;
                }
                try {
                    b.a.a.c.a.c.a().b(this.f1021b, file);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                Context context2 = this.f1021b;
                if (context2 == null) {
                    return false;
                }
                return b.a.a.c.a.c.a().a(context2, file);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void o() {
        List<c> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (list = this.a) == null) {
            return;
        }
        list.clear();
        this.a = null;
    }

    public void p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            c.a.a.b.b.o(str);
        }
    }
}

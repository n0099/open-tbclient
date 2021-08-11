package c.a.a.b;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cloudbase.download.exception.DownloadException;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.mobads.container.util.XAdSimpleImageLoader;
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

    /* renamed from: a  reason: collision with root package name */
    public Context f1578a;

    /* renamed from: b  reason: collision with root package name */
    public List<c> f1579b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, Integer> f1580c;

    /* renamed from: c.a.a.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0012a extends c.a.a.c.c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f1581a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f1582b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ File f1583c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ File f1584d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f1585e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f1586f;

        public C0012a(a aVar, c cVar, String str, File file, File file2, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, cVar, str, file, file2, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1586f = aVar;
            this.f1581a = cVar;
            this.f1582b = str;
            this.f1583c = file;
            this.f1584d = file2;
            this.f1585e = str2;
        }

        @Override // c.a.a.c.c.a
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                try {
                    this.f1583c.renameTo(this.f1584d);
                    String str2 = "unzip:" + this.f1584d + "---" + this.f1585e;
                    c.a.a.e.a.e(this.f1584d, this.f1585e);
                    c.a.a.e.a.b(this.f1584d.getAbsolutePath());
                    this.f1586f.h(this.f1581a, this.f1582b, this.f1585e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    c.a.a.e.a.b(this.f1584d.getAbsolutePath());
                    if (c.a.a.e.a.c(this.f1585e)) {
                        c.a.a.e.a.a(new File(this.f1585e));
                    }
                    this.f1586f.e(this.f1581a, this.f1582b, 108, "unzip exception");
                }
            }
        }

        @Override // c.a.a.c.c.a
        public void f(DownloadException downloadException) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadException) == null) {
                downloadException.printStackTrace();
                c.a.a.e.a.b(this.f1583c.getAbsolutePath());
                this.f1586f.e(this.f1581a, this.f1582b, downloadException.getErrorCode(), downloadException.getErrorMessage());
            }
        }

        @Override // c.a.a.c.c.a
        public void g(long j2, long j3, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i2)}) == null) {
                this.f1586f.f(this.f1581a, this.f1582b, i2);
            }
        }

        @Override // c.a.a.c.c.a
        public void h() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.f1586f.g(this.f1581a, this.f1582b);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static a f1587a;
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
            f1587a = new a();
        }
    }

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
        this.f1580c = new HashMap();
    }

    public static a k(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, context)) == null) {
            b.f1587a.f1578a = context.getApplicationContext();
            return b.f1587a;
        }
        return (a) invokeL.objValue;
    }

    public final void e(c cVar, String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(1048576, this, cVar, str, i2, str2) == null) {
            this.f1580c.put(str, 2);
            if (cVar != null) {
                cVar.onDownloadFail(str, i2, str2);
            }
            if (this.f1579b != null) {
                for (int i3 = 0; i3 < this.f1579b.size(); i3++) {
                    this.f1579b.get(i3).onDownloadFail(str, i2, str2);
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
            if (this.f1579b != null) {
                for (int i2 = 0; i2 < this.f1579b.size(); i2++) {
                    this.f1579b.get(i2).onDownloadProgress(f2);
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
            if (this.f1579b != null) {
                for (int i2 = 0; i2 < this.f1579b.size(); i2++) {
                    this.f1579b.get(i2).onDownloadStart(str);
                }
            }
        }
    }

    public final void h(c cVar, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, cVar, str, str2) == null) {
            this.f1580c.put(str, 3);
            if (cVar != null) {
                cVar.onDownloadSuccess(str, str2);
            }
            if (this.f1579b != null) {
                for (int i2 = 0; i2 < this.f1579b.size(); i2++) {
                    this.f1579b.get(i2).onDownloadSuccess(str, str2);
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
            this.f1580c.put(str, 1);
            String d2 = c.a.a.b.b.d(this.f1578a, str, str2);
            File file2 = new File(d2 + XAdSimpleImageLoader.TEMP_SUFFIX);
            String str3 = "start down folder=" + str2 + "name=" + file2.getName();
            c.a.a.c.a.i().h(str, str2, file2.getName(), looper, new C0012a(this, cVar, str, file2, new File(d2 + ".zip"), d2));
        }
    }

    public void j(@NonNull String str, boolean z, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{str, Boolean.valueOf(z), cVar}) == null) {
            String b2 = c.a.a.b.b.b(this.f1578a);
            if (TextUtils.isEmpty(str)) {
                cVar.onDownloadFail(str, 108, "download url is empty.");
            } else if (l(str, b2)) {
                if (cVar != null) {
                    cVar.onDownloadSuccess(str, c.a.a.b.b.d(this.f1578a, str, b2));
                }
            } else if (!z || Looper.getMainLooper().getThread() == Thread.currentThread()) {
                i(str, b2, Looper.getMainLooper(), cVar);
            } else {
                Looper.prepare();
                i(str, b2, Looper.myLooper(), cVar);
                Looper.loop();
            }
        }
    }

    public boolean l(@NonNull String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, str, str2)) == null) ? c.a.a.b.b.m(this.f1578a, str, str2) : invokeLL.booleanValue;
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
                Context context = this.f1578a;
                if (context == null ? false : b.a.a.c.a.c.a().a(context, file)) {
                    return true;
                }
                try {
                    b.a.a.c.a.c.a().b(this.f1578a, file);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                Context context2 = this.f1578a;
                if (context2 == null) {
                    return false;
                }
                return b.a.a.c.a.c.a().a(context2, file);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void o(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            c.a.a.b.b.o(str);
        }
    }
}

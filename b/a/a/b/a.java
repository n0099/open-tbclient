package b.a.a.b;

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
    public List<c> f1068a;

    /* renamed from: b  reason: collision with root package name */
    public Context f1069b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, Integer> f1070c;

    /* renamed from: b.a.a.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0006a extends b.a.a.c.c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f1071a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f1072b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ File f1073c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ File f1074d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f1075e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f1076f;

        public C0006a(a aVar, c cVar, String str, File file, File file2, String str2) {
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
            this.f1076f = aVar;
            this.f1071a = cVar;
            this.f1072b = str;
            this.f1073c = file;
            this.f1074d = file2;
            this.f1075e = str2;
        }

        @Override // b.a.a.c.c.a
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                try {
                    this.f1073c.renameTo(this.f1074d);
                    StringBuilder sb = new StringBuilder();
                    sb.append("unzip:");
                    sb.append(this.f1074d);
                    sb.append("---");
                    sb.append(this.f1075e);
                    sb.toString();
                    b.a.a.e.a.e(this.f1074d, this.f1075e);
                    b.a.a.e.a.b(this.f1074d.getAbsolutePath());
                    this.f1076f.h(this.f1071a, this.f1072b, this.f1075e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    b.a.a.e.a.b(this.f1074d.getAbsolutePath());
                    if (b.a.a.e.a.c(this.f1075e)) {
                        b.a.a.e.a.a(new File(this.f1075e));
                    }
                    this.f1076f.e(this.f1071a, this.f1072b, 108, "unzip exception");
                }
            }
        }

        @Override // b.a.a.c.c.a
        public void f(DownloadException downloadException) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadException) == null) {
                downloadException.printStackTrace();
                b.a.a.e.a.b(this.f1073c.getAbsolutePath());
                this.f1076f.e(this.f1071a, this.f1072b, downloadException.getErrorCode(), downloadException.getErrorMessage());
            }
        }

        @Override // b.a.a.c.c.a
        public void g(long j, long j2, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i2)}) == null) {
                this.f1076f.f(this.f1071a, this.f1072b, i2);
            }
        }

        @Override // b.a.a.c.c.a
        public void h() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.f1076f.g(this.f1071a, this.f1072b);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static a f1077a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1680009666, "Lb/a/a/b/a$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1680009666, "Lb/a/a/b/a$b;");
                    return;
                }
            }
            f1077a = new a();
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
        this.f1070c = new HashMap();
    }

    public static a k(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, context)) == null) {
            b.f1077a.f1069b = context.getApplicationContext();
            return b.f1077a;
        }
        return (a) invokeL.objValue;
    }

    public final void e(c cVar, String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(1048576, this, cVar, str, i2, str2) == null) {
            this.f1070c.put(str, 2);
            if (cVar != null) {
                cVar.onDownloadFail(str, i2, str2);
            }
            if (this.f1068a != null) {
                for (int i3 = 0; i3 < this.f1068a.size(); i3++) {
                    this.f1068a.get(i3).onDownloadFail(str, i2, str2);
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
            if (this.f1068a != null) {
                for (int i2 = 0; i2 < this.f1068a.size(); i2++) {
                    this.f1068a.get(i2).onDownloadProgress(f2);
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
            if (this.f1068a != null) {
                for (int i2 = 0; i2 < this.f1068a.size(); i2++) {
                    this.f1068a.get(i2).onDownloadStart(str);
                }
            }
        }
    }

    public final void h(c cVar, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, cVar, str, str2) == null) {
            this.f1070c.put(str, 3);
            if (cVar != null) {
                cVar.onDownloadSuccess(str, str2);
            }
            if (this.f1068a != null) {
                for (int i2 = 0; i2 < this.f1068a.size(); i2++) {
                    this.f1068a.get(i2).onDownloadSuccess(str, str2);
                }
            }
        }
    }

    public final void i(String str, String str2, Looper looper, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048580, this, str, str2, looper, cVar) == null) {
            if (!m(str)) {
                b.a.a.e.a.a(new File(str2));
            }
            File file = new File(str2);
            if (!file.exists()) {
                file.mkdirs();
            }
            this.f1070c.put(str, 1);
            String d2 = b.a.a.b.b.d(this.f1069b, str, str2);
            File file2 = new File(d2 + XAdSimpleImageLoader.TEMP_SUFFIX);
            String str3 = "start down folder=" + str2 + "name=" + file2.getName();
            b.a.a.c.a.i().h(str, str2, file2.getName(), looper, new C0006a(this, cVar, str, file2, new File(d2 + ".zip"), d2));
        }
    }

    public void j(@NonNull String str, boolean z, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{str, Boolean.valueOf(z), cVar}) == null) {
            String b2 = b.a.a.b.b.b(this.f1069b);
            if (TextUtils.isEmpty(str)) {
                cVar.onDownloadFail(str, 108, "download url is empty.");
            } else if (l(str, b2)) {
                if (cVar != null) {
                    cVar.onDownloadSuccess(str, b.a.a.b.b.d(this.f1069b, str, b2));
                }
            } else if (z) {
                if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
                    i(str, b2, Looper.getMainLooper(), cVar);
                    return;
                }
                Looper.prepare();
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
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, str, str2)) == null) ? b.a.a.b.b.m(this.f1069b, str, str2) : invokeLL.booleanValue;
    }

    public final boolean m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) ? b.a.a.c.a.i().l(str) : invokeL.booleanValue;
    }

    public boolean n(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            File file = new File(str);
            if (file.exists()) {
                Context context = this.f1069b;
                if (context == null ? false : a.a.a.c.a.c.a().a(context, file)) {
                    return true;
                }
                try {
                    a.a.a.c.a.c.a().b(this.f1069b, file);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                Context context2 = this.f1069b;
                if (context2 == null) {
                    return false;
                }
                return a.a.a.c.a.c.a().a(context2, file);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void o() {
        List<c> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (list = this.f1068a) == null) {
            return;
        }
        list.clear();
        this.f1068a = null;
    }

    public void p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            b.a.a.b.b.o(str);
        }
    }
}

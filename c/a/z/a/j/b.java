package c.a.z.a.j;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.z.a.j.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.minivideo.arface.utils.ThreadPool;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.Objects;
/* loaded from: classes4.dex */
public class b extends d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static b f31008g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public String f31009c;

    /* renamed from: d  reason: collision with root package name */
    public File f31010d;

    /* renamed from: e  reason: collision with root package name */
    public Context f31011e;

    /* renamed from: f  reason: collision with root package name */
    public Boolean f31012f;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f31013e;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f31013e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b bVar = this.f31013e;
                bVar.p(bVar.f31011e);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-958691993, "Lc/a/z/a/j/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-958691993, "Lc/a/z/a/j/b;");
        }
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f31009c = "arsource";
    }

    public static synchronized void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            synchronized (b.class) {
                if (f31008g == null) {
                    f31008g = new b();
                }
            }
        }
    }

    public static final b k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
            if (f31008g == null) {
                h();
            }
            return f31008g;
        }
        return (b) invokeV.objValue;
    }

    @Override // c.a.z.a.j.d
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ThreadPool.b().e(new a(this));
        }
    }

    public final boolean i(Context context, String str, File file) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str, file)) == null) {
            if (file.isDirectory()) {
                e.b(file);
            } else {
                e.d(file);
            }
            File file2 = new File(file + ".loading");
            boolean a2 = new c(context).a(str, file2);
            if (n()) {
                q(a2 + " assetsToSD " + file2.getAbsolutePath());
            }
            if (a2) {
                a2 = file2.renameTo(file);
            }
            if (n()) {
                q(a2 + " renameTo " + file);
            }
            if (!a2) {
                q("del temp ...");
                e.b(file2);
                if (file.exists()) {
                    q("del " + file);
                    e.b(file);
                }
            }
            return a2;
        }
        return invokeLLL.booleanValue;
    }

    public final String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f31009c : (String) invokeV.objValue;
    }

    public final File l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.f31010d == null && c.a.z.a.b.h() != null && !TextUtils.isEmpty(c.a.z.a.c.a())) {
                this.f31010d = new File(c.a.z.a.c.a());
            }
            return this.f31010d;
        }
        return (File) invokeV.objValue;
    }

    @SuppressLint({"NewApi"})
    public void m(Context context, String str, File file) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, context, str, file) == null) {
            this.f31011e = ((Context) Objects.requireNonNull(context)).getApplicationContext();
            this.f31009c = (String) Objects.requireNonNull(str);
            this.f31010d = (File) Objects.requireNonNull(file);
            if (n()) {
                q("init " + str + " to " + file.getAbsolutePath());
            }
        }
    }

    public final boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? c.a.z.a.b.n() : invokeV.booleanValue;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            Boolean bool = this.f31012f;
            if (bool != null) {
                return bool.booleanValue();
            }
            String j2 = j();
            File l = l();
            boolean z = false;
            if (n()) {
                q(String.format("from %s to %s ", j2, l));
            }
            String str = null;
            String h2 = (l != null && l.exists() && l.isDirectory()) ? e.h(new File(l, "version")) : null;
            if (!TextUtils.isEmpty(h2)) {
                Context context = this.f31011e;
                str = e.g(context, j2 + "/version");
            }
            if (n()) {
                q("assets=" + str + ", sdcard=" + h2);
            }
            z = (TextUtils.isEmpty(h2) || !TextUtils.equals(h2, str)) ? true : true;
            this.f31012f = Boolean.valueOf(!z);
            return !z;
        }
        return invokeV.booleanValue;
    }

    public final void p(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, context) == null) {
            if (!o() ? i(context, j(), l()) : true) {
                this.f31012f = null;
                d(2);
            }
            if (n()) {
                q("arVersion=" + c.a.z.a.b.i() + ", arVersionName=" + c.a.z.a.b.j());
            }
        }
    }

    public final void q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
        }
    }

    @SuppressLint({"NewApi"})
    public void r(Context context, String str, File file, f.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048585, this, context, str, file, aVar) == null) {
            this.f31011e = ((Context) Objects.requireNonNull(context)).getApplicationContext();
            this.f31009c = (String) Objects.requireNonNull(str);
            this.f31010d = (File) Objects.requireNonNull(file);
            if (n()) {
                q("start " + str + " to " + file.getAbsolutePath());
            }
            super.e(aVar);
        }
    }
}

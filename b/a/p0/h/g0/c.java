package b.a.p0.h.g0;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.k;
import b.a.p0.a.p.b.a.l;
import b.a.p0.a.q2.c;
import b.a.p0.a.r0.n;
import b.a.p0.h.s.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.Set;
@Singleton
@Service
/* loaded from: classes4.dex */
public class c implements l {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f10452c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public SharedPreferences f10453a;

    /* renamed from: b  reason: collision with root package name */
    public File f10454b;

    /* loaded from: classes4.dex */
    public class a implements c.a<Long> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f10455a;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10455a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // b.a.p0.a.q2.c.a
        public Long update() throws IllegalStateException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? Long.valueOf(this.f10455a.m()) : (Long) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1053766673, "Lb/a/p0/h/g0/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1053766673, "Lb/a/p0/h/g0/c;");
                return;
            }
        }
        f10452c = k.f6397a;
    }

    public c() {
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
        String o = o();
        if (f10452c) {
            String str = "preferencesName:" + o;
        }
        if (o != null) {
            this.f10453a = b.a.p0.a.c1.a.b().getSharedPreferences(o, 0);
            this.f10454b = new File(q(), o + ActivityChooserModel.HISTORY_FILE_EXTENSION);
        }
        b.a.p0.a.q2.d.f7425h.b(new a(this));
    }

    public static void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, str) == null) {
            l(String.format("aigame_storage_%s_anonymous", str, ""));
        }
    }

    public static void l(String str) {
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, str) == null) || str == null || !str.startsWith("aigame_storage_") || (listFiles = q().listFiles()) == null) {
            return;
        }
        for (File file : listFiles) {
            if (file.getName().startsWith(str)) {
                b.a.p0.t.d.K(file);
            }
        }
    }

    @NonNull
    public static File q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? new File(AppRuntime.getAppContext().getApplicationInfo().dataDir, "shared_prefs") : (File) invokeV.objValue;
    }

    @Override // b.a.p0.a.p.b.a.l
    public String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? n.U(str) : (String) invokeL.objValue;
    }

    @Override // b.a.p0.a.p.b.a.l
    public b.a.p0.a.n0.c b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new b.a.p0.h.g0.a() : (b.a.p0.a.n0.c) invokeV.objValue;
    }

    @Override // b.a.p0.a.p.b.a.l
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            n.c();
        }
    }

    @Override // b.a.p0.a.p.b.a.l
    public File[] d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? q().listFiles() : (File[]) invokeV.objValue;
    }

    @Override // b.a.p0.a.p.b.a.l
    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? n.n() : (String) invokeV.objValue;
    }

    @Override // b.a.p0.a.p.b.a.l
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            String I = b.a.p0.t.d.I(b.a.p0.h.s.a.d());
            String I2 = b.a.p0.t.d.I(a.d.g());
            g();
            c();
            b.a.p0.t.d.j(I);
            b.a.p0.t.d.j(I2);
        }
    }

    @Override // b.a.p0.a.p.b.a.l
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            l("aigame_storage_");
        }
    }

    @Override // b.a.p0.a.p.b.a.l
    public String h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) ? n.V(str) : (String) invokeL.objValue;
    }

    @Override // b.a.p0.a.p.b.a.l
    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            b.a.p0.a.r0.k.c();
        }
    }

    @SuppressLint({"ApplySharedPref"})
    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? r() && this.f10453a.edit().clear().commit() : invokeV.booleanValue;
    }

    public long m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            File file = this.f10454b;
            if (file != null) {
                return file.length();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    public String[] n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (r()) {
                Set<String> keySet = this.f10453a.getAll().keySet();
                String[] strArr = new String[keySet.size()];
                keySet.toArray(strArr);
                return strArr;
            }
            return new String[0];
        }
        return (String[]) invokeV.objValue;
    }

    @Nullable
    public final String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            String U = b.a.p0.a.a2.e.U();
            if (TextUtils.isEmpty(U)) {
                return null;
            }
            return String.format("aigame_storage_%s_anonymous", U);
        }
        return (String) invokeV.objValue;
    }

    public String p(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, str, str2)) == null) {
            if (r()) {
                return this.f10453a.getString(str, str2);
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    public final boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f10453a != null : invokeV.booleanValue;
    }

    public long s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return 10485760L;
        }
        return invokeV.longValue;
    }

    @SuppressLint({"ApplySharedPref"})
    public boolean t(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048592, this, str, str2)) == null) ? r() && this.f10453a.edit().putString(str, str2).commit() : invokeLL.booleanValue;
    }

    @SuppressLint({"ApplySharedPref"})
    public boolean u(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) ? r() && this.f10453a.edit().remove(str).commit() : invokeL.booleanValue;
    }
}

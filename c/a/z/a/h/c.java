package c.a.z.a.h;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.z.a.j.j;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes3.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f22164b;

    /* renamed from: c  reason: collision with root package name */
    public String f22165c;

    /* renamed from: d  reason: collision with root package name */
    public String f22166d;

    /* renamed from: e  reason: collision with root package name */
    public String f22167e;

    /* renamed from: f  reason: collision with root package name */
    public String f22168f;

    /* renamed from: g  reason: collision with root package name */
    public File f22169g;

    /* renamed from: h  reason: collision with root package name */
    public File f22170h;

    public c() {
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
        this.a = "5.1_v2";
        this.f22169g = null;
    }

    public static c f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            c cVar = new c();
            cVar.f22166d = "source";
            cVar.a = "5.1_v2";
            cVar.f22168f = "resource_capture";
            String a = cVar.a("resource_capture");
            cVar.f22164b = a;
            cVar.f22165c = f.b(a);
            cVar.f22169g = cVar.k();
            cVar.f22170h = cVar.d();
            return cVar;
        }
        return (c) invokeV.objValue;
    }

    public static c g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            c cVar = new c();
            cVar.f22166d = "source";
            cVar.a = "5.1_v2";
            cVar.f22168f = "resource_live";
            String a = cVar.a("resource_live");
            cVar.f22164b = a;
            cVar.f22165c = f.b(a);
            cVar.f22169g = cVar.k();
            cVar.f22170h = cVar.d();
            return cVar;
        }
        return (c) invokeV.objValue;
    }

    public static c h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            c cVar = new c();
            cVar.f22166d = "so";
            cVar.f22167e = "so1";
            cVar.a = "5.1_v2";
            String j = cVar.j("so1");
            cVar.f22164b = j;
            cVar.f22165c = f.b(j);
            cVar.f22169g = cVar.k();
            if (c.a.z.a.b.m()) {
                c.a.z.a.j.i.a("DuAr_", "so1 local file path = " + cVar.f22169g.getAbsolutePath());
            }
            cVar.f22170h = cVar.d();
            return cVar;
        }
        return (c) invokeV.objValue;
    }

    public static c i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            c cVar = new c();
            cVar.f22166d = "so";
            cVar.f22167e = "so2";
            cVar.a = "5.1_v2";
            String j = cVar.j("so2");
            cVar.f22164b = j;
            cVar.f22165c = f.b(j);
            cVar.f22169g = cVar.k();
            if (c.a.z.a.b.m()) {
                c.a.z.a.j.i.a("DuAr_", "So2 local file path = " + cVar.f22169g.getAbsolutePath());
            }
            cVar.f22170h = cVar.d();
            return cVar;
        }
        return (c) invokeV.objValue;
    }

    public final String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            String str2 = TextUtils.equals("resource_live", str) ? "https://pic.rmb.bdstatic.com/baidu-ar-source-live-" : "https://pic.rmb.bdstatic.com/baidu-ar-source-";
            return str2 + "5.1_v2.zip";
        }
        return (String) invokeL.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            boolean a = j.a(c.a.z.a.b.getContext());
            if (TextUtils.equals(this.f22166d, "so")) {
                if (TextUtils.equals(this.f22167e, "so2")) {
                    return d.f().getAbsolutePath();
                }
                return d.b(a).getAbsolutePath();
            }
            return d.d().g().getAbsolutePath();
        }
        return (String) invokeV.objValue;
    }

    public File c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? k() : (File) invokeV.objValue;
    }

    public File d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.f22170h == null) {
                File c2 = c();
                String absolutePath = c2 != null ? c2.getAbsolutePath() : null;
                if (absolutePath == null) {
                    return null;
                }
                if (!absolutePath.endsWith(".zip")) {
                    absolutePath = absolutePath + ".zip";
                }
                if (!absolutePath.endsWith(".loading")) {
                    absolutePath = absolutePath + ".loading";
                }
                this.f22170h = new File(absolutePath);
            }
            return this.f22170h;
        }
        return (File) invokeV.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.a + "-" + this.f22165c;
        }
        return (String) invokeV.objValue;
    }

    public final String j(String str) {
        InterceptResult invokeL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            if (TextUtils.equals("so2", str)) {
                str2 = "https://pic.rmb.bdstatic.com/baidu-ar-so-live-";
            } else {
                str2 = "https://pic.rmb.bdstatic.com/baidu-ar-so-";
                if (j.a(c.a.z.a.b.getContext())) {
                    str2 = "https://pic.rmb.bdstatic.com/baidu-ar-so-64bit-";
                }
            }
            return str2 + "5.1_v2.zip";
        }
        return (String) invokeL.objValue;
    }

    public File k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.f22169g == null && !TextUtils.isEmpty(this.a)) {
                this.f22169g = new File(b(), e());
            }
            return this.f22169g;
        }
        return (File) invokeV.objValue;
    }
}

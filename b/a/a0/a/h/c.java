package b.a.a0.a.h;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f1171a;

    /* renamed from: b  reason: collision with root package name */
    public String f1172b;

    /* renamed from: c  reason: collision with root package name */
    public String f1173c;

    /* renamed from: d  reason: collision with root package name */
    public String f1174d;

    /* renamed from: e  reason: collision with root package name */
    public String f1175e;

    /* renamed from: f  reason: collision with root package name */
    public String f1176f;

    /* renamed from: g  reason: collision with root package name */
    public File f1177g;

    /* renamed from: h  reason: collision with root package name */
    public File f1178h;

    public c() {
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
        this.f1171a = "5.1_v2";
        this.f1177g = null;
    }

    public static c f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            c cVar = new c();
            cVar.f1174d = "source";
            cVar.f1171a = "5.1_v2";
            cVar.f1176f = "resource_capture";
            String a2 = cVar.a("resource_capture");
            cVar.f1172b = a2;
            cVar.f1173c = f.b(a2);
            cVar.f1177g = cVar.k();
            cVar.f1178h = cVar.d();
            return cVar;
        }
        return (c) invokeV.objValue;
    }

    public static c g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            c cVar = new c();
            cVar.f1174d = "source";
            cVar.f1171a = "5.1_v2";
            cVar.f1176f = "resource_live";
            String a2 = cVar.a("resource_live");
            cVar.f1172b = a2;
            cVar.f1173c = f.b(a2);
            cVar.f1177g = cVar.k();
            cVar.f1178h = cVar.d();
            return cVar;
        }
        return (c) invokeV.objValue;
    }

    public static c h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            c cVar = new c();
            cVar.f1174d = "so";
            cVar.f1175e = "so1";
            cVar.f1171a = "5.1_v2";
            String j = cVar.j("so1");
            cVar.f1172b = j;
            cVar.f1173c = f.b(j);
            cVar.f1177g = cVar.k();
            if (b.a.a0.a.b.m()) {
                b.a.a0.a.j.i.a("DuAr_", "so1 local file path = " + cVar.f1177g.getAbsolutePath());
            }
            cVar.f1178h = cVar.d();
            return cVar;
        }
        return (c) invokeV.objValue;
    }

    public static c i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            c cVar = new c();
            cVar.f1174d = "so";
            cVar.f1175e = "so2";
            cVar.f1171a = "5.1_v2";
            String j = cVar.j("so2");
            cVar.f1172b = j;
            cVar.f1173c = f.b(j);
            cVar.f1177g = cVar.k();
            if (b.a.a0.a.b.m()) {
                b.a.a0.a.j.i.a("DuAr_", "So2 local file path = " + cVar.f1177g.getAbsolutePath());
            }
            cVar.f1178h = cVar.d();
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
            if (TextUtils.equals(this.f1174d, "so")) {
                if (TextUtils.equals(this.f1175e, "so2")) {
                    return d.f().getAbsolutePath();
                }
                return d.b().getAbsolutePath();
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
            if (this.f1178h == null) {
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
                this.f1178h = new File(absolutePath);
            }
            return this.f1178h;
        }
        return (File) invokeV.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.f1171a + "-" + this.f1173c;
        }
        return (String) invokeV.objValue;
    }

    public final String j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            String str2 = TextUtils.equals("so2", str) ? "https://pic.rmb.bdstatic.com/baidu-ar-so-live-" : "https://pic.rmb.bdstatic.com/baidu-ar-so-";
            return str2 + "5.1_v2.zip";
        }
        return (String) invokeL.objValue;
    }

    public File k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.f1177g == null && !TextUtils.isEmpty(this.f1171a)) {
                this.f1177g = new File(b(), e());
            }
            return this.f1177g;
        }
        return (File) invokeV.objValue;
    }
}

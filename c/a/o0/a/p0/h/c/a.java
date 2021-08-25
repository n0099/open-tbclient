package c.a.o0.a.p0.h.c;

import android.text.TextUtils;
import c.a.o0.a.e0.d;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes.dex */
public class a extends c.a.o0.a.p0.h.b<c.a.o0.a.p0.g.b.a> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f7967d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-236767514, "Lc/a/o0/a/p0/h/c/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-236767514, "Lc/a/o0/a/p0/h/c/a;");
                return;
            }
        }
        c.a.o0.a.c1.a.Z().getSwitch("swan_extension_unzip_check", false);
        f7967d = false;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a() {
        super(new c.a.o0.a.p0.g.b.a());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((c.a.o0.a.p0.g.c.a) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static boolean r(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            d.h("ExtCore-SwanAppPresetControl", "isExtensionFileAvailable extensionPath:" + str);
            boolean z = false;
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            File file = new File(str, "extension.js");
            if (file.exists() && file.length() > 0) {
                z = true;
            }
            d.h("ExtCore-SwanAppPresetControl", "isExtensionFileAvailable: " + z);
            return z;
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.o0.a.p0.h.b
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            d.h("ExtCore-SwanAppPresetControl", "isNeedUpdate sExtensionUnzipCheck=" + f7967d);
            if (f7967d) {
                return !r(h().extensionCorePath) || super.k();
            }
            return super.k();
        }
        return invokeV.booleanValue;
    }
}

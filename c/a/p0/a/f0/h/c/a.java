package c.a.p0.a.f0.h.c;

import android.text.TextUtils;
import c.a.p0.a.u.d;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes.dex */
public class a extends c.a.p0.a.f0.h.b<c.a.p0.a.f0.g.b.a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a() {
        super(new c.a.p0.a.f0.g.b.a());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((c.a.p0.a.f0.g.c.a) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static boolean r(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            d.k("ExtCore-SwanAppPresetControl", "isExtensionFileAvailable extensionPath:" + str);
            boolean z = false;
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            File file = new File(str, "extension.js");
            if (file.exists() && file.length() > 0) {
                z = true;
            }
            d.k("ExtCore-SwanAppPresetControl", "isExtensionFileAvailable: " + z);
            return z;
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.p0.a.f0.h.b
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? !r(h().extensionCorePath) || super.k() : invokeV.booleanValue;
    }
}

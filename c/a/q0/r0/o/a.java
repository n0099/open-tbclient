package c.a.q0.r0.o;

import android.os.Build;
import c.a.d.f.p.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c a;

    /* renamed from: b  reason: collision with root package name */
    public String f12554b;

    public a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f12554b = str;
    }

    public final void a(String str, int i2) {
        int intValue;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048576, this, str, i2) == null) || k.isEmpty(str) || i2 <= 0 || TbSingleton.getInstance().isAnimFpsComputed(str) || (intValue = TbSingleton.getInstance().getAnimAvgFpsCount(str).intValue()) >= 5) {
            return;
        }
        int i3 = intValue + 1;
        int intValue2 = TbSingleton.getInstance().getAnimAvgFps(str).intValue();
        if (intValue2 > 0) {
            i2 = (i2 + (intValue2 * (i3 - 1))) / i3;
        }
        TbSingleton.getInstance().setAnimAvgFps(str, i2);
        TbSingleton.getInstance().setAnimAvgFpsCount(str, i3);
        if (i3 >= 5) {
            TbSingleton.getInstance().setAnimComputedFps(str, i2);
            b.a();
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || Build.VERSION.SDK_INT < 16) {
            return;
        }
        if (this.a == null) {
            this.a = new c();
        }
        this.a.c();
    }

    public void c() {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (cVar = this.a) == null || Build.VERSION.SDK_INT < 16) {
            return;
        }
        cVar.d();
        a(this.f12554b, this.a.b());
    }
}

package c.a.r0;

import android.os.Bundle;
import c.a.q0.r0.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.stats.SpeedStatsManager;
import com.baidu.searchbox.launch.stats.SpeedStatsStampTable;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.LogoActivityConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class m extends c.a.r0.d0.a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f19823d = true;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public long f19824b;

    /* renamed from: c  reason: collision with root package name */
    public j f19825c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1349058425, "Lc/a/r0/m;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1349058425, "Lc/a/r0/m;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragmentActivity};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((BaseFragmentActivity) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f19824b = -1L;
    }

    @Override // c.a.r0.d0.a
    public void d(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(3007);
            this.f19824b = System.currentTimeMillis();
            super.d(bundle);
            j jVar = new j(this.a);
            this.f19825c = jVar;
            jVar.f(f19823d);
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.NEW_LOGO_ACTIVITY_ON_CREATE_END_STAMP_KEY);
        }
    }

    @Override // c.a.r0.d0.a
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.e();
            f19823d = false;
            this.f19825c.d();
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && LogoActivityConfig.isFirst && this.f19824b >= 0) {
            l.b().w(System.currentTimeMillis() - this.f19824b);
        }
    }
}

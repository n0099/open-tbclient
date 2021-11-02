package b.a.r0.o3;

import android.os.Bundle;
import com.baidu.tieba.R;
import com.baidu.tieba.splashad.SplashAdFragment;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public MainTabActivity f22103a;

    public f() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static f b(MainTabActivity mainTabActivity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, mainTabActivity)) == null) {
            f fVar = new f();
            fVar.f22103a = mainTabActivity;
            return fVar;
        }
        return (f) invokeL.objValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            SplashAdFragment splashAdFragment = new SplashAdFragment();
            Bundle bundle = new Bundle();
            bundle.putInt(SplashAdFragment.AT_ACTIVITY_FLAG, 2);
            splashAdFragment.setArguments(bundle);
            this.f22103a.getWindow().setFlags(1024, 1024);
            this.f22103a.getSupportFragmentManager().beginTransaction().add(R.id.splash_ad_container, splashAdFragment).commitAllowingStateLoss();
        }
    }
}

package c.a.s0.y3;

import android.os.Bundle;
import com.baidu.tieba.splashad.SplashAdFragment;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
/* loaded from: classes9.dex */
public class r {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public WeakReference<MainTabActivity> a;

    public r() {
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

    public static r b(MainTabActivity mainTabActivity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, mainTabActivity)) == null) {
            r rVar = new r();
            rVar.a = new WeakReference<>(mainTabActivity);
            return rVar;
        }
        return (r) invokeL.objValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            SplashAdFragment splashAdFragment = new SplashAdFragment();
            Bundle bundle = new Bundle();
            bundle.putInt(SplashAdFragment.AT_ACTIVITY_FLAG, 2);
            splashAdFragment.setArguments(bundle);
            WeakReference<MainTabActivity> weakReference = this.a;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            this.a.get().getWindow().setFlags(1024, 1024);
            this.a.get().getSupportFragmentManager().beginTransaction().add(o.splash_ad_container, splashAdFragment).commitAllowingStateLoss();
        }
    }
}

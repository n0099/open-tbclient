package b.a.r0.f0;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.baidu.tieba.NewLogoActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.splashad.SplashAdFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public NewLogoActivity f16328a;

    public d() {
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

    public static d b(@NonNull NewLogoActivity newLogoActivity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, newLogoActivity)) == null) {
            d dVar = new d();
            dVar.f16328a = newLogoActivity;
            return dVar;
        }
        return (d) invokeL.objValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            SplashAdFragment splashAdFragment = new SplashAdFragment();
            Bundle bundle = new Bundle();
            bundle.putInt(SplashAdFragment.AT_ACTIVITY_FLAG, 1);
            splashAdFragment.setArguments(bundle);
            this.f16328a.getSupportFragmentManager().beginTransaction().add(R.id.layout_root, splashAdFragment).commitAllowingStateLoss();
        }
    }
}

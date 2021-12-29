package c.a.t0.k0;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.splashad.SplashAdFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseFragmentActivity a;

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

    public static d b(@NonNull BaseFragmentActivity baseFragmentActivity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, baseFragmentActivity)) == null) {
            d dVar = new d();
            dVar.a = baseFragmentActivity;
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
            this.a.getSupportFragmentManager().beginTransaction().add(R.id.layout_root, splashAdFragment).commitAllowingStateLoss();
        }
    }
}

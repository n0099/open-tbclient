package c.a.r0.a4;

import android.content.res.Configuration;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.tieba.splashad.SplashAdView;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
/* loaded from: classes2.dex */
public class m {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static m f15017b;
    public transient /* synthetic */ FieldHolder $fh;
    public WeakReference<SplashAdView> a;

    public m() {
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

    public static m a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f15017b == null) {
                f15017b = new m();
            }
            return f15017b;
        }
        return (m) invokeV.objValue;
    }

    public void b(Configuration configuration) {
        WeakReference<SplashAdView> weakReference;
        SplashAdView splashAdView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, configuration) == null) || (weakReference = this.a) == null || (splashAdView = weakReference.get()) == null) {
            return;
        }
        splashAdView.onConfigurationChanged(configuration);
    }

    public void c() {
        WeakReference<SplashAdView> weakReference;
        SplashAdView splashAdView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (weakReference = this.a) == null || (splashAdView = weakReference.get()) == null) {
            return;
        }
        splashAdView.onPause();
    }

    public void d() {
        WeakReference<SplashAdView> weakReference;
        SplashAdView splashAdView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (weakReference = this.a) == null || (splashAdView = weakReference.get()) == null) {
            return;
        }
        splashAdView.onResume();
    }

    public void e(MainTabActivity mainTabActivity) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, mainTabActivity) == null) || mainTabActivity == null) {
            return;
        }
        SplashAdView splashAdView = new SplashAdView(mainTabActivity, 2);
        this.a = new WeakReference<>(splashAdView);
        mainTabActivity.getWindow().setFlags(1024, 1024);
        ViewGroup viewGroup = (ViewGroup) mainTabActivity.findViewById(R.id.splash_ad_container);
        if (viewGroup != null) {
            viewGroup.setVisibility(0);
            viewGroup.addView(splashAdView);
        }
    }
}

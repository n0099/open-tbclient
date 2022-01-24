package c.a.t0.z3;

import android.content.res.Configuration;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.splashad.SplashAdView;
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

    /* renamed from: b  reason: collision with root package name */
    public static r f26178b;
    public transient /* synthetic */ FieldHolder $fh;
    public WeakReference<SplashAdView> a;

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

    public static r a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f26178b == null) {
                f26178b = new r();
            }
            return f26178b;
        }
        return (r) invokeV.objValue;
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

    public void e(MainTabActivity mainTabActivity, long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLJ(1048579, this, mainTabActivity, j2) == null) || mainTabActivity == null) {
            return;
        }
        SplashAdView splashAdView = new SplashAdView(mainTabActivity, 2, j2);
        this.a = new WeakReference<>(splashAdView);
        mainTabActivity.getWindow().setFlags(1024, 1024);
        ViewGroup viewGroup = (ViewGroup) mainTabActivity.findViewById(o.splash_ad_container);
        if (viewGroup != null) {
            viewGroup.addView(splashAdView);
        }
    }
}

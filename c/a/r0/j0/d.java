package c.a.r0.j0;

import android.content.res.Configuration;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.splashad.SplashAdView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
/* loaded from: classes2.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static d f18229b;
    public transient /* synthetic */ FieldHolder $fh;
    public WeakReference<SplashAdView> a;

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

    public static d a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f18229b == null) {
                f18229b = new d();
            }
            return f18229b;
        }
        return (d) invokeV.objValue;
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

    public void e(BaseFragmentActivity baseFragmentActivity) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, baseFragmentActivity) == null) || baseFragmentActivity == null) {
            return;
        }
        SplashAdView splashAdView = new SplashAdView(baseFragmentActivity, 1);
        this.a = new WeakReference<>(splashAdView);
        ViewGroup viewGroup = (ViewGroup) baseFragmentActivity.findViewById(R.id.layout_root);
        if (viewGroup != null) {
            viewGroup.addView(splashAdView);
        }
    }
}

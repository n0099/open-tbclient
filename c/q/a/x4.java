package c.q.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.PBError;
import com.win.opensdk.PBInterstitial;
import com.win.opensdk.PBInterstitialListener;
/* loaded from: classes3.dex */
public class x4 implements PBInterstitialListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ PBInterstitial a;

    public x4(PBInterstitial pBInterstitial) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pBInterstitial};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = pBInterstitial;
    }

    @Override // com.win.opensdk.PBListener
    public void onClicked() {
        PBInterstitialListener pBInterstitialListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (pBInterstitialListener = this.a.f59365c) == null) {
            return;
        }
        pBInterstitialListener.onClicked();
    }

    @Override // com.win.opensdk.PBListener
    public void onFail(PBError pBError) {
        PBInterstitialListener pBInterstitialListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pBError) == null) || (pBInterstitialListener = this.a.f59365c) == null) {
            return;
        }
        pBInterstitialListener.onFail(pBError);
    }

    @Override // com.win.opensdk.PBInterstitialListener
    public void onInterstitialDismissed() {
        PBInterstitialListener pBInterstitialListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (pBInterstitialListener = this.a.f59365c) == null) {
            return;
        }
        pBInterstitialListener.onInterstitialDismissed();
    }

    @Override // com.win.opensdk.PBInterstitialListener
    public void onInterstitialDisplayed() {
        PBInterstitialListener pBInterstitialListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (pBInterstitialListener = this.a.f59365c) == null) {
            return;
        }
        pBInterstitialListener.onInterstitialDisplayed();
    }

    @Override // com.win.opensdk.PBInterstitialListener
    public void onInterstitialShowFail(String str) {
        PBInterstitialListener pBInterstitialListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || (pBInterstitialListener = this.a.f59365c) == null) {
            return;
        }
        pBInterstitialListener.onInterstitialShowFail(str);
    }

    @Override // com.win.opensdk.PBListener
    public void onLoaded() {
        PBInterstitialListener pBInterstitialListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (pBInterstitialListener = this.a.f59365c) == null) {
            return;
        }
        pBInterstitialListener.onLoaded();
    }
}

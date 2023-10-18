package com.baidu.mobads.sdk.api;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.KeyEvent;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.sdk.internal.br;
import com.baidu.mobads.sdk.internal.cp;
import com.baidu.mobads.sdk.internal.dp;
import com.baidu.mobads.sdk.internal.y;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class InterstitialAd {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "InterstitialAd";
    public transient /* synthetic */ FieldHolder $fh;
    public boolean initialized;
    public InterstitialAdListener listener;
    public final br mAdLogger;
    public y mXInterstitial;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1279769969, "Lcom/baidu/mobads/sdk/api/InterstitialAd;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1279769969, "Lcom/baidu/mobads/sdk/api/InterstitialAd;");
        }
    }

    public InterstitialAd(Context context, AdSize adSize, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, adSize, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.initialized = false;
        this.mAdLogger = br.a();
        this.listener = new InterstitialAdListener(this) { // from class: com.baidu.mobads.sdk.api.InterstitialAd.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ InterstitialAd this$0;

            @Override // com.baidu.mobads.sdk.api.InterstitialAdListener
            public void onAdClick(InterstitialAd interstitialAd) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, interstitialAd) == null) {
                }
            }

            @Override // com.baidu.mobads.sdk.api.InterstitialAdListener
            public void onAdDismissed() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                }
            }

            @Override // com.baidu.mobads.sdk.api.InterstitialAdListener
            public void onAdFailed(String str2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str2) == null) {
                }
            }

            @Override // com.baidu.mobads.sdk.api.InterstitialAdListener
            public void onAdPresent() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                }
            }

            @Override // com.baidu.mobads.sdk.api.InterstitialAdListener
            public void onAdReady() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                }
            }

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }
        };
        cp cpVar = new cp(context);
        cpVar.a(new cp.a(this) { // from class: com.baidu.mobads.sdk.api.InterstitialAd.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ InterstitialAd this$0;

            @Override // com.baidu.mobads.sdk.internal.cp.a
            public void onAttachedToWindow() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                }
            }

            @Override // com.baidu.mobads.sdk.internal.cp.a
            @SuppressLint({"MissingSuperCall"})
            public void onDetachedFromWindow() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                }
            }

            @Override // com.baidu.mobads.sdk.internal.cp.a
            public void onLayoutComplete(int i3, int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeII(1048579, this, i3, i4) == null) {
                }
            }

            @Override // com.baidu.mobads.sdk.internal.cp.a
            public void onWindowFocusChanged(boolean z) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeZ(1048580, this, z) == null) {
                }
            }

            @Override // com.baidu.mobads.sdk.internal.cp.a
            public void onWindowVisibilityChanged(int i3) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048581, this, i3) == null) {
                }
            }

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // com.baidu.mobads.sdk.internal.cp.a
            public boolean onKeyDown(int i3, KeyEvent keyEvent) {
                InterceptResult invokeIL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeIL = interceptable2.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i3, keyEvent)) == null) {
                    return this.this$0.mXInterstitial.a(i3, keyEvent);
                }
                return invokeIL.booleanValue;
            }
        });
        if (isInterstitial(adSize)) {
            this.mXInterstitial = new dp(context, cpVar, this, str);
        } else if (isInterstitialPause(adSize)) {
            this.mXInterstitial = new dp(context, cpVar, this, adSize, str);
        }
        this.mXInterstitial.a(this.listener);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public InterstitialAd(Context context, String str) {
        this(context, AdSize.InterstitialGame, str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AdSize) objArr2[1], (String) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    private boolean isInterstitial(AdSize adSize) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, adSize)) == null) {
            if (adSize.getValue() <= AdSize.InterstitialOther.getValue() && adSize.getValue() >= AdSize.InterstitialGame.getValue()) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    private boolean isInterstitialPause(AdSize adSize) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, adSize)) == null) {
            if (adSize.getValue() >= AdSize.InterstitialForVideoBeforePlay.getValue() && adSize.getValue() <= AdSize.InterstitialForVideoPausePlay.getValue()) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void setAppSid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.mXInterstitial.a(str);
        }
    }

    public void setListener(InterstitialAdListener interstitialAdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, interstitialAdListener) == null) {
            if (interstitialAdListener != null) {
                this.listener = interstitialAdListener;
                this.mXInterstitial.a(interstitialAdListener);
                return;
            }
            throw new IllegalArgumentException();
        }
    }

    @Deprecated
    public void showAd(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, activity) == null) {
            this.mXInterstitial.a_();
        }
    }

    public void showAdInParentForVideoApp(RelativeLayout relativeLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, relativeLayout) == null) {
            this.mXInterstitial.a(relativeLayout);
        }
    }

    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.mXInterstitial.e();
        }
    }

    public boolean isAdReady() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mXInterstitial.c();
        }
        return invokeV.booleanValue;
    }

    public void loadAd() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (!this.initialized) {
                this.mXInterstitial.f();
                this.initialized = true;
            }
            this.mXInterstitial.b();
        }
    }

    public void showAd() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.mXInterstitial.a_();
        }
    }

    public void loadAdForVideoApp(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048579, this, i, i2) == null) {
            if (!this.initialized) {
                this.mXInterstitial.f();
                this.initialized = true;
            }
            this.mXInterstitial.a(i, i2);
        }
    }

    @Deprecated
    public void showAdInParentForVideoApp(Activity activity, RelativeLayout relativeLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, activity, relativeLayout) == null) {
            if (activity != null && relativeLayout != null) {
                this.mXInterstitial.a(relativeLayout);
                return;
            }
            throw new IllegalArgumentException();
        }
    }
}

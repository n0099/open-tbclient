package com.baidu.mobads.sdk.api;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.reward.KSRewardVideoActivityProxy;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes3.dex */
public final class AdSize {
    public static final /* synthetic */ AdSize[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final AdSize Banner;
    public static final AdSize FeedH5TemplateNative;
    public static final AdSize FeedNative;
    public static final AdSize InterstitialForVideoBeforePlay;
    public static final AdSize InterstitialForVideoPausePlay;
    public static final AdSize InterstitialGame;
    public static final AdSize InterstitialOther;
    public static final AdSize InterstitialReader;
    public static final AdSize InterstitialRefresh;
    public static final AdSize PrerollVideoNative;
    public static final AdSize RewardVideo;
    public static final AdSize Square;
    public transient /* synthetic */ FieldHolder $fh;
    public int value;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-757179716, "Lcom/baidu/mobads/sdk/api/AdSize;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-757179716, "Lcom/baidu/mobads/sdk/api/AdSize;");
                return;
            }
        }
        Banner = new AdSize("Banner", 0, 0);
        Square = new AdSize("Square", 1, 1);
        InterstitialGame = new AdSize("InterstitialGame", 2, 6);
        InterstitialReader = new AdSize("InterstitialReader", 3, 7);
        InterstitialRefresh = new AdSize("InterstitialRefresh", 4, 9);
        InterstitialOther = new AdSize("InterstitialOther", 5, 10);
        InterstitialForVideoBeforePlay = new AdSize("InterstitialForVideoBeforePlay", 6, 12);
        InterstitialForVideoPausePlay = new AdSize("InterstitialForVideoPausePlay", 7, 13);
        RewardVideo = new AdSize(KSRewardVideoActivityProxy.TAG, 8, 14);
        PrerollVideoNative = new AdSize("PrerollVideoNative", 9, 15);
        FeedNative = new AdSize("FeedNative", 10, 16);
        AdSize adSize = new AdSize("FeedH5TemplateNative", 11, 17);
        FeedH5TemplateNative = adSize;
        $VALUES = new AdSize[]{Banner, Square, InterstitialGame, InterstitialReader, InterstitialRefresh, InterstitialOther, InterstitialForVideoBeforePlay, InterstitialForVideoPausePlay, RewardVideo, PrerollVideoNative, FeedNative, adSize};
    }

    public AdSize(String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.value = i2;
    }

    public static AdSize valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            return (AdSize) Enum.valueOf(AdSize.class, str);
        }
        return (AdSize) invokeL.objValue;
    }

    public static AdSize[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return (AdSize[]) $VALUES.clone();
        }
        return (AdSize[]) invokeV.objValue;
    }

    public int getValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.value;
        }
        return invokeV.intValue;
    }
}

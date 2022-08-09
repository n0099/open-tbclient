package com.baidu.live.mix.creator;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.mix.creator.MixLiveCreatorInterface;
import com.baidu.pyramid.annotation.Autowired;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
@Autowired
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\bÇ\u0002\u0018\u0000B\t\b\u0002¢\u0006\u0004\b$\u0010%R\"\u0010\u0002\u001a\u00020\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\"\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0017\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010\u001e\u001a\u00020\u001d8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u0006&"}, d2 = {"Lcom/baidu/live/mix/creator/MixLiveShellCreateHelper;", "Lcom/baidu/live/mix/creator/MixLiveCreatorInterface$AudioLiveCreator;", "audioLiveCreator", "Lcom/baidu/live/mix/creator/MixLiveCreatorInterface$AudioLiveCreator;", "getAudioLiveCreator", "()Lcom/baidu/live/mix/creator/MixLiveCreatorInterface$AudioLiveCreator;", "setAudioLiveCreator", "(Lcom/baidu/live/mix/creator/MixLiveCreatorInterface$AudioLiveCreator;)V", "Lcom/baidu/live/mix/creator/MixLiveCreatorInterface$ConsultLiveCreator;", "consultLiveCreator", "Lcom/baidu/live/mix/creator/MixLiveCreatorInterface$ConsultLiveCreator;", "getConsultLiveCreator", "()Lcom/baidu/live/mix/creator/MixLiveCreatorInterface$ConsultLiveCreator;", "setConsultLiveCreator", "(Lcom/baidu/live/mix/creator/MixLiveCreatorInterface$ConsultLiveCreator;)V", "Lcom/baidu/live/mix/creator/MixLiveCreatorInterface$MediaLiveCreator;", "mediaLiveCreator", "Lcom/baidu/live/mix/creator/MixLiveCreatorInterface$MediaLiveCreator;", "getMediaLiveCreator", "()Lcom/baidu/live/mix/creator/MixLiveCreatorInterface$MediaLiveCreator;", "setMediaLiveCreator", "(Lcom/baidu/live/mix/creator/MixLiveCreatorInterface$MediaLiveCreator;)V", "Lcom/baidu/live/mix/creator/MixLiveCreatorInterface$NewMediaLiveCreator;", "newMediaLiveCreator", "Lcom/baidu/live/mix/creator/MixLiveCreatorInterface$NewMediaLiveCreator;", "getNewMediaLiveCreator", "()Lcom/baidu/live/mix/creator/MixLiveCreatorInterface$NewMediaLiveCreator;", "setNewMediaLiveCreator", "(Lcom/baidu/live/mix/creator/MixLiveCreatorInterface$NewMediaLiveCreator;)V", "Lcom/baidu/live/mix/creator/MixLiveCreatorInterface$ShoppingLiveCreator;", "shoppingLiveCreator", "Lcom/baidu/live/mix/creator/MixLiveCreatorInterface$ShoppingLiveCreator;", "getShoppingLiveCreator", "()Lcom/baidu/live/mix/creator/MixLiveCreatorInterface$ShoppingLiveCreator;", "setShoppingLiveCreator", "(Lcom/baidu/live/mix/creator/MixLiveCreatorInterface$ShoppingLiveCreator;)V", "<init>", "()V", "lib-live-mix-creator_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class MixLiveShellCreateHelper {
    public static /* synthetic */ Interceptable $ic;
    public static final MixLiveShellCreateHelper INSTANCE;
    public static MixLiveCreatorInterface.AudioLiveCreator audioLiveCreator;
    public static MixLiveCreatorInterface.ConsultLiveCreator consultLiveCreator;
    public static MixLiveCreatorInterface.MediaLiveCreator mediaLiveCreator;
    public static MixLiveCreatorInterface.NewMediaLiveCreator newMediaLiveCreator;
    public static MixLiveCreatorInterface.ShoppingLiveCreator shoppingLiveCreator;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-175464354, "Lcom/baidu/live/mix/creator/MixLiveShellCreateHelper;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-175464354, "Lcom/baidu/live/mix/creator/MixLiveShellCreateHelper;");
                return;
            }
        }
        INSTANCE = new MixLiveShellCreateHelper();
        mediaLiveCreator = new MixLiveCreatorInterface.MediaEmpty();
        newMediaLiveCreator = new MixLiveCreatorInterface.NewMediaEmpty();
        shoppingLiveCreator = new MixLiveCreatorInterface.ShoppingEmpty();
        consultLiveCreator = new MixLiveCreatorInterface.ConsultEmpty();
        audioLiveCreator = new MixLiveCreatorInterface.AudioEmpty();
    }

    public MixLiveShellCreateHelper() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public final MixLiveCreatorInterface.AudioLiveCreator getAudioLiveCreator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? audioLiveCreator : (MixLiveCreatorInterface.AudioLiveCreator) invokeV.objValue;
    }

    public final MixLiveCreatorInterface.ConsultLiveCreator getConsultLiveCreator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? consultLiveCreator : (MixLiveCreatorInterface.ConsultLiveCreator) invokeV.objValue;
    }

    public final MixLiveCreatorInterface.MediaLiveCreator getMediaLiveCreator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? mediaLiveCreator : (MixLiveCreatorInterface.MediaLiveCreator) invokeV.objValue;
    }

    public final MixLiveCreatorInterface.NewMediaLiveCreator getNewMediaLiveCreator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? newMediaLiveCreator : (MixLiveCreatorInterface.NewMediaLiveCreator) invokeV.objValue;
    }

    public final MixLiveCreatorInterface.ShoppingLiveCreator getShoppingLiveCreator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? shoppingLiveCreator : (MixLiveCreatorInterface.ShoppingLiveCreator) invokeV.objValue;
    }

    public final void setAudioLiveCreator(MixLiveCreatorInterface.AudioLiveCreator audioLiveCreator2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, audioLiveCreator2) == null) {
            audioLiveCreator = audioLiveCreator2;
        }
    }

    public final void setConsultLiveCreator(MixLiveCreatorInterface.ConsultLiveCreator consultLiveCreator2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, consultLiveCreator2) == null) {
            consultLiveCreator = consultLiveCreator2;
        }
    }

    public final void setMediaLiveCreator(MixLiveCreatorInterface.MediaLiveCreator mediaLiveCreator2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, mediaLiveCreator2) == null) {
            mediaLiveCreator = mediaLiveCreator2;
        }
    }

    public final void setNewMediaLiveCreator(MixLiveCreatorInterface.NewMediaLiveCreator newMediaLiveCreator2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, newMediaLiveCreator2) == null) {
            newMediaLiveCreator = newMediaLiveCreator2;
        }
    }

    public final void setShoppingLiveCreator(MixLiveCreatorInterface.ShoppingLiveCreator shoppingLiveCreator2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, shoppingLiveCreator2) == null) {
            shoppingLiveCreator = shoppingLiveCreator2;
        }
    }
}

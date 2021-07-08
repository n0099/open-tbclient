package com.baidu.searchbox.player.helper;

import android.app.Activity;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.player.UniversalPlayer;
import com.baidu.searchbox.player.utils.BdActivityUtils;
import com.baidu.searchbox.player.utils.BdViewOpUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class SimpleStyleSwitchHelper implements IPlayerStyleSwitchHelper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ViewGroup mOriginPlayerContainer;
    public UniversalPlayer mPlayer;

    public SimpleStyleSwitchHelper(@NonNull UniversalPlayer universalPlayer) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {universalPlayer};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mPlayer = universalPlayer;
    }

    private void setKeepScreenOn(@Nullable Activity activity) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, this, activity) == null) || activity == null) {
            return;
        }
        activity.getWindow().addFlags(128);
    }

    @Override // com.baidu.searchbox.player.helper.IPlayerStyleSwitchHelper
    public void switchToFullStyle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.mOriginPlayerContainer = this.mPlayer.getAttachedContainer();
            this.mPlayer.setIsFullMode(true);
            Activity activity = this.mPlayer.getActivity();
            BdActivityUtils.requestLandscape(activity, this.mPlayer.isReverseLandscape());
            setKeepScreenOn(activity);
            BdViewOpUtils.attachDecor(activity, this.mPlayer.getLayerContainer());
        }
    }

    @Override // com.baidu.searchbox.player.helper.IPlayerStyleSwitchHelper
    public void switchToNormalStyle() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.mOriginPlayerContainer == null) {
            return;
        }
        this.mOriginPlayerContainer = this.mPlayer.getAttachedContainer();
        this.mPlayer.setIsFullMode(false);
        BdActivityUtils.requestPortrait(this.mPlayer.getActivity());
        BdViewOpUtils.removeView(this.mPlayer.getLayerContainer());
        BdViewOpUtils.removeChilds(this.mPlayer.getAttachedContainer());
        BdViewOpUtils.attachView(this.mPlayer.getLayerContainer(), this.mOriginPlayerContainer);
    }
}

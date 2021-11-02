package com.baidu.searchbox.player.helper;

import androidx.annotation.NonNull;
import com.baidu.searchbox.player.BDVideoPlayer;
import com.baidu.searchbox.player.annotation.PublicMethod;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class ProgressHelper extends AbsHandlerTask {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BDVideoPlayer mPlayer;

    public ProgressHelper(@NonNull BDVideoPlayer bDVideoPlayer) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bDVideoPlayer};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mPlayer = bDVideoPlayer;
    }

    private void callPlayerBack(int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIII(65537, this, i2, i3, i4) == null) || i3 <= 0) {
            return;
        }
        this.mPlayer.getPlayerCallbackManager().onUpdateProgress(i2, (i4 * 100) / i3, i3);
    }

    @Override // com.baidu.searchbox.player.helper.ITimerTask
    @PublicMethod
    public void doTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            int position = this.mPlayer.getPosition();
            int duration = this.mPlayer.getDuration();
            int bufferingPosition = this.mPlayer.getBufferingPosition();
            this.mPlayer.getVideoSession().getControlEventTrigger().syncPos(position, duration, bufferingPosition);
            callPlayerBack(position, duration, bufferingPosition);
        }
    }
}

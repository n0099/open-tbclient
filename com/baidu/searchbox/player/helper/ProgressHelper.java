package com.baidu.searchbox.player.helper;

import androidx.annotation.NonNull;
import com.baidu.searchbox.player.BDVideoPlayer;
import com.baidu.searchbox.player.annotation.PublicMethod;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class ProgressHelper extends AbsHandlerTask {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BDVideoPlayer mPlayer;

    public ProgressHelper(@NonNull BDVideoPlayer bDVideoPlayer) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bDVideoPlayer};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mPlayer = bDVideoPlayer;
    }

    private void callPlayerBack(int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIII(65537, this, i, i2, i3) == null) || i2 <= 0) {
            return;
        }
        this.mPlayer.getPlayerCallbackManager().onUpdateProgress(i, (i3 * 100) / i2, i2);
    }

    @Override // com.baidu.searchbox.player.helper.ITimerTask
    @PublicMethod
    public void doTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            int position = this.mPlayer.getPosition();
            int duration = this.mPlayer.getDuration();
            int bufferingPosition = this.mPlayer.getBufferingPosition();
            this.mPlayer.getControlEventTrigger().syncPos(position, duration, bufferingPosition);
            callPlayerBack(position, duration, bufferingPosition);
        }
    }
}

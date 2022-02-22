package c.a.u0.b3;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.d0.m.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberVideoView;
import com.baidu.searchbox.player.UniversalPlayer;
import com.baidu.searchbox.player.event.PlayerEventTrigger;
import com.baidu.searchbox.player.kernel.AbsVideoKernel;
import com.baidu.searchbox.player.layer.BaseKernelLayer;
import com.baidu.searchbox.player.ubc.BDVideoPlayerUbcContent;
import com.baidu.searchbox.player.ubc.CoreStatPlugin;
import com.baidu.searchbox.player.ubc.DurationStatPlugin;
import com.baidu.searchbox.player.ubc.IUbcPlayerStatusFetcher;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class o extends UniversalPlayer implements f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public IUbcPlayerStatusFetcher f15595b;

    /* loaded from: classes7.dex */
    public class a implements IUbcPlayerStatusFetcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o a;

        public a(o oVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oVar;
        }

        @Override // com.baidu.searchbox.player.ubc.IUbcPlayerStatusFetcher
        public int getCurrentPosition() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a.getPosition() : invokeV.intValue;
        }

        @Override // com.baidu.searchbox.player.ubc.IUbcPlayerStatusFetcher
        public String getKernelLogId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a.mKernelLayer != null ? this.a.mKernelLayer.getKernelLogId() : "" : (String) invokeV.objValue;
        }

        @Override // com.baidu.searchbox.player.ubc.IUbcPlayerStatusFetcher
        public float getLaunchSpeedScore() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? e.a.a().getLaunchSpeedScore() : invokeV.floatValue;
        }

        @Override // com.baidu.searchbox.player.ubc.IUbcPlayerStatusFetcher
        public int getPlayType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a.a : invokeV.intValue;
        }

        @Override // com.baidu.searchbox.player.ubc.IUbcPlayerStatusFetcher
        public String getPlayUrl() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a.getVideoUrl() : (String) invokeV.objValue;
        }

        @Override // com.baidu.searchbox.player.ubc.IUbcPlayerStatusFetcher
        public String getSessionId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.a.mVideoTask.sessionId : (String) invokeV.objValue;
        }

        @Override // com.baidu.searchbox.player.ubc.IUbcPlayerStatusFetcher
        public float getStaticDeviceScore() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? e.a.a().getStaticDeviceScore() : invokeV.floatValue;
        }

        @Override // com.baidu.searchbox.player.ubc.IUbcPlayerStatusFetcher
        public String getTraceId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.a.mVideoTask.traceId : (String) invokeV.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(@Nullable Context context) {
        super(context, new BaseKernelLayer(AbsVideoKernel.CYBER_PLAYER), "");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BaseKernelLayer) objArr2[1], (String) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f15595b = new a(this);
        this.mLayerContainer.setClickable(false);
    }

    public void f() {
        PlayerEventTrigger playerEventTrigger;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (playerEventTrigger = getPlayerEventTrigger()) == null) {
            return;
        }
        playerEventTrigger.ignoreInfoEventFilter(true);
    }

    public void g(r rVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rVar) == null) || rVar == null) {
            return;
        }
        this.a = rVar.f15606f;
        updateStatisticsContent(new BDVideoPlayerUbcContent.Builder().extLog(rVar.a).url(rVar.f15602b).id(rVar.f15603c).from(rVar.f15604d).page(rVar.f15605e).playerStatusFetcher(this.f15595b).build());
    }

    @Override // com.baidu.searchbox.player.BDVideoPlayer
    public int getPlayerStageType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return 24;
        }
        return invokeV.intValue;
    }

    public void h(float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            BaseKernelLayer baseKernelLayer = this.mKernelLayer;
            if (baseKernelLayer != null && (baseKernelLayer.getContentView() instanceof CyberVideoView) && ((CyberVideoView) this.mKernelLayer.getContentView()).getCyberPlayer() != null) {
                ((CyberVideoView) this.mKernelLayer.getContentView()).getCyberPlayer().setVolume(f2, f3);
            } else {
                mute(f2 == 0.0f && f3 == 0.0f);
            }
        }
    }

    @Override // com.baidu.searchbox.player.BDVideoPlayer, com.baidu.searchbox.player.IBVideoPlayer
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            BaseKernelLayer baseKernelLayer = this.mKernelLayer;
            if (baseKernelLayer != null && (baseKernelLayer.getContentView() instanceof CyberVideoView)) {
                return ((CyberVideoView) this.mKernelLayer.getContentView()).isPlaying();
            }
            return super.isPlaying();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.searchbox.player.BDVideoPlayer
    public void onAudioFocusChanged(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
        }
    }

    @Override // com.baidu.searchbox.player.UniversalPlayer, com.baidu.searchbox.player.BDVideoPlayer
    public void setupLayers(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, context) == null) {
            this.mKernelLayer.setAcceptVolumeChange(Boolean.FALSE);
        }
    }

    @Override // com.baidu.searchbox.player.BDVideoPlayer
    public void setupPlugin(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, context) == null) {
            super.setupPlugin(context);
            addPlugin(new CoreStatPlugin());
            addPlugin(new DurationStatPlugin());
        }
    }

    @Override // com.baidu.searchbox.player.BDVideoPlayer, com.baidu.searchbox.player.IBVideoPlayer
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (isPause()) {
                resume();
            } else {
                super.start();
            }
        }
    }
}

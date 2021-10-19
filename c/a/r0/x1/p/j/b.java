package c.a.r0.x1.p.j;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.rtc.RTCCommStatesReport;
import com.baidu.rtc.player.BRTCPlayer;
import com.baidu.rtc.player.BRTCPlayerEvents;
import com.baidu.rtc.player.PlayTimeStatistician;
import com.baidu.searchbox.live.interfaces.player.BuildParams;
import com.baidu.searchbox.live.interfaces.player.IPlayerViewable;
import com.baidu.searchbox.live.interfaces.player.LivePlayer;
import com.baidu.searchbox.player.callback.IVideoPlayerCallback;
import com.baidu.searchbox.player.callback.UniversalPlayerCallbackManager;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.player.helper.IPlayerStyleSwitchHelper;
import com.baidu.tieba.medialive.player.bdrtc.TbBRTCPlayerView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b extends c.a.r0.x1.p.j.a implements LivePlayer, IPlayerViewable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbBRTCPlayerView s;
    public boolean t;
    public BuildParams u;
    public RTCCommStatesReport v;
    public String w;

    /* loaded from: classes4.dex */
    public class a implements BRTCPlayerEvents {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f28307a;

        /* renamed from: c.a.r0.x1.p.j.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC1331a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f28308e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ String f28309f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ a f28310g;

            public RunnableC1331a(a aVar, int i2, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, Integer.valueOf(i2), str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f28310g = aVar;
                this.f28308e = i2;
                this.f28309f = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                IVideoPlayerCallback iVideoPlayerCallback;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (iVideoPlayerCallback = this.f28310g.f28307a.f28300i) == null) {
                    return;
                }
                int i2 = this.f28308e;
                iVideoPlayerCallback.onError(i2, 0, this.f28309f + this.f28310g.f28307a.w);
            }
        }

        /* renamed from: c.a.r0.x1.p.j.b$a$b  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC1332b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f28311e;

            public RunnableC1332b(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f28311e = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                IVideoPlayerCallback iVideoPlayerCallback;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (iVideoPlayerCallback = this.f28311e.f28307a.f28300i) == null) {
                    return;
                }
                iVideoPlayerCallback.onInfo(904, 0);
                this.f28311e.f28307a.f28300i.onInfo(3, 0);
                this.f28311e.f28307a.f28300i.onInfo(CyberPlayerManager.MEDIA_INFO_PROCESS, 0);
                this.f28311e.f28307a.f28300i.onInfo(702, 0);
            }
        }

        /* loaded from: classes4.dex */
        public class c implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f28312e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ Object f28313f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ a f28314g;

            public c(a aVar, int i2, Object obj) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, Integer.valueOf(i2), obj};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f28314g = aVar;
                this.f28312e = i2;
                this.f28313f = obj;
            }

            @Override // java.lang.Runnable
            public void run() {
                IVideoPlayerCallback iVideoPlayerCallback;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (iVideoPlayerCallback = this.f28314g.f28307a.f28300i) == null) {
                    return;
                }
                iVideoPlayerCallback.onInfo(this.f28312e, 0);
                if (this.f28312e == 1003 && this.f28314g.f28307a.s.isPlaying()) {
                    Object obj = this.f28313f;
                    if (obj instanceof RTCCommStatesReport) {
                        this.f28314g.f28307a.v = (RTCCommStatesReport) obj;
                    }
                    this.f28314g.f28307a.f28300i.onInfo(CyberPlayerManager.MEDIA_INFO_PROCESS, 0);
                    return;
                }
                int i2 = this.f28312e;
                if (i2 == 1004) {
                    this.f28314g.f28307a.f28300i.onBufferStart();
                    this.f28314g.f28307a.f28300i.onInfo(701, 0);
                } else if (i2 == 1005) {
                    this.f28314g.f28307a.f28300i.onBufferEnd();
                    this.f28314g.f28307a.f28300i.onInfo(702, 0);
                } else if (i2 == 1008) {
                    this.f28314g.f28307a.j(this.f28313f);
                }
            }
        }

        /* loaded from: classes4.dex */
        public class d implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f28315e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f28316f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ a f28317g;

            public d(a aVar, int i2, int i3) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, Integer.valueOf(i2), Integer.valueOf(i3)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i4 = newInitContext.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f28317g = aVar;
                this.f28315e = i2;
                this.f28316f = i3;
            }

            @Override // java.lang.Runnable
            public void run() {
                IVideoPlayerCallback iVideoPlayerCallback;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (iVideoPlayerCallback = this.f28317g.f28307a.f28300i) == null) {
                    return;
                }
                iVideoPlayerCallback.onVideoSizeChanged(this.f28315e, this.f28316f);
            }
        }

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f28307a = bVar;
        }

        @Override // com.baidu.rtc.player.BRTCPlayerEvents
        public void onError(int i2, String str) {
            b bVar;
            TbBRTCPlayerView tbBRTCPlayerView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) || (tbBRTCPlayerView = (bVar = this.f28307a).s) == null || bVar.f28300i == null) {
                return;
            }
            tbBRTCPlayerView.post(new RunnableC1331a(this, i2, str));
        }

        @Override // com.baidu.rtc.player.BRTCPlayerEvents
        public void onFirstFrameRendered() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f28307a.a("onFirstFrameRendered invoked");
                b bVar = this.f28307a;
                TbBRTCPlayerView tbBRTCPlayerView = bVar.s;
                if (tbBRTCPlayerView == null || bVar.f28300i == null) {
                    return;
                }
                tbBRTCPlayerView.post(new RunnableC1332b(this));
            }
        }

        @Override // com.baidu.rtc.player.BRTCPlayerEvents
        public void onInfoUpdated(int i2, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, obj) == null) {
                b bVar = this.f28307a;
                bVar.f("onInfoUpdated i= " + i2 + " s= " + obj);
                b bVar2 = this.f28307a;
                TbBRTCPlayerView tbBRTCPlayerView = bVar2.s;
                if (tbBRTCPlayerView == null || bVar2.f28300i == null) {
                    return;
                }
                tbBRTCPlayerView.post(new c(this, i2, obj));
            }
        }

        @Override // com.baidu.rtc.player.BRTCPlayerEvents
        public void onPlayerStateChanged(BRTCPlayer.PlayerState playerState) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, playerState) == null) {
                b bVar = this.f28307a;
                bVar.f("onPlayerStateChanged " + playerState.name());
            }
        }

        @Override // com.baidu.rtc.player.BRTCPlayerEvents
        public void onRemoteData(ByteBuffer byteBuffer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, byteBuffer) == null) {
                b bVar = this.f28307a;
                bVar.f("onRemoteData " + byteBuffer);
            }
        }

        @Override // com.baidu.rtc.player.BRTCPlayerEvents
        public void onRemoteStreamStats(boolean z, boolean z2, BigInteger bigInteger) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), bigInteger}) == null) {
                b bVar = this.f28307a;
                bVar.f("onRemoteStreamStats hasVideo: " + z + "hasAudio: " + z2 + " handleID: " + bigInteger);
            }
        }

        @Override // com.baidu.rtc.player.BRTCPlayerEvents
        public void onResolutionChanged(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048582, this, i2, i3) == null) {
                b bVar = this.f28307a;
                bVar.f("onResolutionChanged " + i2 + " " + i3);
                b bVar2 = this.f28307a;
                TbBRTCPlayerView tbBRTCPlayerView = bVar2.s;
                if (tbBRTCPlayerView == null || bVar2.f28300i == null) {
                    return;
                }
                tbBRTCPlayerView.post(new d(this, i2, i3));
            }
        }

        @Override // com.baidu.rtc.player.BRTCPlayerEvents
        public void onSEIRecv(ByteBuffer byteBuffer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, byteBuffer) == null) {
                b bVar = this.f28307a;
                bVar.f("onSEIRecv " + byteBuffer);
                this.f28307a.e(10103, 0, byteBuffer);
            }
        }
    }

    public b(BuildParams buildParams) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {buildParams};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.t = false;
        this.u = buildParams;
        k();
    }

    @Override // com.baidu.searchbox.live.interfaces.player.IPlayerViewable
    public void attachKernelView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            if (view instanceof TbBRTCPlayerView) {
                this.s = (TbBRTCPlayerView) view;
            }
            attachToContainer(this.m);
        }
    }

    @Override // c.a.r0.x1.p.j.a, com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void attachToContainer(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup) == null) {
            a("attachToContainer " + viewGroup);
            super.attachToContainer(viewGroup);
            if (this.s == null) {
                c(viewGroup.getContext());
                TbBRTCPlayerView tbBRTCPlayerView = new TbBRTCPlayerView(viewGroup.getContext());
                this.s = tbBRTCPlayerView;
                tbBRTCPlayerView.setParams(this.u);
                this.s.setBRTCPlayerEvents(new a(this));
            }
            TbBRTCPlayerView tbBRTCPlayerView2 = this.s;
            if (tbBRTCPlayerView2 == null || tbBRTCPlayerView2.getParent() == viewGroup) {
                return;
            }
            this.s.attachContainer(viewGroup);
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void detachFromContainer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            a("detachFromContainer ");
            TbBRTCPlayerView tbBRTCPlayerView = this.s;
            if (tbBRTCPlayerView != null) {
                tbBRTCPlayerView.dettachContainer();
            }
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.player.IPlayerViewable
    @Nullable
    public View detachKernelView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            detachFromContainer();
            return this.s;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public int getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    @Nullable
    public Object getInfo(Object obj, @Nullable Object obj2, @Nullable LivePlayer.InfoCallback infoCallback) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, obj, obj2, infoCallback)) == null) {
            if ("video_fps".equals(obj)) {
                return Integer.valueOf(this.v.getVideoOutputFps());
            }
            if ("getUri".equals(obj)) {
                return getVideoUrl();
            }
            if ("player_id".equals(obj)) {
                TbBRTCPlayerView tbBRTCPlayerView = this.s;
                if (tbBRTCPlayerView != null) {
                    return Long.valueOf(tbBRTCPlayerView.getPlayerID());
                }
                return null;
            } else if ("firtFrameTimePart".equals(obj)) {
                return this.w;
            } else {
                return null;
            }
        }
        return invokeLLL.objValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public UniversalPlayerCallbackManager getPlayerCallbackManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return null;
        }
        return (UniversalPlayerCallbackManager) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public int getPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    @Nullable
    public String getServerIpInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            RTCCommStatesReport rTCCommStatesReport = this.v;
            return rTCCommStatesReport != null ? rTCCommStatesReport.getRemoteAddr() : "";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    @Nullable
    public String getVideoUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            TbBRTCPlayerView tbBRTCPlayerView = this.s;
            return tbBRTCPlayerView != null ? tbBRTCPlayerView.getVideoUrl() : "";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void imCloseTimeStatistics() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public boolean isComplete() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public boolean isError() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            TbBRTCPlayerView tbBRTCPlayerView = this.s;
            if (tbBRTCPlayerView != null) {
                return tbBRTCPlayerView.isError();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public boolean isPause() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            TbBRTCPlayerView tbBRTCPlayerView = this.s;
            if (tbBRTCPlayerView != null) {
                return tbBRTCPlayerView.isPause();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            TbBRTCPlayerView tbBRTCPlayerView = this.s;
            return tbBRTCPlayerView != null && tbBRTCPlayerView.isPlaying();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public boolean isReverseLandscape() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void j(Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048592, this, obj) == null) && (obj instanceof PlayTimeStatistician)) {
            a("time statistic updated ${timeStatistician?.toString()}\nmap: ${timeStatistician?.getTimeStepsMap()}");
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry<PlayTimeStatistician.PlayStep, Long> entry : ((PlayTimeStatistician) obj).getTimeStepsMap().entrySet()) {
                if (entry.getValue() != null) {
                    try {
                        jSONObject.put(entry.getKey().toString(), entry.getValue());
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
            }
            this.w = jSONObject.toString();
            a("json ${firtFrameTimePart}");
        }
    }

    public final void k() {
        BuildParams buildParams;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (buildParams = this.u) == null) {
            return;
        }
        Object option = buildParams.getOption(BuildParams.K_DEBUG_LEVEL, 0);
        if (option instanceof Integer) {
            b(((Integer) option).intValue());
        }
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    public void mute(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
        }
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            a("BRTCPlayer pause");
            TbBRTCPlayerView tbBRTCPlayerView = this.s;
            if (tbBRTCPlayerView != null) {
                tbBRTCPlayerView.pause();
                IVideoPlayerCallback iVideoPlayerCallback = this.f28300i;
                if (iVideoPlayerCallback != null) {
                    iVideoPlayerCallback.onPause();
                }
            }
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void pauseInternal(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            a("pauseInternal isUserClick= " + z);
            this.t = z;
            pause();
        }
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    public void play(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
            a("BRTCPlayer play");
            TbBRTCPlayerView tbBRTCPlayerView = this.s;
            if (tbBRTCPlayerView != null) {
                tbBRTCPlayerView.play(str);
            }
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void prePlay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
        }
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    public void prepare() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
        }
    }

    @Override // c.a.r0.x1.p.j.a, com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            super.release();
            a("BRTCPlayer release");
            TbBRTCPlayerView tbBRTCPlayerView = this.s;
            if (tbBRTCPlayerView != null) {
                this.f28300i = null;
                tbBRTCPlayerView.release();
                this.s = null;
            }
            ViewGroup viewGroup = this.m;
            if (viewGroup != null) {
                viewGroup.removeAllViews();
                this.m = null;
            }
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void resetDefaultSwitchHelper() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void resume(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
            a("resume isForce= $isForce");
            if (z) {
                resume();
            } else if (this.t) {
            } else {
                resume();
            }
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void resumeFromError() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            a("BRTCPlayer resumeFromError");
            TbBRTCPlayerView tbBRTCPlayerView = this.s;
            if (tbBRTCPlayerView != null) {
                tbBRTCPlayerView.resumeFromError();
            }
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void resumePlayer(boolean z) {
        TbBRTCPlayerView tbBRTCPlayerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048605, this, z) == null) || (tbBRTCPlayerView = this.s) == null) {
            return;
        }
        tbBRTCPlayerView.resume();
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void saveProgressToDb() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
        }
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    public void seekTo(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i2) == null) {
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void seekTo(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048608, this, i2, i3) == null) {
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void sendEvent(VideoEvent videoEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, videoEvent) == null) {
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void setExtInfoStatistics(@Nullable HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, hashMap) == null) {
        }
    }

    @Override // c.a.r0.x1.p.j.a, com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void setOrientationLock(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048611, this, z) == null) {
            super.setOrientationLock(z);
        }
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    public void setParameter(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048612, this, str, i2) == null) {
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void setSpeed(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048613, this, f2) == null) {
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void setStyleSwitchHelper(IPlayerStyleSwitchHelper iPlayerStyleSwitchHelper) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, iPlayerStyleSwitchHelper) == null) {
        }
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    public void setUserAgent(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, str) == null) {
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void setVideoInfo(@Nullable HashMap<Integer, String> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, hashMap) == null) {
            a("setVideoInfo${videoInfo?.map " + hashMap);
            TbBRTCPlayerView tbBRTCPlayerView = this.s;
            if (tbBRTCPlayerView != null) {
                tbBRTCPlayerView.setVideoInfo(hashMap);
            }
        }
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    public void setVideoRotation(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048617, this, i2) == null) {
        }
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    public void setVideoScalingMode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048618, this, i2) == null) {
        }
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    public void setVideoUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, str) == null) {
            a("BRTCPlayer setVideoUrl url= " + str);
            if (this.s == null || TextUtils.isEmpty(str)) {
                return;
            }
            this.s.setVideoUrl(str);
        }
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            a("BRTCPlayer start");
            TbBRTCPlayerView tbBRTCPlayerView = this.s;
            if (tbBRTCPlayerView != null) {
                tbBRTCPlayerView.start();
                IVideoPlayerCallback iVideoPlayerCallback = this.f28300i;
                if (iVideoPlayerCallback != null) {
                    iVideoPlayerCallback.onStart();
                }
            }
        }
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    public void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            a("BRTCPlayer stop ");
            TbBRTCPlayerView tbBRTCPlayerView = this.s;
            if (tbBRTCPlayerView != null) {
                tbBRTCPlayerView.stop();
            }
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void stopTimeStatistics() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
        }
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    public void resume() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048602, this) == null) && isPause()) {
            a("resume no force");
            this.s.resume();
            IVideoPlayerCallback iVideoPlayerCallback = this.f28300i;
            if (iVideoPlayerCallback != null) {
                iVideoPlayerCallback.onResume();
            }
        }
    }
}

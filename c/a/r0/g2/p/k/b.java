package c.a.r0.g2.p.k;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
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
/* loaded from: classes2.dex */
public class b extends c.a.r0.g2.p.k.a implements LivePlayer, IPlayerViewable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbBRTCPlayerView o;
    public boolean p;
    public BuildParams q;
    public RTCCommStatesReport r;
    public String s;

    /* loaded from: classes2.dex */
    public class a implements BRTCPlayerEvents {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        /* renamed from: c.a.r0.g2.p.k.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC1106a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f17529e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ String f17530f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ a f17531g;

            public RunnableC1106a(a aVar, int i2, String str) {
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
                this.f17531g = aVar;
                this.f17529e = i2;
                this.f17530f = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                IVideoPlayerCallback iVideoPlayerCallback;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (iVideoPlayerCallback = this.f17531g.a.f17519e) == null) {
                    return;
                }
                int i2 = this.f17529e;
                iVideoPlayerCallback.onError(i2, 0, this.f17530f + this.f17531g.a.s);
            }
        }

        /* renamed from: c.a.r0.g2.p.k.b$a$b  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC1107b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f17532e;

            public RunnableC1107b(a aVar) {
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
                this.f17532e = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                IVideoPlayerCallback iVideoPlayerCallback;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (iVideoPlayerCallback = this.f17532e.a.f17519e) == null) {
                    return;
                }
                iVideoPlayerCallback.onInfo(904, 0);
                this.f17532e.a.f17519e.onInfo(3, 0);
                this.f17532e.a.f17519e.onInfo(910, 0);
                this.f17532e.a.f17519e.onInfo(702, 0);
            }
        }

        /* loaded from: classes2.dex */
        public class c implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f17533e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ Object f17534f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ a f17535g;

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
                this.f17535g = aVar;
                this.f17533e = i2;
                this.f17534f = obj;
            }

            @Override // java.lang.Runnable
            public void run() {
                IVideoPlayerCallback iVideoPlayerCallback;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (iVideoPlayerCallback = this.f17535g.a.f17519e) == null) {
                    return;
                }
                iVideoPlayerCallback.onInfo(this.f17533e, 0);
                if (this.f17533e == 1003 && this.f17535g.a.o.isPlaying()) {
                    Object obj = this.f17534f;
                    if (obj instanceof RTCCommStatesReport) {
                        this.f17535g.a.r = (RTCCommStatesReport) obj;
                    }
                    this.f17535g.a.f17519e.onInfo(910, 0);
                    return;
                }
                int i2 = this.f17533e;
                if (i2 == 1004) {
                    this.f17535g.a.f17519e.onBufferStart();
                    this.f17535g.a.f17519e.onInfo(701, 0);
                } else if (i2 == 1005) {
                    this.f17535g.a.f17519e.onBufferEnd();
                    this.f17535g.a.f17519e.onInfo(702, 0);
                } else if (i2 == 1008) {
                    this.f17535g.a.j(this.f17534f);
                }
            }
        }

        /* loaded from: classes2.dex */
        public class d implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f17536e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f17537f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ a f17538g;

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
                this.f17538g = aVar;
                this.f17536e = i2;
                this.f17537f = i3;
            }

            @Override // java.lang.Runnable
            public void run() {
                IVideoPlayerCallback iVideoPlayerCallback;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (iVideoPlayerCallback = this.f17538g.a.f17519e) == null) {
                    return;
                }
                iVideoPlayerCallback.onVideoSizeChanged(this.f17536e, this.f17537f);
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
            this.a = bVar;
        }

        @Override // com.baidu.rtc.player.BRTCPlayerEvents
        public void onError(int i2, String str) {
            b bVar;
            TbBRTCPlayerView tbBRTCPlayerView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) || (tbBRTCPlayerView = (bVar = this.a).o) == null || bVar.f17519e == null) {
                return;
            }
            tbBRTCPlayerView.post(new RunnableC1106a(this, i2, str));
        }

        @Override // com.baidu.rtc.player.BRTCPlayerEvents
        public void onFirstFrameRendered() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.a("onFirstFrameRendered invoked");
                b bVar = this.a;
                TbBRTCPlayerView tbBRTCPlayerView = bVar.o;
                if (tbBRTCPlayerView == null || bVar.f17519e == null) {
                    return;
                }
                tbBRTCPlayerView.post(new RunnableC1107b(this));
            }
        }

        @Override // com.baidu.rtc.player.BRTCPlayerEvents
        public void onInfoUpdated(int i2, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, obj) == null) {
                b bVar = this.a;
                bVar.f("onInfoUpdated i= " + i2 + " s= " + obj);
                b bVar2 = this.a;
                TbBRTCPlayerView tbBRTCPlayerView = bVar2.o;
                if (tbBRTCPlayerView == null || bVar2.f17519e == null) {
                    return;
                }
                tbBRTCPlayerView.post(new c(this, i2, obj));
            }
        }

        @Override // com.baidu.rtc.player.BRTCPlayerEvents
        public void onPlayerStateChanged(BRTCPlayer.PlayerState playerState) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, playerState) == null) {
                b bVar = this.a;
                bVar.f("onPlayerStateChanged " + playerState.name());
            }
        }

        @Override // com.baidu.rtc.player.BRTCPlayerEvents
        public void onRemoteData(ByteBuffer byteBuffer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, byteBuffer) == null) {
                b bVar = this.a;
                bVar.f("onRemoteData " + byteBuffer);
            }
        }

        @Override // com.baidu.rtc.player.BRTCPlayerEvents
        public void onRemoteStreamStats(boolean z, boolean z2, BigInteger bigInteger) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), bigInteger}) == null) {
                b bVar = this.a;
                bVar.f("onRemoteStreamStats hasVideo: " + z + "hasAudio: " + z2 + " handleID: " + bigInteger);
            }
        }

        @Override // com.baidu.rtc.player.BRTCPlayerEvents
        public void onResolutionChanged(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048582, this, i2, i3) == null) {
                b bVar = this.a;
                bVar.f("onResolutionChanged " + i2 + " " + i3);
                b bVar2 = this.a;
                TbBRTCPlayerView tbBRTCPlayerView = bVar2.o;
                if (tbBRTCPlayerView == null || bVar2.f17519e == null) {
                    return;
                }
                tbBRTCPlayerView.post(new d(this, i2, i3));
            }
        }

        @Override // com.baidu.rtc.player.BRTCPlayerEvents
        public void onSEIRecv(ByteBuffer byteBuffer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, byteBuffer) == null) {
                b bVar = this.a;
                bVar.f("onSEIRecv " + byteBuffer);
                this.a.e(10103, 0, byteBuffer);
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
        this.p = false;
        this.q = buildParams;
        k();
    }

    @Override // com.baidu.searchbox.live.interfaces.player.IPlayerViewable
    public void attachKernelView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            if (view instanceof TbBRTCPlayerView) {
                this.o = (TbBRTCPlayerView) view;
            }
            attachToContainer(this.f17523i);
        }
    }

    @Override // c.a.r0.g2.p.k.a, com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void attachToContainer(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup) == null) {
            a("attachToContainer " + viewGroup);
            super.attachToContainer(viewGroup);
            if (this.o == null) {
                c(viewGroup.getContext());
                TbBRTCPlayerView tbBRTCPlayerView = new TbBRTCPlayerView(viewGroup.getContext());
                this.o = tbBRTCPlayerView;
                tbBRTCPlayerView.setParams(this.q);
                this.o.setBRTCPlayerEvents(new a(this));
            }
            TbBRTCPlayerView tbBRTCPlayerView2 = this.o;
            if (tbBRTCPlayerView2 == null || tbBRTCPlayerView2.getParent() == viewGroup) {
                return;
            }
            this.o.attachContainer(viewGroup);
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void detachFromContainer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            a("detachFromContainer ");
            TbBRTCPlayerView tbBRTCPlayerView = this.o;
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
            return this.o;
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
                return Integer.valueOf(this.r.getVideoOutputFps());
            }
            if ("getUri".equals(obj)) {
                return getVideoUrl();
            }
            if ("player_id".equals(obj)) {
                TbBRTCPlayerView tbBRTCPlayerView = this.o;
                if (tbBRTCPlayerView != null) {
                    return Long.valueOf(tbBRTCPlayerView.getPlayerID());
                }
                return null;
            } else if ("firtFrameTimePart".equals(obj)) {
                return this.s;
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
            RTCCommStatesReport rTCCommStatesReport = this.r;
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
            TbBRTCPlayerView tbBRTCPlayerView = this.o;
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
            TbBRTCPlayerView tbBRTCPlayerView = this.o;
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
            TbBRTCPlayerView tbBRTCPlayerView = this.o;
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
            TbBRTCPlayerView tbBRTCPlayerView = this.o;
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
            this.s = jSONObject.toString();
            a("json ${firtFrameTimePart}");
        }
    }

    public final void k() {
        BuildParams buildParams;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (buildParams = this.q) == null) {
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
            TbBRTCPlayerView tbBRTCPlayerView = this.o;
            if (tbBRTCPlayerView != null) {
                tbBRTCPlayerView.pause();
                IVideoPlayerCallback iVideoPlayerCallback = this.f17519e;
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
            this.p = z;
            pause();
        }
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    public void play(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
            a("BRTCPlayer play");
            TbBRTCPlayerView tbBRTCPlayerView = this.o;
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

    @Override // c.a.r0.g2.p.k.a, com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            super.release();
            a("BRTCPlayer release");
            TbBRTCPlayerView tbBRTCPlayerView = this.o;
            if (tbBRTCPlayerView != null) {
                this.f17519e = null;
                tbBRTCPlayerView.release();
                this.o = null;
            }
            ViewGroup viewGroup = this.f17523i;
            if (viewGroup != null) {
                viewGroup.removeAllViews();
                this.f17523i = null;
            }
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void removePlayerListener(@Nullable IVideoPlayerCallback iVideoPlayerCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, iVideoPlayerCallback) == null) {
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void resetDefaultSwitchHelper() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void resume(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048604, this, z) == null) {
            a("resume isForce= $isForce");
            if (z) {
                resume();
            } else if (this.p) {
            } else {
                resume();
            }
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void resumeFromError() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            a("BRTCPlayer resumeFromError");
            TbBRTCPlayerView tbBRTCPlayerView = this.o;
            if (tbBRTCPlayerView != null) {
                tbBRTCPlayerView.resumeFromError();
            }
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void resumePlayer(boolean z) {
        TbBRTCPlayerView tbBRTCPlayerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048606, this, z) == null) || (tbBRTCPlayerView = this.o) == null) {
            return;
        }
        tbBRTCPlayerView.resume();
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void saveProgressToDb() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
        }
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    public void seekTo(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i2) == null) {
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void seekTo(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048609, this, i2, i3) == null) {
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void sendEvent(VideoEvent videoEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, videoEvent) == null) {
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void setAcceptVolumeChange(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048611, this, z) == null) {
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void setExtInfoStatistics(@Nullable HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, hashMap) == null) {
        }
    }

    @Override // c.a.r0.g2.p.k.a, com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void setOrientationLock(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048613, this, z) == null) {
            super.setOrientationLock(z);
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void setSpeed(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048614, this, f2) == null) {
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void setStyleSwitchHelper(IPlayerStyleSwitchHelper iPlayerStyleSwitchHelper) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, iPlayerStyleSwitchHelper) == null) {
        }
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    public void setUserAgent(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, str) == null) {
        }
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    public void setVideoBackground(@Nullable Drawable drawable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048617, this, drawable) == null) || drawable == null || this.o == null) {
            return;
        }
        a("setVideoBackground: " + drawable);
        this.o.setBackground(drawable);
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void setVideoInfo(@Nullable HashMap<Integer, String> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, hashMap) == null) {
            a("setVideoInfo${videoInfo?.map " + hashMap);
            TbBRTCPlayerView tbBRTCPlayerView = this.o;
            if (tbBRTCPlayerView != null) {
                tbBRTCPlayerView.setVideoInfo(hashMap);
            }
        }
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    public void setVideoRotation(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048619, this, i2) == null) {
        }
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    public void setVideoScalingMode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048620, this, i2) == null) {
        }
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    public void setVideoUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, str) == null) {
            a("BRTCPlayer setVideoUrl url= " + str);
            if (this.o == null || TextUtils.isEmpty(str)) {
                return;
            }
            this.o.setVideoUrl(str);
        }
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            a("BRTCPlayer start");
            TbBRTCPlayerView tbBRTCPlayerView = this.o;
            if (tbBRTCPlayerView != null) {
                tbBRTCPlayerView.start();
                IVideoPlayerCallback iVideoPlayerCallback = this.f17519e;
                if (iVideoPlayerCallback != null) {
                    iVideoPlayerCallback.onStart();
                }
            }
        }
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    public void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            a("BRTCPlayer stop ");
            TbBRTCPlayerView tbBRTCPlayerView = this.o;
            if (tbBRTCPlayerView != null) {
                tbBRTCPlayerView.stop();
            }
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void stopTimeStatistics() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
        }
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    public void resume() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048603, this) == null) && isPause()) {
            a("resume no force");
            this.o.resume();
            IVideoPlayerCallback iVideoPlayerCallback = this.f17519e;
            if (iVideoPlayerCallback != null) {
                iVideoPlayerCallback.onResume();
            }
        }
    }
}

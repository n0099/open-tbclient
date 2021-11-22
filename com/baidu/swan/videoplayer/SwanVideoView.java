package com.baidu.swan.videoplayer;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.PlaybackParams;
import android.net.Uri;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.y.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.videoplayer.media.video.view.MediaGestureLayout;
import com.baidu.swan.videoplayer.widget.MediaController;
import com.baidu.swan.videoplayer.widget.MediaTipStateLayer;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.util.Map;
import org.webrtc.MediaStreamTrack;
/* loaded from: classes8.dex */
public class SwanVideoView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int STATE_ERROR = -1;
    public static final int STATE_IDLE = 0;
    public static final int STATE_PAUSED = 4;
    public static final int STATE_PLAYBACK_COMPLETED = 5;
    public static final int STATE_PLAYING = 3;
    public static final int STATE_PREPARED = 2;
    public static final int STATE_PREPARING = 1;
    public static final int VIDEO_SCALING_MODE_SCALE_TO_FIT = 1;
    public static final int VIDEO_SCALING_MODE_SCALE_TO_FIT_WITH_CROPPING = 2;
    public static final int VIDEO_SCALING_MODE_SCALE_TO_MATCH_PARENT = 3;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public int B;
    public FrameLayout C;
    public b.a.p0.y.j.a D;
    public boolean E;
    public AudioManager F;
    public AudioManager.OnAudioFocusChangeListener G;
    public boolean H;
    public MediaPlayer.OnPreparedListener I;
    public MediaPlayer.OnCompletionListener J;
    public MediaPlayer.OnVideoSizeChangedListener K;
    public MediaPlayer.OnErrorListener L;
    public MediaPlayer.OnBufferingUpdateListener M;
    public MediaPlayer.OnSeekCompleteListener N;
    public a.InterfaceC0659a O;

    /* renamed from: e  reason: collision with root package name */
    public int f45682e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f45683f;

    /* renamed from: g  reason: collision with root package name */
    public Uri f45684g;

    /* renamed from: h  reason: collision with root package name */
    public Map<String, String> f45685h;

    /* renamed from: i  reason: collision with root package name */
    public MediaController f45686i;
    public b.a.p0.y.n.c j;
    public b.a.p0.y.n.d k;
    public b.a.p0.y.n.e l;
    public b.a.p0.y.n.b m;
    public MediaTipStateLayer n;
    public b.a.p0.y.l.b.c.c o;
    public MediaPlayer p;
    public int q;
    public Context r;
    public int s;
    public boolean t;
    public boolean u;
    public boolean v;
    public boolean w;
    public View x;
    public int y;
    public b.a.p0.y.a z;

    /* loaded from: classes8.dex */
    public class a extends MediaGestureLayout.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SwanVideoView f45687a;

        public a(SwanVideoView swanVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanVideoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45687a = swanVideoView;
        }

        @Override // com.baidu.swan.videoplayer.media.video.view.MediaGestureLayout.c, com.baidu.swan.videoplayer.media.video.view.MediaGestureLayout.b
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.f45687a.seekTo(i2);
            }
        }

        @Override // com.baidu.swan.videoplayer.media.video.view.MediaGestureLayout.c, com.baidu.swan.videoplayer.media.video.view.MediaGestureLayout.b
        public void onDoubleTap(MotionEvent motionEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent) == null) {
                if (this.f45687a.isPlaying()) {
                    this.f45687a.pause();
                } else {
                    this.f45687a.start();
                }
            }
        }

        @Override // com.baidu.swan.videoplayer.media.video.view.MediaGestureLayout.c, com.baidu.swan.videoplayer.media.video.view.MediaGestureLayout.b
        public void onSingleTap(MotionEvent motionEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, motionEvent) == null) {
                this.f45687a.y();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements MediaPlayer.OnPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanVideoView f45688e;

        public b(SwanVideoView swanVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanVideoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45688e = swanVideoView;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, mediaPlayer) == null) {
                this.f45688e.setCurrentState(2);
                this.f45688e.setCacheViewVisibility(false);
                if (this.f45688e.D != null) {
                    this.f45688e.D.onPrepared();
                }
                this.f45688e.A = mediaPlayer.getVideoWidth();
                this.f45688e.B = mediaPlayer.getVideoHeight();
                if (this.f45688e.A != 0 && this.f45688e.B != 0 && this.f45688e.z != null) {
                    this.f45688e.z.setVideoSize(this.f45688e.A, this.f45688e.B);
                }
                if (this.f45688e.f45683f) {
                    this.f45688e.start();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements MediaPlayer.OnCompletionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanVideoView f45689e;

        public c(SwanVideoView swanVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanVideoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45689e = swanVideoView;
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, mediaPlayer) == null) {
                this.f45689e.setCacheViewVisibility(false);
                this.f45689e.setCurrentState(5);
                this.f45689e.f45683f = false;
                if (this.f45689e.D != null) {
                    this.f45689e.D.onEnd();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements MediaPlayer.OnVideoSizeChangedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanVideoView f45690e;

        public d(SwanVideoView swanVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanVideoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45690e = swanVideoView;
        }

        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, mediaPlayer, i2, i3) == null) {
                this.f45690e.A = mediaPlayer.getVideoWidth();
                this.f45690e.B = mediaPlayer.getVideoHeight();
                if (this.f45690e.A == 0 || this.f45690e.B == 0) {
                    return;
                }
                if (this.f45690e.z != null) {
                    this.f45690e.z.setVideoSize(this.f45690e.A, this.f45690e.B);
                }
                if (this.f45690e.D != null) {
                    this.f45690e.D.onVideoSizeChanged(i2, i3);
                }
                this.f45690e.requestLayout();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements MediaPlayer.OnErrorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanVideoView f45691e;

        public e(SwanVideoView swanVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanVideoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45691e = swanVideoView;
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, mediaPlayer, i2, i3)) == null) {
                String str = "onError: " + i2 + "," + i3;
                this.f45691e.setCurrentState(-1);
                this.f45691e.f45683f = false;
                this.f45691e.setCacheViewVisibility(false);
                if (this.f45691e.D != null) {
                    this.f45691e.D.onError(i2, i3, null);
                }
                return this.f45691e.D != null;
            }
            return invokeLII.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class f implements MediaPlayer.OnBufferingUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanVideoView f45692e;

        public f(SwanVideoView swanVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanVideoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45692e = swanVideoView;
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, mediaPlayer, i2) == null) {
                String str = "onBufferingUpdate: percent=" + i2;
                this.f45692e.q = i2;
                if (this.f45692e.D != null) {
                    this.f45692e.D.onBufferingUpdate(i2);
                }
                if (this.f45692e.f45686i != null) {
                    this.f45692e.f45686i.onTotalCacheUpdate((i2 * this.f45692e.getDuration()) / 100);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements MediaPlayer.OnSeekCompleteListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanVideoView f45693e;

        public g(SwanVideoView swanVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanVideoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45693e = swanVideoView;
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, mediaPlayer) == null) {
                this.f45693e.setCacheViewVisibility(false);
                if (this.f45693e.D != null) {
                    this.f45693e.D.onSeekEnd();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class h implements a.InterfaceC0659a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SwanVideoView f45694a;

        public h(SwanVideoView swanVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanVideoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45694a = swanVideoView;
        }

        @Override // b.a.p0.y.a.InterfaceC0659a
        public void a(a.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            }
        }

        @Override // b.a.p0.y.a.InterfaceC0659a
        public void b(a.b bVar, int i2, int i3) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, i2, i3) == null) && bVar.b() == this.f45694a.z && this.f45694a.p != null) {
                SwanVideoView swanVideoView = this.f45694a;
                swanVideoView.r(swanVideoView.p, bVar);
            }
        }

        @Override // b.a.p0.y.a.InterfaceC0659a
        public void c(a.b bVar, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, bVar, i2, i3, i4) == null) {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwanVideoView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f45682e = 0;
        this.s = -1;
        this.w = true;
        this.y = 0;
        this.I = new b(this);
        this.J = new c(this);
        this.K = new d(this);
        this.L = new e(this);
        this.M = new f(this);
        this.N = new g(this);
        this.O = new h(this);
        u(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCacheViewVisibility(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65554, this, z) == null) {
            if (z) {
                this.x.setVisibility(0);
            } else {
                this.x.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCurrentState(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65555, this, i2) == null) || this.f45682e == i2) {
            return;
        }
        this.f45682e = i2;
        MediaController mediaController = this.f45686i;
        if (mediaController != null) {
            mediaController.updateState();
        }
    }

    public MediaPlayer createPlayer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            MediaPlayer mediaPlayer = new MediaPlayer();
            mediaPlayer.setLooping(this.t);
            mediaPlayer.setWakeMode(getContext(), 10);
            return mediaPlayer;
        }
        return (MediaPlayer) invokeV.objValue;
    }

    public Bitmap getBitmap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            b.a.p0.y.a aVar = this.z;
            if (aVar != null) {
                return aVar.getBitmap();
            }
            return null;
        }
        return (Bitmap) invokeV.objValue;
    }

    public int getBufferPercentage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.p != null) {
                return this.q;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public int getCurrentPlayerState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f45682e : invokeV.intValue;
    }

    public String getCurrentPlayingUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            Uri uri = this.f45684g;
            if (uri != null) {
                return uri.toString();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (isInPlaybackState()) {
                return this.p.getCurrentPosition();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public int getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (isInPlaybackState()) {
                return this.p.getDuration();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public MediaTipStateLayer.TipState getTipState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.n.c() : (MediaTipStateLayer.TipState) invokeV.objValue;
    }

    public int getVideoHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.p.getVideoHeight() : invokeV.intValue;
    }

    public b.a.p0.y.j.a getVideoPlayerCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.D : (b.a.p0.y.j.a) invokeV.objValue;
    }

    public int getVideoWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.p.getVideoWidth() : invokeV.intValue;
    }

    public boolean isEnd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f45682e == 5 : invokeV.booleanValue;
    }

    public boolean isInPlaybackState() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? (this.p == null || (i2 = this.f45682e) == -1 || i2 == 0 || i2 == 1) ? false : true : invokeV.booleanValue;
    }

    public boolean isIsLandscape() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.E : invokeV.booleanValue;
    }

    public boolean isMute() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.u : invokeV.booleanValue;
    }

    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? isInPlaybackState() && this.p.isPlaying() : invokeV.booleanValue;
    }

    public boolean isSilent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.v : invokeV.booleanValue;
    }

    public void openVideo() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            try {
                MediaPlayer createPlayer = createPlayer();
                this.p = createPlayer;
                createPlayer.setOnPreparedListener(this.I);
                this.p.setOnCompletionListener(this.J);
                this.p.setOnErrorListener(this.L);
                this.p.setOnBufferingUpdateListener(this.M);
                this.p.setOnSeekCompleteListener(this.N);
                this.p.setOnVideoSizeChangedListener(this.K);
                this.q = 0;
                this.p.setAudioStreamType(3);
                this.p.setScreenOnWhilePlaying(true);
            } catch (IllegalArgumentException unused) {
                setCurrentState(-1);
                this.f45683f = false;
                this.L.onError(this.p, 1, 0);
            }
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(b.a.p0.y.g.swanapp_video_loading, (ViewGroup) null);
            this.x = inflate;
            addView(inflate);
        }
    }

    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            if (isInPlaybackState() && this.p.isPlaying()) {
                this.p.pause();
                setCurrentState(4);
            }
            this.f45683f = false;
            b.a.p0.y.j.a aVar = this.D;
            if (aVar != null) {
                aVar.onPause();
            }
        }
    }

    public final void q(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, context) == null) {
            this.m = new b.a.p0.y.n.b(context);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            this.m.f(new a(this));
            addView(this.m.d(), layoutParams);
            this.m.b(this);
        }
    }

    public final void r(MediaPlayer mediaPlayer, a.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048597, this, mediaPlayer, bVar) == null) || mediaPlayer == null) {
            return;
        }
        if (bVar == null) {
            mediaPlayer.setDisplay(null);
        } else {
            bVar.a(mediaPlayer);
        }
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            v();
            this.f45683f = false;
            b.a.p0.y.a aVar = this.z;
            if (aVar != null) {
                aVar.release();
            }
            MediaController mediaController = this.f45686i;
            if (mediaController != null) {
                mediaController.setToggleScreenListener(null);
                this.f45686i.bindMediaControl(null);
                this.f45686i = null;
            }
            if (this.l != null) {
                this.l = null;
            }
            b.a.p0.y.n.d dVar = this.k;
            if (dVar != null) {
                dVar.release();
                this.k = null;
            }
            b.a.p0.y.n.c cVar = this.j;
            if (cVar != null) {
                cVar.f();
                this.j = null;
            }
            if (this.D != null) {
                this.D = null;
            }
        }
    }

    public final void s() {
        b.a.p0.y.n.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048599, this) == null) || (dVar = this.k) == null) {
            return;
        }
        dVar.e();
        this.k.d();
    }

    public void seekTo(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048600, this, i2) == null) && isInPlaybackState()) {
            if (i2 >= this.p.getDuration()) {
                i2 = this.p.getDuration() - 1000;
            }
            this.p.seekTo(i2);
            if (i2 > 0) {
                setCacheViewVisibility(true);
            }
        }
    }

    public void setAudioFocusListener(AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, onAudioFocusChangeListener) == null) {
            this.G = onAudioFocusChangeListener;
        }
    }

    public void setDirection(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i2) == null) {
        }
    }

    public void setHeaders(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, map) == null) {
            this.f45685h = map;
        }
    }

    public void setInitPlayPosition(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i2) == null) {
            this.s = i2;
            MediaPlayer mediaPlayer = this.p;
            if (mediaPlayer != null) {
                mediaPlayer.seekTo(i2);
                this.s = -1;
            }
        }
    }

    public void setIsLandscape(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048605, this, z) == null) {
            this.E = z;
            MediaController mediaController = this.f45686i;
            if (mediaController != null) {
                mediaController.onVideoOrientationChange(z);
            }
            b.a.p0.y.l.b.c.c cVar = this.o;
            if (cVar != null) {
                cVar.g(z);
            }
            MediaTipStateLayer mediaTipStateLayer = this.n;
            if (mediaTipStateLayer != null) {
                mediaTipStateLayer.g(z);
            }
            s();
        }
    }

    public void setLooping(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048606, this, z) == null) {
            this.t = z;
            MediaPlayer mediaPlayer = this.p;
            if (mediaPlayer != null) {
                mediaPlayer.setLooping(z);
            }
        }
    }

    public void setMediaControllerEnabled(boolean z) {
        MediaController mediaController;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048607, this, z) == null) {
            this.w = z;
            if (z || (mediaController = this.f45686i) == null) {
                return;
            }
            mediaController.hide();
        }
    }

    public void setMediaGesture(@NonNull b.a.p0.y.l.b.c.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, cVar) == null) {
            this.o = cVar;
            this.m.c(cVar);
        }
    }

    public void setMuted(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048609, this, z) == null) || this.p == null) {
            return;
        }
        setVolume(z ? 0.0f : 1.0f);
        this.u = z;
        MediaController mediaController = this.f45686i;
        if (mediaController != null) {
            mediaController.setMute(z);
        }
    }

    public int setPlayBackRate(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048610, this, str)) == null) {
            try {
                if (setPlayRate(Float.parseFloat(str))) {
                    this.k.g(str);
                    return 0;
                }
                return 1001;
            } catch (NumberFormatException unused) {
                return 202;
            }
        }
        return invokeL.intValue;
    }

    public boolean setPlayRate(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048611, this, f2)) == null) {
            if (Build.VERSION.SDK_INT >= 23) {
                try {
                    PlaybackParams playbackParams = this.p.getPlaybackParams();
                    playbackParams.setSpeed(f2);
                    boolean isPlaying = this.p.isPlaying();
                    this.p.setPlaybackParams(playbackParams);
                    if (isPlaying) {
                        return true;
                    }
                    this.p.pause();
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }
        return invokeF.booleanValue;
    }

    public void setRenderView(b.a.p0.y.a aVar) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, aVar) == null) {
            if (this.z != null) {
                MediaPlayer mediaPlayer = this.p;
                if (mediaPlayer != null) {
                    mediaPlayer.setDisplay(null);
                }
                View view = this.z.getView();
                this.z.removeRenderCallback(this.O);
                this.z.release();
                this.z = null;
                this.C.removeView(view);
            }
            if (aVar == null) {
                return;
            }
            this.z = aVar;
            aVar.setAspectRatio(this.y);
            int i3 = this.A;
            if (i3 > 0 && (i2 = this.B) > 0) {
                aVar.setVideoSize(i3, i2);
            }
            View view2 = this.z.getView();
            view2.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
            this.C.addView(view2);
            this.z.addRenderCallback(this.O);
        }
    }

    public void setSilentTips(String str) {
        b.a.p0.y.n.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048613, this, str) == null) || (cVar = this.j) == null) {
            return;
        }
        cVar.g(str);
    }

    public void setSurface(Surface surface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, surface) == null) {
            this.p.setSurface(surface);
        }
    }

    public void setTitle(String str) {
        MediaController mediaController;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048615, this, str) == null) && (mediaController = this.f45686i) != null && this.w) {
            mediaController.setTitle(str);
        }
    }

    public void setVideoPath(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, str) == null) {
            Uri parse = Uri.parse(str);
            this.f45684g = parse;
            if (parse == null) {
                return;
            }
            MediaPlayer mediaPlayer = this.p;
            if (mediaPlayer != null) {
                try {
                    mediaPlayer.setDataSource(this.r, parse, this.f45685h);
                    this.p.prepareAsync();
                    setCacheViewVisibility(true);
                    setCurrentState(1);
                } catch (IOException unused) {
                    setCurrentState(-1);
                    this.f45683f = false;
                    this.L.onError(this.p, 1, 0);
                }
            }
            requestLayout();
            invalidate();
        }
    }

    public void setVideoPlayerCallback(b.a.p0.y.j.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, aVar) == null) {
            this.D = aVar;
            MediaController mediaController = this.f45686i;
            if (mediaController != null) {
                mediaController.setToggleScreenListener(aVar);
            }
        }
    }

    public void setVideoScalingMode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048618, this, i2) == null) {
            if (i2 == 1 || i2 == 2 || i2 == 3) {
                if (i2 == 1) {
                    this.y = 0;
                } else if (i2 == 2) {
                    this.y = 1;
                } else {
                    this.y = 3;
                }
                b.a.p0.y.a aVar = this.z;
                if (aVar != null) {
                    aVar.setAspectRatio(this.y);
                }
            }
        }
    }

    public void setVolume(float f2) {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048619, this, f2) == null) || (mediaPlayer = this.p) == null) {
            return;
        }
        mediaPlayer.setVolume(f2, f2);
    }

    public void showCenterPlayButton(boolean z) {
        MediaController mediaController;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048620, this, z) == null) && (mediaController = this.f45686i) != null && this.w) {
            mediaController.showCenterPlayButton(z);
        }
    }

    public void showDanmuButton(boolean z) {
        MediaController mediaController;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048621, this, z) == null) && (mediaController = this.f45686i) != null && this.w) {
            mediaController.showDanmuButton(z);
        }
    }

    public void showFullscreenBtn(boolean z) {
        MediaController mediaController;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048622, this, z) == null) && (mediaController = this.f45686i) != null && this.w) {
            mediaController.showToggleScreenButton(z);
        }
    }

    public void showMuteButton(boolean z) {
        MediaController mediaController;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048623, this, z) == null) && (mediaController = this.f45686i) != null && this.w) {
            mediaController.showMuteButton(z);
        }
    }

    public void showPlayButton(boolean z) {
        MediaController mediaController;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048624, this, z) == null) && (mediaController = this.f45686i) != null && this.w) {
            mediaController.showPlayButton(z);
        }
    }

    public void showRateButton(boolean z) {
        MediaController mediaController;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048625, this, z) == null) && (mediaController = this.f45686i) != null && this.w) {
            mediaController.showRateButton(z);
        }
    }

    public void showRateInfo(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, str) == null) {
            MediaController mediaController = this.f45686i;
            if (mediaController != null && this.w) {
                mediaController.hide();
            }
            b.a.p0.y.n.e eVar = this.l;
            if (eVar != null) {
                eVar.e(str);
            }
        }
    }

    public void showRateLayer() {
        b.a.p0.y.n.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048627, this) == null) || (dVar = this.k) == null) {
            return;
        }
        dVar.l();
    }

    public void showSeekBar(boolean z) {
        MediaController mediaController;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048628, this, z) == null) && (mediaController = this.f45686i) != null && this.w) {
            mediaController.showSeekBar(z);
        }
    }

    public void showSettingButton(boolean z) {
        MediaController mediaController;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048629, this, z) == null) && (mediaController = this.f45686i) != null && this.w) {
            mediaController.showSettingButton(z);
        }
    }

    public void showSettingLayer() {
        b.a.p0.y.n.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048630, this) == null) || (dVar = this.k) == null) {
            return;
        }
        dVar.m();
    }

    public void showSilentMuteButton(boolean z) {
        b.a.p0.y.n.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048631, this, z) == null) || (cVar = this.j) == null) {
            return;
        }
        if (z) {
            cVar.h();
        } else {
            cVar.b();
        }
    }

    public void showSilentPlay(boolean z) {
        MediaController mediaController;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048632, this, z) == null) {
            this.v = z;
            b.a.p0.y.n.c cVar = this.j;
            if (cVar != null) {
                cVar.i(z);
            }
            if (!z || (mediaController = this.f45686i) == null) {
                return;
            }
            mediaController.hide();
        }
    }

    public void start() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048633, this) == null) || this.p == null) {
            return;
        }
        int i2 = this.f45682e;
        if (i2 != -1 && i2 != 5) {
            if (isInPlaybackState()) {
                b.a.p0.y.j.a aVar = this.D;
                if (aVar != null) {
                    if (this.f45682e == 4) {
                        aVar.onResume();
                    } else {
                        aVar.onStart();
                    }
                }
                this.p.start();
                setCurrentState(3);
            }
        } else {
            if (this.f45682e == 5) {
                this.p.stop();
            }
            x();
            setCacheViewVisibility(true);
            setCurrentState(1);
        }
        this.f45683f = true;
    }

    public void startWithFocus() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048634, this) == null) {
            if (!this.H && !w()) {
                updateTipState(MediaTipStateLayer.TipState.ERROR);
                this.H = false;
                return;
            }
            this.H = true;
            start();
        }
    }

    public void stopPlayback() {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048635, this) == null) || (mediaPlayer = this.p) == null) {
            return;
        }
        mediaPlayer.stop();
        v();
        this.f45683f = false;
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048636, this) == null) {
            setRenderView(new TextureRenderView(getContext()));
        }
    }

    public final void u(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048637, this, context) == null) {
            this.r = context.getApplicationContext();
            this.C = new FrameLayout(context);
            ViewGroup.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            this.C.setBackgroundColor(-16777216);
            addView(this.C, layoutParams);
            q(context);
            this.l = new b.a.p0.y.n.e(getContext());
            addView(this.l.a(), new FrameLayout.LayoutParams(-1, -1));
            this.f45686i = new MediaController(context);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
            layoutParams2.gravity = 80;
            this.f45686i.setVisibility(8);
            addView(this.f45686i, layoutParams2);
            this.f45686i.bindMediaControl(this);
            this.j = new b.a.p0.y.n.c(getContext());
            addView(this.j.a(), new FrameLayout.LayoutParams(-1, -1));
            b.a.p0.y.n.d dVar = new b.a.p0.y.n.d(getContext());
            this.k = dVar;
            dVar.b(this);
            addView(this.k.c(), new FrameLayout.LayoutParams(-1, -1));
            this.n = new MediaTipStateLayer(getContext());
            addView(this.n.b(), new FrameLayout.LayoutParams(-1, -1));
            this.n.a(this);
            t();
            p();
            setFocusable(true);
            setFocusableInTouchMode(true);
            requestFocus();
            setCurrentState(0);
            this.F = (AudioManager) this.r.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
        }
    }

    public void updateLockState(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048638, this, z) == null) {
            this.o.h(z);
        }
    }

    public void updateTipState(MediaTipStateLayer.TipState tipState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048639, this, tipState) == null) {
            this.n.h(tipState);
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048640, this) == null) {
            MediaPlayer mediaPlayer = this.p;
            if (mediaPlayer != null) {
                mediaPlayer.reset();
                this.p.setDisplay(null);
                this.p.release();
                this.p = null;
                setCurrentState(0);
            }
            if (this.D != null) {
                this.D = null;
            }
            AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener = this.G;
            if (onAudioFocusChangeListener != null) {
                this.H = false;
                this.F.abandonAudioFocus(onAudioFocusChangeListener);
                this.G = null;
            }
        }
    }

    public final boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) ? this.F.requestAudioFocus(this.G, 3, 1) == 1 : invokeV.booleanValue;
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048642, this) == null) {
            try {
                this.p.reset();
                this.p.setDataSource(this.r, this.f45684g, this.f45685h);
                this.p.prepareAsync();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048643, this) == null) && this.w) {
            if (this.f45686i.getVisibility() != 0) {
                this.f45686i.hideOuterAfterSeconds();
            } else {
                this.f45686i.hide();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwanVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f45682e = 0;
        this.s = -1;
        this.w = true;
        this.y = 0;
        this.I = new b(this);
        this.J = new c(this);
        this.K = new d(this);
        this.L = new e(this);
        this.M = new f(this);
        this.N = new g(this);
        this.O = new h(this);
        u(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwanVideoView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f45682e = 0;
        this.s = -1;
        this.w = true;
        this.y = 0;
        this.I = new b(this);
        this.J = new c(this);
        this.K = new d(this);
        this.L = new e(this);
        this.M = new f(this);
        this.N = new g(this);
        this.O = new h(this);
        u(context);
    }
}

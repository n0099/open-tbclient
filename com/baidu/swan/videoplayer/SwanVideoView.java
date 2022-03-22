package com.baidu.swan.videoplayer;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.PlaybackParams;
import android.net.Uri;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.y.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.videoplayer.media.video.view.MediaGestureLayout;
import com.baidu.swan.videoplayer.widget.MediaController;
import com.baidu.swan.videoplayer.widget.MediaTipStateLayer;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.util.Map;
/* loaded from: classes4.dex */
public class SwanVideoView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public AudioManager B;
    public AudioManager.OnAudioFocusChangeListener C;
    public boolean D;
    public MediaPlayer.OnPreparedListener E;
    public MediaPlayer.OnCompletionListener F;
    public MediaPlayer.OnVideoSizeChangedListener G;
    public MediaPlayer.OnErrorListener H;
    public MediaPlayer.OnBufferingUpdateListener I;
    public MediaPlayer.OnSeekCompleteListener J;
    public a.InterfaceC0769a K;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f29706b;

    /* renamed from: c  reason: collision with root package name */
    public Uri f29707c;

    /* renamed from: d  reason: collision with root package name */
    public Map<String, String> f29708d;

    /* renamed from: e  reason: collision with root package name */
    public MediaController f29709e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.n0.y.h.c f29710f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.n0.y.h.d f29711g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.n0.y.h.e f29712h;
    public c.a.n0.y.h.b i;
    public MediaTipStateLayer j;
    public c.a.n0.y.f.b.c.c k;
    public MediaPlayer l;
    public int m;
    public Context n;
    public int o;
    public boolean p;
    public boolean q;
    public boolean r;
    public boolean s;
    public View t;
    public int u;
    public c.a.n0.y.a v;
    public int w;
    public int x;
    public FrameLayout y;
    public c.a.n0.y.d.a z;

    /* loaded from: classes4.dex */
    public class a extends MediaGestureLayout.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanVideoView a;

        public a(SwanVideoView swanVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanVideoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = swanVideoView;
        }

        @Override // com.baidu.swan.videoplayer.media.video.view.MediaGestureLayout.c, com.baidu.swan.videoplayer.media.video.view.MediaGestureLayout.b
        public void a(MotionEvent motionEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, motionEvent) == null) {
                this.a.a0();
            }
        }

        @Override // com.baidu.swan.videoplayer.media.video.view.MediaGestureLayout.c, com.baidu.swan.videoplayer.media.video.view.MediaGestureLayout.b
        public void c(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                this.a.H(i);
            }
        }

        @Override // com.baidu.swan.videoplayer.media.video.view.MediaGestureLayout.c, com.baidu.swan.videoplayer.media.video.view.MediaGestureLayout.b
        public void onDoubleTap(MotionEvent motionEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, motionEvent) == null) {
                if (this.a.z()) {
                    this.a.C();
                } else {
                    this.a.X();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements MediaPlayer.OnPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanVideoView a;

        public b(SwanVideoView swanVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanVideoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = swanVideoView;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, mediaPlayer) == null) {
                this.a.setCurrentState(2);
                this.a.setCacheViewVisibility(false);
                if (this.a.z != null) {
                    this.a.z.onPrepared();
                }
                this.a.w = mediaPlayer.getVideoWidth();
                this.a.x = mediaPlayer.getVideoHeight();
                if (this.a.w != 0 && this.a.x != 0 && this.a.v != null) {
                    this.a.v.setVideoSize(this.a.w, this.a.x);
                }
                if (this.a.f29706b) {
                    this.a.X();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements MediaPlayer.OnCompletionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanVideoView a;

        public c(SwanVideoView swanVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanVideoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = swanVideoView;
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, mediaPlayer) == null) {
                Log.d("SwanVideoView", "onCompletion");
                this.a.setCacheViewVisibility(false);
                this.a.setCurrentState(5);
                this.a.f29706b = false;
                if (this.a.z != null) {
                    this.a.z.a();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements MediaPlayer.OnVideoSizeChangedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanVideoView a;

        public d(SwanVideoView swanVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanVideoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = swanVideoView;
        }

        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, mediaPlayer, i, i2) == null) {
                this.a.w = mediaPlayer.getVideoWidth();
                this.a.x = mediaPlayer.getVideoHeight();
                if (this.a.w == 0 || this.a.x == 0) {
                    return;
                }
                if (this.a.v != null) {
                    this.a.v.setVideoSize(this.a.w, this.a.x);
                }
                if (this.a.z != null) {
                    this.a.z.onVideoSizeChanged(i, i2);
                }
                this.a.requestLayout();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements MediaPlayer.OnErrorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanVideoView a;

        public e(SwanVideoView swanVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanVideoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = swanVideoView;
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, mediaPlayer, i, i2)) == null) {
                Log.d("SwanVideoView", "onError: " + i + "," + i2);
                this.a.setCurrentState(-1);
                this.a.f29706b = false;
                this.a.setCacheViewVisibility(false);
                if (this.a.z != null) {
                    this.a.z.onError(i, i2, null);
                }
                return this.a.z != null;
            }
            return invokeLII.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class f implements MediaPlayer.OnBufferingUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanVideoView a;

        public f(SwanVideoView swanVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanVideoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = swanVideoView;
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, mediaPlayer, i) == null) {
                Log.d("SwanVideoView", "onBufferingUpdate: percent=" + i);
                this.a.m = i;
                if (this.a.z != null) {
                    this.a.z.onBufferingUpdate(i);
                }
                if (this.a.f29709e != null) {
                    this.a.f29709e.o((i * this.a.getDuration()) / 100);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements MediaPlayer.OnSeekCompleteListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanVideoView a;

        public g(SwanVideoView swanVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanVideoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = swanVideoView;
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, mediaPlayer) == null) {
                Log.d("SwanVideoView", "onSeekComplete");
                this.a.setCacheViewVisibility(false);
                if (this.a.z != null) {
                    this.a.z.onSeekEnd();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements a.InterfaceC0769a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanVideoView a;

        public h(SwanVideoView swanVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanVideoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = swanVideoView;
        }

        @Override // c.a.n0.y.a.InterfaceC0769a
        public void a(a.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            }
        }

        @Override // c.a.n0.y.a.InterfaceC0769a
        public void b(a.b bVar, int i, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, i, i2) == null) && bVar.b() == this.a.v && this.a.l != null) {
                SwanVideoView swanVideoView = this.a;
                swanVideoView.r(swanVideoView.l, bVar);
            }
        }

        @Override // c.a.n0.y.a.InterfaceC0769a
        public void c(a.b bVar, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, bVar, i, i2, i3) == null) {
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 0;
        this.o = -1;
        this.s = true;
        this.u = 0;
        this.E = new b(this);
        this.F = new c(this);
        this.G = new d(this);
        this.H = new e(this);
        this.I = new f(this);
        this.J = new g(this);
        this.K = new h(this);
        v(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCacheViewVisibility(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65554, this, z) == null) {
            if (z) {
                this.t.setVisibility(0);
            } else {
                this.t.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCurrentState(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65555, this, i) == null) || this.a == i) {
            return;
        }
        this.a = i;
        MediaController mediaController = this.f29709e;
        if (mediaController != null) {
            mediaController.E();
        }
    }

    public boolean A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.r : invokeV.booleanValue;
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            try {
                MediaPlayer s = s();
                this.l = s;
                s.setOnPreparedListener(this.E);
                this.l.setOnCompletionListener(this.F);
                this.l.setOnErrorListener(this.H);
                this.l.setOnBufferingUpdateListener(this.I);
                this.l.setOnSeekCompleteListener(this.J);
                this.l.setOnVideoSizeChangedListener(this.G);
                this.m = 0;
                this.l.setAudioStreamType(3);
                this.l.setScreenOnWhilePlaying(true);
            } catch (IllegalArgumentException unused) {
                setCurrentState(-1);
                this.f29706b = false;
                this.H.onError(this.l, 1, 0);
            }
        }
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (w() && this.l.isPlaying()) {
                this.l.pause();
                setCurrentState(4);
            }
            this.f29706b = false;
            c.a.n0.y.d.a aVar = this.z;
            if (aVar != null) {
                aVar.onPause();
            }
        }
    }

    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            E();
            this.f29706b = false;
            c.a.n0.y.a aVar = this.v;
            if (aVar != null) {
                aVar.release();
            }
            MediaController mediaController = this.f29709e;
            if (mediaController != null) {
                mediaController.setToggleScreenListener(null);
                this.f29709e.i(null);
                this.f29709e = null;
            }
            if (this.f29712h != null) {
                this.f29712h = null;
            }
            c.a.n0.y.h.d dVar = this.f29711g;
            if (dVar != null) {
                dVar.release();
                this.f29711g = null;
            }
            c.a.n0.y.h.c cVar = this.f29710f;
            if (cVar != null) {
                cVar.f();
                this.f29710f = null;
            }
            if (this.z != null) {
                this.z = null;
            }
        }
    }

    public final void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            MediaPlayer mediaPlayer = this.l;
            if (mediaPlayer != null) {
                mediaPlayer.reset();
                this.l.setDisplay(null);
                this.l.release();
                this.l = null;
                setCurrentState(0);
            }
            if (this.z != null) {
                this.z = null;
            }
            AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener = this.C;
            if (onAudioFocusChangeListener != null) {
                this.D = false;
                this.B.abandonAudioFocus(onAudioFocusChangeListener);
                this.C = null;
            }
        }
    }

    public final boolean F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.B.requestAudioFocus(this.C, 3, 1) == 1 : invokeV.booleanValue;
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            try {
                this.l.reset();
                this.l.setDataSource(this.n, this.f29707c, this.f29708d);
                this.l.prepareAsync();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void H(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048583, this, i) == null) && w()) {
            if (i >= this.l.getDuration()) {
                i = this.l.getDuration() - 1000;
            }
            this.l.seekTo(i);
            if (i > 0) {
                setCacheViewVisibility(true);
            }
        }
    }

    public int I(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            try {
                if (J(Float.parseFloat(str))) {
                    this.f29711g.g(str);
                    return 0;
                }
                return 1001;
            } catch (NumberFormatException unused) {
                return 202;
            }
        }
        return invokeL.intValue;
    }

    public boolean J(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048585, this, f2)) == null) {
            if (Build.VERSION.SDK_INT >= 23) {
                try {
                    PlaybackParams playbackParams = this.l.getPlaybackParams();
                    playbackParams.setSpeed(f2);
                    boolean isPlaying = this.l.isPlaying();
                    this.l.setPlaybackParams(playbackParams);
                    if (isPlaying) {
                        return true;
                    }
                    this.l.pause();
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }
        return invokeF.booleanValue;
    }

    public void K(boolean z) {
        MediaController mediaController;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048586, this, z) == null) && (mediaController = this.f29709e) != null && this.s) {
            mediaController.r(z);
        }
    }

    public void L(boolean z) {
        MediaController mediaController;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048587, this, z) == null) && (mediaController = this.f29709e) != null && this.s) {
            mediaController.s(z);
        }
    }

    public void M(boolean z) {
        MediaController mediaController;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048588, this, z) == null) && (mediaController = this.f29709e) != null && this.s) {
            mediaController.y(z);
        }
    }

    public void N(boolean z) {
        MediaController mediaController;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048589, this, z) == null) && (mediaController = this.f29709e) != null && this.s) {
            mediaController.t(z);
        }
    }

    public void O(boolean z) {
        MediaController mediaController;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048590, this, z) == null) && (mediaController = this.f29709e) != null && this.s) {
            mediaController.u(z);
        }
    }

    public void P(boolean z) {
        MediaController mediaController;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048591, this, z) == null) && (mediaController = this.f29709e) != null && this.s) {
            mediaController.v(z);
        }
    }

    public void Q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            MediaController mediaController = this.f29709e;
            if (mediaController != null && this.s) {
                mediaController.k();
            }
            c.a.n0.y.h.e eVar = this.f29712h;
            if (eVar != null) {
                eVar.e(str);
            }
        }
    }

    public void R() {
        c.a.n0.y.h.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (dVar = this.f29711g) == null) {
            return;
        }
        dVar.m();
    }

    public void S(boolean z) {
        MediaController mediaController;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048594, this, z) == null) && (mediaController = this.f29709e) != null && this.s) {
            mediaController.w(z);
        }
    }

    public void T(boolean z) {
        MediaController mediaController;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048595, this, z) == null) && (mediaController = this.f29709e) != null && this.s) {
            mediaController.x(z);
        }
    }

    public void U() {
        c.a.n0.y.h.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || (dVar = this.f29711g) == null) {
            return;
        }
        dVar.n();
    }

    public void V(boolean z) {
        c.a.n0.y.h.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048597, this, z) == null) || (cVar = this.f29710f) == null) {
            return;
        }
        if (z) {
            cVar.h();
        } else {
            cVar.b();
        }
    }

    public void W(boolean z) {
        MediaController mediaController;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            this.r = z;
            c.a.n0.y.h.c cVar = this.f29710f;
            if (cVar != null) {
                cVar.i(z);
            }
            if (!z || (mediaController = this.f29709e) == null) {
                return;
            }
            mediaController.k();
        }
    }

    public void X() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048599, this) == null) || this.l == null) {
            return;
        }
        int i = this.a;
        if (i != -1 && i != 5) {
            if (w()) {
                c.a.n0.y.d.a aVar = this.z;
                if (aVar != null) {
                    if (this.a == 4) {
                        aVar.onResume();
                    } else {
                        aVar.onStart();
                    }
                }
                this.l.start();
                setCurrentState(3);
            }
        } else {
            if (this.a == 5) {
                this.l.stop();
            }
            G();
            setCacheViewVisibility(true);
            setCurrentState(1);
        }
        this.f29706b = true;
    }

    public void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            if (!this.D && !F()) {
                c0(MediaTipStateLayer.TipState.ERROR);
                this.D = false;
                return;
            }
            this.D = true;
            X();
        }
    }

    public void Z() {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048601, this) == null) || (mediaPlayer = this.l) == null) {
            return;
        }
        mediaPlayer.stop();
        E();
        this.f29706b = false;
    }

    public final void a0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048602, this) == null) && this.s) {
            if (this.f29709e.getVisibility() != 0) {
                this.f29709e.l();
            } else {
                this.f29709e.k();
            }
        }
    }

    public void b0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
            this.k.h(z);
        }
    }

    public void c0(MediaTipStateLayer.TipState tipState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, tipState) == null) {
            this.j.h(tipState);
        }
    }

    public Bitmap getBitmap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            c.a.n0.y.a aVar = this.v;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            if (this.l != null) {
                return this.m;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public int getCurrentPlayerState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.a : invokeV.intValue;
    }

    public String getCurrentPlayingUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            Uri uri = this.f29707c;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            if (w()) {
                return this.l.getCurrentPosition();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public int getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            if (w()) {
                return this.l.getDuration();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public MediaTipStateLayer.TipState getTipState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.j.c() : (MediaTipStateLayer.TipState) invokeV.objValue;
    }

    public int getVideoHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.l.getVideoHeight() : invokeV.intValue;
    }

    public c.a.n0.y.d.a getVideoPlayerCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? this.z : (c.a.n0.y.d.a) invokeV.objValue;
    }

    public int getVideoWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.l.getVideoWidth() : invokeV.intValue;
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d07e4, (ViewGroup) null);
            this.t = inflate;
            addView(inflate);
        }
    }

    public final void q(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, context) == null) {
            this.i = new c.a.n0.y.h.b(context);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            this.i.h(new a(this));
            addView(this.i.f(), layoutParams);
            this.i.d(this);
        }
    }

    public final void r(MediaPlayer mediaPlayer, a.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048617, this, mediaPlayer, bVar) == null) || mediaPlayer == null) {
            return;
        }
        if (bVar == null) {
            mediaPlayer.setDisplay(null);
        } else {
            bVar.a(mediaPlayer);
        }
    }

    public MediaPlayer s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            MediaPlayer mediaPlayer = new MediaPlayer();
            mediaPlayer.setLooping(this.p);
            mediaPlayer.setWakeMode(getContext(), 10);
            return mediaPlayer;
        }
        return (MediaPlayer) invokeV.objValue;
    }

    public void setAudioFocusListener(AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, onAudioFocusChangeListener) == null) {
            this.C = onAudioFocusChangeListener;
        }
    }

    public void setDirection(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048620, this, i) == null) {
        }
    }

    public void setHeaders(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, map) == null) {
            this.f29708d = map;
        }
    }

    public void setInitPlayPosition(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048622, this, i) == null) {
            this.o = i;
            MediaPlayer mediaPlayer = this.l;
            if (mediaPlayer != null) {
                mediaPlayer.seekTo(i);
                this.o = -1;
            }
        }
    }

    public void setIsLandscape(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048623, this, z) == null) {
            this.A = z;
            MediaController mediaController = this.f29709e;
            if (mediaController != null) {
                mediaController.p(z);
            }
            c.a.n0.y.f.b.c.c cVar = this.k;
            if (cVar != null) {
                cVar.g(z);
            }
            MediaTipStateLayer mediaTipStateLayer = this.j;
            if (mediaTipStateLayer != null) {
                mediaTipStateLayer.g(z);
            }
            t();
        }
    }

    public void setLooping(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048624, this, z) == null) {
            this.p = z;
            MediaPlayer mediaPlayer = this.l;
            if (mediaPlayer != null) {
                mediaPlayer.setLooping(z);
            }
        }
    }

    public void setMediaControllerEnabled(boolean z) {
        MediaController mediaController;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048625, this, z) == null) {
            this.s = z;
            if (z || (mediaController = this.f29709e) == null) {
                return;
            }
            mediaController.k();
        }
    }

    public void setMediaGesture(@NonNull c.a.n0.y.f.b.c.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, cVar) == null) {
            this.k = cVar;
            this.i.e(cVar);
        }
    }

    public void setMuted(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048627, this, z) == null) || this.l == null) {
            return;
        }
        setVolume(z ? 0.0f : 1.0f);
        this.q = z;
        MediaController mediaController = this.f29709e;
        if (mediaController != null) {
            mediaController.setMute(z);
        }
    }

    public void setRenderView(c.a.n0.y.a aVar) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, aVar) == null) {
            if (this.v != null) {
                MediaPlayer mediaPlayer = this.l;
                if (mediaPlayer != null) {
                    mediaPlayer.setDisplay(null);
                }
                View view = this.v.getView();
                this.v.a(this.K);
                this.v.release();
                this.v = null;
                this.y.removeView(view);
            }
            if (aVar == null) {
                return;
            }
            this.v = aVar;
            aVar.setAspectRatio(this.u);
            int i2 = this.w;
            if (i2 > 0 && (i = this.x) > 0) {
                aVar.setVideoSize(i2, i);
            }
            View view2 = this.v.getView();
            view2.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
            this.y.addView(view2);
            this.v.b(this.K);
        }
    }

    public void setSilentTips(String str) {
        c.a.n0.y.h.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048629, this, str) == null) || (cVar = this.f29710f) == null) {
            return;
        }
        cVar.g(str);
    }

    public void setSurface(Surface surface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, surface) == null) {
            this.l.setSurface(surface);
        }
    }

    public void setTitle(String str) {
        MediaController mediaController;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048631, this, str) == null) && (mediaController = this.f29709e) != null && this.s) {
            mediaController.setTitle(str);
        }
    }

    public void setVideoPath(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, str) == null) {
            Uri parse = Uri.parse(str);
            this.f29707c = parse;
            if (parse == null) {
                return;
            }
            MediaPlayer mediaPlayer = this.l;
            if (mediaPlayer != null) {
                try {
                    mediaPlayer.setDataSource(this.n, parse, this.f29708d);
                    this.l.prepareAsync();
                    setCacheViewVisibility(true);
                    setCurrentState(1);
                } catch (IOException unused) {
                    setCurrentState(-1);
                    this.f29706b = false;
                    this.H.onError(this.l, 1, 0);
                }
            }
            requestLayout();
            invalidate();
        }
    }

    public void setVideoPlayerCallback(c.a.n0.y.d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048633, this, aVar) == null) {
            this.z = aVar;
            MediaController mediaController = this.f29709e;
            if (mediaController != null) {
                mediaController.setToggleScreenListener(aVar);
            }
        }
    }

    public void setVideoScalingMode(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048634, this, i) == null) {
            if (i != 1 && i != 2 && i != 3) {
                Log.e("SwanVideoView", "setVideoScalingMode: param should be VID");
                return;
            }
            if (i == 1) {
                this.u = 0;
            } else if (i == 2) {
                this.u = 1;
            } else {
                this.u = 3;
            }
            c.a.n0.y.a aVar = this.v;
            if (aVar != null) {
                aVar.setAspectRatio(this.u);
            }
        }
    }

    public void setVolume(float f2) {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048635, this, f2) == null) || (mediaPlayer = this.l) == null) {
            return;
        }
        mediaPlayer.setVolume(f2, f2);
    }

    public final void t() {
        c.a.n0.y.h.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048636, this) == null) || (dVar = this.f29711g) == null) {
            return;
        }
        dVar.e();
        this.f29711g.d();
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048637, this) == null) {
            setRenderView(new TextureRenderView(getContext()));
        }
    }

    public final void v(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048638, this, context) == null) {
            this.n = context.getApplicationContext();
            this.y = new FrameLayout(context);
            ViewGroup.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            this.y.setBackgroundColor(-16777216);
            addView(this.y, layoutParams);
            q(context);
            this.f29712h = new c.a.n0.y.h.e(getContext());
            addView(this.f29712h.a(), new FrameLayout.LayoutParams(-1, -1));
            this.f29709e = new MediaController(context);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
            layoutParams2.gravity = 80;
            this.f29709e.setVisibility(8);
            addView(this.f29709e, layoutParams2);
            this.f29709e.i(this);
            this.f29710f = new c.a.n0.y.h.c(getContext());
            addView(this.f29710f.a(), new FrameLayout.LayoutParams(-1, -1));
            c.a.n0.y.h.d dVar = new c.a.n0.y.h.d(getContext());
            this.f29711g = dVar;
            dVar.b(this);
            addView(this.f29711g.c(), new FrameLayout.LayoutParams(-1, -1));
            this.j = new MediaTipStateLayer(getContext());
            addView(this.j.b(), new FrameLayout.LayoutParams(-1, -1));
            this.j.a(this);
            u();
            p();
            setFocusable(true);
            setFocusableInTouchMode(true);
            requestFocus();
            setCurrentState(0);
            this.B = (AudioManager) this.n.getSystemService("audio");
        }
    }

    public boolean w() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) ? (this.l == null || (i = this.a) == -1 || i == 0 || i == 1) ? false : true : invokeV.booleanValue;
    }

    public boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) ? this.A : invokeV.booleanValue;
    }

    public boolean y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) ? this.q : invokeV.booleanValue;
    }

    public boolean z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) ? w() && this.l.isPlaying() : invokeV.booleanValue;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = 0;
        this.o = -1;
        this.s = true;
        this.u = 0;
        this.E = new b(this);
        this.F = new c(this);
        this.G = new d(this);
        this.H = new e(this);
        this.I = new f(this);
        this.J = new g(this);
        this.K = new h(this);
        v(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwanVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = 0;
        this.o = -1;
        this.s = true;
        this.u = 0;
        this.E = new b(this);
        this.F = new c(this);
        this.G = new d(this);
        this.H = new e(this);
        this.I = new f(this);
        this.J = new g(this);
        this.K = new h(this);
        v(context);
    }
}

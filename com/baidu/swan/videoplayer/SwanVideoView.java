package com.baidu.swan.videoplayer;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.v.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.videoplayer.widget.MediaController;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.util.Map;
/* loaded from: classes6.dex */
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
    public MediaPlayer.OnPreparedListener A;
    public MediaPlayer.OnCompletionListener B;
    public MediaPlayer.OnVideoSizeChangedListener C;
    public MediaPlayer.OnErrorListener D;
    public MediaPlayer.OnBufferingUpdateListener E;
    public MediaPlayer.OnSeekCompleteListener F;
    public a.InterfaceC0632a G;

    /* renamed from: e  reason: collision with root package name */
    public int f47257e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f47258f;

    /* renamed from: g  reason: collision with root package name */
    public Uri f47259g;

    /* renamed from: h  reason: collision with root package name */
    public Map<String, String> f47260h;

    /* renamed from: i  reason: collision with root package name */
    public MediaController f47261i;

    /* renamed from: j  reason: collision with root package name */
    public MediaPlayer f47262j;
    public int k;
    public Context l;
    public int m;
    public boolean n;
    public boolean o;
    public boolean p;
    public RelativeLayout q;
    public ProgressBar r;
    public TextView s;
    public int t;
    public c.a.p0.v.a u;
    public int v;
    public int w;
    public FrameLayout x;
    public c.a.p0.v.h.a y;
    public boolean z;

    /* loaded from: classes6.dex */
    public class a implements MediaPlayer.OnPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanVideoView f47263e;

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
            this.f47263e = swanVideoView;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, mediaPlayer) == null) {
                this.f47263e.setCurrentState(2);
                this.f47263e.setCacheViewVisibility(false);
                if (this.f47263e.y != null) {
                    this.f47263e.y.onPrepared();
                }
                this.f47263e.v = mediaPlayer.getVideoWidth();
                this.f47263e.w = mediaPlayer.getVideoHeight();
                if (this.f47263e.v != 0 && this.f47263e.w != 0 && this.f47263e.u != null) {
                    this.f47263e.u.setVideoSize(this.f47263e.v, this.f47263e.w);
                }
                if (this.f47263e.f47258f) {
                    this.f47263e.start();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements MediaPlayer.OnCompletionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanVideoView f47264e;

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
            this.f47264e = swanVideoView;
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, mediaPlayer) == null) {
                this.f47264e.setCacheViewVisibility(false);
                this.f47264e.setCurrentState(5);
                this.f47264e.f47258f = false;
                if (this.f47264e.y != null) {
                    this.f47264e.y.onEnd();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements MediaPlayer.OnVideoSizeChangedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanVideoView f47265e;

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
            this.f47265e = swanVideoView;
        }

        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, mediaPlayer, i2, i3) == null) {
                this.f47265e.v = mediaPlayer.getVideoWidth();
                this.f47265e.w = mediaPlayer.getVideoHeight();
                if (this.f47265e.v == 0 || this.f47265e.w == 0) {
                    return;
                }
                if (this.f47265e.u != null) {
                    this.f47265e.u.setVideoSize(this.f47265e.v, this.f47265e.w);
                }
                if (this.f47265e.y != null) {
                    this.f47265e.y.onVideoSizeChanged(i2, i3);
                }
                this.f47265e.requestLayout();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements MediaPlayer.OnErrorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanVideoView f47266e;

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
            this.f47266e = swanVideoView;
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, mediaPlayer, i2, i3)) == null) {
                String str = "onError: " + i2 + "," + i3;
                this.f47266e.setCurrentState(-1);
                this.f47266e.f47258f = false;
                this.f47266e.setCacheViewVisibility(false);
                if (this.f47266e.y != null) {
                    this.f47266e.y.onError(i2, i3, null);
                }
                return this.f47266e.y != null;
            }
            return invokeLII.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class e implements MediaPlayer.OnBufferingUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanVideoView f47267e;

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
            this.f47267e = swanVideoView;
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, mediaPlayer, i2) == null) {
                String str = "onBufferingUpdate: percent=" + i2;
                this.f47267e.k = i2;
                if (this.f47267e.y != null) {
                    this.f47267e.y.onBufferingUpdate(i2);
                }
                if (this.f47267e.f47261i != null) {
                    this.f47267e.f47261i.onTotalCacheUpdate((i2 * this.f47267e.getDuration()) / 100);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements MediaPlayer.OnSeekCompleteListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanVideoView f47268e;

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
            this.f47268e = swanVideoView;
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, mediaPlayer) == null) {
                this.f47268e.setCacheViewVisibility(false);
                if (this.f47268e.y != null) {
                    this.f47268e.y.onSeekEnd();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements a.InterfaceC0632a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SwanVideoView f47269a;

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
            this.f47269a = swanVideoView;
        }

        @Override // c.a.p0.v.a.InterfaceC0632a
        public void a(a.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            }
        }

        @Override // c.a.p0.v.a.InterfaceC0632a
        public void b(a.b bVar, int i2, int i3) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, i2, i3) == null) && bVar.b() == this.f47269a.u && this.f47269a.f47262j != null) {
                SwanVideoView swanVideoView = this.f47269a;
                swanVideoView.p(swanVideoView.f47262j, bVar);
            }
        }

        @Override // c.a.p0.v.a.InterfaceC0632a
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
        this.f47257e = 0;
        this.m = -1;
        this.p = true;
        this.t = 0;
        this.A = new a(this);
        this.B = new b(this);
        this.C = new c(this);
        this.D = new d(this);
        this.E = new e(this);
        this.F = new f(this);
        this.G = new g(this);
        r(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCacheViewVisibility(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65553, this, z) == null) {
            if (z) {
                this.q.setVisibility(0);
            } else {
                this.q.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCurrentState(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65554, this, i2) == null) || this.f47257e == i2) {
            return;
        }
        this.f47257e = i2;
        MediaController mediaController = this.f47261i;
        if (mediaController != null) {
            mediaController.updateState();
        }
    }

    public MediaPlayer createPlayer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            MediaPlayer mediaPlayer = new MediaPlayer();
            mediaPlayer.setLooping(this.n);
            mediaPlayer.setWakeMode(getContext(), 10);
            return mediaPlayer;
        }
        return (MediaPlayer) invokeV.objValue;
    }

    public Bitmap getBitmap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            c.a.p0.v.a aVar = this.u;
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
            if (this.f47262j != null) {
                return this.k;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public int getCurrentPlayerState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f47257e : invokeV.intValue;
    }

    public String getCurrentPlayingUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            Uri uri = this.f47259g;
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
            if (s()) {
                return this.f47262j.getCurrentPosition();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public int getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (s()) {
                return this.f47262j.getDuration();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public int getVideoHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f47262j.getVideoHeight() : invokeV.intValue;
    }

    public c.a.p0.v.h.a getVideoPlayerCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.y : (c.a.p0.v.h.a) invokeV.objValue;
    }

    public int getVideoWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f47262j.getVideoWidth() : invokeV.intValue;
    }

    public boolean isEnd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f47257e == 5 : invokeV.booleanValue;
    }

    public boolean isIsLandscape() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.z : invokeV.booleanValue;
    }

    public boolean isMute() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.o : invokeV.booleanValue;
    }

    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? s() && this.f47262j.isPlaying() : invokeV.booleanValue;
    }

    public void mute(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048590, this, z) == null) || this.f47262j == null) {
            return;
        }
        float f2 = z ? 0.0f : 1.0f;
        this.f47262j.setVolume(f2, f2);
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.q = new RelativeLayout(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            this.q.setVisibility(8);
            addView(this.q, layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.addRule(13);
            ProgressBar progressBar = new ProgressBar(getContext());
            this.r = progressBar;
            progressBar.setId(16908308);
            this.r.setMax(100);
            this.r.setProgress(10);
            this.r.setSecondaryProgress(100);
            this.q.addView(this.r, layoutParams2);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams3.addRule(9);
            layoutParams3.addRule(3, 16908308);
            TextView textView = new TextView(getContext());
            this.s = textView;
            textView.setTextColor(-1);
            this.s.setText(c.a.p0.v.f.laoding);
            this.s.setGravity(1);
            this.q.addView(this.s, layoutParams3);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, motionEvent)) == null) {
            if (motionEvent.getAction() == 0) {
                v();
            }
            return super.onTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public void openVideo() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            try {
                MediaPlayer createPlayer = createPlayer();
                this.f47262j = createPlayer;
                createPlayer.setOnPreparedListener(this.A);
                this.f47262j.setOnCompletionListener(this.B);
                this.f47262j.setOnErrorListener(this.D);
                this.f47262j.setOnBufferingUpdateListener(this.E);
                this.f47262j.setOnSeekCompleteListener(this.F);
                this.f47262j.setOnVideoSizeChangedListener(this.C);
                this.k = 0;
                this.f47262j.setAudioStreamType(3);
                this.f47262j.setScreenOnWhilePlaying(true);
            } catch (IllegalArgumentException unused) {
                setCurrentState(-1);
                this.f47258f = false;
                this.D.onError(this.f47262j, 1, 0);
            }
        }
    }

    public final void p(MediaPlayer mediaPlayer, a.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048594, this, mediaPlayer, bVar) == null) || mediaPlayer == null) {
            return;
        }
        if (bVar == null) {
            mediaPlayer.setDisplay(null);
        } else {
            bVar.a(mediaPlayer);
        }
    }

    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            if (s() && this.f47262j.isPlaying()) {
                this.f47262j.pause();
                setCurrentState(4);
            }
            this.f47258f = false;
            c.a.p0.v.h.a aVar = this.y;
            if (aVar != null) {
                aVar.onPause();
            }
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            setRenderView(new TextureRenderView(getContext()));
        }
    }

    public final void r(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, context) == null) {
            this.l = context.getApplicationContext();
            this.x = new FrameLayout(context);
            ViewGroup.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            this.x.setBackgroundColor(-16777216);
            addView(this.x, layoutParams);
            this.f47261i = new MediaController(context);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
            layoutParams2.gravity = 80;
            this.f47261i.setVisibility(8);
            addView(this.f47261i, layoutParams2);
            this.f47261i.bindMediaControl(this);
            q();
            o();
            setFocusable(true);
            setFocusableInTouchMode(true);
            requestFocus();
            setCurrentState(0);
        }
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            t();
            this.f47258f = false;
            c.a.p0.v.a aVar = this.u;
            if (aVar != null) {
                aVar.release();
            }
            MediaController mediaController = this.f47261i;
            if (mediaController != null) {
                mediaController.setToggleScreenListener(null);
                this.f47261i.bindMediaControl(null);
                this.f47261i = null;
            }
            if (this.y != null) {
                this.y = null;
            }
        }
    }

    public final boolean s() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? (this.f47262j == null || (i2 = this.f47257e) == -1 || i2 == 0 || i2 == 1) ? false : true : invokeV.booleanValue;
    }

    public void seekTo(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048600, this, i2) == null) && s()) {
            if (i2 >= this.f47262j.getDuration()) {
                i2 = this.f47262j.getDuration() - 1000;
            }
            this.f47262j.seekTo(i2);
            setCacheViewVisibility(true);
        }
    }

    public void setHeaders(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, map) == null) {
            this.f47260h = map;
        }
    }

    public void setInitPlayPosition(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i2) == null) {
            this.m = i2;
            MediaPlayer mediaPlayer = this.f47262j;
            if (mediaPlayer != null) {
                mediaPlayer.seekTo(i2);
                this.m = -1;
            }
        }
    }

    public void setIsLandscape(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
            this.z = z;
            MediaController mediaController = this.f47261i;
            if (mediaController != null) {
                mediaController.onVideoOrientationChange(z);
            }
        }
    }

    public void setLooping(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048604, this, z) == null) {
            this.n = z;
            MediaPlayer mediaPlayer = this.f47262j;
            if (mediaPlayer != null) {
                mediaPlayer.setLooping(z);
            }
        }
    }

    public void setMediaControllerEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048605, this, z) == null) {
            this.p = z;
        }
    }

    public void setMuted(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048606, this, z) == null) || this.f47262j == null) {
            return;
        }
        setVolume(z ? 0.0f : 1.0f);
        this.o = z;
        MediaController mediaController = this.f47261i;
        if (mediaController == null || !this.p) {
            return;
        }
        mediaController.setMute(z);
    }

    public void setRenderView(c.a.p0.v.a aVar) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, aVar) == null) {
            if (this.u != null) {
                MediaPlayer mediaPlayer = this.f47262j;
                if (mediaPlayer != null) {
                    mediaPlayer.setDisplay(null);
                }
                View view = this.u.getView();
                this.u.removeRenderCallback(this.G);
                this.u.release();
                this.u = null;
                this.x.removeView(view);
            }
            if (aVar == null) {
                return;
            }
            this.u = aVar;
            aVar.setAspectRatio(this.t);
            int i3 = this.v;
            if (i3 > 0 && (i2 = this.w) > 0) {
                aVar.setVideoSize(i3, i2);
            }
            View view2 = this.u.getView();
            view2.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
            this.x.addView(view2);
            this.u.addRenderCallback(this.G);
        }
    }

    public void setSurface(Surface surface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, surface) == null) {
            this.f47262j.setSurface(surface);
        }
    }

    public void setVideoPath(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, str) == null) {
            Uri parse = Uri.parse(str);
            this.f47259g = parse;
            if (parse == null) {
                return;
            }
            MediaPlayer mediaPlayer = this.f47262j;
            if (mediaPlayer != null) {
                try {
                    mediaPlayer.setDataSource(this.l, parse, this.f47260h);
                    this.f47262j.prepareAsync();
                    setCacheViewVisibility(true);
                    setCurrentState(1);
                } catch (IOException unused) {
                    setCurrentState(-1);
                    this.f47258f = false;
                    this.D.onError(this.f47262j, 1, 0);
                }
            }
            requestLayout();
            invalidate();
        }
    }

    public void setVideoPlayerCallback(c.a.p0.v.h.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, aVar) == null) {
            this.y = aVar;
            MediaController mediaController = this.f47261i;
            if (mediaController != null) {
                mediaController.setToggleScreenListener(aVar);
            }
        }
    }

    public void setVideoScalingMode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048611, this, i2) == null) {
            if (i2 == 1 || i2 == 2 || i2 == 3) {
                if (i2 == 1) {
                    this.t = 0;
                } else if (i2 == 2) {
                    this.t = 1;
                } else {
                    this.t = 3;
                }
                c.a.p0.v.a aVar = this.u;
                if (aVar != null) {
                    aVar.setAspectRatio(this.t);
                }
            }
        }
    }

    public void setVolume(float f2) {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048612, this, f2) == null) || (mediaPlayer = this.f47262j) == null) {
            return;
        }
        mediaPlayer.setVolume(f2, f2);
    }

    public void start() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048613, this) == null) || this.f47262j == null) {
            return;
        }
        int i2 = this.f47257e;
        if (i2 != -1 && i2 != 5) {
            if (s()) {
                c.a.p0.v.h.a aVar = this.y;
                if (aVar != null) {
                    if (this.f47257e == 4) {
                        aVar.onResume();
                    } else {
                        aVar.onStart();
                    }
                }
                this.f47262j.start();
                setCurrentState(3);
            }
        } else {
            if (this.f47257e == 5) {
                this.f47262j.stop();
            }
            u();
            setCacheViewVisibility(true);
            setCurrentState(1);
        }
        this.f47258f = true;
    }

    public void stopPlayback() {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048614, this) == null) || (mediaPlayer = this.f47262j) == null) {
            return;
        }
        mediaPlayer.stop();
        t();
        this.f47258f = false;
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            MediaPlayer mediaPlayer = this.f47262j;
            if (mediaPlayer != null) {
                mediaPlayer.reset();
                this.f47262j.setDisplay(null);
                this.f47262j.release();
                this.f47262j = null;
                setCurrentState(0);
            }
            if (this.y != null) {
                this.y = null;
            }
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            try {
                this.f47262j.reset();
                this.f47262j.setDataSource(this.l, this.f47259g, this.f47260h);
                this.f47262j.prepareAsync();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048617, this) == null) && this.p) {
            if (this.f47261i.getVisibility() != 0) {
                this.f47261i.hideOuterAfterSeconds();
            } else {
                this.f47261i.hide();
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
        this.f47257e = 0;
        this.m = -1;
        this.p = true;
        this.t = 0;
        this.A = new a(this);
        this.B = new b(this);
        this.C = new c(this);
        this.D = new d(this);
        this.E = new e(this);
        this.F = new f(this);
        this.G = new g(this);
        r(context);
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
        this.f47257e = 0;
        this.m = -1;
        this.p = true;
        this.t = 0;
        this.A = new a(this);
        this.B = new b(this);
        this.C = new c(this);
        this.D = new d(this);
        this.E = new e(this);
        this.F = new f(this);
        this.G = new g(this);
        r(context);
    }
}

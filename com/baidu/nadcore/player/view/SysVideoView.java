package com.baidu.nadcore.player.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Build;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.c0.s.j;
import c.a.c0.s.k;
import c.a.c0.s.l;
import c.a.c0.s.o;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.player.SurfaceView;
import com.baidu.nadcore.player.SysMediaPlayer;
import com.baidu.nadcore.player.TextureView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes10.dex */
public class SysVideoView extends FrameLayout implements MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnVideoSizeChangedListener, MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnSeekCompleteListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final Context f38140e;

    /* renamed from: f  reason: collision with root package name */
    public final SysMediaPlayer f38141f;

    /* renamed from: g  reason: collision with root package name */
    public k f38142g;

    /* renamed from: h  reason: collision with root package name */
    public MediaPlayer.OnPreparedListener f38143h;

    /* renamed from: i  reason: collision with root package name */
    public MediaPlayer.OnVideoSizeChangedListener f38144i;

    /* renamed from: j  reason: collision with root package name */
    public MediaPlayer.OnCompletionListener f38145j;

    /* renamed from: k  reason: collision with root package name */
    public MediaPlayer.OnSeekCompleteListener f38146k;
    public MediaPlayer.OnBufferingUpdateListener l;
    public MediaPlayer.OnErrorListener m;
    public MediaPlayer.OnInfoListener n;
    public l o;
    public j p;

    /* loaded from: classes10.dex */
    public class a implements o {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SysVideoView a;

        public a(SysVideoView sysVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sysVideoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sysVideoView;
        }

        @Override // c.a.c0.s.o
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.a.d(i2);
            }
        }
    }

    /* loaded from: classes10.dex */
    public class b implements l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SysVideoView a;

        public b(SysVideoView sysVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sysVideoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sysVideoView;
        }

        @Override // c.a.c0.s.l
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // c.a.c0.s.l
        public void b(Surface surface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, surface) == null) {
                this.a.f38141f.z(surface);
                this.a.f38141f.A(this.a.f38140e, 10);
            }
        }
    }

    /* loaded from: classes10.dex */
    public class c implements j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SysVideoView a;

        public c(SysVideoView sysVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sysVideoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sysVideoView;
        }

        @Override // c.a.c0.s.j
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // c.a.c0.s.j
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, surfaceHolder) == null) {
                this.a.f38141f.o(surfaceHolder);
                this.a.f38141f.y(true);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SysVideoView(@NonNull Context context) {
        this(context, null);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void d(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048576, this, i2) == null) && i2 == 258) {
            k kVar = this.f38142g;
            if (kVar != null) {
                kVar.onVideoSizeChanged(this.f38141f.d(), this.f38141f.c());
            }
            this.f38141f.B();
        }
    }

    public final void e(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            this.f38141f.v(this);
            this.f38141f.r(this);
            this.f38141f.x(this);
            this.f38141f.q(this);
            this.f38141f.w(this);
            this.f38141f.s(this);
            this.f38141f.t(this);
            f(false);
        }
    }

    @SuppressLint({"ObsoleteSdkInt"})
    public final void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            if (z && Build.VERSION.SDK_INT < 14) {
                this.f38142g = new SurfaceView(this.f38140e, this.p);
            } else {
                this.f38142g = new TextureView(this.f38140e, this.o);
            }
            addView((View) this.f38142g, new FrameLayout.LayoutParams(-2, -2, 17));
        }
    }

    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f38141f.a() : invokeV.intValue;
    }

    public int getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f38141f.b() : invokeV.intValue;
    }

    public int getVideoHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f38141f.c() : invokeV.intValue;
    }

    public int getVideoWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f38141f.d() : invokeV.intValue;
    }

    public void muteOrUnmuteAudio(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.f38141f.f(z);
        }
    }

    @Override // android.media.MediaPlayer.OnBufferingUpdateListener
    public void onBufferingUpdate(MediaPlayer mediaPlayer, int i2) {
        MediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, mediaPlayer, i2) == null) || (onBufferingUpdateListener = this.l) == null) {
            return;
        }
        onBufferingUpdateListener.onBufferingUpdate(mediaPlayer, i2);
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        MediaPlayer.OnCompletionListener onCompletionListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, mediaPlayer) == null) || (onCompletionListener = this.f38145j) == null) {
            return;
        }
        onCompletionListener.onCompletion(mediaPlayer);
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048586, this, mediaPlayer, i2, i3)) == null) {
            MediaPlayer.OnErrorListener onErrorListener = this.m;
            if (onErrorListener != null) {
                onErrorListener.onError(mediaPlayer, i2, i3);
                return true;
            }
            return true;
        }
        return invokeLII.booleanValue;
    }

    @Override // android.media.MediaPlayer.OnInfoListener
    public boolean onInfo(MediaPlayer mediaPlayer, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048587, this, mediaPlayer, i2, i3)) == null) {
            MediaPlayer.OnInfoListener onInfoListener = this.n;
            if (onInfoListener != null) {
                onInfoListener.onInfo(mediaPlayer, i2, i3);
                return false;
            }
            return false;
        }
        return invokeLII.booleanValue;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        MediaPlayer.OnPreparedListener onPreparedListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, mediaPlayer) == null) || (onPreparedListener = this.f38143h) == null) {
            return;
        }
        onPreparedListener.onPrepared(mediaPlayer);
    }

    @Override // android.media.MediaPlayer.OnSeekCompleteListener
    public void onSeekComplete(MediaPlayer mediaPlayer) {
        MediaPlayer.OnSeekCompleteListener onSeekCompleteListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, mediaPlayer) == null) || (onSeekCompleteListener = this.f38146k) == null) {
            return;
        }
        onSeekCompleteListener.onSeekComplete(mediaPlayer);
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i2, int i3) {
        MediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(1048590, this, mediaPlayer, i2, i3) == null) || (onVideoSizeChangedListener = this.f38144i) == null) {
            return;
        }
        onVideoSizeChangedListener.onVideoSizeChanged(mediaPlayer, i2, i3);
    }

    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.f38141f.h();
        }
    }

    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.f38141f.j();
            this.f38145j = null;
            this.l = null;
            this.m = null;
            this.n = null;
            this.f38143h = null;
            this.f38146k = null;
            this.f38144i = null;
        }
    }

    public void resume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.f38141f.k();
        }
    }

    public void seekTo(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            seekTo(i2, 3);
        }
    }

    public void setLooping(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            this.f38141f.p(z);
        }
    }

    public void setOnBufferingUpdateListener(MediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, onBufferingUpdateListener) == null) {
            this.l = onBufferingUpdateListener;
        }
    }

    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, onCompletionListener) == null) {
            this.f38145j = onCompletionListener;
        }
    }

    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, onErrorListener) == null) {
            this.m = onErrorListener;
        }
    }

    public void setOnInfoListener(MediaPlayer.OnInfoListener onInfoListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, onInfoListener) == null) {
            this.n = onInfoListener;
        }
    }

    public void setOnPreparedListener(MediaPlayer.OnPreparedListener onPreparedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, onPreparedListener) == null) {
            this.f38143h = onPreparedListener;
        }
    }

    public void setOnSeekCompleteListener(MediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, onSeekCompleteListener) == null) {
            this.f38146k = onSeekCompleteListener;
        }
    }

    public void setOnVideoSizeChangedListener(MediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, onVideoSizeChangedListener) == null) {
            this.f38144i = onVideoSizeChangedListener;
        }
    }

    public void setVideoURI(String str, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048604, this, str, map) == null) {
            this.f38141f.m(str, map);
            requestLayout();
            invalidate();
        }
    }

    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            this.f38141f.B();
        }
    }

    public void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            this.f38141f.C();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SysVideoView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public void seekTo(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048595, this, i2, i3) == null) {
            this.f38141f.l(i2, i3);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SysVideoView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
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
        this.o = new b(this);
        this.p = new c(this);
        this.f38140e = context;
        SysMediaPlayer sysMediaPlayer = new SysMediaPlayer(context);
        this.f38141f = sysMediaPlayer;
        sysMediaPlayer.u(new a(this));
        e(context);
    }
}

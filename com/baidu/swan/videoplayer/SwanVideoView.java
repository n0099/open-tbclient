package com.baidu.swan.videoplayer;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.videoplayer.widget.MediaController;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.v.a;
import java.io.IOException;
import java.util.Map;
/* loaded from: classes3.dex */
public class SwanVideoView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public MediaPlayer.OnCompletionListener A;
    public MediaPlayer.OnVideoSizeChangedListener B;
    public MediaPlayer.OnErrorListener C;
    public MediaPlayer.OnBufferingUpdateListener D;
    public MediaPlayer.OnSeekCompleteListener E;
    public a.InterfaceC1164a F;

    /* renamed from: e  reason: collision with root package name */
    public int f12112e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f12113f;

    /* renamed from: g  reason: collision with root package name */
    public Uri f12114g;

    /* renamed from: h  reason: collision with root package name */
    public Map<String, String> f12115h;

    /* renamed from: i  reason: collision with root package name */
    public MediaController f12116i;
    public MediaPlayer j;
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
    public d.a.o0.v.a u;
    public int v;
    public int w;
    public FrameLayout x;
    public d.a.o0.v.h.a y;
    public MediaPlayer.OnPreparedListener z;

    /* loaded from: classes3.dex */
    public class a implements MediaPlayer.OnPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanVideoView f12117e;

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
            this.f12117e = swanVideoView;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, mediaPlayer) == null) {
                this.f12117e.setCurrentState(2);
                this.f12117e.setCacheViewVisibility(false);
                if (this.f12117e.y != null) {
                    this.f12117e.y.onPrepared();
                }
                this.f12117e.v = mediaPlayer.getVideoWidth();
                this.f12117e.w = mediaPlayer.getVideoHeight();
                if (this.f12117e.v != 0 && this.f12117e.w != 0 && this.f12117e.u != null) {
                    this.f12117e.u.setVideoSize(this.f12117e.v, this.f12117e.w);
                }
                if (this.f12117e.f12113f) {
                    this.f12117e.C();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements MediaPlayer.OnCompletionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanVideoView f12118e;

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
            this.f12118e = swanVideoView;
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, mediaPlayer) == null) {
                Log.d("SwanVideoView", "onCompletion");
                this.f12118e.setCacheViewVisibility(false);
                this.f12118e.setCurrentState(5);
                this.f12118e.f12113f = false;
                if (this.f12118e.y != null) {
                    this.f12118e.y.onEnd();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements MediaPlayer.OnVideoSizeChangedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanVideoView f12119e;

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
            this.f12119e = swanVideoView;
        }

        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, mediaPlayer, i2, i3) == null) {
                this.f12119e.v = mediaPlayer.getVideoWidth();
                this.f12119e.w = mediaPlayer.getVideoHeight();
                if (this.f12119e.v == 0 || this.f12119e.w == 0) {
                    return;
                }
                if (this.f12119e.u != null) {
                    this.f12119e.u.setVideoSize(this.f12119e.v, this.f12119e.w);
                }
                if (this.f12119e.y != null) {
                    this.f12119e.y.onVideoSizeChanged(i2, i3);
                }
                this.f12119e.requestLayout();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements MediaPlayer.OnErrorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanVideoView f12120e;

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
            this.f12120e = swanVideoView;
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, mediaPlayer, i2, i3)) == null) {
                Log.d("SwanVideoView", "onError: " + i2 + "," + i3);
                this.f12120e.setCurrentState(-1);
                this.f12120e.f12113f = false;
                this.f12120e.setCacheViewVisibility(false);
                if (this.f12120e.y != null) {
                    this.f12120e.y.onError(i2, i3, null);
                }
                return this.f12120e.y != null;
            }
            return invokeLII.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class e implements MediaPlayer.OnBufferingUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanVideoView f12121e;

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
            this.f12121e = swanVideoView;
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, mediaPlayer, i2) == null) {
                Log.d("SwanVideoView", "onBufferingUpdate: percent=" + i2);
                this.f12121e.k = i2;
                if (this.f12121e.y != null) {
                    this.f12121e.y.onBufferingUpdate(i2);
                }
                if (this.f12121e.f12116i != null) {
                    this.f12121e.f12116i.l((i2 * this.f12121e.getDuration()) / 100);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements MediaPlayer.OnSeekCompleteListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanVideoView f12122e;

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
            this.f12122e = swanVideoView;
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, mediaPlayer) == null) {
                Log.d("SwanVideoView", "onSeekComplete");
                this.f12122e.setCacheViewVisibility(false);
                if (this.f12122e.y != null) {
                    this.f12122e.y.onSeekEnd();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements a.InterfaceC1164a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SwanVideoView f12123a;

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
            this.f12123a = swanVideoView;
        }

        @Override // d.a.o0.v.a.InterfaceC1164a
        public void a(a.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            }
        }

        @Override // d.a.o0.v.a.InterfaceC1164a
        public void b(a.b bVar, int i2, int i3) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, i2, i3) == null) && bVar.b() == this.f12123a.u && this.f12123a.j != null) {
                SwanVideoView swanVideoView = this.f12123a;
                swanVideoView.p(swanVideoView.j, bVar);
            }
        }

        @Override // d.a.o0.v.a.InterfaceC1164a
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
        this.f12112e = 0;
        this.m = -1;
        this.p = true;
        this.t = 0;
        this.z = new a(this);
        this.A = new b(this);
        this.B = new c(this);
        this.C = new d(this);
        this.D = new e(this);
        this.E = new f(this);
        this.F = new g(this);
        s(context);
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
        if (!(interceptable == null || interceptable.invokeI(65554, this, i2) == null) || this.f12112e == i2) {
            return;
        }
        this.f12112e = i2;
        MediaController mediaController = this.f12116i;
        if (mediaController != null) {
            mediaController.s();
        }
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                this.j.reset();
                this.j.setDataSource(this.l, this.f12114g, this.f12115h);
                this.j.prepareAsync();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void B(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) && t()) {
            if (i2 >= this.j.getDuration()) {
                i2 = this.j.getDuration() - 1000;
            }
            this.j.seekTo(i2);
            setCacheViewVisibility(true);
        }
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.j == null) {
            return;
        }
        int i2 = this.f12112e;
        if (i2 != -1 && i2 != 5) {
            if (t()) {
                d.a.o0.v.h.a aVar = this.y;
                if (aVar != null) {
                    if (this.f12112e == 4) {
                        aVar.onResume();
                    } else {
                        aVar.onStart();
                    }
                }
                this.j.start();
                setCurrentState(3);
            }
        } else {
            if (this.f12112e == 5) {
                this.j.stop();
            }
            A();
            setCacheViewVisibility(true);
            setCurrentState(1);
        }
        this.f12113f = true;
    }

    public void D() {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (mediaPlayer = this.j) == null) {
            return;
        }
        mediaPlayer.stop();
        z();
        this.f12113f = false;
    }

    public final void E() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.p) {
            if (this.f12116i.getVisibility() != 0) {
                this.f12116i.i();
            } else {
                this.f12116i.h();
            }
        }
    }

    public Bitmap getBitmap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            d.a.o0.v.a aVar = this.u;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.j != null) {
                return this.k;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public int getCurrentPlayerState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f12112e : invokeV.intValue;
    }

    public String getCurrentPlayingUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            Uri uri = this.f12114g;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (t()) {
                return this.j.getCurrentPosition();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public int getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (t()) {
                return this.j.getDuration();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public int getVideoHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.j.getVideoHeight() : invokeV.intValue;
    }

    public d.a.o0.v.h.a getVideoPlayerCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.y : (d.a.o0.v.h.a) invokeV.objValue;
    }

    public int getVideoWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.j.getVideoWidth() : invokeV.intValue;
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
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
            this.s.setText(d.a.o0.v.f.laoding);
            this.s.setGravity(1);
            this.q.addView(this.s, layoutParams3);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, motionEvent)) == null) {
            if (motionEvent.getAction() == 0) {
                E();
            }
            return super.onTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public final void p(MediaPlayer mediaPlayer, a.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048592, this, mediaPlayer, bVar) == null) || mediaPlayer == null) {
            return;
        }
        if (bVar == null) {
            mediaPlayer.setDisplay(null);
        } else {
            bVar.a(mediaPlayer);
        }
    }

    public MediaPlayer q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            MediaPlayer mediaPlayer = new MediaPlayer();
            mediaPlayer.setLooping(this.n);
            mediaPlayer.setWakeMode(getContext(), 10);
            return mediaPlayer;
        }
        return (MediaPlayer) invokeV.objValue;
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            setRenderView(new TextureRenderView(getContext()));
        }
    }

    public final void s(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, context) == null) {
            this.l = context.getApplicationContext();
            this.x = new FrameLayout(context);
            ViewGroup.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            this.x.setBackgroundColor(-16777216);
            addView(this.x, layoutParams);
            this.f12116i = new MediaController(context);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
            layoutParams2.gravity = 80;
            this.f12116i.setVisibility(8);
            addView(this.f12116i, layoutParams2);
            this.f12116i.f(this);
            r();
            o();
            setFocusable(true);
            setFocusableInTouchMode(true);
            requestFocus();
            setCurrentState(0);
        }
    }

    public void setHeaders(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, map) == null) {
            this.f12115h = map;
        }
    }

    public void setInitPlayPosition(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i2) == null) {
            this.m = i2;
            MediaPlayer mediaPlayer = this.j;
            if (mediaPlayer != null) {
                mediaPlayer.seekTo(i2);
                this.m = -1;
            }
        }
    }

    public void setIsLandscape(boolean z) {
        MediaController mediaController;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048598, this, z) == null) || (mediaController = this.f12116i) == null) {
            return;
        }
        mediaController.m(z);
    }

    public void setLooping(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            this.n = z;
            MediaPlayer mediaPlayer = this.j;
            if (mediaPlayer != null) {
                mediaPlayer.setLooping(z);
            }
        }
    }

    public void setMediaControllerEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            this.p = z;
        }
    }

    public void setMuted(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048601, this, z) == null) || this.j == null) {
            return;
        }
        setVolume(z ? 0.0f : 1.0f);
        this.o = z;
        MediaController mediaController = this.f12116i;
        if (mediaController == null || !this.p) {
            return;
        }
        mediaController.setMute(z);
    }

    public void setRenderView(d.a.o0.v.a aVar) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, aVar) == null) {
            if (this.u != null) {
                MediaPlayer mediaPlayer = this.j;
                if (mediaPlayer != null) {
                    mediaPlayer.setDisplay(null);
                }
                View view = this.u.getView();
                this.u.a(this.F);
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
            this.u.b(this.F);
        }
    }

    public void setSurface(Surface surface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, surface) == null) {
            this.j.setSurface(surface);
        }
    }

    public void setVideoPath(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, str) == null) {
            Uri parse = Uri.parse(str);
            this.f12114g = parse;
            if (parse == null) {
                return;
            }
            MediaPlayer mediaPlayer = this.j;
            if (mediaPlayer != null) {
                try {
                    mediaPlayer.setDataSource(this.l, parse, this.f12115h);
                    this.j.prepareAsync();
                    setCacheViewVisibility(true);
                    setCurrentState(1);
                } catch (IOException unused) {
                    setCurrentState(-1);
                    this.f12113f = false;
                    this.C.onError(this.j, 1, 0);
                }
            }
            requestLayout();
            invalidate();
        }
    }

    public void setVideoPlayerCallback(d.a.o0.v.h.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, aVar) == null) {
            this.y = aVar;
            MediaController mediaController = this.f12116i;
            if (mediaController != null) {
                mediaController.setToggleScreenListener(aVar);
            }
        }
    }

    public void setVideoScalingMode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048606, this, i2) == null) {
            if (i2 != 1 && i2 != 2 && i2 != 3) {
                Log.e("SwanVideoView", "setVideoScalingMode: param should be VID");
                return;
            }
            if (i2 == 1) {
                this.t = 0;
            } else if (i2 == 2) {
                this.t = 1;
            } else {
                this.t = 3;
            }
            d.a.o0.v.a aVar = this.u;
            if (aVar != null) {
                aVar.setAspectRatio(this.t);
            }
        }
    }

    public void setVolume(float f2) {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048607, this, f2) == null) || (mediaPlayer = this.j) == null) {
            return;
        }
        mediaPlayer.setVolume(f2, f2);
    }

    public final boolean t() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? (this.j == null || (i2 = this.f12112e) == -1 || i2 == 0 || i2 == 1) ? false : true : invokeV.booleanValue;
    }

    public boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.o : invokeV.booleanValue;
    }

    public boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? t() && this.j.isPlaying() : invokeV.booleanValue;
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            try {
                MediaPlayer q = q();
                this.j = q;
                q.setOnPreparedListener(this.z);
                this.j.setOnCompletionListener(this.A);
                this.j.setOnErrorListener(this.C);
                this.j.setOnBufferingUpdateListener(this.D);
                this.j.setOnSeekCompleteListener(this.E);
                this.j.setOnVideoSizeChangedListener(this.B);
                this.k = 0;
                this.j.setAudioStreamType(3);
                this.j.setScreenOnWhilePlaying(true);
            } catch (IllegalArgumentException unused) {
                setCurrentState(-1);
                this.f12113f = false;
                this.C.onError(this.j, 1, 0);
            }
        }
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            if (t() && this.j.isPlaying()) {
                this.j.pause();
                setCurrentState(4);
            }
            this.f12113f = false;
            d.a.o0.v.h.a aVar = this.y;
            if (aVar != null) {
                aVar.onPause();
            }
        }
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            z();
            this.f12113f = false;
            d.a.o0.v.a aVar = this.u;
            if (aVar != null) {
                aVar.release();
            }
            MediaController mediaController = this.f12116i;
            if (mediaController != null) {
                mediaController.setToggleScreenListener(null);
                this.f12116i.f(null);
                this.f12116i = null;
            }
            if (this.y != null) {
                this.y = null;
            }
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            MediaPlayer mediaPlayer = this.j;
            if (mediaPlayer != null) {
                mediaPlayer.reset();
                this.j.setDisplay(null);
                this.j.release();
                this.j = null;
                setCurrentState(0);
            }
            if (this.y != null) {
                this.y = null;
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
        this.f12112e = 0;
        this.m = -1;
        this.p = true;
        this.t = 0;
        this.z = new a(this);
        this.A = new b(this);
        this.B = new c(this);
        this.C = new d(this);
        this.D = new e(this);
        this.E = new f(this);
        this.F = new g(this);
        s(context);
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
        this.f12112e = 0;
        this.m = -1;
        this.p = true;
        this.t = 0;
        this.z = new a(this);
        this.A = new b(this);
        this.B = new c(this);
        this.C = new d(this);
        this.D = new e(this);
        this.E = new f(this);
        this.F = new g(this);
        s(context);
    }
}

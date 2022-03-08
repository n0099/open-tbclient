package com.baidu.sdk.container.player;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.b0.h0.f;
import c.a.b0.h0.t;
import c.a.k0.a.j.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sdk.container.player.BaseMediaPlayer;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.un.w0;
import java.lang.ref.SoftReference;
/* loaded from: classes4.dex */
public class AdVideoView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SurfaceHolder A;
    public c.a.k0.a.j.b B;

    /* renamed from: e  reason: collision with root package name */
    public a.InterfaceC0197a f36885e;

    /* renamed from: f  reason: collision with root package name */
    public a.b f36886f;

    /* renamed from: g  reason: collision with root package name */
    public AdVideoProgressBar f36887g;

    /* renamed from: h  reason: collision with root package name */
    public int f36888h;

    /* renamed from: i  reason: collision with root package name */
    public int f36889i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f36890j;
    public int k;
    public e l;
    public boolean m;
    public View mLoadingView;
    public BaseMediaPlayer mMediaPlayer;
    public c.a.k0.a.j.c mSurfaceView;
    public c.a.k0.a.j.a mVideoViewListener;
    public Context mViewContext;
    public String n;
    public d o;
    public boolean p;
    public boolean q;
    public boolean r;
    public boolean s;
    public boolean t;
    public int u;
    public boolean v;
    public int w;
    public boolean x;
    public Surface y;
    public c.a.k0.a.j.d z;

    /* loaded from: classes4.dex */
    public class a implements c.a.k0.a.j.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdVideoView a;

        public a(AdVideoView adVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adVideoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = adVideoView;
        }

        @Override // c.a.k0.a.j.e
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.a.k(i2);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements c.a.k0.a.j.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdVideoView a;

        public b(AdVideoView adVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adVideoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = adVideoView;
        }

        @Override // c.a.k0.a.j.d
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.f36885e != null) {
                    this.a.f36885e.a();
                }
                this.a.p = false;
                this.a.q = false;
                this.a.stopAndRelease();
            }
        }

        @Override // c.a.k0.a.j.d
        public void b(Surface surface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, surface) == null) {
                this.a.y = surface;
                this.a.q = true;
                this.a.t();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements c.a.k0.a.j.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdVideoView a;

        public c(AdVideoView adVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adVideoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = adVideoView;
        }

        @Override // c.a.k0.a.j.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.f36885e != null) {
                    this.a.f36885e.a();
                }
                this.a.p = false;
                this.a.q = false;
                this.a.stopAndRelease();
            }
        }

        @Override // c.a.k0.a.j.b
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, surfaceHolder) == null) {
                this.a.A = surfaceHolder;
                this.a.q = true;
                this.a.t();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdVideoView this$0;

        public d(AdVideoView adVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adVideoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = adVideoView;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) {
                String action = intent.getAction();
                if ("android.intent.action.SCREEN_OFF".equals(action)) {
                    Context context2 = this.this$0.mViewContext;
                    if (c.a.b0.h0.b.d(context2, context2.getPackageName())) {
                        return;
                    }
                    this.this$0.r = true;
                    this.this$0.stopAndRelease();
                } else if ("android.intent.action.USER_PRESENT".equals(action)) {
                    this.this$0.r = false;
                    this.this$0.t();
                }
            }
        }

        public /* synthetic */ d(AdVideoView adVideoView, a aVar) {
            this(adVideoView);
        }
    }

    /* loaded from: classes4.dex */
    public static class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public SoftReference<AdVideoView> f36891e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f36892f;

        public e(AdVideoView adVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adVideoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f36892f = false;
            this.f36891e = new SoftReference<>(adVideoView);
        }

        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.f36892f = z;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            SoftReference<AdVideoView> softReference;
            AdVideoView adVideoView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (softReference = this.f36891e) == null || (adVideoView = softReference.get()) == null) {
                return;
            }
            int currentPosition = adVideoView.getCurrentPosition();
            int duration = adVideoView.getDuration();
            if (adVideoView.f36887g != null && duration > 0) {
                adVideoView.f36887g.setProgress(currentPosition / duration);
            }
            if (this.f36892f) {
                adVideoView.postDelayed(this, 200L);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdVideoView(Context context) {
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
        this.f36888h = -1;
        this.f36889i = -16777216;
        this.f36890j = false;
        this.k = 4;
        this.n = "";
        this.q = false;
        this.r = false;
        this.s = false;
        this.v = false;
        this.w = 1;
        this.x = false;
        this.z = new b(this);
        this.B = new c(this);
        this.mViewContext = context;
        m();
    }

    public void clearData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.n = "";
        }
    }

    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            BaseMediaPlayer baseMediaPlayer = this.mMediaPlayer;
            if (baseMediaPlayer != null) {
                return baseMediaPlayer.a();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public int getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            BaseMediaPlayer baseMediaPlayer = this.mMediaPlayer;
            if (baseMediaPlayer != null) {
                return baseMediaPlayer.b();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public int getLastPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.u : invokeV.intValue;
    }

    public void initAdVideoView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            n();
            p(false);
            j();
            o();
        }
    }

    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            BaseMediaPlayer baseMediaPlayer = this.mMediaPlayer;
            if (baseMediaPlayer != null) {
                return baseMediaPlayer.f();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            removeAllViews();
            this.v = false;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            setBackgroundColor(Color.parseColor("#000000"));
            addView((View) this.mSurfaceView, layoutParams);
        }
    }

    public final void k(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            switch (i2) {
                case 256:
                    this.u = 0;
                    this.v = false;
                    l();
                    c.a.k0.a.j.a aVar = this.mVideoViewListener;
                    if (aVar != null) {
                        aVar.d();
                        return;
                    }
                    return;
                case 257:
                    this.v = false;
                    this.u = 0;
                    r();
                    return;
                case 258:
                    a.b bVar = this.f36886f;
                    if (bVar != null) {
                        bVar.onPrepared();
                    }
                    int i3 = this.u;
                    if (i3 > 0) {
                        this.mMediaPlayer.l(i3);
                    }
                    setVideoMute(this.m);
                    c.a.k0.a.j.c cVar = this.mSurfaceView;
                    if (cVar != null) {
                        cVar.onVideoSizeChanged(this.mMediaPlayer.d(), this.mMediaPlayer.c());
                    }
                    AdVideoProgressBar adVideoProgressBar = this.f36887g;
                    if (adVideoProgressBar != null) {
                        adVideoProgressBar.setProgress(this.u / getDuration());
                        e eVar = this.l;
                        if (eVar != null) {
                            removeCallbacks(eVar);
                            this.l.a(true);
                            postDelayed(this.l, 200L);
                        }
                    }
                    if (this.p && t.c(this)) {
                        q();
                        return;
                    }
                    return;
                case 259:
                default:
                    return;
                case 260:
                    this.v = true;
                    l();
                    c.a.k0.a.j.a aVar2 = this.mVideoViewListener;
                    if (aVar2 != null) {
                        aVar2.e();
                        return;
                    }
                    return;
                case w0.F /* 261 */:
                    w();
                    return;
                case 262:
                    l();
                    return;
            }
        }
    }

    public final void l() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (view = this.mLoadingView) == null) {
            return;
        }
        view.setVisibility(8);
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && this.mMediaPlayer == null) {
            this.t = false;
            BaseMediaPlayer baseMediaPlayer = new BaseMediaPlayer(this.mViewContext);
            this.mMediaPlayer = baseMediaPlayer;
            baseMediaPlayer.n(new a(this));
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            if (this.f36890j) {
                AdVideoProgressBar adVideoProgressBar = new AdVideoProgressBar(this.mViewContext);
                this.f36887g = adVideoProgressBar;
                adVideoProgressBar.setProgressColor(this.f36888h);
                this.f36887g.setProgressBackgroundColor(this.f36889i);
                this.f36887g.setProgressHeight(this.k);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.k);
                layoutParams.addRule(12);
                addView(this.f36887g, layoutParams);
                this.f36887g.setProgress(0.0f);
                this.f36887g.setVisibility(4);
                this.l = new e(this);
                return;
            }
            AdVideoProgressBar adVideoProgressBar2 = this.f36887g;
            if (adVideoProgressBar2 != null) {
                adVideoProgressBar2.setVisibility(8);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onAttachedToWindow();
            s();
        }
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, configuration) == null) {
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onDetachedFromWindow();
            x();
            stopAndRelease();
        }
    }

    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.p = false;
            BaseMediaPlayer baseMediaPlayer = this.mMediaPlayer;
            if (baseMediaPlayer == null || baseMediaPlayer.f36897i == BaseMediaPlayer.State.PLAYBACKCOMPLETED) {
                return;
            }
            baseMediaPlayer.h();
            c.a.k0.a.j.a aVar = this.mVideoViewListener;
            if (aVar != null) {
                aVar.b();
            }
            u();
        }
    }

    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.p = true;
            t();
        }
    }

    public final void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            if (z) {
                this.x = true;
                this.mSurfaceView = new BaseSurfaceView(this.mViewContext, this.B);
            } else if (Build.VERSION.SDK_INT >= 14) {
                this.x = false;
                this.mSurfaceView = new BaseTextureView(this.mViewContext, this.z);
            } else {
                this.x = true;
                this.mSurfaceView = new BaseSurfaceView(this.mViewContext, this.B);
            }
            this.mSurfaceView.setDisplayMode(this.w);
        }
    }

    public final void q() {
        BaseMediaPlayer baseMediaPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (baseMediaPlayer = this.mMediaPlayer) == null) {
            return;
        }
        if (this.x) {
            baseMediaPlayer.m(this.A);
            this.mMediaPlayer.o(true);
        } else {
            baseMediaPlayer.p(this.y);
            this.mMediaPlayer.s(this.mViewContext, 10);
        }
        this.mMediaPlayer.t();
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            c.a.k0.a.j.a aVar = this.mVideoViewListener;
            if (aVar != null) {
                aVar.a();
            }
            l();
            stopAndRelease();
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            if (this.mViewContext == null || this.o != null) {
                return;
            }
            d dVar = new d(this, null);
            this.o = dVar;
            this.mViewContext.registerReceiver(dVar, intentFilter);
        }
    }

    public void seekTo(int i2) {
        BaseMediaPlayer baseMediaPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048598, this, i2) == null) || (baseMediaPlayer = this.mMediaPlayer) == null) {
            return;
        }
        baseMediaPlayer.l(i2);
    }

    public void setAdVideoViewListener(c.a.k0.a.j.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, aVar) == null) {
            this.mVideoViewListener = aVar;
        }
    }

    public void setDestroyedListener(a.InterfaceC0197a interfaceC0197a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, interfaceC0197a) == null) {
            this.f36885e = interfaceC0197a;
        }
    }

    public void setDisplayMode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i2) == null) {
            this.w = i2;
        }
    }

    public void setPreparedListener(a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, bVar) == null) {
            this.f36886f = bVar;
        }
    }

    public void setProgressBar(boolean z, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048603, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            this.f36890j = z;
            this.f36889i = i2;
            this.f36888h = i3;
            this.k = f.c.a(getContext(), i4);
        }
    }

    public void setProgressBarVisibility(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048604, this, i2) == null) && this.f36890j) {
            this.f36887g.setVisibility(i2);
        }
    }

    public void setVideoMute(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048605, this, z) == null) {
            this.m = z;
            if (z) {
                v(0.0f, 0.0f);
            } else {
                v(1.0f, 1.0f);
            }
        }
    }

    public void setVideoUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, str) == null) {
            this.n = str;
            if (TextUtils.isEmpty(str)) {
                r();
                return;
            }
            BaseMediaPlayer baseMediaPlayer = this.mMediaPlayer;
            if (baseMediaPlayer != null) {
                baseMediaPlayer.q(str);
            }
        }
    }

    public void startPlay(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, str) == null) {
            this.u = 0;
            this.n = str;
            this.p = true;
            this.v = true;
            t();
        }
    }

    public void stopAndRelease() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048608, this) == null) || this.mMediaPlayer == null) {
            return;
        }
        u();
        this.t = true;
        this.s = false;
        this.mMediaPlayer.n(null);
        this.mMediaPlayer.u();
        this.mMediaPlayer.k();
        this.mMediaPlayer.j();
        this.mMediaPlayer = null;
        e eVar = this.l;
        if (eVar != null) {
            eVar.a(false);
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048609, this) == null) && !TextUtils.isEmpty(this.n) && this.p && this.q) {
            Context context = this.mViewContext;
            if ((c.a.b0.h0.b.d(context, context.getPackageName()) || !this.r) && this.v) {
                c.a.k0.a.j.a aVar = this.mVideoViewListener;
                if (aVar != null) {
                    aVar.c();
                }
                if (!this.t) {
                    q();
                } else if (this.s) {
                } else {
                    stopAndRelease();
                    this.s = true;
                    n();
                    setVideoUrl(this.n);
                    q();
                }
            }
        }
    }

    public final void u() {
        BaseMediaPlayer baseMediaPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048610, this) == null) || (baseMediaPlayer = this.mMediaPlayer) == null) {
            return;
        }
        this.u = baseMediaPlayer.a();
    }

    public final void v(float f2, float f3) {
        BaseMediaPlayer baseMediaPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048611, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) || (baseMediaPlayer = this.mMediaPlayer) == null) {
            return;
        }
        baseMediaPlayer.r(f2, f3);
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            View view = this.mLoadingView;
            if (view == null) {
                this.mLoadingView = new ProgressBar(this.mViewContext);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(13);
                this.mLoadingView.setLayoutParams(layoutParams);
                addView(this.mLoadingView);
                return;
            }
            view.setVisibility(0);
        }
    }

    public final void x() {
        Context context;
        d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048613, this) == null) || (context = this.mViewContext) == null || (dVar = this.o) == null) {
            return;
        }
        try {
            context.unregisterReceiver(dVar);
            this.o = null;
        } catch (Throwable unused) {
            this.o = null;
        }
    }

    public void initAdVideoView(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            n();
            p(z);
            j();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdVideoView(Context context, AttributeSet attributeSet) {
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
        this.f36888h = -1;
        this.f36889i = -16777216;
        this.f36890j = false;
        this.k = 4;
        this.n = "";
        this.q = false;
        this.r = false;
        this.s = false;
        this.v = false;
        this.w = 1;
        this.x = false;
        this.z = new b(this);
        this.B = new c(this);
        this.mViewContext = context;
        m();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdVideoView(Context context, AttributeSet attributeSet, int i2) {
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
        this.f36888h = -1;
        this.f36889i = -16777216;
        this.f36890j = false;
        this.k = 4;
        this.n = "";
        this.q = false;
        this.r = false;
        this.s = false;
        this.v = false;
        this.w = 1;
        this.x = false;
        this.z = new b(this);
        this.B = new c(this);
        this.mViewContext = context;
        m();
    }
}

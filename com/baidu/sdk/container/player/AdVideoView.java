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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.widget.player.PlayerEvent;
import com.baidu.sdk.container.player.BaseMediaPlayer;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.i0.a.i.a;
import d.a.i0.a.k.h;
import java.lang.ref.SoftReference;
/* loaded from: classes2.dex */
public class AdVideoView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public int B;
    public boolean C;
    public Surface D;
    public d.a.i0.a.i.d E;
    public SurfaceHolder F;
    public d.a.i0.a.i.b G;

    /* renamed from: e  reason: collision with root package name */
    public BaseMediaPlayer f10162e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.i0.a.i.a f10163f;

    /* renamed from: g  reason: collision with root package name */
    public a.InterfaceC0612a f10164g;

    /* renamed from: h  reason: collision with root package name */
    public a.b f10165h;

    /* renamed from: i  reason: collision with root package name */
    public Context f10166i;
    public AdVideoProgressBar j;
    public int k;
    public int l;
    public boolean m;
    public int n;
    public e o;
    public d.a.i0.a.i.c p;
    public View q;
    public boolean r;
    public String s;
    public d t;
    public boolean u;
    public boolean v;
    public boolean w;
    public boolean x;
    public boolean y;
    public int z;

    /* loaded from: classes2.dex */
    public class a implements d.a.i0.a.i.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AdVideoView f10167a;

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
            this.f10167a = adVideoView;
        }

        @Override // d.a.i0.a.i.e
        public void playStateChanged(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.f10167a.k(i2);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements d.a.i0.a.i.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AdVideoView f10168a;

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
            this.f10168a = adVideoView;
        }

        @Override // d.a.i0.a.i.d
        public void surfaceCreated(Surface surface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, surface) == null) {
                this.f10168a.D = surface;
                this.f10168a.v = true;
                this.f10168a.w();
            }
        }

        @Override // d.a.i0.a.i.d
        public void surfaceDestroy() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (this.f10168a.f10164g != null) {
                    this.f10168a.f10164g.onDestroyed();
                }
                this.f10168a.u = false;
                this.f10168a.v = false;
                this.f10168a.B();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements d.a.i0.a.i.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AdVideoView f10169a;

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
            this.f10169a = adVideoView;
        }

        @Override // d.a.i0.a.i.b
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, surfaceHolder) == null) {
                this.f10169a.F = surfaceHolder;
                this.f10169a.v = true;
                this.f10169a.w();
            }
        }

        @Override // d.a.i0.a.i.b
        public void surfaceDestroy() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (this.f10169a.f10164g != null) {
                    this.f10169a.f10164g.onDestroyed();
                }
                this.f10169a.u = false;
                this.f10169a.v = false;
                this.f10169a.B();
            }
        }
    }

    /* loaded from: classes2.dex */
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
                    Context context2 = this.this$0.f10166i;
                    if (d.a.i0.a.k.c.a(context2, context2.getPackageName())) {
                        return;
                    }
                    this.this$0.w = true;
                    this.this$0.B();
                } else if ("android.intent.action.USER_PRESENT".equals(action)) {
                    this.this$0.w = false;
                    this.this$0.w();
                }
            }
        }

        public /* synthetic */ d(AdVideoView adVideoView, a aVar) {
            this(adVideoView);
        }
    }

    /* loaded from: classes2.dex */
    public static class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public SoftReference<AdVideoView> f10170e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f10171f;

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
            this.f10171f = false;
            this.f10170e = new SoftReference<>(adVideoView);
        }

        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.f10171f = z;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            SoftReference<AdVideoView> softReference;
            AdVideoView adVideoView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (softReference = this.f10170e) == null || (adVideoView = softReference.get()) == null) {
                return;
            }
            int currentPosition = adVideoView.getCurrentPosition();
            int duration = adVideoView.getDuration();
            if (adVideoView.j != null && duration > 0) {
                adVideoView.j.setProgress(currentPosition / duration);
            }
            if (this.f10171f) {
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
        this.k = -1;
        this.l = -16777216;
        this.m = false;
        this.n = 4;
        this.s = "";
        this.v = false;
        this.w = false;
        this.x = false;
        this.A = false;
        this.B = 1;
        this.C = false;
        this.E = new b(this);
        this.G = new c(this);
        this.f10166i = context;
        m();
    }

    public void A(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.z = 0;
            this.s = str;
            this.u = true;
            this.A = true;
            w();
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f10162e == null) {
            return;
        }
        x();
        this.y = true;
        this.x = false;
        this.f10162e.m(null);
        this.f10162e.t();
        this.f10162e.j();
        this.f10162e.i();
        this.f10162e = null;
        e eVar = this.o;
        if (eVar != null) {
            eVar.a(false);
        }
    }

    public final void C() {
        Context context;
        d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (context = this.f10166i) == null || (dVar = this.t) == null) {
            return;
        }
        try {
            context.unregisterReceiver(dVar);
            this.t = null;
        } catch (Throwable unused) {
            this.t = null;
        }
    }

    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            BaseMediaPlayer baseMediaPlayer = this.f10162e;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            BaseMediaPlayer baseMediaPlayer = this.f10162e;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.z : invokeV.intValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            removeAllViews();
            this.A = false;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            setBackgroundColor(Color.parseColor("#000000"));
            addView((View) this.p, layoutParams);
        }
    }

    public final void k(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            switch (i2) {
                case 256:
                    this.z = 0;
                    this.A = false;
                    l();
                    d.a.i0.a.i.a aVar = this.f10163f;
                    if (aVar != null) {
                        aVar.playCompletion();
                        return;
                    }
                    return;
                case 257:
                    this.A = false;
                    this.z = 0;
                    u();
                    return;
                case 258:
                    a.b bVar = this.f10165h;
                    if (bVar != null) {
                        bVar.onPrepared();
                    }
                    int i3 = this.z;
                    if (i3 > 0) {
                        this.f10162e.k(i3);
                    }
                    setVideoMute(this.r);
                    d.a.i0.a.i.c cVar = this.p;
                    if (cVar != null) {
                        cVar.onVideoSizeChanged(this.f10162e.d(), this.f10162e.c());
                    }
                    AdVideoProgressBar adVideoProgressBar = this.j;
                    if (adVideoProgressBar != null) {
                        adVideoProgressBar.setProgress(this.z / getDuration());
                        e eVar = this.o;
                        if (eVar != null) {
                            removeCallbacks(eVar);
                            this.o.a(true);
                            postDelayed(this.o, 200L);
                        }
                    }
                    if (this.u && h.e(this)) {
                        t();
                        return;
                    }
                    return;
                case 259:
                default:
                    return;
                case 260:
                    this.A = true;
                    l();
                    d.a.i0.a.i.a aVar2 = this.f10163f;
                    if (aVar2 != null) {
                        aVar2.renderingStart();
                        return;
                    }
                    return;
                case PlayerEvent.PLAY_LOADING_START /* 261 */:
                    z();
                    return;
                case PlayerEvent.PLAY_LOADING_END /* 262 */:
                    l();
                    return;
            }
        }
    }

    public final void l() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (view = this.q) == null) {
            return;
        }
        view.setVisibility(8);
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            o();
            q(false);
            j();
            p();
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && this.f10162e == null) {
            this.y = false;
            BaseMediaPlayer baseMediaPlayer = new BaseMediaPlayer(this.f10166i);
            this.f10162e = baseMediaPlayer;
            baseMediaPlayer.m(new a(this));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onAttachedToWindow();
            v();
        }
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, configuration) == null) {
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onDetachedFromWindow();
            C();
            B();
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            if (this.m) {
                AdVideoProgressBar adVideoProgressBar = new AdVideoProgressBar(this.f10166i);
                this.j = adVideoProgressBar;
                adVideoProgressBar.setProgressColor(this.k);
                this.j.setProgressBackgroundColor(this.l);
                this.j.setProgressHeight(this.n);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.n);
                layoutParams.addRule(12);
                addView(this.j, layoutParams);
                this.j.setProgress(0.0f);
                this.j.setVisibility(4);
                this.o = new e(this);
                return;
            }
            AdVideoProgressBar adVideoProgressBar2 = this.j;
            if (adVideoProgressBar2 != null) {
                adVideoProgressBar2.setVisibility(8);
            }
        }
    }

    public final void q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            if (z) {
                this.C = true;
                this.p = new BaseSurfaceView(this.f10166i, this.G);
            } else if (Build.VERSION.SDK_INT >= 14) {
                this.C = false;
                this.p = new BaseTextureView(this.f10166i, this.E);
            } else {
                this.C = true;
                this.p = new BaseSurfaceView(this.f10166i, this.G);
            }
            this.p.setDisplayMode(this.B);
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.u = false;
            BaseMediaPlayer baseMediaPlayer = this.f10162e;
            if (baseMediaPlayer == null || baseMediaPlayer.f10176i == BaseMediaPlayer.State.PLAYBACKCOMPLETED) {
                return;
            }
            baseMediaPlayer.g();
            d.a.i0.a.i.a aVar = this.f10163f;
            if (aVar != null) {
                aVar.playPause();
            }
            x();
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.u = true;
            w();
        }
    }

    public void setAdVideoViewListener(d.a.i0.a.i.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, aVar) == null) {
            this.f10163f = aVar;
        }
    }

    public void setDestroyedListener(a.InterfaceC0612a interfaceC0612a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, interfaceC0612a) == null) {
            this.f10164g = interfaceC0612a;
        }
    }

    public void setDisplayMode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i2) == null) {
            this.B = i2;
        }
    }

    public void setPreparedListener(a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, bVar) == null) {
            this.f10165h = bVar;
        }
    }

    public void setProgressBar(boolean z, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            this.m = z;
            this.l = i2;
            this.k = i3;
            this.n = h.a(getContext(), i4);
        }
    }

    public void setProgressBarVisibility(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048600, this, i2) == null) && this.m) {
            this.j.setVisibility(i2);
        }
    }

    public void setVideoMute(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            this.r = z;
            if (z) {
                y(0.0f, 0.0f);
            } else {
                y(1.0f, 1.0f);
            }
        }
    }

    public void setVideoUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, str) == null) {
            this.s = str;
            if (TextUtils.isEmpty(str)) {
                u();
                return;
            }
            BaseMediaPlayer baseMediaPlayer = this.f10162e;
            if (baseMediaPlayer != null) {
                baseMediaPlayer.p(str);
            }
        }
    }

    public final void t() {
        BaseMediaPlayer baseMediaPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048603, this) == null) || (baseMediaPlayer = this.f10162e) == null) {
            return;
        }
        if (this.C) {
            baseMediaPlayer.l(this.F);
            this.f10162e.n(true);
        } else {
            baseMediaPlayer.o(this.D);
            this.f10162e.r(this.f10166i, 10);
        }
        this.f10162e.s();
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            d.a.i0.a.i.a aVar = this.f10163f;
            if (aVar != null) {
                aVar.playFailure();
            }
            l();
            B();
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            if (this.f10166i == null || this.t != null) {
                return;
            }
            d dVar = new d(this, null);
            this.t = dVar;
            this.f10166i.registerReceiver(dVar, intentFilter);
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048606, this) == null) && !TextUtils.isEmpty(this.s) && this.u && this.v) {
            Context context = this.f10166i;
            if ((d.a.i0.a.k.c.a(context, context.getPackageName()) || !this.w) && this.A) {
                d.a.i0.a.i.a aVar = this.f10163f;
                if (aVar != null) {
                    aVar.playResume();
                }
                if (!this.y) {
                    t();
                } else if (this.x) {
                } else {
                    B();
                    this.x = true;
                    o();
                    setVideoUrl(this.s);
                    t();
                }
            }
        }
    }

    public final void x() {
        BaseMediaPlayer baseMediaPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048607, this) == null) || (baseMediaPlayer = this.f10162e) == null) {
            return;
        }
        this.z = baseMediaPlayer.a();
    }

    public final void y(float f2, float f3) {
        BaseMediaPlayer baseMediaPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048608, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) || (baseMediaPlayer = this.f10162e) == null) {
            return;
        }
        baseMediaPlayer.q(f2, f3);
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            View view = this.q;
            if (view == null) {
                this.q = new ProgressBar(this.f10166i);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(13);
                this.q.setLayoutParams(layoutParams);
                addView(this.q);
                return;
            }
            view.setVisibility(0);
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
        this.k = -1;
        this.l = -16777216;
        this.m = false;
        this.n = 4;
        this.s = "";
        this.v = false;
        this.w = false;
        this.x = false;
        this.A = false;
        this.B = 1;
        this.C = false;
        this.E = new b(this);
        this.G = new c(this);
        this.f10166i = context;
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
        this.k = -1;
        this.l = -16777216;
        this.m = false;
        this.n = 4;
        this.s = "";
        this.v = false;
        this.w = false;
        this.x = false;
        this.A = false;
        this.B = 1;
        this.C = false;
        this.E = new b(this);
        this.G = new c(this);
        this.f10166i = context;
        m();
    }
}

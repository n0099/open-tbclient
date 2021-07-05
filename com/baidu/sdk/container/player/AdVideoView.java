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
import d.a.k0.a.i.a;
import d.a.k0.a.k.h;
import java.lang.ref.SoftReference;
/* loaded from: classes3.dex */
public class AdVideoView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public int B;
    public boolean C;
    public Surface D;
    public d.a.k0.a.i.d E;
    public SurfaceHolder F;
    public d.a.k0.a.i.b G;

    /* renamed from: e  reason: collision with root package name */
    public BaseMediaPlayer f10119e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.k0.a.i.a f10120f;

    /* renamed from: g  reason: collision with root package name */
    public a.InterfaceC0660a f10121g;

    /* renamed from: h  reason: collision with root package name */
    public a.b f10122h;

    /* renamed from: i  reason: collision with root package name */
    public Context f10123i;
    public AdVideoProgressBar j;
    public int k;
    public int l;
    public boolean m;
    public int n;
    public e o;
    public d.a.k0.a.i.c p;
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

    /* loaded from: classes3.dex */
    public class a implements d.a.k0.a.i.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AdVideoView f10124a;

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
            this.f10124a = adVideoView;
        }

        @Override // d.a.k0.a.i.e
        public void playStateChanged(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.f10124a.k(i2);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.a.k0.a.i.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AdVideoView f10125a;

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
            this.f10125a = adVideoView;
        }

        @Override // d.a.k0.a.i.d
        public void surfaceCreated(Surface surface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, surface) == null) {
                this.f10125a.D = surface;
                this.f10125a.v = true;
                this.f10125a.w();
            }
        }

        @Override // d.a.k0.a.i.d
        public void surfaceDestroy() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (this.f10125a.f10121g != null) {
                    this.f10125a.f10121g.onDestroyed();
                }
                this.f10125a.u = false;
                this.f10125a.v = false;
                this.f10125a.B();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements d.a.k0.a.i.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AdVideoView f10126a;

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
            this.f10126a = adVideoView;
        }

        @Override // d.a.k0.a.i.b
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, surfaceHolder) == null) {
                this.f10126a.F = surfaceHolder;
                this.f10126a.v = true;
                this.f10126a.w();
            }
        }

        @Override // d.a.k0.a.i.b
        public void surfaceDestroy() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (this.f10126a.f10121g != null) {
                    this.f10126a.f10121g.onDestroyed();
                }
                this.f10126a.u = false;
                this.f10126a.v = false;
                this.f10126a.B();
            }
        }
    }

    /* loaded from: classes3.dex */
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
                    Context context2 = this.this$0.f10123i;
                    if (d.a.k0.a.k.c.a(context2, context2.getPackageName())) {
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

    /* loaded from: classes3.dex */
    public static class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public SoftReference<AdVideoView> f10127e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f10128f;

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
            this.f10128f = false;
            this.f10127e = new SoftReference<>(adVideoView);
        }

        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.f10128f = z;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            SoftReference<AdVideoView> softReference;
            AdVideoView adVideoView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (softReference = this.f10127e) == null || (adVideoView = softReference.get()) == null) {
                return;
            }
            int currentPosition = adVideoView.getCurrentPosition();
            int duration = adVideoView.getDuration();
            if (adVideoView.j != null && duration > 0) {
                adVideoView.j.setProgress(currentPosition / duration);
            }
            if (this.f10128f) {
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
        this.f10123i = context;
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
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f10119e == null) {
            return;
        }
        x();
        this.y = true;
        this.x = false;
        this.f10119e.m(null);
        this.f10119e.t();
        this.f10119e.j();
        this.f10119e.i();
        this.f10119e = null;
        e eVar = this.o;
        if (eVar != null) {
            eVar.a(false);
        }
    }

    public final void C() {
        Context context;
        d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (context = this.f10123i) == null || (dVar = this.t) == null) {
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
            BaseMediaPlayer baseMediaPlayer = this.f10119e;
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
            BaseMediaPlayer baseMediaPlayer = this.f10119e;
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
                    d.a.k0.a.i.a aVar = this.f10120f;
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
                    a.b bVar = this.f10122h;
                    if (bVar != null) {
                        bVar.onPrepared();
                    }
                    int i3 = this.z;
                    if (i3 > 0) {
                        this.f10119e.k(i3);
                    }
                    setVideoMute(this.r);
                    d.a.k0.a.i.c cVar = this.p;
                    if (cVar != null) {
                        cVar.onVideoSizeChanged(this.f10119e.d(), this.f10119e.c());
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
                    d.a.k0.a.i.a aVar2 = this.f10120f;
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
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && this.f10119e == null) {
            this.y = false;
            BaseMediaPlayer baseMediaPlayer = new BaseMediaPlayer(this.f10123i);
            this.f10119e = baseMediaPlayer;
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
                AdVideoProgressBar adVideoProgressBar = new AdVideoProgressBar(this.f10123i);
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
                this.p = new BaseSurfaceView(this.f10123i, this.G);
            } else if (Build.VERSION.SDK_INT >= 14) {
                this.C = false;
                this.p = new BaseTextureView(this.f10123i, this.E);
            } else {
                this.C = true;
                this.p = new BaseSurfaceView(this.f10123i, this.G);
            }
            this.p.setDisplayMode(this.B);
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.u = false;
            BaseMediaPlayer baseMediaPlayer = this.f10119e;
            if (baseMediaPlayer == null || baseMediaPlayer.f10133i == BaseMediaPlayer.State.PLAYBACKCOMPLETED) {
                return;
            }
            baseMediaPlayer.g();
            d.a.k0.a.i.a aVar = this.f10120f;
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

    public void setAdVideoViewListener(d.a.k0.a.i.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, aVar) == null) {
            this.f10120f = aVar;
        }
    }

    public void setDestroyedListener(a.InterfaceC0660a interfaceC0660a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, interfaceC0660a) == null) {
            this.f10121g = interfaceC0660a;
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
            this.f10122h = bVar;
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
            BaseMediaPlayer baseMediaPlayer = this.f10119e;
            if (baseMediaPlayer != null) {
                baseMediaPlayer.p(str);
            }
        }
    }

    public final void t() {
        BaseMediaPlayer baseMediaPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048603, this) == null) || (baseMediaPlayer = this.f10119e) == null) {
            return;
        }
        if (this.C) {
            baseMediaPlayer.l(this.F);
            this.f10119e.n(true);
        } else {
            baseMediaPlayer.o(this.D);
            this.f10119e.r(this.f10123i, 10);
        }
        this.f10119e.s();
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            d.a.k0.a.i.a aVar = this.f10120f;
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
            if (this.f10123i == null || this.t != null) {
                return;
            }
            d dVar = new d(this, null);
            this.t = dVar;
            this.f10123i.registerReceiver(dVar, intentFilter);
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048606, this) == null) && !TextUtils.isEmpty(this.s) && this.u && this.v) {
            Context context = this.f10123i;
            if ((d.a.k0.a.k.c.a(context, context.getPackageName()) || !this.w) && this.A) {
                d.a.k0.a.i.a aVar = this.f10120f;
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
        if (!(interceptable == null || interceptable.invokeV(1048607, this) == null) || (baseMediaPlayer = this.f10119e) == null) {
            return;
        }
        this.z = baseMediaPlayer.a();
    }

    public final void y(float f2, float f3) {
        BaseMediaPlayer baseMediaPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048608, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) || (baseMediaPlayer = this.f10119e) == null) {
            return;
        }
        baseMediaPlayer.q(f2, f3);
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            View view = this.q;
            if (view == null) {
                this.q = new ProgressBar(this.f10123i);
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
        this.f10123i = context;
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
        this.f10123i = context;
        m();
    }
}

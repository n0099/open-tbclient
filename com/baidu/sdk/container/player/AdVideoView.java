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
import c.a.a0.h0.f;
import c.a.a0.h0.t;
import c.a.i0.a.j.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sdk.container.player.BaseMediaPlayer;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.titan.sdk.verifier.ApkSignatureSchemeV2Verifier;
import com.kuaishou.weapon.un.w0;
import java.lang.ref.SoftReference;
/* loaded from: classes4.dex */
public class AdVideoView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.i0.a.j.d A;
    public SurfaceHolder B;
    public c.a.i0.a.j.b C;
    public BaseMediaPlayer a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.i0.a.j.a f28624b;

    /* renamed from: c  reason: collision with root package name */
    public a.InterfaceC0155a f28625c;

    /* renamed from: d  reason: collision with root package name */
    public a.b f28626d;

    /* renamed from: e  reason: collision with root package name */
    public Context f28627e;

    /* renamed from: f  reason: collision with root package name */
    public AdVideoProgressBar f28628f;

    /* renamed from: g  reason: collision with root package name */
    public int f28629g;

    /* renamed from: h  reason: collision with root package name */
    public int f28630h;
    public boolean i;
    public int j;
    public e k;
    public c.a.i0.a.j.c l;
    public View m;
    public boolean n;
    public String o;
    public d p;
    public boolean q;
    public boolean r;
    public boolean s;
    public boolean t;
    public boolean u;
    public int v;
    public boolean w;
    public int x;
    public boolean y;
    public Surface z;

    /* loaded from: classes4.dex */
    public class a implements c.a.i0.a.j.e {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = adVideoView;
        }

        @Override // c.a.i0.a.j.e
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.a.k(i);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements c.a.i0.a.j.d {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = adVideoView;
        }

        @Override // c.a.i0.a.j.d
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.f28625c != null) {
                    this.a.f28625c.a();
                }
                this.a.q = false;
                this.a.r = false;
                this.a.B();
            }
        }

        @Override // c.a.i0.a.j.d
        public void b(Surface surface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, surface) == null) {
                this.a.z = surface;
                this.a.r = true;
                this.a.w();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements c.a.i0.a.j.b {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = adVideoView;
        }

        @Override // c.a.i0.a.j.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.f28625c != null) {
                    this.a.f28625c.a();
                }
                this.a.q = false;
                this.a.r = false;
                this.a.B();
            }
        }

        @Override // c.a.i0.a.j.b
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, surfaceHolder) == null) {
                this.a.B = surfaceHolder;
                this.a.r = true;
                this.a.w();
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                    Context context2 = this.this$0.f28627e;
                    if (c.a.a0.h0.b.d(context2, context2.getPackageName())) {
                        return;
                    }
                    this.this$0.s = true;
                    this.this$0.B();
                } else if ("android.intent.action.USER_PRESENT".equals(action)) {
                    this.this$0.s = false;
                    this.this$0.w();
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
        public SoftReference<AdVideoView> a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f28631b;

        public e(AdVideoView adVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adVideoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f28631b = false;
            this.a = new SoftReference<>(adVideoView);
        }

        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.f28631b = z;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            SoftReference<AdVideoView> softReference;
            AdVideoView adVideoView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (softReference = this.a) == null || (adVideoView = softReference.get()) == null) {
                return;
            }
            int currentPosition = adVideoView.getCurrentPosition();
            int duration = adVideoView.getDuration();
            if (adVideoView.f28628f != null && duration > 0) {
                adVideoView.f28628f.setProgress(currentPosition / duration);
            }
            if (this.f28631b) {
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f28629g = -1;
        this.f28630h = -16777216;
        this.i = false;
        this.j = 4;
        this.o = "";
        this.r = false;
        this.s = false;
        this.t = false;
        this.w = false;
        this.x = 1;
        this.y = false;
        this.A = new b(this);
        this.C = new c(this);
        this.f28627e = context;
        m();
    }

    public void A(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.v = 0;
            this.o = str;
            this.q = true;
            this.w = true;
            w();
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.a == null) {
            return;
        }
        x();
        this.u = true;
        this.t = false;
        this.a.m(null);
        this.a.t();
        this.a.j();
        this.a.i();
        this.a = null;
        e eVar = this.k;
        if (eVar != null) {
            eVar.a(false);
        }
    }

    public final void C() {
        Context context;
        d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (context = this.f28627e) == null || (dVar = this.p) == null) {
            return;
        }
        try {
            context.unregisterReceiver(dVar);
            this.p = null;
        } catch (Throwable unused) {
            this.p = null;
        }
    }

    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            BaseMediaPlayer baseMediaPlayer = this.a;
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
            BaseMediaPlayer baseMediaPlayer = this.a;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.v : invokeV.intValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            removeAllViews();
            this.w = false;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            setBackgroundColor(Color.parseColor("#000000"));
            addView((View) this.l, layoutParams);
        }
    }

    public final void k(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            switch (i) {
                case 256:
                    this.v = 0;
                    this.w = false;
                    l();
                    c.a.i0.a.j.a aVar = this.f28624b;
                    if (aVar != null) {
                        aVar.d();
                        return;
                    }
                    return;
                case 257:
                    this.w = false;
                    this.v = 0;
                    u();
                    return;
                case ApkSignatureSchemeV2Verifier.SIGNATURE_RSA_PSS_WITH_SHA512 /* 258 */:
                    a.b bVar = this.f28626d;
                    if (bVar != null) {
                        bVar.onPrepared();
                    }
                    int i2 = this.v;
                    if (i2 > 0) {
                        this.a.k(i2);
                    }
                    setVideoMute(this.n);
                    c.a.i0.a.j.c cVar = this.l;
                    if (cVar != null) {
                        cVar.onVideoSizeChanged(this.a.d(), this.a.c());
                    }
                    AdVideoProgressBar adVideoProgressBar = this.f28628f;
                    if (adVideoProgressBar != null) {
                        adVideoProgressBar.setProgress(this.v / getDuration());
                        e eVar = this.k;
                        if (eVar != null) {
                            removeCallbacks(eVar);
                            this.k.a(true);
                            postDelayed(this.k, 200L);
                        }
                    }
                    if (this.q && t.c(this)) {
                        t();
                        return;
                    }
                    return;
                case ApkSignatureSchemeV2Verifier.SIGNATURE_RSA_PKCS1_V1_5_WITH_SHA256 /* 259 */:
                default:
                    return;
                case 260:
                    this.w = true;
                    l();
                    c.a.i0.a.j.a aVar2 = this.f28624b;
                    if (aVar2 != null) {
                        aVar2.e();
                        return;
                    }
                    return;
                case w0.F /* 261 */:
                    z();
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
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (view = this.m) == null) {
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
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && this.a == null) {
            this.u = false;
            BaseMediaPlayer baseMediaPlayer = new BaseMediaPlayer(this.f28627e);
            this.a = baseMediaPlayer;
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
            if (this.i) {
                AdVideoProgressBar adVideoProgressBar = new AdVideoProgressBar(this.f28627e);
                this.f28628f = adVideoProgressBar;
                adVideoProgressBar.setProgressColor(this.f28629g);
                this.f28628f.setProgressBackgroundColor(this.f28630h);
                this.f28628f.setProgressHeight(this.j);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.j);
                layoutParams.addRule(12);
                addView(this.f28628f, layoutParams);
                this.f28628f.setProgress(0.0f);
                this.f28628f.setVisibility(4);
                this.k = new e(this);
                return;
            }
            AdVideoProgressBar adVideoProgressBar2 = this.f28628f;
            if (adVideoProgressBar2 != null) {
                adVideoProgressBar2.setVisibility(8);
            }
        }
    }

    public final void q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            if (z) {
                this.y = true;
                this.l = new BaseSurfaceView(this.f28627e, this.C);
            } else if (Build.VERSION.SDK_INT >= 14) {
                this.y = false;
                this.l = new BaseTextureView(this.f28627e, this.A);
            } else {
                this.y = true;
                this.l = new BaseSurfaceView(this.f28627e, this.C);
            }
            this.l.setDisplayMode(this.x);
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.q = false;
            BaseMediaPlayer baseMediaPlayer = this.a;
            if (baseMediaPlayer == null || baseMediaPlayer.f28635e == BaseMediaPlayer.State.PLAYBACKCOMPLETED) {
                return;
            }
            baseMediaPlayer.g();
            c.a.i0.a.j.a aVar = this.f28624b;
            if (aVar != null) {
                aVar.b();
            }
            x();
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.q = true;
            w();
        }
    }

    public void setAdVideoViewListener(c.a.i0.a.j.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, aVar) == null) {
            this.f28624b = aVar;
        }
    }

    public void setDestroyedListener(a.InterfaceC0155a interfaceC0155a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, interfaceC0155a) == null) {
            this.f28625c = interfaceC0155a;
        }
    }

    public void setDisplayMode(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i) == null) {
            this.x = i;
        }
    }

    public void setPreparedListener(a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, bVar) == null) {
            this.f28626d = bVar;
        }
    }

    public void setProgressBar(boolean z, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            this.i = z;
            this.f28630h = i;
            this.f28629g = i2;
            this.j = f.c.a(getContext(), i3);
        }
    }

    public void setProgressBarVisibility(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048600, this, i) == null) && this.i) {
            this.f28628f.setVisibility(i);
        }
    }

    public void setVideoMute(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            this.n = z;
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
            this.o = str;
            if (TextUtils.isEmpty(str)) {
                u();
                return;
            }
            BaseMediaPlayer baseMediaPlayer = this.a;
            if (baseMediaPlayer != null) {
                baseMediaPlayer.p(str);
            }
        }
    }

    public final void t() {
        BaseMediaPlayer baseMediaPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048603, this) == null) || (baseMediaPlayer = this.a) == null) {
            return;
        }
        if (this.y) {
            baseMediaPlayer.l(this.B);
            this.a.n(true);
        } else {
            baseMediaPlayer.o(this.z);
            this.a.r(this.f28627e, 10);
        }
        this.a.s();
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            c.a.i0.a.j.a aVar = this.f28624b;
            if (aVar != null) {
                aVar.a();
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
            if (this.f28627e == null || this.p != null) {
                return;
            }
            d dVar = new d(this, null);
            this.p = dVar;
            this.f28627e.registerReceiver(dVar, intentFilter);
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048606, this) == null) && !TextUtils.isEmpty(this.o) && this.q && this.r) {
            Context context = this.f28627e;
            if ((c.a.a0.h0.b.d(context, context.getPackageName()) || !this.s) && this.w) {
                c.a.i0.a.j.a aVar = this.f28624b;
                if (aVar != null) {
                    aVar.c();
                }
                if (!this.u) {
                    t();
                } else if (this.t) {
                } else {
                    B();
                    this.t = true;
                    o();
                    setVideoUrl(this.o);
                    t();
                }
            }
        }
    }

    public final void x() {
        BaseMediaPlayer baseMediaPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048607, this) == null) || (baseMediaPlayer = this.a) == null) {
            return;
        }
        this.v = baseMediaPlayer.a();
    }

    public final void y(float f2, float f3) {
        BaseMediaPlayer baseMediaPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048608, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) || (baseMediaPlayer = this.a) == null) {
            return;
        }
        baseMediaPlayer.q(f2, f3);
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            View view = this.m;
            if (view == null) {
                this.m = new ProgressBar(this.f28627e);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(13);
                this.m.setLayoutParams(layoutParams);
                addView(this.m);
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
        this.f28629g = -1;
        this.f28630h = -16777216;
        this.i = false;
        this.j = 4;
        this.o = "";
        this.r = false;
        this.s = false;
        this.t = false;
        this.w = false;
        this.x = 1;
        this.y = false;
        this.A = new b(this);
        this.C = new c(this);
        this.f28627e = context;
        m();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdVideoView(Context context, AttributeSet attributeSet, int i) {
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
        this.f28629g = -1;
        this.f28630h = -16777216;
        this.i = false;
        this.j = 4;
        this.o = "";
        this.r = false;
        this.s = false;
        this.t = false;
        this.w = false;
        this.x = 1;
        this.y = false;
        this.A = new b(this);
        this.C = new c(this);
        this.f28627e = context;
        m();
    }
}

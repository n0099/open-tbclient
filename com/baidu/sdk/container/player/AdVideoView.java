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
import com.baidu.sdk.container.player.BaseMediaPlayer;
import com.baidu.tieba.am1;
import com.baidu.tieba.b51;
import com.baidu.tieba.u51;
import com.baidu.tieba.v41;
import com.baidu.tieba.wl1;
import com.baidu.tieba.xl1;
import com.baidu.tieba.yl1;
import com.baidu.tieba.zl1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.titan.sdk.verifier.ApkSignatureSchemeV2Verifier;
import java.lang.ref.SoftReference;
/* loaded from: classes2.dex */
public class AdVideoView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public zl1 A;
    public SurfaceHolder B;
    public xl1 C;
    public BaseMediaPlayer a;
    public wl1 b;
    public wl1.a c;
    public wl1.b d;
    public Context e;
    public AdVideoProgressBar f;
    public int g;
    public int h;
    public boolean i;
    public int j;
    public e k;
    public yl1 l;
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

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
        }
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, configuration) == null) {
        }
    }

    /* loaded from: classes2.dex */
    public class a implements am1 {
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

        @Override // com.baidu.tieba.am1
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeI(1048576, this, i) != null) {
                return;
            }
            this.a.k(i);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements zl1 {
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

        @Override // com.baidu.tieba.zl1
        public void b(Surface surface) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, surface) != null) {
                return;
            }
            this.a.z = surface;
            this.a.r = true;
            this.a.w();
        }

        @Override // com.baidu.tieba.zl1
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.c != null) {
                    this.a.c.a();
                }
                this.a.q = false;
                this.a.r = false;
                this.a.B();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements xl1 {
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

        @Override // com.baidu.tieba.xl1
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, surfaceHolder) != null) {
                return;
            }
            this.a.B = surfaceHolder;
            this.a.r = true;
            this.a.w();
        }

        @Override // com.baidu.tieba.xl1
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.c != null) {
                    this.a.c.a();
                }
                this.a.q = false;
                this.a.r = false;
                this.a.B();
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

        public /* synthetic */ d(AdVideoView adVideoView, a aVar) {
            this(adVideoView);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) {
                String action = intent.getAction();
                if ("android.intent.action.SCREEN_OFF".equals(action)) {
                    Context context2 = this.this$0.e;
                    if (v41.d(context2, context2.getPackageName())) {
                        return;
                    }
                    this.this$0.s = true;
                    this.this$0.B();
                } else if (!"android.intent.action.USER_PRESENT".equals(action)) {
                } else {
                    this.this$0.s = false;
                    this.this$0.w();
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public SoftReference<AdVideoView> a;
        public boolean b;

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
            this.b = false;
            this.a = new SoftReference<>(adVideoView);
        }

        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.b = z;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            SoftReference<AdVideoView> softReference;
            AdVideoView adVideoView;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (softReference = this.a) != null && (adVideoView = softReference.get()) != null) {
                int currentPosition = adVideoView.getCurrentPosition();
                int duration = adVideoView.getDuration();
                if (adVideoView.f != null && duration > 0) {
                    adVideoView.f.setProgress(currentPosition / duration);
                }
                if (this.b) {
                    adVideoView.postDelayed(this, 200L);
                }
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
        this.g = -1;
        this.h = -16777216;
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
        this.e = context;
        m();
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
        this.g = -1;
        this.h = -16777216;
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
        this.e = context;
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
        this.g = -1;
        this.h = -16777216;
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
        this.e = context;
        m();
    }

    public final void y(float f, float f2) {
        BaseMediaPlayer baseMediaPlayer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048608, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)}) == null) && (baseMediaPlayer = this.a) != null) {
            baseMediaPlayer.q(f, f2);
        }
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

    public void setAdVideoViewListener(wl1 wl1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, wl1Var) == null) {
            this.b = wl1Var;
        }
    }

    public void setDestroyedListener(wl1.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, aVar) == null) {
            this.c = aVar;
        }
    }

    public void setDisplayMode(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i) == null) {
            this.x = i;
        }
    }

    public void setPreparedListener(wl1.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, bVar) == null) {
            this.d = bVar;
        }
    }

    public void setProgressBarVisibility(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048600, this, i) == null) && this.i) {
            this.f.setVisibility(i);
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

    public void B() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.a != null) {
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
    }

    public final void t() {
        BaseMediaPlayer baseMediaPlayer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048603, this) == null) && (baseMediaPlayer = this.a) != null) {
            if (this.y) {
                baseMediaPlayer.l(this.B);
                this.a.n(true);
            } else {
                baseMediaPlayer.o(this.z);
                this.a.r(this.e, 10);
            }
            this.a.s();
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            if (this.e != null && this.p == null) {
                d dVar = new d(this, null);
                this.p = dVar;
                this.e.registerReceiver(dVar, intentFilter);
            }
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            View view2 = this.m;
            if (view2 == null) {
                this.m = new ProgressBar(this.e);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(13);
                this.m.setLayoutParams(layoutParams);
                addView(this.m);
                return;
            }
            view2.setVisibility(0);
        }
    }

    public final void C() {
        Context context;
        d dVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (context = this.e) != null && (dVar = this.p) != null) {
            try {
                context.unregisterReceiver(dVar);
                this.p = null;
            } catch (Throwable unused) {
                this.p = null;
            }
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.v;
        }
        return invokeV.intValue;
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

    public final void l() {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (view2 = this.m) != null) {
            view2.setVisibility(8);
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
            BaseMediaPlayer baseMediaPlayer = new BaseMediaPlayer(this.e);
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

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onDetachedFromWindow();
            C();
            B();
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.q = false;
            BaseMediaPlayer baseMediaPlayer = this.a;
            if (baseMediaPlayer != null && baseMediaPlayer.e != BaseMediaPlayer.State.PLAYBACKCOMPLETED) {
                baseMediaPlayer.g();
                wl1 wl1Var = this.b;
                if (wl1Var != null) {
                    wl1Var.b();
                }
                x();
            }
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.q = true;
            w();
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            wl1 wl1Var = this.b;
            if (wl1Var != null) {
                wl1Var.a();
            }
            l();
            B();
        }
    }

    public final void x() {
        BaseMediaPlayer baseMediaPlayer;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048607, this) != null) || (baseMediaPlayer = this.a) == null) {
            return;
        }
        this.v = baseMediaPlayer.a();
    }

    public final void k(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            switch (i) {
                case 256:
                    this.v = 0;
                    this.w = false;
                    l();
                    wl1 wl1Var = this.b;
                    if (wl1Var != null) {
                        wl1Var.d();
                        return;
                    }
                    return;
                case 257:
                    this.w = false;
                    this.v = 0;
                    u();
                    return;
                case ApkSignatureSchemeV2Verifier.SIGNATURE_RSA_PSS_WITH_SHA512 /* 258 */:
                    wl1.b bVar = this.d;
                    if (bVar != null) {
                        bVar.onPrepared();
                    }
                    int i2 = this.v;
                    if (i2 > 0) {
                        this.a.k(i2);
                    }
                    setVideoMute(this.n);
                    yl1 yl1Var = this.l;
                    if (yl1Var != null) {
                        yl1Var.onVideoSizeChanged(this.a.d(), this.a.c());
                    }
                    AdVideoProgressBar adVideoProgressBar = this.f;
                    if (adVideoProgressBar != null) {
                        adVideoProgressBar.setProgress(this.v / getDuration());
                        e eVar = this.k;
                        if (eVar != null) {
                            removeCallbacks(eVar);
                            this.k.a(true);
                            postDelayed(this.k, 200L);
                        }
                    }
                    if (this.q && u51.c(this)) {
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
                    wl1 wl1Var2 = this.b;
                    if (wl1Var2 != null) {
                        wl1Var2.e();
                        return;
                    }
                    return;
                case 261:
                    z();
                    return;
                case 262:
                    l();
                    return;
            }
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            if (this.i) {
                AdVideoProgressBar adVideoProgressBar = new AdVideoProgressBar(this.e);
                this.f = adVideoProgressBar;
                adVideoProgressBar.setProgressColor(this.g);
                this.f.setProgressBackgroundColor(this.h);
                this.f.setProgressHeight(this.j);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.j);
                layoutParams.addRule(12);
                addView(this.f, layoutParams);
                this.f.setProgress(0.0f);
                this.f.setVisibility(4);
                this.k = new e(this);
                return;
            }
            AdVideoProgressBar adVideoProgressBar2 = this.f;
            if (adVideoProgressBar2 != null) {
                adVideoProgressBar2.setVisibility(8);
            }
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048606, this) == null) && !TextUtils.isEmpty(this.o) && this.q && this.r) {
            Context context = this.e;
            if ((v41.d(context, context.getPackageName()) || !this.s) && this.w) {
                wl1 wl1Var = this.b;
                if (wl1Var != null) {
                    wl1Var.c();
                }
                if (!this.u) {
                    t();
                } else if (!this.t) {
                    B();
                    this.t = true;
                    o();
                    setVideoUrl(this.o);
                    t();
                }
            }
        }
    }

    public final void q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            if (z) {
                this.y = true;
                this.l = new BaseSurfaceView(this.e, this.C);
            } else if (Build.VERSION.SDK_INT >= 14) {
                this.y = false;
                this.l = new BaseTextureView(this.e, this.A);
            } else {
                this.y = true;
                this.l = new BaseSurfaceView(this.e, this.C);
            }
            this.l.setDisplayMode(this.x);
        }
    }

    public void setProgressBar(boolean z, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            this.i = z;
            this.h = i;
            this.g = i2;
            this.j = b51.c.a(getContext(), i3);
        }
    }
}

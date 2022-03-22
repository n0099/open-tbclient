package c.a.n0.h.a.l;

import android.content.Context;
import android.content.res.Resources;
import android.media.AudioManager;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.h.a.k.h;
import c.a.n0.h.a.k.i;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.game.ad.component.AdImageVIew;
import com.baidu.swan.game.ad.entity.AdElementInfo;
import com.baidu.swan.game.ad.view.InteractiveEndFrameView;
import com.baidu.swan.game.ad.view.RewardLoadWebView;
import com.baidu.swan.game.ad.view.RewardVideoView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public abstract class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.n0.h.a.h.c A;
    public boolean B;
    public Runnable C;
    public View.OnClickListener D;
    public View.OnClickListener E;
    public View.OnClickListener F;
    public RelativeLayout a;

    /* renamed from: b  reason: collision with root package name */
    public View f8404b;

    /* renamed from: c  reason: collision with root package name */
    public RewardVideoView f8405c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.n0.h.a.f.b.c f8406d;

    /* renamed from: e  reason: collision with root package name */
    public int f8407e;

    /* renamed from: f  reason: collision with root package name */
    public ProgressBar f8408f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f8409g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f8410h;
    public TextView i;
    public TextView j;
    public View k;
    public TextView l;
    public RelativeLayout m;
    public int n;
    public int o;
    public Context p;
    public AdElementInfo q;
    public final Handler r;
    public c.a.n0.h.a.e.d s;
    public RewardLoadWebView t;
    public RewardLoadWebView u;
    public InteractiveEndFrameView v;
    public Resources w;
    public c.a.n0.h.a.g.a x;
    public boolean y;
    public c.a.n0.h.a.e.e z;

    /* renamed from: c.a.n0.h.a.l.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class View$OnTouchListenerC0665a implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public View$OnTouchListenerC0665a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.f8406d == null) {
                return;
            }
            this.a.K();
            int currentPosition = this.a.f8406d.getCurrentPosition();
            a aVar = this.a;
            aVar.J(aVar.f8407e, currentPosition);
            int min = Math.min(currentPosition + 1000, this.a.f8407e);
            this.a.f8408f.setProgress(min / 1000);
            if (min < this.a.f8407e) {
                this.a.r.postDelayed(this.a.C, 100L);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public c(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.a.f8405c == null) {
                return;
            }
            if (this.a.f8405c.d()) {
                this.a.f8410h.setImageResource(R.drawable.obfuscated_res_0x7f080e2f);
                this.a.f8405c.e(false);
                return;
            }
            this.a.f8410h.setImageResource(R.drawable.obfuscated_res_0x7f080e2e);
            this.a.f8405c.e(true);
        }
    }

    /* loaded from: classes.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public d(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.a.s == null) {
                return;
            }
            this.a.s.e(view);
        }
    }

    /* loaded from: classes.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public e(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.a.z == null) {
                return;
            }
            this.a.z.f(view);
        }
    }

    /* loaded from: classes.dex */
    public class f implements RewardVideoView.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public f(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // com.baidu.swan.game.ad.view.RewardVideoView.a
        public void onVolumeChanged(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                int streamMinVolume = Build.VERSION.SDK_INT >= 28 ? ((AudioManager) this.a.p.getSystemService("audio")).getStreamMinVolume(3) : 0;
                if (i <= streamMinVolume || !this.a.f8405c.d()) {
                    if (i > streamMinVolume || this.a.f8405c.d()) {
                        return;
                    }
                    this.a.f8410h.setImageResource(R.drawable.obfuscated_res_0x7f080e2e);
                    this.a.f8405c.e(true);
                    return;
                }
                this.a.f8410h.setImageResource(R.drawable.obfuscated_res_0x7f080e2f);
                this.a.f8405c.e(false);
            }
        }
    }

    /* loaded from: classes.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;

        public g(a aVar, View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int n = c.a.n0.h.a.f.a.b().n();
                if (c.a.n0.h.a.f.a.b().u(this.a)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.a.getLayoutParams();
                    layoutParams.topMargin = this.a.getTop() + n;
                    this.a.setLayoutParams(layoutParams);
                }
            }
        }
    }

    public a(Context context, AdElementInfo adElementInfo, c.a.n0.h.a.g.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, adElementInfo, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.r = new Handler();
        this.B = false;
        this.C = new b(this);
        this.D = new c(this);
        this.E = new d(this);
        this.F = new e(this);
        this.p = context;
        this.q = adElementInfo;
        this.n = c.a.n0.h.a.f.a.b().q();
        this.o = c.a.n0.h.a.f.a.b().p();
        this.w = this.p.getResources();
        this.x = aVar;
        this.y = i.i();
        w();
        this.A = new c.a.n0.h.a.h.c(this.p);
        x(this.f8409g);
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            m();
            I();
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            m();
            I();
        }
    }

    public abstract void C(RelativeLayout relativeLayout, AdElementInfo adElementInfo);

    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            H();
        }
    }

    public void E(c.a.n0.h.a.e.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, dVar) == null) {
            this.s = dVar;
        }
    }

    public void F(c.a.n0.h.a.e.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, eVar) == null) {
            this.z = eVar;
        }
    }

    public void G(String str) {
        RewardVideoView rewardVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || (rewardVideoView = this.f8405c) == null) {
            return;
        }
        rewardVideoView.f(str);
    }

    public final void H() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.f8408f == null) {
            return;
        }
        this.r.removeCallbacksAndMessages(null);
        this.r.postDelayed(this.C, 0L);
    }

    public final void I() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.f8408f == null) {
            return;
        }
        this.r.removeCallbacksAndMessages(null);
    }

    public final void J(long j, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Long.valueOf(j), Integer.valueOf(i)}) == null) && this.y) {
            if (j <= 15000 || i > 15000) {
                this.j.setText(R.string.obfuscated_res_0x7f0f1302);
                this.i.setVisibility(0);
                this.k.setVisibility(0);
                this.j.setVisibility(0);
            } else if (i < 5000) {
                this.f8409g.setVisibility(8);
                this.j.setVisibility(8);
                this.k.setVisibility(8);
                this.i.setVisibility(8);
            } else if (i < 10000) {
                this.f8409g.setVisibility(0);
                this.j.setVisibility(0);
                this.k.setVisibility(8);
                this.i.setVisibility(8);
            } else {
                this.f8409g.setVisibility(0);
                this.j.setVisibility(0);
                this.k.setVisibility(0);
                this.i.setVisibility(0);
            }
        }
    }

    public final void K() {
        c.a.n0.h.a.f.b.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.q == null || (cVar = this.f8406d) == null) {
            return;
        }
        this.f8407e = cVar.getDuration();
        int min = Math.min(this.q.getRewardTime(), this.f8407e / 1000);
        int skipTime = this.q.getSkipTime();
        int currentPosition = this.f8406d.getCurrentPosition() / 1000;
        String string = this.p.getResources().getString(R.string.obfuscated_res_0x7f0f1304);
        String string2 = this.p.getResources().getString(R.string.obfuscated_res_0x7f0f1305);
        if (currentPosition <= min) {
            this.j.setText(String.format(string, Integer.valueOf(min - currentPosition)));
        } else {
            this.j.setText(String.format(string2, Integer.valueOf((this.f8407e / 1000) - currentPosition)));
        }
        if (currentPosition <= skipTime) {
            this.i.setVisibility(8);
            this.k.setVisibility(8);
            return;
        }
        this.i.setVisibility(0);
        this.k.setVisibility(0);
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            TextView textView = new TextView(this.p);
            this.l = textView;
            textView.setBackground(this.w.getDrawable(R.drawable.obfuscated_res_0x7f080e2b));
            this.l.setTextColor(this.w.getColor(R.color.obfuscated_res_0x7f06043f));
            this.l.setText(this.w.getString(R.string.obfuscated_res_0x7f0f03e3));
            this.l.setTextSize(2, 16.0f);
            this.l.setOnClickListener(this.E);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(h.a(96.0f), h.a(30.0f));
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            layoutParams.addRule(13);
            this.l.setGravity(17);
            layoutParams.setMargins(0, this.f8409g.getTop(), this.w.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070340), 0);
            this.a.addView(this.l, layoutParams);
            x(this.l);
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || this.a == null) {
            return;
        }
        this.B = true;
        this.f8409g.setVisibility(4);
        this.m.setVisibility(4);
        this.i.setVisibility(4);
        if (!TextUtils.isEmpty(this.q.getEndFrameUrl())) {
            InteractiveEndFrameView interactiveEndFrameView = new InteractiveEndFrameView(this.p);
            this.v = interactiveEndFrameView;
            interactiveEndFrameView.s(this.q, this.a);
            this.a.addView(this.v, new RelativeLayout.LayoutParams(-1, -1));
            c.a.n0.h.a.j.b.i(this.q, this.A);
        } else if (!TextUtils.isEmpty(this.q.getEndFrameHtml())) {
            RewardLoadWebView rewardLoadWebView = new RewardLoadWebView(this.p);
            this.u = rewardLoadWebView;
            rewardLoadWebView.b("reward_end_frame_html", this.q, this.x);
            this.a.addView(this.u, new RelativeLayout.LayoutParams(-1, -1));
            c.a.n0.h.a.j.b.i(this.q, this.A);
        } else {
            View inflate = LayoutInflater.from(this.p).inflate(R.layout.obfuscated_res_0x7f0d061c, (ViewGroup) null);
            this.a.addView(inflate, new RelativeLayout.LayoutParams(-1, -1));
            ((AdImageVIew) inflate.findViewById(R.id.obfuscated_res_0x7f091a84)).setImageUrl(this.q.getIconUrl());
            ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09202b)).setText(this.q.getTitle());
            ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090777)).setText(this.q.getDescription());
            Button button = (Button) inflate.findViewById(R.id.obfuscated_res_0x7f090816);
            if (this.q.getActionType() == 1) {
                button.setText(this.p.getResources().getString(R.string.obfuscated_res_0x7f0f10b8));
            }
            if (this.q.getActionType() == 2) {
                button.setText(this.p.getResources().getString(R.string.obfuscated_res_0x7f0f1249));
            }
            inflate.findViewById(R.id.obfuscated_res_0x7f0906e0).setOnClickListener(this.F);
            button.setOnClickListener(this.F);
        }
        l();
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            I();
            RewardLoadWebView rewardLoadWebView = this.t;
            if (rewardLoadWebView != null) {
                rewardLoadWebView.c();
                this.t = null;
            }
            RewardLoadWebView rewardLoadWebView2 = this.u;
            if (rewardLoadWebView2 != null) {
                rewardLoadWebView2.c();
                this.u = null;
            }
            InteractiveEndFrameView interactiveEndFrameView = this.v;
            if (interactiveEndFrameView != null) {
                interactiveEndFrameView.t();
                this.v = null;
            }
        }
    }

    public RewardVideoView.a o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? new f(this) : (RewardVideoView.a) invokeV.objValue;
    }

    public void p() {
        AdElementInfo adElementInfo;
        c.a.n0.h.a.f.b.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            H();
            ProgressBar progressBar = this.f8408f;
            if (progressBar != null && (cVar = this.f8406d) != null) {
                progressBar.setMax(cVar.getDuration() / 1000);
                this.f8408f.setVisibility(4);
            }
            if (this.j != null && this.f8406d != null && (adElementInfo = this.q) != null) {
                this.j.setText(String.format(this.p.getResources().getString(R.string.obfuscated_res_0x7f0f1304), Integer.valueOf(Math.max(this.q.getSkipTime(), Math.min(adElementInfo.getRewardTime(), this.f8406d.getDuration())) / 1000)));
                if (this.q.getSkipTime() >= 0) {
                    this.i.setVisibility(8);
                    this.k.setVisibility(8);
                }
            }
            if (this.f8409g.getVisibility() != 0) {
                this.f8409g.setVisibility(0);
            }
            if (this.m.getVisibility() != 0) {
                this.m.setAnimation(AnimationUtils.loadAnimation(this.p, R.anim.obfuscated_res_0x7f0100aa));
                this.m.setVisibility(0);
            }
            c.a.n0.h.a.f.b.c cVar2 = this.f8406d;
            if (cVar2 != null) {
                J(cVar2.getDuration(), this.f8406d.getCurrentPosition());
            }
        }
    }

    public abstract String q();

    public View r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f8404b : (View) invokeV.objValue;
    }

    public c.a.n0.h.a.f.b.c s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            RewardVideoView rewardVideoView = this.f8405c;
            if (rewardVideoView != null) {
                return rewardVideoView.getPlayer();
            }
            return null;
        }
        return (c.a.n0.h.a.f.b.c) invokeV.objValue;
    }

    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.B : invokeV.booleanValue;
    }

    public abstract View u();

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.a.setOnTouchListener(new View$OnTouchListenerC0665a(this));
            this.f8410h.setOnClickListener(this.D);
            this.i.setOnClickListener(this.E);
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.f8404b = u();
            this.f8404b.setLayoutParams(new RelativeLayout.LayoutParams(this.n, this.o));
            this.a = (RelativeLayout) this.f8404b.findViewById(R.id.obfuscated_res_0x7f091a88);
            RewardVideoView rewardVideoView = (RewardVideoView) this.f8404b.findViewById(R.id.obfuscated_res_0x7f09239d);
            this.f8405c = rewardVideoView;
            rewardVideoView.setVolumeChangeListener(o());
            if (this.y) {
                this.f8405c.setOnClickListener(this.F);
            }
            this.f8408f = (ProgressBar) this.f8404b.findViewById(R.id.obfuscated_res_0x7f091e1b);
            this.f8409g = (LinearLayout) this.f8404b.findViewById(R.id.obfuscated_res_0x7f09240f);
            this.f8410h = (ImageView) this.f8404b.findViewById(R.id.obfuscated_res_0x7f092410);
            if (this.f8405c.d()) {
                this.f8410h.setImageResource(R.drawable.obfuscated_res_0x7f080e2e);
            }
            this.i = (TextView) this.f8404b.findViewById(R.id.obfuscated_res_0x7f090663);
            this.j = (TextView) this.f8404b.findViewById(R.id.obfuscated_res_0x7f090666);
            this.k = this.f8404b.findViewById(R.id.obfuscated_res_0x7f090667);
            this.m = (RelativeLayout) this.f8404b.findViewById(R.id.obfuscated_res_0x7f0902f6);
            if (!TextUtils.isEmpty(this.q.getBannerHtml())) {
                this.t = new RewardLoadWebView(this.p);
                this.m.addView(this.t, new RelativeLayout.LayoutParams(-1, -1));
                C(this.m, this.q);
                this.t.b(q(), this.q, this.x);
            } else {
                View inflate = LayoutInflater.from(this.p).inflate(R.layout.obfuscated_res_0x7f0d061b, (ViewGroup) null);
                this.m.addView(inflate);
                ((AdImageVIew) inflate.findViewById(R.id.obfuscated_res_0x7f091a84)).setImageUrl(this.q.getIconUrl());
                ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09202b)).setText(this.q.getTitle());
                ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090777)).setText(this.q.getDescription());
                Button button = (Button) inflate.findViewById(R.id.obfuscated_res_0x7f090816);
                if (this.q.getActionType() == 1) {
                    button.setText(this.p.getResources().getString(R.string.obfuscated_res_0x7f0f10b8));
                }
                if (this.q.getActionType() == 2) {
                    button.setText(this.p.getResources().getString(R.string.obfuscated_res_0x7f0f1249));
                }
                this.m.setOnClickListener(this.F);
                button.setOnClickListener(this.F);
            }
            this.f8406d = this.f8405c.getPlayer();
            v();
        }
    }

    public final void x(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, view) == null) {
            view.post(new g(this, view));
        }
    }

    public void y() {
        c.a.n0.h.a.f.b.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048600, this) == null) || (cVar = this.f8406d) == null) {
            return;
        }
        this.f8407e = cVar.getDuration();
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            I();
        }
    }
}

package c.a.p0.h.a.l;

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
import c.a.p0.h.a.k.h;
import c.a.p0.h.a.k.i;
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
/* loaded from: classes2.dex */
public abstract class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.p0.h.a.h.c A;
    public boolean B;
    public Runnable C;
    public View.OnClickListener D;
    public View.OnClickListener E;
    public View.OnClickListener F;
    public RelativeLayout a;

    /* renamed from: b  reason: collision with root package name */
    public View f10037b;

    /* renamed from: c  reason: collision with root package name */
    public RewardVideoView f10038c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.p0.h.a.f.b.c f10039d;

    /* renamed from: e  reason: collision with root package name */
    public int f10040e;

    /* renamed from: f  reason: collision with root package name */
    public ProgressBar f10041f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f10042g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f10043h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f10044i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f10045j;
    public View k;
    public TextView l;
    public RelativeLayout m;
    public int n;
    public int o;
    public Context p;
    public AdElementInfo q;
    public final Handler r;
    public c.a.p0.h.a.e.d s;
    public RewardLoadWebView t;
    public RewardLoadWebView u;
    public InteractiveEndFrameView v;
    public Resources w;
    public c.a.p0.h.a.g.a x;
    public boolean y;
    public c.a.p0.h.a.e.e z;

    /* renamed from: c.a.p0.h.a.l.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class View$OnTouchListenerC0671a implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public View$OnTouchListenerC0671a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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

    /* loaded from: classes2.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f10046e;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10046e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f10046e.f10039d == null) {
                return;
            }
            this.f10046e.K();
            int currentPosition = this.f10046e.f10039d.getCurrentPosition();
            a aVar = this.f10046e;
            aVar.J(aVar.f10040e, currentPosition);
            int min = Math.min(currentPosition + 1000, this.f10046e.f10040e);
            this.f10046e.f10041f.setProgress(min / 1000);
            if (min < this.f10046e.f10040e) {
                this.f10046e.r.postDelayed(this.f10046e.C, 100L);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f10047e;

        public c(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10047e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f10047e.f10038c == null) {
                return;
            }
            if (this.f10047e.f10038c.isMute()) {
                this.f10047e.f10043h.setImageResource(R.drawable.ng_game_vol_open);
                this.f10047e.f10038c.mute(false);
                return;
            }
            this.f10047e.f10043h.setImageResource(R.drawable.ng_game_vol_close);
            this.f10047e.f10038c.mute(true);
        }
    }

    /* loaded from: classes2.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f10048e;

        public d(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10048e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f10048e.s == null) {
                return;
            }
            this.f10048e.s.e(view);
        }
    }

    /* loaded from: classes2.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f10049e;

        public e(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10049e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f10049e.z == null) {
                return;
            }
            this.f10049e.z.f(view);
        }
    }

    /* loaded from: classes2.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // com.baidu.swan.game.ad.view.RewardVideoView.a
        public void onVolumeChanged(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                int streamMinVolume = Build.VERSION.SDK_INT >= 28 ? ((AudioManager) this.a.p.getSystemService("audio")).getStreamMinVolume(3) : 0;
                if (i2 <= streamMinVolume || !this.a.f10038c.isMute()) {
                    if (i2 > streamMinVolume || this.a.f10038c.isMute()) {
                        return;
                    }
                    this.a.f10043h.setImageResource(R.drawable.ng_game_vol_close);
                    this.a.f10038c.mute(true);
                    return;
                }
                this.a.f10043h.setImageResource(R.drawable.ng_game_vol_open);
                this.a.f10038c.mute(false);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f10050e;

        public g(a aVar, View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10050e = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int n = c.a.p0.h.a.f.a.b().n();
                if (c.a.p0.h.a.f.a.b().u(this.f10050e)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f10050e.getLayoutParams();
                    layoutParams.topMargin = this.f10050e.getTop() + n;
                    this.f10050e.setLayoutParams(layoutParams);
                }
            }
        }
    }

    public a(Context context, AdElementInfo adElementInfo, c.a.p0.h.a.g.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, adElementInfo, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
        this.n = c.a.p0.h.a.f.a.b().q();
        this.o = c.a.p0.h.a.f.a.b().p();
        this.w = this.p.getResources();
        this.x = aVar;
        this.y = i.i();
        w();
        this.A = new c.a.p0.h.a.h.c(this.p);
        x(this.f10042g);
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

    public void E(c.a.p0.h.a.e.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, dVar) == null) {
            this.s = dVar;
        }
    }

    public void F(c.a.p0.h.a.e.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, eVar) == null) {
            this.z = eVar;
        }
    }

    public void G(String str) {
        RewardVideoView rewardVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || (rewardVideoView = this.f10038c) == null) {
            return;
        }
        rewardVideoView.start(str);
    }

    public final void H() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.f10041f == null) {
            return;
        }
        this.r.removeCallbacksAndMessages(null);
        this.r.postDelayed(this.C, 0L);
    }

    public final void I() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.f10041f == null) {
            return;
        }
        this.r.removeCallbacksAndMessages(null);
    }

    public final void J(long j2, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Long.valueOf(j2), Integer.valueOf(i2)}) == null) && this.y) {
            if (j2 <= 15000 || i2 > 15000) {
                this.f10045j.setText(R.string.swangame_game_ad_reward_tip);
                this.f10044i.setVisibility(0);
                this.k.setVisibility(0);
                this.f10045j.setVisibility(0);
            } else if (i2 < 5000) {
                this.f10042g.setVisibility(8);
                this.f10045j.setVisibility(8);
                this.k.setVisibility(8);
                this.f10044i.setVisibility(8);
            } else if (i2 < 10000) {
                this.f10042g.setVisibility(0);
                this.f10045j.setVisibility(0);
                this.k.setVisibility(8);
                this.f10044i.setVisibility(8);
            } else {
                this.f10042g.setVisibility(0);
                this.f10045j.setVisibility(0);
                this.k.setVisibility(0);
                this.f10044i.setVisibility(0);
            }
        }
    }

    public final void K() {
        c.a.p0.h.a.f.b.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.q == null || (cVar = this.f10039d) == null) {
            return;
        }
        this.f10040e = cVar.getDuration();
        int min = Math.min(this.q.getRewardTime(), this.f10040e / 1000);
        int skipTime = this.q.getSkipTime();
        int currentPosition = this.f10039d.getCurrentPosition() / 1000;
        String string = this.p.getResources().getString(R.string.swangame_game_ad_video_reward_time_surplus);
        String string2 = this.p.getResources().getString(R.string.swangame_game_ad_video_time_surplus);
        if (currentPosition <= min) {
            this.f10045j.setText(String.format(string, Integer.valueOf(min - currentPosition)));
        } else {
            this.f10045j.setText(String.format(string2, Integer.valueOf((this.f10040e / 1000) - currentPosition)));
        }
        if (currentPosition <= skipTime) {
            this.f10044i.setVisibility(8);
            this.k.setVisibility(8);
            return;
        }
        this.f10044i.setVisibility(0);
        this.k.setVisibility(0);
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            TextView textView = new TextView(this.p);
            this.l = textView;
            textView.setBackground(this.w.getDrawable(R.drawable.ng_game_bg_close_ad));
            this.l.setTextColor(this.w.getColor(R.color.close_ad_text_color));
            this.l.setText(this.w.getString(R.string.close_ad_des));
            this.l.setTextSize(2, 16.0f);
            this.l.setOnClickListener(this.E);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(h.a(96.0f), h.a(30.0f));
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            layoutParams.addRule(13);
            this.l.setGravity(17);
            layoutParams.setMargins(0, this.f10042g.getTop(), this.w.getDimensionPixelSize(R.dimen.include_land_close_ad_margin), 0);
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
        this.f10042g.setVisibility(4);
        this.m.setVisibility(4);
        this.f10044i.setVisibility(4);
        if (!TextUtils.isEmpty(this.q.getEndFrameUrl())) {
            InteractiveEndFrameView interactiveEndFrameView = new InteractiveEndFrameView(this.p);
            this.v = interactiveEndFrameView;
            interactiveEndFrameView.addWebView(this.q, this.a);
            this.a.addView(this.v, new RelativeLayout.LayoutParams(-1, -1));
            c.a.p0.h.a.j.b.i(this.q, this.A);
        } else if (!TextUtils.isEmpty(this.q.getEndFrameHtml())) {
            RewardLoadWebView rewardLoadWebView = new RewardLoadWebView(this.p);
            this.u = rewardLoadWebView;
            rewardLoadWebView.addWebView(RewardLoadWebView.END_FRAME_TYPE, this.q, this.x);
            this.a.addView(this.u, new RelativeLayout.LayoutParams(-1, -1));
            c.a.p0.h.a.j.b.i(this.q, this.A);
        } else {
            View inflate = LayoutInflater.from(this.p).inflate(R.layout.ng_game_reward_close_banner, (ViewGroup) null);
            this.a.addView(inflate, new RelativeLayout.LayoutParams(-1, -1));
            ((AdImageVIew) inflate.findViewById(R.id.reward_icon)).setImageUrl(this.q.getIconUrl());
            ((TextView) inflate.findViewById(R.id.title)).setText(this.q.getTitle());
            ((TextView) inflate.findViewById(R.id.desc)).setText(this.q.getDescription());
            Button button = (Button) inflate.findViewById(R.id.download);
            if (this.q.getActionType() == 1) {
                button.setText(this.p.getResources().getString(R.string.see_detail));
            }
            if (this.q.getActionType() == 2) {
                button.setText(this.p.getResources().getString(R.string.swanapp_ad_download_button));
            }
            inflate.findViewById(R.id.content_des).setOnClickListener(this.F);
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
                rewardLoadWebView.destroy();
                this.t = null;
            }
            RewardLoadWebView rewardLoadWebView2 = this.u;
            if (rewardLoadWebView2 != null) {
                rewardLoadWebView2.destroy();
                this.u = null;
            }
            InteractiveEndFrameView interactiveEndFrameView = this.v;
            if (interactiveEndFrameView != null) {
                interactiveEndFrameView.destroy();
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
        c.a.p0.h.a.f.b.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            H();
            ProgressBar progressBar = this.f10041f;
            if (progressBar != null && (cVar = this.f10039d) != null) {
                progressBar.setMax(cVar.getDuration() / 1000);
                this.f10041f.setVisibility(4);
            }
            if (this.f10045j != null && this.f10039d != null && (adElementInfo = this.q) != null) {
                this.f10045j.setText(String.format(this.p.getResources().getString(R.string.swangame_game_ad_video_reward_time_surplus), Integer.valueOf(Math.max(this.q.getSkipTime(), Math.min(adElementInfo.getRewardTime(), this.f10039d.getDuration())) / 1000)));
                if (this.q.getSkipTime() >= 0) {
                    this.f10044i.setVisibility(8);
                    this.k.setVisibility(8);
                }
            }
            if (this.f10042g.getVisibility() != 0) {
                this.f10042g.setVisibility(0);
            }
            if (this.m.getVisibility() != 0) {
                this.m.setAnimation(AnimationUtils.loadAnimation(this.p, R.anim.ng_game_ad_open));
                this.m.setVisibility(0);
            }
            c.a.p0.h.a.f.b.c cVar2 = this.f10039d;
            if (cVar2 != null) {
                J(cVar2.getDuration(), this.f10039d.getCurrentPosition());
            }
        }
    }

    public abstract String q();

    public View r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f10037b : (View) invokeV.objValue;
    }

    public c.a.p0.h.a.f.b.c s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            RewardVideoView rewardVideoView = this.f10038c;
            if (rewardVideoView != null) {
                return rewardVideoView.getPlayer();
            }
            return null;
        }
        return (c.a.p0.h.a.f.b.c) invokeV.objValue;
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
            this.a.setOnTouchListener(new View$OnTouchListenerC0671a(this));
            this.f10043h.setOnClickListener(this.D);
            this.f10044i.setOnClickListener(this.E);
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.f10037b = u();
            this.f10037b.setLayoutParams(new RelativeLayout.LayoutParams(this.n, this.o));
            this.a = (RelativeLayout) this.f10037b.findViewById(R.id.reward_relative);
            RewardVideoView rewardVideoView = (RewardVideoView) this.f10037b.findViewById(R.id.video_view);
            this.f10038c = rewardVideoView;
            rewardVideoView.setVolumeChangeListener(o());
            if (this.y) {
                this.f10038c.setOnClickListener(this.F);
            }
            this.f10041f = (ProgressBar) this.f10037b.findViewById(R.id.swangame_game_ad_video_progress_horizontal);
            this.f10042g = (LinearLayout) this.f10037b.findViewById(R.id.vol_clo);
            this.f10043h = (ImageView) this.f10037b.findViewById(R.id.volume);
            if (this.f10038c.isMute()) {
                this.f10043h.setImageResource(R.drawable.ng_game_vol_close);
            }
            this.f10044i = (TextView) this.f10037b.findViewById(R.id.close_ad);
            this.f10045j = (TextView) this.f10037b.findViewById(R.id.close_ad_header);
            this.k = this.f10037b.findViewById(R.id.close_ad_middle);
            this.m = (RelativeLayout) this.f10037b.findViewById(R.id.banner);
            if (!TextUtils.isEmpty(this.q.getBannerHtml())) {
                this.t = new RewardLoadWebView(this.p);
                this.m.addView(this.t, new RelativeLayout.LayoutParams(-1, -1));
                C(this.m, this.q);
                this.t.addWebView(q(), this.q, this.x);
            } else {
                View inflate = LayoutInflater.from(this.p).inflate(R.layout.ng_game_reward_banner, (ViewGroup) null);
                this.m.addView(inflate);
                ((AdImageVIew) inflate.findViewById(R.id.reward_icon)).setImageUrl(this.q.getIconUrl());
                ((TextView) inflate.findViewById(R.id.title)).setText(this.q.getTitle());
                ((TextView) inflate.findViewById(R.id.desc)).setText(this.q.getDescription());
                Button button = (Button) inflate.findViewById(R.id.download);
                if (this.q.getActionType() == 1) {
                    button.setText(this.p.getResources().getString(R.string.see_detail));
                }
                if (this.q.getActionType() == 2) {
                    button.setText(this.p.getResources().getString(R.string.swanapp_ad_download_button));
                }
                this.m.setOnClickListener(this.F);
                button.setOnClickListener(this.F);
            }
            this.f10039d = this.f10038c.getPlayer();
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
        c.a.p0.h.a.f.b.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048600, this) == null) || (cVar = this.f10039d) == null) {
            return;
        }
        this.f10040e = cVar.getDuration();
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            I();
        }
    }
}

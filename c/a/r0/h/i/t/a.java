package c.a.r0.h.i.t;

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
import c.a.r0.h.i.s.h;
import c.a.r0.h.i.s.i;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.game.ad.component.AdImageVIew;
import com.baidu.swan.game.ad.entity.AdElementInfo;
import com.baidu.swan.game.ad.view.InteractiveEndFrameView;
import com.baidu.swan.game.ad.view.RewardLoadWebView;
import com.baidu.swan.game.ad.view.RewardVideoView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.webrtc.MediaStreamTrack;
/* loaded from: classes6.dex */
public abstract class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.r0.h.i.p.c A;
    public boolean B;
    public Runnable C;
    public View.OnClickListener D;
    public View.OnClickListener E;
    public View.OnClickListener F;
    public RelativeLayout a;

    /* renamed from: b  reason: collision with root package name */
    public View f10712b;

    /* renamed from: c  reason: collision with root package name */
    public RewardVideoView f10713c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.r0.h.i.n.b.c f10714d;

    /* renamed from: e  reason: collision with root package name */
    public int f10715e;

    /* renamed from: f  reason: collision with root package name */
    public ProgressBar f10716f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f10717g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f10718h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f10719i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f10720j;
    public View k;
    public TextView l;
    public RelativeLayout m;
    public int n;
    public int o;
    public Context p;
    public AdElementInfo q;
    public final Handler r;
    public c.a.r0.h.i.m.d s;
    public RewardLoadWebView t;
    public RewardLoadWebView u;
    public InteractiveEndFrameView v;
    public Resources w;
    public c.a.r0.h.i.o.a x;
    public boolean y;
    public c.a.r0.h.i.m.e z;

    /* renamed from: c.a.r0.h.i.t.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class View$OnTouchListenerC0715a implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public View$OnTouchListenerC0715a(a aVar) {
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

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f10721e;

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
            this.f10721e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f10721e.f10714d == null) {
                return;
            }
            this.f10721e.K();
            int currentPosition = this.f10721e.f10714d.getCurrentPosition();
            a aVar = this.f10721e;
            aVar.J(aVar.f10715e, currentPosition);
            int min = Math.min(currentPosition + 1000, this.f10721e.f10715e);
            this.f10721e.f10716f.setProgress(min / 1000);
            if (min < this.f10721e.f10715e) {
                this.f10721e.r.postDelayed(this.f10721e.C, 100L);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f10722e;

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
            this.f10722e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f10722e.f10713c == null) {
                return;
            }
            if (this.f10722e.f10713c.isMute()) {
                this.f10722e.f10718h.setImageResource(c.a.r0.h.i.d.ng_game_vol_open);
                this.f10722e.f10713c.mute(false);
                return;
            }
            this.f10722e.f10718h.setImageResource(c.a.r0.h.i.d.ng_game_vol_close);
            this.f10722e.f10713c.mute(true);
        }
    }

    /* loaded from: classes6.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f10723e;

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
            this.f10723e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f10723e.s == null) {
                return;
            }
            this.f10723e.s.e(view);
        }
    }

    /* loaded from: classes6.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f10724e;

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
            this.f10724e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f10724e.z == null) {
                return;
            }
            this.f10724e.z.f(view);
        }
    }

    /* loaded from: classes6.dex */
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
                int streamMinVolume = Build.VERSION.SDK_INT >= 28 ? ((AudioManager) this.a.p.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND)).getStreamMinVolume(3) : 0;
                if (i2 <= streamMinVolume || !this.a.f10713c.isMute()) {
                    if (i2 > streamMinVolume || this.a.f10713c.isMute()) {
                        return;
                    }
                    this.a.f10718h.setImageResource(c.a.r0.h.i.d.ng_game_vol_close);
                    this.a.f10713c.mute(true);
                    return;
                }
                this.a.f10718h.setImageResource(c.a.r0.h.i.d.ng_game_vol_open);
                this.a.f10713c.mute(false);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f10725e;

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
            this.f10725e = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int n = c.a.r0.h.i.n.a.b().n();
                if (c.a.r0.h.i.n.a.b().u(this.f10725e)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f10725e.getLayoutParams();
                    layoutParams.topMargin = this.f10725e.getTop() + n;
                    this.f10725e.setLayoutParams(layoutParams);
                }
            }
        }
    }

    public a(Context context, AdElementInfo adElementInfo, c.a.r0.h.i.o.a aVar) {
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
        this.n = c.a.r0.h.i.n.a.b().q();
        this.o = c.a.r0.h.i.n.a.b().p();
        this.w = this.p.getResources();
        this.x = aVar;
        this.y = i.i();
        w();
        this.A = new c.a.r0.h.i.p.c(this.p);
        x(this.f10717g);
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

    public void E(c.a.r0.h.i.m.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, dVar) == null) {
            this.s = dVar;
        }
    }

    public void F(c.a.r0.h.i.m.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, eVar) == null) {
            this.z = eVar;
        }
    }

    public void G(String str) {
        RewardVideoView rewardVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || (rewardVideoView = this.f10713c) == null) {
            return;
        }
        rewardVideoView.start(str);
    }

    public final void H() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.f10716f == null) {
            return;
        }
        this.r.removeCallbacksAndMessages(null);
        this.r.postDelayed(this.C, 0L);
    }

    public final void I() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.f10716f == null) {
            return;
        }
        this.r.removeCallbacksAndMessages(null);
    }

    public final void J(long j2, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Long.valueOf(j2), Integer.valueOf(i2)}) == null) && this.y) {
            if (j2 <= 15000 || i2 > 15000) {
                this.f10720j.setText(c.a.r0.h.i.g.swangame_game_ad_reward_tip);
                this.f10719i.setVisibility(0);
                this.k.setVisibility(0);
                this.f10720j.setVisibility(0);
            } else if (i2 < 5000) {
                this.f10717g.setVisibility(8);
                this.f10720j.setVisibility(8);
                this.k.setVisibility(8);
                this.f10719i.setVisibility(8);
            } else if (i2 < 10000) {
                this.f10717g.setVisibility(0);
                this.f10720j.setVisibility(0);
                this.k.setVisibility(8);
                this.f10719i.setVisibility(8);
            } else {
                this.f10717g.setVisibility(0);
                this.f10720j.setVisibility(0);
                this.k.setVisibility(0);
                this.f10719i.setVisibility(0);
            }
        }
    }

    public final void K() {
        c.a.r0.h.i.n.b.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.q == null || (cVar = this.f10714d) == null) {
            return;
        }
        this.f10715e = cVar.getDuration();
        int min = Math.min(this.q.getRewardTime(), this.f10715e / 1000);
        int skipTime = this.q.getSkipTime();
        int currentPosition = this.f10714d.getCurrentPosition() / 1000;
        String string = this.p.getResources().getString(c.a.r0.h.i.g.swangame_game_ad_video_reward_time_surplus);
        String string2 = this.p.getResources().getString(c.a.r0.h.i.g.swangame_game_ad_video_time_surplus);
        if (currentPosition <= min) {
            this.f10720j.setText(String.format(string, Integer.valueOf(min - currentPosition)));
        } else {
            this.f10720j.setText(String.format(string2, Integer.valueOf((this.f10715e / 1000) - currentPosition)));
        }
        if (currentPosition <= skipTime) {
            this.f10719i.setVisibility(8);
            this.k.setVisibility(8);
            return;
        }
        this.f10719i.setVisibility(0);
        this.k.setVisibility(0);
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            TextView textView = new TextView(this.p);
            this.l = textView;
            textView.setBackground(this.w.getDrawable(c.a.r0.h.i.d.ng_game_bg_close_ad));
            this.l.setTextColor(this.w.getColor(c.a.r0.h.i.b.close_ad_text_color));
            this.l.setText(this.w.getString(c.a.r0.h.i.g.close_ad_des));
            this.l.setTextSize(2, 16.0f);
            this.l.setOnClickListener(this.E);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(h.a(96.0f), h.a(30.0f));
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            layoutParams.addRule(13);
            this.l.setGravity(17);
            layoutParams.setMargins(0, this.f10717g.getTop(), this.w.getDimensionPixelSize(c.a.r0.h.i.c.include_land_close_ad_margin), 0);
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
        this.f10717g.setVisibility(4);
        this.m.setVisibility(4);
        this.f10719i.setVisibility(4);
        if (!TextUtils.isEmpty(this.q.getEndFrameUrl())) {
            InteractiveEndFrameView interactiveEndFrameView = new InteractiveEndFrameView(this.p);
            this.v = interactiveEndFrameView;
            interactiveEndFrameView.addWebView(this.q, this.a);
            this.a.addView(this.v, new RelativeLayout.LayoutParams(-1, -1));
            c.a.r0.h.i.r.b.i(this.q, this.A);
        } else if (!TextUtils.isEmpty(this.q.getEndFrameHtml())) {
            RewardLoadWebView rewardLoadWebView = new RewardLoadWebView(this.p);
            this.u = rewardLoadWebView;
            rewardLoadWebView.addWebView(RewardLoadWebView.END_FRAME_TYPE, this.q, this.x);
            this.a.addView(this.u, new RelativeLayout.LayoutParams(-1, -1));
            c.a.r0.h.i.r.b.i(this.q, this.A);
        } else {
            View inflate = LayoutInflater.from(this.p).inflate(c.a.r0.h.i.f.ng_game_reward_close_banner, (ViewGroup) null);
            this.a.addView(inflate, new RelativeLayout.LayoutParams(-1, -1));
            ((AdImageVIew) inflate.findViewById(c.a.r0.h.i.e.reward_icon)).setImageUrl(this.q.getIconUrl());
            ((TextView) inflate.findViewById(c.a.r0.h.i.e.title)).setText(this.q.getTitle());
            ((TextView) inflate.findViewById(c.a.r0.h.i.e.desc)).setText(this.q.getDescription());
            Button button = (Button) inflate.findViewById(c.a.r0.h.i.e.download);
            if (this.q.getActionType() == 1) {
                button.setText(this.p.getResources().getString(c.a.r0.h.i.g.see_detail));
            }
            if (this.q.getActionType() == 2) {
                button.setText(this.p.getResources().getString(c.a.r0.h.i.g.swanapp_ad_download_button));
            }
            inflate.findViewById(c.a.r0.h.i.e.content_des).setOnClickListener(this.F);
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
        c.a.r0.h.i.n.b.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            H();
            ProgressBar progressBar = this.f10716f;
            if (progressBar != null && (cVar = this.f10714d) != null) {
                progressBar.setMax(cVar.getDuration() / 1000);
                this.f10716f.setVisibility(4);
            }
            if (this.f10720j != null && this.f10714d != null && (adElementInfo = this.q) != null) {
                this.f10720j.setText(String.format(this.p.getResources().getString(c.a.r0.h.i.g.swangame_game_ad_video_reward_time_surplus), Integer.valueOf(Math.max(this.q.getSkipTime(), Math.min(adElementInfo.getRewardTime(), this.f10714d.getDuration())) / 1000)));
                if (this.q.getSkipTime() >= 0) {
                    this.f10719i.setVisibility(8);
                    this.k.setVisibility(8);
                }
            }
            if (this.f10717g.getVisibility() != 0) {
                this.f10717g.setVisibility(0);
            }
            if (this.m.getVisibility() != 0) {
                this.m.setAnimation(AnimationUtils.loadAnimation(this.p, c.a.r0.h.i.a.ng_game_ad_open));
                this.m.setVisibility(0);
            }
            c.a.r0.h.i.n.b.c cVar2 = this.f10714d;
            if (cVar2 != null) {
                J(cVar2.getDuration(), this.f10714d.getCurrentPosition());
            }
        }
    }

    public abstract String q();

    public View r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f10712b : (View) invokeV.objValue;
    }

    public c.a.r0.h.i.n.b.c s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            RewardVideoView rewardVideoView = this.f10713c;
            if (rewardVideoView != null) {
                return rewardVideoView.getPlayer();
            }
            return null;
        }
        return (c.a.r0.h.i.n.b.c) invokeV.objValue;
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
            this.a.setOnTouchListener(new View$OnTouchListenerC0715a(this));
            this.f10718h.setOnClickListener(this.D);
            this.f10719i.setOnClickListener(this.E);
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.f10712b = u();
            this.f10712b.setLayoutParams(new RelativeLayout.LayoutParams(this.n, this.o));
            this.a = (RelativeLayout) this.f10712b.findViewById(c.a.r0.h.i.e.reward_relative);
            RewardVideoView rewardVideoView = (RewardVideoView) this.f10712b.findViewById(c.a.r0.h.i.e.video_view);
            this.f10713c = rewardVideoView;
            rewardVideoView.setVolumeChangeListener(o());
            if (this.y) {
                this.f10713c.setOnClickListener(this.F);
            }
            this.f10716f = (ProgressBar) this.f10712b.findViewById(c.a.r0.h.i.e.swangame_game_ad_video_progress_horizontal);
            this.f10717g = (LinearLayout) this.f10712b.findViewById(c.a.r0.h.i.e.vol_clo);
            this.f10718h = (ImageView) this.f10712b.findViewById(c.a.r0.h.i.e.volume);
            if (this.f10713c.isMute()) {
                this.f10718h.setImageResource(c.a.r0.h.i.d.ng_game_vol_close);
            }
            this.f10719i = (TextView) this.f10712b.findViewById(c.a.r0.h.i.e.close_ad);
            this.f10720j = (TextView) this.f10712b.findViewById(c.a.r0.h.i.e.close_ad_header);
            this.k = this.f10712b.findViewById(c.a.r0.h.i.e.close_ad_middle);
            this.m = (RelativeLayout) this.f10712b.findViewById(c.a.r0.h.i.e.banner);
            if (!TextUtils.isEmpty(this.q.getBannerHtml())) {
                this.t = new RewardLoadWebView(this.p);
                this.m.addView(this.t, new RelativeLayout.LayoutParams(-1, -1));
                C(this.m, this.q);
                this.t.addWebView(q(), this.q, this.x);
            } else {
                View inflate = LayoutInflater.from(this.p).inflate(c.a.r0.h.i.f.ng_game_reward_banner, (ViewGroup) null);
                this.m.addView(inflate);
                ((AdImageVIew) inflate.findViewById(c.a.r0.h.i.e.reward_icon)).setImageUrl(this.q.getIconUrl());
                ((TextView) inflate.findViewById(c.a.r0.h.i.e.title)).setText(this.q.getTitle());
                ((TextView) inflate.findViewById(c.a.r0.h.i.e.desc)).setText(this.q.getDescription());
                Button button = (Button) inflate.findViewById(c.a.r0.h.i.e.download);
                if (this.q.getActionType() == 1) {
                    button.setText(this.p.getResources().getString(c.a.r0.h.i.g.see_detail));
                }
                if (this.q.getActionType() == 2) {
                    button.setText(this.p.getResources().getString(c.a.r0.h.i.g.swanapp_ad_download_button));
                }
                this.m.setOnClickListener(this.F);
                button.setOnClickListener(this.F);
            }
            this.f10714d = this.f10713c.getPlayer();
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
        c.a.r0.h.i.n.b.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048600, this) == null) || (cVar = this.f10714d) == null) {
            return;
        }
        this.f10715e = cVar.getDuration();
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            I();
        }
    }
}

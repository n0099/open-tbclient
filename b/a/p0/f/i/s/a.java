package b.a.p0.f.i.s;

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
import b.a.p0.f.i.r.h;
import b.a.p0.f.i.r.i;
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
/* loaded from: classes4.dex */
public abstract class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b.a.p0.f.i.o.b A;
    public boolean B;
    public Runnable C;
    public View.OnClickListener D;
    public View.OnClickListener E;
    public View.OnClickListener F;

    /* renamed from: a  reason: collision with root package name */
    public RelativeLayout f9907a;

    /* renamed from: b  reason: collision with root package name */
    public View f9908b;

    /* renamed from: c  reason: collision with root package name */
    public RewardVideoView f9909c;

    /* renamed from: d  reason: collision with root package name */
    public b.a.p0.f.i.m.b.c f9910d;

    /* renamed from: e  reason: collision with root package name */
    public int f9911e;

    /* renamed from: f  reason: collision with root package name */
    public ProgressBar f9912f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f9913g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f9914h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f9915i;
    public TextView j;
    public View k;
    public TextView l;
    public RelativeLayout m;
    public int n;
    public int o;
    public Context p;
    public AdElementInfo q;
    public final Handler r;
    public b.a.p0.f.i.l.c s;
    public RewardLoadWebView t;
    public RewardLoadWebView u;
    public InteractiveEndFrameView v;
    public Resources w;
    public b.a.p0.f.i.n.a x;
    public boolean y;
    public b.a.p0.f.i.l.d z;

    /* renamed from: b.a.p0.f.i.s.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnTouchListenerC0529a implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public View$OnTouchListenerC0529a(a aVar) {
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

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f9916e;

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
            this.f9916e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f9916e.f9910d == null) {
                return;
            }
            this.f9916e.K();
            int currentPosition = this.f9916e.f9910d.getCurrentPosition();
            a aVar = this.f9916e;
            aVar.J(aVar.f9911e, currentPosition);
            int min = Math.min(currentPosition + 1000, this.f9916e.f9911e);
            this.f9916e.f9912f.setProgress(min / 1000);
            if (min < this.f9916e.f9911e) {
                this.f9916e.r.postDelayed(this.f9916e.C, 100L);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f9917e;

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
            this.f9917e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f9917e.f9909c == null) {
                return;
            }
            if (this.f9917e.f9909c.isMute()) {
                this.f9917e.f9914h.setImageResource(b.a.p0.f.i.d.ng_game_vol_open);
                this.f9917e.f9909c.mute(false);
                return;
            }
            this.f9917e.f9914h.setImageResource(b.a.p0.f.i.d.ng_game_vol_close);
            this.f9917e.f9909c.mute(true);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f9918e;

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
            this.f9918e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f9918e.s == null) {
                return;
            }
            this.f9918e.s.e(view);
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f9919e;

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
            this.f9919e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f9919e.z == null) {
                return;
            }
            this.f9919e.z.f(view);
        }
    }

    /* loaded from: classes4.dex */
    public class f implements RewardVideoView.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f9920a;

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
            this.f9920a = aVar;
        }

        @Override // com.baidu.swan.game.ad.view.RewardVideoView.a
        public void onVolumeChanged(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                int streamMinVolume = Build.VERSION.SDK_INT >= 28 ? ((AudioManager) this.f9920a.p.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND)).getStreamMinVolume(3) : 0;
                if (i2 <= streamMinVolume || !this.f9920a.f9909c.isMute()) {
                    if (i2 > streamMinVolume || this.f9920a.f9909c.isMute()) {
                        return;
                    }
                    this.f9920a.f9914h.setImageResource(b.a.p0.f.i.d.ng_game_vol_close);
                    this.f9920a.f9909c.mute(true);
                    return;
                }
                this.f9920a.f9914h.setImageResource(b.a.p0.f.i.d.ng_game_vol_open);
                this.f9920a.f9909c.mute(false);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f9921e;

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
            this.f9921e = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int n = b.a.p0.f.i.m.a.b().n();
                if (b.a.p0.f.i.m.a.b().u(this.f9921e)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f9921e.getLayoutParams();
                    layoutParams.topMargin = this.f9921e.getTop() + n;
                    this.f9921e.setLayoutParams(layoutParams);
                }
            }
        }
    }

    public a(Context context, AdElementInfo adElementInfo, b.a.p0.f.i.n.a aVar) {
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
        this.n = b.a.p0.f.i.m.a.b().q();
        this.o = b.a.p0.f.i.m.a.b().p();
        this.w = this.p.getResources();
        this.x = aVar;
        this.y = i.i();
        w();
        this.A = new b.a.p0.f.i.o.b(this.p);
        x(this.f9913g);
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

    public void E(b.a.p0.f.i.l.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) {
            this.s = cVar;
        }
    }

    public void F(b.a.p0.f.i.l.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, dVar) == null) {
            this.z = dVar;
        }
    }

    public void G(String str) {
        RewardVideoView rewardVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || (rewardVideoView = this.f9909c) == null) {
            return;
        }
        rewardVideoView.start(str);
    }

    public final void H() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.f9912f == null) {
            return;
        }
        this.r.removeCallbacksAndMessages(null);
        this.r.postDelayed(this.C, 0L);
    }

    public final void I() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.f9912f == null) {
            return;
        }
        this.r.removeCallbacksAndMessages(null);
    }

    public final void J(long j, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Long.valueOf(j), Integer.valueOf(i2)}) == null) && this.y) {
            if (j <= 15000 || i2 > 15000) {
                this.j.setText(b.a.p0.f.i.g.swangame_game_ad_reward_tip);
                this.f9915i.setVisibility(0);
                this.k.setVisibility(0);
                this.j.setVisibility(0);
            } else if (i2 < 5000) {
                this.f9913g.setVisibility(8);
                this.j.setVisibility(8);
                this.k.setVisibility(8);
                this.f9915i.setVisibility(8);
            } else if (i2 < 10000) {
                this.f9913g.setVisibility(0);
                this.j.setVisibility(0);
                this.k.setVisibility(8);
                this.f9915i.setVisibility(8);
            } else {
                this.f9913g.setVisibility(0);
                this.j.setVisibility(0);
                this.k.setVisibility(0);
                this.f9915i.setVisibility(0);
            }
        }
    }

    public final void K() {
        b.a.p0.f.i.m.b.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.q == null || (cVar = this.f9910d) == null) {
            return;
        }
        this.f9911e = cVar.getDuration();
        int min = Math.min(this.q.getRewardTime(), this.f9911e / 1000);
        int skipTime = this.q.getSkipTime();
        int currentPosition = this.f9910d.getCurrentPosition() / 1000;
        String string = this.p.getResources().getString(b.a.p0.f.i.g.swangame_game_ad_video_reward_time_surplus);
        String string2 = this.p.getResources().getString(b.a.p0.f.i.g.swangame_game_ad_video_time_surplus);
        if (currentPosition <= min) {
            this.j.setText(String.format(string, Integer.valueOf(min - currentPosition)));
        } else {
            this.j.setText(String.format(string2, Integer.valueOf((this.f9911e / 1000) - currentPosition)));
        }
        if (currentPosition <= skipTime) {
            this.f9915i.setVisibility(8);
            this.k.setVisibility(8);
            return;
        }
        this.f9915i.setVisibility(0);
        this.k.setVisibility(0);
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            TextView textView = new TextView(this.p);
            this.l = textView;
            textView.setBackground(this.w.getDrawable(b.a.p0.f.i.d.ng_game_bg_close_ad));
            this.l.setTextColor(this.w.getColor(b.a.p0.f.i.b.close_ad_text_color));
            this.l.setText(this.w.getString(b.a.p0.f.i.g.close_ad_des));
            this.l.setTextSize(2, 16.0f);
            this.l.setOnClickListener(this.E);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(h.a(96.0f), h.a(30.0f));
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            layoutParams.addRule(13);
            this.l.setGravity(17);
            layoutParams.setMargins(0, this.f9913g.getTop(), this.w.getDimensionPixelSize(b.a.p0.f.i.c.include_land_close_ad_margin), 0);
            this.f9907a.addView(this.l, layoutParams);
            x(this.l);
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || this.f9907a == null) {
            return;
        }
        this.B = true;
        this.f9913g.setVisibility(4);
        this.m.setVisibility(4);
        this.f9915i.setVisibility(4);
        if (!TextUtils.isEmpty(this.q.getEndFrameUrl())) {
            InteractiveEndFrameView interactiveEndFrameView = new InteractiveEndFrameView(this.p);
            this.v = interactiveEndFrameView;
            interactiveEndFrameView.addWebView(this.q, this.f9907a);
            this.f9907a.addView(this.v, new RelativeLayout.LayoutParams(-1, -1));
            b.a.p0.f.i.q.b.i(this.q, this.A);
        } else if (!TextUtils.isEmpty(this.q.getEndFrameHtml())) {
            RewardLoadWebView rewardLoadWebView = new RewardLoadWebView(this.p);
            this.u = rewardLoadWebView;
            rewardLoadWebView.addWebView(RewardLoadWebView.END_FRAME_TYPE, this.q, this.x);
            this.f9907a.addView(this.u, new RelativeLayout.LayoutParams(-1, -1));
            b.a.p0.f.i.q.b.i(this.q, this.A);
        } else {
            View inflate = LayoutInflater.from(this.p).inflate(b.a.p0.f.i.f.ng_game_reward_close_banner, (ViewGroup) null);
            this.f9907a.addView(inflate, new RelativeLayout.LayoutParams(-1, -1));
            ((AdImageVIew) inflate.findViewById(b.a.p0.f.i.e.reward_icon)).setImageUrl(this.q.getIconUrl());
            ((TextView) inflate.findViewById(b.a.p0.f.i.e.title)).setText(this.q.getTitle());
            ((TextView) inflate.findViewById(b.a.p0.f.i.e.desc)).setText(this.q.getDescription());
            Button button = (Button) inflate.findViewById(b.a.p0.f.i.e.download);
            if (this.q.getActionType() == 1) {
                button.setText(this.p.getResources().getString(b.a.p0.f.i.g.see_detail));
            }
            if (this.q.getActionType() == 2) {
                button.setText(this.p.getResources().getString(b.a.p0.f.i.g.swanapp_ad_download_button));
            }
            inflate.findViewById(b.a.p0.f.i.e.content_des).setOnClickListener(this.F);
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
        b.a.p0.f.i.m.b.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            H();
            ProgressBar progressBar = this.f9912f;
            if (progressBar != null && (cVar = this.f9910d) != null) {
                progressBar.setMax(cVar.getDuration() / 1000);
                this.f9912f.setVisibility(4);
            }
            if (this.j != null && this.f9910d != null && (adElementInfo = this.q) != null) {
                this.j.setText(String.format(this.p.getResources().getString(b.a.p0.f.i.g.swangame_game_ad_video_reward_time_surplus), Integer.valueOf(Math.max(this.q.getSkipTime(), Math.min(adElementInfo.getRewardTime(), this.f9910d.getDuration())) / 1000)));
                if (this.q.getSkipTime() >= 0) {
                    this.f9915i.setVisibility(8);
                    this.k.setVisibility(8);
                }
            }
            if (this.f9913g.getVisibility() != 0) {
                this.f9913g.setVisibility(0);
            }
            if (this.m.getVisibility() != 0) {
                this.m.setAnimation(AnimationUtils.loadAnimation(this.p, b.a.p0.f.i.a.ng_game_ad_open));
                this.m.setVisibility(0);
            }
            b.a.p0.f.i.m.b.c cVar2 = this.f9910d;
            if (cVar2 != null) {
                J(cVar2.getDuration(), this.f9910d.getCurrentPosition());
            }
        }
    }

    public abstract String q();

    public View r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f9908b : (View) invokeV.objValue;
    }

    public b.a.p0.f.i.m.b.c s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            RewardVideoView rewardVideoView = this.f9909c;
            if (rewardVideoView != null) {
                return rewardVideoView.getPlayer();
            }
            return null;
        }
        return (b.a.p0.f.i.m.b.c) invokeV.objValue;
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
            this.f9907a.setOnTouchListener(new View$OnTouchListenerC0529a(this));
            this.f9914h.setOnClickListener(this.D);
            this.f9915i.setOnClickListener(this.E);
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.f9908b = u();
            this.f9908b.setLayoutParams(new RelativeLayout.LayoutParams(this.n, this.o));
            this.f9907a = (RelativeLayout) this.f9908b.findViewById(b.a.p0.f.i.e.reward_relative);
            RewardVideoView rewardVideoView = (RewardVideoView) this.f9908b.findViewById(b.a.p0.f.i.e.video_view);
            this.f9909c = rewardVideoView;
            rewardVideoView.setVolumeChangeListener(o());
            if (this.y) {
                this.f9909c.setOnClickListener(this.F);
            }
            this.f9912f = (ProgressBar) this.f9908b.findViewById(b.a.p0.f.i.e.swangame_game_ad_video_progress_horizontal);
            this.f9913g = (LinearLayout) this.f9908b.findViewById(b.a.p0.f.i.e.vol_clo);
            this.f9914h = (ImageView) this.f9908b.findViewById(b.a.p0.f.i.e.volume);
            if (this.f9909c.isMute()) {
                this.f9914h.setImageResource(b.a.p0.f.i.d.ng_game_vol_close);
            }
            this.f9915i = (TextView) this.f9908b.findViewById(b.a.p0.f.i.e.close_ad);
            this.j = (TextView) this.f9908b.findViewById(b.a.p0.f.i.e.close_ad_header);
            this.k = this.f9908b.findViewById(b.a.p0.f.i.e.close_ad_middle);
            this.m = (RelativeLayout) this.f9908b.findViewById(b.a.p0.f.i.e.banner);
            if (!TextUtils.isEmpty(this.q.getBannerHtml())) {
                this.t = new RewardLoadWebView(this.p);
                this.m.addView(this.t, new RelativeLayout.LayoutParams(-1, -1));
                C(this.m, this.q);
                this.t.addWebView(q(), this.q, this.x);
            } else {
                View inflate = LayoutInflater.from(this.p).inflate(b.a.p0.f.i.f.ng_game_reward_banner, (ViewGroup) null);
                this.m.addView(inflate);
                ((AdImageVIew) inflate.findViewById(b.a.p0.f.i.e.reward_icon)).setImageUrl(this.q.getIconUrl());
                ((TextView) inflate.findViewById(b.a.p0.f.i.e.title)).setText(this.q.getTitle());
                ((TextView) inflate.findViewById(b.a.p0.f.i.e.desc)).setText(this.q.getDescription());
                Button button = (Button) inflate.findViewById(b.a.p0.f.i.e.download);
                if (this.q.getActionType() == 1) {
                    button.setText(this.p.getResources().getString(b.a.p0.f.i.g.see_detail));
                }
                if (this.q.getActionType() == 2) {
                    button.setText(this.p.getResources().getString(b.a.p0.f.i.g.swanapp_ad_download_button));
                }
                this.m.setOnClickListener(this.F);
                button.setOnClickListener(this.F);
            }
            this.f9910d = this.f9909c.getPlayer();
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
        b.a.p0.f.i.m.b.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048600, this) == null) || (cVar = this.f9910d) == null) {
            return;
        }
        this.f9911e = cVar.getDuration();
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            I();
        }
    }
}

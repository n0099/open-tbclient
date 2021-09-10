package c.a.r0.a4;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.k;
import c.a.e.e.p.l;
import c.a.q0.t.c.l0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.widget.ScaleVideoView;
import com.baidu.tieba.LogoActivity;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public LogoActivity f15862a;

    /* renamed from: b  reason: collision with root package name */
    public View f15863b;

    /* renamed from: c  reason: collision with root package name */
    public View f15864c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f15865d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f15866e;

    /* renamed from: f  reason: collision with root package name */
    public ScaleVideoView f15867f;

    /* renamed from: g  reason: collision with root package name */
    public g f15868g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.r0.a4.a f15869h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.r0.a4.c f15870i;

    /* renamed from: j  reason: collision with root package name */
    public int f15871j;
    public boolean k;
    public Runnable l;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f15872e;

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15872e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f15872e.f15868g == null) {
                return;
            }
            this.f15872e.f15868g.onError();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements MediaPlayer.OnErrorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f15873e;

        public b(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15873e = dVar;
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, mediaPlayer, i2, i3)) == null) {
                c.a.e.e.m.e.a().removeCallbacks(this.f15873e.l);
                if (this.f15873e.f15868g != null) {
                    this.f15873e.k = false;
                    this.f15873e.f15868g.onError();
                    return true;
                }
                return true;
            }
            return invokeLII.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class c implements MediaPlayer.OnCompletionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f15874e;

        public c(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15874e = dVar;
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, mediaPlayer) == null) {
                c.a.e.e.m.e.a().removeCallbacks(this.f15874e.l);
                if (this.f15874e.f15868g != null) {
                    this.f15874e.k = false;
                    this.f15874e.f15868g.onSkip();
                }
            }
        }
    }

    /* renamed from: c.a.r0.a4.d$d  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0758d implements MediaPlayer.OnPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f15875e;

        /* renamed from: c.a.r0.a4.d$d$a */
        /* loaded from: classes3.dex */
        public class a implements MediaPlayer.OnInfoListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ C0758d f15876e;

            public a(C0758d c0758d) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0758d};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f15876e = c0758d;
            }

            @Override // android.media.MediaPlayer.OnInfoListener
            public boolean onInfo(MediaPlayer mediaPlayer, int i2, int i3) {
                InterceptResult invokeLII;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, mediaPlayer, i2, i3)) == null) {
                    if (i2 == 3) {
                        this.f15876e.f15875e.l();
                        return false;
                    }
                    return false;
                }
                return invokeLII.booleanValue;
            }
        }

        public C0758d(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15875e = dVar;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, mediaPlayer) == null) {
                c.a.e.e.m.e.a().removeCallbacks(this.f15875e.l);
                this.f15875e.f15867f.setMediaPlayer(mediaPlayer);
                mediaPlayer.setOnInfoListener(new a(this));
                this.f15875e.q();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f15877e;

        public e(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15877e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.e.e.m.e.a().removeCallbacks(this.f15877e.l);
                if (this.f15877e.f15868g != null) {
                    this.f15877e.k = false;
                    this.f15877e.f15868g.onSkip();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f15878e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f15879f;

        public f(d dVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15879f = dVar;
            this.f15878e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TiebaStatic.log(new StatisticItem("c12945"));
                if (k.isEmpty(this.f15878e)) {
                    return;
                }
                this.f15879f.k = false;
                this.f15879f.f15868g.onSkip();
                UrlManager.getInstance().dealOneLink(this.f15879f.f15862a.getPageContext(), new String[]{this.f15878e});
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface g {
        void onError();

        void onSkip();
    }

    public d(LogoActivity logoActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {logoActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f15871j = 0;
        this.k = true;
        this.l = new a(this);
        this.f15862a = logoActivity;
        this.f15869h = new c.a.r0.a4.a();
        this.f15870i = new c.a.r0.a4.c();
        this.f15871j = 0;
    }

    public boolean h() {
        InterceptResult invokeV;
        c.a.r0.a4.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return (c.a.q0.s.d0.b.j().k("key_video_splash_switch", 0) == 1) && (aVar = this.f15869h) != null && this.f15870i != null && aVar.b() && this.f15870i.l();
        }
        return invokeV.booleanValue;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (c.a.q0.s.d0.b.j().k("key_video_splash_switch", 0) == 1) {
                return;
            }
            c.a.r0.a4.c cVar = this.f15870i;
            if (cVar != null) {
                cVar.g();
            }
            c.a.q0.s.d0.b.j().w("key_video_splash_last_show_time", 0L);
        }
    }

    public final View j(double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Double.valueOf(d2)})) == null) {
            View inflate = LayoutInflater.from(this.f15862a).inflate(R.layout.video_splash_layout, (ViewGroup) null);
            inflate.setLayoutParams(new RelativeLayout.LayoutParams(-1, (int) (l.i(this.f15862a) * d2)));
            ScaleVideoView scaleVideoView = (ScaleVideoView) inflate.findViewById(R.id.video);
            this.f15867f = scaleVideoView;
            scaleVideoView.setOnErrorListener(new b(this));
            this.f15867f.setOnCompletionListener(new c(this));
            this.f15867f.setOnPreparedListener(new C0758d(this));
            TextView textView = (TextView) inflate.findViewById(R.id.skip);
            this.f15866e = textView;
            textView.setOnClickListener(new e(this));
            String p = c.a.q0.s.d0.b.j().p("key_video_splash_config", "");
            l0 l0Var = new l0();
            l0Var.g(p);
            String c2 = l0Var.c();
            View findViewById = inflate.findViewById(R.id.tip_container);
            this.f15864c = findViewById;
            findViewById.setOnClickListener(new f(this, c2));
            this.f15865d = (TextView) inflate.findViewById(R.id.tip_text);
            String b2 = l0Var.b();
            if (k.isEmpty(b2)) {
                b2 = this.f15862a.getString(R.string.video_splash_tip_default);
            }
            this.f15865d.setText(b2);
            s();
            return inflate;
        }
        return (View) invokeCommon.objValue;
    }

    public View k(double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Double.valueOf(d2)})) == null) {
            if (this.f15863b == null) {
                this.f15863b = j(d2);
            }
            return this.f15863b;
        }
        return (View) invokeCommon.objValue;
    }

    public final void l() {
        ScaleVideoView scaleVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (scaleVideoView = this.f15867f) == null) {
            return;
        }
        scaleVideoView.setBackgroundResource(0);
    }

    public final void m() {
        c.a.r0.a4.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (cVar = this.f15870i) == null || k.isEmpty(cVar.i())) {
            return;
        }
        this.f15867f.setVideoPath(this.f15870i.i());
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            c.a.e.e.m.e.a().removeCallbacks(this.l);
        }
    }

    public void o() {
        ScaleVideoView scaleVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (scaleVideoView = this.f15867f) == null) {
            return;
        }
        this.f15871j = scaleVideoView.getCurrentPosition();
        this.f15867f.stopPlayback();
        if (this.k) {
            s();
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.k = true;
            ScaleVideoView scaleVideoView = this.f15867f;
            if (scaleVideoView != null) {
                scaleVideoView.resume();
            }
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            c.a.r0.a4.a aVar = this.f15869h;
            if (aVar != null) {
                aVar.g(System.currentTimeMillis());
            }
            int i2 = this.f15871j;
            if (i2 >= 0) {
                this.f15867f.seekTo(i2);
            }
            this.f15867f.start();
        }
    }

    public void r(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, gVar) == null) {
            this.f15868g = gVar;
        }
    }

    public final void s() {
        c.a.r0.a4.c cVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (cVar = this.f15870i) != null && cVar.l()) {
            try {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(this.f15870i.i());
                Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(0L);
                if (this.f15867f != null) {
                    this.f15867f.setBackgroundDrawable(new BitmapDrawable(frameAtTime));
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                ScaleVideoView scaleVideoView = this.f15867f;
                if (scaleVideoView != null) {
                    scaleVideoView.setBackgroundColor(this.f15862a.getResources().getColor(R.color.CAM_X0101));
                }
            }
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            TiebaStatic.log(new StatisticItem("c12944"));
            c.a.e.e.m.e.a().postDelayed(this.l, 1000L);
            m();
        }
    }
}

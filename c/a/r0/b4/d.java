package c.a.r0.b4;

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
import c.a.q0.t.c.m0;
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
    public LogoActivity f16028a;

    /* renamed from: b  reason: collision with root package name */
    public View f16029b;

    /* renamed from: c  reason: collision with root package name */
    public View f16030c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f16031d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f16032e;

    /* renamed from: f  reason: collision with root package name */
    public ScaleVideoView f16033f;

    /* renamed from: g  reason: collision with root package name */
    public g f16034g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.r0.b4.a f16035h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.r0.b4.c f16036i;

    /* renamed from: j  reason: collision with root package name */
    public int f16037j;
    public boolean k;
    public Runnable l;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f16038e;

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
            this.f16038e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f16038e.f16034g == null) {
                return;
            }
            this.f16038e.f16034g.onError();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements MediaPlayer.OnErrorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f16039e;

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
            this.f16039e = dVar;
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, mediaPlayer, i2, i3)) == null) {
                c.a.e.e.m.e.a().removeCallbacks(this.f16039e.l);
                if (this.f16039e.f16034g != null) {
                    this.f16039e.k = false;
                    this.f16039e.f16034g.onError();
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
        public final /* synthetic */ d f16040e;

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
            this.f16040e = dVar;
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, mediaPlayer) == null) {
                c.a.e.e.m.e.a().removeCallbacks(this.f16040e.l);
                if (this.f16040e.f16034g != null) {
                    this.f16040e.k = false;
                    this.f16040e.f16034g.onSkip();
                }
            }
        }
    }

    /* renamed from: c.a.r0.b4.d$d  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0764d implements MediaPlayer.OnPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f16041e;

        /* renamed from: c.a.r0.b4.d$d$a */
        /* loaded from: classes3.dex */
        public class a implements MediaPlayer.OnInfoListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ C0764d f16042e;

            public a(C0764d c0764d) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0764d};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f16042e = c0764d;
            }

            @Override // android.media.MediaPlayer.OnInfoListener
            public boolean onInfo(MediaPlayer mediaPlayer, int i2, int i3) {
                InterceptResult invokeLII;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, mediaPlayer, i2, i3)) == null) {
                    if (i2 == 3) {
                        this.f16042e.f16041e.l();
                        return false;
                    }
                    return false;
                }
                return invokeLII.booleanValue;
            }
        }

        public C0764d(d dVar) {
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
            this.f16041e = dVar;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, mediaPlayer) == null) {
                c.a.e.e.m.e.a().removeCallbacks(this.f16041e.l);
                this.f16041e.f16033f.setMediaPlayer(mediaPlayer);
                mediaPlayer.setOnInfoListener(new a(this));
                this.f16041e.q();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f16043e;

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
            this.f16043e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.e.e.m.e.a().removeCallbacks(this.f16043e.l);
                if (this.f16043e.f16034g != null) {
                    this.f16043e.k = false;
                    this.f16043e.f16034g.onSkip();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f16044e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f16045f;

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
            this.f16045f = dVar;
            this.f16044e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TiebaStatic.log(new StatisticItem("c12945"));
                if (k.isEmpty(this.f16044e)) {
                    return;
                }
                this.f16045f.k = false;
                this.f16045f.f16034g.onSkip();
                UrlManager.getInstance().dealOneLink(this.f16045f.f16028a.getPageContext(), new String[]{this.f16044e});
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
        this.f16037j = 0;
        this.k = true;
        this.l = new a(this);
        this.f16028a = logoActivity;
        this.f16035h = new c.a.r0.b4.a();
        this.f16036i = new c.a.r0.b4.c();
        this.f16037j = 0;
    }

    public boolean h() {
        InterceptResult invokeV;
        c.a.r0.b4.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return (c.a.q0.s.d0.b.j().k("key_video_splash_switch", 0) == 1) && (aVar = this.f16035h) != null && this.f16036i != null && aVar.b() && this.f16036i.l();
        }
        return invokeV.booleanValue;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (c.a.q0.s.d0.b.j().k("key_video_splash_switch", 0) == 1) {
                return;
            }
            c.a.r0.b4.c cVar = this.f16036i;
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
            View inflate = LayoutInflater.from(this.f16028a).inflate(R.layout.video_splash_layout, (ViewGroup) null);
            inflate.setLayoutParams(new RelativeLayout.LayoutParams(-1, (int) (l.i(this.f16028a) * d2)));
            ScaleVideoView scaleVideoView = (ScaleVideoView) inflate.findViewById(R.id.video);
            this.f16033f = scaleVideoView;
            scaleVideoView.setOnErrorListener(new b(this));
            this.f16033f.setOnCompletionListener(new c(this));
            this.f16033f.setOnPreparedListener(new C0764d(this));
            TextView textView = (TextView) inflate.findViewById(R.id.skip);
            this.f16032e = textView;
            textView.setOnClickListener(new e(this));
            String p = c.a.q0.s.d0.b.j().p("key_video_splash_config", "");
            m0 m0Var = new m0();
            m0Var.g(p);
            String c2 = m0Var.c();
            View findViewById = inflate.findViewById(R.id.tip_container);
            this.f16030c = findViewById;
            findViewById.setOnClickListener(new f(this, c2));
            this.f16031d = (TextView) inflate.findViewById(R.id.tip_text);
            String b2 = m0Var.b();
            if (k.isEmpty(b2)) {
                b2 = this.f16028a.getString(R.string.video_splash_tip_default);
            }
            this.f16031d.setText(b2);
            s();
            return inflate;
        }
        return (View) invokeCommon.objValue;
    }

    public View k(double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Double.valueOf(d2)})) == null) {
            if (this.f16029b == null) {
                this.f16029b = j(d2);
            }
            return this.f16029b;
        }
        return (View) invokeCommon.objValue;
    }

    public final void l() {
        ScaleVideoView scaleVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (scaleVideoView = this.f16033f) == null) {
            return;
        }
        scaleVideoView.setBackgroundResource(0);
    }

    public final void m() {
        c.a.r0.b4.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (cVar = this.f16036i) == null || k.isEmpty(cVar.i())) {
            return;
        }
        this.f16033f.setVideoPath(this.f16036i.i());
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
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (scaleVideoView = this.f16033f) == null) {
            return;
        }
        this.f16037j = scaleVideoView.getCurrentPosition();
        this.f16033f.stopPlayback();
        if (this.k) {
            s();
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.k = true;
            ScaleVideoView scaleVideoView = this.f16033f;
            if (scaleVideoView != null) {
                scaleVideoView.resume();
            }
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            c.a.r0.b4.a aVar = this.f16035h;
            if (aVar != null) {
                aVar.g(System.currentTimeMillis());
            }
            int i2 = this.f16037j;
            if (i2 >= 0) {
                this.f16033f.seekTo(i2);
            }
            this.f16033f.start();
        }
    }

    public void r(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, gVar) == null) {
            this.f16034g = gVar;
        }
    }

    public final void s() {
        c.a.r0.b4.c cVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (cVar = this.f16036i) != null && cVar.l()) {
            try {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(this.f16036i.i());
                Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(0L);
                if (this.f16033f != null) {
                    this.f16033f.setBackgroundDrawable(new BitmapDrawable(frameAtTime));
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                ScaleVideoView scaleVideoView = this.f16033f;
                if (scaleVideoView != null) {
                    scaleVideoView.setBackgroundColor(this.f16028a.getResources().getColor(R.color.CAM_X0101));
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

package c.a.q0.z3;

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
import c.a.p0.t.c.l0;
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
/* loaded from: classes4.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public LogoActivity f29373a;

    /* renamed from: b  reason: collision with root package name */
    public View f29374b;

    /* renamed from: c  reason: collision with root package name */
    public View f29375c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f29376d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f29377e;

    /* renamed from: f  reason: collision with root package name */
    public ScaleVideoView f29378f;

    /* renamed from: g  reason: collision with root package name */
    public g f29379g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.q0.z3.a f29380h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.q0.z3.c f29381i;

    /* renamed from: j  reason: collision with root package name */
    public int f29382j;
    public boolean k;
    public Runnable l;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f29383e;

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
            this.f29383e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f29383e.f29379g == null) {
                return;
            }
            this.f29383e.f29379g.onError();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements MediaPlayer.OnErrorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f29384e;

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
            this.f29384e = dVar;
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, mediaPlayer, i2, i3)) == null) {
                c.a.e.e.m.e.a().removeCallbacks(this.f29384e.l);
                if (this.f29384e.f29379g != null) {
                    this.f29384e.k = false;
                    this.f29384e.f29379g.onError();
                    return true;
                }
                return true;
            }
            return invokeLII.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class c implements MediaPlayer.OnCompletionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f29385e;

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
            this.f29385e = dVar;
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, mediaPlayer) == null) {
                c.a.e.e.m.e.a().removeCallbacks(this.f29385e.l);
                if (this.f29385e.f29379g != null) {
                    this.f29385e.k = false;
                    this.f29385e.f29379g.onSkip();
                }
            }
        }
    }

    /* renamed from: c.a.q0.z3.d$d  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1365d implements MediaPlayer.OnPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f29386e;

        /* renamed from: c.a.q0.z3.d$d$a */
        /* loaded from: classes4.dex */
        public class a implements MediaPlayer.OnInfoListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ C1365d f29387e;

            public a(C1365d c1365d) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1365d};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f29387e = c1365d;
            }

            @Override // android.media.MediaPlayer.OnInfoListener
            public boolean onInfo(MediaPlayer mediaPlayer, int i2, int i3) {
                InterceptResult invokeLII;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, mediaPlayer, i2, i3)) == null) {
                    if (i2 == 3) {
                        this.f29387e.f29386e.l();
                        return false;
                    }
                    return false;
                }
                return invokeLII.booleanValue;
            }
        }

        public C1365d(d dVar) {
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
            this.f29386e = dVar;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, mediaPlayer) == null) {
                c.a.e.e.m.e.a().removeCallbacks(this.f29386e.l);
                this.f29386e.f29378f.setMediaPlayer(mediaPlayer);
                mediaPlayer.setOnInfoListener(new a(this));
                this.f29386e.q();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f29388e;

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
            this.f29388e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.e.e.m.e.a().removeCallbacks(this.f29388e.l);
                if (this.f29388e.f29379g != null) {
                    this.f29388e.k = false;
                    this.f29388e.f29379g.onSkip();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f29389e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f29390f;

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
            this.f29390f = dVar;
            this.f29389e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TiebaStatic.log(new StatisticItem("c12945"));
                if (k.isEmpty(this.f29389e)) {
                    return;
                }
                this.f29390f.k = false;
                this.f29390f.f29379g.onSkip();
                UrlManager.getInstance().dealOneLink(this.f29390f.f29373a.getPageContext(), new String[]{this.f29389e});
            }
        }
    }

    /* loaded from: classes4.dex */
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
        this.f29382j = 0;
        this.k = true;
        this.l = new a(this);
        this.f29373a = logoActivity;
        this.f29380h = new c.a.q0.z3.a();
        this.f29381i = new c.a.q0.z3.c();
        this.f29382j = 0;
    }

    public boolean h() {
        InterceptResult invokeV;
        c.a.q0.z3.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return (c.a.p0.s.d0.b.j().k("key_video_splash_switch", 0) == 1) && (aVar = this.f29380h) != null && this.f29381i != null && aVar.b() && this.f29381i.l();
        }
        return invokeV.booleanValue;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (c.a.p0.s.d0.b.j().k("key_video_splash_switch", 0) == 1) {
                return;
            }
            c.a.q0.z3.c cVar = this.f29381i;
            if (cVar != null) {
                cVar.g();
            }
            c.a.p0.s.d0.b.j().w("key_video_splash_last_show_time", 0L);
        }
    }

    public final View j(double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Double.valueOf(d2)})) == null) {
            View inflate = LayoutInflater.from(this.f29373a).inflate(R.layout.video_splash_layout, (ViewGroup) null);
            inflate.setLayoutParams(new RelativeLayout.LayoutParams(-1, (int) (l.i(this.f29373a) * d2)));
            ScaleVideoView scaleVideoView = (ScaleVideoView) inflate.findViewById(R.id.video);
            this.f29378f = scaleVideoView;
            scaleVideoView.setOnErrorListener(new b(this));
            this.f29378f.setOnCompletionListener(new c(this));
            this.f29378f.setOnPreparedListener(new C1365d(this));
            TextView textView = (TextView) inflate.findViewById(R.id.skip);
            this.f29377e = textView;
            textView.setOnClickListener(new e(this));
            String p = c.a.p0.s.d0.b.j().p("key_video_splash_config", "");
            l0 l0Var = new l0();
            l0Var.g(p);
            String c2 = l0Var.c();
            View findViewById = inflate.findViewById(R.id.tip_container);
            this.f29375c = findViewById;
            findViewById.setOnClickListener(new f(this, c2));
            this.f29376d = (TextView) inflate.findViewById(R.id.tip_text);
            String b2 = l0Var.b();
            if (k.isEmpty(b2)) {
                b2 = this.f29373a.getString(R.string.video_splash_tip_default);
            }
            this.f29376d.setText(b2);
            s();
            return inflate;
        }
        return (View) invokeCommon.objValue;
    }

    public View k(double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Double.valueOf(d2)})) == null) {
            if (this.f29374b == null) {
                this.f29374b = j(d2);
            }
            return this.f29374b;
        }
        return (View) invokeCommon.objValue;
    }

    public final void l() {
        ScaleVideoView scaleVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (scaleVideoView = this.f29378f) == null) {
            return;
        }
        scaleVideoView.setBackgroundResource(0);
    }

    public final void m() {
        c.a.q0.z3.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (cVar = this.f29381i) == null || k.isEmpty(cVar.i())) {
            return;
        }
        this.f29378f.setVideoPath(this.f29381i.i());
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
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (scaleVideoView = this.f29378f) == null) {
            return;
        }
        this.f29382j = scaleVideoView.getCurrentPosition();
        this.f29378f.stopPlayback();
        if (this.k) {
            s();
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.k = true;
            ScaleVideoView scaleVideoView = this.f29378f;
            if (scaleVideoView != null) {
                scaleVideoView.resume();
            }
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            c.a.q0.z3.a aVar = this.f29380h;
            if (aVar != null) {
                aVar.g(System.currentTimeMillis());
            }
            int i2 = this.f29382j;
            if (i2 >= 0) {
                this.f29378f.seekTo(i2);
            }
            this.f29378f.start();
        }
    }

    public void r(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, gVar) == null) {
            this.f29379g = gVar;
        }
    }

    public final void s() {
        c.a.q0.z3.c cVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (cVar = this.f29381i) != null && cVar.l()) {
            try {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(this.f29381i.i());
                Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(0L);
                if (this.f29378f != null) {
                    this.f29378f.setBackgroundDrawable(new BitmapDrawable(frameAtTime));
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                ScaleVideoView scaleVideoView = this.f29378f;
                if (scaleVideoView != null) {
                    scaleVideoView.setBackgroundColor(this.f29373a.getResources().getColor(R.color.CAM_X0101));
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

package c.a.t0.r3.g;

import android.app.Activity;
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
import c.a.d.f.p.m;
import c.a.d.f.p.n;
import c.a.s0.t.c.o0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.widget.ScaleVideoView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Activity a;

    /* renamed from: b  reason: collision with root package name */
    public View f22518b;

    /* renamed from: c  reason: collision with root package name */
    public View f22519c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f22520d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f22521e;

    /* renamed from: f  reason: collision with root package name */
    public ScaleVideoView f22522f;

    /* renamed from: g  reason: collision with root package name */
    public g f22523g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.t0.r3.g.a f22524h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.t0.r3.g.d f22525i;

    /* renamed from: j  reason: collision with root package name */
    public int f22526j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f22527k;
    public Runnable l;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f22528e;

        public a(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22528e = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f22528e.f22523g == null) {
                return;
            }
            this.f22528e.f22523g.onError();
        }
    }

    /* loaded from: classes8.dex */
    public class b implements MediaPlayer.OnErrorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f22529e;

        public b(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22529e = fVar;
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, mediaPlayer, i2, i3)) == null) {
                c.a.d.f.m.e.a().removeCallbacks(this.f22529e.l);
                if (this.f22529e.f22523g != null) {
                    this.f22529e.f22527k = false;
                    this.f22529e.f22523g.onError();
                    return true;
                }
                return true;
            }
            return invokeLII.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class c implements MediaPlayer.OnCompletionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f22530e;

        public c(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22530e = fVar;
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, mediaPlayer) == null) {
                c.a.d.f.m.e.a().removeCallbacks(this.f22530e.l);
                if (this.f22530e.f22523g != null) {
                    this.f22530e.f22527k = false;
                    this.f22530e.f22523g.a();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements MediaPlayer.OnPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f22531e;

        /* loaded from: classes8.dex */
        public class a implements MediaPlayer.OnInfoListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d f22532e;

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
                this.f22532e = dVar;
            }

            @Override // android.media.MediaPlayer.OnInfoListener
            public boolean onInfo(MediaPlayer mediaPlayer, int i2, int i3) {
                InterceptResult invokeLII;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, mediaPlayer, i2, i3)) == null) {
                    if (i2 == 3) {
                        this.f22532e.f22531e.l();
                        return false;
                    }
                    return false;
                }
                return invokeLII.booleanValue;
            }
        }

        public d(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22531e = fVar;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, mediaPlayer) == null) {
                c.a.d.f.m.e.a().removeCallbacks(this.f22531e.l);
                this.f22531e.f22522f.setMediaPlayer(mediaPlayer);
                mediaPlayer.setOnInfoListener(new a(this));
                this.f22531e.q();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f22533e;

        public e(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22533e = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.d.f.m.e.a().removeCallbacks(this.f22533e.l);
                if (this.f22533e.f22523g != null) {
                    this.f22533e.f22527k = false;
                    this.f22533e.f22523g.a();
                }
            }
        }
    }

    /* renamed from: c.a.t0.r3.g.f$f  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class View$OnClickListenerC1342f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f22534e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ f f22535f;

        public View$OnClickListenerC1342f(f fVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22535f = fVar;
            this.f22534e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TiebaStatic.log(new StatisticItem("c12945"));
                if (m.isEmpty(this.f22534e)) {
                    return;
                }
                this.f22535f.f22527k = false;
                this.f22535f.f22523g.a();
                UrlManager.getInstance().dealOneLink(((TbPageContextSupport) this.f22535f.a).getPageContext(), new String[]{this.f22534e});
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface g {
        void a();

        void onError();
    }

    public f(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f22526j = 0;
        this.f22527k = true;
        this.l = new a(this);
        this.a = activity;
        this.f22524h = new c.a.t0.r3.g.a();
        this.f22525i = new c.a.t0.r3.g.d();
        this.f22526j = 0;
    }

    public boolean h() {
        InterceptResult invokeV;
        c.a.t0.r3.g.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return (c.a.s0.s.g0.b.j().k("key_video_splash_switch", 0) == 1) && (aVar = this.f22524h) != null && this.f22525i != null && aVar.b() && this.f22525i.l();
        }
        return invokeV.booleanValue;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (c.a.s0.s.g0.b.j().k("key_video_splash_switch", 0) == 1) {
                return;
            }
            c.a.t0.r3.g.d dVar = this.f22525i;
            if (dVar != null) {
                dVar.g();
            }
            c.a.s0.s.g0.b.j().w("key_video_splash_last_show_time", 0L);
        }
    }

    public final View j(double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Double.valueOf(d2)})) == null) {
            View inflate = LayoutInflater.from(this.a).inflate(R.layout.video_splash_layout, (ViewGroup) null);
            inflate.setLayoutParams(new RelativeLayout.LayoutParams(-1, (int) (n.i(this.a) * d2)));
            ScaleVideoView scaleVideoView = (ScaleVideoView) inflate.findViewById(R.id.video);
            this.f22522f = scaleVideoView;
            scaleVideoView.setOnErrorListener(new b(this));
            this.f22522f.setOnCompletionListener(new c(this));
            this.f22522f.setOnPreparedListener(new d(this));
            TextView textView = (TextView) inflate.findViewById(R.id.skip);
            this.f22521e = textView;
            textView.setOnClickListener(new e(this));
            String p = c.a.s0.s.g0.b.j().p("key_video_splash_config", "");
            o0 o0Var = new o0();
            o0Var.g(p);
            String c2 = o0Var.c();
            View findViewById = inflate.findViewById(R.id.tip_container);
            this.f22519c = findViewById;
            findViewById.setOnClickListener(new View$OnClickListenerC1342f(this, c2));
            this.f22520d = (TextView) inflate.findViewById(R.id.tip_text);
            String b2 = o0Var.b();
            if (m.isEmpty(b2)) {
                b2 = this.a.getString(R.string.video_splash_tip_default);
            }
            this.f22520d.setText(b2);
            s();
            return inflate;
        }
        return (View) invokeCommon.objValue;
    }

    public View k(double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Double.valueOf(d2)})) == null) {
            if (this.f22518b == null) {
                this.f22518b = j(d2);
            }
            return this.f22518b;
        }
        return (View) invokeCommon.objValue;
    }

    public final void l() {
        ScaleVideoView scaleVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (scaleVideoView = this.f22522f) == null) {
            return;
        }
        scaleVideoView.setBackgroundResource(0);
    }

    public final void m() {
        c.a.t0.r3.g.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (dVar = this.f22525i) == null || m.isEmpty(dVar.i())) {
            return;
        }
        this.f22522f.setVideoPath(this.f22525i.i());
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            c.a.d.f.m.e.a().removeCallbacks(this.l);
        }
    }

    public void o() {
        ScaleVideoView scaleVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (scaleVideoView = this.f22522f) == null) {
            return;
        }
        this.f22526j = scaleVideoView.getCurrentPosition();
        this.f22522f.stopPlayback();
        if (this.f22527k) {
            s();
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f22527k = true;
            ScaleVideoView scaleVideoView = this.f22522f;
            if (scaleVideoView != null) {
                scaleVideoView.resume();
            }
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            c.a.t0.r3.g.a aVar = this.f22524h;
            if (aVar != null) {
                aVar.g(System.currentTimeMillis());
            }
            int i2 = this.f22526j;
            if (i2 >= 0) {
                this.f22522f.seekTo(i2);
            }
            this.f22522f.start();
        }
    }

    public void r(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, gVar) == null) {
            this.f22523g = gVar;
        }
    }

    public final void s() {
        c.a.t0.r3.g.d dVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (dVar = this.f22525i) != null && dVar.l()) {
            try {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(this.f22525i.i());
                Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(0L);
                if (this.f22522f != null) {
                    this.f22522f.setBackgroundDrawable(new BitmapDrawable(frameAtTime));
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                ScaleVideoView scaleVideoView = this.f22522f;
                if (scaleVideoView != null) {
                    scaleVideoView.setBackgroundColor(this.a.getResources().getColor(R.color.CAM_X0101));
                }
            }
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            TiebaStatic.log(new StatisticItem("c12944"));
            c.a.d.f.m.e.a().postDelayed(this.l, 1000L);
            m();
        }
    }
}

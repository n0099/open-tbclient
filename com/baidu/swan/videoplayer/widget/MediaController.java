package com.baidu.swan.videoplayer.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.videoplayer.SwanVideoView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes8.dex */
public class MediaController extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public View.OnClickListener B;
    public boolean C;
    public boolean D;
    public boolean E;
    public LinearLayout F;
    public LinearLayout G;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f45730e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f45731f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f45732g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f45733h;

    /* renamed from: i  reason: collision with root package name */
    public SeekBar f45734i;
    public TextView j;
    public View k;
    public TextView l;
    public ImageView m;
    public ImageView n;
    public ImageView o;
    public TextView p;
    public View q;
    public long r;
    public Timer s;
    public Handler t;
    public Timer u;
    public SwanVideoView v;
    public boolean w;
    public boolean x;
    public b.a.p0.y.j.a y;
    public boolean z;

    /* loaded from: classes8.dex */
    public class a extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MediaController f45735e;

        /* renamed from: com.baidu.swan.videoplayer.widget.MediaController$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC1739a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f45736e;

            public RunnableC1739a(a aVar) {
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
                this.f45736e = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f45736e.f45735e.hide();
                }
            }
        }

        public a(MediaController mediaController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mediaController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45735e = mediaController;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f45735e.getMainThreadHandler().post(new RunnableC1739a(this));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MediaController f45737e;

        public b(MediaController mediaController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mediaController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45737e = mediaController;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f45737e.v == null) {
                return;
            }
            if (this.f45737e.v.isPlaying()) {
                if (this.f45737e.f45730e.getVisibility() == 0) {
                    this.f45737e.f45730e.setImageResource(b.a.p0.y.e.swanapp_video_btn_play);
                }
                if (this.f45737e.m.getVisibility() == 0) {
                    this.f45737e.m.setImageResource(b.a.p0.y.e.swanapp_video_btn_play);
                }
                this.f45737e.v.pause();
                return;
            }
            if (this.f45737e.f45730e.getVisibility() == 0) {
                this.f45737e.f45730e.setImageResource(b.a.p0.y.e.swanapp_video_btn_pause);
            }
            if (this.f45737e.m.getVisibility() == 0) {
                this.f45737e.m.setImageResource(b.a.p0.y.e.swanapp_video_btn_pause);
            }
            this.f45737e.v.start();
        }
    }

    /* loaded from: classes8.dex */
    public class c implements SeekBar.OnSeekBarChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MediaController f45738e;

        public c(MediaController mediaController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mediaController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45738e = mediaController;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{seekBar, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
                this.f45738e.o(i2);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, seekBar) == null) {
                this.f45738e.w = true;
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, seekBar) == null) {
                if (this.f45738e.v.getDuration() > 0) {
                    this.f45738e.r = seekBar.getProgress();
                    if (this.f45738e.v != null) {
                        this.f45738e.v.seekTo(seekBar.getProgress());
                    }
                }
                this.f45738e.w = false;
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MediaController f45739e;

        public d(MediaController mediaController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mediaController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45739e = mediaController;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                boolean z = !this.f45739e.v.isMute();
                if (this.f45739e.v != null) {
                    this.f45739e.v.setMuted(z);
                }
                if (this.f45739e.y != null) {
                    this.f45739e.y.a(z);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MediaController f45740e;

        public e(MediaController mediaController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mediaController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45740e = mediaController;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f45740e.y == null) {
                return;
            }
            this.f45740e.y.c(!this.f45740e.z);
        }
    }

    /* loaded from: classes8.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MediaController f45741e;

        public f(MediaController mediaController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mediaController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45741e = mediaController;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && this.f45741e.z && this.f45741e.y != null) {
                this.f45741e.y.c(false);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MediaController f45742e;

        public g(MediaController mediaController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mediaController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45742e = mediaController;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f45742e.m();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MediaController f45743e;

        public h(MediaController mediaController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mediaController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45743e = mediaController;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f45743e.v.showRateLayer();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MediaController f45744e;

        public i(MediaController mediaController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mediaController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45744e = mediaController;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f45744e.v.showSettingLayer();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class j extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MediaController f45745e;

        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ j f45746e;

            public a(j jVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {jVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f45746e = jVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (this.f45746e.f45745e.v != null && this.f45746e.f45745e.v.getVideoPlayerCallback() != null) {
                        this.f45746e.f45745e.v.getVideoPlayerCallback().b(this.f45746e.f45745e.v);
                    }
                    this.f45746e.f45745e.onPositionUpdate();
                }
            }
        }

        public j(MediaController mediaController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mediaController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45745e = mediaController;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f45745e.getMainThreadHandler().post(new a(this));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediaController(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.x = false;
        this.z = false;
        this.A = false;
        i();
    }

    public static String formatTimeText(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65544, null, i2)) == null) {
            if (i2 < 0) {
                return "";
            }
            int i3 = i2 / 1000;
            int i4 = i3 / 3600;
            int i5 = (i3 % 3600) / 60;
            int i6 = i3 % 60;
            return i4 != 0 ? String.format(Locale.US, "%02d:%02d:%02d", Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)) : String.format(Locale.US, "%02d:%02d", Integer.valueOf(i5), Integer.valueOf(i6));
        }
        return (String) invokeI.objValue;
    }

    private void setMax(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65547, this, i2) == null) || this.x) {
            return;
        }
        SeekBar seekBar = this.f45734i;
        if (seekBar != null) {
            seekBar.setMax(i2);
        }
        n(i2);
        if (i2 > 0) {
            this.x = true;
        }
    }

    public void bindMediaControl(SwanVideoView swanVideoView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, swanVideoView) == null) {
            this.v = swanVideoView;
        }
    }

    public Handler getMainThreadHandler() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.t == null) {
                this.t = new Handler(Looper.getMainLooper());
            }
            return this.t;
        }
        return (Handler) invokeV.objValue;
    }

    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            setVisibility(8);
        }
    }

    public void hideOuterAfterSeconds() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            j();
            Timer timer = this.u;
            if (timer != null) {
                timer.cancel();
                this.u = null;
            }
            Timer timer2 = new Timer();
            this.u = timer2;
            timer2.schedule(new a(this), 3000L);
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(b.a.p0.y.g.swanapp_media_controller_layer, this);
            this.F = (LinearLayout) inflate.findViewById(b.a.p0.y.f.swanapp_video_controller_title_bar);
            this.G = (LinearLayout) inflate.findViewById(b.a.p0.y.f.swanapp_video_controller_bottom_bar);
            this.B = new b(this);
            ImageView imageView = (ImageView) inflate.findViewById(b.a.p0.y.f.swanapp_video_controller_btn_play);
            this.f45730e = imageView;
            imageView.setOnClickListener(this.B);
            ImageView imageView2 = (ImageView) inflate.findViewById(b.a.p0.y.f.swanapp_video_controller_btn_play_mini);
            this.m = imageView2;
            imageView2.setOnClickListener(this.B);
            this.f45733h = (TextView) inflate.findViewById(b.a.p0.y.f.swanapp_video_controller_tv_position);
            this.f45734i = (SeekBar) inflate.findViewById(b.a.p0.y.f.swanapp_video_controller_seekbar);
            this.j = (TextView) inflate.findViewById(b.a.p0.y.f.swanapp_video_controller_tv_duration);
            this.f45734i.setOnSeekBarChangeListener(new c(this));
            this.f45732g = (ImageView) inflate.findViewById(b.a.p0.y.f.swanapp_video_controller_btn_mute);
            SwanVideoView swanVideoView = this.v;
            this.f45732g.setImageResource(swanVideoView != null && swanVideoView.isMute() ? b.a.p0.y.e.swanapp_video_mute_on : b.a.p0.y.e.swanapp_video_mute_off);
            this.f45732g.setOnClickListener(new d(this));
            ImageView imageView3 = (ImageView) inflate.findViewById(b.a.p0.y.f.swanapp_video_controller_btn_toggle_screen);
            this.f45731f = imageView3;
            imageView3.setOnClickListener(new e(this));
            this.f45734i.setEnabled(false);
            this.f45730e.setEnabled(false);
            this.m.setEnabled(false);
            View findViewById = inflate.findViewById(b.a.p0.y.f.swanapp_video_controller_btn_back);
            this.k = findViewById;
            findViewById.setOnClickListener(new f(this));
            TextView textView = (TextView) inflate.findViewById(b.a.p0.y.f.swanapp_video_controller_tv_title);
            this.l = textView;
            textView.setVisibility(4);
            this.k.setVisibility(8);
            ImageView imageView4 = (ImageView) inflate.findViewById(b.a.p0.y.f.swanapp_video_controller_btn_danmu);
            this.n = imageView4;
            imageView4.setVisibility(8);
            ImageView imageView5 = (ImageView) inflate.findViewById(b.a.p0.y.f.swanapp_video_controller_btn_lock);
            this.o = imageView5;
            imageView5.setVisibility(8);
            this.o.setOnClickListener(new g(this));
            TextView textView2 = (TextView) inflate.findViewById(b.a.p0.y.f.swanapp_video_controller_tv_rate);
            this.p = textView2;
            textView2.setOnClickListener(new h(this));
            View findViewById2 = inflate.findViewById(b.a.p0.y.f.swanapp_video_controller_btn_setting);
            this.q = findViewById2;
            findViewById2.setVisibility(8);
            this.q.setOnClickListener(new i(this));
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.v == null) {
            return;
        }
        setProgress((int) this.r);
        setVisibility(0);
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            Timer timer = this.s;
            if (timer != null) {
                timer.cancel();
                this.s = null;
            }
            Timer timer2 = new Timer();
            this.s = timer2;
            timer2.schedule(new j(this), 0L, 1000L);
        }
    }

    public final void l() {
        Timer timer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (timer = this.s) == null) {
            return;
        }
        timer.cancel();
        this.s = null;
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            boolean z = !this.C;
            this.C = z;
            if (z) {
                this.o.setImageResource(b.a.p0.y.e.swanapp_video_btn_lock);
                this.F.setVisibility(8);
                this.G.setVisibility(8);
                this.p.setVisibility(8);
                this.f45730e.setVisibility(8);
            } else {
                this.o.setImageResource(b.a.p0.y.e.swanapp_video_btn_unlock);
                this.F.setVisibility(0);
                this.G.setVisibility(0);
                this.p.setVisibility(this.D ? 0 : 8);
                this.f45730e.setVisibility(this.E ? 0 : 8);
            }
            SwanVideoView swanVideoView = this.v;
            if (swanVideoView != null) {
                swanVideoView.updateLockState(this.C);
            }
        }
    }

    public final void n(int i2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048585, this, i2) == null) || (textView = this.j) == null) {
            return;
        }
        textView.setText(formatTimeText(i2));
    }

    public final void o(int i2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048586, this, i2) == null) || (textView = this.f45733h) == null) {
            return;
        }
        textView.setText(formatTimeText(i2));
    }

    public void onPositionUpdate() {
        SwanVideoView swanVideoView;
        int duration;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (swanVideoView = this.v) == null || this.w) {
            return;
        }
        long currentPosition = swanVideoView.getCurrentPosition();
        if (currentPosition >= 0) {
            this.r = currentPosition;
        }
        if (getVisibility() == 0 && (duration = this.v.getDuration()) > 0) {
            setMax(duration);
            setProgress((int) currentPosition);
        }
    }

    public void onTotalCacheUpdate(int i2) {
        SeekBar seekBar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048588, this, i2) == null) || (seekBar = this.f45734i) == null || i2 == seekBar.getSecondaryProgress()) {
            return;
        }
        this.f45734i.setSecondaryProgress(i2);
    }

    public void onVideoOrientationChange(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.z = z;
            this.f45731f.setImageResource(z ? b.a.p0.y.e.swanapp_video_btn_halfscreen : b.a.p0.y.e.swanapp_video_btn_fullscreen);
            int i2 = 8;
            if (this.z) {
                this.l.setVisibility(0);
                this.k.setVisibility(0);
                this.o.setVisibility(0);
                this.q.setVisibility(this.A ? 0 : 8);
                this.F.setVisibility(this.C ? 8 : 0);
                this.G.setVisibility(this.C ? 8 : 0);
                this.f45730e.setVisibility((this.C || !this.E) ? 8 : 0);
                TextView textView = this.p;
                if (!this.C && this.D) {
                    i2 = 0;
                }
                textView.setVisibility(i2);
                return;
            }
            this.l.setVisibility(4);
            this.k.setVisibility(8);
            this.o.setVisibility(8);
            this.G.setVisibility(0);
            this.p.setVisibility(this.D ? 0 : 8);
            this.q.setVisibility(8);
        }
    }

    public void setMute(boolean z) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048590, this, z) == null) || (imageView = this.f45732g) == null) {
            return;
        }
        imageView.setImageResource(z ? b.a.p0.y.e.swanapp_video_mute_on : b.a.p0.y.e.swanapp_video_mute_off);
    }

    public void setProgress(int i2) {
        SeekBar seekBar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048591, this, i2) == null) || (seekBar = this.f45734i) == null) {
            return;
        }
        seekBar.setProgress(i2);
    }

    public void setTitle(String str) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, str) == null) || (textView = this.l) == null) {
            return;
        }
        textView.setText(str);
    }

    public void setToggleScreenListener(b.a.p0.y.j.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, aVar) == null) {
            this.y = aVar;
        }
    }

    public void showCenterPlayButton(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            this.E = z;
            ImageView imageView = this.f45730e;
            if (imageView != null) {
                imageView.setVisibility(z ? 0 : 8);
            }
        }
    }

    public void showDanmuButton(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
        }
    }

    public void showMuteButton(boolean z) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048596, this, z) == null) || (imageView = this.f45732g) == null) {
            return;
        }
        imageView.setVisibility(z ? 0 : 8);
    }

    public void showPlayButton(boolean z) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048597, this, z) == null) || (imageView = this.m) == null) {
            return;
        }
        imageView.setVisibility(z ? 0 : 8);
    }

    public void showRateButton(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            this.D = z;
            TextView textView = this.p;
            if (textView != null) {
                textView.setVisibility(z ? 0 : 8);
            }
        }
    }

    public void showSeekBar(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            SeekBar seekBar = this.f45734i;
            if (seekBar != null) {
                seekBar.setVisibility(z ? 0 : 4);
            }
            TextView textView = this.j;
            if (textView != null) {
                textView.setVisibility(z ? 0 : 4);
            }
            TextView textView2 = this.f45733h;
            if (textView2 != null) {
                textView2.setVisibility(z ? 0 : 4);
            }
        }
    }

    public void showSettingButton(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            this.A = z;
        }
    }

    public void showToggleScreenButton(boolean z) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048601, this, z) == null) || (imageView = this.f45731f) == null) {
            return;
        }
        imageView.setVisibility(z ? 0 : 8);
    }

    public void updateState() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            int currentPlayerState = this.v.getCurrentPlayerState();
            this.x = false;
            switch (currentPlayerState) {
                case -1:
                case 0:
                    l();
                    this.f45730e.setEnabled(true);
                    this.f45730e.setImageResource(b.a.p0.y.e.swanapp_video_btn_play);
                    this.m.setEnabled(true);
                    this.m.setImageResource(b.a.p0.y.e.swanapp_video_btn_play);
                    this.f45734i.setEnabled(false);
                    SwanVideoView swanVideoView = this.v;
                    o(swanVideoView == null ? 0 : swanVideoView.getCurrentPosition());
                    SwanVideoView swanVideoView2 = this.v;
                    n(swanVideoView2 != null ? swanVideoView2.getDuration() : 0);
                    return;
                case 1:
                    this.f45730e.setEnabled(false);
                    this.m.setEnabled(false);
                    this.f45734i.setEnabled(false);
                    return;
                case 2:
                    this.f45730e.setEnabled(true);
                    this.f45730e.setImageResource(b.a.p0.y.e.swanapp_video_btn_play);
                    this.m.setEnabled(true);
                    this.m.setImageResource(b.a.p0.y.e.swanapp_video_btn_play);
                    this.f45734i.setEnabled(true);
                    SwanVideoView swanVideoView3 = this.v;
                    n(swanVideoView3 == null ? 0 : swanVideoView3.getDuration());
                    SeekBar seekBar = this.f45734i;
                    SwanVideoView swanVideoView4 = this.v;
                    seekBar.setMax(swanVideoView4 != null ? swanVideoView4.getDuration() : 0);
                    return;
                case 3:
                    k();
                    this.f45734i.setEnabled(true);
                    this.f45730e.setEnabled(true);
                    this.f45730e.setImageResource(b.a.p0.y.e.swanapp_video_btn_pause);
                    this.m.setEnabled(true);
                    this.m.setImageResource(b.a.p0.y.e.swanapp_video_btn_pause);
                    return;
                case 4:
                    this.f45730e.setEnabled(true);
                    this.f45730e.setImageResource(b.a.p0.y.e.swanapp_video_btn_play);
                    this.m.setEnabled(true);
                    this.m.setImageResource(b.a.p0.y.e.swanapp_video_btn_play);
                    return;
                case 5:
                    l();
                    SeekBar seekBar2 = this.f45734i;
                    seekBar2.setProgress(seekBar2.getMax());
                    this.f45734i.setEnabled(false);
                    this.f45730e.setEnabled(true);
                    this.f45730e.setImageResource(b.a.p0.y.e.swanapp_video_btn_play);
                    this.m.setEnabled(true);
                    this.m.setImageResource(b.a.p0.y.e.swanapp_video_btn_play);
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediaController(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.x = false;
        this.z = false;
        this.A = false;
        i();
    }
}

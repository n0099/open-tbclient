package com.baidu.swan.videoplayer.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
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
/* loaded from: classes3.dex */
public class MediaController extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ImageButton f12139e;

    /* renamed from: f  reason: collision with root package name */
    public View f12140f;

    /* renamed from: g  reason: collision with root package name */
    public View f12141g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f12142h;

    /* renamed from: i  reason: collision with root package name */
    public SeekBar f12143i;
    public TextView j;
    public long k;
    public Timer l;
    public Handler m;
    public Timer n;
    public SwanVideoView o;
    public boolean p;
    public boolean q;
    public d.a.o0.v.h.a r;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MediaController f12144e;

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
            this.f12144e = mediaController;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f12144e.o == null) {
                return;
            }
            if (this.f12144e.o.v()) {
                this.f12144e.f12139e.setBackgroundResource(d.a.o0.v.c.btn_play);
                this.f12144e.o.x();
                return;
            }
            Log.d("SimpleMediaController", "mPlayButton clicked : to resume");
            this.f12144e.f12139e.setBackgroundResource(d.a.o0.v.c.btn_pause);
            this.f12144e.o.C();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements SeekBar.OnSeekBarChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MediaController f12145e;

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
            this.f12145e = mediaController;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{seekBar, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
                this.f12145e.r(i2);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, seekBar) == null) {
                this.f12145e.p = true;
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, seekBar) == null) {
                if (this.f12145e.o.getDuration() > 0) {
                    this.f12145e.k = seekBar.getProgress();
                    if (this.f12145e.o != null) {
                        this.f12145e.o.B(seekBar.getProgress());
                    }
                }
                this.f12145e.p = false;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MediaController f12146e;

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
            this.f12146e = mediaController;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f12146e.o == null) {
                return;
            }
            this.f12146e.o.setMuted(!this.f12146e.o.u());
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public boolean f12147e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ MediaController f12148f;

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
            this.f12148f = mediaController;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f12147e = !this.f12147e;
                if (this.f12148f.r != null) {
                    this.f12148f.r.b(this.f12147e);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MediaController f12149e;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ e f12150e;

            public a(e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f12150e = eVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (this.f12150e.f12149e.o != null && this.f12150e.f12149e.o.getVideoPlayerCallback() != null) {
                        this.f12150e.f12149e.o.getVideoPlayerCallback().a(this.f12150e.f12149e.o);
                    }
                    this.f12150e.f12149e.k();
                }
            }
        }

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
            this.f12149e = mediaController;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f12149e.getMainThreadHandler().post(new a(this));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MediaController f12151e;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ f f12152e;

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
                this.f12152e = fVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f12152e.f12151e.h();
                }
            }
        }

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
            this.f12151e = mediaController;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f12151e.getMainThreadHandler().post(new a(this));
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
        this.q = false;
        j();
    }

    public static String g(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65543, null, i2)) == null) {
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
        if (!(interceptable == null || interceptable.invokeI(65544, this, i2) == null) || this.q) {
            return;
        }
        SeekBar seekBar = this.f12143i;
        if (seekBar != null) {
            seekBar.setMax(i2);
        }
        q(i2);
        if (i2 > 0) {
            this.q = true;
        }
    }

    public void f(SwanVideoView swanVideoView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, swanVideoView) == null) {
            this.o = swanVideoView;
        }
    }

    public Handler getMainThreadHandler() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.m == null) {
                this.m = new Handler(Looper.getMainLooper());
            }
            return this.m;
        }
        return (Handler) invokeV.objValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            setVisibility(8);
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            n();
            Timer timer = this.n;
            if (timer != null) {
                timer.cancel();
                this.n = null;
            }
            Timer timer2 = new Timer();
            this.n = timer2;
            timer2.schedule(new f(this), 3000L);
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(d.a.o0.v.e.media_controller, this);
            ImageButton imageButton = (ImageButton) inflate.findViewById(d.a.o0.v.d.btn_play);
            this.f12139e = imageButton;
            imageButton.setOnClickListener(new a(this));
            this.f12142h = (TextView) inflate.findViewById(d.a.o0.v.d.tv_position);
            this.f12143i = (SeekBar) inflate.findViewById(d.a.o0.v.d.seekbar);
            this.j = (TextView) inflate.findViewById(d.a.o0.v.d.tv_duration);
            this.f12143i.setOnSeekBarChangeListener(new b(this));
            this.f12141g = inflate.findViewById(d.a.o0.v.d.btn_mute);
            SwanVideoView swanVideoView = this.o;
            this.f12141g.setBackgroundResource(swanVideoView != null && swanVideoView.u() ? d.a.o0.v.c.mute_on : d.a.o0.v.c.mute_off);
            this.f12141g.setOnClickListener(new c(this));
            View findViewById = inflate.findViewById(d.a.o0.v.d.btn_toggle_screen);
            this.f12140f = findViewById;
            findViewById.setOnClickListener(new d(this));
            this.f12143i.setEnabled(false);
            this.f12139e.setEnabled(false);
        }
    }

    public void k() {
        SwanVideoView swanVideoView;
        int duration;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (swanVideoView = this.o) == null || this.p) {
            return;
        }
        long currentPosition = swanVideoView.getCurrentPosition();
        if (currentPosition > 0) {
            this.k = currentPosition;
        }
        if (getVisibility() == 0 && (duration = this.o.getDuration()) > 0) {
            setMax(duration);
            setProgress((int) currentPosition);
        }
    }

    public void l(int i2) {
        SeekBar seekBar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048582, this, i2) == null) || (seekBar = this.f12143i) == null || i2 == seekBar.getSecondaryProgress()) {
            return;
        }
        this.f12143i.setSecondaryProgress(i2);
    }

    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.f12140f.setBackgroundResource(z ? d.a.o0.v.c.btn_halfscreen : d.a.o0.v.c.btn_fullscreen);
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.o == null) {
            return;
        }
        setProgress((int) this.k);
        setVisibility(0);
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            Timer timer = this.l;
            if (timer != null) {
                timer.cancel();
                this.l = null;
            }
            Timer timer2 = new Timer();
            this.l = timer2;
            timer2.schedule(new e(this), 0L, 1000L);
        }
    }

    public final void p() {
        Timer timer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (timer = this.l) == null) {
            return;
        }
        timer.cancel();
        this.l = null;
    }

    public final void q(int i2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048587, this, i2) == null) || (textView = this.j) == null) {
            return;
        }
        textView.setText(g(i2));
    }

    public final void r(int i2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048588, this, i2) == null) || (textView = this.f12142h) == null) {
            return;
        }
        textView.setText(g(i2));
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            int currentPlayerState = this.o.getCurrentPlayerState();
            this.q = false;
            switch (currentPlayerState) {
                case -1:
                case 0:
                    p();
                    this.f12139e.setEnabled(true);
                    this.f12139e.setBackgroundResource(d.a.o0.v.c.btn_play);
                    this.f12143i.setEnabled(false);
                    SwanVideoView swanVideoView = this.o;
                    r(swanVideoView == null ? 0 : swanVideoView.getCurrentPosition());
                    SwanVideoView swanVideoView2 = this.o;
                    q(swanVideoView2 != null ? swanVideoView2.getDuration() : 0);
                    return;
                case 1:
                    this.f12139e.setEnabled(false);
                    this.f12143i.setEnabled(false);
                    return;
                case 2:
                    this.f12139e.setEnabled(true);
                    this.f12139e.setBackgroundResource(d.a.o0.v.c.btn_play);
                    this.f12143i.setEnabled(true);
                    SwanVideoView swanVideoView3 = this.o;
                    q(swanVideoView3 == null ? 0 : swanVideoView3.getDuration());
                    SeekBar seekBar = this.f12143i;
                    SwanVideoView swanVideoView4 = this.o;
                    seekBar.setMax(swanVideoView4 != null ? swanVideoView4.getDuration() : 0);
                    return;
                case 3:
                    o();
                    this.f12143i.setEnabled(true);
                    this.f12139e.setEnabled(true);
                    this.f12139e.setBackgroundResource(d.a.o0.v.c.btn_pause);
                    return;
                case 4:
                    this.f12139e.setEnabled(true);
                    this.f12139e.setBackgroundResource(d.a.o0.v.c.btn_play);
                    return;
                case 5:
                    p();
                    SeekBar seekBar2 = this.f12143i;
                    seekBar2.setProgress(seekBar2.getMax());
                    this.f12143i.setEnabled(false);
                    this.f12139e.setEnabled(true);
                    this.f12139e.setBackgroundResource(d.a.o0.v.c.btn_play);
                    return;
                default:
                    return;
            }
        }
    }

    public void setMute(boolean z) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048590, this, z) == null) || (view = this.f12141g) == null) {
            return;
        }
        view.setBackgroundResource(z ? d.a.o0.v.c.mute_on : d.a.o0.v.c.mute_off);
    }

    public void setProgress(int i2) {
        SeekBar seekBar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048591, this, i2) == null) || (seekBar = this.f12143i) == null) {
            return;
        }
        seekBar.setProgress(i2);
    }

    public void setToggleScreenListener(d.a.o0.v.h.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, aVar) == null) {
            this.r = aVar;
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
        this.q = false;
        j();
    }
}

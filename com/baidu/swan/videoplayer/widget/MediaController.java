package com.baidu.swan.videoplayer.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
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
/* loaded from: classes6.dex */
public class MediaController extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ImageButton f47157e;

    /* renamed from: f  reason: collision with root package name */
    public View f47158f;

    /* renamed from: g  reason: collision with root package name */
    public View f47159g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f47160h;

    /* renamed from: i  reason: collision with root package name */
    public SeekBar f47161i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f47162j;
    public long k;
    public Timer l;
    public Handler m;
    public Timer n;
    public SwanVideoView o;
    public boolean p;
    public boolean q;
    public c.a.o0.v.h.a r;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MediaController f47163e;

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
            this.f47163e = mediaController;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f47163e.o == null) {
                return;
            }
            if (this.f47163e.o.isPlaying()) {
                this.f47163e.f47157e.setBackgroundResource(c.a.o0.v.c.btn_play);
                this.f47163e.o.pause();
                return;
            }
            this.f47163e.f47157e.setBackgroundResource(c.a.o0.v.c.btn_pause);
            this.f47163e.o.start();
        }
    }

    /* loaded from: classes6.dex */
    public class b implements SeekBar.OnSeekBarChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MediaController f47164e;

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
            this.f47164e = mediaController;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{seekBar, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
                this.f47164e.k(i2);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, seekBar) == null) {
                this.f47164e.p = true;
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, seekBar) == null) {
                if (this.f47164e.o.getDuration() > 0) {
                    this.f47164e.k = seekBar.getProgress();
                    if (this.f47164e.o != null) {
                        this.f47164e.o.seekTo(seekBar.getProgress());
                    }
                }
                this.f47164e.p = false;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MediaController f47165e;

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
            this.f47165e = mediaController;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f47165e.o == null) {
                return;
            }
            this.f47165e.o.setMuted(!this.f47165e.o.isMute());
        }
    }

    /* loaded from: classes6.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public boolean f47166e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ MediaController f47167f;

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
            this.f47167f = mediaController;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f47166e = !this.f47166e;
                if (this.f47167f.r != null) {
                    this.f47167f.r.b(this.f47166e);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MediaController f47168e;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ e f47169e;

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
                this.f47169e = eVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (this.f47169e.f47168e.o != null && this.f47169e.f47168e.o.getVideoPlayerCallback() != null) {
                        this.f47169e.f47168e.o.getVideoPlayerCallback().a(this.f47169e.f47168e.o);
                    }
                    this.f47169e.f47168e.onPositionUpdate();
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
            this.f47168e = mediaController;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f47168e.getMainThreadHandler().post(new a(this));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MediaController f47170e;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ f f47171e;

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
                this.f47171e = fVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f47171e.f47170e.hide();
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
            this.f47170e = mediaController;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f47170e.getMainThreadHandler().post(new a(this));
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
        f();
    }

    public static String formatTimeText(int i2) {
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
        SeekBar seekBar = this.f47161i;
        if (seekBar != null) {
            seekBar.setMax(i2);
        }
        j(i2);
        if (i2 > 0) {
            this.q = true;
        }
    }

    public void bindMediaControl(SwanVideoView swanVideoView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, swanVideoView) == null) {
            this.o = swanVideoView;
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(c.a.o0.v.e.media_controller, this);
            ImageButton imageButton = (ImageButton) inflate.findViewById(c.a.o0.v.d.btn_play);
            this.f47157e = imageButton;
            imageButton.setOnClickListener(new a(this));
            this.f47160h = (TextView) inflate.findViewById(c.a.o0.v.d.tv_position);
            this.f47161i = (SeekBar) inflate.findViewById(c.a.o0.v.d.seekbar);
            this.f47162j = (TextView) inflate.findViewById(c.a.o0.v.d.tv_duration);
            this.f47161i.setOnSeekBarChangeListener(new b(this));
            this.f47159g = inflate.findViewById(c.a.o0.v.d.btn_mute);
            SwanVideoView swanVideoView = this.o;
            this.f47159g.setBackgroundResource(swanVideoView != null && swanVideoView.isMute() ? c.a.o0.v.c.mute_on : c.a.o0.v.c.mute_off);
            this.f47159g.setOnClickListener(new c(this));
            View findViewById = inflate.findViewById(c.a.o0.v.d.btn_toggle_screen);
            this.f47158f = findViewById;
            findViewById.setOnClickListener(new d(this));
            this.f47161i.setEnabled(false);
            this.f47157e.setEnabled(false);
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.o == null) {
            return;
        }
        setProgress((int) this.k);
        setVisibility(0);
    }

    public Handler getMainThreadHandler() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.m == null) {
                this.m = new Handler(Looper.getMainLooper());
            }
            return this.m;
        }
        return (Handler) invokeV.objValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
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

    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            setVisibility(8);
        }
    }

    public void hideOuterAfterSeconds() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            g();
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

    public final void i() {
        Timer timer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (timer = this.l) == null) {
            return;
        }
        timer.cancel();
        this.l = null;
    }

    public final void j(int i2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) || (textView = this.f47162j) == null) {
            return;
        }
        textView.setText(formatTimeText(i2));
    }

    public final void k(int i2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048585, this, i2) == null) || (textView = this.f47160h) == null) {
            return;
        }
        textView.setText(formatTimeText(i2));
    }

    public void onPositionUpdate() {
        SwanVideoView swanVideoView;
        int duration;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (swanVideoView = this.o) == null || this.p) {
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

    public void onTotalCacheUpdate(int i2) {
        SeekBar seekBar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048587, this, i2) == null) || (seekBar = this.f47161i) == null || i2 == seekBar.getSecondaryProgress()) {
            return;
        }
        this.f47161i.setSecondaryProgress(i2);
    }

    public void onVideoOrientationChange(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.f47158f.setBackgroundResource(z ? c.a.o0.v.c.btn_halfscreen : c.a.o0.v.c.btn_fullscreen);
        }
    }

    public void setMute(boolean z) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048589, this, z) == null) || (view = this.f47159g) == null) {
            return;
        }
        view.setBackgroundResource(z ? c.a.o0.v.c.mute_on : c.a.o0.v.c.mute_off);
    }

    public void setProgress(int i2) {
        SeekBar seekBar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048590, this, i2) == null) || (seekBar = this.f47161i) == null) {
            return;
        }
        seekBar.setProgress(i2);
    }

    public void setToggleScreenListener(c.a.o0.v.h.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, aVar) == null) {
            this.r = aVar;
        }
    }

    public void updateState() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            int currentPlayerState = this.o.getCurrentPlayerState();
            this.q = false;
            switch (currentPlayerState) {
                case -1:
                case 0:
                    i();
                    this.f47157e.setEnabled(true);
                    this.f47157e.setBackgroundResource(c.a.o0.v.c.btn_play);
                    this.f47161i.setEnabled(false);
                    SwanVideoView swanVideoView = this.o;
                    k(swanVideoView == null ? 0 : swanVideoView.getCurrentPosition());
                    SwanVideoView swanVideoView2 = this.o;
                    j(swanVideoView2 != null ? swanVideoView2.getDuration() : 0);
                    return;
                case 1:
                    this.f47157e.setEnabled(false);
                    this.f47161i.setEnabled(false);
                    return;
                case 2:
                    this.f47157e.setEnabled(true);
                    this.f47157e.setBackgroundResource(c.a.o0.v.c.btn_play);
                    this.f47161i.setEnabled(true);
                    SwanVideoView swanVideoView3 = this.o;
                    j(swanVideoView3 == null ? 0 : swanVideoView3.getDuration());
                    SeekBar seekBar = this.f47161i;
                    SwanVideoView swanVideoView4 = this.o;
                    seekBar.setMax(swanVideoView4 != null ? swanVideoView4.getDuration() : 0);
                    return;
                case 3:
                    h();
                    this.f47161i.setEnabled(true);
                    this.f47157e.setEnabled(true);
                    this.f47157e.setBackgroundResource(c.a.o0.v.c.btn_pause);
                    return;
                case 4:
                    this.f47157e.setEnabled(true);
                    this.f47157e.setBackgroundResource(c.a.o0.v.c.btn_play);
                    return;
                case 5:
                    i();
                    SeekBar seekBar2 = this.f47161i;
                    seekBar2.setProgress(seekBar2.getMax());
                    this.f47161i.setEnabled(false);
                    this.f47157e.setEnabled(true);
                    this.f47157e.setBackgroundResource(c.a.o0.v.c.btn_play);
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
        this.q = false;
        f();
    }
}

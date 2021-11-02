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
/* loaded from: classes8.dex */
public class MediaController extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ImageButton f44900e;

    /* renamed from: f  reason: collision with root package name */
    public View f44901f;

    /* renamed from: g  reason: collision with root package name */
    public View f44902g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f44903h;

    /* renamed from: i  reason: collision with root package name */
    public SeekBar f44904i;
    public TextView j;
    public long k;
    public Timer l;
    public Handler m;
    public Timer n;
    public SwanVideoView o;
    public boolean p;
    public boolean q;
    public b.a.p0.v.h.a r;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MediaController f44905e;

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
            this.f44905e = mediaController;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f44905e.o == null) {
                return;
            }
            if (this.f44905e.o.isPlaying()) {
                this.f44905e.f44900e.setBackgroundResource(b.a.p0.v.c.btn_play);
                this.f44905e.o.pause();
                return;
            }
            this.f44905e.f44900e.setBackgroundResource(b.a.p0.v.c.btn_pause);
            this.f44905e.o.start();
        }
    }

    /* loaded from: classes8.dex */
    public class b implements SeekBar.OnSeekBarChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MediaController f44906e;

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
            this.f44906e = mediaController;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{seekBar, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
                this.f44906e.k(i2);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, seekBar) == null) {
                this.f44906e.p = true;
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, seekBar) == null) {
                if (this.f44906e.o.getDuration() > 0) {
                    this.f44906e.k = seekBar.getProgress();
                    if (this.f44906e.o != null) {
                        this.f44906e.o.seekTo(seekBar.getProgress());
                    }
                }
                this.f44906e.p = false;
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MediaController f44907e;

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
            this.f44907e = mediaController;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f44907e.o == null) {
                return;
            }
            this.f44907e.o.setMuted(!this.f44907e.o.isMute());
        }
    }

    /* loaded from: classes8.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public boolean f44908e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ MediaController f44909f;

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
            this.f44909f = mediaController;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f44908e = !this.f44908e;
                if (this.f44909f.r != null) {
                    this.f44909f.r.b(this.f44908e);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MediaController f44910e;

        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ e f44911e;

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
                this.f44911e = eVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (this.f44911e.f44910e.o != null && this.f44911e.f44910e.o.getVideoPlayerCallback() != null) {
                        this.f44911e.f44910e.o.getVideoPlayerCallback().a(this.f44911e.f44910e.o);
                    }
                    this.f44911e.f44910e.onPositionUpdate();
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
            this.f44910e = mediaController;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f44910e.getMainThreadHandler().post(new a(this));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MediaController f44912e;

        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ f f44913e;

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
                this.f44913e = fVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f44913e.f44912e.hide();
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
            this.f44912e = mediaController;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f44912e.getMainThreadHandler().post(new a(this));
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
        SeekBar seekBar = this.f44904i;
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
            View inflate = LayoutInflater.from(getContext()).inflate(b.a.p0.v.e.media_controller, this);
            ImageButton imageButton = (ImageButton) inflate.findViewById(b.a.p0.v.d.btn_play);
            this.f44900e = imageButton;
            imageButton.setOnClickListener(new a(this));
            this.f44903h = (TextView) inflate.findViewById(b.a.p0.v.d.tv_position);
            this.f44904i = (SeekBar) inflate.findViewById(b.a.p0.v.d.seekbar);
            this.j = (TextView) inflate.findViewById(b.a.p0.v.d.tv_duration);
            this.f44904i.setOnSeekBarChangeListener(new b(this));
            this.f44902g = inflate.findViewById(b.a.p0.v.d.btn_mute);
            SwanVideoView swanVideoView = this.o;
            this.f44902g.setBackgroundResource(swanVideoView != null && swanVideoView.isMute() ? b.a.p0.v.c.mute_on : b.a.p0.v.c.mute_off);
            this.f44902g.setOnClickListener(new c(this));
            View findViewById = inflate.findViewById(b.a.p0.v.d.btn_toggle_screen);
            this.f44901f = findViewById;
            findViewById.setOnClickListener(new d(this));
            this.f44904i.setEnabled(false);
            this.f44900e.setEnabled(false);
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
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) || (textView = this.j) == null) {
            return;
        }
        textView.setText(formatTimeText(i2));
    }

    public final void k(int i2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048585, this, i2) == null) || (textView = this.f44903h) == null) {
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
        if (!(interceptable == null || interceptable.invokeI(1048587, this, i2) == null) || (seekBar = this.f44904i) == null || i2 == seekBar.getSecondaryProgress()) {
            return;
        }
        this.f44904i.setSecondaryProgress(i2);
    }

    public void onVideoOrientationChange(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.f44901f.setBackgroundResource(z ? b.a.p0.v.c.btn_halfscreen : b.a.p0.v.c.btn_fullscreen);
        }
    }

    public void setMute(boolean z) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048589, this, z) == null) || (view = this.f44902g) == null) {
            return;
        }
        view.setBackgroundResource(z ? b.a.p0.v.c.mute_on : b.a.p0.v.c.mute_off);
    }

    public void setProgress(int i2) {
        SeekBar seekBar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048590, this, i2) == null) || (seekBar = this.f44904i) == null) {
            return;
        }
        seekBar.setProgress(i2);
    }

    public void setToggleScreenListener(b.a.p0.v.h.a aVar) {
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
                    this.f44900e.setEnabled(true);
                    this.f44900e.setBackgroundResource(b.a.p0.v.c.btn_play);
                    this.f44904i.setEnabled(false);
                    SwanVideoView swanVideoView = this.o;
                    k(swanVideoView == null ? 0 : swanVideoView.getCurrentPosition());
                    SwanVideoView swanVideoView2 = this.o;
                    j(swanVideoView2 != null ? swanVideoView2.getDuration() : 0);
                    return;
                case 1:
                    this.f44900e.setEnabled(false);
                    this.f44904i.setEnabled(false);
                    return;
                case 2:
                    this.f44900e.setEnabled(true);
                    this.f44900e.setBackgroundResource(b.a.p0.v.c.btn_play);
                    this.f44904i.setEnabled(true);
                    SwanVideoView swanVideoView3 = this.o;
                    j(swanVideoView3 == null ? 0 : swanVideoView3.getDuration());
                    SeekBar seekBar = this.f44904i;
                    SwanVideoView swanVideoView4 = this.o;
                    seekBar.setMax(swanVideoView4 != null ? swanVideoView4.getDuration() : 0);
                    return;
                case 3:
                    h();
                    this.f44904i.setEnabled(true);
                    this.f44900e.setEnabled(true);
                    this.f44900e.setBackgroundResource(b.a.p0.v.c.btn_pause);
                    return;
                case 4:
                    this.f44900e.setEnabled(true);
                    this.f44900e.setBackgroundResource(b.a.p0.v.c.btn_play);
                    return;
                case 5:
                    i();
                    SeekBar seekBar2 = this.f44904i;
                    seekBar2.setProgress(seekBar2.getMax());
                    this.f44904i.setEnabled(false);
                    this.f44900e.setEnabled(true);
                    this.f44900e.setBackgroundResource(b.a.p0.v.c.btn_play);
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

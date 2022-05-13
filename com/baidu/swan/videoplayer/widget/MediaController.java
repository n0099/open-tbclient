package com.baidu.swan.videoplayer.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
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
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.th4;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes2.dex */
public class MediaController extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public LinearLayout B;
    public LinearLayout C;
    public ImageView a;
    public ImageView b;
    public ImageView c;
    public TextView d;
    public SeekBar e;
    public TextView f;
    public View g;
    public TextView h;
    public ImageView i;
    public ImageView j;
    public ImageView k;
    public TextView l;
    public View m;
    public long n;
    public Timer o;
    public Handler p;
    public Timer q;
    public SwanVideoView r;
    public boolean s;
    public boolean t;
    public th4 u;
    public boolean v;
    public boolean w;
    public View.OnClickListener x;
    public boolean y;
    public boolean z;

    /* loaded from: classes2.dex */
    public class a extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MediaController a;

        /* renamed from: com.baidu.swan.videoplayer.widget.MediaController$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC0167a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public RunnableC0167a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.a.k();
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mediaController;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.getMainThreadHandler().post(new RunnableC0167a(this));
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MediaController a;

        public b(MediaController mediaController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mediaController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mediaController;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.r == null) {
                return;
            }
            if (this.a.r.z()) {
                if (this.a.a.getVisibility() == 0) {
                    this.a.a.setImageResource(R.drawable.obfuscated_res_0x7f0811bc);
                }
                if (this.a.i.getVisibility() == 0) {
                    this.a.i.setImageResource(R.drawable.obfuscated_res_0x7f0811bc);
                }
                this.a.r.C();
                return;
            }
            Log.d("SimpleMediaController", "mPlayButton clicked : to resume");
            if (this.a.a.getVisibility() == 0) {
                this.a.a.setImageResource(R.drawable.obfuscated_res_0x7f0811bb);
            }
            if (this.a.i.getVisibility() == 0) {
                this.a.i.setImageResource(R.drawable.obfuscated_res_0x7f0811bb);
            }
            this.a.r.X();
        }
    }

    /* loaded from: classes2.dex */
    public class c implements SeekBar.OnSeekBarChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MediaController a;

        public c(MediaController mediaController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mediaController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mediaController;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{seekBar, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
                this.a.D(i);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, seekBar) == null) {
                this.a.s = true;
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, seekBar) == null) {
                if (this.a.r.getDuration() > 0) {
                    this.a.n = seekBar.getProgress();
                    if (this.a.r != null) {
                        this.a.r.H(seekBar.getProgress());
                    }
                }
                this.a.s = false;
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MediaController a;

        public d(MediaController mediaController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mediaController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mediaController;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                boolean z = !this.a.r.y();
                if (this.a.r != null) {
                    this.a.r.setMuted(z);
                }
                if (this.a.u != null) {
                    this.a.u.b(z);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MediaController a;

        public e(MediaController mediaController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mediaController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mediaController;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.u == null) {
                return;
            }
            this.a.u.d(!this.a.v);
        }
    }

    /* loaded from: classes2.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MediaController a;

        public f(MediaController mediaController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mediaController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mediaController;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.v && this.a.u != null) {
                this.a.u.d(false);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MediaController a;

        public g(MediaController mediaController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mediaController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mediaController;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.B();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MediaController a;

        public h(MediaController mediaController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mediaController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mediaController;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.r.R();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MediaController a;

        public i(MediaController mediaController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mediaController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mediaController;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.r.U();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class j extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MediaController a;

        /* loaded from: classes2.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ j a;

            public a(j jVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {jVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = jVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (this.a.a.r != null && this.a.a.r.getVideoPlayerCallback() != null) {
                        this.a.a.r.getVideoPlayerCallback().c(this.a.a.r);
                    }
                    this.a.a.n();
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mediaController;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.getMainThreadHandler().post(new a(this));
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
        this.t = false;
        this.v = false;
        this.w = false;
        m();
    }

    public static String j(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65546, null, i2)) == null) {
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
        if (!(interceptable == null || interceptable.invokeI(65547, this, i2) == null) || this.t) {
            return;
        }
        SeekBar seekBar = this.e;
        if (seekBar != null) {
            seekBar.setMax(i2);
        }
        C(i2);
        if (i2 > 0) {
            this.t = true;
        }
    }

    public final void A() {
        Timer timer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (timer = this.o) == null) {
            return;
        }
        timer.cancel();
        this.o = null;
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            boolean z = !this.y;
            this.y = z;
            if (z) {
                this.k.setImageResource(R.drawable.obfuscated_res_0x7f0811ba);
                this.B.setVisibility(8);
                this.C.setVisibility(8);
                this.l.setVisibility(8);
                this.a.setVisibility(8);
            } else {
                this.k.setImageResource(R.drawable.obfuscated_res_0x7f0811be);
                this.B.setVisibility(0);
                this.C.setVisibility(0);
                this.l.setVisibility(this.z ? 0 : 8);
                this.a.setVisibility(this.A ? 0 : 8);
            }
            SwanVideoView swanVideoView = this.r;
            if (swanVideoView != null) {
                swanVideoView.b0(this.y);
            }
        }
    }

    public final void C(int i2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) || (textView = this.f) == null) {
            return;
        }
        textView.setText(j(i2));
    }

    public final void D(int i2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || (textView = this.d) == null) {
            return;
        }
        textView.setText(j(i2));
    }

    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            int currentPlayerState = this.r.getCurrentPlayerState();
            this.t = false;
            switch (currentPlayerState) {
                case -1:
                case 0:
                    A();
                    this.a.setEnabled(true);
                    this.a.setImageResource(R.drawable.obfuscated_res_0x7f0811bc);
                    this.i.setEnabled(true);
                    this.i.setImageResource(R.drawable.obfuscated_res_0x7f0811bc);
                    this.e.setEnabled(false);
                    SwanVideoView swanVideoView = this.r;
                    D(swanVideoView == null ? 0 : swanVideoView.getCurrentPosition());
                    SwanVideoView swanVideoView2 = this.r;
                    C(swanVideoView2 != null ? swanVideoView2.getDuration() : 0);
                    return;
                case 1:
                    this.a.setEnabled(false);
                    this.i.setEnabled(false);
                    this.e.setEnabled(false);
                    return;
                case 2:
                    this.a.setEnabled(true);
                    this.a.setImageResource(R.drawable.obfuscated_res_0x7f0811bc);
                    this.i.setEnabled(true);
                    this.i.setImageResource(R.drawable.obfuscated_res_0x7f0811bc);
                    this.e.setEnabled(true);
                    SwanVideoView swanVideoView3 = this.r;
                    C(swanVideoView3 == null ? 0 : swanVideoView3.getDuration());
                    SeekBar seekBar = this.e;
                    SwanVideoView swanVideoView4 = this.r;
                    seekBar.setMax(swanVideoView4 != null ? swanVideoView4.getDuration() : 0);
                    return;
                case 3:
                    z();
                    this.e.setEnabled(true);
                    this.a.setEnabled(true);
                    this.a.setImageResource(R.drawable.obfuscated_res_0x7f0811bb);
                    this.i.setEnabled(true);
                    this.i.setImageResource(R.drawable.obfuscated_res_0x7f0811bb);
                    return;
                case 4:
                    this.a.setEnabled(true);
                    this.a.setImageResource(R.drawable.obfuscated_res_0x7f0811bc);
                    this.i.setEnabled(true);
                    this.i.setImageResource(R.drawable.obfuscated_res_0x7f0811bc);
                    return;
                case 5:
                    A();
                    SeekBar seekBar2 = this.e;
                    seekBar2.setProgress(seekBar2.getMax());
                    this.e.setEnabled(false);
                    this.a.setEnabled(true);
                    this.a.setImageResource(R.drawable.obfuscated_res_0x7f0811bc);
                    this.i.setEnabled(true);
                    this.i.setImageResource(R.drawable.obfuscated_res_0x7f0811bc);
                    return;
                default:
                    return;
            }
        }
    }

    public Handler getMainThreadHandler() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.p == null) {
                this.p = new Handler(Looper.getMainLooper());
            }
            return this.p;
        }
        return (Handler) invokeV.objValue;
    }

    public void i(SwanVideoView swanVideoView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, swanVideoView) == null) {
            this.r = swanVideoView;
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            setVisibility(8);
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            q();
            Timer timer = this.q;
            if (timer != null) {
                timer.cancel();
                this.q = null;
            }
            Timer timer2 = new Timer();
            this.q = timer2;
            timer2.schedule(new a(this), 3000L);
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d07cc, this);
            this.B = (LinearLayout) inflate.findViewById(R.id.obfuscated_res_0x7f091e49);
            this.C = (LinearLayout) inflate.findViewById(R.id.obfuscated_res_0x7f091e3f);
            this.x = new b(this);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f091e44);
            this.a = imageView;
            imageView.setOnClickListener(this.x);
            ImageView imageView2 = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f091e45);
            this.i = imageView2;
            imageView2.setOnClickListener(this.x);
            this.d = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091e4b);
            this.e = (SeekBar) inflate.findViewById(R.id.obfuscated_res_0x7f091e48);
            this.f = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091e4a);
            this.e.setOnSeekBarChangeListener(new c(this));
            this.c = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f091e43);
            SwanVideoView swanVideoView = this.r;
            this.c.setImageResource(swanVideoView != null && swanVideoView.y() ? R.drawable.obfuscated_res_0x7f0811c8 : R.drawable.obfuscated_res_0x7f0811c7);
            this.c.setOnClickListener(new d(this));
            ImageView imageView3 = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f091e47);
            this.b = imageView3;
            imageView3.setOnClickListener(new e(this));
            this.e.setEnabled(false);
            this.a.setEnabled(false);
            this.i.setEnabled(false);
            View findViewById = inflate.findViewById(R.id.obfuscated_res_0x7f091e40);
            this.g = findViewById;
            findViewById.setOnClickListener(new f(this));
            TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091e4d);
            this.h = textView;
            textView.setVisibility(4);
            this.g.setVisibility(8);
            ImageView imageView4 = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f091e41);
            this.j = imageView4;
            imageView4.setVisibility(8);
            ImageView imageView5 = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f091e42);
            this.k = imageView5;
            imageView5.setVisibility(8);
            this.k.setOnClickListener(new g(this));
            TextView textView2 = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091e4c);
            this.l = textView2;
            textView2.setOnClickListener(new h(this));
            View findViewById2 = inflate.findViewById(R.id.obfuscated_res_0x7f091e46);
            this.m = findViewById2;
            findViewById2.setVisibility(8);
            this.m.setOnClickListener(new i(this));
        }
    }

    public void n() {
        SwanVideoView swanVideoView;
        int duration;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (swanVideoView = this.r) == null || this.s) {
            return;
        }
        long currentPosition = swanVideoView.getCurrentPosition();
        if (currentPosition >= 0) {
            this.n = currentPosition;
        }
        if (getVisibility() == 0 && (duration = this.r.getDuration()) > 0) {
            setMax(duration);
            setProgress((int) currentPosition);
        }
    }

    public void o(int i2) {
        SeekBar seekBar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048587, this, i2) == null) || (seekBar = this.e) == null || i2 == seekBar.getSecondaryProgress()) {
            return;
        }
        this.e.setSecondaryProgress(i2);
    }

    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.v = z;
            this.b.setImageResource(z ? R.drawable.obfuscated_res_0x7f0811b9 : R.drawable.obfuscated_res_0x7f0811b8);
            int i2 = 8;
            if (this.v) {
                this.h.setVisibility(0);
                this.g.setVisibility(0);
                this.k.setVisibility(0);
                this.m.setVisibility(this.w ? 0 : 8);
                this.B.setVisibility(this.y ? 8 : 0);
                this.C.setVisibility(this.y ? 8 : 0);
                this.a.setVisibility((this.y || !this.A) ? 8 : 0);
                TextView textView = this.l;
                if (!this.y && this.z) {
                    i2 = 0;
                }
                textView.setVisibility(i2);
                return;
            }
            this.h.setVisibility(4);
            this.g.setVisibility(8);
            this.k.setVisibility(8);
            this.C.setVisibility(0);
            this.l.setVisibility(this.z ? 0 : 8);
            this.m.setVisibility(8);
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || this.r == null) {
            return;
        }
        setProgress((int) this.n);
        setVisibility(0);
    }

    public void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.A = z;
            ImageView imageView = this.a;
            if (imageView != null) {
                imageView.setVisibility(z ? 0 : 8);
            }
        }
    }

    public void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
        }
    }

    public void setMute(boolean z) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048592, this, z) == null) || (imageView = this.c) == null) {
            return;
        }
        imageView.setImageResource(z ? R.drawable.obfuscated_res_0x7f0811c8 : R.drawable.obfuscated_res_0x7f0811c7);
    }

    public void setProgress(int i2) {
        SeekBar seekBar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048593, this, i2) == null) || (seekBar = this.e) == null) {
            return;
        }
        seekBar.setProgress(i2);
    }

    public void setTitle(String str) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, str) == null) || (textView = this.h) == null) {
            return;
        }
        textView.setText(str);
    }

    public void setToggleScreenListener(th4 th4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, th4Var) == null) {
            this.u = th4Var;
        }
    }

    public void t(boolean z) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048596, this, z) == null) || (imageView = this.c) == null) {
            return;
        }
        imageView.setVisibility(z ? 0 : 8);
    }

    public void u(boolean z) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048597, this, z) == null) || (imageView = this.i) == null) {
            return;
        }
        imageView.setVisibility(z ? 0 : 8);
    }

    public void v(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            this.z = z;
            TextView textView = this.l;
            if (textView != null) {
                textView.setVisibility(z ? 0 : 8);
            }
        }
    }

    public void w(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            SeekBar seekBar = this.e;
            if (seekBar != null) {
                seekBar.setVisibility(z ? 0 : 4);
            }
            TextView textView = this.f;
            if (textView != null) {
                textView.setVisibility(z ? 0 : 4);
            }
            TextView textView2 = this.d;
            if (textView2 != null) {
                textView2.setVisibility(z ? 0 : 4);
            }
        }
    }

    public void x(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            this.w = z;
        }
    }

    public void y(boolean z) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048601, this, z) == null) || (imageView = this.b) == null) {
            return;
        }
        imageView.setVisibility(z ? 0 : 8);
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            Timer timer = this.o;
            if (timer != null) {
                timer.cancel();
                this.o = null;
            }
            Timer timer2 = new Timer();
            this.o = timer2;
            timer2.schedule(new j(this), 0L, 1000L);
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
        this.t = false;
        this.v = false;
        this.w = false;
        m();
    }
}

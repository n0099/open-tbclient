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
import com.baidu.tieba.wp4;
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
    public wp4 u;
    public boolean v;
    public boolean w;
    public View.OnClickListener x;
    public boolean y;
    public boolean z;

    public void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
        }
    }

    /* loaded from: classes3.dex */
    public class a extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MediaController a;

        /* renamed from: com.baidu.swan.videoplayer.widget.MediaController$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0205a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public RunnableC0205a(a aVar) {
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
                this.a.getMainThreadHandler().post(new RunnableC0205a(this));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class j extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MediaController a;

        /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.r != null) {
                if (this.a.r.z()) {
                    if (this.a.a.getVisibility() == 0) {
                        this.a.a.setImageResource(R.drawable.obfuscated_res_0x7f081262);
                    }
                    if (this.a.i.getVisibility() == 0) {
                        this.a.i.setImageResource(R.drawable.obfuscated_res_0x7f081262);
                    }
                    this.a.r.C();
                    return;
                }
                Log.d("SimpleMediaController", "mPlayButton clicked : to resume");
                if (this.a.a.getVisibility() == 0) {
                    this.a.a.setImageResource(R.drawable.obfuscated_res_0x7f081261);
                }
                if (this.a.i.getVisibility() == 0) {
                    this.a.i.setImageResource(R.drawable.obfuscated_res_0x7f081261);
                }
                this.a.r.X();
            }
        }
    }

    /* loaded from: classes3.dex */
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
        public void onStartTrackingTouch(SeekBar seekBar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, seekBar) == null) {
                this.a.s = true;
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{seekBar, Integer.valueOf(i), Boolean.valueOf(z)}) != null) {
                return;
            }
            this.a.D(i);
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

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.u != null) {
                this.a.u.d(!this.a.v);
            }
        }
    }

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
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
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.a.B();
        }
    }

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
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

    public void w(boolean z) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            SeekBar seekBar = this.e;
            int i4 = 0;
            if (seekBar != null) {
                if (z) {
                    i3 = 0;
                } else {
                    i3 = 4;
                }
                seekBar.setVisibility(i3);
            }
            TextView textView = this.f;
            if (textView != null) {
                if (z) {
                    i2 = 0;
                } else {
                    i2 = 4;
                }
                textView.setVisibility(i2);
            }
            TextView textView2 = this.d;
            if (textView2 != null) {
                if (!z) {
                    i4 = 4;
                }
                textView2.setVisibility(i4);
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
        this.t = false;
        this.v = false;
        this.w = false;
        m();
    }

    private void setMax(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(65547, this, i2) != null) || this.t) {
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

    public final void C(int i2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) && (textView = this.f) != null) {
            textView.setText(j(i2));
        }
    }

    public final void D(int i2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048579, this, i2) == null) && (textView = this.d) != null) {
            textView.setText(j(i2));
        }
    }

    public void i(SwanVideoView swanVideoView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, swanVideoView) == null) {
            this.r = swanVideoView;
        }
    }

    public void o(int i2) {
        SeekBar seekBar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048587, this, i2) == null) && (seekBar = this.e) != null && i2 != seekBar.getSecondaryProgress()) {
            this.e.setSecondaryProgress(i2);
        }
    }

    public void r(boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.A = z;
            ImageView imageView = this.a;
            if (imageView != null) {
                if (z) {
                    i2 = 0;
                } else {
                    i2 = 8;
                }
                imageView.setVisibility(i2);
            }
        }
    }

    public void setMute(boolean z) {
        ImageView imageView;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048592, this, z) == null) && (imageView = this.c) != null) {
            if (z) {
                i2 = R.drawable.obfuscated_res_0x7f08126e;
            } else {
                i2 = R.drawable.obfuscated_res_0x7f08126d;
            }
            imageView.setImageResource(i2);
        }
    }

    public void setProgress(int i2) {
        SeekBar seekBar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048593, this, i2) == null) && (seekBar = this.e) != null) {
            seekBar.setProgress(i2);
        }
    }

    public void setTitle(String str) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048594, this, str) == null) && (textView = this.h) != null) {
            textView.setText(str);
        }
    }

    public void setToggleScreenListener(wp4 wp4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, wp4Var) == null) {
            this.u = wp4Var;
        }
    }

    public void t(boolean z) {
        ImageView imageView;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048596, this, z) == null) && (imageView = this.c) != null) {
            if (z) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            imageView.setVisibility(i2);
        }
    }

    public void u(boolean z) {
        ImageView imageView;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048597, this, z) == null) && (imageView = this.i) != null) {
            if (z) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            imageView.setVisibility(i2);
        }
    }

    public void v(boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            this.z = z;
            TextView textView = this.l;
            if (textView != null) {
                if (z) {
                    i2 = 0;
                } else {
                    i2 = 8;
                }
                textView.setVisibility(i2);
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
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048601, this, z) == null) && (imageView = this.b) != null) {
            if (z) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            imageView.setVisibility(i2);
        }
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
            if (i4 != 0) {
                return String.format(Locale.US, "%02d:%02d:%02d", Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6));
            }
            return String.format(Locale.US, "%02d:%02d", Integer.valueOf(i5), Integer.valueOf(i6));
        }
        return (String) invokeI.objValue;
    }

    public final void A() {
        Timer timer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (timer = this.o) != null) {
            timer.cancel();
            this.o = null;
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

    public final void q() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048589, this) != null) || this.r == null) {
            return;
        }
        setProgress((int) this.n);
        setVisibility(0);
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

    public final void B() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            boolean z = !this.y;
            this.y = z;
            int i3 = 8;
            if (z) {
                this.k.setImageResource(R.drawable.obfuscated_res_0x7f081260);
                this.B.setVisibility(8);
                this.C.setVisibility(8);
                this.l.setVisibility(8);
                this.a.setVisibility(8);
            } else {
                this.k.setImageResource(R.drawable.obfuscated_res_0x7f081264);
                this.B.setVisibility(0);
                this.C.setVisibility(0);
                TextView textView = this.l;
                if (this.z) {
                    i2 = 0;
                } else {
                    i2 = 8;
                }
                textView.setVisibility(i2);
                ImageView imageView = this.a;
                if (this.A) {
                    i3 = 0;
                }
                imageView.setVisibility(i3);
            }
            SwanVideoView swanVideoView = this.r;
            if (swanVideoView != null) {
                swanVideoView.b0(this.y);
            }
        }
    }

    public void E() {
        int currentPosition;
        int duration;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            int currentPlayerState = this.r.getCurrentPlayerState();
            int i2 = 0;
            this.t = false;
            switch (currentPlayerState) {
                case -1:
                case 0:
                    A();
                    this.a.setEnabled(true);
                    this.a.setImageResource(R.drawable.obfuscated_res_0x7f081262);
                    this.i.setEnabled(true);
                    this.i.setImageResource(R.drawable.obfuscated_res_0x7f081262);
                    this.e.setEnabled(false);
                    SwanVideoView swanVideoView = this.r;
                    if (swanVideoView == null) {
                        currentPosition = 0;
                    } else {
                        currentPosition = swanVideoView.getCurrentPosition();
                    }
                    D(currentPosition);
                    SwanVideoView swanVideoView2 = this.r;
                    if (swanVideoView2 != null) {
                        i2 = swanVideoView2.getDuration();
                    }
                    C(i2);
                    return;
                case 1:
                    this.a.setEnabled(false);
                    this.i.setEnabled(false);
                    this.e.setEnabled(false);
                    return;
                case 2:
                    this.a.setEnabled(true);
                    this.a.setImageResource(R.drawable.obfuscated_res_0x7f081262);
                    this.i.setEnabled(true);
                    this.i.setImageResource(R.drawable.obfuscated_res_0x7f081262);
                    this.e.setEnabled(true);
                    SwanVideoView swanVideoView3 = this.r;
                    if (swanVideoView3 == null) {
                        duration = 0;
                    } else {
                        duration = swanVideoView3.getDuration();
                    }
                    C(duration);
                    SeekBar seekBar = this.e;
                    SwanVideoView swanVideoView4 = this.r;
                    if (swanVideoView4 != null) {
                        i2 = swanVideoView4.getDuration();
                    }
                    seekBar.setMax(i2);
                    return;
                case 3:
                    z();
                    this.e.setEnabled(true);
                    this.a.setEnabled(true);
                    this.a.setImageResource(R.drawable.obfuscated_res_0x7f081261);
                    this.i.setEnabled(true);
                    this.i.setImageResource(R.drawable.obfuscated_res_0x7f081261);
                    return;
                case 4:
                    this.a.setEnabled(true);
                    this.a.setImageResource(R.drawable.obfuscated_res_0x7f081262);
                    this.i.setEnabled(true);
                    this.i.setImageResource(R.drawable.obfuscated_res_0x7f081262);
                    return;
                case 5:
                    A();
                    SeekBar seekBar2 = this.e;
                    seekBar2.setProgress(seekBar2.getMax());
                    this.e.setEnabled(false);
                    this.a.setEnabled(true);
                    this.a.setImageResource(R.drawable.obfuscated_res_0x7f081262);
                    this.i.setEnabled(true);
                    this.i.setImageResource(R.drawable.obfuscated_res_0x7f081262);
                    return;
                default:
                    return;
            }
        }
    }

    public final void m() {
        boolean z;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d0863, this);
            this.B = (LinearLayout) inflate.findViewById(R.id.obfuscated_res_0x7f092120);
            this.C = (LinearLayout) inflate.findViewById(R.id.obfuscated_res_0x7f092116);
            this.x = new b(this);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f09211b);
            this.a = imageView;
            imageView.setOnClickListener(this.x);
            ImageView imageView2 = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f09211c);
            this.i = imageView2;
            imageView2.setOnClickListener(this.x);
            this.d = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f092122);
            this.e = (SeekBar) inflate.findViewById(R.id.obfuscated_res_0x7f09211f);
            this.f = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f092121);
            this.e.setOnSeekBarChangeListener(new c(this));
            this.c = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f09211a);
            SwanVideoView swanVideoView = this.r;
            if (swanVideoView != null && swanVideoView.y()) {
                z = true;
            } else {
                z = false;
            }
            ImageView imageView3 = this.c;
            if (z) {
                i2 = R.drawable.obfuscated_res_0x7f08126e;
            } else {
                i2 = R.drawable.obfuscated_res_0x7f08126d;
            }
            imageView3.setImageResource(i2);
            this.c.setOnClickListener(new d(this));
            ImageView imageView4 = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f09211e);
            this.b = imageView4;
            imageView4.setOnClickListener(new e(this));
            this.e.setEnabled(false);
            this.a.setEnabled(false);
            this.i.setEnabled(false);
            View findViewById = inflate.findViewById(R.id.obfuscated_res_0x7f092117);
            this.g = findViewById;
            findViewById.setOnClickListener(new f(this));
            TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f092124);
            this.h = textView;
            textView.setVisibility(4);
            this.g.setVisibility(8);
            ImageView imageView5 = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f092118);
            this.j = imageView5;
            imageView5.setVisibility(8);
            ImageView imageView6 = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f092119);
            this.k = imageView6;
            imageView6.setVisibility(8);
            this.k.setOnClickListener(new g(this));
            TextView textView2 = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f092123);
            this.l = textView2;
            textView2.setOnClickListener(new h(this));
            View findViewById2 = inflate.findViewById(R.id.obfuscated_res_0x7f09211d);
            this.m = findViewById2;
            findViewById2.setVisibility(8);
            this.m.setOnClickListener(new i(this));
        }
    }

    public void n() {
        SwanVideoView swanVideoView;
        int duration;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (swanVideoView = this.r) != null && !this.s) {
            long currentPosition = swanVideoView.getCurrentPosition();
            if (currentPosition >= 0) {
                this.n = currentPosition;
            }
            if (getVisibility() == 0 && (duration = this.r.getDuration()) > 0) {
                setMax(duration);
                setProgress((int) currentPosition);
            }
        }
    }

    public void p(boolean z) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.v = z;
            ImageView imageView = this.b;
            if (z) {
                i2 = R.drawable.obfuscated_res_0x7f08125f;
            } else {
                i2 = R.drawable.obfuscated_res_0x7f08125e;
            }
            imageView.setImageResource(i2);
            int i7 = 8;
            int i8 = 0;
            if (this.v) {
                this.h.setVisibility(0);
                this.g.setVisibility(0);
                this.k.setVisibility(0);
                View view2 = this.m;
                if (this.w) {
                    i3 = 0;
                } else {
                    i3 = 8;
                }
                view2.setVisibility(i3);
                LinearLayout linearLayout = this.B;
                if (this.y) {
                    i4 = 8;
                } else {
                    i4 = 0;
                }
                linearLayout.setVisibility(i4);
                LinearLayout linearLayout2 = this.C;
                if (this.y) {
                    i5 = 8;
                } else {
                    i5 = 0;
                }
                linearLayout2.setVisibility(i5);
                ImageView imageView2 = this.a;
                if (!this.y && this.A) {
                    i6 = 0;
                } else {
                    i6 = 8;
                }
                imageView2.setVisibility(i6);
                TextView textView = this.l;
                if (!this.y && this.z) {
                    i7 = 0;
                }
                textView.setVisibility(i7);
                return;
            }
            this.h.setVisibility(4);
            this.g.setVisibility(8);
            this.k.setVisibility(8);
            this.C.setVisibility(0);
            TextView textView2 = this.l;
            if (!this.z) {
                i8 = 8;
            }
            textView2.setVisibility(i8);
            this.m.setVisibility(8);
        }
    }
}

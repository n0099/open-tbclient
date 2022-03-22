package c.a.n0.y.h;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.h2.b.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.videoplayer.SwanVideoView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class d implements View.OnClickListener, View.OnTouchListener, SeekBar.OnSeekBarChangeListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;

    /* renamed from: b  reason: collision with root package name */
    public SwanVideoView f9587b;

    /* renamed from: c  reason: collision with root package name */
    public FrameLayout f9588c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f9589d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f9590e;

    /* renamed from: f  reason: collision with root package name */
    public SeekBar f9591f;

    /* renamed from: g  reason: collision with root package name */
    public SeekBar f9592g;

    /* renamed from: h  reason: collision with root package name */
    public AudioManager f9593h;
    public int i;
    public boolean j;

    /* loaded from: classes2.dex */
    public class a implements d.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        @Override // c.a.n0.a.h2.b.d.b
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.a.f9592g.setProgress(i);
            }
        }
    }

    public d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context;
        f();
    }

    public void b(SwanVideoView swanVideoView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, swanVideoView) == null) {
            this.f9587b = swanVideoView;
        }
    }

    public FrameLayout c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f9588c : (FrameLayout) invokeV.objValue;
    }

    public void d() {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (linearLayout = this.f9589d) == null) {
            return;
        }
        linearLayout.setVisibility(8);
    }

    public void e() {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (linearLayout = this.f9590e) == null) {
            return;
        }
        linearLayout.setVisibility(8);
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d07e7, (ViewGroup) null);
            this.f9588c = frameLayout;
            frameLayout.setOnTouchListener(this);
            LinearLayout linearLayout = (LinearLayout) this.f9588c.findViewById(R.id.obfuscated_res_0x7f091e08);
            this.f9589d = linearLayout;
            linearLayout.setVisibility(8);
            this.f9589d.findViewById(R.id.obfuscated_res_0x7f091e10).setOnClickListener(this);
            this.f9589d.findViewById(R.id.obfuscated_res_0x7f091e11).setOnClickListener(this);
            this.f9589d.findViewById(R.id.obfuscated_res_0x7f091e12).setOnClickListener(this);
            this.f9589d.findViewById(R.id.obfuscated_res_0x7f091e13).setOnClickListener(this);
            this.f9589d.findViewById(R.id.obfuscated_res_0x7f091e14).setOnClickListener(this);
            this.i = R.id.obfuscated_res_0x7f091e11;
            k(R.id.obfuscated_res_0x7f091e11, -13399809);
            h();
            LinearLayout linearLayout2 = (LinearLayout) this.f9588c.findViewById(R.id.obfuscated_res_0x7f091e09);
            this.f9590e = linearLayout2;
            linearLayout2.setVisibility(8);
            this.f9590e.setOnTouchListener(this);
            this.f9591f = (SeekBar) this.f9590e.findViewById(R.id.obfuscated_res_0x7f091e18);
            this.f9592g = (SeekBar) this.f9590e.findViewById(R.id.obfuscated_res_0x7f091e19);
            this.f9591f.setOnSeekBarChangeListener(this);
            this.f9592g.setOnSeekBarChangeListener(this);
            this.f9591f.setMax(100);
            AudioManager audioManager = (AudioManager) this.a.getSystemService("audio");
            this.f9593h = audioManager;
            this.f9592g.setMax(audioManager.getStreamMaxVolume(3));
            o();
            c.a.n0.a.h2.b.d.e().d("#com.baidu.swan.videoplayer&MediaSettingViewLayer", new a(this));
        }
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            k(this.i, -1);
            if (TextUtils.equals("0.75", str)) {
                this.i = R.id.obfuscated_res_0x7f091e10;
            } else if (TextUtils.equals("1.0", str)) {
                this.i = R.id.obfuscated_res_0x7f091e11;
            } else if (TextUtils.equals("1.25", str)) {
                this.i = R.id.obfuscated_res_0x7f091e12;
            } else if (TextUtils.equals("1.5", str)) {
                this.i = R.id.obfuscated_res_0x7f091e13;
            } else if (TextUtils.equals("2.0", str)) {
                this.i = R.id.obfuscated_res_0x7f091e14;
            } else {
                this.i = 0;
            }
            k(this.i, -13399809);
            SwanVideoView swanVideoView = this.f9587b;
            if (swanVideoView != null) {
                swanVideoView.Q(str);
            }
        }
    }

    public void h() {
        float dimension;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.f9589d == null) {
            return;
        }
        if (this.j) {
            dimension = this.a.getResources().getDimension(R.dimen.obfuscated_res_0x7f0706a9);
        } else {
            dimension = this.a.getResources().getDimension(R.dimen.obfuscated_res_0x7f0706a8);
        }
        ViewGroup.LayoutParams layoutParams = this.f9589d.getLayoutParams();
        layoutParams.width = (int) dimension;
        this.f9589d.setLayoutParams(layoutParams);
    }

    public void j(int i) {
        SwanVideoView swanVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i) == null) || (swanVideoView = this.f9587b) == null || swanVideoView.A()) {
            return;
        }
        AudioManager audioManager = this.f9593h;
        if (audioManager != null) {
            audioManager.setStreamVolume(3, i, 0);
        }
        if (i == 0) {
            this.f9587b.setMuted(true);
        } else if (this.f9587b.y()) {
            this.f9587b.setMuted(false);
        }
    }

    public final void k(int i, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, i2) == null) || i == 0) {
            return;
        }
        ((TextView) this.f9588c.findViewById(i)).setTextColor(i2);
    }

    public void l(float f2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeF(1048585, this, f2) == null) && (this.a instanceof Activity)) {
            c.a.n0.a.h2.d.b.a.c().e((Activity) this.a, f2 / 100.0f);
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            SwanVideoView swanVideoView = this.f9587b;
            boolean x = swanVideoView != null ? swanVideoView.x() : false;
            if (this.f9589d != null) {
                if (x != this.j) {
                    this.j = x;
                    h();
                }
                this.f9589d.setVisibility(0);
            }
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || this.f9590e == null) {
            return;
        }
        o();
        this.f9590e.setVisibility(0);
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            if (this.a instanceof Activity) {
                this.f9591f.setProgress((int) (c.a.n0.a.h2.d.b.a.c().a((Activity) this.a) * 100.0f));
            }
            SwanVideoView swanVideoView = this.f9587b;
            if (swanVideoView != null && swanVideoView.y()) {
                this.f9592g.setProgress(0);
            } else {
                this.f9592g.setProgress(this.f9593h.getStreamVolume(3));
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, view) == null) {
            d();
            if (this.f9587b == null) {
                return;
            }
            int id = view.getId();
            int i = this.i;
            if (id == i) {
                return;
            }
            k(i, -1);
            int id2 = view.getId();
            this.i = id2;
            k(id2, -13399809);
            int i2 = this.i;
            String str = i2 == R.id.obfuscated_res_0x7f091e10 ? "0.75" : i2 == R.id.obfuscated_res_0x7f091e11 ? "1.0" : i2 == R.id.obfuscated_res_0x7f091e12 ? "1.25" : i2 == R.id.obfuscated_res_0x7f091e13 ? "1.5" : i2 == R.id.obfuscated_res_0x7f091e14 ? "2.0" : "";
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                this.f9587b.J(Float.parseFloat(str));
                this.f9587b.Q(str);
            } catch (NumberFormatException unused) {
            }
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{seekBar, Integer.valueOf(i), Boolean.valueOf(z)}) == null) && z) {
            if (seekBar.getId() == R.id.obfuscated_res_0x7f091e19) {
                j(i);
            } else if (seekBar.getId() == R.id.obfuscated_res_0x7f091e18) {
                l(i);
            }
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, seekBar) == null) {
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, seekBar) == null) {
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048593, this, view, motionEvent)) == null) {
            if (view.getId() == R.id.obfuscated_res_0x7f091e09) {
                return true;
            }
            e();
            d();
            return false;
        }
        return invokeLL.booleanValue;
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            b(null);
            c.a.n0.a.h2.b.d.e().i("#com.baidu.swan.videoplayer&MediaSettingViewLayer");
        }
    }
}

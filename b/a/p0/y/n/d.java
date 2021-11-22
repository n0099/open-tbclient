package b.a.p0.y.n;

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
import b.a.p0.a.r2.b.d;
import b.a.p0.y.f;
import b.a.p0.y.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.videoplayer.SwanVideoView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.webrtc.MediaStreamTrack;
/* loaded from: classes4.dex */
public class d implements View.OnClickListener, View.OnTouchListener, SeekBar.OnSeekBarChangeListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final Context f12409e;

    /* renamed from: f  reason: collision with root package name */
    public SwanVideoView f12410f;

    /* renamed from: g  reason: collision with root package name */
    public FrameLayout f12411g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f12412h;

    /* renamed from: i  reason: collision with root package name */
    public LinearLayout f12413i;
    public SeekBar j;
    public SeekBar k;
    public AudioManager l;
    public int m;
    public boolean n;

    /* loaded from: classes4.dex */
    public class a implements d.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f12414a;

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
            this.f12414a = dVar;
        }

        @Override // b.a.p0.a.r2.b.d.b
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.f12414a.k.setProgress(i2);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f12409e = context;
        f();
    }

    public void b(SwanVideoView swanVideoView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, swanVideoView) == null) {
            this.f12410f = swanVideoView;
        }
    }

    public FrameLayout c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f12411g : (FrameLayout) invokeV.objValue;
    }

    public void d() {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (linearLayout = this.f12412h) == null) {
            return;
        }
        linearLayout.setVisibility(8);
    }

    public void e() {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (linearLayout = this.f12413i) == null) {
            return;
        }
        linearLayout.setVisibility(8);
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.f12409e).inflate(g.swanapp_video_setting_layer, (ViewGroup) null);
            this.f12411g = frameLayout;
            frameLayout.setOnTouchListener(this);
            LinearLayout linearLayout = (LinearLayout) this.f12411g.findViewById(f.swanapp_video_layout_rate);
            this.f12412h = linearLayout;
            linearLayout.setVisibility(8);
            this.f12412h.findViewById(f.swanapp_video_rate_tv_rate1).setOnClickListener(this);
            this.f12412h.findViewById(f.swanapp_video_rate_tv_rate2).setOnClickListener(this);
            this.f12412h.findViewById(f.swanapp_video_rate_tv_rate3).setOnClickListener(this);
            this.f12412h.findViewById(f.swanapp_video_rate_tv_rate4).setOnClickListener(this);
            this.f12412h.findViewById(f.swanapp_video_rate_tv_rate5).setOnClickListener(this);
            int i2 = f.swanapp_video_rate_tv_rate2;
            this.m = i2;
            j(i2, -13399809);
            h();
            LinearLayout linearLayout2 = (LinearLayout) this.f12411g.findViewById(f.swanapp_video_layout_setting);
            this.f12413i = linearLayout2;
            linearLayout2.setVisibility(8);
            this.f12413i.setOnTouchListener(this);
            this.j = (SeekBar) this.f12413i.findViewById(f.swanapp_video_setting_seekbar_brightness);
            this.k = (SeekBar) this.f12413i.findViewById(f.swanapp_video_setting_seekbar_sound);
            this.j.setOnSeekBarChangeListener(this);
            this.k.setOnSeekBarChangeListener(this);
            this.j.setMax(100);
            AudioManager audioManager = (AudioManager) this.f12409e.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
            this.l = audioManager;
            this.k.setMax(audioManager.getStreamMaxVolume(3));
            n();
            b.a.p0.a.r2.b.d.e().d("#com.baidu.swan.videoplayer&MediaSettingViewLayer", new a(this));
        }
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            j(this.m, -1);
            if (TextUtils.equals("0.75", str)) {
                this.m = f.swanapp_video_rate_tv_rate1;
            } else if (TextUtils.equals("1.0", str)) {
                this.m = f.swanapp_video_rate_tv_rate2;
            } else if (TextUtils.equals("1.25", str)) {
                this.m = f.swanapp_video_rate_tv_rate3;
            } else if (TextUtils.equals("1.5", str)) {
                this.m = f.swanapp_video_rate_tv_rate4;
            } else if (TextUtils.equals("2.0", str)) {
                this.m = f.swanapp_video_rate_tv_rate5;
            } else {
                this.m = 0;
            }
            j(this.m, -13399809);
            SwanVideoView swanVideoView = this.f12410f;
            if (swanVideoView != null) {
                swanVideoView.showRateInfo(str);
            }
        }
    }

    public void h() {
        float dimension;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.f12412h == null) {
            return;
        }
        if (this.n) {
            dimension = this.f12409e.getResources().getDimension(b.a.p0.y.d.swanapp_video_setting_weight_full);
        } else {
            dimension = this.f12409e.getResources().getDimension(b.a.p0.y.d.swanapp_video_setting_weight);
        }
        ViewGroup.LayoutParams layoutParams = this.f12412h.getLayoutParams();
        layoutParams.width = (int) dimension;
        this.f12412h.setLayoutParams(layoutParams);
    }

    public void i(int i2) {
        SwanVideoView swanVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i2) == null) || (swanVideoView = this.f12410f) == null || swanVideoView.isSilent()) {
            return;
        }
        AudioManager audioManager = this.l;
        if (audioManager != null) {
            audioManager.setStreamVolume(3, i2, 0);
        }
        if (i2 == 0) {
            this.f12410f.setMuted(true);
        } else if (this.f12410f.isMute()) {
            this.f12410f.setMuted(false);
        }
    }

    public final void j(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3) == null) || i2 == 0) {
            return;
        }
        ((TextView) this.f12411g.findViewById(i2)).setTextColor(i3);
    }

    public void k(float f2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeF(1048585, this, f2) == null) && (this.f12409e instanceof Activity)) {
            b.a.p0.a.r2.d.b.a.c().e((Activity) this.f12409e, f2 / 100.0f);
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            SwanVideoView swanVideoView = this.f12410f;
            boolean isIsLandscape = swanVideoView != null ? swanVideoView.isIsLandscape() : false;
            if (this.f12412h != null) {
                if (isIsLandscape != this.n) {
                    this.n = isIsLandscape;
                    h();
                }
                this.f12412h.setVisibility(0);
            }
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || this.f12413i == null) {
            return;
        }
        n();
        this.f12413i.setVisibility(0);
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            if (this.f12409e instanceof Activity) {
                this.j.setProgress((int) (b.a.p0.a.r2.d.b.a.c().a((Activity) this.f12409e) * 100.0f));
            }
            SwanVideoView swanVideoView = this.f12410f;
            if (swanVideoView != null && swanVideoView.isMute()) {
                this.k.setProgress(0);
            } else {
                this.k.setProgress(this.l.getStreamVolume(3));
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, view) == null) {
            d();
            if (this.f12410f == null) {
                return;
            }
            int id = view.getId();
            int i2 = this.m;
            if (id == i2) {
                return;
            }
            j(i2, -1);
            int id2 = view.getId();
            this.m = id2;
            j(id2, -13399809);
            int i3 = this.m;
            if (i3 == f.swanapp_video_rate_tv_rate1) {
                str = "0.75";
            } else if (i3 == f.swanapp_video_rate_tv_rate2) {
                str = "1.0";
            } else if (i3 == f.swanapp_video_rate_tv_rate3) {
                str = "1.25";
            } else if (i3 == f.swanapp_video_rate_tv_rate4) {
                str = "1.5";
            } else {
                str = i3 == f.swanapp_video_rate_tv_rate5 ? "2.0" : "";
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                this.f12410f.setPlayRate(Float.parseFloat(str));
                this.f12410f.showRateInfo(str);
            } catch (NumberFormatException unused) {
            }
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{seekBar, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && z) {
            if (seekBar.getId() == f.swanapp_video_setting_seekbar_sound) {
                i(i2);
            } else if (seekBar.getId() == f.swanapp_video_setting_seekbar_brightness) {
                k(i2);
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
            if (view.getId() == f.swanapp_video_layout_setting) {
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
            b.a.p0.a.r2.b.d.e().i("#com.baidu.swan.videoplayer&MediaSettingViewLayer");
        }
    }
}

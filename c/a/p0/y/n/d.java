package c.a.p0.y.n;

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
import c.a.p0.a.r2.b.d;
import c.a.p0.y.f;
import c.a.p0.y.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.videoplayer.SwanVideoView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.webrtc.MediaStreamTrack;
/* loaded from: classes5.dex */
public class d implements View.OnClickListener, View.OnTouchListener, SeekBar.OnSeekBarChangeListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final Context f11258e;

    /* renamed from: f  reason: collision with root package name */
    public SwanVideoView f11259f;

    /* renamed from: g  reason: collision with root package name */
    public FrameLayout f11260g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f11261h;

    /* renamed from: i  reason: collision with root package name */
    public LinearLayout f11262i;

    /* renamed from: j  reason: collision with root package name */
    public SeekBar f11263j;

    /* renamed from: k  reason: collision with root package name */
    public SeekBar f11264k;
    public AudioManager l;
    public int m;
    public boolean n;

    /* loaded from: classes5.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        @Override // c.a.p0.a.r2.b.d.b
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.a.f11264k.setProgress(i2);
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
        this.f11258e = context;
        i();
    }

    public void b(SwanVideoView swanVideoView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, swanVideoView) == null) {
            this.f11259f = swanVideoView;
        }
    }

    public FrameLayout d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f11260g : (FrameLayout) invokeV.objValue;
    }

    public void e() {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (linearLayout = this.f11261h) == null) {
            return;
        }
        linearLayout.setVisibility(8);
    }

    public void f() {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (linearLayout = this.f11262i) == null) {
            return;
        }
        linearLayout.setVisibility(8);
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.f11258e).inflate(g.swanapp_video_setting_layer, (ViewGroup) null);
            this.f11260g = frameLayout;
            frameLayout.setOnTouchListener(this);
            LinearLayout linearLayout = (LinearLayout) this.f11260g.findViewById(f.swanapp_video_layout_rate);
            this.f11261h = linearLayout;
            linearLayout.setVisibility(8);
            this.f11261h.findViewById(f.swanapp_video_rate_tv_rate1).setOnClickListener(this);
            this.f11261h.findViewById(f.swanapp_video_rate_tv_rate2).setOnClickListener(this);
            this.f11261h.findViewById(f.swanapp_video_rate_tv_rate3).setOnClickListener(this);
            this.f11261h.findViewById(f.swanapp_video_rate_tv_rate4).setOnClickListener(this);
            this.f11261h.findViewById(f.swanapp_video_rate_tv_rate5).setOnClickListener(this);
            int i2 = f.swanapp_video_rate_tv_rate2;
            this.m = i2;
            n(i2, -13399809);
            k();
            LinearLayout linearLayout2 = (LinearLayout) this.f11260g.findViewById(f.swanapp_video_layout_setting);
            this.f11262i = linearLayout2;
            linearLayout2.setVisibility(8);
            this.f11262i.setOnTouchListener(this);
            this.f11263j = (SeekBar) this.f11262i.findViewById(f.swanapp_video_setting_seekbar_brightness);
            this.f11264k = (SeekBar) this.f11262i.findViewById(f.swanapp_video_setting_seekbar_sound);
            this.f11263j.setOnSeekBarChangeListener(this);
            this.f11264k.setOnSeekBarChangeListener(this);
            this.f11263j.setMax(100);
            AudioManager audioManager = (AudioManager) this.f11258e.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
            this.l = audioManager;
            this.f11264k.setMax(audioManager.getStreamMaxVolume(3));
            r();
            c.a.p0.a.r2.b.d.e().d("#com.baidu.swan.videoplayer&MediaSettingViewLayer", new a(this));
        }
    }

    public void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            n(this.m, -1);
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
            n(this.m, -13399809);
            SwanVideoView swanVideoView = this.f11259f;
            if (swanVideoView != null) {
                swanVideoView.showRateInfo(str);
            }
        }
    }

    public void k() {
        float dimension;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.f11261h == null) {
            return;
        }
        if (this.n) {
            dimension = this.f11258e.getResources().getDimension(c.a.p0.y.d.swanapp_video_setting_weight_full);
        } else {
            dimension = this.f11258e.getResources().getDimension(c.a.p0.y.d.swanapp_video_setting_weight);
        }
        ViewGroup.LayoutParams layoutParams = this.f11261h.getLayoutParams();
        layoutParams.width = (int) dimension;
        this.f11261h.setLayoutParams(layoutParams);
    }

    public void l(int i2) {
        SwanVideoView swanVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i2) == null) || (swanVideoView = this.f11259f) == null || swanVideoView.isSilent()) {
            return;
        }
        AudioManager audioManager = this.l;
        if (audioManager != null) {
            audioManager.setStreamVolume(3, i2, 0);
        }
        if (i2 == 0) {
            this.f11259f.setMuted(true);
        } else if (this.f11259f.isMute()) {
            this.f11259f.setMuted(false);
        }
    }

    public final void n(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3) == null) || i2 == 0) {
            return;
        }
        ((TextView) this.f11260g.findViewById(i2)).setTextColor(i3);
    }

    public void o(float f2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeF(1048585, this, f2) == null) && (this.f11258e instanceof Activity)) {
            c.a.p0.a.r2.d.b.a.c().e((Activity) this.f11258e, f2 / 100.0f);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, view) == null) {
            e();
            if (this.f11259f == null) {
                return;
            }
            int id = view.getId();
            int i2 = this.m;
            if (id == i2) {
                return;
            }
            n(i2, -1);
            int id2 = view.getId();
            this.m = id2;
            n(id2, -13399809);
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
                this.f11259f.setPlayRate(Float.parseFloat(str));
                this.f11259f.showRateInfo(str);
            } catch (NumberFormatException unused) {
            }
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{seekBar, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && z) {
            if (seekBar.getId() == f.swanapp_video_setting_seekbar_sound) {
                l(i2);
            } else if (seekBar.getId() == f.swanapp_video_setting_seekbar_brightness) {
                o(i2);
            }
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, seekBar) == null) {
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, seekBar) == null) {
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, view, motionEvent)) == null) {
            if (view.getId() == f.swanapp_video_layout_setting) {
                return true;
            }
            f();
            e();
            return false;
        }
        return invokeLL.booleanValue;
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            SwanVideoView swanVideoView = this.f11259f;
            boolean isIsLandscape = swanVideoView != null ? swanVideoView.isIsLandscape() : false;
            if (this.f11261h != null) {
                if (isIsLandscape != this.n) {
                    this.n = isIsLandscape;
                    k();
                }
                this.f11261h.setVisibility(0);
            }
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || this.f11262i == null) {
            return;
        }
        r();
        this.f11262i.setVisibility(0);
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            if (this.f11258e instanceof Activity) {
                this.f11263j.setProgress((int) (c.a.p0.a.r2.d.b.a.c().a((Activity) this.f11258e) * 100.0f));
            }
            SwanVideoView swanVideoView = this.f11259f;
            if (swanVideoView != null && swanVideoView.isMute()) {
                this.f11264k.setProgress(0);
            } else {
                this.f11264k.setProgress(this.l.getStreamVolume(3));
            }
        }
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            b(null);
            c.a.p0.a.r2.b.d.e().i("#com.baidu.swan.videoplayer&MediaSettingViewLayer");
        }
    }
}

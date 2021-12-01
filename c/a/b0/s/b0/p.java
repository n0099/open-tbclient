package c.a.b0.s.b0;

import android.app.Activity;
import android.media.AudioManager;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.core.view.InputDeviceCompat;
import c.a.b0.d0.f;
import c.a.b0.h0.q;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.player.ui.VerticalVolumeBar;
import com.baidu.searchbox.player.event.ControlEvent;
import com.baidu.searchbox.player.event.LayerEvent;
import com.baidu.searchbox.player.event.SystemEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.webrtc.MediaStreamTrack;
/* loaded from: classes.dex */
public class p extends g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public VerticalVolumeBar f1904f;

    /* renamed from: g  reason: collision with root package name */
    public AudioManager f1905g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f1906h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f1907i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f1908j;

    /* renamed from: k  reason: collision with root package name */
    public int f1909k;
    public final Runnable l;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ p f1910e;

        public a(p pVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1910e = pVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f1910e.v();
            }
        }
    }

    public p() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f1907i = false;
        this.f1908j = false;
        this.l = new a(this);
    }

    @Override // c.a.b0.s.b0.a
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            VerticalVolumeBar verticalVolumeBar = new VerticalVolumeBar(getContext(), null, 16842872);
            this.f1904f = verticalVolumeBar;
            verticalVolumeBar.setLayoutParams(t(false));
            this.f1904f.setProgressDrawable(ContextCompat.getDrawable(getContext(), q.nad_videoplayer_video_volume_bar_color));
            this.f1904f.setBackgroundResource(q.nad_videoplayer_video_volume_bar_shadow_bg);
            int dimension = (int) getContext().getResources().getDimension(c.a.b0.h0.p.nad_videoplayer_bd_video_volume_shadow_width);
            int i2 = dimension / 2;
            this.f1904f.setPadding(i2, dimension, i2, dimension);
            this.f1904f.setVisibility(8);
        }
    }

    @Override // c.a.b0.s.b0.a
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.g();
            v();
        }
    }

    @Override // c.a.b0.s.b0.h
    @NonNull
    public View getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f1904f : (View) invokeV.objValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // c.a.b0.s.b0.a
    public void h(@NonNull c.a.b0.s.c0.p pVar) {
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, pVar) == null) {
            String c3 = pVar.c();
            switch (c3.hashCode()) {
                case -915923721:
                    if (c3.equals(LayerEvent.ACTION_ADJUST_VOLUME)) {
                        c2 = 7;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -552621273:
                    if (c3.equals(LayerEvent.ACTION_SWITCH_FULL)) {
                        c2 = 5;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -552580917:
                    if (c3.equals(LayerEvent.ACTION_SWITCH_HALF)) {
                        c2 = 6;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -316059751:
                    if (c3.equals(LayerEvent.ACTION_ADJUST_LIGHT)) {
                        c2 = 4;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -21461611:
                    if (c3.equals(LayerEvent.ACTION_TOUCH_DOWN)) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -14542718:
                    if (c3.equals(LayerEvent.ACTION_HIDE_VOLUME_BAR)) {
                        c2 = '\t';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 649538615:
                    if (c3.equals(LayerEvent.ACTION_ADJUST_VOLUME_COMPLETE)) {
                        c2 = '\b';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1547354793:
                    if (c3.equals(ControlEvent.ACTION_STOP)) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1822725860:
                    if (c3.equals(SystemEvent.ACTION_VOLUME_CHANGED)) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 2064424334:
                    if (c3.equals(LayerEvent.ACTION_POSITION_SLIDE)) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            switch (c2) {
                case 0:
                    w();
                    return;
                case 1:
                    if (this.f1906h) {
                        return;
                    }
                    v();
                    return;
                case 2:
                case 3:
                case 4:
                    v();
                    return;
                case 5:
                    x(true);
                    return;
                case 6:
                    x(false);
                    return;
                case 7:
                    this.f1908j = true;
                    this.f1909k = pVar.g(20);
                    w();
                    return;
                case '\b':
                    this.f1908j = false;
                    return;
                case '\t':
                    VerticalVolumeBar verticalVolumeBar = this.f1904f;
                    if (verticalVolumeBar == null || verticalVolumeBar.getVisibility() != 0) {
                        return;
                    }
                    this.f1904f.setVisibility(8);
                    return;
                default:
                    return;
            }
        }
    }

    @Override // c.a.b0.s.b0.g
    public void p(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.f1906h = z;
            if (z) {
                v();
            }
        }
    }

    public FrameLayout.LayoutParams t(boolean z) {
        InterceptResult invokeZ;
        int i2;
        float dimension;
        float dimension2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048581, this, z)) == null) {
            int dimension3 = (int) getContext().getResources().getDimension(c.a.b0.h0.p.nad_videoplayer_bd_video_volume_shadow_width);
            int min = Math.min(f.c.e(getContext()), f.c.c(getContext()));
            if (!z) {
                i2 = ((min / 16) * 9) / 2;
            } else {
                i2 = min / 2;
            }
            int i3 = i2 + dimension3;
            int dimension4 = (dimension3 * 2) + ((int) getContext().getResources().getDimension(c.a.b0.h0.p.nad_videoplayer_bd_video_volume_height));
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f1904f.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(i3, dimension4);
            }
            layoutParams.width = i3;
            layoutParams.height = dimension4;
            if (!z) {
                dimension = getContext().getResources().getDimension(c.a.b0.h0.p.nad_videoplayer_bd_video_volume_leftmargin);
            } else {
                dimension = getContext().getResources().getDimension(c.a.b0.h0.p.nad_videoplayer_bd_video_volume_full_leftmargin);
            }
            layoutParams.leftMargin = ((int) dimension) - dimension3;
            layoutParams.gravity = 80;
            if (!z) {
                dimension2 = getContext().getResources().getDimension(c.a.b0.h0.p.nad_videoplayer_bd_video_volume_bottomargin);
            } else {
                dimension2 = getContext().getResources().getDimension(c.a.b0.h0.p.nad_videoplayer_bd_video_volume_full_bottomargin);
            }
            layoutParams.bottomMargin = ((int) dimension2) - dimension3;
            return layoutParams;
        }
        return (FrameLayout.LayoutParams) invokeZ.objValue;
    }

    public void u() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && o() != null && o().c0()) {
            o().d0(false);
        }
    }

    public final void v() {
        VerticalVolumeBar verticalVolumeBar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (verticalVolumeBar = this.f1904f) != null && verticalVolumeBar.getVisibility() == 0) {
            this.f1904f.setVisibility(8);
            b(c.a.b0.s.c0.f.w(LayerEvent.ACTION_HIDE_VOLUME_BAR));
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            Activity activity = n().getActivity();
            if (activity != null && activity.hasWindowFocus()) {
                if ((!n().Y() && !n().W()) || this.f1907i) {
                    v();
                    return;
                }
                VerticalVolumeBar verticalVolumeBar = this.f1904f;
                if (verticalVolumeBar != null && verticalVolumeBar.getVisibility() != 0) {
                    this.f1904f.setVisibility(0);
                    c.a.b0.s.c0.p w = c.a.b0.s.c0.f.w(LayerEvent.ACTION_SHOW_VOLUME_BAR);
                    b(w);
                    l(w);
                }
                u();
                if (this.f1905g == null) {
                    this.f1905g = (AudioManager) getContext().getApplicationContext().getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
                }
                int streamMaxVolume = this.f1905g.getStreamMaxVolume(3);
                int streamVolume = this.f1905g.getStreamVolume(3);
                VerticalVolumeBar verticalVolumeBar2 = this.f1904f;
                if (verticalVolumeBar2 != null) {
                    if (!this.f1908j) {
                        verticalVolumeBar2.setMax(streamMaxVolume);
                        this.f1904f.setProgress(streamVolume);
                    } else {
                        verticalVolumeBar2.setMax(100);
                        this.f1904f.setProgress(this.f1909k);
                    }
                }
                o().x().removeCallbacks(this.l);
                o().x().postDelayed(this.l, 1000L);
                return;
            }
            v();
        }
    }

    public final void x(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            if (this.f1904f == null) {
                f();
            }
            this.f1904f.setLayoutParams(t(z));
            v();
        }
    }
}

package c.a.b0.v.b0;

import android.app.Activity;
import android.media.AudioManager;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.core.view.InputDeviceCompat;
import c.a.b0.h0.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.player.ui.VerticalVolumeBar;
import com.baidu.searchbox.player.event.ControlEvent;
import com.baidu.searchbox.player.event.LayerEvent;
import com.baidu.searchbox.player.event.SystemEvent;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class p extends g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public VerticalVolumeBar f2072f;

    /* renamed from: g  reason: collision with root package name */
    public AudioManager f2073g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f2074h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f2075i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f2076j;
    public int k;
    public final Runnable l;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ p f2077e;

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
            this.f2077e = pVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f2077e.v();
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
        this.f2075i = false;
        this.f2076j = false;
        this.l = new a(this);
    }

    @Override // c.a.b0.v.b0.a
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            VerticalVolumeBar verticalVolumeBar = new VerticalVolumeBar(getContext(), null, 16842872);
            this.f2072f = verticalVolumeBar;
            verticalVolumeBar.setLayoutParams(t(false));
            this.f2072f.setProgressDrawable(ContextCompat.getDrawable(getContext(), R.drawable.nad_videoplayer_video_volume_bar_color));
            this.f2072f.setBackgroundResource(R.drawable.nad_videoplayer_video_volume_bar_shadow_bg);
            int dimension = (int) getContext().getResources().getDimension(R.dimen.nad_videoplayer_bd_video_volume_shadow_width);
            int i2 = dimension / 2;
            this.f2072f.setPadding(i2, dimension, i2, dimension);
            this.f2072f.setVisibility(8);
        }
    }

    @Override // c.a.b0.v.b0.a
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.g();
            v();
        }
    }

    @Override // c.a.b0.v.b0.h
    @NonNull
    public View getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f2072f : (View) invokeV.objValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // c.a.b0.v.b0.a
    public void h(@NonNull c.a.b0.v.c0.p pVar) {
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
                    if (this.f2074h) {
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
                    this.f2076j = true;
                    this.k = pVar.g(20);
                    w();
                    return;
                case '\b':
                    this.f2076j = false;
                    return;
                case '\t':
                    VerticalVolumeBar verticalVolumeBar = this.f2072f;
                    if (verticalVolumeBar == null || verticalVolumeBar.getVisibility() != 0) {
                        return;
                    }
                    this.f2072f.setVisibility(8);
                    return;
                default:
                    return;
            }
        }
    }

    @Override // c.a.b0.v.b0.g
    public void p(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.f2074h = z;
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
            int dimension3 = (int) getContext().getResources().getDimension(R.dimen.nad_videoplayer_bd_video_volume_shadow_width);
            int min = Math.min(f.c.e(getContext()), f.c.c(getContext()));
            if (!z) {
                i2 = ((min / 16) * 9) / 2;
            } else {
                i2 = min / 2;
            }
            int i3 = i2 + dimension3;
            int dimension4 = (dimension3 * 2) + ((int) getContext().getResources().getDimension(R.dimen.nad_videoplayer_bd_video_volume_height));
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f2072f.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(i3, dimension4);
            }
            layoutParams.width = i3;
            layoutParams.height = dimension4;
            if (!z) {
                dimension = getContext().getResources().getDimension(R.dimen.nad_videoplayer_bd_video_volume_leftmargin);
            } else {
                dimension = getContext().getResources().getDimension(R.dimen.nad_videoplayer_bd_video_volume_full_leftmargin);
            }
            layoutParams.leftMargin = ((int) dimension) - dimension3;
            layoutParams.gravity = 80;
            if (!z) {
                dimension2 = getContext().getResources().getDimension(R.dimen.nad_videoplayer_bd_video_volume_bottomargin);
            } else {
                dimension2 = getContext().getResources().getDimension(R.dimen.nad_videoplayer_bd_video_volume_full_bottomargin);
            }
            layoutParams.bottomMargin = ((int) dimension2) - dimension3;
            return layoutParams;
        }
        return (FrameLayout.LayoutParams) invokeZ.objValue;
    }

    public void u() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && o() != null && o().U()) {
            o().V(false);
        }
    }

    public final void v() {
        VerticalVolumeBar verticalVolumeBar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (verticalVolumeBar = this.f2072f) != null && verticalVolumeBar.getVisibility() == 0) {
            this.f2072f.setVisibility(8);
            b(c.a.b0.v.c0.f.w(LayerEvent.ACTION_HIDE_VOLUME_BAR));
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            Activity activity = n().getActivity();
            if (activity != null && activity.hasWindowFocus()) {
                if ((!n().Y() && !n().W()) || this.f2075i) {
                    v();
                    return;
                }
                VerticalVolumeBar verticalVolumeBar = this.f2072f;
                if (verticalVolumeBar != null && verticalVolumeBar.getVisibility() != 0) {
                    this.f2072f.setVisibility(0);
                    c.a.b0.v.c0.p w = c.a.b0.v.c0.f.w(LayerEvent.ACTION_SHOW_VOLUME_BAR);
                    b(w);
                    l(w);
                }
                u();
                if (this.f2073g == null) {
                    this.f2073g = (AudioManager) getContext().getApplicationContext().getSystemService("audio");
                }
                int streamMaxVolume = this.f2073g.getStreamMaxVolume(3);
                int streamVolume = this.f2073g.getStreamVolume(3);
                VerticalVolumeBar verticalVolumeBar2 = this.f2072f;
                if (verticalVolumeBar2 != null) {
                    if (!this.f2076j) {
                        verticalVolumeBar2.setMax(streamMaxVolume);
                        this.f2072f.setProgress(streamVolume);
                    } else {
                        verticalVolumeBar2.setMax(100);
                        this.f2072f.setProgress(this.k);
                    }
                }
                o().w().removeCallbacks(this.l);
                o().w().postDelayed(this.l, 1000L);
                return;
            }
            v();
        }
    }

    public final void x(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            if (this.f2072f == null) {
                f();
            }
            this.f2072f.setLayoutParams(t(z));
            v();
        }
    }
}

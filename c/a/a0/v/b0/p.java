package c.a.a0.v.b0;

import android.app.Activity;
import android.media.AudioManager;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.core.view.InputDeviceCompat;
import c.a.a0.h0.f;
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

    /* renamed from: b  reason: collision with root package name */
    public VerticalVolumeBar f1685b;

    /* renamed from: c  reason: collision with root package name */
    public AudioManager f1686c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f1687d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f1688e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f1689f;

    /* renamed from: g  reason: collision with root package name */
    public int f1690g;

    /* renamed from: h  reason: collision with root package name */
    public final Runnable f1691h;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p a;

        public a(p pVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.y();
            }
        }
    }

    public p() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f1688e = false;
        this.f1689f = false;
        this.f1691h = new a(this);
    }

    public final void A(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            if (this.f1685b == null) {
                i();
            }
            this.f1685b.setLayoutParams(w(z));
            y();
        }
    }

    @Override // c.a.a0.v.b0.h
    @NonNull
    public View getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f1685b : (View) invokeV.objValue;
    }

    @Override // c.a.a0.v.b0.a
    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            VerticalVolumeBar verticalVolumeBar = new VerticalVolumeBar(getContext(), null, 16842872);
            this.f1685b = verticalVolumeBar;
            verticalVolumeBar.setLayoutParams(w(false));
            this.f1685b.setProgressDrawable(ContextCompat.getDrawable(getContext(), R.drawable.obfuscated_res_0x7f080e0e));
            this.f1685b.setBackgroundResource(R.drawable.obfuscated_res_0x7f080e0f);
            int dimension = (int) getContext().getResources().getDimension(R.dimen.obfuscated_res_0x7f070535);
            int i = dimension / 2;
            this.f1685b.setPadding(i, dimension, i, dimension);
            this.f1685b.setVisibility(8);
        }
    }

    @Override // c.a.a0.v.b0.a
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.j();
            y();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // c.a.a0.v.b0.a
    public void k(@NonNull c.a.a0.v.c0.p pVar) {
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, pVar) == null) {
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
                    z();
                    return;
                case 1:
                    if (this.f1687d) {
                        return;
                    }
                    y();
                    return;
                case 2:
                case 3:
                case 4:
                    y();
                    return;
                case 5:
                    A(true);
                    return;
                case 6:
                    A(false);
                    return;
                case 7:
                    this.f1689f = true;
                    this.f1690g = pVar.g(20);
                    z();
                    return;
                case '\b':
                    this.f1689f = false;
                    return;
                case '\t':
                    VerticalVolumeBar verticalVolumeBar = this.f1685b;
                    if (verticalVolumeBar == null || verticalVolumeBar.getVisibility() != 0) {
                        return;
                    }
                    this.f1685b.setVisibility(8);
                    return;
                default:
                    return;
            }
        }
    }

    @Override // c.a.a0.v.b0.g
    public void s(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.f1687d = z;
            if (z) {
                y();
            }
        }
    }

    public FrameLayout.LayoutParams w(boolean z) {
        InterceptResult invokeZ;
        int i;
        float dimension;
        float dimension2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048582, this, z)) == null) {
            int dimension3 = (int) getContext().getResources().getDimension(R.dimen.obfuscated_res_0x7f070535);
            int min = Math.min(f.c.e(getContext()), f.c.c(getContext()));
            if (!z) {
                i = ((min / 16) * 9) / 2;
            } else {
                i = min / 2;
            }
            int i2 = i + dimension3;
            int dimension4 = (dimension3 * 2) + ((int) getContext().getResources().getDimension(R.dimen.obfuscated_res_0x7f070533));
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f1685b.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(i2, dimension4);
            }
            layoutParams.width = i2;
            layoutParams.height = dimension4;
            if (!z) {
                dimension = getContext().getResources().getDimension(R.dimen.obfuscated_res_0x7f070534);
            } else {
                dimension = getContext().getResources().getDimension(R.dimen.obfuscated_res_0x7f070532);
            }
            layoutParams.leftMargin = ((int) dimension) - dimension3;
            layoutParams.gravity = 80;
            if (!z) {
                dimension2 = getContext().getResources().getDimension(R.dimen.obfuscated_res_0x7f070530);
            } else {
                dimension2 = getContext().getResources().getDimension(R.dimen.obfuscated_res_0x7f070531);
            }
            layoutParams.bottomMargin = ((int) dimension2) - dimension3;
            return layoutParams;
        }
        return (FrameLayout.LayoutParams) invokeZ.objValue;
    }

    public void x() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && r() != null && r().U()) {
            r().V(false);
        }
    }

    public final void y() {
        VerticalVolumeBar verticalVolumeBar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (verticalVolumeBar = this.f1685b) != null && verticalVolumeBar.getVisibility() == 0) {
            this.f1685b.setVisibility(8);
            e(c.a.a0.v.c0.f.w(LayerEvent.ACTION_HIDE_VOLUME_BAR));
        }
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            Activity activity = q().getActivity();
            if (activity != null && activity.hasWindowFocus()) {
                if ((!q().Y() && !q().W()) || this.f1688e) {
                    y();
                    return;
                }
                VerticalVolumeBar verticalVolumeBar = this.f1685b;
                if (verticalVolumeBar != null && verticalVolumeBar.getVisibility() != 0) {
                    this.f1685b.setVisibility(0);
                    c.a.a0.v.c0.p w = c.a.a0.v.c0.f.w(LayerEvent.ACTION_SHOW_VOLUME_BAR);
                    e(w);
                    o(w);
                }
                x();
                if (this.f1686c == null) {
                    this.f1686c = (AudioManager) getContext().getApplicationContext().getSystemService("audio");
                }
                int streamMaxVolume = this.f1686c.getStreamMaxVolume(3);
                int streamVolume = this.f1686c.getStreamVolume(3);
                VerticalVolumeBar verticalVolumeBar2 = this.f1685b;
                if (verticalVolumeBar2 != null) {
                    if (!this.f1689f) {
                        verticalVolumeBar2.setMax(streamMaxVolume);
                        this.f1685b.setProgress(streamVolume);
                    } else {
                        verticalVolumeBar2.setMax(100);
                        this.f1685b.setProgress(this.f1690g);
                    }
                }
                r().w().removeCallbacks(this.f1691h);
                r().w().postDelayed(this.f1691h, 1000L);
                return;
            }
            y();
        }
    }
}

package c.a.a0.v.b0;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.player.ui.BdLayerSeekBar;
import com.baidu.searchbox.player.event.ControlEvent;
import com.baidu.searchbox.player.event.LayerEvent;
import com.baidu.searchbox.player.event.PlayerEvent;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class f extends d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f1661h;
    public View i;
    public FrameLayout.LayoutParams j;

    public f() {
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
        this.j = null;
    }

    @Override // c.a.a0.v.b0.d
    public boolean A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            c.a.a0.v.j0.f a = c.a.a0.v.v0.l.a(q().v().getLayerList());
            return q().Q() || (a != null ? a.L() : false);
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.a0.v.b0.d
    public void B(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            super.B(z);
            if (z) {
                this.f1661h.setImageDrawable(getContext().getResources().getDrawable(R.drawable.obfuscated_res_0x7f080dea));
                return;
            }
            I(false);
            this.f1661h.setImageDrawable(getContext().getResources().getDrawable(R.drawable.obfuscated_res_0x7f080de7));
        }
    }

    public final void D(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            if (z) {
                this.i.startAnimation(c.a.a0.v.v0.f.b());
            } else {
                this.i.clearAnimation();
            }
            this.i.setVisibility(4);
        }
    }

    public final void E(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            if (z) {
                this.i.startAnimation(c.a.a0.v.v0.f.a());
            } else {
                this.i.clearAnimation();
            }
            this.i.setVisibility(0);
        }
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            I(false);
        }
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (q().V0() && q().f1() == 0 && this.i.getVisibility() != 4) {
                D(true);
            } else {
                D(false);
            }
        }
    }

    public final void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (q().V0() && q().f1() == 0) {
                E(true);
            } else {
                E(false);
            }
        }
    }

    public final void I(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
        }
    }

    public void J(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.f1661h.setVisibility(i);
        }
    }

    public void K(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            if (q().n1().f() && z) {
                this.f1661h.setVisibility(0);
            } else {
                this.f1661h.setVisibility(4);
            }
        }
    }

    @Override // c.a.a0.v.b0.a
    @Nullable
    public ViewGroup.LayoutParams f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.j : (ViewGroup.LayoutParams) invokeV.objValue;
    }

    @Override // c.a.a0.v.b0.a
    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            this.j = layoutParams;
            layoutParams.gravity = 80;
            ViewGroup viewGroup = (ViewGroup) View.inflate(getContext(), R.layout.obfuscated_res_0x7f0d05d4, null);
            this.f1655e = viewGroup;
            this.i = viewGroup.findViewById(R.id.obfuscated_res_0x7f09033b);
            BdLayerSeekBar bdLayerSeekBar = (BdLayerSeekBar) this.f1655e.findViewById(R.id.obfuscated_res_0x7f0911bf);
            this.f1656f = bdLayerSeekBar;
            bdLayerSeekBar.setSeekBarHolderListener(this);
            ImageView imageView = (ImageView) this.f1655e.findViewById(R.id.obfuscated_res_0x7f09092f);
            this.f1661h = imageView;
            imageView.setOnClickListener(this);
            D(false);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // c.a.a0.v.b0.d, c.a.a0.v.b0.e, c.a.a0.v.b0.a
    public void k(@NonNull c.a.a0.v.c0.p pVar) {
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, pVar) == null) {
            super.k(pVar);
            String c3 = pVar.c();
            switch (c3.hashCode()) {
                case -1532215489:
                    if (c3.equals(LayerEvent.ACTION_SET_BARRAGE_HOT_LIST)) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -849541738:
                    if (c3.equals(LayerEvent.ACTION_BARRAGE_CLICK)) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -552621273:
                    if (c3.equals(LayerEvent.ACTION_SWITCH_FULL)) {
                        c2 = 6;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -503058442:
                    if (c3.equals(LayerEvent.ACTION_SET_BARRAGE_HINT)) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 14382657:
                    if (c3.equals(ControlEvent.ACTION_STATUS_SYNC)) {
                        c2 = 4;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1610373035:
                    if (c3.equals(LayerEvent.ACTION_WAKE_UP_END)) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 2124623197:
                    if (c3.equals(PlayerEvent.ACTION_UPDATE_DATA_SOURCE)) {
                        c2 = 5;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            if (c2 == 3) {
                K(true);
            } else if (c2 != 4) {
                if (c2 == 6 && q().r1()) {
                    F();
                }
            } else {
                B(q().V0());
            }
        }
    }

    @Override // c.a.a0.v.b0.e, c.a.a0.v.b0.a
    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.m();
            this.f1656f.setSeekBarHolderListener(null);
        }
    }

    @Override // c.a.a0.v.b0.d, android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, view) == null) && view.equals(this.f1661h)) {
            ((c.a.a0.v.j0.k) this.a).g0(!q().V0());
        }
    }

    @Override // c.a.a0.v.b0.d, c.a.a0.v.b0.g
    public void s(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            super.s(z, z2);
            if (z) {
                H();
                return;
            }
            G();
            v();
        }
    }

    @Override // c.a.a0.v.b0.d, c.a.a0.v.b0.g
    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.t();
            K(true);
        }
    }

    @Override // c.a.a0.v.b0.e
    public View w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f1655e.findViewById(R.id.obfuscated_res_0x7f090268) : (View) invokeV.objValue;
    }
}

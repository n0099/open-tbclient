package c.a.b0.v.b0;

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
    public ImageView l;
    public View m;
    public FrameLayout.LayoutParams n;

    public f() {
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
        this.n = null;
    }

    public final void A(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            if (z) {
                this.m.startAnimation(c.a.b0.v.v0.f.b());
            } else {
                this.m.clearAnimation();
            }
            this.m.setVisibility(4);
        }
    }

    public final void B(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            if (z) {
                this.m.startAnimation(c.a.b0.v.v0.f.a());
            } else {
                this.m.clearAnimation();
            }
            this.m.setVisibility(0);
        }
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            F(false);
        }
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (n().V0() && n().f1() == 0 && this.m.getVisibility() != 4) {
                A(true);
            } else {
                A(false);
            }
        }
    }

    public final void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (n().V0() && n().f1() == 0) {
                B(true);
            } else {
                B(false);
            }
        }
    }

    public final void F(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
        }
    }

    public void G(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.l.setVisibility(i2);
        }
    }

    public void H(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            if (n().n1().f() && z) {
                this.l.setVisibility(0);
            } else {
                this.l.setVisibility(4);
            }
        }
    }

    @Override // c.a.b0.v.b0.a
    @Nullable
    public ViewGroup.LayoutParams c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.n : (ViewGroup.LayoutParams) invokeV.objValue;
    }

    @Override // c.a.b0.v.b0.a
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            this.n = layoutParams;
            layoutParams.gravity = 80;
            ViewGroup viewGroup = (ViewGroup) View.inflate(getContext(), R.layout.nad_videoplayer_bd_layer_control_bottom_view, null);
            this.f2045i = viewGroup;
            this.m = viewGroup.findViewById(R.id.bd_layer_bottom);
            BdLayerSeekBar bdLayerSeekBar = (BdLayerSeekBar) this.f2045i.findViewById(R.id.layer_seekbar);
            this.f2046j = bdLayerSeekBar;
            bdLayerSeekBar.setSeekBarHolderListener(this);
            ImageView imageView = (ImageView) this.f2045i.findViewById(R.id.expand_full_button);
            this.l = imageView;
            imageView.setOnClickListener(this);
            A(false);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // c.a.b0.v.b0.d, c.a.b0.v.b0.e, c.a.b0.v.b0.a
    public void h(@NonNull c.a.b0.v.c0.p pVar) {
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, pVar) == null) {
            super.h(pVar);
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
                H(true);
            } else if (c2 != 4) {
                if (c2 == 6 && n().r1()) {
                    C();
                }
            } else {
                y(n().V0());
            }
        }
    }

    @Override // c.a.b0.v.b0.e, c.a.b0.v.b0.a
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.j();
            this.f2046j.setSeekBarHolderListener(null);
        }
    }

    @Override // c.a.b0.v.b0.d, android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, view) == null) && view.equals(this.l)) {
            ((c.a.b0.v.j0.k) this.f2044e).g0(!n().V0());
        }
    }

    @Override // c.a.b0.v.b0.d, c.a.b0.v.b0.g
    public void p(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            super.p(z, z2);
            if (z) {
                E();
                return;
            }
            D();
            s();
        }
    }

    @Override // c.a.b0.v.b0.d, c.a.b0.v.b0.g
    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.q();
            H(true);
        }
    }

    @Override // c.a.b0.v.b0.e
    public View t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f2045i.findViewById(R.id.anchor) : (View) invokeV.objValue;
    }

    @Override // c.a.b0.v.b0.d
    public boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            c.a.b0.v.j0.f a = c.a.b0.v.v0.l.a(n().v().getLayerList());
            return n().Q() || (a != null ? a.L() : false);
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.b0.v.b0.d
    public void y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            super.y(z);
            if (z) {
                this.l.setImageDrawable(getContext().getResources().getDrawable(R.drawable.nad_videoplayer_new_player_half_selector));
                return;
            }
            F(false);
            this.l.setImageDrawable(getContext().getResources().getDrawable(R.drawable.nad_videoplayer_new_player_full_selector));
        }
    }
}

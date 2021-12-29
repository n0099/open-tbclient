package c.a.c0.s.j0;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.c0.h0.t;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.player.constants.PlayerStatus;
import com.baidu.nadcore.player.utils.BdNetUtils;
import com.baidu.searchbox.player.event.ControlEvent;
import com.baidu.searchbox.player.event.LayerEvent;
import com.baidu.searchbox.player.event.PlayerEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class m extends j implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: i  reason: collision with root package name */
    public FrameLayout f2424i;

    /* renamed from: j  reason: collision with root package name */
    public LinearLayout f2425j;

    /* renamed from: k  reason: collision with root package name */
    public TextView f2426k;
    public Button l;
    public LinearLayout m;
    public TextView n;
    public boolean o;

    public m() {
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
        this.o = true;
        FrameLayout frameLayout = new FrameLayout(this.f2414g);
        this.f2424i = frameLayout;
        frameLayout.setVisibility(4);
    }

    public final void K() {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (linearLayout = this.m) == null) {
            return;
        }
        linearLayout.setVisibility(8);
    }

    public final void L() {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (linearLayout = this.f2425j) == null) {
            return;
        }
        linearLayout.setVisibility(4);
    }

    public void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.m == null) {
                LinearLayout linearLayout = (LinearLayout) View.inflate(this.f2414g, c.a.c0.h0.s.nad_bdvideoplayer_layout_kernel_error, null);
                this.m = linearLayout;
                TextView textView = (TextView) linearLayout.findViewById(c.a.c0.h0.r.play_error_layout_retry);
                this.n = textView;
                textView.setOnClickListener(this);
                this.f2424i.addView(this.m, new FrameLayout.LayoutParams(-1, -1));
            }
            this.n.setText(t.nad_bdvideoplayer_tip_kernel_error);
            O(u().V0());
            this.m.setVisibility(0);
        }
    }

    public void N() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.o) {
            if (this.f2425j == null) {
                LinearLayout linearLayout = (LinearLayout) View.inflate(this.f2414g, c.a.c0.h0.s.nad_bdvideoplayer_layout_net_error, null);
                this.f2425j = linearLayout;
                this.f2426k = (TextView) linearLayout.findViewById(c.a.c0.h0.r.tv_error);
                Button button = (Button) this.f2425j.findViewById(c.a.c0.h0.r.bt_retry);
                this.l = button;
                button.setOnClickListener(this);
                this.f2424i.addView(this.f2425j, new FrameLayout.LayoutParams(-1, -1));
            }
            P(u().V0());
            F(c.a.c0.s.c0.f.w(LayerEvent.ACTION_NET_ERROR_SHOW));
            this.f2425j.setVisibility(0);
            u().y().y(true);
        }
    }

    public final void O(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            Drawable[] compoundDrawables = this.n.getCompoundDrawables();
            if (z) {
                this.n.setTextSize(0, this.f2414g.getResources().getDimensionPixelOffset(c.a.c0.h0.p.nad_bdvideoplayer_dimens_14dp));
                compoundDrawables[1].setBounds(0, 0, this.f2414g.getResources().getDimensionPixelOffset(c.a.c0.h0.p.nad_bdvideoplayer_dimens_47dp), this.f2414g.getResources().getDimensionPixelOffset(c.a.c0.h0.p.nad_bdvideoplayer_dimens_47dp));
            } else {
                this.n.setTextSize(0, this.f2414g.getResources().getDimensionPixelOffset(c.a.c0.h0.p.nad_bdvideoplayer_dimens_12dp));
                compoundDrawables[1].setBounds(0, 0, this.f2414g.getResources().getDimensionPixelOffset(c.a.c0.h0.p.nad_bdvideoplayer_dimens_42dp), this.f2414g.getResources().getDimensionPixelOffset(c.a.c0.h0.p.nad_bdvideoplayer_dimens_42dp));
            }
            this.n.setCompoundDrawables(compoundDrawables[0], compoundDrawables[1], compoundDrawables[2], compoundDrawables[3]);
        }
    }

    public final void P(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.l.getLayoutParams();
            if (z) {
                this.f2426k.setTextSize(0, this.f2414g.getResources().getDimensionPixelOffset(c.a.c0.h0.p.nad_bdvideoplayer_dimens_14dp));
                this.l.setTextSize(0, this.f2414g.getResources().getDimensionPixelOffset(c.a.c0.h0.p.nad_bdvideoplayer_dimens_14dp));
                layoutParams.width = this.f2414g.getResources().getDimensionPixelOffset(c.a.c0.h0.p.nad_bdvideoplayer_dimens_102dp);
                layoutParams.height = this.f2414g.getResources().getDimensionPixelOffset(c.a.c0.h0.p.nad_bdvideoplayer_dimens_32dp);
                layoutParams.topMargin = this.f2414g.getResources().getDimensionPixelOffset(c.a.c0.h0.p.nad_bdvideoplayer_dimens_31dp);
            } else {
                this.f2426k.setTextSize(0, this.f2414g.getResources().getDimensionPixelOffset(c.a.c0.h0.p.nad_bdvideoplayer_dimens_12dp));
                this.l.setTextSize(0, this.f2414g.getResources().getDimensionPixelOffset(c.a.c0.h0.p.nad_bdvideoplayer_dimens_12dp));
                layoutParams.width = this.f2414g.getResources().getDimensionPixelOffset(c.a.c0.h0.p.nad_bdvideoplayer_dimens_66dp);
                layoutParams.height = this.f2414g.getResources().getDimensionPixelOffset(c.a.c0.h0.p.nad_bdvideoplayer_dimens_24_33dp);
                layoutParams.topMargin = this.f2414g.getResources().getDimensionPixelOffset(c.a.c0.h0.p.nad_bdvideoplayer_dimens_24dp);
            }
            this.l.setLayoutParams(layoutParams);
        }
    }

    @Override // c.a.c0.s.j0.b, c.a.c0.s.f0.j
    public void d(@NonNull c.a.c0.s.c0.p pVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, pVar) == null) && PlayerEvent.ACTION_ON_ERROR.equals(pVar.c()) && !u().U0()) {
            this.f2424i.setVisibility(0);
            u().y().j(this);
            if (!BdNetUtils.f()) {
                N();
                K();
                return;
            }
            M();
            L();
        }
    }

    @Override // c.a.c0.s.j0.o
    @NonNull
    public View getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f2424i : (View) invokeV.objValue;
    }

    @Override // c.a.c0.s.f0.j
    @Nullable
    public int[] getSubscribeEvent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? new int[]{4, 5, 2, 3, 8} : (int[]) invokeV.objValue;
    }

    @Override // c.a.c0.s.j0.b, c.a.c0.s.f0.j
    public void h(PlayerStatus playerStatus, PlayerStatus playerStatus2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, playerStatus, playerStatus2) == null) {
            super.h(playerStatus, playerStatus2);
            if (playerStatus == PlayerStatus.PLAYING || playerStatus == PlayerStatus.PREPARING) {
                u().y().i(this);
                L();
                K();
            }
        }
    }

    @Override // c.a.c0.s.j0.b, c.a.c0.s.f0.j
    public void k(@NonNull c.a.c0.s.c0.p pVar) {
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, pVar) == null) {
            String c3 = pVar.c();
            int hashCode = c3.hashCode();
            if (hashCode == -552621273) {
                if (c3.equals(LayerEvent.ACTION_SWITCH_FULL)) {
                    c2 = 0;
                }
                c2 = 65535;
            } else if (hashCode != -552580917) {
                if (hashCode == 1409909918 && c3.equals(LayerEvent.ACTION_SWITCH_FLOATING)) {
                    c2 = 2;
                }
                c2 = 65535;
            } else {
                if (c3.equals(LayerEvent.ACTION_SWITCH_HALF)) {
                    c2 = 1;
                }
                c2 = 65535;
            }
            if (c2 == 0) {
                if (this.f2425j != null) {
                    P(true);
                }
                if (this.m != null) {
                    O(true);
                }
            } else if (c2 != 1) {
                if (c2 != 2) {
                    return;
                }
                K();
                L();
            } else {
                if (this.f2425j != null) {
                    P(false);
                }
                if (this.m != null) {
                    O(false);
                }
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, view) == null) {
            if (view.getId() == c.a.c0.h0.r.bt_retry || view.getId() == c.a.c0.h0.r.play_error_layout_retry) {
                if (!BdNetUtils.f()) {
                    ViewGroup n = u().n();
                    if (n != null && u().n1().a()) {
                        c.a.c0.b0.b.a().b(n.getContext(), t.nad_bdvideoplayer_tip_net_error);
                        return;
                    }
                    return;
                }
                K();
                L();
                this.f2424i.setVisibility(4);
                u().m0();
                F(c.a.c0.s.c0.f.w(LayerEvent.ACTION_CLICK_RETRY));
            }
        }
    }

    @Override // c.a.c0.s.j0.b, c.a.c0.s.f0.j
    public void q(@NonNull c.a.c0.s.c0.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, pVar) == null) {
            if (ControlEvent.ACTION_RESUME.equals(pVar.c()) || ControlEvent.ACTION_SHOW_TIP.equals(pVar.c()) || ControlEvent.ACTION_START.equals(pVar.c())) {
                u().y().i(this);
                K();
                L();
            }
        }
    }
}

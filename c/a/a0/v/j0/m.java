package c.a.a0.v.j0;

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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.player.constants.PlayerStatus;
import com.baidu.nadcore.player.utils.BdNetUtils;
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
public class m extends j implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public FrameLayout f1753e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f1754f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f1755g;

    /* renamed from: h  reason: collision with root package name */
    public Button f1756h;
    public LinearLayout i;
    public TextView j;
    public boolean k;

    public m() {
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
        this.k = true;
        FrameLayout frameLayout = new FrameLayout(this.f1743c);
        this.f1753e = frameLayout;
        frameLayout.setVisibility(4);
    }

    public final void K() {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (linearLayout = this.i) == null) {
            return;
        }
        linearLayout.setVisibility(8);
    }

    public final void L() {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (linearLayout = this.f1754f) == null) {
            return;
        }
        linearLayout.setVisibility(4);
    }

    public void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.i == null) {
                LinearLayout linearLayout = (LinearLayout) View.inflate(this.f1743c, R.layout.obfuscated_res_0x7f0d05a0, null);
                this.i = linearLayout;
                TextView textView = (TextView) linearLayout.findViewById(R.id.obfuscated_res_0x7f09185b);
                this.j = textView;
                textView.setOnClickListener(this);
                this.f1753e.addView(this.i, new FrameLayout.LayoutParams(-1, -1));
            }
            this.j.setText(R.string.obfuscated_res_0x7f0f0b49);
            O(u().V0());
            this.i.setVisibility(0);
        }
    }

    public void N() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.k) {
            if (this.f1754f == null) {
                LinearLayout linearLayout = (LinearLayout) View.inflate(this.f1743c, R.layout.obfuscated_res_0x7f0d05a1, null);
                this.f1754f = linearLayout;
                this.f1755g = (TextView) linearLayout.findViewById(R.id.obfuscated_res_0x7f0921a9);
                Button button = (Button) this.f1754f.findViewById(R.id.obfuscated_res_0x7f0903f7);
                this.f1756h = button;
                button.setOnClickListener(this);
                this.f1753e.addView(this.f1754f, new FrameLayout.LayoutParams(-1, -1));
            }
            P(u().V0());
            F(c.a.a0.v.c0.f.w(LayerEvent.ACTION_NET_ERROR_SHOW));
            this.f1754f.setVisibility(0);
            u().y().y(true);
        }
    }

    public final void O(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            Drawable[] compoundDrawables = this.j.getCompoundDrawables();
            if (z) {
                this.j.setTextSize(0, this.f1743c.getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f070485));
                compoundDrawables[1].setBounds(0, 0, this.f1743c.getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f070491), this.f1743c.getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f070491));
            } else {
                this.j.setTextSize(0, this.f1743c.getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f070483));
                compoundDrawables[1].setBounds(0, 0, this.f1743c.getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f070490), this.f1743c.getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f070490));
            }
            this.j.setCompoundDrawables(compoundDrawables[0], compoundDrawables[1], compoundDrawables[2], compoundDrawables[3]);
        }
    }

    public final void P(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f1756h.getLayoutParams();
            if (z) {
                this.f1755g.setTextSize(0, this.f1743c.getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f070485));
                this.f1756h.setTextSize(0, this.f1743c.getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f070485));
                layoutParams.width = this.f1743c.getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f070480);
                layoutParams.height = this.f1743c.getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f07048e);
                layoutParams.topMargin = this.f1743c.getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f07048d);
            } else {
                this.f1755g.setTextSize(0, this.f1743c.getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f070483));
                this.f1756h.setTextSize(0, this.f1743c.getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f070483));
                layoutParams.width = this.f1743c.getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f070494);
                layoutParams.height = this.f1743c.getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f070489);
                layoutParams.topMargin = this.f1743c.getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f07048a);
            }
            this.f1756h.setLayoutParams(layoutParams);
        }
    }

    @Override // c.a.a0.v.j0.b, c.a.a0.v.f0.j
    public void d(@NonNull c.a.a0.v.c0.p pVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, pVar) == null) && PlayerEvent.ACTION_ON_ERROR.equals(pVar.c()) && !u().U0()) {
            this.f1753e.setVisibility(0);
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

    @Override // c.a.a0.v.j0.o
    @NonNull
    public View getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f1753e : (View) invokeV.objValue;
    }

    @Override // c.a.a0.v.f0.j
    @Nullable
    public int[] getSubscribeEvent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? new int[]{4, 5, 2, 3, 8} : (int[]) invokeV.objValue;
    }

    @Override // c.a.a0.v.j0.b, c.a.a0.v.f0.j
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

    @Override // c.a.a0.v.j0.b, c.a.a0.v.f0.j
    public void k(@NonNull c.a.a0.v.c0.p pVar) {
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
                if (this.f1754f != null) {
                    P(true);
                }
                if (this.i != null) {
                    O(true);
                }
            } else if (c2 != 1) {
                if (c2 != 2) {
                    return;
                }
                K();
                L();
            } else {
                if (this.f1754f != null) {
                    P(false);
                }
                if (this.i != null) {
                    O(false);
                }
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, view) == null) {
            if (view.getId() == R.id.obfuscated_res_0x7f0903f7 || view.getId() == R.id.obfuscated_res_0x7f09185b) {
                if (!BdNetUtils.f()) {
                    ViewGroup n = u().n();
                    if (n != null && u().n1().a()) {
                        c.a.a0.e0.b.a().b(n.getContext(), R.string.obfuscated_res_0x7f0f0b4a);
                        return;
                    }
                    return;
                }
                K();
                L();
                this.f1753e.setVisibility(4);
                u().m0();
                F(c.a.a0.v.c0.f.w(LayerEvent.ACTION_CLICK_RETRY));
            }
        }
    }

    @Override // c.a.a0.v.j0.b, c.a.a0.v.f0.j
    public void q(@NonNull c.a.a0.v.c0.p pVar) {
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

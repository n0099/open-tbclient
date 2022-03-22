package c.a.a0.v.l0.b;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.a0.v.c0.p;
import c.a.a0.v.j0.j;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.player.constants.PlayerStatus;
import com.baidu.nadcore.player.minivideo.view.LineLoadingView;
import com.baidu.searchbox.player.event.ControlEvent;
import com.baidu.searchbox.player.event.PlayerEvent;
import com.baidu.searchbox.player.event.SystemEvent;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class a extends j implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ViewGroup f1784e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f1785f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f1786g;

    /* renamed from: h  reason: collision with root package name */
    public LineLoadingView f1787h;

    public a() {
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
        this.f1786g = false;
    }

    @Override // c.a.a0.v.j0.b
    @SuppressLint({"InflateParams"})
    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.f1743c).inflate(R.layout.obfuscated_res_0x7f0d05bd, (ViewGroup) null);
            this.f1784e = viewGroup;
            this.f1785f = (ImageView) viewGroup.findViewById(R.id.obfuscated_res_0x7f092357);
            this.f1787h = (LineLoadingView) this.f1784e.findViewById(R.id.obfuscated_res_0x7f091262);
        }
    }

    public void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f1787h.g();
        }
    }

    public void L(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.f1786g = z;
        }
    }

    public void M(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048579, this, i) == null) && this.f1786g) {
            this.f1785f.setVisibility(i);
            this.f1786g = false;
        }
    }

    public final void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f1787h.f();
        }
    }

    @Override // c.a.a0.v.j0.b, c.a.a0.v.f0.j
    public void d(@NonNull p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, pVar) == null) {
            if (PlayerEvent.ACTION_ON_INFO.equals(pVar.c())) {
                int intValue = ((Integer) pVar.f(1)).intValue();
                if (intValue == 904 || 956 == intValue) {
                    this.f1786g = false;
                    this.f1785f.setVisibility(4);
                    K();
                } else if (701 == intValue) {
                    N();
                } else if (702 == intValue) {
                    K();
                }
            } else if (PlayerEvent.ACTION_ON_PREPARED.equals(pVar.c())) {
                K();
            } else if (PlayerEvent.ACTION_ON_ERROR.equals(pVar.c())) {
                K();
            }
        }
    }

    @Override // c.a.a0.v.j0.o
    public View getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f1784e : (View) invokeV.objValue;
    }

    @Override // c.a.a0.v.f0.j
    @Nullable
    public int[] getSubscribeEvent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? new int[]{4, 2, 1, 5} : (int[]) invokeV.objValue;
    }

    @Override // c.a.a0.v.j0.b, c.a.a0.v.f0.j
    public void h(PlayerStatus playerStatus, PlayerStatus playerStatus2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, playerStatus, playerStatus2) == null) {
            super.h(playerStatus, playerStatus2);
            if (playerStatus == PlayerStatus.PLAYING || playerStatus == PlayerStatus.PAUSE || playerStatus == PlayerStatus.STOP) {
                K();
            }
        }
    }

    @Override // c.a.a0.v.j0.b, c.a.a0.v.f0.j
    public void n(@NonNull p pVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, pVar) == null) || !SystemEvent.ACTION_VOLUME_CHANGED.equals(pVar.c()) || u().a0() || u().Q() || ((Integer) pVar.f(5)).intValue() <= 0 || !u().V()) {
            return;
        }
        u().w0(false);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, view) == null) {
        }
    }

    @Override // c.a.a0.v.j0.b, c.a.a0.v.f0.j
    public void q(@NonNull p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, pVar) == null) {
            if (ControlEvent.ACTION_PAUSE.equals(pVar.c())) {
                if (this.f1786g) {
                    this.f1785f.setVisibility(0);
                }
            } else if (ControlEvent.ACTION_RESUME.equals(pVar.c())) {
                this.f1786g = false;
                this.f1785f.setVisibility(4);
            } else if (ControlEvent.ACTION_START.equals(pVar.c())) {
                if (u().Y()) {
                    return;
                }
                N();
            } else if (ControlEvent.ACTION_STOP.equals(pVar.c())) {
                K();
            }
        }
    }
}

package c.a.b0.v.l0.b;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.b0.v.c0.p;
import c.a.b0.v.j0.j;
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

    /* renamed from: i  reason: collision with root package name */
    public ViewGroup f2172i;

    /* renamed from: j  reason: collision with root package name */
    public ImageView f2173j;
    public boolean k;
    public LineLoadingView l;

    public a() {
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
        this.k = false;
    }

    @Override // c.a.b0.v.j0.b
    @SuppressLint({"InflateParams"})
    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.f2135g).inflate(R.layout.nad_mini_video_control_layer, (ViewGroup) null);
            this.f2172i = viewGroup;
            this.f2173j = (ImageView) viewGroup.findViewById(R.id.video_pause_icon);
            this.l = (LineLoadingView) this.f2172i.findViewById(R.id.line_loading_view);
        }
    }

    public void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.l.stop();
        }
    }

    public void L(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.k = z;
        }
    }

    public void M(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048579, this, i2) == null) && this.k) {
            this.f2173j.setVisibility(i2);
            this.k = false;
        }
    }

    public final void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.l.start();
        }
    }

    @Override // c.a.b0.v.j0.b, c.a.b0.v.f0.j
    public void d(@NonNull p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, pVar) == null) {
            if (PlayerEvent.ACTION_ON_INFO.equals(pVar.c())) {
                int intValue = ((Integer) pVar.f(1)).intValue();
                if (intValue == 904 || 956 == intValue) {
                    this.k = false;
                    this.f2173j.setVisibility(4);
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

    @Override // c.a.b0.v.j0.o
    public View getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f2172i : (View) invokeV.objValue;
    }

    @Override // c.a.b0.v.f0.j
    @Nullable
    public int[] getSubscribeEvent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? new int[]{4, 2, 1, 5} : (int[]) invokeV.objValue;
    }

    @Override // c.a.b0.v.j0.b, c.a.b0.v.f0.j
    public void h(PlayerStatus playerStatus, PlayerStatus playerStatus2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, playerStatus, playerStatus2) == null) {
            super.h(playerStatus, playerStatus2);
            if (playerStatus == PlayerStatus.PLAYING || playerStatus == PlayerStatus.PAUSE || playerStatus == PlayerStatus.STOP) {
                K();
            }
        }
    }

    @Override // c.a.b0.v.j0.b, c.a.b0.v.f0.j
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

    @Override // c.a.b0.v.j0.b, c.a.b0.v.f0.j
    public void q(@NonNull p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, pVar) == null) {
            if (ControlEvent.ACTION_PAUSE.equals(pVar.c())) {
                if (this.k) {
                    this.f2173j.setVisibility(0);
                }
            } else if (ControlEvent.ACTION_RESUME.equals(pVar.c())) {
                this.k = false;
                this.f2173j.setVisibility(4);
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

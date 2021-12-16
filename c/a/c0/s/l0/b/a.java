package c.a.c0.s.l0.b;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.c0.h0.r;
import c.a.c0.h0.s;
import c.a.c0.s.c0.p;
import c.a.c0.s.j0.j;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.player.constants.PlayerStatus;
import com.baidu.nadcore.player.minivideo.view.LineLoadingView;
import com.baidu.searchbox.player.event.ControlEvent;
import com.baidu.searchbox.player.event.PlayerEvent;
import com.baidu.searchbox.player.event.SystemEvent;
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
    public ViewGroup f2031i;

    /* renamed from: j  reason: collision with root package name */
    public ImageView f2032j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f2033k;
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
        this.f2033k = false;
    }

    @Override // c.a.c0.s.j0.b
    @SuppressLint({"InflateParams"})
    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.f1987g).inflate(s.nad_mini_video_control_layer, (ViewGroup) null);
            this.f2031i = viewGroup;
            this.f2032j = (ImageView) viewGroup.findViewById(r.video_pause_icon);
            this.l = (LineLoadingView) this.f2031i.findViewById(r.line_loading_view);
        }
    }

    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.l.stop();
        }
    }

    public void Q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.f2033k = z;
        }
    }

    public void S(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048579, this, i2) == null) && this.f2033k) {
            this.f2032j.setVisibility(i2);
            this.f2033k = false;
        }
    }

    public final void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.l.start();
        }
    }

    @Override // c.a.c0.s.j0.b, c.a.c0.s.f0.j
    public void d(@NonNull p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, pVar) == null) {
            if (PlayerEvent.ACTION_ON_INFO.equals(pVar.c())) {
                int intValue = ((Integer) pVar.f(1)).intValue();
                if (intValue == 904 || 956 == intValue) {
                    this.f2033k = false;
                    this.f2032j.setVisibility(4);
                    O();
                } else if (701 == intValue) {
                    T();
                } else if (702 == intValue) {
                    O();
                }
            } else if (PlayerEvent.ACTION_ON_PREPARED.equals(pVar.c())) {
                O();
            } else if (PlayerEvent.ACTION_ON_ERROR.equals(pVar.c())) {
                O();
            }
        }
    }

    @Override // c.a.c0.s.j0.o
    public View getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f2031i : (View) invokeV.objValue;
    }

    @Override // c.a.c0.s.f0.j
    @Nullable
    public int[] getSubscribeEvent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? new int[]{4, 2, 1, 5} : (int[]) invokeV.objValue;
    }

    @Override // c.a.c0.s.j0.b, c.a.c0.s.f0.j
    public void h(PlayerStatus playerStatus, PlayerStatus playerStatus2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, playerStatus, playerStatus2) == null) {
            super.h(playerStatus, playerStatus2);
            if (playerStatus == PlayerStatus.PLAYING || playerStatus == PlayerStatus.PAUSE || playerStatus == PlayerStatus.STOP) {
                O();
            }
        }
    }

    @Override // c.a.c0.s.j0.b, c.a.c0.s.f0.j
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

    @Override // c.a.c0.s.j0.b, c.a.c0.s.f0.j
    public void q(@NonNull p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, pVar) == null) {
            if (ControlEvent.ACTION_PAUSE.equals(pVar.c())) {
                if (this.f2033k) {
                    this.f2032j.setVisibility(0);
                }
            } else if (ControlEvent.ACTION_RESUME.equals(pVar.c())) {
                this.f2033k = false;
                this.f2032j.setVisibility(4);
            } else if (ControlEvent.ACTION_START.equals(pVar.c())) {
                if (u().Y()) {
                    return;
                }
                T();
            } else if (ControlEvent.ACTION_STOP.equals(pVar.c())) {
                O();
            }
        }
    }
}

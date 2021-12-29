package c.a.c0.s.q0;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.c0.s.c0.k;
import c.a.c0.s.c0.p;
import c.a.c0.s.d;
import c.a.c0.s.k0.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.player.constants.PlayerStatus;
import com.baidu.searchbox.player.event.PlayerEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public c a;

    /* renamed from: b  reason: collision with root package name */
    public PlayerStatus f2527b;

    /* renamed from: c  reason: collision with root package name */
    public StringBuilder f2528c;

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
        this.f2527b = PlayerStatus.IDLE;
        d();
    }

    public void a(p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, pVar) == null) {
            if (pVar.getType() == 4 || pVar.getType() == 2) {
                String c2 = pVar.c();
                char c3 = 65535;
                switch (c2.hashCode()) {
                    case -525235558:
                        if (c2.equals(PlayerEvent.ACTION_ON_PREPARED)) {
                            c3 = 2;
                            break;
                        }
                        break;
                    case -461848373:
                        if (c2.equals(PlayerEvent.ACTION_ON_ERROR)) {
                            c3 = 3;
                            break;
                        }
                        break;
                    case 154871702:
                        if (c2.equals(PlayerEvent.ACTION_ON_COMPLETE)) {
                            c3 = 1;
                            break;
                        }
                        break;
                    case 1370689931:
                        if (c2.equals(PlayerEvent.ACTION_ON_INFO)) {
                            c3 = 0;
                            break;
                        }
                        break;
                }
                if (c3 == 0) {
                    int g2 = pVar.g(1);
                    if (904 == g2 || 956 == g2) {
                        g(PlayerStatus.PLAYING);
                    }
                } else if (c3 == 1) {
                    g(PlayerStatus.COMPLETE);
                } else if (c3 == 2) {
                    g(PlayerStatus.PREPARED);
                } else if (c3 != 3) {
                } else {
                    g(PlayerStatus.ERROR);
                }
            }
        }
    }

    public void b(@NonNull c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            this.a = cVar;
        }
    }

    @NonNull
    public PlayerStatus c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f2527b : (PlayerStatus) invokeV.objValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    public boolean e(@NonNull PlayerStatus... playerStatusArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, playerStatusArr)) == null) {
            for (PlayerStatus playerStatus : playerStatusArr) {
                if (playerStatus == c()) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            h();
            this.f2527b = PlayerStatus.IDLE;
        }
    }

    public void g(PlayerStatus playerStatus) {
        PlayerStatus playerStatus2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, playerStatus) == null) || playerStatus == (playerStatus2 = this.f2527b)) {
            return;
        }
        this.f2527b = playerStatus;
        c cVar = this.a;
        if (cVar != null) {
            cVar.d(k.w(playerStatus2, playerStatus));
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.a = null;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (d.f()) {
                StringBuilder sb = this.f2528c;
                if (sb == null) {
                    this.f2528c = new StringBuilder();
                } else if (sb.length() > 0) {
                    StringBuilder sb2 = this.f2528c;
                    sb2.delete(0, sb2.length());
                }
                StringBuilder sb3 = this.f2528c;
                sb3.append("，Courier :");
                sb3.append(this.a);
                sb3.append("，status :");
                sb3.append(this.f2527b);
                sb3.append("，hash :");
                sb3.append(hashCode());
                sb3.append("】");
                return this.f2528c.toString();
            }
            return super.toString();
        }
        return (String) invokeV.objValue;
    }
}

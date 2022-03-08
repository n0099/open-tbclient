package c.a.b0.v.c0;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.player.event.StatisticsEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class m extends j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

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
            }
        }
    }

    public void d(int i2, int i3, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048576, this, i2, i3, obj) == null) {
            p w = l.w(StatisticsEvent.ACTION_PLAYER_ERROR);
            w.n(2, String.valueOf(obj));
            w.n(4, Integer.valueOf(i3));
            c(w);
        }
    }

    public void e(int i2, int i3, Object obj) {
        p w;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, obj) == null) {
            if (i2 == 701) {
                w = l.w(StatisticsEvent.ACTION_BUFFER_START);
            } else if (i2 == 702) {
                w = l.w(StatisticsEvent.ACTION_BUFFER_END);
            } else if (i2 == 904 || i2 == 956) {
                w = l.w(StatisticsEvent.ACTION_PLAYER_FIRST_FRAME_DISPLAY);
                w.n(2, String.valueOf(obj));
            } else if (i2 == 10009) {
                w = l.w("statistics_player_carlton");
                w.n(2, String.valueOf(obj));
            } else if (i2 != 11004) {
                w = i2 != 11005 ? null : l.w(StatisticsEvent.ACTION_ERROR_RETRY_END);
            } else {
                w = l.w(StatisticsEvent.ACTION_ERROR_RETRY_START);
                w.n(4, Integer.valueOf(i3));
            }
            if (w != null) {
                c(w);
            }
        }
    }

    public void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            p w = l.w(StatisticsEvent.ACTION_PLAYER_COMPLETE);
            w.n(1, Integer.valueOf(i2));
            c(w);
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            c(l.w(StatisticsEvent.ACTION_PLAYER_PAUSE));
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            c(l.w(StatisticsEvent.ACTION_PLAYER_RESUME));
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            c(l.w(StatisticsEvent.ACTION_PLAYER_START));
        }
    }

    public void j(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            p w = l.w(StatisticsEvent.ACTION_PLAYER_STOP);
            w.n(1, Integer.valueOf(i2));
            c(w);
        }
    }
}

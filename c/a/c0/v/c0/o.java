package c.a.c0.v.c0;

import androidx.core.view.InputDeviceCompat;
import c.a.c0.v.c0.r;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.player.helper.NetUtils;
import com.baidu.searchbox.player.event.SystemEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class o extends a implements r.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final r f2361b;

    public o() {
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
        this.f2361b = new r(this);
    }

    @Override // c.a.c0.v.c0.r.a
    public void a(NetUtils.NetStatus netStatus, NetUtils.NetStatus netStatus2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, netStatus, netStatus2) == null) {
            p w = n.w(SystemEvent.ACTION_CONNECT_CHANGED);
            w.n(1, netStatus2);
            c(w);
        }
    }

    @Override // c.a.c0.v.c0.r.a
    public void onBatteryChanged(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            p w = n.w(SystemEvent.ACTION_BATTERY_CHANGED);
            w.r(1);
            w.n(4, Integer.valueOf(i2));
            c(w);
        }
    }

    @Override // c.a.c0.v.c0.r.a
    public void onBluetoothHeadsetChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            p w = n.w(SystemEvent.ACTION_BLUETOOTH_HEADSET);
            w.n(6, Boolean.valueOf(z));
            c(w);
        }
    }

    @Override // c.a.c0.v.c0.r.a
    public void onConfigurationChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            c(n.w(SystemEvent.ACTION_CONFIGURATION_CHANGED));
        }
    }

    @Override // c.a.c0.v.c0.r.a
    public void onHeadsetPlug(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            p w = n.w(SystemEvent.ACTION_HEADSET_PLUG);
            w.n(3, Boolean.valueOf(z));
            c(w);
        }
    }

    @Override // c.a.c0.v.c0.r.a
    public void onScreenStatusChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            p w = n.w(z ? SystemEvent.ACTION_SCREEN_OFF : SystemEvent.ACTION_SCREEN_ON);
            w.n(2, Boolean.valueOf(z));
            c(w);
        }
    }

    @Override // c.a.c0.v.c0.r.a
    public void onVolumeChanged(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            p w = n.w(SystemEvent.ACTION_VOLUME_CHANGED);
            w.n(5, Integer.valueOf(i2));
            c(w);
        }
    }

    public void registerReceiver() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            try {
                this.f2361b.registerReceiver();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void unregisterReceiver() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            try {
                this.f2361b.unregisterReceiver();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}

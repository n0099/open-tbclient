package c.a.b0.s.c0;

import androidx.core.view.InputDeviceCompat;
import c.a.b0.s.c0.r;
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
    public final r f1912b;

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
        this.f1912b = new r(this);
    }

    @Override // c.a.b0.s.c0.r.a
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            d(n.w("system_event_configuration_changed"));
        }
    }

    @Override // c.a.b0.s.c0.r.a
    public void b(NetUtils.NetStatus netStatus, NetUtils.NetStatus netStatus2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, netStatus, netStatus2) == null) {
            p w = n.w(SystemEvent.ACTION_CONNECT_CHANGED);
            w.n(1, netStatus2);
            d(w);
        }
    }

    @Override // c.a.b0.s.c0.r.a
    public void onBatteryChanged(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            p w = n.w(SystemEvent.ACTION_BATTERY_CHANGED);
            w.r(1);
            w.n(4, Integer.valueOf(i2));
            d(w);
        }
    }

    @Override // c.a.b0.s.c0.r.a
    public void onBluetoothHeadsetChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            p w = n.w(SystemEvent.ACTION_BLUETOOTH_HEADSET);
            w.n(6, Boolean.valueOf(z));
            d(w);
        }
    }

    @Override // c.a.b0.s.c0.r.a
    public void onHeadsetPlug(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            p w = n.w(SystemEvent.ACTION_HEADSET_PLUG);
            w.n(3, Boolean.valueOf(z));
            d(w);
        }
    }

    @Override // c.a.b0.s.c0.r.a
    public void onScreenStatusChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            p w = n.w(z ? SystemEvent.ACTION_SCREEN_OFF : SystemEvent.ACTION_SCREEN_ON);
            w.n(2, Boolean.valueOf(z));
            d(w);
        }
    }

    @Override // c.a.b0.s.c0.r.a
    public void onVolumeChanged(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            p w = n.w(SystemEvent.ACTION_VOLUME_CHANGED);
            w.n(5, Integer.valueOf(i2));
            d(w);
        }
    }

    public void registerReceiver() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            try {
                this.f1912b.registerReceiver();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void unregisterReceiver() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            try {
                this.f1912b.unregisterReceiver();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}

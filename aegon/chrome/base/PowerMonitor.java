package aegon.chrome.base;

import aegon.chrome.base.annotations.CalledByNative;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class PowerMonitor {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static /* synthetic */ Interceptable $ic;
    public static PowerMonitor sInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mIsBatteryPower;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(2093919588, "Laegon/chrome/base/PowerMonitor;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(2093919588, "Laegon/chrome/base/PowerMonitor;");
        }
    }

    public PowerMonitor() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @CalledByNative
    public static boolean isBatteryPower() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (sInstance == null) {
                ThreadUtils.assertOnUiThread();
                if (sInstance == null) {
                    Context context = ContextUtils.sApplicationContext;
                    sInstance = new PowerMonitor();
                    Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
                    if (registerReceiver != null) {
                        onBatteryChargingChanged(registerReceiver);
                    }
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
                    intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
                    context.registerReceiver(new BroadcastReceiver() { // from class: aegon.chrome.base.PowerMonitor.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                }
                            }
                        }

                        @Override // android.content.BroadcastReceiver
                        public void onReceive(Context context2, Intent intent) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeLL(1048576, this, context2, intent) == null) {
                                PowerMonitor.onBatteryChargingChanged(intent);
                            }
                        }
                    }, intentFilter);
                }
            }
            return sInstance.mIsBatteryPower;
        }
        return invokeV.booleanValue;
    }

    public static native void nativeOnBatteryChargingChanged();

    public static void onBatteryChargingChanged(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65540, null, intent) == null) {
            int intExtra = intent.getIntExtra("plugged", -1);
            boolean z = true;
            sInstance.mIsBatteryPower = (intExtra == 2 || intExtra == 1) ? false : false;
            nativeOnBatteryChargingChanged();
        }
    }
}

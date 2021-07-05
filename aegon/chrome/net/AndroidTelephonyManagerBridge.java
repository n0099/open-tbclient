package aegon.chrome.net;

import aegon.chrome.base.ContextUtils;
import aegon.chrome.base.ThreadUtils;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.TelephonyManager;
import androidx.annotation.AnyThread;
import androidx.annotation.MainThread;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@AnyThread
/* loaded from: classes.dex */
public class AndroidTelephonyManagerBridge {
    public static /* synthetic */ Interceptable $ic;
    public static volatile AndroidTelephonyManagerBridge sInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public Listener mListener;
    public volatile String mNetworkCountryIso;
    public volatile String mNetworkOperator;
    public volatile String mSimOperator;

    /* renamed from: aegon.chrome.net.AndroidTelephonyManagerBridge$1 */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes.dex */
    public class Listener extends PhoneStateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ServiceState mServiceState;

        public /* synthetic */ Listener(AnonymousClass1 anonymousClass1) {
            AndroidTelephonyManagerBridge.this = r1;
        }

        @Override // android.telephony.PhoneStateListener
        public void onServiceStateChanged(ServiceState serviceState) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, serviceState) == null) {
                ServiceState serviceState2 = this.mServiceState;
                if (serviceState2 == null || !serviceState2.equals(serviceState)) {
                    this.mServiceState = serviceState;
                    AndroidTelephonyManagerBridge.this.update(AndroidTelephonyManagerBridge.getTelephonyManager());
                }
            }
        }
    }

    public AndroidTelephonyManagerBridge() {
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

    public static AndroidTelephonyManagerBridge create() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            AndroidTelephonyManagerBridge androidTelephonyManagerBridge = new AndroidTelephonyManagerBridge();
            Runnable runnable = AndroidTelephonyManagerBridge$$Lambda$1.$ic;
            if (ThreadUtils.runningOnUiThread()) {
                runnable.run();
            } else {
                ThreadUtils.getUiThreadHandler().post(runnable);
            }
            return androidTelephonyManagerBridge;
        }
        return (AndroidTelephonyManagerBridge) invokeV.objValue;
    }

    public static AndroidTelephonyManagerBridge getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            AndroidTelephonyManagerBridge androidTelephonyManagerBridge = sInstance;
            if (androidTelephonyManagerBridge == null) {
                synchronized (AndroidTelephonyManagerBridge.class) {
                    androidTelephonyManagerBridge = sInstance;
                    if (androidTelephonyManagerBridge == null) {
                        androidTelephonyManagerBridge = create();
                        sInstance = androidTelephonyManagerBridge;
                    }
                }
            }
            return androidTelephonyManagerBridge;
        }
        return (AndroidTelephonyManagerBridge) invokeV.objValue;
    }

    public static TelephonyManager getTelephonyManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (TelephonyManager) ContextUtils.sApplicationContext.getSystemService("phone") : (TelephonyManager) invokeV.objValue;
    }

    public static /* synthetic */ void lambda$create$0(AndroidTelephonyManagerBridge androidTelephonyManagerBridge) {
        TelephonyManager telephonyManager = getTelephonyManager();
        if (telephonyManager != null) {
            androidTelephonyManagerBridge.listenTelephonyServiceState(telephonyManager);
        }
    }

    @MainThread
    public final void listenTelephonyServiceState(TelephonyManager telephonyManager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, telephonyManager) == null) {
            ThreadUtils.assertOnUiThread();
            Listener listener = new Listener(null);
            this.mListener = listener;
            telephonyManager.listen(listener, 1);
        }
    }

    public final void update(TelephonyManager telephonyManager) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, telephonyManager) == null) || telephonyManager == null) {
            return;
        }
        this.mNetworkCountryIso = telephonyManager.getNetworkCountryIso();
        this.mNetworkOperator = telephonyManager.getNetworkOperator();
        this.mSimOperator = telephonyManager.getSimOperator();
    }
}

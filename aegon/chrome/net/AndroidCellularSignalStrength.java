package aegon.chrome.net;

import aegon.chrome.base.ApplicationStatus;
import aegon.chrome.base.ContextUtils;
import aegon.chrome.base.ThreadUtils;
import aegon.chrome.base.annotations.CalledByNative;
import android.annotation.TargetApi;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class AndroidCellularSignalStrength {
    public static /* synthetic */ Interceptable $ic;
    public static final AndroidCellularSignalStrength sInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile int mSignalLevel;

    /* loaded from: classes.dex */
    public class CellStateListener extends PhoneStateListener implements ApplicationStatus.ApplicationStateListener {
        public static final /* synthetic */ boolean $assertionsDisabled = false;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final TelephonyManager mTelephonyManager;
        public final /* synthetic */ AndroidCellularSignalStrength this$0;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1328583832, "Laegon/chrome/net/AndroidCellularSignalStrength$CellStateListener;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1328583832, "Laegon/chrome/net/AndroidCellularSignalStrength$CellStateListener;");
            }
        }

        public CellStateListener(AndroidCellularSignalStrength androidCellularSignalStrength) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {androidCellularSignalStrength};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.this$0 = androidCellularSignalStrength;
            boolean z = ThreadUtils.sThreadAssertsDisabled;
            TelephonyManager telephonyManager = (TelephonyManager) ContextUtils.sApplicationContext.getSystemService("phone");
            this.mTelephonyManager = telephonyManager;
            if (telephonyManager.getSimState() != 5) {
                return;
            }
            ApplicationStatus.registerApplicationStateListener(this);
            this.mTelephonyManager.listen(this, 256);
        }

        @Override // android.telephony.PhoneStateListener
        @TargetApi(23)
        public void onSignalStrengthsChanged(SignalStrength signalStrength) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, signalStrength) == null) {
                try {
                    this.this$0.mSignalLevel = signalStrength.getLevel();
                } catch (SecurityException unused) {
                    this.this$0.mSignalLevel = Integer.MIN_VALUE;
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-647806745, "Laegon/chrome/net/AndroidCellularSignalStrength;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-647806745, "Laegon/chrome/net/AndroidCellularSignalStrength;");
                return;
            }
        }
        sInstance = new AndroidCellularSignalStrength();
    }

    public AndroidCellularSignalStrength() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mSignalLevel = Integer.MIN_VALUE;
        if (Build.VERSION.SDK_INT < 23) {
            return;
        }
        HandlerThread handlerThread = new HandlerThread("AndroidCellularSignalStrength");
        handlerThread.start();
        new Handler(handlerThread.getLooper()).post(new Runnable(this) { // from class: aegon.chrome.net.AndroidCellularSignalStrength.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ AndroidCellularSignalStrength this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    new CellStateListener(this.this$0);
                }
            }
        });
    }

    @CalledByNative
    @TargetApi(23)
    public static int getSignalStrengthLevel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? sInstance.mSignalLevel : invokeV.intValue;
    }
}

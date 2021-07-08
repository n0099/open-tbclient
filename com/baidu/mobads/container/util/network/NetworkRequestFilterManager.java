package com.baidu.mobads.container.util.network;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.mobads.container.util.CommonUtils;
import com.baidu.mobads.container.util.RemoteXAdLogger;
import com.baidu.mobads.container.util.SystemUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes2.dex */
public class NetworkRequestFilterManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "NetworkRequestFilterManager";
    public static final String USB_STATE = "android.hardware.usb.action.USB_STATE";
    public static volatile NetworkRequestFilterManager sInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public Context mContext;
    public boolean mIsAdbDebugConnected;
    public boolean mIsRootChecked;
    public boolean mIsRooted;
    public RemoteXAdLogger mLogger;
    public BroadcastReceiver mUsbStateChangeReceiver;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(198375830, "Lcom/baidu/mobads/container/util/network/NetworkRequestFilterManager;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(198375830, "Lcom/baidu/mobads/container/util/network/NetworkRequestFilterManager;");
        }
    }

    public NetworkRequestFilterManager(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mLogger = RemoteXAdLogger.getInstance();
        this.mUsbStateChangeReceiver = new BroadcastReceiver(this) { // from class: com.baidu.mobads.container.util.network.NetworkRequestFilterManager.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ NetworkRequestFilterManager this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
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

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                boolean z;
                boolean z2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(1048576, this, context2, intent) == null) {
                    RemoteXAdLogger remoteXAdLogger = this.this$0.mLogger;
                    String str = NetworkRequestFilterManager.TAG;
                    remoteXAdLogger.d(str, "onReceive: " + intent.getAction());
                    boolean z3 = false;
                    if (intent.getExtras() != null) {
                        z2 = intent.getExtras().getBoolean("connected");
                        z = intent.getExtras().getBoolean("adb");
                    } else {
                        z = false;
                        z2 = false;
                    }
                    NetworkRequestFilterManager networkRequestFilterManager = this.this$0;
                    if (networkRequestFilterManager.isAdbDebugEnable(context2) && z2 && z) {
                        z3 = true;
                    }
                    networkRequestFilterManager.mIsAdbDebugConnected = z3;
                }
            }
        };
        this.mContext = context.getApplicationContext();
        detectUsbWithBroadcast();
    }

    private void detectUsbWithBroadcast() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            this.mLogger.d(TAG, "listenUsb: register");
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.hardware.usb.action.USB_DEVICE_ATTACHED");
            intentFilter.addAction("android.hardware.usb.action.USB_DEVICE_DETACHED");
            intentFilter.addAction("android.hardware.usb.action.USB_ACCESSORY_ATTACHED");
            intentFilter.addAction("android.hardware.usb.action.USB_ACCESSORY_DETACHED");
            intentFilter.addAction(USB_STATE);
            this.mContext.registerReceiver(this.mUsbStateChangeReceiver, intentFilter);
            this.mLogger.d(TAG, "listenUsb: registered");
        }
    }

    public static NetworkRequestFilterManager getInstance(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            if (sInstance == null) {
                synchronized (NetworkRequestFilterManager.class) {
                    if (sInstance == null && context != null) {
                        sInstance = new NetworkRequestFilterManager(context);
                    }
                }
            }
            return sInstance;
        }
        return (NetworkRequestFilterManager) invokeL.objValue;
    }

    private String getSuPath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            for (String str : System.getenv("PATH").split(":")) {
                String str2 = str + "/su";
                if (new File(str2).exists()) {
                    this.mLogger.d(TAG, "path:" + str2 + " is exists");
                    return str2;
                }
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isAdbDebugEnable(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, this, context)) == null) {
            try {
                return SystemUtils.isAdbEnable(context);
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public boolean isAdbDebugConnected() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mIsAdbDebugConnected : invokeV.booleanValue;
    }

    public boolean isProxyRunning() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (CommonUtils.isWifi(this.mContext)) {
                return !TextUtils.isEmpty(System.getProperty("http.proxyHost"));
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isRooted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.mIsRootChecked) {
                return this.mIsRooted;
            }
            boolean z = getSuPath() != null;
            this.mIsRooted = z;
            this.mIsRootChecked = true;
            return z;
        }
        return invokeV.booleanValue;
    }
}

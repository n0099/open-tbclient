package aegon.chrome.net;

import aegon.chrome.base.ApplicationStatus;
import aegon.chrome.base.BuildConfig;
import aegon.chrome.base.ContextUtils;
import aegon.chrome.base.StrictModeContext;
import aegon.chrome.base.compat.ApiHelperForM;
import aegon.chrome.net.NetworkChangeNotifier;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.net.Socket;
import java.util.Arrays;
@SuppressLint({"NewApi"})
/* loaded from: classes.dex */
public class NetworkChangeNotifierAutoDetect extends BroadcastReceiver {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ConnectivityManagerDelegate mConnectivityManagerDelegate;
    public DefaultNetworkCallback mDefaultNetworkCallback;
    public final Handler mHandler;
    public boolean mIgnoreNextBroadcast;
    public final NetworkConnectivityIntentFilter mIntentFilter;
    public final Looper mLooper;
    public MyNetworkCallback mNetworkCallback;
    public NetworkRequest mNetworkRequest;
    public NetworkState mNetworkState;
    public final Observer mObserver;
    public boolean mRegisterNetworkCallbackFailed;
    public boolean mRegistered;
    public final RegistrationPolicy mRegistrationPolicy;
    public boolean mShouldSignalObserver;
    public WifiManagerDelegate mWifiManagerDelegate;

    /* loaded from: classes.dex */
    public static class ConnectivityManagerDelegate {
        public static final /* synthetic */ boolean $assertionsDisabled = false;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ConnectivityManager mConnectivityManager;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-138624836, "Laegon/chrome/net/NetworkChangeNotifierAutoDetect$ConnectivityManagerDelegate;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-138624836, "Laegon/chrome/net/NetworkChangeNotifierAutoDetect$ConnectivityManagerDelegate;");
                }
            }
        }

        public ConnectivityManagerDelegate(Context context) {
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
            this.mConnectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        }

        @TargetApi(21)
        public int getConnectionType(Network network) {
            NetworkInfo networkInfo;
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, network)) == null) {
                try {
                    try {
                        networkInfo = this.mConnectivityManager.getNetworkInfo(network);
                    } catch (Exception unused) {
                        networkInfo = this.mConnectivityManager.getNetworkInfo(network);
                    }
                } catch (Exception unused2) {
                    networkInfo = null;
                }
                if (networkInfo != null && networkInfo.getType() == 17) {
                    networkInfo = this.mConnectivityManager.getActiveNetworkInfo();
                }
                if (networkInfo == null || !networkInfo.isConnected()) {
                    return 6;
                }
                return NetworkChangeNotifierAutoDetect.access$000(networkInfo.getType(), networkInfo.getSubtype());
            }
            return invokeL.intValue;
        }

        @TargetApi(21)
        public Network getDefaultNetwork() {
            InterceptResult invokeV;
            Network network;
            Network[] allNetworksFiltered;
            NetworkInfo networkInfo;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (Build.VERSION.SDK_INT >= 23) {
                    network = ApiHelperForM.getActiveNetwork(this.mConnectivityManager);
                    if (network != null) {
                        return network;
                    }
                } else {
                    network = null;
                }
                NetworkInfo activeNetworkInfo = this.mConnectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo == null) {
                    return null;
                }
                for (Network network2 : NetworkChangeNotifierAutoDetect.getAllNetworksFiltered(this, null)) {
                    try {
                        try {
                            networkInfo = this.mConnectivityManager.getNetworkInfo(network2);
                        } catch (Exception unused) {
                            networkInfo = this.mConnectivityManager.getNetworkInfo(network2);
                        }
                    } catch (Exception unused2) {
                        networkInfo = null;
                    }
                    if (networkInfo != null && (networkInfo.getType() == activeNetworkInfo.getType() || networkInfo.getType() == 17)) {
                        network = network2;
                    }
                }
                return network;
            }
            return (Network) invokeV.objValue;
        }

        @TargetApi(21)
        public NetworkCapabilities getNetworkCapabilities(Network network) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, network)) == null) ? this.mConnectivityManager.getNetworkCapabilities(network) : (NetworkCapabilities) invokeL.objValue;
        }

        public NetworkState getNetworkState(WifiManagerDelegate wifiManagerDelegate) {
            InterceptResult invokeL;
            NetworkInfo activeNetworkInfo;
            Network network;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, wifiManagerDelegate)) == null) {
                NetworkInfo networkInfo = null;
                if (Build.VERSION.SDK_INT >= 23) {
                    network = getDefaultNetwork();
                    activeNetworkInfo = this.mConnectivityManager.getNetworkInfo(network);
                } else {
                    activeNetworkInfo = this.mConnectivityManager.getActiveNetworkInfo();
                    network = null;
                }
                if (activeNetworkInfo != null && (activeNetworkInfo.isConnected() || (Build.VERSION.SDK_INT >= 21 && activeNetworkInfo.getDetailedState() == NetworkInfo.DetailedState.BLOCKED && ApplicationStatus.getStateForApplication() == 1))) {
                    networkInfo = activeNetworkInfo;
                }
                if (networkInfo == null) {
                    return new NetworkState(false, -1, -1, null, false);
                }
                if (network != null) {
                    return new NetworkState(true, networkInfo.getType(), networkInfo.getSubtype(), String.valueOf(NetworkChangeNotifierAutoDetect.networkToNetId(network)), Build.VERSION.SDK_INT >= 28 && AndroidNetworkLibrary.isPrivateDnsActive(this.mConnectivityManager.getLinkProperties(network)));
                }
                return networkInfo.getType() == 1 ? (networkInfo.getExtraInfo() == null || "".equals(networkInfo.getExtraInfo())) ? new NetworkState(true, networkInfo.getType(), networkInfo.getSubtype(), wifiManagerDelegate.getWifiSsid(), false) : new NetworkState(true, networkInfo.getType(), networkInfo.getSubtype(), networkInfo.getExtraInfo(), false) : new NetworkState(true, networkInfo.getType(), networkInfo.getSubtype(), null, false);
            }
            return (NetworkState) invokeL.objValue;
        }

        @TargetApi(21)
        public void registerNetworkCallback(NetworkRequest networkRequest, ConnectivityManager.NetworkCallback networkCallback, Handler handler) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048580, this, networkRequest, networkCallback, handler) == null) {
                if (Build.VERSION.SDK_INT >= 26) {
                    this.mConnectivityManager.registerNetworkCallback(networkRequest, networkCallback, handler);
                } else {
                    this.mConnectivityManager.registerNetworkCallback(networkRequest, networkCallback);
                }
            }
        }

        /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE] complete} */
        /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[THROW] complete} */
        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        @TargetApi(21)
        public boolean vpnAccessible(Network network) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, network)) == null) {
                Socket socket = new Socket();
                try {
                    StrictModeContext allowAllVmPolicies = StrictModeContext.allowAllVmPolicies();
                    try {
                        network.bindSocket(socket);
                        allowAllVmPolicies.close();
                        try {
                            socket.close();
                            return true;
                        } catch (IOException unused) {
                            return true;
                        }
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            try {
                                allowAllVmPolicies.close();
                            } catch (Throwable th3) {
                                th.addSuppressed(th3);
                            }
                            throw th2;
                        }
                    }
                } catch (IOException unused2) {
                    try {
                        socket.close();
                    } catch (IOException unused3) {
                    }
                    return false;
                } catch (Throwable th4) {
                    try {
                        socket.close();
                    } catch (IOException unused4) {
                    }
                    throw th4;
                }
            }
            return invokeL.booleanValue;
        }
    }

    @TargetApi(21)
    /* loaded from: classes.dex */
    public class DefaultNetworkCallback extends ConnectivityManager.NetworkCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public /* synthetic */ DefaultNetworkCallback(AnonymousClass1 anonymousClass1) {
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, network) == null) && NetworkChangeNotifierAutoDetect.this.mRegistered) {
                NetworkChangeNotifierAutoDetect.this.connectionTypeChanged();
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLinkPropertiesChanged(Network network, LinkProperties linkProperties) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, network, linkProperties) == null) && NetworkChangeNotifierAutoDetect.this.mRegistered) {
                NetworkChangeNotifierAutoDetect.this.connectionTypeChanged();
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, network) == null) && NetworkChangeNotifierAutoDetect.this.mRegistered) {
                NetworkChangeNotifierAutoDetect.this.connectionTypeChanged();
            }
        }
    }

    @TargetApi(21)
    /* loaded from: classes.dex */
    public class MyNetworkCallback extends ConnectivityManager.NetworkCallback {
        public static final /* synthetic */ boolean $assertionsDisabled = false;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Network mVpnInPlace;

        /* renamed from: aegon.chrome.net.NetworkChangeNotifierAutoDetect$MyNetworkCallback$1  reason: invalid class name */
        /* loaded from: classes.dex */
        public class AnonymousClass1 implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MyNetworkCallback this$1;
            public final /* synthetic */ int val$connectionType;
            public final /* synthetic */ boolean val$makeVpnDefault;
            public final /* synthetic */ long val$netId;

            public AnonymousClass1(MyNetworkCallback myNetworkCallback, long j, int i2, boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {myNetworkCallback, Long.valueOf(j), Integer.valueOf(i2), Boolean.valueOf(z)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$1 = myNetworkCallback;
                this.val$netId = j;
                this.val$connectionType = i2;
                this.val$makeVpnDefault = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    ((NetworkChangeNotifier.AnonymousClass1) NetworkChangeNotifierAutoDetect.this.mObserver).this$0.notifyObserversOfNetworkConnect(this.val$netId, this.val$connectionType);
                    if (this.val$makeVpnDefault) {
                        ((NetworkChangeNotifier.AnonymousClass1) NetworkChangeNotifierAutoDetect.this.mObserver).onConnectionTypeChanged(this.val$connectionType);
                        ((NetworkChangeNotifier.AnonymousClass1) NetworkChangeNotifierAutoDetect.this.mObserver).this$0.notifyObserversToPurgeActiveNetworkList(new long[]{this.val$netId});
                    }
                }
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1467670928, "Laegon/chrome/net/NetworkChangeNotifierAutoDetect$MyNetworkCallback;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1467670928, "Laegon/chrome/net/NetworkChangeNotifierAutoDetect$MyNetworkCallback;");
                }
            }
        }

        public /* synthetic */ MyNetworkCallback(AnonymousClass1 anonymousClass1) {
        }

        public final boolean ignoreConnectedNetwork(Network network, NetworkCapabilities networkCapabilities) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, network, networkCapabilities)) == null) {
                Network network2 = this.mVpnInPlace;
                if ((network2 == null || network2.equals(network)) ? false : true) {
                    return true;
                }
                if (networkCapabilities == null) {
                    networkCapabilities = NetworkChangeNotifierAutoDetect.this.mConnectivityManagerDelegate.mConnectivityManager.getNetworkCapabilities(network);
                }
                return networkCapabilities == null || (networkCapabilities.hasTransport(4) && !NetworkChangeNotifierAutoDetect.this.mConnectivityManagerDelegate.vpnAccessible(network));
            }
            return invokeLL.booleanValue;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, network) == null) {
                NetworkCapabilities networkCapabilities = NetworkChangeNotifierAutoDetect.this.mConnectivityManagerDelegate.mConnectivityManager.getNetworkCapabilities(network);
                if (ignoreConnectedNetwork(network, networkCapabilities)) {
                    return;
                }
                boolean hasTransport = networkCapabilities.hasTransport(4);
                if (hasTransport) {
                    this.mVpnInPlace = network;
                }
                NetworkChangeNotifierAutoDetect.this.runOnThread(new AnonymousClass1(this, NetworkChangeNotifierAutoDetect.networkToNetId(network), NetworkChangeNotifierAutoDetect.this.mConnectivityManagerDelegate.getConnectionType(network), hasTransport));
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, network, networkCapabilities) == null) || ignoreConnectedNetwork(network, networkCapabilities)) {
                return;
            }
            NetworkChangeNotifierAutoDetect.this.runOnThread(new Runnable(this, NetworkChangeNotifierAutoDetect.networkToNetId(network), NetworkChangeNotifierAutoDetect.this.mConnectivityManagerDelegate.getConnectionType(network)) { // from class: aegon.chrome.net.NetworkChangeNotifierAutoDetect.MyNetworkCallback.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MyNetworkCallback this$1;
                public final /* synthetic */ int val$connectionType;
                public final /* synthetic */ long val$netId;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Long.valueOf(r7), Integer.valueOf(r9)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$1 = this;
                    this.val$netId = r7;
                    this.val$connectionType = r9;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        Observer observer = NetworkChangeNotifierAutoDetect.this.mObserver;
                        ((NetworkChangeNotifier.AnonymousClass1) observer).this$0.notifyObserversOfNetworkConnect(this.val$netId, this.val$connectionType);
                    }
                }
            });
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLosing(Network network, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048579, this, network, i2) == null) || ignoreConnectedNetwork(network, null)) {
                return;
            }
            NetworkChangeNotifierAutoDetect.this.runOnThread(new Runnable(this, NetworkChangeNotifierAutoDetect.networkToNetId(network)) { // from class: aegon.chrome.net.NetworkChangeNotifierAutoDetect.MyNetworkCallback.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MyNetworkCallback this$1;
                public final /* synthetic */ long val$netId;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Long.valueOf(r7)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$1 = this;
                    this.val$netId = r7;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        Observer observer = NetworkChangeNotifierAutoDetect.this.mObserver;
                        ((NetworkChangeNotifier.AnonymousClass1) observer).this$0.notifyObserversOfNetworkSoonToDisconnect(this.val$netId);
                    }
                }
            });
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            Network[] allNetworksFiltered;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, network) == null) {
                Network network2 = this.mVpnInPlace;
                if ((network2 == null || network2.equals(network)) ? false : true) {
                    return;
                }
                NetworkChangeNotifierAutoDetect.this.runOnThread(new Runnable(this, network) { // from class: aegon.chrome.net.NetworkChangeNotifierAutoDetect.MyNetworkCallback.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ MyNetworkCallback this$1;
                    public final /* synthetic */ Network val$network;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, network};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$1 = this;
                        this.val$network = network;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            Observer observer = NetworkChangeNotifierAutoDetect.this.mObserver;
                            ((NetworkChangeNotifier.AnonymousClass1) observer).this$0.notifyObserversOfNetworkDisconnect(NetworkChangeNotifierAutoDetect.networkToNetId(this.val$network));
                        }
                    }
                });
                if (this.mVpnInPlace != null) {
                    this.mVpnInPlace = null;
                    for (Network network3 : NetworkChangeNotifierAutoDetect.getAllNetworksFiltered(NetworkChangeNotifierAutoDetect.this.mConnectivityManagerDelegate, network)) {
                        NetworkCapabilities networkCapabilities = NetworkChangeNotifierAutoDetect.this.mConnectivityManagerDelegate.mConnectivityManager.getNetworkCapabilities(network3);
                        if (!ignoreConnectedNetwork(network3, networkCapabilities)) {
                            boolean hasTransport = networkCapabilities.hasTransport(4);
                            if (hasTransport) {
                                this.mVpnInPlace = network3;
                            }
                            NetworkChangeNotifierAutoDetect.this.runOnThread(new AnonymousClass1(this, NetworkChangeNotifierAutoDetect.networkToNetId(network3), NetworkChangeNotifierAutoDetect.this.mConnectivityManagerDelegate.getConnectionType(network3), hasTransport));
                        }
                    }
                    NetworkChangeNotifierAutoDetect.this.runOnThread(new Runnable(this, NetworkChangeNotifierAutoDetect.this.getCurrentNetworkState().getConnectionType()) { // from class: aegon.chrome.net.NetworkChangeNotifierAutoDetect.MyNetworkCallback.5
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ MyNetworkCallback this$1;
                        public final /* synthetic */ int val$newConnectionType;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, Integer.valueOf(r7)};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$1 = this;
                            this.val$newConnectionType = r7;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                ((NetworkChangeNotifier.AnonymousClass1) NetworkChangeNotifierAutoDetect.this.mObserver).onConnectionTypeChanged(this.val$newConnectionType);
                            }
                        }
                    });
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class NetworkConnectivityIntentFilter extends IntentFilter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public NetworkConnectivityIntentFilter() {
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
            addAction("android.net.conn.CONNECTIVITY_CHANGE");
        }
    }

    /* loaded from: classes.dex */
    public static class NetworkState {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final boolean mConnected;
        public final boolean mIsPrivateDnsActive;
        public final String mNetworkIdentifier;
        public final int mSubtype;
        public final int mType;

        public NetworkState(boolean z, int i2, int i3, String str, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), str, Boolean.valueOf(z2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mConnected = z;
            this.mType = i2;
            this.mSubtype = i3;
            this.mNetworkIdentifier = str == null ? "" : str;
            this.mIsPrivateDnsActive = z2;
        }

        public int getConnectionSubtype() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.mConnected) {
                    int i2 = this.mType;
                    if (i2 != 0) {
                        if (i2 == 1 || i2 == 6 || i2 == 7 || i2 != 9) {
                        }
                        return 0;
                    }
                    switch (this.mSubtype) {
                        case 1:
                            return 7;
                        case 2:
                            return 8;
                        case 3:
                            return 9;
                        case 4:
                            return 5;
                        case 5:
                            return 10;
                        case 6:
                            return 11;
                        case 7:
                            return 6;
                        case 8:
                            return 14;
                        case 9:
                            return 15;
                        case 10:
                            return 12;
                        case 11:
                            return 4;
                        case 12:
                            return 13;
                        case 13:
                            return 18;
                        case 14:
                            return 16;
                        case 15:
                            return 17;
                        default:
                            return 0;
                    }
                }
                return 1;
            }
            return invokeV.intValue;
        }

        public int getConnectionType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.mConnected) {
                    return NetworkChangeNotifierAutoDetect.access$000(this.mType, this.mSubtype);
                }
                return 6;
            }
            return invokeV.intValue;
        }
    }

    /* loaded from: classes.dex */
    public interface Observer {
    }

    /* loaded from: classes.dex */
    public static abstract class RegistrationPolicy {
        public static final /* synthetic */ boolean $assertionsDisabled = false;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public NetworkChangeNotifierAutoDetect mNotifier;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1459245036, "Laegon/chrome/net/NetworkChangeNotifierAutoDetect$RegistrationPolicy;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1459245036, "Laegon/chrome/net/NetworkChangeNotifierAutoDetect$RegistrationPolicy;");
                }
            }
        }

        public RegistrationPolicy() {
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

        public abstract void destroy();

        public abstract void init(NetworkChangeNotifierAutoDetect networkChangeNotifierAutoDetect);

        public final void register() {
            NetworkCapabilities networkCapabilities;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                NetworkChangeNotifierAutoDetect networkChangeNotifierAutoDetect = this.mNotifier;
                networkChangeNotifierAutoDetect.assertOnThread();
                if (networkChangeNotifierAutoDetect.mRegistered) {
                    return;
                }
                if (networkChangeNotifierAutoDetect.mShouldSignalObserver) {
                    networkChangeNotifierAutoDetect.connectionTypeChanged();
                }
                DefaultNetworkCallback defaultNetworkCallback = networkChangeNotifierAutoDetect.mDefaultNetworkCallback;
                if (defaultNetworkCallback != null) {
                    try {
                        networkChangeNotifierAutoDetect.mConnectivityManagerDelegate.mConnectivityManager.registerDefaultNetworkCallback(defaultNetworkCallback, networkChangeNotifierAutoDetect.mHandler);
                    } catch (RuntimeException unused) {
                        networkChangeNotifierAutoDetect.mDefaultNetworkCallback = null;
                    }
                }
                if (networkChangeNotifierAutoDetect.mDefaultNetworkCallback == null) {
                    networkChangeNotifierAutoDetect.mIgnoreNextBroadcast = ContextUtils.sApplicationContext.registerReceiver(networkChangeNotifierAutoDetect, networkChangeNotifierAutoDetect.mIntentFilter) != null;
                }
                networkChangeNotifierAutoDetect.mRegistered = true;
                MyNetworkCallback myNetworkCallback = networkChangeNotifierAutoDetect.mNetworkCallback;
                if (myNetworkCallback != null) {
                    Network[] allNetworksFiltered = NetworkChangeNotifierAutoDetect.getAllNetworksFiltered(NetworkChangeNotifierAutoDetect.this.mConnectivityManagerDelegate, null);
                    myNetworkCallback.mVpnInPlace = null;
                    if (allNetworksFiltered.length == 1 && (networkCapabilities = NetworkChangeNotifierAutoDetect.this.mConnectivityManagerDelegate.getNetworkCapabilities(allNetworksFiltered[0])) != null && networkCapabilities.hasTransport(4)) {
                        myNetworkCallback.mVpnInPlace = allNetworksFiltered[0];
                    }
                    try {
                        networkChangeNotifierAutoDetect.mConnectivityManagerDelegate.registerNetworkCallback(networkChangeNotifierAutoDetect.mNetworkRequest, networkChangeNotifierAutoDetect.mNetworkCallback, networkChangeNotifierAutoDetect.mHandler);
                    } catch (RuntimeException unused2) {
                        networkChangeNotifierAutoDetect.mRegisterNetworkCallbackFailed = true;
                        networkChangeNotifierAutoDetect.mNetworkCallback = null;
                    }
                    if (networkChangeNotifierAutoDetect.mRegisterNetworkCallbackFailed || !networkChangeNotifierAutoDetect.mShouldSignalObserver) {
                        return;
                    }
                    Network[] allNetworksFiltered2 = NetworkChangeNotifierAutoDetect.getAllNetworksFiltered(networkChangeNotifierAutoDetect.mConnectivityManagerDelegate, null);
                    long[] jArr = new long[allNetworksFiltered2.length];
                    for (int i2 = 0; i2 < allNetworksFiltered2.length; i2++) {
                        jArr[i2] = NetworkChangeNotifierAutoDetect.networkToNetId(allNetworksFiltered2[i2]);
                    }
                    ((NetworkChangeNotifier.AnonymousClass1) networkChangeNotifierAutoDetect.mObserver).purgeActiveNetworkList(jArr);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class WifiManagerDelegate {
        public static final /* synthetic */ boolean $assertionsDisabled = false;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Context mContext;
        public boolean mHasWifiPermission;
        public boolean mHasWifiPermissionComputed;
        public final Object mLock;
        public WifiManager mWifiManager;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1850410522, "Laegon/chrome/net/NetworkChangeNotifierAutoDetect$WifiManagerDelegate;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1850410522, "Laegon/chrome/net/NetworkChangeNotifierAutoDetect$WifiManagerDelegate;");
                }
            }
        }

        public WifiManagerDelegate(Context context) {
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
            this.mLock = new Object();
            this.mContext = context;
        }

        public String getWifiSsid() {
            InterceptResult invokeV;
            WifiInfo wifiInfo;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                synchronized (this.mLock) {
                    if (hasPermissionLocked()) {
                        try {
                            try {
                                wifiInfo = this.mWifiManager.getConnectionInfo();
                            } catch (NullPointerException unused) {
                                wifiInfo = null;
                            }
                        } catch (NullPointerException unused2) {
                            wifiInfo = this.mWifiManager.getConnectionInfo();
                        }
                        return wifiInfo != null ? wifiInfo.getSSID() : "";
                    }
                    return AndroidNetworkLibrary.getWifiSSID();
                }
            }
            return (String) invokeV.objValue;
        }

        @SuppressLint({"WifiManagerPotentialLeak"})
        public final boolean hasPermissionLocked() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.mHasWifiPermissionComputed) {
                    return this.mHasWifiPermission;
                }
                boolean z = this.mContext.getPackageManager().checkPermission("android.permission.ACCESS_WIFI_STATE", this.mContext.getPackageName()) == 0;
                this.mHasWifiPermission = z;
                this.mWifiManager = z ? (WifiManager) this.mContext.getSystemService("wifi") : null;
                this.mHasWifiPermissionComputed = true;
                return this.mHasWifiPermission;
            }
            return invokeV.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-317859661, "Laegon/chrome/net/NetworkChangeNotifierAutoDetect;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-317859661, "Laegon/chrome/net/NetworkChangeNotifierAutoDetect;");
            }
        }
    }

    @TargetApi(21)
    public NetworkChangeNotifierAutoDetect(Observer observer, RegistrationPolicy registrationPolicy) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {observer, registrationPolicy};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mLooper = Looper.myLooper();
        this.mHandler = new Handler(this.mLooper);
        this.mObserver = observer;
        this.mConnectivityManagerDelegate = new ConnectivityManagerDelegate(ContextUtils.sApplicationContext);
        if (Build.VERSION.SDK_INT < 23) {
            this.mWifiManagerDelegate = new WifiManagerDelegate(ContextUtils.sApplicationContext);
        }
        if (Build.VERSION.SDK_INT >= 21) {
            this.mNetworkCallback = new MyNetworkCallback(null);
            this.mNetworkRequest = new NetworkRequest.Builder().addCapability(12).removeCapability(15).build();
        } else {
            this.mNetworkCallback = null;
            this.mNetworkRequest = null;
        }
        this.mDefaultNetworkCallback = Build.VERSION.SDK_INT >= 28 ? new DefaultNetworkCallback(null) : null;
        this.mNetworkState = getCurrentNetworkState();
        this.mIntentFilter = new NetworkConnectivityIntentFilter();
        this.mIgnoreNextBroadcast = false;
        this.mShouldSignalObserver = false;
        this.mRegistrationPolicy = registrationPolicy;
        registrationPolicy.init(this);
        this.mShouldSignalObserver = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x001e A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static /* synthetic */ int access$000(int i2, int i3) {
        if (i2 == 0) {
            switch (i3) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                    return 3;
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                    return 4;
                case 13:
                    return 5;
            }
        } else if (i2 != 1) {
            if (i2 != 6) {
                if (i2 != 7) {
                    return i2 != 9 ? 0 : 1;
                }
                return 7;
            }
            return 5;
        } else {
            return 2;
        }
    }

    @TargetApi(21)
    public static Network[] getAllNetworksFiltered(ConnectivityManagerDelegate connectivityManagerDelegate, Network network) {
        InterceptResult invokeLL;
        NetworkCapabilities networkCapabilities;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, connectivityManagerDelegate, network)) == null) {
            Network[] allNetworks = connectivityManagerDelegate.mConnectivityManager.getAllNetworks();
            if (allNetworks == null) {
                allNetworks = new Network[0];
            }
            int i2 = 0;
            for (Network network2 : allNetworks) {
                if (!network2.equals(network) && (networkCapabilities = connectivityManagerDelegate.mConnectivityManager.getNetworkCapabilities(network2)) != null && networkCapabilities.hasCapability(12)) {
                    if (!networkCapabilities.hasTransport(4)) {
                        allNetworks[i2] = network2;
                        i2++;
                    } else if (connectivityManagerDelegate.vpnAccessible(network2)) {
                        return new Network[]{network2};
                    }
                }
            }
            return (Network[]) Arrays.copyOf(allNetworks, i2);
        }
        return (Network[]) invokeLL.objValue;
    }

    @TargetApi(21)
    public static long networkToNetId(Network network) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65547, null, network)) == null) ? Build.VERSION.SDK_INT >= 23 ? network.getNetworkHandle() : Integer.parseInt(network.toString()) : invokeL.longValue;
    }

    public final void assertOnThread() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && BuildConfig.DCHECK_IS_ON) {
            if (!(this.mLooper == Looper.myLooper())) {
                throw new IllegalStateException("Must be called on NetworkChangeNotifierAutoDetect thread.");
            }
        }
    }

    public final void connectionTypeChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            NetworkState currentNetworkState = getCurrentNetworkState();
            if (currentNetworkState.getConnectionType() != this.mNetworkState.getConnectionType() || !currentNetworkState.mNetworkIdentifier.equals(this.mNetworkState.mNetworkIdentifier) || currentNetworkState.mIsPrivateDnsActive != this.mNetworkState.mIsPrivateDnsActive) {
                ((NetworkChangeNotifier.AnonymousClass1) this.mObserver).onConnectionTypeChanged(currentNetworkState.getConnectionType());
            }
            if (currentNetworkState.getConnectionType() != this.mNetworkState.getConnectionType() || currentNetworkState.getConnectionSubtype() != this.mNetworkState.getConnectionSubtype()) {
                Observer observer = this.mObserver;
                ((NetworkChangeNotifier.AnonymousClass1) observer).this$0.notifyObserversOfConnectionSubtypeChange(currentNetworkState.getConnectionSubtype());
            }
            this.mNetworkState = currentNetworkState;
        }
    }

    public NetworkState getCurrentNetworkState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mConnectivityManagerDelegate.getNetworkState(this.mWifiManagerDelegate) : (NetworkState) invokeV.objValue;
    }

    public long getDefaultNetId() {
        InterceptResult invokeV;
        Network defaultNetwork;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (Build.VERSION.SDK_INT >= 21 && (defaultNetwork = this.mConnectivityManagerDelegate.getDefaultNetwork()) != null) {
                return networkToNetId(defaultNetwork);
            }
            return -1L;
        }
        return invokeV.longValue;
    }

    public long[] getNetworksAndTypes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (Build.VERSION.SDK_INT < 21) {
                return new long[0];
            }
            Network[] allNetworksFiltered = getAllNetworksFiltered(this.mConnectivityManagerDelegate, null);
            long[] jArr = new long[allNetworksFiltered.length * 2];
            int i2 = 0;
            for (Network network : allNetworksFiltered) {
                int i3 = i2 + 1;
                jArr[i2] = networkToNetId(network);
                i2 = i3 + 1;
                jArr[i3] = this.mConnectivityManagerDelegate.getConnectionType(network);
            }
            return jArr;
        }
        return (long[]) invokeV.objValue;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, context, intent) == null) {
            runOnThread(new Runnable(this) { // from class: aegon.chrome.net.NetworkChangeNotifierAutoDetect.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ NetworkChangeNotifierAutoDetect this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && this.this$0.mRegistered) {
                        if (this.this$0.mIgnoreNextBroadcast) {
                            this.this$0.mIgnoreNextBroadcast = false;
                        } else {
                            this.this$0.connectionTypeChanged();
                        }
                    }
                }
            });
        }
    }

    public final void runOnThread(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, runnable) == null) {
            if (this.mLooper == Looper.myLooper()) {
                runnable.run();
            } else {
                this.mHandler.post(runnable);
            }
        }
    }

    public void unregister() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            assertOnThread();
            if (this.mRegistered) {
                this.mRegistered = false;
                MyNetworkCallback myNetworkCallback = this.mNetworkCallback;
                if (myNetworkCallback != null) {
                    this.mConnectivityManagerDelegate.mConnectivityManager.unregisterNetworkCallback(myNetworkCallback);
                }
                DefaultNetworkCallback defaultNetworkCallback = this.mDefaultNetworkCallback;
                if (defaultNetworkCallback != null) {
                    this.mConnectivityManagerDelegate.mConnectivityManager.unregisterNetworkCallback(defaultNetworkCallback);
                } else {
                    ContextUtils.sApplicationContext.unregisterReceiver(this);
                }
            }
        }
    }
}

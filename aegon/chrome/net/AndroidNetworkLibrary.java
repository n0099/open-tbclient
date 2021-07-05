package aegon.chrome.net;

import aegon.chrome.base.ApiCompatibilityUtils;
import aegon.chrome.base.ContextUtils;
import aegon.chrome.base.annotations.CalledByNative;
import aegon.chrome.base.annotations.CalledByNativeUnchecked;
import aegon.chrome.base.compat.ApiHelperForM;
import aegon.chrome.base.metrics.RecordHistogram;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.TrafficStats;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.security.NetworkSecurityPolicy;
import android.telephony.TelephonyManager;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.mcast.McastConfig;
import com.baidu.media.duplayer.LibsInfoDef;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.manager.DefaultConnectivityMonitorFactory;
import java.io.FileDescriptor;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.SocketImpl;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
/* loaded from: classes.dex */
public class AndroidNetworkLibrary {
    public static /* synthetic */ Interceptable $ic;
    public static final Set<String> sAutoDohDotServers;
    public static final Set<InetAddress> sAutoDohServers;
    public static Boolean sHaveAccessNetworkState;
    public static Boolean sHaveAccessWifiState;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class NetworkSecurityPolicyProxy {
        public static /* synthetic */ Interceptable $ic;
        public static NetworkSecurityPolicyProxy sInstance;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1396360009, "Laegon/chrome/net/AndroidNetworkLibrary$NetworkSecurityPolicyProxy;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1396360009, "Laegon/chrome/net/AndroidNetworkLibrary$NetworkSecurityPolicyProxy;");
                    return;
                }
            }
            sInstance = new NetworkSecurityPolicyProxy();
        }

        public NetworkSecurityPolicyProxy() {
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

        @TargetApi(23)
        public boolean isCleartextTrafficPermitted() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (Build.VERSION.SDK_INT < 23) {
                    return true;
                }
                return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted();
            }
            return invokeV.booleanValue;
        }

        @TargetApi(24)
        public boolean isCleartextTrafficPermitted(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? Build.VERSION.SDK_INT < 24 ? isCleartextTrafficPermitted() : NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(str) : invokeL.booleanValue;
        }
    }

    /* loaded from: classes.dex */
    public static class SetFileDescriptor {
        public static /* synthetic */ Interceptable $ic;
        public static final Method sFileDescriptorSetInt;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1215229156, "Laegon/chrome/net/AndroidNetworkLibrary$SetFileDescriptor;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1215229156, "Laegon/chrome/net/AndroidNetworkLibrary$SetFileDescriptor;");
                    return;
                }
            }
            try {
                sFileDescriptorSetInt = FileDescriptor.class.getMethod("setInt$", Integer.TYPE);
            } catch (NoSuchMethodException | SecurityException e2) {
                throw new RuntimeException("Unable to get FileDescriptor.setInt$", e2);
            }
        }

        public static FileDescriptor createWithFd(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i2)) == null) {
                try {
                    FileDescriptor fileDescriptor = new FileDescriptor();
                    sFileDescriptorSetInt.invoke(fileDescriptor, Integer.valueOf(i2));
                    return fileDescriptor;
                } catch (IllegalAccessException e2) {
                    throw new RuntimeException("FileDescriptor.setInt$() failed", e2);
                } catch (InvocationTargetException e3) {
                    throw new RuntimeException("FileDescriptor.setInt$() failed", e3);
                }
            }
            return (FileDescriptor) invokeI.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static class SocketFd extends Socket {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes.dex */
        public static class SocketImplFd extends SocketImpl {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public SocketImplFd(FileDescriptor fileDescriptor) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fileDescriptor};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                ((SocketImpl) this).fd = fileDescriptor;
            }

            @Override // java.net.SocketImpl
            public void accept(SocketImpl socketImpl) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, socketImpl) == null) {
                    throw new RuntimeException("accept not implemented");
                }
            }

            @Override // java.net.SocketImpl
            public int available() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                    throw new RuntimeException("accept not implemented");
                }
                return invokeV.intValue;
            }

            @Override // java.net.SocketImpl
            public void bind(InetAddress inetAddress, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, inetAddress, i2) == null) {
                    throw new RuntimeException("accept not implemented");
                }
            }

            @Override // java.net.SocketImpl
            public void close() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                }
            }

            @Override // java.net.SocketImpl
            public void connect(String str, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048580, this, str, i2) == null) {
                    throw new RuntimeException("connect not implemented");
                }
            }

            @Override // java.net.SocketImpl
            public void connect(InetAddress inetAddress, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048581, this, inetAddress, i2) == null) {
                    throw new RuntimeException("connect not implemented");
                }
            }

            @Override // java.net.SocketImpl
            public void connect(SocketAddress socketAddress, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048582, this, socketAddress, i2) == null) {
                    throw new RuntimeException("connect not implemented");
                }
            }

            @Override // java.net.SocketImpl
            public void create(boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
                }
            }

            @Override // java.net.SocketImpl
            public InputStream getInputStream() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                    throw new RuntimeException("getInputStream not implemented");
                }
                return (InputStream) invokeV.objValue;
            }

            @Override // java.net.SocketOptions
            public Object getOption(int i2) {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) {
                    throw new RuntimeException("getOption not implemented");
                }
                return invokeI.objValue;
            }

            @Override // java.net.SocketImpl
            public OutputStream getOutputStream() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                    throw new RuntimeException("getOutputStream not implemented");
                }
                return (OutputStream) invokeV.objValue;
            }

            @Override // java.net.SocketImpl
            public void listen(int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
                    throw new RuntimeException("listen not implemented");
                }
            }

            @Override // java.net.SocketImpl
            public void sendUrgentData(int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
                    throw new RuntimeException("sendUrgentData not implemented");
                }
            }

            @Override // java.net.SocketOptions
            public void setOption(int i2, Object obj) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(1048589, this, i2, obj) == null) {
                    throw new RuntimeException("setOption not implemented");
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SocketFd(FileDescriptor fileDescriptor) {
            super(new SocketImplFd(fileDescriptor));
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fileDescriptor};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((SocketImpl) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1549217677, "Laegon/chrome/net/AndroidNetworkLibrary;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1549217677, "Laegon/chrome/net/AndroidNetworkLibrary;");
                return;
            }
        }
        sAutoDohServers = new HashSet();
        sAutoDohDotServers = new HashSet();
        try {
            sAutoDohServers.add(InetAddress.getByName("8.8.8.8"));
            sAutoDohServers.add(InetAddress.getByName("8.8.4.4"));
            sAutoDohServers.add(InetAddress.getByName("2001:4860:4860::8888"));
            sAutoDohServers.add(InetAddress.getByName("2001:4860:4860::8844"));
            sAutoDohServers.add(InetAddress.getByName("1.1.1.1"));
            sAutoDohServers.add(InetAddress.getByName(LibsInfoDef.CYBER_PLAY_SCORE_STORAGE_VERSION));
            sAutoDohServers.add(InetAddress.getByName("2606:4700:4700::1111"));
            sAutoDohServers.add(InetAddress.getByName("2606:4700:4700::1001"));
            sAutoDohServers.add(InetAddress.getByName("9.9.9.9"));
            sAutoDohServers.add(InetAddress.getByName("149.112.112.112"));
            sAutoDohServers.add(InetAddress.getByName("2620:fe::fe"));
            sAutoDohServers.add(InetAddress.getByName("2620:fe::9"));
            sAutoDohDotServers.add("dns.google");
            sAutoDohDotServers.add("1dot1dot1dot1.cloudflare-dns.com");
            sAutoDohDotServers.add("cloudflare-dns.com");
            sAutoDohDotServers.add("dns.quad9.net");
        } catch (UnknownHostException e2) {
            throw new RuntimeException("Failed to parse IP addresses", e2);
        }
    }

    public AndroidNetworkLibrary() {
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

    @CalledByNativeUnchecked
    public static void addTestRootCertificate(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, bArr) == null) {
            X509Util.addTestRootCertificate(bArr);
        }
    }

    @CalledByNativeUnchecked
    public static void clearTestRootCertificates() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            X509Util.clearTestRootCertificates();
        }
    }

    @CalledByNative
    @TargetApi(23)
    public static byte[][] getDnsServers() {
        InterceptResult invokeV;
        boolean z;
        Object newInstance;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65540, null)) == null) {
            if (sHaveAccessNetworkState == null) {
                sHaveAccessNetworkState = Boolean.valueOf(ApiCompatibilityUtils.checkPermission(ContextUtils.sApplicationContext, DefaultConnectivityMonitorFactory.NETWORK_PERMISSION, Process.myPid(), Process.myUid()) == 0);
            }
            if (sHaveAccessNetworkState.booleanValue()) {
                ConnectivityManager connectivityManager = (ConnectivityManager) ContextUtils.sApplicationContext.getSystemService("connectivity");
                if (connectivityManager == null) {
                    newInstance = Array.newInstance(byte.class, 0, 0);
                } else {
                    Network activeNetwork = ApiHelperForM.getActiveNetwork(connectivityManager);
                    if (activeNetwork == null) {
                        newInstance = Array.newInstance(byte.class, 0, 0);
                    } else {
                        LinkProperties linkProperties = connectivityManager.getLinkProperties(activeNetwork);
                        if (linkProperties == null) {
                            newInstance = Array.newInstance(byte.class, 0, 0);
                        } else {
                            List<InetAddress> dnsServers = linkProperties.getDnsServers();
                            Iterator<InetAddress> it = dnsServers.iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    if (sAutoDohServers.contains(it.next())) {
                                        z = true;
                                        break;
                                    }
                                } else {
                                    z = false;
                                    break;
                                }
                            }
                            if (!isPrivateDnsActive(linkProperties)) {
                                RecordHistogram.recordBooleanHistogram("Net.DNS.Android.AutoDohPublic", z);
                                byte[][] bArr = new byte[dnsServers.size()];
                                for (int i2 = 0; i2 < dnsServers.size(); i2++) {
                                    bArr[i2] = dnsServers.get(i2).getAddress();
                                }
                                return bArr;
                            }
                            String privateDnsServerName = Build.VERSION.SDK_INT >= 28 ? ApiHelperForM.getPrivateDnsServerName(linkProperties) : null;
                            if (privateDnsServerName != null) {
                                z = sAutoDohDotServers.contains(privateDnsServerName.toLowerCase(Locale.US));
                            }
                            RecordHistogram.recordBooleanHistogram("Net.DNS.Android.DotExplicit", privateDnsServerName != null);
                            RecordHistogram.recordBooleanHistogram("Net.DNS.Android.AutoDohPrivate", z);
                            newInstance = Array.newInstance(byte.class, 1, 1);
                        }
                    }
                }
            } else {
                newInstance = Array.newInstance(byte.class, 0, 0);
            }
            return (byte[][]) newInstance;
        }
        return (byte[][]) invokeV.objValue;
    }

    @CalledByNative
    @TargetApi(23)
    public static boolean getIsCaptivePortal() {
        InterceptResult invokeV;
        ConnectivityManager connectivityManager;
        Network activeNetwork;
        NetworkCapabilities networkCapabilities;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? (Build.VERSION.SDK_INT < 23 || (connectivityManager = (ConnectivityManager) ContextUtils.sApplicationContext.getSystemService("connectivity")) == null || (activeNetwork = ApiHelperForM.getActiveNetwork(connectivityManager)) == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) == null || !networkCapabilities.hasCapability(17)) ? false : true : invokeV.booleanValue;
    }

    @CalledByNative
    public static boolean getIsRoaming() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) ContextUtils.sApplicationContext.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return false;
            }
            return activeNetworkInfo.isRoaming();
        }
        return invokeV.booleanValue;
    }

    @CalledByNative
    public static String getMimeTypeFromExtension(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            return URLConnection.guessContentTypeFromName("foo." + str);
        }
        return (String) invokeL.objValue;
    }

    @CalledByNative
    public static String getNetworkCountryIso() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            AndroidTelephonyManagerBridge androidTelephonyManagerBridge = AndroidTelephonyManagerBridge.getInstance();
            if (androidTelephonyManagerBridge.mNetworkCountryIso == null) {
                TelephonyManager telephonyManager = AndroidTelephonyManagerBridge.getTelephonyManager();
                if (telephonyManager == null) {
                    return "";
                }
                androidTelephonyManagerBridge.mNetworkCountryIso = telephonyManager.getNetworkCountryIso();
            }
            return androidTelephonyManagerBridge.mNetworkCountryIso;
        }
        return (String) invokeV.objValue;
    }

    @CalledByNative
    public static String getNetworkOperator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            AndroidTelephonyManagerBridge androidTelephonyManagerBridge = AndroidTelephonyManagerBridge.getInstance();
            if (androidTelephonyManagerBridge.mNetworkOperator == null) {
                TelephonyManager telephonyManager = AndroidTelephonyManagerBridge.getTelephonyManager();
                if (telephonyManager == null) {
                    return "";
                }
                androidTelephonyManagerBridge.mNetworkOperator = telephonyManager.getNetworkOperator();
            }
            return androidTelephonyManagerBridge.mNetworkOperator;
        }
        return (String) invokeV.objValue;
    }

    @CalledByNative
    public static String getSimOperator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            AndroidTelephonyManagerBridge androidTelephonyManagerBridge = AndroidTelephonyManagerBridge.getInstance();
            if (androidTelephonyManagerBridge.mSimOperator == null) {
                TelephonyManager telephonyManager = AndroidTelephonyManagerBridge.getTelephonyManager();
                if (telephonyManager == null) {
                    return "";
                }
                androidTelephonyManagerBridge.mSimOperator = telephonyManager.getSimOperator();
            }
            return androidTelephonyManagerBridge.mSimOperator;
        }
        return (String) invokeV.objValue;
    }

    @CalledByNative
    public static String getWifiSSID() {
        InterceptResult invokeV;
        String ssid;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            if (sHaveAccessWifiState == null) {
                sHaveAccessWifiState = Boolean.valueOf(ApiCompatibilityUtils.checkPermission(ContextUtils.sApplicationContext, "android.permission.ACCESS_WIFI_STATE", Process.myPid(), Process.myUid()) == 0);
            }
            WifiInfo wifiInfo = null;
            if (sHaveAccessWifiState.booleanValue()) {
                wifiInfo = ((WifiManager) ContextUtils.sApplicationContext.getSystemService("wifi")).getConnectionInfo();
            } else {
                Intent registerReceiver = ContextUtils.sApplicationContext.registerReceiver(null, new IntentFilter(McastConfig.ACTION_NETWORK_STATE_CHANGED));
                if (registerReceiver != null) {
                    wifiInfo = (WifiInfo) registerReceiver.getParcelableExtra("wifiInfo");
                }
            }
            return (wifiInfo == null || (ssid = wifiInfo.getSSID()) == null || ssid.equals("<unknown ssid>")) ? "" : ssid;
        }
        return (String) invokeV.objValue;
    }

    @CalledByNative
    public static int getWifiSignalLevel(int i2) {
        InterceptResult invokeI;
        Intent registerReceiver;
        int intExtra;
        int calculateSignalLevel;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65548, null, i2)) == null) {
            try {
                registerReceiver = ContextUtils.sApplicationContext.registerReceiver(null, new IntentFilter("android.net.wifi.RSSI_CHANGED"));
            } catch (IllegalArgumentException | Exception unused) {
            }
            if (registerReceiver != null && (intExtra = registerReceiver.getIntExtra("newRssi", Integer.MIN_VALUE)) != Integer.MIN_VALUE && (calculateSignalLevel = WifiManager.calculateSignalLevel(intExtra, i2)) >= 0 && calculateSignalLevel < i2) {
                return calculateSignalLevel;
            }
            return -1;
        }
        return invokeI.intValue;
    }

    @CalledByNative
    public static boolean haveOnlyLoopbackAddresses() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            try {
                Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
                if (networkInterfaces == null) {
                    return false;
                }
                while (networkInterfaces.hasMoreElements()) {
                    NetworkInterface nextElement = networkInterfaces.nextElement();
                    try {
                        if (nextElement.isUp() && !nextElement.isLoopback()) {
                            return false;
                        }
                    } catch (SocketException unused) {
                    }
                }
                return true;
            } catch (Exception e2) {
                Log.w("AndroidNetworkLibrary", "could not get network interfaces: " + e2);
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    @CalledByNative
    public static boolean isCleartextPermitted(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, str)) == null) {
            try {
                return NetworkSecurityPolicyProxy.sInstance.isCleartextTrafficPermitted(str);
            } catch (IllegalArgumentException unused) {
                return NetworkSecurityPolicyProxy.sInstance.isCleartextTrafficPermitted();
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean isPrivateDnsActive(LinkProperties linkProperties) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, linkProperties)) == null) {
            if (Build.VERSION.SDK_INT < 28 || linkProperties == null) {
                return false;
            }
            return ApiHelperForM.isPrivateDnsActive(linkProperties);
        }
        return invokeL.booleanValue;
    }

    @CalledByNative
    public static void tagSocket(int i2, int i3, int i4) {
        ParcelFileDescriptor adoptFd;
        FileDescriptor fileDescriptor;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(65552, null, i2, i3, i4) == null) {
            int threadStatsTag = TrafficStats.getThreadStatsTag();
            if (i4 != threadStatsTag) {
                TrafficStats.setThreadStatsTag(i4);
            }
            if (i3 != -1) {
                ThreadStatsUid.set(i3);
            }
            if (Build.VERSION.SDK_INT < 23) {
                adoptFd = null;
                fileDescriptor = SetFileDescriptor.createWithFd(i2);
            } else {
                adoptFd = ParcelFileDescriptor.adoptFd(i2);
                fileDescriptor = adoptFd.getFileDescriptor();
            }
            SocketFd socketFd = new SocketFd(fileDescriptor);
            TrafficStats.tagSocket(socketFd);
            socketFd.close();
            if (adoptFd != null) {
                adoptFd.detachFd();
            }
            if (i4 != threadStatsTag) {
                TrafficStats.setThreadStatsTag(threadStatsTag);
            }
            if (i3 != -1) {
                ThreadStatsUid.clear();
            }
        }
    }

    @CalledByNative
    public static AndroidCertVerifyResult verifyServerCertificates(byte[][] bArr, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65553, null, bArr, str, str2)) == null) {
            try {
                return X509Util.verifyServerCertificates(bArr, str, str2);
            } catch (IllegalArgumentException unused) {
                return new AndroidCertVerifyResult(-1);
            } catch (KeyStoreException unused2) {
                return new AndroidCertVerifyResult(-1);
            } catch (NoSuchAlgorithmException unused3) {
                return new AndroidCertVerifyResult(-1);
            } catch (Throwable unused4) {
                return new AndroidCertVerifyResult(-1);
            }
        }
        return (AndroidCertVerifyResult) invokeLLL.objValue;
    }
}

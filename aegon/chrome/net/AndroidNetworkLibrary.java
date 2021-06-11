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
import com.baidu.android.imsdk.mcast.McastConfig;
import com.baidu.media.duplayer.LibsInfoDef;
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
    public static Boolean sHaveAccessNetworkState;
    public static Boolean sHaveAccessWifiState;
    public static final Set<InetAddress> sAutoDohServers = new HashSet();
    public static final Set<String> sAutoDohDotServers = new HashSet();

    /* loaded from: classes.dex */
    public static class NetworkSecurityPolicyProxy {
        public static NetworkSecurityPolicyProxy sInstance = new NetworkSecurityPolicyProxy();

        @TargetApi(23)
        public boolean isCleartextTrafficPermitted() {
            if (Build.VERSION.SDK_INT < 23) {
                return true;
            }
            return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted();
        }

        @TargetApi(24)
        public boolean isCleartextTrafficPermitted(String str) {
            return Build.VERSION.SDK_INT < 24 ? isCleartextTrafficPermitted() : NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(str);
        }
    }

    /* loaded from: classes.dex */
    public static class SetFileDescriptor {
        public static final Method sFileDescriptorSetInt;

        static {
            try {
                sFileDescriptorSetInt = FileDescriptor.class.getMethod("setInt$", Integer.TYPE);
            } catch (NoSuchMethodException | SecurityException e2) {
                throw new RuntimeException("Unable to get FileDescriptor.setInt$", e2);
            }
        }

        public static FileDescriptor createWithFd(int i2) {
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
    }

    /* loaded from: classes.dex */
    public static class SocketFd extends Socket {

        /* loaded from: classes.dex */
        public static class SocketImplFd extends SocketImpl {
            public SocketImplFd(FileDescriptor fileDescriptor) {
                ((SocketImpl) this).fd = fileDescriptor;
            }

            @Override // java.net.SocketImpl
            public void accept(SocketImpl socketImpl) {
                throw new RuntimeException("accept not implemented");
            }

            @Override // java.net.SocketImpl
            public int available() {
                throw new RuntimeException("accept not implemented");
            }

            @Override // java.net.SocketImpl
            public void bind(InetAddress inetAddress, int i2) {
                throw new RuntimeException("accept not implemented");
            }

            @Override // java.net.SocketImpl
            public void close() {
            }

            @Override // java.net.SocketImpl
            public void connect(String str, int i2) {
                throw new RuntimeException("connect not implemented");
            }

            @Override // java.net.SocketImpl
            public void connect(InetAddress inetAddress, int i2) {
                throw new RuntimeException("connect not implemented");
            }

            @Override // java.net.SocketImpl
            public void connect(SocketAddress socketAddress, int i2) {
                throw new RuntimeException("connect not implemented");
            }

            @Override // java.net.SocketImpl
            public void create(boolean z) {
            }

            @Override // java.net.SocketImpl
            public InputStream getInputStream() {
                throw new RuntimeException("getInputStream not implemented");
            }

            @Override // java.net.SocketOptions
            public Object getOption(int i2) {
                throw new RuntimeException("getOption not implemented");
            }

            @Override // java.net.SocketImpl
            public OutputStream getOutputStream() {
                throw new RuntimeException("getOutputStream not implemented");
            }

            @Override // java.net.SocketImpl
            public void listen(int i2) {
                throw new RuntimeException("listen not implemented");
            }

            @Override // java.net.SocketImpl
            public void sendUrgentData(int i2) {
                throw new RuntimeException("sendUrgentData not implemented");
            }

            @Override // java.net.SocketOptions
            public void setOption(int i2, Object obj) {
                throw new RuntimeException("setOption not implemented");
            }
        }

        public SocketFd(FileDescriptor fileDescriptor) {
            super(new SocketImplFd(fileDescriptor));
        }
    }

    static {
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

    @CalledByNativeUnchecked
    public static void addTestRootCertificate(byte[] bArr) {
        X509Util.addTestRootCertificate(bArr);
    }

    @CalledByNativeUnchecked
    public static void clearTestRootCertificates() {
        X509Util.clearTestRootCertificates();
    }

    @CalledByNative
    @TargetApi(23)
    public static byte[][] getDnsServers() {
        boolean z;
        Object newInstance;
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
                            if (!it.hasNext()) {
                                z = false;
                                break;
                            }
                            if (sAutoDohServers.contains(it.next())) {
                                z = true;
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

    @CalledByNative
    @TargetApi(23)
    public static boolean getIsCaptivePortal() {
        ConnectivityManager connectivityManager;
        Network activeNetwork;
        NetworkCapabilities networkCapabilities;
        return (Build.VERSION.SDK_INT < 23 || (connectivityManager = (ConnectivityManager) ContextUtils.sApplicationContext.getSystemService("connectivity")) == null || (activeNetwork = ApiHelperForM.getActiveNetwork(connectivityManager)) == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) == null || !networkCapabilities.hasCapability(17)) ? false : true;
    }

    @CalledByNative
    public static boolean getIsRoaming() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) ContextUtils.sApplicationContext.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return false;
        }
        return activeNetworkInfo.isRoaming();
    }

    @CalledByNative
    public static String getMimeTypeFromExtension(String str) {
        return URLConnection.guessContentTypeFromName("foo." + str);
    }

    @CalledByNative
    public static String getNetworkCountryIso() {
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

    @CalledByNative
    public static String getNetworkOperator() {
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

    @CalledByNative
    public static String getSimOperator() {
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

    @CalledByNative
    public static String getWifiSSID() {
        String ssid;
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

    @CalledByNative
    public static int getWifiSignalLevel(int i2) {
        Intent registerReceiver;
        int intExtra;
        int calculateSignalLevel;
        try {
            registerReceiver = ContextUtils.sApplicationContext.registerReceiver(null, new IntentFilter("android.net.wifi.RSSI_CHANGED"));
        } catch (IllegalArgumentException | Exception unused) {
        }
        if (registerReceiver != null && (intExtra = registerReceiver.getIntExtra("newRssi", Integer.MIN_VALUE)) != Integer.MIN_VALUE && (calculateSignalLevel = WifiManager.calculateSignalLevel(intExtra, i2)) >= 0 && calculateSignalLevel < i2) {
            return calculateSignalLevel;
        }
        return -1;
    }

    @CalledByNative
    public static boolean haveOnlyLoopbackAddresses() {
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

    @CalledByNative
    public static boolean isCleartextPermitted(String str) {
        try {
            return NetworkSecurityPolicyProxy.sInstance.isCleartextTrafficPermitted(str);
        } catch (IllegalArgumentException unused) {
            return NetworkSecurityPolicyProxy.sInstance.isCleartextTrafficPermitted();
        }
    }

    public static boolean isPrivateDnsActive(LinkProperties linkProperties) {
        if (Build.VERSION.SDK_INT < 28 || linkProperties == null) {
            return false;
        }
        return ApiHelperForM.isPrivateDnsActive(linkProperties);
    }

    @CalledByNative
    public static void tagSocket(int i2, int i3, int i4) {
        ParcelFileDescriptor adoptFd;
        FileDescriptor fileDescriptor;
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

    @CalledByNative
    public static AndroidCertVerifyResult verifyServerCertificates(byte[][] bArr, String str, String str2) {
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
}

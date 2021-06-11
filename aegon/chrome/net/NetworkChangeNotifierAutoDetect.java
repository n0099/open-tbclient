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
import java.io.IOException;
import java.net.Socket;
import java.util.Arrays;
@SuppressLint({"NewApi"})
/* loaded from: classes.dex */
public class NetworkChangeNotifierAutoDetect extends BroadcastReceiver {
    public DefaultNetworkCallback mDefaultNetworkCallback;
    public boolean mIgnoreNextBroadcast;
    public final NetworkConnectivityIntentFilter mIntentFilter;
    public MyNetworkCallback mNetworkCallback;
    public NetworkRequest mNetworkRequest;
    public NetworkState mNetworkState;
    public final Observer mObserver;
    public boolean mRegisterNetworkCallbackFailed;
    public boolean mRegistered;
    public final RegistrationPolicy mRegistrationPolicy;
    public boolean mShouldSignalObserver;
    public WifiManagerDelegate mWifiManagerDelegate;
    public final Looper mLooper = Looper.myLooper();
    public final Handler mHandler = new Handler(this.mLooper);
    public ConnectivityManagerDelegate mConnectivityManagerDelegate = new ConnectivityManagerDelegate(ContextUtils.sApplicationContext);

    /* loaded from: classes.dex */
    public static class ConnectivityManagerDelegate {
        public static final /* synthetic */ boolean $assertionsDisabled = false;
        public final ConnectivityManager mConnectivityManager;

        public ConnectivityManagerDelegate(Context context) {
            this.mConnectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        }

        @TargetApi(21)
        public int getConnectionType(Network network) {
            NetworkInfo networkInfo;
            try {
                try {
                    networkInfo = this.mConnectivityManager.getNetworkInfo(network);
                } catch (Exception unused) {
                    networkInfo = null;
                }
            } catch (Exception unused2) {
                networkInfo = this.mConnectivityManager.getNetworkInfo(network);
            }
            if (networkInfo != null && networkInfo.getType() == 17) {
                networkInfo = this.mConnectivityManager.getActiveNetworkInfo();
            }
            if (networkInfo == null || !networkInfo.isConnected()) {
                return 6;
            }
            return NetworkChangeNotifierAutoDetect.access$000(networkInfo.getType(), networkInfo.getSubtype());
        }

        @TargetApi(21)
        public Network getDefaultNetwork() {
            Network network;
            Network[] allNetworksFiltered;
            NetworkInfo networkInfo;
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

        @TargetApi(21)
        public NetworkCapabilities getNetworkCapabilities(Network network) {
            return this.mConnectivityManager.getNetworkCapabilities(network);
        }

        public NetworkState getNetworkState(WifiManagerDelegate wifiManagerDelegate) {
            NetworkInfo activeNetworkInfo;
            Network network;
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

        @TargetApi(21)
        public void registerNetworkCallback(NetworkRequest networkRequest, ConnectivityManager.NetworkCallback networkCallback, Handler handler) {
            if (Build.VERSION.SDK_INT >= 26) {
                this.mConnectivityManager.registerNetworkCallback(networkRequest, networkCallback, handler);
            } else {
                this.mConnectivityManager.registerNetworkCallback(networkRequest, networkCallback);
            }
        }

        @TargetApi(21)
        public boolean vpnAccessible(Network network) {
            Socket socket = new Socket();
            try {
                StrictModeContext allowAllVmPolicies = StrictModeContext.allowAllVmPolicies();
                network.bindSocket(socket);
                allowAllVmPolicies.close();
                try {
                    socket.close();
                    return true;
                } catch (IOException unused) {
                    return true;
                }
            } catch (IOException unused2) {
                try {
                    socket.close();
                } catch (IOException unused3) {
                }
                return false;
            } catch (Throwable th) {
                try {
                    socket.close();
                } catch (IOException unused4) {
                }
                throw th;
            }
        }
    }

    @TargetApi(21)
    /* loaded from: classes.dex */
    public class DefaultNetworkCallback extends ConnectivityManager.NetworkCallback {
        public /* synthetic */ DefaultNetworkCallback(AnonymousClass1 anonymousClass1) {
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            if (NetworkChangeNotifierAutoDetect.this.mRegistered) {
                NetworkChangeNotifierAutoDetect.this.connectionTypeChanged();
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLinkPropertiesChanged(Network network, LinkProperties linkProperties) {
            if (NetworkChangeNotifierAutoDetect.this.mRegistered) {
                NetworkChangeNotifierAutoDetect.this.connectionTypeChanged();
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            if (NetworkChangeNotifierAutoDetect.this.mRegistered) {
                NetworkChangeNotifierAutoDetect.this.connectionTypeChanged();
            }
        }
    }

    @TargetApi(21)
    /* loaded from: classes.dex */
    public class MyNetworkCallback extends ConnectivityManager.NetworkCallback {
        public static final /* synthetic */ boolean $assertionsDisabled = false;
        public Network mVpnInPlace;

        /* renamed from: aegon.chrome.net.NetworkChangeNotifierAutoDetect$MyNetworkCallback$1  reason: invalid class name */
        /* loaded from: classes.dex */
        public class AnonymousClass1 implements Runnable {
            public final /* synthetic */ int val$connectionType;
            public final /* synthetic */ boolean val$makeVpnDefault;
            public final /* synthetic */ long val$netId;

            public AnonymousClass1(long j, int i2, boolean z) {
                this.val$netId = j;
                this.val$connectionType = i2;
                this.val$makeVpnDefault = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                NetworkChangeNotifier.this.notifyObserversOfNetworkConnect(this.val$netId, this.val$connectionType);
                if (this.val$makeVpnDefault) {
                    ((NetworkChangeNotifier.AnonymousClass1) NetworkChangeNotifierAutoDetect.this.mObserver).onConnectionTypeChanged(this.val$connectionType);
                    NetworkChangeNotifier.this.notifyObserversToPurgeActiveNetworkList(new long[]{this.val$netId});
                }
            }
        }

        public /* synthetic */ MyNetworkCallback(AnonymousClass1 anonymousClass1) {
        }

        public final boolean ignoreConnectedNetwork(Network network, NetworkCapabilities networkCapabilities) {
            Network network2 = this.mVpnInPlace;
            if ((network2 == null || network2.equals(network)) ? false : true) {
                return true;
            }
            if (networkCapabilities == null) {
                networkCapabilities = NetworkChangeNotifierAutoDetect.this.mConnectivityManagerDelegate.mConnectivityManager.getNetworkCapabilities(network);
            }
            return networkCapabilities == null || (networkCapabilities.hasTransport(4) && !NetworkChangeNotifierAutoDetect.this.mConnectivityManagerDelegate.vpnAccessible(network));
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            NetworkCapabilities networkCapabilities = NetworkChangeNotifierAutoDetect.this.mConnectivityManagerDelegate.mConnectivityManager.getNetworkCapabilities(network);
            if (ignoreConnectedNetwork(network, networkCapabilities)) {
                return;
            }
            boolean hasTransport = networkCapabilities.hasTransport(4);
            if (hasTransport) {
                this.mVpnInPlace = network;
            }
            NetworkChangeNotifierAutoDetect.this.runOnThread(new AnonymousClass1(NetworkChangeNotifierAutoDetect.networkToNetId(network), NetworkChangeNotifierAutoDetect.this.mConnectivityManagerDelegate.getConnectionType(network), hasTransport));
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
            if (ignoreConnectedNetwork(network, networkCapabilities)) {
                return;
            }
            final long networkToNetId = NetworkChangeNotifierAutoDetect.networkToNetId(network);
            final int connectionType = NetworkChangeNotifierAutoDetect.this.mConnectivityManagerDelegate.getConnectionType(network);
            NetworkChangeNotifierAutoDetect.this.runOnThread(new Runnable() { // from class: aegon.chrome.net.NetworkChangeNotifierAutoDetect.MyNetworkCallback.2
                @Override // java.lang.Runnable
                public void run() {
                    Observer observer = NetworkChangeNotifierAutoDetect.this.mObserver;
                    NetworkChangeNotifier.this.notifyObserversOfNetworkConnect(networkToNetId, connectionType);
                }
            });
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLosing(Network network, int i2) {
            if (ignoreConnectedNetwork(network, null)) {
                return;
            }
            final long networkToNetId = NetworkChangeNotifierAutoDetect.networkToNetId(network);
            NetworkChangeNotifierAutoDetect.this.runOnThread(new Runnable() { // from class: aegon.chrome.net.NetworkChangeNotifierAutoDetect.MyNetworkCallback.3
                @Override // java.lang.Runnable
                public void run() {
                    Observer observer = NetworkChangeNotifierAutoDetect.this.mObserver;
                    NetworkChangeNotifier.this.notifyObserversOfNetworkSoonToDisconnect(networkToNetId);
                }
            });
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(final Network network) {
            Network[] allNetworksFiltered;
            Network network2 = this.mVpnInPlace;
            if ((network2 == null || network2.equals(network)) ? false : true) {
                return;
            }
            NetworkChangeNotifierAutoDetect.this.runOnThread(new Runnable() { // from class: aegon.chrome.net.NetworkChangeNotifierAutoDetect.MyNetworkCallback.4
                @Override // java.lang.Runnable
                public void run() {
                    Observer observer = NetworkChangeNotifierAutoDetect.this.mObserver;
                    NetworkChangeNotifier.this.notifyObserversOfNetworkDisconnect(NetworkChangeNotifierAutoDetect.networkToNetId(network));
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
                        NetworkChangeNotifierAutoDetect.this.runOnThread(new AnonymousClass1(NetworkChangeNotifierAutoDetect.networkToNetId(network3), NetworkChangeNotifierAutoDetect.this.mConnectivityManagerDelegate.getConnectionType(network3), hasTransport));
                    }
                }
                final int connectionType = NetworkChangeNotifierAutoDetect.this.getCurrentNetworkState().getConnectionType();
                NetworkChangeNotifierAutoDetect.this.runOnThread(new Runnable() { // from class: aegon.chrome.net.NetworkChangeNotifierAutoDetect.MyNetworkCallback.5
                    @Override // java.lang.Runnable
                    public void run() {
                        ((NetworkChangeNotifier.AnonymousClass1) NetworkChangeNotifierAutoDetect.this.mObserver).onConnectionTypeChanged(connectionType);
                    }
                });
            }
        }
    }

    /* loaded from: classes.dex */
    public static class NetworkConnectivityIntentFilter extends IntentFilter {
        public NetworkConnectivityIntentFilter() {
            addAction("android.net.conn.CONNECTIVITY_CHANGE");
        }
    }

    /* loaded from: classes.dex */
    public static class NetworkState {
        public final boolean mConnected;
        public final boolean mIsPrivateDnsActive;
        public final String mNetworkIdentifier;
        public final int mSubtype;
        public final int mType;

        public NetworkState(boolean z, int i2, int i3, String str, boolean z2) {
            this.mConnected = z;
            this.mType = i2;
            this.mSubtype = i3;
            this.mNetworkIdentifier = str == null ? "" : str;
            this.mIsPrivateDnsActive = z2;
        }

        public int getConnectionSubtype() {
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

        public int getConnectionType() {
            if (this.mConnected) {
                return NetworkChangeNotifierAutoDetect.access$000(this.mType, this.mSubtype);
            }
            return 6;
        }
    }

    /* loaded from: classes.dex */
    public interface Observer {
    }

    /* loaded from: classes.dex */
    public static abstract class RegistrationPolicy {
        public static final /* synthetic */ boolean $assertionsDisabled = false;
        public NetworkChangeNotifierAutoDetect mNotifier;

        public abstract void destroy();

        public abstract void init(NetworkChangeNotifierAutoDetect networkChangeNotifierAutoDetect);

        public final void register() {
            NetworkCapabilities networkCapabilities;
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

    /* loaded from: classes.dex */
    public static class WifiManagerDelegate {
        public static final /* synthetic */ boolean $assertionsDisabled = false;
        public final Context mContext;
        public boolean mHasWifiPermission;
        public boolean mHasWifiPermissionComputed;
        public final Object mLock = new Object();
        public WifiManager mWifiManager;

        public WifiManagerDelegate(Context context) {
            this.mContext = context;
        }

        public String getWifiSsid() {
            WifiInfo wifiInfo;
            synchronized (this.mLock) {
                if (hasPermissionLocked()) {
                    try {
                        try {
                            wifiInfo = this.mWifiManager.getConnectionInfo();
                        } catch (NullPointerException unused) {
                            wifiInfo = this.mWifiManager.getConnectionInfo();
                        }
                    } catch (NullPointerException unused2) {
                        wifiInfo = null;
                    }
                    if (wifiInfo != null) {
                        return wifiInfo.getSSID();
                    }
                    return "";
                }
                return AndroidNetworkLibrary.getWifiSSID();
            }
        }

        @SuppressLint({"WifiManagerPotentialLeak"})
        public final boolean hasPermissionLocked() {
            if (this.mHasWifiPermissionComputed) {
                return this.mHasWifiPermission;
            }
            boolean z = this.mContext.getPackageManager().checkPermission("android.permission.ACCESS_WIFI_STATE", this.mContext.getPackageName()) == 0;
            this.mHasWifiPermission = z;
            this.mWifiManager = z ? (WifiManager) this.mContext.getSystemService("wifi") : null;
            this.mHasWifiPermissionComputed = true;
            return this.mHasWifiPermission;
        }
    }

    @TargetApi(21)
    public NetworkChangeNotifierAutoDetect(Observer observer, RegistrationPolicy registrationPolicy) {
        this.mObserver = observer;
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
        NetworkCapabilities networkCapabilities;
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

    @TargetApi(21)
    public static long networkToNetId(Network network) {
        return Build.VERSION.SDK_INT >= 23 ? network.getNetworkHandle() : Integer.parseInt(network.toString());
    }

    public final void assertOnThread() {
        if (BuildConfig.DCHECK_IS_ON) {
            if (!(this.mLooper == Looper.myLooper())) {
                throw new IllegalStateException("Must be called on NetworkChangeNotifierAutoDetect thread.");
            }
        }
    }

    public final void connectionTypeChanged() {
        NetworkState currentNetworkState = getCurrentNetworkState();
        if (currentNetworkState.getConnectionType() != this.mNetworkState.getConnectionType() || !currentNetworkState.mNetworkIdentifier.equals(this.mNetworkState.mNetworkIdentifier) || currentNetworkState.mIsPrivateDnsActive != this.mNetworkState.mIsPrivateDnsActive) {
            ((NetworkChangeNotifier.AnonymousClass1) this.mObserver).onConnectionTypeChanged(currentNetworkState.getConnectionType());
        }
        if (currentNetworkState.getConnectionType() != this.mNetworkState.getConnectionType() || currentNetworkState.getConnectionSubtype() != this.mNetworkState.getConnectionSubtype()) {
            Observer observer = this.mObserver;
            NetworkChangeNotifier.this.notifyObserversOfConnectionSubtypeChange(currentNetworkState.getConnectionSubtype());
        }
        this.mNetworkState = currentNetworkState;
    }

    public NetworkState getCurrentNetworkState() {
        return this.mConnectivityManagerDelegate.getNetworkState(this.mWifiManagerDelegate);
    }

    public long getDefaultNetId() {
        Network defaultNetwork;
        if (Build.VERSION.SDK_INT >= 21 && (defaultNetwork = this.mConnectivityManagerDelegate.getDefaultNetwork()) != null) {
            return networkToNetId(defaultNetwork);
        }
        return -1L;
    }

    public long[] getNetworksAndTypes() {
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

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        runOnThread(new Runnable() { // from class: aegon.chrome.net.NetworkChangeNotifierAutoDetect.1
            @Override // java.lang.Runnable
            public void run() {
                if (NetworkChangeNotifierAutoDetect.this.mRegistered) {
                    if (NetworkChangeNotifierAutoDetect.this.mIgnoreNextBroadcast) {
                        NetworkChangeNotifierAutoDetect.this.mIgnoreNextBroadcast = false;
                    } else {
                        NetworkChangeNotifierAutoDetect.this.connectionTypeChanged();
                    }
                }
            }
        });
    }

    public final void runOnThread(Runnable runnable) {
        if (this.mLooper == Looper.myLooper()) {
            runnable.run();
        } else {
            this.mHandler.post(runnable);
        }
    }

    public void unregister() {
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
